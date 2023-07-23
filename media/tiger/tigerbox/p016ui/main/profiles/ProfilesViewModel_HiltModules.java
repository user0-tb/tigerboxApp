package media.tiger.tigerbox.p016ui.main.profiles;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel_HiltModules */
public final class ProfilesViewModel_HiltModules {
    private ProfilesViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel")
        @IntoMap
        public abstract ViewModel binds(ProfilesViewModel profilesViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel";
        }

        private KeyModule() {
        }
    }
}
