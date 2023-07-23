package media.tiger.tigerbox.model.dto;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006 "}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct;", "Ljava/io/Serializable;", "couponDto", "Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$CouponDto;", "linkedProduct", "Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$LinkedProduct;", "newEndDate", "", "type", "(Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$CouponDto;Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$LinkedProduct;Ljava/lang/String;Ljava/lang/String;)V", "getCouponDto", "()Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$CouponDto;", "getLinkedProduct", "()Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$LinkedProduct;", "getNewEndDate", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "CouponDto", "Duration", "LinkedProduct", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerTicketAssignedProduct.kt */
public final class TigerTicketAssignedProduct implements Serializable {
    private final CouponDto couponDto;
    private final LinkedProduct linkedProduct;
    private final String newEndDate;
    private final String type;

    public static /* synthetic */ TigerTicketAssignedProduct copy$default(TigerTicketAssignedProduct tigerTicketAssignedProduct, CouponDto couponDto2, LinkedProduct linkedProduct2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            couponDto2 = tigerTicketAssignedProduct.couponDto;
        }
        if ((i & 2) != 0) {
            linkedProduct2 = tigerTicketAssignedProduct.linkedProduct;
        }
        if ((i & 4) != 0) {
            str = tigerTicketAssignedProduct.newEndDate;
        }
        if ((i & 8) != 0) {
            str2 = tigerTicketAssignedProduct.type;
        }
        return tigerTicketAssignedProduct.copy(couponDto2, linkedProduct2, str, str2);
    }

    public final CouponDto component1() {
        return this.couponDto;
    }

    public final LinkedProduct component2() {
        return this.linkedProduct;
    }

    public final String component3() {
        return this.newEndDate;
    }

    public final String component4() {
        return this.type;
    }

    public final TigerTicketAssignedProduct copy(CouponDto couponDto2, LinkedProduct linkedProduct2, String str, String str2) {
        Intrinsics.checkNotNullParameter(couponDto2, "couponDto");
        Intrinsics.checkNotNullParameter(linkedProduct2, "linkedProduct");
        Intrinsics.checkNotNullParameter(str, "newEndDate");
        Intrinsics.checkNotNullParameter(str2, SessionDescription.ATTR_TYPE);
        return new TigerTicketAssignedProduct(couponDto2, linkedProduct2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TigerTicketAssignedProduct)) {
            return false;
        }
        TigerTicketAssignedProduct tigerTicketAssignedProduct = (TigerTicketAssignedProduct) obj;
        return Intrinsics.areEqual((Object) this.couponDto, (Object) tigerTicketAssignedProduct.couponDto) && Intrinsics.areEqual((Object) this.linkedProduct, (Object) tigerTicketAssignedProduct.linkedProduct) && Intrinsics.areEqual((Object) this.newEndDate, (Object) tigerTicketAssignedProduct.newEndDate) && Intrinsics.areEqual((Object) this.type, (Object) tigerTicketAssignedProduct.type);
    }

    public int hashCode() {
        return (((((this.couponDto.hashCode() * 31) + this.linkedProduct.hashCode()) * 31) + this.newEndDate.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "TigerTicketAssignedProduct(couponDto=" + this.couponDto + ", linkedProduct=" + this.linkedProduct + ", newEndDate=" + this.newEndDate + ", type=" + this.type + ')';
    }

    public TigerTicketAssignedProduct(CouponDto couponDto2, LinkedProduct linkedProduct2, String str, String str2) {
        Intrinsics.checkNotNullParameter(couponDto2, "couponDto");
        Intrinsics.checkNotNullParameter(linkedProduct2, "linkedProduct");
        Intrinsics.checkNotNullParameter(str, "newEndDate");
        Intrinsics.checkNotNullParameter(str2, SessionDescription.ATTR_TYPE);
        this.couponDto = couponDto2;
        this.linkedProduct = linkedProduct2;
        this.newEndDate = str;
        this.type = str2;
    }

    public final CouponDto getCouponDto() {
        return this.couponDto;
    }

    public final LinkedProduct getLinkedProduct() {
        return this.linkedProduct;
    }

    public final String getNewEndDate() {
        return this.newEndDate;
    }

    public final String getType() {
        return this.type;
    }

    @Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$CouponDto;", "Ljava/io/Serializable;", "duration", "Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$Duration;", "landingPageId", "", "(Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$Duration;Ljava/lang/String;)V", "getDuration", "()Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$Duration;", "getLandingPageId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerTicketAssignedProduct.kt */
    public static final class CouponDto implements Serializable {
        private final Duration duration;
        private final String landingPageId;

        public static /* synthetic */ CouponDto copy$default(CouponDto couponDto, Duration duration2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                duration2 = couponDto.duration;
            }
            if ((i & 2) != 0) {
                str = couponDto.landingPageId;
            }
            return couponDto.copy(duration2, str);
        }

        public final Duration component1() {
            return this.duration;
        }

        public final String component2() {
            return this.landingPageId;
        }

        public final CouponDto copy(Duration duration2, String str) {
            Intrinsics.checkNotNullParameter(duration2, TypedValues.TransitionType.S_DURATION);
            Intrinsics.checkNotNullParameter(str, "landingPageId");
            return new CouponDto(duration2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CouponDto)) {
                return false;
            }
            CouponDto couponDto = (CouponDto) obj;
            return Intrinsics.areEqual((Object) this.duration, (Object) couponDto.duration) && Intrinsics.areEqual((Object) this.landingPageId, (Object) couponDto.landingPageId);
        }

        public int hashCode() {
            return (this.duration.hashCode() * 31) + this.landingPageId.hashCode();
        }

        public String toString() {
            return "CouponDto(duration=" + this.duration + ", landingPageId=" + this.landingPageId + ')';
        }

        public CouponDto(Duration duration2, String str) {
            Intrinsics.checkNotNullParameter(duration2, TypedValues.TransitionType.S_DURATION);
            Intrinsics.checkNotNullParameter(str, "landingPageId");
            this.duration = duration2;
            this.landingPageId = str;
        }

        public final Duration getDuration() {
            return this.duration;
        }

        public final String getLandingPageId() {
            return this.landingPageId;
        }
    }

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jg\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006+"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$LinkedProduct;", "Ljava/io/Serializable;", "displayName", "", "period", "Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$Duration;", "planVariantDescription", "planVariantId", "price", "", "productDescription", "shortName", "trial", "verb", "(Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$Duration;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getPeriod", "()Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$Duration;", "getPlanVariantDescription", "getPlanVariantId", "getPrice", "()I", "getProductDescription", "getShortName", "getTrial", "getVerb", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerTicketAssignedProduct.kt */
    public static final class LinkedProduct implements Serializable {
        private final String displayName;
        private final Duration period;
        private final String planVariantDescription;
        private final String planVariantId;
        private final int price;
        private final String productDescription;
        private final String shortName;
        private final String trial;
        private final String verb;

        public static /* synthetic */ LinkedProduct copy$default(LinkedProduct linkedProduct, String str, Duration duration, String str2, String str3, int i, String str4, String str5, String str6, String str7, int i2, Object obj) {
            LinkedProduct linkedProduct2 = linkedProduct;
            int i3 = i2;
            return linkedProduct.copy((i3 & 1) != 0 ? linkedProduct2.displayName : str, (i3 & 2) != 0 ? linkedProduct2.period : duration, (i3 & 4) != 0 ? linkedProduct2.planVariantDescription : str2, (i3 & 8) != 0 ? linkedProduct2.planVariantId : str3, (i3 & 16) != 0 ? linkedProduct2.price : i, (i3 & 32) != 0 ? linkedProduct2.productDescription : str4, (i3 & 64) != 0 ? linkedProduct2.shortName : str5, (i3 & 128) != 0 ? linkedProduct2.trial : str6, (i3 & 256) != 0 ? linkedProduct2.verb : str7);
        }

        public final String component1() {
            return this.displayName;
        }

        public final Duration component2() {
            return this.period;
        }

        public final String component3() {
            return this.planVariantDescription;
        }

        public final String component4() {
            return this.planVariantId;
        }

        public final int component5() {
            return this.price;
        }

        public final String component6() {
            return this.productDescription;
        }

        public final String component7() {
            return this.shortName;
        }

        public final String component8() {
            return this.trial;
        }

        public final String component9() {
            return this.verb;
        }

        public final LinkedProduct copy(String str, Duration duration, String str2, String str3, int i, String str4, String str5, String str6, String str7) {
            Intrinsics.checkNotNullParameter(str, "displayName");
            Intrinsics.checkNotNullParameter(duration, TypedValues.CycleType.S_WAVE_PERIOD);
            Intrinsics.checkNotNullParameter(str2, "planVariantDescription");
            Intrinsics.checkNotNullParameter(str3, "planVariantId");
            String str8 = str5;
            Intrinsics.checkNotNullParameter(str8, "shortName");
            String str9 = str7;
            Intrinsics.checkNotNullParameter(str9, "verb");
            return new LinkedProduct(str, duration, str2, str3, i, str4, str8, str6, str9);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LinkedProduct)) {
                return false;
            }
            LinkedProduct linkedProduct = (LinkedProduct) obj;
            return Intrinsics.areEqual((Object) this.displayName, (Object) linkedProduct.displayName) && Intrinsics.areEqual((Object) this.period, (Object) linkedProduct.period) && Intrinsics.areEqual((Object) this.planVariantDescription, (Object) linkedProduct.planVariantDescription) && Intrinsics.areEqual((Object) this.planVariantId, (Object) linkedProduct.planVariantId) && this.price == linkedProduct.price && Intrinsics.areEqual((Object) this.productDescription, (Object) linkedProduct.productDescription) && Intrinsics.areEqual((Object) this.shortName, (Object) linkedProduct.shortName) && Intrinsics.areEqual((Object) this.trial, (Object) linkedProduct.trial) && Intrinsics.areEqual((Object) this.verb, (Object) linkedProduct.verb);
        }

        public int hashCode() {
            int hashCode = ((((((((this.displayName.hashCode() * 31) + this.period.hashCode()) * 31) + this.planVariantDescription.hashCode()) * 31) + this.planVariantId.hashCode()) * 31) + this.price) * 31;
            String str = this.productDescription;
            int i = 0;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.shortName.hashCode()) * 31;
            String str2 = this.trial;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return ((hashCode2 + i) * 31) + this.verb.hashCode();
        }

        public String toString() {
            return "LinkedProduct(displayName=" + this.displayName + ", period=" + this.period + ", planVariantDescription=" + this.planVariantDescription + ", planVariantId=" + this.planVariantId + ", price=" + this.price + ", productDescription=" + this.productDescription + ", shortName=" + this.shortName + ", trial=" + this.trial + ", verb=" + this.verb + ')';
        }

        public LinkedProduct(String str, Duration duration, String str2, String str3, int i, String str4, String str5, String str6, String str7) {
            Intrinsics.checkNotNullParameter(str, "displayName");
            Intrinsics.checkNotNullParameter(duration, TypedValues.CycleType.S_WAVE_PERIOD);
            Intrinsics.checkNotNullParameter(str2, "planVariantDescription");
            Intrinsics.checkNotNullParameter(str3, "planVariantId");
            Intrinsics.checkNotNullParameter(str5, "shortName");
            Intrinsics.checkNotNullParameter(str7, "verb");
            this.displayName = str;
            this.period = duration;
            this.planVariantDescription = str2;
            this.planVariantId = str3;
            this.price = i;
            this.productDescription = str4;
            this.shortName = str5;
            this.trial = str6;
            this.verb = str7;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final Duration getPeriod() {
            return this.period;
        }

        public final String getPlanVariantDescription() {
            return this.planVariantDescription;
        }

        public final String getPlanVariantId() {
            return this.planVariantId;
        }

        public final int getPrice() {
            return this.price;
        }

        public final String getProductDescription() {
            return this.productDescription;
        }

        public final String getShortName() {
            return this.shortName;
        }

        public final String getTrial() {
            return this.trial;
        }

        public final String getVerb() {
            return this.verb;
        }
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct$Duration;", "Ljava/io/Serializable;", "unit", "", "quantity", "", "(Ljava/lang/String;I)V", "getQuantity", "()I", "getUnit", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerTicketAssignedProduct.kt */
    public static final class Duration implements Serializable {
        private final int quantity;
        private final String unit;

        public static /* synthetic */ Duration copy$default(Duration duration, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = duration.unit;
            }
            if ((i2 & 2) != 0) {
                i = duration.quantity;
            }
            return duration.copy(str, i);
        }

        public final String component1() {
            return this.unit;
        }

        public final int component2() {
            return this.quantity;
        }

        public final Duration copy(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "unit");
            return new Duration(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Duration)) {
                return false;
            }
            Duration duration = (Duration) obj;
            return Intrinsics.areEqual((Object) this.unit, (Object) duration.unit) && this.quantity == duration.quantity;
        }

        public int hashCode() {
            return (this.unit.hashCode() * 31) + this.quantity;
        }

        public String toString() {
            return "Duration(unit=" + this.unit + ", quantity=" + this.quantity + ')';
        }

        public Duration(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "unit");
            this.unit = str;
            this.quantity = i;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public final String getUnit() {
            return this.unit;
        }
    }
}
