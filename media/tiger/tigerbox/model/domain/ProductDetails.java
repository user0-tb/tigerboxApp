package media.tiger.tigerbox.model.domain;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.spongycastle.i18n.MessageBundle;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/ProductDetails;", "Ljava/io/Serializable;", "id", "", "productType", "", "title", "description", "language", "author", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getDescription", "getId", "()I", "getLanguage", "getProductType", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProductDetails.kt */
public final class ProductDetails implements Serializable {
    private final String author;
    private final String description;

    /* renamed from: id */
    private final int f627id;
    private final String language;
    private final String productType;
    private final String title;

    public static /* synthetic */ ProductDetails copy$default(ProductDetails productDetails, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = productDetails.f627id;
        }
        if ((i2 & 2) != 0) {
            str = productDetails.productType;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = productDetails.title;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = productDetails.description;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = productDetails.language;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = productDetails.author;
        }
        return productDetails.copy(i, str6, str7, str8, str9, str5);
    }

    public final int component1() {
        return this.f627id;
    }

    public final String component2() {
        return this.productType;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.language;
    }

    public final String component6() {
        return this.author;
    }

    public final ProductDetails copy(int i, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "productType");
        Intrinsics.checkNotNullParameter(str2, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "language");
        Intrinsics.checkNotNullParameter(str5, "author");
        return new ProductDetails(i, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetails)) {
            return false;
        }
        ProductDetails productDetails = (ProductDetails) obj;
        return this.f627id == productDetails.f627id && Intrinsics.areEqual((Object) this.productType, (Object) productDetails.productType) && Intrinsics.areEqual((Object) this.title, (Object) productDetails.title) && Intrinsics.areEqual((Object) this.description, (Object) productDetails.description) && Intrinsics.areEqual((Object) this.language, (Object) productDetails.language) && Intrinsics.areEqual((Object) this.author, (Object) productDetails.author);
    }

    public int hashCode() {
        return (((((((((this.f627id * 31) + this.productType.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.language.hashCode()) * 31) + this.author.hashCode();
    }

    public String toString() {
        return "ProductDetails(id=" + this.f627id + ", productType=" + this.productType + ", title=" + this.title + ", description=" + this.description + ", language=" + this.language + ", author=" + this.author + ')';
    }

    public ProductDetails(int i, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "productType");
        Intrinsics.checkNotNullParameter(str2, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "language");
        Intrinsics.checkNotNullParameter(str5, "author");
        this.f627id = i;
        this.productType = str;
        this.title = str2;
        this.description = str3;
        this.language = str4;
        this.author = str5;
    }

    public final int getId() {
        return this.f627id;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getAuthor() {
        return this.author;
    }
}
