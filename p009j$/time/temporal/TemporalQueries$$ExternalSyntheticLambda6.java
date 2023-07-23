package p009j$.time.temporal;

import p009j$.time.LocalTime;

/* renamed from: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda6 */
public final /* synthetic */ class TemporalQueries$$ExternalSyntheticLambda6 implements TemporalQuery {
    public static final /* synthetic */ TemporalQueries$$ExternalSyntheticLambda6 INSTANCE = new TemporalQueries$$ExternalSyntheticLambda6();

    private /* synthetic */ TemporalQueries$$ExternalSyntheticLambda6() {
    }

    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        int i = TemporalQueries.$r8$clinit;
        ChronoField chronoField = ChronoField.NANO_OF_DAY;
        if (temporalAccessor.isSupported(chronoField)) {
            return LocalTime.ofNanoOfDay(temporalAccessor.getLong(chronoField));
        }
        return null;
    }
}
