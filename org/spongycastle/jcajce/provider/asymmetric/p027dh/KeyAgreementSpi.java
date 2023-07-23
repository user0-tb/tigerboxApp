package org.spongycastle.jcajce.provider.asymmetric.p027dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi */
public class KeyAgreementSpi extends javax.crypto.KeyAgreementSpi {
    private static final Hashtable algorithms;

    /* renamed from: g */
    private BigInteger f1193g;

    /* renamed from: p */
    private BigInteger f1194p;
    private BigInteger result;

    /* renamed from: x */
    private BigInteger f1195x;

    static {
        Hashtable hashtable = new Hashtable();
        algorithms = hashtable;
        Integer valueOf = Integers.valueOf(64);
        Integer valueOf2 = Integers.valueOf(192);
        Integer valueOf3 = Integers.valueOf(128);
        Integer valueOf4 = Integers.valueOf(256);
        hashtable.put("DES", valueOf);
        hashtable.put("DESEDE", valueOf2);
        hashtable.put("BLOWFISH", valueOf3);
        hashtable.put("AES", valueOf4);
    }

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        int bitLength = (this.f1194p.bitLength() + 7) / 8;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == bitLength) {
            return byteArray;
        }
        if (byteArray[0] == 0 && byteArray.length == bitLength + 1) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            return bArr;
        }
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(byteArray, 0, bArr2, bitLength - byteArray.length, byteArray.length);
        return bArr2;
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (this.f1195x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        } else if (key instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            if (!dHPublicKey.getParams().getG().equals(this.f1193g) || !dHPublicKey.getParams().getP().equals(this.f1194p)) {
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            } else if (z) {
                this.result = dHPublicKey.getY().modPow(this.f1195x, this.f1194p);
                return null;
            } else {
                BigInteger modPow = dHPublicKey.getY().modPow(this.f1195x, this.f1194p);
                this.result = modPow;
                return new BCDHPublicKey(modPow, dHPublicKey.getParams());
            }
        } else {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.f1195x != null) {
            return bigIntToBytes(this.result);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        if (this.f1195x != null) {
            byte[] bigIntToBytes = bigIntToBytes(this.result);
            if (bArr.length - i >= bigIntToBytes.length) {
                System.arraycopy(bigIntToBytes, 0, bArr, i, bigIntToBytes.length);
                return bigIntToBytes.length;
            }
            throw new ShortBufferException("DHKeyAgreement - buffer too short");
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    public SecretKey engineGenerateSecret(String str) {
        if (this.f1195x != null) {
            String upperCase = Strings.toUpperCase(str);
            byte[] bigIntToBytes = bigIntToBytes(this.result);
            Hashtable hashtable = algorithms;
            if (!hashtable.containsKey(upperCase)) {
                return new SecretKeySpec(bigIntToBytes, str);
            }
            int intValue = ((Integer) hashtable.get(upperCase)).intValue() / 8;
            byte[] bArr = new byte[intValue];
            System.arraycopy(bigIntToBytes, 0, bArr, 0, intValue);
            if (upperCase.startsWith("DES")) {
                DESParameters.setOddParity(bArr);
            }
            return new SecretKeySpec(bArr, str);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec == null) {
                this.f1194p = dHPrivateKey.getParams().getP();
                this.f1193g = dHPrivateKey.getParams().getG();
            } else if (algorithmParameterSpec instanceof DHParameterSpec) {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.f1194p = dHParameterSpec.getP();
                this.f1193g = dHParameterSpec.getG();
            } else {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            BigInteger x = dHPrivateKey.getX();
            this.result = x;
            this.f1195x = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.f1194p = dHPrivateKey.getParams().getP();
            this.f1193g = dHPrivateKey.getParams().getG();
            BigInteger x = dHPrivateKey.getX();
            this.result = x;
            this.f1195x = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }
}
