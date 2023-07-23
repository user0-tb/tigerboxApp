package p009j$.time.format;

import java.util.Locale;
import p009j$.time.Clock$SystemClock$$ExternalSyntheticOutline0;
import p009j$.time.DateTimeException;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalField;
import p009j$.time.temporal.TemporalQuery;

/* renamed from: j$.time.format.DateTimePrintContext */
final class DateTimePrintContext {
    private DateTimeFormatter formatter;
    private int optional;
    private TemporalAccessor temporal;

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    DateTimePrintContext(final p009j$.time.temporal.TemporalAccessor r10, p009j$.time.format.DateTimeFormatter r11) {
        /*
            r9 = this;
            r9.<init>()
            j$.time.chrono.Chronology r0 = r11.getChronology()
            j$.time.ZoneId r1 = r11.getZone()
            if (r0 != 0) goto L_0x0011
            if (r1 != 0) goto L_0x0011
            goto L_0x0105
        L_0x0011:
            int r2 = p009j$.time.temporal.TemporalQueries.$r8$clinit
            j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1 r2 = p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1.INSTANCE
            java.lang.Object r2 = r10.query(r2)
            j$.time.chrono.Chronology r2 = (p009j$.time.chrono.Chronology) r2
            j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0 r3 = p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0.INSTANCE
            java.lang.Object r3 = r10.query(r3)
            j$.time.ZoneId r3 = (p009j$.time.ZoneId) r3
            boolean r4 = p009j$.util.Objects.equals(r0, r2)
            r5 = 0
            if (r4 == 0) goto L_0x002b
            r0 = r5
        L_0x002b:
            boolean r4 = p009j$.util.Objects.equals(r1, r3)
            if (r4 == 0) goto L_0x0032
            r1 = r5
        L_0x0032:
            if (r0 != 0) goto L_0x0038
            if (r1 != 0) goto L_0x0038
            goto L_0x0105
        L_0x0038:
            if (r0 == 0) goto L_0x003c
            r4 = r0
            goto L_0x003d
        L_0x003c:
            r4 = r2
        L_0x003d:
            if (r1 == 0) goto L_0x00a8
            j$.time.temporal.ChronoField r6 = p009j$.time.temporal.ChronoField.INSTANT_SECONDS
            boolean r6 = r10.isSupported(r6)
            if (r6 == 0) goto L_0x0056
            if (r4 == 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            j$.time.chrono.IsoChronology r0 = p009j$.time.chrono.IsoChronology.INSTANCE
        L_0x004c:
            j$.time.Instant r10 = p009j$.time.Instant.from(r10)
            j$.time.ZonedDateTime r10 = p009j$.time.ZonedDateTime.ofInstant(r10, r1)
            goto L_0x0105
        L_0x0056:
            j$.time.zone.ZoneRules r6 = r1.getRules()     // Catch:{ ZoneRulesException -> 0x0067 }
            boolean r7 = r6.isFixedOffset()     // Catch:{ ZoneRulesException -> 0x0067 }
            if (r7 == 0) goto L_0x0067
            j$.time.Instant r7 = p009j$.time.Instant.EPOCH     // Catch:{ ZoneRulesException -> 0x0067 }
            j$.time.ZoneOffset r6 = r6.getOffset(r7)     // Catch:{ ZoneRulesException -> 0x0067 }
            goto L_0x0068
        L_0x0067:
            r6 = r1
        L_0x0068:
            boolean r6 = r6 instanceof p009j$.time.ZoneOffset
            if (r6 == 0) goto L_0x00a8
            j$.time.temporal.ChronoField r6 = p009j$.time.temporal.ChronoField.OFFSET_SECONDS
            boolean r7 = r10.isSupported(r6)
            if (r7 == 0) goto L_0x00a8
            int r6 = r10.get(r6)
            j$.time.zone.ZoneRules r7 = r1.getRules()
            j$.time.Instant r8 = p009j$.time.Instant.EPOCH
            j$.time.ZoneOffset r7 = r7.getOffset(r8)
            int r7 = r7.getTotalSeconds()
            if (r6 != r7) goto L_0x0089
            goto L_0x00a8
        L_0x0089:
            j$.time.DateTimeException r11 = new j$.time.DateTimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Unable to apply override zone '"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "' because the temporal object being formatted has a different offset but does not represent an instant: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r11.<init>(r10)
            throw r11
        L_0x00a8:
            if (r1 == 0) goto L_0x00ab
            r3 = r1
        L_0x00ab:
            if (r0 == 0) goto L_0x00ff
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.EPOCH_DAY
            boolean r1 = r10.isSupported(r1)
            if (r1 == 0) goto L_0x00c0
            r0 = r4
            j$.time.chrono.IsoChronology r0 = (p009j$.time.chrono.IsoChronology) r0
            java.util.Objects.requireNonNull(r0)
            j$.time.LocalDate r5 = p009j$.time.LocalDate.from(r10)
            goto L_0x00ff
        L_0x00c0:
            j$.time.chrono.IsoChronology r1 = p009j$.time.chrono.IsoChronology.INSTANCE
            if (r0 != r1) goto L_0x00c6
            if (r2 == 0) goto L_0x00ff
        L_0x00c6:
            j$.time.temporal.ChronoField[] r1 = p009j$.time.temporal.ChronoField.values()
            int r2 = r1.length
            r6 = 0
        L_0x00cc:
            if (r6 >= r2) goto L_0x00ff
            r7 = r1[r6]
            boolean r8 = r7.isDateBased()
            if (r8 == 0) goto L_0x00fc
            boolean r7 = r10.isSupported(r7)
            if (r7 != 0) goto L_0x00dd
            goto L_0x00fc
        L_0x00dd:
            j$.time.DateTimeException r11 = new j$.time.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to apply override chronology '"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = "' because the temporal object being formatted contains date fields but does not represent a whole date: "
            r1.append(r0)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r11.<init>(r10)
            throw r11
        L_0x00fc:
            int r6 = r6 + 1
            goto L_0x00cc
        L_0x00ff:
            j$.time.format.DateTimePrintContext$1 r0 = new j$.time.format.DateTimePrintContext$1
            r0.<init>(r10, r4, r3)
            r10 = r0
        L_0x0105:
            r9.temporal = r10
            r9.formatter = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.DateTimePrintContext.<init>(j$.time.temporal.TemporalAccessor, j$.time.format.DateTimeFormatter):void");
    }

    /* access modifiers changed from: package-private */
    public void endOptional() {
        this.optional--;
    }

    /* access modifiers changed from: package-private */
    public DecimalStyle getDecimalStyle() {
        return this.formatter.getDecimalStyle();
    }

    /* access modifiers changed from: package-private */
    public Locale getLocale() {
        return this.formatter.getLocale();
    }

    /* access modifiers changed from: package-private */
    public TemporalAccessor getTemporal() {
        return this.temporal;
    }

    /* access modifiers changed from: package-private */
    public Long getValue(TemporalField temporalField) {
        try {
            return Long.valueOf(this.temporal.getLong(temporalField));
        } catch (DateTimeException e) {
            if (this.optional > 0) {
                return null;
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public Object getValue(TemporalQuery temporalQuery) {
        Object query = this.temporal.query(temporalQuery);
        if (query != null || this.optional != 0) {
            return query;
        }
        StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Unable to extract value: ");
        m.append(this.temporal.getClass());
        throw new DateTimeException(m.toString());
    }

    /* access modifiers changed from: package-private */
    public void startOptional() {
        this.optional++;
    }

    public String toString() {
        return this.temporal.toString();
    }
}
