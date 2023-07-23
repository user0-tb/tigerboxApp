package media.tiger.tigerbox.p016ui.main.mediaplayer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import androidx.core.content.ContextCompat;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentMediaPlayerBinding;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;
import media.tiger.tigerbox.databinding.IncludePlayerDeviceControlsBinding;
import media.tiger.tigerbox.databinding.IncludePlayerTrackControlsBinding;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.exception.MediaPlayerFailure;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.main.MiniPlayerListener;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.p016ui.settings.SeekBarDialogType;
import media.tiger.tigerbox.p016ui.view.CircleProgressImageView;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;
import media.tiger.tigerbox.utils.RotateDrawableAnimator;
import timber.log.Timber;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020:H\u0002J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020:H\u0002J\u0010\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020FH\u0002J$\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020:H\u0016J\b\u0010P\u001a\u00020:H\u0016J\u001a\u0010Q\u001a\u00020:2\u0006\u0010R\u001a\u00020H2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010S\u001a\u00020:H\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b\u001f\u0010\u001cR\u001b\u0010!\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b\"\u0010\u001cR\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b*\u0010\u0017R\u001b\u0010,\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b5\u0010\u0013\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b8\u0010\u0013\u001a\u0004\b7\u0010\u0017¨\u0006T"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "bufferingAnimator", "Lmedia/tiger/tigerbox/utils/RotateDrawableAnimator;", "mediaPlayerDeviceControls", "Lmedia/tiger/tigerbox/databinding/IncludePlayerDeviceControlsBinding;", "getMediaPlayerDeviceControls", "()Lmedia/tiger/tigerbox/databinding/IncludePlayerDeviceControlsBinding;", "mediaPlayerDeviceControls$delegate", "Lkotlin/Lazy;", "mediaPlayerLightControl", "Lmedia/tiger/tigerbox/ui/view/CircleProgressImageView;", "getMediaPlayerLightControl", "()Lmedia/tiger/tigerbox/ui/view/CircleProgressImageView;", "mediaPlayerLightControl$delegate", "mediaPlayerNextButton", "Landroid/widget/ImageButton;", "getMediaPlayerNextButton", "()Landroid/widget/ImageButton;", "mediaPlayerNextButton$delegate", "mediaPlayerPlayButton", "getMediaPlayerPlayButton", "mediaPlayerPlayButton$delegate", "mediaPlayerPreviousButton", "getMediaPlayerPreviousButton", "mediaPlayerPreviousButton$delegate", "mediaPlayerProgressSeekBar", "Landroid/widget/SeekBar;", "getMediaPlayerProgressSeekBar", "()Landroid/widget/SeekBar;", "mediaPlayerProgressSeekBar$delegate", "mediaPlayerTrackControl", "getMediaPlayerTrackControl", "mediaPlayerTrackControl$delegate", "mediaPlayerTrackControls", "Lmedia/tiger/tigerbox/databinding/IncludePlayerTrackControlsBinding;", "getMediaPlayerTrackControls", "()Lmedia/tiger/tigerbox/databinding/IncludePlayerTrackControlsBinding;", "mediaPlayerTrackControls$delegate", "mediaPlayerViewModel", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel;", "getMediaPlayerViewModel", "()Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerViewModel;", "mediaPlayerViewModel$delegate", "mediaPlayerVolumeControl", "getMediaPlayerVolumeControl", "mediaPlayerVolumeControl$delegate", "attachControlListeners", "", "attachObservers", "getHeaderBinding", "Lmedia/tiger/tigerbox/databinding/IncludeDialogHeaderBarBinding;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "handleFailure", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "navigateToChapterList", "navigateToFullScreenCover", "imageUrl", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStop", "onViewCreated", "view", "showVolumeControl", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFragment */
/* compiled from: MediaPlayerFragment.kt */
public final class MediaPlayerFragment extends Hilt_MediaPlayerFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MediaPlayerFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private RotateDrawableAnimator bufferingAnimator;
    private final Lazy mediaPlayerDeviceControls$delegate = LazyKt.lazy(new MediaPlayerFragment$mediaPlayerDeviceControls$2(this));
    private final Lazy mediaPlayerLightControl$delegate = LazyKt.lazy(new MediaPlayerFragment$mediaPlayerLightControl$2(this));
    private final Lazy mediaPlayerNextButton$delegate = LazyKt.lazy(new MediaPlayerFragment$mediaPlayerNextButton$2(this));
    private final Lazy mediaPlayerPlayButton$delegate = LazyKt.lazy(new MediaPlayerFragment$mediaPlayerPlayButton$2(this));
    private final Lazy mediaPlayerPreviousButton$delegate = LazyKt.lazy(new MediaPlayerFragment$mediaPlayerPreviousButton$2(this));
    private final Lazy mediaPlayerProgressSeekBar$delegate = LazyKt.lazy(new MediaPlayerFragment$mediaPlayerProgressSeekBar$2(this));
    private final Lazy mediaPlayerTrackControl$delegate = LazyKt.lazy(new MediaPlayerFragment$mediaPlayerTrackControl$2(this));
    private final Lazy mediaPlayerTrackControls$delegate = LazyKt.lazy(new MediaPlayerFragment$mediaPlayerTrackControls$2(this));
    private final Lazy mediaPlayerViewModel$delegate;
    private final Lazy mediaPlayerVolumeControl$delegate = LazyKt.lazy(new MediaPlayerFragment$mediaPlayerVolumeControl$2(this));

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFragment$WhenMappings */
    /* compiled from: MediaPlayerFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudioPlaybackState.values().length];
            iArr[AudioPlaybackState.ERROR.ordinal()] = 1;
            iArr[AudioPlaybackState.PREPARING.ordinal()] = 2;
            iArr[AudioPlaybackState.BUFFERING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MediaPlayerFragment() {
        Fragment fragment = this;
        this.mediaPlayerViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(MediaPlayerViewModel.class), new C2970xce135dab(fragment), new C2971xce135dac(fragment));
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
    }

    /* access modifiers changed from: private */
    public final MediaPlayerViewModel getMediaPlayerViewModel() {
        return (MediaPlayerViewModel) this.mediaPlayerViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FragmentMediaPlayerBinding getBinding() {
        return (FragmentMediaPlayerBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentMediaPlayerBinding fragmentMediaPlayerBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentMediaPlayerBinding);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMediaPlayerBinding inflate = FragmentMediaPlayerBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().setLifecycleOwner(getViewLifecycleOwner());
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        attachObservers();
        attachControlListeners();
    }

    public void onStop() {
        DialogViewModel viewModel = getViewModel();
        FullScreenViewModel fullScreenViewModel = viewModel instanceof FullScreenViewModel ? (FullScreenViewModel) viewModel : null;
        if (fullScreenViewModel != null) {
            fullScreenViewModel.getHeaderProvider().getMediaPlayerOpened().setValue(false);
        }
        super.onStop();
    }

    public void onResume() {
        super.onResume();
        DialogViewModel viewModel = getViewModel();
        FullScreenViewModel fullScreenViewModel = viewModel instanceof FullScreenViewModel ? (FullScreenViewModel) viewModel : null;
        if (fullScreenViewModel != null) {
            fullScreenViewModel.getHeaderProvider().getMediaPlayerOpened().setValue(true);
        }
    }

    public DialogViewModel getViewModel() {
        return getMediaPlayerViewModel();
    }

    public IncludeDialogHeaderBarBinding getHeaderBinding() {
        IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding = getBinding().fragmentHeaderBar;
        Intrinsics.checkNotNullExpressionValue(includeDialogHeaderBarBinding, "binding.fragmentHeaderBar");
        return includeDialogHeaderBarBinding;
    }

    private final void handleFailure(Failure failure) {
        InfoDialogType infoDialogType;
        Timber.Tree tag = Timber.Forest.tag("MediaPlayerFragment");
        tag.mo50214d("handleFailure: " + failure, new Object[0]);
        if (failure instanceof MediaPlayerFailure.ProductAcquisitionAccessFailure) {
            infoDialogType = InfoDialogType.ACCESS_FAILURE;
        } else {
            infoDialogType = InfoDialogType.GENERAL_ERROR;
        }
        FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType)), NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), (int) C2814R.C2817id.mainContentProductList, false, false, 4, (Object) null).build());
    }

    private final void attachObservers() {
        getMediaPlayerViewModel().getFailure().observe(getViewLifecycleOwner(), new MediaPlayerFragment$$ExternalSyntheticLambda6(this));
        getMediaPlayerViewModel().getViewState().observe(getViewLifecycleOwner(), new MediaPlayerFragment$$ExternalSyntheticLambda8(this));
        getMediaPlayerViewModel().getPlaybackState().observe(getViewLifecycleOwner(), new MediaPlayerFragment$$ExternalSyntheticLambda7(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: attachObservers$lambda-2  reason: not valid java name */
    public static final void m2438attachObservers$lambda2(MediaPlayerFragment mediaPlayerFragment, Failure failure) {
        Intrinsics.checkNotNullParameter(mediaPlayerFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(failure, "it");
        mediaPlayerFragment.handleFailure(failure);
    }

    /* access modifiers changed from: private */
    /* renamed from: attachObservers$lambda-4  reason: not valid java name */
    public static final void m2439attachObservers$lambda4(MediaPlayerFragment mediaPlayerFragment, MediaPlayerViewModel.ViewState viewState) {
        Context context;
        Intrinsics.checkNotNullParameter(mediaPlayerFragment, "this$0");
        if (viewState.getAudioProduct() != null) {
            mediaPlayerFragment.getBinding().mediaPlayerContent.mediaPlayerProduct.setAudioProduct(viewState.getAudioProduct());
        }
        if (viewState.getLightOn() != null) {
            mediaPlayerFragment.getBinding().mediaPlayerContent.mediaPlayerControls.mediaPlayerControlsDeviceControls.setLightControlEnabled(viewState.getLightOn());
        }
        if (!(viewState.getLightOn() == null || (context = mediaPlayerFragment.getContext()) == null)) {
            if (viewState.getLightOn().booleanValue()) {
                mediaPlayerFragment.getMediaPlayerLightControl().setColorFilter(ContextCompat.getColor(context, C2814R.C2815color.main_theme_color));
            } else {
                mediaPlayerFragment.getMediaPlayerLightControl().setColorFilter(ContextCompat.getColor(context, C2814R.C2815color.white));
            }
        }
        if (viewState.getVolumePercent() != null) {
            mediaPlayerFragment.getMediaPlayerVolumeControl().setProgress(viewState.getVolumePercent().intValue());
        }
        if (viewState.getLightPercent() != null) {
            mediaPlayerFragment.getMediaPlayerLightControl().setProgress(viewState.getLightPercent().intValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: attachObservers$lambda-7  reason: not valid java name */
    public static final void m2440attachObservers$lambda7(MediaPlayerFragment mediaPlayerFragment, MediaPlayerViewModel.PlaybackState playbackState) {
        Intrinsics.checkNotNullParameter(mediaPlayerFragment, "this$0");
        if (playbackState.getPlaybackState() == AudioPlaybackState.STOPPED) {
            Fragment fragment = mediaPlayerFragment;
            if (Intrinsics.areEqual((Object) FragmentKt.findNavController(fragment).getBackQueue().last().getDestination(), (Object) FragmentKt.findNavController(fragment).findDestination((int) C2814R.C2817id.mainContentMediaPlayer))) {
                mediaPlayerFragment.closeSafely();
            }
        }
        mediaPlayerFragment.getMediaPlayerNextButton().setEnabled(playbackState.getHasNext());
        mediaPlayerFragment.getMediaPlayerNextButton().setClickable(playbackState.getHasNext());
        float f = 1.0f;
        mediaPlayerFragment.getMediaPlayerNextButton().setAlpha(playbackState.getHasNext() ? 1.0f : 0.4f);
        mediaPlayerFragment.getMediaPlayerPreviousButton().setEnabled(playbackState.getHasPrevious());
        mediaPlayerFragment.getMediaPlayerPreviousButton().setClickable(playbackState.getHasPrevious());
        ImageButton mediaPlayerPreviousButton = mediaPlayerFragment.getMediaPlayerPreviousButton();
        if (!playbackState.getHasPrevious()) {
            f = 0.4f;
        }
        mediaPlayerPreviousButton.setAlpha(f);
        if (playbackState.isPlaying() != null) {
            mediaPlayerFragment.getMediaPlayerTrackControls().setPlaying(playbackState.isPlaying());
        }
        if (playbackState.getCurrentTrackIndex() != null) {
            mediaPlayerFragment.getMediaPlayerTrackControl().setText(String.valueOf(playbackState.getCurrentTrackIndex()));
        }
        if (playbackState.getTrackProgress() != null) {
            mediaPlayerFragment.getBinding().mediaPlayerContent.setTrackProgress(playbackState.getTrackProgress().intValue());
        }
        if (playbackState.getCurrentTrackPosition() != null) {
            mediaPlayerFragment.getBinding().mediaPlayerContent.setTrackPosition(playbackState.getCurrentTrackPosition().longValue());
        }
        if (playbackState.getCurrentTrackRemaining() != null) {
            mediaPlayerFragment.getBinding().mediaPlayerContent.setTrackRemaining(playbackState.getCurrentTrackRemaining().longValue());
        }
        if (playbackState.isPlaying() != null) {
            mediaPlayerFragment.getBinding().mediaPlayerContent.setPlaying(playbackState.isPlaying());
        }
        if (playbackState.getPlaybackState() != null) {
            mediaPlayerFragment.bufferingAnimator = null;
            Context context = mediaPlayerFragment.getContext();
            if (context != null) {
                AudioPlaybackState playbackState2 = playbackState.getPlaybackState();
                int i = playbackState2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[playbackState2.ordinal()];
                if (i == 1) {
                    mediaPlayerFragment.getBinding().mediaPlayerLoading.getRoot().setVisibility(8);
                    mediaPlayerFragment.getBinding().mediaPlayerContent.mediaPlayerProgressSeekBar.setThumb(ContextCompat.getDrawable(context, C2814R.C2816drawable.seekbar_media_player_thumb_fail));
                } else if (i == 2) {
                    mediaPlayerFragment.getBinding().mediaPlayerLoading.getRoot().setVisibility(0);
                } else if (i != 3) {
                    mediaPlayerFragment.getBinding().mediaPlayerLoading.getRoot().setVisibility(8);
                    mediaPlayerFragment.getBinding().mediaPlayerContent.mediaPlayerProgressSeekBar.setThumb(ContextCompat.getDrawable(context, C2814R.C2816drawable.seekbar_media_player_thumb));
                } else {
                    mediaPlayerFragment.getBinding().mediaPlayerLoading.getRoot().setVisibility(8);
                    Drawable drawable = ContextCompat.getDrawable(context, C2814R.C2816drawable.seekbar_thumb_rotate);
                    if (drawable != null) {
                        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
                        mediaPlayerFragment.bufferingAnimator = new RotateDrawableAnimator(drawable);
                        mediaPlayerFragment.getBinding().mediaPlayerContent.mediaPlayerProgressSeekBar.setThumb(drawable);
                    }
                }
            }
        }
        if (playbackState.getPlaylistProgress() != null) {
            mediaPlayerFragment.getMediaPlayerTrackControl().setProgress(playbackState.getPlaylistProgress().intValue());
        }
    }

    private final void attachControlListeners() {
        getMediaPlayerPlayButton().setOnClickListener(new MediaPlayerFragment$$ExternalSyntheticLambda2(this));
        getMediaPlayerPreviousButton().setOnClickListener(new MediaPlayerFragment$$ExternalSyntheticLambda3(this));
        getMediaPlayerNextButton().setOnClickListener(new MediaPlayerFragment$$ExternalSyntheticLambda4(this));
        getMediaPlayerTrackControl().setOnClickListener(new MediaPlayerFragment$$ExternalSyntheticLambda5(this));
        getMediaPlayerVolumeControl().setOnClickListener(new MediaPlayerFragment$$ExternalSyntheticLambda1(this));
        getMediaPlayerLightControl().setOnClickListener(new MediaPlayerFragment$$ExternalSyntheticLambda0(this));
        getMediaPlayerProgressSeekBar().setOnSeekBarChangeListener(new MediaPlayerFragment$attachControlListeners$7(this));
        getBinding().mediaPlayerContent.mediaPlayerProduct.setAudioCoverClickListener(new MediaPlayerFragment$attachControlListeners$8(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: attachControlListeners$lambda-8  reason: not valid java name */
    public static final void m2436attachControlListeners$lambda8(MediaPlayerFragment mediaPlayerFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaPlayerFragment, "this$0");
        mediaPlayerFragment.getMediaPlayerViewModel().onPlayClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: attachControlListeners$lambda-9  reason: not valid java name */
    public static final void m2437attachControlListeners$lambda9(MediaPlayerFragment mediaPlayerFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaPlayerFragment, "this$0");
        mediaPlayerFragment.getMediaPlayerViewModel().onPreviousClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: attachControlListeners$lambda-10  reason: not valid java name */
    public static final void m2432attachControlListeners$lambda10(MediaPlayerFragment mediaPlayerFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaPlayerFragment, "this$0");
        mediaPlayerFragment.getMediaPlayerViewModel().onNextClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: attachControlListeners$lambda-11  reason: not valid java name */
    public static final void m2433attachControlListeners$lambda11(MediaPlayerFragment mediaPlayerFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaPlayerFragment, "this$0");
        mediaPlayerFragment.navigateToChapterList();
    }

    /* access modifiers changed from: private */
    /* renamed from: attachControlListeners$lambda-12  reason: not valid java name */
    public static final void m2434attachControlListeners$lambda12(MediaPlayerFragment mediaPlayerFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaPlayerFragment, "this$0");
        mediaPlayerFragment.showVolumeControl();
    }

    /* access modifiers changed from: private */
    /* renamed from: attachControlListeners$lambda-13  reason: not valid java name */
    public static final void m2435attachControlListeners$lambda13(MediaPlayerFragment mediaPlayerFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaPlayerFragment, "this$0");
        if (mediaPlayerFragment.getMediaPlayerViewModel().isNightlightEnabled()) {
            FragmentKt.findNavController(mediaPlayerFragment).navigate((int) C2814R.C2817id.fullScreenSeekBar, BundleKt.bundleOf(TuplesKt.m475to("seekBarType", SeekBarDialogType.TIGER_LIGHT_INTENSITY)));
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToFullScreenCover(String str) {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.f576x9bd2a9ba, BundleKt.bundleOf(TuplesKt.m475to("imageUrl", str)));
    }

    private final void navigateToChapterList() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.f575xbc526b73, (Bundle) null, 2, (Object) null);
    }

    private final void showVolumeControl() {
        FragmentActivity requireActivity = requireActivity();
        MiniPlayerListener miniPlayerListener = requireActivity instanceof MiniPlayerListener ? (MiniPlayerListener) requireActivity : null;
        if (miniPlayerListener != null) {
            miniPlayerListener.openVolumeControl();
        }
    }

    /* access modifiers changed from: private */
    public final IncludePlayerDeviceControlsBinding getMediaPlayerDeviceControls() {
        return (IncludePlayerDeviceControlsBinding) this.mediaPlayerDeviceControls$delegate.getValue();
    }

    private final CircleProgressImageView getMediaPlayerTrackControl() {
        return (CircleProgressImageView) this.mediaPlayerTrackControl$delegate.getValue();
    }

    private final CircleProgressImageView getMediaPlayerVolumeControl() {
        return (CircleProgressImageView) this.mediaPlayerVolumeControl$delegate.getValue();
    }

    private final CircleProgressImageView getMediaPlayerLightControl() {
        return (CircleProgressImageView) this.mediaPlayerLightControl$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final IncludePlayerTrackControlsBinding getMediaPlayerTrackControls() {
        return (IncludePlayerTrackControlsBinding) this.mediaPlayerTrackControls$delegate.getValue();
    }

    private final ImageButton getMediaPlayerPlayButton() {
        return (ImageButton) this.mediaPlayerPlayButton$delegate.getValue();
    }

    private final ImageButton getMediaPlayerPreviousButton() {
        return (ImageButton) this.mediaPlayerPreviousButton$delegate.getValue();
    }

    private final ImageButton getMediaPlayerNextButton() {
        return (ImageButton) this.mediaPlayerNextButton$delegate.getValue();
    }

    private final SeekBar getMediaPlayerProgressSeekBar() {
        return (SeekBar) this.mediaPlayerProgressSeekBar$delegate.getValue();
    }
}
