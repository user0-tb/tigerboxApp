package media.tiger.tigerbox.p016ui.main.maincontent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import media.tiger.tigerbox.model.domain.ProductRowDomain;
import media.tiger.tigerbox.model.domain.ProductRowType;
import media.tiger.tigerbox.services.interfaces.StorageService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$handleMainContentLayout$1", mo34424f = "ProductContentViewModel.kt", mo34425i = {}, mo34426l = {388}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$handleMainContentLayout$1 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$handleMainContentLayout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ProductRowDomain> $listOfProductRows;
    final /* synthetic */ List<ProductRowDomain> $newList;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProductContentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$handleMainContentLayout$1(List<ProductRowDomain> list, List<ProductRowDomain> list2, ProductContentViewModel productContentViewModel, Continuation<? super ProductContentViewModel$handleMainContentLayout$1> continuation) {
        super(2, continuation);
        this.$listOfProductRows = list;
        this.$newList = list2;
        this.this$0 = productContentViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProductContentViewModel$handleMainContentLayout$1 productContentViewModel$handleMainContentLayout$1 = new ProductContentViewModel$handleMainContentLayout$1(this.$listOfProductRows, this.$newList, this.this$0, continuation);
        productContentViewModel$handleMainContentLayout$1.L$0 = obj;
        return productContentViewModel$handleMainContentLayout$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProductContentViewModel$handleMainContentLayout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List<ProductRowDomain> list;
        ProductContentViewModel productContentViewModel;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            List arrayList = new ArrayList();
            ProductContentViewModel productContentViewModel2 = this.this$0;
            List<ProductRowDomain> list2 = this.$newList;
            int i2 = 0;
            for (Object next : this.$listOfProductRows) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ProductRowDomain productRowDomain = (ProductRowDomain) next;
                if (productRowDomain.isOfflineRowType()) {
                    productContentViewModel2.offlineRowPosition = i2;
                    productContentViewModel2.offlineRow = productRowDomain;
                    StorageService access$getStorageService$p = productContentViewModel2.storageService;
                    ProductRowDomain access$getOfflineRow$p = productContentViewModel2.offlineRow;
                    if (access$getOfflineRow$p == null || (str = access$getOfflineRow$p.getTitle()) == null) {
                        str = "";
                    }
                    access$getStorageService$p.setOfflineRowTitle(str);
                }
                if (productRowDomain.getLayoutItemType() != ProductRowType.BANNER) {
                    list = list2;
                    productContentViewModel = productContentViewModel2;
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProductContentViewModel$handleMainContentLayout$1$1$1(productContentViewModel2, productRowDomain, i2, list2, (Continuation<? super ProductContentViewModel$handleMainContentLayout$1$1$1>) null), 3, (Object) null));
                } else {
                    list = list2;
                    productContentViewModel = productContentViewModel2;
                }
                productContentViewModel2 = productContentViewModel;
                list2 = list;
                i2 = i3;
            }
            this.label = 1;
            if (AwaitKt.awaitAll(arrayList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("ProductContentViewModel handleMainContentLayout exception " + e, new Object[0]);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ProductContentViewModel productContentViewModel3 = this.this$0;
        Collection arrayList2 = new ArrayList();
        for (Object next2 : this.$newList) {
            if (productContentViewModel3.isNotBannerOrBannerWithContent((ProductRowDomain) next2)) {
                arrayList2.add(next2);
            }
        }
        this.this$0.updateProductAvailableStatus((List) arrayList2);
        return Unit.INSTANCE;
    }
}
