package media.tiger.tigerbox;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.LogsUploaderProtocol;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;
import p012io.shipbook.shipbooksdk.Log;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0014\u0010\u001e\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190 J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u000fH\u0003R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo33737d2 = {"Lmedia/tiger/tigerbox/WriteToFileExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Lmedia/tiger/tigerbox/LogsUploaderProtocol;", "postLogsUseCase", "Lmedia/tiger/tigerbox/usecase/PostCrashLogsUseCase;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "(Lmedia/tiger/tigerbox/usecase/PostCrashLogsUseCase;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;)V", "autoLogs", "", "getAutoLogs", "()Z", "cpuId", "", "defaultExceptionHandler", "firmwareVersion", "hasExceptions", "getHasExceptions", "serialNumber", "stackReportsDir", "Ljava/io/File;", "logcatToString", "uncaughtException", "", "thread", "Ljava/lang/Thread;", "throwable", "", "uploadStackTraces", "finishLambda", "Lkotlin/Function0;", "writeToFile", "currentStacktrace", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WriteToFileExceptionHandler.kt */
public final class WriteToFileExceptionHandler implements Thread.UncaughtExceptionHandler, LogsUploaderProtocol {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int LOGCAT_LINES_COUNT = 2000;
    private static final String STACKTRACE_REPORTS_FOLDER = "Crash_Reports";
    private String cpuId;
    private final Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private final String firmwareVersion;
    private final PostCrashLogsUseCase postLogsUseCase;
    private final String serialNumber;
    private final File stackReportsDir = new File(Environment.getExternalStorageDirectory(), STACKTRACE_REPORTS_FOLDER);
    private final StorageService storageService;

    public WriteToFileExceptionHandler(PostCrashLogsUseCase postCrashLogsUseCase, StorageService storageService2, MetaDataService metaDataService) {
        Intrinsics.checkNotNullParameter(postCrashLogsUseCase, "postLogsUseCase");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService, "metaDataService");
        this.postLogsUseCase = postCrashLogsUseCase;
        this.storageService = storageService2;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Objects.requireNonNull(defaultUncaughtExceptionHandler, "null cannot be cast to non-null type java.lang.Thread.UncaughtExceptionHandler");
        this.defaultExceptionHandler = defaultUncaughtExceptionHandler;
        this.firmwareVersion = metaDataService.getFirmwareVersion();
        this.cpuId = metaDataService.getCpuId();
        this.serialNumber = metaDataService.getSerialNumber();
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C28281(this, (Continuation<? super C28281>) null), 3, (Object) null);
    }

    public void uploadThenDeleteFiles(List<? extends File> list, PostCrashLogsUseCase postCrashLogsUseCase, String str, String str2, Function0<Unit> function0) {
        LogsUploaderProtocol.DefaultImpls.uploadThenDeleteFiles(this, list, postCrashLogsUseCase, str, str2, function0);
    }

    public final boolean getHasExceptions() {
        boolean z = false;
        try {
            File[] listFiles = this.stackReportsDir.listFiles();
            if (listFiles == null) {
                return false;
            }
            if (listFiles.length == 0) {
                z = true;
            }
            return !z;
        } catch (IOException e) {
            Log.Companion companion = Log.Companion;
            Log.Companion.e$default(companion, "WriteToFileException", "hasExceptions: " + e, (Throwable) null, 4, (Object) null);
            return false;
        }
    }

    public final boolean getAutoLogs() {
        return this.storageService.getFlagAutoLogsEnabled();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(th, "throwable");
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String writer = stringWriter.toString();
        printWriter.close();
        writeToFile(writer);
        this.defaultExceptionHandler.uncaughtException(thread, th);
    }

    private final String logcatToString() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -t 2000").getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine + 10);
                } else {
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "log.toString()");
                    return sb2;
                }
            }
        } catch (IOException e) {
            Log.Companion companion = Log.Companion;
            Log.Companion.e$default(companion, "WriteToFileException", "logcatToString exception: " + e, (Throwable) null, 4, (Object) null);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00b3, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b7, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void writeToFile(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "__"
            java.io.File r1 = r6.stackReportsDir     // Catch:{ Exception -> 0x00b8 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00b8 }
            if (r2 != 0) goto L_0x000d
            r1.mkdirs()     // Catch:{ Exception -> 0x00b8 }
        L_0x000d:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r3 = "yyyy_MM_dd_HH_mm_ss"
            r2.<init>(r3)     // Catch:{ Exception -> 0x00b8 }
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x00b8 }
            r3.<init>()     // Catch:{ Exception -> 0x00b8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8 }
            r4.<init>()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r5 = r6.firmwareVersion     // Catch:{ Exception -> 0x00b8 }
            r4.append(r5)     // Catch:{ Exception -> 0x00b8 }
            r4.append(r0)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r5 = r6.serialNumber     // Catch:{ Exception -> 0x00b8 }
            r4.append(r5)     // Catch:{ Exception -> 0x00b8 }
            r4.append(r0)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r0 = r2.format(r3)     // Catch:{ Exception -> 0x00b8 }
            r4.append(r0)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r0 = ".STACKTRACE"
            r4.append(r0)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r2 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r2)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r2 = "encode(filename, \"UTF-8\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x00b8 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00b8 }
            r2.<init>(r1, r0)     // Catch:{ Exception -> 0x00b8 }
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch:{ Exception -> 0x00b8 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00b8 }
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ Exception -> 0x00b8 }
            r1 = 0
            r2 = r0
            java.io.FileWriter r2 = (java.io.FileWriter) r2     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r3.<init>()     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = "Firmware: "
            r3.append(r4)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = r6.firmwareVersion     // Catch:{ all -> 0x00b1 }
            r3.append(r4)     // Catch:{ all -> 0x00b1 }
            r4 = 10
            r3.append(r4)     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b1 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b1 }
            r2.append(r3)     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r3.<init>()     // Catch:{ all -> 0x00b1 }
            java.lang.String r5 = "Serial: "
            r3.append(r5)     // Catch:{ all -> 0x00b1 }
            java.lang.String r5 = r6.serialNumber     // Catch:{ all -> 0x00b1 }
            r3.append(r5)     // Catch:{ all -> 0x00b1 }
            r3.append(r4)     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b1 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b1 }
            r2.append(r3)     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "Logcat:\n\n"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b1 }
            r2.append(r3)     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = r6.logcatToString()     // Catch:{ all -> 0x00b1 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b1 }
            r2.append(r3)     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "StackTrace:\n\n"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b1 }
            r2.append(r3)     // Catch:{ all -> 0x00b1 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x00b1 }
            r2.append(r7)     // Catch:{ all -> 0x00b1 }
            kotlin.p013io.CloseableKt.closeFinally(r0, r1)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00d4
        L_0x00b1:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x00b3 }
        L_0x00b3:
            r1 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r0, r7)     // Catch:{ Exception -> 0x00b8 }
            throw r1     // Catch:{ Exception -> 0x00b8 }
        L_0x00b8:
            r7 = move-exception
            io.shipbook.shipbooksdk.Log$Companion r0 = p012io.shipbook.shipbooksdk.Log.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ExceptionHandler: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = r1.toString()
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "WriteToFileException"
            p012io.shipbook.shipbooksdk.Log.Companion.e$default(r0, r1, r2, r3, r4, r5)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.WriteToFileExceptionHandler.writeToFile(java.lang.String):void");
    }

    public final void uploadStackTraces(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "finishLambda");
        boolean z = false;
        Timber.Forest.mo50221i("uploading stackTraces", new Object[0]);
        File[] listFiles = this.stackReportsDir.listFiles();
        if (listFiles != null) {
            if (listFiles.length == 0) {
                z = true;
            }
            if (!z) {
                uploadThenDeleteFiles(ArraysKt.asList((T[]) listFiles), this.postLogsUseCase, this.cpuId, this.serialNumber, function0);
                return;
            }
        }
        function0.invoke();
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.WriteToFileExceptionHandler$1", mo34424f = "WriteToFileExceptionHandler.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.WriteToFileExceptionHandler$1 */
    /* compiled from: WriteToFileExceptionHandler.kt */
    static final class C28281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WriteToFileExceptionHandler this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28281(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.this$0.getAutoLogs()) {
                    this.this$0.uploadStackTraces(C28291.INSTANCE);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/WriteToFileExceptionHandler$Companion;", "", "()V", "LOGCAT_LINES_COUNT", "", "STACKTRACE_REPORTS_FOLDER", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: WriteToFileExceptionHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
