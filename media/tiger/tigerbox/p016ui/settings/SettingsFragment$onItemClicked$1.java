package media.tiger.tigerbox.p016ui.settings;

import android.os.Bundle;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, mo33737d2 = {"<anonymous>", "", "index", "", "item", "Lmedia/tiger/tigerbox/ui/settings/SettingsItemData;", "isLongClick", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$onItemClicked$1 */
/* compiled from: SettingsFragment.kt */
final class SettingsFragment$onItemClicked$1 extends Lambda implements Function3<Integer, SettingsItemData, Boolean, Unit> {
    final /* synthetic */ SettingsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsFragment$onItemClicked$1(SettingsFragment settingsFragment) {
        super(3);
        this.this$0 = settingsFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).intValue(), (SettingsItemData) obj2, ((Boolean) obj3).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, SettingsItemData settingsItemData, boolean z) {
        Intrinsics.checkNotNullParameter(settingsItemData, "item");
        int id = settingsItemData.getId();
        SettingsAdapter settingsAdapter = null;
        if (id != C2814R.string.settings_tiger_button) {
            switch (id) {
                case C2814R.string.settings_brightness:
                    this.this$0.openScreenBrightness();
                    break;
                case C2814R.string.settings_cards_mode:
                    this.this$0.toggleCardsMode();
                    break;
                case C2814R.string.settings_delete_downloads:
                    if (!this.this$0.getSettingsViewModel().getUseProfiles()) {
                        SettingsFragment.showInfoDialog$default(this.this$0, InfoDialogType.DELETE_ALL_DOWNLOADS, (String[]) null, 2, (Object) null);
                        break;
                    } else {
                        this.this$0.showInfoDialog(InfoDialogType.DELETE_PROFILE_DOWNLOADS, new String[]{this.this$0.getSettingsViewModel().getCurrentProfileName()});
                        break;
                    }
                case C2814R.string.settings_disco_light:
                    this.this$0.getSettingsViewModel().toggleDiscoLight();
                    break;
                case C2814R.string.settings_list_autoplay:
                    this.this$0.getSettingsViewModel().toggleAutoplay();
                    break;
                case C2814R.string.settings_nightlight:
                    this.this$0.handleTigerLightTap(z);
                    break;
                case C2814R.string.settings_parental_gate:
                    this.this$0.openParentalGateToggling();
                    break;
                case C2814R.string.settings_profiles:
                    this.this$0.showProfiles();
                    break;
                case C2814R.string.settings_restrict_timers_mode:
                    this.this$0.showTimersSetup();
                    break;
                case C2814R.string.settings_search_update:
                    this.this$0.showUpdate();
                    break;
                case C2814R.string.settings_search_wifi:
                    this.this$0.showWifiSettings();
                    break;
                default:
                    switch (id) {
                        case C2814R.string.settings_sleep_mode:
                            this.this$0.openSleepTimer();
                            break;
                        case C2814R.string.settings_sound_alert:
                            this.this$0.getSettingsViewModel().toggleSound();
                            break;
                        case C2814R.string.settings_submit_logs:
                            if (!this.this$0.getSettingsViewModel().getHasLogsOrCrashes()) {
                                OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this.this$0), C2814R.C2817id.action_parental_settings_to_send_logs_none, (Bundle) null, 2, (Object) null);
                                break;
                            } else {
                                OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this.this$0), C2814R.C2817id.action_parental_settings_to_send_logs_in_progress, (Bundle) null, 2, (Object) null);
                                break;
                            }
                        case C2814R.string.settings_submit_logs_invoke_crash:
                            throw new Exception("Test Exception");
                        case C2814R.string.settings_system_info:
                            this.this$0.showSystemInfo();
                            break;
                        case C2814R.string.settings_ticket_redeem:
                            this.this$0.showTicketRedeemDialog();
                            break;
                        default:
                            switch (id) {
                                case C2814R.string.settings_wifi_toggle:
                                    this.this$0.toggleWifi();
                                    break;
                                case C2814R.string.settings_wildcard:
                                    if (!Intrinsics.areEqual((Object) this.this$0.getSettingsViewModel().getHeaderProvider().getOfflineMode().getValue(), (Object) true)) {
                                        this.this$0.getSettingsViewModel().toggleWildcardReassign();
                                        break;
                                    } else {
                                        SettingsFragment.showInfoDialog$default(this.this$0, InfoDialogType.NO_WIRELESS_SIGNAL, (String[]) null, 2, (Object) null);
                                        break;
                                    }
                            }
                    }
            }
        } else {
            this.this$0.getSettingsViewModel().toggleTigerButtonLight();
        }
        SettingsAdapter access$getAdapter$p = this.this$0.adapter;
        if (access$getAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            settingsAdapter = access$getAdapter$p;
        }
        settingsAdapter.notifyItemChanged(i);
    }
}
