package media.tiger.tigerbox.usecase.accesstokenrepo;

import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;

@Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/accesstokenrepo/GetAccessTokenUseCase;", "", "repository", "Ljavax/inject/Provider;", "Lmedia/tiger/tigerbox/data/repository/AccessTokenRepository;", "(Ljavax/inject/Provider;)V", "invoke", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetAccessTokenUseCase.kt */
public final class GetAccessTokenUseCase {
    private final Provider<AccessTokenRepository> repository;

    @Inject
    public GetAccessTokenUseCase(Provider<AccessTokenRepository> provider) {
        Intrinsics.checkNotNullParameter(provider, "repository");
        this.repository = provider;
    }

    public final AccessTokenDomain invoke() {
        return this.repository.get().getTokens();
    }
}
