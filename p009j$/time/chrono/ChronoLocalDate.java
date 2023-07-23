package p009j$.time.chrono;

import p009j$.time.LocalTime;
import p009j$.time.temporal.Temporal;
import p009j$.time.temporal.TemporalAdjuster;
import p009j$.time.temporal.TemporalAmount;
import p009j$.time.temporal.TemporalField;

/* renamed from: j$.time.chrono.ChronoLocalDate */
public interface ChronoLocalDate extends Temporal, TemporalAdjuster, Comparable<ChronoLocalDate> {
    ChronoLocalDateTime atTime(LocalTime localTime);

    boolean equals(Object obj);

    Chronology getChronology();

    boolean isSupported(TemporalField temporalField);

    ChronoLocalDate plus(TemporalAmount temporalAmount);

    long toEpochDay();
}
