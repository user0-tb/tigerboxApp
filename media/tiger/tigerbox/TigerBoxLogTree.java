package media.tiger.tigerbox;

import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;
import p012io.shipbook.shipbooksdk.Log;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000267B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fH\u0002J,\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00172\u0006\u0010'\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0016\u0010*\u001a\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001f0,H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\u0016\u0010.\u001a\u00020/2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001f0,H\u0002J\u0014\u00100\u001a\u00020\"2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\"02J\u0018\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0017H\u0003R\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000fR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u00068"}, mo33737d2 = {"Lmedia/tiger/tigerbox/TigerBoxLogTree;", "Ltimber/log/Timber$DebugTree;", "Lmedia/tiger/tigerbox/LogsUploaderProtocol;", "postLogsUseCase", "Lmedia/tiger/tigerbox/usecase/PostCrashLogsUseCase;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Lmedia/tiger/tigerbox/usecase/PostCrashLogsUseCase;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "allowLogging", "", "getAllowLogging", "()Z", "allowOnlineLogs", "getAllowOnlineLogs", "allowShipBookLogs", "getAllowShipBookLogs", "autoLogs", "getAutoLogs", "cpuId", "", "firmwareVersion", "hasLogs", "getHasLogs", "logReportsDir", "Ljava/io/File;", "logs", "", "Lmedia/tiger/tigerbox/TigerBoxLogTree$LogInfo;", "serialNumber", "catchLog", "", "log", "priority", "", "tag", "message", "t", "", "logsToString", "logsList", "", "removeOldLogFiles", "saveLogsToFile", "Lkotlinx/coroutines/Job;", "uploadLogs", "finishLambda", "Lkotlin/Function0;", "writeToFile", "filename", "currentStacktrace", "Companion", "LogInfo", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxLogTree.kt */
public final class TigerBoxLogTree extends Timber.DebugTree implements LogsUploaderProtocol {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ENABLE_SEND_AT_MIN_LOG_FILES = 3;
    private static final int LOGS_CATCHER_PRIORITY = 2;
    private static final String LOGS_REPORTS_FOLDER = "Logs_Reports";
    private static final int LOGS_SAVE_PRIORITY = 6;
    private static final int MAX_LOGS_PER_FILE = 500;
    private static final int MAX_LOG_FILES = 10;
    private final ConfigurationProperties configurationProperties;
    private String cpuId;
    /* access modifiers changed from: private */
    public final String firmwareVersion;
    private final File logReportsDir = new File(Environment.getExternalStorageDirectory(), LOGS_REPORTS_FOLDER);
    private List<LogInfo> logs = new ArrayList();
    private final PostCrashLogsUseCase postLogsUseCase;
    /* access modifiers changed from: private */
    public final String serialNumber;
    private final StorageService storageService;

    public void uploadThenDeleteFiles(List<? extends File> list, PostCrashLogsUseCase postCrashLogsUseCase, String str, String str2, Function0<Unit> function0) {
        LogsUploaderProtocol.DefaultImpls.uploadThenDeleteFiles(this, list, postCrashLogsUseCase, str, str2, function0);
    }

    public TigerBoxLogTree(PostCrashLogsUseCase postCrashLogsUseCase, MetaDataService metaDataService, StorageService storageService2, ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(postCrashLogsUseCase, "postLogsUseCase");
        Intrinsics.checkNotNullParameter(metaDataService, "metaDataService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        this.postLogsUseCase = postCrashLogsUseCase;
        this.storageService = storageService2;
        this.configurationProperties = configurationProperties2;
        this.firmwareVersion = metaDataService.getFirmwareVersion();
        this.cpuId = metaDataService.getCpuId();
        this.serialNumber = metaDataService.getSerialNumber();
        if (getAllowLogging() || getAutoLogs()) {
            Timber.Forest.plant((Timber.Tree) this);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C28251(this, (Continuation<? super C28251>) null), 3, (Object) null);
    }

    public final boolean getHasLogs() {
        File[] listFiles = this.logReportsDir.listFiles();
        if (listFiles == null || listFiles.length < 3) {
            return false;
        }
        return true;
    }

    @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/TigerBoxLogTree$LogInfo;", "", "priority", "", "tag", "", "message", "t", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getPriority", "()I", "getT", "()Ljava/lang/Throwable;", "getTag", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerBoxLogTree.kt */
    public static final class LogInfo {
        private final String message;
        private final int priority;

        /* renamed from: t */
        private final Throwable f617t;
        private final String tag;

        public static /* synthetic */ LogInfo copy$default(LogInfo logInfo, int i, String str, String str2, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = logInfo.priority;
            }
            if ((i2 & 2) != 0) {
                str = logInfo.tag;
            }
            if ((i2 & 4) != 0) {
                str2 = logInfo.message;
            }
            if ((i2 & 8) != 0) {
                th = logInfo.f617t;
            }
            return logInfo.copy(i, str, str2, th);
        }

        public final int component1() {
            return this.priority;
        }

        public final String component2() {
            return this.tag;
        }

        public final String component3() {
            return this.message;
        }

        public final Throwable component4() {
            return this.f617t;
        }

        public final LogInfo copy(int i, String str, String str2, Throwable th) {
            return new LogInfo(i, str, str2, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LogInfo)) {
                return false;
            }
            LogInfo logInfo = (LogInfo) obj;
            return this.priority == logInfo.priority && Intrinsics.areEqual((Object) this.tag, (Object) logInfo.tag) && Intrinsics.areEqual((Object) this.message, (Object) logInfo.message) && Intrinsics.areEqual((Object) this.f617t, (Object) logInfo.f617t);
        }

        public int hashCode() {
            int i = this.priority * 31;
            String str = this.tag;
            int i2 = 0;
            int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.message;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Throwable th = this.f617t;
            if (th != null) {
                i2 = th.hashCode();
            }
            return hashCode2 + i2;
        }

        public String toString() {
            return "LogInfo(priority=" + this.priority + ", tag=" + this.tag + ", message=" + this.message + ", t=" + this.f617t + ')';
        }

        public LogInfo(int i, String str, String str2, Throwable th) {
            this.priority = i;
            this.tag = str;
            this.message = str2;
            this.f617t = th;
        }

        public final String getMessage() {
            return this.message;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final Throwable getT() {
            return this.f617t;
        }

        public final String getTag() {
            return this.tag;
        }
    }

    private final boolean getAllowShipBookLogs() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty("log.allowShipBookLogs"));
    }

    private final boolean getAllowOnlineLogs() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty("log.allowOnline"));
    }

    private final boolean getAllowLogging() {
        return Boolean.parseBoolean(this.configurationProperties.getProperty("log.enabled"));
    }

    /* access modifiers changed from: private */
    public final boolean getAutoLogs() {
        return this.storageService.getFlagAutoLogsEnabled();
    }

    /* access modifiers changed from: protected */
    public void log(int i, String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str2, "message");
        super.log(i, str, str2, th);
        if (getAllowShipBookLogs()) {
            Log.Companion.mo33285d(this.serialNumber, str2, th);
        }
        if (getAllowOnlineLogs() || getAutoLogs()) {
            catchLog(new LogInfo(i, str, str2, th));
        }
    }

    private final void catchLog(LogInfo logInfo) {
        if (logInfo.getPriority() >= 2) {
            synchronized (this.logs) {
                try {
                    this.logs.add(LogInfo.copy$default(logInfo, 0, (String) null, (String) null, (Throwable) null, 15, (Object) null));
                    if (logInfo.getPriority() >= 6 && this.logs.size() >= 500) {
                        saveLogsToFile(CollectionsKt.toList(this.logs));
                        this.logs.clear();
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    Integer.valueOf(android.util.Log.e("TigerBoxLogTree", "catchLog exception: " + e));
                }
            }
            return;
        }
        return;
    }

    /* access modifiers changed from: private */
    public final String logsToString(List<LogInfo> list) {
        String str = "";
        for (LogInfo next : list) {
            try {
                String str2 = str + next.getPriority() + ':';
                if (next.getTag() != null) {
                    str2 = str2 + next.getTag() + ':';
                }
                if (next.getMessage() != null) {
                    str2 = str2 + ' ' + next.getMessage();
                }
                if (next.getT() != null) {
                    str2 = str2 + ' ' + next.getT();
                }
                str = str2 + 10;
            } catch (Exception e) {
                android.util.Log.e("TigerBoxLogTree", "logsToString exception: " + e);
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeToFile(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.io.File r0 = r5.logReportsDir     // Catch:{ Exception -> 0x006a }
            boolean r1 = r0.exists()     // Catch:{ Exception -> 0x006a }
            if (r1 != 0) goto L_0x000b
            r0.mkdirs()     // Catch:{ Exception -> 0x006a }
        L_0x000b:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x006a }
            r1.<init>(r0, r6)     // Catch:{ Exception -> 0x006a }
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ Exception -> 0x006a }
            r6.<init>(r1)     // Catch:{ Exception -> 0x006a }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ Exception -> 0x006a }
            r0 = 0
            r1 = r6
            java.io.FileWriter r1 = (java.io.FileWriter) r1     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r2.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = "Firmware: "
            r2.append(r3)     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = r5.firmwareVersion     // Catch:{ all -> 0x0063 }
            r2.append(r3)     // Catch:{ all -> 0x0063 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0063 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0063 }
            r1.append(r2)     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r2.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r4 = "Serial: "
            r2.append(r4)     // Catch:{ all -> 0x0063 }
            java.lang.String r4 = r5.serialNumber     // Catch:{ all -> 0x0063 }
            r2.append(r4)     // Catch:{ all -> 0x0063 }
            r2.append(r3)     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0063 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0063 }
            r1.append(r2)     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = "LogTree:\n\n"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0063 }
            r1.append(r2)     // Catch:{ all -> 0x0063 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0063 }
            r1.append(r7)     // Catch:{ all -> 0x0063 }
            kotlin.p013io.CloseableKt.closeFinally(r6, r0)     // Catch:{ Exception -> 0x006a }
            goto L_0x0081
        L_0x0063:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r0 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r6, r7)     // Catch:{ Exception -> 0x006a }
            throw r0     // Catch:{ Exception -> 0x006a }
        L_0x006a:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "ExceptionHandler: "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "TigerBoxLogTree"
            android.util.Log.e(r7, r6)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.TigerBoxLogTree.writeToFile(java.lang.String, java.lang.String):void");
    }

    private final Job saveLogsToFile(List<LogInfo> list) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new TigerBoxLogTree$saveLogsToFile$1(list, this, (Continuation<? super TigerBoxLogTree$saveLogsToFile$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void removeOldLogFiles() {
        File[] listFiles = this.logReportsDir.listFiles();
        if (listFiles != null && listFiles.length >= 10) {
            ArraysKt.sortWith(listFiles, new C2827xe2b291b());
            int length = listFiles.length;
            for (int i = 9; i < length; i++) {
                listFiles[i].delete();
            }
        }
    }

    public final void uploadLogs(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "finishLambda");
        boolean z = false;
        Timber.Forest.mo50221i("uploading logs", new Object[0]);
        File[] listFiles = this.logReportsDir.listFiles();
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
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.TigerBoxLogTree$1", mo34424f = "TigerBoxLogTree.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.TigerBoxLogTree$1 */
    /* compiled from: TigerBoxLogTree.kt */
    static final class C28251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TigerBoxLogTree this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28251(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.this$0.getAutoLogs()) {
                    this.this$0.uploadLogs(C28261.INSTANCE);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/TigerBoxLogTree$Companion;", "", "()V", "ENABLE_SEND_AT_MIN_LOG_FILES", "", "LOGS_CATCHER_PRIORITY", "LOGS_REPORTS_FOLDER", "", "LOGS_SAVE_PRIORITY", "MAX_LOGS_PER_FILE", "MAX_LOG_FILES", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerBoxLogTree.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
