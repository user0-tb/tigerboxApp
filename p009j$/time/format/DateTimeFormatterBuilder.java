package p009j$.time.format;

import com.google.android.exoplayer2.C0963C;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.CharCompanionObject;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupViewModel;
import okhttp3.internal.connection.RealConnection;
import org.spongycastle.pqc.math.linearalgebra.Matrix;
import p009j$.lang.Iterable;
import p009j$.time.Clock$SystemClock$$ExternalSyntheticOutline0;
import p009j$.time.DateTimeException;
import p009j$.time.DayOfWeek;
import p009j$.time.LocalDate;
import p009j$.time.LocalDateTime;
import p009j$.time.ZoneId;
import p009j$.time.ZoneOffset;
import p009j$.time.chrono.ChronoLocalDate;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.format.DateTimeTextProvider;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.IsoFields;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalField;
import p009j$.time.temporal.TemporalQueries;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1;
import p009j$.time.temporal.TemporalQuery;
import p009j$.time.temporal.TemporalUnit;
import p009j$.time.temporal.ValueRange;
import p009j$.time.temporal.WeekFields;
import p009j$.time.zone.ZoneRulesProvider;
import p009j$.util.concurrent.ConcurrentHashMap;

/* renamed from: j$.time.format.DateTimeFormatterBuilder */
public final class DateTimeFormatterBuilder {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Map FIELD_MAP;
    private DateTimeFormatterBuilder active;
    private final boolean optional;
    private char padNextChar;
    private int padNextWidth;
    private final DateTimeFormatterBuilder parent;
    private final List printerParsers;
    private int valueParserIndex;

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$3 */
    abstract /* synthetic */ class C14173 {
        static final /* synthetic */ int[] $SwitchMap$java$time$format$SignStyle;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                j$.time.format.SignStyle[] r0 = p009j$.time.format.SignStyle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$time$format$SignStyle = r0
                j$.time.format.SignStyle r1 = p009j$.time.format.SignStyle.EXCEEDS_PAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$time$format$SignStyle     // Catch:{ NoSuchFieldError -> 0x001d }
                j$.time.format.SignStyle r1 = p009j$.time.format.SignStyle.ALWAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$time$format$SignStyle     // Catch:{ NoSuchFieldError -> 0x0028 }
                j$.time.format.SignStyle r1 = p009j$.time.format.SignStyle.NORMAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$time$format$SignStyle     // Catch:{ NoSuchFieldError -> 0x0033 }
                j$.time.format.SignStyle r1 = p009j$.time.format.SignStyle.NOT_NEGATIVE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.DateTimeFormatterBuilder.C14173.<clinit>():void");
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$CharLiteralPrinterParser */
    final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char literal;

        CharLiteralPrinterParser(char c) {
            this.literal = c;
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.literal);
            return true;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            if (i == charSequence.length()) {
                return ~i;
            }
            char charAt = charSequence.charAt(i);
            return (charAt == this.literal || (!dateTimeParseContext.isCaseSensitive() && (Character.toUpperCase(charAt) == Character.toUpperCase(this.literal) || Character.toLowerCase(charAt) == Character.toLowerCase(this.literal)))) ? i + 1 : ~i;
        }

        public String toString() {
            if (this.literal == '\'') {
                return "''";
            }
            StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("'");
            m.append(this.literal);
            m.append("'");
            return m.toString();
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$CompositePrinterParser */
    static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean optional;
        private final DateTimePrinterParser[] printerParsers;

        CompositePrinterParser(List list, boolean z) {
            this.printerParsers = (DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]);
            this.optional = z;
        }

        CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z) {
            this.printerParsers = dateTimePrinterParserArr;
            this.optional = z;
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (this.optional) {
                dateTimePrintContext.startOptional();
            }
            try {
                for (DateTimePrinterParser format : this.printerParsers) {
                    if (!format.format(dateTimePrintContext, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
                return true;
            } finally {
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
            }
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            if (this.optional) {
                dateTimeParseContext.startOptional();
                int i2 = i;
                for (DateTimePrinterParser parse : this.printerParsers) {
                    i2 = parse.parse(dateTimeParseContext, charSequence, i2);
                    if (i2 < 0) {
                        dateTimeParseContext.endOptional(false);
                        return i;
                    }
                }
                dateTimeParseContext.endOptional(true);
                return i2;
            }
            for (DateTimePrinterParser parse2 : this.printerParsers) {
                i = parse2.parse(dateTimeParseContext, charSequence, i);
                if (i < 0) {
                    break;
                }
            }
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.printerParsers != null) {
                sb.append(this.optional ? "[" : "(");
                for (DateTimePrinterParser append : this.printerParsers) {
                    sb.append(append);
                }
                sb.append(this.optional ? "]" : ")");
            }
            return sb.toString();
        }

        public CompositePrinterParser withOptional(boolean z) {
            return z == this.optional ? this : new CompositePrinterParser(this.printerParsers, z);
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$DateTimePrinterParser */
    interface DateTimePrinterParser {
        boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb);

        int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i);
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$FractionPrinterParser */
    final class FractionPrinterParser implements DateTimePrinterParser {
        private final boolean decimalPoint;
        private final TemporalField field;
        private final int maxWidth;
        private final int minWidth;

        FractionPrinterParser(TemporalField temporalField, int i, int i2, boolean z) {
            Objects.requireNonNull(temporalField, "field");
            if (!temporalField.range().isFixed()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + temporalField);
            } else if (i < 0 || i > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i);
            } else if (i2 < 1 || i2 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i2);
            } else if (i2 >= i) {
                this.field = temporalField;
                this.minWidth = i;
                this.maxWidth = i2;
                this.decimalPoint = z;
            } else {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
            }
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            DecimalStyle decimalStyle = dateTimePrintContext.getDecimalStyle();
            long longValue = value.longValue();
            ValueRange range = this.field.range();
            range.checkValidValue(longValue, this.field);
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
            if (stripTrailingZeros.scale() != 0) {
                String convertNumberToI18N = decimalStyle.convertNumberToI18N(stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.decimalPoint) {
                    sb.append(decimalStyle.getDecimalSeparator());
                }
                sb.append(convertNumberToI18N);
                return true;
            } else if (this.minWidth <= 0) {
                return true;
            } else {
                if (this.decimalPoint) {
                    sb.append(decimalStyle.getDecimalSeparator());
                }
                for (int i = 0; i < this.minWidth; i++) {
                    sb.append(decimalStyle.getZeroDigit());
                }
                return true;
            }
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            int i3 = dateTimeParseContext.isStrict() ? this.minWidth : 0;
            int i4 = dateTimeParseContext.isStrict() ? this.maxWidth : 9;
            int length = charSequence.length();
            if (i == length) {
                return i3 > 0 ? ~i : i;
            }
            if (this.decimalPoint) {
                if (charSequence.charAt(i) != dateTimeParseContext.getDecimalStyle().getDecimalSeparator()) {
                    return i3 > 0 ? ~i : i;
                }
                i++;
            }
            int i5 = i;
            int i6 = i3 + i5;
            if (i6 > length) {
                return ~i5;
            }
            int min = Math.min(i4 + i5, length);
            int i7 = i5;
            int i8 = 0;
            while (true) {
                if (i7 >= min) {
                    i2 = i7;
                    break;
                }
                int i9 = i7 + 1;
                int convertToDigit = dateTimeParseContext.getDecimalStyle().convertToDigit(charSequence.charAt(i7));
                if (convertToDigit >= 0) {
                    i8 = (i8 * 10) + convertToDigit;
                    i7 = i9;
                } else if (i9 < i6) {
                    return ~i5;
                } else {
                    i2 = i9 - 1;
                }
            }
            BigDecimal movePointLeft = new BigDecimal(i8).movePointLeft(i2 - i5);
            ValueRange range = this.field.range();
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            return dateTimeParseContext.setParsedField(this.field, movePointLeft.multiply(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact(), i5, i2);
        }

        public String toString() {
            String str = this.decimalPoint ? ",DecimalPoint" : "";
            StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Fraction(");
            m.append(this.field);
            m.append(",");
            m.append(this.minWidth);
            m.append(",");
            m.append(this.maxWidth);
            m.append(str);
            m.append(")");
            return m.toString();
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$InstantPrinterParser */
    final class InstantPrinterParser implements DateTimePrinterParser {
        InstantPrinterParser(int i) {
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Long value = dateTimePrintContext.getValue((TemporalField) ChronoField.INSTANT_SECONDS);
            TemporalAccessor temporal = dateTimePrintContext.getTemporal();
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            Long valueOf = temporal.isSupported(chronoField) ? Long.valueOf(dateTimePrintContext.getTemporal().getLong(chronoField)) : null;
            int i = 0;
            if (value == null) {
                return false;
            }
            long longValue = value.longValue();
            int checkValidIntValue = chronoField.checkValidIntValue(valueOf != null ? valueOf.longValue() : 0);
            if (longValue >= -62167219200L) {
                long j = (longValue - 315569520000L) + 62167219200L;
                long m$2 = Iterable.CC.m$2(j, 315569520000L) + 1;
                LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(Iterable.CC.m$1(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                if (m$2 > 0) {
                    sb2.append('+');
                    sb2.append(m$2);
                }
                sb2.append(ofEpochSecond);
                if (ofEpochSecond.getSecond() == 0) {
                    sb2.append(":00");
                }
            } else {
                long j2 = longValue + 62167219200L;
                long j3 = j2 / 315569520000L;
                long j4 = j2 % 315569520000L;
                LocalDateTime ofEpochSecond2 = LocalDateTime.ofEpochSecond(j4 - 62167219200L, 0, ZoneOffset.UTC);
                int length = sb.length();
                sb2.append(ofEpochSecond2);
                if (ofEpochSecond2.getSecond() == 0) {
                    sb2.append(":00");
                }
                if (j3 < 0) {
                    if (ofEpochSecond2.getYear() == -10000) {
                        sb2.replace(length, length + 2, Long.toString(j3 - 1));
                    } else if (j4 == 0) {
                        sb2.insert(length, j3);
                    } else {
                        sb2.insert(length + 1, Math.abs(j3));
                    }
                }
            }
            if (checkValidIntValue > 0) {
                sb2.append('.');
                int i2 = 100000000;
                while (true) {
                    if (checkValidIntValue <= 0 && i % 3 == 0 && i >= -2) {
                        break;
                    }
                    int i3 = checkValidIntValue / i2;
                    sb2.append((char) (i3 + 48));
                    checkValidIntValue -= i3 * i2;
                    i2 /= 10;
                    i++;
                }
            }
            sb2.append(Matrix.MATRIX_TYPE_ZERO);
            return true;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            int i3;
            int i4 = i;
            DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder.append(DateTimeFormatter.ISO_LOCAL_DATE);
            dateTimeFormatterBuilder.appendLiteral('T');
            ChronoField chronoField = ChronoField.HOUR_OF_DAY;
            dateTimeFormatterBuilder.appendValue(chronoField, 2);
            dateTimeFormatterBuilder.appendLiteral(':');
            ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
            dateTimeFormatterBuilder.appendValue(chronoField2, 2);
            dateTimeFormatterBuilder.appendLiteral(':');
            ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
            dateTimeFormatterBuilder.appendValue(chronoField3, 2);
            ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
            int i5 = 0;
            dateTimeFormatterBuilder.appendFraction(chronoField4, 0, 9, true);
            dateTimeFormatterBuilder.appendLiteral((char) Matrix.MATRIX_TYPE_ZERO);
            CompositePrinterParser printerParser = dateTimeFormatterBuilder.toFormatter().toPrinterParser(false);
            DateTimeParseContext copy = dateTimeParseContext.copy();
            int parse = printerParser.parse(copy, charSequence, i4);
            if (parse < 0) {
                return parse;
            }
            long longValue = copy.getParsed(ChronoField.YEAR).longValue();
            int intValue = copy.getParsed(ChronoField.MONTH_OF_YEAR).intValue();
            int intValue2 = copy.getParsed(ChronoField.DAY_OF_MONTH).intValue();
            int intValue3 = copy.getParsed(chronoField).intValue();
            int intValue4 = copy.getParsed(chronoField2).intValue();
            Long parsed = copy.getParsed(chronoField3);
            Long parsed2 = copy.getParsed(chronoField4);
            int intValue5 = parsed != null ? parsed.intValue() : 0;
            int intValue6 = parsed2 != null ? parsed2.intValue() : 0;
            if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                i2 = intValue5;
                i5 = 1;
                i3 = 0;
            } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                dateTimeParseContext.setParsedLeapSecond();
                i3 = intValue3;
                i2 = 59;
            } else {
                i3 = intValue3;
                i2 = intValue5;
            }
            try {
                DateTimeParseContext dateTimeParseContext2 = dateTimeParseContext;
                int i6 = i;
                return dateTimeParseContext2.setParsedField(chronoField4, (long) intValue6, i6, dateTimeParseContext2.setParsedField(ChronoField.INSTANT_SECONDS, Iterable.CC.m$3(longValue / 10000, 315569520000L) + LocalDateTime.m187of(((int) longValue) % 10000, intValue, intValue2, i3, intValue4, i2, 0).plusDays((long) i5).toEpochSecond(ZoneOffset.UTC), i6, parse));
            } catch (RuntimeException unused) {
                return ~i4;
            }
        }

        public String toString() {
            return "Instant()";
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$NumberPrinterParser */
    class NumberPrinterParser implements DateTimePrinterParser {
        static final long[] EXCEED_POINTS = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, C0963C.NANOS_PER_SECOND, RealConnection.IDLE_CONNECTION_HEALTHY_NS};
        final TemporalField field;
        final int maxWidth;
        final int minWidth;
        /* access modifiers changed from: private */
        public final SignStyle signStyle;
        final int subsequentWidth;

        NumberPrinterParser(TemporalField temporalField, int i, int i2, SignStyle signStyle2) {
            this.field = temporalField;
            this.minWidth = i;
            this.maxWidth = i2;
            this.signStyle = signStyle2;
            this.subsequentWidth = 0;
        }

        protected NumberPrinterParser(TemporalField temporalField, int i, int i2, SignStyle signStyle2, int i3) {
            this.field = temporalField;
            this.minWidth = i;
            this.maxWidth = i2;
            this.signStyle = signStyle2;
            this.subsequentWidth = i3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x009b A[LOOP:0: B:30:0x0092->B:32:0x009b, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean format(p009j$.time.format.DateTimePrintContext r12, java.lang.StringBuilder r13) {
            /*
                r11 = this;
                j$.time.temporal.TemporalField r0 = r11.field
                java.lang.Long r0 = r12.getValue((p009j$.time.temporal.TemporalField) r0)
                r1 = 0
                if (r0 != 0) goto L_0x000a
                return r1
            L_0x000a:
                long r2 = r0.longValue()
                long r2 = r11.getValue(r12, r2)
                j$.time.format.DecimalStyle r12 = r12.getDecimalStyle()
                r4 = -9223372036854775808
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x001f
                java.lang.String r0 = "9223372036854775808"
                goto L_0x0027
            L_0x001f:
                long r4 = java.lang.Math.abs(r2)
                java.lang.String r0 = java.lang.Long.toString(r4)
            L_0x0027:
                int r4 = r0.length()
                int r5 = r11.maxWidth
                java.lang.String r6 = " cannot be printed as the value "
                java.lang.String r7 = "Field "
                if (r4 > r5) goto L_0x00a9
                r12.convertNumberToI18N(r0)
                r4 = 0
                r8 = 2
                r9 = 1
                int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                int[] r4 = p009j$.time.format.DateTimeFormatterBuilder.C14173.$SwitchMap$java$time$format$SignStyle
                j$.time.format.SignStyle r5 = r11.signStyle
                int r5 = r5.ordinal()
                if (r10 < 0) goto L_0x0060
                r4 = r4[r5]
                if (r4 == r9) goto L_0x004d
                if (r4 == r8) goto L_0x005b
                goto L_0x0092
            L_0x004d:
                int r4 = r11.minWidth
                r5 = 19
                if (r4 >= r5) goto L_0x0092
                long[] r5 = EXCEED_POINTS
                r4 = r5[r4]
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto L_0x0092
            L_0x005b:
                char r2 = r12.getPositiveSign()
                goto L_0x008f
            L_0x0060:
                r4 = r4[r5]
                if (r4 == r9) goto L_0x008b
                if (r4 == r8) goto L_0x008b
                r5 = 3
                if (r4 == r5) goto L_0x008b
                r5 = 4
                if (r4 == r5) goto L_0x006d
                goto L_0x0092
            L_0x006d:
                j$.time.DateTimeException r12 = new j$.time.DateTimeException
                java.lang.StringBuilder r13 = p009j$.time.Clock$SystemClock$$ExternalSyntheticOutline0.m183m(r7)
                j$.time.temporal.TemporalField r0 = r11.field
                r13.append(r0)
                r13.append(r6)
                r13.append(r2)
                java.lang.String r0 = " cannot be negative according to the SignStyle"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r12
            L_0x008b:
                char r2 = r12.getNegativeSign()
            L_0x008f:
                r13.append(r2)
            L_0x0092:
                int r2 = r11.minWidth
                int r3 = r0.length()
                int r2 = r2 - r3
                if (r1 >= r2) goto L_0x00a5
                char r2 = r12.getZeroDigit()
                r13.append(r2)
                int r1 = r1 + 1
                goto L_0x0092
            L_0x00a5:
                r13.append(r0)
                return r9
            L_0x00a9:
                j$.time.DateTimeException r12 = new j$.time.DateTimeException
                java.lang.StringBuilder r13 = p009j$.time.Clock$SystemClock$$ExternalSyntheticOutline0.m183m(r7)
                j$.time.temporal.TemporalField r0 = r11.field
                r13.append(r0)
                r13.append(r6)
                r13.append(r2)
                java.lang.String r0 = " exceeds the maximum print width of "
                r13.append(r0)
                int r0 = r11.maxWidth
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser.format(j$.time.format.DateTimePrintContext, java.lang.StringBuilder):boolean");
        }

        /* access modifiers changed from: package-private */
        public long getValue(DateTimePrintContext dateTimePrintContext, long j) {
            return j;
        }

        /* access modifiers changed from: package-private */
        public boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            int i = this.subsequentWidth;
            return i == -1 || (i > 0 && this.minWidth == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ee, code lost:
            r10 = r6.subsequentWidth;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f0, code lost:
            if (r10 <= 0) goto L_0x00fe;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f2, code lost:
            if (r4 != 0) goto L_0x00fe;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x013e, code lost:
            if (r0 <= r1) goto L_0x0115;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0144, code lost:
            if (r0 > r1) goto L_0x0146;
         */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x014c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parse(p009j$.time.format.DateTimeParseContext r18, java.lang.CharSequence r19, int r20) {
            /*
                r17 = this;
                r6 = r17
                r0 = r20
                int r1 = r19.length()
                if (r0 != r1) goto L_0x000c
                goto L_0x0147
            L_0x000c:
                char r2 = r19.charAt(r20)
                j$.time.format.DecimalStyle r3 = r18.getDecimalStyle()
                char r3 = r3.getPositiveSign()
                r4 = 0
                r5 = 1
                if (r2 != r3) goto L_0x0039
                j$.time.format.SignStyle r2 = r6.signStyle
                boolean r3 = r18.isStrict()
                int r7 = r6.minWidth
                int r8 = r6.maxWidth
                if (r7 != r8) goto L_0x002a
                r7 = 1
                goto L_0x002b
            L_0x002a:
                r7 = 0
            L_0x002b:
                boolean r2 = r2.parse(r5, r3, r7)
                if (r2 != 0) goto L_0x0033
                goto L_0x0147
            L_0x0033:
                int r0 = r0 + 1
                r7 = r0
                r0 = 0
                r2 = 1
                goto L_0x0070
            L_0x0039:
                j$.time.format.DecimalStyle r3 = r18.getDecimalStyle()
                char r3 = r3.getNegativeSign()
                if (r2 != r3) goto L_0x005f
                j$.time.format.SignStyle r2 = r6.signStyle
                boolean r3 = r18.isStrict()
                int r7 = r6.minWidth
                int r8 = r6.maxWidth
                if (r7 != r8) goto L_0x0051
                r7 = 1
                goto L_0x0052
            L_0x0051:
                r7 = 0
            L_0x0052:
                boolean r2 = r2.parse(r4, r3, r7)
                if (r2 != 0) goto L_0x005a
                goto L_0x0147
            L_0x005a:
                int r0 = r0 + 1
                r7 = r0
                r0 = 1
                goto L_0x006f
            L_0x005f:
                j$.time.format.SignStyle r2 = r6.signStyle
                j$.time.format.SignStyle r3 = p009j$.time.format.SignStyle.ALWAYS
                if (r2 != r3) goto L_0x006d
                boolean r2 = r18.isStrict()
                if (r2 == 0) goto L_0x006d
                goto L_0x0147
            L_0x006d:
                r7 = r0
                r0 = 0
            L_0x006f:
                r2 = 0
            L_0x0070:
                boolean r3 = r18.isStrict()
                if (r3 != 0) goto L_0x007f
                boolean r3 = r17.isFixedWidth(r18)
                if (r3 == 0) goto L_0x007d
                goto L_0x007f
            L_0x007d:
                r3 = 1
                goto L_0x0081
            L_0x007f:
                int r3 = r6.minWidth
            L_0x0081:
                int r8 = r7 + r3
                if (r8 <= r1) goto L_0x0087
                goto L_0x0146
            L_0x0087:
                boolean r9 = r18.isStrict()
                if (r9 != 0) goto L_0x0097
                boolean r9 = r17.isFixedWidth(r18)
                if (r9 == 0) goto L_0x0094
                goto L_0x0097
            L_0x0094:
                r9 = 9
                goto L_0x0099
            L_0x0097:
                int r9 = r6.maxWidth
            L_0x0099:
                int r10 = r6.subsequentWidth
                int r10 = java.lang.Math.max(r10, r4)
                int r10 = r10 + r9
            L_0x00a0:
                r9 = 0
                r11 = 2
                if (r4 >= r11) goto L_0x0100
                int r10 = r10 + r7
                int r10 = java.lang.Math.min(r10, r1)
                r11 = r7
                r14 = 0
            L_0x00ac:
                if (r11 >= r10) goto L_0x00ec
                int r16 = r11 + 1
                r5 = r19
                char r11 = r5.charAt(r11)
                j$.time.format.DecimalStyle r12 = r18.getDecimalStyle()
                int r11 = r12.convertToDigit(r11)
                if (r11 >= 0) goto L_0x00c6
                int r11 = r16 + -1
                if (r11 >= r8) goto L_0x00ee
                goto L_0x0146
            L_0x00c6:
                int r12 = r16 - r7
                r13 = 18
                if (r12 <= r13) goto L_0x00e2
                if (r9 != 0) goto L_0x00d2
                java.math.BigInteger r9 = java.math.BigInteger.valueOf(r14)
            L_0x00d2:
                java.math.BigInteger r12 = java.math.BigInteger.TEN
                java.math.BigInteger r9 = r9.multiply(r12)
                long r11 = (long) r11
                java.math.BigInteger r11 = java.math.BigInteger.valueOf(r11)
                java.math.BigInteger r9 = r9.add(r11)
                goto L_0x00e8
            L_0x00e2:
                r12 = 10
                long r14 = r14 * r12
                long r11 = (long) r11
                long r14 = r14 + r11
            L_0x00e8:
                r11 = r16
                r5 = 1
                goto L_0x00ac
            L_0x00ec:
                r5 = r19
            L_0x00ee:
                int r10 = r6.subsequentWidth
                if (r10 <= 0) goto L_0x00fe
                if (r4 != 0) goto L_0x00fe
                int r11 = r11 - r7
                int r11 = r11 - r10
                int r10 = java.lang.Math.max(r3, r11)
                int r4 = r4 + 1
                r5 = 1
                goto L_0x00a0
            L_0x00fe:
                r5 = r11
                goto L_0x0103
            L_0x0100:
                r5 = r7
                r14 = 0
            L_0x0103:
                if (r0 == 0) goto L_0x012c
                if (r9 == 0) goto L_0x011c
                java.math.BigInteger r0 = java.math.BigInteger.ZERO
                boolean r0 = r9.equals(r0)
                if (r0 == 0) goto L_0x0117
                boolean r0 = r18.isStrict()
                if (r0 == 0) goto L_0x0117
            L_0x0115:
                r0 = 1
                goto L_0x0141
            L_0x0117:
                java.math.BigInteger r9 = r9.negate()
                goto L_0x0149
            L_0x011c:
                r0 = 0
                int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x0129
                boolean r0 = r18.isStrict()
                if (r0 == 0) goto L_0x0129
                goto L_0x0140
            L_0x0129:
                long r0 = -r14
                r2 = r0
                goto L_0x014a
            L_0x012c:
                j$.time.format.SignStyle r0 = r6.signStyle
                j$.time.format.SignStyle r1 = p009j$.time.format.SignStyle.EXCEEDS_PAD
                if (r0 != r1) goto L_0x0149
                boolean r0 = r18.isStrict()
                if (r0 == 0) goto L_0x0149
                int r0 = r5 - r7
                int r1 = r6.minWidth
                if (r2 == 0) goto L_0x0144
                if (r0 > r1) goto L_0x0149
            L_0x0140:
                goto L_0x0115
            L_0x0141:
                int r7 = r7 - r0
                int r0 = ~r7
                goto L_0x0169
            L_0x0144:
                if (r0 <= r1) goto L_0x0149
            L_0x0146:
                r0 = r7
            L_0x0147:
                int r0 = ~r0
                goto L_0x0169
            L_0x0149:
                r2 = r14
            L_0x014a:
                if (r9 == 0) goto L_0x0160
                int r0 = r9.bitLength()
                r1 = 63
                if (r0 <= r1) goto L_0x015c
                java.math.BigInteger r0 = java.math.BigInteger.TEN
                java.math.BigInteger r9 = r9.divide(r0)
                int r5 = r5 + -1
            L_0x015c:
                long r2 = r9.longValue()
            L_0x0160:
                r0 = r17
                r1 = r18
                r4 = r7
                int r0 = r0.setValue(r1, r2, r4, r5)
            L_0x0169:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        /* access modifiers changed from: package-private */
        public int setValue(DateTimeParseContext dateTimeParseContext, long j, int i, int i2) {
            return dateTimeParseContext.setParsedField(this.field, j, i, i2);
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            int i = this.minWidth;
            if (i == 1 && this.maxWidth == 19 && this.signStyle == SignStyle.NORMAL) {
                sb = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Value(");
                obj = this.field;
            } else if (i == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE) {
                sb = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Value(");
                sb.append(this.field);
                sb.append(",");
                sb.append(this.minWidth);
                sb.append(")");
                return sb.toString();
            } else {
                sb = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Value(");
                sb.append(this.field);
                sb.append(",");
                sb.append(this.minWidth);
                sb.append(",");
                sb.append(this.maxWidth);
                sb.append(",");
                obj = this.signStyle;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public NumberPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, -1);
        }

        /* access modifiers changed from: package-private */
        public NumberPrinterParser withSubsequentWidth(int i) {
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, this.subsequentWidth + i);
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$OffsetIdPrinterParser */
    final class OffsetIdPrinterParser implements DateTimePrinterParser {
        static final OffsetIdPrinterParser INSTANCE_ID_Z = new OffsetIdPrinterParser("+HH:MM:ss", "Z");
        static final OffsetIdPrinterParser INSTANCE_ID_ZERO = new OffsetIdPrinterParser("+HH:MM:ss", SessionDescription.SUPPORTED_SDP_VERSION);
        static final String[] PATTERNS = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        private final String noOffsetText;
        private final int type;

        OffsetIdPrinterParser(String str, String str2) {
            Objects.requireNonNull(str, "pattern");
            Objects.requireNonNull(str2, "noOffsetText");
            int i = 0;
            while (true) {
                String[] strArr = PATTERNS;
                if (i >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                } else if (strArr[i].equals(str)) {
                    this.type = i;
                    this.noOffsetText = str2;
                    return;
                } else {
                    i++;
                }
            }
        }

        private boolean parseNumber(int[] iArr, int i, CharSequence charSequence, boolean z) {
            int i2;
            int i3 = this.type;
            if ((i3 + 3) / 2 < i) {
                return false;
            }
            int i4 = iArr[0];
            if (i3 % 2 == 0 && i > 1) {
                int i5 = i4 + 1;
                if (i5 > charSequence.length() || charSequence.charAt(i4) != ':') {
                    return z;
                }
                i4 = i5;
            }
            if (i4 + 2 > charSequence.length()) {
                return z;
            }
            int i6 = i4 + 1;
            char charAt = charSequence.charAt(i4);
            int i7 = i6 + 1;
            char charAt2 = charSequence.charAt(i6);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i2 = (charAt2 - '0') + ((charAt - '0') * 10)) < 0 || i2 > 59) {
                return z;
            }
            iArr[i] = i2;
            iArr[0] = i7;
            return false;
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue((TemporalField) ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            int m = Iterable.CC.m181m(value.longValue());
            if (m != 0) {
                int abs = Math.abs((m / TimersSetupLimitSetupViewModel.SEC_1H) % 100);
                int abs2 = Math.abs((m / 60) % 60);
                int abs3 = Math.abs(m % 60);
                int length = sb.length();
                sb.append(m < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i = this.type;
                if (i >= 3 || (i >= 1 && abs2 > 0)) {
                    String str = ":";
                    sb.append(i % 2 == 0 ? str : "");
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i2 = this.type;
                    if (i2 >= 7 || (i2 >= 5 && abs3 > 0)) {
                        if (i2 % 2 != 0) {
                            str = "";
                        }
                        sb.append(str);
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb.setLength(length);
                }
                return true;
            }
            sb.append(this.noOffsetText);
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
            if (r16.subSequenceEquals(r17, r18, r0.noOffsetText, 0, r9) != false) goto L_0x0036;
         */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parse(p009j$.time.format.DateTimeParseContext r16, java.lang.CharSequence r17, int r18) {
            /*
                r15 = this;
                r0 = r15
                r7 = r17
                r8 = r18
                int r1 = r17.length()
                java.lang.String r2 = r0.noOffsetText
                int r9 = r2.length()
                if (r9 != 0) goto L_0x0022
                if (r8 != r1) goto L_0x0041
                j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                r1 = r16
                r5 = r18
                r6 = r18
            L_0x001d:
                int r1 = r1.setParsedField(r2, r3, r5, r6)
                return r1
            L_0x0022:
                if (r8 != r1) goto L_0x0026
                int r1 = ~r8
                return r1
            L_0x0026:
                java.lang.String r4 = r0.noOffsetText
                r5 = 0
                r1 = r16
                r2 = r17
                r3 = r18
                r6 = r9
                boolean r1 = r1.subSequenceEquals(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L_0x0041
            L_0x0036:
                j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.OFFSET_SECONDS
                int r6 = r8 + r9
                r3 = 0
                r1 = r16
                r5 = r18
                goto L_0x001d
            L_0x0041:
                char r1 = r17.charAt(r18)
                r2 = 43
                r3 = 45
                if (r1 == r2) goto L_0x004d
                if (r1 != r3) goto L_0x009d
            L_0x004d:
                r2 = 1
                if (r1 != r3) goto L_0x0052
                r1 = -1
                goto L_0x0053
            L_0x0052:
                r1 = 1
            L_0x0053:
                r3 = 4
                int[] r3 = new int[r3]
                int r4 = r8 + 1
                r5 = 0
                r3[r5] = r4
                boolean r4 = r15.parseNumber(r3, r2, r7, r2)
                r6 = 2
                r10 = 3
                if (r4 != 0) goto L_0x0079
                int r4 = r0.type
                if (r4 < r10) goto L_0x0069
                r4 = 1
                goto L_0x006a
            L_0x0069:
                r4 = 0
            L_0x006a:
                boolean r4 = r15.parseNumber(r3, r6, r7, r4)
                if (r4 != 0) goto L_0x0079
                boolean r4 = r15.parseNumber(r3, r10, r7, r5)
                if (r4 == 0) goto L_0x0077
                goto L_0x0079
            L_0x0077:
                r4 = 0
                goto L_0x007a
            L_0x0079:
                r4 = 1
            L_0x007a:
                if (r4 != 0) goto L_0x009d
                long r11 = (long) r1
                r1 = r3[r2]
                long r1 = (long) r1
                r13 = 3600(0xe10, double:1.7786E-320)
                long r1 = r1 * r13
                r4 = r3[r6]
                long r6 = (long) r4
                r13 = 60
                long r6 = r6 * r13
                long r6 = r6 + r1
                r1 = r3[r10]
                long r1 = (long) r1
                long r6 = r6 + r1
                long r6 = r6 * r11
                j$.time.temporal.ChronoField r2 = p009j$.time.temporal.ChronoField.OFFSET_SECONDS
                r9 = r3[r5]
                r1 = r16
                r3 = r6
                r5 = r18
                r6 = r9
                goto L_0x001d
            L_0x009d:
                if (r9 != 0) goto L_0x00a0
                goto L_0x0036
            L_0x00a0:
                int r1 = ~r8
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public String toString() {
            String replace = this.noOffsetText.replace("'", "''");
            StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Offset(");
            m.append(PATTERNS[this.type]);
            m.append(",'");
            m.append(replace);
            m.append("')");
            return m.toString();
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$PadPrinterParserDecorator */
    final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final char padChar;
        private final int padWidth;
        private final DateTimePrinterParser printerParser;

        PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i, char c) {
            this.printerParser = dateTimePrinterParser;
            this.padWidth = i;
            this.padChar = c;
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (!this.printerParser.format(dateTimePrintContext, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 <= this.padWidth) {
                for (int i = 0; i < this.padWidth - length2; i++) {
                    sb.insert(length, this.padChar);
                }
                return true;
            }
            throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.padWidth);
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            boolean isStrict = dateTimeParseContext.isStrict();
            if (i > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            } else if (i == charSequence.length()) {
                return ~i;
            } else {
                int i2 = this.padWidth + i;
                if (i2 > charSequence.length()) {
                    if (isStrict) {
                        return ~i;
                    }
                    i2 = charSequence.length();
                }
                int i3 = i;
                while (i3 < i2 && dateTimeParseContext.charEquals(charSequence.charAt(i3), this.padChar)) {
                    i3++;
                }
                int parse = this.printerParser.parse(dateTimeParseContext, charSequence.subSequence(0, i2), i3);
                return (parse == i2 || !isStrict) ? parse : ~(i + i3);
            }
        }

        public String toString() {
            String str;
            StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Pad(");
            m.append(this.printerParser);
            m.append(",");
            m.append(this.padWidth);
            if (this.padChar == ' ') {
                str = ")";
            } else {
                StringBuilder m2 = Clock$SystemClock$$ExternalSyntheticOutline0.m183m(",'");
                m2.append(this.padChar);
                m2.append("')");
                str = m2.toString();
            }
            m.append(str);
            return m.toString();
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$PrefixTree */
    class PrefixTree {

        /* renamed from: c0 */
        protected char f230c0;
        protected PrefixTree child;
        protected String key;
        protected PrefixTree sibling;
        protected String value;

        /* renamed from: j$.time.format.DateTimeFormatterBuilder$PrefixTree$CI */
        class C1418CI extends PrefixTree {
            private C1418CI(String str, String str2, PrefixTree prefixTree) {
                super(str, str2, prefixTree);
            }

            C1418CI(String str, String str2, PrefixTree prefixTree, C14161 r4) {
                super(str, (String) null, (PrefixTree) null);
            }

            /* access modifiers changed from: protected */
            public boolean isEqual(char c, char c2) {
                return DateTimeParseContext.charEqualsIgnoreCase(c, c2);
            }

            /* access modifiers changed from: protected */
            public PrefixTree newNode(String str, String str2, PrefixTree prefixTree) {
                return new C1418CI(str, str2, prefixTree);
            }

            /* access modifiers changed from: protected */
            public boolean prefixOf(CharSequence charSequence, int i, int i2) {
                int length = this.key.length();
                if (length > i2 - i) {
                    return false;
                }
                int i3 = 0;
                while (true) {
                    int i4 = length - 1;
                    if (length <= 0) {
                        return true;
                    }
                    int i5 = i3 + 1;
                    int i6 = i + 1;
                    if (!DateTimeParseContext.charEqualsIgnoreCase(this.key.charAt(i3), charSequence.charAt(i))) {
                        return false;
                    }
                    i = i6;
                    length = i4;
                    i3 = i5;
                }
            }
        }

        private PrefixTree(String str, String str2, PrefixTree prefixTree) {
            this.key = str;
            this.value = str2;
            this.child = prefixTree;
            this.f230c0 = str.length() == 0 ? CharCompanionObject.MAX_VALUE : this.key.charAt(0);
        }

        private boolean add0(String str, String str2) {
            int i = 0;
            while (i < str.length() && i < this.key.length() && isEqual(str.charAt(i), this.key.charAt(i))) {
                i++;
            }
            if (i != this.key.length()) {
                PrefixTree newNode = newNode(this.key.substring(i), this.value, this.child);
                this.key = str.substring(0, i);
                this.child = newNode;
                if (i < str.length()) {
                    this.child.sibling = newNode(str.substring(i), str2, (PrefixTree) null);
                    this.value = null;
                } else {
                    this.value = str2;
                }
                return true;
            } else if (i < str.length()) {
                String substring = str.substring(i);
                for (PrefixTree prefixTree = this.child; prefixTree != null; prefixTree = prefixTree.sibling) {
                    if (isEqual(prefixTree.f230c0, substring.charAt(0))) {
                        return prefixTree.add0(substring, str2);
                    }
                }
                PrefixTree newNode2 = newNode(substring, str2, (PrefixTree) null);
                newNode2.sibling = this.child;
                this.child = newNode2;
                return true;
            } else {
                this.value = str2;
                return true;
            }
        }

        public static PrefixTree newTree(DateTimeParseContext dateTimeParseContext) {
            return dateTimeParseContext.isCaseSensitive() ? new PrefixTree("", (String) null, (PrefixTree) null) : new C1418CI("", (String) null, (PrefixTree) null, (C14161) null);
        }

        public static PrefixTree newTree(Set set, DateTimeParseContext dateTimeParseContext) {
            PrefixTree newTree = newTree(dateTimeParseContext);
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                newTree.add0(str, str);
            }
            return newTree;
        }

        public boolean add(String str, String str2) {
            return add0(str, str2);
        }

        /* access modifiers changed from: protected */
        public boolean isEqual(char c, char c2) {
            return c == c2;
        }

        public String match(CharSequence charSequence, ParsePosition parsePosition) {
            int index = parsePosition.getIndex();
            int length = charSequence.length();
            if (!prefixOf(charSequence, index, length)) {
                return null;
            }
            int length2 = this.key.length() + index;
            PrefixTree prefixTree = this.child;
            if (prefixTree != null && length2 != length) {
                while (true) {
                    if (!isEqual(prefixTree.f230c0, charSequence.charAt(length2))) {
                        prefixTree = prefixTree.sibling;
                        if (prefixTree == null) {
                            break;
                        }
                    } else {
                        parsePosition.setIndex(length2);
                        String match = prefixTree.match(charSequence, parsePosition);
                        if (match != null) {
                            return match;
                        }
                    }
                }
            }
            parsePosition.setIndex(length2);
            return this.value;
        }

        /* access modifiers changed from: protected */
        public PrefixTree newNode(String str, String str2, PrefixTree prefixTree) {
            return new PrefixTree(str, str2, prefixTree);
        }

        /* access modifiers changed from: protected */
        public boolean prefixOf(CharSequence charSequence, int i, int i2) {
            if (charSequence instanceof String) {
                return ((String) charSequence).startsWith(this.key, i);
            }
            int length = this.key.length();
            if (length > i2 - i) {
                return false;
            }
            int i3 = 0;
            while (true) {
                int i4 = length - 1;
                if (length <= 0) {
                    return true;
                }
                int i5 = i3 + 1;
                int i6 = i + 1;
                if (!isEqual(this.key.charAt(i3), charSequence.charAt(i))) {
                    return false;
                }
                i = i6;
                length = i4;
                i3 = i5;
            }
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$ReducedPrinterParser */
    final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate BASE_DATE = LocalDate.m185of(2000, 1, 1);
        private final ChronoLocalDate baseDate;
        private final int baseValue;

        ReducedPrinterParser(TemporalField temporalField, int i, int i2, int i3, ChronoLocalDate chronoLocalDate) {
            this(temporalField, i, i2, i3, chronoLocalDate, 0);
            if (i < 1 || i > 10) {
                throw new IllegalArgumentException("The minWidth must be from 1 to 10 inclusive but was " + i);
            } else if (i2 < 1 || i2 > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
            }
        }

        private ReducedPrinterParser(TemporalField temporalField, int i, int i2, int i3, ChronoLocalDate chronoLocalDate, int i4) {
            super(temporalField, i, i2, SignStyle.NOT_NEGATIVE, i4);
            this.baseValue = i3;
            this.baseDate = chronoLocalDate;
        }

        /* access modifiers changed from: package-private */
        public long getValue(DateTimePrintContext dateTimePrintContext, long j) {
            long j2;
            long abs = Math.abs(j);
            int i = this.baseValue;
            if (this.baseDate != null) {
                Chronology.CC.from(dateTimePrintContext.getTemporal());
                i = LocalDate.from(this.baseDate).get(this.field);
            }
            long j3 = (long) i;
            if (j >= j3) {
                long[] jArr = NumberPrinterParser.EXCEED_POINTS;
                int i2 = this.minWidth;
                if (j < j3 + jArr[i2]) {
                    j2 = jArr[i2];
                    return abs % j2;
                }
            }
            j2 = NumberPrinterParser.EXCEED_POINTS[this.maxWidth];
            return abs % j2;
        }

        /* access modifiers changed from: package-private */
        public boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            if (!dateTimeParseContext.isStrict()) {
                return false;
            }
            return super.isFixedWidth(dateTimeParseContext);
        }

        /* access modifiers changed from: package-private */
        public int setValue(DateTimeParseContext dateTimeParseContext, long j, int i, int i2) {
            int i3 = this.baseValue;
            if (this.baseDate != null) {
                dateTimeParseContext.getEffectiveChronology();
                i3 = LocalDate.from(this.baseDate).get(this.field);
                dateTimeParseContext.addChronoChangedListener(new C1419xdc213142(this, dateTimeParseContext, j, i, i2));
            }
            int i4 = i2 - i;
            int i5 = this.minWidth;
            if (i4 == i5 && j >= 0) {
                long j2 = NumberPrinterParser.EXCEED_POINTS[i5];
                long j3 = (long) i3;
                long j4 = j3 - (j3 % j2);
                j = i3 > 0 ? j4 + j : j4 - j;
                if (j < j3) {
                    j += j2;
                }
            }
            return dateTimeParseContext.setParsedField(this.field, j, i, i2);
        }

        public String toString() {
            StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("ReducedValue(");
            m.append(this.field);
            m.append(",");
            m.append(this.minWidth);
            m.append(",");
            m.append(this.maxWidth);
            m.append(",");
            Object obj = this.baseDate;
            if (obj == null) {
                obj = Integer.valueOf(this.baseValue);
            }
            m.append(obj);
            m.append(")");
            return m.toString();
        }

        /* access modifiers changed from: package-private */
        public NumberPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, -1);
        }

        /* access modifiers changed from: package-private */
        public NumberPrinterParser withSubsequentWidth(int i) {
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, this.subsequentWidth + i);
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$SettingsParser */
    enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                dateTimeParseContext.setCaseSensitive(true);
            } else if (ordinal == 1) {
                dateTimeParseContext.setCaseSensitive(false);
            } else if (ordinal == 2) {
                dateTimeParseContext.setStrict(true);
            } else if (ordinal == 3) {
                dateTimeParseContext.setStrict(false);
            }
            return i;
        }

        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (ordinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (ordinal == 2) {
                return "ParseStrict(true)";
            }
            if (ordinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$StringLiteralPrinterParser */
    final class StringLiteralPrinterParser implements DateTimePrinterParser {
        public final /* synthetic */ int $r8$classId = 1;
        private final Object literal;

        public StringLiteralPrinterParser(TextStyle textStyle) {
            this.literal = textStyle;
        }

        private static StringBuilder appendHMS(StringBuilder sb, int i) {
            sb.append((char) ((i / 10) + 48));
            sb.append((char) ((i % 10) + 48));
            return sb;
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            switch (this.$r8$classId) {
                case 0:
                    sb.append((String) this.literal);
                    return true;
                default:
                    Long value = dateTimePrintContext.getValue((TemporalField) ChronoField.OFFSET_SECONDS);
                    if (value == null) {
                        return false;
                    }
                    sb.append("GMT");
                    int m = Iterable.CC.m181m(value.longValue());
                    if (m == 0) {
                        return true;
                    }
                    int abs = Math.abs((m / TimersSetupLimitSetupViewModel.SEC_1H) % 100);
                    int abs2 = Math.abs((m / 60) % 60);
                    int abs3 = Math.abs(m % 60);
                    sb.append(m < 0 ? "-" : "+");
                    if (((TextStyle) this.literal) == TextStyle.FULL) {
                        appendHMS(sb, abs);
                        sb.append(':');
                        appendHMS(sb, abs2);
                        if (abs3 == 0) {
                            return true;
                        }
                    } else {
                        if (abs >= 10) {
                            sb.append((char) ((abs / 10) + 48));
                        }
                        sb.append((char) ((abs % 10) + 48));
                        if (abs2 == 0 && abs3 == 0) {
                            return true;
                        }
                        sb.append(':');
                        appendHMS(sb, abs2);
                        if (abs3 == 0) {
                            return true;
                        }
                    }
                    sb.append(':');
                    appendHMS(sb, abs3);
                    return true;
            }
        }

        /* access modifiers changed from: package-private */
        public int getDigit(CharSequence charSequence, int i) {
            char charAt = charSequence.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return -1;
            }
            return charAt - '0';
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
            if (r14 >= 0) goto L_0x0107;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0105, code lost:
            if (r14 >= 0) goto L_0x0107;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parse(p009j$.time.format.DateTimeParseContext r13, java.lang.CharSequence r14, int r15) {
            /*
                r12 = this;
                int r0 = r12.$r8$classId
                switch(r0) {
                    case 0: goto L_0x0006;
                    default: goto L_0x0005;
                }
            L_0x0005:
                goto L_0x0033
            L_0x0006:
                int r0 = r14.length()
                if (r15 > r0) goto L_0x002d
                if (r15 < 0) goto L_0x002d
                java.lang.Object r0 = r12.literal
                r4 = r0
                java.lang.String r4 = (java.lang.String) r4
                int r6 = r4.length()
                r5 = 0
                r1 = r13
                r2 = r14
                r3 = r15
                boolean r13 = r1.subSequenceEquals(r2, r3, r4, r5, r6)
                if (r13 != 0) goto L_0x0023
                int r13 = ~r15
                goto L_0x002c
            L_0x0023:
                java.lang.Object r13 = r12.literal
                java.lang.String r13 = (java.lang.String) r13
                int r13 = r13.length()
                int r13 = r13 + r15
            L_0x002c:
                return r13
            L_0x002d:
                java.lang.IndexOutOfBoundsException r13 = new java.lang.IndexOutOfBoundsException
                r13.<init>()
                throw r13
            L_0x0033:
                int r0 = r14.length()
                int r0 = r0 + r15
                r5 = 0
                r6 = 3
                java.lang.String r4 = "GMT"
                r1 = r13
                r2 = r14
                r3 = r15
                boolean r1 = r1.subSequenceEquals(r2, r3, r4, r5, r6)
                if (r1 != 0) goto L_0x0047
                goto L_0x00ba
            L_0x0047:
                int r1 = r15 + 3
                if (r1 != r0) goto L_0x004d
                goto L_0x0126
            L_0x004d:
                char r2 = r14.charAt(r1)
                r3 = 43
                if (r2 != r3) goto L_0x0057
                r2 = 1
                goto L_0x005c
            L_0x0057:
                r3 = 45
                if (r2 != r3) goto L_0x0126
                r2 = -1
            L_0x005c:
                int r1 = r1 + 1
                java.lang.Object r3 = r12.literal
                j$.time.format.TextStyle r3 = (p009j$.time.format.TextStyle) r3
                j$.time.format.TextStyle r4 = p009j$.time.format.TextStyle.FULL
                r5 = 58
                r6 = 0
                if (r3 != r4) goto L_0x00b2
                int r3 = r1 + 1
                int r1 = r12.getDigit(r14, r1)
                int r4 = r3 + 1
                int r3 = r12.getDigit(r14, r3)
                if (r1 < 0) goto L_0x00ba
                if (r3 < 0) goto L_0x00ba
                int r7 = r4 + 1
                char r4 = r14.charAt(r4)
                if (r4 == r5) goto L_0x0082
                goto L_0x00ba
            L_0x0082:
                int r1 = r1 * 10
                int r1 = r1 + r3
                int r3 = r7 + 1
                int r4 = r12.getDigit(r14, r7)
                int r7 = r3 + 1
                int r3 = r12.getDigit(r14, r3)
                if (r4 < 0) goto L_0x00ba
                if (r3 >= 0) goto L_0x0096
                goto L_0x00ba
            L_0x0096:
                int r4 = r4 * 10
                int r4 = r4 + r3
                int r3 = r7 + 2
                if (r3 >= r0) goto L_0x0110
                char r0 = r14.charAt(r7)
                if (r0 != r5) goto L_0x0110
                int r0 = r7 + 1
                int r0 = r12.getDigit(r14, r0)
                int r14 = r12.getDigit(r14, r3)
                if (r0 < 0) goto L_0x0110
                if (r14 < 0) goto L_0x0110
                goto L_0x0107
            L_0x00b2:
                int r3 = r1 + 1
                int r1 = r12.getDigit(r14, r1)
                if (r1 >= 0) goto L_0x00bd
            L_0x00ba:
                int r13 = ~r15
                goto L_0x0133
            L_0x00bd:
                if (r3 >= r0) goto L_0x010e
                int r4 = r12.getDigit(r14, r3)
                if (r4 < 0) goto L_0x00ca
                int r1 = r1 * 10
                int r1 = r1 + r4
                int r3 = r3 + 1
            L_0x00ca:
                int r4 = r3 + 2
                if (r4 >= r0) goto L_0x010e
                char r7 = r14.charAt(r3)
                if (r7 != r5) goto L_0x010e
                if (r4 >= r0) goto L_0x010e
                char r7 = r14.charAt(r3)
                if (r7 != r5) goto L_0x010e
                int r7 = r3 + 1
                int r7 = r12.getDigit(r14, r7)
                int r4 = r12.getDigit(r14, r4)
                if (r7 < 0) goto L_0x010e
                if (r4 < 0) goto L_0x010e
                int r7 = r7 * 10
                int r4 = r4 + r7
                int r7 = r3 + 3
                int r3 = r7 + 2
                if (r3 >= r0) goto L_0x0110
                char r0 = r14.charAt(r7)
                if (r0 != r5) goto L_0x0110
                int r0 = r7 + 1
                int r0 = r12.getDigit(r14, r0)
                int r14 = r12.getDigit(r14, r3)
                if (r0 < 0) goto L_0x0110
                if (r14 < 0) goto L_0x0110
            L_0x0107:
                int r0 = r0 * 10
                int r6 = r0 + r14
                int r7 = r7 + 3
                goto L_0x0110
            L_0x010e:
                r7 = r3
                r4 = 0
            L_0x0110:
                long r2 = (long) r2
                long r0 = (long) r1
                r8 = 3600(0xe10, double:1.7786E-320)
                long r0 = r0 * r8
                long r4 = (long) r4
                r8 = 60
                long r4 = r4 * r8
                long r4 = r4 + r0
                long r0 = (long) r6
                long r4 = r4 + r0
                long r4 = r4 * r2
                j$.time.temporal.ChronoField r14 = p009j$.time.temporal.ChronoField.OFFSET_SECONDS
                r8 = r4
                r11 = r7
                r7 = r14
                goto L_0x012d
            L_0x0126:
                j$.time.temporal.ChronoField r14 = p009j$.time.temporal.ChronoField.OFFSET_SECONDS
                r4 = 0
                r7 = r14
                r11 = r1
                r8 = r4
            L_0x012d:
                r6 = r13
                r10 = r15
                int r13 = r6.setParsedField(r7, r8, r10, r11)
            L_0x0133:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.DateTimeFormatterBuilder.StringLiteralPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 0:
                    String replace = ((String) this.literal).replace("'", "''");
                    return "'" + replace + "'";
                default:
                    return "LocalizedOffset(" + ((TextStyle) this.literal) + ")";
            }
        }

        public StringLiteralPrinterParser(String str) {
            this.literal = str;
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$TextPrinterParser */
    final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField field;
        private volatile NumberPrinterParser numberPrinterParser;
        private final DateTimeTextProvider provider;
        private final TextStyle textStyle;

        TextPrinterParser(TemporalField temporalField, TextStyle textStyle2, DateTimeTextProvider dateTimeTextProvider) {
            this.field = temporalField;
            this.textStyle = textStyle2;
            this.provider = dateTimeTextProvider;
        }

        private NumberPrinterParser numberPrinterParser() {
            if (this.numberPrinterParser == null) {
                this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
            }
            return this.numberPrinterParser;
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            String str;
            IsoChronology isoChronology;
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            TemporalAccessor temporal = dateTimePrintContext.getTemporal();
            int i = TemporalQueries.$r8$clinit;
            Chronology chronology = (Chronology) temporal.query(TemporalQueries$$ExternalSyntheticLambda1.INSTANCE);
            if (chronology == null || chronology == (isoChronology = IsoChronology.INSTANCE)) {
                str = this.provider.getText(this.field, value.longValue(), this.textStyle, dateTimePrintContext.getLocale());
            } else {
                DateTimeTextProvider dateTimeTextProvider = this.provider;
                TemporalField temporalField = this.field;
                long longValue = value.longValue();
                TextStyle textStyle2 = this.textStyle;
                Locale locale = dateTimePrintContext.getLocale();
                Objects.requireNonNull(dateTimeTextProvider);
                str = (chronology == isoChronology || !(temporalField instanceof ChronoField)) ? dateTimeTextProvider.getText(temporalField, longValue, textStyle2, locale) : null;
            }
            if (str == null) {
                return numberPrinterParser().format(dateTimePrintContext, sb);
            }
            sb.append(str);
            return true;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            Iterator it;
            int length = charSequence.length();
            if (i < 0 || i > length) {
                throw new IndexOutOfBoundsException();
            }
            Iterator it2 = null;
            TextStyle textStyle2 = dateTimeParseContext.isStrict() ? this.textStyle : null;
            Chronology effectiveChronology = dateTimeParseContext.getEffectiveChronology();
            IsoChronology isoChronology = IsoChronology.INSTANCE;
            if (effectiveChronology == isoChronology) {
                it = this.provider.getTextIterator(this.field, textStyle2, dateTimeParseContext.getLocale());
            } else {
                DateTimeTextProvider dateTimeTextProvider = this.provider;
                TemporalField temporalField = this.field;
                Locale locale = dateTimeParseContext.getLocale();
                Objects.requireNonNull(dateTimeTextProvider);
                if (effectiveChronology == isoChronology || !(temporalField instanceof ChronoField)) {
                    it2 = dateTimeTextProvider.getTextIterator(temporalField, textStyle2, locale);
                }
                it = it2;
            }
            if (it != null) {
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String str = (String) entry.getKey();
                    if (dateTimeParseContext.subSequenceEquals(str, 0, charSequence, i, str.length())) {
                        return dateTimeParseContext.setParsedField(this.field, ((Long) entry.getValue()).longValue(), i, str.length() + i);
                    }
                }
                if (dateTimeParseContext.isStrict()) {
                    return ~i;
                }
            }
            return numberPrinterParser().parse(dateTimeParseContext, charSequence, i);
        }

        public String toString() {
            Object obj;
            StringBuilder sb;
            if (this.textStyle == TextStyle.FULL) {
                sb = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Text(");
                obj = this.field;
            } else {
                sb = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Text(");
                sb.append(this.field);
                sb.append(",");
                obj = this.textStyle;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$WeekBasedFieldPrinterParser */
    final class WeekBasedFieldPrinterParser implements DateTimePrinterParser {
        private char chr;
        private int count;

        WeekBasedFieldPrinterParser(char c, int i) {
            this.chr = c;
            this.count = i;
        }

        private DateTimePrinterParser printerParser(Locale locale) {
            TemporalField temporalField;
            TemporalUnit temporalUnit = WeekFields.WEEK_BASED_YEARS;
            Objects.requireNonNull(locale, "locale");
            Calendar instance = Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry()));
            WeekFields of = WeekFields.m199of(DayOfWeek.SUNDAY.plus((long) (instance.getFirstDayOfWeek() - 1)), instance.getMinimalDaysInFirstWeek());
            char c = this.chr;
            if (c == 'W') {
                temporalField = of.weekOfMonth();
            } else if (c == 'Y') {
                TemporalField weekBasedYear = of.weekBasedYear();
                int i = this.count;
                if (i == 2) {
                    return new ReducedPrinterParser(weekBasedYear, 2, 2, 0, ReducedPrinterParser.BASE_DATE, 0);
                }
                return new NumberPrinterParser(weekBasedYear, i, 19, i < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, -1);
            } else if (c == 'c' || c == 'e') {
                temporalField = of.dayOfWeek();
            } else if (c == 'w') {
                temporalField = of.weekOfWeekBasedYear();
            } else {
                throw new IllegalStateException("unreachable");
            }
            return new NumberPrinterParser(temporalField, this.count == 2 ? 2 : 1, 2, SignStyle.NOT_NEGATIVE);
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return ((NumberPrinterParser) printerParser(dateTimePrintContext.getLocale())).format(dateTimePrintContext, sb);
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            return ((NumberPrinterParser) printerParser(dateTimeParseContext.getLocale())).parse(dateTimeParseContext, charSequence, i);
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            char c = this.chr;
            if (c == 'Y') {
                int i = this.count;
                if (i == 1) {
                    str2 = "WeekBasedYear";
                } else if (i == 2) {
                    str2 = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
                } else {
                    sb.append("WeekBasedYear,");
                    sb.append(this.count);
                    sb.append(",");
                    sb.append(19);
                    sb.append(",");
                    sb.append(this.count < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD);
                }
                sb.append(str2);
            } else {
                if (c == 'W') {
                    str = "WeekOfMonth";
                } else if (c == 'c' || c == 'e') {
                    str = "DayOfWeek";
                } else {
                    if (c == 'w') {
                        str = "WeekOfWeekBasedYear";
                    }
                    sb.append(",");
                    sb.append(this.count);
                }
                sb.append(str);
                sb.append(",");
                sb.append(this.count);
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$ZoneIdPrinterParser */
    class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry cachedPrefixTree;
        private static volatile Map.Entry cachedPrefixTreeCI;
        private final String description;
        private final TemporalQuery query;

        ZoneIdPrinterParser(TemporalQuery temporalQuery, String str) {
            this.query = temporalQuery;
            this.description = str;
        }

        private int parseOffsetBased(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i, int i2, OffsetIdPrinterParser offsetIdPrinterParser) {
            String upperCase = charSequence.toString().substring(i, i2).toUpperCase();
            if (i2 < charSequence.length() && charSequence.charAt(i2) != '0' && !dateTimeParseContext.charEquals(charSequence.charAt(i2), Matrix.MATRIX_TYPE_ZERO)) {
                DateTimeParseContext copy = dateTimeParseContext.copy();
                int parse = offsetIdPrinterParser.parse(copy, charSequence, i2);
                if (parse < 0) {
                    try {
                        if (offsetIdPrinterParser == OffsetIdPrinterParser.INSTANCE_ID_Z) {
                            return ~i;
                        }
                        dateTimeParseContext.setParsed(ZoneId.m192of(upperCase));
                        return i2;
                    } catch (DateTimeException unused) {
                        return ~i;
                    }
                } else {
                    dateTimeParseContext.setParsed(ZoneId.ofOffset(upperCase, ZoneOffset.ofTotalSeconds((int) copy.getParsed(ChronoField.OFFSET_SECONDS).longValue())));
                    return parse;
                }
            } else {
                dateTimeParseContext.setParsed(ZoneId.m192of(upperCase));
                return i2;
            }
        }

        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(this.query);
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.getId());
            return true;
        }

        /* access modifiers changed from: protected */
        public PrefixTree getTree(DateTimeParseContext dateTimeParseContext) {
            Set availableZoneIds = ZoneRulesProvider.getAvailableZoneIds();
            int size = ((HashSet) availableZoneIds).size();
            Map.Entry entry = dateTimeParseContext.isCaseSensitive() ? cachedPrefixTree : cachedPrefixTreeCI;
            if (entry == null || ((Integer) entry.getKey()).intValue() != size) {
                synchronized (this) {
                    Map.Entry entry2 = dateTimeParseContext.isCaseSensitive() ? cachedPrefixTree : cachedPrefixTreeCI;
                    if (entry2 == null || ((Integer) entry2.getKey()).intValue() != size) {
                        entry2 = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), PrefixTree.newTree(availableZoneIds, dateTimeParseContext));
                        if (dateTimeParseContext.isCaseSensitive()) {
                            cachedPrefixTree = entry2;
                        } else {
                            cachedPrefixTreeCI = entry2;
                        }
                    }
                }
            }
            return (PrefixTree) entry.getValue();
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            int length = charSequence.length();
            if (i > length) {
                throw new IndexOutOfBoundsException();
            } else if (i == length) {
                return ~i;
            } else {
                char charAt = charSequence.charAt(i);
                if (charAt == '+' || charAt == '-') {
                    return parseOffsetBased(dateTimeParseContext, charSequence, i, i, OffsetIdPrinterParser.INSTANCE_ID_Z);
                }
                int i3 = i + 2;
                if (length >= i3) {
                    char charAt2 = charSequence.charAt(i + 1);
                    if (dateTimeParseContext.charEquals(charAt, Matrix.MATRIX_TYPE_RANDOM_UT) && dateTimeParseContext.charEquals(charAt2, 'T')) {
                        int i4 = i + 3;
                        if (length < i4 || !dateTimeParseContext.charEquals(charSequence.charAt(i3), 'C')) {
                            return parseOffsetBased(dateTimeParseContext, charSequence, i, i3, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                        }
                        return parseOffsetBased(dateTimeParseContext, charSequence, i, i4, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                    } else if (dateTimeParseContext.charEquals(charAt, 'G') && length >= (i2 = i + 3) && dateTimeParseContext.charEquals(charAt2, 'M') && dateTimeParseContext.charEquals(charSequence.charAt(i3), 'T')) {
                        return parseOffsetBased(dateTimeParseContext, charSequence, i, i2, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                    }
                }
                PrefixTree tree = getTree(dateTimeParseContext);
                ParsePosition parsePosition = new ParsePosition(i);
                String match = tree.match(charSequence, parsePosition);
                if (match != null) {
                    dateTimeParseContext.setParsed(ZoneId.m192of(match));
                    return parsePosition.getIndex();
                } else if (!dateTimeParseContext.charEquals(charAt, Matrix.MATRIX_TYPE_ZERO)) {
                    return ~i;
                } else {
                    dateTimeParseContext.setParsed(ZoneOffset.UTC);
                    return i + 1;
                }
            }
        }

        public String toString() {
            return this.description;
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$ZoneTextPrinterParser */
    final class ZoneTextPrinterParser extends ZoneIdPrinterParser {
        private static final Map cache = new ConcurrentHashMap();
        private final Map cachedTree = new HashMap();
        private final Map cachedTreeCI = new HashMap();
        private Set preferredZones;
        private final TextStyle textStyle;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ZoneTextPrinterParser(p009j$.time.format.TextStyle r3, java.util.Set r4) {
            /*
                r2 = this;
                int r4 = p009j$.time.temporal.TemporalQueries.$r8$clinit
                j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda4 r4 = p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda4.INSTANCE
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "ZoneText("
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r2.<init>(r4, r0)
                java.util.HashMap r4 = new java.util.HashMap
                r4.<init>()
                r2.cachedTree = r4
                java.util.HashMap r4 = new java.util.HashMap
                r4.<init>()
                r2.cachedTreeCI = r4
                java.lang.String r4 = "textStyle"
                java.util.Objects.requireNonNull(r3, r4)
                r2.textStyle = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.DateTimeFormatterBuilder.ZoneTextPrinterParser.<init>(j$.time.format.TextStyle, java.util.Set):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: j$.util.concurrent.ConcurrentHashMap} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: j$.util.concurrent.ConcurrentHashMap} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.util.Map} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.lang.String} */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
            if (r5 == null) goto L_0x0060;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean format(p009j$.time.format.DateTimePrintContext r13, java.lang.StringBuilder r14) {
            /*
                r12 = this;
                int r0 = p009j$.time.temporal.TemporalQueries.$r8$clinit
                j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0 r0 = p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0.INSTANCE
                java.lang.Object r0 = r13.getValue((p009j$.time.temporal.TemporalQuery) r0)
                j$.time.ZoneId r0 = (p009j$.time.ZoneId) r0
                r1 = 0
                if (r0 != 0) goto L_0x000e
                return r1
            L_0x000e:
                java.lang.String r2 = r0.getId()
                boolean r3 = r0 instanceof p009j$.time.ZoneOffset
                r4 = 1
                if (r3 != 0) goto L_0x00b2
                j$.time.temporal.TemporalAccessor r3 = r13.getTemporal()
                j$.time.temporal.ChronoField r5 = p009j$.time.temporal.ChronoField.INSTANT_SECONDS
                boolean r5 = r3.isSupported(r5)
                r6 = 2
                if (r5 == 0) goto L_0x0036
                j$.time.zone.ZoneRules r0 = r0.getRules()
                j$.time.Instant r3 = p009j$.time.Instant.from(r3)
                boolean r0 = r0.isDaylightSavings(r3)
                if (r0 == 0) goto L_0x0034
                r0 = 1
                goto L_0x0037
            L_0x0034:
                r0 = 0
                goto L_0x0037
            L_0x0036:
                r0 = 2
            L_0x0037:
                java.util.Locale r13 = r13.getLocale()
                j$.time.format.TextStyle r3 = r12.textStyle
                j$.time.format.TextStyle r5 = p009j$.time.format.TextStyle.NARROW
                r7 = 0
                if (r3 != r5) goto L_0x0043
                goto L_0x00af
            L_0x0043:
                java.util.Map r3 = cache
                java.lang.Object r5 = r3.get(r2)
                java.lang.ref.SoftReference r5 = (java.lang.ref.SoftReference) r5
                r8 = 5
                r9 = 3
                if (r5 == 0) goto L_0x0060
                java.lang.Object r5 = r5.get()
                r7 = r5
                java.util.Map r7 = (java.util.Map) r7
                if (r7 == 0) goto L_0x0060
                java.lang.Object r5 = r7.get(r13)
                java.lang.String[] r5 = (java.lang.String[]) r5
                if (r5 != 0) goto L_0x009a
            L_0x0060:
                java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r2)
                r10 = 7
                java.lang.String[] r10 = new java.lang.String[r10]
                r10[r1] = r2
                java.lang.String r11 = r5.getDisplayName(r1, r4, r13)
                r10[r4] = r11
                java.lang.String r11 = r5.getDisplayName(r1, r1, r13)
                r10[r6] = r11
                java.lang.String r6 = r5.getDisplayName(r4, r4, r13)
                r10[r9] = r6
                java.lang.String r1 = r5.getDisplayName(r4, r1, r13)
                r5 = 4
                r10[r5] = r1
                r10[r8] = r2
                r1 = 6
                r10[r1] = r2
                if (r7 != 0) goto L_0x008e
                j$.util.concurrent.ConcurrentHashMap r7 = new j$.util.concurrent.ConcurrentHashMap
                r7.<init>()
            L_0x008e:
                r7.put(r13, r10)
                java.lang.ref.SoftReference r13 = new java.lang.ref.SoftReference
                r13.<init>(r7)
                r3.put(r2, r13)
                r5 = r10
            L_0x009a:
                j$.time.format.TextStyle r13 = r12.textStyle
                int r13 = r13.zoneNameStyleIndex()
                if (r0 == 0) goto L_0x00ac
                if (r0 == r4) goto L_0x00a8
                int r13 = r13 + r8
                r7 = r5[r13]
                goto L_0x00af
            L_0x00a8:
                int r13 = r13 + r9
                r7 = r5[r13]
                goto L_0x00af
            L_0x00ac:
                int r13 = r13 + r4
                r7 = r5[r13]
            L_0x00af:
                if (r7 == 0) goto L_0x00b2
                r2 = r7
            L_0x00b2:
                r14.append(r2)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.DateTimeFormatterBuilder.ZoneTextPrinterParser.format(j$.time.format.DateTimePrintContext, java.lang.StringBuilder):boolean");
        }

        /* access modifiers changed from: protected */
        public PrefixTree getTree(DateTimeParseContext dateTimeParseContext) {
            PrefixTree prefixTree;
            if (this.textStyle == TextStyle.NARROW) {
                return super.getTree(dateTimeParseContext);
            }
            Locale locale = dateTimeParseContext.getLocale();
            boolean isCaseSensitive = dateTimeParseContext.isCaseSensitive();
            HashSet hashSet = (HashSet) ZoneRulesProvider.getAvailableZoneIds();
            int size = hashSet.size();
            Map map = isCaseSensitive ? this.cachedTree : this.cachedTreeCI;
            Map.Entry entry = (Map.Entry) map.get(locale);
            if (entry == null || ((Integer) entry.getKey()).intValue() != size || (prefixTree = (PrefixTree) ((SoftReference) entry.getValue()).get()) == null) {
                prefixTree = PrefixTree.newTree(dateTimeParseContext);
                String[][] zoneStrings = DateFormatSymbols.getInstance(locale).getZoneStrings();
                int length = zoneStrings.length;
                int i = 0;
                while (true) {
                    int i2 = 1;
                    if (i >= length) {
                        break;
                    }
                    String[] strArr = zoneStrings[i];
                    String str = strArr[0];
                    if (hashSet.contains(str)) {
                        prefixTree.add(str, str);
                        String zid = ZoneName.toZid(str, locale);
                        if (this.textStyle != TextStyle.FULL) {
                            i2 = 2;
                        }
                        while (i2 < strArr.length) {
                            prefixTree.add(strArr[i2], zid);
                            i2 += 2;
                        }
                    }
                    i++;
                }
                if (this.preferredZones != null) {
                    for (String[] strArr2 : zoneStrings) {
                        String str2 = strArr2[0];
                        if (this.preferredZones.contains(str2) && hashSet.contains(str2)) {
                            for (int i3 = this.textStyle == TextStyle.FULL ? 1 : 2; i3 < strArr2.length; i3 += 2) {
                                prefixTree.add(strArr2[i3], str2);
                            }
                        }
                    }
                }
                map.put(locale, new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), new SoftReference(prefixTree)));
            }
            return prefixTree;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        FIELD_MAP = hashMap;
        hashMap.put('G', ChronoField.ERA);
        hashMap.put('y', ChronoField.YEAR_OF_ERA);
        hashMap.put('u', ChronoField.YEAR);
        TemporalField temporalField = IsoFields.QUARTER_OF_YEAR;
        hashMap.put('Q', temporalField);
        hashMap.put('q', temporalField);
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        hashMap.put('M', chronoField);
        hashMap.put(Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_LT), chronoField);
        hashMap.put('D', ChronoField.DAY_OF_YEAR);
        hashMap.put('d', ChronoField.DAY_OF_MONTH);
        hashMap.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField chronoField2 = ChronoField.DAY_OF_WEEK;
        hashMap.put('E', chronoField2);
        hashMap.put('c', chronoField2);
        hashMap.put('e', chronoField2);
        hashMap.put('a', ChronoField.AMPM_OF_DAY);
        hashMap.put('H', ChronoField.HOUR_OF_DAY);
        hashMap.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', ChronoField.HOUR_OF_AMPM);
        hashMap.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', ChronoField.MINUTE_OF_HOUR);
        hashMap.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField chronoField3 = ChronoField.NANO_OF_SECOND;
        hashMap.put('S', chronoField3);
        hashMap.put('A', ChronoField.MILLI_OF_DAY);
        hashMap.put('n', chronoField3);
        hashMap.put('N', ChronoField.NANO_OF_DAY);
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = dateTimeFormatterBuilder;
        this.optional = z;
    }

    private int appendInternal(DateTimePrinterParser dateTimePrinterParser) {
        Objects.requireNonNull(dateTimePrinterParser, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i = dateTimeFormatterBuilder.padNextWidth;
        if (i > 0) {
            PadPrinterParserDecorator padPrinterParserDecorator = new PadPrinterParserDecorator(dateTimePrinterParser, i, dateTimeFormatterBuilder.padNextChar);
            dateTimeFormatterBuilder.padNextWidth = 0;
            dateTimeFormatterBuilder.padNextChar = 0;
            dateTimePrinterParser = padPrinterParserDecorator;
        }
        dateTimeFormatterBuilder.printerParsers.add(dateTimePrinterParser);
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
        dateTimeFormatterBuilder2.valueParserIndex = -1;
        return dateTimeFormatterBuilder2.printerParsers.size() - 1;
    }

    private DateTimeFormatterBuilder appendValue(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser numberPrinterParser2;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i = dateTimeFormatterBuilder.valueParserIndex;
        if (i >= 0) {
            NumberPrinterParser numberPrinterParser3 = (NumberPrinterParser) dateTimeFormatterBuilder.printerParsers.get(i);
            if (numberPrinterParser.minWidth == numberPrinterParser.maxWidth && numberPrinterParser.signStyle == SignStyle.NOT_NEGATIVE) {
                numberPrinterParser2 = numberPrinterParser3.withSubsequentWidth(numberPrinterParser.maxWidth);
                appendInternal(numberPrinterParser.withFixedWidth());
                this.active.valueParserIndex = i;
            } else {
                numberPrinterParser2 = numberPrinterParser3.withFixedWidth();
                this.active.valueParserIndex = appendInternal(numberPrinterParser);
            }
            this.active.printerParsers.set(i, numberPrinterParser2);
        } else {
            dateTimeFormatterBuilder.valueParserIndex = appendInternal(numberPrinterParser);
        }
        return this;
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        appendInternal(dateTimeFormatter.toPrinterParser(false));
        return this;
    }

    public DateTimeFormatterBuilder appendFraction(TemporalField temporalField, int i, int i2, boolean z) {
        appendInternal(new FractionPrinterParser(temporalField, i, i2, z));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant() {
        appendInternal(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char c) {
        appendInternal(new CharLiteralPrinterParser(c));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.length() > 0) {
            appendInternal(str.length() == 1 ? new CharLiteralPrinterParser(str.charAt(0)) : new StringLiteralPrinterParser(str));
        }
        return this;
    }

    public DateTimeFormatterBuilder appendLocalizedOffset(TextStyle textStyle) {
        Objects.requireNonNull(textStyle, TtmlNode.TAG_STYLE);
        if (textStyle == TextStyle.FULL || textStyle == TextStyle.SHORT) {
            appendInternal(new StringLiteralPrinterParser(textStyle));
            return this;
        }
        throw new IllegalArgumentException("Style must be either full or short");
    }

    public DateTimeFormatterBuilder appendOffset(String str, String str2) {
        appendInternal(new OffsetIdPrinterParser(str, str2));
        return this;
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        appendInternal(OffsetIdPrinterParser.INSTANCE_ID_Z);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ed, code lost:
        if (r3 == 1) goto L_0x01c8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0333 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p009j$.time.format.DateTimeFormatterBuilder appendPattern(java.lang.String r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "pattern"
            java.util.Objects.requireNonNull(r1, r2)
            r2 = 0
            r3 = 0
        L_0x000b:
            int r4 = r18.length()
            if (r3 >= r4) goto L_0x0394
            char r4 = r1.charAt(r3)
            r5 = 65
            r6 = 122(0x7a, float:1.71E-43)
            r7 = 90
            r8 = 97
            r9 = 1
            if (r4 < r5) goto L_0x0022
            if (r4 <= r7) goto L_0x0026
        L_0x0022:
            if (r4 < r8) goto L_0x02ee
            if (r4 > r6) goto L_0x02ee
        L_0x0026:
            int r10 = r3 + 1
        L_0x0028:
            int r11 = r18.length()
            if (r10 >= r11) goto L_0x0037
            char r11 = r1.charAt(r10)
            if (r11 != r4) goto L_0x0037
            int r10 = r10 + 1
            goto L_0x0028
        L_0x0037:
            int r3 = r10 - r3
            r11 = 112(0x70, float:1.57E-43)
            r12 = -1
            if (r4 != r11) goto L_0x00a7
            int r11 = r18.length()
            if (r10 >= r11) goto L_0x0064
            char r4 = r1.charAt(r10)
            if (r4 < r5) goto L_0x004c
            if (r4 <= r7) goto L_0x0050
        L_0x004c:
            if (r4 < r8) goto L_0x0064
            if (r4 > r6) goto L_0x0064
        L_0x0050:
            int r5 = r10 + 1
        L_0x0052:
            int r11 = r18.length()
            if (r5 >= r11) goto L_0x0061
            char r11 = r1.charAt(r5)
            if (r11 != r4) goto L_0x0061
            int r5 = r5 + 1
            goto L_0x0052
        L_0x0061:
            int r10 = r5 - r10
            goto L_0x0068
        L_0x0064:
            r5 = 0
            r5 = r10
            r10 = r3
            r3 = 0
        L_0x0068:
            if (r3 == 0) goto L_0x0090
            if (r3 < r9) goto L_0x0079
            j$.time.format.DateTimeFormatterBuilder r11 = r0.active
            r11.padNextWidth = r3
            r3 = 32
            r11.padNextChar = r3
            r11.valueParserIndex = r12
            r3 = r10
            r10 = r5
            goto L_0x00a7
        L_0x0079:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "The pad width must be at least one but was "
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0090:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Pad letter 'p' must be followed by valid pad pattern: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00a7:
            java.util.Map r5 = FIELD_MAP
            java.lang.Character r11 = java.lang.Character.valueOf(r4)
            java.util.HashMap r5 = (java.util.HashMap) r5
            java.lang.Object r5 = r5.get(r11)
            r12 = r5
            j$.time.temporal.TemporalField r12 = (p009j$.time.temporal.TemporalField) r12
            r5 = 5
            r11 = 4
            java.lang.String r13 = "Too many pattern letters: "
            r14 = 2
            if (r12 == 0) goto L_0x01dc
            r6 = 81
            r7 = 3
            if (r4 == r6) goto L_0x0188
            r6 = 83
            if (r4 == r6) goto L_0x017c
            if (r4 == r8) goto L_0x016f
            r6 = 104(0x68, float:1.46E-43)
            if (r4 == r6) goto L_0x015a
            r6 = 107(0x6b, float:1.5E-43)
            if (r4 == r6) goto L_0x015a
            r6 = 109(0x6d, float:1.53E-43)
            if (r4 == r6) goto L_0x015a
            r6 = 113(0x71, float:1.58E-43)
            if (r4 == r6) goto L_0x0158
            r6 = 115(0x73, float:1.61E-43)
            if (r4 == r6) goto L_0x015a
            r6 = 117(0x75, float:1.64E-43)
            if (r4 == r6) goto L_0x0131
            r6 = 121(0x79, float:1.7E-43)
            if (r4 == r6) goto L_0x0131
            switch(r4) {
                case 68: goto L_0x0115;
                case 69: goto L_0x0188;
                case 70: goto L_0x0107;
                case 71: goto L_0x00f1;
                case 72: goto L_0x015a;
                default: goto L_0x00e7;
            }
        L_0x00e7:
            switch(r4) {
                case 75: goto L_0x015a;
                case 76: goto L_0x0158;
                case 77: goto L_0x0188;
                default: goto L_0x00ea;
            }
        L_0x00ea:
            switch(r4) {
                case 99: goto L_0x0126;
                case 100: goto L_0x015a;
                case 101: goto L_0x0188;
                default: goto L_0x00ed;
            }
        L_0x00ed:
            if (r3 != r9) goto L_0x0160
            goto L_0x01c8
        L_0x00f1:
            if (r3 == r9) goto L_0x01bf
            if (r3 == r14) goto L_0x01bf
            if (r3 == r7) goto L_0x01bf
            if (r3 == r11) goto L_0x01aa
            if (r3 != r5) goto L_0x00fd
            goto L_0x0198
        L_0x00fd:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x0107:
            if (r3 != r9) goto L_0x010b
            goto L_0x01c8
        L_0x010b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x0115:
            if (r3 != r9) goto L_0x0119
            goto L_0x01c8
        L_0x0119:
            if (r3 > r7) goto L_0x011c
            goto L_0x0160
        L_0x011c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x0126:
            if (r3 == r14) goto L_0x0129
            goto L_0x0158
        L_0x0129:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid pattern \"cc\""
            r1.<init>(r2)
            throw r1
        L_0x0131:
            if (r3 != r14) goto L_0x014a
            j$.time.LocalDate r3 = p009j$.time.format.DateTimeFormatterBuilder.ReducedPrinterParser.BASE_DATE
            r13 = 2
            r14 = 2
            java.lang.String r4 = "baseDate"
            java.util.Objects.requireNonNull(r3, r4)
            j$.time.format.DateTimeFormatterBuilder$ReducedPrinterParser r4 = new j$.time.format.DateTimeFormatterBuilder$ReducedPrinterParser
            r15 = 0
            r11 = r4
            r16 = r3
            r11.<init>(r12, r13, r14, r15, r16)
            r0.appendValue((p009j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser) r4)
            goto L_0x02de
        L_0x014a:
            r4 = 19
            if (r3 >= r11) goto L_0x0151
            j$.time.format.SignStyle r5 = p009j$.time.format.SignStyle.NORMAL
            goto L_0x0153
        L_0x0151:
            j$.time.format.SignStyle r5 = p009j$.time.format.SignStyle.EXCEEDS_PAD
        L_0x0153:
            r0.appendValue(r12, r3, r4, r5)
            goto L_0x02de
        L_0x0158:
            r6 = 1
            goto L_0x0189
        L_0x015a:
            if (r3 != r9) goto L_0x015e
            goto L_0x01c8
        L_0x015e:
            if (r3 != r14) goto L_0x0165
        L_0x0160:
            r0.appendValue(r12, r3)
            goto L_0x02de
        L_0x0165:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x016f:
            if (r3 != r9) goto L_0x0172
            goto L_0x01bf
        L_0x0172:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x017c:
            j$.time.temporal.ChronoField r4 = p009j$.time.temporal.ChronoField.NANO_OF_SECOND
            j$.time.format.DateTimeFormatterBuilder$FractionPrinterParser r5 = new j$.time.format.DateTimeFormatterBuilder$FractionPrinterParser
            r5.<init>(r4, r3, r3, r2)
            r0.appendInternal(r5)
            goto L_0x02de
        L_0x0188:
            r6 = 0
        L_0x0189:
            if (r3 == r9) goto L_0x01b2
            if (r3 == r14) goto L_0x01b2
            if (r3 == r7) goto L_0x01ad
            if (r3 == r11) goto L_0x01a5
            if (r3 != r5) goto L_0x019b
            if (r6 == 0) goto L_0x0198
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.NARROW_STANDALONE
            goto L_0x01c1
        L_0x0198:
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.NARROW
            goto L_0x01c1
        L_0x019b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x01a5:
            if (r6 == 0) goto L_0x01aa
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.FULL_STANDALONE
            goto L_0x01c1
        L_0x01aa:
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.FULL
            goto L_0x01c1
        L_0x01ad:
            if (r6 == 0) goto L_0x01bf
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.SHORT_STANDALONE
            goto L_0x01c1
        L_0x01b2:
            r5 = 99
            if (r4 == r5) goto L_0x01d2
            r5 = 101(0x65, float:1.42E-43)
            if (r4 != r5) goto L_0x01bb
            goto L_0x01d2
        L_0x01bb:
            r5 = 69
            if (r4 != r5) goto L_0x01c6
        L_0x01bf:
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.SHORT
        L_0x01c1:
            r0.appendText((p009j$.time.temporal.TemporalField) r12, (p009j$.time.format.TextStyle) r3)
            goto L_0x02de
        L_0x01c6:
            if (r3 != r9) goto L_0x01cd
        L_0x01c8:
            r0.appendValue((p009j$.time.temporal.TemporalField) r12)
            goto L_0x02de
        L_0x01cd:
            r0.appendValue(r12, r14)
            goto L_0x02de
        L_0x01d2:
            j$.time.format.DateTimeFormatterBuilder$WeekBasedFieldPrinterParser r5 = new j$.time.format.DateTimeFormatterBuilder$WeekBasedFieldPrinterParser
            r5.<init>(r4, r3)
            r0.appendInternal(r5)
            goto L_0x02de
        L_0x01dc:
            if (r4 != r6) goto L_0x0201
            if (r3 > r11) goto L_0x01f7
            r4 = 0
            if (r3 != r11) goto L_0x01eb
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.FULL
            j$.time.format.DateTimeFormatterBuilder$ZoneTextPrinterParser r5 = new j$.time.format.DateTimeFormatterBuilder$ZoneTextPrinterParser
            r5.<init>(r3, r4)
            goto L_0x01f2
        L_0x01eb:
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.SHORT
            j$.time.format.DateTimeFormatterBuilder$ZoneTextPrinterParser r5 = new j$.time.format.DateTimeFormatterBuilder$ZoneTextPrinterParser
            r5.<init>(r3, r4)
        L_0x01f2:
            r0.appendInternal(r5)
            goto L_0x02de
        L_0x01f7:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x0201:
            r6 = 86
            if (r4 != r6) goto L_0x0221
            if (r3 != r14) goto L_0x0215
            j$.time.format.DateTimeFormatterBuilder$ZoneIdPrinterParser r3 = new j$.time.format.DateTimeFormatterBuilder$ZoneIdPrinterParser
            j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0 r4 = p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0.INSTANCE
            java.lang.String r5 = "ZoneId()"
            r3.<init>(r4, r5)
            r0.appendInternal(r3)
            goto L_0x02de
        L_0x0215:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Pattern letter count must be 2: "
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r2, r4)
            r1.<init>(r2)
            throw r1
        L_0x0221:
            java.lang.String r6 = "+0000"
            if (r4 != r7) goto L_0x023d
            if (r3 >= r11) goto L_0x022b
            java.lang.String r3 = "+HHMM"
            goto L_0x0298
        L_0x022b:
            if (r3 != r11) goto L_0x022e
            goto L_0x0248
        L_0x022e:
            if (r3 != r5) goto L_0x0233
            java.lang.String r3 = "+HH:MM:ss"
            goto L_0x026b
        L_0x0233:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x023d:
            r7 = 79
            if (r4 != r7) goto L_0x025b
            if (r3 != r9) goto L_0x0246
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.SHORT
            goto L_0x024a
        L_0x0246:
            if (r3 != r11) goto L_0x024f
        L_0x0248:
            j$.time.format.TextStyle r3 = p009j$.time.format.TextStyle.FULL
        L_0x024a:
            r0.appendLocalizedOffset(r3)
            goto L_0x02de
        L_0x024f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Pattern letter count must be 1 or 4: "
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r2, r4)
            r1.<init>(r2)
            throw r1
        L_0x025b:
            r7 = 88
            if (r4 != r7) goto L_0x027c
            if (r3 > r5) goto L_0x0272
            java.lang.String[] r4 = p009j$.time.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.PATTERNS
            if (r3 != r9) goto L_0x0267
            r5 = 0
            goto L_0x0268
        L_0x0267:
            r5 = 1
        L_0x0268:
            int r3 = r3 + r5
            r3 = r4[r3]
        L_0x026b:
            java.lang.String r4 = "Z"
            r0.appendOffset(r3, r4)
            goto L_0x02de
        L_0x0272:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x027c:
            r7 = 120(0x78, float:1.68E-43)
            if (r4 != r7) goto L_0x02a6
            if (r3 > r5) goto L_0x029c
            if (r3 != r9) goto L_0x0287
            java.lang.String r6 = "+00"
            goto L_0x028e
        L_0x0287:
            int r4 = r3 % 2
            if (r4 != 0) goto L_0x028c
            goto L_0x028e
        L_0x028c:
            java.lang.String r6 = "+00:00"
        L_0x028e:
            java.lang.String[] r4 = p009j$.time.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.PATTERNS
            if (r3 != r9) goto L_0x0294
            r5 = 0
            goto L_0x0295
        L_0x0294:
            r5 = 1
        L_0x0295:
            int r3 = r3 + r5
            r3 = r4[r3]
        L_0x0298:
            r0.appendOffset(r3, r6)
            goto L_0x02de
        L_0x029c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x02a6:
            r5 = 87
            if (r4 != r5) goto L_0x02bc
            if (r3 > r9) goto L_0x02b2
            j$.time.format.DateTimeFormatterBuilder$WeekBasedFieldPrinterParser r5 = new j$.time.format.DateTimeFormatterBuilder$WeekBasedFieldPrinterParser
            r5.<init>(r4, r3)
            goto L_0x02db
        L_0x02b2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x02bc:
            r5 = 119(0x77, float:1.67E-43)
            if (r4 != r5) goto L_0x02d2
            if (r3 > r14) goto L_0x02c8
            j$.time.format.DateTimeFormatterBuilder$WeekBasedFieldPrinterParser r5 = new j$.time.format.DateTimeFormatterBuilder$WeekBasedFieldPrinterParser
            r5.<init>(r4, r3)
            goto L_0x02db
        L_0x02c8:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r13, r4)
            r1.<init>(r2)
            throw r1
        L_0x02d2:
            r5 = 89
            if (r4 != r5) goto L_0x02e2
            j$.time.format.DateTimeFormatterBuilder$WeekBasedFieldPrinterParser r5 = new j$.time.format.DateTimeFormatterBuilder$WeekBasedFieldPrinterParser
            r5.<init>(r4, r3)
        L_0x02db:
            r0.appendInternal(r5)
        L_0x02de:
            int r3 = r10 + -1
            goto L_0x0377
        L_0x02e2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Unknown pattern letter: "
            java.lang.String r2 = p009j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticOutline0.m194m(r2, r4)
            r1.<init>(r2)
            throw r1
        L_0x02ee:
            java.lang.String r5 = "'"
            r6 = 39
            if (r4 != r6) goto L_0x034a
            int r3 = r3 + 1
            r4 = r3
        L_0x02f7:
            int r7 = r18.length()
            if (r4 >= r7) goto L_0x0314
            char r7 = r1.charAt(r4)
            if (r7 != r6) goto L_0x0312
            int r7 = r4 + 1
            int r8 = r18.length()
            if (r7 >= r8) goto L_0x0314
            char r8 = r1.charAt(r7)
            if (r8 != r6) goto L_0x0314
            r4 = r7
        L_0x0312:
            int r4 = r4 + r9
            goto L_0x02f7
        L_0x0314:
            int r7 = r18.length()
            if (r4 >= r7) goto L_0x0333
            java.lang.String r3 = r1.substring(r3, r4)
            int r7 = r3.length()
            if (r7 != 0) goto L_0x0328
            r0.appendLiteral((char) r6)
            goto L_0x0331
        L_0x0328:
            java.lang.String r6 = "''"
            java.lang.String r3 = r3.replace(r6, r5)
            r0.appendLiteral((java.lang.String) r3)
        L_0x0331:
            r3 = r4
            goto L_0x0377
        L_0x0333:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Pattern ends with an incomplete string literal: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x034a:
            r6 = 91
            if (r4 != r6) goto L_0x0352
            r17.optionalStart()
            goto L_0x0377
        L_0x0352:
            r6 = 93
            if (r4 != r6) goto L_0x0368
            j$.time.format.DateTimeFormatterBuilder r4 = r0.active
            j$.time.format.DateTimeFormatterBuilder r4 = r4.parent
            if (r4 == 0) goto L_0x0360
            r17.optionalEnd()
            goto L_0x0377
        L_0x0360:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Pattern invalid as it contains ] without previous ["
            r1.<init>(r2)
            throw r1
        L_0x0368:
            r6 = 123(0x7b, float:1.72E-43)
            if (r4 == r6) goto L_0x037a
            r6 = 125(0x7d, float:1.75E-43)
            if (r4 == r6) goto L_0x037a
            r6 = 35
            if (r4 == r6) goto L_0x037a
            r0.appendLiteral((char) r4)
        L_0x0377:
            int r3 = r3 + r9
            goto L_0x000b
        L_0x037a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Pattern includes reserved character: '"
            r2.append(r3)
            r2.append(r4)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0394:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.DateTimeFormatterBuilder.appendPattern(java.lang.String):j$.time.format.DateTimeFormatterBuilder");
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, TextStyle textStyle) {
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(textStyle, "textStyle");
        appendInternal(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider()));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField) {
        Objects.requireNonNull(temporalField, "field");
        appendValue(new NumberPrinterParser(temporalField, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneRegionId() {
        appendInternal(new ZoneIdPrinterParser(DateTimeFormatterBuilder$$ExternalSyntheticLambda0.INSTANCE, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        if (dateTimeFormatterBuilder.parent != null) {
            if (dateTimeFormatterBuilder.printerParsers.size() > 0) {
                DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
                CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.printerParsers, dateTimeFormatterBuilder2.optional);
                this.active = this.active.parent;
                appendInternal(compositePrinterParser);
            } else {
                this.active = this.active.parent;
            }
            return this;
        }
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public DateTimeFormatterBuilder optionalStart() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        appendInternal(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseSensitive() {
        appendInternal(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseLenient() {
        appendInternal(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault(), ResolverStyle.SMART, (Chronology) null);
    }

    /* access modifiers changed from: package-private */
    public DateTimeFormatter toFormatter(ResolverStyle resolverStyle, Chronology chronology) {
        return toFormatter(Locale.getDefault(), resolverStyle, chronology);
    }

    private DateTimeFormatter toFormatter(Locale locale, ResolverStyle resolverStyle, Chronology chronology) {
        Objects.requireNonNull(locale, "locale");
        while (this.active.parent != null) {
            optionalEnd();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.printerParsers, false), locale, DecimalStyle.STANDARD, resolverStyle, (Set) null, chronology, (ZoneId) null);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i) {
        Objects.requireNonNull(temporalField, "field");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i);
        }
        appendValue(new NumberPrinterParser(temporalField, i, i, SignStyle.NOT_NEGATIVE));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, Map map) {
        Objects.requireNonNull(temporalField, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        TextStyle textStyle = TextStyle.FULL;
        final DateTimeTextProvider.LocaleStore localeStore = new DateTimeTextProvider.LocaleStore(Collections.singletonMap(textStyle, linkedHashMap));
        appendInternal(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider(this) {
            public String getText(TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
                return localeStore.getText(j, textStyle);
            }

            public Iterator getTextIterator(TemporalField temporalField, TextStyle textStyle, Locale locale) {
                return localeStore.getTextIterator(textStyle);
            }
        }));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i, int i2, SignStyle signStyle) {
        if (i == i2 && signStyle == SignStyle.NOT_NEGATIVE) {
            appendValue(temporalField, i2);
            return this;
        }
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(signStyle, "signStyle");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i);
        } else if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i2);
        } else if (i2 >= i) {
            appendValue(new NumberPrinterParser(temporalField, i, i2, signStyle));
            return this;
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
        }
    }
}
