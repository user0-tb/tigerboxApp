package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.util.ArrayList;
import java.util.Objects;
import p009j$.time.Clock;
import p009j$.time.Duration;
import p009j$.time.Instant;
import p009j$.util.Optional;

@Immutable
public final class JwtValidator {
    /* access modifiers changed from: private */
    public static final Duration MAX_CLOCK_SKEW = Duration.ofMinutes(10);
    private final boolean allowMissingExpiration;
    private final Clock clock;
    private final Duration clockSkew;
    private final boolean expectIssuedInThePast;
    private final Optional<String> expectedAudience;
    private final Optional<String> expectedIssuer;
    private final Optional<String> expectedTypeHeader;
    private final boolean ignoreAudiences;
    private final boolean ignoreIssuer;
    private final boolean ignoreTypeHeader;

    private JwtValidator(Builder builder) {
        this.expectedTypeHeader = builder.expectedTypeHeader;
        this.ignoreTypeHeader = builder.ignoreTypeHeader;
        this.expectedIssuer = builder.expectedIssuer;
        this.ignoreIssuer = builder.ignoreIssuer;
        this.expectedAudience = builder.expectedAudience;
        this.ignoreAudiences = builder.ignoreAudiences;
        this.allowMissingExpiration = builder.allowMissingExpiration;
        this.expectIssuedInThePast = builder.expectIssuedInThePast;
        this.clock = builder.clock;
        this.clockSkew = builder.clockSkew;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean allowMissingExpiration;
        /* access modifiers changed from: private */
        public Clock clock;
        /* access modifiers changed from: private */
        public Duration clockSkew;
        /* access modifiers changed from: private */
        public boolean expectIssuedInThePast;
        /* access modifiers changed from: private */
        public Optional<String> expectedAudience;
        /* access modifiers changed from: private */
        public Optional<String> expectedIssuer;
        /* access modifiers changed from: private */
        public Optional<String> expectedTypeHeader;
        /* access modifiers changed from: private */
        public boolean ignoreAudiences;
        /* access modifiers changed from: private */
        public boolean ignoreIssuer;
        /* access modifiers changed from: private */
        public boolean ignoreTypeHeader;

        private Builder() {
            this.clock = Clock.systemUTC();
            this.clockSkew = Duration.ZERO;
            this.expectedTypeHeader = Optional.empty();
            this.ignoreTypeHeader = false;
            this.expectedIssuer = Optional.empty();
            this.ignoreIssuer = false;
            this.expectedAudience = Optional.empty();
            this.ignoreAudiences = false;
            this.allowMissingExpiration = false;
            this.expectIssuedInThePast = false;
        }

        public Builder expectTypeHeader(String str) {
            Objects.requireNonNull(str, "typ header cannot be null");
            this.expectedTypeHeader = Optional.m201of(str);
            return this;
        }

        public Builder ignoreTypeHeader() {
            this.ignoreTypeHeader = true;
            return this;
        }

        public Builder expectIssuer(String str) {
            Objects.requireNonNull(str, "issuer cannot be null");
            this.expectedIssuer = Optional.m201of(str);
            return this;
        }

        public Builder ignoreIssuer() {
            this.ignoreIssuer = true;
            return this;
        }

        public Builder expectAudience(String str) {
            Objects.requireNonNull(str, "audience cannot be null");
            this.expectedAudience = Optional.m201of(str);
            return this;
        }

        public Builder ignoreAudiences() {
            this.ignoreAudiences = true;
            return this;
        }

        public Builder expectIssuedInThePast() {
            this.expectIssuedInThePast = true;
            return this;
        }

        public Builder setClock(Clock clock2) {
            Objects.requireNonNull(clock2, "clock cannot be null");
            this.clock = clock2;
            return this;
        }

        public Builder setClockSkew(Duration duration) {
            if (duration.compareTo(JwtValidator.MAX_CLOCK_SKEW) <= 0) {
                this.clockSkew = duration;
                return this;
            }
            throw new IllegalArgumentException("Clock skew too large, max is 10 minutes");
        }

        public Builder allowMissingExpiration() {
            this.allowMissingExpiration = true;
            return this;
        }

        public JwtValidator build() {
            if (this.ignoreTypeHeader && this.expectedTypeHeader.isPresent()) {
                throw new IllegalArgumentException("ignoreTypeHeader() and expectedTypeHeader() cannot be used together.");
            } else if (this.ignoreIssuer && this.expectedIssuer.isPresent()) {
                throw new IllegalArgumentException("ignoreIssuer() and expectedIssuer() cannot be used together.");
            } else if (!this.ignoreAudiences || !this.expectedAudience.isPresent()) {
                return new JwtValidator(this);
            } else {
                throw new IllegalArgumentException("ignoreAudiences() and expectedAudience() cannot be used together.");
            }
        }
    }

    private void validateTypeHeader(RawJwt rawJwt) throws JwtInvalidException {
        if (this.expectedTypeHeader.isPresent()) {
            if (!rawJwt.hasTypeHeader()) {
                throw new JwtInvalidException(String.format("invalid JWT; missing expected type header %s.", new Object[]{this.expectedTypeHeader.get()}));
            } else if (!rawJwt.getTypeHeader().equals(this.expectedTypeHeader.get())) {
                throw new JwtInvalidException(String.format("invalid JWT; expected type header %s, but got %s", new Object[]{this.expectedTypeHeader.get(), rawJwt.getTypeHeader()}));
            }
        } else if (rawJwt.hasTypeHeader() && !this.ignoreTypeHeader) {
            throw new JwtInvalidException("invalid JWT; token has type header set, but validator not.");
        }
    }

    private void validateIssuer(RawJwt rawJwt) throws JwtInvalidException {
        if (this.expectedIssuer.isPresent()) {
            if (!rawJwt.hasIssuer()) {
                throw new JwtInvalidException(String.format("invalid JWT; missing expected issuer %s.", new Object[]{this.expectedIssuer.get()}));
            } else if (!rawJwt.getIssuer().equals(this.expectedIssuer.get())) {
                throw new JwtInvalidException(String.format("invalid JWT; expected issuer %s, but got %s", new Object[]{this.expectedIssuer.get(), rawJwt.getIssuer()}));
            }
        } else if (rawJwt.hasIssuer() && !this.ignoreIssuer) {
            throw new JwtInvalidException("invalid JWT; token has issuer set, but validator not.");
        }
    }

    private void validateAudiences(RawJwt rawJwt) throws JwtInvalidException {
        if (this.expectedAudience.isPresent()) {
            if (!rawJwt.hasAudiences() || !rawJwt.getAudiences().contains(this.expectedAudience.get())) {
                throw new JwtInvalidException(String.format("invalid JWT; missing expected audience %s.", new Object[]{this.expectedAudience.get()}));
            }
        } else if (rawJwt.hasAudiences() && !this.ignoreAudiences) {
            throw new JwtInvalidException("invalid JWT; token has audience set, but validator not.");
        }
    }

    /* access modifiers changed from: package-private */
    public VerifiedJwt validate(RawJwt rawJwt) throws JwtInvalidException {
        validateTimestampClaims(rawJwt);
        validateTypeHeader(rawJwt);
        validateIssuer(rawJwt);
        validateAudiences(rawJwt);
        return new VerifiedJwt(rawJwt);
    }

    private void validateTimestampClaims(RawJwt rawJwt) throws JwtInvalidException {
        Instant instant = this.clock.instant();
        if (!rawJwt.hasExpiration() && !this.allowMissingExpiration) {
            throw new JwtInvalidException("token does not have an expiration set");
        } else if (rawJwt.hasExpiration() && !rawJwt.getExpiration().isAfter(instant.minus(this.clockSkew))) {
            throw new JwtInvalidException("token has expired since " + rawJwt.getExpiration());
        } else if (rawJwt.hasNotBefore() && rawJwt.getNotBefore().isAfter(instant.plus(this.clockSkew))) {
            throw new JwtInvalidException("token cannot be used before " + rawJwt.getNotBefore());
        } else if (!this.expectIssuedInThePast) {
        } else {
            if (!rawJwt.hasIssuedAt()) {
                throw new JwtInvalidException("token does not have an iat claim");
            } else if (rawJwt.getIssuedAt().isAfter(instant.plus(this.clockSkew))) {
                throw new JwtInvalidException("token has a invalid iat claim in the future: " + rawJwt.getIssuedAt());
            }
        }
    }

    public String toString() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.expectedTypeHeader.isPresent()) {
            arrayList.add("expectedTypeHeader=" + this.expectedTypeHeader.get());
        }
        if (this.ignoreTypeHeader) {
            arrayList.add("ignoreTypeHeader");
        }
        if (this.expectedIssuer.isPresent()) {
            arrayList.add("expectedIssuer=" + this.expectedIssuer.get());
        }
        if (this.ignoreIssuer) {
            arrayList.add("ignoreIssuer");
        }
        if (this.expectedAudience.isPresent()) {
            arrayList.add("expectedAudience=" + this.expectedAudience.get());
        }
        if (this.ignoreAudiences) {
            arrayList.add("ignoreAudiences");
        }
        if (this.allowMissingExpiration) {
            arrayList.add("allowMissingExpiration");
        }
        if (this.expectIssuedInThePast) {
            arrayList.add("expectIssuedInThePast");
        }
        if (!this.clockSkew.isZero()) {
            arrayList.add("clockSkew=" + this.clockSkew);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("JwtValidator{");
        String str = "";
        for (String append : arrayList) {
            sb.append(str);
            sb.append(append);
            str = ",";
        }
        sb.append("}");
        return sb.toString();
    }
}
