package media.tiger.tigerbox;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import media.tiger.tigerbox.databinding.FragmentFullscreenSeekbarBindingImpl;
import media.tiger.tigerbox.databinding.FragmentHeaderBarBindingImpl;
import media.tiger.tigerbox.databinding.FragmentInfoDialogBindingImpl;
import media.tiger.tigerbox.databinding.FragmentMediaPlayerBindingImpl;
import media.tiger.tigerbox.databinding.FragmentMediaPlayerFullscreenCoverBindingImpl;
import media.tiger.tigerbox.databinding.FragmentMiniPlayerBindingImpl;
import media.tiger.tigerbox.databinding.FragmentMiniProfilesBindingImpl;
import media.tiger.tigerbox.databinding.FragmentOnboardingBackendResponseBindingImpl;
import media.tiger.tigerbox.databinding.FragmentOnboardingBatteryWarningBindingImpl;
import media.tiger.tigerbox.databinding.FragmentOnboardingLoginBindingImpl;
import media.tiger.tigerbox.databinding.FragmentOnboardingUpdateStartBindingImpl;
import media.tiger.tigerbox.databinding.FragmentOtaUpdateInProgressBindingImpl;
import media.tiger.tigerbox.databinding.FragmentParentalGateBindingImpl;
import media.tiger.tigerbox.databinding.FragmentProfilePictureBindingImpl;
import media.tiger.tigerbox.databinding.FragmentProfilesBindingImpl;
import media.tiger.tigerbox.databinding.FragmentSendLogsFinishedBindingImpl;
import media.tiger.tigerbox.databinding.FragmentSendLogsNoneBindingImpl;
import media.tiger.tigerbox.databinding.FragmentSettingsBindingImpl;
import media.tiger.tigerbox.databinding.FragmentTicketRedeemTicketNumberInputBindingImpl;
import media.tiger.tigerbox.databinding.FragmentTigerTicketInputPinBindingImpl;
import media.tiger.tigerbox.databinding.FragmentTigerTicketPurchaseBindingImpl;
import media.tiger.tigerbox.databinding.FragmentTimersLimitBindingImpl;
import media.tiger.tigerbox.databinding.FragmentTimersSetupBindingImpl;
import media.tiger.tigerbox.databinding.FragmentTimersWindowBindingImpl;
import media.tiger.tigerbox.databinding.FragmentWifiEnterPasswordBindingImpl;
import media.tiger.tigerbox.databinding.FragmentWildcardReassigningStep4BindingImpl;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBindingImpl;
import media.tiger.tigerbox.databinding.IncludeMediaPlayerBindingImpl;
import media.tiger.tigerbox.databinding.IncludeMediaPlayerControlsBindingImpl;
import media.tiger.tigerbox.databinding.IncludePlayerDeviceControlsBindingImpl;
import media.tiger.tigerbox.databinding.IncludePlayerTrackControlsBindingImpl;
import media.tiger.tigerbox.databinding.IncludeProfilesBindingImpl;
import media.tiger.tigerbox.databinding.ItemChapterListBindingImpl;
import media.tiger.tigerbox.databinding.ItemFooterBindingImpl;
import media.tiger.tigerbox.databinding.ItemProductActionBindingImpl;
import media.tiger.tigerbox.databinding.ItemProductBindingImpl;
import media.tiger.tigerbox.databinding.ItemProductRowBindingImpl;
import media.tiger.tigerbox.databinding.ItemProfileBindingImpl;
import media.tiger.tigerbox.databinding.ItemSettingsBindingImpl;
import media.tiger.tigerbox.databinding.ItemSettingsCircleProgressBindingImpl;
import media.tiger.tigerbox.databinding.ItemSystemInfoBindingImpl;
import media.tiger.tigerbox.databinding.ItemTimersLimitsCustomBindingImpl;
import media.tiger.tigerbox.databinding.ItemTimersLimitsSpecificBindingImpl;
import media.tiger.tigerbox.databinding.ItemTimersSetupClickableTitleBindingImpl;
import media.tiger.tigerbox.databinding.ItemTimersSetupClickableValueBindingImpl;
import media.tiger.tigerbox.databinding.ItemTimersSetupTitleBindingImpl;
import media.tiger.tigerbox.databinding.ItemWifiListBindingImpl;
import media.tiger.tigerbox.databinding.MediaPlayerCoverBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_FRAGMENTFULLSCREENSEEKBAR = 1;
    private static final int LAYOUT_FRAGMENTHEADERBAR = 2;
    private static final int LAYOUT_FRAGMENTINFODIALOG = 3;
    private static final int LAYOUT_FRAGMENTMEDIAPLAYER = 4;
    private static final int LAYOUT_FRAGMENTMEDIAPLAYERFULLSCREENCOVER = 5;
    private static final int LAYOUT_FRAGMENTMINIPLAYER = 6;
    private static final int LAYOUT_FRAGMENTMINIPROFILES = 7;
    private static final int LAYOUT_FRAGMENTONBOARDINGBACKENDRESPONSE = 8;
    private static final int LAYOUT_FRAGMENTONBOARDINGBATTERYWARNING = 9;
    private static final int LAYOUT_FRAGMENTONBOARDINGLOGIN = 10;
    private static final int LAYOUT_FRAGMENTONBOARDINGUPDATESTART = 11;
    private static final int LAYOUT_FRAGMENTOTAUPDATEINPROGRESS = 12;
    private static final int LAYOUT_FRAGMENTPARENTALGATE = 13;
    private static final int LAYOUT_FRAGMENTPROFILEPICTURE = 14;
    private static final int LAYOUT_FRAGMENTPROFILES = 15;
    private static final int LAYOUT_FRAGMENTSENDLOGSFINISHED = 16;
    private static final int LAYOUT_FRAGMENTSENDLOGSNONE = 17;
    private static final int LAYOUT_FRAGMENTSETTINGS = 18;
    private static final int LAYOUT_FRAGMENTTICKETREDEEMTICKETNUMBERINPUT = 19;
    private static final int LAYOUT_FRAGMENTTIGERTICKETINPUTPIN = 20;
    private static final int LAYOUT_FRAGMENTTIGERTICKETPURCHASE = 21;
    private static final int LAYOUT_FRAGMENTTIMERSLIMIT = 22;
    private static final int LAYOUT_FRAGMENTTIMERSSETUP = 23;
    private static final int LAYOUT_FRAGMENTTIMERSWINDOW = 24;
    private static final int LAYOUT_FRAGMENTWIFIENTERPASSWORD = 25;
    private static final int LAYOUT_FRAGMENTWILDCARDREASSIGNINGSTEP4 = 26;
    private static final int LAYOUT_INCLUDEDIALOGHEADERBAR = 27;
    private static final int LAYOUT_INCLUDEMEDIAPLAYER = 28;
    private static final int LAYOUT_INCLUDEMEDIAPLAYERCONTROLS = 29;
    private static final int LAYOUT_INCLUDEPLAYERDEVICECONTROLS = 30;
    private static final int LAYOUT_INCLUDEPLAYERTRACKCONTROLS = 31;
    private static final int LAYOUT_INCLUDEPROFILES = 32;
    private static final int LAYOUT_ITEMCHAPTERLIST = 33;
    private static final int LAYOUT_ITEMFOOTER = 34;
    private static final int LAYOUT_ITEMPRODUCT = 35;
    private static final int LAYOUT_ITEMPRODUCTACTION = 36;
    private static final int LAYOUT_ITEMPRODUCTROW = 37;
    private static final int LAYOUT_ITEMPROFILE = 38;
    private static final int LAYOUT_ITEMSETTINGS = 39;
    private static final int LAYOUT_ITEMSETTINGSCIRCLEPROGRESS = 40;
    private static final int LAYOUT_ITEMSYSTEMINFO = 41;
    private static final int LAYOUT_ITEMTIMERSLIMITSCUSTOM = 42;
    private static final int LAYOUT_ITEMTIMERSLIMITSSPECIFIC = 43;
    private static final int LAYOUT_ITEMTIMERSSETUPCLICKABLETITLE = 44;
    private static final int LAYOUT_ITEMTIMERSSETUPCLICKABLEVALUE = 45;
    private static final int LAYOUT_ITEMTIMERSSETUPTITLE = 46;
    private static final int LAYOUT_ITEMWIFILIST = 47;
    private static final int LAYOUT_MEDIAPLAYERCOVER = 48;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(48);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(C2814R.C2819layout.fragment_fullscreen_seekbar, 1);
        sparseIntArray.put(C2814R.C2819layout.fragment_header_bar, 2);
        sparseIntArray.put(C2814R.C2819layout.fragment_info_dialog, 3);
        sparseIntArray.put(C2814R.C2819layout.fragment_media_player, 4);
        sparseIntArray.put(C2814R.C2819layout.fragment_media_player_fullscreen_cover, 5);
        sparseIntArray.put(C2814R.C2819layout.fragment_mini_player, 6);
        sparseIntArray.put(C2814R.C2819layout.fragment_mini_profiles, 7);
        sparseIntArray.put(C2814R.C2819layout.fragment_onboarding_backend_response, 8);
        sparseIntArray.put(C2814R.C2819layout.fragment_onboarding_battery_warning, 9);
        sparseIntArray.put(C2814R.C2819layout.fragment_onboarding_login, 10);
        sparseIntArray.put(C2814R.C2819layout.fragment_onboarding_update_start, 11);
        sparseIntArray.put(C2814R.C2819layout.fragment_ota_update_in_progress, 12);
        sparseIntArray.put(C2814R.C2819layout.fragment_parental_gate, 13);
        sparseIntArray.put(C2814R.C2819layout.fragment_profile_picture, 14);
        sparseIntArray.put(C2814R.C2819layout.fragment_profiles, 15);
        sparseIntArray.put(C2814R.C2819layout.fragment_send_logs_finished, 16);
        sparseIntArray.put(C2814R.C2819layout.fragment_send_logs_none, 17);
        sparseIntArray.put(C2814R.C2819layout.fragment_settings, 18);
        sparseIntArray.put(C2814R.C2819layout.fragment_ticket_redeem_ticket_number_input, 19);
        sparseIntArray.put(C2814R.C2819layout.fragment_tiger_ticket_input_pin, 20);
        sparseIntArray.put(C2814R.C2819layout.fragment_tiger_ticket_purchase, 21);
        sparseIntArray.put(C2814R.C2819layout.fragment_timers_limit, 22);
        sparseIntArray.put(C2814R.C2819layout.fragment_timers_setup, 23);
        sparseIntArray.put(C2814R.C2819layout.fragment_timers_window, 24);
        sparseIntArray.put(C2814R.C2819layout.fragment_wifi_enter_password, 25);
        sparseIntArray.put(C2814R.C2819layout.fragment_wildcard_reassigning_step4, 26);
        sparseIntArray.put(C2814R.C2819layout.include_dialog_header_bar, 27);
        sparseIntArray.put(C2814R.C2819layout.include_media_player, 28);
        sparseIntArray.put(C2814R.C2819layout.include_media_player_controls, 29);
        sparseIntArray.put(C2814R.C2819layout.include_player_device_controls, 30);
        sparseIntArray.put(C2814R.C2819layout.include_player_track_controls, 31);
        sparseIntArray.put(C2814R.C2819layout.include_profiles, 32);
        sparseIntArray.put(C2814R.C2819layout.item_chapter_list, 33);
        sparseIntArray.put(C2814R.C2819layout.item_footer, 34);
        sparseIntArray.put(C2814R.C2819layout.item_product, 35);
        sparseIntArray.put(C2814R.C2819layout.item_product_action, 36);
        sparseIntArray.put(C2814R.C2819layout.item_product_row, 37);
        sparseIntArray.put(C2814R.C2819layout.item_profile, 38);
        sparseIntArray.put(C2814R.C2819layout.item_settings, 39);
        sparseIntArray.put(C2814R.C2819layout.item_settings_circle_progress, 40);
        sparseIntArray.put(C2814R.C2819layout.item_system_info, 41);
        sparseIntArray.put(C2814R.C2819layout.item_timers_limits_custom, 42);
        sparseIntArray.put(C2814R.C2819layout.item_timers_limits_specific, 43);
        sparseIntArray.put(C2814R.C2819layout.item_timers_setup_clickable_title, 44);
        sparseIntArray.put(C2814R.C2819layout.item_timers_setup_clickable_value, 45);
        sparseIntArray.put(C2814R.C2819layout.item_timers_setup_title, 46);
        sparseIntArray.put(C2814R.C2819layout.item_wifi_list, 47);
        sparseIntArray.put(C2814R.C2819layout.media_player_cover, 48);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i2) {
                case 1:
                    if ("layout/fragment_fullscreen_seekbar_0".equals(tag)) {
                        return new FragmentFullscreenSeekbarBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_fullscreen_seekbar is invalid. Received: " + tag);
                case 2:
                    if ("layout/fragment_header_bar_0".equals(tag)) {
                        return new FragmentHeaderBarBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_header_bar is invalid. Received: " + tag);
                case 3:
                    if ("layout/fragment_info_dialog_0".equals(tag)) {
                        return new FragmentInfoDialogBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_info_dialog is invalid. Received: " + tag);
                case 4:
                    if ("layout/fragment_media_player_0".equals(tag)) {
                        return new FragmentMediaPlayerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_media_player is invalid. Received: " + tag);
                case 5:
                    if ("layout/fragment_media_player_fullscreen_cover_0".equals(tag)) {
                        return new FragmentMediaPlayerFullscreenCoverBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_media_player_fullscreen_cover is invalid. Received: " + tag);
                case 6:
                    if ("layout/fragment_mini_player_0".equals(tag)) {
                        return new FragmentMiniPlayerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_mini_player is invalid. Received: " + tag);
                case 7:
                    if ("layout/fragment_mini_profiles_0".equals(tag)) {
                        return new FragmentMiniProfilesBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_mini_profiles is invalid. Received: " + tag);
                case 8:
                    if ("layout/fragment_onboarding_backend_response_0".equals(tag)) {
                        return new FragmentOnboardingBackendResponseBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_onboarding_backend_response is invalid. Received: " + tag);
                case 9:
                    if ("layout/fragment_onboarding_battery_warning_0".equals(tag)) {
                        return new FragmentOnboardingBatteryWarningBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_onboarding_battery_warning is invalid. Received: " + tag);
                case 10:
                    if ("layout/fragment_onboarding_login_0".equals(tag)) {
                        return new FragmentOnboardingLoginBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_onboarding_login is invalid. Received: " + tag);
                case 11:
                    if ("layout/fragment_onboarding_update_start_0".equals(tag)) {
                        return new FragmentOnboardingUpdateStartBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_onboarding_update_start is invalid. Received: " + tag);
                case 12:
                    if ("layout/fragment_ota_update_in_progress_0".equals(tag)) {
                        return new FragmentOtaUpdateInProgressBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_ota_update_in_progress is invalid. Received: " + tag);
                case 13:
                    if ("layout/fragment_parental_gate_0".equals(tag)) {
                        return new FragmentParentalGateBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_parental_gate is invalid. Received: " + tag);
                case 14:
                    if ("layout/fragment_profile_picture_0".equals(tag)) {
                        return new FragmentProfilePictureBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_profile_picture is invalid. Received: " + tag);
                case 15:
                    if ("layout/fragment_profiles_0".equals(tag)) {
                        return new FragmentProfilesBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_profiles is invalid. Received: " + tag);
                case 16:
                    if ("layout/fragment_send_logs_finished_0".equals(tag)) {
                        return new FragmentSendLogsFinishedBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_send_logs_finished is invalid. Received: " + tag);
                case 17:
                    if ("layout/fragment_send_logs_none_0".equals(tag)) {
                        return new FragmentSendLogsNoneBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_send_logs_none is invalid. Received: " + tag);
                case 18:
                    if ("layout/fragment_settings_0".equals(tag)) {
                        return new FragmentSettingsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_settings is invalid. Received: " + tag);
                case 19:
                    if ("layout/fragment_ticket_redeem_ticket_number_input_0".equals(tag)) {
                        return new FragmentTicketRedeemTicketNumberInputBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_ticket_redeem_ticket_number_input is invalid. Received: " + tag);
                case 20:
                    if ("layout/fragment_tiger_ticket_input_pin_0".equals(tag)) {
                        return new FragmentTigerTicketInputPinBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_tiger_ticket_input_pin is invalid. Received: " + tag);
                case 21:
                    if ("layout/fragment_tiger_ticket_purchase_0".equals(tag)) {
                        return new FragmentTigerTicketPurchaseBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_tiger_ticket_purchase is invalid. Received: " + tag);
                case 22:
                    if ("layout/fragment_timers_limit_0".equals(tag)) {
                        return new FragmentTimersLimitBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_timers_limit is invalid. Received: " + tag);
                case 23:
                    if ("layout/fragment_timers_setup_0".equals(tag)) {
                        return new FragmentTimersSetupBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_timers_setup is invalid. Received: " + tag);
                case 24:
                    if ("layout/fragment_timers_window_0".equals(tag)) {
                        return new FragmentTimersWindowBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_timers_window is invalid. Received: " + tag);
                case 25:
                    if ("layout/fragment_wifi_enter_password_0".equals(tag)) {
                        return new FragmentWifiEnterPasswordBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_wifi_enter_password is invalid. Received: " + tag);
                case 26:
                    if ("layout/fragment_wildcard_reassigning_step4_0".equals(tag)) {
                        return new FragmentWildcardReassigningStep4BindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_wildcard_reassigning_step4 is invalid. Received: " + tag);
                case 27:
                    if ("layout/include_dialog_header_bar_0".equals(tag)) {
                        return new IncludeDialogHeaderBarBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for include_dialog_header_bar is invalid. Received: " + tag);
                case 28:
                    if ("layout/include_media_player_0".equals(tag)) {
                        return new IncludeMediaPlayerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for include_media_player is invalid. Received: " + tag);
                case 29:
                    if ("layout/include_media_player_controls_0".equals(tag)) {
                        return new IncludeMediaPlayerControlsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for include_media_player_controls is invalid. Received: " + tag);
                case 30:
                    if ("layout/include_player_device_controls_0".equals(tag)) {
                        return new IncludePlayerDeviceControlsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for include_player_device_controls is invalid. Received: " + tag);
                case 31:
                    if ("layout/include_player_track_controls_0".equals(tag)) {
                        return new IncludePlayerTrackControlsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for include_player_track_controls is invalid. Received: " + tag);
                case 32:
                    if ("layout/include_profiles_0".equals(tag)) {
                        return new IncludeProfilesBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for include_profiles is invalid. Received: " + tag);
                case 33:
                    if ("layout/item_chapter_list_0".equals(tag)) {
                        return new ItemChapterListBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_chapter_list is invalid. Received: " + tag);
                case 34:
                    if ("layout/item_footer_0".equals(tag)) {
                        return new ItemFooterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_footer is invalid. Received: " + tag);
                case 35:
                    if ("layout/item_product_0".equals(tag)) {
                        return new ItemProductBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_product is invalid. Received: " + tag);
                case 36:
                    if ("layout/item_product_action_0".equals(tag)) {
                        return new ItemProductActionBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_product_action is invalid. Received: " + tag);
                case 37:
                    if ("layout/item_product_row_0".equals(tag)) {
                        return new ItemProductRowBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_product_row is invalid. Received: " + tag);
                case 38:
                    if ("layout/item_profile_0".equals(tag)) {
                        return new ItemProfileBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_profile is invalid. Received: " + tag);
                case 39:
                    if ("layout/item_settings_0".equals(tag)) {
                        return new ItemSettingsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_settings is invalid. Received: " + tag);
                case 40:
                    if ("layout/item_settings_circle_progress_0".equals(tag)) {
                        return new ItemSettingsCircleProgressBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_settings_circle_progress is invalid. Received: " + tag);
                case 41:
                    if ("layout/item_system_info_0".equals(tag)) {
                        return new ItemSystemInfoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_system_info is invalid. Received: " + tag);
                case 42:
                    if ("layout/item_timers_limits_custom_0".equals(tag)) {
                        return new ItemTimersLimitsCustomBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_timers_limits_custom is invalid. Received: " + tag);
                case 43:
                    if ("layout/item_timers_limits_specific_0".equals(tag)) {
                        return new ItemTimersLimitsSpecificBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_timers_limits_specific is invalid. Received: " + tag);
                case 44:
                    if ("layout/item_timers_setup_clickable_title_0".equals(tag)) {
                        return new ItemTimersSetupClickableTitleBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_timers_setup_clickable_title is invalid. Received: " + tag);
                case 45:
                    if ("layout/item_timers_setup_clickable_value_0".equals(tag)) {
                        return new ItemTimersSetupClickableValueBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_timers_setup_clickable_value is invalid. Received: " + tag);
                case 46:
                    if ("layout/item_timers_setup_title_0".equals(tag)) {
                        return new ItemTimersSetupTitleBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_timers_setup_title is invalid. Received: " + tag);
                case 47:
                    if ("layout/item_wifi_list_0".equals(tag)) {
                        return new ItemWifiListBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_wifi_list is invalid. Received: " + tag);
                case 48:
                    if ("layout/media_player_cover_0".equals(tag)) {
                        return new MediaPlayerCoverBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for media_player_cover is invalid. Received: " + tag);
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(61);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "acceptButtonListener");
            sparseArray.put(2, "accountPin");
            sparseArray.put(3, "attemptCount");
            sparseArray.put(4, "audioCoverClickListener");
            sparseArray.put(5, "audioProduct");
            sparseArray.put(6, "backSpaceListener");
            sparseArray.put(7, "batteryPercent");
            sparseArray.put(8, "batterySummary");
            sparseArray.put(9, "bindingProduct");
            sparseArray.put(10, "cancelListener");
            sparseArray.put(11, "cancellable");
            sparseArray.put(12, "chapterClickListener");
            sparseArray.put(13, "chapterItem");
            sparseArray.put(14, "clickListener");
            sparseArray.put(15, "closeButtonVisible");
            sparseArray.put(16, "closeHandler");
            sparseArray.put(17, "downloadsInProgress");
            sparseArray.put(18, "exitButtonListener");
            sparseArray.put(19, "firmwareUpdateAvailable");
            sparseArray.put(20, "footerClickListener");
            sparseArray.put(21, "footerRowId");
            sparseArray.put(22, "hasError");
            sparseArray.put(23, "hasRandomPin");
            sparseArray.put(24, "imageUrl");
            sparseArray.put(25, "isCharging");
            sparseArray.put(26, "isPlaying");
            sparseArray.put(27, "item");
            sparseArray.put(28, "layoutTitle");
            sparseArray.put(29, "layoutTitleIdx");
            sparseArray.put(30, "lightControlEnabled");
            sparseArray.put(31, "navigateListener");
            sparseArray.put(32, "navigateToMediaPlayer");
            sparseArray.put(33, "nickName");
            sparseArray.put(34, "numberClickListener");
            sparseArray.put(35, "password");
            sparseArray.put(36, "pinText");
            sparseArray.put(37, "playing");
            sparseArray.put(38, "productRow");
            sparseArray.put(39, "profile");
            sparseArray.put(40, "profileClickListener");
            sparseArray.put(41, "profileItem");
            sparseArray.put(42, "selected");
            sparseArray.put(43, "settingsClickListener");
            sparseArray.put(44, "settingsOpened");
            sparseArray.put(45, "subscriptionAboutToExpired");
            sparseArray.put(46, "subscriptionEndDate");
            sparseArray.put(47, "subscriptionExpired");
            sparseArray.put(48, "subscriptionVisible");
            sparseArray.put(49, "systemInfoItem");
            sparseArray.put(50, "timersSetupItem");
            sparseArray.put(51, "timersTimeLimitItem");
            sparseArray.put(52, "titleVisible");
            sparseArray.put(53, "trackPosition");
            sparseArray.put(54, "trackProgress");
            sparseArray.put(55, "trackRemaining");
            sparseArray.put(56, "updateAvailableClickListener");
            sparseArray.put(57, "updateLabel");
            sparseArray.put(58, "updatePercent");
            sparseArray.put(59, "wifiItem");
            sparseArray.put(60, "wifiName");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(48);
            sKeys = hashMap;
            hashMap.put("layout/fragment_fullscreen_seekbar_0", Integer.valueOf(C2814R.C2819layout.fragment_fullscreen_seekbar));
            hashMap.put("layout/fragment_header_bar_0", Integer.valueOf(C2814R.C2819layout.fragment_header_bar));
            hashMap.put("layout/fragment_info_dialog_0", Integer.valueOf(C2814R.C2819layout.fragment_info_dialog));
            hashMap.put("layout/fragment_media_player_0", Integer.valueOf(C2814R.C2819layout.fragment_media_player));
            hashMap.put("layout/fragment_media_player_fullscreen_cover_0", Integer.valueOf(C2814R.C2819layout.fragment_media_player_fullscreen_cover));
            hashMap.put("layout/fragment_mini_player_0", Integer.valueOf(C2814R.C2819layout.fragment_mini_player));
            hashMap.put("layout/fragment_mini_profiles_0", Integer.valueOf(C2814R.C2819layout.fragment_mini_profiles));
            hashMap.put("layout/fragment_onboarding_backend_response_0", Integer.valueOf(C2814R.C2819layout.fragment_onboarding_backend_response));
            hashMap.put("layout/fragment_onboarding_battery_warning_0", Integer.valueOf(C2814R.C2819layout.fragment_onboarding_battery_warning));
            hashMap.put("layout/fragment_onboarding_login_0", Integer.valueOf(C2814R.C2819layout.fragment_onboarding_login));
            hashMap.put("layout/fragment_onboarding_update_start_0", Integer.valueOf(C2814R.C2819layout.fragment_onboarding_update_start));
            hashMap.put("layout/fragment_ota_update_in_progress_0", Integer.valueOf(C2814R.C2819layout.fragment_ota_update_in_progress));
            hashMap.put("layout/fragment_parental_gate_0", Integer.valueOf(C2814R.C2819layout.fragment_parental_gate));
            hashMap.put("layout/fragment_profile_picture_0", Integer.valueOf(C2814R.C2819layout.fragment_profile_picture));
            hashMap.put("layout/fragment_profiles_0", Integer.valueOf(C2814R.C2819layout.fragment_profiles));
            hashMap.put("layout/fragment_send_logs_finished_0", Integer.valueOf(C2814R.C2819layout.fragment_send_logs_finished));
            hashMap.put("layout/fragment_send_logs_none_0", Integer.valueOf(C2814R.C2819layout.fragment_send_logs_none));
            hashMap.put("layout/fragment_settings_0", Integer.valueOf(C2814R.C2819layout.fragment_settings));
            hashMap.put("layout/fragment_ticket_redeem_ticket_number_input_0", Integer.valueOf(C2814R.C2819layout.fragment_ticket_redeem_ticket_number_input));
            hashMap.put("layout/fragment_tiger_ticket_input_pin_0", Integer.valueOf(C2814R.C2819layout.fragment_tiger_ticket_input_pin));
            hashMap.put("layout/fragment_tiger_ticket_purchase_0", Integer.valueOf(C2814R.C2819layout.fragment_tiger_ticket_purchase));
            hashMap.put("layout/fragment_timers_limit_0", Integer.valueOf(C2814R.C2819layout.fragment_timers_limit));
            hashMap.put("layout/fragment_timers_setup_0", Integer.valueOf(C2814R.C2819layout.fragment_timers_setup));
            hashMap.put("layout/fragment_timers_window_0", Integer.valueOf(C2814R.C2819layout.fragment_timers_window));
            hashMap.put("layout/fragment_wifi_enter_password_0", Integer.valueOf(C2814R.C2819layout.fragment_wifi_enter_password));
            hashMap.put("layout/fragment_wildcard_reassigning_step4_0", Integer.valueOf(C2814R.C2819layout.fragment_wildcard_reassigning_step4));
            hashMap.put("layout/include_dialog_header_bar_0", Integer.valueOf(C2814R.C2819layout.include_dialog_header_bar));
            hashMap.put("layout/include_media_player_0", Integer.valueOf(C2814R.C2819layout.include_media_player));
            hashMap.put("layout/include_media_player_controls_0", Integer.valueOf(C2814R.C2819layout.include_media_player_controls));
            hashMap.put("layout/include_player_device_controls_0", Integer.valueOf(C2814R.C2819layout.include_player_device_controls));
            hashMap.put("layout/include_player_track_controls_0", Integer.valueOf(C2814R.C2819layout.include_player_track_controls));
            hashMap.put("layout/include_profiles_0", Integer.valueOf(C2814R.C2819layout.include_profiles));
            hashMap.put("layout/item_chapter_list_0", Integer.valueOf(C2814R.C2819layout.item_chapter_list));
            hashMap.put("layout/item_footer_0", Integer.valueOf(C2814R.C2819layout.item_footer));
            hashMap.put("layout/item_product_0", Integer.valueOf(C2814R.C2819layout.item_product));
            hashMap.put("layout/item_product_action_0", Integer.valueOf(C2814R.C2819layout.item_product_action));
            hashMap.put("layout/item_product_row_0", Integer.valueOf(C2814R.C2819layout.item_product_row));
            hashMap.put("layout/item_profile_0", Integer.valueOf(C2814R.C2819layout.item_profile));
            hashMap.put("layout/item_settings_0", Integer.valueOf(C2814R.C2819layout.item_settings));
            hashMap.put("layout/item_settings_circle_progress_0", Integer.valueOf(C2814R.C2819layout.item_settings_circle_progress));
            hashMap.put("layout/item_system_info_0", Integer.valueOf(C2814R.C2819layout.item_system_info));
            hashMap.put("layout/item_timers_limits_custom_0", Integer.valueOf(C2814R.C2819layout.item_timers_limits_custom));
            hashMap.put("layout/item_timers_limits_specific_0", Integer.valueOf(C2814R.C2819layout.item_timers_limits_specific));
            hashMap.put("layout/item_timers_setup_clickable_title_0", Integer.valueOf(C2814R.C2819layout.item_timers_setup_clickable_title));
            hashMap.put("layout/item_timers_setup_clickable_value_0", Integer.valueOf(C2814R.C2819layout.item_timers_setup_clickable_value));
            hashMap.put("layout/item_timers_setup_title_0", Integer.valueOf(C2814R.C2819layout.item_timers_setup_title));
            hashMap.put("layout/item_wifi_list_0", Integer.valueOf(C2814R.C2819layout.item_wifi_list));
            hashMap.put("layout/media_player_cover_0", Integer.valueOf(C2814R.C2819layout.media_player_cover));
        }
    }
}
