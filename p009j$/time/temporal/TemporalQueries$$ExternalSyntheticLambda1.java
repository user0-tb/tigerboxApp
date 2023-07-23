package p009j$.time.temporal;

import p009j$.time.chrono.Chronology;

/* renamed from: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1 */
public final /* synthetic */ class TemporalQueries$$ExternalSyntheticLambda1 implements TemporalQuery {
    public static final /* synthetic */ TemporalQueries$$ExternalSyntheticLambda1 INSTANCE = new TemporalQueries$$ExternalSyntheticLambda1();

    private /* synthetic */ TemporalQueries$$ExternalSyntheticLambda1() {
    }

    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        int i = TemporalQueries.$r8$clinit;
        return (Chronology) temporalAccessor.query(INSTANCE);
    }
}
