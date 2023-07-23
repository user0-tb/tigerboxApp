package androidx.room;

public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda0(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f$0 = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(this.f$0);
    }
}
