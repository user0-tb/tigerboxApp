package media.tiger.tigerbox.p016ui.settings.systeminfo;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.C2814R;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "", "Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoItem;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoFragment$systemInfoItems$2 */
/* compiled from: SystemInfoFragment.kt */
final class SystemInfoFragment$systemInfoItems$2 extends Lambda implements Function0<List<? extends SystemInfoItem>> {
    final /* synthetic */ SystemInfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SystemInfoFragment$systemInfoItems$2(SystemInfoFragment systemInfoFragment) {
        super(0);
        this.this$0 = systemInfoFragment;
    }

    public final List<SystemInfoItem> invoke() {
        return CollectionsKt.listOf(new SystemInfoItem(C2814R.string.system_info_account_label, this.this$0.getSystemInfoViewModel().getUserEmail()), new SystemInfoItem(C2814R.string.system_info_ip_label, this.this$0.getSystemInfoViewModel().getIpAddress()), new SystemInfoItem(C2814R.string.system_info_mac_label, this.this$0.getSystemInfoViewModel().getMacAddress()), new SystemInfoItem(C2814R.string.system_info_cpuId_label, this.this$0.getSystemInfoViewModel().getCpuId()), new SystemInfoItem(C2814R.string.system_info_firmware_version_label, this.this$0.getSystemInfoViewModel().getSoftwareVersion()), new SystemInfoItem(C2814R.string.system_info_battery_percent, this.this$0.getSystemInfoViewModel().getBatteryPercentage() + '%'), new SystemInfoItem(C2814R.string.system_info_dish_space_available_label, this.this$0.getSystemInfoViewModel().getAvailableDiskSpace()), new SystemInfoItem(C2814R.string.system_info_dish_space_used_label, this.this$0.getSystemInfoViewModel().getUsedDiskSpace()));
    }
}
