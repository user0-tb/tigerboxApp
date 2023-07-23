package media.tiger.tigerbox.usecase;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.interactor.RetryUseCase;
import media.tiger.tigerbox.model.dto.PlaybackTrackingEvent;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ'\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u0010\f\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/PostTrackingEventUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/RetryUseCase;", "Lmedia/tiger/tigerbox/usecase/PostTrackingEventParameters;", "Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Lmedia/tiger/tigerbox/usecase/PostTrackingEventParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PostTrackingEventUseCase.kt */
public final class PostTrackingEventUseCase extends RetryUseCase<PostTrackingEventParameters, PlaybackTrackingEvent> {
    private final TigerBoxWebService tigerBoxWebService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public PostTrackingEventUseCase(TigerBoxWebService tigerBoxWebService2, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher, 3);
        Intrinsics.checkNotNullParameter(tigerBoxWebService2, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.tigerBoxWebService = tigerBoxWebService2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(media.tiger.tigerbox.usecase.PostTrackingEventParameters r11, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.dto.PlaybackTrackingEvent>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof media.tiger.tigerbox.usecase.PostTrackingEventUseCase$run$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            media.tiger.tigerbox.usecase.PostTrackingEventUseCase$run$1 r0 = (media.tiger.tigerbox.usecase.PostTrackingEventUseCase$run$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.usecase.PostTrackingEventUseCase$run$1 r0 = new media.tiger.tigerbox.usecase.PostTrackingEventUseCase$run$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r11 = r0.L$1
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r11 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r11
            java.lang.Object r0 = r0.L$0
            media.tiger.tigerbox.usecase.PostTrackingEventParameters r0 = (media.tiger.tigerbox.usecase.PostTrackingEventParameters) r0
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r11
            r11 = r0
            goto L_0x0056
        L_0x0034:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r12)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r12 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r2 = r10.tigerBoxWebService
            media.tiger.tigerbox.model.dto.PlaybackTrackingEvent r4 = r11.getEvent()
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r0 = r2.postTrackingEvent(r4, r0)
            if (r0 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r2 = r12
            r12 = r0
        L_0x0056:
            r3 = r12
            media.tiger.tigerbox.data.network.ApiResponse r3 = (media.tiger.tigerbox.data.network.ApiResponse) r3
            media.tiger.tigerbox.usecase.PostTrackingEventUseCase$run$2 r12 = new media.tiger.tigerbox.usecase.PostTrackingEventUseCase$run$2
            r12.<init>(r11)
            r4 = r12
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 24
            r9 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r11 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r2, r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.PostTrackingEventUseCase.run(media.tiger.tigerbox.usecase.PostTrackingEventParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
