package androidx.room;

/* renamed from: androidx.room.MultiInstanceInvalidationClient$callback$1$$ExternalSyntheticLambda0 */
public final /* synthetic */ class C0715x93941c2e implements Runnable {
    public final /* synthetic */ MultiInstanceInvalidationClient f$0;
    public final /* synthetic */ String[] f$1;

    public /* synthetic */ C0715x93941c2e(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        this.f$0 = multiInstanceInvalidationClient;
        this.f$1 = strArr;
    }

    public final void run() {
        MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0(this.f$0, this.f$1);
    }
}
