package p009j$.time.temporal;

import p009j$.time.LocalDate;

/* renamed from: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda5 */
public final /* synthetic */ class TemporalQueries$$ExternalSyntheticLambda5 implements TemporalQuery {
    public static final /* synthetic */ TemporalQueries$$ExternalSyntheticLambda5 INSTANCE = new TemporalQueries$$ExternalSyntheticLambda5();

    private /* synthetic */ TemporalQueries$$ExternalSyntheticLambda5() {
    }

    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        int i = TemporalQueries.$r8$clinit;
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (temporalAccessor.isSupported(chronoField)) {
            return LocalDate.ofEpochDay(temporalAccessor.getLong(chronoField));
        }
        return null;
    }
}
