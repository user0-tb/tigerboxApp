package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.MediaDescription;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.exoplayer2.util.Assertions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SessionDescriptionParser {
    private static final Pattern ATTRIBUTE_PATTERN = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");
    private static final String ATTRIBUTE_TYPE = "a";
    private static final String BANDWIDTH_TYPE = "b";
    private static final String CONNECTION_TYPE = "c";
    private static final String EMAIL_TYPE = "e";
    private static final String INFORMATION_TYPE = "i";
    private static final String KEY_TYPE = "k";
    private static final Pattern MEDIA_DESCRIPTION_PATTERN = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");
    private static final String MEDIA_TYPE = "m";
    private static final String ORIGIN_TYPE = "o";
    private static final String PHONE_NUMBER_TYPE = "p";
    private static final String REPEAT_TYPE = "r";
    private static final Pattern SDP_LINE_PATTERN = Pattern.compile("([a-z])=\\s?(.+)");
    private static final String SESSION_TYPE = "s";
    private static final String TIMING_TYPE = "t";
    private static final String URI_TYPE = "u";
    private static final String VERSION_TYPE = "v";
    private static final String ZONE_TYPE = "z";

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01b5, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.source.rtsp.SessionDescription parse(java.lang.String r13) throws com.google.android.exoplayer2.ParserException {
        /*
            com.google.android.exoplayer2.source.rtsp.SessionDescription$Builder r0 = new com.google.android.exoplayer2.source.rtsp.SessionDescription$Builder
            r0.<init>()
            java.lang.String[] r13 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.splitRtspMessageBody(r13)
            int r1 = r13.length
            r2 = 0
            r3 = 0
            r5 = r3
            r4 = 0
        L_0x000e:
            if (r4 >= r1) goto L_0x01cf
            r6 = r13[r4]
            java.lang.String r7 = ""
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x001c
            goto L_0x01b5
        L_0x001c:
            java.util.regex.Pattern r7 = SDP_LINE_PATTERN
            java.util.regex.Matcher r7 = r7.matcher(r6)
            boolean r8 = r7.matches()
            if (r8 == 0) goto L_0x01b9
            r8 = 1
            java.lang.String r9 = r7.group(r8)
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)
            java.lang.String r9 = (java.lang.String) r9
            r10 = 2
            java.lang.String r7 = r7.group(r10)
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)
            java.lang.String r7 = (java.lang.String) r7
            r11 = -1
            int r12 = r9.hashCode()
            switch(r12) {
                case 97: goto L_0x00e3;
                case 98: goto L_0x00d8;
                case 99: goto L_0x00ce;
                case 100: goto L_0x0046;
                case 101: goto L_0x00c4;
                case 102: goto L_0x0046;
                case 103: goto L_0x0046;
                case 104: goto L_0x0046;
                case 105: goto L_0x00ba;
                case 106: goto L_0x0046;
                case 107: goto L_0x00af;
                case 108: goto L_0x0046;
                case 109: goto L_0x00a4;
                case 110: goto L_0x0046;
                case 111: goto L_0x009a;
                case 112: goto L_0x0090;
                case 113: goto L_0x0046;
                case 114: goto L_0x0085;
                case 115: goto L_0x007a;
                case 116: goto L_0x006d;
                case 117: goto L_0x0061;
                case 118: goto L_0x0055;
                case 119: goto L_0x0046;
                case 120: goto L_0x0046;
                case 121: goto L_0x0046;
                case 122: goto L_0x0048;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x00ed
        L_0x0048:
            java.lang.String r12 = "z"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 14
            goto L_0x00ed
        L_0x0055:
            java.lang.String r12 = "v"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 0
            goto L_0x00ed
        L_0x0061:
            java.lang.String r12 = "u"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 4
            goto L_0x00ed
        L_0x006d:
            java.lang.String r12 = "t"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 9
            goto L_0x00ed
        L_0x007a:
            java.lang.String r12 = "s"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 2
            goto L_0x00ed
        L_0x0085:
            java.lang.String r12 = "r"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 13
            goto L_0x00ed
        L_0x0090:
            java.lang.String r12 = "p"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 6
            goto L_0x00ed
        L_0x009a:
            java.lang.String r12 = "o"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 1
            goto L_0x00ed
        L_0x00a4:
            java.lang.String r12 = "m"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 12
            goto L_0x00ed
        L_0x00af:
            java.lang.String r12 = "k"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 10
            goto L_0x00ed
        L_0x00ba:
            java.lang.String r12 = "i"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 3
            goto L_0x00ed
        L_0x00c4:
            java.lang.String r12 = "e"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 5
            goto L_0x00ed
        L_0x00ce:
            java.lang.String r12 = "c"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 7
            goto L_0x00ed
        L_0x00d8:
            java.lang.String r12 = "b"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 8
            goto L_0x00ed
        L_0x00e3:
            java.lang.String r12 = "a"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x00ed
            r11 = 11
        L_0x00ed:
            switch(r11) {
                case 0: goto L_0x019d;
                case 1: goto L_0x0199;
                case 2: goto L_0x0195;
                case 3: goto L_0x018b;
                case 4: goto L_0x0183;
                case 5: goto L_0x017f;
                case 6: goto L_0x017b;
                case 7: goto L_0x0171;
                case 8: goto L_0x014e;
                case 9: goto L_0x0149;
                case 10: goto L_0x013d;
                case 11: goto L_0x00fd;
                case 12: goto L_0x00f2;
                default: goto L_0x00f0;
            }
        L_0x00f0:
            goto L_0x01b5
        L_0x00f2:
            if (r5 == 0) goto L_0x00f7
            addMediaDescriptionToSession(r0, r5)
        L_0x00f7:
            com.google.android.exoplayer2.source.rtsp.MediaDescription$Builder r5 = parseMediaDescriptionLine(r7)
            goto L_0x01b5
        L_0x00fd:
            java.util.regex.Pattern r9 = ATTRIBUTE_PATTERN
            java.util.regex.Matcher r7 = r9.matcher(r7)
            boolean r9 = r7.matches()
            if (r9 == 0) goto L_0x0127
            java.lang.String r6 = r7.group(r8)
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = r7.group(r10)
            java.lang.String r7 = com.google.common.base.Strings.nullToEmpty(r7)
            if (r5 != 0) goto L_0x0122
            r0.addAttribute(r6, r7)
            goto L_0x01b5
        L_0x0122:
            r5.addAttribute(r6, r7)
            goto L_0x01b5
        L_0x0127:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Malformed Attribute line: "
            r13.append(r0)
            r13.append(r6)
            java.lang.String r13 = r13.toString()
            com.google.android.exoplayer2.ParserException r13 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r13, r3)
            throw r13
        L_0x013d:
            if (r5 != 0) goto L_0x0144
            r0.setKey(r7)
            goto L_0x01b5
        L_0x0144:
            r5.setKey(r7)
            goto L_0x01b5
        L_0x0149:
            r0.setTiming(r7)
            goto L_0x01b5
        L_0x014e:
            java.lang.String r6 = ":\\s?"
            java.lang.String[] r6 = com.google.android.exoplayer2.util.C1229Util.split(r7, r6)
            int r7 = r6.length
            if (r7 != r10) goto L_0x0159
            r7 = 1
            goto L_0x015a
        L_0x0159:
            r7 = 0
        L_0x015a:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r7)
            r6 = r6[r8]
            int r6 = java.lang.Integer.parseInt(r6)
            if (r5 != 0) goto L_0x016b
            int r6 = r6 * 1000
            r0.setBitrate(r6)
            goto L_0x01b5
        L_0x016b:
            int r6 = r6 * 1000
            r5.setBitrate(r6)
            goto L_0x01b5
        L_0x0171:
            if (r5 != 0) goto L_0x0177
            r0.setConnection(r7)
            goto L_0x01b5
        L_0x0177:
            r5.setConnection(r7)
            goto L_0x01b5
        L_0x017b:
            r0.setPhoneNumber(r7)
            goto L_0x01b5
        L_0x017f:
            r0.setEmailAddress(r7)
            goto L_0x01b5
        L_0x0183:
            android.net.Uri r6 = android.net.Uri.parse(r7)
            r0.setUri(r6)
            goto L_0x01b5
        L_0x018b:
            if (r5 != 0) goto L_0x0191
            r0.setSessionInfo(r7)
            goto L_0x01b5
        L_0x0191:
            r5.setMediaTitle(r7)
            goto L_0x01b5
        L_0x0195:
            r0.setSessionName(r7)
            goto L_0x01b5
        L_0x0199:
            r0.setOrigin(r7)
            goto L_0x01b5
        L_0x019d:
            java.lang.String r6 = "0"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x01a6
            goto L_0x01b5
        L_0x01a6:
            java.lang.Object[] r13 = new java.lang.Object[r8]
            r13[r2] = r7
            java.lang.String r0 = "SDP version %s is not supported."
            java.lang.String r13 = java.lang.String.format(r0, r13)
            com.google.android.exoplayer2.ParserException r13 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r13, r3)
            throw r13
        L_0x01b5:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x01b9:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Malformed SDP line: "
            r13.append(r0)
            r13.append(r6)
            java.lang.String r13 = r13.toString()
            com.google.android.exoplayer2.ParserException r13 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r13, r3)
            throw r13
        L_0x01cf:
            if (r5 == 0) goto L_0x01d4
            addMediaDescriptionToSession(r0, r5)
        L_0x01d4:
            com.google.android.exoplayer2.source.rtsp.SessionDescription r13 = r0.build()     // Catch:{ IllegalArgumentException -> 0x01db, IllegalStateException -> 0x01d9 }
            return r13
        L_0x01d9:
            r13 = move-exception
            goto L_0x01dc
        L_0x01db:
            r13 = move-exception
        L_0x01dc:
            com.google.android.exoplayer2.ParserException r13 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r3, r13)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.SessionDescriptionParser.parse(java.lang.String):com.google.android.exoplayer2.source.rtsp.SessionDescription");
    }

    private static void addMediaDescriptionToSession(SessionDescription.Builder builder, MediaDescription.Builder builder2) throws ParserException {
        try {
            builder.addMediaDescription(builder2.build());
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw ParserException.createForMalformedManifest((String) null, e);
        }
    }

    private static MediaDescription.Builder parseMediaDescriptionLine(String str) throws ParserException {
        Matcher matcher = MEDIA_DESCRIPTION_PATTERN.matcher(str);
        if (matcher.matches()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(1));
            String str3 = (String) Assertions.checkNotNull(matcher.group(2));
            try {
                return new MediaDescription.Builder(str2, Integer.parseInt(str3), (String) Assertions.checkNotNull(matcher.group(3)), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(4))));
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, e);
            }
        } else {
            throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, (Throwable) null);
        }
    }

    private SessionDescriptionParser() {
    }
}
