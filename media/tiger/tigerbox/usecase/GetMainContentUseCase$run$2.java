package media.tiger.tigerbox.usecase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.BannerProductDomain;
import media.tiger.tigerbox.model.domain.ProductRowDomain;
import media.tiger.tigerbox.model.domain.ProductRowType;
import media.tiger.tigerbox.model.dto.MainContentItem;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, mo33737d2 = {"<anonymous>", "", "Lmedia/tiger/tigerbox/model/domain/ProductRowDomain;", "mainContentItemList", "Lmedia/tiger/tigerbox/model/dto/MainContentItem;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetMainContentUseCase.kt */
final class GetMainContentUseCase$run$2 extends Lambda implements Function1<List<? extends MainContentItem>, List<? extends ProductRowDomain>> {
    public static final GetMainContentUseCase$run$2 INSTANCE = new GetMainContentUseCase$run$2();

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: GetMainContentUseCase.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductRowType.values().length];
            iArr[ProductRowType.BANNER.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    GetMainContentUseCase$run$2() {
        super(1);
    }

    public final List<ProductRowDomain> invoke(List<MainContentItem> list) {
        ProductRowDomain productRowDomain;
        String str;
        String str2;
        String str3;
        List list2;
        List<MainContentItem.LayoutItem.Banner.Image> images;
        Intrinsics.checkNotNullParameter(list, "mainContentItemList");
        Iterable<MainContentItem.LayoutItem> sortedWith = CollectionsKt.sortedWith(((MainContentItem) CollectionsKt.first(list)).getLayoutItems(), new GetMainContentUseCase$run$2$invoke$$inlined$sortedBy$1());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (MainContentItem.LayoutItem layoutItem : sortedWith) {
            String layoutItemType = layoutItem.getLayoutItemType();
            if (layoutItemType == null) {
                layoutItemType = "";
            }
            ProductRowType access$mapLayoutType = GetMainContentUseCaseKt.mapLayoutType(layoutItemType);
            if (WhenMappings.$EnumSwitchMapping$0[access$mapLayoutType.ordinal()] == 1) {
                int ordinal = layoutItem.getOrdinal();
                String title = layoutItem.getTitle();
                String productSourceType = layoutItem.getProductSourceType();
                if (productSourceType == null) {
                    str3 = "";
                } else {
                    str3 = productSourceType;
                }
                MainContentItem.LayoutItem.Banner banner = layoutItem.getBanner();
                if (banner == null || (images = banner.getImages()) == null) {
                    list2 = CollectionsKt.emptyList();
                } else {
                    Iterable<MainContentItem.LayoutItem.Banner.Image> iterable = images;
                    Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (MainContentItem.LayoutItem.Banner.Image image : iterable) {
                        arrayList2.add(new BannerProductDomain(image.getOrdinal(), image.getTitle(), image.getHdImage(), image.getSdImage(), image.getUrl()));
                    }
                    list2 = (List) arrayList2;
                }
                productRowDomain = new ProductRowDomain(ordinal, title, access$mapLayoutType, str3, (List<BannerProductDomain>) list2);
            } else {
                int ordinal2 = layoutItem.getOrdinal();
                String title2 = layoutItem.getTitle();
                String productSourceType2 = layoutItem.getProductSourceType();
                if (productSourceType2 == null) {
                    str = "";
                } else {
                    str = productSourceType2;
                }
                String url = layoutItem.getUrl();
                if (url == null) {
                    str2 = "";
                } else {
                    str2 = url;
                }
                productRowDomain = new ProductRowDomain(ordinal2, title2, access$mapLayoutType, str, str2);
            }
            arrayList.add(productRowDomain);
        }
        return (List) arrayList;
    }
}
