package androidx.room;

public final /* synthetic */ class QueryInterceptorStatement$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ QueryInterceptorStatement f$0;

    public /* synthetic */ QueryInterceptorStatement$$ExternalSyntheticLambda2(QueryInterceptorStatement queryInterceptorStatement) {
        this.f$0 = queryInterceptorStatement;
    }

    public final void run() {
        QueryInterceptorStatement.executeUpdateDelete$lambda$1(this.f$0);
    }
}
