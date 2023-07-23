package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.dto.Acquisition;
import media.tiger.tigerbox.services.implementations.ProductAcquisition;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Lmedia/tiger/tigerbox/model/dto/Acquisition;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProductAcquisition.kt */
final class ProductAcquisition$RequestHandler$requestAcquisition$1 extends Lambda implements Function1<Either<? extends Failure, ? extends Acquisition>, Unit> {
    final /* synthetic */ ProductAcquisition.RequestHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductAcquisition$RequestHandler$requestAcquisition$1(ProductAcquisition.RequestHandler requestHandler) {
        super(1);
        this.this$0 = requestHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, Acquisition>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Either<? extends Failure, Acquisition> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        either.fold(new Function1<Failure, Unit>(this.this$0) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((ProductAcquisition.RequestHandler) this.receiver).handleRequestAcquisitionFailure(failure);
            }
        }, new Function1<Acquisition, Unit>(this.this$0) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Acquisition) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Acquisition acquisition) {
                Intrinsics.checkNotNullParameter(acquisition, "p0");
                ((ProductAcquisition.RequestHandler) this.receiver).handleRequestAcquisitionResponse(acquisition);
            }
        });
    }
}
