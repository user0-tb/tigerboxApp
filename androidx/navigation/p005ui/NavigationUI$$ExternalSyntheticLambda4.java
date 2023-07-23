package androidx.navigation.p005ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationView;

/* renamed from: androidx.navigation.ui.NavigationUI$$ExternalSyntheticLambda4 */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda4 implements NavigationView.OnNavigationItemSelectedListener {
    public final /* synthetic */ NavController f$0;
    public final /* synthetic */ NavigationView f$1;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda4(NavController navController, NavigationView navigationView) {
        this.f$0 = navController;
        this.f$1 = navigationView;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.m694setupWithNavController$lambda3(this.f$0, this.f$1, menuItem);
    }
}
