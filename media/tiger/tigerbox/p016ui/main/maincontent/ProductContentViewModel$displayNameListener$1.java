package media.tiger.tigerbox.p016ui.main.maincontent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.DisplayNameChangedListener;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$displayNameListener$1", "Lmedia/tiger/tigerbox/services/interfaces/DisplayNameChangedListener;", "onDisplayNameChanged", "", "name", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$displayNameListener$1 */
/* compiled from: ProductContentViewModel.kt */
public final class ProductContentViewModel$displayNameListener$1 implements DisplayNameChangedListener {
    final /* synthetic */ ProductContentViewModel this$0;

    ProductContentViewModel$displayNameListener$1(ProductContentViewModel productContentViewModel) {
        this.this$0 = productContentViewModel;
    }

    public void onDisplayNameChanged(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.this$0._deviceName.setValue(str);
    }
}
