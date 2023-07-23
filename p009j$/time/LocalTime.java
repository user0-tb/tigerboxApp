package p009j$.time;

import com.google.android.exoplayer2.C0963C;
import com.google.common.base.Ascii;
import java.io.Serializable;
import java.util.Objects;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupViewModel;
import okhttp3.internal.http2.Http2Connection;
import p009j$.time.format.DateTimeFormatter;
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
import p009j$.time.temporal.UnsupportedTemporalTypeException;
import p009j$.time.temporal.ValueRange;

/* renamed from: j$.time.LocalTime */
public final class LocalTime implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable {
    private static final LocalTime[] HOURS = new LocalTime[24];
    public static final LocalTime MAX = new LocalTime(23, 59, 59, 999999999);
    public static final LocalTime MIDNIGHT;
    public static final LocalTime MIN;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    /* renamed from: j$.time.LocalTime$1 */
    static /* synthetic */ class C14121 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|(3:57|58|60)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(53:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00f5 */
        static {
            /*
                j$.time.temporal.ChronoUnit[] r0 = p009j$.time.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$time$temporal$ChronoUnit = r0
                r1 = 1
                j$.time.temporal.ChronoUnit r2 = p009j$.time.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                j$.time.temporal.ChronoUnit r3 = p009j$.time.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                j$.time.temporal.ChronoUnit r4 = p009j$.time.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                j$.time.temporal.ChronoUnit r5 = p009j$.time.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                j$.time.temporal.ChronoUnit r6 = p009j$.time.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                j$.time.temporal.ChronoUnit r7 = p009j$.time.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0054 }
                j$.time.temporal.ChronoUnit r8 = p009j$.time.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                j$.time.temporal.ChronoField[] r7 = p009j$.time.temporal.ChronoField.values()
                int r7 = r7.length
                int[] r7 = new int[r7]
                $SwitchMap$java$time$temporal$ChronoField = r7
                j$.time.temporal.ChronoField r8 = p009j$.time.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r7[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r1 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x006f }
                j$.time.temporal.ChronoField r7 = p009j$.time.temporal.ChronoField.NANO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x006f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r1[r7] = r0     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0079 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MICRO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0083 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MICRO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x008d }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MILLI_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x008d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0097 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MILLI_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00a1 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.SECOND_OF_MINUTE     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00ad }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.SECOND_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00b9 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MINUTE_OF_HOUR     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00c5 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MINUTE_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00d1 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00dd }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.CLOCK_HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00e9 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x00f5 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.CLOCK_HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00f5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f5 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f5 }
            L_0x00f5:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0101 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.AMPM_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0101 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0101 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0101 }
            L_0x0101:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.LocalTime.C14121.<clinit>():void");
        }
    }

    static {
        int i = 0;
        while (true) {
            LocalTime[] localTimeArr = HOURS;
            if (i < localTimeArr.length) {
                localTimeArr[i] = new LocalTime(i, 0, 0, 0);
                i++;
            } else {
                MIDNIGHT = localTimeArr[0];
                LocalTime localTime = localTimeArr[12];
                MIN = localTimeArr[0];
                return;
            }
        }
    }

    private LocalTime(int i, int i2, int i3, int i4) {
        this.hour = (byte) i;
        this.minute = (byte) i2;
        this.second = (byte) i3;
        this.nano = i4;
    }

    private static LocalTime create(int i, int i2, int i3, int i4) {
        return ((i2 | i3) | i4) == 0 ? HOURS[i] : new LocalTime(i, i2, i3, i4);
    }

    private int get0(TemporalField temporalField) {
        switch (C14121.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.nano;
            case 2:
                throw new UnsupportedTemporalTypeException("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.nano / 1000;
            case 4:
                throw new UnsupportedTemporalTypeException("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.nano / 1000000;
            case 6:
                return (int) (toNanoOfDay() / 1000000);
            case 7:
                return this.second;
            case 8:
                return toSecondOfDay();
            case 9:
                return this.minute;
            case 10:
                return (this.hour * 60) + this.minute;
            case 11:
                return this.hour % Ascii.f271FF;
            case 12:
                int i = this.hour % Ascii.f271FF;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 13:
                return this.hour;
            case 14:
                byte b = this.hour;
                if (b == 0) {
                    return 24;
                }
                return b;
            case 15:
                return this.hour / Ascii.f271FF;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    /* renamed from: of */
    public static LocalTime m189of(int i, int i2) {
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i);
        if (i2 == 0) {
            return HOURS[i];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue((long) i2);
        return new LocalTime(i, i2, 0, 0);
    }

    /* renamed from: of */
    public static LocalTime m190of(int i, int i2, int i3, int i4) {
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i);
        ChronoField.MINUTE_OF_HOUR.checkValidValue((long) i2);
        ChronoField.SECOND_OF_MINUTE.checkValidValue((long) i3);
        ChronoField.NANO_OF_SECOND.checkValidValue((long) i4);
        return create(i, i2, i3, i4);
    }

    public static LocalTime ofNanoOfDay(long j) {
        ChronoField.NANO_OF_DAY.checkValidValue(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (((long) i) * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i2) * 60000000000L);
        int i3 = (int) (j3 / C0963C.NANOS_PER_SECOND);
        return create(i, i2, i3, (int) (j3 - (((long) i3) * C0963C.NANOS_PER_SECOND)));
    }

    public static LocalTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalTime) dateTimeFormatter.parse(charSequence, LocalTime$$ExternalSyntheticLambda0.INSTANCE);
    }

    public int compareTo(LocalTime localTime) {
        int compare = Integer.compare(this.hour, localTime.hour);
        if (compare != 0) {
            return compare;
        }
        int compare2 = Integer.compare(this.minute, localTime.minute);
        if (compare2 != 0) {
            return compare2;
        }
        int compare3 = Integer.compare(this.second, localTime.second);
        return compare3 == 0 ? Integer.compare(this.nano, localTime.nano) : compare3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        return this.hour == localTime.hour && this.minute == localTime.minute && this.second == localTime.second && this.nano == localTime.nano;
    }

    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : TemporalAdjusters.$default$get(this, temporalField);
    }

    public int getHour() {
        return this.hour;
    }

    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.NANO_OF_DAY ? toNanoOfDay() : temporalField == ChronoField.MICRO_OF_DAY ? toNanoOfDay() / 1000 : (long) get0(temporalField) : temporalField.getFrom(this);
    }

    public int getMinute() {
        return this.minute;
    }

    public int getNano() {
        return this.nano;
    }

    public int getSecond() {
        return this.second;
    }

    public int hashCode() {
        long nanoOfDay = toNanoOfDay();
        return (int) (nanoOfDay ^ (nanoOfDay >>> 32));
    }

    public boolean isAfter(LocalTime localTime) {
        return compareTo(localTime) > 0;
    }

    public boolean isBefore(LocalTime localTime) {
        return compareTo(localTime) < 0;
    }

    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    public LocalTime plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalTime) temporalUnit.addTo(this, j);
        }
        switch (C14121.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusNanos(j);
            case 2:
                return plusNanos((j % 86400000000L) * 1000);
            case 3:
                return plusNanos((j % 86400000) * 1000000);
            case 4:
                return plusSeconds(j);
            case 5:
                return plusMinutes(j);
            case 6:
                return plusHours(j);
            case 7:
                return plusHours((j % 2) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalTime plusHours(long j) {
        return j == 0 ? this : create(((((int) (j % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.hour * 60) + this.minute;
        int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
        return i == i2 ? this : create(i2 / 60, i2 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long j) {
        if (j == 0) {
            return this;
        }
        long nanoOfDay = toNanoOfDay();
        long j2 = (((j % 86400000000000L) + nanoOfDay) + 86400000000000L) % 86400000000000L;
        return nanoOfDay == j2 ? this : create((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / C0963C.NANOS_PER_SECOND) % 60), (int) (j2 % C0963C.NANOS_PER_SECOND));
    }

    public LocalTime plusSeconds(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.minute * 60) + (this.hour * 3600) + this.second;
        int i2 = ((((int) (j % 86400)) + i) + 86400) % 86400;
        return i == i2 ? this : create(i2 / TimersSetupLimitSetupViewModel.SEC_1H, (i2 / 60) % 60, i2 % 60, this.nano);
    }

    public Object query(TemporalQuery temporalQuery) {
        int i = TemporalQueries.$r8$clinit;
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda1.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda0.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda4.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda3.INSTANCE) {
            return null;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda6.INSTANCE) {
            return this;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda5.INSTANCE) {
            return null;
        }
        return temporalQuery == TemporalQueries$$ExternalSyntheticLambda2.INSTANCE ? ChronoUnit.NANOS : temporalQuery.queryFrom(this);
    }

    public ValueRange range(TemporalField temporalField) {
        return TemporalAdjusters.$default$range(this, temporalField);
    }

    public long toNanoOfDay() {
        return (((long) this.second) * C0963C.NANOS_PER_SECOND) + (((long) this.minute) * 60000000000L) + (((long) this.hour) * 3600000000000L) + ((long) this.nano);
    }

    public int toSecondOfDay() {
        return (this.minute * 60) + (this.hour * 3600) + this.second;
    }

    public String toString() {
        int i;
        StringBuilder sb = new StringBuilder(18);
        byte b = this.hour;
        byte b2 = this.minute;
        byte b3 = this.second;
        int i2 = this.nano;
        sb.append(b < 10 ? SessionDescription.SUPPORTED_SDP_VERSION : "");
        sb.append(b);
        String str = ":0";
        sb.append(b2 < 10 ? str : ":");
        sb.append(b2);
        if (b3 > 0 || i2 > 0) {
            if (b3 >= 10) {
                str = ":";
            }
            sb.append(str);
            sb.append(b3);
            if (i2 > 0) {
                sb.append('.');
                int i3 = 1000000;
                if (i2 % 1000000 == 0) {
                    i = (i2 / 1000000) + 1000;
                } else {
                    if (i2 % 1000 == 0) {
                        i2 /= 1000;
                    } else {
                        i3 = Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
                    }
                    i = i2 + i3;
                }
                sb.append(Integer.toString(i).substring(1));
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        r7 = r7 - ((long) (r5.hour % com.google.common.base.Ascii.f271FF));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ad, code lost:
        r7 = r7 * r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return withHour((int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return plusHours(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return withNano(r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p009j$.time.LocalTime with(p009j$.time.temporal.TemporalField r6, long r7) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof p009j$.time.temporal.ChronoField
            if (r0 == 0) goto L_0x00bf
            r0 = r6
            j$.time.temporal.ChronoField r0 = (p009j$.time.temporal.ChronoField) r0
            r0.checkValidValue(r7)
            int[] r1 = p009j$.time.LocalTime.C14121.$SwitchMap$java$time$temporal$ChronoField
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r3 = 12
            switch(r0) {
                case 1: goto L_0x00b9;
                case 2: goto L_0x00b4;
                case 3: goto L_0x00b0;
                case 4: goto L_0x00ab;
                case 5: goto L_0x00a4;
                case 6: goto L_0x00a0;
                case 7: goto L_0x0089;
                case 8: goto L_0x007e;
                case 9: goto L_0x0066;
                case 10: goto L_0x0058;
                case 11: goto L_0x004c;
                case 12: goto L_0x0047;
                case 13: goto L_0x0040;
                case 14: goto L_0x0039;
                case 15: goto L_0x0030;
                default: goto L_0x0019;
            }
        L_0x0019:
            j$.time.temporal.UnsupportedTemporalTypeException r7 = new j$.time.temporal.UnsupportedTemporalTypeException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unsupported field: "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L_0x0030:
            byte r6 = r5.hour
            int r6 = r6 / 12
            long r0 = (long) r6
            long r7 = r7 - r0
            long r7 = r7 * r3
            goto L_0x0052
        L_0x0039:
            r3 = 24
            int r6 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x0040
            r7 = r1
        L_0x0040:
            int r6 = (int) r7
            j$.time.LocalTime r6 = r5.withHour(r6)
            goto L_0x00c5
        L_0x0047:
            int r6 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x004c
            r7 = r1
        L_0x004c:
            byte r6 = r5.hour
            int r6 = r6 % 12
            long r0 = (long) r6
            long r7 = r7 - r0
        L_0x0052:
            j$.time.LocalTime r6 = r5.plusHours(r7)
            goto L_0x00c5
        L_0x0058:
            byte r6 = r5.hour
            int r6 = r6 * 60
            byte r0 = r5.minute
            int r6 = r6 + r0
            long r0 = (long) r6
            long r7 = r7 - r0
            j$.time.LocalTime r6 = r5.plusMinutes(r7)
            goto L_0x00c5
        L_0x0066:
            int r6 = (int) r7
            byte r7 = r5.minute
            if (r7 != r6) goto L_0x006d
        L_0x006b:
            r6 = r5
            goto L_0x00c5
        L_0x006d:
            j$.time.temporal.ChronoField r7 = p009j$.time.temporal.ChronoField.MINUTE_OF_HOUR
            long r0 = (long) r6
            r7.checkValidValue(r0)
            byte r7 = r5.hour
            byte r8 = r5.second
            int r0 = r5.nano
            j$.time.LocalTime r6 = create(r7, r6, r8, r0)
            goto L_0x00c5
        L_0x007e:
            int r6 = r5.toSecondOfDay()
            long r0 = (long) r6
            long r7 = r7 - r0
            j$.time.LocalTime r6 = r5.plusSeconds(r7)
            goto L_0x00c5
        L_0x0089:
            int r6 = (int) r7
            byte r7 = r5.second
            if (r7 != r6) goto L_0x008f
            goto L_0x006b
        L_0x008f:
            j$.time.temporal.ChronoField r7 = p009j$.time.temporal.ChronoField.SECOND_OF_MINUTE
            long r0 = (long) r6
            r7.checkValidValue(r0)
            byte r7 = r5.hour
            byte r8 = r5.minute
            int r0 = r5.nano
            j$.time.LocalTime r6 = create(r7, r8, r6, r0)
            goto L_0x00c5
        L_0x00a0:
            r0 = 1000000(0xf4240, double:4.940656E-318)
            goto L_0x00ad
        L_0x00a4:
            int r6 = (int) r7
            r7 = 1000000(0xf4240, float:1.401298E-39)
            int r6 = r6 * r7
            goto L_0x00ba
        L_0x00ab:
            r0 = 1000(0x3e8, double:4.94E-321)
        L_0x00ad:
            long r7 = r7 * r0
            goto L_0x00b4
        L_0x00b0:
            int r6 = (int) r7
            int r6 = r6 * 1000
            goto L_0x00ba
        L_0x00b4:
            j$.time.LocalTime r6 = ofNanoOfDay(r7)
            goto L_0x00c5
        L_0x00b9:
            int r6 = (int) r7
        L_0x00ba:
            j$.time.LocalTime r6 = r5.withNano(r6)
            goto L_0x00c5
        L_0x00bf:
            j$.time.temporal.Temporal r6 = r6.adjustInto(r5, r7)
            j$.time.LocalTime r6 = (p009j$.time.LocalTime) r6
        L_0x00c5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.LocalTime.with(j$.time.temporal.TemporalField, long):j$.time.LocalTime");
    }

    public LocalTime withHour(int i) {
        if (this.hour == i) {
            return this;
        }
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i);
        return create(i, this.minute, this.second, this.nano);
    }

    public LocalTime withNano(int i) {
        if (this.nano == i) {
            return this;
        }
        ChronoField.NANO_OF_SECOND.checkValidValue((long) i);
        return create(this.hour, this.minute, this.second, i);
    }

    public Temporal with(TemporalAdjuster temporalAdjuster) {
        boolean z = temporalAdjuster instanceof LocalTime;
        Object obj = temporalAdjuster;
        if (!z) {
            obj = ((LocalDate) temporalAdjuster).adjustInto(this);
        }
        return (LocalTime) obj;
    }
}
