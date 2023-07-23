package media.tiger.tigerbox.services.interfaces;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.dto.ProductDetailsDto;
import org.spongycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0002./BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jf\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0007HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00060"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "", "code", "", "uid", "cardType", "productId", "", "accountGeneratedContentId", "wildcardUserContent", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$AccountGeneratedContentsDomain;", "tigerTicketContent", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketDomain;", "multiTigercardVariant", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$MultiTigercardVariantDomain;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$AccountGeneratedContentsDomain;Lmedia/tiger/tigerbox/services/interfaces/TigerTicketDomain;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$MultiTigercardVariantDomain;)V", "getAccountGeneratedContentId", "()I", "getCardType", "()Ljava/lang/String;", "getCode", "getMultiTigercardVariant", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$MultiTigercardVariantDomain;", "getProductId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTigerTicketContent", "()Lmedia/tiger/tigerbox/services/interfaces/TigerTicketDomain;", "getUid", "getWildcardUserContent", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$AccountGeneratedContentsDomain;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$AccountGeneratedContentsDomain;Lmedia/tiger/tigerbox/services/interfaces/TigerTicketDomain;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$MultiTigercardVariantDomain;)Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "equals", "", "other", "hashCode", "toString", "AccountGeneratedContentsDomain", "MultiTigercardVariantDomain", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerCardsManagerService.kt */
public final class TigerCardDomain {
    private final int accountGeneratedContentId;
    private final String cardType;
    private final String code;
    private final MultiTigercardVariantDomain multiTigercardVariant;
    private final Integer productId;
    private final TigerTicketDomain tigerTicketContent;
    private final String uid;
    private final AccountGeneratedContentsDomain wildcardUserContent;

    public static /* synthetic */ TigerCardDomain copy$default(TigerCardDomain tigerCardDomain, String str, String str2, String str3, Integer num, int i, AccountGeneratedContentsDomain accountGeneratedContentsDomain, TigerTicketDomain tigerTicketDomain, MultiTigercardVariantDomain multiTigercardVariantDomain, int i2, Object obj) {
        TigerCardDomain tigerCardDomain2 = tigerCardDomain;
        int i3 = i2;
        return tigerCardDomain.copy((i3 & 1) != 0 ? tigerCardDomain2.code : str, (i3 & 2) != 0 ? tigerCardDomain2.uid : str2, (i3 & 4) != 0 ? tigerCardDomain2.cardType : str3, (i3 & 8) != 0 ? tigerCardDomain2.productId : num, (i3 & 16) != 0 ? tigerCardDomain2.accountGeneratedContentId : i, (i3 & 32) != 0 ? tigerCardDomain2.wildcardUserContent : accountGeneratedContentsDomain, (i3 & 64) != 0 ? tigerCardDomain2.tigerTicketContent : tigerTicketDomain, (i3 & 128) != 0 ? tigerCardDomain2.multiTigercardVariant : multiTigercardVariantDomain);
    }

    public final String component1() {
        return this.code;
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

    public final int component5() {
        return this.accountGeneratedContentId;
    }

    public final AccountGeneratedContentsDomain component6() {
        return this.wildcardUserContent;
    }

    public final TigerTicketDomain component7() {
        return this.tigerTicketContent;
    }

    public final MultiTigercardVariantDomain component8() {
        return this.multiTigercardVariant;
    }

    public final TigerCardDomain copy(String str, String str2, String str3, Integer num, int i, AccountGeneratedContentsDomain accountGeneratedContentsDomain, TigerTicketDomain tigerTicketDomain, MultiTigercardVariantDomain multiTigercardVariantDomain) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "uid");
        Intrinsics.checkNotNullParameter(str3, "cardType");
        return new TigerCardDomain(str, str2, str3, num, i, accountGeneratedContentsDomain, tigerTicketDomain, multiTigercardVariantDomain);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TigerCardDomain)) {
            return false;
        }
        TigerCardDomain tigerCardDomain = (TigerCardDomain) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) tigerCardDomain.code) && Intrinsics.areEqual((Object) this.uid, (Object) tigerCardDomain.uid) && Intrinsics.areEqual((Object) this.cardType, (Object) tigerCardDomain.cardType) && Intrinsics.areEqual((Object) this.productId, (Object) tigerCardDomain.productId) && this.accountGeneratedContentId == tigerCardDomain.accountGeneratedContentId && Intrinsics.areEqual((Object) this.wildcardUserContent, (Object) tigerCardDomain.wildcardUserContent) && Intrinsics.areEqual((Object) this.tigerTicketContent, (Object) tigerCardDomain.tigerTicketContent) && Intrinsics.areEqual((Object) this.multiTigercardVariant, (Object) tigerCardDomain.multiTigercardVariant);
    }

    public int hashCode() {
        int hashCode = ((((this.code.hashCode() * 31) + this.uid.hashCode()) * 31) + this.cardType.hashCode()) * 31;
        Integer num = this.productId;
        int i = 0;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.accountGeneratedContentId) * 31;
        AccountGeneratedContentsDomain accountGeneratedContentsDomain = this.wildcardUserContent;
        int hashCode3 = (hashCode2 + (accountGeneratedContentsDomain == null ? 0 : accountGeneratedContentsDomain.hashCode())) * 31;
        TigerTicketDomain tigerTicketDomain = this.tigerTicketContent;
        int hashCode4 = (hashCode3 + (tigerTicketDomain == null ? 0 : tigerTicketDomain.hashCode())) * 31;
        MultiTigercardVariantDomain multiTigercardVariantDomain = this.multiTigercardVariant;
        if (multiTigercardVariantDomain != null) {
            i = multiTigercardVariantDomain.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "TigerCardDomain(code=" + this.code + ", uid=" + this.uid + ", cardType=" + this.cardType + ", productId=" + this.productId + ", accountGeneratedContentId=" + this.accountGeneratedContentId + ", wildcardUserContent=" + this.wildcardUserContent + ", tigerTicketContent=" + this.tigerTicketContent + ", multiTigercardVariant=" + this.multiTigercardVariant + ')';
    }

    public TigerCardDomain(String str, String str2, String str3, Integer num, int i, AccountGeneratedContentsDomain accountGeneratedContentsDomain, TigerTicketDomain tigerTicketDomain, MultiTigercardVariantDomain multiTigercardVariantDomain) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "uid");
        Intrinsics.checkNotNullParameter(str3, "cardType");
        this.code = str;
        this.uid = str2;
        this.cardType = str3;
        this.productId = num;
        this.accountGeneratedContentId = i;
        this.wildcardUserContent = accountGeneratedContentsDomain;
        this.tigerTicketContent = tigerTicketDomain;
        this.multiTigercardVariant = multiTigercardVariantDomain;
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

    public final int getAccountGeneratedContentId() {
        return this.accountGeneratedContentId;
    }

    public final AccountGeneratedContentsDomain getWildcardUserContent() {
        return this.wildcardUserContent;
    }

    public final TigerTicketDomain getTigerTicketContent() {
        return this.tigerTicketContent;
    }

    public final MultiTigercardVariantDomain getMultiTigercardVariant() {
        return this.multiTigercardVariant;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$AccountGeneratedContentsDomain;", "", "name", "", "accountId", "", "totalDuration", "contentType", "transcodingStatus", "lastModifiedDate", "playlistLink", "coverLink", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()I", "getContentType", "()Ljava/lang/String;", "getCoverLink", "getLastModifiedDate", "getName", "getPlaylistLink", "getTotalDuration", "getTranscodingStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerCardsManagerService.kt */
    public static final class AccountGeneratedContentsDomain {
        private final int accountId;
        private final String contentType;
        private final String coverLink;
        private final String lastModifiedDate;
        private final String name;
        private final String playlistLink;
        private final int totalDuration;
        private final String transcodingStatus;

        public static /* synthetic */ AccountGeneratedContentsDomain copy$default(AccountGeneratedContentsDomain accountGeneratedContentsDomain, String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
            AccountGeneratedContentsDomain accountGeneratedContentsDomain2 = accountGeneratedContentsDomain;
            int i4 = i3;
            return accountGeneratedContentsDomain.copy((i4 & 1) != 0 ? accountGeneratedContentsDomain2.name : str, (i4 & 2) != 0 ? accountGeneratedContentsDomain2.accountId : i, (i4 & 4) != 0 ? accountGeneratedContentsDomain2.totalDuration : i2, (i4 & 8) != 0 ? accountGeneratedContentsDomain2.contentType : str2, (i4 & 16) != 0 ? accountGeneratedContentsDomain2.transcodingStatus : str3, (i4 & 32) != 0 ? accountGeneratedContentsDomain2.lastModifiedDate : str4, (i4 & 64) != 0 ? accountGeneratedContentsDomain2.playlistLink : str5, (i4 & 128) != 0 ? accountGeneratedContentsDomain2.coverLink : str6);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.accountId;
        }

        public final int component3() {
            return this.totalDuration;
        }

        public final String component4() {
            return this.contentType;
        }

        public final String component5() {
            return this.transcodingStatus;
        }

        public final String component6() {
            return this.lastModifiedDate;
        }

        public final String component7() {
            return this.playlistLink;
        }

        public final String component8() {
            return this.coverLink;
        }

        public final AccountGeneratedContentsDomain copy(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, CMSAttributeTableGenerator.CONTENT_TYPE);
            Intrinsics.checkNotNullParameter(str3, "transcodingStatus");
            String str7 = str4;
            Intrinsics.checkNotNullParameter(str7, "lastModifiedDate");
            String str8 = str5;
            Intrinsics.checkNotNullParameter(str8, "playlistLink");
            String str9 = str6;
            Intrinsics.checkNotNullParameter(str9, "coverLink");
            return new AccountGeneratedContentsDomain(str, i, i2, str2, str3, str7, str8, str9);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AccountGeneratedContentsDomain)) {
                return false;
            }
            AccountGeneratedContentsDomain accountGeneratedContentsDomain = (AccountGeneratedContentsDomain) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) accountGeneratedContentsDomain.name) && this.accountId == accountGeneratedContentsDomain.accountId && this.totalDuration == accountGeneratedContentsDomain.totalDuration && Intrinsics.areEqual((Object) this.contentType, (Object) accountGeneratedContentsDomain.contentType) && Intrinsics.areEqual((Object) this.transcodingStatus, (Object) accountGeneratedContentsDomain.transcodingStatus) && Intrinsics.areEqual((Object) this.lastModifiedDate, (Object) accountGeneratedContentsDomain.lastModifiedDate) && Intrinsics.areEqual((Object) this.playlistLink, (Object) accountGeneratedContentsDomain.playlistLink) && Intrinsics.areEqual((Object) this.coverLink, (Object) accountGeneratedContentsDomain.coverLink);
        }

        public int hashCode() {
            return (((((((((((((this.name.hashCode() * 31) + this.accountId) * 31) + this.totalDuration) * 31) + this.contentType.hashCode()) * 31) + this.transcodingStatus.hashCode()) * 31) + this.lastModifiedDate.hashCode()) * 31) + this.playlistLink.hashCode()) * 31) + this.coverLink.hashCode();
        }

        public String toString() {
            return "AccountGeneratedContentsDomain(name=" + this.name + ", accountId=" + this.accountId + ", totalDuration=" + this.totalDuration + ", contentType=" + this.contentType + ", transcodingStatus=" + this.transcodingStatus + ", lastModifiedDate=" + this.lastModifiedDate + ", playlistLink=" + this.playlistLink + ", coverLink=" + this.coverLink + ')';
        }

        public AccountGeneratedContentsDomain(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, CMSAttributeTableGenerator.CONTENT_TYPE);
            Intrinsics.checkNotNullParameter(str3, "transcodingStatus");
            Intrinsics.checkNotNullParameter(str4, "lastModifiedDate");
            Intrinsics.checkNotNullParameter(str5, "playlistLink");
            Intrinsics.checkNotNullParameter(str6, "coverLink");
            this.name = str;
            this.accountId = i;
            this.totalDuration = i2;
            this.contentType = str2;
            this.transcodingStatus = str3;
            this.lastModifiedDate = str4;
            this.playlistLink = str5;
            this.coverLink = str6;
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

        public final String getContentType() {
            return this.contentType;
        }

        public final String getTranscodingStatus() {
            return this.transcodingStatus;
        }

        public final String getLastModifiedDate() {
            return this.lastModifiedDate;
        }

        public final String getPlaylistLink() {
            return this.playlistLink;
        }

        public final String getCoverLink() {
            return this.coverLink;
        }
    }

    @Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001,B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Js\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006-"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$MultiTigercardVariantDomain;", "", "name", "", "description", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate", "products", "", "Lmedia/tiger/tigerbox/model/dto/ProductDetailsDto;", "recentlyUsedProduct", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$MultiTigercardVariantDomain$RecentlyUsedProductDomain;", "saveRecentlyUsedMultiTigercardProductUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$MultiTigercardVariantDomain$RecentlyUsedProductDomain;Ljava/lang/String;)V", "getCreatedBy", "()Ljava/lang/String;", "getCreatedDate", "getDescription", "getLastModifiedBy", "getLastModifiedDate", "getName", "getProducts", "()Ljava/util/List;", "getRecentlyUsedProduct", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$MultiTigercardVariantDomain$RecentlyUsedProductDomain;", "getSaveRecentlyUsedMultiTigercardProductUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "RecentlyUsedProductDomain", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerCardsManagerService.kt */
    public static final class MultiTigercardVariantDomain {
        private final String createdBy;
        private final String createdDate;
        private final String description;
        private final String lastModifiedBy;
        private final String lastModifiedDate;
        private final String name;
        private final List<ProductDetailsDto> products;
        private final RecentlyUsedProductDomain recentlyUsedProduct;
        private final String saveRecentlyUsedMultiTigercardProductUrl;

        public static /* synthetic */ MultiTigercardVariantDomain copy$default(MultiTigercardVariantDomain multiTigercardVariantDomain, String str, String str2, String str3, String str4, String str5, String str6, List list, RecentlyUsedProductDomain recentlyUsedProductDomain, String str7, int i, Object obj) {
            MultiTigercardVariantDomain multiTigercardVariantDomain2 = multiTigercardVariantDomain;
            int i2 = i;
            return multiTigercardVariantDomain.copy((i2 & 1) != 0 ? multiTigercardVariantDomain2.name : str, (i2 & 2) != 0 ? multiTigercardVariantDomain2.description : str2, (i2 & 4) != 0 ? multiTigercardVariantDomain2.createdBy : str3, (i2 & 8) != 0 ? multiTigercardVariantDomain2.createdDate : str4, (i2 & 16) != 0 ? multiTigercardVariantDomain2.lastModifiedBy : str5, (i2 & 32) != 0 ? multiTigercardVariantDomain2.lastModifiedDate : str6, (i2 & 64) != 0 ? multiTigercardVariantDomain2.products : list, (i2 & 128) != 0 ? multiTigercardVariantDomain2.recentlyUsedProduct : recentlyUsedProductDomain, (i2 & 256) != 0 ? multiTigercardVariantDomain2.saveRecentlyUsedMultiTigercardProductUrl : str7);
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

        public final List<ProductDetailsDto> component7() {
            return this.products;
        }

        public final RecentlyUsedProductDomain component8() {
            return this.recentlyUsedProduct;
        }

        public final String component9() {
            return this.saveRecentlyUsedMultiTigercardProductUrl;
        }

        public final MultiTigercardVariantDomain copy(String str, String str2, String str3, String str4, String str5, String str6, List<ProductDetailsDto> list, RecentlyUsedProductDomain recentlyUsedProductDomain, String str7) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(str3, "createdBy");
            Intrinsics.checkNotNullParameter(str4, "createdDate");
            return new MultiTigercardVariantDomain(str, str2, str3, str4, str5, str6, list, recentlyUsedProductDomain, str7);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MultiTigercardVariantDomain)) {
                return false;
            }
            MultiTigercardVariantDomain multiTigercardVariantDomain = (MultiTigercardVariantDomain) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) multiTigercardVariantDomain.name) && Intrinsics.areEqual((Object) this.description, (Object) multiTigercardVariantDomain.description) && Intrinsics.areEqual((Object) this.createdBy, (Object) multiTigercardVariantDomain.createdBy) && Intrinsics.areEqual((Object) this.createdDate, (Object) multiTigercardVariantDomain.createdDate) && Intrinsics.areEqual((Object) this.lastModifiedBy, (Object) multiTigercardVariantDomain.lastModifiedBy) && Intrinsics.areEqual((Object) this.lastModifiedDate, (Object) multiTigercardVariantDomain.lastModifiedDate) && Intrinsics.areEqual((Object) this.products, (Object) multiTigercardVariantDomain.products) && Intrinsics.areEqual((Object) this.recentlyUsedProduct, (Object) multiTigercardVariantDomain.recentlyUsedProduct) && Intrinsics.areEqual((Object) this.saveRecentlyUsedMultiTigercardProductUrl, (Object) multiTigercardVariantDomain.saveRecentlyUsedMultiTigercardProductUrl);
        }

        public int hashCode() {
            int hashCode = ((((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.createdDate.hashCode()) * 31;
            String str = this.lastModifiedBy;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.lastModifiedDate;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<ProductDetailsDto> list = this.products;
            int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
            RecentlyUsedProductDomain recentlyUsedProductDomain = this.recentlyUsedProduct;
            int hashCode5 = (hashCode4 + (recentlyUsedProductDomain == null ? 0 : recentlyUsedProductDomain.hashCode())) * 31;
            String str3 = this.saveRecentlyUsedMultiTigercardProductUrl;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode5 + i;
        }

        public String toString() {
            return "MultiTigercardVariantDomain(name=" + this.name + ", description=" + this.description + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy=" + this.lastModifiedBy + ", lastModifiedDate=" + this.lastModifiedDate + ", products=" + this.products + ", recentlyUsedProduct=" + this.recentlyUsedProduct + ", saveRecentlyUsedMultiTigercardProductUrl=" + this.saveRecentlyUsedMultiTigercardProductUrl + ')';
        }

        public MultiTigercardVariantDomain(String str, String str2, String str3, String str4, String str5, String str6, List<ProductDetailsDto> list, RecentlyUsedProductDomain recentlyUsedProductDomain, String str7) {
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
            this.products = list;
            this.recentlyUsedProduct = recentlyUsedProductDomain;
            this.saveRecentlyUsedMultiTigercardProductUrl = str7;
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

        public final List<ProductDetailsDto> getProducts() {
            return this.products;
        }

        public final RecentlyUsedProductDomain getRecentlyUsedProduct() {
            return this.recentlyUsedProduct;
        }

        public final String getSaveRecentlyUsedMultiTigercardProductUrl() {
            return this.saveRecentlyUsedMultiTigercardProductUrl;
        }

        @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003JS\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$MultiTigercardVariantDomain$RecentlyUsedProductDomain;", "", "multiTigercardVariantId", "", "profileId", "productId", "createdBy", "", "createdDate", "lastModifiedBy", "lastModifiedDate", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreatedBy", "()Ljava/lang/String;", "getCreatedDate", "getLastModifiedBy", "getLastModifiedDate", "getMultiTigercardVariantId", "()I", "getProductId", "getProfileId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: TigerCardsManagerService.kt */
        public static final class RecentlyUsedProductDomain {
            private final String createdBy;
            private final String createdDate;
            private final String lastModifiedBy;
            private final String lastModifiedDate;
            private final int multiTigercardVariantId;
            private final int productId;
            private final int profileId;

            public static /* synthetic */ RecentlyUsedProductDomain copy$default(RecentlyUsedProductDomain recentlyUsedProductDomain, int i, int i2, int i3, String str, String str2, String str3, String str4, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = recentlyUsedProductDomain.multiTigercardVariantId;
                }
                if ((i4 & 2) != 0) {
                    i2 = recentlyUsedProductDomain.profileId;
                }
                int i5 = i2;
                if ((i4 & 4) != 0) {
                    i3 = recentlyUsedProductDomain.productId;
                }
                int i6 = i3;
                if ((i4 & 8) != 0) {
                    str = recentlyUsedProductDomain.createdBy;
                }
                String str5 = str;
                if ((i4 & 16) != 0) {
                    str2 = recentlyUsedProductDomain.createdDate;
                }
                String str6 = str2;
                if ((i4 & 32) != 0) {
                    str3 = recentlyUsedProductDomain.lastModifiedBy;
                }
                String str7 = str3;
                if ((i4 & 64) != 0) {
                    str4 = recentlyUsedProductDomain.lastModifiedDate;
                }
                return recentlyUsedProductDomain.copy(i, i5, i6, str5, str6, str7, str4);
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

            public final RecentlyUsedProductDomain copy(int i, int i2, int i3, String str, String str2, String str3, String str4) {
                Intrinsics.checkNotNullParameter(str, "createdBy");
                Intrinsics.checkNotNullParameter(str2, "createdDate");
                return new RecentlyUsedProductDomain(i, i2, i3, str, str2, str3, str4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RecentlyUsedProductDomain)) {
                    return false;
                }
                RecentlyUsedProductDomain recentlyUsedProductDomain = (RecentlyUsedProductDomain) obj;
                return this.multiTigercardVariantId == recentlyUsedProductDomain.multiTigercardVariantId && this.profileId == recentlyUsedProductDomain.profileId && this.productId == recentlyUsedProductDomain.productId && Intrinsics.areEqual((Object) this.createdBy, (Object) recentlyUsedProductDomain.createdBy) && Intrinsics.areEqual((Object) this.createdDate, (Object) recentlyUsedProductDomain.createdDate) && Intrinsics.areEqual((Object) this.lastModifiedBy, (Object) recentlyUsedProductDomain.lastModifiedBy) && Intrinsics.areEqual((Object) this.lastModifiedDate, (Object) recentlyUsedProductDomain.lastModifiedDate);
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
                return "RecentlyUsedProductDomain(multiTigercardVariantId=" + this.multiTigercardVariantId + ", profileId=" + this.profileId + ", productId=" + this.productId + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy=" + this.lastModifiedBy + ", lastModifiedDate=" + this.lastModifiedDate + ')';
            }

            public RecentlyUsedProductDomain(int i, int i2, int i3, String str, String str2, String str3, String str4) {
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
            public /* synthetic */ RecentlyUsedProductDomain(int i, int i2, int i3, String str, String str2, String str3, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
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
}
