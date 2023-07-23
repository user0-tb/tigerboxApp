package media.tiger.tigerbox.p016ui.common;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "getHeaderProvider", "()Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.FullScreenViewModel */
/* compiled from: FullScreenViewModel.kt */
public class FullScreenViewModel extends DialogViewModel {
    private final HeaderProvider headerProvider;

    public final HeaderProvider getHeaderProvider() {
        return this.headerProvider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public FullScreenViewModel(ButtonService buttonService, HeaderProvider headerProvider2) {
        super(buttonService);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(headerProvider2, "headerProvider");
        this.headerProvider = headerProvider2;
    }
}
