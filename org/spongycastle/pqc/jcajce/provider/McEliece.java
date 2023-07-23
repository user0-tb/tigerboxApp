package org.spongycastle.pqc.jcajce.provider;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;

public class McEliece {
    private static final String PREFIX = "org.spongycastle.pqc.jcajce.provider.mceliece.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyPairGenerator.McElieceKobaraImai", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McElieceCCA2");
            configurableProvider.addAlgorithm("KeyPairGenerator.McEliecePointcheval", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McElieceCCA2");
            configurableProvider.addAlgorithm("KeyPairGenerator.McElieceFujisaki", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McElieceCCA2");
            configurableProvider.addAlgorithm("KeyPairGenerator.McEliecePKCS", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McEliece");
            configurableProvider.addAlgorithm("KeyPairGenerator." + PQCObjectIdentifiers.mcEliece, "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McEliece");
            configurableProvider.addAlgorithm("KeyPairGenerator." + PQCObjectIdentifiers.mcElieceCca2, "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McElieceCCA2");
            configurableProvider.addAlgorithm("Cipher.McEliecePointcheval", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval");
            configurableProvider.addAlgorithm("Cipher.McEliecePointchevalWithSHA1", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval");
            configurableProvider.addAlgorithm("Cipher.McEliecePointchevalWithSHA224", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval224");
            configurableProvider.addAlgorithm("Cipher.McEliecePointchevalWithSHA256", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval256");
            configurableProvider.addAlgorithm("Cipher.McEliecePointchevalWithSHA384", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval384");
            configurableProvider.addAlgorithm("Cipher.McEliecePointchevalWithSHA512", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval512");
            configurableProvider.addAlgorithm("Cipher.McEliecePKCS", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS");
            configurableProvider.addAlgorithm("Cipher.McEliecePKCSWithSHA1", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS");
            configurableProvider.addAlgorithm("Cipher.McEliecePKCSWithSHA224", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS224");
            configurableProvider.addAlgorithm("Cipher.McEliecePKCSWithSHA256", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS256");
            configurableProvider.addAlgorithm("Cipher.McEliecePKCSWithSHA384", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS384");
            configurableProvider.addAlgorithm("Cipher.McEliecePKCSWithSHA512", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS512");
            configurableProvider.addAlgorithm("Cipher.McElieceKobaraImai", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai");
            configurableProvider.addAlgorithm("Cipher.McElieceKobaraImaiWithSHA1", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai");
            configurableProvider.addAlgorithm("Cipher.McElieceKobaraImaiWithSHA224", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai224");
            configurableProvider.addAlgorithm("Cipher.McElieceKobaraImaiWithSHA256", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai256");
            configurableProvider.addAlgorithm("Cipher.McElieceKobaraImaiWithSHA384", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai384");
            configurableProvider.addAlgorithm("Cipher.McElieceKobaraImaiWithSHA512", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai512");
            configurableProvider.addAlgorithm("Cipher.McElieceFujisaki", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki");
            configurableProvider.addAlgorithm("Cipher.McElieceFujisakiWithSHA1", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki");
            configurableProvider.addAlgorithm("Cipher.McElieceFujisakiWithSHA224", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki224");
            configurableProvider.addAlgorithm("Cipher.McElieceFujisakiWithSHA256", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki256");
            configurableProvider.addAlgorithm("Cipher.McElieceFujisakiWithSHA384", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki384");
            configurableProvider.addAlgorithm("Cipher.McElieceFujisakiWithSHA512", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki512");
        }
    }
}
