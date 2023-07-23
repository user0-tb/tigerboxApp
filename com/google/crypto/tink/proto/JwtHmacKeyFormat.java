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

public final class JwtHmacKeyFormat extends GeneratedMessageLite<JwtHmacKeyFormat, Builder> implements JwtHmacKeyFormatOrBuilder {
    public static final int ALGORITHM_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final JwtHmacKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 3;
    private static volatile Parser<JwtHmacKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int algorithm_;
    private int keySize_;
    private int version_;

    private JwtHmacKeyFormat() {
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

    public int getAlgorithmValue() {
        return this.algorithm_;
    }

    public JwtHmacAlgorithm getAlgorithm() {
        JwtHmacAlgorithm forNumber = JwtHmacAlgorithm.forNumber(this.algorithm_);
        return forNumber == null ? JwtHmacAlgorithm.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setAlgorithmValue(int i) {
        this.algorithm_ = i;
    }

    /* access modifiers changed from: private */
    public void setAlgorithm(JwtHmacAlgorithm jwtHmacAlgorithm) {
        this.algorithm_ = jwtHmacAlgorithm.getNumber();
    }

    /* access modifiers changed from: private */
    public void clearAlgorithm() {
        this.algorithm_ = 0;
    }

    public int getKeySize() {
        return this.keySize_;
    }

    /* access modifiers changed from: private */
    public void setKeySize(int i) {
        this.keySize_ = i;
    }

    /* access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    public static JwtHmacKeyFormat parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static JwtHmacKeyFormat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static JwtHmacKeyFormat parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static JwtHmacKeyFormat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static JwtHmacKeyFormat parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static JwtHmacKeyFormat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static JwtHmacKeyFormat parseFrom(InputStream inputStream) throws IOException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtHmacKeyFormat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtHmacKeyFormat parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (JwtHmacKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtHmacKeyFormat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtHmacKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtHmacKeyFormat parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static JwtHmacKeyFormat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtHmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(JwtHmacKeyFormat jwtHmacKeyFormat) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(jwtHmacKeyFormat);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<JwtHmacKeyFormat, Builder> implements JwtHmacKeyFormatOrBuilder {
        /* synthetic */ Builder(C23021 r1) {
            this();
        }

        private Builder() {
            super(JwtHmacKeyFormat.DEFAULT_INSTANCE);
        }

        public int getVersion() {
            return ((JwtHmacKeyFormat) this.instance).getVersion();
        }

        public Builder setVersion(int i) {
            copyOnWrite();
            ((JwtHmacKeyFormat) this.instance).setVersion(i);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((JwtHmacKeyFormat) this.instance).clearVersion();
            return this;
        }

        public int getAlgorithmValue() {
            return ((JwtHmacKeyFormat) this.instance).getAlgorithmValue();
        }

        public Builder setAlgorithmValue(int i) {
            copyOnWrite();
            ((JwtHmacKeyFormat) this.instance).setAlgorithmValue(i);
            return this;
        }

        public JwtHmacAlgorithm getAlgorithm() {
            return ((JwtHmacKeyFormat) this.instance).getAlgorithm();
        }

        public Builder setAlgorithm(JwtHmacAlgorithm jwtHmacAlgorithm) {
            copyOnWrite();
            ((JwtHmacKeyFormat) this.instance).setAlgorithm(jwtHmacAlgorithm);
            return this;
        }

        public Builder clearAlgorithm() {
            copyOnWrite();
            ((JwtHmacKeyFormat) this.instance).clearAlgorithm();
            return this;
        }

        public int getKeySize() {
            return ((JwtHmacKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int i) {
            copyOnWrite();
            ((JwtHmacKeyFormat) this.instance).setKeySize(i);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((JwtHmacKeyFormat) this.instance).clearKeySize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.JwtHmacKeyFormat$1 */
    static /* synthetic */ class C23021 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f422xa1df5c61;

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
                f422xa1df5c61 = r0
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f422xa1df5c61     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f422xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f422xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f422xa1df5c61     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f422xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f422xa1df5c61     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.proto.JwtHmacKeyFormat.C23021.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C23021.f422xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new JwtHmacKeyFormat();
            case 2:
                return new Builder((C23021) null);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\f\u0003\u000b", new Object[]{"version_", "algorithm_", "keySize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<JwtHmacKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (JwtHmacKeyFormat.class) {
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
        JwtHmacKeyFormat jwtHmacKeyFormat = new JwtHmacKeyFormat();
        DEFAULT_INSTANCE = jwtHmacKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(JwtHmacKeyFormat.class, jwtHmacKeyFormat);
    }

    public static JwtHmacKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<JwtHmacKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
