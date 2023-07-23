package p009j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.C0963C;
import java.io.Serializable;
import java.util.Objects;
import p009j$.lang.Iterable;
import p009j$.time.chrono.ChronoLocalDate;
import p009j$.time.chrono.ChronoLocalDateTime;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.ChronoUnit;
import p009j$.time.temporal.Temporal;
import p009j$.time.temporal.TemporalAdjuster;
import p009j$.time.temporal.TemporalAdjusters;
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
import p009j$.time.temporal.ValueRange;

/* renamed from: j$.time.LocalDateTime */
public final class LocalDateTime implements Temporal, TemporalAdjuster, ChronoLocalDateTime, Serializable {
    private final LocalDate date;
    private final LocalTime time;

    /* renamed from: j$.time.LocalDateTime$1 */
    abstract /* synthetic */ class C14111 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                j$.time.temporal.ChronoUnit[] r0 = p009j$.time.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$time$temporal$ChronoUnit = r0
                j$.time.temporal.ChronoUnit r1 = p009j$.time.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                j$.time.temporal.ChronoUnit r1 = p009j$.time.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                j$.time.temporal.ChronoUnit r1 = p009j$.time.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                j$.time.temporal.ChronoUnit r1 = p009j$.time.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                j$.time.temporal.ChronoUnit r1 = p009j$.time.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                j$.time.temporal.ChronoUnit r1 = p009j$.time.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0054 }
                j$.time.temporal.ChronoUnit r1 = p009j$.time.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.LocalDateTime.C14111.<clinit>():void");
        }
    }

    static {
        m188of(LocalDate.MIN, LocalTime.MIN);
        m188of(LocalDate.MAX, LocalTime.MAX);
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    private int compareTo0(LocalDateTime localDateTime) {
        int compareTo0 = this.date.compareTo0(localDateTime.date);
        return compareTo0 == 0 ? this.time.compareTo(localDateTime.time) : compareTo0;
    }

    /* renamed from: of */
    public static LocalDateTime m186of(int i, int i2, int i3, int i4, int i5) {
        return new LocalDateTime(LocalDate.m185of(i, i2, i3), LocalTime.m189of(i4, i5));
    }

    /* renamed from: of */
    public static LocalDateTime m187of(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new LocalDateTime(LocalDate.m185of(i, i2, i3), LocalTime.m190of(i4, i5, i6, i7));
    }

    /* renamed from: of */
    public static LocalDateTime m188of(LocalDate localDate, LocalTime localTime) {
        Objects.requireNonNull(localDate, "date");
        Objects.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime ofEpochSecond(long j, int i, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        long j2 = (long) i;
        ChronoField.NANO_OF_SECOND.checkValidValue(j2);
        long totalSeconds = j + ((long) zoneOffset.getTotalSeconds());
        return new LocalDateTime(LocalDate.ofEpochDay(Iterable.CC.m$2(totalSeconds, 86400)), LocalTime.ofNanoOfDay((((long) ((int) Iterable.CC.m$1(totalSeconds, 86400))) * C0963C.NANOS_PER_SECOND) + j2));
    }

    private LocalDateTime plusWithOverflow(LocalDate localDate, long j, long j2, long j3, long j4, int i) {
        LocalTime ofNanoOfDay;
        LocalDate localDate2 = localDate;
        if ((j | j2 | j3 | j4) == 0) {
            ofNanoOfDay = this.time;
        } else {
            long j5 = j / 24;
            long j6 = j5 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
            long j7 = (long) i;
            long j8 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * C0963C.NANOS_PER_SECOND) + (j4 % 86400000000000L);
            long nanoOfDay = this.time.toNanoOfDay();
            long j9 = (j8 * j7) + nanoOfDay;
            long m$2 = Iterable.CC.m$2(j9, 86400000000000L) + (j6 * j7);
            long m$1 = Iterable.CC.m$1(j9, 86400000000000L);
            ofNanoOfDay = m$1 == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(m$1);
            localDate2 = localDate2.plusDays(m$2);
        }
        return with(localDate2, ofNanoOfDay);
    }

    private LocalDateTime with(LocalDate localDate, LocalTime localTime) {
        return (this.date == localDate && this.time == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    public int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return compareTo0((LocalDateTime) chronoLocalDateTime);
        }
        LocalDateTime localDateTime = (LocalDateTime) chronoLocalDateTime;
        int compareTo = ((LocalDate) toLocalDate()).compareTo(localDateTime.toLocalDate());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = toLocalTime().compareTo(localDateTime.toLocalTime());
        if (compareTo2 != 0) {
            return compareTo2;
        }
        getChronology();
        IsoChronology isoChronology = IsoChronology.INSTANCE;
        localDateTime.getChronology();
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.date.equals(localDateTime.date) && this.time.equals(localDateTime.time);
    }

    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField) : TemporalAdjusters.$default$get(this, temporalField);
    }

    public Chronology getChronology() {
        Objects.requireNonNull((LocalDate) toLocalDate());
        return IsoChronology.INSTANCE;
    }

    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField) : temporalField.getFrom(this);
    }

    public int getNano() {
        return this.time.getNano();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    public boolean isAfter(ChronoLocalDateTime chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return compareTo0((LocalDateTime) chronoLocalDateTime) > 0;
        }
        LocalDateTime localDateTime = (LocalDateTime) chronoLocalDateTime;
        int i = (((LocalDate) toLocalDate()).toEpochDay() > ((LocalDate) localDateTime.toLocalDate()).toEpochDay() ? 1 : (((LocalDate) toLocalDate()).toEpochDay() == ((LocalDate) localDateTime.toLocalDate()).toEpochDay() ? 0 : -1));
        return i > 0 || (i == 0 && toLocalTime().toNanoOfDay() > localDateTime.toLocalTime().toNanoOfDay());
    }

    public boolean isBefore(ChronoLocalDateTime chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return compareTo0((LocalDateTime) chronoLocalDateTime) < 0;
        }
        LocalDateTime localDateTime = (LocalDateTime) chronoLocalDateTime;
        int i = (((LocalDate) toLocalDate()).toEpochDay() > ((LocalDate) localDateTime.toLocalDate()).toEpochDay() ? 1 : (((LocalDate) toLocalDate()).toEpochDay() == ((LocalDate) localDateTime.toLocalDate()).toEpochDay() ? 0 : -1));
        return i < 0 || (i == 0 && toLocalTime().toNanoOfDay() < localDateTime.toLocalTime().toNanoOfDay());
    }

    public boolean isSupported(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField != null && temporalField.isSupportedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        return chronoField.isDateBased() || chronoField.isTimeBased();
    }

    public LocalDateTime plus(long j, TemporalUnit temporalUnit) {
        long j2 = j;
        TemporalUnit temporalUnit2 = temporalUnit;
        if (!(temporalUnit2 instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit2.addTo(this, j2);
        }
        switch (C14111.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit2).ordinal()]) {
            case 1:
                return plusNanos(j);
            case 2:
                return plusDays(j2 / 86400000000L).plusNanos((j2 % 86400000000L) * 1000);
            case 3:
                return plusDays(j2 / 86400000).plusNanos((j2 % 86400000) * 1000000);
            case 4:
                return plusSeconds(j);
            case 5:
                return plusWithOverflow(this.date, 0, j, 0, 0, 1);
            case 6:
                return plusWithOverflow(this.date, j, 0, 0, 0, 1);
            case 7:
                LocalDateTime plusDays = plusDays(j2 / 256);
                return plusDays.plusWithOverflow(plusDays.date, (j2 % 256) * 12, 0, 0, 0, 1);
            default:
                return with(this.date.plus(j2, temporalUnit2), this.time);
        }
    }

    public LocalDateTime plusDays(long j) {
        return with(this.date.plusDays(j), this.time);
    }

    public LocalDateTime plusNanos(long j) {
        return plusWithOverflow(this.date, 0, 0, 0, j, 1);
    }

    public LocalDateTime plusSeconds(long j) {
        return plusWithOverflow(this.date, 0, 0, j, 0, 1);
    }

    public Object query(TemporalQuery temporalQuery) {
        int i = TemporalQueries.$r8$clinit;
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda5.INSTANCE) {
            return this.date;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda0.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda4.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda3.INSTANCE) {
            return null;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda6.INSTANCE) {
            return toLocalTime();
        }
        if (temporalQuery != TemporalQueries$$ExternalSyntheticLambda1.INSTANCE) {
            return temporalQuery == TemporalQueries$$ExternalSyntheticLambda2.INSTANCE ? ChronoUnit.NANOS : temporalQuery.queryFrom(this);
        }
        getChronology();
        return IsoChronology.INSTANCE;
    }

    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (!((ChronoField) temporalField).isTimeBased()) {
            return this.date.range(temporalField);
        }
        LocalTime localTime = this.time;
        Objects.requireNonNull(localTime);
        return TemporalAdjusters.$default$range(localTime, temporalField);
    }

    public long toEpochSecond(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return ((((LocalDate) toLocalDate()).toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) zoneOffset.getTotalSeconds());
    }

    public LocalDate toLocalDate() {
        return this.date;
    }

    /* renamed from: toLocalDate  reason: collision with other method in class */
    public ChronoLocalDate m740toLocalDate() {
        return this.date;
    }

    public LocalTime toLocalTime() {
        return this.time;
    }

    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    public LocalDateTime with(TemporalField temporalField, long j) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? with(this.date, this.time.with(temporalField, j)) : with(this.date.with(temporalField, j), this.time) : (LocalDateTime) temporalField.adjustInto(this, j);
    }

    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return with((LocalDate) temporalAdjuster, this.time);
    }
}
