package org.spongycastle.cms;

import org.spongycastle.util.Selector;

public abstract class RecipientId implements Selector {
    public static final int kek = 1;
    public static final int keyAgree = 2;
    public static final int keyTrans = 0;
    public static final int password = 3;
    private final int type;

    public abstract Object clone();

    protected RecipientId(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
