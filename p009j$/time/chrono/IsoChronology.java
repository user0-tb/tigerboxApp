package p009j$.time.chrono;

import java.io.Serializable;

/* renamed from: j$.time.chrono.IsoChronology */
public final class IsoChronology extends AbstractChronology implements Serializable {
    public static final IsoChronology INSTANCE = new IsoChronology();

    private IsoChronology() {
    }

    public boolean isLeapYear(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008a, code lost:
        if (r2 > 0) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p009j$.time.chrono.ChronoLocalDate resolveDate(java.util.Map r16, p009j$.time.format.ResolverStyle r17) {
        /*
            r15 = this;
            r8 = r15
            r0 = r16
            r1 = r17
            j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.EPOCH_DAY
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x001d
            java.lang.Object r0 = r0.remove(r2)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            j$.time.LocalDate r0 = p009j$.time.LocalDate.ofEpochDay(r0)
            goto L_0x04b6
        L_0x001d:
            j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.PROLEPTIC_MONTH
            java.lang.Object r3 = r0.remove(r2)
            java.lang.Long r3 = (java.lang.Long) r3
            r4 = 1
            if (r3 == 0) goto L_0x0051
            j$.time.format.ResolverStyle r6 = p009j$.time.format.ResolverStyle.LENIENT
            if (r1 == r6) goto L_0x0034
            long r6 = r3.longValue()
            r2.checkValidValue(r6)
        L_0x0034:
            j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.MONTH_OF_YEAR
            long r6 = r3.longValue()
            r9 = 12
            long r6 = p009j$.lang.Iterable.CC.m$1(r6, r9)
            long r6 = r6 + r4
            r15.addFieldValue(r0, r2, r6)
            j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.YEAR
            long r6 = r3.longValue()
            long r6 = p009j$.lang.Iterable.CC.m$2(r6, r9)
            r15.addFieldValue(r0, r2, r6)
        L_0x0051:
            j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.YEAR_OF_ERA
            java.lang.Object r3 = r0.remove(r2)
            java.lang.Long r3 = (java.lang.Long) r3
            r6 = 0
            if (r3 == 0) goto L_0x00e9
            j$.time.format.ResolverStyle r9 = p009j$.time.format.ResolverStyle.LENIENT
            if (r1 == r9) goto L_0x0068
            long r9 = r3.longValue()
            r2.checkValidValue(r9)
        L_0x0068:
            j$.time.temporal.ChronoField r9 = p009j$.time.temporal.ChronoField.ERA
            java.lang.Object r9 = r0.remove(r9)
            java.lang.Long r9 = (java.lang.Long) r9
            if (r9 != 0) goto L_0x00ad
            j$.time.temporal.ChronoField r9 = p009j$.time.temporal.ChronoField.YEAR
            java.lang.Object r10 = r0.get(r9)
            java.lang.Long r10 = (java.lang.Long) r10
            j$.time.format.ResolverStyle r11 = p009j$.time.format.ResolverStyle.STRICT
            if (r1 != r11) goto L_0x0091
            if (r10 == 0) goto L_0x008d
            long r10 = r10.longValue()
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            long r10 = r3.longValue()
            if (r2 <= 0) goto L_0x00a0
            goto L_0x00a9
        L_0x008d:
            r0.put(r2, r3)
            goto L_0x00fe
        L_0x0091:
            if (r10 == 0) goto L_0x00a5
            long r10 = r10.longValue()
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x009c
            goto L_0x00a5
        L_0x009c:
            long r10 = r3.longValue()
        L_0x00a0:
            long r10 = p009j$.lang.Iterable.CC.m$4(r4, r10)
            goto L_0x00a9
        L_0x00a5:
            long r10 = r3.longValue()
        L_0x00a9:
            r15.addFieldValue(r0, r9, r10)
            goto L_0x00fe
        L_0x00ad:
            long r10 = r9.longValue()
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x00bc
            j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.YEAR
            long r9 = r3.longValue()
            goto L_0x00ce
        L_0x00bc:
            long r10 = r9.longValue()
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x00d2
            j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.YEAR
            long r9 = r3.longValue()
            long r9 = p009j$.lang.Iterable.CC.m$4(r4, r9)
        L_0x00ce:
            r15.addFieldValue(r0, r2, r9)
            goto L_0x00fe
        L_0x00d2:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid value for era: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00e9:
            j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.ERA
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x00fe
            java.lang.Object r3 = r0.get(r2)
            java.lang.Long r3 = (java.lang.Long) r3
            long r9 = r3.longValue()
            r2.checkValidValue(r9)
        L_0x00fe:
            j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.YEAR
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x04b5
            j$.time.temporal.ChronoField r3 = p009j$.time.temporal.ChronoField.MONTH_OF_YEAR
            boolean r9 = r0.containsKey(r3)
            r10 = 1
            if (r9 == 0) goto L_0x032f
            j$.time.temporal.ChronoField r9 = p009j$.time.temporal.ChronoField.DAY_OF_MONTH
            boolean r11 = r0.containsKey(r9)
            if (r11 == 0) goto L_0x01b3
            java.lang.Object r11 = r0.remove(r2)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            int r2 = r2.checkValidIntValue(r11)
            j$.time.format.ResolverStyle r11 = p009j$.time.format.ResolverStyle.LENIENT
            if (r1 != r11) goto L_0x0153
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r6 = r1.longValue()
            long r6 = p009j$.lang.Iterable.CC.m$4(r6, r4)
            java.lang.Object r0 = r0.remove(r9)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r0 = p009j$.lang.Iterable.CC.m$4(r0, r4)
            j$.time.LocalDate r2 = p009j$.time.LocalDate.m185of(r2, r10, r10)
            j$.time.LocalDate r2 = r2.plusMonths(r6)
            j$.time.LocalDate r0 = r2.plusDays(r0)
            goto L_0x04b6
        L_0x0153:
            java.lang.Object r4 = r0.remove(r3)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r3 = r3.checkValidIntValue(r4)
            java.lang.Object r0 = r0.remove(r9)
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            int r0 = r9.checkValidIntValue(r4)
            j$.time.format.ResolverStyle r4 = p009j$.time.format.ResolverStyle.SMART
            if (r1 != r4) goto L_0x01ad
            r1 = 4
            if (r3 == r1) goto L_0x01a7
            r1 = 6
            if (r3 == r1) goto L_0x01a7
            r1 = 9
            if (r3 == r1) goto L_0x01a7
            r1 = 11
            if (r3 != r1) goto L_0x0182
            goto L_0x01a7
        L_0x0182:
            r1 = 2
            if (r3 != r1) goto L_0x01ad
            j$.time.Month r1 = p009j$.time.Month.FEBRUARY
            long r4 = (long) r2
            int r9 = p009j$.time.Year.$r8$clinit
            r11 = 3
            long r11 = r11 & r4
            int r9 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x01a1
            r11 = 100
            long r11 = r4 % r11
            int r9 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x01a2
            r11 = 400(0x190, double:1.976E-321)
            long r4 = r4 % r11
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x01a1
            goto L_0x01a2
        L_0x01a1:
            r10 = 0
        L_0x01a2:
            int r1 = r1.length(r10)
            goto L_0x01a9
        L_0x01a7:
            r1 = 30
        L_0x01a9:
            int r0 = java.lang.Math.min(r0, r1)
        L_0x01ad:
            j$.time.LocalDate r0 = p009j$.time.LocalDate.m185of(r2, r3, r0)
            goto L_0x04b6
        L_0x01b3:
            j$.time.temporal.ChronoField r6 = p009j$.time.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH
            boolean r7 = r0.containsKey(r6)
            if (r7 == 0) goto L_0x032f
            j$.time.temporal.ChronoField r7 = p009j$.time.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH
            boolean r9 = r0.containsKey(r7)
            java.lang.String r11 = "Strict mode rejected resolved date as it is in a different month"
            if (r9 == 0) goto L_0x0275
            j$.time.temporal.ValueRange r9 = r2.range()
            java.lang.Object r12 = r0.remove(r2)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            int r2 = r9.checkValidIntValue(r12, r2)
            j$.time.format.ResolverStyle r9 = p009j$.time.format.ResolverStyle.LENIENT
            if (r1 != r9) goto L_0x021d
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r11 = r1.longValue()
            long r11 = p009j$.lang.Iterable.CC.m$4(r11, r4)
            java.lang.Object r1 = r0.remove(r6)
            java.lang.Long r1 = (java.lang.Long) r1
            long r13 = r1.longValue()
            long r13 = p009j$.lang.Iterable.CC.m$4(r13, r4)
            java.lang.Object r0 = r0.remove(r7)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r0 = p009j$.lang.Iterable.CC.m$4(r0, r4)
            j$.time.LocalDate r2 = p009j$.time.LocalDate.m185of(r2, r10, r10)
            j$.time.temporal.ChronoUnit r3 = p009j$.time.temporal.ChronoUnit.MONTHS
            j$.time.LocalDate r2 = r2.plus((long) r11, (p009j$.time.temporal.TemporalUnit) r3)
            j$.time.temporal.ChronoUnit r3 = p009j$.time.temporal.ChronoUnit.WEEKS
            j$.time.LocalDate r2 = r2.plus((long) r13, (p009j$.time.temporal.TemporalUnit) r3)
            j$.time.temporal.ChronoUnit r3 = p009j$.time.temporal.ChronoUnit.DAYS
            j$.time.LocalDate r0 = r2.plus((long) r0, (p009j$.time.temporal.TemporalUnit) r3)
            goto L_0x04b6
        L_0x021d:
            j$.time.temporal.ValueRange r4 = r3.range()
            java.lang.Object r5 = r0.remove(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r12 = r5.longValue()
            int r4 = r4.checkValidIntValue(r12, r3)
            j$.time.temporal.ValueRange r5 = r6.range()
            java.lang.Object r9 = r0.remove(r6)
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            int r5 = r5.checkValidIntValue(r12, r6)
            j$.time.temporal.ValueRange r6 = r7.range()
            java.lang.Object r0 = r0.remove(r7)
            java.lang.Long r0 = (java.lang.Long) r0
            long r12 = r0.longValue()
            int r0 = r6.checkValidIntValue(r12, r7)
            j$.time.LocalDate r2 = p009j$.time.LocalDate.m185of(r2, r4, r10)
            int r5 = r5 - r10
            int r5 = r5 * 7
            int r0 = r0 - r10
            int r0 = r0 + r5
            long r5 = (long) r0
            j$.time.temporal.ChronoUnit r0 = p009j$.time.temporal.ChronoUnit.DAYS
            j$.time.LocalDate r0 = r2.plus((long) r5, (p009j$.time.temporal.TemporalUnit) r0)
            j$.time.format.ResolverStyle r2 = p009j$.time.format.ResolverStyle.STRICT
            if (r1 != r2) goto L_0x04b6
            int r1 = r0.get(r3)
            if (r1 != r4) goto L_0x026f
            goto L_0x04b6
        L_0x026f:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            r0.<init>(r11)
            throw r0
        L_0x0275:
            j$.time.temporal.ChronoField r7 = p009j$.time.temporal.ChronoField.DAY_OF_WEEK
            boolean r9 = r0.containsKey(r7)
            if (r9 == 0) goto L_0x032f
            j$.time.temporal.ValueRange r9 = r2.range()
            java.lang.Object r12 = r0.remove(r2)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            int r2 = r9.checkValidIntValue(r12, r2)
            j$.time.format.ResolverStyle r9 = p009j$.time.format.ResolverStyle.LENIENT
            if (r1 != r9) goto L_0x02ca
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r11 = r1.longValue()
            long r11 = p009j$.lang.Iterable.CC.m$4(r11, r4)
            java.lang.Object r1 = r0.remove(r6)
            java.lang.Long r1 = (java.lang.Long) r1
            long r13 = r1.longValue()
            long r13 = p009j$.lang.Iterable.CC.m$4(r13, r4)
            java.lang.Object r0 = r0.remove(r7)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r6 = p009j$.lang.Iterable.CC.m$4(r0, r4)
            j$.time.LocalDate r1 = p009j$.time.LocalDate.m185of(r2, r10, r10)
            r0 = r15
            r2 = r11
            r4 = r13
            j$.time.chrono.ChronoLocalDate r0 = r0.resolveAligned(r1, r2, r4, r6)
            goto L_0x04b6
        L_0x02ca:
            j$.time.temporal.ValueRange r4 = r3.range()
            java.lang.Object r5 = r0.remove(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r12 = r5.longValue()
            int r4 = r4.checkValidIntValue(r12, r3)
            j$.time.temporal.ValueRange r5 = r6.range()
            java.lang.Object r9 = r0.remove(r6)
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            int r5 = r5.checkValidIntValue(r12, r6)
            j$.time.temporal.ValueRange r6 = r7.range()
            java.lang.Object r0 = r0.remove(r7)
            java.lang.Long r0 = (java.lang.Long) r0
            long r12 = r0.longValue()
            int r0 = r6.checkValidIntValue(r12, r7)
            j$.time.LocalDate r2 = p009j$.time.LocalDate.m185of(r2, r4, r10)
            int r5 = r5 - r10
            int r5 = r5 * 7
            long r5 = (long) r5
            j$.time.temporal.ChronoUnit r7 = p009j$.time.temporal.ChronoUnit.DAYS
            j$.time.LocalDate r2 = r2.plus((long) r5, (p009j$.time.temporal.TemporalUnit) r7)
            j$.time.DayOfWeek r0 = p009j$.time.DayOfWeek.m184of(r0)
            j$.time.temporal.TemporalAdjuster r0 = p009j$.time.temporal.TemporalAdjusters.nextOrSame(r0)
            j$.time.chrono.ChronoLocalDate r0 = r2.with((p009j$.time.temporal.TemporalAdjuster) r0)
            j$.time.format.ResolverStyle r2 = p009j$.time.format.ResolverStyle.STRICT
            if (r1 != r2) goto L_0x04b6
            r1 = r0
            j$.time.LocalDate r1 = (p009j$.time.LocalDate) r1
            int r1 = r1.get(r3)
            if (r1 != r4) goto L_0x0329
            goto L_0x04b6
        L_0x0329:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            r0.<init>(r11)
            throw r0
        L_0x032f:
            j$.time.temporal.ChronoField r3 = p009j$.time.temporal.ChronoField.DAY_OF_YEAR
            boolean r6 = r0.containsKey(r3)
            if (r6 == 0) goto L_0x037f
            j$.time.temporal.ValueRange r6 = r2.range()
            java.lang.Object r7 = r0.remove(r2)
            java.lang.Long r7 = (java.lang.Long) r7
            long r11 = r7.longValue()
            int r2 = r6.checkValidIntValue(r11, r2)
            j$.time.format.ResolverStyle r6 = p009j$.time.format.ResolverStyle.LENIENT
            if (r1 != r6) goto L_0x0367
            java.lang.Object r0 = r0.remove(r3)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r0 = p009j$.lang.Iterable.CC.m$4(r0, r4)
            j$.time.LocalDate r2 = p009j$.time.LocalDate.ofYearDay(r2, r10)
            j$.time.temporal.ChronoUnit r3 = p009j$.time.temporal.ChronoUnit.DAYS
            j$.time.LocalDate r0 = r2.plus((long) r0, (p009j$.time.temporal.TemporalUnit) r3)
            goto L_0x04b6
        L_0x0367:
            j$.time.temporal.ValueRange r1 = r3.range()
            java.lang.Object r0 = r0.remove(r3)
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            int r0 = r1.checkValidIntValue(r4, r3)
            j$.time.LocalDate r0 = p009j$.time.LocalDate.ofYearDay(r2, r0)
            goto L_0x04b6
        L_0x037f:
            j$.time.temporal.ChronoField r3 = p009j$.time.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR
            boolean r6 = r0.containsKey(r3)
            if (r6 == 0) goto L_0x04b5
            j$.time.temporal.ChronoField r6 = p009j$.time.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR
            boolean r7 = r0.containsKey(r6)
            java.lang.String r9 = "Strict mode rejected resolved date as it is in a different year"
            if (r7 == 0) goto L_0x041b
            j$.time.temporal.ValueRange r7 = r2.range()
            java.lang.Object r11 = r0.remove(r2)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            int r7 = r7.checkValidIntValue(r11, r2)
            j$.time.format.ResolverStyle r11 = p009j$.time.format.ResolverStyle.LENIENT
            if (r1 != r11) goto L_0x03d5
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r1 = p009j$.lang.Iterable.CC.m$4(r1, r4)
            java.lang.Object r0 = r0.remove(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r11 = r0.longValue()
            long r3 = p009j$.lang.Iterable.CC.m$4(r11, r4)
            j$.time.LocalDate r0 = p009j$.time.LocalDate.ofYearDay(r7, r10)
            j$.time.temporal.ChronoUnit r5 = p009j$.time.temporal.ChronoUnit.WEEKS
            j$.time.LocalDate r0 = r0.plus((long) r1, (p009j$.time.temporal.TemporalUnit) r5)
            j$.time.temporal.ChronoUnit r1 = p009j$.time.temporal.ChronoUnit.DAYS
            j$.time.LocalDate r0 = r0.plus((long) r3, (p009j$.time.temporal.TemporalUnit) r1)
            goto L_0x04b6
        L_0x03d5:
            j$.time.temporal.ValueRange r4 = r3.range()
            java.lang.Object r5 = r0.remove(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            int r3 = r4.checkValidIntValue(r11, r3)
            j$.time.temporal.ValueRange r4 = r6.range()
            java.lang.Object r0 = r0.remove(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r11 = r0.longValue()
            int r0 = r4.checkValidIntValue(r11, r6)
            j$.time.LocalDate r4 = p009j$.time.LocalDate.ofYearDay(r7, r10)
            int r3 = r3 - r10
            int r3 = r3 * 7
            int r0 = r0 - r10
            int r0 = r0 + r3
            long r5 = (long) r0
            j$.time.temporal.ChronoUnit r0 = p009j$.time.temporal.ChronoUnit.DAYS
            j$.time.LocalDate r0 = r4.plus((long) r5, (p009j$.time.temporal.TemporalUnit) r0)
            j$.time.format.ResolverStyle r3 = p009j$.time.format.ResolverStyle.STRICT
            if (r1 != r3) goto L_0x04b6
            int r1 = r0.get(r2)
            if (r1 != r7) goto L_0x0415
            goto L_0x04b6
        L_0x0415:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            r0.<init>(r9)
            throw r0
        L_0x041b:
            j$.time.temporal.ChronoField r6 = p009j$.time.temporal.ChronoField.DAY_OF_WEEK
            boolean r7 = r0.containsKey(r6)
            if (r7 == 0) goto L_0x04b5
            j$.time.temporal.ValueRange r7 = r2.range()
            java.lang.Object r11 = r0.remove(r2)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            int r7 = r7.checkValidIntValue(r11, r2)
            j$.time.format.ResolverStyle r11 = p009j$.time.format.ResolverStyle.LENIENT
            if (r1 != r11) goto L_0x0463
            java.lang.Object r1 = r0.remove(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r11 = p009j$.lang.Iterable.CC.m$4(r1, r4)
            java.lang.Object r0 = r0.remove(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r13 = p009j$.lang.Iterable.CC.m$4(r0, r4)
            j$.time.LocalDate r1 = p009j$.time.LocalDate.ofYearDay(r7, r10)
            r2 = 0
            r0 = r15
            r4 = r11
            r6 = r13
            j$.time.chrono.ChronoLocalDate r0 = r0.resolveAligned(r1, r2, r4, r6)
            goto L_0x04b6
        L_0x0463:
            j$.time.temporal.ValueRange r4 = r3.range()
            java.lang.Object r5 = r0.remove(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            int r3 = r4.checkValidIntValue(r11, r3)
            j$.time.temporal.ValueRange r4 = r6.range()
            java.lang.Object r0 = r0.remove(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r11 = r0.longValue()
            int r0 = r4.checkValidIntValue(r11, r6)
            j$.time.LocalDate r4 = p009j$.time.LocalDate.ofYearDay(r7, r10)
            int r3 = r3 - r10
            int r3 = r3 * 7
            long r5 = (long) r3
            j$.time.temporal.ChronoUnit r3 = p009j$.time.temporal.ChronoUnit.DAYS
            j$.time.LocalDate r3 = r4.plus((long) r5, (p009j$.time.temporal.TemporalUnit) r3)
            j$.time.DayOfWeek r0 = p009j$.time.DayOfWeek.m184of(r0)
            j$.time.temporal.TemporalAdjuster r0 = p009j$.time.temporal.TemporalAdjusters.nextOrSame(r0)
            j$.time.chrono.ChronoLocalDate r0 = r3.with((p009j$.time.temporal.TemporalAdjuster) r0)
            j$.time.format.ResolverStyle r3 = p009j$.time.format.ResolverStyle.STRICT
            if (r1 != r3) goto L_0x04b6
            r1 = r0
            j$.time.LocalDate r1 = (p009j$.time.LocalDate) r1
            int r1 = r1.get(r2)
            if (r1 != r7) goto L_0x04af
            goto L_0x04b6
        L_0x04af:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            r0.<init>(r9)
            throw r0
        L_0x04b5:
            r0 = 0
        L_0x04b6:
            j$.time.LocalDate r0 = (p009j$.time.LocalDate) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.chrono.IsoChronology.resolveDate(java.util.Map, j$.time.format.ResolverStyle):j$.time.chrono.ChronoLocalDate");
    }
}
