package p009j$.time.chrono;

import java.util.Objects;
import p009j$.time.LocalDateTime;
import p009j$.time.ZonedDateTime;
import p009j$.time.chrono.ChronoZonedDateTime;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalAdjusters;
import p009j$.time.temporal.TemporalField;
import p009j$.time.temporal.TemporalQueries;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1;
import p009j$.time.temporal.UnsupportedTemporalTypeException;

/* renamed from: j$.time.chrono.Chronology */
public interface Chronology extends Comparable {

    /* renamed from: j$.time.chrono.Chronology$-CC  reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static int $default$get(ChronoZonedDateTime chronoZonedDateTime, TemporalField temporalField) {
            if (!(temporalField instanceof ChronoField)) {
                return TemporalAdjusters.$default$get(chronoZonedDateTime, temporalField);
            }
            int i = ChronoZonedDateTime.C14151.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
            if (i != 1) {
                ZonedDateTime zonedDateTime = (ZonedDateTime) chronoZonedDateTime;
                return i != 2 ? ((LocalDateTime) zonedDateTime.toLocalDateTime()).get(temporalField) : zonedDateTime.getOffset().getTotalSeconds();
            }
            throw new UnsupportedTemporalTypeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }

        public static Chronology from(TemporalAccessor temporalAccessor) {
            Objects.requireNonNull(temporalAccessor, "temporal");
            int i = TemporalQueries.$r8$clinit;
            Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries$$ExternalSyntheticLambda1.INSTANCE);
            return chronology != null ? chronology : IsoChronology.INSTANCE;
        }
    }
}
