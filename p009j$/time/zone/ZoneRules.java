package p009j$.time.zone;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupViewModel;
import p009j$.lang.Iterable;
import p009j$.time.Clock;
import p009j$.time.Clock$SystemClock$$ExternalSyntheticOutline0;
import p009j$.time.Instant;
import p009j$.time.LocalDate;
import p009j$.time.LocalDateTime;
import p009j$.time.ZoneOffset;
import p009j$.util.Objects;
import p009j$.util.concurrent.ConcurrentHashMap;

/* renamed from: j$.time.zone.ZoneRules */
public final class ZoneRules implements Serializable {
    private static final ZoneOffsetTransitionRule[] EMPTY_LASTRULES = new ZoneOffsetTransitionRule[0];
    private static final LocalDateTime[] EMPTY_LDT_ARRAY = new LocalDateTime[0];
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final ZoneOffsetTransition[] NO_TRANSITIONS = new ZoneOffsetTransition[0];
    private final ZoneOffsetTransitionRule[] lastRules;
    private final transient ConcurrentMap lastRulesCache = new ConcurrentHashMap();
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final TimeZone timeZone;
    private final ZoneOffset[] wallOffsets;

    private ZoneRules(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.standardOffsets = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        long[] jArr = EMPTY_LONG_ARRAY;
        this.standardTransitions = jArr;
        this.savingsInstantTransitions = jArr;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = zoneOffsetArr;
        this.lastRules = EMPTY_LASTRULES;
        this.timeZone = null;
    }

    ZoneRules(TimeZone timeZone2) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.standardOffsets = zoneOffsetArr;
        zoneOffsetArr[0] = offsetFromMillis(timeZone2.getRawOffset());
        long[] jArr = EMPTY_LONG_ARRAY;
        this.standardTransitions = jArr;
        this.savingsInstantTransitions = jArr;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = zoneOffsetArr;
        this.lastRules = EMPTY_LASTRULES;
        this.timeZone = timeZone2;
    }

    private Object findOffsetInfo(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        LocalDateTime dateTimeBefore = zoneOffsetTransition.getDateTimeBefore();
        boolean isGap = zoneOffsetTransition.isGap();
        boolean isBefore = localDateTime.isBefore(dateTimeBefore);
        return isGap ? isBefore ? zoneOffsetTransition.getOffsetBefore() : localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition : zoneOffsetTransition.getOffsetAfter() : !isBefore ? zoneOffsetTransition.getOffsetAfter() : localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition.getOffsetBefore() : zoneOffsetTransition;
    }

    /* JADX WARNING: type inference failed for: r8v3, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p009j$.time.zone.ZoneOffsetTransition[] findTransitionArray(int r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            java.util.concurrent.ConcurrentMap r3 = r0.lastRulesCache
            java.lang.Object r3 = r3.get(r2)
            j$.time.zone.ZoneOffsetTransition[] r3 = (p009j$.time.zone.ZoneOffsetTransition[]) r3
            if (r3 == 0) goto L_0x0013
            return r3
        L_0x0013:
            java.util.TimeZone r3 = r0.timeZone
            r5 = 0
            if (r3 == 0) goto L_0x00cc
            r3 = 1800(0x708, float:2.522E-42)
            if (r1 >= r3) goto L_0x001f
            j$.time.zone.ZoneOffsetTransition[] r1 = NO_TRANSITIONS
            return r1
        L_0x001f:
            int r3 = r1 + -1
            r6 = 12
            r7 = 31
            j$.time.LocalDateTime r3 = p009j$.time.LocalDateTime.m186of(r3, r6, r7, r5, r5)
            j$.time.ZoneOffset[] r6 = r0.standardOffsets
            r5 = r6[r5]
            long r5 = r3.toEpochSecond(r5)
            java.util.TimeZone r3 = r0.timeZone
            r7 = 1000(0x3e8, double:4.94E-321)
            long r9 = r5 * r7
            int r3 = r3.getOffset(r9)
            r9 = 31968000(0x1e7cb00, double:1.57942906E-316)
            long r9 = r9 + r5
            j$.time.zone.ZoneOffsetTransition[] r11 = NO_TRANSITIONS
        L_0x0041:
            int r12 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r12 >= 0) goto L_0x00be
            r12 = 7776000(0x76a700, double:3.8418545E-317)
            long r12 = r12 + r5
            java.util.TimeZone r14 = r0.timeZone
            r15 = r5
            long r4 = r12 * r7
            int r4 = r14.getOffset(r4)
            if (r3 == r4) goto L_0x00bc
            r5 = r15
        L_0x0055:
            long r15 = r12 - r5
            r17 = 1
            int r4 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r4 <= 0) goto L_0x007d
            long r7 = r12 + r5
            r17 = r9
            r9 = 2
            long r7 = p009j$.lang.Iterable.CC.m$2(r7, r9)
            java.util.TimeZone r4 = r0.timeZone
            r15 = r12
            r9 = 1000(0x3e8, double:4.94E-321)
            long r12 = r7 * r9
            int r4 = r4.getOffset(r12)
            if (r4 != r3) goto L_0x0078
            r5 = r7
            r7 = r9
            r12 = r15
            goto L_0x007a
        L_0x0078:
            r12 = r7
            r7 = r9
        L_0x007a:
            r9 = r17
            goto L_0x0055
        L_0x007d:
            r17 = r9
            r15 = r12
            r9 = r7
            java.util.TimeZone r4 = r0.timeZone
            long r7 = r5 * r9
            int r4 = r4.getOffset(r7)
            if (r4 == r3) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r5 = r15
        L_0x008d:
            j$.time.ZoneOffset r3 = offsetFromMillis(r3)
            java.util.TimeZone r4 = r0.timeZone
            long r7 = r5 * r9
            int r4 = r4.getOffset(r7)
            j$.time.ZoneOffset r7 = offsetFromMillis(r4)
            int r8 = r0.findYear(r5, r7)
            if (r8 != r1) goto L_0x00b7
            int r8 = r11.length
            int r8 = r8 + 1
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r11, r8)
            r11 = r8
            j$.time.zone.ZoneOffsetTransition[] r11 = (p009j$.time.zone.ZoneOffsetTransition[]) r11
            int r8 = r11.length
            int r8 = r8 + -1
            j$.time.zone.ZoneOffsetTransition r12 = new j$.time.zone.ZoneOffsetTransition
            r12.<init>((long) r5, (p009j$.time.ZoneOffset) r3, (p009j$.time.ZoneOffset) r7)
            r11[r8] = r12
        L_0x00b7:
            r3 = r4
            r7 = r9
            r9 = r17
            goto L_0x0041
        L_0x00bc:
            r5 = r12
            goto L_0x0041
        L_0x00be:
            r3 = 1916(0x77c, float:2.685E-42)
            if (r3 > r1) goto L_0x00cb
            r3 = 2100(0x834, float:2.943E-42)
            if (r1 >= r3) goto L_0x00cb
            java.util.concurrent.ConcurrentMap r1 = r0.lastRulesCache
            r1.putIfAbsent(r2, r11)
        L_0x00cb:
            return r11
        L_0x00cc:
            j$.time.zone.ZoneOffsetTransitionRule[] r3 = r0.lastRules
            int r4 = r3.length
            j$.time.zone.ZoneOffsetTransition[] r4 = new p009j$.time.zone.ZoneOffsetTransition[r4]
            int r6 = r3.length
            if (r6 > 0) goto L_0x00de
            r6 = 2100(0x834, float:2.943E-42)
            if (r1 >= r6) goto L_0x00dd
            java.util.concurrent.ConcurrentMap r1 = r0.lastRulesCache
            r1.putIfAbsent(r2, r4)
        L_0x00dd:
            return r4
        L_0x00de:
            r1 = r3[r5]
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.zone.ZoneRules.findTransitionArray(int):j$.time.zone.ZoneOffsetTransition[]");
    }

    private int findYear(long j, ZoneOffset zoneOffset) {
        return LocalDate.ofEpochDay(Iterable.CC.m$2(j + ((long) zoneOffset.getTotalSeconds()), 86400)).getYear();
    }

    private Object getOffsetInfo(LocalDateTime localDateTime) {
        Object obj = null;
        int i = 0;
        if (this.timeZone != null) {
            ZoneOffsetTransition[] findTransitionArray = findTransitionArray(localDateTime.getYear());
            if (findTransitionArray.length == 0) {
                return offsetFromMillis(this.timeZone.getOffset(localDateTime.toEpochSecond(this.standardOffsets[0]) * 1000));
            }
            int length = findTransitionArray.length;
            while (i < length) {
                ZoneOffsetTransition zoneOffsetTransition = findTransitionArray[i];
                Object findOffsetInfo = findOffsetInfo(localDateTime, zoneOffsetTransition);
                if ((findOffsetInfo instanceof ZoneOffsetTransition) || findOffsetInfo.equals(zoneOffsetTransition.getOffsetBefore())) {
                    return findOffsetInfo;
                }
                i++;
                obj = findOffsetInfo;
            }
            return obj;
        } else if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        } else {
            if (this.lastRules.length > 0) {
                LocalDateTime[] localDateTimeArr = this.savingsLocalTransitions;
                if (localDateTime.isAfter(localDateTimeArr[localDateTimeArr.length - 1])) {
                    ZoneOffsetTransition[] findTransitionArray2 = findTransitionArray(localDateTime.getYear());
                    int length2 = findTransitionArray2.length;
                    while (i < length2) {
                        ZoneOffsetTransition zoneOffsetTransition2 = findTransitionArray2[i];
                        Object findOffsetInfo2 = findOffsetInfo(localDateTime, zoneOffsetTransition2);
                        if ((findOffsetInfo2 instanceof ZoneOffsetTransition) || findOffsetInfo2.equals(zoneOffsetTransition2.getOffsetBefore())) {
                            return findOffsetInfo2;
                        }
                        i++;
                        obj = findOffsetInfo2;
                    }
                    return obj;
                }
            }
            int binarySearch = Arrays.binarySearch(this.savingsLocalTransitions, localDateTime);
            if (binarySearch == -1) {
                return this.wallOffsets[0];
            }
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            } else {
                LocalDateTime[] localDateTimeArr2 = this.savingsLocalTransitions;
                if (binarySearch < localDateTimeArr2.length - 1) {
                    int i2 = binarySearch + 1;
                    if (localDateTimeArr2[binarySearch].equals(localDateTimeArr2[i2])) {
                        binarySearch = i2;
                    }
                }
            }
            if ((binarySearch & 1) != 0) {
                return this.wallOffsets[(binarySearch / 2) + 1];
            }
            LocalDateTime[] localDateTimeArr3 = this.savingsLocalTransitions;
            LocalDateTime localDateTime2 = localDateTimeArr3[binarySearch];
            LocalDateTime localDateTime3 = localDateTimeArr3[binarySearch + 1];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            int i3 = binarySearch / 2;
            ZoneOffset zoneOffset = zoneOffsetArr[i3];
            ZoneOffset zoneOffset2 = zoneOffsetArr[i3 + 1];
            return zoneOffset2.getTotalSeconds() > zoneOffset.getTotalSeconds() ? new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2) : new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
        }
    }

    /* renamed from: of */
    public static ZoneRules m200of(ZoneOffset zoneOffset) {
        return new ZoneRules(zoneOffset);
    }

    private static ZoneOffset offsetFromMillis(int i) {
        return ZoneOffset.ofTotalSeconds(i / 1000);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZoneRules)) {
            return false;
        }
        ZoneRules zoneRules = (ZoneRules) obj;
        return Objects.equals(this.timeZone, zoneRules.timeZone) && Arrays.equals(this.standardTransitions, zoneRules.standardTransitions) && Arrays.equals(this.standardOffsets, zoneRules.standardOffsets) && Arrays.equals(this.savingsInstantTransitions, zoneRules.savingsInstantTransitions) && Arrays.equals(this.wallOffsets, zoneRules.wallOffsets) && Arrays.equals(this.lastRules, zoneRules.lastRules);
    }

    public ZoneOffset getOffset(Instant instant) {
        TimeZone timeZone2 = this.timeZone;
        if (timeZone2 != null) {
            return offsetFromMillis(timeZone2.getOffset(instant.toEpochMilli()));
        }
        if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        long epochSecond = instant.getEpochSecond();
        if (this.lastRules.length > 0) {
            long[] jArr = this.savingsInstantTransitions;
            if (epochSecond > jArr[jArr.length - 1]) {
                ZoneOffset[] zoneOffsetArr = this.wallOffsets;
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear(epochSecond, zoneOffsetArr[zoneOffsetArr.length - 1]));
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int i = 0; i < findTransitionArray.length; i++) {
                    zoneOffsetTransition = findTransitionArray[i];
                    if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                        return zoneOffsetTransition.getOffsetBefore();
                    }
                }
                return zoneOffsetTransition.getOffsetAfter();
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.wallOffsets[binarySearch + 1];
    }

    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) offsetInfo;
        }
        return null;
    }

    public List getValidOffsets(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        return offsetInfo instanceof ZoneOffsetTransition ? ((ZoneOffsetTransition) offsetInfo).getValidOffsets() : Collections.singletonList((ZoneOffset) offsetInfo);
    }

    public int hashCode() {
        TimeZone timeZone2 = this.timeZone;
        return (((((timeZone2 != null ? timeZone2.hashCode() : 0) ^ Arrays.hashCode(this.standardTransitions)) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    public boolean isDaylightSavings(Instant instant) {
        ZoneOffset zoneOffset;
        TimeZone timeZone2 = this.timeZone;
        if (timeZone2 != null) {
            zoneOffset = offsetFromMillis(timeZone2.getRawOffset());
        } else if (this.savingsInstantTransitions.length == 0) {
            zoneOffset = this.standardOffsets[0];
        } else {
            int binarySearch = Arrays.binarySearch(this.standardTransitions, instant.getEpochSecond());
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            zoneOffset = this.standardOffsets[binarySearch + 1];
        }
        return !zoneOffset.equals(getOffset(instant));
    }

    public boolean isFixedOffset() {
        TimeZone timeZone2 = this.timeZone;
        if (timeZone2 != null) {
            if (timeZone2.useDaylightTime() || this.timeZone.getDSTSavings() != 0) {
                return false;
            }
            Instant now = Instant.now();
            ZoneOffsetTransition zoneOffsetTransition = null;
            if (this.timeZone != null) {
                long epochSecond = now.getEpochSecond();
                if (now.getNano() > 0 && epochSecond < Long.MAX_VALUE) {
                    epochSecond++;
                }
                int findYear = findYear(epochSecond, getOffset(now));
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear);
                int length = findTransitionArray.length - 1;
                while (true) {
                    if (length >= 0) {
                        if (epochSecond > findTransitionArray[length].toEpochSecond()) {
                            zoneOffsetTransition = findTransitionArray[length];
                            break;
                        }
                        length--;
                    } else if (findYear > 1800) {
                        ZoneOffsetTransition[] findTransitionArray2 = findTransitionArray(findYear - 1);
                        int length2 = findTransitionArray2.length - 1;
                        while (true) {
                            if (length2 < 0) {
                                long min = Math.min(epochSecond - 31104000, (Clock.systemUTC().millis() / 1000) + 31968000);
                                int offset = this.timeZone.getOffset((epochSecond - 1) * 1000);
                                long epochDay = LocalDate.m185of(TimersSetupLimitSetupViewModel.SEC_30M, 1, 1).toEpochDay() * 86400;
                                while (true) {
                                    if (epochDay > min) {
                                        break;
                                    }
                                    int offset2 = this.timeZone.getOffset(min * 1000);
                                    if (offset != offset2) {
                                        int findYear2 = findYear(min, offsetFromMillis(offset2));
                                        ZoneOffsetTransition[] findTransitionArray3 = findTransitionArray(findYear2 + 1);
                                        int length3 = findTransitionArray3.length - 1;
                                        while (true) {
                                            if (length3 < 0) {
                                                ZoneOffsetTransition[] findTransitionArray4 = findTransitionArray(findYear2);
                                                zoneOffsetTransition = findTransitionArray4[findTransitionArray4.length - 1];
                                                break;
                                            } else if (epochSecond > findTransitionArray3[length3].toEpochSecond()) {
                                                zoneOffsetTransition = findTransitionArray3[length3];
                                                break;
                                            } else {
                                                length3--;
                                            }
                                        }
                                    } else {
                                        min -= 7776000;
                                    }
                                }
                            } else if (epochSecond > findTransitionArray2[length2].toEpochSecond()) {
                                zoneOffsetTransition = findTransitionArray2[length2];
                                break;
                            } else {
                                length2--;
                            }
                        }
                    }
                }
            } else if (this.savingsInstantTransitions.length != 0) {
                long epochSecond2 = now.getEpochSecond();
                if (now.getNano() > 0 && epochSecond2 < Long.MAX_VALUE) {
                    epochSecond2++;
                }
                long[] jArr = this.savingsInstantTransitions;
                long j = jArr[jArr.length - 1];
                if (this.lastRules.length > 0 && epochSecond2 > j) {
                    ZoneOffset[] zoneOffsetArr = this.wallOffsets;
                    ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
                    int findYear3 = findYear(epochSecond2, zoneOffset);
                    ZoneOffsetTransition[] findTransitionArray5 = findTransitionArray(findYear3);
                    int length4 = findTransitionArray5.length - 1;
                    while (true) {
                        if (length4 < 0) {
                            int i = findYear3 - 1;
                            if (i > findYear(j, zoneOffset)) {
                                ZoneOffsetTransition[] findTransitionArray6 = findTransitionArray(i);
                                zoneOffsetTransition = findTransitionArray6[findTransitionArray6.length - 1];
                            }
                        } else if (epochSecond2 > findTransitionArray5[length4].toEpochSecond()) {
                            zoneOffsetTransition = findTransitionArray5[length4];
                            break;
                        } else {
                            length4--;
                        }
                    }
                }
                int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond2);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                if (binarySearch > 0) {
                    int i2 = binarySearch - 1;
                    long j2 = this.savingsInstantTransitions[i2];
                    ZoneOffset[] zoneOffsetArr2 = this.wallOffsets;
                    zoneOffsetTransition = new ZoneOffsetTransition(j2, zoneOffsetArr2[i2], zoneOffsetArr2[binarySearch]);
                }
            }
            return zoneOffsetTransition == null;
        } else if (this.savingsInstantTransitions.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb;
        if (this.timeZone != null) {
            sb = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("ZoneRules[timeZone=");
            sb.append(this.timeZone.getID());
        } else {
            sb = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("ZoneRules[currentStandardOffset=");
            ZoneOffset[] zoneOffsetArr = this.standardOffsets;
            sb.append(zoneOffsetArr[zoneOffsetArr.length - 1]);
        }
        sb.append("]");
        return sb.toString();
    }
}
