package media.tiger.tigerbox.webserver.controller;

import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.webserver.responses.ResponseFactory;
import p011fi.iki.elonen.NanoHTTPD;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "step", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$StepType;", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: MediaRestController.kt */
final class MediaRestController$startDownload$2 extends Lambda implements Function2<ProductAcquisitionService.StepType, ProductAcquisitionService.ErrorCode, Unit> {
    final /* synthetic */ CountDownLatch $countDownLatch;
    final /* synthetic */ int $id;
    final /* synthetic */ Ref.ObjectRef<NanoHTTPD.Response> $response;
    final /* synthetic */ NanoHTTPD.IHTTPSession $session;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: MediaRestController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductAcquisitionService.ErrorCode.values().length];
            iArr[ProductAcquisitionService.ErrorCode.ACQUISITION_ERROR_410.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaRestController$startDownload$2(Ref.ObjectRef<NanoHTTPD.Response> objectRef, int i, NanoHTTPD.IHTTPSession iHTTPSession, CountDownLatch countDownLatch) {
        super(2);
        this.$response = objectRef;
        this.$id = i;
        this.$session = iHTTPSession;
        this.$countDownLatch = countDownLatch;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ProductAcquisitionService.StepType) obj, (ProductAcquisitionService.ErrorCode) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisitionService.StepType stepType, ProductAcquisitionService.ErrorCode errorCode) {
        T t;
        Intrinsics.checkNotNullParameter(stepType, "step");
        Ref.ObjectRef<NanoHTTPD.Response> objectRef = this.$response;
        if ((errorCode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[errorCode.ordinal()]) == 1) {
            String uri = this.$session.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "session.uri");
            t = ResponseFactory.Companion.notAllowedResponse("Product [" + this.$id + "] not found or subscription is invalid", uri);
        } else {
            t = ResponseFactory.Companion.createdResponse();
        }
        objectRef.element = t;
        if (stepType == ProductAcquisitionService.StepType.ACQUISITION_FINISHED) {
            this.$countDownLatch.countDown();
        }
    }
}
