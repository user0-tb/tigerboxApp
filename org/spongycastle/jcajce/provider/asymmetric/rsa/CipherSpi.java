package org.spongycastle.jcajce.provider.asymmetric.rsa;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.encodings.ISO9796d1Encoding;
import org.spongycastle.crypto.encodings.OAEPEncoding;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Strings;

public class CipherSpi extends BaseCipherSpi {
    private ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    private AsymmetricBlockCipher cipher;
    private AlgorithmParameters engineParams;
    private AlgorithmParameterSpec paramSpec;
    private boolean privateKeyOnly = false;
    private boolean publicKeyOnly = false;

    public CipherSpi(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.cipher = asymmetricBlockCipher;
    }

    public CipherSpi(OAEPParameterSpec oAEPParameterSpec) {
        try {
            initFromSpec(oAEPParameterSpec);
        } catch (NoSuchPaddingException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public CipherSpi(boolean z, boolean z2, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.publicKeyOnly = z;
        this.privateKeyOnly = z2;
        this.cipher = asymmetricBlockCipher;
    }

    private void initFromSpec(OAEPParameterSpec oAEPParameterSpec) throws NoSuchPaddingException {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        Digest digest = DigestFactory.getDigest(mGF1ParameterSpec.getDigestAlgorithm());
        if (digest != null) {
            this.cipher = new OAEPEncoding(new RSABlindedEngine(), digest, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
            this.paramSpec = oAEPParameterSpec;
            return;
        }
        throw new NoSuchPaddingException("no match on OAEP constructor for digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        try {
            return this.cipher.getInputBlockSize();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        if (key instanceof RSAPrivateKey) {
            return ((RSAPrivateKey) key).getModulus().bitLength();
        }
        if (key instanceof RSAPublicKey) {
            return ((RSAPublicKey) key).getModulus().bitLength();
        }
        throw new IllegalArgumentException("not an RSA key!");
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        try {
            return this.cipher.getOutputBlockSize();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.paramSpec != null) {
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("OAEP", BouncyCastleProvider.PROVIDER_NAME);
                this.engineParams = instance;
                instance.init(this.paramSpec);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParams;
    }

    /* access modifiers changed from: protected */
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NONE") && !upperCase.equals("ECB")) {
            if (upperCase.equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
                this.privateKeyOnly = true;
                this.publicKeyOnly = false;
            } else if (upperCase.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                this.privateKeyOnly = false;
                this.publicKeyOnly = true;
            } else {
                throw new NoSuchAlgorithmException("can't support mode " + str);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            this.cipher = new RSABlindedEngine();
        } else if (upperCase.equals("PKCS1PADDING")) {
            this.cipher = new PKCS1Encoding(new RSABlindedEngine());
        } else if (upperCase.equals("ISO9796-1PADDING")) {
            this.cipher = new ISO9796d1Encoding(new RSABlindedEngine());
        } else if (upperCase.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPPADDING")) {
            initFromSpec(OAEPParameterSpec.DEFAULT);
        } else if (upperCase.equals("OAEPWITHSHA1ANDMGF1PADDING") || upperCase.equals("OAEPWITHSHA-1ANDMGF1PADDING")) {
            initFromSpec(OAEPParameterSpec.DEFAULT);
        } else if (upperCase.equals("OAEPWITHSHA224ANDMGF1PADDING") || upperCase.equals("OAEPWITHSHA-224ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA256ANDMGF1PADDING") || upperCase.equals("OAEPWITHSHA-256ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA384ANDMGF1PADDING") || upperCase.equals("OAEPWITHSHA-384ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA512ANDMGF1PADDING") || upperCase.equals("OAEPWITHSHA-512ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT));
        } else {
            throw new NoSuchPaddingException(str + " unavailable with RSA.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithRandom parametersWithRandom;
        ParametersWithRandom parametersWithRandom2;
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof OAEPParameterSpec)) {
            if (key instanceof RSAPublicKey) {
                if (!this.privateKeyOnly || i != 1) {
                    parametersWithRandom = RSAUtil.generatePublicKeyParameter((RSAPublicKey) key);
                } else {
                    throw new InvalidKeyException("mode 1 requires RSAPrivateKey");
                }
            } else if (!(key instanceof RSAPrivateKey)) {
                throw new InvalidKeyException("unknown key type passed to RSA");
            } else if (!this.publicKeyOnly || i != 1) {
                parametersWithRandom = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) key);
            } else {
                throw new InvalidKeyException("mode 2 requires RSAPublicKey");
            }
            if (algorithmParameterSpec != null) {
                OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                this.paramSpec = algorithmParameterSpec;
                if (!oAEPParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !oAEPParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId())) {
                    throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
                } else if (oAEPParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                    Digest digest = DigestFactory.getDigest(oAEPParameterSpec.getDigestAlgorithm());
                    if (digest != null) {
                        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
                        Digest digest2 = DigestFactory.getDigest(mGF1ParameterSpec.getDigestAlgorithm());
                        if (digest2 != null) {
                            this.cipher = new OAEPEncoding(new RSABlindedEngine(), digest, digest2, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
                        } else {
                            throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
                        }
                    } else {
                        throw new InvalidAlgorithmParameterException("no match on digest algorithm: " + oAEPParameterSpec.getDigestAlgorithm());
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("unkown MGF parameters");
                }
            }
            if (!(this.cipher instanceof RSABlindedEngine)) {
                if (secureRandom != null) {
                    parametersWithRandom2 = new ParametersWithRandom(parametersWithRandom, secureRandom);
                } else {
                    parametersWithRandom2 = new ParametersWithRandom(parametersWithRandom, new SecureRandom());
                }
                parametersWithRandom = parametersWithRandom2;
            }
            this.bOut.reset();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new InvalidParameterException("unknown opmode " + i + " passed to RSA");
                        }
                    }
                }
                this.cipher.init(false, parametersWithRandom);
                return;
            }
            this.cipher.init(true, parametersWithRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("unknown parameter type: " + algorithmParameterSpec.getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(OAEPParameterSpec.class);
            } catch (InvalidParameterSpecException e) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e.toString(), e);
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.engineParams = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException("Eeeek! " + e.toString(), e);
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.bOut.write(bArr, i, i2);
        if (this.cipher instanceof RSABlindedEngine) {
            if (this.bOut.size() <= this.cipher.getInputBlockSize() + 1) {
                return null;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        } else if (this.bOut.size() <= this.cipher.getInputBlockSize()) {
            return null;
        } else {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.bOut.write(bArr, i, i2);
        if (this.cipher instanceof RSABlindedEngine) {
            if (this.bOut.size() <= this.cipher.getInputBlockSize() + 1) {
                return 0;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        } else if (this.bOut.size() <= this.cipher.getInputBlockSize()) {
            return 0;
        } else {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            this.bOut.write(bArr, i, i2);
        }
        if (this.cipher instanceof RSABlindedEngine) {
            if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.bOut.size() > this.cipher.getInputBlockSize()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        try {
            byte[] byteArray = this.bOut.toByteArray();
            this.bOut.reset();
            return this.cipher.processBlock(byteArray, 0, byteArray.length);
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            this.bOut.write(bArr, i, i2);
        }
        if (this.cipher instanceof RSABlindedEngine) {
            if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.bOut.size() > this.cipher.getInputBlockSize()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        try {
            byte[] byteArray = this.bOut.toByteArray();
            byte[] processBlock = this.cipher.processBlock(byteArray, 0, byteArray.length);
            this.bOut.reset();
            for (int i4 = 0; i4 != processBlock.length; i4++) {
                bArr2[i3 + i4] = processBlock[i4];
            }
            return processBlock.length;
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        } catch (Throwable th) {
            this.bOut.reset();
            throw th;
        }
    }

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super((AsymmetricBlockCipher) new RSABlindedEngine());
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super((AsymmetricBlockCipher) new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PrivateOnly extends CipherSpi {
        public PKCS1v1_5Padding_PrivateOnly() {
            super(false, true, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PublicOnly extends CipherSpi {
        public PKCS1v1_5Padding_PublicOnly() {
            super(true, false, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class OAEPPadding extends CipherSpi {
        public OAEPPadding() {
            super(OAEPParameterSpec.DEFAULT);
        }
    }

    public static class ISO9796d1Padding extends CipherSpi {
        public ISO9796d1Padding() {
            super((AsymmetricBlockCipher) new ISO9796d1Encoding(new RSABlindedEngine()));
        }
    }
}
