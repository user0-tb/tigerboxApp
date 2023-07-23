package media.tiger.tigerbox.webserver.controller;

import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: MediaRestController.kt */
final class MediaRestController$startDownload$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ CountDownLatch $countDownLatch;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaRestController$startDownload$1(CountDownLatch countDownLatch) {
        super(1);
        this.$countDownLatch = countDownLatch;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.$countDownLatch.countDown();
    }
}
