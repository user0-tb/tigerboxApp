package p012io.shipbook.shipbooksdk;

import java.lang.Thread;

/* renamed from: io.shipbook.shipbooksdk.ExceptionManager$$ExternalSyntheticLambda0 */
public final /* synthetic */ class ExceptionManager$$ExternalSyntheticLambda0 implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ Thread.UncaughtExceptionHandler f$0;

    public /* synthetic */ ExceptionManager$$ExternalSyntheticLambda0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f$0 = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        ExceptionManager.m767start$lambda0(this.f$0, thread, th);
    }
}
