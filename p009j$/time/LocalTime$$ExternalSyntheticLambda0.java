package p009j$.time;

import java.util.Objects;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalQueries;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda6;
import p009j$.time.temporal.TemporalQuery;

/* renamed from: j$.time.LocalTime$$ExternalSyntheticLambda0 */
public final /* synthetic */ class LocalTime$$ExternalSyntheticLambda0 implements TemporalQuery {
    public static final /* synthetic */ LocalTime$$ExternalSyntheticLambda0 INSTANCE = new LocalTime$$ExternalSyntheticLambda0();

    private /* synthetic */ LocalTime$$ExternalSyntheticLambda0() {
    }

    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        LocalTime localTime = LocalTime.MIN;
        Objects.requireNonNull(temporalAccessor, "temporal");
        int i = TemporalQueries.$r8$clinit;
        LocalTime localTime2 = (LocalTime) temporalAccessor.query(TemporalQueries$$ExternalSyntheticLambda6.INSTANCE);
        if (localTime2 != null) {
            return localTime2;
        }
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }
}
