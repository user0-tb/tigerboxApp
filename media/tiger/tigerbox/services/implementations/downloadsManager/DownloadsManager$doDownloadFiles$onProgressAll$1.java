package media.tiger.tigerbox.services.implementations.downloadsManager;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.MultiFileDownloadState;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n¢\u0006\u0002\b\b"}, mo33737d2 = {"<anonymous>", "", "success", "", "canceled", "downloaded", "", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService$FileDownloadInfo;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadsManager.kt */
final class DownloadsManager$doDownloadFiles$onProgressAll$1 extends Lambda implements Function3<Boolean, Boolean, List<? extends DownloadsManagerService.FileDownloadInfo>, Unit> {
    final /* synthetic */ Function5<Boolean, String, String, List<DownloadsManagerService.FileDownloadInfo>, MultiFileDownloadState, Unit> $onProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DownloadsManager$doDownloadFiles$onProgressAll$1(Function5<? super Boolean, ? super String, ? super String, ? super List<DownloadsManagerService.FileDownloadInfo>, ? super MultiFileDownloadState, Unit> function5) {
        super(3);
        this.$onProgress = function5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (List<DownloadsManagerService.FileDownloadInfo>) (List) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, boolean z2, List<DownloadsManagerService.FileDownloadInfo> list) {
        Intrinsics.checkNotNullParameter(list, "downloaded");
        MultiFileDownloadState multiFileDownloadState = MultiFileDownloadState.FINISHED_SOME_FAILED;
        if (z) {
            multiFileDownloadState = MultiFileDownloadState.FINISHED_ALL_SUCCESS;
        }
        if (z2) {
            multiFileDownloadState = MultiFileDownloadState.CANCELED;
        }
        MultiFileDownloadState multiFileDownloadState2 = multiFileDownloadState;
        Function5<Boolean, String, String, List<DownloadsManagerService.FileDownloadInfo>, MultiFileDownloadState, Unit> function5 = this.$onProgress;
        if (function5 != null) {
            function5.invoke(Boolean.valueOf(z), "", "", list, multiFileDownloadState2);
        }
    }
}
