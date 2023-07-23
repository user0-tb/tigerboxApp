package androidx.navigation;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"androidx/navigation/NavController$onBackPressedCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "navigation-runtime_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NavController.kt */
public final class NavController$onBackPressedCallback$1 extends OnBackPressedCallback {
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavController$onBackPressedCallback$1(NavController navController) {
        super(false);
        this.this$0 = navController;
    }

    public void handleOnBackPressed() {
        this.this$0.popBackStack();
    }
}
