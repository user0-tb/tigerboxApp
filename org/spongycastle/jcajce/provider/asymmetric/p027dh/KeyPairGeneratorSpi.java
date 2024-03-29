package org.spongycastle.jcajce.provider.asymmetric.p027dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.spongycastle.crypto.generators.DHParametersGenerator;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Integers;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.dh.KeyPairGeneratorSpi */
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    private static Object lock = new Object();
    private static Hashtable params = new Hashtable();
    int certainty = 20;
    DHBasicKeyPairGenerator engine = new DHBasicKeyPairGenerator();
    boolean initialised = false;
    DHKeyGenerationParameters param;
    SecureRandom random = new SecureRandom();
    int strength = 1024;

    public KeyPairGeneratorSpi() {
        super("DH");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            DHKeyGenerationParameters dHKeyGenerationParameters = new DHKeyGenerationParameters(secureRandom, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), (BigInteger) null, dHParameterSpec.getL()));
            this.param = dHKeyGenerationParameters;
            this.engine.init(dHKeyGenerationParameters);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            Integer valueOf = Integers.valueOf(this.strength);
            if (params.containsKey(valueOf)) {
                this.param = (DHKeyGenerationParameters) params.get(valueOf);
            } else {
                DHParameterSpec dHDefaultParameters = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters(this.strength);
                if (dHDefaultParameters != null) {
                    this.param = new DHKeyGenerationParameters(this.random, new DHParameters(dHDefaultParameters.getP(), dHDefaultParameters.getG(), (BigInteger) null, dHDefaultParameters.getL()));
                } else {
                    synchronized (lock) {
                        if (params.containsKey(valueOf)) {
                            this.param = (DHKeyGenerationParameters) params.get(valueOf);
                        } else {
                            DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
                            dHParametersGenerator.init(this.strength, this.certainty, this.random);
                            DHKeyGenerationParameters dHKeyGenerationParameters = new DHKeyGenerationParameters(this.random, dHParametersGenerator.generateParameters());
                            this.param = dHKeyGenerationParameters;
                            params.put(valueOf, dHKeyGenerationParameters);
                        }
                    }
                }
            }
            this.engine.init(this.param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCDHPublicKey((DHPublicKeyParameters) generateKeyPair.getPublic()), new BCDHPrivateKey((DHPrivateKeyParameters) generateKeyPair.getPrivate()));
    }
}
