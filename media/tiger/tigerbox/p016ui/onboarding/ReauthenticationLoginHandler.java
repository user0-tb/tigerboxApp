package media.tiger.tigerbox.p016ui.onboarding;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/ReauthenticationLoginHandler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "showLogin", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.ReauthenticationLoginHandler */
/* compiled from: ReauthenticationLoginHandler.kt */
public final class ReauthenticationLoginHandler {
    private final Context context;

    public ReauthenticationLoginHandler(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final void showLogin() {
        OnboardingActivity.Companion.showLogin(this.context);
    }
}
