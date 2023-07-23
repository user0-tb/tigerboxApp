package media.tiger.tigerbox.data.network;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;
import okhttp3.Request;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$3 */
/* compiled from: AuthenticationInterceptor.kt */
final class C2853x36ebae8e extends Lambda implements Function1<AccessTokenDomain, Object> {
    final /* synthetic */ Request $request;
    final /* synthetic */ AuthenticationInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2853x36ebae8e(Request request, AuthenticationInterceptor authenticationInterceptor) {
        super(1);
        this.$request = request;
        this.this$0 = authenticationInterceptor;
    }

    public final Object invoke(AccessTokenDomain accessTokenDomain) {
        Intrinsics.checkNotNullParameter(accessTokenDomain, "it");
        Timber.Tree tag = Timber.Forest.tag("AuthenticationInterceptor");
        tag.mo50214d("Refresh token succeeded. New access token: " + accessTokenDomain.getAccessToken() + ". Was initiated by url: " + this.$request.url(), new Object[0]);
        return this.this$0.updateRequestAuthorizationToken(this.$request);
    }
}
