package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.interfaces.CardValidationFailError;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.TicketFailure;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerCardsManager.kt */
final class TigerCardsManager$handleValidatedCard$1$3 extends Lambda implements Function1<ProductAcquisitionService.ErrorCode, Unit> {
    final /* synthetic */ TigerCardsManager this$0;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerCardsManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductAcquisitionService.ErrorCode.values().length];
            iArr[ProductAcquisitionService.ErrorCode.NO_WIFI.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerCardsManager$handleValidatedCard$1$3(TigerCardsManager tigerCardsManager) {
        super(1);
        this.this$0 = tigerCardsManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductAcquisitionService.ErrorCode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisitionService.ErrorCode errorCode) {
        if (errorCode != null) {
            TigerCardsManager tigerCardsManager = this.this$0;
            if (WhenMappings.$EnumSwitchMapping$0[errorCode.ordinal()] == 1) {
                TigerCardsManager.notifyAllOnCardValidateFailure$default(tigerCardsManager, CardValidationFailError.NO_WIFI, (TicketFailure) null, 2, (Object) null);
            } else {
                TigerCardsManager.notifyAllOnCardValidateFailure$default(tigerCardsManager, CardValidationFailError.TIGERCARD_PRODUCT_COULD_NOT_BE_PLAYED, (TicketFailure) null, 2, (Object) null);
            }
        }
    }
}
