package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0003\b\t\nJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, mo33737d2 = {"Lokhttp3/AsyncDns;", "", "query", "", "hostname", "", "callback", "Lokhttp3/AsyncDns$Callback;", "Callback", "Companion", "DnsClass", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AsyncDns.kt */
public interface AsyncDns {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int TYPE_A = 1;
    public static final int TYPE_AAAA = 28;

    @Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&¨\u0006\r"}, mo33737d2 = {"Lokhttp3/AsyncDns$Callback;", "", "onFailure", "", "hostname", "", "e", "Ljava/io/IOException;", "Lokio/IOException;", "onResponse", "addresses", "", "Ljava/net/InetAddress;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AsyncDns.kt */
    public interface Callback {
        void onFailure(String str, IOException iOException);

        void onResponse(String str, List<? extends InetAddress> list);
    }

    void query(String str, Callback callback);

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo33737d2 = {"Lokhttp3/AsyncDns$DnsClass;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "IPV4", "IPV6", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AsyncDns.kt */
    public enum DnsClass {
        IPV4(1),
        IPV6(28);
        
        private final int type;

        private DnsClass(int i) {
            this.type = i;
        }

        public final int getType() {
            return this.type;
        }
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo33737d2 = {"Lokhttp3/AsyncDns$Companion;", "", "()V", "TYPE_A", "", "TYPE_AAAA", "toDns", "Lokhttp3/Dns;", "asyncDns", "", "Lokhttp3/AsyncDns;", "([Lokhttp3/AsyncDns;)Lokhttp3/Dns;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AsyncDns.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TYPE_A = 1;
        public static final int TYPE_AAAA = 28;

        private Companion() {
        }

        public final Dns toDns(AsyncDns... asyncDnsArr) {
            Intrinsics.checkNotNullParameter(asyncDnsArr, "asyncDns");
            return new AsyncDns$Companion$$ExternalSyntheticLambda0(asyncDnsArr);
        }

        /* access modifiers changed from: private */
        /* renamed from: toDns$lambda-2  reason: not valid java name */
        public static final List m2600toDns$lambda2(AsyncDns[] asyncDnsArr, String str) {
            Intrinsics.checkNotNullParameter(asyncDnsArr, "$asyncDns");
            Intrinsics.checkNotNullParameter(str, "hostname");
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            CountDownLatch countDownLatch = new CountDownLatch(asyncDnsArr.length);
            for (AsyncDns query : asyncDnsArr) {
                query.query(str, new AsyncDns$Companion$toDns$1$1$1(arrayList, countDownLatch, arrayList2));
            }
            countDownLatch.await();
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            IOException iOException = (IOException) CollectionsKt.firstOrNull(arrayList2);
            if (iOException == null) {
                iOException = new UnknownHostException("No results for " + str);
            }
            for (IOException addSuppressed : CollectionsKt.drop(arrayList2, 1)) {
                ExceptionsKt.addSuppressed(iOException, addSuppressed);
            }
            throw iOException;
        }
    }
}
