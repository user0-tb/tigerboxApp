package media.tiger.tigerbox.p016ui.main.maincontent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.model.domain.ProductRowDomain;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.main.maincontent.GetProductListRequest", mo34424f = "GetProductListRequest.kt", mo34425i = {0, 0}, mo34426l = {32}, mo34427m = "requestProductList", mo34428n = {"this", "mainContentList"}, mo34429s = {"L$0", "L$1"})
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.GetProductListRequest$requestProductList$1 */
/* compiled from: GetProductListRequest.kt */
final class GetProductListRequest$requestProductList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetProductListRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetProductListRequest$requestProductList$1(GetProductListRequest getProductListRequest, Continuation<? super GetProductListRequest$requestProductList$1> continuation) {
        super(continuation);
        this.this$0 = getProductListRequest;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.requestProductList((ProductRowDomain) null, (String) null, this);
    }
}
