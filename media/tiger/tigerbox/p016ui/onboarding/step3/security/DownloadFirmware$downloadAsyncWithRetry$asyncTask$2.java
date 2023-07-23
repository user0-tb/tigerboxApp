package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$downloadAsyncWithRetry$asyncTask$2 */
/* compiled from: DownloadFirmware.kt */
final class DownloadFirmware$downloadAsyncWithRetry$asyncTask$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<LargeDownloadHandler.Result, Unit> $onComplete;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DownloadFirmware$downloadAsyncWithRetry$asyncTask$2(Function1<? super LargeDownloadHandler.Result, Unit> function1) {
        super(0);
        this.$onComplete = function1;
    }

    public final void invoke() {
        this.$onComplete.invoke(LargeDownloadHandler.Result.Complete.INSTANCE);
    }
}
