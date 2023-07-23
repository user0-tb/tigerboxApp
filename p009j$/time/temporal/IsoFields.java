package p009j$.time.temporal;

import java.util.Map;
import org.spongycastle.crypto.tls.CipherSuite;
import p009j$.lang.Iterable;
import p009j$.time.DateTimeException;
import p009j$.time.DayOfWeek;
import p009j$.time.Duration;
import p009j$.time.LocalDate;
import p009j$.time.chrono.AbstractChronology;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.format.ResolverStyle;

/* renamed from: j$.time.temporal.IsoFields */
public abstract class IsoFields {
    public static final TemporalField QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
    public static final TemporalField WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
    public static final TemporalUnit WEEK_BASED_YEARS = Unit.WEEK_BASED_YEARS;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: j$.time.temporal.IsoFields$1 */
    abstract /* synthetic */ class C14221 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$IsoFields$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                j$.time.temporal.IsoFields$Unit[] r0 = p009j$.time.temporal.IsoFields.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$time$temporal$IsoFields$Unit = r0
                j$.time.temporal.IsoFields$Unit r1 = p009j$.time.temporal.IsoFields.Unit.WEEK_BASED_YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$time$temporal$IsoFields$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                j$.time.temporal.IsoFields$Unit r1 = p009j$.time.temporal.IsoFields.Unit.QUARTER_YEARS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.temporal.IsoFields.C14221.<clinit>():void");
        }
    }

    /* renamed from: j$.time.temporal.IsoFields$Field */
    enum Field implements TemporalField {
        DAY_OF_QUARTER {
            public Temporal adjustInto(Temporal temporal, long j) {
                long from = getFrom(temporal);
                range().checkValidValue(j, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return temporal.with(chronoField, (j - from) + temporal.getLong(chronoField));
            }

            public long getFrom(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return (long) (temporalAccessor.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((temporalAccessor.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? 4 : 0)]);
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
            }

            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR) && temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && temporalAccessor.isSupported(ChronoField.YEAR)) {
                    if (((AbstractChronology) Chronology.CC.from(temporalAccessor)).equals(IsoChronology.INSTANCE)) {
                        return true;
                    }
                }
                return false;
            }

            public ValueRange range() {
                return ValueRange.m197of(1, 90, 92);
            }

            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    long j = temporalAccessor.getLong(Field.QUARTER_OF_YEAR);
                    if (j != 1) {
                        return j == 2 ? ValueRange.m196of(1, 91) : (j == 3 || j == 4) ? ValueRange.m196of(1, 92) : range();
                    }
                    return IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? ValueRange.m196of(1, 91) : ValueRange.m196of(1, 90);
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
            }

            public TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate localDate;
                long j;
                ChronoField chronoField = ChronoField.YEAR;
                Long l = (Long) map.get(chronoField);
                Field field = Field.QUARTER_OF_YEAR;
                Long l2 = (Long) map.get(field);
                if (l == null || l2 == null) {
                    return null;
                }
                int checkValidIntValue = chronoField.checkValidIntValue(l.longValue());
                long longValue = ((Long) map.get(Field.DAY_OF_QUARTER)).longValue();
                Field.access$300(temporalAccessor);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    localDate = LocalDate.m185of(checkValidIntValue, 1, 1).plusMonths(Iterable.CC.m$3(Iterable.CC.m$4(l2.longValue(), 1), 3));
                    j = Iterable.CC.m$4(longValue, 1);
                } else {
                    localDate = LocalDate.m185of(checkValidIntValue, ((field.range().checkValidIntValue(l2.longValue(), field) - 1) * 3) + 1, 1);
                    if (longValue < 1 || longValue > 90) {
                        (resolverStyle == ResolverStyle.STRICT ? rangeRefinedBy(localDate) : range()).checkValidValue(longValue, this);
                    }
                    j = longValue - 1;
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(field);
                return localDate.plusDays(j);
            }

            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR {
            public Temporal adjustInto(Temporal temporal, long j) {
                long from = getFrom(temporal);
                range().checkValidValue(j, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return temporal.with(chronoField, ((j - from) * 3) + temporal.getLong(chronoField));
            }

            public long getFrom(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return (temporalAccessor.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR)) {
                    if (((AbstractChronology) Chronology.CC.from(temporalAccessor)).equals(IsoChronology.INSTANCE)) {
                        return true;
                    }
                }
                return false;
            }

            public ValueRange range() {
                return ValueRange.m196of(1, 4);
            }

            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            public Temporal adjustInto(Temporal temporal, long j) {
                range().checkValidValue(j, this);
                return temporal.plus(Iterable.CC.m$4(j, getFrom(temporal)), ChronoUnit.WEEKS);
            }

            public long getFrom(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return (long) Field.access$500(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(ChronoField.EPOCH_DAY)) {
                    if (((AbstractChronology) Chronology.CC.from(temporalAccessor)).equals(IsoChronology.INSTANCE)) {
                        return true;
                    }
                }
                return false;
            }

            public ValueRange range() {
                return ValueRange.m197of(1, 52, 53);
            }

            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return Field.access$400(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            public TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate localDate;
                long j;
                LocalDate plusWeeks;
                long j2;
                Map map2 = map;
                ResolverStyle resolverStyle2 = resolverStyle;
                Field field = Field.WEEK_BASED_YEAR;
                Long l = (Long) map2.get(field);
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                Long l2 = (Long) map2.get(chronoField);
                if (l == null || l2 == null) {
                    return null;
                }
                int checkValidIntValue = field.range().checkValidIntValue(l.longValue(), field);
                long longValue = ((Long) map2.get(Field.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                Field.access$300(temporalAccessor);
                LocalDate of = LocalDate.m185of(checkValidIntValue, 1, 4);
                if (resolverStyle2 == ResolverStyle.LENIENT) {
                    long longValue2 = l2.longValue();
                    if (longValue2 > 7) {
                        j2 = longValue2 - 1;
                        plusWeeks = of.plusWeeks(j2 / 7);
                    } else {
                        j = 1;
                        if (longValue2 < 1) {
                            plusWeeks = of.plusWeeks(Iterable.CC.m$4(longValue2, 7) / 7);
                            j2 = longValue2 + 6;
                        }
                        localDate = of.plusWeeks(Iterable.CC.m$4(longValue, j)).with((TemporalField) chronoField, longValue2);
                    }
                    of = plusWeeks;
                    j = 1;
                    longValue2 = (j2 % 7) + 1;
                    localDate = of.plusWeeks(Iterable.CC.m$4(longValue, j)).with((TemporalField) chronoField, longValue2);
                } else {
                    int checkValidIntValue2 = chronoField.checkValidIntValue(l2.longValue());
                    if (longValue < 1 || longValue > 52) {
                        (resolverStyle2 == ResolverStyle.STRICT ? Field.access$400(of) : range()).checkValidValue(longValue, this);
                    }
                    localDate = of.plusWeeks(longValue - 1).with((TemporalField) chronoField, (long) checkValidIntValue2);
                }
                map2.remove(this);
                map2.remove(field);
                map2.remove(chronoField);
                return localDate;
            }

            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR {
            public Temporal adjustInto(Temporal temporal, long j) {
                if (isSupportedBy(temporal)) {
                    int checkValidIntValue = range().checkValidIntValue(j, Field.WEEK_BASED_YEAR);
                    LocalDate from = LocalDate.from(temporal);
                    ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                    int i = from.get(chronoField);
                    int access$500 = Field.access$500(from);
                    if (access$500 == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                        access$500 = 52;
                    }
                    LocalDate of = LocalDate.m185of(checkValidIntValue, 1, 4);
                    return temporal.with(of.plusDays((long) (((access$500 - 1) * 7) + (i - of.get(chronoField)))));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            public long getFrom(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return (long) Field.getWeekBasedYear(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(ChronoField.EPOCH_DAY)) {
                    if (((AbstractChronology) Chronology.CC.from(temporalAccessor)).equals(IsoChronology.INSTANCE)) {
                        return true;
                    }
                }
                return false;
            }

            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            public String toString() {
                return "WeekBasedYear";
            }
        };
        
        /* access modifiers changed from: private */
        public static final int[] QUARTER_DAYS = null;

        static {
            QUARTER_DAYS = new int[]{0, 90, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, 273, 0, 91, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, 274};
        }

        Field(C14221 r3) {
        }

        static void access$300(TemporalAccessor temporalAccessor) {
            if (!((AbstractChronology) Chronology.CC.from(temporalAccessor)).equals(IsoChronology.INSTANCE)) {
                throw new DateTimeException("Resolve requires IsoChronology");
            }
        }

        static ValueRange access$400(LocalDate localDate) {
            return ValueRange.m196of(1, (long) getWeekRange(getWeekBasedYear(localDate)));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
            if ((r0 == -3 || (r0 == -2 && r5.isLeapYear())) == false) goto L_0x005a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static int access$500(p009j$.time.LocalDate r5) {
            /*
                j$.time.DayOfWeek r0 = r5.getDayOfWeek()
                int r0 = r0.ordinal()
                int r1 = r5.getDayOfYear()
                r2 = 1
                int r1 = r1 - r2
                int r0 = 3 - r0
                int r0 = r0 + r1
                int r3 = r0 / 7
                int r3 = r3 * 7
                int r0 = r0 - r3
                r3 = -3
                int r0 = r0 + r3
                if (r0 >= r3) goto L_0x001c
                int r0 = r0 + 7
            L_0x001c:
                if (r1 >= r0) goto L_0x003f
                r0 = 180(0xb4, float:2.52E-43)
                j$.time.LocalDate r5 = r5.withDayOfYear(r0)
                r0 = -1
                j$.time.LocalDate r5 = r5.plusYears(r0)
                int r5 = getWeekBasedYear(r5)
                int r5 = getWeekRange(r5)
                long r0 = (long) r5
                r2 = 1
                j$.time.temporal.ValueRange r5 = p009j$.time.temporal.ValueRange.m196of(r2, r0)
                long r0 = r5.getMaximum()
                int r5 = (int) r0
                goto L_0x005b
            L_0x003f:
                int r1 = r1 - r0
                int r1 = r1 / 7
                int r1 = r1 + r2
                r4 = 53
                if (r1 != r4) goto L_0x0059
                if (r0 == r3) goto L_0x0055
                r3 = -2
                if (r0 != r3) goto L_0x0053
                boolean r5 = r5.isLeapYear()
                if (r5 == 0) goto L_0x0053
                goto L_0x0055
            L_0x0053:
                r5 = 0
                goto L_0x0056
            L_0x0055:
                r5 = 1
            L_0x0056:
                if (r5 != 0) goto L_0x0059
                goto L_0x005a
            L_0x0059:
                r2 = r1
            L_0x005a:
                r5 = r2
            L_0x005b:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.temporal.IsoFields.Field.access$500(j$.time.LocalDate):int");
        }

        /* access modifiers changed from: private */
        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                return dayOfYear - localDate.getDayOfWeek().ordinal() < -2 ? year - 1 : year;
            }
            if (dayOfYear < 363) {
                return year;
            }
            return ((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? year + 1 : year;
        }

        /* access modifiers changed from: private */
        public static int getWeekRange(int i) {
            LocalDate of = LocalDate.m185of(i, 1, 1);
            if (of.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (of.getDayOfWeek() != DayOfWeek.WEDNESDAY || !of.isLeapYear()) ? 52 : 53;
            }
            return 53;
        }

        public boolean isDateBased() {
            return true;
        }

        public boolean isTimeBased() {
            return false;
        }

        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            return range();
        }
    }

    /* renamed from: j$.time.temporal.IsoFields$Unit */
    enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));
        
        private final String name;

        private Unit(String str, Duration duration) {
            this.name = str;
        }

        public Temporal addTo(Temporal temporal, long j) {
            int i = C14221.$SwitchMap$java$time$temporal$IsoFields$Unit[ordinal()];
            if (i == 1) {
                TemporalField temporalField = IsoFields.WEEK_BASED_YEAR;
                return temporal.with(temporalField, Iterable.CC.m182m((long) temporal.get(temporalField), j));
            } else if (i == 2) {
                return temporal.plus(j / 256, ChronoUnit.YEARS).plus((j % 256) * 3, ChronoUnit.MONTHS);
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        public boolean isDateBased() {
            return true;
        }

        public String toString() {
            return this.name;
        }
    }

    static {
        Field field = Field.DAY_OF_QUARTER;
        Unit unit = Unit.QUARTER_YEARS;
    }
}
