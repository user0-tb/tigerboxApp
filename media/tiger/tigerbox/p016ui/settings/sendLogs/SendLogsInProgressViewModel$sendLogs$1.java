package media.tiger.tigerbox.p016ui.settings.sendLogs;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.TigerBoxLogTree;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel$sendLogs$1 */
/* compiled from: SendLogsInProgressViewModel.kt */
final class SendLogsInProgressViewModel$sendLogs$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SendLogsInProgressViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SendLogsInProgressViewModel$sendLogs$1(SendLogsInProgressViewModel sendLogsInProgressViewModel) {
        super(0);
        this.this$0 = sendLogsInProgressViewModel;
    }

    public final void invoke() {
        TigerBoxLogTree access$getBoxLogTree$p = this.this$0.boxLogTree;
        final SendLogsInProgressViewModel sendLogsInProgressViewModel = this.this$0;
        access$getBoxLogTree$p.uploadLogs(new Function0<Unit>() {
            public final void invoke() {
                sendLogsInProgressViewModel.postViewState(true);
            }
        });
    }
}
