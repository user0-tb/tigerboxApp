package media.tiger.tigerbox.p016ui.main.maincontent;

import media.tiger.tigerbox.model.domain.ProductRowDomain;
import p009j$.util.function.Predicate;

/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$$ExternalSyntheticLambda0 */
public final /* synthetic */ class ProductContentViewModel$$ExternalSyntheticLambda0 implements Predicate {
    public static final /* synthetic */ ProductContentViewModel$$ExternalSyntheticLambda0 INSTANCE = new ProductContentViewModel$$ExternalSyntheticLambda0();

    private /* synthetic */ ProductContentViewModel$$ExternalSyntheticLambda0() {
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    /* renamed from: or */
    public /* synthetic */ Predicate mo6806or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return ProductContentViewModel.m2400updateOfflineContent$lambda4$lambda3((ProductRowDomain) obj);
    }
}
