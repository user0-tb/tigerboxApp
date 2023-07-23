package p009j$.time.temporal;

/* renamed from: j$.time.temporal.Temporal */
public interface Temporal extends TemporalAccessor {
    Temporal plus(long j, TemporalUnit temporalUnit);

    Temporal with(TemporalAdjuster temporalAdjuster);

    Temporal with(TemporalField temporalField, long j);
}
