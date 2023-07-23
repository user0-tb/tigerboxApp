package media.tiger.tigerbox.p016ui.main.miniplayer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import media.tiger.tigerbox.databinding.FragmentMiniPlayerBinding;
import media.tiger.tigerbox.p016ui.main.MainContentActivity;
import media.tiger.tigerbox.p016ui.main.MiniPlayerListener;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;

@Metadata(mo33736d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0006\u0010\u0018\u001a\u00020\fJ\b\u0010\u0019\u001a\u00020\fH\u0002J\u0006\u0010\u001a\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/miniplayer/MiniPlayerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lmedia/tiger/tigerbox/databinding/FragmentMiniPlayerBinding;", "miniPlayerViewModel", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel;", "getMiniPlayerViewModel", "()Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel;", "miniPlayerViewModel$delegate", "Lkotlin/Lazy;", "attachObservers", "", "maximizeMiniPlayer", "minimizeMiniPlayer", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOfflineModeEnabled", "showVolumeControl", "stopPlayback", "stopPlayingNonCardsProducts", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.miniplayer.MiniPlayerFragment */
/* compiled from: MiniPlayerFragment.kt */
public final class MiniPlayerFragment extends Fragment {
    private FragmentMiniPlayerBinding binding;
    private final Lazy miniPlayerViewModel$delegate;

    public MiniPlayerFragment() {
        Fragment fragment = this;
        this.miniPlayerViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(MediaPlayerViewModel.class), new MiniPlayerFragment$special$$inlined$activityViewModels$default$1(fragment), new MiniPlayerFragment$special$$inlined$activityViewModels$default$2(fragment));
    }

    private final MediaPlayerViewModel getMiniPlayerViewModel() {
        return (MediaPlayerViewModel) this.miniPlayerViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMiniPlayerBinding inflate = FragmentMiniPlayerBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type media.tiger.tigerbox.ui.main.MainContentActivity");
        inflate.setNavigateToMediaPlayer(((MainContentActivity) activity).getNavigateToMediaPlayer());
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding2 = this.binding;
        if (fragmentMiniPlayerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniPlayerBinding2 = null;
        }
        fragmentMiniPlayerBinding2.miniPlayerPlayPauseButton.setOnClickListener(new MiniPlayerFragment$$ExternalSyntheticLambda1(this));
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding3 = this.binding;
        if (fragmentMiniPlayerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniPlayerBinding3 = null;
        }
        fragmentMiniPlayerBinding3.miniPlayerVolumeButton.setOnClickListener(new MiniPlayerFragment$$ExternalSyntheticLambda0(this));
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding4 = this.binding;
        if (fragmentMiniPlayerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniPlayerBinding4 = null;
        }
        fragmentMiniPlayerBinding4.setLifecycleOwner(getViewLifecycleOwner());
        minimizeMiniPlayer();
        attachObservers();
        getMiniPlayerViewModel().registerListeners();
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding5 = this.binding;
        if (fragmentMiniPlayerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMiniPlayerBinding = fragmentMiniPlayerBinding5;
        }
        View root = fragmentMiniPlayerBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m2446onCreateView$lambda0(MiniPlayerFragment miniPlayerFragment, View view) {
        Intrinsics.checkNotNullParameter(miniPlayerFragment, "this$0");
        miniPlayerFragment.getMiniPlayerViewModel().onPlayClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m2447onCreateView$lambda1(MiniPlayerFragment miniPlayerFragment, View view) {
        Intrinsics.checkNotNullParameter(miniPlayerFragment, "this$0");
        miniPlayerFragment.showVolumeControl();
    }

    private final void showVolumeControl() {
        Context context = getContext();
        MiniPlayerListener miniPlayerListener = context instanceof MiniPlayerListener ? (MiniPlayerListener) context : null;
        if (miniPlayerListener != null) {
            miniPlayerListener.openVolumeControl();
        }
    }

    private final void attachObservers() {
        getMiniPlayerViewModel().getViewState().observe(getViewLifecycleOwner(), new MiniPlayerFragment$$ExternalSyntheticLambda3(this));
        getMiniPlayerViewModel().getPlaybackState().observe(getViewLifecycleOwner(), new MiniPlayerFragment$$ExternalSyntheticLambda2(this));
        getMiniPlayerViewModel().requestOnlyVolume();
    }

    /* access modifiers changed from: private */
    /* renamed from: attachObservers$lambda-2  reason: not valid java name */
    public static final void m2444attachObservers$lambda2(MiniPlayerFragment miniPlayerFragment, MediaPlayerViewModel.ViewState viewState) {
        Intrinsics.checkNotNullParameter(miniPlayerFragment, "this$0");
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding = null;
        if (viewState.getAudioProduct() != null) {
            FragmentMiniPlayerBinding fragmentMiniPlayerBinding2 = miniPlayerFragment.binding;
            if (fragmentMiniPlayerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniPlayerBinding2 = null;
            }
            fragmentMiniPlayerBinding2.setAudioProduct(viewState.getAudioProduct());
        }
        if (viewState.getVolumePercent() != null) {
            FragmentMiniPlayerBinding fragmentMiniPlayerBinding3 = miniPlayerFragment.binding;
            if (fragmentMiniPlayerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentMiniPlayerBinding = fragmentMiniPlayerBinding3;
            }
            fragmentMiniPlayerBinding.miniPlayerVolumeButton.setProgress(viewState.getVolumePercent().intValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: attachObservers$lambda-3  reason: not valid java name */
    public static final void m2445attachObservers$lambda3(MiniPlayerFragment miniPlayerFragment, MediaPlayerViewModel.PlaybackState playbackState) {
        Intrinsics.checkNotNullParameter(miniPlayerFragment, "this$0");
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding = null;
        if (playbackState.getPlaylistProgress() != null) {
            FragmentMiniPlayerBinding fragmentMiniPlayerBinding2 = miniPlayerFragment.binding;
            if (fragmentMiniPlayerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniPlayerBinding2 = null;
            }
            fragmentMiniPlayerBinding2.miniPlayerPlayPauseButton.setProgress(playbackState.getPlaylistProgress().intValue());
        }
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding3 = miniPlayerFragment.binding;
        if (fragmentMiniPlayerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMiniPlayerBinding = fragmentMiniPlayerBinding3;
        }
        fragmentMiniPlayerBinding.setIsPlaying(playbackState.isPlaying());
        if (playbackState.getPlaybackState() == AudioPlaybackState.STOPPED) {
            miniPlayerFragment.minimizeMiniPlayer();
        } else if (playbackState.getPlaybackState() != null) {
            miniPlayerFragment.maximizeMiniPlayer();
        }
    }

    public final void maximizeMiniPlayer() {
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding = this.binding;
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding2 = null;
        if (fragmentMiniPlayerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniPlayerBinding = null;
        }
        fragmentMiniPlayerBinding.miniPlayerContainer.setVisibility(0);
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding3 = this.binding;
        if (fragmentMiniPlayerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniPlayerBinding3 = null;
        }
        fragmentMiniPlayerBinding3.miniPlayerProductCover.setVisibility(0);
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding4 = this.binding;
        if (fragmentMiniPlayerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMiniPlayerBinding2 = fragmentMiniPlayerBinding4;
        }
        fragmentMiniPlayerBinding2.miniPlayerPlayPauseButton.setVisibility(0);
    }

    public final void minimizeMiniPlayer() {
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding = this.binding;
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding2 = null;
        if (fragmentMiniPlayerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniPlayerBinding = null;
        }
        fragmentMiniPlayerBinding.miniPlayerContainer.setVisibility(0);
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding3 = this.binding;
        if (fragmentMiniPlayerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniPlayerBinding3 = null;
        }
        fragmentMiniPlayerBinding3.miniPlayerProductCover.setVisibility(8);
        FragmentMiniPlayerBinding fragmentMiniPlayerBinding4 = this.binding;
        if (fragmentMiniPlayerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMiniPlayerBinding2 = fragmentMiniPlayerBinding4;
        }
        fragmentMiniPlayerBinding2.miniPlayerPlayPauseButton.setVisibility(8);
    }

    public final void stopPlayback() {
        getMiniPlayerViewModel().stopPlayingProduct();
    }

    public final void onOfflineModeEnabled() {
        getMiniPlayerViewModel().onOfflineModeEnabled();
    }

    public final void stopPlayingNonCardsProducts() {
        getMiniPlayerViewModel().stopPlayingNonCardsProducts();
    }

    public void onDestroy() {
        getMiniPlayerViewModel().onViewExit();
        super.onDestroy();
    }
}
