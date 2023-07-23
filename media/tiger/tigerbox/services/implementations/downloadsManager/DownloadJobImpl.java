package media.tiger.tigerbox.services.implementations.downloadsManager;

import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadJob;
import okhttp3.ResponseBody;
import retrofit2.Call;

@Metadata(mo33736d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010N\u001a\u000204H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017Ra\u0010,\u001aI\u0012\u0013\u0012\u00110.¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(3\u0012\u0004\u0012\u000204\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR\u0014\u0010E\u001a\u00020.8VX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010?R\u0014\u0010F\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\tR\u0014\u0010I\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\tR\u0014\u0010L\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\t¨\u0006O"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/downloadsManager/DownloadJobImpl;", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadJob;", "sourceUrl", "", "destinationPath", "baseUrl", "urlFileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getDestinationPath", "dlCall", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "getDlCall", "()Lretrofit2/Call;", "setDlCall", "(Lretrofit2/Call;)V", "dlLength", "", "getDlLength", "()J", "setDlLength", "(J)V", "dlProgress", "", "getDlProgress", "()I", "setDlProgress", "(I)V", "dlTryCount", "getDlTryCount", "setDlTryCount", "downloadedLengthKb", "getDownloadedLengthKb", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "fileLength", "getFileLength", "setFileLength", "finishLambda", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "success", "url", "path", "", "getFinishLambda", "()Lkotlin/jvm/functions/Function3;", "setFinishLambda", "(Lkotlin/jvm/functions/Function3;)V", "finishMessage", "getFinishMessage", "setFinishMessage", "(Ljava/lang/String;)V", "finishShouldPublish", "getFinishShouldPublish", "()Z", "setFinishShouldPublish", "(Z)V", "finishSuccess", "getFinishSuccess", "setFinishSuccess", "isInProgress", "progress", "getProgress", "getSourceUrl", "totalLengthKb", "getTotalLengthKb", "getUrlFileName", "uuid", "getUuid", "cancel", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadJobImpl.kt */
public final class DownloadJobImpl implements DownloadJob {
    private final String baseUrl;
    private final String destinationPath;
    private Call<ResponseBody> dlCall;
    private long dlLength;
    private int dlProgress;
    private int dlTryCount;
    private File file;
    private long fileLength;
    private Function3<? super Boolean, ? super String, ? super String, Unit> finishLambda;
    private String finishMessage;
    private boolean finishShouldPublish = true;
    private boolean finishSuccess;
    private final String sourceUrl;
    private final String urlFileName;
    private final String uuid;

    public DownloadJobImpl(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "sourceUrl");
        Intrinsics.checkNotNullParameter(str2, "destinationPath");
        Intrinsics.checkNotNullParameter(str3, "baseUrl");
        Intrinsics.checkNotNullParameter(str4, "urlFileName");
        this.sourceUrl = str;
        this.destinationPath = str2;
        this.baseUrl = str3;
        this.urlFileName = str4;
        String uuid2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "randomUUID().toString()");
        this.uuid = uuid2;
    }

    public String getSourceUrl() {
        return this.sourceUrl;
    }

    public String getDestinationPath() {
        return this.destinationPath;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getUrlFileName() {
        return this.urlFileName;
    }

    public String getUuid() {
        return this.uuid;
    }

    public final File getFile() {
        return this.file;
    }

    public final void setFile(File file2) {
        this.file = file2;
    }

    public final Call<ResponseBody> getDlCall() {
        return this.dlCall;
    }

    public final void setDlCall(Call<ResponseBody> call) {
        this.dlCall = call;
    }

    public final boolean getFinishShouldPublish() {
        return this.finishShouldPublish;
    }

    public final void setFinishShouldPublish(boolean z) {
        this.finishShouldPublish = z;
    }

    public final Function3<Boolean, String, String, Unit> getFinishLambda() {
        return this.finishLambda;
    }

    public final void setFinishLambda(Function3<? super Boolean, ? super String, ? super String, Unit> function3) {
        this.finishLambda = function3;
    }

    public final boolean getFinishSuccess() {
        return this.finishSuccess;
    }

    public final void setFinishSuccess(boolean z) {
        this.finishSuccess = z;
    }

    public final String getFinishMessage() {
        return this.finishMessage;
    }

    public final void setFinishMessage(String str) {
        this.finishMessage = str;
    }

    public final int getDlTryCount() {
        return this.dlTryCount;
    }

    public final void setDlTryCount(int i) {
        this.dlTryCount = i;
    }

    public final int getDlProgress() {
        return this.dlProgress;
    }

    public final void setDlProgress(int i) {
        this.dlProgress = i;
    }

    public final long getDlLength() {
        return this.dlLength;
    }

    public final void setDlLength(long j) {
        this.dlLength = j;
    }

    public final long getFileLength() {
        return this.fileLength;
    }

    public final void setFileLength(long j) {
        this.fileLength = j;
    }

    public int getProgress() {
        return this.dlProgress;
    }

    public long getDownloadedLengthKb() {
        return this.dlLength;
    }

    public long getTotalLengthKb() {
        return this.fileLength;
    }

    public void cancel() {
        Call<ResponseBody> call = this.dlCall;
        if (call != null) {
            call.cancel();
        }
    }

    public boolean isInProgress() {
        return this.dlCall != null;
    }
}
