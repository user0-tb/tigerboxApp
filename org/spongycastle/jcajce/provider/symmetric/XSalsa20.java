package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.XSalsa20Engine;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class XSalsa20 {
    private XSalsa20() {
    }

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new XSalsa20Engine(), 24);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("XSalsa20", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = XSalsa20.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            sb.append(str);
            sb.append("$Base");
            configurableProvider.addAlgorithm("Cipher.XSALSA20", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.XSALSA20", str + "$KeyGen");
        }
    }
}
