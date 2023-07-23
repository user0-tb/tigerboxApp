package media.tiger.tigerbox.infrastructure.interactor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn", mo34424f = "UseCaseWithReturn.kt", mo34425i = {}, mo34426l = {17}, mo34427m = "invoke", mo34428n = {}, mo34429s = {})
/* compiled from: UseCaseWithReturn.kt */
final class UseCaseWithReturn$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UseCaseWithReturn<Params, Type> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UseCaseWithReturn$invoke$1(UseCaseWithReturn<? super Params, ? extends Type> useCaseWithReturn, Continuation<? super UseCaseWithReturn$invoke$1> continuation) {
        super(continuation);
        this.this$0 = useCaseWithReturn;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
