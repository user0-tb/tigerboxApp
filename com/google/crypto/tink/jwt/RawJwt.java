package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import p009j$.time.Instant;
import p009j$.util.Optional;

@Immutable
public final class RawJwt {
    private static final long MAX_TIMESTAMP_VALUE = 253402300799L;
    private final JsonObject payload;
    private final Optional<String> typeHeader;

    private RawJwt(Builder builder) {
        if (!builder.payload.has("exp") && !builder.withoutExpiration) {
            throw new IllegalArgumentException("neither setExpiration() nor withoutExpiration() was called");
        } else if (!builder.payload.has("exp") || !builder.withoutExpiration) {
            this.typeHeader = builder.typeHeader;
            this.payload = builder.payload.deepCopy();
        } else {
            throw new IllegalArgumentException("setExpiration() and withoutExpiration() must not be called together");
        }
    }

    private RawJwt(Optional<String> optional, String str) throws JwtInvalidException {
        this.typeHeader = optional;
        this.payload = JsonUtil.parseJson(str);
        validateStringClaim("iss");
        validateStringClaim("sub");
        validateStringClaim("jti");
        validateTimestampClaim("exp");
        validateTimestampClaim("nbf");
        validateTimestampClaim("iat");
        validateAudienceClaim();
    }

    private void validateStringClaim(String str) throws JwtInvalidException {
        if (this.payload.has(str)) {
            if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isString()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a string.");
            }
        }
    }

    private void validateTimestampClaim(String str) throws JwtInvalidException {
        if (this.payload.has(str)) {
            if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a number.");
            }
            double asDouble = this.payload.get(str).getAsJsonPrimitive().getAsDouble();
            if (asDouble > 2.53402300799E11d || asDouble < 0.0d) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " has an invalid timestamp");
            }
        }
    }

    private void validateAudienceClaim() throws JwtInvalidException {
        if (this.payload.has("aud")) {
            if ((!this.payload.get("aud").isJsonPrimitive() || !this.payload.get("aud").getAsJsonPrimitive().isString()) && getAudiences().size() < 1) {
                throw new JwtInvalidException("invalid JWT payload: claim aud is present but empty.");
            }
        }
    }

    static RawJwt fromJsonPayload(Optional<String> optional, String str) throws JwtInvalidException {
        return new RawJwt(optional, str);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public final JsonObject payload;
        /* access modifiers changed from: private */
        public Optional<String> typeHeader;
        /* access modifiers changed from: private */
        public boolean withoutExpiration;

        private Builder() {
            this.typeHeader = Optional.empty();
            this.withoutExpiration = false;
            this.payload = new JsonObject();
        }

        public Builder setTypeHeader(String str) {
            this.typeHeader = Optional.m201of(str);
            return this;
        }

        public Builder setIssuer(String str) {
            if (JsonUtil.isValidString(str)) {
                this.payload.add("iss", new JsonPrimitive(str));
                return this;
            }
            throw new IllegalArgumentException();
        }

        public Builder setSubject(String str) {
            if (JsonUtil.isValidString(str)) {
                this.payload.add("sub", new JsonPrimitive(str));
                return this;
            }
            throw new IllegalArgumentException();
        }

        public Builder setAudience(String str) {
            if (this.payload.has("aud") && this.payload.get("aud").isJsonArray()) {
                throw new IllegalArgumentException("setAudience can't be used together with setAudiences or addAudience");
            } else if (JsonUtil.isValidString(str)) {
                this.payload.add("aud", new JsonPrimitive(str));
                return this;
            } else {
                throw new IllegalArgumentException("invalid string");
            }
        }

        public Builder setAudiences(List<String> list) {
            if (this.payload.has("aud") && !this.payload.get("aud").isJsonArray()) {
                throw new IllegalArgumentException("setAudiences can't be used together with setAudience");
            } else if (!list.isEmpty()) {
                JsonArray jsonArray = new JsonArray();
                for (String next : list) {
                    if (JsonUtil.isValidString(next)) {
                        jsonArray.add(next);
                    } else {
                        throw new IllegalArgumentException("invalid string");
                    }
                }
                this.payload.add("aud", jsonArray);
                return this;
            } else {
                throw new IllegalArgumentException("audiences must not be empty");
            }
        }

        public Builder addAudience(String str) {
            JsonArray jsonArray;
            if (JsonUtil.isValidString(str)) {
                if (this.payload.has("aud")) {
                    JsonElement jsonElement = this.payload.get("aud");
                    if (jsonElement.isJsonArray()) {
                        jsonArray = jsonElement.getAsJsonArray();
                    } else {
                        throw new IllegalArgumentException("addAudience can't be used together with setAudience");
                    }
                } else {
                    jsonArray = new JsonArray();
                }
                jsonArray.add(str);
                this.payload.add("aud", jsonArray);
                return this;
            }
            throw new IllegalArgumentException("invalid string");
        }

        public Builder setJwtId(String str) {
            if (JsonUtil.isValidString(str)) {
                this.payload.add("jti", new JsonPrimitive(str));
                return this;
            }
            throw new IllegalArgumentException();
        }

        private void setTimestampClaim(String str, Instant instant) {
            long epochSecond = instant.getEpochSecond();
            if (epochSecond > RawJwt.MAX_TIMESTAMP_VALUE || epochSecond < 0) {
                throw new IllegalArgumentException("timestamp of claim " + str + " is out of range");
            }
            this.payload.add(str, new JsonPrimitive((Number) Long.valueOf(epochSecond)));
        }

        public Builder setExpiration(Instant instant) {
            setTimestampClaim("exp", instant);
            return this;
        }

        public Builder withoutExpiration() {
            this.withoutExpiration = true;
            return this;
        }

        public Builder setNotBefore(Instant instant) {
            setTimestampClaim("nbf", instant);
            return this;
        }

        public Builder setIssuedAt(Instant instant) {
            setTimestampClaim("iat", instant);
            return this;
        }

        public Builder addBooleanClaim(String str, boolean z) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(Boolean.valueOf(z)));
            return this;
        }

        public Builder addNumberClaim(String str, double d) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive((Number) Double.valueOf(d)));
            return this;
        }

        public Builder addStringClaim(String str, String str2) {
            if (JsonUtil.isValidString(str2)) {
                JwtNames.validate(str);
                this.payload.add(str, new JsonPrimitive(str2));
                return this;
            }
            throw new IllegalArgumentException();
        }

        public Builder addNullClaim(String str) {
            JwtNames.validate(str);
            this.payload.add(str, JsonNull.INSTANCE);
            return this;
        }

        public Builder addJsonObjectClaim(String str, String str2) throws JwtInvalidException {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJson(str2));
            return this;
        }

        public Builder addJsonArrayClaim(String str, String str2) throws JwtInvalidException {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJsonArray(str2));
            return this;
        }

        public RawJwt build() {
            return new RawJwt(this);
        }
    }

    /* access modifiers changed from: package-private */
    public String getJsonPayload() {
        return this.payload.toString();
    }

    /* access modifiers changed from: package-private */
    public boolean hasBooleanClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isBoolean();
    }

    /* access modifiers changed from: package-private */
    public Boolean getBooleanClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isBoolean()) {
            return Boolean.valueOf(this.payload.get(str).getAsBoolean());
        } else {
            throw new JwtInvalidException("claim " + str + " is not a boolean");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasNumberClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isNumber();
    }

    /* access modifiers changed from: package-private */
    public Double getNumberClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            return Double.valueOf(this.payload.get(str).getAsDouble());
        } else {
            throw new JwtInvalidException("claim " + str + " is not a number");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasStringClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString();
    }

    /* access modifiers changed from: package-private */
    public String getStringClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        return getStringClaimInternal(str);
    }

    private String getStringClaimInternal(String str) throws JwtInvalidException {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString()) {
            return this.payload.get(str).getAsString();
        } else {
            throw new JwtInvalidException("claim " + str + " is not a string");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isNullClaim(String str) {
        JwtNames.validate(str);
        try {
            return JsonNull.INSTANCE.equals(this.payload.get(str));
        } catch (JsonParseException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasJsonObjectClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonObject();
    }

    /* access modifiers changed from: package-private */
    public String getJsonObjectClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonObject()) {
            return this.payload.get(str).getAsJsonObject().toString();
        } else {
            throw new JwtInvalidException("claim " + str + " is not a JSON object");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasJsonArrayClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonArray();
    }

    /* access modifiers changed from: package-private */
    public String getJsonArrayClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (this.payload.get(str).isJsonArray()) {
            return this.payload.get(str).getAsJsonArray().toString();
        } else {
            throw new JwtInvalidException("claim " + str + " is not a JSON array");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasTypeHeader() {
        return this.typeHeader.isPresent();
    }

    /* access modifiers changed from: package-private */
    public String getTypeHeader() throws JwtInvalidException {
        if (this.typeHeader.isPresent()) {
            return this.typeHeader.get();
        }
        throw new JwtInvalidException("type header is not set");
    }

    /* access modifiers changed from: package-private */
    public boolean hasIssuer() {
        return this.payload.has("iss");
    }

    /* access modifiers changed from: package-private */
    public String getIssuer() throws JwtInvalidException {
        return getStringClaimInternal("iss");
    }

    /* access modifiers changed from: package-private */
    public boolean hasSubject() {
        return this.payload.has("sub");
    }

    /* access modifiers changed from: package-private */
    public String getSubject() throws JwtInvalidException {
        return getStringClaimInternal("sub");
    }

    /* access modifiers changed from: package-private */
    public boolean hasJwtId() {
        return this.payload.has("jti");
    }

    /* access modifiers changed from: package-private */
    public String getJwtId() throws JwtInvalidException {
        return getStringClaimInternal("jti");
    }

    /* access modifiers changed from: package-private */
    public boolean hasAudiences() {
        return this.payload.has("aud");
    }

    /* access modifiers changed from: package-private */
    public List<String> getAudiences() throws JwtInvalidException {
        if (hasAudiences()) {
            JsonElement jsonElement = this.payload.get("aud");
            if (jsonElement.isJsonPrimitive()) {
                if (jsonElement.getAsJsonPrimitive().isString()) {
                    return Collections.unmodifiableList(Arrays.asList(new String[]{jsonElement.getAsString()}));
                }
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", new Object[]{jsonElement}));
            } else if (jsonElement.isJsonArray()) {
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                ArrayList arrayList = new ArrayList(asJsonArray.size());
                for (int i = 0; i < asJsonArray.size(); i++) {
                    if (!asJsonArray.get(i).isJsonPrimitive() || !asJsonArray.get(i).getAsJsonPrimitive().isString()) {
                        throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", new Object[]{asJsonArray.get(i)}));
                    }
                    arrayList.add(asJsonArray.get(i).getAsString());
                }
                return Collections.unmodifiableList(arrayList);
            } else {
                throw new JwtInvalidException("claim aud is not a string or a JSON array");
            }
        } else {
            throw new JwtInvalidException("claim aud does not exist");
        }
    }

    private Instant getInstant(String str) throws JwtInvalidException {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        } else if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp");
        } else {
            try {
                return Instant.ofEpochMilli((long) (this.payload.get(str).getAsJsonPrimitive().getAsDouble() * 1000.0d));
            } catch (NumberFormatException e) {
                throw new JwtInvalidException("claim " + str + " is not a timestamp: " + e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasExpiration() {
        return this.payload.has("exp");
    }

    /* access modifiers changed from: package-private */
    public Instant getExpiration() throws JwtInvalidException {
        return getInstant("exp");
    }

    /* access modifiers changed from: package-private */
    public boolean hasNotBefore() {
        return this.payload.has("nbf");
    }

    /* access modifiers changed from: package-private */
    public Instant getNotBefore() throws JwtInvalidException {
        return getInstant("nbf");
    }

    /* access modifiers changed from: package-private */
    public boolean hasIssuedAt() {
        return this.payload.has("iat");
    }

    /* access modifiers changed from: package-private */
    public Instant getIssuedAt() throws JwtInvalidException {
        return getInstant("iat");
    }

    /* access modifiers changed from: package-private */
    public Set<String> customClaimNames() {
        HashSet hashSet = new HashSet();
        for (String next : this.payload.keySet()) {
            if (!JwtNames.isRegisteredName(next)) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public String toString() {
        JsonObject jsonObject = new JsonObject();
        if (this.typeHeader.isPresent()) {
            jsonObject.add("typ", new JsonPrimitive(this.typeHeader.get()));
        }
        return jsonObject + DownloadsManager.EXTENSION_SEPARATOR + this.payload;
    }
}
