package media.tiger.tigerbox.p016ui.main.mediaplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.databinding.FragmentMediaPlayerChapterListBinding;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.model.domain.ChapterItem;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerChapterListFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerChapterListBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerChapterListBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerChapterListBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "chapterListAdapter", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/ChapterListAdapter;", "chapterListViewModel", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/ChapterListViewModel;", "getChapterListViewModel", "()Lmedia/tiger/tigerbox/ui/main/mediaplayer/ChapterListViewModel;", "chapterListViewModel$delegate", "Lkotlin/Lazy;", "getHeaderBinding", "Lmedia/tiger/tigerbox/databinding/IncludeDialogHeaderBarBinding;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerChapterListFragment */
/* compiled from: MediaPlayerChapterListFragment.kt */
public final class MediaPlayerChapterListFragment extends Hilt_MediaPlayerChapterListFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MediaPlayerChapterListFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentMediaPlayerChapterListBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private ChapterListAdapter chapterListAdapter;
    private final Lazy chapterListViewModel$delegate;

    public MediaPlayerChapterListFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 mediaPlayerChapterListFragment$special$$inlined$viewModels$default$1 = new C2967xe0b0f2fd(fragment);
        this.chapterListViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ChapterListViewModel.class), new C2968xe0b0f2fe(mediaPlayerChapterListFragment$special$$inlined$viewModels$default$1), new C2969xe0b0f2ff(mediaPlayerChapterListFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentMediaPlayerChapterListBinding getBinding() {
        return (FragmentMediaPlayerChapterListBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentMediaPlayerChapterListBinding fragmentMediaPlayerChapterListBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentMediaPlayerChapterListBinding);
    }

    /* access modifiers changed from: private */
    public final ChapterListViewModel getChapterListViewModel() {
        return (ChapterListViewModel) this.chapterListViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMediaPlayerChapterListBinding inflate = FragmentMediaPlayerChapterListBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().mediaPlayerChapterListTitle.setText(getChapterListViewModel().getChapterTitle());
        this.chapterListAdapter = new ChapterListAdapter(new MediaPlayerChapterListFragment$onCreateView$1(this));
        RecyclerView recyclerView = getBinding().mediaPlayerChapterListRecyclerView;
        ChapterListAdapter chapterListAdapter2 = this.chapterListAdapter;
        if (chapterListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chapterListAdapter");
            chapterListAdapter2 = null;
        }
        recyclerView.setAdapter(chapterListAdapter2);
        getChapterListViewModel().getChapterList().observe(getViewLifecycleOwner(), new MediaPlayerChapterListFragment$$ExternalSyntheticLambda0(this));
        getChapterListViewModel().updateData();
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m2430onCreateView$lambda1(MediaPlayerChapterListFragment mediaPlayerChapterListFragment, List list) {
        Intrinsics.checkNotNullParameter(mediaPlayerChapterListFragment, "this$0");
        ChapterListAdapter chapterListAdapter2 = mediaPlayerChapterListFragment.chapterListAdapter;
        if (chapterListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chapterListAdapter");
            chapterListAdapter2 = null;
        }
        chapterListAdapter2.submitList(list);
        try {
            Intrinsics.checkNotNullExpressionValue(list, "chapterList");
            for (Object next : list) {
                if (((ChapterItem) next).isSelected()) {
                    mediaPlayerChapterListFragment.getBinding().mediaPlayerChapterListRecyclerView.scrollToPosition(list.indexOf((ChapterItem) next));
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (NoSuchElementException e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("ChapterListFragment: " + e.getMessage(), new Object[0]);
        }
    }

    public DialogViewModel getViewModel() {
        return getChapterListViewModel();
    }

    public IncludeDialogHeaderBarBinding getHeaderBinding() {
        IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding = getBinding().fragmentHeaderBar;
        Intrinsics.checkNotNullExpressionValue(includeDialogHeaderBarBinding, "binding.fragmentHeaderBar");
        return includeDialogHeaderBarBinding;
    }
}
