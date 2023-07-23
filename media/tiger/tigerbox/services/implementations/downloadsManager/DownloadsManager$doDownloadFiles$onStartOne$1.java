package media.tiger.tigerbox.services.implementations.downloadsManager;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.MultiFileDownloadState;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService$FileDownloadInfo;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadsManager.kt */
final class DownloadsManager$doDownloadFiles$onStartOne$1 extends Lambda implements Function1<DownloadsManagerService.FileDownloadInfo, Unit> {
    final /* synthetic */ Function5<Boolean, String, String, List<DownloadsManagerService.FileDownloadInfo>, MultiFileDownloadState, Unit> $onProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DownloadsManager$doDownloadFiles$onStartOne$1(Function5<? super Boolean, ? super String, ? super String, ? super List<DownloadsManagerService.FileDownloadInfo>, ? super MultiFileDownloadState, Unit> function5) {
        super(1);
        this.$onProgress = function5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DownloadsManagerService.FileDownloadInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DownloadsManagerService.FileDownloadInfo fileDownloadInfo) {
        Intrinsics.checkNotNullParameter(fileDownloadInfo, "it");
        Function5<Boolean, String, String, List<DownloadsManagerService.FileDownloadInfo>, MultiFileDownloadState, Unit> function5 = this.$onProgress;
        if (function5 != null) {
            function5.invoke(false, "", "", CollectionsKt.listOf(fileDownloadInfo), MultiFileDownloadState.WILL_BEGIN_ONE);
        }
    }
}
