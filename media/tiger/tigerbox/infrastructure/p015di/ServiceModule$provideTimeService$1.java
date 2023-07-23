package media.tiger.tigerbox.infrastructure.p015di;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.Constants;
import media.tiger.tigerbox.services.interfaces.TimeService;
import p009j$.time.Instant;

@Metadata(mo33736d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u0011"}, mo33737d2 = {"media/tiger/tigerbox/infrastructure/di/ServiceModule$provideTimeService$1", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "currentInstantTime", "", "getCurrentInstantTime", "()Ljava/lang/String;", "currentSystemTimeMillis", "", "getCurrentSystemTimeMillis", "()J", "currentTime", "getCurrentTime", "parseUtcDateString", "Ljava/util/Date;", "date", "toUtcDateString", "time", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule$provideTimeService$1 */
/* compiled from: ServiceModule.kt */
public final class ServiceModule$provideTimeService$1 implements TimeService {
    ServiceModule$provideTimeService$1() {
    }

    public String getCurrentTime() {
        return new SimpleDateFormat(Constants.TIME_DATE_FORMAT, Locale.getDefault()).format(new Date());
    }

    public String getCurrentInstantTime() {
        String instant = Instant.now().toString();
        Intrinsics.checkNotNullExpressionValue(instant, "now().toString()");
        return instant;
    }

    public String toUtcDateString(long j) {
        String instant = Instant.ofEpochMilli(j).toString();
        Intrinsics.checkNotNullExpressionValue(instant, "ofEpochMilli(time).toString()");
        return instant;
    }

    public Date parseUtcDateString(String str) {
        Intrinsics.checkNotNullParameter(str, "date");
        return new Date(Instant.parse(str).toEpochMilli());
    }

    public long getCurrentSystemTimeMillis() {
        return Instant.now().toEpochMilli();
    }
}
