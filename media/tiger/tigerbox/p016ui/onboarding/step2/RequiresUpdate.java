package media.tiger.tigerbox.p016ui.onboarding.step2;

import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.domain.LatestRelease;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.utils.DateUtilsKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step2/RequiresUpdate;", "", "storageProvider", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "invoke", "", "latestRelease", "Lmedia/tiger/tigerbox/model/domain/LatestRelease;", "logInfo", "", "text", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.RequiresUpdate */
/* compiled from: RequiresUpdate.kt */
public final class RequiresUpdate {
    private final ConfigurationProperties configurationProperties;
    private final StorageService storageProvider;

    @Inject
    public RequiresUpdate(StorageService storageService, ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(storageService, "storageProvider");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        this.storageProvider = storageService;
        this.configurationProperties = configurationProperties2;
    }

    public final boolean invoke(LatestRelease latestRelease) {
        String str;
        Intrinsics.checkNotNullParameter(latestRelease, "latestRelease");
        if (Intrinsics.areEqual((Object) latestRelease.getVersionName(), (Object) this.configurationProperties.getProperty("software.version.code"))) {
            logInfo("Not updating due to version code match [" + this.configurationProperties.getProperty("software.version.code") + ']');
            return false;
        }
        Date date$default = DateUtilsKt.toDate$default(this.configurationProperties.getProperty("software.version.date"), (String) null, 1, (Object) null);
        Date updateDate = this.storageProvider.getUpdateDate();
        if (updateDate.after(date$default)) {
            logInfo("Most recent date is from memory: [" + this.storageProvider.getUpdateDate().getTime() + ']');
            date$default = updateDate;
        } else {
            logInfo("Most recent date is from properties: [" + this.configurationProperties.getProperty("software.version.date") + ']');
        }
        boolean after = latestRelease.getReleaseDate().after(date$default);
        if (after) {
            str = "Will update. LatestRelease: [" + latestRelease.getReleaseDate().getTime() + "] is after [" + date$default.getTime() + ']';
        } else {
            str = "Not updating. LatestRelease: [" + latestRelease.getReleaseDate().getTime() + "] is NOT after [" + date$default.getTime() + ']';
        }
        logInfo(str);
        return after;
    }

    private final void logInfo(String str) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50214d("RequiresUpdate " + str, new Object[0]);
    }
}
