package p009j$.time.format;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p009j$.time.DateTimeException;
import p009j$.time.ZoneId;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.format.DateTimeFormatterBuilder;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.IsoFields;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalField;
import p009j$.time.temporal.TemporalQuery;

/* renamed from: j$.time.format.DateTimeFormatter */
public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_INSTANT;
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public static final DateTimeFormatter ISO_LOCAL_TIME;
    private final Chronology chrono;
    private final DecimalStyle decimalStyle;
    private final Locale locale;
    private final DateTimeFormatterBuilder.CompositePrinterParser printerParser;
    private final Set resolverFields = null;
    private final ResolverStyle resolverStyle;
    private final ZoneId zone;

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        ChronoField chronoField = ChronoField.YEAR;
        SignStyle signStyle = SignStyle.EXCEEDS_PAD;
        DateTimeFormatterBuilder appendValue = dateTimeFormatterBuilder.appendValue(chronoField, 4, 10, signStyle);
        appendValue.appendLiteral('-');
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        appendValue.appendValue(chronoField2, 2);
        appendValue.appendLiteral('-');
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        appendValue.appendValue(chronoField3, 2);
        ResolverStyle resolverStyle2 = ResolverStyle.STRICT;
        IsoChronology isoChronology = IsoChronology.INSTANCE;
        DateTimeFormatter formatter = appendValue.toFormatter(resolverStyle2, isoChronology);
        ISO_LOCAL_DATE = formatter;
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder2.parseCaseInsensitive();
        dateTimeFormatterBuilder2.append(formatter);
        dateTimeFormatterBuilder2.appendOffsetId();
        dateTimeFormatterBuilder2.toFormatter(resolverStyle2, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder3 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder3.parseCaseInsensitive();
        dateTimeFormatterBuilder3.append(formatter);
        dateTimeFormatterBuilder3.optionalStart();
        dateTimeFormatterBuilder3.appendOffsetId();
        dateTimeFormatterBuilder3.toFormatter(resolverStyle2, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder4 = new DateTimeFormatterBuilder();
        ChronoField chronoField4 = ChronoField.HOUR_OF_DAY;
        dateTimeFormatterBuilder4.appendValue(chronoField4, 2);
        dateTimeFormatterBuilder4.appendLiteral(':');
        ChronoField chronoField5 = ChronoField.MINUTE_OF_HOUR;
        dateTimeFormatterBuilder4.appendValue(chronoField5, 2);
        dateTimeFormatterBuilder4.optionalStart();
        dateTimeFormatterBuilder4.appendLiteral(':');
        ChronoField chronoField6 = ChronoField.SECOND_OF_MINUTE;
        dateTimeFormatterBuilder4.appendValue(chronoField6, 2);
        dateTimeFormatterBuilder4.optionalStart();
        dateTimeFormatterBuilder4.appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter formatter2 = dateTimeFormatterBuilder4.toFormatter(resolverStyle2, (Chronology) null);
        ISO_LOCAL_TIME = formatter2;
        DateTimeFormatterBuilder dateTimeFormatterBuilder5 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder5.parseCaseInsensitive();
        dateTimeFormatterBuilder5.append(formatter2);
        dateTimeFormatterBuilder5.appendOffsetId();
        dateTimeFormatterBuilder5.toFormatter(resolverStyle2, (Chronology) null);
        DateTimeFormatterBuilder dateTimeFormatterBuilder6 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder6.parseCaseInsensitive();
        dateTimeFormatterBuilder6.append(formatter2);
        dateTimeFormatterBuilder6.optionalStart();
        dateTimeFormatterBuilder6.appendOffsetId();
        dateTimeFormatterBuilder6.toFormatter(resolverStyle2, (Chronology) null);
        DateTimeFormatterBuilder dateTimeFormatterBuilder7 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder7.parseCaseInsensitive();
        dateTimeFormatterBuilder7.append(formatter);
        dateTimeFormatterBuilder7.appendLiteral('T');
        dateTimeFormatterBuilder7.append(formatter2);
        DateTimeFormatter formatter3 = dateTimeFormatterBuilder7.toFormatter(resolverStyle2, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder8 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder8.parseCaseInsensitive();
        dateTimeFormatterBuilder8.append(formatter3);
        dateTimeFormatterBuilder8.appendOffsetId();
        DateTimeFormatter formatter4 = dateTimeFormatterBuilder8.toFormatter(resolverStyle2, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder9 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder9.append(formatter4);
        dateTimeFormatterBuilder9.optionalStart();
        dateTimeFormatterBuilder9.appendLiteral('[');
        dateTimeFormatterBuilder9.parseCaseSensitive();
        dateTimeFormatterBuilder9.appendZoneRegionId();
        dateTimeFormatterBuilder9.appendLiteral(']');
        dateTimeFormatterBuilder9.toFormatter(resolverStyle2, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder10 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder10.append(formatter3);
        dateTimeFormatterBuilder10.optionalStart();
        dateTimeFormatterBuilder10.appendOffsetId();
        dateTimeFormatterBuilder10.optionalStart();
        dateTimeFormatterBuilder10.appendLiteral('[');
        dateTimeFormatterBuilder10.parseCaseSensitive();
        dateTimeFormatterBuilder10.appendZoneRegionId();
        dateTimeFormatterBuilder10.appendLiteral(']');
        dateTimeFormatterBuilder10.toFormatter(resolverStyle2, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder11 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder11.parseCaseInsensitive();
        DateTimeFormatterBuilder appendValue2 = dateTimeFormatterBuilder11.appendValue(chronoField, 4, 10, signStyle);
        appendValue2.appendLiteral('-');
        appendValue2.appendValue(ChronoField.DAY_OF_YEAR, 3);
        appendValue2.optionalStart();
        appendValue2.appendOffsetId();
        appendValue2.toFormatter(resolverStyle2, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder12 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder12.parseCaseInsensitive();
        DateTimeFormatterBuilder appendValue3 = dateTimeFormatterBuilder12.appendValue(IsoFields.WEEK_BASED_YEAR, 4, 10, signStyle);
        appendValue3.appendLiteral("-W");
        appendValue3.appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2);
        appendValue3.appendLiteral('-');
        ChronoField chronoField7 = ChronoField.DAY_OF_WEEK;
        appendValue3.appendValue(chronoField7, 1);
        appendValue3.optionalStart();
        appendValue3.appendOffsetId();
        appendValue3.toFormatter(resolverStyle2, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder13 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder13.parseCaseInsensitive();
        dateTimeFormatterBuilder13.appendInstant();
        ISO_INSTANT = dateTimeFormatterBuilder13.toFormatter(resolverStyle2, (Chronology) null);
        DateTimeFormatterBuilder dateTimeFormatterBuilder14 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder14.parseCaseInsensitive();
        dateTimeFormatterBuilder14.appendValue(chronoField, 4);
        dateTimeFormatterBuilder14.appendValue(chronoField2, 2);
        dateTimeFormatterBuilder14.appendValue(chronoField3, 2);
        dateTimeFormatterBuilder14.optionalStart();
        dateTimeFormatterBuilder14.appendOffset("+HHMMss", "Z");
        dateTimeFormatterBuilder14.toFormatter(resolverStyle2, isoChronology);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        IsoChronology isoChronology2 = isoChronology;
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        DateTimeFormatterBuilder dateTimeFormatterBuilder15 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder15.parseCaseInsensitive();
        dateTimeFormatterBuilder15.parseLenient();
        dateTimeFormatterBuilder15.optionalStart();
        dateTimeFormatterBuilder15.appendText((TemporalField) chronoField7, (Map) hashMap);
        dateTimeFormatterBuilder15.appendLiteral(", ");
        dateTimeFormatterBuilder15.optionalEnd();
        DateTimeFormatterBuilder appendValue4 = dateTimeFormatterBuilder15.appendValue(chronoField3, 1, 2, SignStyle.NOT_NEGATIVE);
        appendValue4.appendLiteral(' ');
        appendValue4.appendText((TemporalField) chronoField2, (Map) hashMap2);
        appendValue4.appendLiteral(' ');
        appendValue4.appendValue(chronoField, 4);
        appendValue4.appendLiteral(' ');
        appendValue4.appendValue(chronoField4, 2);
        appendValue4.appendLiteral(':');
        appendValue4.appendValue(chronoField5, 2);
        appendValue4.optionalStart();
        appendValue4.appendLiteral(':');
        appendValue4.appendValue(chronoField6, 2);
        appendValue4.optionalEnd();
        appendValue4.appendLiteral(' ');
        appendValue4.appendOffset("+HHMM", "GMT");
        appendValue4.toFormatter(ResolverStyle.SMART, isoChronology2);
    }

    DateTimeFormatter(DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser, Locale locale2, DecimalStyle decimalStyle2, ResolverStyle resolverStyle2, Set set, Chronology chronology, ZoneId zoneId) {
        this.printerParser = compositePrinterParser;
        this.locale = locale2;
        this.decimalStyle = decimalStyle2;
        Objects.requireNonNull(resolverStyle2, "resolverStyle");
        this.resolverStyle = resolverStyle2;
        this.chrono = chronology;
        this.zone = null;
    }

    public static DateTimeFormatter ofPattern(String str) {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendPattern(str);
        return dateTimeFormatterBuilder.toFormatter();
    }

    private TemporalAccessor parseResolved0(CharSequence charSequence, ParsePosition parsePosition) {
        String str;
        ParsePosition parsePosition2 = new ParsePosition(0);
        DateTimeParseContext dateTimeParseContext = new DateTimeParseContext(this);
        int parse = this.printerParser.parse(dateTimeParseContext, charSequence, parsePosition2.getIndex());
        if (parse < 0) {
            parsePosition2.setErrorIndex(~parse);
            dateTimeParseContext = null;
        } else {
            parsePosition2.setIndex(parse);
        }
        if (dateTimeParseContext != null && parsePosition2.getErrorIndex() < 0 && parsePosition2.getIndex() >= charSequence.length()) {
            return dateTimeParseContext.toResolved(this.resolverStyle, this.resolverFields);
        }
        if (charSequence.length() > 64) {
            str = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            str = charSequence.toString();
        }
        if (parsePosition2.getErrorIndex() >= 0) {
            throw new DateTimeParseException("Text '" + str + "' could not be parsed at index " + parsePosition2.getErrorIndex(), charSequence, parsePosition2.getErrorIndex());
        }
        throw new DateTimeParseException("Text '" + str + "' could not be parsed, unparsed text found at index " + parsePosition2.getIndex(), charSequence, parsePosition2.getIndex());
    }

    public String format(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        try {
            this.printerParser.format(new DateTimePrintContext(temporalAccessor, this), sb);
            return sb.toString();
        } catch (IOException e) {
            throw new DateTimeException(e.getMessage(), e);
        }
    }

    public Chronology getChronology() {
        return this.chrono;
    }

    public DecimalStyle getDecimalStyle() {
        return this.decimalStyle;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public ZoneId getZone() {
        return this.zone;
    }

    public Object parse(CharSequence charSequence, TemporalQuery temporalQuery) {
        String str;
        Objects.requireNonNull(charSequence, "text");
        try {
            return ((Parsed) parseResolved0(charSequence, (ParsePosition) null)).query(temporalQuery);
        } catch (DateTimeParseException e) {
            throw e;
        } catch (RuntimeException e2) {
            if (charSequence.length() > 64) {
                str = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                str = charSequence.toString();
            }
            throw new DateTimeParseException("Text '" + str + "' could not be parsed: " + e2.getMessage(), charSequence, 0, e2);
        }
    }

    /* access modifiers changed from: package-private */
    public DateTimeFormatterBuilder.CompositePrinterParser toPrinterParser(boolean z) {
        return this.printerParser.withOptional(z);
    }

    public String toString() {
        String compositePrinterParser = this.printerParser.toString();
        return compositePrinterParser.startsWith("[") ? compositePrinterParser : compositePrinterParser.substring(1, compositePrinterParser.length() - 1);
    }
}
