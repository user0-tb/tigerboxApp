package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.LatestRelease;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.model.dto.ReleaseInformationKt;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/LatestRelease;", "releaseInformation", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: CheckForUpdateUseCase.kt */
final class CheckForUpdateUseCase$run$2 extends Lambda implements Function1<ReleaseInformation, LatestRelease> {
    final /* synthetic */ CheckForUpdateUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckForUpdateUseCase$run$2(CheckForUpdateUseCase checkForUpdateUseCase) {
        super(1);
        this.this$0 = checkForUpdateUseCase;
    }

    public final LatestRelease invoke(ReleaseInformation releaseInformation) {
        Intrinsics.checkNotNullParameter(releaseInformation, "releaseInformation");
        if (releaseInformation.getReleases().isEmpty()) {
            return this.this$0.defaultRelease;
        }
        ReleaseInformation.Release latest = ReleaseInformationKt.getLatest(releaseInformation);
        if (latest != null) {
            return new LatestRelease(latest.getVersion(), latest.getReleased());
        }
        return this.this$0.defaultRelease;
    }
}
