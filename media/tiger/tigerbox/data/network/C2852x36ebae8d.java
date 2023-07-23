package media.tiger.tigerbox.data.network;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import okhttp3.Request;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$2 */
/* compiled from: AuthenticationInterceptor.kt */
final class C2852x36ebae8d extends Lambda implements Function1<Failure, Object> {
    final /* synthetic */ Request $request;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2852x36ebae8d(Request request) {
        super(1);
        this.$request = request;
    }

    public final Object invoke(Failure failure) {
        Intrinsics.checkNotNullParameter(failure, "it");
        Timber.Forest forest = Timber.Forest;
        forest.mo50217e("Unable to re-authenticate - was initiated by url: " + this.$request.url() + " failure " + failure, new Object[0]);
        throw new IOException("Unable to re-authenticate - was initiated by url: " + this.$request.url() + " failure " + failure);
    }
}
