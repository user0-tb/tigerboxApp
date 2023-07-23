package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class NavController$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ NavController f$0;

    public /* synthetic */ NavController$$ExternalSyntheticLambda0(NavController navController) {
        this.f$0 = navController;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        NavController.m680lifecycleObserver$lambda2(this.f$0, lifecycleOwner, event);
    }
}
