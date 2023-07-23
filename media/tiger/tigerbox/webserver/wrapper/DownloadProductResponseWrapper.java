package media.tiger.tigerbox.webserver.wrapper;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p011fi.iki.elonen.NanoHTTPD;

@Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/wrapper/DownloadProductResponseWrapper;", "", "downloadResponse", "Lkotlin/Function0;", "Lfi/iki/elonen/NanoHTTPD$Response;", "(Lkotlin/jvm/functions/Function0;)V", "getDownloadResponse", "()Lkotlin/jvm/functions/Function0;", "setDownloadResponse", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadProductResponseWrapper.kt */
public final class DownloadProductResponseWrapper {
    private Function0<? extends NanoHTTPD.Response> downloadResponse;

    public static /* synthetic */ DownloadProductResponseWrapper copy$default(DownloadProductResponseWrapper downloadProductResponseWrapper, Function0<? extends NanoHTTPD.Response> function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = downloadProductResponseWrapper.downloadResponse;
        }
        return downloadProductResponseWrapper.copy(function0);
    }

    public final Function0<NanoHTTPD.Response> component1() {
        return this.downloadResponse;
    }

    public final DownloadProductResponseWrapper copy(Function0<? extends NanoHTTPD.Response> function0) {
        Intrinsics.checkNotNullParameter(function0, "downloadResponse");
        return new DownloadProductResponseWrapper(function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DownloadProductResponseWrapper) && Intrinsics.areEqual((Object) this.downloadResponse, (Object) ((DownloadProductResponseWrapper) obj).downloadResponse);
    }

    public int hashCode() {
        return this.downloadResponse.hashCode();
    }

    public String toString() {
        return "DownloadProductResponseWrapper(downloadResponse=" + this.downloadResponse + ')';
    }

    public DownloadProductResponseWrapper(Function0<? extends NanoHTTPD.Response> function0) {
        Intrinsics.checkNotNullParameter(function0, "downloadResponse");
        this.downloadResponse = function0;
    }

    public final Function0<NanoHTTPD.Response> getDownloadResponse() {
        return this.downloadResponse;
    }

    public final void setDownloadResponse(Function0<? extends NanoHTTPD.Response> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.downloadResponse = function0;
    }
}
