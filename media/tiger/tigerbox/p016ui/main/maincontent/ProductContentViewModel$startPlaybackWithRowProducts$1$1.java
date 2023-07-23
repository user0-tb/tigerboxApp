package media.tiger.tigerbox.p016ui.main.maincontent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.interfaces.CardValidationFailError;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.TicketFailure;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$startPlaybackWithRowProducts$1$1 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$startPlaybackWithRowProducts$1$1 extends Lambda implements Function1<ProductAcquisitionService.ErrorCode, Unit> {
    final /* synthetic */ ProductContentViewModel this$0;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$startPlaybackWithRowProducts$1$1$WhenMappings */
    /* compiled from: ProductContentViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductAcquisitionService.ErrorCode.values().length];
            iArr[ProductAcquisitionService.ErrorCode.NO_WIFI.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$startPlaybackWithRowProducts$1$1(ProductContentViewModel productContentViewModel) {
        super(1);
        this.this$0 = productContentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductAcquisitionService.ErrorCode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisitionService.ErrorCode errorCode) {
        if (errorCode != null) {
            ProductContentViewModel productContentViewModel = this.this$0;
            productContentViewModel.audioPlayerService.stop();
            productContentViewModel._startedAudioProduct.postValue(null);
            if (WhenMappings.$EnumSwitchMapping$0[errorCode.ordinal()] == 1) {
                productContentViewModel.tigerCardListener.onCardValidateFailure(CardValidationFailError.NO_WIFI, (TicketFailure) null);
            } else {
                productContentViewModel.tigerCardListener.onCardValidateFailure(CardValidationFailError.TIGERCARD_PRODUCT_COULD_NOT_BE_PLAYED, (TicketFailure) null);
            }
        }
    }
}
