package p009j$.time.temporal;

import com.google.android.exoplayer2.C0963C;

/* renamed from: j$.time.temporal.ChronoField */
public enum ChronoField implements TemporalField {
    NANO_OF_SECOND("NanoOfSecond", r4, r17, ValueRange.m196of(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", r4, r27, ValueRange.m196of(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", r4, r17, ValueRange.m196of(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", r4, r27, ValueRange.m196of(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", r4, r17, ValueRange.m196of(0, 999)),
    MILLI_OF_DAY("MilliOfDay", r4, r27, ValueRange.m196of(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", r17, r32, ValueRange.m196of(0, 59), "second"),
    SECOND_OF_DAY("SecondOfDay", r17, r5, ValueRange.m196of(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", r32, r13, ValueRange.m196of(0, 59), "minute"),
    MINUTE_OF_DAY("MinuteOfDay", r32, r5, ValueRange.m196of(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", r13, r16, ValueRange.m196of(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", r4, r16, ValueRange.m196of(1, 12)),
    HOUR_OF_DAY("HourOfDay", r13, r24, ValueRange.m196of(0, 23), "hour"),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", r4, r27, ValueRange.m196of(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", r16, r24, ValueRange.m196of(0, 1), "dayperiod"),
    DAY_OF_WEEK("DayOfWeek", r23, r38, ValueRange.m196of(1, 7), "weekday"),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", r4, r5, ValueRange.m196of(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", r4, r5, ValueRange.m196of(1, 7)),
    DAY_OF_MONTH("DayOfMonth", r23, r15, ValueRange.m197of(1, 28, 31), "day"),
    DAY_OF_YEAR("DayOfYear", r4, r42, ValueRange.m197of(1, 365, 366)),
    EPOCH_DAY("EpochDay", r4, r44, ValueRange.m196of(-365249999634L, 365249999634L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", r4, r15, ValueRange.m197of(1, 4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", r4, r42, ValueRange.m196of(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", r15, r42, ValueRange.m196of(1, 12), "month"),
    PROLEPTIC_MONTH("ProlepticMonth", r15, r44, ValueRange.m196of(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", r42, r5, ValueRange.m197of(1, 999999999, C0963C.NANOS_PER_SECOND)),
    YEAR("Year", r42, r24, ValueRange.m196of(-999999999, 999999999), "year"),
    ERA("Era", ChronoUnit.ERAS, r24, ValueRange.m196of(0, 1), "era"),
    INSTANT_SECONDS("InstantSeconds", r4, r5, ValueRange.m196of(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", r4, r5, ValueRange.m196of(-64800, 64800));
    
    private final String name;
    private final ValueRange range;

    private ChronoField(String str, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
        this.name = str;
        this.range = valueRange;
    }

    private ChronoField(String str, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange, String str2) {
        this.name = str;
        this.range = valueRange;
    }

    public Temporal adjustInto(Temporal temporal, long j) {
        return temporal.with(this, j);
    }

    public int checkValidIntValue(long j) {
        return this.range.checkValidIntValue(j, this);
    }

    public long checkValidValue(long j) {
        this.range.checkValidValue(j, this);
        return j;
    }

    public long getFrom(TemporalAccessor temporalAccessor) {
        return temporalAccessor.getLong(this);
    }

    public boolean isDateBased() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
        return temporalAccessor.isSupported(this);
    }

    public boolean isTimeBased() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    public ValueRange range() {
        return this.range;
    }

    public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
        return temporalAccessor.range(this);
    }

    public String toString() {
        return this.name;
    }
}
