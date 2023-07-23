package p009j$.time.format;

import p009j$.time.ZoneId;
import p009j$.time.ZoneOffset;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalQueries;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0;
import p009j$.time.temporal.TemporalQuery;

/* renamed from: j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticLambda0 */
public final /* synthetic */ class DateTimeFormatterBuilder$$ExternalSyntheticLambda0 implements TemporalQuery {
    public static final /* synthetic */ DateTimeFormatterBuilder$$ExternalSyntheticLambda0 INSTANCE = new DateTimeFormatterBuilder$$ExternalSyntheticLambda0();

    private /* synthetic */ DateTimeFormatterBuilder$$ExternalSyntheticLambda0() {
    }

    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        int i = DateTimeFormatterBuilder.$r8$clinit;
        int i2 = TemporalQueries.$r8$clinit;
        ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries$$ExternalSyntheticLambda0.INSTANCE);
        if (zoneId == null || (zoneId instanceof ZoneOffset)) {
            return null;
        }
        return zoneId;
    }
}
