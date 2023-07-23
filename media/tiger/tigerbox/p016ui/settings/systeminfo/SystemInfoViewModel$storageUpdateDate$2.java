package media.tiger.tigerbox.p016ui.settings.systeminfo;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo33737d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel$storageUpdateDate$2 */
/* compiled from: SystemInfoViewModel.kt */
final class SystemInfoViewModel$storageUpdateDate$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ SystemInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SystemInfoViewModel$storageUpdateDate$2(SystemInfoViewModel systemInfoViewModel) {
        super(0);
        this.this$0 = systemInfoViewModel;
    }

    public final Long invoke() {
        return Long.valueOf(this.this$0.storageService.getUpdateDate().getTime());
    }
}
