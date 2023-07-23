package media.tiger.tigerbox.p016ui.main.mediaplayer;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.ChapterListViewModel_MembersInjector */
public final class ChapterListViewModel_MembersInjector implements MembersInjector<ChapterListViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public ChapterListViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<ChapterListViewModel> create(Provider<LightControlService> provider) {
        return new ChapterListViewModel_MembersInjector(provider);
    }

    public void injectMembers(ChapterListViewModel chapterListViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(chapterListViewModel, this._lightControlProvider.get());
    }
}
