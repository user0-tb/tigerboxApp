package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.AsyncDns;

@Metadata(mo33736d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, mo33737d2 = {"okhttp3/AsyncDns$Companion$toDns$1$1$1", "Lokhttp3/AsyncDns$Callback;", "onFailure", "", "hostname", "", "e", "Ljava/io/IOException;", "Lokio/IOException;", "onResponse", "addresses", "", "Ljava/net/InetAddress;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AsyncDns.kt */
public final class AsyncDns$Companion$toDns$1$1$1 implements AsyncDns.Callback {
    final /* synthetic */ List<InetAddress> $allAddresses;
    final /* synthetic */ List<IOException> $allExceptions;
    final /* synthetic */ CountDownLatch $latch;

    AsyncDns$Companion$toDns$1$1$1(List<InetAddress> list, CountDownLatch countDownLatch, List<IOException> list2) {
        this.$allAddresses = list;
        this.$latch = countDownLatch;
        this.$allExceptions = list2;
    }

    public void onResponse(String str, List<? extends InetAddress> list) {
        Intrinsics.checkNotNullParameter(str, "hostname");
        Intrinsics.checkNotNullParameter(list, "addresses");
        List<InetAddress> list2 = this.$allAddresses;
        synchronized (list2) {
            list2.addAll(list);
        }
        this.$latch.countDown();
    }

    public void onFailure(String str, IOException iOException) {
        Intrinsics.checkNotNullParameter(str, "hostname");
        Intrinsics.checkNotNullParameter(iOException, "e");
        List<IOException> list = this.$allExceptions;
        synchronized (list) {
            list.add(iOException);
        }
        this.$latch.countDown();
    }
}
