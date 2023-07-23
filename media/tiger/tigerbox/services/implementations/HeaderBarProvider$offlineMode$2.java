package media.tiger.tigerbox.services.implementations;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeaderBarProvider.kt */
final class HeaderBarProvider$offlineMode$2 extends Lambda implements Function0<LiveData<Boolean>> {
    final /* synthetic */ HeaderBarProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeaderBarProvider$offlineMode$2(HeaderBarProvider headerBarProvider) {
        super(0);
        this.this$0 = headerBarProvider;
    }

    public final LiveData<Boolean> invoke() {
        return this.this$0.getWifiService().getOfflineMode();
    }
}
