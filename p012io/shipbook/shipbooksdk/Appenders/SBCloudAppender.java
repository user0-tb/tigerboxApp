package p012io.shipbook.shipbooksdk.Appenders;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p013io.FilesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import p012io.shipbook.shipbooksdk.BroadcastNames;
import p012io.shipbook.shipbooksdk.InnerLog;
import p012io.shipbook.shipbooksdk.Models.BaseEvent;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.Models.BaseObj;
import p012io.shipbook.shipbooksdk.Models.Exception;
import p012io.shipbook.shipbooksdk.Models.Login;
import p012io.shipbook.shipbooksdk.Models.Message;
import p012io.shipbook.shipbooksdk.Models.SessionLogData;
import p012io.shipbook.shipbooksdk.Models.Severity;
import p012io.shipbook.shipbooksdk.Models.User;
import p012io.shipbook.shipbooksdk.Networking.SessionManager;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020+H\u0004J\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u00101\u001a\u00020+2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00101\u001a\u00020+2\u0006\u00104\u001a\u00020\u0017H\u0016J\u0010\u00101\u001a\u00020+2\u0006\u00105\u001a\u000206H\u0002J\u0010\u00101\u001a\u00020+2\u0006\u00104\u001a\u000207H\u0002J\b\u00108\u001a\u00020+H\u0002J\u000e\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020;J\u0011\u0010<\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0002\u0010=J$\u0010>\u001a\u00020+2\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007H\u0016R\u000e\u0010\t\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Appenders/SBCloudAppender;", "Lio/shipbook/shipbooksdk/Appenders/BaseAppender;", "name", "", "config", "", "", "Lio/shipbook/shipbooksdk/Appenders/Config;", "(Ljava/lang/String;Ljava/util/Map;)V", "FILE_CLASS_SEPARATOR", "NEW_LINE_SEPARATOR", "TAG", "TOKEN", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "getBroadcastReceiver", "()Landroid/content/BroadcastReceiver;", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "flushQueue", "Ljava/util/Queue;", "Lio/shipbook/shipbooksdk/Models/BaseLog;", "flushSeverity", "Lio/shipbook/shipbooksdk/Models/Severity;", "flushSize", "", "hasLog", "", "getHasLog", "()Z", "setHasLog", "(Z)V", "maxFileSize", "maxTime", "", "tempFile", "getTempFile", "timer", "Ljava/util/Timer;", "uploadingSavedData", "concatTmpFile", "", "createTimer", "finalize", "loadFromFile", "", "Lio/shipbook/shipbooksdk/Models/SessionLogData;", "push", "event", "Lio/shipbook/shipbooksdk/Models/BaseEvent;", "log", "exception", "Lio/shipbook/shipbooksdk/Models/Exception;", "Lio/shipbook/shipbooksdk/Models/Message;", "saveFlushQueue", "saveToFile", "obj", "Lio/shipbook/shipbooksdk/Models/BaseObj;", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Appenders.SBCloudAppender */
/* compiled from: SBCloudAppender.kt */
public final class SBCloudAppender extends BaseAppender {
    private final String FILE_CLASS_SEPARATOR = ": ";
    private final String NEW_LINE_SEPARATOR = "\n";
    /* access modifiers changed from: private */
    public final String TAG = "SBCloudAppender";
    private final String TOKEN = "token";
    private final BroadcastReceiver broadcastReceiver;
    private final File file;
    private Queue<BaseLog> flushQueue;
    private volatile Severity flushSeverity = Severity.Verbose;
    private volatile int flushSize = 40;
    private boolean hasLog;
    private volatile int maxFileSize = 1048576;
    private volatile double maxTime = 3.0d;
    private final File tempFile;
    /* access modifiers changed from: private */
    public volatile Timer timer;
    private volatile boolean uploadingSavedData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SBCloudAppender(String str, Map<String, ? extends Object> map) {
        super(str, map);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullExpressionValue("SBCloudAppender", "SBCloudAppender::class.java.simpleName");
        BroadcastReceiver sBCloudAppender$broadcastReceiver$1 = new SBCloudAppender$broadcastReceiver$1(this);
        this.broadcastReceiver = sBCloudAppender$broadcastReceiver$1;
        this.flushQueue = new LinkedBlockingQueue();
        Context appContext = SessionManager.INSTANCE.getAppContext();
        File file2 = null;
        this.file = new File(appContext == null ? null : appContext.getFilesDir(), "CloudQueue.log");
        this.tempFile = new File(appContext != null ? appContext.getFilesDir() : file2, "TempCloudQueue.log");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BroadcastNames.INSTANCE.getUSER_CHANGE());
        intentFilter.addAction(BroadcastNames.INSTANCE.getCONNECTED());
        Intrinsics.checkNotNull(appContext);
        LocalBroadcastManager.getInstance(appContext).registerReceiver(sBCloudAppender$broadcastReceiver$1, intentFilter);
    }

    public final BroadcastReceiver getBroadcastReceiver() {
        return this.broadcastReceiver;
    }

    public final File getFile() {
        return this.file;
    }

    public final File getTempFile() {
        return this.tempFile;
    }

    public final boolean getHasLog() {
        return this.hasLog;
    }

    public final void setHasLog(boolean z) {
        this.hasLog = z;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        InnerLog.d$default(InnerLog.INSTANCE, this.TAG, "unregister broadcast receiver", (Throwable) null, 4, (Object) null);
        if (SessionManager.INSTANCE.getAppContext() != null) {
            Context appContext = SessionManager.INSTANCE.getAppContext();
            Intrinsics.checkNotNull(appContext);
            LocalBroadcastManager.getInstance(appContext).unregisterReceiver(this.broadcastReceiver);
        }
    }

    public void update(Map<String, ? extends Object> map) {
        if (map != null) {
            Object obj = map.get("maxTime");
            if (obj != null && (obj instanceof Number)) {
                this.maxTime = ((Number) obj).doubleValue();
            }
            Object obj2 = map.get("maxFileSize");
            if (obj2 != null && (obj2 instanceof Number)) {
                this.maxFileSize = ((Number) obj2).intValue();
            }
            Object obj3 = map.get("flushSeverity");
            if (obj3 != null && (obj3 instanceof String)) {
                this.flushSeverity = Severity.valueOf((String) obj3);
            }
            Object obj4 = map.get("flushSize");
            if (obj4 != null && (obj4 instanceof Number)) {
                this.flushSize = ((Number) obj4).intValue();
            }
        }
    }

    public final void saveToFile(BaseObj baseObj) {
        Intrinsics.checkNotNullParameter(baseObj, "obj");
        try {
            if (this.file.length() > ((long) this.maxFileSize)) {
                this.file.delete();
                this.hasLog = false;
            }
            if (!this.hasLog) {
                if (SessionManager.INSTANCE.getToken() != null) {
                    FilesKt.appendText$default(this.file, this.TOKEN + this.FILE_CLASS_SEPARATOR + SessionManager.INSTANCE.getToken() + this.NEW_LINE_SEPARATOR, (Charset) null, 2, (Object) null);
                } else {
                    Login login = SessionManager.INSTANCE.getLogin();
                    if (login != null) {
                        String stringPlus = Intrinsics.stringPlus(login.getClass().getName(), this.FILE_CLASS_SEPARATOR);
                        String jSONObject = login.toJson().toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "login.toJson().toString()");
                        FilesKt.appendText$default(getFile(), stringPlus + jSONObject + this.NEW_LINE_SEPARATOR, (Charset) null, 2, (Object) null);
                    }
                }
            }
            String str = "";
            if (baseObj instanceof BaseLog) {
                str = Intrinsics.stringPlus(BaseLog.class.getName(), this.FILE_CLASS_SEPARATOR);
            } else if (baseObj instanceof User) {
                str = Intrinsics.stringPlus(User.class.getName(), this.FILE_CLASS_SEPARATOR);
            }
            JSONObject json = baseObj.toJson();
            FilesKt.appendText$default(this.file, str + json + this.NEW_LINE_SEPARATOR, (Charset) null, 2, (Object) null);
            this.hasLog = true;
        } catch (Exception e) {
            InnerLog.INSTANCE.mo33259e(this.TAG, "save file got error", e);
        }
    }

    public final List<SessionLogData> loadFromFile(File file2) {
        File file3 = file2;
        Intrinsics.checkNotNullParameter(file3, "file");
        List<SessionLogData> arrayList = new ArrayList<>();
        String name = Login.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "Login::class.java.name");
        String name2 = BaseLog.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "BaseLog::class.java.name");
        String name3 = User.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "User::class.java.name");
        SessionLogData sessionLogData = null;
        try {
            for (String split$default : FilesKt.readLines$default(file3, (Charset) null, 1, (Object) null)) {
                List split$default2 = StringsKt.split$default((CharSequence) split$default, new String[]{this.FILE_CLASS_SEPARATOR}, false, 2, 2, (Object) null);
                String str = (String) split$default2.get(0);
                String str2 = (String) split$default2.get(1);
                if (Intrinsics.areEqual((Object) str, (Object) name)) {
                    Login create = Login.Companion.create(new JSONObject(str2));
                    if (sessionLogData != null) {
                        arrayList.add(sessionLogData);
                    }
                    sessionLogData = new SessionLogData((String) null, create, (User) null, (List) null, 13, (DefaultConstructorMarker) null);
                } else if (Intrinsics.areEqual((Object) str, (Object) this.TOKEN)) {
                    if (sessionLogData != null) {
                        arrayList.add(sessionLogData);
                    }
                    sessionLogData = new SessionLogData(str2, (Login) null, (User) null, (List) null, 14, (DefaultConstructorMarker) null);
                } else if (Intrinsics.areEqual((Object) str, (Object) name2)) {
                    BaseLog create2 = BaseLog.Companion.create(new JSONObject(str2));
                    if (sessionLogData != null) {
                        List<BaseLog> logs = sessionLogData.getLogs();
                        if (logs != null) {
                            logs.add(create2);
                        }
                    }
                } else if (Intrinsics.areEqual((Object) str, (Object) name3)) {
                    User create3 = User.Companion.create(new JSONObject(str2));
                    if (sessionLogData != null) {
                        sessionLogData.setUser(create3);
                    }
                } else {
                    InnerLog.e$default(InnerLog.INSTANCE, this.TAG, "no classname exists", (Throwable) null, 4, (Object) null);
                }
            }
            if (sessionLogData != null) {
                arrayList.add(sessionLogData);
            }
        } catch (Exception e) {
            InnerLog.INSTANCE.mo33259e(this.TAG, "load from file failed", e);
        }
        return arrayList;
    }

    private final void saveFlushQueue() {
        for (BaseLog baseLog : this.flushQueue) {
            Intrinsics.checkNotNullExpressionValue(baseLog, "it");
            saveToFile(baseLog);
        }
        this.flushQueue = new LinkedBlockingQueue();
    }

    /* access modifiers changed from: private */
    public final void createTimer() {
        if (this.timer == null) {
            InnerLog.d$default(InnerLog.INSTANCE, this.TAG, Intrinsics.stringPlus("the current time ", Double.valueOf(this.maxTime)), (Throwable) null, 4, (Object) null);
            this.timer = new Timer(true);
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.schedule(new SBCloudAppender$createTimer$$inlined$timerTask$1(this), (long) (this.maxTime * ((double) 1000)));
            }
        }
    }

    public void push(BaseLog baseLog) {
        Intrinsics.checkNotNullParameter(baseLog, "log");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, SessionManager.INSTANCE.getThreadContext(), (CoroutineStart) null, new SBCloudAppender$push$1(baseLog, this, (Continuation<? super SBCloudAppender$push$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void push(Message message) {
        if (this.flushSeverity.ordinal() < message.getSeverity().ordinal()) {
            this.flushQueue.add(message);
            if (this.flushQueue.size() > this.flushSize) {
                this.flushQueue.remove();
                return;
            }
            return;
        }
        saveFlushQueue();
        saveToFile(message);
        createTimer();
    }

    /* access modifiers changed from: private */
    public final void push(BaseEvent baseEvent) {
        this.flushQueue.add(baseEvent);
        if (this.flushQueue.size() > this.flushSize) {
            this.flushQueue.remove();
        }
    }

    /* access modifiers changed from: private */
    public final void push(Exception exception) {
        saveFlushQueue();
        saveToFile(exception);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0131 A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0139 A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object send(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof p012io.shipbook.shipbooksdk.Appenders.SBCloudAppender$send$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            io.shipbook.shipbooksdk.Appenders.SBCloudAppender$send$1 r0 = (p012io.shipbook.shipbooksdk.Appenders.SBCloudAppender$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            io.shipbook.shipbooksdk.Appenders.SBCloudAppender$send$1 r0 = new io.shipbook.shipbooksdk.Appenders.SBCloudAppender$send$1
            r0.<init>(r13, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "Had an error in send"
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r0 = r0.L$0
            io.shipbook.shipbooksdk.Appenders.SBCloudAppender r0 = (p012io.shipbook.shipbooksdk.Appenders.SBCloudAppender) r0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0129
        L_0x0032:
            r14 = move-exception
            goto L_0x016d
        L_0x0035:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.Timer r14 = r13.timer
            r2 = 0
            if (r14 != 0) goto L_0x0046
            goto L_0x004b
        L_0x0046:
            r14.cancel()
            r13.timer = r2
        L_0x004b:
            boolean r14 = r13.uploadingSavedData
            if (r14 == 0) goto L_0x005e
            io.shipbook.shipbooksdk.InnerLog r6 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE
            java.lang.String r7 = r13.TAG
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r8 = "uploading saved data"
            p012io.shipbook.shipbooksdk.InnerLog.d$default(r6, r7, r8, r9, r10, r11)
            r13.createTimer()
        L_0x005e:
            io.shipbook.shipbooksdk.Networking.SessionManager r14 = p012io.shipbook.shipbooksdk.Networking.SessionManager.INSTANCE
            boolean r14 = r14.getConnected()
            if (r14 != 0) goto L_0x0075
            io.shipbook.shipbooksdk.InnerLog r6 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE
            java.lang.String r7 = r13.TAG
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r8 = "not connected"
            p012io.shipbook.shipbooksdk.InnerLog.d$default(r6, r7, r8, r9, r10, r11)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0075:
            java.io.File r14 = r13.getFile()
            boolean r14 = r14.isFile()
            if (r14 != 0) goto L_0x008e
            io.shipbook.shipbooksdk.InnerLog r6 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE
            java.lang.String r7 = r13.TAG
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r8 = "no file"
            p012io.shipbook.shipbooksdk.InnerLog.d$default(r6, r7, r8, r9, r10, r11)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x008e:
            r13.uploadingSavedData = r4
            java.io.File r14 = r13.getTempFile()     // Catch:{ Exception -> 0x017d }
            r14.delete()     // Catch:{ Exception -> 0x017d }
            java.io.File r14 = r13.getFile()     // Catch:{ Exception -> 0x017d }
            java.io.File r6 = r13.getTempFile()     // Catch:{ Exception -> 0x017d }
            r14.renameTo(r6)     // Catch:{ Exception -> 0x017d }
            r13.setHasLog(r5)     // Catch:{ Exception -> 0x017d }
            java.io.File r14 = r13.getTempFile()     // Catch:{ Exception -> 0x017d }
            java.util.List r14 = r13.loadFromFile(r14)     // Catch:{ Exception -> 0x017d }
            r6 = r14
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x017d }
            int r6 = r6.size()     // Catch:{ Exception -> 0x017d }
            if (r6 > 0) goto L_0x00c7
            io.shipbook.shipbooksdk.InnerLog r7 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ Exception -> 0x017d }
            java.lang.String r8 = r13.TAG     // Catch:{ Exception -> 0x017d }
            java.lang.String r9 = "empty session data eventhough loaded from file"
            r10 = 0
            r11 = 4
            r12 = 0
            p012io.shipbook.shipbooksdk.InnerLog.w$default(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x017d }
            r13.uploadingSavedData = r5     // Catch:{ Exception -> 0x017d }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x017d }
            return r14
        L_0x00c7:
            java.util.Iterator r6 = r14.iterator()     // Catch:{ Exception -> 0x017d }
        L_0x00cb:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x017d }
            if (r7 == 0) goto L_0x00f4
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x017d }
            io.shipbook.shipbooksdk.Models.SessionLogData r7 = (p012io.shipbook.shipbooksdk.Models.SessionLogData) r7     // Catch:{ Exception -> 0x017d }
            io.shipbook.shipbooksdk.Models.Login r8 = r7.getLogin()     // Catch:{ Exception -> 0x017d }
            io.shipbook.shipbooksdk.Networking.SessionManager r9 = p012io.shipbook.shipbooksdk.Networking.SessionManager.INSTANCE     // Catch:{ Exception -> 0x017d }
            io.shipbook.shipbooksdk.Models.Login r9 = r9.getLogin()     // Catch:{ Exception -> 0x017d }
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x017d }
            if (r8 == 0) goto L_0x00cb
            io.shipbook.shipbooksdk.Networking.SessionManager r8 = p012io.shipbook.shipbooksdk.Networking.SessionManager.INSTANCE     // Catch:{ Exception -> 0x017d }
            java.lang.String r8 = r8.getToken()     // Catch:{ Exception -> 0x017d }
            r7.setToken(r8)     // Catch:{ Exception -> 0x017d }
            r7.setLogin(r2)     // Catch:{ Exception -> 0x017d }
            goto L_0x00cb
        L_0x00f4:
            java.util.Date r2 = new java.util.Date     // Catch:{ Exception -> 0x017d }
            r2.<init>()     // Catch:{ Exception -> 0x017d }
            r6 = r14
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ Exception -> 0x017d }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x017d }
        L_0x0100:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x017d }
            if (r7 == 0) goto L_0x0117
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x017d }
            io.shipbook.shipbooksdk.Models.SessionLogData r7 = (p012io.shipbook.shipbooksdk.Models.SessionLogData) r7     // Catch:{ Exception -> 0x017d }
            io.shipbook.shipbooksdk.Models.Login r7 = r7.getLogin()     // Catch:{ Exception -> 0x017d }
            if (r7 != 0) goto L_0x0113
            goto L_0x0100
        L_0x0113:
            r7.setDeviceTime(r2)     // Catch:{ Exception -> 0x017d }
            goto L_0x0100
        L_0x0117:
            io.shipbook.shipbooksdk.Networking.ConnectionClient r2 = p012io.shipbook.shipbooksdk.Networking.ConnectionClient.INSTANCE     // Catch:{ Exception -> 0x016b }
            java.lang.String r6 = "sessions/uploadSavedData"
            io.shipbook.shipbooksdk.Networking.HttpMethod r7 = p012io.shipbook.shipbooksdk.Networking.HttpMethod.POST     // Catch:{ Exception -> 0x016b }
            r0.L$0 = r13     // Catch:{ Exception -> 0x016b }
            r0.label = r4     // Catch:{ Exception -> 0x016b }
            java.lang.Object r14 = r2.request((java.lang.String) r6, (java.util.List<? extends p012io.shipbook.shipbooksdk.Models.BaseObj>) r14, (p012io.shipbook.shipbooksdk.Networking.HttpMethod) r7, (kotlin.coroutines.Continuation<? super p012io.shipbook.shipbooksdk.Networking.ResponseData>) r0)     // Catch:{ Exception -> 0x016b }
            if (r14 != r1) goto L_0x0128
            return r1
        L_0x0128:
            r0 = r13
        L_0x0129:
            io.shipbook.shipbooksdk.Networking.ResponseData r14 = (p012io.shipbook.shipbooksdk.Networking.ResponseData) r14     // Catch:{ Exception -> 0x0032 }
            boolean r1 = r14.getOk()     // Catch:{ Exception -> 0x0032 }
            if (r1 == 0) goto L_0x0139
            java.io.File r14 = r0.getTempFile()     // Catch:{ Exception -> 0x0032 }
            r14.delete()     // Catch:{ Exception -> 0x0032 }
            goto L_0x0168
        L_0x0139:
            int r1 = r14.getStatusCode()     // Catch:{ Exception -> 0x0032 }
            r2 = -1
            if (r1 != r2) goto L_0x0150
            io.shipbook.shipbooksdk.InnerLog r6 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ Exception -> 0x0032 }
            java.lang.String r7 = r0.TAG     // Catch:{ Exception -> 0x0032 }
            java.lang.String r8 = "probably no internet connection"
            r9 = 0
            r10 = 4
            r11 = 0
            p012io.shipbook.shipbooksdk.InnerLog.i$default(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0032 }
            r0.concatTmpFile()     // Catch:{ Exception -> 0x0032 }
            goto L_0x0168
        L_0x0150:
            io.shipbook.shipbooksdk.InnerLog r6 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ Exception -> 0x0032 }
            java.lang.String r7 = r0.TAG     // Catch:{ Exception -> 0x0032 }
            java.lang.String r1 = "got error from the server with status code:"
            int r14 = r14.getStatusCode()     // Catch:{ Exception -> 0x0032 }
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r14)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r14)     // Catch:{ Exception -> 0x0032 }
            r9 = 0
            r10 = 4
            r11 = 0
            p012io.shipbook.shipbooksdk.InnerLog.i$default(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0032 }
        L_0x0168:
            r0.uploadingSavedData = r5     // Catch:{ Exception -> 0x0032 }
            goto L_0x0178
        L_0x016b:
            r14 = move-exception
            r0 = r13
        L_0x016d:
            io.shipbook.shipbooksdk.InnerLog r1 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = r0.TAG     // Catch:{ Exception -> 0x017b }
            java.lang.Throwable r14 = (java.lang.Throwable) r14     // Catch:{ Exception -> 0x017b }
            r1.mo33259e(r2, r3, r14)     // Catch:{ Exception -> 0x017b }
            r0.uploadingSavedData = r5     // Catch:{ Exception -> 0x017b }
        L_0x0178:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x017b:
            r14 = move-exception
            goto L_0x017f
        L_0x017d:
            r14 = move-exception
            r0 = r13
        L_0x017f:
            io.shipbook.shipbooksdk.InnerLog r1 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE
            java.lang.String r2 = r0.TAG
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            r1.mo33259e(r2, r3, r14)
            r0.uploadingSavedData = r5
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: p012io.shipbook.shipbooksdk.Appenders.SBCloudAppender.send(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void concatTmpFile() {
        if (this.file.isFile()) {
            FilesKt.appendText$default(this.tempFile, FilesKt.readText$default(this.file, (Charset) null, 1, (Object) null), (Charset) null, 2, (Object) null);
        }
        this.tempFile.renameTo(this.file);
    }
}
