package media.tiger.tigerbox.p016ui.main.maincontent;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.model.domain.ProductRowDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$fetchNextLinkProductListData$1", mo34424f = "ProductContentViewModel.kt", mo34425i = {0, 0, 0, 1, 1, 1}, mo34426l = {599, 600}, mo34427m = "invokeSuspend", mo34428n = {"nextLink", "repeatCounter", "tempHeaderResponseLink", "nextLink", "repeatCounter", "tempHeaderResponseLink"}, mo34429s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$fetchNextLinkProductListData$1 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$fetchNextLinkProductListData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProductRowDomain $clickedRow;
    final /* synthetic */ List<ProductDomain> $mergedResponsesList;
    final /* synthetic */ Function1<List<ProductDomain>, Unit> $onDone;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ProductContentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$fetchNextLinkProductListData$1(ProductRowDomain productRowDomain, ProductContentViewModel productContentViewModel, Function1<? super List<ProductDomain>, Unit> function1, List<ProductDomain> list, Continuation<? super ProductContentViewModel$fetchNextLinkProductListData$1> continuation) {
        super(2, continuation);
        this.$clickedRow = productRowDomain;
        this.this$0 = productContentViewModel;
        this.$onDone = function1;
        this.$mergedResponsesList = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductContentViewModel$fetchNextLinkProductListData$1(this.$clickedRow, this.this$0, this.$onDone, this.$mergedResponsesList, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProductContentViewModel$fetchNextLinkProductListData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r3) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r1 = r12.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r12.L$1
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r12.L$0
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r12
            r10 = r4
            r4 = r1
            r1 = r10
            goto L_0x00a8
        L_0x0023:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x002b:
            java.lang.Object r1 = r12.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r12.L$1
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r12.L$0
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r5
            r5 = r12
            goto L_0x0083
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            media.tiger.tigerbox.model.domain.ProductRowDomain r4 = r12.$clickedRow
            java.lang.String r4 = r4.getHeaderResponseLink()
            r5 = r12
        L_0x0051:
            media.tiger.tigerbox.model.domain.ProductRowDomain r6 = r5.$clickedRow
            java.lang.String r6 = r6.getNextLink()
            r13.element = r6
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            r7 = 0
            if (r6 <= 0) goto L_0x0064
            r6 = 1
            goto L_0x0065
        L_0x0064:
            r6 = 0
        L_0x0065:
            if (r6 == 0) goto L_0x00c4
            r6 = 3000(0xbb8, double:1.482E-320)
            int r8 = r1.element
            long r8 = (long) r8
            long r8 = r8 * r6
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.L$0 = r13
            r5.L$1 = r1
            r5.L$2 = r4
            r5.label = r3
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r8, r6)
            if (r6 != r0) goto L_0x0080
            return r0
        L_0x0080:
            r10 = r4
            r4 = r1
            r1 = r10
        L_0x0083:
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel r6 = r5.this$0
            media.tiger.tigerbox.ui.main.maincontent.GetProductListRequest r6 = r6.getProductListRequest
            media.tiger.tigerbox.model.domain.ProductRowDomain r7 = r5.$clickedRow
            T r8 = r13.element
            java.lang.String r8 = (java.lang.String) r8
            r9 = r5
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r5.L$0 = r13
            r5.L$1 = r4
            r5.L$2 = r1
            r5.label = r2
            java.lang.Object r6 = r6.invoke(r7, r8, r9)
            if (r6 != r0) goto L_0x00a1
            return r0
        L_0x00a1:
            r10 = r5
            r5 = r13
            r13 = r6
            r6 = r10
            r11 = r4
            r4 = r1
            r1 = r11
        L_0x00a8:
            media.tiger.tigerbox.infrastructure.functional.Either r13 = (media.tiger.tigerbox.infrastructure.functional.Either) r13
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$fetchNextLinkProductListData$1$2 r7 = new media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$fetchNextLinkProductListData$1$2
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel r8 = r6.this$0
            media.tiger.tigerbox.model.domain.ProductRowDomain r9 = r6.$clickedRow
            r7.<init>(r1, r8, r9)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$fetchNextLinkProductListData$1$3 r8 = new media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$fetchNextLinkProductListData$1$3
            java.util.List<media.tiger.tigerbox.model.domain.ProductDomain> r9 = r6.$mergedResponsesList
            r8.<init>(r1, r9)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r13.fold(r7, r8)
            r13 = r5
            r5 = r6
            goto L_0x0051
        L_0x00c4:
            media.tiger.tigerbox.model.domain.ProductRowDomain r13 = r5.$clickedRow
            r13.setHeaderResponseLink(r4)
            kotlin.jvm.functions.Function1<java.util.List<media.tiger.tigerbox.model.domain.ProductDomain>, kotlin.Unit> r13 = r5.$onDone
            if (r13 == 0) goto L_0x00d2
            java.util.List<media.tiger.tigerbox.model.domain.ProductDomain> r0 = r5.$mergedResponsesList
            r13.invoke(r0)
        L_0x00d2:
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel r13 = r5.this$0
            media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent r13 = r13._loadingListInProgress
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            r13.setValue(r0)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.maincontent.ProductContentViewModel$fetchNextLinkProductListData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
