package androidx.navigation.p005ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationBarView;

/* renamed from: androidx.navigation.ui.NavigationUI$$ExternalSyntheticLambda3 */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda3 implements NavigationBarView.OnItemSelectedListener {
    public final /* synthetic */ NavController f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda3(NavController navController, boolean z) {
        this.f$0 = navController;
        this.f$1 = z;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.m697setupWithNavController$lambda8(this.f$0, this.f$1, menuItem);
    }
}
