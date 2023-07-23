package androidx.room;

public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Object[] f$2;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda2(QueryInterceptorDatabase queryInterceptorDatabase, String str, Object[] objArr) {
        this.f$0 = queryInterceptorDatabase;
        this.f$1 = str;
        this.f$2 = objArr;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$7(this.f$0, this.f$1, this.f$2);
    }
}
