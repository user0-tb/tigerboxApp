package com.google.android.exoplayer2.extractor.p007ts;

import com.google.android.exoplayer2.C0963C;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p007ts.TsPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.extractor.ts.H262Reader */
public final class H262Reader implements ElementaryStreamReader {
    private static final double[] FRAME_RATE_VALUES = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private static final int START_EXTENSION = 181;
    private static final int START_GROUP = 184;
    private static final int START_PICTURE = 0;
    private static final int START_SEQUENCE_HEADER = 179;
    private static final int START_USER_DATA = 178;
    private final CsdBuffer csdBuffer;
    private String formatId;
    private long frameDurationUs;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final boolean[] prefixFlags;
    private boolean sampleHasPicture;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private boolean startedFirstSample;
    private long totalBytesWritten;
    private final NalUnitTargetBuffer userData;
    private final ParsableByteArray userDataParsable;
    private final UserDataReader userDataReader;

    public void packetFinished() {
    }

    public H262Reader() {
        this((UserDataReader) null);
    }

    H262Reader(UserDataReader userDataReader2) {
        this.userDataReader = userDataReader2;
        this.prefixFlags = new boolean[4];
        this.csdBuffer = new CsdBuffer(128);
        if (userDataReader2 != null) {
            this.userData = new NalUnitTargetBuffer(178, 128);
            this.userDataParsable = new ParsableByteArray();
        } else {
            this.userData = null;
            this.userDataParsable = null;
        }
        this.pesTimeUs = C0963C.TIME_UNSET;
        this.sampleTimeUs = C0963C.TIME_UNSET;
    }

    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        NalUnitTargetBuffer nalUnitTargetBuffer = this.userData;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.reset();
        }
        this.totalBytesWritten = 0;
        this.startedFirstSample = false;
        this.pesTimeUs = C0963C.TIME_UNSET;
        this.sampleTimeUs = C0963C.TIME_UNSET;
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        UserDataReader userDataReader2 = this.userDataReader;
        if (userDataReader2 != null) {
            userDataReader2.createTracks(extractorOutput, trackIdGenerator);
        }
    }

    public void packetStarted(long j, int i) {
        this.pesTimeUs = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0144  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray r21) {
        /*
            r20 = this;
            r0 = r20
            com.google.android.exoplayer2.extractor.TrackOutput r1 = r0.output
            com.google.android.exoplayer2.util.Assertions.checkStateNotNull(r1)
            int r1 = r21.getPosition()
            int r2 = r21.limit()
            byte[] r3 = r21.getData()
            long r4 = r0.totalBytesWritten
            int r6 = r21.bytesLeft()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.totalBytesWritten = r4
            com.google.android.exoplayer2.extractor.TrackOutput r4 = r0.output
            int r5 = r21.bytesLeft()
            r6 = r21
            r4.sampleData(r6, r5)
        L_0x0028:
            boolean[] r4 = r0.prefixFlags
            int r4 = com.google.android.exoplayer2.util.NalUnitUtil.findNalUnit(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0041
            boolean r4 = r0.hasOutputFormat
            if (r4 != 0) goto L_0x0039
            com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer r4 = r0.csdBuffer
            r4.onData(r3, r1, r2)
        L_0x0039:
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r4 = r0.userData
            if (r4 == 0) goto L_0x0040
            r4.appendToNalUnit(r3, r1, r2)
        L_0x0040:
            return
        L_0x0041:
            byte[] r5 = r21.getData()
            int r7 = r4 + 3
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.hasOutputFormat
            r10 = 0
            r11 = 1
            if (r9 != 0) goto L_0x008a
            if (r8 <= 0) goto L_0x005a
            com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer r9 = r0.csdBuffer
            r9.onData(r3, r1, r4)
        L_0x005a:
            if (r8 >= 0) goto L_0x005e
            int r9 = -r8
            goto L_0x005f
        L_0x005e:
            r9 = 0
        L_0x005f:
            com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer r12 = r0.csdBuffer
            boolean r9 = r12.onStartCode(r5, r9)
            if (r9 == 0) goto L_0x008a
            com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer r9 = r0.csdBuffer
            java.lang.String r12 = r0.formatId
            java.lang.Object r12 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r12)
            java.lang.String r12 = (java.lang.String) r12
            android.util.Pair r9 = parseCsdBuffer(r9, r12)
            com.google.android.exoplayer2.extractor.TrackOutput r12 = r0.output
            java.lang.Object r13 = r9.first
            com.google.android.exoplayer2.Format r13 = (com.google.android.exoplayer2.Format) r13
            r12.format(r13)
            java.lang.Object r9 = r9.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            r0.frameDurationUs = r12
            r0.hasOutputFormat = r11
        L_0x008a:
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r9 = r0.userData
            if (r9 == 0) goto L_0x00db
            if (r8 <= 0) goto L_0x0095
            r9.appendToNalUnit(r3, r1, r4)
            r1 = 0
            goto L_0x0096
        L_0x0095:
            int r1 = -r8
        L_0x0096:
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r8 = r0.userData
            boolean r1 = r8.endNalUnit(r1)
            if (r1 == 0) goto L_0x00c8
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r1 = r0.userData
            byte[] r1 = r1.nalData
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r8 = r0.userData
            int r8 = r8.nalLength
            int r1 = com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(r1, r8)
            com.google.android.exoplayer2.util.ParsableByteArray r8 = r0.userDataParsable
            java.lang.Object r8 = com.google.android.exoplayer2.util.C1229Util.castNonNull(r8)
            com.google.android.exoplayer2.util.ParsableByteArray r8 = (com.google.android.exoplayer2.util.ParsableByteArray) r8
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r9 = r0.userData
            byte[] r9 = r9.nalData
            r8.reset(r9, r1)
            com.google.android.exoplayer2.extractor.ts.UserDataReader r1 = r0.userDataReader
            java.lang.Object r1 = com.google.android.exoplayer2.util.C1229Util.castNonNull(r1)
            com.google.android.exoplayer2.extractor.ts.UserDataReader r1 = (com.google.android.exoplayer2.extractor.p007ts.UserDataReader) r1
            long r8 = r0.sampleTimeUs
            com.google.android.exoplayer2.util.ParsableByteArray r12 = r0.userDataParsable
            r1.consume(r8, r12)
        L_0x00c8:
            r1 = 178(0xb2, float:2.5E-43)
            if (r5 != r1) goto L_0x00db
            byte[] r1 = r21.getData()
            int r8 = r4 + 2
            byte r1 = r1[r8]
            if (r1 != r11) goto L_0x00db
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r1 = r0.userData
            r1.startNalUnit(r5)
        L_0x00db:
            if (r5 == 0) goto L_0x00e9
            r1 = 179(0xb3, float:2.51E-43)
            if (r5 != r1) goto L_0x00e2
            goto L_0x00e9
        L_0x00e2:
            r1 = 184(0xb8, float:2.58E-43)
            if (r5 != r1) goto L_0x0147
            r0.sampleIsKeyframe = r11
            goto L_0x0147
        L_0x00e9:
            int r1 = r2 - r4
            boolean r4 = r0.sampleHasPicture
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x0114
            boolean r4 = r0.hasOutputFormat
            if (r4 == 0) goto L_0x0114
            long r13 = r0.sampleTimeUs
            int r4 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0114
            boolean r15 = r0.sampleIsKeyframe
            long r11 = r0.totalBytesWritten
            r19 = r5
            long r4 = r0.samplePosition
            long r11 = r11 - r4
            int r4 = (int) r11
            int r16 = r4 - r1
            com.google.android.exoplayer2.extractor.TrackOutput r12 = r0.output
            r18 = 0
            r17 = r1
            r12.sampleMetadata(r13, r15, r16, r17, r18)
            goto L_0x0116
        L_0x0114:
            r19 = r5
        L_0x0116:
            boolean r4 = r0.startedFirstSample
            if (r4 == 0) goto L_0x0121
            boolean r4 = r0.sampleHasPicture
            if (r4 == 0) goto L_0x011f
            goto L_0x0121
        L_0x011f:
            r1 = 1
            goto L_0x0142
        L_0x0121:
            long r4 = r0.totalBytesWritten
            long r11 = (long) r1
            long r4 = r4 - r11
            r0.samplePosition = r4
            long r4 = r0.pesTimeUs
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x012e
            goto L_0x0139
        L_0x012e:
            long r4 = r0.sampleTimeUs
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0138
            long r11 = r0.frameDurationUs
            long r4 = r4 + r11
            goto L_0x0139
        L_0x0138:
            r4 = r8
        L_0x0139:
            r0.sampleTimeUs = r4
            r0.sampleIsKeyframe = r10
            r0.pesTimeUs = r8
            r1 = 1
            r0.startedFirstSample = r1
        L_0x0142:
            if (r19 != 0) goto L_0x0145
            r10 = 1
        L_0x0145:
            r0.sampleHasPicture = r10
        L_0x0147:
            r1 = r7
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.p007ts.H262Reader.consume(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<com.google.android.exoplayer2.Format, java.lang.Long> parseCsdBuffer(com.google.android.exoplayer2.extractor.p007ts.H262Reader.CsdBuffer r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.data
            int r1 = r8.length
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            byte r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            byte r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 6
            byte r5 = r0[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r6 = r4 >> 4
            r2 = r2 | r6
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r5
            r5 = 7
            byte r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L_0x003d
            r7 = 3
            if (r6 == r7) goto L_0x0037
            if (r6 == r1) goto L_0x0031
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0044
        L_0x0031:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
            goto L_0x0042
        L_0x0037:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L_0x0042
        L_0x003d:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
        L_0x0042:
            float r6 = (float) r6
            float r1 = r1 / r6
        L_0x0044:
            com.google.android.exoplayer2.Format$Builder r6 = new com.google.android.exoplayer2.Format$Builder
            r6.<init>()
            com.google.android.exoplayer2.Format$Builder r9 = r6.setId((java.lang.String) r9)
            java.lang.String r6 = "video/mpeg2"
            com.google.android.exoplayer2.Format$Builder r9 = r9.setSampleMimeType(r6)
            com.google.android.exoplayer2.Format$Builder r9 = r9.setWidth(r2)
            com.google.android.exoplayer2.Format$Builder r9 = r9.setHeight(r4)
            com.google.android.exoplayer2.Format$Builder r9 = r9.setPixelWidthHeightRatio(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            com.google.android.exoplayer2.Format$Builder r9 = r9.setInitializationData(r1)
            com.google.android.exoplayer2.Format r9 = r9.build()
            r1 = 0
            byte r4 = r0[r5]
            r4 = r4 & 15
            int r4 = r4 + -1
            if (r4 < 0) goto L_0x009e
            double[] r5 = FRAME_RATE_VALUES
            int r6 = r5.length
            if (r4 >= r6) goto L_0x009e
            r1 = r5[r4]
            int r8 = r8.sequenceExtensionPosition
            int r8 = r8 + 9
            byte r4 = r0[r8]
            r4 = r4 & 96
            int r3 = r4 >> 5
            byte r8 = r0[r8]
            r8 = r8 & 31
            if (r3 == r8) goto L_0x0097
            double r3 = (double) r3
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L_0x0097:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r1 = (long) r3
        L_0x009e:
            java.lang.Long r8 = java.lang.Long.valueOf(r1)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.p007ts.H262Reader.parseCsdBuffer(com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer, java.lang.String):android.util.Pair");
    }

    /* renamed from: com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer */
    private static final class CsdBuffer {
        private static final byte[] START_CODE = {0, 0, 1};
        public byte[] data;
        private boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        public CsdBuffer(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.isFilling = false;
            this.length = 0;
            this.sequenceExtensionPosition = 0;
        }

        public boolean onStartCode(int i, int i2) {
            if (this.isFilling) {
                int i3 = this.length - i2;
                this.length = i3;
                if (this.sequenceExtensionPosition == 0 && i == 181) {
                    this.sequenceExtensionPosition = i3;
                } else {
                    this.isFilling = false;
                    return true;
                }
            } else if (i == 179) {
                this.isFilling = true;
            }
            byte[] bArr = START_CODE;
            onData(bArr, 0, bArr.length);
            return false;
        }

        public void onData(byte[] bArr, int i, int i2) {
            if (this.isFilling) {
                int i3 = i2 - i;
                byte[] bArr2 = this.data;
                int length2 = bArr2.length;
                int i4 = this.length;
                if (length2 < i4 + i3) {
                    this.data = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.data, this.length, i3);
                this.length += i3;
            }
        }
    }
}
