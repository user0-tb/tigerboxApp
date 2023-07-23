package media.tiger.tigerbox.p016ui.main;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import media.tiger.tigerbox.p016ui.TigerBoxActivity;

/* renamed from: media.tiger.tigerbox.ui.main.Hilt_MainContentActivity */
public abstract class Hilt_MainContentActivity extends TigerBoxActivity {
    private boolean injected = false;

    Hilt_MainContentActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() {
            public void onContextAvailable(Context context) {
                Hilt_MainContentActivity.this.inject();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void inject() {
        if (!this.injected) {
            this.injected = true;
            ((MainContentActivity_GeneratedInjector) ((GeneratedComponentManagerHolder) UnsafeCasts.unsafeCast(this)).generatedComponent()).injectMainContentActivity((MainContentActivity) UnsafeCasts.unsafeCast(this));
        }
    }
}
