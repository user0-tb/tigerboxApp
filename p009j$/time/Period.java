package p009j$.time;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.regex.Pattern;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.temporal.ChronoUnit;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalAmount;
import p009j$.time.temporal.TemporalQueries;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1;
import p009j$.time.temporal.TemporalUnit;

/* renamed from: j$.time.Period */
public final class Period implements TemporalAmount, Serializable {
    public static final Period ZERO = new Period(0, 0, 0);
    private final int days;
    private final int months;
    private final int years;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        Collections.unmodifiableList(Arrays.asList(new TemporalUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    private Period(int i, int i2, int i3) {
        this.years = i;
        this.months = i2;
        this.days = i3;
    }

    public static Period ofDays(int i) {
        return (0 | i) == 0 ? ZERO : new Period(0, 0, i);
    }

    private void validateChrono(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        int i = TemporalQueries.$r8$clinit;
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries$$ExternalSyntheticLambda1.INSTANCE);
        if (chronology != null && !IsoChronology.INSTANCE.equals(chronology)) {
            throw new DateTimeException("Chronology mismatch, expected: ISO, actual: ISO");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p009j$.time.temporal.Temporal addTo(p009j$.time.temporal.Temporal r6) {
        /*
            r5 = this;
            r5.validateChrono(r6)
            int r0 = r5.months
            if (r0 != 0) goto L_0x000f
            int r0 = r5.years
            if (r0 == 0) goto L_0x001f
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = p009j$.time.temporal.ChronoUnit.YEARS
            goto L_0x001b
        L_0x000f:
            long r0 = r5.toTotalMonths()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            j$.time.temporal.ChronoUnit r2 = p009j$.time.temporal.ChronoUnit.MONTHS
        L_0x001b:
            j$.time.temporal.Temporal r6 = r6.plus(r0, r2)
        L_0x001f:
            int r0 = r5.days
            if (r0 == 0) goto L_0x002a
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = p009j$.time.temporal.ChronoUnit.DAYS
            j$.time.temporal.Temporal r6 = r6.plus(r0, r2)
        L_0x002a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.Period.addTo(j$.time.temporal.Temporal):j$.time.temporal.Temporal");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.years == period.years && this.months == period.months && this.days == period.days;
    }

    public int getDays() {
        return this.days;
    }

    public int hashCode() {
        return Integer.rotateLeft(this.days, 16) + Integer.rotateLeft(this.months, 8) + this.years;
    }

    public boolean isZero() {
        return this == ZERO;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p009j$.time.temporal.Temporal subtractFrom(p009j$.time.temporal.Temporal r6) {
        /*
            r5 = this;
            r5.validateChrono(r6)
            int r0 = r5.months
            if (r0 != 0) goto L_0x000f
            int r0 = r5.years
            if (r0 == 0) goto L_0x0021
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = p009j$.time.temporal.ChronoUnit.YEARS
            goto L_0x001b
        L_0x000f:
            long r0 = r5.toTotalMonths()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0021
            j$.time.temporal.ChronoUnit r2 = p009j$.time.temporal.ChronoUnit.MONTHS
        L_0x001b:
            j$.time.Instant r6 = (p009j$.time.Instant) r6
            j$.time.temporal.Temporal r6 = r6.minus(r0, r2)
        L_0x0021:
            int r0 = r5.days
            if (r0 == 0) goto L_0x002e
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = p009j$.time.temporal.ChronoUnit.DAYS
            j$.time.Instant r6 = (p009j$.time.Instant) r6
            j$.time.temporal.Temporal r6 = r6.minus(r0, r2)
        L_0x002e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.Period.subtractFrom(j$.time.temporal.Temporal):j$.time.temporal.Temporal");
    }

    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int i = this.years;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.months;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.days;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    public long toTotalMonths() {
        return (((long) this.years) * 12) + ((long) this.months);
    }
}
