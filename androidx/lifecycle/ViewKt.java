package androidx.lifecycle;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, mo33737d2 = {"findViewTreeLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/view/View;", "lifecycle-runtime-ktx_release"}, mo33738k = 2, mo33739mv = {1, 5, 1}, mo33741xi = 48)
/* compiled from: View.kt */
public final class ViewKt {
    public static final LifecycleOwner findViewTreeLifecycleOwner(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return ViewTreeLifecycleOwner.get(view);
    }
}
