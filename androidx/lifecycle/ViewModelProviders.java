package androidx.lifecycle;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

@Deprecated
public class ViewModelProviders {
    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m36of(Fragment fragment) {
        return new ViewModelProvider(fragment);
    }

    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m38of(FragmentActivity fragmentActivity) {
        return new ViewModelProvider(fragmentActivity);
    }

    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m37of(Fragment fragment, ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragment.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragment.getViewModelStore(), factory);
    }

    @Deprecated
    /* renamed from: of */
    public static ViewModelProvider m39of(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragmentActivity.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragmentActivity.getViewModelStore(), factory);
    }

    @Deprecated
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(Application application) {
            super(application);
        }
    }
}
