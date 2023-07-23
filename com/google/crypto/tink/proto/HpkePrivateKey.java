package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HpkePublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class HpkePrivateKey extends GeneratedMessageLite<HpkePrivateKey, Builder> implements HpkePrivateKeyOrBuilder {
    /* access modifiers changed from: private */
    public static final HpkePrivateKey DEFAULT_INSTANCE;
    private static volatile Parser<HpkePrivateKey> PARSER = null;
    public static final int PRIVATE_KEY_FIELD_NUMBER = 3;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString privateKey_ = ByteString.EMPTY;
    private HpkePublicKey publicKey_;
    private int version_;

    private HpkePrivateKey() {
    }

    public int getVersion() {
        return this.version_;
    }

    /* access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    /* access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public boolean hasPublicKey() {
        return this.publicKey_ != null;
    }

    public HpkePublicKey getPublicKey() {
        HpkePublicKey hpkePublicKey = this.publicKey_;
        return hpkePublicKey == null ? HpkePublicKey.getDefaultInstance() : hpkePublicKey;
    }

    /* access modifiers changed from: private */
    public void setPublicKey(HpkePublicKey hpkePublicKey) {
        hpkePublicKey.getClass();
        this.publicKey_ = hpkePublicKey;
    }

    /* access modifiers changed from: private */
    public void mergePublicKey(HpkePublicKey hpkePublicKey) {
        hpkePublicKey.getClass();
        HpkePublicKey hpkePublicKey2 = this.publicKey_;
        if (hpkePublicKey2 == null || hpkePublicKey2 == HpkePublicKey.getDefaultInstance()) {
            this.publicKey_ = hpkePublicKey;
        } else {
            this.publicKey_ = (HpkePublicKey) ((HpkePublicKey.Builder) HpkePublicKey.newBuilder(this.publicKey_).mergeFrom(hpkePublicKey)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    public ByteString getPrivateKey() {
        return this.privateKey_;
    }

    /* access modifiers changed from: private */
    public void setPrivateKey(ByteString byteString) {
        byteString.getClass();
        this.privateKey_ = byteString;
    }

    /* access modifiers changed from: private */
    public void clearPrivateKey() {
        this.privateKey_ = getDefaultInstance().getPrivateKey();
    }

    public static HpkePrivateKey parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static HpkePrivateKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HpkePrivateKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HpkePrivateKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HpkePrivateKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HpkePrivateKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HpkePrivateKey parseFrom(InputStream inputStream) throws IOException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HpkePrivateKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HpkePrivateKey parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HpkePrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HpkePrivateKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HpkePrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HpkePrivateKey parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HpkePrivateKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HpkePrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HpkePrivateKey hpkePrivateKey) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(hpkePrivateKey);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HpkePrivateKey, Builder> implements HpkePrivateKeyOrBuilder {
        /* synthetic */ Builder(C22941 r1) {
            this();
        }

        private Builder() {
            super(HpkePrivateKey.DEFAULT_INSTANCE);
        }

        public int getVersion() {
            return ((HpkePrivateKey) this.instance).getVersion();
        }

        public Builder setVersion(int i) {
            copyOnWrite();
            ((HpkePrivateKey) this.instance).setVersion(i);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((HpkePrivateKey) this.instance).clearVersion();
            return this;
        }

        public boolean hasPublicKey() {
            return ((HpkePrivateKey) this.instance).hasPublicKey();
        }

        public HpkePublicKey getPublicKey() {
            return ((HpkePrivateKey) this.instance).getPublicKey();
        }

        public Builder setPublicKey(HpkePublicKey hpkePublicKey) {
            copyOnWrite();
            ((HpkePrivateKey) this.instance).setPublicKey(hpkePublicKey);
            return this;
        }

        public Builder setPublicKey(HpkePublicKey.Builder builder) {
            copyOnWrite();
            ((HpkePrivateKey) this.instance).setPublicKey((HpkePublicKey) builder.build());
            return this;
        }

        public Builder mergePublicKey(HpkePublicKey hpkePublicKey) {
            copyOnWrite();
            ((HpkePrivateKey) this.instance).mergePublicKey(hpkePublicKey);
            return this;
        }

        public Builder clearPublicKey() {
            copyOnWrite();
            ((HpkePrivateKey) this.instance).clearPublicKey();
            return this;
        }

        public ByteString getPrivateKey() {
            return ((HpkePrivateKey) this.instance).getPrivateKey();
        }

        public Builder setPrivateKey(ByteString byteString) {
            copyOnWrite();
            ((HpkePrivateKey) this.instance).setPrivateKey(byteString);
            return this;
        }

        public Builder clearPrivateKey() {
            copyOnWrite();
            ((HpkePrivateKey) this.instance).clearPrivateKey();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HpkePrivateKey$1 */
    static /* synthetic */ class C22941 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f414xa1df5c61;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f414xa1df5c61 = r0
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f414xa1df5c61     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f414xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f414xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f414xa1df5c61     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f414xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f414xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.HpkePrivateKey.C22941.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C22941.f414xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new HpkePrivateKey();
            case 2:
                return new Builder((C22941) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "publicKey_", "privateKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HpkePrivateKey> parser = PARSER;
                if (parser == null) {
                    synchronized (HpkePrivateKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HpkePrivateKey hpkePrivateKey = new HpkePrivateKey();
        DEFAULT_INSTANCE = hpkePrivateKey;
        GeneratedMessageLite.registerDefaultInstance(HpkePrivateKey.class, hpkePrivateKey);
    }

    public static HpkePrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HpkePrivateKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
