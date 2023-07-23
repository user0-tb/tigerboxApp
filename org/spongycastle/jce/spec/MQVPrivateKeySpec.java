package org.spongycastle.jce.spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.jce.interfaces.MQVPrivateKey;

public class MQVPrivateKeySpec implements KeySpec, MQVPrivateKey {
    private PrivateKey ephemeralPrivateKey;
    private PublicKey ephemeralPublicKey;
    private PrivateKey staticPrivateKey;

    public String getAlgorithm() {
        return "ECMQV";
    }

    public byte[] getEncoded() {
        return null;
    }

    public String getFormat() {
        return null;
    }

    public MQVPrivateKeySpec(PrivateKey privateKey, PrivateKey privateKey2) {
        this(privateKey, privateKey2, (PublicKey) null);
    }

    public MQVPrivateKeySpec(PrivateKey privateKey, PrivateKey privateKey2, PublicKey publicKey) {
        this.staticPrivateKey = privateKey;
        this.ephemeralPrivateKey = privateKey2;
        this.ephemeralPublicKey = publicKey;
    }

    public PrivateKey getStaticPrivateKey() {
        return this.staticPrivateKey;
    }

    public PrivateKey getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public PublicKey getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }
}
