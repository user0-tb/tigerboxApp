package media.tiger.tigerbox.usecase;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.dto.AssetProduct;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.usecase.GetProductAssetsUseCase", mo34424f = "GetProductAssetsUseCase.kt", mo34425i = {}, mo34426l = {21}, mo34427m = "run", mo34428n = {}, mo34429s = {})
/* compiled from: GetProductAssetsUseCase.kt */
final class GetProductAssetsUseCase$run$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetProductAssetsUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetProductAssetsUseCase$run$1(GetProductAssetsUseCase getProductAssetsUseCase, Continuation<? super GetProductAssetsUseCase$run$1> continuation) {
        super(continuation);
        this.this$0 = getProductAssetsUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((GetProductAssetsParameters) null, (Continuation<? super Either<? extends Failure, ? extends List<AssetProduct>>>) this);
    }
}
