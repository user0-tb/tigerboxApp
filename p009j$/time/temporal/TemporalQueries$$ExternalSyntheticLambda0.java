package p009j$.time.temporal;

import p009j$.time.ZoneId;

/* renamed from: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0 */
public final /* synthetic */ class TemporalQueries$$ExternalSyntheticLambda0 implements TemporalQuery {
    public static final /* synthetic */ TemporalQueries$$ExternalSyntheticLambda0 INSTANCE = new TemporalQueries$$ExternalSyntheticLambda0();

    private /* synthetic */ TemporalQueries$$ExternalSyntheticLambda0() {
    }

    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        int i = TemporalQueries.$r8$clinit;
        return (ZoneId) temporalAccessor.query(INSTANCE);
    }
}
