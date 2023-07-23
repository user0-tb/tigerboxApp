package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;

final class RtspTrackTiming {
    public final long rtpTimestamp;
    public final int sequenceNumber;
    public final Uri uri;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d A[Catch:{ Exception -> 0x0092 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084 A[Catch:{ Exception -> 0x0092 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.collect.ImmutableList<com.google.android.exoplayer2.source.rtsp.RtspTrackTiming> parseTrackTiming(java.lang.String r18, android.net.Uri r19) throws com.google.android.exoplayer2.ParserException {
        /*
            com.google.common.collect.ImmutableList$Builder r0 = new com.google.common.collect.ImmutableList$Builder
            r0.<init>()
            java.lang.String r1 = ","
            r2 = r18
            java.lang.String[] r1 = com.google.android.exoplayer2.util.C1229Util.split(r2, r1)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0010:
            if (r4 >= r2) goto L_0x00c9
            r5 = r1[r4]
            java.lang.String r6 = ";"
            java.lang.String[] r6 = com.google.android.exoplayer2.util.C1229Util.split(r5, r6)
            int r7 = r6.length
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r12 = 0
            r13 = 0
            r14 = -1
        L_0x0023:
            if (r12 >= r7) goto L_0x0098
            r15 = r6[r12]
            java.lang.String r11 = "="
            java.lang.String[] r11 = com.google.android.exoplayer2.util.C1229Util.splitAtFirst(r15, r11)     // Catch:{ Exception -> 0x0092 }
            r10 = r11[r3]     // Catch:{ Exception -> 0x0092 }
            r3 = 1
            r11 = r11[r3]     // Catch:{ Exception -> 0x0092 }
            int r3 = r10.hashCode()     // Catch:{ Exception -> 0x0092 }
            r16 = r1
            r1 = 113759(0x1bc5f, float:1.5941E-40)
            r17 = r2
            r2 = 2
            if (r3 == r1) goto L_0x0060
            r1 = 116079(0x1c56f, float:1.62661E-40)
            if (r3 == r1) goto L_0x0055
            r1 = 1524180539(0x5ad9263b, float:3.05610524E16)
            if (r3 == r1) goto L_0x004b
            goto L_0x006a
        L_0x004b:
            java.lang.String r1 = "rtptime"
            boolean r1 = r10.equals(r1)     // Catch:{ Exception -> 0x0092 }
            if (r1 == 0) goto L_0x006a
            r1 = 2
            goto L_0x006b
        L_0x0055:
            java.lang.String r1 = "url"
            boolean r1 = r10.equals(r1)     // Catch:{ Exception -> 0x0092 }
            if (r1 == 0) goto L_0x006a
            r1 = 0
            goto L_0x006b
        L_0x0060:
            java.lang.String r1 = "seq"
            boolean r1 = r10.equals(r1)     // Catch:{ Exception -> 0x0092 }
            if (r1 == 0) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x006a:
            r1 = -1
        L_0x006b:
            if (r1 == 0) goto L_0x0084
            r3 = 1
            if (r1 == r3) goto L_0x007d
            if (r1 != r2) goto L_0x0077
            long r8 = java.lang.Long.parseLong(r11)     // Catch:{ Exception -> 0x0092 }
            goto L_0x0081
        L_0x0077:
            r0 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r10, r0)     // Catch:{ Exception -> 0x0092 }
            throw r0     // Catch:{ Exception -> 0x0092 }
        L_0x007d:
            int r14 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x0092 }
        L_0x0081:
            r1 = r19
            goto L_0x008a
        L_0x0084:
            r1 = r19
            android.net.Uri r13 = resolveUri(r11, r1)     // Catch:{ Exception -> 0x0092 }
        L_0x008a:
            int r12 = r12 + 1
            r1 = r16
            r2 = r17
            r3 = 0
            goto L_0x0023
        L_0x0092:
            r0 = move-exception
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r15, r0)
            throw r0
        L_0x0098:
            r16 = r1
            r17 = r2
            r1 = r19
            if (r13 == 0) goto L_0x00c3
            java.lang.String r2 = r13.getScheme()
            if (r2 == 0) goto L_0x00c3
            r2 = -1
            if (r14 != r2) goto L_0x00b2
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x00c3
        L_0x00b2:
            com.google.android.exoplayer2.source.rtsp.RtspTrackTiming r2 = new com.google.android.exoplayer2.source.rtsp.RtspTrackTiming
            r2.<init>(r8, r14, r13)
            r0.add((java.lang.Object) r2)
            int r4 = r4 + 1
            r1 = r16
            r2 = r17
            r3 = 0
            goto L_0x0010
        L_0x00c3:
            r0 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r5, r0)
            throw r0
        L_0x00c9:
            com.google.common.collect.ImmutableList r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspTrackTiming.parseTrackTiming(java.lang.String, android.net.Uri):com.google.common.collect.ImmutableList");
    }

    static Uri resolveUri(String str, Uri uri2) {
        Assertions.checkArgument(((String) Assertions.checkNotNull(uri2.getScheme())).equals("rtsp"));
        Uri parse = Uri.parse(str);
        if (parse.isAbsolute()) {
            return parse;
        }
        Uri parse2 = Uri.parse("rtsp://" + str);
        String uri3 = uri2.toString();
        if (((String) Assertions.checkNotNull(parse2.getHost())).equals(uri2.getHost())) {
            return parse2;
        }
        if (uri3.endsWith(DownloadsManager.FOLDERS_SEPARATOR)) {
            return UriUtil.resolveToUri(uri3, str);
        }
        return UriUtil.resolveToUri(uri3 + DownloadsManager.FOLDERS_SEPARATOR, str);
    }

    private RtspTrackTiming(long j, int i, Uri uri2) {
        this.rtpTimestamp = j;
        this.sequenceNumber = i;
        this.uri = uri2;
    }
}
