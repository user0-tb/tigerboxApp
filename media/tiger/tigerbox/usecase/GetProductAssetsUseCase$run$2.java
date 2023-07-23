package media.tiger.tigerbox.usecase;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.AssetProduct;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "Lmedia/tiger/tigerbox/model/dto/AssetProduct;", "assetsList", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetProductAssetsUseCase.kt */
final class GetProductAssetsUseCase$run$2 extends Lambda implements Function1<List<? extends AssetProduct>, List<? extends AssetProduct>> {
    public static final GetProductAssetsUseCase$run$2 INSTANCE = new GetProductAssetsUseCase$run$2();

    GetProductAssetsUseCase$run$2() {
        super(1);
    }

    public final List<AssetProduct> invoke(List<AssetProduct> list) {
        Intrinsics.checkNotNullParameter(list, "assetsList");
        return list;
    }
}
