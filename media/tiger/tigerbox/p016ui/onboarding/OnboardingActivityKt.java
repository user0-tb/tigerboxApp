package media.tiger.tigerbox.p016ui.onboarding;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo33737d2 = {"navigateActionSafe", "", "Landroidx/navigation/NavController;", "direction", "Landroidx/navigation/NavDirections;", "resId", "", "args", "Landroid/os/Bundle;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.OnboardingActivityKt */
/* compiled from: OnboardingActivity.kt */
public final class OnboardingActivityKt {
    public static /* synthetic */ void navigateActionSafe$default(NavController navController, int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        navigateActionSafe(navController, i, bundle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getAction(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void navigateActionSafe(androidx.navigation.NavController r3, int r4, android.os.Bundle r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.navigation.NavDestination r0 = r3.getCurrentDestination()
            if (r0 == 0) goto L_0x0016
            androidx.navigation.NavAction r0 = r0.getAction(r4)
            if (r0 == 0) goto L_0x0016
            int r0 = r0.getDestinationId()
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            kotlin.collections.ArrayDeque r1 = r3.getBackQueue()
            java.lang.Object r1 = r1.last()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
            int r1 = r1.getId()
            if (r1 != r0) goto L_0x002c
            return
        L_0x002c:
            androidx.navigation.NavDestination r1 = r3.getCurrentDestination()
            if (r1 == 0) goto L_0x004a
            boolean r2 = r1 instanceof androidx.navigation.NavGraph
            if (r2 == 0) goto L_0x0039
            androidx.navigation.NavGraph r1 = (androidx.navigation.NavGraph) r1
            goto L_0x003d
        L_0x0039:
            androidx.navigation.NavGraph r1 = r1.getParent()
        L_0x003d:
            if (r0 == 0) goto L_0x004a
            if (r1 == 0) goto L_0x004a
            androidx.navigation.NavDestination r0 = r1.findNode((int) r0)
            if (r0 == 0) goto L_0x004a
            r3.navigate((int) r4, (android.os.Bundle) r5)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt.navigateActionSafe(androidx.navigation.NavController, int, android.os.Bundle):void");
    }

    public static final void navigateActionSafe(NavController navController, NavDirections navDirections) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        Intrinsics.checkNotNullParameter(navDirections, "direction");
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination != null && currentDestination.getAction(navDirections.getActionId()) != null) {
            navController.navigate(navDirections);
        }
    }
}
