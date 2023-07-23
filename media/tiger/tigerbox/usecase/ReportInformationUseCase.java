package media.tiger.tigerbox.usecase;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.interactor.UseCase;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.domain.ReportInformation;
import media.tiger.tigerbox.model.dto.ReportInformationDto;
import media.tiger.tigerbox.services.interfaces.AdbEnabler;
import media.tiger.tigerbox.services.interfaces.StorageService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J%\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0017\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/ReportInformationUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/UseCase;", "Lmedia/tiger/tigerbox/usecase/ReportInformationRequestBody;", "Lmedia/tiger/tigerbox/model/domain/ReportInformation;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "adbEnabler", "Lmedia/tiger/tigerbox/services/interfaces/AdbEnabler;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/AdbEnabler;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lkotlinx/coroutines/CoroutineDispatcher;)V", "processFeatureFlags", "", "reportInformationDto", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto;", "resetFlags", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Lmedia/tiger/tigerbox/usecase/ReportInformationRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ReportInformationUseCase.kt */
public final class ReportInformationUseCase extends UseCase<ReportInformationRequestBody, ReportInformation> {
    private final AdbEnabler adbEnabler;
    private final ConfigurationProperties configurationProperties;
    private final StorageService storageService;
    private final TigerBoxWebService tigerBoxWebService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ReportInformationUseCase(TigerBoxWebService tigerBoxWebService2, StorageService storageService2, AdbEnabler adbEnabler2, ConfigurationProperties configurationProperties2, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(tigerBoxWebService2, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(adbEnabler2, "adbEnabler");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.tigerBoxWebService = tigerBoxWebService2;
        this.storageService = storageService2;
        this.adbEnabler = adbEnabler2;
        this.configurationProperties = configurationProperties2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(media.tiger.tigerbox.usecase.ReportInformationRequestBody r11, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.domain.ReportInformation>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof media.tiger.tigerbox.usecase.ReportInformationUseCase$run$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            media.tiger.tigerbox.usecase.ReportInformationUseCase$run$1 r0 = (media.tiger.tigerbox.usecase.ReportInformationUseCase$run$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.usecase.ReportInformationUseCase$run$1 r0 = new media.tiger.tigerbox.usecase.ReportInformationUseCase$run$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r11 = r0.L$1
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r11 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r11
            java.lang.Object r0 = r0.L$0
            media.tiger.tigerbox.usecase.ReportInformationUseCase r0 = (media.tiger.tigerbox.usecase.ReportInformationUseCase) r0
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r11
            goto L_0x0052
        L_0x0033:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r12)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r12 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r2 = r10.tigerBoxWebService
            r0.L$0 = r10
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r11 = r2.reportInformation(r11, r0)
            if (r11 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r10
            r2 = r12
            r12 = r11
        L_0x0052:
            r3 = r12
            media.tiger.tigerbox.data.network.ApiResponse r3 = (media.tiger.tigerbox.data.network.ApiResponse) r3
            media.tiger.tigerbox.usecase.ReportInformationUseCase$run$2 r11 = new media.tiger.tigerbox.usecase.ReportInformationUseCase$run$2
            r11.<init>(r0)
            r4 = r11
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            media.tiger.tigerbox.model.domain.ReportInformation r5 = new media.tiger.tigerbox.model.domain.ReportInformation
            r11 = -1
            r5.<init>(r11, r11, r11)
            r6 = 0
            media.tiger.tigerbox.usecase.ReportInformationUseCase$run$3 r11 = new media.tiger.tigerbox.usecase.ReportInformationUseCase$run$3
            r11.<init>(r0)
            r7 = r11
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r8 = 8
            r9 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r11 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r2, r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.ReportInformationUseCase.run(media.tiger.tigerbox.usecase.ReportInformationRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void processFeatureFlags(ReportInformationDto reportInformationDto) {
        resetFlags();
        if (reportInformationDto.getFlags() != null) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50221i("processFeatureFlags: " + reportInformationDto, new Object[0]);
            ReportInformationDto.FeatureSet flags = reportInformationDto.getFlags();
            this.storageService.saveFeatureFlags(flags.getSubmitLogs(), flags.getAutoplay(), flags.getForceCrash(), flags.getManualTicketRedemption(), flags.getAdvancedTimers(), flags.getProfiles(), flags.getPinEntry(), flags.getAutoLogs());
        }
    }

    /* access modifiers changed from: private */
    public final void resetFlags() {
        this.storageService.clearFeatureFlags();
    }
}
