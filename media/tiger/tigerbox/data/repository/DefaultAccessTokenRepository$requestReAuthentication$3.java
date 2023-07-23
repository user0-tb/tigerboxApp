package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;
import media.tiger.tigerbox.model.dto.AccessTokenDto;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "returnedToken", "Lmedia/tiger/tigerbox/model/dto/AccessTokenDto;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AccessTokenRepository.kt */
final class DefaultAccessTokenRepository$requestReAuthentication$3 extends Lambda implements Function1<AccessTokenDto, AccessTokenDomain> {
    final /* synthetic */ DefaultAccessTokenRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultAccessTokenRepository$requestReAuthentication$3(DefaultAccessTokenRepository defaultAccessTokenRepository) {
        super(1);
        this.this$0 = defaultAccessTokenRepository;
    }

    public final AccessTokenDomain invoke(AccessTokenDto accessTokenDto) {
        Intrinsics.checkNotNullParameter(accessTokenDto, "returnedToken");
        AccessTokenDomain accessTokenDomain = new AccessTokenDomain(accessTokenDto.getAccess_token(), accessTokenDto.getRefresh_token(), 0, 4, (DefaultConstructorMarker) null);
        this.this$0.updateTokens(accessTokenDomain);
        return accessTokenDomain;
    }
}
