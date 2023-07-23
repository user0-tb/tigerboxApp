package media.tiger.tigerbox.developer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "step", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$StepType;", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AdbReceiver.kt */
final class AdbReceiver$onReceive$1$3$1 extends Lambda implements Function2<ProductAcquisitionService.StepType, ProductAcquisitionService.ErrorCode, Unit> {
    final /* synthetic */ int $productId;
    final /* synthetic */ AdbReceiver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdbReceiver$onReceive$1$3$1(AdbReceiver adbReceiver, int i) {
        super(2);
        this.this$0 = adbReceiver;
        this.$productId = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ProductAcquisitionService.StepType) obj, (ProductAcquisitionService.ErrorCode) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisitionService.StepType stepType, ProductAcquisitionService.ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(stepType, "step");
        this.this$0.downloadStep(stepType, errorCode, this.$productId);
    }
}
