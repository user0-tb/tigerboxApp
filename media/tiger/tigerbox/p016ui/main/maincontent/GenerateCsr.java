package media.tiger.tigerbox.p016ui.main.maincontent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.RequestPemCertificateUseCase;
import media.tiger.tigerbox.webserver.WebServer;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/GenerateCsr;", "", "requestPemCertificateUseCase", "Lmedia/tiger/tigerbox/usecase/RequestPemCertificateUseCase;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "webServer", "Lmedia/tiger/tigerbox/webserver/WebServer;", "(Lmedia/tiger/tigerbox/usecase/RequestPemCertificateUseCase;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/webserver/WebServer;)V", "invoke", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "failureHandler", "Lkotlin/Function1;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.GenerateCsr */
/* compiled from: GenerateCsr.kt */
public final class GenerateCsr {
    /* access modifiers changed from: private */
    public final MetaDataService metaDataService;
    /* access modifiers changed from: private */
    public final RequestPemCertificateUseCase requestPemCertificateUseCase;
    /* access modifiers changed from: private */
    public final StorageService storageService;
    /* access modifiers changed from: private */
    public final WebServer webServer;

    public GenerateCsr(RequestPemCertificateUseCase requestPemCertificateUseCase2, StorageService storageService2, MetaDataService metaDataService2, WebServer webServer2) {
        Intrinsics.checkNotNullParameter(requestPemCertificateUseCase2, "requestPemCertificateUseCase");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(webServer2, "webServer");
        this.requestPemCertificateUseCase = requestPemCertificateUseCase2;
        this.storageService = storageService2;
        this.metaDataService = metaDataService2;
        this.webServer = webServer2;
    }

    public final void invoke(CoroutineScope coroutineScope, Function1<? super Failure, Unit> function1) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function1, "failureHandler");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new GenerateCsr$invoke$1(this, function1, (Continuation<? super GenerateCsr$invoke$1>) null), 2, (Object) null);
    }
}
