package media.tiger.tigerbox.p016ui.main.maincontent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import media.tiger.tigerbox.p016ui.main.MainContentHeaderListener;
import media.tiger.tigerbox.p016ui.main.MiniPlayerListener;
import media.tiger.tigerbox.p016ui.main.OfflineModeListener;
import media.tiger.tigerbox.p016ui.main.ProgressBarListener;
import media.tiger.tigerbox.services.implementations.timersController.LockedModeReason;
import org.spongycastle.i18n.MessageBundle;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0004J\b\u0010\u000f\u001a\u00020\fH\u0004J\b\u0010\u0010\u001a\u00020\fH\u0004J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0004J\b\u0010\u0014\u001a\u00020\fH\u0004J\b\u0010\u0015\u001a\u00020\fH\u0004J\b\u0010\u0016\u001a\u00020\fH\u0004J\b\u0010\u0017\u001a\u00020\fH\u0004J\b\u0010\u0018\u001a\u00020\fH\u0004J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0004J\b\u0010\u001d\u001a\u00020\fH\u0004J\b\u0010\u001e\u001a\u00020\fH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/MainContentFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mainContentHeaderListener", "Lmedia/tiger/tigerbox/ui/main/MainContentHeaderListener;", "miniPlayerListener", "Lmedia/tiger/tigerbox/ui/main/MiniPlayerListener;", "offlineModeListener", "Lmedia/tiger/tigerbox/ui/main/OfflineModeListener;", "progressBarListener", "Lmedia/tiger/tigerbox/ui/main/ProgressBarListener;", "changeHeaderTitle", "", "title", "", "disableLockScreen", "disableOffline", "enableLockScreen", "reason", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "enableOffline", "hideHeaderCloseButton", "hideMultiProductListInCardsMode", "hideProgressBar", "maximizeMiniPlayer", "onAttach", "context", "Landroid/content/Context;", "showHeaderCloseButton", "showMultiProductListInCardsMode", "showProgressBar", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.MainContentFragment */
/* compiled from: MainContentFragment.kt */
public abstract class MainContentFragment extends Fragment {
    private MainContentHeaderListener mainContentHeaderListener;
    private MiniPlayerListener miniPlayerListener;
    private OfflineModeListener offlineModeListener;
    private ProgressBarListener progressBarListener;

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            this.progressBarListener = (ProgressBarListener) context;
            this.mainContentHeaderListener = (MainContentHeaderListener) context;
            this.miniPlayerListener = (MiniPlayerListener) context;
            this.offlineModeListener = (OfflineModeListener) context;
        } catch (ClassCastException unused) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("MainContentFragment: onAttach: This activity does not implement " + Reflection.getOrCreateKotlinClass(ProgressBarListener.class).getSimpleName() + " or " + Reflection.getOrCreateKotlinClass(MainContentHeaderListener.class).getSimpleName() + " or " + Reflection.getOrCreateKotlinClass(MiniPlayerListener.class).getSimpleName() + " or " + Reflection.getOrCreateKotlinClass(OfflineModeListener.class).getSimpleName(), new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public final void hideProgressBar() {
        ProgressBarListener progressBarListener2 = this.progressBarListener;
        if (progressBarListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBarListener");
            progressBarListener2 = null;
        }
        progressBarListener2.hideProgressBar();
    }

    /* access modifiers changed from: protected */
    public final void showProgressBar() {
        ProgressBarListener progressBarListener2 = this.progressBarListener;
        if (progressBarListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBarListener");
            progressBarListener2 = null;
        }
        progressBarListener2.showProgressBar();
    }

    /* access modifiers changed from: protected */
    public final void showHeaderCloseButton() {
        MainContentHeaderListener mainContentHeaderListener2 = this.mainContentHeaderListener;
        if (mainContentHeaderListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentHeaderListener");
            mainContentHeaderListener2 = null;
        }
        mainContentHeaderListener2.showHeaderCloseButton();
    }

    /* access modifiers changed from: protected */
    public final void hideHeaderCloseButton() {
        MainContentHeaderListener mainContentHeaderListener2 = this.mainContentHeaderListener;
        if (mainContentHeaderListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentHeaderListener");
            mainContentHeaderListener2 = null;
        }
        mainContentHeaderListener2.hideHeaderCloseButton();
    }

    /* access modifiers changed from: protected */
    public final void changeHeaderTitle(String str) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        MainContentHeaderListener mainContentHeaderListener2 = this.mainContentHeaderListener;
        if (mainContentHeaderListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentHeaderListener");
            mainContentHeaderListener2 = null;
        }
        mainContentHeaderListener2.changeHeaderTitle(str);
    }

    /* access modifiers changed from: protected */
    public final void showMultiProductListInCardsMode() {
        MainContentHeaderListener mainContentHeaderListener2 = this.mainContentHeaderListener;
        if (mainContentHeaderListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentHeaderListener");
            mainContentHeaderListener2 = null;
        }
        mainContentHeaderListener2.showMultiProductListInCardsMode();
    }

    /* access modifiers changed from: protected */
    public final void hideMultiProductListInCardsMode() {
        MainContentHeaderListener mainContentHeaderListener2 = this.mainContentHeaderListener;
        if (mainContentHeaderListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentHeaderListener");
            mainContentHeaderListener2 = null;
        }
        mainContentHeaderListener2.hideMultiProductListInCardsMode();
    }

    /* access modifiers changed from: protected */
    public final void enableLockScreen(LockedModeReason lockedModeReason) {
        Intrinsics.checkNotNullParameter(lockedModeReason, "reason");
        MainContentHeaderListener mainContentHeaderListener2 = this.mainContentHeaderListener;
        if (mainContentHeaderListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentHeaderListener");
            mainContentHeaderListener2 = null;
        }
        mainContentHeaderListener2.enableLockScreen(lockedModeReason);
    }

    /* access modifiers changed from: protected */
    public final void disableLockScreen() {
        MainContentHeaderListener mainContentHeaderListener2 = this.mainContentHeaderListener;
        if (mainContentHeaderListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentHeaderListener");
            mainContentHeaderListener2 = null;
        }
        mainContentHeaderListener2.disableLockScreen();
    }

    /* access modifiers changed from: protected */
    public final void enableOffline() {
        Timber.Forest.mo50221i("MainContentFragment enableOffline", new Object[0]);
        OfflineModeListener offlineModeListener2 = this.offlineModeListener;
        OfflineModeListener offlineModeListener3 = null;
        if (offlineModeListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineModeListener");
            offlineModeListener2 = null;
        }
        offlineModeListener2.enableOfflineMode();
        OfflineModeListener offlineModeListener4 = this.offlineModeListener;
        if (offlineModeListener4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineModeListener");
        } else {
            offlineModeListener3 = offlineModeListener4;
        }
        offlineModeListener3.onOfflineModeEnabled();
    }

    /* access modifiers changed from: protected */
    public final void disableOffline() {
        OfflineModeListener offlineModeListener2 = this.offlineModeListener;
        if (offlineModeListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineModeListener");
            offlineModeListener2 = null;
        }
        offlineModeListener2.disableOfflineMode();
    }

    /* access modifiers changed from: protected */
    public final void maximizeMiniPlayer() {
        MiniPlayerListener miniPlayerListener2 = this.miniPlayerListener;
        if (miniPlayerListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniPlayerListener");
            miniPlayerListener2 = null;
        }
        miniPlayerListener2.maximizeMiniPlayer();
    }
}
