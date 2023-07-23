package media.tiger.tigerbox.model.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.spongycastle.i18n.MessageBundle;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010$\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eBQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003Je\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0005HÆ\u0001J\u0013\u0010/\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u00101\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0005H\u0002J\t\u00103\u001a\u00020\u0003HÖ\u0001J\u0006\u00104\u001a\u00020\u0017J\u0014\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000506H\u0002J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001b¨\u00068"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/ProductRowDomain;", "", "id", "", "title", "", "layoutItemType", "Lmedia/tiger/tigerbox/model/domain/ProductRowType;", "productSourceType", "bannerProducts", "", "Lmedia/tiger/tigerbox/model/domain/BannerProductDomain;", "(ILjava/lang/String;Lmedia/tiger/tigerbox/model/domain/ProductRowType;Ljava/lang/String;Ljava/util/List;)V", "url", "(ILjava/lang/String;Lmedia/tiger/tigerbox/model/domain/ProductRowType;Ljava/lang/String;Ljava/lang/String;)V", "products", "", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "headerResponseLink", "(ILjava/lang/String;Lmedia/tiger/tigerbox/model/domain/ProductRowType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getBannerProducts", "()Ljava/util/List;", "hasLoadMore", "", "getHasLoadMore", "()Z", "getHeaderResponseLink", "()Ljava/lang/String;", "setHeaderResponseLink", "(Ljava/lang/String;)V", "getId", "()I", "getLayoutItemType", "()Lmedia/tiger/tigerbox/model/domain/ProductRowType;", "getProductSourceType", "getProducts", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "getNextLink", "link", "hashCode", "isOfflineRowType", "parseLink", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProductRowDomain.kt */
public final class ProductRowDomain {
    private final List<BannerProductDomain> bannerProducts;
    private String headerResponseLink;

    /* renamed from: id */
    private final int f629id;
    private final ProductRowType layoutItemType;
    private final String productSourceType;
    private final List<ProductDomain> products;
    private final String title;
    private final String url;

    public static /* synthetic */ ProductRowDomain copy$default(ProductRowDomain productRowDomain, int i, String str, ProductRowType productRowType, String str2, String str3, List list, List list2, String str4, int i2, Object obj) {
        ProductRowDomain productRowDomain2 = productRowDomain;
        int i3 = i2;
        return productRowDomain.copy((i3 & 1) != 0 ? productRowDomain2.f629id : i, (i3 & 2) != 0 ? productRowDomain2.title : str, (i3 & 4) != 0 ? productRowDomain2.layoutItemType : productRowType, (i3 & 8) != 0 ? productRowDomain2.productSourceType : str2, (i3 & 16) != 0 ? productRowDomain2.url : str3, (i3 & 32) != 0 ? productRowDomain2.products : list, (i3 & 64) != 0 ? productRowDomain2.bannerProducts : list2, (i3 & 128) != 0 ? productRowDomain2.headerResponseLink : str4);
    }

    public final int component1() {
        return this.f629id;
    }

    public final String component2() {
        return this.title;
    }

    public final ProductRowType component3() {
        return this.layoutItemType;
    }

    public final String component4() {
        return this.productSourceType;
    }

    public final String component5() {
        return this.url;
    }

    public final List<ProductDomain> component6() {
        return this.products;
    }

    public final List<BannerProductDomain> component7() {
        return this.bannerProducts;
    }

    public final String component8() {
        return this.headerResponseLink;
    }

    public final ProductRowDomain copy(int i, String str, ProductRowType productRowType, String str2, String str3, List<ProductDomain> list, List<BannerProductDomain> list2, String str4) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(productRowType, "layoutItemType");
        Intrinsics.checkNotNullParameter(str2, "productSourceType");
        Intrinsics.checkNotNullParameter(str3, "url");
        List<ProductDomain> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "products");
        List<BannerProductDomain> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "bannerProducts");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "headerResponseLink");
        return new ProductRowDomain(i, str, productRowType, str2, str3, list3, list4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductRowDomain)) {
            return false;
        }
        ProductRowDomain productRowDomain = (ProductRowDomain) obj;
        return this.f629id == productRowDomain.f629id && Intrinsics.areEqual((Object) this.title, (Object) productRowDomain.title) && this.layoutItemType == productRowDomain.layoutItemType && Intrinsics.areEqual((Object) this.productSourceType, (Object) productRowDomain.productSourceType) && Intrinsics.areEqual((Object) this.url, (Object) productRowDomain.url) && Intrinsics.areEqual((Object) this.products, (Object) productRowDomain.products) && Intrinsics.areEqual((Object) this.bannerProducts, (Object) productRowDomain.bannerProducts) && Intrinsics.areEqual((Object) this.headerResponseLink, (Object) productRowDomain.headerResponseLink);
    }

    public int hashCode() {
        return (((((((((((((this.f629id * 31) + this.title.hashCode()) * 31) + this.layoutItemType.hashCode()) * 31) + this.productSourceType.hashCode()) * 31) + this.url.hashCode()) * 31) + this.products.hashCode()) * 31) + this.bannerProducts.hashCode()) * 31) + this.headerResponseLink.hashCode();
    }

    public String toString() {
        return "ProductRowDomain(id=" + this.f629id + ", title=" + this.title + ", layoutItemType=" + this.layoutItemType + ", productSourceType=" + this.productSourceType + ", url=" + this.url + ", products=" + this.products + ", bannerProducts=" + this.bannerProducts + ", headerResponseLink=" + this.headerResponseLink + ')';
    }

    public ProductRowDomain(int i, String str, ProductRowType productRowType, String str2, String str3, List<ProductDomain> list, List<BannerProductDomain> list2, String str4) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(productRowType, "layoutItemType");
        Intrinsics.checkNotNullParameter(str2, "productSourceType");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(list2, "bannerProducts");
        Intrinsics.checkNotNullParameter(str4, "headerResponseLink");
        this.f629id = i;
        this.title = str;
        this.layoutItemType = productRowType;
        this.productSourceType = str2;
        this.url = str3;
        this.products = list;
        this.bannerProducts = list2;
        this.headerResponseLink = str4;
    }

    public final int getId() {
        return this.f629id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ProductRowType getLayoutItemType() {
        return this.layoutItemType;
    }

    public final String getProductSourceType() {
        return this.productSourceType;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<ProductDomain> getProducts() {
        return this.products;
    }

    public final List<BannerProductDomain> getBannerProducts() {
        return this.bannerProducts;
    }

    public final String getHeaderResponseLink() {
        return this.headerResponseLink;
    }

    public final void setHeaderResponseLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headerResponseLink = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProductRowDomain(int i, String str, ProductRowType productRowType, String str2, List<BannerProductDomain> list) {
        this(i, str, productRowType, str2, "", new ArrayList(), list, "");
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(productRowType, "layoutItemType");
        Intrinsics.checkNotNullParameter(str2, "productSourceType");
        Intrinsics.checkNotNullParameter(list, "bannerProducts");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProductRowDomain(int i, String str, ProductRowType productRowType, String str2, String str3) {
        this(i, str, productRowType, str2, str3, new ArrayList(), new ArrayList(), "");
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(productRowType, "layoutItemType");
        Intrinsics.checkNotNullParameter(str2, "productSourceType");
        Intrinsics.checkNotNullParameter(str3, "url");
    }

    public final boolean getHasLoadMore() {
        return hasLoadMore(this.headerResponseLink);
    }

    private final boolean hasLoadMore(String str) {
        CharSequence charSequence = str;
        return (charSequence.length() > 0) && StringsKt.contains$default(charSequence, (CharSequence) "rel=\"next\"", false, 2, (Object) null);
    }

    private final Map<String, String> parseLink() {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        try {
            for (String split$default : StringsKt.split$default((CharSequence) this.headerResponseLink, new String[]{","}, true, 0, 4, (Object) null)) {
                List split$default2 = StringsKt.split$default((CharSequence) split$default, new String[]{";"}, true, 0, 4, (Object) null);
                String removeSuffix = StringsKt.removeSuffix(StringsKt.removePrefix((String) CollectionsKt.first(split$default2), (CharSequence) "<"), (CharSequence) ">");
                if (StringsKt.contains$default((CharSequence) CollectionsKt.last(split$default2), (CharSequence) "first", false, 2, (Object) null)) {
                    linkedHashMap.put("first", removeSuffix);
                } else if (StringsKt.contains$default((CharSequence) CollectionsKt.last(split$default2), (CharSequence) "last", false, 2, (Object) null)) {
                    linkedHashMap.put("last", removeSuffix);
                } else if (StringsKt.contains$default((CharSequence) CollectionsKt.last(split$default2), (CharSequence) "next", false, 2, (Object) null)) {
                    linkedHashMap.put("next", removeSuffix);
                } else if (StringsKt.contains$default((CharSequence) CollectionsKt.last(split$default2), (CharSequence) "prev", false, 2, (Object) null)) {
                    linkedHashMap.put("prev", removeSuffix);
                }
            }
        } catch (Exception e) {
            Timber.Tree tag = Timber.Forest.tag("ProductRowDomaing");
            tag.mo50217e("Exception while parsing link " + e, new Object[0]);
        }
        return linkedHashMap;
    }

    public final String getNextLink() {
        String str = parseLink().get("next");
        return str == null ? "" : str;
    }

    public final boolean isOfflineRowType() {
        return this.layoutItemType == ProductRowType.RESOURCE && Intrinsics.areEqual((Object) this.productSourceType, (Object) ProductRowDomainKt.OFFLINE_CONTENT);
    }
}
