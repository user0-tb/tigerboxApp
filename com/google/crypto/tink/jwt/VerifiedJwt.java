package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.util.List;
import java.util.Set;
import p009j$.time.Instant;

@Immutable
public final class VerifiedJwt {
    private final RawJwt rawJwt;

    VerifiedJwt(RawJwt rawJwt2) {
        this.rawJwt = rawJwt2;
    }

    public String getTypeHeader() throws JwtInvalidException {
        return this.rawJwt.getTypeHeader();
    }

    public boolean hasTypeHeader() {
        return this.rawJwt.hasTypeHeader();
    }

    public String getIssuer() throws JwtInvalidException {
        return this.rawJwt.getIssuer();
    }

    public boolean hasIssuer() {
        return this.rawJwt.hasIssuer();
    }

    public String getSubject() throws JwtInvalidException {
        return this.rawJwt.getSubject();
    }

    public boolean hasSubject() {
        return this.rawJwt.hasSubject();
    }

    public List<String> getAudiences() throws JwtInvalidException {
        return this.rawJwt.getAudiences();
    }

    public boolean hasAudiences() {
        return this.rawJwt.hasAudiences();
    }

    public String getJwtId() throws JwtInvalidException {
        return this.rawJwt.getJwtId();
    }

    public boolean hasJwtId() {
        return this.rawJwt.hasJwtId();
    }

    public Instant getExpiration() throws JwtInvalidException {
        return this.rawJwt.getExpiration();
    }

    public boolean hasExpiration() {
        return this.rawJwt.hasExpiration();
    }

    public Instant getNotBefore() throws JwtInvalidException {
        return this.rawJwt.getNotBefore();
    }

    public boolean hasNotBefore() {
        return this.rawJwt.hasNotBefore();
    }

    public Instant getIssuedAt() throws JwtInvalidException {
        return this.rawJwt.getIssuedAt();
    }

    public boolean hasIssuedAt() {
        return this.rawJwt.hasIssuedAt();
    }

    public Boolean getBooleanClaim(String str) throws JwtInvalidException {
        return this.rawJwt.getBooleanClaim(str);
    }

    public Double getNumberClaim(String str) throws JwtInvalidException {
        return this.rawJwt.getNumberClaim(str);
    }

    public String getStringClaim(String str) throws JwtInvalidException {
        return this.rawJwt.getStringClaim(str);
    }

    public boolean isNullClaim(String str) {
        return this.rawJwt.isNullClaim(str);
    }

    public String getJsonObjectClaim(String str) throws JwtInvalidException {
        return this.rawJwt.getJsonObjectClaim(str);
    }

    public String getJsonArrayClaim(String str) throws JwtInvalidException {
        return this.rawJwt.getJsonArrayClaim(str);
    }

    public boolean hasBooleanClaim(String str) {
        return this.rawJwt.hasBooleanClaim(str);
    }

    public boolean hasNumberClaim(String str) {
        return this.rawJwt.hasNumberClaim(str);
    }

    public boolean hasStringClaim(String str) {
        return this.rawJwt.hasStringClaim(str);
    }

    public boolean hasJsonObjectClaim(String str) {
        return this.rawJwt.hasJsonObjectClaim(str);
    }

    public boolean hasJsonArrayClaim(String str) {
        return this.rawJwt.hasJsonArrayClaim(str);
    }

    public Set<String> customClaimNames() {
        return this.rawJwt.customClaimNames();
    }

    public String toString() {
        return "verified{" + this.rawJwt + "}";
    }
}
