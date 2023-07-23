package p009j$.time.temporal;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import p009j$.lang.Iterable;
import p009j$.time.Clock$SystemClock$$ExternalSyntheticOutline0;
import p009j$.time.DateTimeException;
import p009j$.time.DayOfWeek;
import p009j$.time.LocalDate;
import p009j$.time.chrono.ChronoLocalDate;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.format.ResolverStyle;
import p009j$.util.concurrent.ConcurrentHashMap;

/* renamed from: j$.time.temporal.WeekFields */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap CACHE = new ConcurrentHashMap(4, 0.75f, 2);
    public static final TemporalUnit WEEK_BASED_YEARS = IsoFields.WEEK_BASED_YEARS;
    /* access modifiers changed from: private */
    public final transient TemporalField dayOfWeek = ComputedDayOfField.ofDayOfWeekField(this);
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    /* access modifiers changed from: private */
    public final transient TemporalField weekBasedYear;
    private final transient TemporalField weekOfMonth = ComputedDayOfField.ofWeekOfMonthField(this);
    /* access modifiers changed from: private */
    public final transient TemporalField weekOfWeekBasedYear;

    /* renamed from: j$.time.temporal.WeekFields$ComputedDayOfField */
    class ComputedDayOfField implements TemporalField {
        private static final ValueRange DAY_OF_WEEK_RANGE = ValueRange.m196of(1, 7);
        private static final ValueRange WEEK_OF_MONTH_RANGE = ValueRange.m198of(0, 1, 4, 6);
        private static final ValueRange WEEK_OF_WEEK_BASED_YEAR_RANGE = ValueRange.m197of(1, 52, 53);
        private static final ValueRange WEEK_OF_YEAR_RANGE = ValueRange.m198of(0, 1, 52, 54);
        private final TemporalUnit baseUnit;
        private final String name;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;
        private final WeekFields weekDef;

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.name = str;
            this.weekDef = weekFields;
            this.baseUnit = temporalUnit;
            this.rangeUnit = temporalUnit2;
            this.range = valueRange;
        }

        private int computeWeek(int i, int i2) {
            return ((i2 - 1) + (i + 7)) / 7;
        }

        private int localizedDayOfWeek(TemporalAccessor temporalAccessor) {
            return TemporalAdjusters.m195m(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
        }

        private int localizedWeekBasedYear(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.YEAR);
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            int i2 = temporalAccessor.get(chronoField);
            int startOfWeekOffset = startOfWeekOffset(i2, localizedDayOfWeek);
            int computeWeek = computeWeek(startOfWeekOffset, i2);
            if (computeWeek == 0) {
                return i - 1;
            }
            return computeWeek >= computeWeek(startOfWeekOffset, this.weekDef.getMinimalDaysInFirstWeek() + ((int) temporalAccessor.range(chronoField).getMaximum())) ? i + 1 : i;
        }

        private long localizedWeekOfMonth(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
            return (long) computeWeek(startOfWeekOffset(i, localizedDayOfWeek), i);
        }

        private int localizedWeekOfWeekBasedYear(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            int i = temporalAccessor.get(chronoField);
            int startOfWeekOffset = startOfWeekOffset(i, localizedDayOfWeek);
            int computeWeek = computeWeek(startOfWeekOffset, i);
            if (computeWeek == 0) {
                IsoChronology isoChronology = (IsoChronology) Chronology.CC.from(temporalAccessor);
                return localizedWeekOfWeekBasedYear(LocalDate.from(temporalAccessor).minus((long) i, ChronoUnit.DAYS));
            } else if (computeWeek <= 50) {
                return computeWeek;
            } else {
                int computeWeek2 = computeWeek(startOfWeekOffset, this.weekDef.getMinimalDaysInFirstWeek() + ((int) temporalAccessor.range(chronoField).getMaximum()));
                return computeWeek >= computeWeek2 ? (computeWeek - computeWeek2) + 1 : computeWeek;
            }
        }

        private long localizedWeekOfYear(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
            return (long) computeWeek(startOfWeekOffset(i, localizedDayOfWeek), i);
        }

        static ComputedDayOfField ofDayOfWeekField(WeekFields weekFields) {
            return new ComputedDayOfField("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, DAY_OF_WEEK_RANGE);
        }

        private ChronoLocalDate ofWeekBasedYear(Chronology chronology, int i, int i2, int i3) {
            Objects.requireNonNull((IsoChronology) chronology);
            LocalDate of = LocalDate.m185of(i, 1, 1);
            int startOfWeekOffset = startOfWeekOffset(1, localizedDayOfWeek(of));
            return of.plus((long) (((Math.min(i2, computeWeek(startOfWeekOffset, this.weekDef.getMinimalDaysInFirstWeek() + (of.isLeapYear() ? 366 : 365)) - 1) - 1) * 7) + (i3 - 1) + (-startOfWeekOffset)), (TemporalUnit) ChronoUnit.DAYS);
        }

        static ComputedDayOfField ofWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.WEEK_BASED_YEARS, ChronoUnit.FOREVER, ChronoField.YEAR.range());
        }

        static ComputedDayOfField ofWeekOfMonthField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, WEEK_OF_MONTH_RANGE);
        }

        static ComputedDayOfField ofWeekOfWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.WEEK_BASED_YEARS, WEEK_OF_WEEK_BASED_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekOfYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, WEEK_OF_YEAR_RANGE);
        }

        private ValueRange rangeByWeek(TemporalAccessor temporalAccessor, TemporalField temporalField) {
            int startOfWeekOffset = startOfWeekOffset(temporalAccessor.get(temporalField), localizedDayOfWeek(temporalAccessor));
            ValueRange range2 = temporalAccessor.range(temporalField);
            return ValueRange.m196of((long) computeWeek(startOfWeekOffset, (int) range2.getMinimum()), (long) computeWeek(startOfWeekOffset, (int) range2.getMaximum()));
        }

        private ValueRange rangeWeekOfWeekBasedYear(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            if (!temporalAccessor.isSupported(chronoField)) {
                return WEEK_OF_YEAR_RANGE;
            }
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(chronoField);
            int startOfWeekOffset = startOfWeekOffset(i, localizedDayOfWeek);
            int computeWeek = computeWeek(startOfWeekOffset, i);
            if (computeWeek == 0) {
                IsoChronology isoChronology = (IsoChronology) Chronology.CC.from(temporalAccessor);
                return rangeWeekOfWeekBasedYear(LocalDate.from(temporalAccessor).minus((long) (i + 7), ChronoUnit.DAYS));
            }
            int maximum = (int) temporalAccessor.range(chronoField).getMaximum();
            int computeWeek2 = computeWeek(startOfWeekOffset, this.weekDef.getMinimalDaysInFirstWeek() + maximum);
            if (computeWeek < computeWeek2) {
                return ValueRange.m196of(1, (long) (computeWeek2 - 1));
            }
            IsoChronology isoChronology2 = (IsoChronology) Chronology.CC.from(temporalAccessor);
            return rangeWeekOfWeekBasedYear(LocalDate.from(temporalAccessor).plus((long) ((maximum - i) + 1 + 7), (TemporalUnit) ChronoUnit.DAYS));
        }

        private int startOfWeekOffset(int i, int i2) {
            int m = TemporalAdjusters.m195m(i - i2, 7);
            return m + 1 > this.weekDef.getMinimalDaysInFirstWeek() ? 7 - m : -m;
        }

        public Temporal adjustInto(Temporal temporal, long j) {
            int checkValidIntValue = this.range.checkValidIntValue(j, this);
            int i = temporal.get(this);
            if (checkValidIntValue == i) {
                return temporal;
            }
            if (this.rangeUnit != ChronoUnit.FOREVER) {
                return temporal.plus((long) (checkValidIntValue - i), this.baseUnit);
            }
            int i2 = temporal.get(this.weekDef.dayOfWeek);
            return ofWeekBasedYear(Chronology.CC.from(temporal), (int) j, temporal.get(this.weekDef.weekOfWeekBasedYear), i2);
        }

        public long getFrom(TemporalAccessor temporalAccessor) {
            int i;
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                i = localizedDayOfWeek(temporalAccessor);
            } else if (temporalUnit == ChronoUnit.MONTHS) {
                return localizedWeekOfMonth(temporalAccessor);
            } else {
                if (temporalUnit == ChronoUnit.YEARS) {
                    return localizedWeekOfYear(temporalAccessor);
                }
                if (temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                    i = localizedWeekOfWeekBasedYear(temporalAccessor);
                } else if (temporalUnit == ChronoUnit.FOREVER) {
                    i = localizedWeekBasedYear(temporalAccessor);
                } else {
                    StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("unreachable, rangeUnit: ");
                    m.append(this.rangeUnit);
                    m.append(", this: ");
                    m.append(this);
                    throw new IllegalStateException(m.toString());
                }
            }
            return (long) i;
        }

        public boolean isDateBased() {
            return true;
        }

        public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
            ChronoField chronoField;
            if (!temporalAccessor.isSupported(ChronoField.DAY_OF_WEEK)) {
                return false;
            }
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return true;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                chronoField = ChronoField.DAY_OF_MONTH;
            } else if (temporalUnit == ChronoUnit.YEARS || temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                chronoField = ChronoField.DAY_OF_YEAR;
            } else if (temporalUnit != ChronoUnit.FOREVER) {
                return false;
            } else {
                chronoField = ChronoField.YEAR;
            }
            return temporalAccessor.isSupported(chronoField);
        }

        public boolean isTimeBased() {
            return false;
        }

        public ValueRange range() {
            return this.range;
        }

        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return this.range;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                return rangeByWeek(temporalAccessor, ChronoField.DAY_OF_MONTH);
            }
            if (temporalUnit == ChronoUnit.YEARS) {
                return rangeByWeek(temporalAccessor, ChronoField.DAY_OF_YEAR);
            }
            if (temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                return rangeWeekOfWeekBasedYear(temporalAccessor);
            }
            if (temporalUnit == ChronoUnit.FOREVER) {
                return ChronoField.YEAR.range();
            }
            StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("unreachable, rangeUnit: ");
            m.append(this.rangeUnit);
            m.append(", this: ");
            m.append(this);
            throw new IllegalStateException(m.toString());
        }

        public TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            ChronoLocalDate chronoLocalDate;
            LocalDate localDate;
            LocalDate localDate2;
            Map map2 = map;
            ResolverStyle resolverStyle2 = resolverStyle;
            long longValue = ((Long) map2.get(this)).longValue();
            int m = Iterable.CC.m181m(longValue);
            TemporalUnit temporalUnit = this.rangeUnit;
            ChronoUnit chronoUnit = ChronoUnit.WEEKS;
            if (temporalUnit == chronoUnit) {
                map2.remove(this);
                map2.put(ChronoField.DAY_OF_WEEK, Long.valueOf((long) (TemporalAdjusters.m195m((this.range.checkValidIntValue(longValue, this) - 1) + (this.weekDef.getFirstDayOfWeek().getValue() - 1), 7) + 1)));
            } else {
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                if (map2.containsKey(chronoField)) {
                    int m2 = TemporalAdjusters.m195m(chronoField.checkValidIntValue(((Long) map2.get(chronoField)).longValue()) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
                    Chronology from = Chronology.CC.from(temporalAccessor);
                    ChronoField chronoField2 = ChronoField.YEAR;
                    if (map2.containsKey(chronoField2)) {
                        int checkValidIntValue = chronoField2.checkValidIntValue(((Long) map2.get(chronoField2)).longValue());
                        TemporalUnit temporalUnit2 = this.rangeUnit;
                        ChronoUnit chronoUnit2 = ChronoUnit.MONTHS;
                        if (temporalUnit2 == chronoUnit2) {
                            ChronoField chronoField3 = ChronoField.MONTH_OF_YEAR;
                            if (map2.containsKey(chronoField3)) {
                                long longValue2 = ((Long) map2.get(chronoField3)).longValue();
                                long j = (long) m;
                                if (resolverStyle2 == ResolverStyle.LENIENT) {
                                    IsoChronology isoChronology = (IsoChronology) from;
                                    LocalDate plus = LocalDate.m185of(checkValidIntValue, 1, 1).plus(Iterable.CC.m$4(longValue2, 1), (TemporalUnit) chronoUnit2);
                                    localDate2 = plus.plus(Iterable.CC.m182m(Iterable.CC.m$3(Iterable.CC.m$4(j, localizedWeekOfMonth(plus)), 7), (long) (m2 - localizedDayOfWeek(plus))), (TemporalUnit) ChronoUnit.DAYS);
                                } else {
                                    IsoChronology isoChronology2 = (IsoChronology) from;
                                    LocalDate of = LocalDate.m185of(checkValidIntValue, chronoField3.checkValidIntValue(longValue2), 1);
                                    LocalDate plus2 = of.plus((long) ((((int) (((long) this.range.checkValidIntValue(j, this)) - localizedWeekOfMonth(of))) * 7) + (m2 - localizedDayOfWeek(of))), (TemporalUnit) ChronoUnit.DAYS);
                                    if (resolverStyle2 != ResolverStyle.STRICT || plus2.getLong(chronoField3) == longValue2) {
                                        localDate2 = plus2;
                                    } else {
                                        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                                    }
                                }
                                map2.remove(this);
                                map2.remove(chronoField2);
                                map2.remove(chronoField3);
                                map2.remove(chronoField);
                                return localDate2;
                            }
                        }
                        if (this.rangeUnit == ChronoUnit.YEARS) {
                            long j2 = (long) m;
                            IsoChronology isoChronology3 = (IsoChronology) from;
                            LocalDate of2 = LocalDate.m185of(checkValidIntValue, 1, 1);
                            if (resolverStyle2 == ResolverStyle.LENIENT) {
                                localDate = of2.plus(Iterable.CC.m182m(Iterable.CC.m$3(Iterable.CC.m$4(j2, localizedWeekOfYear(of2)), 7), (long) (m2 - localizedDayOfWeek(of2))), (TemporalUnit) ChronoUnit.DAYS);
                            } else {
                                LocalDate plus3 = of2.plus((long) ((((int) (((long) this.range.checkValidIntValue(j2, this)) - localizedWeekOfYear(of2))) * 7) + (m2 - localizedDayOfWeek(of2))), (TemporalUnit) ChronoUnit.DAYS);
                                if (resolverStyle2 != ResolverStyle.STRICT || plus3.getLong(chronoField2) == ((long) checkValidIntValue)) {
                                    localDate = plus3;
                                } else {
                                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
                                }
                            }
                            map2.remove(this);
                            map2.remove(chronoField2);
                            map2.remove(chronoField);
                            return localDate;
                        }
                    } else {
                        TemporalUnit temporalUnit3 = this.rangeUnit;
                        if ((temporalUnit3 == WeekFields.WEEK_BASED_YEARS || temporalUnit3 == ChronoUnit.FOREVER) && map2.containsKey(this.weekDef.weekBasedYear) && map2.containsKey(this.weekDef.weekOfWeekBasedYear)) {
                            int checkValidIntValue2 = this.weekDef.weekBasedYear.range().checkValidIntValue(((Long) map2.get(this.weekDef.weekBasedYear)).longValue(), this.weekDef.weekBasedYear);
                            if (resolverStyle2 == ResolverStyle.LENIENT) {
                                chronoLocalDate = ((LocalDate) ofWeekBasedYear(from, checkValidIntValue2, 1, m2)).plus(Iterable.CC.m$4(((Long) map2.get(this.weekDef.weekOfWeekBasedYear)).longValue(), 1), (TemporalUnit) chronoUnit);
                            } else {
                                ChronoLocalDate ofWeekBasedYear = ofWeekBasedYear(from, checkValidIntValue2, this.weekDef.weekOfWeekBasedYear.range().checkValidIntValue(((Long) map2.get(this.weekDef.weekOfWeekBasedYear)).longValue(), this.weekDef.weekOfWeekBasedYear), m2);
                                if (resolverStyle2 != ResolverStyle.STRICT || localizedWeekBasedYear(ofWeekBasedYear) == checkValidIntValue2) {
                                    chronoLocalDate = ofWeekBasedYear;
                                } else {
                                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different week-based-year");
                                }
                            }
                            map2.remove(this);
                            map2.remove(this.weekDef.weekBasedYear);
                            map2.remove(this.weekDef.weekOfWeekBasedYear);
                            map2.remove(chronoField);
                            return chronoLocalDate;
                        }
                    }
                }
            }
            return null;
        }

        public String toString() {
            return this.name + "[" + this.weekDef.toString() + "]";
        }
    }

    static {
        new WeekFields(DayOfWeek.MONDAY, 4);
        m199of(DayOfWeek.SUNDAY, 1);
    }

    private WeekFields(DayOfWeek dayOfWeek2, int i) {
        ComputedDayOfField.ofWeekOfYearField(this);
        this.weekOfWeekBasedYear = ComputedDayOfField.ofWeekOfWeekBasedYearField(this);
        this.weekBasedYear = ComputedDayOfField.ofWeekBasedYearField(this);
        Objects.requireNonNull(dayOfWeek2, "firstDayOfWeek");
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.firstDayOfWeek = dayOfWeek2;
        this.minimalDays = i;
    }

    /* renamed from: of */
    public static WeekFields m199of(DayOfWeek dayOfWeek2, int i) {
        String str = dayOfWeek2.toString() + i;
        ConcurrentMap concurrentMap = CACHE;
        WeekFields weekFields = (WeekFields) concurrentMap.get(str);
        if (weekFields != null) {
            return weekFields;
        }
        concurrentMap.putIfAbsent(str, new WeekFields(dayOfWeek2, i));
        return (WeekFields) concurrentMap.get(str);
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("WeekFields[");
        m.append(this.firstDayOfWeek);
        m.append(',');
        m.append(this.minimalDays);
        m.append(']');
        return m.toString();
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }
}
