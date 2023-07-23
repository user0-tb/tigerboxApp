package p012io.shipbook.shipbooksdk;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.Models.Severity;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ(\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\"\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\"\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0017"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/InnerLog;", "", "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "d", "", "tag", "", "msg", "throwable", "", "e", "i", "message", "severity", "Lio/shipbook/shipbooksdk/Models/Severity;", "v", "w", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.InnerLog */
/* compiled from: InnerLog.kt */
public final class InnerLog {
    public static final InnerLog INSTANCE = new InnerLog();
    private static boolean enabled;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.InnerLog$WhenMappings */
    /* compiled from: InnerLog.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Severity.values().length];
            iArr[Severity.Error.ordinal()] = 1;
            iArr[Severity.Warning.ordinal()] = 2;
            iArr[Severity.Info.ordinal()] = 3;
            iArr[Severity.Debug.ordinal()] = 4;
            iArr[Severity.Verbose.ordinal()] = 5;
            iArr[Severity.Off.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private InnerLog() {
    }

    public final boolean getEnabled() {
        return enabled;
    }

    public final void setEnabled(boolean z) {
        enabled = z;
    }

    public static /* synthetic */ void e$default(InnerLog innerLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        innerLog.mo33259e(str, str2, th);
    }

    /* renamed from: e */
    public final void mo33259e(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        message(str, str2, Severity.Error, th);
    }

    public static /* synthetic */ void w$default(InnerLog innerLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        innerLog.mo33265w(str, str2, th);
    }

    /* renamed from: w */
    public final void mo33265w(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        message(str, str2, Severity.Warning, th);
    }

    public static /* synthetic */ void i$default(InnerLog innerLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        innerLog.mo33261i(str, str2, th);
    }

    /* renamed from: i */
    public final void mo33261i(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        message(str, str2, Severity.Info, th);
    }

    public static /* synthetic */ void d$default(InnerLog innerLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        innerLog.mo33258d(str, str2, th);
    }

    /* renamed from: d */
    public final void mo33258d(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        message(str, str2, Severity.Debug, th);
    }

    public static /* synthetic */ void v$default(InnerLog innerLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        innerLog.mo33264v(str, str2, th);
    }

    /* renamed from: v */
    public final void mo33264v(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        message(str, str2, Severity.Verbose, th);
    }

    public final void message(String str, String str2, Severity severity, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(severity, "severity");
        if (enabled) {
            String stringPlus = Intrinsics.stringPlus("Shipbook-", str);
            if (th != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[severity.ordinal()];
                if (i == 1) {
                    Log.e(stringPlus, str2, th);
                } else if (i == 2) {
                    Log.w(stringPlus, str2, th);
                } else if (i == 3) {
                    Log.i(stringPlus, str2, th);
                } else if (i == 4) {
                    Log.d(stringPlus, str2, th);
                } else if (i == 5) {
                    Log.v(stringPlus, str2, th);
                }
            } else {
                int i2 = WhenMappings.$EnumSwitchMapping$0[severity.ordinal()];
                if (i2 == 1) {
                    Log.e(stringPlus, str2);
                } else if (i2 == 2) {
                    Log.w(stringPlus, str2);
                } else if (i2 == 3) {
                    Log.i(stringPlus, str2);
                } else if (i2 == 4) {
                    Log.d(stringPlus, str2);
                } else if (i2 == 5) {
                    Log.v(stringPlus, str2);
                }
            }
        }
    }
}
