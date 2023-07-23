package org.spongycastle.jcajce.provider.digest;

import com.google.android.exoplayer2.RendererCapabilities;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;

public class SHA3 {
    private SHA3() {
    }

    public static class DigestSHA3 extends BCMessageDigest implements Cloneable {
        public DigestSHA3(int i) {
            super(new SHA3Digest(i));
        }

        public Object clone() throws CloneNotSupportedException {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.digest = new SHA3Digest((SHA3Digest) this.digest);
            return bCMessageDigest;
        }
    }

    public static class Digest224 extends DigestSHA3 {
        public Digest224() {
            super(224);
        }
    }

    public static class Digest256 extends DigestSHA3 {
        public Digest256() {
            super(256);
        }
    }

    public static class Digest384 extends DigestSHA3 {
        public Digest384() {
            super(RendererCapabilities.MODE_SUPPORT_MASK);
        }
    }

    public static class Digest512 extends DigestSHA3 {
        public Digest512() {
            super(512);
        }
    }

    public static class HashMac224 extends BaseMac {
        public HashMac224() {
            super(new HMac(new SHA3Digest(224)));
        }
    }

    public static class HashMac256 extends BaseMac {
        public HashMac256() {
            super(new HMac(new SHA3Digest(256)));
        }
    }

    public static class HashMac384 extends BaseMac {
        public HashMac384() {
            super(new HMac(new SHA3Digest((int) RendererCapabilities.MODE_SUPPORT_MASK)));
        }
    }

    public static class HashMac512 extends BaseMac {
        public HashMac512() {
            super(new HMac(new SHA3Digest(512)));
        }
    }

    public static class KeyGenerator224 extends BaseKeyGenerator {
        public KeyGenerator224() {
            super("HMACSHA3-224", 224, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator256 extends BaseKeyGenerator {
        public KeyGenerator256() {
            super("HMACSHA3-256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator384 extends BaseKeyGenerator {
        public KeyGenerator384() {
            super("HMACSHA3-384", RendererCapabilities.MODE_SUPPORT_MASK, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator512 extends BaseKeyGenerator {
        public KeyGenerator512() {
            super("HMACSHA3-512", 512, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = SHA3.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            sb.append(str);
            sb.append("$Digest224");
            configurableProvider.addAlgorithm("MessageDigest.SHA3-224", sb.toString());
            configurableProvider.addAlgorithm("MessageDigest.SHA3-256", str + "$Digest256");
            configurableProvider.addAlgorithm("MessageDigest.SHA3-384", str + "$Digest384");
            configurableProvider.addAlgorithm("MessageDigest.SHA3-512", str + "$Digest512");
            addHMACAlgorithm(configurableProvider, "SHA3-224", str + "$HashMac224", str + "$KeyGenerator224");
            addHMACAlgorithm(configurableProvider, "SHA3-256", str + "$HashMac256", str + "$KeyGenerator256");
            addHMACAlgorithm(configurableProvider, "SHA3-384", str + "$HashMac384", str + "$KeyGenerator384");
            addHMACAlgorithm(configurableProvider, "SHA3-512", str + "$HashMac512", str + "$KeyGenerator512");
        }
    }
}
