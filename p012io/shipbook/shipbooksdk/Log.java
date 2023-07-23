package p012io.shipbook.shipbooksdk;

import android.content.Context;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.exoplayer2.extractor.p007ts.PsExtractor;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.Models.Message;
import p012io.shipbook.shipbooksdk.Models.Severity;
import p012io.shipbook.shipbooksdk.Models.StackTraceElement;
import p012io.shipbook.shipbooksdk.Networking.SessionManager;
import p012io.shipbook.shipbooksdk.Util.ListStackTraceElementExtKt;

@Metadata(mo33736d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\r*\u0001\t\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001c\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\b\u0010\u0019\u001a\u00020\u0013H\u0004J\u001c\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007JY\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001c\u0010\"\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Log;", "", "tag", "", "(Ljava/lang/String;)V", "TAG", "getTAG$annotations", "()V", "broadcastReceiver", "io/shipbook/shipbooksdk/Log$broadcastReceiver$1", "Lio/shipbook/shipbooksdk/Log$broadcastReceiver$1;", "callStackSeverity", "Lio/shipbook/shipbooksdk/Models/Severity;", "counter", "", "severity", "getTag", "()Ljava/lang/String;", "addBroadcastReceiver", "", "d", "msg", "throwable", "", "e", "finalize", "i", "message", "function", "fileName", "lineNumber", "className", "(Ljava/lang/String;Lio/shipbook/shipbooksdk/Models/Severity;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "v", "w", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Log */
/* compiled from: Log.kt */
public final class Log {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final String TAG = "Log";
    private final Log$broadcastReceiver$1 broadcastReceiver;
    /* access modifiers changed from: private */
    public volatile Severity callStackSeverity;
    /* access modifiers changed from: private */
    public int counter;
    /* access modifiers changed from: private */
    public volatile Severity severity;
    private final String tag;

    @JvmStatic
    /* renamed from: d */
    public static final void m435d(String str, String str2) {
        Companion.mo33284d(str, str2);
    }

    @JvmStatic
    /* renamed from: d */
    public static final void m436d(String str, String str2, Throwable th) {
        Companion.mo33285d(str, str2, th);
    }

    @JvmStatic
    /* renamed from: e */
    public static final void m437e(String str, String str2) {
        Companion.mo33286e(str, str2);
    }

    @JvmStatic
    /* renamed from: e */
    public static final void m438e(String str, String str2, Throwable th) {
        Companion.mo33287e(str, str2, th);
    }

    private static /* synthetic */ void getTAG$annotations() {
    }

    @JvmStatic
    /* renamed from: i */
    public static final void m439i(String str, String str2) {
        Companion.mo33288i(str, str2);
    }

    @JvmStatic
    /* renamed from: i */
    public static final void m440i(String str, String str2, Throwable th) {
        Companion.mo33289i(str, str2, th);
    }

    @JvmStatic
    public static final void message(String str, String str2, int i) {
        Companion.message(str, str2, i);
    }

    @JvmStatic
    public static final void message(String str, String str2, int i, Throwable th) {
        Companion.message(str, str2, i, th);
    }

    @JvmStatic
    public static final void message(String str, String str2, int i, Throwable th, String str3) {
        Companion.message(str, str2, i, th, str3);
    }

    @JvmStatic
    public static final void message(String str, String str2, int i, Throwable th, String str3, String str4) {
        Companion.message(str, str2, i, th, str3, str4);
    }

    @JvmStatic
    public static final void message(String str, String str2, int i, Throwable th, String str3, String str4, Integer num) {
        Companion.message(str, str2, i, th, str3, str4, num);
    }

    @JvmStatic
    public static final void message(String str, String str2, int i, Throwable th, String str3, String str4, Integer num, String str5) {
        Companion.message(str, str2, i, th, str3, str4, num, str5);
    }

    @JvmStatic
    public static final void message(String str, String str2, Severity severity2) {
        Companion.message(str, str2, severity2);
    }

    @JvmStatic
    public static final void message(String str, String str2, Severity severity2, Throwable th) {
        Companion.message(str, str2, severity2, th);
    }

    @JvmStatic
    public static final void message(String str, String str2, Severity severity2, Throwable th, String str3) {
        Companion.message(str, str2, severity2, th, str3);
    }

    @JvmStatic
    public static final void message(String str, String str2, Severity severity2, Throwable th, String str3, String str4) {
        Companion.message(str, str2, severity2, th, str3, str4);
    }

    @JvmStatic
    public static final void message(String str, String str2, Severity severity2, Throwable th, String str3, String str4, Integer num) {
        Companion.message(str, str2, severity2, th, str3, str4, num);
    }

    @JvmStatic
    public static final void message(String str, String str2, Severity severity2, Throwable th, String str3, String str4, Integer num, String str5) {
        Companion.message(str, str2, severity2, th, str3, str4, num, str5);
    }

    @JvmStatic
    /* renamed from: v */
    public static final void m441v(String str, String str2) {
        Companion.mo33302v(str, str2);
    }

    @JvmStatic
    /* renamed from: v */
    public static final void m442v(String str, String str2, Throwable th) {
        Companion.mo33303v(str, str2, th);
    }

    @JvmStatic
    /* renamed from: w */
    public static final void m443w(String str, String str2) {
        Companion.mo33304w(str, str2);
    }

    @JvmStatic
    /* renamed from: w */
    public static final void m444w(String str, String str2, Throwable th) {
        Companion.mo33305w(str, str2, th);
    }

    /* renamed from: d */
    public final void mo33266d(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        d$default(this, str, (Throwable) null, 2, (Object) null);
    }

    /* renamed from: e */
    public final void mo33268e(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        e$default(this, str, (Throwable) null, 2, (Object) null);
    }

    /* renamed from: i */
    public final void mo33272i(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        i$default(this, str, (Throwable) null, 2, (Object) null);
    }

    public final void message(String str, Severity severity2) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(severity2, "severity");
        message$default(this, str, severity2, (Throwable) null, (String) null, (String) null, (Integer) null, (String) null, 124, (Object) null);
    }

    public final void message(String str, Severity severity2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(severity2, "severity");
        message$default(this, str, severity2, th, (String) null, (String) null, (Integer) null, (String) null, 120, (Object) null);
    }

    public final void message(String str, Severity severity2, Throwable th, String str2) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(severity2, "severity");
        message$default(this, str, severity2, th, str2, (String) null, (Integer) null, (String) null, 112, (Object) null);
    }

    public final void message(String str, Severity severity2, Throwable th, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(severity2, "severity");
        message$default(this, str, severity2, th, str2, str3, (Integer) null, (String) null, 96, (Object) null);
    }

    public final void message(String str, Severity severity2, Throwable th, String str2, String str3, Integer num) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(severity2, "severity");
        message$default(this, str, severity2, th, str2, str3, num, (String) null, 64, (Object) null);
    }

    /* renamed from: v */
    public final void mo33280v(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        v$default(this, str, (Throwable) null, 2, (Object) null);
    }

    /* renamed from: w */
    public final void mo33282w(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        w$default(this, str, (Throwable) null, 2, (Object) null);
    }

    public Log(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.tag = str;
        Intrinsics.checkNotNullExpressionValue("Log", "Log::class.java.simpleName");
        this.severity = LogManager.INSTANCE.getSeverity(str);
        this.callStackSeverity = LogManager.INSTANCE.getCallStackSeverity(str);
        this.broadcastReceiver = new Log$broadcastReceiver$1(this);
        InnerLog.d$default(InnerLog.INSTANCE, "Log", "register broadcast receiver", (Throwable) null, 4, (Object) null);
        addBroadcastReceiver();
    }

    public final String getTag() {
        return this.tag;
    }

    @Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J&\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J&\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007Jc\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0014Jc\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00122\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J&\u0010\u0017\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u0018"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Log$Companion;", "", "()V", "d", "", "tag", "", "msg", "throwable", "", "e", "i", "message", "severity", "Lio/shipbook/shipbooksdk/Models/Severity;", "function", "fileName", "lineNumber", "", "className", "(Ljava/lang/String;Ljava/lang/String;Lio/shipbook/shipbooksdk/Models/Severity;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "v", "w", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Log$Companion */
    /* compiled from: Log.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* renamed from: d */
        public final void mo33284d(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            d$default(this, str, str2, (Throwable) null, 4, (Object) null);
        }

        @JvmStatic
        /* renamed from: e */
        public final void mo33286e(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            e$default(this, str, str2, (Throwable) null, 4, (Object) null);
        }

        @JvmStatic
        /* renamed from: i */
        public final void mo33288i(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            i$default(this, str, str2, (Throwable) null, 4, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, i, (Throwable) null, (String) null, (String) null, (Integer) null, (String) null, 248, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, int i, Throwable th) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, i, th, (String) null, (String) null, (Integer) null, (String) null, (int) PsExtractor.VIDEO_STREAM_MASK, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, int i, Throwable th, String str3) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, i, th, str3, (String) null, (Integer) null, (String) null, 224, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, int i, Throwable th, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, i, th, str3, str4, (Integer) null, (String) null, 192, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, int i, Throwable th, String str3, String str4, Integer num) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, i, th, str3, str4, num, (String) null, 128, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, Severity severity) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(severity, "severity");
            message$default(this, str, str2, severity, (Throwable) null, (String) null, (String) null, (Integer) null, (String) null, 248, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, Severity severity, Throwable th) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(severity, "severity");
            message$default(this, str, str2, severity, th, (String) null, (String) null, (Integer) null, (String) null, (int) PsExtractor.VIDEO_STREAM_MASK, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, Severity severity, Throwable th, String str3) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(severity, "severity");
            message$default(this, str, str2, severity, th, str3, (String) null, (Integer) null, (String) null, 224, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, Severity severity, Throwable th, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(severity, "severity");
            message$default(this, str, str2, severity, th, str3, str4, (Integer) null, (String) null, 192, (Object) null);
        }

        @JvmStatic
        public final void message(String str, String str2, Severity severity, Throwable th, String str3, String str4, Integer num) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(severity, "severity");
            message$default(this, str, str2, severity, th, str3, str4, num, (String) null, 128, (Object) null);
        }

        @JvmStatic
        /* renamed from: v */
        public final void mo33302v(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            v$default(this, str, str2, (Throwable) null, 4, (Object) null);
        }

        @JvmStatic
        /* renamed from: w */
        public final void mo33304w(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            w$default(this, str, str2, (Throwable) null, 4, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ void e$default(Companion companion, String str, String str2, Throwable th, int i, Object obj) {
            if ((i & 4) != 0) {
                th = null;
            }
            companion.mo33287e(str, str2, th);
        }

        @JvmStatic
        /* renamed from: e */
        public final void mo33287e(String str, String str2, Throwable th) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, Severity.Error, th, (String) null, (String) null, (Integer) null, (String) null, (int) PsExtractor.VIDEO_STREAM_MASK, (Object) null);
        }

        public static /* synthetic */ void w$default(Companion companion, String str, String str2, Throwable th, int i, Object obj) {
            if ((i & 4) != 0) {
                th = null;
            }
            companion.mo33305w(str, str2, th);
        }

        @JvmStatic
        /* renamed from: w */
        public final void mo33305w(String str, String str2, Throwable th) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, Severity.Warning, th, (String) null, (String) null, (Integer) null, (String) null, (int) PsExtractor.VIDEO_STREAM_MASK, (Object) null);
        }

        public static /* synthetic */ void i$default(Companion companion, String str, String str2, Throwable th, int i, Object obj) {
            if ((i & 4) != 0) {
                th = null;
            }
            companion.mo33289i(str, str2, th);
        }

        @JvmStatic
        /* renamed from: i */
        public final void mo33289i(String str, String str2, Throwable th) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, Severity.Info, th, (String) null, (String) null, (Integer) null, (String) null, (int) PsExtractor.VIDEO_STREAM_MASK, (Object) null);
        }

        public static /* synthetic */ void d$default(Companion companion, String str, String str2, Throwable th, int i, Object obj) {
            if ((i & 4) != 0) {
                th = null;
            }
            companion.mo33285d(str, str2, th);
        }

        @JvmStatic
        /* renamed from: d */
        public final void mo33285d(String str, String str2, Throwable th) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, Severity.Debug, th, (String) null, (String) null, (Integer) null, (String) null, (int) PsExtractor.VIDEO_STREAM_MASK, (Object) null);
        }

        public static /* synthetic */ void v$default(Companion companion, String str, String str2, Throwable th, int i, Object obj) {
            if ((i & 4) != 0) {
                th = null;
            }
            companion.mo33303v(str, str2, th);
        }

        @JvmStatic
        /* renamed from: v */
        public final void mo33303v(String str, String str2, Throwable th) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            message$default(this, str, str2, Severity.Verbose, th, (String) null, (String) null, (Integer) null, (String) null, (int) PsExtractor.VIDEO_STREAM_MASK, (Object) null);
        }

        public static /* synthetic */ void message$default(Companion companion, String str, String str2, int i, Throwable th, String str3, String str4, Integer num, String str5, int i2, Object obj) {
            int i3 = i2;
            companion.message(str, str2, i, (i3 & 8) != 0 ? null : th, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : num, (i3 & 128) != 0 ? null : str5);
        }

        @JvmStatic
        public final void message(String str, String str2, int i, Throwable th, String str3, String str4, Integer num, String str5) {
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            int i2 = i;
            message(str, str2, Severity.Companion.fromInt(i), th, str3, str4, num, str5);
        }

        public static /* synthetic */ void message$default(Companion companion, String str, String str2, Severity severity, Throwable th, String str3, String str4, Integer num, String str5, int i, Object obj) {
            int i2 = i;
            companion.message(str, str2, severity, (i2 & 8) != 0 ? null : th, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : str5);
        }

        @JvmStatic
        public final void message(String str, String str2, Severity severity, Throwable th, String str3, String str4, Integer num, String str5) {
            Message message;
            String str6 = str;
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(severity, "severity");
            List<StackTraceElement> list = null;
            if (str6 == null) {
                Message message2 = r1;
                Message message3 = new Message(severity, str2, (String) null, (List) null, th, str3, str4, num, str5, (Message.MessageException) null, 0, (Date) null, (BaseLog.ThreadInfo) null, 7680, (DefaultConstructorMarker) null);
                String tag = message2.getTag();
                if (tag != null && severity.ordinal() <= LogManager.INSTANCE.getSeverity(tag).ordinal()) {
                    if (severity.ordinal() <= LogManager.INSTANCE.getCallStackSeverity(tag).ordinal()) {
                        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                        Intrinsics.checkNotNullExpressionValue(stackTrace, "Throwable().stackTrace");
                        list = ListStackTraceElementExtKt.toInternal(stackTrace);
                    }
                    Message message4 = message2;
                    message4.setStackTrace(list);
                    message = message4;
                } else {
                    return;
                }
            } else if (severity.ordinal() <= LogManager.INSTANCE.getSeverity(str6).ordinal()) {
                if (severity.ordinal() <= LogManager.INSTANCE.getCallStackSeverity(str6).ordinal()) {
                    StackTraceElement[] stackTrace2 = new Throwable().getStackTrace();
                    Intrinsics.checkNotNullExpressionValue(stackTrace2, "Throwable().stackTrace");
                    list = ListStackTraceElementExtKt.toInternal(stackTrace2);
                }
                message = new Message(severity, str2, str, list, th, str3, str4, num, str5, (Message.MessageException) null, 0, (Date) null, (BaseLog.ThreadInfo) null, 7680, (DefaultConstructorMarker) null);
            } else {
                return;
            }
            LogManager.INSTANCE.push(message);
        }
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

    /* access modifiers changed from: private */
    public final void addBroadcastReceiver() {
        InnerLog.d$default(InnerLog.INSTANCE, this.TAG, Intrinsics.stringPlus("add broadcast receiver with counter ", Integer.valueOf(this.counter)), (Throwable) null, 4, (Object) null);
        if (SessionManager.INSTANCE.getAppContext() == null || this.counter <= 0) {
            new Timer().schedule(new Log$addBroadcastReceiver$$inlined$schedule$1(this), 0);
            return;
        }
        Context appContext = SessionManager.INSTANCE.getAppContext();
        Intrinsics.checkNotNull(appContext);
        LocalBroadcastManager.getInstance(appContext).registerReceiver(this.broadcastReceiver, new IntentFilter(BroadcastNames.INSTANCE.getCONFIG_CHANGE()));
    }

    public static /* synthetic */ void e$default(Log log, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        log.mo33269e(str, th);
    }

    /* renamed from: e */
    public final void mo33269e(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        message$default(this, str, Severity.Error, th, (String) null, (String) null, (Integer) null, (String) null, 120, (Object) null);
    }

    public static /* synthetic */ void w$default(Log log, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        log.mo33283w(str, th);
    }

    /* renamed from: w */
    public final void mo33283w(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        message$default(this, str, Severity.Warning, th, (String) null, (String) null, (Integer) null, (String) null, 120, (Object) null);
    }

    public static /* synthetic */ void i$default(Log log, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        log.mo33273i(str, th);
    }

    /* renamed from: i */
    public final void mo33273i(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        message$default(this, str, Severity.Info, th, (String) null, (String) null, (Integer) null, (String) null, 120, (Object) null);
    }

    public static /* synthetic */ void d$default(Log log, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        log.mo33267d(str, th);
    }

    /* renamed from: d */
    public final void mo33267d(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        message$default(this, str, Severity.Debug, th, (String) null, (String) null, (Integer) null, (String) null, 120, (Object) null);
    }

    public static /* synthetic */ void v$default(Log log, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        log.mo33281v(str, th);
    }

    /* renamed from: v */
    public final void mo33281v(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        message$default(this, str, Severity.Verbose, th, (String) null, (String) null, (Integer) null, (String) null, 120, (Object) null);
    }

    public static /* synthetic */ void message$default(Log log, String str, Severity severity2, Throwable th, String str2, String str3, Integer num, String str4, int i, Object obj) {
        log.message(str, severity2, (i & 4) != 0 ? null : th, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str4);
    }

    public final void message(String str, Severity severity2, Throwable th, String str2, String str3, Integer num, String str4) {
        List<StackTraceElement> list;
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(severity2, "severity");
        if (severity2.ordinal() <= this.severity.ordinal()) {
            if (severity2.ordinal() <= this.callStackSeverity.ordinal()) {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace, "Throwable().stackTrace");
                list = ListStackTraceElementExtKt.toInternal(stackTrace);
            } else {
                list = null;
            }
            Severity severity3 = severity2;
            String str5 = str;
            LogManager.INSTANCE.push(new Message(severity3, str5, this.tag, list, th, str2, str3, num, str4, (Message.MessageException) null, 0, (Date) null, (BaseLog.ThreadInfo) null, 7680, (DefaultConstructorMarker) null));
        }
    }
}
