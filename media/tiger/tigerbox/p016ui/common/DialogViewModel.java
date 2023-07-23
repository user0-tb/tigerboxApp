package media.tiger.tigerbox.p016ui.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.ButtonService;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "Lmedia/tiger/tigerbox/ui/common/BaseViewModel;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;)V", "onViewClose", "", "onViewExit", "onViewPrepared", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.DialogViewModel */
/* compiled from: DialogViewModel.kt */
public abstract class DialogViewModel extends BaseViewModel {
    private final ButtonService buttonService;

    public void onViewClose() {
    }

    public void onViewPrepared() {
    }

    public DialogViewModel(ButtonService buttonService2) {
        Intrinsics.checkNotNullParameter(buttonService2, "buttonService");
        this.buttonService = buttonService2;
    }

    public void onViewExit() {
        onViewClose();
    }
}
