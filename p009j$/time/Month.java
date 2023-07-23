package p009j$.time;

import org.spongycastle.crypto.tls.CipherSuite;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.ChronoUnit;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalAdjuster;
import p009j$.time.temporal.TemporalAdjusters;
import p009j$.time.temporal.TemporalField;
import p009j$.time.temporal.TemporalQueries;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda2;
import p009j$.time.temporal.TemporalQuery;
import p009j$.time.temporal.UnsupportedTemporalTypeException;
import p009j$.time.temporal.ValueRange;

/* renamed from: j$.time.Month */
public enum Month implements TemporalAccessor, TemporalAdjuster {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    
    private static final Month[] ENUMS = null;

    /* renamed from: j$.time.Month$1 */
    abstract /* synthetic */ class C14131 {
        static final /* synthetic */ int[] $SwitchMap$java$time$Month = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                j$.time.Month[] r0 = p009j$.time.Month.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$time$Month = r0
                j$.time.Month r1 = p009j$.time.Month.FEBRUARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x001d }
                j$.time.Month r1 = p009j$.time.Month.APRIL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x0028 }
                j$.time.Month r1 = p009j$.time.Month.JUNE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x0033 }
                j$.time.Month r1 = p009j$.time.Month.SEPTEMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x003e }
                j$.time.Month r1 = p009j$.time.Month.NOVEMBER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x0049 }
                j$.time.Month r1 = p009j$.time.Month.JANUARY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x0054 }
                j$.time.Month r1 = p009j$.time.Month.MARCH     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x0060 }
                j$.time.Month r1 = p009j$.time.Month.MAY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x006c }
                j$.time.Month r1 = p009j$.time.Month.JULY     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x0078 }
                j$.time.Month r1 = p009j$.time.Month.AUGUST     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x0084 }
                j$.time.Month r1 = p009j$.time.Month.OCTOBER     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$java$time$Month     // Catch:{ NoSuchFieldError -> 0x0090 }
                j$.time.Month r1 = p009j$.time.Month.DECEMBER     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.Month.C14131.<clinit>():void");
        }
    }

    static {
        ENUMS = values();
    }

    /* renamed from: of */
    public static Month m191of(int i) {
        if (i >= 1 && i <= 12) {
            return ENUMS[i - 1];
        }
        throw new DateTimeException("Invalid value for MonthOfYear: " + i);
    }

    public int firstDayOfYear(boolean z) {
        int i;
        switch (C14131.$SwitchMap$java$time$Month[ordinal()]) {
            case 1:
                return 32;
            case 2:
                i = 91;
                break;
            case 3:
                i = CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA;
                break;
            case 4:
                i = 244;
                break;
            case 5:
                i = 305;
                break;
            case 6:
                return 1;
            case 7:
                i = 60;
                break;
            case 8:
                i = 121;
                break;
            case 9:
                i = CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256;
                break;
            case 10:
                i = 213;
                break;
            case 11:
                i = 274;
                break;
            default:
                i = 335;
                break;
        }
        return (z ? 1 : 0) + i;
    }

    public int get(TemporalField temporalField) {
        return temporalField == ChronoField.MONTH_OF_YEAR ? getValue() : TemporalAdjusters.$default$get(this, temporalField);
    }

    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return (long) getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR : temporalField != null && temporalField.isSupportedBy(this);
    }

    public int length(boolean z) {
        int i = C14131.$SwitchMap$java$time$Month[ordinal()];
        return i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : z ? 29 : 28;
    }

    public Month plus(long j) {
        return ENUMS[((((int) (j % 12)) + 12) + ordinal()) % 12];
    }

    public Object query(TemporalQuery temporalQuery) {
        int i = TemporalQueries.$r8$clinit;
        return temporalQuery == TemporalQueries$$ExternalSyntheticLambda1.INSTANCE ? IsoChronology.INSTANCE : temporalQuery == TemporalQueries$$ExternalSyntheticLambda2.INSTANCE ? ChronoUnit.MONTHS : TemporalAdjusters.$default$query(this, temporalQuery);
    }

    public ValueRange range(TemporalField temporalField) {
        return temporalField == ChronoField.MONTH_OF_YEAR ? temporalField.range() : TemporalAdjusters.$default$range(this, temporalField);
    }
}
