package media.tiger.tigerbox.p016ui.main.maincontent;

import android.os.Bundle;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.MaincontentNavGraphDirections;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductListMainContentFragmentDirections;", "", "()V", "ActionProductListMainContentToSeeMoreProducts", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductListMainContentFragmentDirections */
/* compiled from: ProductListMainContentFragmentDirections.kt */
public final class ProductListMainContentFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductListMainContentFragmentDirections$ActionProductListMainContentToSeeMoreProducts;", "Landroidx/navigation/NavDirections;", "rowId", "", "ordinal", "(II)V", "actionId", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getOrdinal", "getRowId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductListMainContentFragmentDirections$ActionProductListMainContentToSeeMoreProducts */
    /* compiled from: ProductListMainContentFragmentDirections.kt */
    private static final class ActionProductListMainContentToSeeMoreProducts implements NavDirections {
        private final int actionId = C2814R.C2817id.action_productListMainContent_to_seeMoreProducts;
        private final int ordinal;
        private final int rowId;

        public static /* synthetic */ ActionProductListMainContentToSeeMoreProducts copy$default(ActionProductListMainContentToSeeMoreProducts actionProductListMainContentToSeeMoreProducts, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = actionProductListMainContentToSeeMoreProducts.rowId;
            }
            if ((i3 & 2) != 0) {
                i2 = actionProductListMainContentToSeeMoreProducts.ordinal;
            }
            return actionProductListMainContentToSeeMoreProducts.copy(i, i2);
        }

        public final int component1() {
            return this.rowId;
        }

        public final int component2() {
            return this.ordinal;
        }

        public final ActionProductListMainContentToSeeMoreProducts copy(int i, int i2) {
            return new ActionProductListMainContentToSeeMoreProducts(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionProductListMainContentToSeeMoreProducts)) {
                return false;
            }
            ActionProductListMainContentToSeeMoreProducts actionProductListMainContentToSeeMoreProducts = (ActionProductListMainContentToSeeMoreProducts) obj;
            return this.rowId == actionProductListMainContentToSeeMoreProducts.rowId && this.ordinal == actionProductListMainContentToSeeMoreProducts.ordinal;
        }

        public int hashCode() {
            return (this.rowId * 31) + this.ordinal;
        }

        public String toString() {
            return "ActionProductListMainContentToSeeMoreProducts(rowId=" + this.rowId + ", ordinal=" + this.ordinal + ')';
        }

        public ActionProductListMainContentToSeeMoreProducts(int i, int i2) {
            this.rowId = i;
            this.ordinal = i2;
        }

        public final int getRowId() {
            return this.rowId;
        }

        public final int getOrdinal() {
            return this.ordinal;
        }

        public int getActionId() {
            return this.actionId;
        }

        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putInt("rowId", this.rowId);
            bundle.putInt("ordinal", this.ordinal);
            return bundle;
        }
    }

    private ProductListMainContentFragmentDirections() {
    }

    @Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductListMainContentFragmentDirections$Companion;", "", "()V", "actionMainContentToTigerTicketValid", "Landroidx/navigation/NavDirections;", "actionProductListMainContentToSeeMoreProducts", "rowId", "", "ordinal", "actionToMainContentProductList", "actionToMediaPlayer", "actionToMultiProductCard", "actionToOfflineMode", "actionToParentalGate", "actionToParentalSettings", "actionToShowProfilePicture", "actionToUserProfilesSwitching", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductListMainContentFragmentDirections$Companion */
    /* compiled from: ProductListMainContentFragmentDirections.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavDirections actionProductListMainContentToSeeMoreProducts(int i, int i2) {
            return new ActionProductListMainContentToSeeMoreProducts(i, i2);
        }

        public final NavDirections actionMainContentToTigerTicketValid() {
            return new ActionOnlyNavDirections(C2814R.C2817id.action_mainContent_to_tigerTicketValid);
        }

        public final NavDirections actionToParentalGate() {
            return MaincontentNavGraphDirections.Companion.actionToParentalGate();
        }

        public final NavDirections actionToParentalSettings() {
            return MaincontentNavGraphDirections.Companion.actionToParentalSettings();
        }

        public final NavDirections actionToMediaPlayer() {
            return MaincontentNavGraphDirections.Companion.actionToMediaPlayer();
        }

        public final NavDirections actionToUserProfilesSwitching() {
            return MaincontentNavGraphDirections.Companion.actionToUserProfilesSwitching();
        }

        public final NavDirections actionToShowProfilePicture() {
            return MaincontentNavGraphDirections.Companion.actionToShowProfilePicture();
        }

        public final NavDirections actionToOfflineMode() {
            return MaincontentNavGraphDirections.Companion.actionToOfflineMode();
        }

        public final NavDirections actionToMultiProductCard() {
            return MaincontentNavGraphDirections.Companion.actionToMultiProductCard();
        }

        public final NavDirections actionToMainContentProductList() {
            return MaincontentNavGraphDirections.Companion.actionToMainContentProductList();
        }
    }
}
