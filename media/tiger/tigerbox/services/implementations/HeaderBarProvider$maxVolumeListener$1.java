package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.VolumeChangedListener;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/HeaderBarProvider$maxVolumeListener$1", "Lmedia/tiger/tigerbox/services/interfaces/VolumeChangedListener;", "onVolumeChanged", "", "newVolume", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeaderBarProvider.kt */
public final class HeaderBarProvider$maxVolumeListener$1 implements VolumeChangedListener {
    final /* synthetic */ HeaderBarProvider this$0;

    HeaderBarProvider$maxVolumeListener$1(HeaderBarProvider headerBarProvider) {
        this.this$0 = headerBarProvider;
    }

    public void onVolumeChanged(int i) {
        this.this$0._maxVolumeChanged.postValue(Integer.valueOf(i));
    }
}
