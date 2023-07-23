package media.tiger.tigerbox.p016ui.common.reset;

import androidx.lifecycle.ViewModelKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/reset/ResetInProgressViewModel;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "soundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;)V", "resetConfirmed", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.reset.ResetInProgressViewModel */
/* compiled from: ResetInProgressViewModel.kt */
public final class ResetInProgressViewModel extends DialogViewModel {
    /* access modifiers changed from: private */
    public final MetaDataService metaDataService;
    private final InfoSoundService soundService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ResetInProgressViewModel(ButtonService buttonService, MetaDataService metaDataService2, InfoSoundService infoSoundService) {
        super(buttonService);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(infoSoundService, "soundService");
        this.metaDataService = metaDataService2;
        this.soundService = infoSoundService;
    }

    public final void resetConfirmed() {
        this.soundService.playSound(InfoSoundService.SoundType.USER_RESET_WAIT);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ResetInProgressViewModel$resetConfirmed$1(this, (Continuation<? super ResetInProgressViewModel$resetConfirmed$1>) null), 3, (Object) null);
    }
}
