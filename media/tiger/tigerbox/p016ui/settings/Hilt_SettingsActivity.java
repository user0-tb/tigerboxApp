package media.tiger.tigerbox.p016ui.settings;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import media.tiger.tigerbox.p016ui.TigerBoxActivity;

/* renamed from: media.tiger.tigerbox.ui.settings.Hilt_SettingsActivity */
public abstract class Hilt_SettingsActivity extends TigerBoxActivity {
    private boolean injected = false;

    Hilt_SettingsActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() {
            public void onContextAvailable(Context context) {
                Hilt_SettingsActivity.this.inject();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void inject() {
        if (!this.injected) {
            this.injected = true;
            ((SettingsActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectSettingsActivity((SettingsActivity) UnsafeCasts.unsafeCast(this));
        }
    }
}
