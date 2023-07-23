package p009j$.time.temporal;

import p009j$.time.ZoneId;

/* renamed from: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda4 */
public final /* synthetic */ class TemporalQueries$$ExternalSyntheticLambda4 implements TemporalQuery {
    public static final /* synthetic */ TemporalQueries$$ExternalSyntheticLambda4 INSTANCE = new TemporalQueries$$ExternalSyntheticLambda4();

    private /* synthetic */ TemporalQueries$$ExternalSyntheticLambda4() {
    }

    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        int i = TemporalQueries.$r8$clinit;
        ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries$$ExternalSyntheticLambda0.INSTANCE);
        return zoneId != null ? zoneId : (ZoneId) temporalAccessor.query(TemporalQueries$$ExternalSyntheticLambda3.INSTANCE);
    }
}
