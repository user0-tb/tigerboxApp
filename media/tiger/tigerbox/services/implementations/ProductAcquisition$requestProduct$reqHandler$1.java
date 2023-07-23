package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.implementations.ProductAcquisition;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$RequestHandler;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProductAcquisition.kt */
final class ProductAcquisition$requestProduct$reqHandler$1 extends Lambda implements Function1<ProductAcquisition.RequestHandler, Unit> {
    final /* synthetic */ ProductAcquisition this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductAcquisition$requestProduct$reqHandler$1(ProductAcquisition productAcquisition) {
        super(1);
        this.this$0 = productAcquisition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductAcquisition.RequestHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisition.RequestHandler requestHandler) {
        Intrinsics.checkNotNullParameter(requestHandler, "it");
        this.this$0.removeHandler(requestHandler);
    }
}
