package media.tiger.tigerbox.services.implementations.downloadsManager;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.data.network.DownloadsWebService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerListener;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.MultiFileDownloadState;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 P2\u00020\u0001:\u0001PB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0002Jg\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032M\u0010 \u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001a\u0018\u00010!H\u0002J¥\u0001\u0010&\u001a\u00020\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010*2}\u0010+\u001ay\u0012\u0013\u0012\u00110\f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020(0\u001c¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110.¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u001a\u0018\u00010,H\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u000fH\u0002Jg\u00102\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032M\u0010+\u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001a\u0018\u00010!H\u0016Js\u00102\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u00104\u001a\u0004\u0018\u00010\u00032M\u0010+\u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001a\u0018\u00010!H\u0016J¥\u0001\u00105\u001a\u00020\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010*2}\u0010+\u001ay\u0012\u0013\u0012\u00110\f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020(0\u001c¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110.¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u001a\u0018\u00010,H\u0016J\u0012\u00106\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0016J\b\u00108\u001a\u00020\u001aH\u0002J\u0018\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u000fH\u0002J\u0010\u0010;\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u000fH\u0002J!\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020>2\u0006\u00101\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u0018H\u0016J\u0016\u0010B\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0002J¦\u0001\u0010C\u001a\u00020\u001a2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010*2U\b\u0002\u0010E\u001aO\u0012\u0013\u0012\u00110\f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(F\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020(0\u001c¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u001a\u0018\u00010!2%\b\u0002\u0010G\u001a\u001f\u0012\u0013\u0012\u00110(¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u001a\u0018\u00010HH\u0002J\u0010\u0010J\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u0018H\u0016J\b\u0010K\u001a\u00020\u001aH\u0002J\u001e\u0010L\u001a\u00020\u001a2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020O0N2\u0006\u00101\u001a\u00020\u000fH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u000ej\b\u0012\u0004\u0012\u00020\u0018`\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006Q"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/downloadsManager/DownloadsManager;", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService;", "applicationDataDir", "", "context", "Landroid/content/Context;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "webDlService", "Lmedia/tiger/tigerbox/data/network/DownloadsWebService;", "(Ljava/lang/String;Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/data/network/DownloadsWebService;)V", "_downloadsInProgress", "", "activeJobs", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/implementations/downloadsManager/DownloadJobImpl;", "Lkotlin/collections/ArrayList;", "downloadsFolder", "getDownloadsFolder", "()Ljava/lang/String;", "downloadsInProgress", "getDownloadsInProgress", "()Z", "listeners", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerListener;", "addRequest", "", "requests", "", "createJob", "url", "destinationPath", "onDone", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "success", "path", "doDownloadFiles", "list", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService$FileDownloadInfo;", "onShouldContinue", "Lkotlin/Function0;", "onProgress", "Lkotlin/Function5;", "downloaded", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/MultiFileDownloadState;", "state", "doRequest", "request", "downloadFile", "destinationFileNameNoExt", "destinationDirectory", "downloadFiles", "jobWithUrl", "jobsInProgress", "publishDownloadingStateChanged", "publishFail", "message", "publishFinish", "publishProgress", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;Lmedia/tiger/tigerbox/services/implementations/downloadsManager/DownloadJobImpl;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerListener", "listener", "removeRequest", "startJobs", "jobRequests", "onProgressAll", "canceled", "onStartOne", "Lkotlin/Function1;", "info", "unregisterListener", "updateDownloadProgress", "writeResponseBodyToDisk", "response", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadsManager.kt */
public final class DownloadsManager implements DownloadsManagerService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DL_TRY_COUNT = 3;
    public static final String DOWNLOADS_FOLDER = "downloads";
    private static final int DOWNLOAD_CHUNK_SIZE = 2048;
    public static final String EXTENSION_SEPARATOR = ".";
    public static final String FOLDERS_SEPARATOR = "/";
    private static final int JOBS_THREAD_COUNT = 6;
    private boolean _downloadsInProgress;
    private ArrayList<DownloadJobImpl> activeJobs = new ArrayList<>();
    private final Context context;
    private final String downloadsFolder;
    /* access modifiers changed from: private */
    public ArrayList<DownloadsManagerListener> listeners = new ArrayList<>();
    private final DownloadsWebService webDlService;
    private final WifiService wifiService;

    public DownloadsManager(String str, Context context2, WifiService wifiService2, DownloadsWebService downloadsWebService) {
        Intrinsics.checkNotNullParameter(str, "applicationDataDir");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(downloadsWebService, "webDlService");
        this.context = context2;
        this.wifiService = wifiService2;
        this.webDlService = downloadsWebService;
        this.downloadsFolder = str + "/downloads/";
    }

    public String getDownloadsFolder() {
        return this.downloadsFolder;
    }

    private final void updateDownloadProgress() {
        synchronized (this.activeJobs) {
            boolean z = true;
            boolean z2 = !this.activeJobs.isEmpty();
            if (this._downloadsInProgress == z2) {
                z = false;
            }
            this._downloadsInProgress = z2;
            if (z) {
                publishDownloadingStateChanged();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean getDownloadsInProgress() {
        return this._downloadsInProgress;
    }

    public DownloadJobImpl jobWithUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        synchronized (this.activeJobs) {
            Iterator<DownloadJobImpl> it = this.activeJobs.iterator();
            while (it.hasNext()) {
                DownloadJobImpl next = it.next();
                if (Intrinsics.areEqual((Object) next.getSourceUrl(), (Object) str)) {
                    return next;
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        }
    }

    private final void doDownloadFiles(List<DownloadsManagerService.FileDownloadInfo> list, Function0<Boolean> function0, Function5<? super Boolean, ? super String, ? super String, ? super List<DownloadsManagerService.FileDownloadInfo>, ? super MultiFileDownloadState, Unit> function5) {
        Function3 downloadsManager$doDownloadFiles$onProgressAll$1 = new DownloadsManager$doDownloadFiles$onProgressAll$1(function5);
        Function1 downloadsManager$doDownloadFiles$onStartOne$1 = new DownloadsManager$doDownloadFiles$onStartOne$1(function5);
        List arrayList = new ArrayList();
        for (DownloadsManagerService.FileDownloadInfo fileDownloadInfo : list) {
            DownloadJobImpl createJob = createJob(fileDownloadInfo.getUrl(), fileDownloadInfo.getDestinationPath(), (Function3<? super Boolean, ? super String, ? super String, Unit>) null);
            createJob.setFinishShouldPublish(false);
            arrayList.add(createJob);
        }
        startJobs(arrayList, function0, downloadsManager$doDownloadFiles$onProgressAll$1, downloadsManager$doDownloadFiles$onStartOne$1);
    }

    public void downloadFiles(List<DownloadsManagerService.FileDownloadInfo> list, Function0<Boolean> function0, Function5<? super Boolean, ? super String, ? super String, ? super List<DownloadsManagerService.FileDownloadInfo>, ? super MultiFileDownloadState, Unit> function5) {
        Intrinsics.checkNotNullParameter(list, "list");
        doDownloadFiles(list, function0, function5);
    }

    public DownloadJobImpl downloadFile(String str, String str2, Function3<? super Boolean, ? super String, ? super String, Unit> function3) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "destinationPath");
        DownloadJobImpl createJob = createJob(str, str2, function3);
        startJobs$default(this, CollectionsKt.listOf(createJob), (Function0) null, (Function3) null, (Function1) null, 14, (Object) null);
        return createJob;
    }

    public DownloadJobImpl downloadFile(String str, String str2, String str3, Function3<? super Boolean, ? super String, ? super String, Unit> function3) {
        Intrinsics.checkNotNullParameter(str, "url");
        StringsKt.substringBeforeLast$default(str, FOLDERS_SEPARATOR, (String) null, 2, (Object) null);
        String substringAfterLast$default = StringsKt.substringAfterLast$default(str, FOLDERS_SEPARATOR, (String) null, 2, (Object) null);
        String substringAfterLast$default2 = StringsKt.substringAfterLast$default(str, EXTENSION_SEPARATOR, (String) null, 2, (Object) null);
        StringBuilder sb = new StringBuilder();
        sb.append(getDownloadsFolder());
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        String sb2 = sb.toString();
        String str4 = sb2 + '/' + substringAfterLast$default;
        if (str2 != null) {
            str4 = sb2 + '/' + StringsKt.substringBeforeLast$default(str2, EXTENSION_SEPARATOR, (String) null, 2, (Object) null) + '.' + substringAfterLast$default2;
        }
        return downloadFile(str, str4, function3);
    }

    private final DownloadJobImpl createJob(String str, String str2, Function3<? super Boolean, ? super String, ? super String, Unit> function3) {
        String str3 = StringsKt.substringBeforeLast$default(str, FOLDERS_SEPARATOR, (String) null, 2, (Object) null) + '/';
        String substringAfterLast$default = StringsKt.substringAfterLast$default(str, FOLDERS_SEPARATOR, (String) null, 2, (Object) null);
        File file = new File(StringsKt.substringBeforeLast$default(str2, FOLDERS_SEPARATOR, (String) null, 2, (Object) null) + '/');
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadJobImpl downloadJobImpl = new DownloadJobImpl(str, str2, str3, substringAfterLast$default);
        downloadJobImpl.setFinishLambda(function3);
        return downloadJobImpl;
    }

    static /* synthetic */ void startJobs$default(DownloadsManager downloadsManager, List list, Function0 function0, Function3 function3, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        downloadsManager.startJobs(list, function0, function3, function1);
    }

    private final void startJobs(List<DownloadJobImpl> list, Function0<Boolean> function0, Function3<? super Boolean, ? super Boolean, ? super List<DownloadsManagerService.FileDownloadInfo>, Unit> function3, Function1<? super DownloadsManagerService.FileDownloadInfo, Unit> function1) {
        addRequest(list);
        Thread thread = new Thread(new DownloadsManager$$ExternalSyntheticLambda0(list, this, function0, function1, function3));
        thread.setPriority(1);
        thread.start();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x005a A[LOOP:1: B:5:0x005a->B:10:0x0066, LOOP_START] */
    /* renamed from: startJobs$lambda-7  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2349startJobs$lambda7(java.util.List r16, media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager r17, kotlin.jvm.functions.Function0 r18, kotlin.jvm.functions.Function1 r19, kotlin.jvm.functions.Function3 r20) {
        /*
            r1 = r16
            r10 = r17
            java.lang.String r0 = "$jobRequests"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r11 = r0
            java.util.List r11 = (java.util.List) r11
            r0 = 6
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newFixedThreadPool(r0)
            kotlin.jvm.internal.Ref$BooleanRef r12 = new kotlin.jvm.internal.Ref$BooleanRef
            r12.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r13 = new kotlin.jvm.internal.Ref$BooleanRef
            r13.<init>()
            r2 = 1
            r13.element = r2
            kotlin.jvm.internal.Ref$BooleanRef r14 = new kotlin.jvm.internal.Ref$BooleanRef
            r14.<init>()
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r15 = r2.iterator()
        L_0x0034:
            boolean r2 = r15.hasNext()
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r15.next()
            r7 = r2
            media.tiger.tigerbox.services.implementations.downloadsManager.DownloadJobImpl r7 = (media.tiger.tigerbox.services.implementations.downloadsManager.DownloadJobImpl) r7
            media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager$$ExternalSyntheticLambda2 r9 = new media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager$$ExternalSyntheticLambda2
            r2 = r9
            r3 = r18
            r4 = r13
            r5 = r17
            r6 = r14
            r8 = r19
            r1 = r9
            r9 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r0.execute(r1)
            r1 = r16
            goto L_0x0034
        L_0x0057:
            r0.shutdown()
        L_0x005a:
            boolean r1 = r0.isTerminated()
            if (r1 != 0) goto L_0x0068
            boolean r1 = r14.element
            if (r1 != 0) goto L_0x0068
            boolean r1 = r12.element
            if (r1 == 0) goto L_0x005a
        L_0x0068:
            android.os.Handler r6 = new android.os.Handler
            android.content.Context r0 = r10.context
            android.os.Looper r0 = r0.getMainLooper()
            r6.<init>(r0)
            media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager$$ExternalSyntheticLambda1 r7 = new media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager$$ExternalSyntheticLambda1
            r0 = r7
            r1 = r16
            r2 = r17
            r3 = r20
            r4 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.post(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager.m2349startJobs$lambda7(java.util.List, media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: startJobs$lambda-7$lambda-4$lambda-3  reason: not valid java name */
    public static final void m2350startJobs$lambda7$lambda4$lambda3(Function0 function0, Ref.BooleanRef booleanRef, DownloadsManager downloadsManager, Ref.BooleanRef booleanRef2, DownloadJobImpl downloadJobImpl, Function1 function1, Ref.BooleanRef booleanRef3) {
        Intrinsics.checkNotNullParameter(booleanRef, "$shouldRun");
        Intrinsics.checkNotNullParameter(downloadsManager, "this$0");
        Intrinsics.checkNotNullParameter(booleanRef2, "$stoppedByInternet");
        Intrinsics.checkNotNullParameter(downloadJobImpl, "$active");
        Intrinsics.checkNotNullParameter(booleanRef3, "$canceled");
        if (function0 != null && booleanRef.element) {
            booleanRef.element = ((Boolean) function0.invoke()).booleanValue();
        }
        if (Intrinsics.areEqual((Object) downloadsManager.wifiService.getOfflineMode().getValue(), (Object) true)) {
            booleanRef2.element = true;
        } else if (booleanRef.element) {
            String sourceUrl = downloadJobImpl.getSourceUrl();
            String destinationPath = downloadJobImpl.getDestinationPath();
            if (function1 != null) {
                function1.invoke(new DownloadsManagerService.FileDownloadInfo(sourceUrl, destinationPath));
            }
            downloadsManager.doRequest(downloadJobImpl);
        } else {
            booleanRef3.element = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startJobs$lambda-7$lambda-6  reason: not valid java name */
    public static final void m2351startJobs$lambda7$lambda6(List list, DownloadsManager downloadsManager, Function3 function3, List list2, Ref.BooleanRef booleanRef) {
        Intrinsics.checkNotNullParameter(list, "$jobRequests");
        Intrinsics.checkNotNullParameter(downloadsManager, "this$0");
        Intrinsics.checkNotNullParameter(list2, "$downloaded");
        Intrinsics.checkNotNullParameter(booleanRef, "$canceled");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DownloadJobImpl downloadJobImpl = (DownloadJobImpl) it.next();
            boolean finishSuccess = downloadJobImpl.getFinishSuccess();
            String sourceUrl = downloadJobImpl.getSourceUrl();
            String destinationPath = downloadJobImpl.getDestinationPath();
            if (finishSuccess) {
                list2.add(new DownloadsManagerService.FileDownloadInfo(sourceUrl, destinationPath));
            }
            Function3<Boolean, String, String, Unit> finishLambda = downloadJobImpl.getFinishLambda();
            if (finishLambda != null) {
                finishLambda.invoke(Boolean.valueOf(finishSuccess), sourceUrl, destinationPath);
            }
            if (downloadJobImpl.getFinishShouldPublish()) {
                if (finishSuccess) {
                    downloadsManager.publishFinish(downloadJobImpl);
                } else {
                    String finishMessage = downloadJobImpl.getFinishMessage();
                    if (finishMessage == null) {
                        finishMessage = "";
                    }
                    downloadsManager.publishFail(finishMessage, downloadJobImpl);
                }
            }
        }
        downloadsManager.removeRequest(list);
        downloadsManager.updateDownloadProgress();
        if (function3 != null) {
            function3.invoke(Boolean.valueOf(list2.size() == list.size()), Boolean.valueOf(booleanRef.element), list2);
        }
    }

    private final void doRequest(DownloadJobImpl downloadJobImpl) {
        downloadJobImpl.setFile(new File(downloadJobImpl.getDestinationPath()));
        if (downloadJobImpl.getFile() != null) {
            File file = downloadJobImpl.getFile();
            Intrinsics.checkNotNull(file);
            if (file.exists()) {
                downloadJobImpl.setFinishSuccess(true);
                return;
            }
        }
        while (downloadJobImpl.getDlTryCount() < 3 && !downloadJobImpl.getFinishSuccess()) {
            downloadJobImpl.setDlTryCount(downloadJobImpl.getDlTryCount() + 1);
            downloadJobImpl.setDlCall(DownloadsWebService.DefaultImpls.downloadFileWithUrl$default(this.webDlService, downloadJobImpl.getSourceUrl(), (String) null, 2, (Object) null));
            try {
                Call<ResponseBody> dlCall = downloadJobImpl.getDlCall();
                Intrinsics.checkNotNull(dlCall);
                Response<ResponseBody> execute = dlCall.execute();
                if (execute.code() == 401) {
                    downloadJobImpl.setDlCall(this.webDlService.downloadPrivateFileWithUrl(downloadJobImpl.getSourceUrl()));
                    Call<ResponseBody> dlCall2 = downloadJobImpl.getDlCall();
                    Intrinsics.checkNotNull(dlCall2);
                    execute = dlCall2.execute();
                }
                Intrinsics.checkNotNullExpressionValue(execute, "response");
                writeResponseBodyToDisk(execute, downloadJobImpl);
            } catch (Exception e) {
                File file2 = downloadJobImpl.getFile();
                if (file2 != null) {
                    file2.delete();
                }
                downloadJobImpl.setFinishSuccess(false);
                downloadJobImpl.setFinishMessage(e.toString());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bf A[SYNTHETIC, Splitter:B:36:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ca A[SYNTHETIC, Splitter:B:42:0x00ca] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void writeResponseBodyToDisk(retrofit2.Response<okhttp3.ResponseBody> r12, media.tiger.tigerbox.services.implementations.downloadsManager.DownloadJobImpl r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r12.body()
            okhttp3.ResponseBody r0 = (okhttp3.ResponseBody) r0
            boolean r1 = r12.isSuccessful()
            r2 = 0
            if (r1 == 0) goto L_0x00de
            if (r0 == 0) goto L_0x00de
            java.io.InputStream r1 = r0.byteStream()
            r3 = 0
            r4 = 2048(0x800, float:2.87E-42)
            r5 = 1
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            long r6 = r0.contentLength()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r13.setFileLength(r6)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.io.File r6 = r13.getFile()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            long r6 = r6.length()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            long r8 = r13.getFileLength()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x007e
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.io.File r7 = r13.getFile()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
        L_0x003c:
            int r3 = r1.read(r4)     // Catch:{ Exception -> 0x007c }
            r7 = -1
            if (r3 == r7) goto L_0x0077
            retrofit2.Call r7 = r13.getDlCall()     // Catch:{ Exception -> 0x007c }
            if (r7 == 0) goto L_0x0057
            retrofit2.Call r7 = r13.getDlCall()     // Catch:{ Exception -> 0x007c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ Exception -> 0x007c }
            boolean r7 = r7.isCanceled()     // Catch:{ Exception -> 0x007c }
            if (r7 == 0) goto L_0x0057
            goto L_0x0077
        L_0x0057:
            r6.write(r4, r2, r3)     // Catch:{ Exception -> 0x007c }
            long r7 = r13.getDlLength()     // Catch:{ Exception -> 0x007c }
            long r9 = (long) r3     // Catch:{ Exception -> 0x007c }
            long r7 = r7 + r9
            r13.setDlLength(r7)     // Catch:{ Exception -> 0x007c }
            long r7 = r13.getDlLength()     // Catch:{ Exception -> 0x007c }
            float r3 = (float) r7     // Catch:{ Exception -> 0x007c }
            long r7 = r13.getFileLength()     // Catch:{ Exception -> 0x007c }
            float r7 = (float) r7     // Catch:{ Exception -> 0x007c }
            float r3 = r3 / r7
            r7 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 * r7
            int r3 = (int) r3     // Catch:{ Exception -> 0x007c }
            r13.setDlProgress(r3)     // Catch:{ Exception -> 0x007c }
            goto L_0x003c
        L_0x0077:
            r6.flush()     // Catch:{ Exception -> 0x007c }
            r3 = r6
            goto L_0x007e
        L_0x007c:
            r3 = move-exception
            goto L_0x0099
        L_0x007e:
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ Exception -> 0x0089 }
        L_0x0083:
            r1.close()     // Catch:{ Exception -> 0x0089 }
        L_0x0086:
            r0.close()     // Catch:{ Exception -> 0x0089 }
        L_0x0089:
            r13.setFinishSuccess(r5)
            java.lang.String r12 = r12.message()
            r13.setFinishMessage(r12)
            goto L_0x00ed
        L_0x0094:
            r2 = move-exception
            goto L_0x00c8
        L_0x0096:
            r4 = move-exception
            r6 = r3
            r3 = r4
        L_0x0099:
            java.io.File r4 = r13.getFile()     // Catch:{ all -> 0x00c6 }
            if (r4 == 0) goto L_0x00a2
            r4.delete()     // Catch:{ all -> 0x00c6 }
        L_0x00a2:
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c6 }
            r7.<init>()     // Catch:{ all -> 0x00c6 }
            java.lang.String r8 = "DownloadsManager: EXCEPTION "
            r7.append(r8)     // Catch:{ all -> 0x00c6 }
            r7.append(r3)     // Catch:{ all -> 0x00c6 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00c6 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00c6 }
            r4.mo50217e(r7, r2)     // Catch:{ all -> 0x00c6 }
            r3.printStackTrace()     // Catch:{ all -> 0x00c6 }
            if (r6 == 0) goto L_0x00c2
            r6.close()     // Catch:{ Exception -> 0x0089 }
        L_0x00c2:
            r1.close()     // Catch:{ Exception -> 0x0089 }
            goto L_0x0086
        L_0x00c6:
            r2 = move-exception
            r3 = r6
        L_0x00c8:
            if (r3 == 0) goto L_0x00cd
            r3.close()     // Catch:{ Exception -> 0x00d3 }
        L_0x00cd:
            r1.close()     // Catch:{ Exception -> 0x00d3 }
            r0.close()     // Catch:{ Exception -> 0x00d3 }
        L_0x00d3:
            r13.setFinishSuccess(r5)
            java.lang.String r12 = r12.message()
            r13.setFinishMessage(r12)
            throw r2
        L_0x00de:
            if (r0 == 0) goto L_0x00e3
            r0.close()
        L_0x00e3:
            r13.setFinishSuccess(r2)
            java.lang.String r12 = r12.message()
            r13.setFinishMessage(r12)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager.writeResponseBodyToDisk(retrofit2.Response, media.tiger.tigerbox.services.implementations.downloadsManager.DownloadJobImpl):void");
    }

    private final void addRequest(List<DownloadJobImpl> list) {
        synchronized (this.activeJobs) {
            this.activeJobs.addAll(list);
        }
    }

    private final void removeRequest(List<DownloadJobImpl> list) {
        for (DownloadJobImpl downloadJobImpl : list) {
            downloadJobImpl.setDlCall((Call<ResponseBody>) null);
            downloadJobImpl.setFile((File) null);
        }
        synchronized (this.activeJobs) {
            this.activeJobs.removeAll(list);
        }
    }

    public List<DownloadJobImpl> jobsInProgress() {
        List<DownloadJobImpl> list;
        synchronized (this.activeJobs) {
            list = CollectionsKt.toList(this.activeJobs);
        }
        return list;
    }

    public void registerListener(DownloadsManagerListener downloadsManagerListener) {
        Intrinsics.checkNotNullParameter(downloadsManagerListener, "listener");
        if (!this.listeners.contains(downloadsManagerListener)) {
            this.listeners.add(downloadsManagerListener);
            downloadsManagerListener.downloadingStateChanged(getDownloadsInProgress());
        }
    }

    public void unregisterListener(DownloadsManagerListener downloadsManagerListener) {
        Intrinsics.checkNotNullParameter(downloadsManagerListener, "listener");
        this.listeners.remove(downloadsManagerListener);
    }

    private final void publishDownloadingStateChanged() {
        Iterator<DownloadsManagerListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().downloadingStateChanged(getDownloadsInProgress());
        }
    }

    private final void publishFinish(DownloadJobImpl downloadJobImpl) {
        Iterator<DownloadsManagerListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().downloadRequestFinished(downloadJobImpl);
        }
    }

    private final void publishFail(String str, DownloadJobImpl downloadJobImpl) {
        Iterator<DownloadsManagerListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().downloadRequestFailed(str, downloadJobImpl);
        }
    }

    /* access modifiers changed from: private */
    public final Object publishProgress(CoroutineScope coroutineScope, DownloadJobImpl downloadJobImpl, Continuation<? super Unit> continuation) {
        Job launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DownloadsManager$publishProgress$2(this, downloadJobImpl, (Continuation<? super DownloadsManager$publishProgress$2>) null), 3, (Object) null);
        if (launch$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return launch$default;
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/downloadsManager/DownloadsManager$Companion;", "", "()V", "DL_TRY_COUNT", "", "DOWNLOADS_FOLDER", "", "DOWNLOAD_CHUNK_SIZE", "EXTENSION_SEPARATOR", "FOLDERS_SEPARATOR", "JOBS_THREAD_COUNT", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DownloadsManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
