package androidx.navigation.p005ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationView;

/* renamed from: androidx.navigation.ui.NavigationUI$$ExternalSyntheticLambda5 */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda5 implements NavigationView.OnNavigationItemSelectedListener {
    public final /* synthetic */ NavController f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ NavigationView f$2;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda5(NavController navController, boolean z, NavigationView navigationView) {
        this.f$0 = navController;
        this.f$1 = z;
        this.f$2 = navigationView;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.m695setupWithNavController$lambda5(this.f$0, this.f$1, this.f$2, menuItem);
    }
}
