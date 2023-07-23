package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0 */
public final /* synthetic */ class C3254xee4a199c implements Runnable {
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.C32531 f$0;
    public final /* synthetic */ Callback f$1;
    public final /* synthetic */ Throwable f$2;

    public /* synthetic */ C3254xee4a199c(DefaultCallAdapterFactory.ExecutorCallbackCall.C32531 r1, Callback callback, Throwable th) {
        this.f$0 = r1;
        this.f$1 = callback;
        this.f$2 = th;
    }

    public final void run() {
        this.f$0.mo50072x714e864(this.f$1, this.f$2);
    }
}
