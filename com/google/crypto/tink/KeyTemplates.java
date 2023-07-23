package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public final class KeyTemplates {
    public static KeyTemplate get(String str) throws GeneralSecurityException {
        KeyTemplate keyTemplate = Registry.keyTemplateMap().get(str);
        if (keyTemplate != null) {
            return keyTemplate;
        }
        throw new GeneralSecurityException("cannot find key template: " + str);
    }

    private KeyTemplates() {
    }
}
