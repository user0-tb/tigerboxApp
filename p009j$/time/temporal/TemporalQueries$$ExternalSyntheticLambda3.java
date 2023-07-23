package p009j$.time.temporal;

import p009j$.time.ZoneOffset;

/* renamed from: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda3 */
public final /* synthetic */ class TemporalQueries$$ExternalSyntheticLambda3 implements TemporalQuery {
    public static final /* synthetic */ TemporalQueries$$ExternalSyntheticLambda3 INSTANCE = new TemporalQueries$$ExternalSyntheticLambda3();

    private /* synthetic */ TemporalQueries$$ExternalSyntheticLambda3() {
    }

    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        int i = TemporalQueries.$r8$clinit;
        ChronoField chronoField = ChronoField.OFFSET_SECONDS;
        if (temporalAccessor.isSupported(chronoField)) {
            return ZoneOffset.ofTotalSeconds(temporalAccessor.get(chronoField));
        }
        return null;
    }
}
