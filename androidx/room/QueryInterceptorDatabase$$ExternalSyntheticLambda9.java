package androidx.room;

import androidx.sqlite.p006db.SupportSQLiteQuery;

public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;
    public final /* synthetic */ SupportSQLiteQuery f$1;
    public final /* synthetic */ QueryInterceptorProgram f$2;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda9(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f$0 = queryInterceptorDatabase;
        this.f$1 = supportSQLiteQuery;
        this.f$2 = queryInterceptorProgram;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$9(this.f$0, this.f$1, this.f$2);
    }
}
