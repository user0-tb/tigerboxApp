package androidx.room;

import androidx.room.IMultiInstanceInvalidationCallback;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo33737d2 = {"androidx/room/MultiInstanceInvalidationClient$callback$1", "Landroidx/room/IMultiInstanceInvalidationCallback$Stub;", "onInvalidation", "", "tables", "", "", "([Ljava/lang/String;)V", "room-runtime_release"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* compiled from: MultiInstanceInvalidationClient.kt */
public final class MultiInstanceInvalidationClient$callback$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient$callback$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    /* access modifiers changed from: private */
    public static final void onInvalidation$lambda$0(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        Intrinsics.checkNotNullParameter(multiInstanceInvalidationClient, "this$0");
        Intrinsics.checkNotNullParameter(strArr, "$tables");
        multiInstanceInvalidationClient.getInvalidationTracker().notifyObserversByTableNames((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void onInvalidation(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "tables");
        this.this$0.getExecutor().execute(new C0715x93941c2e(this.this$0, strArr));
    }
}
