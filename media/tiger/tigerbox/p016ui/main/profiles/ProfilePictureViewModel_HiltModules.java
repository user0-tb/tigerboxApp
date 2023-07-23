package media.tiger.tigerbox.p016ui.main.profiles;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel_HiltModules */
public final class ProfilePictureViewModel_HiltModules {
    private ProfilePictureViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel")
        @IntoMap
        public abstract ViewModel binds(ProfilePictureViewModel profilePictureViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel";
        }

        private KeyModule() {
        }
    }
}
