package androidx.navigation.p005ui;

import android.view.View;
import androidx.navigation.NavController;

/* renamed from: androidx.navigation.ui.NavigationUI$$ExternalSyntheticLambda1 */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ NavController f$0;
    public final /* synthetic */ AppBarConfiguration f$1;

    public /* synthetic */ NavigationUI$$ExternalSyntheticLambda1(NavController navController, AppBarConfiguration appBarConfiguration) {
        this.f$0 = navController;
        this.f$1 = appBarConfiguration;
    }

    public final void onClick(View view) {
        NavigationUI.m693setupWithNavController$lambda2(this.f$0, this.f$1, view);
    }
}
