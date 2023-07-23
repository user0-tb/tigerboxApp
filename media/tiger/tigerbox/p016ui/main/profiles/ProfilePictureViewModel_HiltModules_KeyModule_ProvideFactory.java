package media.tiger.tigerbox.p016ui.main.profiles;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilePictureViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel_HiltModules_KeyModule_ProvideFactory */
public final class ProfilePictureViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static ProfilePictureViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(ProfilePictureViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ProfilePictureViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ProfilePictureViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
