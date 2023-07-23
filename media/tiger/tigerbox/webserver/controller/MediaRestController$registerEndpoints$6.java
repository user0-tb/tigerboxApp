package media.tiger.tigerbox.webserver.controller;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p011fi.iki.elonen.NanoHTTPD;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "Lfi/iki/elonen/NanoHTTPD$Response;", "it", "Lfi/iki/elonen/NanoHTTPD$IHTTPSession;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: MediaRestController.kt */
final class MediaRestController$registerEndpoints$6 extends Lambda implements Function1<NanoHTTPD.IHTTPSession, NanoHTTPD.Response> {
    final /* synthetic */ MediaRestController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaRestController$registerEndpoints$6(MediaRestController mediaRestController) {
        super(1);
        this.this$0 = mediaRestController;
    }

    public final NanoHTTPD.Response invoke(NanoHTTPD.IHTTPSession iHTTPSession) {
        Intrinsics.checkNotNullParameter(iHTTPSession, "it");
        return this.this$0.deleteOfflineContent(iHTTPSession);
    }
}
