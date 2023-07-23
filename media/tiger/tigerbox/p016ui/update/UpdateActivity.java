package media.tiger.tigerbox.p016ui.update;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.ActivityUpdateBinding;
import media.tiger.tigerbox.p016ui.TigerBoxActivity;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/update/UpdateActivity;", "Lmedia/tiger/tigerbox/ui/TigerBoxActivity;", "()V", "binding", "Lmedia/tiger/tigerbox/databinding/ActivityUpdateBinding;", "canFinishOnTigerButton", "", "getCanFinishOnTigerButton", "()Z", "setCanFinishOnTigerButton", "(Z)V", "navController", "Landroidx/navigation/NavController;", "navHostFragment", "Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onTigerButtonPressed", "showHardwareSafeguardDialog", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.update.UpdateActivity */
/* compiled from: UpdateActivity.kt */
public final class UpdateActivity extends TigerBoxActivity {
    private ActivityUpdateBinding binding;
    private boolean canFinishOnTigerButton;
    private NavController navController;
    private Fragment navHostFragment;

    public void showHardwareSafeguardDialog() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityUpdateBinding inflate = ActivityUpdateBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        Fragment fragment = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2814R.C2817id.f1792updatenav_graph_fragment);
        if (findFragmentById != null) {
            this.navHostFragment = findFragmentById;
            if (findFragmentById == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navHostFragment");
            } else {
                fragment = findFragmentById;
            }
            this.navController = FragmentKt.findNavController(fragment);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final boolean getCanFinishOnTigerButton() {
        return this.canFinishOnTigerButton;
    }

    public final void setCanFinishOnTigerButton(boolean z) {
        this.canFinishOnTigerButton = z;
    }

    public void onTigerButtonPressed() {
        if (this.canFinishOnTigerButton) {
            finish();
        }
    }
}
