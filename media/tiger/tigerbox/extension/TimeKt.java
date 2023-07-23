package media.tiger.tigerbox.extension;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0006"}, mo33737d2 = {"millisToSeconds", "", "", "minutesToSeconds", "secondsToMillis", "secondsToMinutes", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: time.kt */
public final class TimeKt {
    public static final long secondsToMillis(int i) {
        return TimeUnit.SECONDS.toMillis((long) i);
    }

    public static final int secondsToMinutes(int i) {
        return (int) TimeUnit.SECONDS.toMinutes((long) i);
    }

    public static final int minutesToSeconds(int i) {
        return (int) TimeUnit.MINUTES.toSeconds((long) i);
    }

    public static final int millisToSeconds(long j) {
        return (int) TimeUnit.MILLISECONDS.toSeconds(j);
    }
}
