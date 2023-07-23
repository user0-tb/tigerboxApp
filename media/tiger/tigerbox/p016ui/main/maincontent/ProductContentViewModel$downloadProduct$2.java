package media.tiger.tigerbox.p016ui.main.maincontent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "stepType", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$StepType;", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$downloadProduct$2 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$downloadProduct$2 extends Lambda implements Function2<ProductAcquisitionService.StepType, ProductAcquisitionService.ErrorCode, Unit> {
    final /* synthetic */ ProductContentViewModel this$0;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$downloadProduct$2$WhenMappings */
    /* compiled from: ProductContentViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductAcquisitionService.StepType.values().length];
            iArr[ProductAcquisitionService.StepType.ACQUISITION_STARTED.ordinal()] = 1;
            iArr[ProductAcquisitionService.StepType.ACQUISITION_FINISHED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$downloadProduct$2(ProductContentViewModel productContentViewModel) {
        super(2);
        this.this$0 = productContentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ProductAcquisitionService.StepType) obj, (ProductAcquisitionService.ErrorCode) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisitionService.StepType stepType, ProductAcquisitionService.ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(stepType, "stepType");
        int i = WhenMappings.$EnumSwitchMapping$0[stepType.ordinal()];
        if (i == 1) {
            this.this$0.updateListDlStatus();
        } else if (i == 2) {
            if (errorCode != null) {
                this.this$0.updateListDlStatus();
            }
            this.this$0.handleAcquisitionError(errorCode);
        }
    }
}
