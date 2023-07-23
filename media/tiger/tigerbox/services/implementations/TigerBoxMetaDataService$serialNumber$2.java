package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxMetaDataService.kt */
final class TigerBoxMetaDataService$serialNumber$2 extends Lambda implements Function0<String> {
    final /* synthetic */ TigerBoxMetaDataService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerBoxMetaDataService$serialNumber$2(TigerBoxMetaDataService tigerBoxMetaDataService) {
        super(0);
        this.this$0 = tigerBoxMetaDataService;
    }

    public final String invoke() {
        return this.this$0.getSystemProperty("ro.serialno");
    }
}
