package media.tiger.tigerbox.p016ui.settings;

import kotlin.Metadata;
import media.tiger.tigerbox.C2814R;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SeekBarDialogType;", "", "thumbId", "", "maxValue", "backgroundId", "(Ljava/lang/String;IIII)V", "getBackgroundId", "()I", "getMaxValue", "getThumbId", "SCREEN_BRIGHTNESS", "TIGER_LIGHT_INTENSITY", "VOLUME", "SLEEP_TIMER", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SeekBarDialogType */
/* compiled from: SeekBarDialogType.kt */
public enum SeekBarDialogType {
    SCREEN_BRIGHTNESS(C2814R.C2816drawable.seekbar_brightness_thumb, 255, 0, 4, (int) null),
    TIGER_LIGHT_INTENSITY(C2814R.C2816drawable.seekbar_tiger_light_thumb, 100, 0, 4, (int) null),
    VOLUME(C2814R.C2816drawable.seekbar_volume_thumb, -1, 0, 4, (int) null),
    SLEEP_TIMER(C2814R.C2816drawable.seekbar_sleep_timer_thumb, 8, C2814R.C2816drawable.seekbar_progress_sleep_timer_background);
    
    private final int backgroundId;
    private final int maxValue;
    private final int thumbId;

    private SeekBarDialogType(int i, int i2, int i3) {
        this.thumbId = i;
        this.maxValue = i2;
        this.backgroundId = i3;
    }

    public final int getBackgroundId() {
        return this.backgroundId;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final int getThumbId() {
        return this.thumbId;
    }
}
