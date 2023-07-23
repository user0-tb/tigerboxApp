package p009j$.time;

import com.google.android.exoplayer2.C0963C;
import java.io.Serializable;
import java.util.Objects;
import p009j$.lang.Iterable;
import p009j$.time.format.DateTimeFormatter;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.ChronoUnit;
import p009j$.time.temporal.Temporal;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalAdjuster;
import p009j$.time.temporal.TemporalAdjusters;
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

/* renamed from: j$.time.Instant */
public final class Instant implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    public static final Instant EPOCH = new Instant(0, 0);
    private final int nanos;
    private final long seconds;

    /* renamed from: j$.time.Instant$1 */
    static /* synthetic */ class C14091 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0085 */
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
                int[] r4 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                j$.time.temporal.ChronoUnit r5 = p009j$.time.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r4 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                j$.time.temporal.ChronoUnit r5 = p009j$.time.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r4 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0054 }
                j$.time.temporal.ChronoUnit r5 = p009j$.time.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r4 = $SwitchMap$java$time$temporal$ChronoUnit     // Catch:{ NoSuchFieldError -> 0x0060 }
                j$.time.temporal.ChronoUnit r5 = p009j$.time.temporal.ChronoUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                j$.time.temporal.ChronoField[] r4 = p009j$.time.temporal.ChronoField.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$java$time$temporal$ChronoField = r4
                j$.time.temporal.ChronoField r5 = p009j$.time.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x007b }
                j$.time.temporal.ChronoField r4 = p009j$.time.temporal.ChronoField.MICRO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x007b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x0085 }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MILLI_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x008f }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.Instant.C14091.<clinit>():void");
        }
    }

    static {
        ofEpochSecond(-31557014167219200L, 0);
        ofEpochSecond(31556889864403199L, 999999999);
    }

    private Instant(long j, int i) {
        this.seconds = j;
        this.nanos = i;
    }

    private static Instant create(long j, int i) {
        if ((((long) i) | j) == 0) {
            return EPOCH;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new Instant(j, i);
        }
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    public static Instant from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Instant) {
            return (Instant) temporalAccessor;
        }
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            return ofEpochSecond(temporalAccessor.getLong(ChronoField.INSTANT_SECONDS), (long) temporalAccessor.get(ChronoField.NANO_OF_SECOND));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
        }
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public static Instant ofEpochMilli(long j) {
        return create(Iterable.CC.m$2(j, 1000), ((int) Iterable.CC.m$1(j, 1000)) * 1000000);
    }

    public static Instant ofEpochSecond(long j) {
        return create(j, 0);
    }

    public static Instant ofEpochSecond(long j, long j2) {
        return create(Iterable.CC.m182m(j, Iterable.CC.m$2(j2, C0963C.NANOS_PER_SECOND)), (int) Iterable.CC.m$1(j2, C0963C.NANOS_PER_SECOND));
    }

    public static Instant parse(CharSequence charSequence) {
        return (Instant) DateTimeFormatter.ISO_INSTANT.parse(charSequence, Instant$$ExternalSyntheticLambda1.INSTANCE);
    }

    private Instant plus(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return ofEpochSecond(Iterable.CC.m182m(Iterable.CC.m182m(this.seconds, j), j2 / C0963C.NANOS_PER_SECOND), ((long) this.nanos) + (j2 % C0963C.NANOS_PER_SECOND));
    }

    public int compareTo(Instant instant) {
        int compare = Long.compare(this.seconds, instant.seconds);
        return compare != 0 ? compare : this.nanos - instant.nanos;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.seconds == instant.seconds && this.nanos == instant.nanos;
    }

    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return TemporalAdjusters.$default$range(this, temporalField).checkValidIntValue(temporalField.getFrom(this), temporalField);
        }
        int i = C14091.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i == 1) {
            return this.nanos;
        }
        if (i == 2) {
            return this.nanos / 1000;
        }
        if (i == 3) {
            return this.nanos / 1000000;
        }
        if (i == 4) {
            ChronoField.INSTANT_SECONDS.checkValidIntValue(this.seconds);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    public long getLong(TemporalField temporalField) {
        int i;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i2 = C14091.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i2 == 1) {
            i = this.nanos;
        } else if (i2 == 2) {
            i = this.nanos / 1000;
        } else if (i2 == 3) {
            i = this.nanos / 1000000;
        } else if (i2 == 4) {
            return this.seconds;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return (long) i;
    }

    public int getNano() {
        return this.nanos;
    }

    public int hashCode() {
        long j = this.seconds;
        return (this.nanos * 51) + ((int) (j ^ (j >>> 32)));
    }

    public boolean isAfter(Instant instant) {
        return compareTo(instant) > 0;
    }

    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.NANO_OF_SECOND || temporalField == ChronoField.MICRO_OF_SECOND || temporalField == ChronoField.MILLI_OF_SECOND : temporalField != null && temporalField.isSupportedBy(this);
    }

    public Instant minus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.subtractFrom(this);
    }

    public Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1, temporalUnit) : plus(-j, temporalUnit);
    }

    public Instant plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.addTo(this, j);
        }
        switch (C14091.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plus(0, j);
            case 2:
                return plus(j / 1000000, (j % 1000000) * 1000);
            case 3:
                return plus(j / 1000, (j % 1000) * 1000000);
            case 4:
                return plus(j, 0);
            case 5:
                return plusSeconds(Iterable.CC.m$3(j, 60));
            case 6:
                return plusSeconds(Iterable.CC.m$3(j, 3600));
            case 7:
                return plusSeconds(Iterable.CC.m$3(j, 43200));
            case 8:
                return plusSeconds(Iterable.CC.m$3(j, 86400));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public Instant plus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.addTo(this);
    }

    public Instant plusSeconds(long j) {
        return plus(j, 0);
    }

    public Object query(TemporalQuery temporalQuery) {
        int i = TemporalQueries.$r8$clinit;
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda2.INSTANCE) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda1.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda0.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda4.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda3.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda5.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda6.INSTANCE) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    public ValueRange range(TemporalField temporalField) {
        return TemporalAdjusters.$default$range(this, temporalField);
    }

    public long toEpochMilli() {
        long m$3;
        int i;
        long j = this.seconds;
        if (j >= 0 || this.nanos <= 0) {
            m$3 = Iterable.CC.m$3(j, 1000);
            i = this.nanos / 1000000;
        } else {
            m$3 = Iterable.CC.m$3(j + 1, 1000);
            i = (this.nanos / 1000000) - 1000;
        }
        return Iterable.CC.m182m(m$3, (long) i);
    }

    public String toString() {
        return DateTimeFormatter.ISO_INSTANT.format(this);
    }

    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return (Instant) ((LocalDate) temporalAdjuster).adjustInto(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r3 != r2.nanos) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r3 != r2.nanos) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p009j$.time.temporal.Temporal with(p009j$.time.temporal.TemporalField r3, long r4) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof p009j$.time.temporal.ChronoField
            if (r0 == 0) goto L_0x0068
            r0 = r3
            j$.time.temporal.ChronoField r0 = (p009j$.time.temporal.ChronoField) r0
            r0.checkValidValue(r4)
            int[] r1 = p009j$.time.Instant.C14091.$SwitchMap$java$time$temporal$ChronoField
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x0057
            r1 = 2
            if (r0 == r1) goto L_0x0049
            r1 = 3
            if (r0 == r1) goto L_0x003e
            r1 = 4
            if (r0 != r1) goto L_0x0027
            long r0 = r2.seconds
            int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r3 == 0) goto L_0x0066
            int r3 = r2.nanos
            goto L_0x0052
        L_0x0027:
            j$.time.temporal.UnsupportedTemporalTypeException r4 = new j$.time.temporal.UnsupportedTemporalTypeException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Unsupported field: "
            r5.append(r0)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.<init>(r3)
            throw r4
        L_0x003e:
            int r3 = (int) r4
            r4 = 1000000(0xf4240, float:1.401298E-39)
            int r3 = r3 * r4
            int r4 = r2.nanos
            if (r3 == r4) goto L_0x0066
            goto L_0x0050
        L_0x0049:
            int r3 = (int) r4
            int r3 = r3 * 1000
            int r4 = r2.nanos
            if (r3 == r4) goto L_0x0066
        L_0x0050:
            long r4 = r2.seconds
        L_0x0052:
            j$.time.Instant r3 = create(r4, r3)
            goto L_0x006e
        L_0x0057:
            int r3 = r2.nanos
            long r0 = (long) r3
            int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r3 == 0) goto L_0x0066
            long r0 = r2.seconds
            int r3 = (int) r4
            j$.time.Instant r3 = create(r0, r3)
            goto L_0x006e
        L_0x0066:
            r3 = r2
            goto L_0x006e
        L_0x0068:
            j$.time.temporal.Temporal r3 = r3.adjustInto(r2, r4)
            j$.time.Instant r3 = (p009j$.time.Instant) r3
        L_0x006e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.Instant.with(j$.time.temporal.TemporalField, long):j$.time.temporal.Temporal");
    }
}
