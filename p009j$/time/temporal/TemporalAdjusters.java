package p009j$.time.temporal;

import java.util.Objects;
import p009j$.time.DateTimeException;
import p009j$.time.DayOfWeek;

/* renamed from: j$.time.temporal.TemporalAdjusters */
public abstract class TemporalAdjusters {
    public static int $default$get(TemporalAccessor temporalAccessor, TemporalField temporalField) {
        ValueRange range = temporalAccessor.range(temporalField);
        if (range.isIntValue()) {
            long j = temporalAccessor.getLong(temporalField);
            if (range.isValidValue(j)) {
                return (int) j;
            }
            throw new DateTimeException("Invalid value for " + temporalField + " (valid values " + range + "): " + j);
        }
        throw new UnsupportedTemporalTypeException("Invalid field " + temporalField + " for get() method, use getLong() instead");
    }

    public static Object $default$query(TemporalAccessor temporalAccessor, TemporalQuery temporalQuery) {
        int i = TemporalQueries.$r8$clinit;
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda0.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda1.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda2.INSTANCE) {
            return null;
        }
        return temporalQuery.queryFrom(temporalAccessor);
    }

    public static ValueRange $default$range(TemporalAccessor temporalAccessor, TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            Objects.requireNonNull(temporalField, "field");
            return temporalField.rangeRefinedBy(temporalAccessor);
        } else if (temporalAccessor.isSupported(temporalField)) {
            return temporalField.range();
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    /* renamed from: m */
    public static /* synthetic */ int m195m(int i, int i2) {
        int i3 = i % i2;
        if (i3 == 0) {
            return 0;
        }
        return (((i ^ i2) >> 31) | 1) > 0 ? i3 : i3 + i2;
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) {
        return new TemporalAdjusters$$ExternalSyntheticLambda1(dayOfWeek.getValue());
    }
}
