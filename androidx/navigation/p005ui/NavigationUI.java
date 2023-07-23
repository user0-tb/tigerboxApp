package androidx.navigation.p005ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.Openable;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.p005ui.AppBarConfiguration;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u0007J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J*\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J*\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u001b\u0010 \u001a\u00020\b*\u00020!2\b\b\u0001\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$J!\u0010%\u001a\u00020\b*\u00020!2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0'H\u0001¢\u0006\u0002\b(¨\u0006)"}, mo33737d2 = {"Landroidx/navigation/ui/NavigationUI;", "", "()V", "findBottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "view", "Landroid/view/View;", "navigateUp", "", "navController", "Landroidx/navigation/NavController;", "openableLayout", "Landroidx/customview/widget/Openable;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "onNavDestinationSelected", "item", "Landroid/view/MenuItem;", "saveState", "setupActionBarWithNavController", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "setupWithNavController", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "collapsingToolbarLayout", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "navigationBarView", "Lcom/google/android/material/navigation/NavigationBarView;", "navigationView", "Lcom/google/android/material/navigation/NavigationView;", "matchDestination", "Landroidx/navigation/NavDestination;", "destId", "", "matchDestination$navigation_ui_release", "matchDestinations", "destinationIds", "", "matchDestinations$navigation_ui_release", "navigation-ui_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: androidx.navigation.ui.NavigationUI */
/* compiled from: NavigationUI.kt */
public final class NavigationUI {
    public static final NavigationUI INSTANCE = new NavigationUI();

    @JvmStatic
    public static final void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(navController, "navController");
        setupActionBarWithNavController$default(appCompatActivity, navController, (AppBarConfiguration) null, 4, (Object) null);
    }

    @JvmStatic
    public static final void setupWithNavController(Toolbar toolbar, NavController navController) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(navController, "navController");
        setupWithNavController$default(toolbar, navController, (AppBarConfiguration) null, 4, (Object) null);
    }

    @JvmStatic
    public static final void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController) {
        Intrinsics.checkNotNullParameter(collapsingToolbarLayout, "collapsingToolbarLayout");
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(navController, "navController");
        setupWithNavController$default(collapsingToolbarLayout, toolbar, navController, (AppBarConfiguration) null, 8, (Object) null);
    }

    private NavigationUI() {
    }

    @JvmStatic
    public static final boolean onNavDestinationSelected(MenuItem menuItem, NavController navController) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        Intrinsics.checkNotNullParameter(navController, "navController");
        boolean z = true;
        NavOptions.Builder restoreState = new NavOptions.Builder().setLaunchSingleTop(true).setRestoreState(true);
        NavDestination currentDestination = navController.getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        NavGraph parent = currentDestination.getParent();
        Intrinsics.checkNotNull(parent);
        if (parent.findNode(menuItem.getItemId()) instanceof ActivityNavigator.Destination) {
            restoreState.setEnterAnim(C0621R.anim.nav_default_enter_anim).setExitAnim(C0621R.anim.nav_default_exit_anim).setPopEnterAnim(C0621R.anim.nav_default_pop_enter_anim).setPopExitAnim(C0621R.anim.nav_default_pop_exit_anim);
        } else {
            restoreState.setEnterAnim(C0621R.animator.nav_default_enter_anim).setExitAnim(C0621R.animator.nav_default_exit_anim).setPopEnterAnim(C0621R.animator.nav_default_pop_enter_anim).setPopExitAnim(C0621R.animator.nav_default_pop_exit_anim);
        }
        if ((menuItem.getOrder() & 196608) == 0) {
            restoreState.setPopUpTo(NavGraph.Companion.findStartDestination(navController.getGraph()).getId(), false, true);
        }
        try {
            navController.navigate(menuItem.getItemId(), (Bundle) null, restoreState.build());
            NavDestination currentDestination2 = navController.getCurrentDestination();
            if (currentDestination2 == null || !matchDestination$navigation_ui_release(currentDestination2, menuItem.getItemId())) {
                z = false;
            }
            return z;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @JvmStatic
    @NavigationUiSaveStateControl
    public static final boolean onNavDestinationSelected(MenuItem menuItem, NavController navController, boolean z) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        Intrinsics.checkNotNullParameter(navController, "navController");
        boolean z2 = true;
        if (!z) {
            NavOptions.Builder launchSingleTop = new NavOptions.Builder().setLaunchSingleTop(true);
            NavDestination currentDestination = navController.getCurrentDestination();
            Intrinsics.checkNotNull(currentDestination);
            NavGraph parent = currentDestination.getParent();
            Intrinsics.checkNotNull(parent);
            if (parent.findNode(menuItem.getItemId()) instanceof ActivityNavigator.Destination) {
                launchSingleTop.setEnterAnim(C0621R.anim.nav_default_enter_anim).setExitAnim(C0621R.anim.nav_default_exit_anim).setPopEnterAnim(C0621R.anim.nav_default_pop_enter_anim).setPopExitAnim(C0621R.anim.nav_default_pop_exit_anim);
            } else {
                launchSingleTop.setEnterAnim(C0621R.animator.nav_default_enter_anim).setExitAnim(C0621R.animator.nav_default_exit_anim).setPopEnterAnim(C0621R.animator.nav_default_pop_enter_anim).setPopExitAnim(C0621R.animator.nav_default_pop_exit_anim);
            }
            if ((menuItem.getOrder() & 196608) == 0) {
                NavOptions.Builder.setPopUpTo$default(launchSingleTop, NavGraph.Companion.findStartDestination(navController.getGraph()).getId(), false, false, 4, (Object) null);
            }
            try {
                navController.navigate(menuItem.getItemId(), (Bundle) null, launchSingleTop.build());
                NavDestination currentDestination2 = navController.getCurrentDestination();
                if (currentDestination2 == null || !matchDestination$navigation_ui_release(currentDestination2, menuItem.getItemId())) {
                    z2 = false;
                }
                return z2;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default".toString());
        }
    }

    @JvmStatic
    public static final boolean navigateUp(NavController navController, Openable openable) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        return navigateUp(navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    @JvmStatic
    public static final boolean navigateUp(NavController navController, AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(appBarConfiguration, "configuration");
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        Set<Integer> topLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        if (openableLayout != null && currentDestination != null && matchDestinations$navigation_ui_release(currentDestination, topLevelDestinations)) {
            openableLayout.open();
            return true;
        } else if (navController.navigateUp()) {
            return true;
        } else {
            AppBarConfiguration.OnNavigateUpListener fallbackOnNavigateUpListener = appBarConfiguration.getFallbackOnNavigateUpListener();
            if (fallbackOnNavigateUpListener == null) {
                return false;
            }
            return fallbackOnNavigateUpListener.onNavigateUp();
        }
    }

    @JvmStatic
    public static final void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController, Openable openable) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(navController, "navController");
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static /* synthetic */ void setupActionBarWithNavController$default(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupActionBarWithNavController(appCompatActivity, navController, appBarConfiguration);
    }

    @JvmStatic
    public static final void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(appBarConfiguration, "configuration");
        navController.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(appCompatActivity, appBarConfiguration));
    }

    @JvmStatic
    public static final void setupWithNavController(Toolbar toolbar, NavController navController, Openable openable) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(navController, "navController");
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static /* synthetic */ void setupWithNavController$default(Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    @JvmStatic
    public static final void setupWithNavController(Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(appBarConfiguration, "configuration");
        navController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new NavigationUI$$ExternalSyntheticLambda0(navController, appBarConfiguration));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupWithNavController$lambda-1  reason: not valid java name */
    public static final void m692setupWithNavController$lambda1(NavController navController, AppBarConfiguration appBarConfiguration, View view) {
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(appBarConfiguration, "$configuration");
        navigateUp(navController, appBarConfiguration);
    }

    @JvmStatic
    public static final void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, Openable openable) {
        Intrinsics.checkNotNullParameter(collapsingToolbarLayout, "collapsingToolbarLayout");
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(navController, "navController");
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static /* synthetic */ void setupWithNavController$default(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 8) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, appBarConfiguration);
    }

    @JvmStatic
    public static final void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkNotNullParameter(collapsingToolbarLayout, "collapsingToolbarLayout");
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(appBarConfiguration, "configuration");
        navController.addOnDestinationChangedListener(new CollapsingToolbarOnDestinationChangedListener(collapsingToolbarLayout, toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new NavigationUI$$ExternalSyntheticLambda1(navController, appBarConfiguration));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupWithNavController$lambda-2  reason: not valid java name */
    public static final void m693setupWithNavController$lambda2(NavController navController, AppBarConfiguration appBarConfiguration, View view) {
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(appBarConfiguration, "$configuration");
        navigateUp(navController, appBarConfiguration);
    }

    @JvmStatic
    public static final void setupWithNavController(NavigationView navigationView, NavController navController) {
        Intrinsics.checkNotNullParameter(navigationView, "navigationView");
        Intrinsics.checkNotNullParameter(navController, "navController");
        navigationView.setNavigationItemSelectedListener(new NavigationUI$$ExternalSyntheticLambda4(navController, navigationView));
        navController.addOnDestinationChangedListener(new NavigationUI$setupWithNavController$4(new WeakReference(navigationView), navController));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupWithNavController$lambda-3  reason: not valid java name */
    public static final boolean m694setupWithNavController$lambda3(NavController navController, NavigationView navigationView, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(navigationView, "$navigationView");
        Intrinsics.checkNotNullParameter(menuItem, "item");
        boolean onNavDestinationSelected = onNavDestinationSelected(menuItem, navController);
        if (onNavDestinationSelected) {
            ViewParent parent = navigationView.getParent();
            if (parent instanceof Openable) {
                ((Openable) parent).close();
            } else {
                BottomSheetBehavior<?> findBottomSheetBehavior = findBottomSheetBehavior(navigationView);
                if (findBottomSheetBehavior != null) {
                    findBottomSheetBehavior.setState(5);
                }
            }
        }
        return onNavDestinationSelected;
    }

    @JvmStatic
    @NavigationUiSaveStateControl
    public static final void setupWithNavController(NavigationView navigationView, NavController navController, boolean z) {
        Intrinsics.checkNotNullParameter(navigationView, "navigationView");
        Intrinsics.checkNotNullParameter(navController, "navController");
        if (!z) {
            navigationView.setNavigationItemSelectedListener(new NavigationUI$$ExternalSyntheticLambda5(navController, z, navigationView));
            navController.addOnDestinationChangedListener(new NavigationUI$setupWithNavController$7(new WeakReference(navigationView), navController));
            return;
        }
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: setupWithNavController$lambda-5  reason: not valid java name */
    public static final boolean m695setupWithNavController$lambda5(NavController navController, boolean z, NavigationView navigationView, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(navigationView, "$navigationView");
        Intrinsics.checkNotNullParameter(menuItem, "item");
        boolean onNavDestinationSelected = onNavDestinationSelected(menuItem, navController, z);
        if (onNavDestinationSelected) {
            ViewParent parent = navigationView.getParent();
            if (parent instanceof Openable) {
                ((Openable) parent).close();
            } else {
                BottomSheetBehavior<?> findBottomSheetBehavior = findBottomSheetBehavior(navigationView);
                if (findBottomSheetBehavior != null) {
                    findBottomSheetBehavior.setState(5);
                }
            }
        }
        return onNavDestinationSelected;
    }

    @JvmStatic
    public static final BottomSheetBehavior<?> findBottomSheetBehavior(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                return findBottomSheetBehavior((View) parent);
            }
            return null;
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (!(behavior instanceof BottomSheetBehavior)) {
            return null;
        }
        return (BottomSheetBehavior) behavior;
    }

    @JvmStatic
    public static final void setupWithNavController(NavigationBarView navigationBarView, NavController navController) {
        Intrinsics.checkNotNullParameter(navigationBarView, "navigationBarView");
        Intrinsics.checkNotNullParameter(navController, "navController");
        navigationBarView.setOnItemSelectedListener(new NavigationUI$$ExternalSyntheticLambda2(navController));
        navController.addOnDestinationChangedListener(new NavigationUI$setupWithNavController$9(new WeakReference(navigationBarView), navController));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupWithNavController$lambda-6  reason: not valid java name */
    public static final boolean m696setupWithNavController$lambda6(NavController navController, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(menuItem, "item");
        return onNavDestinationSelected(menuItem, navController);
    }

    @JvmStatic
    @NavigationUiSaveStateControl
    public static final void setupWithNavController(NavigationBarView navigationBarView, NavController navController, boolean z) {
        Intrinsics.checkNotNullParameter(navigationBarView, "navigationBarView");
        Intrinsics.checkNotNullParameter(navController, "navController");
        if (!z) {
            navigationBarView.setOnItemSelectedListener(new NavigationUI$$ExternalSyntheticLambda3(navController, z));
            navController.addOnDestinationChangedListener(new NavigationUI$setupWithNavController$12(new WeakReference(navigationBarView), navController));
            return;
        }
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: setupWithNavController$lambda-8  reason: not valid java name */
    public static final boolean m697setupWithNavController$lambda8(NavController navController, boolean z, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(menuItem, "item");
        return onNavDestinationSelected(menuItem, navController, z);
    }

    @JvmStatic
    public static final boolean matchDestination$navigation_ui_release(NavDestination navDestination, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        Iterator<NavDestination> it = NavDestination.Companion.getHierarchy(navDestination).iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            if (it.next().getId() == i) {
                z = true;
                continue;
            }
        } while (!z);
        return true;
    }

    @JvmStatic
    public static final boolean matchDestinations$navigation_ui_release(NavDestination navDestination, Set<Integer> set) {
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        Intrinsics.checkNotNullParameter(set, "destinationIds");
        for (NavDestination id : NavDestination.Companion.getHierarchy(navDestination)) {
            if (set.contains(Integer.valueOf(id.getId()))) {
                return true;
            }
        }
        return false;
    }
}
