package media.tiger.tigerbox.data.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/NoAuthenticationParamsException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AuthenticationInterceptor.kt */
public final class NoAuthenticationParamsException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoAuthenticationParamsException(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
