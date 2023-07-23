package okhttp3;

import java.util.List;
import okhttp3.AsyncDns;

public final /* synthetic */ class AsyncDns$Companion$$ExternalSyntheticLambda0 implements Dns {
    public final /* synthetic */ AsyncDns[] f$0;

    public /* synthetic */ AsyncDns$Companion$$ExternalSyntheticLambda0(AsyncDns[] asyncDnsArr) {
        this.f$0 = asyncDnsArr;
    }

    public final List lookup(String str) {
        return AsyncDns.Companion.m2600toDns$lambda2(this.f$0, str);
    }
}
