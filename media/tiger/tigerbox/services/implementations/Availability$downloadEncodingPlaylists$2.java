package media.tiger.tigerbox.services.implementations;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.services.implementations.Availability;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.MultiFileDownloadState;

@Metadata(mo33736d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\n¢\u0006\u0002\b\f"}, mo33737d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "downloaded", "", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService$FileDownloadInfo;", "state", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/MultiFileDownloadState;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Availability.kt */
final class Availability$downloadEncodingPlaylists$2 extends Lambda implements Function5<Boolean, String, String, List<? extends DownloadsManagerService.FileDownloadInfo>, MultiFileDownloadState, Unit> {
    final /* synthetic */ Availability.AudioDownload $download;
    final /* synthetic */ List<DownloadsManagerService.FileDownloadInfo> $m3u8List;
    final /* synthetic */ Availability this$0;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Availability.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MultiFileDownloadState.values().length];
            iArr[MultiFileDownloadState.FINISHED_ALL_SUCCESS.ordinal()] = 1;
            iArr[MultiFileDownloadState.FINISHED_SOME_FAILED.ordinal()] = 2;
            iArr[MultiFileDownloadState.FINISHED_ONE_DOWNLOADING_REST.ordinal()] = 3;
            iArr[MultiFileDownloadState.CANCELED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$downloadEncodingPlaylists$2(Availability availability, Availability.AudioDownload audioDownload, List<DownloadsManagerService.FileDownloadInfo> list) {
        super(5);
        this.this$0 = availability;
        this.$download = audioDownload;
        this.$m3u8List = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke(((Boolean) obj).booleanValue(), (String) obj2, (String) obj3, (List<DownloadsManagerService.FileDownloadInfo>) (List) obj4, (MultiFileDownloadState) obj5);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, String str, String str2, List<DownloadsManagerService.FileDownloadInfo> list, MultiFileDownloadState multiFileDownloadState) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 2>");
        Intrinsics.checkNotNullParameter(list, "downloaded");
        Intrinsics.checkNotNullParameter(multiFileDownloadState, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[multiFileDownloadState.ordinal()];
        if (i == 1) {
            this.this$0.progressAudioDownload(this.$download, 20);
            this.this$0.downloadTsFiles(this.$download, this.this$0.parseEncodingPlaylists(this.$download, list));
        } else if (i == 2) {
            this.this$0.failAudioDownload(this.$download);
        } else if (i == 3) {
            this.this$0.progressAudioDownload(this.$download, ((int) ((((float) list.size()) / ((float) this.$m3u8List.size())) * 10.0f)) + 10);
        } else if (i == 4) {
            Job unused = this.this$0.finishAudioDownload(this.$download);
        }
    }
}
