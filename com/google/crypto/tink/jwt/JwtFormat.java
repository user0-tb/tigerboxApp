package com.google.crypto.tink.jwt;

import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonObject;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import p009j$.util.Optional;

final class JwtFormat {
    static boolean isValidUrlsafeBase64Char(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '-' || c == '_');
    }

    static class Parts {
        String header;
        String payload;
        byte[] signatureOrMac;
        String unsignedCompact;

        Parts(String str, byte[] bArr, String str2, String str3) {
            this.unsignedCompact = str;
            this.signatureOrMac = bArr;
            this.header = str2;
            this.payload = str3;
        }
    }

    private JwtFormat() {
    }

    static void validateUtf8(byte[] bArr) throws JwtInvalidException {
        try {
            StandardCharsets.UTF_8.newDecoder().decode(ByteBuffer.wrap(bArr));
        } catch (CharacterCodingException e) {
            throw new JwtInvalidException(e.getMessage());
        }
    }

    static byte[] strictUrlSafeDecode(String str) throws JwtInvalidException {
        int i = 0;
        while (i < str.length()) {
            if (isValidUrlsafeBase64Char(str.charAt(i))) {
                i++;
            } else {
                throw new JwtInvalidException("invalid encoding");
            }
        }
        try {
            return Base64.urlSafeDecode(str);
        } catch (IllegalArgumentException e) {
            throw new JwtInvalidException("invalid encoding: " + e);
        }
    }

    private static String validateAlgorithm(String str) throws InvalidAlgorithmParameterException {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 66245349:
                if (str.equals("ES256")) {
                    c = 0;
                    break;
                }
                break;
            case 66246401:
                if (str.equals("ES384")) {
                    c = 1;
                    break;
                }
                break;
            case 66248104:
                if (str.equals("ES512")) {
                    c = 2;
                    break;
                }
                break;
            case 69015912:
                if (str.equals("HS256")) {
                    c = 3;
                    break;
                }
                break;
            case 69016964:
                if (str.equals("HS384")) {
                    c = 4;
                    break;
                }
                break;
            case 69018667:
                if (str.equals("HS512")) {
                    c = 5;
                    break;
                }
                break;
            case 76404080:
                if (str.equals("PS256")) {
                    c = 6;
                    break;
                }
                break;
            case 76405132:
                if (str.equals("PS384")) {
                    c = 7;
                    break;
                }
                break;
            case 76406835:
                if (str.equals("PS512")) {
                    c = 8;
                    break;
                }
                break;
            case 78251122:
                if (str.equals("RS256")) {
                    c = 9;
                    break;
                }
                break;
            case 78252174:
                if (str.equals("RS384")) {
                    c = 10;
                    break;
                }
                break;
            case 78253877:
                if (str.equals("RS512")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return str;
            default:
                throw new InvalidAlgorithmParameterException("invalid algorithm: " + str);
        }
    }

    static String createHeader(String str, Optional<String> optional, Optional<String> optional2) throws InvalidAlgorithmParameterException {
        validateAlgorithm(str);
        JsonObject jsonObject = new JsonObject();
        if (optional2.isPresent()) {
            jsonObject.addProperty("kid", optional2.get());
        }
        jsonObject.addProperty("alg", str);
        if (optional.isPresent()) {
            jsonObject.addProperty("typ", optional.get());
        }
        return Base64.urlSafeEncode(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
    }

    private static void validateKidInHeader(String str, JsonObject jsonObject) throws JwtInvalidException {
        if (!getStringHeader(jsonObject, "kid").equals(str)) {
            throw new JwtInvalidException("invalid kid in header");
        }
    }

    static void validateHeader(String str, Optional<String> optional, Optional<String> optional2, JsonObject jsonObject) throws InvalidAlgorithmParameterException, JwtInvalidException {
        validateAlgorithm(str);
        String stringHeader = getStringHeader(jsonObject, "alg");
        if (!stringHeader.equals(str)) {
            throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", new Object[]{str, stringHeader}));
        } else if (jsonObject.has("crit")) {
            throw new JwtInvalidException("all tokens with crit headers are rejected");
        } else if (!optional.isPresent() || !optional2.isPresent()) {
            boolean has = jsonObject.has("kid");
            if (optional.isPresent()) {
                if (has) {
                    validateKidInHeader(optional.get(), jsonObject);
                } else {
                    throw new JwtInvalidException("missing kid in header");
                }
            }
            if (optional2.isPresent() && has) {
                validateKidInHeader(optional2.get(), jsonObject);
            }
        } else {
            throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
        }
    }

    static Optional<String> getTypeHeader(JsonObject jsonObject) throws JwtInvalidException {
        if (jsonObject.has("typ")) {
            return Optional.m201of(getStringHeader(jsonObject, "typ"));
        }
        return Optional.empty();
    }

    private static String getStringHeader(JsonObject jsonObject, String str) throws JwtInvalidException {
        if (!jsonObject.has(str)) {
            throw new JwtInvalidException("header " + str + " does not exist");
        } else if (jsonObject.get(str).isJsonPrimitive() && jsonObject.get(str).getAsJsonPrimitive().isString()) {
            return jsonObject.get(str).getAsString();
        } else {
            throw new JwtInvalidException("header " + str + " is not a string");
        }
    }

    static String decodeHeader(String str) throws JwtInvalidException {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, StandardCharsets.UTF_8);
    }

    static String encodePayload(String str) {
        return Base64.urlSafeEncode(str.getBytes(StandardCharsets.UTF_8));
    }

    static String decodePayload(String str) throws JwtInvalidException {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, StandardCharsets.UTF_8);
    }

    static String encodeSignature(byte[] bArr) {
        return Base64.urlSafeEncode(bArr);
    }

    static byte[] decodeSignature(String str) throws JwtInvalidException {
        return strictUrlSafeDecode(str);
    }

    static Optional<String> getKid(int i, OutputPrefixType outputPrefixType) throws JwtInvalidException {
        if (outputPrefixType == OutputPrefixType.RAW) {
            return Optional.empty();
        }
        if (outputPrefixType == OutputPrefixType.TINK) {
            return Optional.m201of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(i).array()));
        }
        throw new JwtInvalidException("unsupported output prefix type");
    }

    static Optional<Integer> getKeyId(String str) {
        byte[] urlSafeDecode = Base64.urlSafeDecode(str);
        if (urlSafeDecode.length != 4) {
            return Optional.empty();
        }
        return Optional.m201of(Integer.valueOf(ByteBuffer.wrap(urlSafeDecode).getInt()));
    }

    static Parts splitSignedCompact(String str) throws JwtInvalidException {
        validateASCII(str);
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            byte[] decodeSignature = decodeSignature(str.substring(lastIndexOf + 1));
            int indexOf = substring.indexOf(46);
            if (indexOf >= 0) {
                String substring2 = substring.substring(0, indexOf);
                String substring3 = substring.substring(indexOf + 1);
                if (substring3.indexOf(46) <= 0) {
                    return new Parts(substring, decodeSignature, decodeHeader(substring2), decodePayload(substring3));
                }
                throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
            }
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
    }

    static String createUnsignedCompact(String str, Optional<String> optional, RawJwt rawJwt) throws InvalidAlgorithmParameterException, JwtInvalidException {
        String jsonPayload = rawJwt.getJsonPayload();
        Optional of = rawJwt.hasTypeHeader() ? Optional.m201of(rawJwt.getTypeHeader()) : Optional.empty();
        return createHeader(str, of, optional) + DownloadsManager.EXTENSION_SEPARATOR + encodePayload(jsonPayload);
    }

    static String createSignedCompact(String str, byte[] bArr) {
        return str + DownloadsManager.EXTENSION_SEPARATOR + encodeSignature(bArr);
    }

    static void validateASCII(String str) throws JwtInvalidException {
        int i = 0;
        while (i < str.length()) {
            if ((str.charAt(i) & 128) <= 0) {
                i++;
            } else {
                throw new JwtInvalidException("Non ascii character");
            }
        }
    }
}
