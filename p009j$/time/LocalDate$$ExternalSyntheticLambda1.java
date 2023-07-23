package p009j$.time;

import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalQuery;

/* renamed from: j$.time.LocalDate$$ExternalSyntheticLambda1 */
public final /* synthetic */ class LocalDate$$ExternalSyntheticLambda1 implements TemporalQuery {
    public static final /* synthetic */ LocalDate$$ExternalSyntheticLambda1 INSTANCE = new LocalDate$$ExternalSyntheticLambda1();

    private /* synthetic */ LocalDate$$ExternalSyntheticLambda1() {
    }

    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return LocalDate.from(temporalAccessor);
    }
}
