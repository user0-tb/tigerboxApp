package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimeListener;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/HeaderBarProvider$sleepTimeListener$1", "Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimeListener;", "onSleepTimeInitialValueChanged", "", "onSleepTimeTick", "secondsUntilFinished", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeaderBarProvider.kt */
public final class HeaderBarProvider$sleepTimeListener$1 implements ShutDownTimeListener {
    final /* synthetic */ HeaderBarProvider this$0;

    public void onSleepTimeInitialValueChanged() {
    }

    HeaderBarProvider$sleepTimeListener$1(HeaderBarProvider headerBarProvider) {
        this.this$0 = headerBarProvider;
    }

    public void onSleepTimeTick(int i) {
        this.this$0._sleepTimeTick.postValue(Integer.valueOf(i));
    }
}
