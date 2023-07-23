package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import media.tiger.tigerbox.model.domain.ProductRowType;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, mo33737d2 = {"mapLayoutType", "Lmedia/tiger/tigerbox/model/domain/ProductRowType;", "type", "", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetMainContentUseCase.kt */
public final class GetMainContentUseCaseKt {
    /* access modifiers changed from: private */
    public static final ProductRowType mapLayoutType(String str) {
        switch (str.hashCode()) {
            case -933809650:
                if (str.equals("PRODUCT_LIST")) {
                    return ProductRowType.PRODUCT_LIST;
                }
                break;
            case 77406376:
                if (str.equals("QUERY")) {
                    return ProductRowType.QUERY;
                }
                break;
            case 441562126:
                if (str.equals("RESOURCE")) {
                    return ProductRowType.RESOURCE;
                }
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    return ProductRowType.BANNER;
                }
                break;
        }
        return ProductRowType.INVALID;
    }
}
