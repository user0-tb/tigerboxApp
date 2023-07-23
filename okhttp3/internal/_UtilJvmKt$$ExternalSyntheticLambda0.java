package okhttp3.internal;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class _UtilJvmKt$$ExternalSyntheticLambda0 implements ThreadFactory {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ _UtilJvmKt$$ExternalSyntheticLambda0(String str, boolean z) {
        this.f$0 = str;
        this.f$1 = z;
    }

    public final Thread newThread(Runnable runnable) {
        return _UtilJvmKt.m2726threadFactory$lambda1(this.f$0, this.f$1, runnable);
    }
}
