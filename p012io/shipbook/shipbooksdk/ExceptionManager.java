package p012io.shipbook.shipbooksdk;

import java.lang.Thread;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.Models.Exception;
import p012io.shipbook.shipbooksdk.Util.ListStackTraceElementExtKt;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/ExceptionManager;", "", "()V", "TAG", "", "start", "", "hasException", "", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.ExceptionManager */
/* compiled from: ExceptionManager.kt */
public final class ExceptionManager {
    public static final ExceptionManager INSTANCE = new ExceptionManager();
    private static final String TAG = "ExceptionManager";

    private ExceptionManager() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("ExceptionManager", "ExceptionManager::class.java.simpleName");
    }

    public static /* synthetic */ void start$default(ExceptionManager exceptionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        exceptionManager.start(z);
    }

    public final void start(boolean z) {
        if (z) {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionManager$$ExternalSyntheticLambda0(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: start$lambda-0  reason: not valid java name */
    public static final void m767start$lambda0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        InnerLog.e$default(InnerLog.INSTANCE, TAG, "catch uncaught exception", (Throwable) null, 4, (Object) null);
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "throwable.stackTrace");
        LogManager.INSTANCE.push(new Exception(th.getClass().getName(), th.getMessage(), ListStackTraceElementExtKt.toInternal(stackTrace), 0, (Date) null, (BaseLog.ThreadInfo) null, 56, (DefaultConstructorMarker) null));
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            System.exit(1);
        }
    }
}
