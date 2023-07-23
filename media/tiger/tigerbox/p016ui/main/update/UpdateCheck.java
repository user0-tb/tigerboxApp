package media.tiger.tigerbox.p016ui.main.update;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.ReportInformationRequestBody;
import media.tiger.tigerbox.usecase.ReportInformationUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\u0011\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/update/UpdateCheck;", "", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "reportSuccessfulUpdate", "Lmedia/tiger/tigerbox/usecase/ReportInformationUseCase;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/usecase/ReportInformationUseCase;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "clearUpdateValue", "", "invoke", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.update.UpdateCheck */
/* compiled from: UpdateCheck.kt */
public final class UpdateCheck {
    private final ConfigurationProperties configurationProperties;
    private final MetaDataService metaDataService;
    private final ReportInformationUseCase reportSuccessfulUpdate;
    private final StorageService storageService;

    public UpdateCheck(StorageService storageService2, MetaDataService metaDataService2, ReportInformationUseCase reportInformationUseCase, ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(reportInformationUseCase, "reportSuccessfulUpdate");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        this.storageService = storageService2;
        this.metaDataService = metaDataService2;
        this.reportSuccessfulUpdate = reportInformationUseCase;
        this.configurationProperties = configurationProperties2;
    }

    public final void invoke(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        if (Intrinsics.areEqual((Object) this.storageService.getAttemptedUpdateVersion(), (Object) this.configurationProperties.getProperty("software.version.code"))) {
            this.reportSuccessfulUpdate.invoke(new ReportInformationRequestBody(this.metaDataService.getCpuId(), this.metaDataService.getSerialNumber(), this.storageService.getAttemptedUpdateVersion(), this.metaDataService.getIpAddress()), coroutineScope, new UpdateCheck$invoke$1(this));
            return;
        }
        Timber.Forest.mo50214d("UpdateCheck: Update was not successful", new Object[0]);
        this.storageService.setUpdateDate(new Date(0));
    }

    /* access modifiers changed from: private */
    public final void clearUpdateValue() {
        this.storageService.setAttemptedUpdateVersion("");
    }
}
