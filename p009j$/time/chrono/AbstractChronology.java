package p009j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import p009j$.lang.Iterable;
import p009j$.time.DateTimeException;
import p009j$.time.DayOfWeek;
import p009j$.time.LocalDate;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.ChronoUnit;
import p009j$.time.temporal.TemporalAdjusters;
import p009j$.time.temporal.TemporalUnit;
import p009j$.util.concurrent.ConcurrentHashMap;

/* renamed from: j$.time.chrono.AbstractChronology */
public abstract class AbstractChronology implements Chronology {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new Locale("ja", "JP", "JP");
    }

    protected AbstractChronology() {
    }

    /* access modifiers changed from: package-private */
    public void addFieldValue(Map map, ChronoField chronoField, long j) {
        Long l = (Long) map.get(chronoField);
        if (l == null || l.longValue() == j) {
            map.put(chronoField, Long.valueOf(j));
            return;
        }
        throw new DateTimeException("Conflict found: " + chronoField + " " + l + " differs from " + chronoField + " " + j);
    }

    public int compareTo(Object obj) {
        Objects.requireNonNull((Chronology) obj);
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractChronology)) {
            return false;
        }
        Objects.requireNonNull((AbstractChronology) obj);
        return true;
    }

    public int hashCode() {
        return getClass().hashCode() ^ 72805;
    }

    /* access modifiers changed from: package-private */
    public ChronoLocalDate resolveAligned(ChronoLocalDate chronoLocalDate, long j, long j2, long j3) {
        long j4;
        LocalDate plus = ((LocalDate) chronoLocalDate).plus(j, (TemporalUnit) ChronoUnit.MONTHS);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        LocalDate plus2 = plus.plus(j2, (TemporalUnit) chronoUnit);
        if (j3 > 7) {
            j4 = j3 - 1;
            plus2 = plus2.plus(j4 / 7, (TemporalUnit) chronoUnit);
        } else {
            if (j3 < 1) {
                plus2 = plus2.plus(Iterable.CC.m$4(j3, 7) / 7, (TemporalUnit) chronoUnit);
                j4 = j3 + 6;
            }
            return plus2.with(TemporalAdjusters.nextOrSame(DayOfWeek.m184of((int) j3)));
        }
        j3 = (j4 % 7) + 1;
        return plus2.with(TemporalAdjusters.nextOrSame(DayOfWeek.m184of((int) j3)));
    }

    public String toString() {
        return ExifInterface.TAG_RW2_ISO;
    }
}
