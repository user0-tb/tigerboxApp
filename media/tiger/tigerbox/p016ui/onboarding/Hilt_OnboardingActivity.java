package media.tiger.tigerbox.p016ui.onboarding;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import media.tiger.tigerbox.p016ui.TigerBoxActivity;

/* renamed from: media.tiger.tigerbox.ui.onboarding.Hilt_OnboardingActivity */
public abstract class Hilt_OnboardingActivity extends TigerBoxActivity {
    private boolean injected = false;

    Hilt_OnboardingActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() {
            public void onContextAvailable(Context context) {
                Hilt_OnboardingActivity.this.inject();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void inject() {
        if (!this.injected) {
            this.injected = true;
            ((OnboardingActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectOnboardingActivity((OnboardingActivity) UnsafeCasts.unsafeCast(this));
        }
    }
}
