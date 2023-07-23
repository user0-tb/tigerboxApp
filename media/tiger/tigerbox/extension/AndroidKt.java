package media.tiger.tigerbox.extension;

import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¨\u0006\b"}, mo33737d2 = {"isCurrentThreadMain", "", "printIsCurrentThreadMain", "", "runOnUiThread", "", "block", "Lkotlin/Function0;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: android.kt */
public final class AndroidKt {
    public static final boolean isCurrentThreadMain() {
        return Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper());
    }

    public static final String printIsCurrentThreadMain() {
        return isCurrentThreadMain() ? "Running on the main thread" : "Not running on the main thread";
    }

    public static final void runOnUiThread(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new AndroidKt$runOnUiThread$1(function0, (Continuation<? super AndroidKt$runOnUiThread$1>) null), 3, (Object) null);
    }
}
