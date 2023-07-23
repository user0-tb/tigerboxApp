package p009j$.time;

import com.google.android.exoplayer2.C0963C;
import java.io.Serializable;
import java.util.Objects;
import org.spongycastle.crypto.tls.CipherSuite;
import p009j$.lang.Iterable;
import p009j$.time.chrono.ChronoLocalDate;
import p009j$.time.chrono.ChronoLocalDateTime;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.format.DateTimeFormatter;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.ChronoUnit;
import p009j$.time.temporal.Temporal;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalAdjuster;
import p009j$.time.temporal.TemporalAdjusters;
import p009j$.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda1;
import p009j$.time.temporal.TemporalAmount;
import p009j$.time.temporal.TemporalField;
import p009j$.time.temporal.TemporalQueries;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda2;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda3;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda4;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda5;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda6;
import p009j$.time.temporal.TemporalQuery;
import p009j$.time.temporal.TemporalUnit;
import p009j$.time.temporal.UnsupportedTemporalTypeException;
import p009j$.time.temporal.ValueRange;

/* renamed from: j$.time.LocalDate */
public final class LocalDate implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable {
    public static final LocalDate MAX = m185of(999999999, 12, 31);
    public static final LocalDate MIN = m185of(-999999999, 1, 1);
    private final short day;
    private final short month;
    private final int year;

    /* renamed from: j$.time.LocalDate$1 */
    static /* synthetic */ class C14101 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(49:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0099 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00b7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00cf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00db */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e7 */
        static {
            /*
                j$.time.temporal.ChronoUnit[] r0 = p009j$.time.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$time$temporal$ChronoUnit = r0
                r1 = 1
                j$.time.temporal.ChronoUnit r2 = p009j$.time.temporal.ChronoUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                j$.time.temporal.ChronoUnit r3 = p009j$.time.temporal.ChronoUnit.WEEKS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                j$.time.temporal.ChronoUnit r4 = p009j$.time.temporal.ChronoUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                j$.time.temporal.ChronoUnit r5 = p009j$.time.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                j$.time.temporal.ChronoUnit r6 = p009j$.time.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                j$.time.temporal.ChronoUnit r7 = p009j$.time.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0054 }
                j$.time.temporal.ChronoUnit r8 = p009j$.time.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0060 }
                j$.time.temporal.ChronoUnit r9 = p009j$.time.temporal.ChronoUnit.ERAS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                j$.time.temporal.ChronoField[] r8 = p009j$.time.temporal.ChronoField.values()
                int r8 = r8.length
                int[] r8 = new int[r8]
                $SwitchMap$java$time$temporal$ChronoField = r8
                j$.time.temporal.ChronoField r9 = p009j$.time.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r8[r9] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x007b }
                j$.time.temporal.ChronoField r8 = p009j$.time.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x007b }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r8] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0085 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x008f }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0099 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.DAY_OF_WEEK     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00a3 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00ad }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00b7 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.EPOCH_DAY     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00c3 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x00c3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00cf }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x00cf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cf }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cf }
            L_0x00cf:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00db }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x00db }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00db }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00e7 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x00e7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e7 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e7 }
            L_0x00e7:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00f3 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.LocalDate.C14101.<clinit>():void");
        }
    }

    private LocalDate(int i, int i2, int i3) {
        this.year = i;
        this.month = (short) i2;
        this.day = (short) i3;
    }

    public static LocalDate from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        int i = TemporalQueries.$r8$clinit;
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries$$ExternalSyntheticLambda5.INSTANCE);
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (C14101.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int i = this.year;
                return i >= 1 ? i : 1 - i;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new UnsupportedTemporalTypeException("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new UnsupportedTemporalTypeException("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.year;
            case 13:
                return this.year >= 1 ? 1 : 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    /* renamed from: of */
    public static LocalDate m185of(int i, int i2, int i3) {
        long j = (long) i;
        ChronoField.YEAR.checkValidValue(j);
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i2);
        ChronoField.DAY_OF_MONTH.checkValidValue((long) i3);
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else if (IsoChronology.INSTANCE.isLeapYear(j)) {
                i4 = 29;
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    throw new DateTimeException("Invalid date 'February 29' as '" + i + "' is not a leap year");
                }
                StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Invalid date '");
                m.append(Month.m191of(i2).name());
                m.append(" ");
                m.append(i3);
                m.append("'");
                throw new DateTimeException(m.toString());
            }
        }
        return new LocalDate(i, i2, i3);
    }

    public static LocalDate ofEpochDay(long j) {
        long j2;
        long j3 = (j + 719528) - 60;
        if (j3 < 0) {
            long j4 = ((j3 + 1) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j5 + j2 + ((long) (i2 / 10))), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate ofYearDay(int i, int i2) {
        long j = (long) i;
        ChronoField.YEAR.checkValidValue(j);
        ChronoField.DAY_OF_YEAR.checkValidValue((long) i2);
        boolean isLeapYear = IsoChronology.INSTANCE.isLeapYear(j);
        if (i2 != 366 || isLeapYear) {
            Month of = Month.m191of(((i2 - 1) / 31) + 1);
            if (i2 > (of.length(isLeapYear) + of.firstDayOfYear(isLeapYear)) - 1) {
                of = of.plus(1);
            }
            return new LocalDate(i, of.getValue(), (i2 - of.firstDayOfYear(isLeapYear)) + 1);
        }
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i + "' is not a leap year");
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.parse(charSequence, LocalDate$$ExternalSyntheticLambda1.INSTANCE);
    }

    private static LocalDate resolvePreviousValid(int i, int i2, int i3) {
        int i4;
        if (i2 != 2) {
            if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
                i4 = 30;
            }
            return new LocalDate(i, i2, i3);
        }
        i4 = IsoChronology.INSTANCE.isLeapYear((long) i) ? 29 : 28;
        i3 = Math.min(i3, i4);
        return new LocalDate(i, i2, i3);
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public ChronoLocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.m188of(this, localTime);
    }

    public int compareTo(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return compareTo0((LocalDate) chronoLocalDate);
        }
        int compare = Long.compare(toEpochDay(), chronoLocalDate.toEpochDay());
        if (compare != 0) {
            return compare;
        }
        getChronology();
        IsoChronology isoChronology = IsoChronology.INSTANCE;
        Objects.requireNonNull(chronoLocalDate.getChronology());
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int compareTo0(LocalDate localDate) {
        int i = this.year - localDate.year;
        if (i != 0) {
            return i;
        }
        int i2 = this.month - localDate.month;
        return i2 == 0 ? this.day - localDate.day : i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && compareTo0((LocalDate) obj) == 0;
    }

    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : TemporalAdjusters.$default$get(this, temporalField);
    }

    public Chronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.m184of(((int) Iterable.CC.m$1(toEpochDay() + 3, 7)) + 1);
    }

    public int getDayOfYear() {
        return (Month.m191of(this.month).firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        if (temporalField == ChronoField.EPOCH_DAY) {
            return toEpochDay();
        }
        if (temporalField == ChronoField.PROLEPTIC_MONTH) {
            return ((((long) this.year) * 12) + ((long) this.month)) - 1;
        }
        return (long) get0(temporalField);
    }

    public int getYear() {
        return this.year;
    }

    public int hashCode() {
        int i = this.year;
        return (((i << 11) + (this.month << 6)) + this.day) ^ (i & -2048);
    }

    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) < 0 : toEpochDay() < chronoLocalDate.toEpochDay();
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear((long) this.year);
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isDateBased();
        }
        return temporalField != null && temporalField.isSupportedBy(this);
    }

    public LocalDate minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1, temporalUnit) : plus(-j, temporalUnit);
    }

    public LocalDate plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.addTo(this, j);
        }
        switch (C14101.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusDays(j);
            case 2:
                return plusWeeks(j);
            case 3:
                return plusMonths(j);
            case 4:
                return plusYears(j);
            case 5:
                return plusYears(Iterable.CC.m$3(j, 10));
            case 6:
                return plusYears(Iterable.CC.m$3(j, 100));
            case 7:
                return plusYears(Iterable.CC.m$3(j, 1000));
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return with((TemporalField) chronoField, Iterable.CC.m182m(getLong(chronoField), j));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public ChronoLocalDate plus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof Period) {
            Period period = (Period) temporalAmount;
            return plusMonths(period.toTotalMonths()).plusDays((long) period.getDays());
        }
        Objects.requireNonNull(temporalAmount, "amountToAdd");
        return (LocalDate) ((Period) temporalAmount).addTo(this);
    }

    public LocalDate plusDays(long j) {
        return j == 0 ? this : ofEpochDay(Iterable.CC.m182m(toEpochDay(), j));
    }

    public LocalDate plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.year) * 12) + ((long) (this.month - 1)) + j;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(Iterable.CC.m$2(j2, 12)), ((int) Iterable.CC.m$1(j2, 12)) + 1, this.day);
    }

    public LocalDate plusWeeks(long j) {
        return plusDays(Iterable.CC.m$3(j, 7));
    }

    public LocalDate plusYears(long j) {
        return j == 0 ? this : resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j), this.month, this.day);
    }

    public Object query(TemporalQuery temporalQuery) {
        int i = TemporalQueries.$r8$clinit;
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda5.INSTANCE) {
            return this;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda0.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda4.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda3.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda6.INSTANCE) {
            return null;
        }
        if (temporalQuery != TemporalQueries$$ExternalSyntheticLambda1.INSTANCE) {
            return temporalQuery == TemporalQueries$$ExternalSyntheticLambda2.INSTANCE ? ChronoUnit.DAYS : temporalQuery.queryFrom(this);
        }
        getChronology();
        return IsoChronology.INSTANCE;
    }

    public ValueRange range(TemporalField temporalField) {
        int i;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (chronoField.isDateBased()) {
            int i2 = C14101.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()];
            if (i2 == 1) {
                short s = this.month;
                i = s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : isLeapYear() ? 29 : 28;
            } else if (i2 == 2) {
                i = isLeapYear() ? 366 : 365;
            } else if (i2 == 3) {
                return ValueRange.m196of(1, (Month.m191of(this.month) != Month.FEBRUARY || isLeapYear()) ? 5 : 4);
            } else if (i2 != 4) {
                return temporalField.range();
            } else {
                return ValueRange.m196of(1, this.year <= 0 ? C0963C.NANOS_PER_SECOND : 999999999);
            }
            return ValueRange.m196of(1, (long) i);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long toEpochDay() {
        long j;
        long j2 = (long) this.year;
        long j3 = (long) this.month;
        long j4 = (365 * j2) + 0;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / -400) + ((j2 / -4) - (j2 / -100)));
        }
        long j5 = (((367 * j3) - 362) / 12) + j + ((long) (this.day - 1));
        if (j3 > 2) {
            j5--;
            if (!isLeapYear()) {
                j5--;
            }
        }
        return j5 - 719528;
    }

    public String toString() {
        int i;
        int i2 = this.year;
        short s = this.month;
        short s2 = this.day;
        int abs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (i2 < 0) {
                sb.append(i2 - 10000);
                i = 1;
            } else {
                sb.append(i2 + 10000);
                i = 0;
            }
            sb.deleteCharAt(i);
        } else {
            if (i2 > 9999) {
                sb.append('+');
            }
            sb.append(i2);
        }
        String str = "-0";
        sb.append(s < 10 ? str : "-");
        sb.append(s);
        if (s2 >= 10) {
            str = "-";
        }
        sb.append(str);
        sb.append(s2);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
        r0 = getLong(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return plusDays(r9 - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return withYear((int) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return plusWeeks(r9 - getLong(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p009j$.time.LocalDate with(p009j$.time.temporal.TemporalField r8, long r9) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof p009j$.time.temporal.ChronoField
            if (r0 == 0) goto L_0x00c4
            r0 = r8
            j$.time.temporal.ChronoField r0 = (p009j$.time.temporal.ChronoField) r0
            r0.checkValidValue(r9)
            int[] r1 = p009j$.time.LocalDate.C14101.$SwitchMap$java$time$temporal$ChronoField
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r3 = 1
            switch(r0) {
                case 1: goto L_0x00b4;
                case 2: goto L_0x00a5;
                case 3: goto L_0x0099;
                case 4: goto L_0x008c;
                case 5: goto L_0x007d;
                case 6: goto L_0x0076;
                case 7: goto L_0x0073;
                case 8: goto L_0x006e;
                case 9: goto L_0x006b;
                case 10: goto L_0x0056;
                case 11: goto L_0x0043;
                case 12: goto L_0x0093;
                case 13: goto L_0x002f;
                default: goto L_0x0018;
            }
        L_0x0018:
            j$.time.temporal.UnsupportedTemporalTypeException r9 = new j$.time.temporal.UnsupportedTemporalTypeException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Unsupported field: "
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x002f:
            j$.time.temporal.ChronoField r8 = p009j$.time.temporal.ChronoField.ERA
            long r0 = r7.getLong(r8)
            int r8 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x003b
            r8 = r7
            goto L_0x0042
        L_0x003b:
            int r8 = r7.year
            int r3 = r3 - r8
            j$.time.LocalDate r8 = r7.withYear(r3)
        L_0x0042:
            return r8
        L_0x0043:
            int r8 = r7.year
            long r3 = (long) r8
            r5 = 12
            long r3 = r3 * r5
            short r8 = r7.month
            long r5 = (long) r8
            long r3 = r3 + r5
            long r3 = r3 - r1
            long r9 = r9 - r3
            j$.time.LocalDate r8 = r7.plusMonths(r9)
            goto L_0x00ca
        L_0x0056:
            int r8 = (int) r9
            short r9 = r7.month
            if (r9 != r8) goto L_0x005c
            goto L_0x00b9
        L_0x005c:
            j$.time.temporal.ChronoField r9 = p009j$.time.temporal.ChronoField.MONTH_OF_YEAR
            long r0 = (long) r8
            r9.checkValidValue(r0)
            int r9 = r7.year
            short r10 = r7.day
            j$.time.LocalDate r8 = resolvePreviousValid(r9, r8, r10)
            goto L_0x00ca
        L_0x006b:
            j$.time.temporal.ChronoField r8 = p009j$.time.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR
            goto L_0x009b
        L_0x006e:
            j$.time.LocalDate r8 = ofEpochDay(r9)
            goto L_0x00ca
        L_0x0073:
            j$.time.temporal.ChronoField r8 = p009j$.time.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR
            goto L_0x0078
        L_0x0076:
            j$.time.temporal.ChronoField r8 = p009j$.time.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH
        L_0x0078:
            long r0 = r7.getLong(r8)
            goto L_0x0086
        L_0x007d:
            j$.time.DayOfWeek r8 = r7.getDayOfWeek()
            int r8 = r8.getValue()
            long r0 = (long) r8
        L_0x0086:
            long r9 = r9 - r0
            j$.time.LocalDate r8 = r7.plusDays(r9)
            goto L_0x00ca
        L_0x008c:
            int r8 = r7.year
            if (r8 < r3) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            long r9 = r1 - r9
        L_0x0093:
            int r8 = (int) r9
            j$.time.LocalDate r8 = r7.withYear(r8)
            goto L_0x00ca
        L_0x0099:
            j$.time.temporal.ChronoField r8 = p009j$.time.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH
        L_0x009b:
            long r0 = r7.getLong(r8)
            long r9 = r9 - r0
            j$.time.LocalDate r8 = r7.plusWeeks(r9)
            goto L_0x00ca
        L_0x00a5:
            int r8 = (int) r9
            int r9 = r7.getDayOfYear()
            if (r9 != r8) goto L_0x00ad
            goto L_0x00b9
        L_0x00ad:
            int r9 = r7.year
            j$.time.LocalDate r8 = ofYearDay(r9, r8)
            goto L_0x00ca
        L_0x00b4:
            int r8 = (int) r9
            short r9 = r7.day
            if (r9 != r8) goto L_0x00bb
        L_0x00b9:
            r8 = r7
            goto L_0x00ca
        L_0x00bb:
            int r9 = r7.year
            short r10 = r7.month
            j$.time.LocalDate r8 = m185of(r9, r10, r8)
            goto L_0x00ca
        L_0x00c4:
            j$.time.temporal.Temporal r8 = r8.adjustInto(r7, r9)
            j$.time.LocalDate r8 = (p009j$.time.LocalDate) r8
        L_0x00ca:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.LocalDate.with(j$.time.temporal.TemporalField, long):j$.time.LocalDate");
    }

    public LocalDate withDayOfYear(int i) {
        return getDayOfYear() == i ? this : ofYearDay(this.year, i);
    }

    public LocalDate withYear(int i) {
        if (this.year == i) {
            return this;
        }
        ChronoField.YEAR.checkValidValue((long) i);
        return resolvePreviousValid(i, this.month, this.day);
    }

    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        boolean z = temporalAdjuster instanceof LocalDate;
        Object obj = temporalAdjuster;
        if (!z) {
            obj = ((TemporalAdjusters$$ExternalSyntheticLambda1) temporalAdjuster).adjustInto(this);
        }
        return (LocalDate) obj;
    }

    /* renamed from: with  reason: collision with other method in class */
    public Temporal m739with(TemporalAdjuster temporalAdjuster) {
        return (LocalDate) temporalAdjuster;
    }
}
