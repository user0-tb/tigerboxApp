package media.tiger.tigerbox.model.domain;

import com.google.android.exoplayer2.RendererCapabilities;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.spongycastle.i18n.MessageBundle;

@Metadata(mo33736d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BU\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0012HÆ\u0003Jg\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u00062"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "Ljava/io/Serializable;", "productId", "", "(I)V", "id", "title", "", "author", "imageUrl", "isBanner", "", "offlineAvailabilityState", "Lmedia/tiger/tigerbox/model/domain/OfflineAvailabilityState;", "offlineAvailabilityReason", "Lmedia/tiger/tigerbox/model/domain/DownloadReason;", "isSelected", "source", "Lmedia/tiger/tigerbox/model/domain/ProductSource;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLmedia/tiger/tigerbox/model/domain/OfflineAvailabilityState;Lmedia/tiger/tigerbox/model/domain/DownloadReason;ZLmedia/tiger/tigerbox/model/domain/ProductSource;)V", "getAuthor", "()Ljava/lang/String;", "getId", "()I", "getImageUrl", "()Z", "setSelected", "(Z)V", "getOfflineAvailabilityReason", "()Lmedia/tiger/tigerbox/model/domain/DownloadReason;", "getOfflineAvailabilityState", "()Lmedia/tiger/tigerbox/model/domain/OfflineAvailabilityState;", "getSource", "()Lmedia/tiger/tigerbox/model/domain/ProductSource;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProductDomain.kt */
public final class ProductDomain implements Serializable {
    private final String author;

    /* renamed from: id */
    private final int f628id;
    private final String imageUrl;
    private final boolean isBanner;
    private boolean isSelected;
    private final DownloadReason offlineAvailabilityReason;
    private final OfflineAvailabilityState offlineAvailabilityState;
    private final ProductSource source;
    private final String title;

    public static /* synthetic */ ProductDomain copy$default(ProductDomain productDomain, int i, String str, String str2, String str3, boolean z, OfflineAvailabilityState offlineAvailabilityState2, DownloadReason downloadReason, boolean z2, ProductSource productSource, int i2, Object obj) {
        ProductDomain productDomain2 = productDomain;
        int i3 = i2;
        return productDomain.copy((i3 & 1) != 0 ? productDomain2.f628id : i, (i3 & 2) != 0 ? productDomain2.title : str, (i3 & 4) != 0 ? productDomain2.author : str2, (i3 & 8) != 0 ? productDomain2.imageUrl : str3, (i3 & 16) != 0 ? productDomain2.isBanner : z, (i3 & 32) != 0 ? productDomain2.offlineAvailabilityState : offlineAvailabilityState2, (i3 & 64) != 0 ? productDomain2.offlineAvailabilityReason : downloadReason, (i3 & 128) != 0 ? productDomain2.isSelected : z2, (i3 & 256) != 0 ? productDomain2.source : productSource);
    }

    public final int component1() {
        return this.f628id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.author;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final boolean component5() {
        return this.isBanner;
    }

    public final OfflineAvailabilityState component6() {
        return this.offlineAvailabilityState;
    }

    public final DownloadReason component7() {
        return this.offlineAvailabilityReason;
    }

    public final boolean component8() {
        return this.isSelected;
    }

    public final ProductSource component9() {
        return this.source;
    }

    public final ProductDomain copy(int i, String str, String str2, String str3, boolean z, OfflineAvailabilityState offlineAvailabilityState2, DownloadReason downloadReason, boolean z2, ProductSource productSource) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "author");
        OfflineAvailabilityState offlineAvailabilityState3 = offlineAvailabilityState2;
        Intrinsics.checkNotNullParameter(offlineAvailabilityState3, "offlineAvailabilityState");
        ProductSource productSource2 = productSource;
        Intrinsics.checkNotNullParameter(productSource2, "source");
        return new ProductDomain(i, str, str2, str3, z, offlineAvailabilityState3, downloadReason, z2, productSource2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDomain)) {
            return false;
        }
        ProductDomain productDomain = (ProductDomain) obj;
        return this.f628id == productDomain.f628id && Intrinsics.areEqual((Object) this.title, (Object) productDomain.title) && Intrinsics.areEqual((Object) this.author, (Object) productDomain.author) && Intrinsics.areEqual((Object) this.imageUrl, (Object) productDomain.imageUrl) && this.isBanner == productDomain.isBanner && this.offlineAvailabilityState == productDomain.offlineAvailabilityState && this.offlineAvailabilityReason == productDomain.offlineAvailabilityReason && this.isSelected == productDomain.isSelected && this.source == productDomain.source;
    }

    public int hashCode() {
        int hashCode = ((((this.f628id * 31) + this.title.hashCode()) * 31) + this.author.hashCode()) * 31;
        String str = this.imageUrl;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.isBanner;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode3 = (((hashCode2 + (z ? 1 : 0)) * 31) + this.offlineAvailabilityState.hashCode()) * 31;
        DownloadReason downloadReason = this.offlineAvailabilityReason;
        if (downloadReason != null) {
            i = downloadReason.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z3 = this.isSelected;
        if (!z3) {
            z2 = z3;
        }
        return ((i2 + (z2 ? 1 : 0)) * 31) + this.source.hashCode();
    }

    public String toString() {
        return "ProductDomain(id=" + this.f628id + ", title=" + this.title + ", author=" + this.author + ", imageUrl=" + this.imageUrl + ", isBanner=" + this.isBanner + ", offlineAvailabilityState=" + this.offlineAvailabilityState + ", offlineAvailabilityReason=" + this.offlineAvailabilityReason + ", isSelected=" + this.isSelected + ", source=" + this.source + ')';
    }

    public ProductDomain(int i, String str, String str2, String str3, boolean z, OfflineAvailabilityState offlineAvailabilityState2, DownloadReason downloadReason, boolean z2, ProductSource productSource) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "author");
        Intrinsics.checkNotNullParameter(offlineAvailabilityState2, "offlineAvailabilityState");
        Intrinsics.checkNotNullParameter(productSource, "source");
        this.f628id = i;
        this.title = str;
        this.author = str2;
        this.imageUrl = str3;
        this.isBanner = z;
        this.offlineAvailabilityState = offlineAvailabilityState2;
        this.offlineAvailabilityReason = downloadReason;
        this.isSelected = z2;
        this.source = productSource;
    }

    public final int getId() {
        return this.f628id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean isBanner() {
        return this.isBanner;
    }

    public final OfflineAvailabilityState getOfflineAvailabilityState() {
        return this.offlineAvailabilityState;
    }

    public final DownloadReason getOfflineAvailabilityReason() {
        return this.offlineAvailabilityReason;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ProductDomain(int r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, boolean r17, media.tiger.tigerbox.model.domain.OfflineAvailabilityState r18, media.tiger.tigerbox.model.domain.DownloadReason r19, boolean r20, media.tiger.tigerbox.model.domain.ProductSource r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r10 = 0
            goto L_0x000b
        L_0x0009:
            r10 = r20
        L_0x000b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0013
            media.tiger.tigerbox.model.domain.ProductSource r0 = media.tiger.tigerbox.model.domain.ProductSource.BACKEND
            r11 = r0
            goto L_0x0015
        L_0x0013:
            r11 = r21
        L_0x0015:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.model.domain.ProductDomain.<init>(int, java.lang.String, java.lang.String, java.lang.String, boolean, media.tiger.tigerbox.model.domain.OfflineAvailabilityState, media.tiger.tigerbox.model.domain.DownloadReason, boolean, media.tiger.tigerbox.model.domain.ProductSource, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ProductSource getSource() {
        return this.source;
    }

    public ProductDomain(int i) {
        this(i, "", "", "", false, OfflineAvailabilityState.NOT_AVAILABLE, DownloadReason.NONE, false, (ProductSource) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
    }
}
