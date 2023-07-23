package media.tiger.tigerbox;

import android.content.Context;
import android.widget.Toast;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"showToast", "", "Landroid/content/Context;", "text", "", "length", "", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxApplication.kt */
public final class TigerBoxApplicationKt {
    public static /* synthetic */ void showToast$default(Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        showToast(context, str, i);
    }

    public static final void showToast(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "text");
        Context applicationContext = context.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type media.tiger.tigerbox.TigerBoxApplication");
        if (((TigerBoxApplication) applicationContext).getAllowToast()) {
            Toast.makeText(context, str, i).show();
        }
    }
}
