package media.tiger.tigerbox.services.interfaces;

import java.util.Date;
import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "", "currentInstantTime", "", "getCurrentInstantTime", "()Ljava/lang/String;", "currentSystemTimeMillis", "", "getCurrentSystemTimeMillis", "()J", "currentTime", "getCurrentTime", "parseUtcDateString", "Ljava/util/Date;", "date", "toUtcDateString", "time", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TimeService.kt */
public interface TimeService {
    String getCurrentInstantTime();

    long getCurrentSystemTimeMillis();

    String getCurrentTime();

    Date parseUtcDateString(String str);

    String toUtcDateString(long j);
}
