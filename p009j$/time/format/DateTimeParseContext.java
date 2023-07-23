package p009j$.time.format;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import p009j$.time.ZoneId;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalField;
import p009j$.util.function.Consumer;

/* renamed from: j$.time.format.DateTimeParseContext */
final class DateTimeParseContext {
    private boolean caseSensitive = true;
    private ArrayList chronoListeners;
    private DateTimeFormatter formatter;
    private final ArrayList parsed;
    private boolean strict = true;

    DateTimeParseContext(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.parsed = arrayList;
        this.chronoListeners = null;
        this.formatter = dateTimeFormatter;
        arrayList.add(new Parsed());
    }

    static boolean charEqualsIgnoreCase(char c, char c2) {
        return c == c2 || Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    private Parsed currentParsed() {
        ArrayList arrayList = this.parsed;
        return (Parsed) arrayList.get(arrayList.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public void addChronoChangedListener(Consumer consumer) {
        if (this.chronoListeners == null) {
            this.chronoListeners = new ArrayList();
        }
        this.chronoListeners.add(consumer);
    }

    /* access modifiers changed from: package-private */
    public boolean charEquals(char c, char c2) {
        if (this.caseSensitive) {
            return c == c2;
        }
        return charEqualsIgnoreCase(c, c2);
    }

    /* access modifiers changed from: package-private */
    public DateTimeParseContext copy() {
        DateTimeParseContext dateTimeParseContext = new DateTimeParseContext(this.formatter);
        dateTimeParseContext.caseSensitive = this.caseSensitive;
        dateTimeParseContext.strict = this.strict;
        return dateTimeParseContext;
    }

    /* access modifiers changed from: package-private */
    public void endOptional(boolean z) {
        ArrayList arrayList;
        int i;
        if (z) {
            arrayList = this.parsed;
            i = arrayList.size() - 2;
        } else {
            arrayList = this.parsed;
            i = arrayList.size() - 1;
        }
        arrayList.remove(i);
    }

    /* access modifiers changed from: package-private */
    public DecimalStyle getDecimalStyle() {
        return this.formatter.getDecimalStyle();
    }

    /* access modifiers changed from: package-private */
    public Chronology getEffectiveChronology() {
        Chronology chronology = currentParsed().chrono;
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = this.formatter.getChronology();
        return chronology2 == null ? IsoChronology.INSTANCE : chronology2;
    }

    /* access modifiers changed from: package-private */
    public Locale getLocale() {
        return this.formatter.getLocale();
    }

    /* access modifiers changed from: package-private */
    public Long getParsed(TemporalField temporalField) {
        return (Long) currentParsed().fieldValues.get(temporalField);
    }

    /* access modifiers changed from: package-private */
    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    /* access modifiers changed from: package-private */
    public boolean isStrict() {
        return this.strict;
    }

    /* access modifiers changed from: package-private */
    public void setCaseSensitive(boolean z) {
        this.caseSensitive = z;
    }

    /* access modifiers changed from: package-private */
    public void setParsed(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        currentParsed().zone = zoneId;
    }

    /* access modifiers changed from: package-private */
    public int setParsedField(TemporalField temporalField, long j, int i, int i2) {
        Objects.requireNonNull(temporalField, "field");
        Long l = (Long) currentParsed().fieldValues.put(temporalField, Long.valueOf(j));
        return (l == null || l.longValue() == j) ? i2 : ~i;
    }

    /* access modifiers changed from: package-private */
    public void setParsedLeapSecond() {
        currentParsed().leapSecond = true;
    }

    /* access modifiers changed from: package-private */
    public void setStrict(boolean z) {
        this.strict = z;
    }

    /* access modifiers changed from: package-private */
    public void startOptional() {
        ArrayList arrayList = this.parsed;
        Parsed currentParsed = currentParsed();
        Objects.requireNonNull(currentParsed);
        Parsed parsed2 = new Parsed();
        parsed2.fieldValues.putAll(currentParsed.fieldValues);
        parsed2.zone = currentParsed.zone;
        parsed2.chrono = currentParsed.chrono;
        parsed2.leapSecond = currentParsed.leapSecond;
        arrayList.add(parsed2);
    }

    /* access modifiers changed from: package-private */
    public boolean subSequenceEquals(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3) {
        if (i + i3 > charSequence.length() || i2 + i3 > charSequence2.length()) {
            return false;
        }
        if (this.caseSensitive) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (charSequence.charAt(i + i4) != charSequence2.charAt(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            char charAt = charSequence.charAt(i + i5);
            char charAt2 = charSequence2.charAt(i2 + i5);
            if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public TemporalAccessor toResolved(ResolverStyle resolverStyle, Set set) {
        Parsed currentParsed = currentParsed();
        currentParsed.chrono = getEffectiveChronology();
        ZoneId zoneId = currentParsed.zone;
        if (zoneId == null) {
            zoneId = this.formatter.getZone();
        }
        currentParsed.zone = zoneId;
        currentParsed.resolve(resolverStyle, set);
        return currentParsed;
    }

    public String toString() {
        return currentParsed().toString();
    }
}
