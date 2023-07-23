package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class HpkeParams extends GeneratedMessageLite<HpkeParams, Builder> implements HpkeParamsOrBuilder {
    public static final int AEAD_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final HpkeParams DEFAULT_INSTANCE;
    public static final int KDF_FIELD_NUMBER = 2;
    public static final int KEM_FIELD_NUMBER = 1;
    private static volatile Parser<HpkeParams> PARSER;
    private int aead_;
    private int kdf_;
    private int kem_;

    private HpkeParams() {
    }

    public int getKemValue() {
        return this.kem_;
    }

    public HpkeKem getKem() {
        HpkeKem forNumber = HpkeKem.forNumber(this.kem_);
        return forNumber == null ? HpkeKem.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setKemValue(int i) {
        this.kem_ = i;
    }

    /* access modifiers changed from: private */
    public void setKem(HpkeKem hpkeKem) {
        this.kem_ = hpkeKem.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearKem() {
        this.kem_ = 0;
    }

    public int getKdfValue() {
        return this.kdf_;
    }

    public HpkeKdf getKdf() {
        HpkeKdf forNumber = HpkeKdf.forNumber(this.kdf_);
        return forNumber == null ? HpkeKdf.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setKdfValue(int i) {
        this.kdf_ = i;
    }

    /* access modifiers changed from: private */
    public void setKdf(HpkeKdf hpkeKdf) {
        this.kdf_ = hpkeKdf.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearKdf() {
        this.kdf_ = 0;
    }

    public int getAeadValue() {
        return this.aead_;
    }

    public HpkeAead getAead() {
        HpkeAead forNumber = HpkeAead.forNumber(this.aead_);
        return forNumber == null ? HpkeAead.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setAeadValue(int i) {
        this.aead_ = i;
    }

    /* access modifiers changed from: private */
    public void setAead(HpkeAead hpkeAead) {
        this.aead_ = hpkeAead.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearAead() {
        this.aead_ = 0;
    }

    public static HpkeParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static HpkeParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HpkeParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HpkeParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HpkeParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HpkeParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HpkeParams parseFrom(InputStream inputStream) throws IOException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HpkeParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HpkeParams parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HpkeParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HpkeParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HpkeParams) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HpkeParams parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HpkeParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HpkeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HpkeParams hpkeParams) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(hpkeParams);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HpkeParams, Builder> implements HpkeParamsOrBuilder {
        /* synthetic */ Builder(C22931 r1) {
            this();
        }

        private Builder() {
            super(HpkeParams.DEFAULT_INSTANCE);
        }

        public int getKemValue() {
            return ((HpkeParams) this.instance).getKemValue();
        }

        public Builder setKemValue(int i) {
            copyOnWrite();
            ((HpkeParams) this.instance).setKemValue(i);
            return this;
        }

        public HpkeKem getKem() {
            return ((HpkeParams) this.instance).getKem();
        }

        public Builder setKem(HpkeKem hpkeKem) {
            copyOnWrite();
            ((HpkeParams) this.instance).setKem(hpkeKem);
            return this;
        }

        public Builder clearKem() {
            copyOnWrite();
            ((HpkeParams) this.instance).clearKem();
            return this;
        }

        public int getKdfValue() {
            return ((HpkeParams) this.instance).getKdfValue();
        }

        public Builder setKdfValue(int i) {
            copyOnWrite();
            ((HpkeParams) this.instance).setKdfValue(i);
            return this;
        }

        public HpkeKdf getKdf() {
            return ((HpkeParams) this.instance).getKdf();
        }

        public Builder setKdf(HpkeKdf hpkeKdf) {
            copyOnWrite();
            ((HpkeParams) this.instance).setKdf(hpkeKdf);
            return this;
        }

        public Builder clearKdf() {
            copyOnWrite();
            ((HpkeParams) this.instance).clearKdf();
            return this;
        }

        public int getAeadValue() {
            return ((HpkeParams) this.instance).getAeadValue();
        }

        public Builder setAeadValue(int i) {
            copyOnWrite();
            ((HpkeParams) this.instance).setAeadValue(i);
            return this;
        }

        public HpkeAead getAead() {
            return ((HpkeParams) this.instance).getAead();
        }

        public Builder setAead(HpkeAead hpkeAead) {
            copyOnWrite();
            ((HpkeParams) this.instance).setAead(hpkeAead);
            return this;
        }

        public Builder clearAead() {
            copyOnWrite();
            ((HpkeParams) this.instance).clearAead();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HpkeParams$1 */
    static /* synthetic */ class C22931 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f413xa1df5c61;

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
                f413xa1df5c61 = r0
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f413xa1df5c61     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f413xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f413xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f413xa1df5c61     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f413xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f413xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.HpkeParams.C22931.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C22931.f413xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new HpkeParams();
            case 2:
                return new Builder((C22931) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"kem_", "kdf_", "aead_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HpkeParams> parser = PARSER;
                if (parser == null) {
                    synchronized (HpkeParams.class) {
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
        HpkeParams hpkeParams = new HpkeParams();
        DEFAULT_INSTANCE = hpkeParams;
        GeneratedMessageLite.registerDefaultInstance(HpkeParams.class, hpkeParams);
    }

    public static HpkeParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HpkeParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
