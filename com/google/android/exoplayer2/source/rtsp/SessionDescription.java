package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.util.C1229Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;

final class SessionDescription {
    public static final String ATTR_CONTROL = "control";
    public static final String ATTR_FMTP = "fmtp";
    public static final String ATTR_LENGTH = "length";
    public static final String ATTR_RANGE = "range";
    public static final String ATTR_RTPMAP = "rtpmap";
    public static final String ATTR_TOOL = "tool";
    public static final String ATTR_TYPE = "type";
    public static final String SUPPORTED_SDP_VERSION = "0";
    public final ImmutableMap<String, String> attributes;
    public final int bitrate;
    public final String connection;
    public final String emailAddress;
    public final String key;
    public final ImmutableList<MediaDescription> mediaDescriptionList;
    public final String origin;
    public final String phoneNumber;
    public final String sessionInfo;
    public final String sessionName;
    public final String timing;
    public final Uri uri;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final HashMap<String, String> attributes = new HashMap<>();
        /* access modifiers changed from: private */
        public int bitrate = -1;
        /* access modifiers changed from: private */
        public String connection;
        /* access modifiers changed from: private */
        public String emailAddress;
        /* access modifiers changed from: private */
        public String key;
        /* access modifiers changed from: private */
        public final ImmutableList.Builder<MediaDescription> mediaDescriptionListBuilder = new ImmutableList.Builder<>();
        /* access modifiers changed from: private */
        public String origin;
        /* access modifiers changed from: private */
        public String phoneNumber;
        /* access modifiers changed from: private */
        public String sessionInfo;
        /* access modifiers changed from: private */
        public String sessionName;
        /* access modifiers changed from: private */
        public String timing;
        /* access modifiers changed from: private */
        public Uri uri;

        public Builder setSessionName(String str) {
            this.sessionName = str;
            return this;
        }

        public Builder setSessionInfo(String str) {
            this.sessionInfo = str;
            return this;
        }

        public Builder setUri(Uri uri2) {
            this.uri = uri2;
            return this;
        }

        public Builder setOrigin(String str) {
            this.origin = str;
            return this;
        }

        public Builder setConnection(String str) {
            this.connection = str;
            return this;
        }

        public Builder setBitrate(int i) {
            this.bitrate = i;
            return this;
        }

        public Builder setTiming(String str) {
            this.timing = str;
            return this;
        }

        public Builder setKey(String str) {
            this.key = str;
            return this;
        }

        public Builder setEmailAddress(String str) {
            this.emailAddress = str;
            return this;
        }

        public Builder setPhoneNumber(String str) {
            this.phoneNumber = str;
            return this;
        }

        public Builder addAttribute(String str, String str2) {
            this.attributes.put(str, str2);
            return this;
        }

        public Builder addMediaDescription(MediaDescription mediaDescription) {
            this.mediaDescriptionListBuilder.add((Object) mediaDescription);
            return this;
        }

        public SessionDescription build() {
            return new SessionDescription(this);
        }
    }

    private SessionDescription(Builder builder) {
        this.attributes = ImmutableMap.copyOf(builder.attributes);
        this.mediaDescriptionList = builder.mediaDescriptionListBuilder.build();
        this.sessionName = (String) C1229Util.castNonNull(builder.sessionName);
        this.origin = (String) C1229Util.castNonNull(builder.origin);
        this.timing = (String) C1229Util.castNonNull(builder.timing);
        this.uri = builder.uri;
        this.connection = builder.connection;
        this.bitrate = builder.bitrate;
        this.key = builder.key;
        this.emailAddress = builder.emailAddress;
        this.phoneNumber = builder.phoneNumber;
        this.sessionInfo = builder.sessionInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SessionDescription sessionDescription = (SessionDescription) obj;
        if (this.bitrate != sessionDescription.bitrate || !this.attributes.equals(sessionDescription.attributes) || !this.mediaDescriptionList.equals(sessionDescription.mediaDescriptionList) || !C1229Util.areEqual(this.origin, sessionDescription.origin) || !C1229Util.areEqual(this.sessionName, sessionDescription.sessionName) || !C1229Util.areEqual(this.timing, sessionDescription.timing) || !C1229Util.areEqual(this.sessionInfo, sessionDescription.sessionInfo) || !C1229Util.areEqual(this.uri, sessionDescription.uri) || !C1229Util.areEqual(this.emailAddress, sessionDescription.emailAddress) || !C1229Util.areEqual(this.phoneNumber, sessionDescription.phoneNumber) || !C1229Util.areEqual(this.connection, sessionDescription.connection) || !C1229Util.areEqual(this.key, sessionDescription.key)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((217 + this.attributes.hashCode()) * 31) + this.mediaDescriptionList.hashCode()) * 31;
        String str = this.origin;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sessionName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.timing;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.bitrate) * 31;
        String str4 = this.sessionInfo;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Uri uri2 = this.uri;
        int hashCode6 = (hashCode5 + (uri2 == null ? 0 : uri2.hashCode())) * 31;
        String str5 = this.emailAddress;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.phoneNumber;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.connection;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.key;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode9 + i;
    }
}
