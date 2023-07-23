package p012io.shipbook.shipbooksdk.Appenders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "io.shipbook.shipbooksdk.Appenders.SBCloudAppender", mo34424f = "SBCloudAppender.kt", mo34425i = {0}, mo34426l = {277}, mo34427m = "send", mo34428n = {"this"}, mo34429s = {"L$0"})
/* renamed from: io.shipbook.shipbooksdk.Appenders.SBCloudAppender$send$1 */
/* compiled from: SBCloudAppender.kt */
final class SBCloudAppender$send$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SBCloudAppender this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SBCloudAppender$send$1(SBCloudAppender sBCloudAppender, Continuation<? super SBCloudAppender$send$1> continuation) {
        super(continuation);
        this.this$0 = sBCloudAppender;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send(this);
    }
}
