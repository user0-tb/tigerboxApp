package androidx.navigation.p005ui;

import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo33737d2 = {"setupWithNavController", "", "Lcom/google/android/material/navigation/NavigationView;", "navController", "Landroidx/navigation/NavController;", "navigation-ui_release"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: androidx.navigation.ui.NavigationViewKt */
/* compiled from: NavigationView.kt */
public final class NavigationViewKt {
    public static final void setupWithNavController(NavigationView navigationView, NavController navController) {
        Intrinsics.checkNotNullParameter(navigationView, "<this>");
        Intrinsics.checkNotNullParameter(navController, "navController");
        NavigationUI.setupWithNavController(navigationView, navController);
    }
}
