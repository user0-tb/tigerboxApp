package media.tiger.tigerbox.usecase.tigerboxuserrepo;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.model.domain.TigerBoxAccountDomain;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "", "repository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "(Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;)V", "invoke", "Lmedia/tiger/tigerbox/model/domain/TigerBoxAccountDomain;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetTigerBoxAccountUseCase.kt */
public final class GetTigerBoxAccountUseCase {
    private final TigerBoxAccountRepository repository;

    @Inject
    public GetTigerBoxAccountUseCase(TigerBoxAccountRepository tigerBoxAccountRepository) {
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "repository");
        this.repository = tigerBoxAccountRepository;
    }

    public final TigerBoxAccountDomain invoke() {
        return new TigerBoxAccountDomain(this.repository.getTigerBoxUser(), this.repository.getTigerBoxProfiles());
    }
}
