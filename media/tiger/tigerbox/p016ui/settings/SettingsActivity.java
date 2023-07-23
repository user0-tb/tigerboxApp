package media.tiger.tigerbox.p016ui.settings;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.ActivitySettingsBinding;
import media.tiger.tigerbox.p016ui.main.SettingsListener;

@Metadata(mo33736d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsActivity;", "Lmedia/tiger/tigerbox/ui/TigerBoxActivity;", "Lmedia/tiger/tigerbox/ui/main/SettingsListener;", "()V", "binding", "Lmedia/tiger/tigerbox/databinding/ActivitySettingsBinding;", "canResetDevice", "", "getCanResetDevice", "()Z", "navController", "Landroidx/navigation/NavController;", "navHostFragment", "Landroidx/fragment/app/Fragment;", "supportsNfc", "getSupportsNfc", "disableCardsMode", "", "enableCardsMode", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTigerButtonPressed", "showHardwareSafeguardDialog", "showResetDialog", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsActivity */
/* compiled from: SettingsActivity.kt */
public final class SettingsActivity extends Hilt_SettingsActivity implements SettingsListener {
    private ActivitySettingsBinding binding;
    private NavController navController;
    private Fragment navHostFragment;

    public void disableCardsMode() {
    }

    public void enableCardsMode() {
    }

    public boolean getCanResetDevice() {
        return true;
    }

    public boolean getSupportsNfc() {
        return true;
    }

    public void showHardwareSafeguardDialog() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivitySettingsBinding inflate = ActivitySettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        Fragment fragment = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        getWindow().setSoftInputMode(48);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2814R.C2817id.f1764settingsnav_graph_fragment);
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

    public void onTigerButtonPressed() {
        NavController navController2 = this.navController;
        NavController navController3 = null;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        if (navController2.getBackQueue().size() > 2) {
            NavController navController4 = this.navController;
            if (navController4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController4 = null;
            }
            NavDestination destination = navController4.getBackQueue().last().getDestination();
            NavController navController5 = this.navController;
            if (navController5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController5 = null;
            }
            if (!Intrinsics.areEqual((Object) destination, (Object) navController5.findDestination((int) C2814R.C2817id.offlineModeFragment))) {
                NavController navController6 = this.navController;
                if (navController6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController3 = navController6;
                }
                navController3.popBackStack();
                return;
            }
        }
        finish();
    }

    public void showResetDialog() {
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        navController2.navigate((int) C2814R.C2817id.resetDialogFragment);
    }
}
