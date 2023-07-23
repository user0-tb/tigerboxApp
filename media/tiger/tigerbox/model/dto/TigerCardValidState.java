package media.tiger.tigerbox.model.dto;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.spongycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\b\b\u0018\u00002\u00020\u0001:\u0004DEFGB{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00104\u001a\u00020\u0014HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010-J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0001HÆ\u0003J\t\u0010=\u001a\u00020\u0001HÆ\u0003J \u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\t2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0007HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\r\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!¨\u0006H"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState;", "", "code", "", "uid", "cardType", "productId", "", "enabled", "", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate", "accountGeneratedContentId", "_embedded", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded;", "multiTigercardVariant", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$MultiTigercardVariant;", "_links", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links;", "_templates", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;ILmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$MultiTigercardVariant;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates;)V", "get_embedded", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded;", "get_links", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links;", "get_templates", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates;", "getAccountGeneratedContentId", "()I", "getCardType", "()Ljava/lang/String;", "getCode", "getCreatedBy", "getCreatedDate", "getEnabled", "()Z", "getLastModifiedBy", "()Ljava/lang/Object;", "getLastModifiedDate", "getMultiTigercardVariant", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$MultiTigercardVariant;", "getProductId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUid", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;ILmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$MultiTigercardVariant;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates;)Lmedia/tiger/tigerbox/model/dto/TigerCardValidState;", "equals", "other", "hashCode", "toString", "Embedded", "Links", "MultiTigercardVariant", "Templates", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerCardValidState.kt */
public final class TigerCardValidState {
    private final Embedded _embedded;
    private final Links _links;
    private final Templates _templates;
    private final int accountGeneratedContentId;
    private final String cardType;
    private final String code;
    private final String createdBy;
    private final String createdDate;
    private final boolean enabled;
    private final Object lastModifiedBy;
    private final Object lastModifiedDate;
    private final MultiTigercardVariant multiTigercardVariant;
    private final Integer productId;
    private final String uid;

    public static /* synthetic */ TigerCardValidState copy$default(TigerCardValidState tigerCardValidState, String str, String str2, String str3, Integer num, boolean z, String str4, String str5, Object obj, Object obj2, int i, Embedded embedded, MultiTigercardVariant multiTigercardVariant2, Links links, Templates templates, int i2, Object obj3) {
        TigerCardValidState tigerCardValidState2 = tigerCardValidState;
        int i3 = i2;
        return tigerCardValidState.copy((i3 & 1) != 0 ? tigerCardValidState2.code : str, (i3 & 2) != 0 ? tigerCardValidState2.uid : str2, (i3 & 4) != 0 ? tigerCardValidState2.cardType : str3, (i3 & 8) != 0 ? tigerCardValidState2.productId : num, (i3 & 16) != 0 ? tigerCardValidState2.enabled : z, (i3 & 32) != 0 ? tigerCardValidState2.createdBy : str4, (i3 & 64) != 0 ? tigerCardValidState2.createdDate : str5, (i3 & 128) != 0 ? tigerCardValidState2.lastModifiedBy : obj, (i3 & 256) != 0 ? tigerCardValidState2.lastModifiedDate : obj2, (i3 & 512) != 0 ? tigerCardValidState2.accountGeneratedContentId : i, (i3 & 1024) != 0 ? tigerCardValidState2._embedded : embedded, (i3 & 2048) != 0 ? tigerCardValidState2.multiTigercardVariant : multiTigercardVariant2, (i3 & 4096) != 0 ? tigerCardValidState2._links : links, (i3 & 8192) != 0 ? tigerCardValidState2._templates : templates);
    }

    public final String component1() {
        return this.code;
    }

    public final int component10() {
        return this.accountGeneratedContentId;
    }

    public final Embedded component11() {
        return this._embedded;
    }

    public final MultiTigercardVariant component12() {
        return this.multiTigercardVariant;
    }

    public final Links component13() {
        return this._links;
    }

    public final Templates component14() {
        return this._templates;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.cardType;
    }

    public final Integer component4() {
        return this.productId;
    }

    public final boolean component5() {
        return this.enabled;
    }

    public final String component6() {
        return this.createdBy;
    }

    public final String component7() {
        return this.createdDate;
    }

    public final Object component8() {
        return this.lastModifiedBy;
    }

    public final Object component9() {
        return this.lastModifiedDate;
    }

    public final TigerCardValidState copy(String str, String str2, String str3, Integer num, boolean z, String str4, String str5, Object obj, Object obj2, int i, Embedded embedded, MultiTigercardVariant multiTigercardVariant2, Links links, Templates templates) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "code");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "uid");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "cardType");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "createdBy");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "createdDate");
        Object obj3 = obj;
        Intrinsics.checkNotNullParameter(obj3, "lastModifiedBy");
        Object obj4 = obj2;
        Intrinsics.checkNotNullParameter(obj4, "lastModifiedDate");
        Embedded embedded2 = embedded;
        Intrinsics.checkNotNullParameter(embedded2, "_embedded");
        Links links2 = links;
        Intrinsics.checkNotNullParameter(links2, "_links");
        return new TigerCardValidState(str6, str7, str8, num, z, str9, str10, obj3, obj4, i, embedded2, multiTigercardVariant2, links2, templates);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TigerCardValidState)) {
            return false;
        }
        TigerCardValidState tigerCardValidState = (TigerCardValidState) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) tigerCardValidState.code) && Intrinsics.areEqual((Object) this.uid, (Object) tigerCardValidState.uid) && Intrinsics.areEqual((Object) this.cardType, (Object) tigerCardValidState.cardType) && Intrinsics.areEqual((Object) this.productId, (Object) tigerCardValidState.productId) && this.enabled == tigerCardValidState.enabled && Intrinsics.areEqual((Object) this.createdBy, (Object) tigerCardValidState.createdBy) && Intrinsics.areEqual((Object) this.createdDate, (Object) tigerCardValidState.createdDate) && Intrinsics.areEqual(this.lastModifiedBy, tigerCardValidState.lastModifiedBy) && Intrinsics.areEqual(this.lastModifiedDate, tigerCardValidState.lastModifiedDate) && this.accountGeneratedContentId == tigerCardValidState.accountGeneratedContentId && Intrinsics.areEqual((Object) this._embedded, (Object) tigerCardValidState._embedded) && Intrinsics.areEqual((Object) this.multiTigercardVariant, (Object) tigerCardValidState.multiTigercardVariant) && Intrinsics.areEqual((Object) this._links, (Object) tigerCardValidState._links) && Intrinsics.areEqual((Object) this._templates, (Object) tigerCardValidState._templates);
    }

    public int hashCode() {
        int hashCode = ((((this.code.hashCode() * 31) + this.uid.hashCode()) * 31) + this.cardType.hashCode()) * 31;
        Integer num = this.productId;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        boolean z = this.enabled;
        if (z) {
            z = true;
        }
        int hashCode3 = (((((((((((((hashCode2 + (z ? 1 : 0)) * 31) + this.createdBy.hashCode()) * 31) + this.createdDate.hashCode()) * 31) + this.lastModifiedBy.hashCode()) * 31) + this.lastModifiedDate.hashCode()) * 31) + this.accountGeneratedContentId) * 31) + this._embedded.hashCode()) * 31;
        MultiTigercardVariant multiTigercardVariant2 = this.multiTigercardVariant;
        int hashCode4 = (((hashCode3 + (multiTigercardVariant2 == null ? 0 : multiTigercardVariant2.hashCode())) * 31) + this._links.hashCode()) * 31;
        Templates templates = this._templates;
        if (templates != null) {
            i = templates.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "TigerCardValidState(code=" + this.code + ", uid=" + this.uid + ", cardType=" + this.cardType + ", productId=" + this.productId + ", enabled=" + this.enabled + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy=" + this.lastModifiedBy + ", lastModifiedDate=" + this.lastModifiedDate + ", accountGeneratedContentId=" + this.accountGeneratedContentId + ", _embedded=" + this._embedded + ", multiTigercardVariant=" + this.multiTigercardVariant + ", _links=" + this._links + ", _templates=" + this._templates + ')';
    }

    public TigerCardValidState(String str, String str2, String str3, Integer num, boolean z, String str4, String str5, Object obj, Object obj2, int i, Embedded embedded, MultiTigercardVariant multiTigercardVariant2, Links links, Templates templates) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "uid");
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Intrinsics.checkNotNullParameter(str4, "createdBy");
        Intrinsics.checkNotNullParameter(str5, "createdDate");
        Intrinsics.checkNotNullParameter(obj, "lastModifiedBy");
        Intrinsics.checkNotNullParameter(obj2, "lastModifiedDate");
        Intrinsics.checkNotNullParameter(embedded, "_embedded");
        Intrinsics.checkNotNullParameter(links, "_links");
        this.code = str;
        this.uid = str2;
        this.cardType = str3;
        this.productId = num;
        this.enabled = z;
        this.createdBy = str4;
        this.createdDate = str5;
        this.lastModifiedBy = obj;
        this.lastModifiedDate = obj2;
        this.accountGeneratedContentId = i;
        this._embedded = embedded;
        this.multiTigercardVariant = multiTigercardVariant2;
        this._links = links;
        this._templates = templates;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final Integer getProductId() {
        return this.productId;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getCreatedBy() {
        return this.createdBy;
    }

    public final String getCreatedDate() {
        return this.createdDate;
    }

    public final Object getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public final Object getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public final int getAccountGeneratedContentId() {
        return this.accountGeneratedContentId;
    }

    public final Embedded get_embedded() {
        return this._embedded;
    }

    public final MultiTigercardVariant getMultiTigercardVariant() {
        return this.multiTigercardVariant;
    }

    public final Links get_links() {
        return this._links;
    }

    public final Templates get_templates() {
        return this._templates;
    }

    @Metadata(mo33736d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0003 !\"B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded;", "", "coupon", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$Coupon;", "products", "", "Lmedia/tiger/tigerbox/model/dto/ProductDetailsDto;", "recentlyUsedProduct", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$RecentlyUsedProduct;", "accountGeneratedContents", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$AccountGeneratedContents;", "(Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$Coupon;Ljava/util/List;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$RecentlyUsedProduct;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$AccountGeneratedContents;)V", "getAccountGeneratedContents", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$AccountGeneratedContents;", "getCoupon", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$Coupon;", "getProducts", "()Ljava/util/List;", "getRecentlyUsedProduct", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$RecentlyUsedProduct;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AccountGeneratedContents", "Coupon", "RecentlyUsedProduct", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerCardValidState.kt */
    public static final class Embedded {
        @SerializedName("accountgeneratedcontents")
        private final AccountGeneratedContents accountGeneratedContents;
        private final Coupon coupon;
        @JsonAdapter(AlwaysListTypeAdapterFactory.class)
        private final List<ProductDetailsDto> products;
        private final RecentlyUsedProduct recentlyUsedProduct;

        public static /* synthetic */ Embedded copy$default(Embedded embedded, Coupon coupon2, List<ProductDetailsDto> list, RecentlyUsedProduct recentlyUsedProduct2, AccountGeneratedContents accountGeneratedContents2, int i, Object obj) {
            if ((i & 1) != 0) {
                coupon2 = embedded.coupon;
            }
            if ((i & 2) != 0) {
                list = embedded.products;
            }
            if ((i & 4) != 0) {
                recentlyUsedProduct2 = embedded.recentlyUsedProduct;
            }
            if ((i & 8) != 0) {
                accountGeneratedContents2 = embedded.accountGeneratedContents;
            }
            return embedded.copy(coupon2, list, recentlyUsedProduct2, accountGeneratedContents2);
        }

        public final Coupon component1() {
            return this.coupon;
        }

        public final List<ProductDetailsDto> component2() {
            return this.products;
        }

        public final RecentlyUsedProduct component3() {
            return this.recentlyUsedProduct;
        }

        public final AccountGeneratedContents component4() {
            return this.accountGeneratedContents;
        }

        public final Embedded copy(Coupon coupon2, List<ProductDetailsDto> list, RecentlyUsedProduct recentlyUsedProduct2, AccountGeneratedContents accountGeneratedContents2) {
            return new Embedded(coupon2, list, recentlyUsedProduct2, accountGeneratedContents2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Embedded)) {
                return false;
            }
            Embedded embedded = (Embedded) obj;
            return Intrinsics.areEqual((Object) this.coupon, (Object) embedded.coupon) && Intrinsics.areEqual((Object) this.products, (Object) embedded.products) && Intrinsics.areEqual((Object) this.recentlyUsedProduct, (Object) embedded.recentlyUsedProduct) && Intrinsics.areEqual((Object) this.accountGeneratedContents, (Object) embedded.accountGeneratedContents);
        }

        public int hashCode() {
            Coupon coupon2 = this.coupon;
            int i = 0;
            int hashCode = (coupon2 == null ? 0 : coupon2.hashCode()) * 31;
            List<ProductDetailsDto> list = this.products;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            RecentlyUsedProduct recentlyUsedProduct2 = this.recentlyUsedProduct;
            int hashCode3 = (hashCode2 + (recentlyUsedProduct2 == null ? 0 : recentlyUsedProduct2.hashCode())) * 31;
            AccountGeneratedContents accountGeneratedContents2 = this.accountGeneratedContents;
            if (accountGeneratedContents2 != null) {
                i = accountGeneratedContents2.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "Embedded(coupon=" + this.coupon + ", products=" + this.products + ", recentlyUsedProduct=" + this.recentlyUsedProduct + ", accountGeneratedContents=" + this.accountGeneratedContents + ')';
        }

        public Embedded(Coupon coupon2, List<ProductDetailsDto> list, RecentlyUsedProduct recentlyUsedProduct2, AccountGeneratedContents accountGeneratedContents2) {
            this.coupon = coupon2;
            this.products = list;
            this.recentlyUsedProduct = recentlyUsedProduct2;
            this.accountGeneratedContents = accountGeneratedContents2;
        }

        public final Coupon getCoupon() {
            return this.coupon;
        }

        public final List<ProductDetailsDto> getProducts() {
            return this.products;
        }

        public final RecentlyUsedProduct getRecentlyUsedProduct() {
            return this.recentlyUsedProduct;
        }

        public final AccountGeneratedContents getAccountGeneratedContents() {
            return this.accountGeneratedContents;
        }

        @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$Coupon;", "", "couponCode", "", "(Ljava/lang/String;)V", "getCouponCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: TigerCardValidState.kt */
        public static final class Coupon {
            private final String couponCode;

            public static /* synthetic */ Coupon copy$default(Coupon coupon, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = coupon.couponCode;
                }
                return coupon.copy(str);
            }

            public final String component1() {
                return this.couponCode;
            }

            public final Coupon copy(String str) {
                Intrinsics.checkNotNullParameter(str, "couponCode");
                return new Coupon(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Coupon) && Intrinsics.areEqual((Object) this.couponCode, (Object) ((Coupon) obj).couponCode);
            }

            public int hashCode() {
                return this.couponCode.hashCode();
            }

            public String toString() {
                return "Coupon(couponCode=" + this.couponCode + ')';
            }

            public Coupon(String str) {
                Intrinsics.checkNotNullParameter(str, "couponCode");
                this.couponCode = str;
            }

            public final String getCouponCode() {
                return this.couponCode;
            }
        }

        @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\b\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0011HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0005HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u00064"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$AccountGeneratedContents;", "", "name", "", "accountId", "", "totalDuration", "unusedDuration", "contentType", "transcodingStatus", "publicContent", "", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate", "_links", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links;", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links;)V", "get_links", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links;", "getAccountId", "()I", "getContentType", "()Ljava/lang/String;", "getCreatedBy", "getCreatedDate", "getLastModifiedBy", "getLastModifiedDate", "getName", "getPublicContent", "()Z", "getTotalDuration", "getTranscodingStatus", "getUnusedDuration", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: TigerCardValidState.kt */
        public static final class AccountGeneratedContents {
            private final Links _links;
            private final int accountId;
            private final String contentType;
            private final String createdBy;
            private final String createdDate;
            private final String lastModifiedBy;
            private final String lastModifiedDate;
            private final String name;
            private final boolean publicContent;
            private final int totalDuration;
            private final String transcodingStatus;
            private final int unusedDuration;

            public static /* synthetic */ AccountGeneratedContents copy$default(AccountGeneratedContents accountGeneratedContents, String str, int i, int i2, int i3, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, Links links, int i4, Object obj) {
                AccountGeneratedContents accountGeneratedContents2 = accountGeneratedContents;
                int i5 = i4;
                return accountGeneratedContents.copy((i5 & 1) != 0 ? accountGeneratedContents2.name : str, (i5 & 2) != 0 ? accountGeneratedContents2.accountId : i, (i5 & 4) != 0 ? accountGeneratedContents2.totalDuration : i2, (i5 & 8) != 0 ? accountGeneratedContents2.unusedDuration : i3, (i5 & 16) != 0 ? accountGeneratedContents2.contentType : str2, (i5 & 32) != 0 ? accountGeneratedContents2.transcodingStatus : str3, (i5 & 64) != 0 ? accountGeneratedContents2.publicContent : z, (i5 & 128) != 0 ? accountGeneratedContents2.createdBy : str4, (i5 & 256) != 0 ? accountGeneratedContents2.createdDate : str5, (i5 & 512) != 0 ? accountGeneratedContents2.lastModifiedBy : str6, (i5 & 1024) != 0 ? accountGeneratedContents2.lastModifiedDate : str7, (i5 & 2048) != 0 ? accountGeneratedContents2._links : links);
            }

            public final String component1() {
                return this.name;
            }

            public final String component10() {
                return this.lastModifiedBy;
            }

            public final String component11() {
                return this.lastModifiedDate;
            }

            public final Links component12() {
                return this._links;
            }

            public final int component2() {
                return this.accountId;
            }

            public final int component3() {
                return this.totalDuration;
            }

            public final int component4() {
                return this.unusedDuration;
            }

            public final String component5() {
                return this.contentType;
            }

            public final String component6() {
                return this.transcodingStatus;
            }

            public final boolean component7() {
                return this.publicContent;
            }

            public final String component8() {
                return this.createdBy;
            }

            public final String component9() {
                return this.createdDate;
            }

            public final AccountGeneratedContents copy(String str, int i, int i2, int i3, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, Links links) {
                Intrinsics.checkNotNullParameter(str, "name");
                String str8 = str2;
                Intrinsics.checkNotNullParameter(str8, CMSAttributeTableGenerator.CONTENT_TYPE);
                String str9 = str3;
                Intrinsics.checkNotNullParameter(str9, "transcodingStatus");
                String str10 = str4;
                Intrinsics.checkNotNullParameter(str10, "createdBy");
                String str11 = str5;
                Intrinsics.checkNotNullParameter(str11, "createdDate");
                String str12 = str6;
                Intrinsics.checkNotNullParameter(str12, "lastModifiedBy");
                String str13 = str7;
                Intrinsics.checkNotNullParameter(str13, "lastModifiedDate");
                Links links2 = links;
                Intrinsics.checkNotNullParameter(links2, "_links");
                return new AccountGeneratedContents(str, i, i2, i3, str8, str9, z, str10, str11, str12, str13, links2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AccountGeneratedContents)) {
                    return false;
                }
                AccountGeneratedContents accountGeneratedContents = (AccountGeneratedContents) obj;
                return Intrinsics.areEqual((Object) this.name, (Object) accountGeneratedContents.name) && this.accountId == accountGeneratedContents.accountId && this.totalDuration == accountGeneratedContents.totalDuration && this.unusedDuration == accountGeneratedContents.unusedDuration && Intrinsics.areEqual((Object) this.contentType, (Object) accountGeneratedContents.contentType) && Intrinsics.areEqual((Object) this.transcodingStatus, (Object) accountGeneratedContents.transcodingStatus) && this.publicContent == accountGeneratedContents.publicContent && Intrinsics.areEqual((Object) this.createdBy, (Object) accountGeneratedContents.createdBy) && Intrinsics.areEqual((Object) this.createdDate, (Object) accountGeneratedContents.createdDate) && Intrinsics.areEqual((Object) this.lastModifiedBy, (Object) accountGeneratedContents.lastModifiedBy) && Intrinsics.areEqual((Object) this.lastModifiedDate, (Object) accountGeneratedContents.lastModifiedDate) && Intrinsics.areEqual((Object) this._links, (Object) accountGeneratedContents._links);
            }

            public int hashCode() {
                int hashCode = ((((((((((this.name.hashCode() * 31) + this.accountId) * 31) + this.totalDuration) * 31) + this.unusedDuration) * 31) + this.contentType.hashCode()) * 31) + this.transcodingStatus.hashCode()) * 31;
                boolean z = this.publicContent;
                if (z) {
                    z = true;
                }
                return ((((((((((hashCode + (z ? 1 : 0)) * 31) + this.createdBy.hashCode()) * 31) + this.createdDate.hashCode()) * 31) + this.lastModifiedBy.hashCode()) * 31) + this.lastModifiedDate.hashCode()) * 31) + this._links.hashCode();
            }

            public String toString() {
                return "AccountGeneratedContents(name=" + this.name + ", accountId=" + this.accountId + ", totalDuration=" + this.totalDuration + ", unusedDuration=" + this.unusedDuration + ", contentType=" + this.contentType + ", transcodingStatus=" + this.transcodingStatus + ", publicContent=" + this.publicContent + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy=" + this.lastModifiedBy + ", lastModifiedDate=" + this.lastModifiedDate + ", _links=" + this._links + ')';
            }

            public AccountGeneratedContents(String str, int i, int i2, int i3, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, Links links) {
                Intrinsics.checkNotNullParameter(str, "name");
                Intrinsics.checkNotNullParameter(str2, CMSAttributeTableGenerator.CONTENT_TYPE);
                Intrinsics.checkNotNullParameter(str3, "transcodingStatus");
                Intrinsics.checkNotNullParameter(str4, "createdBy");
                Intrinsics.checkNotNullParameter(str5, "createdDate");
                Intrinsics.checkNotNullParameter(str6, "lastModifiedBy");
                Intrinsics.checkNotNullParameter(str7, "lastModifiedDate");
                Intrinsics.checkNotNullParameter(links, "_links");
                this.name = str;
                this.accountId = i;
                this.totalDuration = i2;
                this.unusedDuration = i3;
                this.contentType = str2;
                this.transcodingStatus = str3;
                this.publicContent = z;
                this.createdBy = str4;
                this.createdDate = str5;
                this.lastModifiedBy = str6;
                this.lastModifiedDate = str7;
                this._links = links;
            }

            public final String getName() {
                return this.name;
            }

            public final int getAccountId() {
                return this.accountId;
            }

            public final int getTotalDuration() {
                return this.totalDuration;
            }

            public final int getUnusedDuration() {
                return this.unusedDuration;
            }

            public final String getContentType() {
                return this.contentType;
            }

            public final String getTranscodingStatus() {
                return this.transcodingStatus;
            }

            public final boolean getPublicContent() {
                return this.publicContent;
            }

            public final String getCreatedBy() {
                return this.createdBy;
            }

            public final String getCreatedDate() {
                return this.createdDate;
            }

            public final String getLastModifiedBy() {
                return this.lastModifiedBy;
            }

            public final String getLastModifiedDate() {
                return this.lastModifiedDate;
            }

            public final Links get_links() {
                return this._links;
            }
        }

        @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003JS\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Embedded$RecentlyUsedProduct;", "", "multiTigercardVariantId", "", "profileId", "productId", "createdBy", "", "createdDate", "lastModifiedBy", "lastModifiedDate", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreatedBy", "()Ljava/lang/String;", "getCreatedDate", "getLastModifiedBy", "getLastModifiedDate", "getMultiTigercardVariantId", "()I", "getProductId", "getProfileId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: TigerCardValidState.kt */
        public static final class RecentlyUsedProduct {
            private final String createdBy;
            private final String createdDate;
            private final String lastModifiedBy;
            private final String lastModifiedDate;
            private final int multiTigercardVariantId;
            private final int productId;
            private final int profileId;

            public static /* synthetic */ RecentlyUsedProduct copy$default(RecentlyUsedProduct recentlyUsedProduct, int i, int i2, int i3, String str, String str2, String str3, String str4, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = recentlyUsedProduct.multiTigercardVariantId;
                }
                if ((i4 & 2) != 0) {
                    i2 = recentlyUsedProduct.profileId;
                }
                int i5 = i2;
                if ((i4 & 4) != 0) {
                    i3 = recentlyUsedProduct.productId;
                }
                int i6 = i3;
                if ((i4 & 8) != 0) {
                    str = recentlyUsedProduct.createdBy;
                }
                String str5 = str;
                if ((i4 & 16) != 0) {
                    str2 = recentlyUsedProduct.createdDate;
                }
                String str6 = str2;
                if ((i4 & 32) != 0) {
                    str3 = recentlyUsedProduct.lastModifiedBy;
                }
                String str7 = str3;
                if ((i4 & 64) != 0) {
                    str4 = recentlyUsedProduct.lastModifiedDate;
                }
                return recentlyUsedProduct.copy(i, i5, i6, str5, str6, str7, str4);
            }

            public final int component1() {
                return this.multiTigercardVariantId;
            }

            public final int component2() {
                return this.profileId;
            }

            public final int component3() {
                return this.productId;
            }

            public final String component4() {
                return this.createdBy;
            }

            public final String component5() {
                return this.createdDate;
            }

            public final String component6() {
                return this.lastModifiedBy;
            }

            public final String component7() {
                return this.lastModifiedDate;
            }

            public final RecentlyUsedProduct copy(int i, int i2, int i3, String str, String str2, String str3, String str4) {
                Intrinsics.checkNotNullParameter(str, "createdBy");
                Intrinsics.checkNotNullParameter(str2, "createdDate");
                return new RecentlyUsedProduct(i, i2, i3, str, str2, str3, str4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RecentlyUsedProduct)) {
                    return false;
                }
                RecentlyUsedProduct recentlyUsedProduct = (RecentlyUsedProduct) obj;
                return this.multiTigercardVariantId == recentlyUsedProduct.multiTigercardVariantId && this.profileId == recentlyUsedProduct.profileId && this.productId == recentlyUsedProduct.productId && Intrinsics.areEqual((Object) this.createdBy, (Object) recentlyUsedProduct.createdBy) && Intrinsics.areEqual((Object) this.createdDate, (Object) recentlyUsedProduct.createdDate) && Intrinsics.areEqual((Object) this.lastModifiedBy, (Object) recentlyUsedProduct.lastModifiedBy) && Intrinsics.areEqual((Object) this.lastModifiedDate, (Object) recentlyUsedProduct.lastModifiedDate);
            }

            public int hashCode() {
                int hashCode = ((((((((this.multiTigercardVariantId * 31) + this.profileId) * 31) + this.productId) * 31) + this.createdBy.hashCode()) * 31) + this.createdDate.hashCode()) * 31;
                String str = this.lastModifiedBy;
                int i = 0;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.lastModifiedDate;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "RecentlyUsedProduct(multiTigercardVariantId=" + this.multiTigercardVariantId + ", profileId=" + this.profileId + ", productId=" + this.productId + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy=" + this.lastModifiedBy + ", lastModifiedDate=" + this.lastModifiedDate + ')';
            }

            public RecentlyUsedProduct(int i, int i2, int i3, String str, String str2, String str3, String str4) {
                Intrinsics.checkNotNullParameter(str, "createdBy");
                Intrinsics.checkNotNullParameter(str2, "createdDate");
                this.multiTigercardVariantId = i;
                this.profileId = i2;
                this.productId = i3;
                this.createdBy = str;
                this.createdDate = str2;
                this.lastModifiedBy = str3;
                this.lastModifiedDate = str4;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ RecentlyUsedProduct(int i, int i2, int i3, String str, String str2, String str3, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, i2, i3, str, str2, (i4 & 32) != 0 ? null : str3, (i4 & 64) != 0 ? null : str4);
            }

            public final int getMultiTigercardVariantId() {
                return this.multiTigercardVariantId;
            }

            public final int getProfileId() {
                return this.profileId;
            }

            public final int getProductId() {
                return this.productId;
            }

            public final String getCreatedBy() {
                return this.createdBy;
            }

            public final String getCreatedDate() {
                return this.createdDate;
            }

            public final String getLastModifiedBy() {
                return this.lastModifiedBy;
            }

            public final String getLastModifiedDate() {
                return this.lastModifiedDate;
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$MultiTigercardVariant;", "", "name", "", "description", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreatedBy", "()Ljava/lang/String;", "getCreatedDate", "getDescription", "getLastModifiedBy", "getLastModifiedDate", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerCardValidState.kt */
    public static final class MultiTigercardVariant {
        private final String createdBy;
        private final String createdDate;
        private final String description;
        private final String lastModifiedBy;
        private final String lastModifiedDate;
        private final String name;

        public static /* synthetic */ MultiTigercardVariant copy$default(MultiTigercardVariant multiTigercardVariant, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = multiTigercardVariant.name;
            }
            if ((i & 2) != 0) {
                str2 = multiTigercardVariant.description;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = multiTigercardVariant.createdBy;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = multiTigercardVariant.createdDate;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = multiTigercardVariant.lastModifiedBy;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = multiTigercardVariant.lastModifiedDate;
            }
            return multiTigercardVariant.copy(str, str7, str8, str9, str10, str6);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.description;
        }

        public final String component3() {
            return this.createdBy;
        }

        public final String component4() {
            return this.createdDate;
        }

        public final String component5() {
            return this.lastModifiedBy;
        }

        public final String component6() {
            return this.lastModifiedDate;
        }

        public final MultiTigercardVariant copy(String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(str3, "createdBy");
            Intrinsics.checkNotNullParameter(str4, "createdDate");
            return new MultiTigercardVariant(str, str2, str3, str4, str5, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MultiTigercardVariant)) {
                return false;
            }
            MultiTigercardVariant multiTigercardVariant = (MultiTigercardVariant) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) multiTigercardVariant.name) && Intrinsics.areEqual((Object) this.description, (Object) multiTigercardVariant.description) && Intrinsics.areEqual((Object) this.createdBy, (Object) multiTigercardVariant.createdBy) && Intrinsics.areEqual((Object) this.createdDate, (Object) multiTigercardVariant.createdDate) && Intrinsics.areEqual((Object) this.lastModifiedBy, (Object) multiTigercardVariant.lastModifiedBy) && Intrinsics.areEqual((Object) this.lastModifiedDate, (Object) multiTigercardVariant.lastModifiedDate);
        }

        public int hashCode() {
            int hashCode = ((((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.createdDate.hashCode()) * 31;
            String str = this.lastModifiedBy;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.lastModifiedDate;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "MultiTigercardVariant(name=" + this.name + ", description=" + this.description + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy=" + this.lastModifiedBy + ", lastModifiedDate=" + this.lastModifiedDate + ')';
        }

        public MultiTigercardVariant(String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(str3, "createdBy");
            Intrinsics.checkNotNullParameter(str4, "createdDate");
            this.name = str;
            this.description = str2;
            this.createdBy = str3;
            this.createdDate = str4;
            this.lastModifiedBy = str5;
            this.lastModifiedDate = str6;
        }

        public final String getName() {
            return this.name;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getCreatedBy() {
            return this.createdBy;
        }

        public final String getCreatedDate() {
            return this.createdDate;
        }

        public final String getLastModifiedBy() {
            return this.lastModifiedBy;
        }

        public final String getLastModifiedDate() {
            return this.lastModifiedDate;
        }
    }

    @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001(Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006)"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links;", "", "self", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;", "card", "validate", "getProduct", "order", "playlist", "cover", "accountGeneratedContent", "disable", "(Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;)V", "getAccountGeneratedContent", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;", "getCard", "getCover", "getDisable", "getGetProduct", "getOrder", "getPlaylist", "getSelf", "getValidate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Link", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerCardValidState.kt */
    public static final class Links {
        private final Link accountGeneratedContent;
        private final Link card;
        private final Link cover;
        private final Link disable;
        private final Link getProduct;
        private final Link order;
        private final Link playlist;
        private final Link self;
        private final Link validate;

        public Links() {
            this((Link) null, (Link) null, (Link) null, (Link) null, (Link) null, (Link) null, (Link) null, (Link) null, (Link) null, 511, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Links copy$default(Links links, Link link, Link link2, Link link3, Link link4, Link link5, Link link6, Link link7, Link link8, Link link9, int i, Object obj) {
            Links links2 = links;
            int i2 = i;
            return links.copy((i2 & 1) != 0 ? links2.self : link, (i2 & 2) != 0 ? links2.card : link2, (i2 & 4) != 0 ? links2.validate : link3, (i2 & 8) != 0 ? links2.getProduct : link4, (i2 & 16) != 0 ? links2.order : link5, (i2 & 32) != 0 ? links2.playlist : link6, (i2 & 64) != 0 ? links2.cover : link7, (i2 & 128) != 0 ? links2.accountGeneratedContent : link8, (i2 & 256) != 0 ? links2.disable : link9);
        }

        public final Link component1() {
            return this.self;
        }

        public final Link component2() {
            return this.card;
        }

        public final Link component3() {
            return this.validate;
        }

        public final Link component4() {
            return this.getProduct;
        }

        public final Link component5() {
            return this.order;
        }

        public final Link component6() {
            return this.playlist;
        }

        public final Link component7() {
            return this.cover;
        }

        public final Link component8() {
            return this.accountGeneratedContent;
        }

        public final Link component9() {
            return this.disable;
        }

        public final Links copy(Link link, Link link2, Link link3, Link link4, Link link5, Link link6, Link link7, Link link8, Link link9) {
            return new Links(link, link2, link3, link4, link5, link6, link7, link8, link9);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Links)) {
                return false;
            }
            Links links = (Links) obj;
            return Intrinsics.areEqual((Object) this.self, (Object) links.self) && Intrinsics.areEqual((Object) this.card, (Object) links.card) && Intrinsics.areEqual((Object) this.validate, (Object) links.validate) && Intrinsics.areEqual((Object) this.getProduct, (Object) links.getProduct) && Intrinsics.areEqual((Object) this.order, (Object) links.order) && Intrinsics.areEqual((Object) this.playlist, (Object) links.playlist) && Intrinsics.areEqual((Object) this.cover, (Object) links.cover) && Intrinsics.areEqual((Object) this.accountGeneratedContent, (Object) links.accountGeneratedContent) && Intrinsics.areEqual((Object) this.disable, (Object) links.disable);
        }

        public int hashCode() {
            Link link = this.self;
            int i = 0;
            int hashCode = (link == null ? 0 : link.hashCode()) * 31;
            Link link2 = this.card;
            int hashCode2 = (hashCode + (link2 == null ? 0 : link2.hashCode())) * 31;
            Link link3 = this.validate;
            int hashCode3 = (hashCode2 + (link3 == null ? 0 : link3.hashCode())) * 31;
            Link link4 = this.getProduct;
            int hashCode4 = (hashCode3 + (link4 == null ? 0 : link4.hashCode())) * 31;
            Link link5 = this.order;
            int hashCode5 = (hashCode4 + (link5 == null ? 0 : link5.hashCode())) * 31;
            Link link6 = this.playlist;
            int hashCode6 = (hashCode5 + (link6 == null ? 0 : link6.hashCode())) * 31;
            Link link7 = this.cover;
            int hashCode7 = (hashCode6 + (link7 == null ? 0 : link7.hashCode())) * 31;
            Link link8 = this.accountGeneratedContent;
            int hashCode8 = (hashCode7 + (link8 == null ? 0 : link8.hashCode())) * 31;
            Link link9 = this.disable;
            if (link9 != null) {
                i = link9.hashCode();
            }
            return hashCode8 + i;
        }

        public String toString() {
            return "Links(self=" + this.self + ", card=" + this.card + ", validate=" + this.validate + ", getProduct=" + this.getProduct + ", order=" + this.order + ", playlist=" + this.playlist + ", cover=" + this.cover + ", accountGeneratedContent=" + this.accountGeneratedContent + ", disable=" + this.disable + ')';
        }

        public Links(Link link, Link link2, Link link3, Link link4, Link link5, Link link6, Link link7, Link link8, Link link9) {
            this.self = link;
            this.card = link2;
            this.validate = link3;
            this.getProduct = link4;
            this.order = link5;
            this.playlist = link6;
            this.cover = link7;
            this.accountGeneratedContent = link8;
            this.disable = link9;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Links(media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link r11, media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link r12, media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link r13, media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link r14, media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link r15, media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link r16, media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link r17, media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link r18, media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
            /*
                r10 = this;
                r0 = r20
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r1 = r2
                goto L_0x000a
            L_0x0009:
                r1 = r11
            L_0x000a:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0010
                r3 = r2
                goto L_0x0011
            L_0x0010:
                r3 = r12
            L_0x0011:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x0017
                r4 = r2
                goto L_0x0018
            L_0x0017:
                r4 = r13
            L_0x0018:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x001e
                r5 = r2
                goto L_0x001f
            L_0x001e:
                r5 = r14
            L_0x001f:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0025
                r6 = r2
                goto L_0x0026
            L_0x0025:
                r6 = r15
            L_0x0026:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x002c
                r7 = r2
                goto L_0x002e
            L_0x002c:
                r7 = r16
            L_0x002e:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0034
                r8 = r2
                goto L_0x0036
            L_0x0034:
                r8 = r17
            L_0x0036:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x003c
                r9 = r2
                goto L_0x003e
            L_0x003c:
                r9 = r18
            L_0x003e:
                r0 = r0 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L_0x0043
                goto L_0x0045
            L_0x0043:
                r2 = r19
            L_0x0045:
                r11 = r10
                r12 = r1
                r13 = r3
                r14 = r4
                r15 = r5
                r16 = r6
                r17 = r7
                r18 = r8
                r19 = r9
                r20 = r2
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.model.dto.TigerCardValidState.Links.<init>(media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link, media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link, media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link, media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link, media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link, media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link, media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link, media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link, media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final Link getSelf() {
            return this.self;
        }

        public final Link getCard() {
            return this.card;
        }

        public final Link getValidate() {
            return this.validate;
        }

        public final Link getGetProduct() {
            return this.getProduct;
        }

        public final Link getOrder() {
            return this.order;
        }

        public final Link getPlaylist() {
            return this.playlist;
        }

        public final Link getCover() {
            return this.cover;
        }

        public final Link getAccountGeneratedContent() {
            return this.accountGeneratedContent;
        }

        public final Link getDisable() {
            return this.disable;
        }

        @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003Jg\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Links$Link;", "", "href", "", "hreflang", "title", "type", "deprecation", "profile", "name", "templated", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDeprecation", "()Ljava/lang/String;", "getHref", "getHreflang", "getName", "getProfile", "getTemplated", "()Z", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: TigerCardValidState.kt */
        public static final class Link {
            private final String deprecation;
            private final String href;
            private final String hreflang;
            private final String name;
            private final String profile;
            private final boolean templated;
            private final String title;
            private final String type;

            public Link() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, 255, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Link copy$default(Link link, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, Object obj) {
                Link link2 = link;
                int i2 = i;
                return link.copy((i2 & 1) != 0 ? link2.href : str, (i2 & 2) != 0 ? link2.hreflang : str2, (i2 & 4) != 0 ? link2.title : str3, (i2 & 8) != 0 ? link2.type : str4, (i2 & 16) != 0 ? link2.deprecation : str5, (i2 & 32) != 0 ? link2.profile : str6, (i2 & 64) != 0 ? link2.name : str7, (i2 & 128) != 0 ? link2.templated : z);
            }

            public final String component1() {
                return this.href;
            }

            public final String component2() {
                return this.hreflang;
            }

            public final String component3() {
                return this.title;
            }

            public final String component4() {
                return this.type;
            }

            public final String component5() {
                return this.deprecation;
            }

            public final String component6() {
                return this.profile;
            }

            public final String component7() {
                return this.name;
            }

            public final boolean component8() {
                return this.templated;
            }

            public final Link copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
                return new Link(str, str2, str3, str4, str5, str6, str7, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Link)) {
                    return false;
                }
                Link link = (Link) obj;
                return Intrinsics.areEqual((Object) this.href, (Object) link.href) && Intrinsics.areEqual((Object) this.hreflang, (Object) link.hreflang) && Intrinsics.areEqual((Object) this.title, (Object) link.title) && Intrinsics.areEqual((Object) this.type, (Object) link.type) && Intrinsics.areEqual((Object) this.deprecation, (Object) link.deprecation) && Intrinsics.areEqual((Object) this.profile, (Object) link.profile) && Intrinsics.areEqual((Object) this.name, (Object) link.name) && this.templated == link.templated;
            }

            public int hashCode() {
                String str = this.href;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.hreflang;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.title;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.type;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.deprecation;
                int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.profile;
                int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.name;
                if (str7 != null) {
                    i = str7.hashCode();
                }
                int i2 = (hashCode6 + i) * 31;
                boolean z = this.templated;
                if (z) {
                    z = true;
                }
                return i2 + (z ? 1 : 0);
            }

            public String toString() {
                return "Link(href=" + this.href + ", hreflang=" + this.hreflang + ", title=" + this.title + ", type=" + this.type + ", deprecation=" + this.deprecation + ", profile=" + this.profile + ", name=" + this.name + ", templated=" + this.templated + ')';
            }

            public Link(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
                this.href = str;
                this.hreflang = str2;
                this.title = str3;
                this.type = str4;
                this.deprecation = str5;
                this.profile = str6;
                this.name = str7;
                this.templated = z;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ Link(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
                /*
                    r9 = this;
                    r0 = r18
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000a
                L_0x0009:
                    r1 = r10
                L_0x000a:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0010
                    r3 = r2
                    goto L_0x0011
                L_0x0010:
                    r3 = r11
                L_0x0011:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0017
                    r4 = r2
                    goto L_0x0018
                L_0x0017:
                    r4 = r12
                L_0x0018:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001e
                    r5 = r2
                    goto L_0x001f
                L_0x001e:
                    r5 = r13
                L_0x001f:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0025
                    r6 = r2
                    goto L_0x0026
                L_0x0025:
                    r6 = r14
                L_0x0026:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x002c
                    r7 = r2
                    goto L_0x002d
                L_0x002c:
                    r7 = r15
                L_0x002d:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0032
                    goto L_0x0034
                L_0x0032:
                    r2 = r16
                L_0x0034:
                    r0 = r0 & 128(0x80, float:1.794E-43)
                    if (r0 == 0) goto L_0x003a
                    r0 = 0
                    goto L_0x003c
                L_0x003a:
                    r0 = r17
                L_0x003c:
                    r10 = r9
                    r11 = r1
                    r12 = r3
                    r13 = r4
                    r14 = r5
                    r15 = r6
                    r16 = r7
                    r17 = r2
                    r18 = r0
                    r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.model.dto.TigerCardValidState.Links.Link.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final String getHref() {
                return this.href;
            }

            public final String getHreflang() {
                return this.hreflang;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getType() {
                return this.type;
            }

            public final String getDeprecation() {
                return this.deprecation;
            }

            public final String getProfile() {
                return this.profile;
            }

            public final String getName() {
                return this.name;
            }

            public final boolean getTemplated() {
                return this.templated;
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates;", "", "default", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates$Template;", "saveRecentlyUsedMultiTigercardProduct", "(Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates$Template;Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates$Template;)V", "getDefault", "()Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates$Template;", "getSaveRecentlyUsedMultiTigercardProduct", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Template", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerCardValidState.kt */
    public static final class Templates {

        /* renamed from: default  reason: not valid java name */
        private final Template f1815default;
        private final Template saveRecentlyUsedMultiTigercardProduct;

        public static /* synthetic */ Templates copy$default(Templates templates, Template template, Template template2, int i, Object obj) {
            if ((i & 1) != 0) {
                template = templates.f1815default;
            }
            if ((i & 2) != 0) {
                template2 = templates.saveRecentlyUsedMultiTigercardProduct;
            }
            return templates.copy(template, template2);
        }

        public final Template component1() {
            return this.f1815default;
        }

        public final Template component2() {
            return this.saveRecentlyUsedMultiTigercardProduct;
        }

        public final Templates copy(Template template, Template template2) {
            return new Templates(template, template2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Templates)) {
                return false;
            }
            Templates templates = (Templates) obj;
            return Intrinsics.areEqual((Object) this.f1815default, (Object) templates.f1815default) && Intrinsics.areEqual((Object) this.saveRecentlyUsedMultiTigercardProduct, (Object) templates.saveRecentlyUsedMultiTigercardProduct);
        }

        public int hashCode() {
            Template template = this.f1815default;
            int i = 0;
            int hashCode = (template == null ? 0 : template.hashCode()) * 31;
            Template template2 = this.saveRecentlyUsedMultiTigercardProduct;
            if (template2 != null) {
                i = template2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Templates(default=" + this.f1815default + ", saveRecentlyUsedMultiTigercardProduct=" + this.saveRecentlyUsedMultiTigercardProduct + ')';
        }

        public Templates(Template template, Template template2) {
            this.f1815default = template;
            this.saveRecentlyUsedMultiTigercardProduct = template2;
        }

        public final Template getDefault() {
            return this.f1815default;
        }

        public final Template getSaveRecentlyUsedMultiTigercardProduct() {
            return this.saveRecentlyUsedMultiTigercardProduct;
        }

        @Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates$Template;", "", "method", "", "properties", "", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates$Template$Property;", "target", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getMethod", "()Ljava/lang/String;", "getProperties", "()Ljava/util/List;", "getTarget", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Property", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: TigerCardValidState.kt */
        public static final class Template {
            private final String method;
            private final List<Property> properties;
            private final String target;

            public Template() {
                this((String) null, (List) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Template copy$default(Template template, String str, List<Property> list, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = template.method;
                }
                if ((i & 2) != 0) {
                    list = template.properties;
                }
                if ((i & 4) != 0) {
                    str2 = template.target;
                }
                return template.copy(str, list, str2);
            }

            public final String component1() {
                return this.method;
            }

            public final List<Property> component2() {
                return this.properties;
            }

            public final String component3() {
                return this.target;
            }

            public final Template copy(String str, List<Property> list, String str2) {
                return new Template(str, list, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Template)) {
                    return false;
                }
                Template template = (Template) obj;
                return Intrinsics.areEqual((Object) this.method, (Object) template.method) && Intrinsics.areEqual((Object) this.properties, (Object) template.properties) && Intrinsics.areEqual((Object) this.target, (Object) template.target);
            }

            public int hashCode() {
                String str = this.method;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                List<Property> list = this.properties;
                int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
                String str2 = this.target;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "Template(method=" + this.method + ", properties=" + this.properties + ", target=" + this.target + ')';
            }

            public Template(String str, List<Property> list, String str2) {
                this.method = str;
                this.properties = list;
                this.target = str2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Template(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2);
            }

            public final String getMethod() {
                return this.method;
            }

            public final List<Property> getProperties() {
                return this.properties;
            }

            public final String getTarget() {
                return this.target;
            }

            @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerCardValidState$Templates$Template$Property;", "", "method", "", "type", "(Ljava/lang/String;Ljava/lang/String;)V", "getMethod", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
            /* compiled from: TigerCardValidState.kt */
            public static final class Property {
                private final String method;
                private final String type;

                public static /* synthetic */ Property copy$default(Property property, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = property.method;
                    }
                    if ((i & 2) != 0) {
                        str2 = property.type;
                    }
                    return property.copy(str, str2);
                }

                public final String component1() {
                    return this.method;
                }

                public final String component2() {
                    return this.type;
                }

                public final Property copy(String str, String str2) {
                    return new Property(str, str2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Property)) {
                        return false;
                    }
                    Property property = (Property) obj;
                    return Intrinsics.areEqual((Object) this.method, (Object) property.method) && Intrinsics.areEqual((Object) this.type, (Object) property.type);
                }

                public int hashCode() {
                    String str = this.method;
                    int i = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.type;
                    if (str2 != null) {
                        i = str2.hashCode();
                    }
                    return hashCode + i;
                }

                public String toString() {
                    return "Property(method=" + this.method + ", type=" + this.type + ')';
                }

                public Property(String str, String str2) {
                    this.method = str;
                    this.type = str2;
                }

                public final String getMethod() {
                    return this.method;
                }

                public final String getType() {
                    return this.type;
                }
            }
        }
    }
}
