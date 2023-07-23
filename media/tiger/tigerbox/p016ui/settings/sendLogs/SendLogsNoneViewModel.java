package media.tiger.tigerbox.p016ui.settings.sendLogs;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/sendLogs/SendLogsNoneViewModel;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;)V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel */
/* compiled from: SendLogsNoneViewModel.kt */
public final class SendLogsNoneViewModel extends DialogViewModel {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SendLogsNoneViewModel(ButtonService buttonService) {
        super(buttonService);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
    }
}
