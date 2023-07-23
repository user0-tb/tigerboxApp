package org.spongycastle.openssl.jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.openssl.PEMEncryptor;
import org.spongycastle.openssl.PEMException;

public class JcePEMEncryptorBuilder {
    /* access modifiers changed from: private */
    public final String algorithm;
    /* access modifiers changed from: private */
    public JcaJceHelper helper = new DefaultJcaJceHelper();
    private SecureRandom random;

    public JcePEMEncryptorBuilder(String str) {
        this.algorithm = str;
    }

    public JcePEMEncryptorBuilder setProvider(Provider provider) {
        this.helper = new ProviderJcaJceHelper(provider);
        return this;
    }

    public JcePEMEncryptorBuilder setProvider(String str) {
        this.helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePEMEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public PEMEncryptor build(final char[] cArr) {
        if (this.random == null) {
            this.random = new SecureRandom();
        }
        final byte[] bArr = new byte[(this.algorithm.startsWith("AES-") ? 16 : 8)];
        this.random.nextBytes(bArr);
        return new PEMEncryptor() {
            public String getAlgorithm() {
                return JcePEMEncryptorBuilder.this.algorithm;
            }

            public byte[] getIV() {
                return bArr;
            }

            public byte[] encrypt(byte[] bArr) throws PEMException {
                return PEMUtilities.crypt(true, JcePEMEncryptorBuilder.this.helper, bArr, cArr, JcePEMEncryptorBuilder.this.algorithm, bArr);
            }
        };
    }
}
