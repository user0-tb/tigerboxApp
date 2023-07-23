package media.tiger.tigerbox.p016ui.settings.systeminfo;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel$ipAddress$2 */
/* compiled from: SystemInfoViewModel.kt */
final class SystemInfoViewModel$ipAddress$2 extends Lambda implements Function0<String> {
    final /* synthetic */ SystemInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SystemInfoViewModel$ipAddress$2(SystemInfoViewModel systemInfoViewModel) {
        super(0);
        this.this$0 = systemInfoViewModel;
    }

    public final String invoke() {
        return this.this$0.metaDataService.getIpAddress();
    }
}
