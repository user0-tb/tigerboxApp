package media.tiger.tigerbox.webserver.controller;

import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.webserver.dto.TonesPlaybackDto;
import media.tiger.tigerbox.webserver.responses.ResponseFactory;
import p011fi.iki.elonen.NanoHTTPD;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: MediaRestController.kt */
final class MediaRestController$startPlayback$1 extends Lambda implements Function1<ProductAcquisitionService.ErrorCode, Unit> {
    final /* synthetic */ CountDownLatch $countDownLatch;
    final /* synthetic */ Ref.ObjectRef<NanoHTTPD.Response> $response;
    final /* synthetic */ NanoHTTPD.IHTTPSession $session;
    final /* synthetic */ Ref.ObjectRef<TonesPlaybackDto> $tonesPlayback;
    final /* synthetic */ MediaRestController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaRestController$startPlayback$1(MediaRestController mediaRestController, Ref.ObjectRef<NanoHTTPD.Response> objectRef, Ref.ObjectRef<TonesPlaybackDto> objectRef2, NanoHTTPD.IHTTPSession iHTTPSession, CountDownLatch countDownLatch) {
        super(1);
        this.this$0 = mediaRestController;
        this.$response = objectRef;
        this.$tonesPlayback = objectRef2;
        this.$session = iHTTPSession;
        this.$countDownLatch = countDownLatch;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductAcquisitionService.ErrorCode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisitionService.ErrorCode errorCode) {
        if (errorCode != null) {
            try {
                this.this$0.audioPlayerService.stop();
            } catch (Exception e) {
                Timber.Forest.tag("Webserver").mo50217e("Failed to stop audio: " + e.getMessage(), new Object[0]);
            }
        }
        if (errorCode == ProductAcquisitionService.ErrorCode.ACQUISITION_ERROR_410) {
            String uri = this.$session.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "session.uri");
            this.$response.element = ResponseFactory.Companion.notAllowedResponse("Product [" + ((TonesPlaybackDto) this.$tonesPlayback.element).getProductId() + "] not found or subscription is invalid", uri);
        }
        this.$countDownLatch.countDown();
    }
}
