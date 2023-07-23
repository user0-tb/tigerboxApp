package org.spongycastle.operator;

import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class GenericKey {
    private AlgorithmIdentifier algorithmIdentifier;
    private Object representation;

    public GenericKey(Object obj) {
        this.algorithmIdentifier = null;
        this.representation = obj;
    }

    public GenericKey(AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) {
        this.algorithmIdentifier = algorithmIdentifier2;
        this.representation = bArr;
    }

    protected GenericKey(AlgorithmIdentifier algorithmIdentifier2, Object obj) {
        this.algorithmIdentifier = algorithmIdentifier2;
        this.representation = obj;
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.algorithmIdentifier;
    }

    public Object getRepresentation() {
        return this.representation;
    }
}
