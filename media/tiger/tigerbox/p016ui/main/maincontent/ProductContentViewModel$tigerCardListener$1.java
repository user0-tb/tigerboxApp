package media.tiger.tigerbox.p016ui.main.maincontent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.TigerTicketFail;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.services.implementations.TigerCardsManager;
import media.tiger.tigerbox.services.interfaces.CardValidationFailError;
import media.tiger.tigerbox.services.interfaces.TicketFailure;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.TigerCardsListener;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;
import media.tiger.tigerbox.services.interfaces.WildcardReassignStep;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$tigerCardListener$1", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsListener;", "onCardInsertedAndValidated", "", "card", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "onCardRemoved", "onCardValidateFailure", "failError", "Lmedia/tiger/tigerbox/services/interfaces/CardValidationFailError;", "ticketFailure", "Lmedia/tiger/tigerbox/services/interfaces/TicketFailure;", "onTigerTicketStep", "step", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "onWildcardReassignStep", "Lmedia/tiger/tigerbox/services/interfaces/WildcardReassignStep;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$tigerCardListener$1 */
/* compiled from: ProductContentViewModel.kt */
public final class ProductContentViewModel$tigerCardListener$1 implements TigerCardsListener {
    final /* synthetic */ ProductContentViewModel this$0;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$tigerCardListener$1$WhenMappings */
    /* compiled from: ProductContentViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardValidationFailError.values().length];
            iArr[CardValidationFailError.WILDCARD_USER_CONTENT_NOT_FINISHED.ordinal()] = 1;
            iArr[CardValidationFailError.WILDCARD_IS_PRIVATE.ordinal()] = 2;
            iArr[CardValidationFailError.CARD_404_NOT_VALID.ordinal()] = 3;
            iArr[CardValidationFailError.TIGERCARD_PRODUCT_COULD_NOT_BE_PLAYED.ordinal()] = 4;
            iArr[CardValidationFailError.WILDCARD_PRODUCT_COULD_NOT_BE_PLAYED.ordinal()] = 5;
            iArr[CardValidationFailError.WILDCARD_USER_CONTENT_COULD_NOT_BE_PLAYED.ordinal()] = 6;
            iArr[CardValidationFailError.COULD_NOT_READ_CARD.ordinal()] = 7;
            iArr[CardValidationFailError.NO_WIFI.ordinal()] = 8;
            iArr[CardValidationFailError.UNKNOWN_CARD_TYPE.ordinal()] = 9;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_403.ordinal()] = 10;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_404.ordinal()] = 11;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_410.ordinal()] = 12;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_GENERAL.ordinal()] = 13;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_429.ordinal()] = 14;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    ProductContentViewModel$tigerCardListener$1(ProductContentViewModel productContentViewModel) {
        this.this$0 = productContentViewModel;
    }

    public void onCardInsertedAndValidated(TigerCardDomain tigerCardDomain) {
        Intrinsics.checkNotNullParameter(tigerCardDomain, "card");
        Timber.Forest.mo50221i("ProductContentViewModel onCardInsertedAndValidated", new Object[0]);
        if (Intrinsics.areEqual((Object) tigerCardDomain.getCardType(), (Object) TigerCardsManager.MULTI_TIGERCARD)) {
            this.this$0.setMultiProductTigerCard(tigerCardDomain);
            this.this$0._multiCardInserted.setValue(true);
        }
    }

    public void onCardValidateFailure(CardValidationFailError cardValidationFailError, TicketFailure ticketFailure) {
        TigerTicketFail failReason;
        Intrinsics.checkNotNullParameter(cardValidationFailError, "failError");
        Timber.Forest.mo50221i("ProductContentViewModel onCardValidateFailure", new Object[0]);
        String str = null;
        this.this$0.setActiveErrorMessage((String) null);
        switch (WhenMappings.$EnumSwitchMapping$0[cardValidationFailError.ordinal()]) {
            case 1:
                this.this$0._activeError.setValue(InfoDialogType.WILDCARD_UNPROCESSED);
                return;
            case 2:
                this.this$0._activeError.setValue(InfoDialogType.WILDCARD_PRIVATE);
                return;
            case 3:
                this.this$0._activeError.setValue(InfoDialogType.CARD_NOT_FOUND);
                return;
            case 4:
            case 5:
            case 6:
                this.this$0._activeError.setValue(InfoDialogType.ACCESS_FAILURE);
                return;
            case 7:
                this.this$0._activeError.setValue(InfoDialogType.NFC_READ_ERROR);
                return;
            case 8:
                this.this$0._activeError.setValue(InfoDialogType.NO_WIRELESS_SIGNAL);
                return;
            case 9:
                this.this$0._activeError.setValue(InfoDialogType.TIGERTICKET_404_ERROR);
                return;
            case 10:
                this.this$0._activeError.setValue(InfoDialogType.TIGERTICKET_403_ERROR);
                return;
            case 11:
                this.this$0._activeError.setValue(InfoDialogType.TIGERTICKET_404_ERROR);
                return;
            case 12:
                this.this$0._activeError.setValue(InfoDialogType.TIGERTICKET_410_ERROR);
                return;
            case 13:
                this.this$0._activeError.setValue(InfoDialogType.GENERAL_ERROR);
                return;
            case 14:
                ProductContentViewModel productContentViewModel = this.this$0;
                if (!(ticketFailure == null || (failReason = ticketFailure.getFailReason()) == null)) {
                    str = failReason.getMessage();
                }
                productContentViewModel.setActiveErrorMessage(str);
                this.this$0._activeError.setValue(InfoDialogType.TIGERTICKET_429_ERROR);
                return;
            default:
                return;
        }
    }

    public void onTigerTicketStep(TigerTicketStepDomain tigerTicketStepDomain) {
        Intrinsics.checkNotNullParameter(tigerTicketStepDomain, "step");
        Timber.Forest.mo50221i("ProductContentViewModel onTigerTicketStep", new Object[0]);
        this.this$0._activeTigerTicketStep.setValue(tigerTicketStepDomain);
    }

    public void onWildcardReassignStep(WildcardReassignStep wildcardReassignStep) {
        Intrinsics.checkNotNullParameter(wildcardReassignStep, "step");
        Timber.Forest.mo50221i("ProductContentViewModel onWildcardReassignStep", new Object[0]);
    }

    public void onCardRemoved() {
        Timber.Forest.mo50221i("ProductContentViewModel onCardRemoved", new Object[0]);
        if (this.this$0.getMultiProductTigerCard() != null) {
            this.this$0._multiCardInserted.setValue(false);
            this.this$0.setMultiProductTigerCard((TigerCardDomain) null);
        }
        this.this$0._activeError.setValue(null);
        this.this$0._activeTigerTicketStep.setValue(null);
    }
}
