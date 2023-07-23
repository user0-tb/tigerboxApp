package org.spongycastle.dvcs;

import org.spongycastle.asn1.dvcs.Data;

public abstract class DVCSRequestData {
    protected Data data;

    protected DVCSRequestData(Data data2) {
        this.data = data2;
    }

    public Data toASN1Structure() {
        return this.data;
    }
}
