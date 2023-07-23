package media.tiger.tigerbox.p016ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelLazy;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import media.tiger.tigerbox.databinding.ActivityStartupAnimationBinding;
import media.tiger.tigerbox.infrastructure.interactor.EventObserver;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u0002"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/LauncherActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lmedia/tiger/tigerbox/databinding/ActivityStartupAnimationBinding;", "infoSoundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "getInfoSoundService", "()Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "setInfoSoundService", "(Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;)V", "checkIfAnimationDone", "", "anim", "Landroid/graphics/drawable/AnimationDrawable;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_tigerBoxRelease", "viewModel", "Lmedia/tiger/tigerbox/ui/LaunchViewModel;"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.LauncherActivity */
/* compiled from: LauncherActivity.kt */
public final class LauncherActivity extends Hilt_LauncherActivity {
    private ActivityStartupAnimationBinding binding;
    @Inject
    public InfoSoundService infoSoundService;

    public final InfoSoundService getInfoSoundService() {
        InfoSoundService infoSoundService2 = this.infoSoundService;
        if (infoSoundService2 != null) {
            return infoSoundService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoSoundService");
        return null;
    }

    public final void setInfoSoundService(InfoSoundService infoSoundService2) {
        Intrinsics.checkNotNullParameter(infoSoundService2, "<set-?>");
        this.infoSoundService = infoSoundService2;
    }

    /* JADX WARNING: type inference failed for: r4v10, types: [android.graphics.drawable.Drawable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            super.onCreate(r4)
            android.view.LayoutInflater r4 = r3.getLayoutInflater()
            media.tiger.tigerbox.databinding.ActivityStartupAnimationBinding r4 = media.tiger.tigerbox.databinding.ActivityStartupAnimationBinding.inflate(r4)
            java.lang.String r0 = "inflate(layoutInflater)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.binding = r4
            java.lang.String r0 = "binding"
            r1 = 0
            if (r4 != 0) goto L_0x001b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r4 = r1
        L_0x001b:
            android.widget.RelativeLayout r4 = r4.getRoot()
            android.view.View r4 = (android.view.View) r4
            r3.setContentView((android.view.View) r4)
            java.lang.String r4 = "LauncherActivity"
            java.lang.String r2 = "onCreate.........................."
            android.util.Log.e(r4, r2)
            media.tiger.tigerbox.databinding.ActivityStartupAnimationBinding r4 = r3.binding
            if (r4 != 0) goto L_0x0033
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r4 = r1
        L_0x0033:
            android.widget.ImageView r4 = r4.tigerboxTextAnimation
            android.graphics.drawable.Drawable r4 = r4.getBackground()
            boolean r0 = r4 instanceof android.graphics.drawable.AnimationDrawable
            if (r0 == 0) goto L_0x0040
            r1 = r4
            android.graphics.drawable.AnimationDrawable r1 = (android.graphics.drawable.AnimationDrawable) r1
        L_0x0040:
            if (r1 == 0) goto L_0x0051
            r3.checkIfAnimationDone(r1)
            media.tiger.tigerbox.services.interfaces.InfoSoundService r4 = r3.getInfoSoundService()
            media.tiger.tigerbox.services.interfaces.InfoSoundService$SoundType r0 = media.tiger.tigerbox.services.interfaces.InfoSoundService.SoundType.SWITCH_ON
            r4.playSound(r0)
            r1.start()
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.LauncherActivity.onCreate(android.os.Bundle):void");
    }

    private final void checkIfAnimationDone(AnimationDrawable animationDrawable) {
        new Handler().postDelayed(new LauncherActivity$$ExternalSyntheticLambda0(animationDrawable, this), 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: checkIfAnimationDone$lambda-2  reason: not valid java name */
    public static final void m2352checkIfAnimationDone$lambda2(AnimationDrawable animationDrawable, LauncherActivity launcherActivity) {
        Intrinsics.checkNotNullParameter(animationDrawable, "$anim");
        Intrinsics.checkNotNullParameter(launcherActivity, "this$0");
        if (animationDrawable.getCurrent() != animationDrawable.getFrame(animationDrawable.getNumberOfFrames() - 1)) {
            launcherActivity.checkIfAnimationDone(animationDrawable);
            return;
        }
        ComponentActivity componentActivity = launcherActivity;
        Function0 function0 = null;
        m2353checkIfAnimationDone$lambda2$lambda1(new ViewModelLazy(Reflection.getOrCreateKotlinClass(LaunchViewModel.class), new C2921xb9addbcd(componentActivity), new C2920xb9addbcc(componentActivity))).getLaunchDestination().observe(launcherActivity, new EventObserver(new LauncherActivity$checkIfAnimationDone$1$1(launcherActivity)));
    }

    /* renamed from: checkIfAnimationDone$lambda-2$lambda-1  reason: not valid java name */
    private static final LaunchViewModel m2353checkIfAnimationDone$lambda2$lambda1(Lazy<LaunchViewModel> lazy) {
        return lazy.getValue();
    }
}
