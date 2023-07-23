package media.tiger.tigerbox.model.dto;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.spongycastle.i18n.MessageBundle;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ProductList;", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem;", "Lkotlin/collections/ArrayList;", "()V", "ProductItem", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProductList.kt */
public final class ProductList extends ArrayList<ProductItem> {

    @Metadata(mo33736d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b?\b\b\u0018\u00002\u00020\u0001:\u0004Z[\\]BÃ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0001\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0001HÆ\u0003J\t\u0010B\u001a\u00020\u0001HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\t\u0010E\u001a\u00020\u0016HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0001HÆ\u0003J\t\u0010H\u001a\u00020\u0001HÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u001cHÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\nHÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0001HÆ\u0003J\t\u0010T\u001a\u00020\u0001HÆ\u0003Jó\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u00012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001J\u0013\u0010V\u001a\u00020\n2\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\u0003HÖ\u0001J\t\u0010Y\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0011\u0010\u000f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\b\n\u0000\u001a\u0004\b7\u00106R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u0011\u0010\r\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010(R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(¨\u0006^"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem;", "", "id", "", "state", "", "title", "iapProductIdentifier", "publicationDate", "freemium", "", "ageMin", "ageMax", "requiredReaderVersion", "author", "lastNameOfFirstAuthor", "illustrator", "externalId", "prices", "", "Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Price;", "attributes", "Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Attributes;", "productType", "similarityCategory", "similarityCategoryCode", "productGroupIds", "metaData", "Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$MetaData;", "lastModifiedDate", "cover", "Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/util/List;Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Attributes;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/List;Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$MetaData;Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover;)V", "getAgeMax", "()Ljava/lang/Object;", "getAgeMin", "()I", "getAttributes", "()Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Attributes;", "getAuthor", "()Ljava/lang/String;", "getCover", "()Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover;", "getExternalId", "getFreemium", "()Z", "getIapProductIdentifier", "getId", "getIllustrator", "getLastModifiedDate", "getLastNameOfFirstAuthor", "getMetaData", "()Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$MetaData;", "getPrices", "()Ljava/util/List;", "getProductGroupIds", "getProductType", "getPublicationDate", "getRequiredReaderVersion", "getSimilarityCategory", "getSimilarityCategoryCode", "getState", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Attributes", "Cover", "MetaData", "Price", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ProductList.kt */
    public static final class ProductItem {
        private final Object ageMax;
        private final int ageMin;
        private final Attributes attributes;
        private final String author;
        private final Cover cover;
        private final String externalId;
        private final boolean freemium;
        private final String iapProductIdentifier;

        /* renamed from: id */
        private final int f642id;
        private final Object illustrator;
        private final String lastModifiedDate;
        private final Object lastNameOfFirstAuthor;
        private final MetaData metaData;
        private final List<Price> prices;
        private final List<Integer> productGroupIds;
        private final String productType;
        private final String publicationDate;
        private final Object requiredReaderVersion;
        private final Object similarityCategory;
        private final Object similarityCategoryCode;
        private final String state;
        private final String title;

        public static /* synthetic */ ProductItem copy$default(ProductItem productItem, int i, String str, String str2, String str3, String str4, boolean z, int i2, Object obj, Object obj2, String str5, Object obj3, Object obj4, String str6, List list, Attributes attributes2, String str7, Object obj5, Object obj6, List list2, MetaData metaData2, String str8, Cover cover2, int i3, Object obj7) {
            ProductItem productItem2 = productItem;
            int i4 = i3;
            return productItem.copy((i4 & 1) != 0 ? productItem2.f642id : i, (i4 & 2) != 0 ? productItem2.state : str, (i4 & 4) != 0 ? productItem2.title : str2, (i4 & 8) != 0 ? productItem2.iapProductIdentifier : str3, (i4 & 16) != 0 ? productItem2.publicationDate : str4, (i4 & 32) != 0 ? productItem2.freemium : z, (i4 & 64) != 0 ? productItem2.ageMin : i2, (i4 & 128) != 0 ? productItem2.ageMax : obj, (i4 & 256) != 0 ? productItem2.requiredReaderVersion : obj2, (i4 & 512) != 0 ? productItem2.author : str5, (i4 & 1024) != 0 ? productItem2.lastNameOfFirstAuthor : obj3, (i4 & 2048) != 0 ? productItem2.illustrator : obj4, (i4 & 4096) != 0 ? productItem2.externalId : str6, (i4 & 8192) != 0 ? productItem2.prices : list, (i4 & 16384) != 0 ? productItem2.attributes : attributes2, (i4 & 32768) != 0 ? productItem2.productType : str7, (i4 & 65536) != 0 ? productItem2.similarityCategory : obj5, (i4 & 131072) != 0 ? productItem2.similarityCategoryCode : obj6, (i4 & 262144) != 0 ? productItem2.productGroupIds : list2, (i4 & 524288) != 0 ? productItem2.metaData : metaData2, (i4 & 1048576) != 0 ? productItem2.lastModifiedDate : str8, (i4 & 2097152) != 0 ? productItem2.cover : cover2);
        }

        public final int component1() {
            return this.f642id;
        }

        public final String component10() {
            return this.author;
        }

        public final Object component11() {
            return this.lastNameOfFirstAuthor;
        }

        public final Object component12() {
            return this.illustrator;
        }

        public final String component13() {
            return this.externalId;
        }

        public final List<Price> component14() {
            return this.prices;
        }

        public final Attributes component15() {
            return this.attributes;
        }

        public final String component16() {
            return this.productType;
        }

        public final Object component17() {
            return this.similarityCategory;
        }

        public final Object component18() {
            return this.similarityCategoryCode;
        }

        public final List<Integer> component19() {
            return this.productGroupIds;
        }

        public final String component2() {
            return this.state;
        }

        public final MetaData component20() {
            return this.metaData;
        }

        public final String component21() {
            return this.lastModifiedDate;
        }

        public final Cover component22() {
            return this.cover;
        }

        public final String component3() {
            return this.title;
        }

        public final String component4() {
            return this.iapProductIdentifier;
        }

        public final String component5() {
            return this.publicationDate;
        }

        public final boolean component6() {
            return this.freemium;
        }

        public final int component7() {
            return this.ageMin;
        }

        public final Object component8() {
            return this.ageMax;
        }

        public final Object component9() {
            return this.requiredReaderVersion;
        }

        public final ProductItem copy(int i, String str, String str2, String str3, String str4, boolean z, int i2, Object obj, Object obj2, String str5, Object obj3, Object obj4, String str6, List<Price> list, Attributes attributes2, String str7, Object obj5, Object obj6, List<Integer> list2, MetaData metaData2, String str8, Cover cover2) {
            int i3 = i;
            Intrinsics.checkNotNullParameter(str, "state");
            Intrinsics.checkNotNullParameter(str2, MessageBundle.TITLE_ENTRY);
            Intrinsics.checkNotNullParameter(str3, "iapProductIdentifier");
            Intrinsics.checkNotNullParameter(str4, "publicationDate");
            Intrinsics.checkNotNullParameter(obj, "ageMax");
            Intrinsics.checkNotNullParameter(obj2, "requiredReaderVersion");
            Intrinsics.checkNotNullParameter(str5, "author");
            Intrinsics.checkNotNullParameter(obj3, "lastNameOfFirstAuthor");
            Intrinsics.checkNotNullParameter(obj4, "illustrator");
            Intrinsics.checkNotNullParameter(str6, "externalId");
            Intrinsics.checkNotNullParameter(list, "prices");
            Intrinsics.checkNotNullParameter(attributes2, "attributes");
            Intrinsics.checkNotNullParameter(str7, "productType");
            Intrinsics.checkNotNullParameter(obj5, "similarityCategory");
            Intrinsics.checkNotNullParameter(obj6, "similarityCategoryCode");
            Intrinsics.checkNotNullParameter(list2, "productGroupIds");
            Intrinsics.checkNotNullParameter(metaData2, "metaData");
            Intrinsics.checkNotNullParameter(str8, "lastModifiedDate");
            return new ProductItem(i, str, str2, str3, str4, z, i2, obj, obj2, str5, obj3, obj4, str6, list, attributes2, str7, obj5, obj6, list2, metaData2, str8, cover2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProductItem)) {
                return false;
            }
            ProductItem productItem = (ProductItem) obj;
            return this.f642id == productItem.f642id && Intrinsics.areEqual((Object) this.state, (Object) productItem.state) && Intrinsics.areEqual((Object) this.title, (Object) productItem.title) && Intrinsics.areEqual((Object) this.iapProductIdentifier, (Object) productItem.iapProductIdentifier) && Intrinsics.areEqual((Object) this.publicationDate, (Object) productItem.publicationDate) && this.freemium == productItem.freemium && this.ageMin == productItem.ageMin && Intrinsics.areEqual(this.ageMax, productItem.ageMax) && Intrinsics.areEqual(this.requiredReaderVersion, productItem.requiredReaderVersion) && Intrinsics.areEqual((Object) this.author, (Object) productItem.author) && Intrinsics.areEqual(this.lastNameOfFirstAuthor, productItem.lastNameOfFirstAuthor) && Intrinsics.areEqual(this.illustrator, productItem.illustrator) && Intrinsics.areEqual((Object) this.externalId, (Object) productItem.externalId) && Intrinsics.areEqual((Object) this.prices, (Object) productItem.prices) && Intrinsics.areEqual((Object) this.attributes, (Object) productItem.attributes) && Intrinsics.areEqual((Object) this.productType, (Object) productItem.productType) && Intrinsics.areEqual(this.similarityCategory, productItem.similarityCategory) && Intrinsics.areEqual(this.similarityCategoryCode, productItem.similarityCategoryCode) && Intrinsics.areEqual((Object) this.productGroupIds, (Object) productItem.productGroupIds) && Intrinsics.areEqual((Object) this.metaData, (Object) productItem.metaData) && Intrinsics.areEqual((Object) this.lastModifiedDate, (Object) productItem.lastModifiedDate) && Intrinsics.areEqual((Object) this.cover, (Object) productItem.cover);
        }

        public int hashCode() {
            int hashCode = ((((((((this.f642id * 31) + this.state.hashCode()) * 31) + this.title.hashCode()) * 31) + this.iapProductIdentifier.hashCode()) * 31) + this.publicationDate.hashCode()) * 31;
            boolean z = this.freemium;
            if (z) {
                z = true;
            }
            int hashCode2 = (((((((((((((((((((((((((((((((hashCode + (z ? 1 : 0)) * 31) + this.ageMin) * 31) + this.ageMax.hashCode()) * 31) + this.requiredReaderVersion.hashCode()) * 31) + this.author.hashCode()) * 31) + this.lastNameOfFirstAuthor.hashCode()) * 31) + this.illustrator.hashCode()) * 31) + this.externalId.hashCode()) * 31) + this.prices.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.productType.hashCode()) * 31) + this.similarityCategory.hashCode()) * 31) + this.similarityCategoryCode.hashCode()) * 31) + this.productGroupIds.hashCode()) * 31) + this.metaData.hashCode()) * 31) + this.lastModifiedDate.hashCode()) * 31;
            Cover cover2 = this.cover;
            return hashCode2 + (cover2 == null ? 0 : cover2.hashCode());
        }

        public String toString() {
            return "ProductItem(id=" + this.f642id + ", state=" + this.state + ", title=" + this.title + ", iapProductIdentifier=" + this.iapProductIdentifier + ", publicationDate=" + this.publicationDate + ", freemium=" + this.freemium + ", ageMin=" + this.ageMin + ", ageMax=" + this.ageMax + ", requiredReaderVersion=" + this.requiredReaderVersion + ", author=" + this.author + ", lastNameOfFirstAuthor=" + this.lastNameOfFirstAuthor + ", illustrator=" + this.illustrator + ", externalId=" + this.externalId + ", prices=" + this.prices + ", attributes=" + this.attributes + ", productType=" + this.productType + ", similarityCategory=" + this.similarityCategory + ", similarityCategoryCode=" + this.similarityCategoryCode + ", productGroupIds=" + this.productGroupIds + ", metaData=" + this.metaData + ", lastModifiedDate=" + this.lastModifiedDate + ", cover=" + this.cover + ')';
        }

        public ProductItem(int i, String str, String str2, String str3, String str4, boolean z, int i2, Object obj, Object obj2, String str5, Object obj3, Object obj4, String str6, List<Price> list, Attributes attributes2, String str7, Object obj5, Object obj6, List<Integer> list2, MetaData metaData2, String str8, Cover cover2) {
            String str9 = str;
            String str10 = str2;
            String str11 = str3;
            String str12 = str4;
            Object obj7 = obj;
            Object obj8 = obj2;
            String str13 = str5;
            Object obj9 = obj3;
            Object obj10 = obj4;
            String str14 = str6;
            List<Price> list3 = list;
            Attributes attributes3 = attributes2;
            String str15 = str7;
            Object obj11 = obj5;
            List<Integer> list4 = list2;
            Intrinsics.checkNotNullParameter(str9, "state");
            Intrinsics.checkNotNullParameter(str10, MessageBundle.TITLE_ENTRY);
            Intrinsics.checkNotNullParameter(str11, "iapProductIdentifier");
            Intrinsics.checkNotNullParameter(str12, "publicationDate");
            Intrinsics.checkNotNullParameter(obj7, "ageMax");
            Intrinsics.checkNotNullParameter(obj8, "requiredReaderVersion");
            Intrinsics.checkNotNullParameter(str13, "author");
            Intrinsics.checkNotNullParameter(obj9, "lastNameOfFirstAuthor");
            Intrinsics.checkNotNullParameter(obj10, "illustrator");
            Intrinsics.checkNotNullParameter(str14, "externalId");
            Intrinsics.checkNotNullParameter(list3, "prices");
            Intrinsics.checkNotNullParameter(attributes3, "attributes");
            Intrinsics.checkNotNullParameter(str15, "productType");
            Intrinsics.checkNotNullParameter(obj11, "similarityCategory");
            Intrinsics.checkNotNullParameter(obj6, "similarityCategoryCode");
            Intrinsics.checkNotNullParameter(list2, "productGroupIds");
            Intrinsics.checkNotNullParameter(metaData2, "metaData");
            Intrinsics.checkNotNullParameter(str8, "lastModifiedDate");
            this.f642id = i;
            this.state = str9;
            this.title = str10;
            this.iapProductIdentifier = str11;
            this.publicationDate = str12;
            this.freemium = z;
            this.ageMin = i2;
            this.ageMax = obj7;
            this.requiredReaderVersion = obj8;
            this.author = str13;
            this.lastNameOfFirstAuthor = obj9;
            this.illustrator = obj10;
            this.externalId = str14;
            this.prices = list3;
            this.attributes = attributes3;
            this.productType = str15;
            this.similarityCategory = obj11;
            this.similarityCategoryCode = obj6;
            this.productGroupIds = list2;
            this.metaData = metaData2;
            this.lastModifiedDate = str8;
            this.cover = cover2;
        }

        public final int getId() {
            return this.f642id;
        }

        public final String getState() {
            return this.state;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getIapProductIdentifier() {
            return this.iapProductIdentifier;
        }

        public final String getPublicationDate() {
            return this.publicationDate;
        }

        public final boolean getFreemium() {
            return this.freemium;
        }

        public final int getAgeMin() {
            return this.ageMin;
        }

        public final Object getAgeMax() {
            return this.ageMax;
        }

        public final Object getRequiredReaderVersion() {
            return this.requiredReaderVersion;
        }

        public final String getAuthor() {
            return this.author;
        }

        public final Object getLastNameOfFirstAuthor() {
            return this.lastNameOfFirstAuthor;
        }

        public final Object getIllustrator() {
            return this.illustrator;
        }

        public final String getExternalId() {
            return this.externalId;
        }

        public final List<Price> getPrices() {
            return this.prices;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        public final String getProductType() {
            return this.productType;
        }

        public final Object getSimilarityCategory() {
            return this.similarityCategory;
        }

        public final Object getSimilarityCategoryCode() {
            return this.similarityCategoryCode;
        }

        public final List<Integer> getProductGroupIds() {
            return this.productGroupIds;
        }

        public final MetaData getMetaData() {
            return this.metaData;
        }

        public final String getLastModifiedDate() {
            return this.lastModifiedDate;
        }

        public final Cover getCover() {
            return this.cover;
        }

        @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Price;", "", "amount", "", "countryCode", "", "currencyCode", "(DLjava/lang/String;Ljava/lang/String;)V", "getAmount", "()D", "getCountryCode", "()Ljava/lang/String;", "getCurrencyCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: ProductList.kt */
        public static final class Price {
            private final double amount;
            private final String countryCode;
            private final String currencyCode;

            public static /* synthetic */ Price copy$default(Price price, double d, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    d = price.amount;
                }
                if ((i & 2) != 0) {
                    str = price.countryCode;
                }
                if ((i & 4) != 0) {
                    str2 = price.currencyCode;
                }
                return price.copy(d, str, str2);
            }

            public final double component1() {
                return this.amount;
            }

            public final String component2() {
                return this.countryCode;
            }

            public final String component3() {
                return this.currencyCode;
            }

            public final Price copy(double d, String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "countryCode");
                Intrinsics.checkNotNullParameter(str2, "currencyCode");
                return new Price(d, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Price)) {
                    return false;
                }
                Price price = (Price) obj;
                return Intrinsics.areEqual((Object) Double.valueOf(this.amount), (Object) Double.valueOf(price.amount)) && Intrinsics.areEqual((Object) this.countryCode, (Object) price.countryCode) && Intrinsics.areEqual((Object) this.currencyCode, (Object) price.currencyCode);
            }

            public int hashCode() {
                return (((Double.doubleToLongBits(this.amount) * 31) + this.countryCode.hashCode()) * 31) + this.currencyCode.hashCode();
            }

            public String toString() {
                return "Price(amount=" + this.amount + ", countryCode=" + this.countryCode + ", currencyCode=" + this.currencyCode + ')';
            }

            public Price(double d, String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "countryCode");
                Intrinsics.checkNotNullParameter(str2, "currencyCode");
                this.amount = d;
                this.countryCode = str;
                this.currencyCode = str2;
            }

            public final double getAmount() {
                return this.amount;
            }

            public final String getCountryCode() {
                return this.countryCode;
            }

            public final String getCurrencyCode() {
                return this.currencyCode;
            }
        }

        @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Attributes;", "", "length", "", "isbn", "", "(ILjava/lang/String;)V", "getIsbn", "()Ljava/lang/String;", "getLength", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: ProductList.kt */
        public static final class Attributes {
            private final String isbn;
            private final int length;

            public static /* synthetic */ Attributes copy$default(Attributes attributes, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = attributes.length;
                }
                if ((i2 & 2) != 0) {
                    str = attributes.isbn;
                }
                return attributes.copy(i, str);
            }

            public final int component1() {
                return this.length;
            }

            public final String component2() {
                return this.isbn;
            }

            public final Attributes copy(int i, String str) {
                Intrinsics.checkNotNullParameter(str, "isbn");
                return new Attributes(i, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return this.length == attributes.length && Intrinsics.areEqual((Object) this.isbn, (Object) attributes.isbn);
            }

            public int hashCode() {
                return (this.length * 31) + this.isbn.hashCode();
            }

            public String toString() {
                return "Attributes(length=" + this.length + ", isbn=" + this.isbn + ')';
            }

            public Attributes(int i, String str) {
                Intrinsics.checkNotNullParameter(str, "isbn");
                this.length = i;
                this.isbn = str;
            }

            public final int getLength() {
                return this.length;
            }

            public final String getIsbn() {
                return this.isbn;
            }
        }

        @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$MetaData;", "", "treeVersion", "", "(I)V", "getTreeVersion", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: ProductList.kt */
        public static final class MetaData {
            private final int treeVersion;

            public static /* synthetic */ MetaData copy$default(MetaData metaData, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = metaData.treeVersion;
                }
                return metaData.copy(i);
            }

            public final int component1() {
                return this.treeVersion;
            }

            public final MetaData copy(int i) {
                return new MetaData(i);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MetaData) && this.treeVersion == ((MetaData) obj).treeVersion;
            }

            public int hashCode() {
                return this.treeVersion;
            }

            public String toString() {
                return "MetaData(treeVersion=" + this.treeVersion + ')';
            }

            public MetaData(int i) {
                this.treeVersion = i;
            }

            public final int getTreeVersion() {
                return this.treeVersion;
            }
        }

        @Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001:\u0003./0BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003Jc\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u00061"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover;", "", "id", "", "version", "assetProductType", "", "ordinal", "productId", "assetId", "metaData", "Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$MetaData;", "asset", "Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$Asset;", "contentLocation", "Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$ContentLocation;", "(IILjava/lang/String;IIILmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$MetaData;Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$Asset;Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$ContentLocation;)V", "getAsset", "()Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$Asset;", "getAssetId", "()I", "getAssetProductType", "()Ljava/lang/String;", "getContentLocation", "()Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$ContentLocation;", "getId", "getMetaData", "()Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$MetaData;", "getOrdinal", "getProductId", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "Asset", "ContentLocation", "MetaData", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: ProductList.kt */
        public static final class Cover {
            private final Asset asset;
            private final int assetId;
            private final String assetProductType;
            private final ContentLocation contentLocation;

            /* renamed from: id */
            private final int f643id;
            private final MetaData metaData;
            private final int ordinal;
            private final int productId;
            private final int version;

            public static /* synthetic */ Cover copy$default(Cover cover, int i, int i2, String str, int i3, int i4, int i5, MetaData metaData2, Asset asset2, ContentLocation contentLocation2, int i6, Object obj) {
                Cover cover2 = cover;
                int i7 = i6;
                return cover.copy((i7 & 1) != 0 ? cover2.f643id : i, (i7 & 2) != 0 ? cover2.version : i2, (i7 & 4) != 0 ? cover2.assetProductType : str, (i7 & 8) != 0 ? cover2.ordinal : i3, (i7 & 16) != 0 ? cover2.productId : i4, (i7 & 32) != 0 ? cover2.assetId : i5, (i7 & 64) != 0 ? cover2.metaData : metaData2, (i7 & 128) != 0 ? cover2.asset : asset2, (i7 & 256) != 0 ? cover2.contentLocation : contentLocation2);
            }

            public final int component1() {
                return this.f643id;
            }

            public final int component2() {
                return this.version;
            }

            public final String component3() {
                return this.assetProductType;
            }

            public final int component4() {
                return this.ordinal;
            }

            public final int component5() {
                return this.productId;
            }

            public final int component6() {
                return this.assetId;
            }

            public final MetaData component7() {
                return this.metaData;
            }

            public final Asset component8() {
                return this.asset;
            }

            public final ContentLocation component9() {
                return this.contentLocation;
            }

            public final Cover copy(int i, int i2, String str, int i3, int i4, int i5, MetaData metaData2, Asset asset2, ContentLocation contentLocation2) {
                Intrinsics.checkNotNullParameter(str, "assetProductType");
                MetaData metaData3 = metaData2;
                Intrinsics.checkNotNullParameter(metaData3, "metaData");
                Asset asset3 = asset2;
                Intrinsics.checkNotNullParameter(asset3, "asset");
                ContentLocation contentLocation3 = contentLocation2;
                Intrinsics.checkNotNullParameter(contentLocation3, "contentLocation");
                return new Cover(i, i2, str, i3, i4, i5, metaData3, asset3, contentLocation3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Cover)) {
                    return false;
                }
                Cover cover = (Cover) obj;
                return this.f643id == cover.f643id && this.version == cover.version && Intrinsics.areEqual((Object) this.assetProductType, (Object) cover.assetProductType) && this.ordinal == cover.ordinal && this.productId == cover.productId && this.assetId == cover.assetId && Intrinsics.areEqual((Object) this.metaData, (Object) cover.metaData) && Intrinsics.areEqual((Object) this.asset, (Object) cover.asset) && Intrinsics.areEqual((Object) this.contentLocation, (Object) cover.contentLocation);
            }

            public int hashCode() {
                return (((((((((((((((this.f643id * 31) + this.version) * 31) + this.assetProductType.hashCode()) * 31) + this.ordinal) * 31) + this.productId) * 31) + this.assetId) * 31) + this.metaData.hashCode()) * 31) + this.asset.hashCode()) * 31) + this.contentLocation.hashCode();
            }

            public String toString() {
                return "Cover(id=" + this.f643id + ", version=" + this.version + ", assetProductType=" + this.assetProductType + ", ordinal=" + this.ordinal + ", productId=" + this.productId + ", assetId=" + this.assetId + ", metaData=" + this.metaData + ", asset=" + this.asset + ", contentLocation=" + this.contentLocation + ')';
            }

            public Cover(int i, int i2, String str, int i3, int i4, int i5, MetaData metaData2, Asset asset2, ContentLocation contentLocation2) {
                Intrinsics.checkNotNullParameter(str, "assetProductType");
                Intrinsics.checkNotNullParameter(metaData2, "metaData");
                Intrinsics.checkNotNullParameter(asset2, "asset");
                Intrinsics.checkNotNullParameter(contentLocation2, "contentLocation");
                this.f643id = i;
                this.version = i2;
                this.assetProductType = str;
                this.ordinal = i3;
                this.productId = i4;
                this.assetId = i5;
                this.metaData = metaData2;
                this.asset = asset2;
                this.contentLocation = contentLocation2;
            }

            public final int getId() {
                return this.f643id;
            }

            public final int getVersion() {
                return this.version;
            }

            public final String getAssetProductType() {
                return this.assetProductType;
            }

            public final int getOrdinal() {
                return this.ordinal;
            }

            public final int getProductId() {
                return this.productId;
            }

            public final int getAssetId() {
                return this.assetId;
            }

            public final MetaData getMetaData() {
                return this.metaData;
            }

            public final Asset getAsset() {
                return this.asset;
            }

            public final ContentLocation getContentLocation() {
                return this.contentLocation;
            }

            @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$MetaData;", "", "treeVersion", "", "(I)V", "getTreeVersion", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
            /* compiled from: ProductList.kt */
            public static final class MetaData {
                private final int treeVersion;

                public static /* synthetic */ MetaData copy$default(MetaData metaData, int i, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        i = metaData.treeVersion;
                    }
                    return metaData.copy(i);
                }

                public final int component1() {
                    return this.treeVersion;
                }

                public final MetaData copy(int i) {
                    return new MetaData(i);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof MetaData) && this.treeVersion == ((MetaData) obj).treeVersion;
                }

                public int hashCode() {
                    return this.treeVersion;
                }

                public String toString() {
                    return "MetaData(treeVersion=" + this.treeVersion + ')';
                }

                public MetaData(int i) {
                    this.treeVersion = i;
                }

                public final int getTreeVersion() {
                    return this.treeVersion;
                }
            }

            @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u00061"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$Asset;", "", "id", "", "version", "name", "", "assetType", "mimeType", "size", "width", "height", "md5Hash", "visibility", "storage", "storageReferenceId", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssetType", "()Ljava/lang/String;", "getHeight", "()I", "getId", "getMd5Hash", "getMimeType", "getName", "getSize", "getStorage", "getStorageReferenceId", "getVersion", "getVisibility", "getWidth", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
            /* compiled from: ProductList.kt */
            public static final class Asset {
                private final String assetType;
                private final int height;

                /* renamed from: id */
                private final int f644id;
                private final String md5Hash;
                private final String mimeType;
                private final String name;
                private final int size;
                private final String storage;
                private final String storageReferenceId;
                private final int version;
                private final String visibility;
                private final int width;

                public static /* synthetic */ Asset copy$default(Asset asset, int i, int i2, String str, String str2, String str3, int i3, int i4, int i5, String str4, String str5, String str6, String str7, int i6, Object obj) {
                    Asset asset2 = asset;
                    int i7 = i6;
                    return asset.copy((i7 & 1) != 0 ? asset2.f644id : i, (i7 & 2) != 0 ? asset2.version : i2, (i7 & 4) != 0 ? asset2.name : str, (i7 & 8) != 0 ? asset2.assetType : str2, (i7 & 16) != 0 ? asset2.mimeType : str3, (i7 & 32) != 0 ? asset2.size : i3, (i7 & 64) != 0 ? asset2.width : i4, (i7 & 128) != 0 ? asset2.height : i5, (i7 & 256) != 0 ? asset2.md5Hash : str4, (i7 & 512) != 0 ? asset2.visibility : str5, (i7 & 1024) != 0 ? asset2.storage : str6, (i7 & 2048) != 0 ? asset2.storageReferenceId : str7);
                }

                public final int component1() {
                    return this.f644id;
                }

                public final String component10() {
                    return this.visibility;
                }

                public final String component11() {
                    return this.storage;
                }

                public final String component12() {
                    return this.storageReferenceId;
                }

                public final int component2() {
                    return this.version;
                }

                public final String component3() {
                    return this.name;
                }

                public final String component4() {
                    return this.assetType;
                }

                public final String component5() {
                    return this.mimeType;
                }

                public final int component6() {
                    return this.size;
                }

                public final int component7() {
                    return this.width;
                }

                public final int component8() {
                    return this.height;
                }

                public final String component9() {
                    return this.md5Hash;
                }

                public final Asset copy(int i, int i2, String str, String str2, String str3, int i3, int i4, int i5, String str4, String str5, String str6, String str7) {
                    String str8 = str;
                    Intrinsics.checkNotNullParameter(str8, "name");
                    String str9 = str2;
                    Intrinsics.checkNotNullParameter(str9, "assetType");
                    String str10 = str3;
                    Intrinsics.checkNotNullParameter(str10, "mimeType");
                    String str11 = str4;
                    Intrinsics.checkNotNullParameter(str11, "md5Hash");
                    String str12 = str5;
                    Intrinsics.checkNotNullParameter(str12, "visibility");
                    String str13 = str6;
                    Intrinsics.checkNotNullParameter(str13, "storage");
                    String str14 = str7;
                    Intrinsics.checkNotNullParameter(str14, "storageReferenceId");
                    return new Asset(i, i2, str8, str9, str10, i3, i4, i5, str11, str12, str13, str14);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Asset)) {
                        return false;
                    }
                    Asset asset = (Asset) obj;
                    return this.f644id == asset.f644id && this.version == asset.version && Intrinsics.areEqual((Object) this.name, (Object) asset.name) && Intrinsics.areEqual((Object) this.assetType, (Object) asset.assetType) && Intrinsics.areEqual((Object) this.mimeType, (Object) asset.mimeType) && this.size == asset.size && this.width == asset.width && this.height == asset.height && Intrinsics.areEqual((Object) this.md5Hash, (Object) asset.md5Hash) && Intrinsics.areEqual((Object) this.visibility, (Object) asset.visibility) && Intrinsics.areEqual((Object) this.storage, (Object) asset.storage) && Intrinsics.areEqual((Object) this.storageReferenceId, (Object) asset.storageReferenceId);
                }

                public int hashCode() {
                    return (((((((((((((((((((((this.f644id * 31) + this.version) * 31) + this.name.hashCode()) * 31) + this.assetType.hashCode()) * 31) + this.mimeType.hashCode()) * 31) + this.size) * 31) + this.width) * 31) + this.height) * 31) + this.md5Hash.hashCode()) * 31) + this.visibility.hashCode()) * 31) + this.storage.hashCode()) * 31) + this.storageReferenceId.hashCode();
                }

                public String toString() {
                    return "Asset(id=" + this.f644id + ", version=" + this.version + ", name=" + this.name + ", assetType=" + this.assetType + ", mimeType=" + this.mimeType + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + ", md5Hash=" + this.md5Hash + ", visibility=" + this.visibility + ", storage=" + this.storage + ", storageReferenceId=" + this.storageReferenceId + ')';
                }

                public Asset(int i, int i2, String str, String str2, String str3, int i3, int i4, int i5, String str4, String str5, String str6, String str7) {
                    Intrinsics.checkNotNullParameter(str, "name");
                    Intrinsics.checkNotNullParameter(str2, "assetType");
                    Intrinsics.checkNotNullParameter(str3, "mimeType");
                    Intrinsics.checkNotNullParameter(str4, "md5Hash");
                    Intrinsics.checkNotNullParameter(str5, "visibility");
                    Intrinsics.checkNotNullParameter(str6, "storage");
                    Intrinsics.checkNotNullParameter(str7, "storageReferenceId");
                    this.f644id = i;
                    this.version = i2;
                    this.name = str;
                    this.assetType = str2;
                    this.mimeType = str3;
                    this.size = i3;
                    this.width = i4;
                    this.height = i5;
                    this.md5Hash = str4;
                    this.visibility = str5;
                    this.storage = str6;
                    this.storageReferenceId = str7;
                }

                public final int getId() {
                    return this.f644id;
                }

                public final int getVersion() {
                    return this.version;
                }

                public final String getName() {
                    return this.name;
                }

                public final String getAssetType() {
                    return this.assetType;
                }

                public final String getMimeType() {
                    return this.mimeType;
                }

                public final int getSize() {
                    return this.size;
                }

                public final int getWidth() {
                    return this.width;
                }

                public final int getHeight() {
                    return this.height;
                }

                public final String getMd5Hash() {
                    return this.md5Hash;
                }

                public final String getVisibility() {
                    return this.visibility;
                }

                public final String getStorage() {
                    return this.storage;
                }

                public final String getStorageReferenceId() {
                    return this.storageReferenceId;
                }
            }

            @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ProductList$ProductItem$Cover$ContentLocation;", "", "location", "", "expires", "(Ljava/lang/String;Ljava/lang/Object;)V", "getExpires", "()Ljava/lang/Object;", "getLocation", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
            /* compiled from: ProductList.kt */
            public static final class ContentLocation {
                private final Object expires;
                private final String location;

                public static /* synthetic */ ContentLocation copy$default(ContentLocation contentLocation, String str, Object obj, int i, Object obj2) {
                    if ((i & 1) != 0) {
                        str = contentLocation.location;
                    }
                    if ((i & 2) != 0) {
                        obj = contentLocation.expires;
                    }
                    return contentLocation.copy(str, obj);
                }

                public final String component1() {
                    return this.location;
                }

                public final Object component2() {
                    return this.expires;
                }

                public final ContentLocation copy(String str, Object obj) {
                    Intrinsics.checkNotNullParameter(str, "location");
                    Intrinsics.checkNotNullParameter(obj, "expires");
                    return new ContentLocation(str, obj);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof ContentLocation)) {
                        return false;
                    }
                    ContentLocation contentLocation = (ContentLocation) obj;
                    return Intrinsics.areEqual((Object) this.location, (Object) contentLocation.location) && Intrinsics.areEqual(this.expires, contentLocation.expires);
                }

                public int hashCode() {
                    return (this.location.hashCode() * 31) + this.expires.hashCode();
                }

                public String toString() {
                    return "ContentLocation(location=" + this.location + ", expires=" + this.expires + ')';
                }

                public ContentLocation(String str, Object obj) {
                    Intrinsics.checkNotNullParameter(str, "location");
                    Intrinsics.checkNotNullParameter(obj, "expires");
                    this.location = str;
                    this.expires = obj;
                }

                public final String getLocation() {
                    return this.location;
                }

                public final Object getExpires() {
                    return this.expires;
                }
            }
        }
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ProductItem)) {
            return false;
        }
        return contains((ProductItem) obj);
    }

    public /* bridge */ boolean contains(ProductItem productItem) {
        return super.contains(productItem);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ProductItem)) {
            return -1;
        }
        return indexOf((ProductItem) obj);
    }

    public /* bridge */ int indexOf(ProductItem productItem) {
        return super.indexOf(productItem);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ProductItem)) {
            return -1;
        }
        return lastIndexOf((ProductItem) obj);
    }

    public /* bridge */ int lastIndexOf(ProductItem productItem) {
        return super.lastIndexOf(productItem);
    }

    public final /* bridge */ ProductItem remove(int i) {
        return removeAt(i);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof ProductItem)) {
            return false;
        }
        return remove((ProductItem) obj);
    }

    public /* bridge */ boolean remove(ProductItem productItem) {
        return super.remove(productItem);
    }

    public /* bridge */ ProductItem removeAt(int i) {
        return (ProductItem) super.remove(i);
    }

    public final /* bridge */ int size() {
        return getSize();
    }
}
