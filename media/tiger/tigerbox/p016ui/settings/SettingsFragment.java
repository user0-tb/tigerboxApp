package media.tiger.tigerbox.p016ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentSettingsBinding;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;
import media.tiger.tigerbox.extension.TimeKt;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.FullScreenFragment;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogFragment;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.common.InfoDialogTypeResult;
import media.tiger.tigerbox.p016ui.main.SettingsListener;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.p016ui.settings.SettingsViewModel;
import media.tiger.tigerbox.services.implementations.TigerCardsManager;
import media.tiger.tigerbox.services.interfaces.WildcardReassignStep;
import p009j$.util.Collection;
import timber.log.Timber;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"H\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0011H\u0002J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0017J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\b\u00103\u001a\u00020\u0016H\u0016J\u001a\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00106\u001a\u00020\u0016H\u0002J\b\u00107\u001a\u00020\u0016H\u0002J\b\u00108\u001a\u00020\u0016H\u0002J%\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020;2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020\u0016H\u0002J\b\u0010A\u001a\u00020\u0016H\u0002J\b\u0010B\u001a\u00020\u0016H\u0002J\b\u0010C\u001a\u00020\u0016H\u0002J\b\u0010D\u001a\u00020\u0016H\u0002J\b\u0010E\u001a\u00020\u0016H\u0002J\b\u0010F\u001a\u00020\u0016H\u0002J\b\u0010G\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00160\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006I"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenFragment;", "()V", "adapter", "Lmedia/tiger/tigerbox/ui/settings/SettingsAdapter;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentSettingsBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentSettingsBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentSettingsBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "isItemSelected", "Lkotlin/Function1;", "Lmedia/tiger/tigerbox/ui/settings/SettingsItemData;", "", "isSoundEnabled", "onItemClicked", "Lkotlin/Function3;", "", "", "settingsListener", "Lmedia/tiger/tigerbox/ui/main/SettingsListener;", "settingsViewModel", "Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel;", "getSettingsViewModel", "()Lmedia/tiger/tigerbox/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "Lkotlin/Lazy;", "canShowSettings", "closeSafely", "createSettingsList", "", "getHeaderBinding", "Lmedia/tiger/tigerbox/databinding/IncludeDialogHeaderBarBinding;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "handleTigerLightTap", "longClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onStop", "onViewCreated", "view", "openParentalGateToggling", "openScreenBrightness", "openSleepTimer", "showInfoDialog", "type", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "params", "", "", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;)V", "showProfiles", "showSystemInfo", "showTicketRedeemDialog", "showTimersSetup", "showUpdate", "showWifiSettings", "toggleCardsMode", "toggleWifi", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment */
/* compiled from: SettingsFragment.kt */
public final class SettingsFragment extends Hilt_SettingsFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SettingsFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentSettingsBinding;", 0))};
    public static final int COLUMNS_COUNT = 4;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<SettingsItemData> settingsElements = CollectionsKt.listOf(new SettingsItemData(C2814R.string.settings_restrict_timers_mode, C2814R.C2816drawable.settings_switch_timers_selector), new SettingsCircleProgressItemData(C2814R.string.settings_sleep_mode, C2814R.C2816drawable.settings_switch_sleep_selector), new SettingsItemData(C2814R.string.settings_profiles, C2814R.C2816drawable.settings_switch_profiles), new SettingsItemData(C2814R.string.settings_wifi_toggle, C2814R.C2816drawable.settings_switch_wifi_selector), new SettingsItemData(C2814R.string.settings_search_wifi, C2814R.C2816drawable.settings_switch_wifi_seach_selector), new SettingsItemData(C2814R.string.settings_search_update, C2814R.C2816drawable.settings_switch_ota_update), new SettingsItemData(C2814R.string.settings_list_autoplay, C2814R.C2816drawable.selector_settings_autoplay), new SettingsItemData(C2814R.string.settings_brightness, C2814R.C2816drawable.settings_switch_brightness_selector), new SettingsItemData(C2814R.string.settings_nightlight, C2814R.C2816drawable.settings_switch_light_selector), new SettingsItemData(C2814R.string.settings_disco_light, C2814R.C2816drawable.settings_switch_music_light_selector), new SettingsItemData(C2814R.string.settings_tiger_button, C2814R.C2816drawable.settings_switch_tiger_light_selector), new SettingsItemData(C2814R.string.settings_sound_alert, C2814R.C2816drawable.settings_switch_volume_selector), new SettingsItemData(C2814R.string.settings_cards_mode, C2814R.C2816drawable.settings_switch_card_modus_selector), new SettingsItemData(C2814R.string.settings_delete_downloads, C2814R.C2816drawable.settings_switch_offline_delete), new SettingsItemData(C2814R.string.settings_ticket_redeem, C2814R.C2816drawable.settings_ticket_manual_redemption), new SettingsItemData(C2814R.string.settings_wildcard, C2814R.C2816drawable.settings_switch_wildcard_selector), new SettingsItemData(C2814R.string.settings_system_info, C2814R.C2816drawable.settings_switch_system_info), new SettingsItemData(C2814R.string.settings_parental_gate, C2814R.C2816drawable.settings_switch_parental_gate), new SettingsItemData(C2814R.string.settings_submit_logs, C2814R.C2816drawable.settings_switch_logs), new SettingsItemData(C2814R.string.settings_submit_logs_invoke_crash, C2814R.mipmap.parent_force_crash));
    /* access modifiers changed from: private */
    public SettingsAdapter adapter;
    private final AutoClearedValue binding$delegate;
    private final Function1<SettingsItemData, Boolean> isItemSelected = new SettingsFragment$isItemSelected$1(this);
    /* access modifiers changed from: private */
    public boolean isSoundEnabled;
    private final Function3<Integer, SettingsItemData, Boolean, Unit> onItemClicked = new SettingsFragment$onItemClicked$1(this);
    private SettingsListener settingsListener;
    private final Lazy settingsViewModel$delegate;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$WhenMappings */
    /* compiled from: SettingsFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WildcardReassignStep.values().length];
            iArr[WildcardReassignStep.WILDCARD_REASSIGN_CANCELED_OR_ENDED.ordinal()] = 1;
            iArr[WildcardReassignStep.WILDCARD_REASSIGN_STEP_1.ordinal()] = 2;
            iArr[WildcardReassignStep.WILDCARD_REASSIGN_STEP_2.ordinal()] = 3;
            iArr[WildcardReassignStep.WILDCARD_REASSIGN_STEP_3.ordinal()] = 4;
            iArr[WildcardReassignStep.WILDCARD_REASSIGN_FAIL.ordinal()] = 5;
            iArr[WildcardReassignStep.WILDCARD_REASSIGN_STEP_4.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean canShowSettings() {
        return false;
    }

    public SettingsFragment() {
        Fragment fragment = this;
        Function0 settingsFragment$special$$inlined$viewModels$default$1 = new SettingsFragment$special$$inlined$viewModels$default$1(fragment);
        this.settingsViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new SettingsFragment$special$$inlined$viewModels$default$2(settingsFragment$special$$inlined$viewModels$default$1), new SettingsFragment$special$$inlined$viewModels$default$3(settingsFragment$special$$inlined$viewModels$default$1, fragment));
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
    }

    /* access modifiers changed from: private */
    public final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel$delegate.getValue();
    }

    private final FragmentSettingsBinding getBinding() {
        return (FragmentSettingsBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentSettingsBinding fragmentSettingsBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentSettingsBinding);
    }

    public void onStop() {
        DialogViewModel viewModel = getViewModel();
        FullScreenViewModel fullScreenViewModel = viewModel instanceof FullScreenViewModel ? (FullScreenViewModel) viewModel : null;
        if (fullScreenViewModel != null) {
            fullScreenViewModel.getHeaderProvider().getSettingsOpened().setValue(false);
        }
        super.onStop();
    }

    public void closeSafely() {
        requireActivity().finish();
        getSettingsViewModel().clearObservers();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        SettingsCircleProgressItemData settingsCircleProgressItemData;
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSettingsBinding inflate = FragmentSettingsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        Timber.Forest.mo50221i("SettingsFragment onCreateView", new Object[0]);
        List<SettingsItemData> createSettingsList = createSettingsList();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        Iterator it = createSettingsList.iterator();
        while (true) {
            settingsCircleProgressItemData = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SettingsItemData) obj).getId() == C2814R.string.settings_sleep_mode) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (obj instanceof SettingsCircleProgressItemData) {
            settingsCircleProgressItemData = (SettingsCircleProgressItemData) obj;
        }
        if (settingsCircleProgressItemData != null) {
            intRef.element = createSettingsList.indexOf(settingsCircleProgressItemData);
            Integer value = getSettingsViewModel().getHeaderProvider().getSleepTimeTick().getValue();
            if (value != null) {
                Intrinsics.checkNotNullExpressionValue(value, "secondsUntilFinished");
                settingsCircleProgressItemData.setCircleItemText(value.intValue() <= 0 ? "" : String.valueOf(TimeKt.secondsToMinutes(value.intValue()) + 1));
                settingsCircleProgressItemData.setProgress(value.intValue());
            }
            Timber.Forest.mo50221i("binding.settingsRecyclerView.adapter?.notifyItemChanged 1", new Object[0]);
            RecyclerView.Adapter adapter2 = getBinding().settingsRecyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyItemChanged(intRef.element);
            }
        }
        getSettingsViewModel().getHeaderProvider().getOfflineMode().observe(getViewLifecycleOwner(), new SettingsFragment$$ExternalSyntheticLambda8(this, createSettingsList));
        getSettingsViewModel().getViewState().observe(getViewLifecycleOwner(), new SettingsFragment$$ExternalSyntheticLambda9(this, createSettingsList));
        getSettingsViewModel().getWildcardReassignState().observe(getViewLifecycleOwner(), new SettingsFragment$$ExternalSyntheticLambda7(this));
        getSettingsViewModel().getHeaderProvider().getSleepTimeTick().observe(getViewLifecycleOwner(), new SettingsFragment$$ExternalSyntheticLambda6(settingsCircleProgressItemData, intRef, this));
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-4  reason: not valid java name */
    public static final void m2526onCreateView$lambda4(SettingsFragment settingsFragment, List list, Boolean bool) {
        Intrinsics.checkNotNullParameter(settingsFragment, "this$0");
        Intrinsics.checkNotNullParameter(list, "$settingsItemsList");
        Timber.Forest.mo50221i("settingsViewModel.headerProvider.offlineMode", new Object[0]);
        settingsFragment.getSettingsViewModel().setWifiEnabled(!bool.booleanValue());
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new SettingsFragment$onCreateView$2$1(bool, list, settingsFragment, (Continuation<? super SettingsFragment$onCreateView$2$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-8  reason: not valid java name */
    public static final void m2527onCreateView$lambda8(SettingsFragment settingsFragment, List list, SettingsViewModel.ViewState viewState) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(settingsFragment, "this$0");
        Intrinsics.checkNotNullParameter(list, "$settingsItemsList");
        settingsFragment.isSoundEnabled = viewState.getAudioEnabled();
        settingsFragment.getBinding().setSubscriptionExpired(Boolean.valueOf(viewState.getSubscription().getExpired()));
        settingsFragment.getBinding().setSubscriptionEndDate(viewState.getSubscription().getEndDate());
        settingsFragment.getBinding().setSubscriptionAboutToExpired(Boolean.valueOf(viewState.getSubscription().getAboutToExpire()));
        settingsFragment.getBinding().setSubscriptionVisible(Boolean.valueOf(viewState.getSubscription().getVisible()));
        SettingsAdapter settingsAdapter = settingsFragment.adapter;
        SettingsAdapter settingsAdapter2 = null;
        if (settingsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            settingsAdapter = null;
        }
        Iterable iterable = list;
        for (Object next : iterable) {
            if (((SettingsItemData) next).getId() == C2814R.string.settings_nightlight) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                settingsAdapter.notifyItemChanged(list.indexOf(next));
                SettingsAdapter settingsAdapter3 = settingsFragment.adapter;
                if (settingsAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    settingsAdapter2 = settingsAdapter3;
                }
                for (Object next2 : iterable) {
                    if (((SettingsItemData) next2).getId() == C2814R.string.settings_sound_alert) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        settingsAdapter2.notifyItemChanged(list.indexOf(next2));
                        String insertedNfcCardType = viewState.getInsertedNfcCardType();
                        if (insertedNfcCardType != null) {
                            Timber.Forest.mo50221i("SETTINGS inserted card type " + insertedNfcCardType, new Object[0]);
                            int hashCode = insertedNfcCardType.hashCode();
                            if (hashCode != -483323767) {
                                if (hashCode != -390388262) {
                                    if (hashCode != 1810236463 || !insertedNfcCardType.equals(TigerCardsManager.TIGERCARD)) {
                                        return;
                                    }
                                } else if (!insertedNfcCardType.equals(TigerCardsManager.WILDCARD)) {
                                    return;
                                }
                            } else if (!insertedNfcCardType.equals(TigerCardsManager.MULTI_TIGERCARD)) {
                                return;
                            }
                            settingsFragment.closeSafely();
                            return;
                        }
                        return;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-9  reason: not valid java name */
    public static final void m2528onCreateView$lambda9(SettingsFragment settingsFragment, SettingsViewModel.WildcardState wildcardState) {
        Intrinsics.checkNotNullParameter(settingsFragment, "this$0");
        SettingsAdapter settingsAdapter = null;
        switch (WhenMappings.$EnumSwitchMapping$0[wildcardState.getStep().ordinal()]) {
            case 1:
                SettingsAdapter settingsAdapter2 = settingsFragment.adapter;
                if (settingsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    settingsAdapter = settingsAdapter2;
                }
                settingsAdapter.notifyDataSetChanged();
                FragmentKt.findNavController(settingsFragment).popBackStack((int) C2814R.C2817id.parentalSettings, false);
                return;
            case 2:
                OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(settingsFragment), C2814R.C2817id.action_parentalSettings_to_wildCardReAssigningStep1Fragment, (Bundle) null, 2, (Object) null);
                return;
            case 3:
                Fragment fragment = settingsFragment;
                FragmentKt.findNavController(fragment).popBackStack((int) C2814R.C2817id.parentalSettings, false);
                OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(fragment), C2814R.C2817id.action_parentalSettings_to_wildCardReAssigningStep2Fragment, (Bundle) null, 2, (Object) null);
                return;
            case 4:
                OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(settingsFragment), C2814R.C2817id.f588xbae4774f, (Bundle) null, 2, (Object) null);
                return;
            case 5:
                showInfoDialog$default(settingsFragment, InfoDialogType.WILDCARD_ASSIGN_ERROR, (String[]) null, 2, (Object) null);
                return;
            case 6:
                OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(settingsFragment), C2814R.C2817id.action_parentalSettings_to_wildCardReAssigningStep4Fragment, (Bundle) null, 2, (Object) null);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-10  reason: not valid java name */
    public static final void m2525onCreateView$lambda10(SettingsCircleProgressItemData settingsCircleProgressItemData, Ref.IntRef intRef, SettingsFragment settingsFragment, Integer num) {
        RecyclerView.Adapter adapter2;
        Intrinsics.checkNotNullParameter(intRef, "$sleepTimerPosition");
        Intrinsics.checkNotNullParameter(settingsFragment, "this$0");
        if (settingsCircleProgressItemData != null) {
            Intrinsics.checkNotNullExpressionValue(num, "secondsUntilFinished");
            settingsCircleProgressItemData.setCircleItemText(num.intValue() <= 0 ? "" : String.valueOf(TimeKt.secondsToMinutes(num.intValue()) + 1));
        }
        if (settingsCircleProgressItemData != null) {
            Intrinsics.checkNotNullExpressionValue(num, "secondsUntilFinished");
            settingsCircleProgressItemData.setProgress(num.intValue());
        }
        if (intRef.element > -1 && (adapter2 = settingsFragment.getBinding().settingsRecyclerView.getAdapter()) != null) {
            adapter2.notifyItemChanged(intRef.element);
        }
    }

    public void onResume() {
        super.onResume();
        getSettingsViewModel().registerObservers();
        LifecycleOwner lifecycleOwner = this;
        requireActivity().getSupportFragmentManager().setFragmentResultListener(InfoDialogFragment.REQUEST_KEY, lifecycleOwner, new SettingsFragment$$ExternalSyntheticLambda0(this));
        requireActivity().getSupportFragmentManager().setFragmentResultListener(FullScreenFragment.FULLSCREEN_FRAGMENT_DID_CLOSE_RESULT_KEY, lifecycleOwner, new SettingsFragment$$ExternalSyntheticLambda5(this));
        DialogViewModel viewModel = getViewModel();
        FullScreenViewModel fullScreenViewModel = viewModel instanceof FullScreenViewModel ? (FullScreenViewModel) viewModel : null;
        if (fullScreenViewModel != null) {
            fullScreenViewModel.getHeaderProvider().getSettingsOpened().setValue(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-11  reason: not valid java name */
    public static final void m2529onResume$lambda11(SettingsFragment settingsFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(settingsFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey("RESULT_KEY")) {
            String string = bundle.getString("RESULT_KEY");
            if (string == null) {
                string = "";
            }
            if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.DELETE_DOWNLOADS_CONFIRMED.getText())) {
                settingsFragment.getSettingsViewModel().deleteAllDownloadedProducts();
                if (!settingsFragment.getSettingsViewModel().getUseProfiles()) {
                    showInfoDialog$default(settingsFragment, InfoDialogType.DELETE_ALL_CONFIRMATION, (String[]) null, 2, (Object) null);
                }
            } else if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.DELETE_PROFILE_DOWNLOADS_CONFIRMED.getText())) {
                settingsFragment.getSettingsViewModel().deleteProfileDownloadedProducts();
            } else if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.SELECT_WIFI_NETWORKS.getText())) {
                settingsFragment.showWifiSettings();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-15  reason: not valid java name */
    public static final void m2530onResume$lambda15(SettingsFragment settingsFragment, String str, Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(settingsFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Timber.Forest.mo50221i("fullscreen did close result key", new Object[0]);
        try {
            SettingsAdapter settingsAdapter = null;
            if (settingsFragment.getSettingsViewModel().getShowAdvanceTimers()) {
                SettingsAdapter settingsAdapter2 = settingsFragment.adapter;
                if (settingsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsAdapter2 = null;
                }
                SettingsAdapter settingsAdapter3 = settingsFragment.adapter;
                if (settingsAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsAdapter3 = null;
                }
                List<SettingsItemData> itemsList = settingsAdapter3.getItemsList();
                SettingsAdapter settingsAdapter4 = settingsFragment.adapter;
                if (settingsAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsAdapter4 = null;
                }
                for (Object next : settingsAdapter4.getItemsList()) {
                    if (((SettingsItemData) next).getId() == C2814R.string.settings_restrict_timers_mode) {
                        z3 = true;
                        continue;
                    } else {
                        z3 = false;
                        continue;
                    }
                    if (z3) {
                        settingsAdapter2.notifyItemChanged(itemsList.indexOf(next));
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            if (settingsFragment.getSettingsViewModel().getShowParentalGate()) {
                SettingsAdapter settingsAdapter5 = settingsFragment.adapter;
                if (settingsAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsAdapter5 = null;
                }
                SettingsAdapter settingsAdapter6 = settingsFragment.adapter;
                if (settingsAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsAdapter6 = null;
                }
                List<SettingsItemData> itemsList2 = settingsAdapter6.getItemsList();
                SettingsAdapter settingsAdapter7 = settingsFragment.adapter;
                if (settingsAdapter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsAdapter7 = null;
                }
                for (Object next2 : settingsAdapter7.getItemsList()) {
                    if (((SettingsItemData) next2).getId() == C2814R.string.settings_parental_gate) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        settingsAdapter5.notifyItemChanged(itemsList2.indexOf(next2));
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            if (settingsFragment.getSettingsViewModel().getCanSubmitLogs()) {
                SettingsAdapter settingsAdapter8 = settingsFragment.adapter;
                if (settingsAdapter8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsAdapter8 = null;
                }
                SettingsAdapter settingsAdapter9 = settingsFragment.adapter;
                if (settingsAdapter9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsAdapter9 = null;
                }
                List<SettingsItemData> itemsList3 = settingsAdapter9.getItemsList();
                SettingsAdapter settingsAdapter10 = settingsFragment.adapter;
                if (settingsAdapter10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    settingsAdapter = settingsAdapter10;
                }
                for (Object next3 : settingsAdapter.getItemsList()) {
                    if (((SettingsItemData) next3).getId() == C2814R.string.settings_submit_logs) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        settingsAdapter8.notifyItemChanged(itemsList3.indexOf(next3));
                        return;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        } catch (Exception e) {
            Timber.Forest.mo50221i("Could not find settings item " + e, new Object[0]);
        }
    }

    public void onPause() {
        super.onPause();
        getSettingsViewModel().clearObservers();
        requireActivity().getSupportFragmentManager().clearFragmentResultListener(InfoDialogFragment.REQUEST_KEY);
        requireActivity().getSupportFragmentManager().clearFragmentResultListener(FullScreenFragment.FULLSCREEN_FRAGMENT_DID_CLOSE_RESULT_KEY);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.settingsListener = (SettingsListener) activity;
                getSettingsViewModel().requestState();
                this.adapter = new SettingsAdapter(createSettingsList(), this.onItemClicked, this.isItemSelected);
                RecyclerView recyclerView = getBinding().settingsRecyclerView;
                SettingsAdapter settingsAdapter = this.adapter;
                if (settingsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    settingsAdapter = null;
                }
                recyclerView.setAdapter(settingsAdapter);
                getBinding().settingsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
                if (getSettingsViewModel().getHasFirmwareUpdateAvailable() && !getSettingsViewModel().getHasAlreadyShownUpdateDialogue()) {
                    getSettingsViewModel().setHasAlreadyShownUpdateDialogue(true);
                    showUpdate();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type media.tiger.tigerbox.ui.main.SettingsListener");
        } catch (ClassCastException unused) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("SettingsFragment: onAttach: This activity (" + getContext() + ") " + getActivity() + " does not implement " + Reflection.getOrCreateKotlinClass(SettingsListener.class).getSimpleName(), new Object[0]);
        }
    }

    public DialogViewModel getViewModel() {
        return getSettingsViewModel();
    }

    public IncludeDialogHeaderBarBinding getHeaderBinding() {
        IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding = getBinding().fragmentHeaderBar;
        Intrinsics.checkNotNullExpressionValue(includeDialogHeaderBarBinding, "binding.fragmentHeaderBar");
        return includeDialogHeaderBarBinding;
    }

    /* access modifiers changed from: private */
    public final void openScreenBrightness() {
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder();
        sb.append("TEST openScreenBrightness ");
        Fragment fragment = this;
        sb.append(FragmentKt.findNavController(fragment));
        forest.mo50221i(sb.toString(), new Object[0]);
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(fragment), C2814R.C2817id.action_parentalSettings_to_fullScreenSeekBar, BundleKt.bundleOf(TuplesKt.m475to("seekBarType", SeekBarDialogType.SCREEN_BRIGHTNESS)));
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(fragment), C2814R.C2817id.action_parentalSettings_to_userProfilesSwitching, (Bundle) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void openParentalGateToggling() {
        if (getSettingsViewModel().isParentalGateEnabled()) {
            OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_parental_settings_to_disable_parental_gate_step, (Bundle) null, 2, (Object) null);
        } else {
            OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_parental_settings_to_enable_parental_gate_step, (Bundle) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void openSleepTimer() {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.action_parentalSettings_to_fullScreenSeekBar, BundleKt.bundleOf(TuplesKt.m475to("seekBarType", SeekBarDialogType.SLEEP_TIMER)));
    }

    /* access modifiers changed from: private */
    public final void handleTigerLightTap(boolean z) {
        if (z) {
            getSettingsViewModel().turnTigerLightOn();
            OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.action_parentalSettings_to_fullScreenSeekBar, BundleKt.bundleOf(TuplesKt.m475to("seekBarType", SeekBarDialogType.TIGER_LIGHT_INTENSITY)));
            return;
        }
        getSettingsViewModel().toggleTigerLight();
    }

    /* access modifiers changed from: private */
    public final void showInfoDialog(InfoDialogType infoDialogType, String[] strArr) {
        FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType), TuplesKt.m475to("messageFormatParams", strArr)));
    }

    /* access modifiers changed from: private */
    public final void toggleCardsMode() {
        getSettingsViewModel().toggleCardsMode();
        SettingsListener settingsListener2 = null;
        if (getSettingsViewModel().isTigerCardModeEnabled()) {
            SettingsListener settingsListener3 = this.settingsListener;
            if (settingsListener3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsListener");
            } else {
                settingsListener2 = settingsListener3;
            }
            settingsListener2.enableCardsMode();
            return;
        }
        SettingsListener settingsListener4 = this.settingsListener;
        if (settingsListener4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsListener");
        } else {
            settingsListener2 = settingsListener4;
        }
        settingsListener2.disableCardsMode();
    }

    /* access modifiers changed from: private */
    public final void showWifiSettings() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_parental_settings_to_wifiListFragment, (Bundle) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showTicketRedeemDialog() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.f587x5e13727b, (Bundle) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showSystemInfo() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_parentalSettings_to_systemInfoFragment, (Bundle) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showProfiles() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_parentalSettings_to_userProfilesSwitching, (Bundle) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showTimersSetup() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_parentalSettings_to_timersSetupFragment, (Bundle) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showUpdate() {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.action_parentalSettings_to_updateFragment, BundleKt.bundleOf(new Pair("source", "SETTINGS")));
    }

    /* access modifiers changed from: private */
    public final void toggleWifi() {
        getSettingsViewModel().toggleWifi();
    }

    private final List<SettingsItemData> createSettingsList() {
        List<SettingsItemData> arrayList = new ArrayList<>();
        arrayList.addAll(settingsElements);
        Timber.Forest.mo50221i("Create settings", new Object[0]);
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("showAutoPlay " + getSettingsViewModel().getShowAutoPlay(), new Object[0]);
        Timber.Forest forest2 = Timber.Forest;
        forest2.mo50221i("useProfiles " + getSettingsViewModel().getUseProfiles(), new Object[0]);
        Timber.Forest forest3 = Timber.Forest;
        forest3.mo50221i("useProfilesMainContentSwitchEnabled " + getSettingsViewModel().getUseProfilesMainContentSwitchEnabled(), new Object[0]);
        Timber.Forest forest4 = Timber.Forest;
        forest4.mo50221i("showAdvanceTimers " + getSettingsViewModel().getShowAdvanceTimers(), new Object[0]);
        Timber.Forest forest5 = Timber.Forest;
        forest5.mo50221i("showTicketManualRedemption " + getSettingsViewModel().getShowTicketManualRedemption(), new Object[0]);
        Timber.Forest forest6 = Timber.Forest;
        forest6.mo50221i("canSubmitLogs " + getSettingsViewModel().getCanSubmitLogs(), new Object[0]);
        Timber.Forest forest7 = Timber.Forest;
        forest7.mo50221i("canForceCrash " + getSettingsViewModel().getCanForceCrash(), new Object[0]);
        Timber.Forest forest8 = Timber.Forest;
        forest8.mo50221i("parentalGate " + getSettingsViewModel().getShowParentalGate(), new Object[0]);
        if (!getSettingsViewModel().getShowAutoPlay()) {
            Collection.EL.removeIf(arrayList, SettingsFragment$$ExternalSyntheticLambda2.INSTANCE);
        }
        if (!getSettingsViewModel().getShowParentalGate()) {
            Collection.EL.removeIf(arrayList, SettingsFragment$$ExternalSyntheticLambda11.INSTANCE);
        }
        if (!getSettingsViewModel().getUseProfiles() || getSettingsViewModel().getUseProfilesMainContentSwitchEnabled()) {
            Collection.EL.removeIf(arrayList, SettingsFragment$$ExternalSyntheticLambda10.INSTANCE);
        }
        if (!getSettingsViewModel().getShowAdvanceTimers()) {
            Collection.EL.removeIf(arrayList, SettingsFragment$$ExternalSyntheticLambda4.INSTANCE);
        } else {
            Collection.EL.removeIf(arrayList, SettingsFragment$$ExternalSyntheticLambda13.INSTANCE);
        }
        if (!getSettingsViewModel().getShowTicketManualRedemption()) {
            Collection.EL.removeIf(arrayList, SettingsFragment$$ExternalSyntheticLambda12.INSTANCE);
        }
        if (!getSettingsViewModel().getCanSubmitLogs()) {
            Collection.EL.removeIf(arrayList, SettingsFragment$$ExternalSyntheticLambda3.INSTANCE);
        }
        if (!getSettingsViewModel().getCanSubmitLogs() || !getSettingsViewModel().getCanForceCrash()) {
            Collection.EL.removeIf(arrayList, SettingsFragment$$ExternalSyntheticLambda1.INSTANCE);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: createSettingsList$lambda-18  reason: not valid java name */
    public static final boolean m2517createSettingsList$lambda18(SettingsItemData settingsItemData) {
        Intrinsics.checkNotNullParameter(settingsItemData, "element");
        return settingsItemData.getId() == C2814R.string.settings_list_autoplay;
    }

    /* access modifiers changed from: private */
    /* renamed from: createSettingsList$lambda-19  reason: not valid java name */
    public static final boolean m2518createSettingsList$lambda19(SettingsItemData settingsItemData) {
        Intrinsics.checkNotNullParameter(settingsItemData, "element");
        return settingsItemData.getId() == C2814R.string.settings_parental_gate;
    }

    /* access modifiers changed from: private */
    /* renamed from: createSettingsList$lambda-20  reason: not valid java name */
    public static final boolean m2519createSettingsList$lambda20(SettingsItemData settingsItemData) {
        Intrinsics.checkNotNullParameter(settingsItemData, "element");
        return settingsItemData.getId() == C2814R.string.settings_profiles;
    }

    /* access modifiers changed from: private */
    /* renamed from: createSettingsList$lambda-21  reason: not valid java name */
    public static final boolean m2520createSettingsList$lambda21(SettingsItemData settingsItemData) {
        Intrinsics.checkNotNullParameter(settingsItemData, "element");
        return settingsItemData.getId() == C2814R.string.settings_restrict_timers_mode;
    }

    /* access modifiers changed from: private */
    /* renamed from: createSettingsList$lambda-22  reason: not valid java name */
    public static final boolean m2521createSettingsList$lambda22(SettingsItemData settingsItemData) {
        Intrinsics.checkNotNullParameter(settingsItemData, "element");
        return settingsItemData.getId() == C2814R.string.settings_sleep_mode;
    }

    /* access modifiers changed from: private */
    /* renamed from: createSettingsList$lambda-23  reason: not valid java name */
    public static final boolean m2522createSettingsList$lambda23(SettingsItemData settingsItemData) {
        Intrinsics.checkNotNullParameter(settingsItemData, "element");
        return settingsItemData.getId() == C2814R.string.settings_ticket_redeem;
    }

    /* access modifiers changed from: private */
    /* renamed from: createSettingsList$lambda-24  reason: not valid java name */
    public static final boolean m2523createSettingsList$lambda24(SettingsItemData settingsItemData) {
        Intrinsics.checkNotNullParameter(settingsItemData, "element");
        return settingsItemData.getId() == C2814R.string.settings_submit_logs;
    }

    /* access modifiers changed from: private */
    /* renamed from: createSettingsList$lambda-25  reason: not valid java name */
    public static final boolean m2524createSettingsList$lambda25(SettingsItemData settingsItemData) {
        Intrinsics.checkNotNullParameter(settingsItemData, "element");
        return settingsItemData.getId() == C2814R.string.settings_submit_logs_invoke_crash;
    }

    @Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsFragment$Companion;", "", "()V", "COLUMNS_COUNT", "", "settingsElements", "", "Lmedia/tiger/tigerbox/ui/settings/SettingsItemData;", "getSettingsElements", "()Ljava/util/List;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$Companion */
    /* compiled from: SettingsFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<SettingsItemData> getSettingsElements() {
            return SettingsFragment.settingsElements;
        }
    }

    static /* synthetic */ void showInfoDialog$default(SettingsFragment settingsFragment, InfoDialogType infoDialogType, String[] strArr, int i, Object obj) {
        if ((i & 2) != 0) {
            strArr = (String[]) ((Object[]) new String[0]);
        }
        settingsFragment.showInfoDialog(infoDialogType, strArr);
    }
}
