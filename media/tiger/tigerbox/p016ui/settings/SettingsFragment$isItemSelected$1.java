package media.tiger.tigerbox.p016ui.settings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.C2814R;

@Metadata(mo33736d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo33737d2 = {"<anonymous>", "", "item", "Lmedia/tiger/tigerbox/ui/settings/SettingsItemData;", "invoke", "(Lmedia/tiger/tigerbox/ui/settings/SettingsItemData;)Ljava/lang/Boolean;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$isItemSelected$1 */
/* compiled from: SettingsFragment.kt */
final class SettingsFragment$isItemSelected$1 extends Lambda implements Function1<SettingsItemData, Boolean> {
    final /* synthetic */ SettingsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsFragment$isItemSelected$1(SettingsFragment settingsFragment) {
        super(1);
        this.this$0 = settingsFragment;
    }

    public final Boolean invoke(SettingsItemData settingsItemData) {
        boolean z;
        Intrinsics.checkNotNullParameter(settingsItemData, "item");
        switch (settingsItemData.getId()) {
            case C2814R.string.settings_cards_mode:
                z = this.this$0.getSettingsViewModel().isTigerCardModeEnabled();
                break;
            case C2814R.string.settings_disco_light:
                z = this.this$0.getSettingsViewModel().isMusicLightEnabled();
                break;
            case C2814R.string.settings_list_autoplay:
                z = this.this$0.getSettingsViewModel().isAutoplayEnabled();
                break;
            case C2814R.string.settings_nightlight:
                z = this.this$0.getSettingsViewModel().isTigerLightEnabled();
                break;
            case C2814R.string.settings_parental_gate:
                z = this.this$0.getSettingsViewModel().isParentalGateEnabled();
                break;
            case C2814R.string.settings_restrict_timers_mode:
                z = this.this$0.getSettingsViewModel().getHasAnyTimerSet();
                break;
            case C2814R.string.settings_sleep_mode:
                z = this.this$0.getSettingsViewModel().getTimerActive();
                break;
            case C2814R.string.settings_sound_alert:
                z = this.this$0.isSoundEnabled;
                break;
            case C2814R.string.settings_submit_logs:
                z = this.this$0.getSettingsViewModel().getHasLogsOrCrashes();
                break;
            case C2814R.string.settings_tiger_button:
                z = this.this$0.getSettingsViewModel().isTigerButtonLightEnabled();
                break;
            case C2814R.string.settings_wifi_toggle:
                z = this.this$0.getSettingsViewModel().isWifiEnabled();
                break;
            case C2814R.string.settings_wildcard:
                z = this.this$0.getSettingsViewModel().isWildcardReassignModeEnabled();
                break;
            default:
                z = false;
                break;
        }
        return Boolean.valueOf(z);
    }
}
