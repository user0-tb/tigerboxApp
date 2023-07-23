package media.tiger.tigerbox.p016ui.main.maincontent;

import java.security.KeyPair;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.exception.GeneratingCertificateFailure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.PemResponse;
import media.tiger.tigerbox.usecase.RequestPemCertificateUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.main.maincontent.GenerateCsr$invoke$1", mo34424f = "GenerateCsr.kt", mo34425i = {}, mo34426l = {34}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.GenerateCsr$invoke$1 */
/* compiled from: GenerateCsr.kt */
final class GenerateCsr$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Failure, Unit> $failureHandler;
    int label;
    final /* synthetic */ GenerateCsr this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenerateCsr$invoke$1(GenerateCsr generateCsr, Function1<? super Failure, Unit> function1, Continuation<? super GenerateCsr$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = generateCsr;
        this.$failureHandler = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GenerateCsr$invoke$1(this.this$0, this.$failureHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GenerateCsr$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest.mo50221i("GenerateCsr invoke", new Object[0]);
            KeyPair generateCertificateKeyPair = this.this$0.storageService.generateCertificateKeyPair();
            if (this.this$0.storageService.loadCertificate(generateCertificateKeyPair)) {
                Timber.Forest.mo50221i("GenerateCsr finished (existing)", new Object[0]);
                this.this$0.webServer.startServer();
                return Unit.INSTANCE;
            }
            this.label = 1;
            obj = this.this$0.requestPemCertificateUseCase.invoke(new RequestPemCertificateUseCase.RequestPemCertificateParams(generateCertificateKeyPair, this.this$0.metaDataService.getCpuId(), this.this$0.metaDataService.getSerialNumber()), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final Function1<Failure, Unit> function1 = this.$failureHandler;
        final GenerateCsr generateCsr = this.this$0;
        final Function1<Failure, Unit> function12 = this.$failureHandler;
        final GenerateCsr generateCsr2 = this.this$0;
        ((Either) obj).fold(new Function1<Failure, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "it");
                Timber.Forest forest = Timber.Forest;
                forest.mo50221i("GenerateCsr failed " + failure, new Object[0]);
                function1.invoke(failure);
                generateCsr.webServer.startServer();
            }
        }, new Function1<PemResponse, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PemResponse) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PemResponse pemResponse) {
                Intrinsics.checkNotNullParameter(pemResponse, "pemResponse");
                Timber.Forest.mo50221i("GenerateCsr finished", new Object[0]);
                if (!(pemResponse instanceof PemResponse.CertificateData)) {
                    function12.invoke(GeneratingCertificateFailure.PemRequestFailure.INSTANCE);
                } else {
                    generateCsr2.storageService.saveCertificateData((PemResponse.CertificateData) pemResponse);
                }
                generateCsr2.webServer.startServer();
            }
        });
        return Unit.INSTANCE;
    }
}
