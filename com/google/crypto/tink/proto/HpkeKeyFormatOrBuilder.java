package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface HpkeKeyFormatOrBuilder extends MessageLiteOrBuilder {
    HpkeParams getParams();

    boolean hasParams();
}
