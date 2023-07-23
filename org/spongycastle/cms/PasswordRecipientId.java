package org.spongycastle.cms;

public class PasswordRecipientId extends RecipientId {
    public int hashCode() {
        return 3;
    }

    public PasswordRecipientId() {
        super(3);
    }

    public boolean equals(Object obj) {
        return obj instanceof PasswordRecipientId;
    }

    public Object clone() {
        return new PasswordRecipientId();
    }

    public boolean match(Object obj) {
        return obj instanceof PasswordRecipientInformation;
    }
}
