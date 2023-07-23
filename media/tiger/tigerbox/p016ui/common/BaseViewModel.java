package media.tiger.tigerbox.p016ui.common;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEvent;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEventKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0005H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_failure", "Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "_lightControl", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "get_lightControl", "()Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "set_lightControl", "(Lmedia/tiger/tigerbox/services/interfaces/LightControlService;)V", "failure", "Landroidx/lifecycle/LiveData;", "getFailure", "()Landroidx/lifecycle/LiveData;", "handleFailure", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.BaseViewModel */
/* compiled from: BaseViewModel.kt */
public class BaseViewModel extends ViewModel {
    private final SingleLiveEvent<Failure> _failure;
    @Inject
    public LightControlService _lightControl;
    private final LiveData<Failure> failure;

    @Inject
    public BaseViewModel() {
        SingleLiveEvent<Failure> singleLiveEvent = new SingleLiveEvent<>();
        this._failure = singleLiveEvent;
        this.failure = singleLiveEvent;
    }

    public final LightControlService get_lightControl() {
        LightControlService lightControlService = this._lightControl;
        if (lightControlService != null) {
            return lightControlService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_lightControl");
        return null;
    }

    public final void set_lightControl(LightControlService lightControlService) {
        Intrinsics.checkNotNullParameter(lightControlService, "<set-?>");
        this._lightControl = lightControlService;
    }

    public final LiveData<Failure> getFailure() {
        return this.failure;
    }

    /* access modifiers changed from: protected */
    public void handleFailure(Failure failure2) {
        Intrinsics.checkNotNullParameter(failure2, "failure");
        Timber.Forest forest = Timber.Forest;
        forest.mo50217e("BaseViewModel: Failure: " + failure2, new Object[0]);
        this._failure.postValue(failure2);
        get_lightControl().addTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.ERROR));
    }
}
