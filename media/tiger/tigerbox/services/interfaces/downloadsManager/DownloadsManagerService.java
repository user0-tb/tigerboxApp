package media.tiger.tigerbox.services.interfaces.downloadsManager;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001'Ji\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032O\b\u0002\u0010\u000e\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fH&Ju\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032O\b\u0002\u0010\u000e\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fH&J©\u0001\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c2\b\u0002\u0010\u000e\u001ay\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001dH&J\u0012\u0010!\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019H&J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H&J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006("}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService;", "", "downloadsFolder", "", "getDownloadsFolder", "()Ljava/lang/String;", "downloadsInProgress", "", "getDownloadsInProgress", "()Z", "downloadFile", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadJob;", "url", "destinationPath", "onProgress", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "success", "path", "", "destinationFileNameNoExt", "destinationDirectory", "downloadFiles", "list", "", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService$FileDownloadInfo;", "onShouldContinue", "Lkotlin/Function0;", "Lkotlin/Function5;", "downloaded", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/MultiFileDownloadState;", "state", "jobWithUrl", "jobsInProgress", "registerListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerListener;", "unregisterListener", "FileDownloadInfo", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadsManagerService.kt */
public interface DownloadsManagerService {
    DownloadJob downloadFile(String str, String str2, String str3, Function3<? super Boolean, ? super String, ? super String, Unit> function3);

    DownloadJob downloadFile(String str, String str2, Function3<? super Boolean, ? super String, ? super String, Unit> function3);

    void downloadFiles(List<FileDownloadInfo> list, Function0<Boolean> function0, Function5<? super Boolean, ? super String, ? super String, ? super List<FileDownloadInfo>, ? super MultiFileDownloadState, Unit> function5);

    String getDownloadsFolder();

    boolean getDownloadsInProgress();

    DownloadJob jobWithUrl(String str);

    List<DownloadJob> jobsInProgress();

    void registerListener(DownloadsManagerListener downloadsManagerListener);

    void unregisterListener(DownloadsManagerListener downloadsManagerListener);

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService$FileDownloadInfo;", "", "url", "", "destinationPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getDestinationPath", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DownloadsManagerService.kt */
    public static final class FileDownloadInfo {
        private final String destinationPath;
        private final String url;

        public static /* synthetic */ FileDownloadInfo copy$default(FileDownloadInfo fileDownloadInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileDownloadInfo.url;
            }
            if ((i & 2) != 0) {
                str2 = fileDownloadInfo.destinationPath;
            }
            return fileDownloadInfo.copy(str, str2);
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.destinationPath;
        }

        public final FileDownloadInfo copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "destinationPath");
            return new FileDownloadInfo(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FileDownloadInfo)) {
                return false;
            }
            FileDownloadInfo fileDownloadInfo = (FileDownloadInfo) obj;
            return Intrinsics.areEqual((Object) this.url, (Object) fileDownloadInfo.url) && Intrinsics.areEqual((Object) this.destinationPath, (Object) fileDownloadInfo.destinationPath);
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.destinationPath.hashCode();
        }

        public String toString() {
            return "FileDownloadInfo(url=" + this.url + ", destinationPath=" + this.destinationPath + ')';
        }

        public FileDownloadInfo(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "destinationPath");
            this.url = str;
            this.destinationPath = str2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getDestinationPath() {
            return this.destinationPath;
        }
    }

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DownloadsManagerService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void downloadFiles$default(DownloadsManagerService downloadsManagerService, List list, Function0 function0, Function5 function5, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function0 = null;
                }
                if ((i & 4) != 0) {
                    function5 = null;
                }
                downloadsManagerService.downloadFiles(list, function0, function5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFiles");
        }

        public static /* synthetic */ DownloadJob downloadFile$default(DownloadsManagerService downloadsManagerService, String str, String str2, Function3 function3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function3 = null;
                }
                return downloadsManagerService.downloadFile(str, str2, function3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFile");
        }

        public static /* synthetic */ DownloadJob downloadFile$default(DownloadsManagerService downloadsManagerService, String str, String str2, String str3, Function3 function3, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    function3 = null;
                }
                return downloadsManagerService.downloadFile(str, str2, str3, function3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFile");
        }
    }
}
