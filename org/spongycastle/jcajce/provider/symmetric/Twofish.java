package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public final class Twofish {

    public static class AlgParams extends IvAlgorithmParameters {
        /* access modifiers changed from: protected */
        public String engineToString() {
            return "Twofish IV";
        }
    }

    private Twofish() {
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public BlockCipher get() {
                    return new TwofishEngine();
                }
            });
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Twofish", 256, new CipherKeyGenerator());
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new TwofishEngine())));
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new TwofishEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Twofish", 256, new Poly1305KeyGenerator());
        }
    }

    public static class PBEWithSHAKeyFactory extends PBESecretKeyFactory {
        public PBEWithSHAKeyFactory() {
            super("PBEwithSHAandTwofish-CBC", (ASN1ObjectIdentifier) null, true, 2, 1, 256, 128);
        }
    }

    public static class PBEWithSHA extends BaseBlockCipher {
        public PBEWithSHA() {
            super((BlockCipher) new CBCBlockCipher(new TwofishEngine()));
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        private static final String PREFIX = Twofish.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            sb.append(str);
            sb.append("$ECB");
            configurableProvider.addAlgorithm("Cipher.Twofish", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.Twofish", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.Twofish", str + "$AlgParams");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH-CBC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Cipher.PBEWITHSHAANDTWOFISH-CBC", str + "$PBEWithSHA");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAANDTWOFISH-CBC", str + "$PBEWithSHAKeyFactory");
            addGMacAlgorithm(configurableProvider, "Twofish", str + "$GMAC", str + "$KeyGen");
            addPoly1305Algorithm(configurableProvider, "Twofish", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }
}
