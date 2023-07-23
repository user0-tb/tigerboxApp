package com.google.android.exoplayer2.util;

import android.net.Uri;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

public final class FileTypes {
    public static final int AC3 = 0;
    public static final int AC4 = 1;
    public static final int ADTS = 2;
    public static final int AMR = 3;
    public static final int AVI = 16;
    private static final String EXTENSION_AAC = ".aac";
    private static final String EXTENSION_AC3 = ".ac3";
    private static final String EXTENSION_AC4 = ".ac4";
    private static final String EXTENSION_ADTS = ".adts";
    private static final String EXTENSION_AMR = ".amr";
    private static final String EXTENSION_AVI = ".avi";
    private static final String EXTENSION_EC3 = ".ec3";
    private static final String EXTENSION_FLAC = ".flac";
    private static final String EXTENSION_FLV = ".flv";
    private static final String EXTENSION_JPEG = ".jpeg";
    private static final String EXTENSION_JPG = ".jpg";
    private static final String EXTENSION_M2P = ".m2p";
    private static final String EXTENSION_MID = ".mid";
    private static final String EXTENSION_MIDI = ".midi";
    private static final String EXTENSION_MP3 = ".mp3";
    private static final String EXTENSION_MP4 = ".mp4";
    private static final String EXTENSION_MPEG = ".mpeg";
    private static final String EXTENSION_MPG = ".mpg";
    private static final String EXTENSION_OPUS = ".opus";
    private static final String EXTENSION_PREFIX_CMF = ".cmf";
    private static final String EXTENSION_PREFIX_M4 = ".m4";
    private static final String EXTENSION_PREFIX_MK = ".mk";
    private static final String EXTENSION_PREFIX_MP4 = ".mp4";
    private static final String EXTENSION_PREFIX_OG = ".og";
    private static final String EXTENSION_PREFIX_TS = ".ts";
    private static final String EXTENSION_PS = ".ps";
    private static final String EXTENSION_SMF = ".smf";
    private static final String EXTENSION_TS = ".ts";
    private static final String EXTENSION_VTT = ".vtt";
    private static final String EXTENSION_WAV = ".wav";
    private static final String EXTENSION_WAVE = ".wave";
    private static final String EXTENSION_WEBM = ".webm";
    private static final String EXTENSION_WEBVTT = ".webvtt";
    public static final int FLAC = 4;
    public static final int FLV = 5;
    static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final int JPEG = 14;
    public static final int MATROSKA = 6;
    public static final int MIDI = 15;
    public static final int MP3 = 7;
    public static final int MP4 = 8;
    public static final int OGG = 9;

    /* renamed from: PS */
    public static final int f186PS = 10;

    /* renamed from: TS */
    public static final int f187TS = 11;
    public static final int UNKNOWN = -1;
    public static final int WAV = 12;
    public static final int WEBVTT = 13;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private FileTypes() {
    }

    public static int inferFileTypeFromResponseHeaders(Map<String, List<String>> map) {
        List list = map.get("Content-Type");
        return inferFileTypeFromMimeType((list == null || list.isEmpty()) ? null : (String) list.get(0));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int inferFileTypeFromMimeType(java.lang.String r19) {
        /*
            r0 = -1
            if (r19 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = com.google.android.exoplayer2.util.MimeTypes.normalizeMimeType(r19)
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = 16
            r4 = 15
            r5 = 14
            r6 = 13
            r7 = 12
            r8 = 11
            r9 = 10
            r10 = 9
            r11 = 8
            r12 = 7
            r13 = 6
            r14 = 5
            r15 = 4
            r16 = 3
            r17 = 1
            r18 = 0
            switch(r2) {
                case -2123537834: goto L_0x0180;
                case -1662384011: goto L_0x0173;
                case -1662384007: goto L_0x0166;
                case -1662095187: goto L_0x0159;
                case -1606874997: goto L_0x014d;
                case -1487394660: goto L_0x0141;
                case -1248337486: goto L_0x0135;
                case -1079884372: goto L_0x0128;
                case -1004728940: goto L_0x0119;
                case -387023398: goto L_0x010b;
                case -43467528: goto L_0x00fd;
                case 13915911: goto L_0x00ee;
                case 187078296: goto L_0x00e0;
                case 187078297: goto L_0x00d2;
                case 187078669: goto L_0x00c4;
                case 187090232: goto L_0x00b6;
                case 187091926: goto L_0x00a8;
                case 187099443: goto L_0x009b;
                case 1331848029: goto L_0x008d;
                case 1503095341: goto L_0x0080;
                case 1504578661: goto L_0x0073;
                case 1504619009: goto L_0x0066;
                case 1504824762: goto L_0x0059;
                case 1504831518: goto L_0x004c;
                case 1505118770: goto L_0x003f;
                case 2039520277: goto L_0x0031;
                default: goto L_0x002e;
            }
        L_0x002e:
            r1 = -1
            goto L_0x018b
        L_0x0031:
            java.lang.String r2 = "video/x-matroska"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x003b
            goto L_0x002e
        L_0x003b:
            r1 = 25
            goto L_0x018b
        L_0x003f:
            java.lang.String r2 = "audio/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0048
            goto L_0x002e
        L_0x0048:
            r1 = 24
            goto L_0x018b
        L_0x004c:
            java.lang.String r2 = "audio/mpeg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0055
            goto L_0x002e
        L_0x0055:
            r1 = 23
            goto L_0x018b
        L_0x0059:
            java.lang.String r2 = "audio/midi"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0062
            goto L_0x002e
        L_0x0062:
            r1 = 22
            goto L_0x018b
        L_0x0066:
            java.lang.String r2 = "audio/flac"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x006f
            goto L_0x002e
        L_0x006f:
            r1 = 21
            goto L_0x018b
        L_0x0073:
            java.lang.String r2 = "audio/eac3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x007c
            goto L_0x002e
        L_0x007c:
            r1 = 20
            goto L_0x018b
        L_0x0080:
            java.lang.String r2 = "audio/3gpp"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0089
            goto L_0x002e
        L_0x0089:
            r1 = 19
            goto L_0x018b
        L_0x008d:
            java.lang.String r2 = "video/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0097
            goto L_0x002e
        L_0x0097:
            r1 = 18
            goto L_0x018b
        L_0x009b:
            java.lang.String r2 = "audio/wav"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00a4
            goto L_0x002e
        L_0x00a4:
            r1 = 17
            goto L_0x018b
        L_0x00a8:
            java.lang.String r2 = "audio/ogg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00b2
            goto L_0x002e
        L_0x00b2:
            r1 = 16
            goto L_0x018b
        L_0x00b6:
            java.lang.String r2 = "audio/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00c0
            goto L_0x002e
        L_0x00c0:
            r1 = 15
            goto L_0x018b
        L_0x00c4:
            java.lang.String r2 = "audio/amr"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00ce
            goto L_0x002e
        L_0x00ce:
            r1 = 14
            goto L_0x018b
        L_0x00d2:
            java.lang.String r2 = "audio/ac4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00dc
            goto L_0x002e
        L_0x00dc:
            r1 = 13
            goto L_0x018b
        L_0x00e0:
            java.lang.String r2 = "audio/ac3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00ea
            goto L_0x002e
        L_0x00ea:
            r1 = 12
            goto L_0x018b
        L_0x00ee:
            java.lang.String r2 = "video/x-flv"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00f9
            goto L_0x002e
        L_0x00f9:
            r1 = 11
            goto L_0x018b
        L_0x00fd:
            java.lang.String r2 = "application/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0107
            goto L_0x002e
        L_0x0107:
            r1 = 10
            goto L_0x018b
        L_0x010b:
            java.lang.String r2 = "audio/x-matroska"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0115
            goto L_0x002e
        L_0x0115:
            r1 = 9
            goto L_0x018b
        L_0x0119:
            java.lang.String r2 = "text/vtt"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0124
            goto L_0x002e
        L_0x0124:
            r1 = 8
            goto L_0x018b
        L_0x0128:
            java.lang.String r2 = "video/x-msvideo"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0133
            goto L_0x002e
        L_0x0133:
            r1 = 7
            goto L_0x018b
        L_0x0135:
            java.lang.String r2 = "application/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x013f
            goto L_0x002e
        L_0x013f:
            r1 = 6
            goto L_0x018b
        L_0x0141:
            java.lang.String r2 = "image/jpeg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x014b
            goto L_0x002e
        L_0x014b:
            r1 = 5
            goto L_0x018b
        L_0x014d:
            java.lang.String r2 = "audio/amr-wb"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0157
            goto L_0x002e
        L_0x0157:
            r1 = 4
            goto L_0x018b
        L_0x0159:
            java.lang.String r2 = "video/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0164
            goto L_0x002e
        L_0x0164:
            r1 = 3
            goto L_0x018b
        L_0x0166:
            java.lang.String r2 = "video/mp2t"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0171
            goto L_0x002e
        L_0x0171:
            r1 = 2
            goto L_0x018b
        L_0x0173:
            java.lang.String r2 = "video/mp2p"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x017e
            goto L_0x002e
        L_0x017e:
            r1 = 1
            goto L_0x018b
        L_0x0180:
            java.lang.String r2 = "audio/eac3-joc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x018a
            goto L_0x002e
        L_0x018a:
            r1 = 0
        L_0x018b:
            switch(r1) {
                case 0: goto L_0x019e;
                case 1: goto L_0x019d;
                case 2: goto L_0x019c;
                case 3: goto L_0x019b;
                case 4: goto L_0x019a;
                case 5: goto L_0x0199;
                case 6: goto L_0x0198;
                case 7: goto L_0x0197;
                case 8: goto L_0x0196;
                case 9: goto L_0x019b;
                case 10: goto L_0x019b;
                case 11: goto L_0x0195;
                case 12: goto L_0x019e;
                case 13: goto L_0x0194;
                case 14: goto L_0x019a;
                case 15: goto L_0x0198;
                case 16: goto L_0x0193;
                case 17: goto L_0x0192;
                case 18: goto L_0x0198;
                case 19: goto L_0x019a;
                case 20: goto L_0x019e;
                case 21: goto L_0x0191;
                case 22: goto L_0x0190;
                case 23: goto L_0x018f;
                case 24: goto L_0x019b;
                case 25: goto L_0x019b;
                default: goto L_0x018e;
            }
        L_0x018e:
            return r0
        L_0x018f:
            return r12
        L_0x0190:
            return r4
        L_0x0191:
            return r15
        L_0x0192:
            return r7
        L_0x0193:
            return r10
        L_0x0194:
            return r17
        L_0x0195:
            return r14
        L_0x0196:
            return r6
        L_0x0197:
            return r3
        L_0x0198:
            return r11
        L_0x0199:
            return r5
        L_0x019a:
            return r16
        L_0x019b:
            return r13
        L_0x019c:
            return r8
        L_0x019d:
            return r9
        L_0x019e:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.FileTypes.inferFileTypeFromMimeType(java.lang.String):int");
    }

    public static int inferFileTypeFromUri(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC3) || lastPathSegment.endsWith(EXTENSION_EC3)) {
            return 0;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC4)) {
            return 1;
        }
        if (lastPathSegment.endsWith(EXTENSION_ADTS) || lastPathSegment.endsWith(EXTENSION_AAC)) {
            return 2;
        }
        if (lastPathSegment.endsWith(EXTENSION_AMR)) {
            return 3;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLAC)) {
            return 4;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLV)) {
            return 5;
        }
        if (lastPathSegment.endsWith(EXTENSION_MID) || lastPathSegment.endsWith(EXTENSION_MIDI) || lastPathSegment.endsWith(EXTENSION_SMF)) {
            return 15;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_MK, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_WEBM)) {
            return 6;
        }
        if (lastPathSegment.endsWith(EXTENSION_MP3)) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(EXTENSION_PREFIX_M4, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(EXTENSION_PREFIX_CMF, lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_OG, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_OPUS)) {
            return 9;
        }
        if (lastPathSegment.endsWith(EXTENSION_PS) || lastPathSegment.endsWith(EXTENSION_MPEG) || lastPathSegment.endsWith(EXTENSION_MPG) || lastPathSegment.endsWith(EXTENSION_M2P)) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(EXTENSION_WAV) || lastPathSegment.endsWith(EXTENSION_WAVE)) {
            return 12;
        }
        if (lastPathSegment.endsWith(EXTENSION_VTT) || lastPathSegment.endsWith(EXTENSION_WEBVTT)) {
            return 13;
        }
        if (lastPathSegment.endsWith(EXTENSION_JPG) || lastPathSegment.endsWith(EXTENSION_JPEG)) {
            return 14;
        }
        if (lastPathSegment.endsWith(EXTENSION_AVI)) {
            return 16;
        }
        return -1;
    }
}
