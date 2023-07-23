package media.tiger.tigerbox.p016ui;

import android.content.Intent;
import android.view.MotionEvent;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import media.tiger.tigerbox.services.interfaces.NfcService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001dH\u0014J\b\u0010 \u001a\u00020\u0019H\u0014J\b\u0010!\u001a\u00020\u0019H\u0014J\b\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0019H&J\b\u0010$\u001a\u00020\u0019H\u0016J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/TigerBoxActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "canResetDevice", "", "getCanResetDevice", "()Z", "nfcService", "Lmedia/tiger/tigerbox/services/interfaces/NfcService;", "getNfcService", "()Lmedia/tiger/tigerbox/services/interfaces/NfcService;", "setNfcService", "(Lmedia/tiger/tigerbox/services/interfaces/NfcService;)V", "supportsNfc", "getSupportsNfc", "tigerBoxActivityViewModel", "Lmedia/tiger/tigerbox/ui/TigerBoxActivityViewModel;", "getTigerBoxActivityViewModel", "()Lmedia/tiger/tigerbox/ui/TigerBoxActivityViewModel;", "tigerBoxActivityViewModel$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onActivityReenter", "", "resultCode", "", "data", "Landroid/content/Intent;", "onNewIntent", "intent", "onPause", "onResume", "onTigerButtonPressed", "showHardwareSafeguardDialog", "showResetDialog", "stopOnDisplayDimWithEvent", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.TigerBoxActivity */
/* compiled from: TigerBoxActivity.kt */
public abstract class TigerBoxActivity extends Hilt_TigerBoxActivity {
    private final boolean canResetDevice;
    @Inject
    public NfcService nfcService;
    private final boolean supportsNfc;
    private final Lazy tigerBoxActivityViewModel$delegate;

    public abstract void showHardwareSafeguardDialog();

    public TigerBoxActivity() {
        ComponentActivity componentActivity = this;
        Function0 function0 = null;
        this.tigerBoxActivityViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TigerBoxActivityViewModel.class), new TigerBoxActivity$special$$inlined$viewModels$default$2(componentActivity), new TigerBoxActivity$special$$inlined$viewModels$default$1(componentActivity));
    }

    public final NfcService getNfcService() {
        NfcService nfcService2 = this.nfcService;
        if (nfcService2 != null) {
            return nfcService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nfcService");
        return null;
    }

    public final void setNfcService(NfcService nfcService2) {
        Intrinsics.checkNotNullParameter(nfcService2, "<set-?>");
        this.nfcService = nfcService2;
    }

    private final TigerBoxActivityViewModel getTigerBoxActivityViewModel() {
        return (TigerBoxActivityViewModel) this.tigerBoxActivityViewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (getSupportsNfc()) {
            getNfcService().enableForegroundDispatch(this);
        }
        getTigerBoxActivityViewModel().viewEntered();
        LifecycleOwner lifecycleOwner = this;
        getTigerBoxActivityViewModel().getSafeguardHardwareErrorEvent().observe(lifecycleOwner, new TigerBoxActivity$$ExternalSyntheticLambda2(this));
        getTigerBoxActivityViewModel().checkSafeguardHardware();
        getTigerBoxActivityViewModel().getResetButtonLongPressedEvent().observe(lifecycleOwner, new TigerBoxActivity$$ExternalSyntheticLambda0(this));
        getTigerBoxActivityViewModel().getTigerButtonPressedEvent().observe(lifecycleOwner, new TigerBoxActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-0  reason: not valid java name */
    public static final void m2355onResume$lambda0(TigerBoxActivity tigerBoxActivity, Unit unit) {
        Intrinsics.checkNotNullParameter(tigerBoxActivity, "this$0");
        tigerBoxActivity.showHardwareSafeguardDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-1  reason: not valid java name */
    public static final void m2356onResume$lambda1(TigerBoxActivity tigerBoxActivity, Unit unit) {
        Intrinsics.checkNotNullParameter(tigerBoxActivity, "this$0");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("TigerBoxActivity did receive reset event. canResetDevice: " + tigerBoxActivity.getCanResetDevice(), new Object[0]);
        if (tigerBoxActivity.getCanResetDevice()) {
            tigerBoxActivity.showResetDialog();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-2  reason: not valid java name */
    public static final void m2357onResume$lambda2(TigerBoxActivity tigerBoxActivity, Unit unit) {
        Intrinsics.checkNotNullParameter(tigerBoxActivity, "this$0");
        tigerBoxActivity.onTigerButtonPressed();
    }

    public boolean getCanResetDevice() {
        return this.canResetDevice;
    }

    public void showResetDialog() {
        Timber.Forest forest = Timber.Forest;
        forest.mo50217e("ShowResetDialog not overwritten by activity " + this, new Object[0]);
    }

    public void onTigerButtonPressed() {
        sendBroadcast(new Intent(TigerBoxIntentActions.ACTION_GO_TO_SLEEP));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        getTigerBoxActivityViewModel().viewExited();
        super.onPause();
    }

    public final boolean stopOnDisplayDimWithEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 0) {
            return false;
        }
        if (getTigerBoxActivityViewModel().isDisplayStateDim() || getTigerBoxActivityViewModel().isDisplayStateOff()) {
            return true;
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (stopOnDisplayDimWithEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onActivityReenter(int i, Intent intent) {
        super.onActivityReenter(i, intent);
    }

    public boolean getSupportsNfc() {
        return this.supportsNfc;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("onNewIntent " + this + " intent " + intent, new Object[0]);
        super.onNewIntent(intent);
        setIntent(intent);
        if (getSupportsNfc()) {
            getNfcService().parseIntent(intent);
        }
    }
}
