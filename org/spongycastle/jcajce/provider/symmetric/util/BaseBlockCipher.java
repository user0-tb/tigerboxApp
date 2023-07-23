package org.spongycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.CTSBlockCipher;
import org.spongycastle.crypto.modes.EAXBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.GOFBBlockCipher;
import org.spongycastle.crypto.modes.OCBBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.spongycastle.crypto.modes.PGPCFBBlockCipher;
import org.spongycastle.crypto.modes.SICBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO10126d2Padding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.paddings.TBCPadding;
import org.spongycastle.crypto.paddings.X923Padding;
import org.spongycastle.crypto.paddings.ZeroBytePadding;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Strings;

public class BaseBlockCipher extends BaseWrapCipher implements PBE {
    private static final Class gcmSpecClass = lookup("javax.crypto.spec.GCMParameterSpec");
    private AEADParameters aeadParams;
    private Class[] availableSpecs = {RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class, gcmSpecClass};
    private BlockCipher baseEngine;
    private GenericBlockCipher cipher;
    private BlockCipherProvider engineProvider;
    private int ivLength = 0;
    private ParametersWithIV ivParam;
    private String modeName = null;
    private boolean padded;
    private String pbeAlgorithm = null;
    private PBEParameterSpec pbeSpec = null;

    private interface GenericBlockCipher {
        int doFinal(byte[] bArr, int i) throws IllegalStateException, BadPaddingException;

        String getAlgorithmName();

        int getOutputSize(int i);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int i);

        void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

        int processByte(byte b, byte[] bArr, int i) throws DataLengthException;

        int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

        void updateAAD(byte[] bArr, int i, int i2);

        boolean wrapOnNoPadding();
    }

    /* access modifiers changed from: private */
    public static Class lookup(String str) {
        try {
            return BaseBlockCipher.class.getClassLoader().loadClass(str);
        } catch (Exception unused) {
            return null;
        }
    }

    protected BaseBlockCipher(BlockCipher blockCipher) {
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    protected BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.baseEngine = blockCipherProvider.get();
        this.engineProvider = blockCipherProvider;
        this.cipher = new BufferedGenericBlockCipher(blockCipherProvider.get());
    }

    protected BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        BlockCipher underlyingCipher = aEADBlockCipher.getUnderlyingCipher();
        this.baseEngine = underlyingCipher;
        this.ivLength = underlyingCipher.getBlockSize();
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    protected BaseBlockCipher(BlockCipher blockCipher, int i) {
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = i / 8;
    }

    protected BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i) {
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.ivLength = i / 8;
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return this.baseEngine.getBlockSize();
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        AEADParameters aEADParameters = this.aeadParams;
        if (aEADParameters != null) {
            return aEADParameters.getNonce();
        }
        ParametersWithIV parametersWithIV = this.ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        return this.cipher.getOutputSize(i);
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            if (this.pbeSpec != null) {
                try {
                    this.engineParams = AlgorithmParameters.getInstance(this.pbeAlgorithm, BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams.init(this.pbeSpec);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.ivParam != null) {
                String algorithmName = this.cipher.getUnderlyingCipher().getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                try {
                    this.engineParams = AlgorithmParameters.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams.init(this.ivParam.getIV());
                } catch (Exception e) {
                    throw new RuntimeException(e.toString());
                }
            } else if (this.aeadParams != null) {
                try {
                    this.engineParams = AlgorithmParameters.getInstance("GCM", BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams.init(new GCMParameters(this.aeadParams.getNonce(), this.aeadParams.getMacSize()).getEncoded());
                } catch (Exception e2) {
                    throw new RuntimeException(e2.toString());
                }
            }
        }
        return this.engineParams;
    }

    /* access modifiers changed from: protected */
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        this.modeName = upperCase;
        if (upperCase.equals("ECB")) {
            this.ivLength = 0;
            this.cipher = new BufferedGenericBlockCipher(this.baseEngine);
        } else if (this.modeName.equals("CBC")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new CBCBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("OFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                this.cipher = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                return;
            }
            BlockCipher blockCipher = this.baseEngine;
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
        } else if (this.modeName.startsWith("CFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                this.cipher = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                return;
            }
            BlockCipher blockCipher2 = this.baseEngine;
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(blockCipher2, blockCipher2.getBlockSize() * 8));
        } else if (this.modeName.startsWith("PGP")) {
            boolean equalsIgnoreCase = this.modeName.equalsIgnoreCase("PGPCFBwithIV");
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new PGPCFBBlockCipher(this.baseEngine, equalsIgnoreCase));
        } else if (this.modeName.equalsIgnoreCase("OpenPGPCFB")) {
            this.ivLength = 0;
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new OpenPGPCFBBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("SIC")) {
            int blockSize = this.baseEngine.getBlockSize();
            this.ivLength = blockSize;
            if (blockSize >= 16) {
                this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
                return;
            }
            throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
        } else if (this.modeName.startsWith("CTR")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("GOFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("GCFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("CTS")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("CCM")) {
            this.ivLength = 13;
            this.cipher = new AEADGenericBlockCipher(new CCMBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("OCB")) {
            if (this.engineProvider != null) {
                this.ivLength = 15;
                this.cipher = new AEADGenericBlockCipher(new OCBBlockCipher(this.baseEngine, this.engineProvider.get()));
                return;
            }
            throw new NoSuchAlgorithmException("can't support mode " + str);
        } else if (this.modeName.startsWith("EAX")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("GCM")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new GCMBlockCipher(this.baseEngine));
        } else {
            throw new NoSuchAlgorithmException("can't support mode " + str);
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            if (this.cipher.wrapOnNoPadding()) {
                this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
            }
        } else if (upperCase.equals("WITHCTS")) {
            this.cipher = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
        } else {
            this.padded = true;
            if (isAEADModeName(this.modeName)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            } else if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
            } else if (upperCase.equals("ZEROBYTEPADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
            } else if (upperCase.equals("ISO10126PADDING") || upperCase.equals("ISO10126-2PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
            } else if (upperCase.equals("X9.23PADDING") || upperCase.equals("X923PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
            } else if (upperCase.equals("ISO7816-4PADDING") || upperCase.equals("ISO9797-1PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
            } else if (upperCase.equals("TBCPADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
            } else {
                throw new NoSuchPaddingException("Padding " + str + " unknown.");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineInit(int r7, java.security.Key r8, java.security.spec.AlgorithmParameterSpec r9, java.security.SecureRandom r10) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            r0 = 0
            r6.pbeSpec = r0
            r6.pbeAlgorithm = r0
            r6.engineParams = r0
            r6.aeadParams = r0
            boolean r1 = r8 instanceof javax.crypto.SecretKey
            if (r1 == 0) goto L_0x036c
            java.lang.String r1 = "RC5-64"
            if (r9 != 0) goto L_0x0026
            org.spongycastle.crypto.BlockCipher r2 = r6.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            boolean r2 = r2.startsWith(r1)
            if (r2 != 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r8 = "RC5 requires an RC5ParametersSpec to be passed in."
            r7.<init>(r8)
            throw r7
        L_0x0026:
            boolean r2 = r8 instanceof org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey
            r3 = 0
            if (r2 == 0) goto L_0x00ac
            org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey r8 = (org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey) r8
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r8.getOID()
            if (r0 == 0) goto L_0x003e
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r8.getOID()
            java.lang.String r0 = r0.getId()
            r6.pbeAlgorithm = r0
            goto L_0x0044
        L_0x003e:
            java.lang.String r0 = r8.getAlgorithm()
            r6.pbeAlgorithm = r0
        L_0x0044:
            org.spongycastle.crypto.CipherParameters r0 = r8.getParam()
            if (r0 == 0) goto L_0x0082
            org.spongycastle.crypto.CipherParameters r8 = r8.getParam()
            boolean r0 = r9 instanceof javax.crypto.spec.IvParameterSpec
            if (r0 == 0) goto L_0x005f
            javax.crypto.spec.IvParameterSpec r9 = (javax.crypto.spec.IvParameterSpec) r9
            org.spongycastle.crypto.params.ParametersWithIV r0 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r9 = r9.getIV()
            r0.<init>(r8, r9)
        L_0x005d:
            r8 = r0
            goto L_0x0099
        L_0x005f:
            boolean r0 = r9 instanceof org.spongycastle.jcajce.spec.GOST28147ParameterSpec
            if (r0 == 0) goto L_0x0099
            org.spongycastle.jcajce.spec.GOST28147ParameterSpec r9 = (org.spongycastle.jcajce.spec.GOST28147ParameterSpec) r9
            org.spongycastle.crypto.params.ParametersWithSBox r0 = new org.spongycastle.crypto.params.ParametersWithSBox
            byte[] r1 = r9.getSbox()
            r0.<init>(r8, r1)
            byte[] r8 = r9.getIV()
            if (r8 == 0) goto L_0x005d
            int r8 = r6.ivLength
            if (r8 == 0) goto L_0x005d
            org.spongycastle.crypto.params.ParametersWithIV r8 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r9 = r9.getIV()
            r8.<init>(r0, r9)
            goto L_0x0099
        L_0x0082:
            boolean r0 = r9 instanceof javax.crypto.spec.PBEParameterSpec
            if (r0 == 0) goto L_0x00a4
            r0 = r9
            javax.crypto.spec.PBEParameterSpec r0 = (javax.crypto.spec.PBEParameterSpec) r0
            r6.pbeSpec = r0
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r6.cipher
            org.spongycastle.crypto.BlockCipher r0 = r0.getUnderlyingCipher()
            java.lang.String r0 = r0.getAlgorithmName()
            org.spongycastle.crypto.CipherParameters r8 = org.spongycastle.jcajce.provider.symmetric.util.PBE.C3199Util.makePBEParameters(r8, r9, r0)
        L_0x0099:
            boolean r9 = r8 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r9 == 0) goto L_0x02c9
            r9 = r8
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9
            r6.ivParam = r9
            goto L_0x02c9
        L_0x00a4:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r8 = "PBE requires PBE parameters to be set."
            r7.<init>(r8)
            throw r7
        L_0x00ac:
            if (r9 != 0) goto L_0x00ba
            org.spongycastle.crypto.params.KeyParameter r9 = new org.spongycastle.crypto.params.KeyParameter
            byte[] r8 = r8.getEncoded()
            r9.<init>(r8)
        L_0x00b7:
            r8 = r9
            goto L_0x02c9
        L_0x00ba:
            boolean r2 = r9 instanceof javax.crypto.spec.IvParameterSpec
            if (r2 == 0) goto L_0x0142
            int r1 = r6.ivLength
            if (r1 == 0) goto L_0x0122
            javax.crypto.spec.IvParameterSpec r9 = (javax.crypto.spec.IvParameterSpec) r9
            byte[] r1 = r9.getIV()
            int r1 = r1.length
            int r2 = r6.ivLength
            if (r1 == r2) goto L_0x00f4
            java.lang.String r1 = r6.modeName
            boolean r1 = r6.isAEADModeName(r1)
            if (r1 == 0) goto L_0x00d6
            goto L_0x00f4
        L_0x00d6:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "IV must be "
            r8.append(r9)
            int r9 = r6.ivLength
            r8.append(r9)
            java.lang.String r9 = " bytes long."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x00f4:
            boolean r1 = r8 instanceof org.spongycastle.jcajce.spec.RepeatedSecretKeySpec
            if (r1 == 0) goto L_0x0108
            org.spongycastle.crypto.params.ParametersWithIV r8 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r9 = r9.getIV()
            r8.<init>(r0, r9)
            r9 = r8
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9
            r6.ivParam = r9
            goto L_0x02c9
        L_0x0108:
            org.spongycastle.crypto.params.ParametersWithIV r0 = new org.spongycastle.crypto.params.ParametersWithIV
            org.spongycastle.crypto.params.KeyParameter r1 = new org.spongycastle.crypto.params.KeyParameter
            byte[] r8 = r8.getEncoded()
            r1.<init>(r8)
            byte[] r8 = r9.getIV()
            r0.<init>(r1, r8)
            r8 = r0
            org.spongycastle.crypto.params.ParametersWithIV r8 = (org.spongycastle.crypto.params.ParametersWithIV) r8
            r6.ivParam = r8
        L_0x011f:
            r8 = r0
            goto L_0x02c9
        L_0x0122:
            java.lang.String r9 = r6.modeName
            if (r9 == 0) goto L_0x0137
            java.lang.String r0 = "ECB"
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L_0x012f
            goto L_0x0137
        L_0x012f:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r8 = "ECB mode does not use an IV"
            r7.<init>(r8)
            throw r7
        L_0x0137:
            org.spongycastle.crypto.params.KeyParameter r9 = new org.spongycastle.crypto.params.KeyParameter
            byte[] r8 = r8.getEncoded()
            r9.<init>(r8)
            goto L_0x00b7
        L_0x0142:
            boolean r2 = r9 instanceof org.spongycastle.jcajce.spec.GOST28147ParameterSpec
            if (r2 == 0) goto L_0x0174
            org.spongycastle.jcajce.spec.GOST28147ParameterSpec r9 = (org.spongycastle.jcajce.spec.GOST28147ParameterSpec) r9
            org.spongycastle.crypto.params.ParametersWithSBox r0 = new org.spongycastle.crypto.params.ParametersWithSBox
            org.spongycastle.crypto.params.KeyParameter r1 = new org.spongycastle.crypto.params.KeyParameter
            byte[] r8 = r8.getEncoded()
            r1.<init>(r8)
            byte[] r8 = r9.getSbox()
            r0.<init>(r1, r8)
            byte[] r8 = r9.getIV()
            if (r8 == 0) goto L_0x011f
            int r8 = r6.ivLength
            if (r8 == 0) goto L_0x011f
            org.spongycastle.crypto.params.ParametersWithIV r8 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r9 = r9.getIV()
            r8.<init>(r0, r9)
            r9 = r8
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9
            r6.ivParam = r9
            goto L_0x02c9
        L_0x0174:
            boolean r2 = r9 instanceof javax.crypto.spec.RC2ParameterSpec
            if (r2 == 0) goto L_0x01a1
            javax.crypto.spec.RC2ParameterSpec r9 = (javax.crypto.spec.RC2ParameterSpec) r9
            org.spongycastle.crypto.params.RC2Parameters r0 = new org.spongycastle.crypto.params.RC2Parameters
            byte[] r8 = r8.getEncoded()
            int r1 = r9.getEffectiveKeyBits()
            r0.<init>(r8, r1)
            byte[] r8 = r9.getIV()
            if (r8 == 0) goto L_0x011f
            int r8 = r6.ivLength
            if (r8 == 0) goto L_0x011f
            org.spongycastle.crypto.params.ParametersWithIV r8 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r9 = r9.getIV()
            r8.<init>(r0, r9)
            r9 = r8
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9
            r6.ivParam = r9
            goto L_0x02c9
        L_0x01a1:
            boolean r2 = r9 instanceof javax.crypto.spec.RC5ParameterSpec
            if (r2 == 0) goto L_0x024e
            javax.crypto.spec.RC5ParameterSpec r9 = (javax.crypto.spec.RC5ParameterSpec) r9
            org.spongycastle.crypto.params.RC5Parameters r0 = new org.spongycastle.crypto.params.RC5Parameters
            byte[] r8 = r8.getEncoded()
            int r2 = r9.getRounds()
            r0.<init>(r8, r2)
            org.spongycastle.crypto.BlockCipher r8 = r6.baseEngine
            java.lang.String r8 = r8.getAlgorithmName()
            java.lang.String r2 = "RC5"
            boolean r8 = r8.startsWith(r2)
            if (r8 == 0) goto L_0x0246
            org.spongycastle.crypto.BlockCipher r8 = r6.baseEngine
            java.lang.String r8 = r8.getAlgorithmName()
            java.lang.String r2 = "RC5-32"
            boolean r8 = r8.equals(r2)
            java.lang.String r2 = "."
            if (r8 == 0) goto L_0x01f9
            int r8 = r9.getWordSize()
            r1 = 32
            if (r8 != r1) goto L_0x01db
            goto L_0x022c
        L_0x01db:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "RC5 already set up for a word size of 32 not "
            r8.append(r10)
            int r9 = r9.getWordSize()
            r8.append(r9)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x01f9:
            org.spongycastle.crypto.BlockCipher r8 = r6.baseEngine
            java.lang.String r8 = r8.getAlgorithmName()
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x022c
            int r8 = r9.getWordSize()
            r1 = 64
            if (r8 != r1) goto L_0x020e
            goto L_0x022c
        L_0x020e:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "RC5 already set up for a word size of 64 not "
            r8.append(r10)
            int r9 = r9.getWordSize()
            r8.append(r9)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x022c:
            byte[] r8 = r9.getIV()
            if (r8 == 0) goto L_0x011f
            int r8 = r6.ivLength
            if (r8 == 0) goto L_0x011f
            org.spongycastle.crypto.params.ParametersWithIV r8 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r9 = r9.getIV()
            r8.<init>(r0, r9)
            r9 = r8
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9
            r6.ivParam = r9
            goto L_0x02c9
        L_0x0246:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r8 = "RC5 parameters passed to a cipher that is not RC5."
            r7.<init>(r8)
            throw r7
        L_0x024e:
            java.lang.Class r1 = gcmSpecClass
            if (r1 == 0) goto L_0x0364
            boolean r2 = r1.isInstance(r9)
            if (r2 == 0) goto L_0x0364
            java.lang.String r2 = r6.modeName
            boolean r2 = r6.isAEADModeName(r2)
            if (r2 != 0) goto L_0x026f
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r6.cipher
            boolean r2 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r2 == 0) goto L_0x0267
            goto L_0x026f
        L_0x0267:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r8 = "GCMParameterSpec can only be used with AEAD modes."
            r7.<init>(r8)
            throw r7
        L_0x026f:
            java.lang.String r2 = "getTLen"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x035c }
            java.lang.reflect.Method r2 = r1.getDeclaredMethod(r2, r4)     // Catch:{ Exception -> 0x035c }
            java.lang.String r4 = "getIV"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x035c }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x035c }
            boolean r4 = r8 instanceof org.spongycastle.jcajce.spec.RepeatedSecretKeySpec     // Catch:{ Exception -> 0x035c }
            if (r4 == 0) goto L_0x02a1
            org.spongycastle.crypto.params.AEADParameters r8 = new org.spongycastle.crypto.params.AEADParameters     // Catch:{ Exception -> 0x035c }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x035c }
            java.lang.Object r2 = r2.invoke(r9, r4)     // Catch:{ Exception -> 0x035c }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x035c }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x035c }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x035c }
            java.lang.Object r9 = r1.invoke(r9, r4)     // Catch:{ Exception -> 0x035c }
            byte[] r9 = (byte[]) r9     // Catch:{ Exception -> 0x035c }
            byte[] r9 = (byte[]) r9     // Catch:{ Exception -> 0x035c }
            r8.<init>(r0, r2, r9)     // Catch:{ Exception -> 0x035c }
            r6.aeadParams = r8     // Catch:{ Exception -> 0x035c }
            goto L_0x02c9
        L_0x02a1:
            org.spongycastle.crypto.params.AEADParameters r0 = new org.spongycastle.crypto.params.AEADParameters     // Catch:{ Exception -> 0x035c }
            org.spongycastle.crypto.params.KeyParameter r4 = new org.spongycastle.crypto.params.KeyParameter     // Catch:{ Exception -> 0x035c }
            byte[] r8 = r8.getEncoded()     // Catch:{ Exception -> 0x035c }
            r4.<init>(r8)     // Catch:{ Exception -> 0x035c }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x035c }
            java.lang.Object r8 = r2.invoke(r9, r8)     // Catch:{ Exception -> 0x035c }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x035c }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x035c }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x035c }
            java.lang.Object r9 = r1.invoke(r9, r2)     // Catch:{ Exception -> 0x035c }
            byte[] r9 = (byte[]) r9     // Catch:{ Exception -> 0x035c }
            byte[] r9 = (byte[]) r9     // Catch:{ Exception -> 0x035c }
            r0.<init>(r4, r8, r9)     // Catch:{ Exception -> 0x035c }
            r6.aeadParams = r0     // Catch:{ Exception -> 0x035c }
            goto L_0x011f
        L_0x02c9:
            int r9 = r6.ivLength
            r0 = 3
            r1 = 1
            if (r9 == 0) goto L_0x0312
            boolean r9 = r8 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r9 != 0) goto L_0x0312
            boolean r9 = r8 instanceof org.spongycastle.crypto.params.AEADParameters
            if (r9 != 0) goto L_0x0312
            if (r10 != 0) goto L_0x02df
            java.security.SecureRandom r9 = new java.security.SecureRandom
            r9.<init>()
            goto L_0x02e0
        L_0x02df:
            r9 = r10
        L_0x02e0:
            if (r7 == r1) goto L_0x0300
            if (r7 != r0) goto L_0x02e5
            goto L_0x0300
        L_0x02e5:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r9 = r6.cipher
            org.spongycastle.crypto.BlockCipher r9 = r9.getUnderlyingCipher()
            java.lang.String r9 = r9.getAlgorithmName()
            java.lang.String r2 = "PGPCFB"
            int r9 = r9.indexOf(r2)
            if (r9 < 0) goto L_0x02f8
            goto L_0x0312
        L_0x02f8:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r8 = "no IV set when one expected"
            r7.<init>(r8)
            throw r7
        L_0x0300:
            int r2 = r6.ivLength
            byte[] r2 = new byte[r2]
            r9.nextBytes(r2)
            org.spongycastle.crypto.params.ParametersWithIV r9 = new org.spongycastle.crypto.params.ParametersWithIV
            r9.<init>(r8, r2)
            r8 = r9
            org.spongycastle.crypto.params.ParametersWithIV r8 = (org.spongycastle.crypto.params.ParametersWithIV) r8
            r6.ivParam = r8
            r8 = r9
        L_0x0312:
            if (r10 == 0) goto L_0x031e
            boolean r9 = r6.padded
            if (r9 == 0) goto L_0x031e
            org.spongycastle.crypto.params.ParametersWithRandom r9 = new org.spongycastle.crypto.params.ParametersWithRandom
            r9.<init>(r8, r10)
            r8 = r9
        L_0x031e:
            if (r7 == r1) goto L_0x034b
            r9 = 2
            if (r7 == r9) goto L_0x0345
            if (r7 == r0) goto L_0x034b
            r9 = 4
            if (r7 != r9) goto L_0x0329
            goto L_0x0345
        L_0x0329:
            java.security.InvalidParameterException r8 = new java.security.InvalidParameterException     // Catch:{ Exception -> 0x0351 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0351 }
            r9.<init>()     // Catch:{ Exception -> 0x0351 }
            java.lang.String r10 = "unknown opmode "
            r9.append(r10)     // Catch:{ Exception -> 0x0351 }
            r9.append(r7)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r7 = " passed"
            r9.append(r7)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x0351 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x0351 }
            throw r8     // Catch:{ Exception -> 0x0351 }
        L_0x0345:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r7 = r6.cipher     // Catch:{ Exception -> 0x0351 }
            r7.init(r3, r8)     // Catch:{ Exception -> 0x0351 }
            goto L_0x0350
        L_0x034b:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r7 = r6.cipher     // Catch:{ Exception -> 0x0351 }
            r7.init(r1, r8)     // Catch:{ Exception -> 0x0351 }
        L_0x0350:
            return
        L_0x0351:
            r7 = move-exception
            java.security.InvalidKeyException r8 = new java.security.InvalidKeyException
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r7)
            throw r8
        L_0x035c:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r8 = "Cannot process GCMParameterSpec."
            r7.<init>(r8)
            throw r7
        L_0x0364:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r8 = "unknown parameter type."
            r7.<init>(r8)
            throw r7
        L_0x036c:
            java.security.InvalidKeyException r7 = new java.security.InvalidKeyException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Key for algorithm "
            r9.append(r10)
            java.lang.String r8 = r8.getAlgorithm()
            r9.append(r8)
            java.lang.String r8 = " not suitable for symmetric enryption."
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i2 = 0;
            while (true) {
                Class[] clsArr = this.availableSpecs;
                if (i2 == clsArr.length) {
                    break;
                }
                if (clsArr[i2] != null) {
                    try {
                        algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i2]);
                        break;
                    } catch (Exception unused) {
                    }
                }
                i2++;
            }
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        engineInit(i, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdateAAD(byte[] bArr, int i, int i2) {
        this.cipher.updateAAD(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        int updateOutputSize = this.cipher.getUpdateOutputSize(i2);
        if (updateOutputSize > 0) {
            byte[] bArr2 = new byte[updateOutputSize];
            int processBytes = this.cipher.processBytes(bArr, i, i2, bArr2, 0);
            if (processBytes == 0) {
                return null;
            }
            if (processBytes == updateOutputSize) {
                return bArr2;
            }
            byte[] bArr3 = new byte[processBytes];
            System.arraycopy(bArr2, 0, bArr3, 0, processBytes);
            return bArr3;
        }
        this.cipher.processBytes(bArr, i, i2, (byte[]) null, 0);
        return null;
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        try {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        } catch (DataLengthException e) {
            throw new ShortBufferException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        int engineGetOutputSize = engineGetOutputSize(i2);
        byte[] bArr2 = new byte[engineGetOutputSize];
        int processBytes = i2 != 0 ? this.cipher.processBytes(bArr, i, i2, bArr2, 0) : 0;
        try {
            int doFinal = processBytes + this.cipher.doFinal(bArr2, processBytes);
            if (doFinal == engineGetOutputSize) {
                return bArr2;
            }
            byte[] bArr3 = new byte[doFinal];
            System.arraycopy(bArr2, 0, bArr3, 0, doFinal);
            return bArr3;
        } catch (DataLengthException e) {
            throw new IllegalBlockSizeException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int i4 = 0;
        if (i2 != 0) {
            try {
                i4 = this.cipher.processBytes(bArr, i, i2, bArr2, i3);
            } catch (OutputLengthException e) {
                throw new ShortBufferException(e.getMessage());
            } catch (DataLengthException e2) {
                throw new IllegalBlockSizeException(e2.getMessage());
            }
        }
        return i4 + this.cipher.doFinal(bArr2, i3 + i4);
    }

    private boolean isAEADModeName(String str) {
        return "CCM".equals(str) || "EAX".equals(str) || "GCM".equals(str) || "OCB".equals(str);
    }

    private static class BufferedGenericBlockCipher implements GenericBlockCipher {
        private BufferedBlockCipher cipher;

        BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.cipher = bufferedBlockCipher;
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher);
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }

        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        public boolean wrapOnNoPadding() {
            return !(this.cipher instanceof CTSBlockCipher);
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        public void updateAAD(byte[] bArr, int i, int i2) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
            return this.cipher.processByte(b, bArr, i);
        }

        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        public int doFinal(byte[] bArr, int i) throws IllegalStateException, BadPaddingException {
            try {
                return this.cipher.doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            }
        }
    }

    private static class AEADGenericBlockCipher implements GenericBlockCipher {
        private static final Constructor aeadBadTagConstructor;
        private AEADBlockCipher cipher;

        public boolean wrapOnNoPadding() {
            return false;
        }

        static {
            Class access$000 = BaseBlockCipher.lookup("javax.crypto.AEADBadTagException");
            if (access$000 != null) {
                aeadBadTagConstructor = findExceptionConstructor(access$000);
            } else {
                aeadBadTagConstructor = null;
            }
        }

        private static Constructor findExceptionConstructor(Class cls) {
            try {
                return cls.getConstructor(new Class[]{String.class});
            } catch (Exception unused) {
                return null;
            }
        }

        AEADGenericBlockCipher(AEADBlockCipher aEADBlockCipher) {
            this.cipher = aEADBlockCipher;
        }

        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        public void updateAAD(byte[] bArr, int i, int i2) {
            this.cipher.processAADBytes(bArr, i, i2);
        }

        public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
            return this.cipher.processByte(b, bArr, i);
        }

        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        public int doFinal(byte[] bArr, int i) throws IllegalStateException, BadPaddingException {
            try {
                return this.cipher.doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                Constructor constructor = aeadBadTagConstructor;
                if (constructor != null) {
                    BadPaddingException badPaddingException = null;
                    try {
                        badPaddingException = (BadPaddingException) constructor.newInstance(new Object[]{e.getMessage()});
                    } catch (Exception unused) {
                    }
                    if (badPaddingException != null) {
                        throw badPaddingException;
                    }
                }
                throw new BadPaddingException(e.getMessage());
            }
        }
    }
}
