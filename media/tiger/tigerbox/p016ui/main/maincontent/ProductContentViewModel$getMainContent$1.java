package media.tiger.tigerbox.p016ui.main.maincontent;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.ProductRowDomain;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "", "Lmedia/tiger/tigerbox/model/domain/ProductRowDomain;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$getMainContent$1 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$getMainContent$1 extends Lambda implements Function1<Either<? extends Failure, ? extends List<? extends ProductRowDomain>>, Unit> {
    final /* synthetic */ ProductContentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$getMainContent$1(ProductContentViewModel productContentViewModel) {
        super(1);
        this.this$0 = productContentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, ? extends List<ProductRowDomain>>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Either<? extends Failure, ? extends List<ProductRowDomain>> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        final ProductContentViewModel productContentViewModel = this.this$0;
        either.fold(new Function1<Failure, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                Collection value = productContentViewModel.getMainContent().getValue();
                if (value == null || value.isEmpty()) {
                    productContentViewModel.handleFailure(failure);
                }
            }
        }, new Function1<List<? extends ProductRowDomain>, Unit>(this.this$0) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<ProductRowDomain>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<ProductRowDomain> list) {
                Intrinsics.checkNotNullParameter(list, "p0");
                ((ProductContentViewModel) this.receiver).handleMainContentLayout(list);
            }
        });
    }
}
