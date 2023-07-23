package media.tiger.tigerbox.p016ui.main.mediaplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.databinding.FragmentMediaPlayerFullscreenCoverBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.FullScreenNoHeaderFragment;

@Metadata(mo33736d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\""}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerFullscreenCoverFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "args", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerFullscreenCoverFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerFullscreenCoverFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerFullscreenCoverBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerFullscreenCoverBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerFullscreenCoverBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFullscreenCoverFragment */
/* compiled from: MediaPlayerFullscreenCoverFragment.kt */
public final class MediaPlayerFullscreenCoverFragment extends FullScreenNoHeaderFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MediaPlayerFullscreenCoverFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerFullscreenCoverBinding;", 0))};
    private final NavArgsLazy args$delegate;
    private final AutoClearedValue binding$delegate;

    public DialogViewModel getViewModel() {
        return null;
    }

    public MediaPlayerFullscreenCoverFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(MediaPlayerFullscreenCoverFragmentArgs.class), new MediaPlayerFullscreenCoverFragment$special$$inlined$navArgs$1(fragment));
    }

    private final FragmentMediaPlayerFullscreenCoverBinding getBinding() {
        return (FragmentMediaPlayerFullscreenCoverBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentMediaPlayerFullscreenCoverBinding fragmentMediaPlayerFullscreenCoverBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentMediaPlayerFullscreenCoverBinding);
    }

    private final MediaPlayerFullscreenCoverFragmentArgs getArgs() {
        return (MediaPlayerFullscreenCoverFragmentArgs) this.args$delegate.getValue();
    }

    public ImageView getCloseButton() {
        ImageButton root = getBinding().fragmentCloseButton.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.fragmentCloseButton.root");
        return root;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMediaPlayerFullscreenCoverBinding inflate = FragmentMediaPlayerFullscreenCoverBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getBinding().setImageUrl(getArgs().getImageUrl());
    }

    public void onStart() {
        super.onStart();
        getBinding().medialPlayerFullscreenCoverImage.setOnClickListener(new MediaPlayerFullscreenCoverFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onStart$lambda-0  reason: not valid java name */
    public static final void m2442onStart$lambda0(MediaPlayerFullscreenCoverFragment mediaPlayerFullscreenCoverFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaPlayerFullscreenCoverFragment, "this$0");
        FragmentKt.findNavController(mediaPlayerFullscreenCoverFragment).navigateUp();
    }
}
