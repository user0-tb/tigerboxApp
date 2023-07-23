package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/TigerTicketPurchase;", "", "Cart", "Lmedia/tiger/tigerbox/model/domain/TigerTicketPurchase$TigerTicketCart;", "(Lmedia/tiger/tigerbox/model/domain/TigerTicketPurchase$TigerTicketCart;)V", "getCart", "()Lmedia/tiger/tigerbox/model/domain/TigerTicketPurchase$TigerTicketCart;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TigerTicketCart", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerTicketPurchase.kt */
public final class TigerTicketPurchase {
    private final TigerTicketCart Cart;

    public static /* synthetic */ TigerTicketPurchase copy$default(TigerTicketPurchase tigerTicketPurchase, TigerTicketCart tigerTicketCart, int i, Object obj) {
        if ((i & 1) != 0) {
            tigerTicketCart = tigerTicketPurchase.Cart;
        }
        return tigerTicketPurchase.copy(tigerTicketCart);
    }

    public final TigerTicketCart component1() {
        return this.Cart;
    }

    public final TigerTicketPurchase copy(TigerTicketCart tigerTicketCart) {
        Intrinsics.checkNotNullParameter(tigerTicketCart, "Cart");
        return new TigerTicketPurchase(tigerTicketCart);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TigerTicketPurchase) && Intrinsics.areEqual((Object) this.Cart, (Object) ((TigerTicketPurchase) obj).Cart);
    }

    public int hashCode() {
        return this.Cart.hashCode();
    }

    public String toString() {
        return "TigerTicketPurchase(Cart=" + this.Cart + ')';
    }

    public TigerTicketPurchase(TigerTicketCart tigerTicketCart) {
        Intrinsics.checkNotNullParameter(tigerTicketCart, "Cart");
        this.Cart = tigerTicketCart;
    }

    public final TigerTicketCart getCart() {
        return this.Cart;
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/TigerTicketPurchase$TigerTicketCart;", "", "planVariant", "", "ticketCode", "ticketPin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "PlanVariantId", "CouponCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getCouponCode", "()Ljava/lang/String;", "getPlanVariantId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerTicketPurchase.kt */
    public static final class TigerTicketCart {
        private final String CouponCode;
        private final String PlanVariantId;

        public static /* synthetic */ TigerTicketCart copy$default(TigerTicketCart tigerTicketCart, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tigerTicketCart.PlanVariantId;
            }
            if ((i & 2) != 0) {
                str2 = tigerTicketCart.CouponCode;
            }
            return tigerTicketCart.copy(str, str2);
        }

        public final String component1() {
            return this.PlanVariantId;
        }

        public final String component2() {
            return this.CouponCode;
        }

        public final TigerTicketCart copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "PlanVariantId");
            Intrinsics.checkNotNullParameter(str2, "CouponCode");
            return new TigerTicketCart(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TigerTicketCart)) {
                return false;
            }
            TigerTicketCart tigerTicketCart = (TigerTicketCart) obj;
            return Intrinsics.areEqual((Object) this.PlanVariantId, (Object) tigerTicketCart.PlanVariantId) && Intrinsics.areEqual((Object) this.CouponCode, (Object) tigerTicketCart.CouponCode);
        }

        public int hashCode() {
            return (this.PlanVariantId.hashCode() * 31) + this.CouponCode.hashCode();
        }

        public String toString() {
            return "TigerTicketCart(PlanVariantId=" + this.PlanVariantId + ", CouponCode=" + this.CouponCode + ')';
        }

        public TigerTicketCart(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "PlanVariantId");
            Intrinsics.checkNotNullParameter(str2, "CouponCode");
            this.PlanVariantId = str;
            this.CouponCode = str2;
        }

        public final String getPlanVariantId() {
            return this.PlanVariantId;
        }

        public final String getCouponCode() {
            return this.CouponCode;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public TigerTicketCart(String str, String str2, String str3) {
            this(str, str2 + 9 + str3);
            Intrinsics.checkNotNullParameter(str, "planVariant");
            Intrinsics.checkNotNullParameter(str2, "ticketCode");
            Intrinsics.checkNotNullParameter(str3, "ticketPin");
        }
    }
}
