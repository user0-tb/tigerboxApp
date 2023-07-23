package media.tiger.tigerbox.p016ui.settings.systeminfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.databinding.FragmentSystemInfoBinding;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentSystemInfoBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentSystemInfoBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentSystemInfoBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "systemInfoItems", "", "Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoItem;", "getSystemInfoItems", "()Ljava/util/List;", "systemInfoItems$delegate", "Lkotlin/Lazy;", "systemInfoViewModel", "Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoViewModel;", "getSystemInfoViewModel", "()Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoViewModel;", "systemInfoViewModel$delegate", "getHeaderBinding", "Lmedia/tiger/tigerbox/databinding/IncludeDialogHeaderBarBinding;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "logUpdateInformation", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoFragment */
/* compiled from: SystemInfoFragment.kt */
public final class SystemInfoFragment extends Hilt_SystemInfoFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SystemInfoFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentSystemInfoBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy systemInfoItems$delegate = LazyKt.lazy(new SystemInfoFragment$systemInfoItems$2(this));
    private final Lazy systemInfoViewModel$delegate;

    public SystemInfoFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 systemInfoFragment$special$$inlined$viewModels$default$1 = new SystemInfoFragment$special$$inlined$viewModels$default$1(fragment);
        this.systemInfoViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SystemInfoViewModel.class), new SystemInfoFragment$special$$inlined$viewModels$default$2(systemInfoFragment$special$$inlined$viewModels$default$1), new SystemInfoFragment$special$$inlined$viewModels$default$3(systemInfoFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentSystemInfoBinding getBinding() {
        return (FragmentSystemInfoBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentSystemInfoBinding fragmentSystemInfoBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentSystemInfoBinding);
    }

    /* access modifiers changed from: private */
    public final SystemInfoViewModel getSystemInfoViewModel() {
        return (SystemInfoViewModel) this.systemInfoViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSystemInfoBinding inflate = FragmentSystemInfoBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        SystemInfoAdapter systemInfoAdapter = new SystemInfoAdapter();
        getBinding().systemInfoRecyclerView.setAdapter(systemInfoAdapter);
        systemInfoAdapter.submitList(getSystemInfoItems());
        logUpdateInformation();
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void logUpdateInformation() {
        Timber.Forest forest = Timber.Forest;
        forest.mo50214d("SystemInfo", "System update info:\n  --> Config  : [" + getSystemInfoViewModel().getConfigName() + "]\n  --> Firmware: [" + getSystemInfoViewModel().getFirmwareVersion() + "]\n  --> F/W Date: [" + getSystemInfoViewModel().getVersionDate() + "]\n  --> Storage : [" + getSystemInfoViewModel().getStorageUpdateDate() + ']');
    }

    private final List<SystemInfoItem> getSystemInfoItems() {
        return (List) this.systemInfoItems$delegate.getValue();
    }

    public IncludeDialogHeaderBarBinding getHeaderBinding() {
        IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding = getBinding().fragmentHeaderBar;
        Intrinsics.checkNotNullExpressionValue(includeDialogHeaderBarBinding, "binding.fragmentHeaderBar");
        return includeDialogHeaderBarBinding;
    }

    public DialogViewModel getViewModel() {
        return getSystemInfoViewModel();
    }
}
