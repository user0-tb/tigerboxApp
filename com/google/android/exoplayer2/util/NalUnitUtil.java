package com.google.android.exoplayer2.util;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final int EXTENDED_SAR = 255;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final int NAL_UNIT_TYPE_AUD = 9;
    public static final int NAL_UNIT_TYPE_IDR = 5;
    public static final int NAL_UNIT_TYPE_NON_IDR = 1;
    public static final int NAL_UNIT_TYPE_PARTITION_A = 2;
    public static final int NAL_UNIT_TYPE_PPS = 8;
    public static final int NAL_UNIT_TYPE_SEI = 6;
    public static final int NAL_UNIT_TYPE_SPS = 7;
    private static final String TAG = "NalUnitUtil";
    private static int[] scratchEscapePositions = new int[10];
    private static final Object scratchEscapePositionsLock = new Object();

    public static final class SpsData {
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int maxNumRefFrames;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthHeightRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, boolean z, boolean z2, int i8, int i9, int i10, boolean z3) {
            this.profileIdc = i;
            this.constraintsFlagsAndReservedZero2Bits = i2;
            this.levelIdc = i3;
            this.seqParameterSetId = i4;
            this.maxNumRefFrames = i5;
            this.width = i6;
            this.height = i7;
            this.pixelWidthHeightRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i8;
            this.picOrderCountType = i9;
            this.picOrderCntLsbLength = i10;
            this.deltaPicOrderAlwaysZeroFlag = z3;
        }
    }

    public static final class H265SpsData {
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;
        public final int[] constraintBytes;
        public final int generalLevelIdc;
        public final int generalProfileCompatibilityFlags;
        public final int generalProfileIdc;
        public final int generalProfileSpace;
        public final boolean generalTierFlag;
        public final int height;
        public final float pixelWidthHeightRatio;
        public final int seqParameterSetId;
        public final int width;

        public H265SpsData(int i, boolean z, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10) {
            this.generalProfileSpace = i;
            this.generalTierFlag = z;
            this.generalProfileIdc = i2;
            this.generalProfileCompatibilityFlags = i3;
            this.constraintBytes = iArr;
            this.generalLevelIdc = i4;
            this.seqParameterSetId = i5;
            this.width = i6;
            this.height = i7;
            this.pixelWidthHeightRatio = f;
            this.colorSpace = i8;
            this.colorRange = i9;
            this.colorTransfer = i10;
        }
    }

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i, int i2, boolean z) {
            this.picParameterSetId = i;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (scratchEscapePositionsLock) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                try {
                    i3 = findNextUnescapeIndex(bArr, i3, i);
                    if (i3 < i) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i4) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i4] = i3;
                        i3 += 3;
                        i4++;
                    }
                } finally {
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = scratchEscapePositions[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                byte b = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (b == 1 && (byteBuffer.get(i3) & Ascii.f281US) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b == 0) {
                    i2++;
                }
                if (b != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean isNalUnitSei(String str, byte b) {
        if (MimeTypes.VIDEO_H264.equals(str) && (b & Ascii.f281US) == 6) {
            return true;
        }
        if (!MimeTypes.VIDEO_H265.equals(str) || ((b & 126) >> 1) != 39) {
            return false;
        }
        return true;
    }

    public static int getNalUnitType(byte[] bArr, int i) {
        return bArr[i + 3] & Ascii.f281US;
    }

    public static int getH265NalUnitType(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        return parseSpsNalUnitPayload(bArr, i + 1, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnitPayload(byte[] r22, int r23, int r24) {
        /*
            com.google.android.exoplayer2.util.ParsableNalUnitBitArray r0 = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray
            r1 = r22
            r2 = r23
            r3 = r24
            r0.<init>(r1, r2, r3)
            r1 = 8
            int r3 = r0.readBits(r1)
            int r4 = r0.readBits(r1)
            int r5 = r0.readBits(r1)
            int r6 = r0.readUnsignedExpGolombCodedInt()
            r2 = 3
            r9 = 1
            r10 = 100
            if (r3 == r10) goto L_0x004b
            r10 = 110(0x6e, float:1.54E-43)
            if (r3 == r10) goto L_0x004b
            r10 = 122(0x7a, float:1.71E-43)
            if (r3 == r10) goto L_0x004b
            r10 = 244(0xf4, float:3.42E-43)
            if (r3 == r10) goto L_0x004b
            r10 = 44
            if (r3 == r10) goto L_0x004b
            r10 = 83
            if (r3 == r10) goto L_0x004b
            r10 = 86
            if (r3 == r10) goto L_0x004b
            r10 = 118(0x76, float:1.65E-43)
            if (r3 == r10) goto L_0x004b
            r10 = 128(0x80, float:1.794E-43)
            if (r3 == r10) goto L_0x004b
            r10 = 138(0x8a, float:1.93E-43)
            if (r3 != r10) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r10 = 1
            r11 = 0
            goto L_0x0084
        L_0x004b:
            int r10 = r0.readUnsignedExpGolombCodedInt()
            if (r10 != r2) goto L_0x0056
            boolean r11 = r0.readBit()
            goto L_0x0057
        L_0x0056:
            r11 = 0
        L_0x0057:
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            boolean r12 = r0.readBit()
            if (r12 == 0) goto L_0x0084
            if (r10 == r2) goto L_0x006b
            r12 = 8
            goto L_0x006d
        L_0x006b:
            r12 = 12
        L_0x006d:
            r13 = 0
        L_0x006e:
            if (r13 >= r12) goto L_0x0084
            boolean r14 = r0.readBit()
            if (r14 == 0) goto L_0x0081
            r14 = 6
            if (r13 >= r14) goto L_0x007c
            r14 = 16
            goto L_0x007e
        L_0x007c:
            r14 = 64
        L_0x007e:
            skipScalingList(r0, r14)
        L_0x0081:
            int r13 = r13 + 1
            goto L_0x006e
        L_0x0084:
            int r12 = r0.readUnsignedExpGolombCodedInt()
            int r13 = r12 + 4
            int r14 = r0.readUnsignedExpGolombCodedInt()
            if (r14 != 0) goto L_0x0098
            int r12 = r0.readUnsignedExpGolombCodedInt()
            int r12 = r12 + 4
            r15 = r12
            goto L_0x00ba
        L_0x0098:
            if (r14 != r9) goto L_0x00b9
            boolean r12 = r0.readBit()
            r0.readSignedExpGolombCodedInt()
            r0.readSignedExpGolombCodedInt()
            int r15 = r0.readUnsignedExpGolombCodedInt()
            long r1 = (long) r15
            r15 = 0
        L_0x00aa:
            long r7 = (long) r15
            int r17 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r17 >= 0) goto L_0x00b5
            r0.readUnsignedExpGolombCodedInt()
            int r15 = r15 + 1
            goto L_0x00aa
        L_0x00b5:
            r16 = r12
            r15 = 0
            goto L_0x00bc
        L_0x00b9:
            r15 = 0
        L_0x00ba:
            r16 = 0
        L_0x00bc:
            int r7 = r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            int r1 = r0.readUnsignedExpGolombCodedInt()
            int r1 = r1 + r9
            int r2 = r0.readUnsignedExpGolombCodedInt()
            int r2 = r2 + r9
            boolean r12 = r0.readBit()
            int r8 = 2 - r12
            int r8 = r8 * r2
            if (r12 != 0) goto L_0x00da
            r0.skipBit()
        L_0x00da:
            r0.skipBit()
            r2 = 16
            int r1 = r1 * 16
            int r8 = r8 * 16
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x011e
            int r2 = r0.readUnsignedExpGolombCodedInt()
            int r17 = r0.readUnsignedExpGolombCodedInt()
            int r18 = r0.readUnsignedExpGolombCodedInt()
            int r19 = r0.readUnsignedExpGolombCodedInt()
            if (r10 != 0) goto L_0x00fe
            int r10 = 2 - r12
            goto L_0x0113
        L_0x00fe:
            r20 = 2
            r9 = 3
            if (r10 != r9) goto L_0x0107
            r9 = 1
            r21 = 1
            goto L_0x010a
        L_0x0107:
            r9 = 1
            r21 = 2
        L_0x010a:
            if (r10 != r9) goto L_0x010d
            r9 = 2
        L_0x010d:
            int r10 = 2 - r12
            int r10 = r10 * r9
            r9 = r21
        L_0x0113:
            int r2 = r2 + r17
            int r2 = r2 * r9
            int r1 = r1 - r2
            int r18 = r18 + r19
            int r18 = r18 * r10
            int r8 = r8 - r18
        L_0x011e:
            r9 = r8
            r8 = r1
            r1 = 1065353216(0x3f800000, float:1.0)
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x016a
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x016a
            r2 = 8
            int r2 = r0.readBits(r2)
            r10 = 255(0xff, float:3.57E-43)
            if (r2 != r10) goto L_0x014b
            r10 = 16
            int r2 = r0.readBits(r10)
            int r0 = r0.readBits(r10)
            if (r2 == 0) goto L_0x0149
            if (r0 == 0) goto L_0x0149
            float r1 = (float) r2
            float r0 = (float) r0
            float r1 = r1 / r0
        L_0x0149:
            r10 = r1
            goto L_0x016c
        L_0x014b:
            float[] r0 = ASPECT_RATIO_IDC_VALUES
            int r10 = r0.length
            if (r2 >= r10) goto L_0x0154
            r0 = r0[r2]
            r10 = r0
            goto L_0x016c
        L_0x0154:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "Unexpected aspect_ratio_idc value: "
            r0.append(r10)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "NalUnitUtil"
            com.google.android.exoplayer2.util.Log.m157w(r2, r0)
        L_0x016a:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x016c:
            com.google.android.exoplayer2.util.NalUnitUtil$SpsData r0 = new com.google.android.exoplayer2.util.NalUnitUtil$SpsData
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnitPayload(byte[], int, int):com.google.android.exoplayer2.util.NalUnitUtil$SpsData");
    }

    public static H265SpsData parseH265SpsNalUnit(byte[] bArr, int i, int i2) {
        return parseH265SpsNalUnitPayload(bArr, i + 2, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.util.NalUnitUtil.H265SpsData parseH265SpsNalUnitPayload(byte[] r23, int r24, int r25) {
        /*
            com.google.android.exoplayer2.util.ParsableNalUnitBitArray r0 = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray
            r1 = r23
            r2 = r24
            r3 = r25
            r0.<init>(r1, r2, r3)
            r1 = 4
            r0.skipBits(r1)
            r2 = 3
            int r3 = r0.readBits(r2)
            r0.skipBit()
            r4 = 2
            int r6 = r0.readBits(r4)
            boolean r7 = r0.readBit()
            r5 = 5
            int r8 = r0.readBits(r5)
            r9 = 0
            r10 = 0
        L_0x0027:
            r11 = 32
            r12 = 1
            if (r10 >= r11) goto L_0x0038
            boolean r11 = r0.readBit()
            if (r11 == 0) goto L_0x0035
            int r11 = r12 << r10
            r9 = r9 | r11
        L_0x0035:
            int r10 = r10 + 1
            goto L_0x0027
        L_0x0038:
            r10 = 6
            int[] r11 = new int[r10]
            r13 = 0
        L_0x003c:
            r14 = 8
            if (r13 >= r10) goto L_0x0049
            int r14 = r0.readBits(r14)
            r11[r13] = r14
            int r13 = r13 + 1
            goto L_0x003c
        L_0x0049:
            int r13 = r0.readBits(r14)
            r10 = 0
            r15 = 0
        L_0x004f:
            if (r10 >= r3) goto L_0x0064
            boolean r16 = r0.readBit()
            if (r16 == 0) goto L_0x0059
            int r15 = r15 + 89
        L_0x0059:
            boolean r16 = r0.readBit()
            if (r16 == 0) goto L_0x0061
            int r15 = r15 + 8
        L_0x0061:
            int r10 = r10 + 1
            goto L_0x004f
        L_0x0064:
            r0.skipBits(r15)
            if (r3 <= 0) goto L_0x0070
            int r10 = 8 - r3
            int r10 = r10 * 2
            r0.skipBits(r10)
        L_0x0070:
            int r15 = r0.readUnsignedExpGolombCodedInt()
            int r10 = r0.readUnsignedExpGolombCodedInt()
            if (r10 != r2) goto L_0x007d
            r0.skipBit()
        L_0x007d:
            int r16 = r0.readUnsignedExpGolombCodedInt()
            int r17 = r0.readUnsignedExpGolombCodedInt()
            boolean r18 = r0.readBit()
            if (r18 == 0) goto L_0x00b6
            int r18 = r0.readUnsignedExpGolombCodedInt()
            int r19 = r0.readUnsignedExpGolombCodedInt()
            int r20 = r0.readUnsignedExpGolombCodedInt()
            int r21 = r0.readUnsignedExpGolombCodedInt()
            if (r10 == r12) goto L_0x00a3
            if (r10 != r4) goto L_0x00a0
            goto L_0x00a3
        L_0x00a0:
            r22 = 1
            goto L_0x00a5
        L_0x00a3:
            r22 = 2
        L_0x00a5:
            if (r10 != r12) goto L_0x00a9
            r10 = 2
            goto L_0x00aa
        L_0x00a9:
            r10 = 1
        L_0x00aa:
            int r18 = r18 + r19
            int r22 = r22 * r18
            int r16 = r16 - r22
            int r20 = r20 + r21
            int r10 = r10 * r20
            int r17 = r17 - r10
        L_0x00b6:
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            int r10 = r0.readUnsignedExpGolombCodedInt()
            boolean r18 = r0.readBit()
            if (r18 == 0) goto L_0x00c9
            r18 = 0
            goto L_0x00cb
        L_0x00c9:
            r18 = r3
        L_0x00cb:
            r5 = r18
        L_0x00cd:
            if (r5 > r3) goto L_0x00db
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            int r5 = r5 + 1
            goto L_0x00cd
        L_0x00db:
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x00fc
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x00fc
            skipH265ScalingList(r0)
        L_0x00fc:
            r0.skipBits(r4)
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x0111
            r0.skipBits(r14)
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
        L_0x0111:
            skipShortTermReferencePictureSets(r0)
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x012a
            r5 = 0
        L_0x011b:
            int r3 = r0.readUnsignedExpGolombCodedInt()
            if (r5 >= r3) goto L_0x012a
            int r3 = r10 + 4
            int r3 = r3 + r12
            r0.skipBits(r3)
            int r5 = r5 + 1
            goto L_0x011b
        L_0x012a:
            r0.skipBits(r4)
            boolean r3 = r0.readBit()
            r5 = -1
            if (r3 == 0) goto L_0x01ca
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x0172
            int r3 = r0.readBits(r14)
            r10 = 255(0xff, float:3.57E-43)
            if (r3 != r10) goto L_0x0154
            r3 = 16
            int r10 = r0.readBits(r3)
            int r3 = r0.readBits(r3)
            if (r10 == 0) goto L_0x0172
            if (r3 == 0) goto L_0x0172
            float r1 = (float) r10
            float r3 = (float) r3
            float r1 = r1 / r3
            goto L_0x0174
        L_0x0154:
            float[] r10 = ASPECT_RATIO_IDC_VALUES
            int r1 = r10.length
            if (r3 >= r1) goto L_0x015c
            r1 = r10[r3]
            goto L_0x0174
        L_0x015c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r10 = "Unexpected aspect_ratio_idc value: "
            r1.append(r10)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "NalUnitUtil"
            com.google.android.exoplayer2.util.Log.m157w(r3, r1)
        L_0x0172:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x0174:
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x017d
            r0.skipBit()
        L_0x017d:
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x01a9
            r0.skipBits(r2)
            boolean r2 = r0.readBit()
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x01a9
            int r3 = r0.readBits(r14)
            int r5 = r0.readBits(r14)
            r0.skipBits(r14)
            int r3 = com.google.android.exoplayer2.video.ColorInfo.isoColorPrimariesToColorSpace(r3)
            if (r2 == 0) goto L_0x01a2
            r4 = 1
        L_0x01a2:
            int r5 = com.google.android.exoplayer2.video.ColorInfo.isoTransferCharacteristicsToColorTransfer(r5)
            r2 = r5
            r5 = r3
            goto L_0x01ab
        L_0x01a9:
            r2 = -1
            r4 = -1
        L_0x01ab:
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x01b7
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
        L_0x01b7:
            r0.skipBit()
            boolean r0 = r0.readBit()
            if (r0 == 0) goto L_0x01c2
            int r17 = r17 * 2
        L_0x01c2:
            r18 = r2
            r0 = r5
            r14 = r17
            r17 = r4
            goto L_0x01d3
        L_0x01ca:
            r14 = r17
            r0 = -1
            r1 = 1065353216(0x3f800000, float:1.0)
            r17 = -1
            r18 = -1
        L_0x01d3:
            com.google.android.exoplayer2.util.NalUnitUtil$H265SpsData r2 = new com.google.android.exoplayer2.util.NalUnitUtil$H265SpsData
            r5 = r2
            r10 = r11
            r11 = r13
            r12 = r15
            r13 = r16
            r15 = r1
            r16 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.parseH265SpsNalUnitPayload(byte[], int, int):com.google.android.exoplayer2.util.NalUnitUtil$H265SpsData");
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        return parsePpsNalUnitPayload(bArr, i + 1, i2);
    }

    public static PpsData parsePpsNalUnitPayload(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        int i3 = i2 - i;
        boolean z2 = false;
        Assertions.checkState(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i - 3;
        } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            clearPrefixFlags(zArr);
            return i - 2;
        } else if (i3 <= 2 || !zArr[2] || bArr[i] != 0 || bArr[i + 1] != 1) {
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                if ((bArr[i5] & 254) == 0) {
                    int i6 = i5 - 2;
                    if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && bArr[i5] == 1) {
                        clearPrefixFlags(zArr);
                        return i6;
                    }
                    i5 -= 2;
                }
                i5 += 3;
            }
            if (i3 <= 2 ? i3 != 2 ? !zArr[1] || bArr[i4] != 1 : !(zArr[2] && bArr[i2 - 2] == 0 && bArr[i4] == 1) : !(bArr[i2 - 3] == 0 && bArr[i2 - 2] == 0 && bArr[i4] == 1)) {
                z = false;
            } else {
                z = true;
            }
            zArr[0] = z;
            zArr[1] = i3 <= 1 ? !(!zArr[2] || bArr[i4] != 0) : bArr[i2 + -2] == 0 && bArr[i4] == 0;
            if (bArr[i4] == 0) {
                z2 = true;
            }
            zArr[2] = z2;
            return i2;
        } else {
            clearPrefixFlags(zArr);
            return i - 1;
        }
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }

    private static void skipH265ScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (!parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i4 = 0; i4 < min; i4++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    private static void skipShortTermReferencePictureSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        while (i3 < readUnsignedExpGolombCodedInt) {
            if (i3 != 0 && parsableNalUnitBitArray.readBit()) {
                int i4 = i + i2;
                int readUnsignedExpGolombCodedInt2 = (1 - ((parsableNalUnitBitArray.readBit() ? 1 : 0) * true)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                int i5 = i4 + 1;
                boolean[] zArr = new boolean[i5];
                for (int i6 = 0; i6 <= i4; i6++) {
                    if (!parsableNalUnitBitArray.readBit()) {
                        zArr[i6] = parsableNalUnitBitArray.readBit();
                    } else {
                        zArr[i6] = true;
                    }
                }
                int[] iArr3 = new int[i5];
                int[] iArr4 = new int[i5];
                int i7 = 0;
                for (int i8 = i2 - 1; i8 >= 0; i8--) {
                    int i9 = iArr2[i8] + readUnsignedExpGolombCodedInt2;
                    if (i9 < 0 && zArr[i + i8]) {
                        iArr3[i7] = i9;
                        i7++;
                    }
                }
                if (readUnsignedExpGolombCodedInt2 < 0 && zArr[i4]) {
                    iArr3[i7] = readUnsignedExpGolombCodedInt2;
                    i7++;
                }
                for (int i10 = 0; i10 < i; i10++) {
                    int i11 = iArr[i10] + readUnsignedExpGolombCodedInt2;
                    if (i11 < 0 && zArr[i10]) {
                        iArr3[i7] = i11;
                        i7++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr3, i7);
                int i12 = 0;
                for (int i13 = i - 1; i13 >= 0; i13--) {
                    int i14 = iArr[i13] + readUnsignedExpGolombCodedInt2;
                    if (i14 > 0 && zArr[i13]) {
                        iArr4[i12] = i14;
                        i12++;
                    }
                }
                if (readUnsignedExpGolombCodedInt2 > 0 && zArr[i4]) {
                    iArr4[i12] = readUnsignedExpGolombCodedInt2;
                    i12++;
                }
                for (int i15 = 0; i15 < i2; i15++) {
                    int i16 = iArr2[i15] + readUnsignedExpGolombCodedInt2;
                    if (i16 > 0 && zArr[i + i15]) {
                        iArr4[i12] = i16;
                        i12++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr4, i12);
                iArr = copyOf;
                i = i7;
                i2 = i12;
            } else {
                int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int[] iArr5 = new int[readUnsignedExpGolombCodedInt3];
                for (int i17 = 0; i17 < readUnsignedExpGolombCodedInt3; i17++) {
                    iArr5[i17] = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                    parsableNalUnitBitArray.skipBit();
                }
                int[] iArr6 = new int[readUnsignedExpGolombCodedInt4];
                for (int i18 = 0; i18 < readUnsignedExpGolombCodedInt4; i18++) {
                    iArr6[i18] = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                    parsableNalUnitBitArray.skipBit();
                }
                int[] iArr7 = iArr5;
                i = readUnsignedExpGolombCodedInt3;
                iArr = iArr7;
                int[] iArr8 = iArr6;
                i2 = readUnsignedExpGolombCodedInt4;
                iArr2 = iArr8;
            }
            i3++;
        }
    }

    private NalUnitUtil() {
    }
}
