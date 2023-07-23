package media.tiger.tigerbox.p016ui.main.maincontent;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$startPlaybackWithRowProducts$2 */
/* compiled from: ProductContentViewModel.kt */
final class ProductContentViewModel$startPlaybackWithRowProducts$2 extends Lambda implements Function1<ProductAcquisitionService.ErrorCode, Unit> {
    final /* synthetic */ ProductContentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductContentViewModel$startPlaybackWithRowProducts$2(ProductContentViewModel productContentViewModel) {
        super(1);
        this.this$0 = productContentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductAcquisitionService.ErrorCode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisitionService.ErrorCode errorCode) {
        if (errorCode != null) {
            ProductContentViewModel productContentViewModel = this.this$0;
            productContentViewModel.audioPlayerService.stop();
            productContentViewModel._startedAudioProduct.postValue(null);
            new Handler(Looper.getMainLooper()).postDelayed(new C2948x2074cf22(productContentViewModel, errorCode), 250);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2403invoke$lambda1$lambda0(ProductContentViewModel productContentViewModel, ProductAcquisitionService.ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(productContentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(errorCode, "$errorCode");
        productContentViewModel.handleAcquisitionError(errorCode);
    }
}
