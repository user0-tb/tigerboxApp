package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 176)
@DebugMetadata(mo34423c = "kotlinx.coroutines.selects.WhileSelectKt", mo34424f = "WhileSelect.kt", mo34425i = {0}, mo34426l = {37}, mo34427m = "whileSelect", mo34428n = {"builder"}, mo34429s = {"L$0"})
/* compiled from: WhileSelect.kt */
final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    WhileSelectKt$whileSelect$1(Continuation<? super WhileSelectKt$whileSelect$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WhileSelectKt.whileSelect((Function1<? super SelectBuilder<? super Boolean>, Unit>) null, this);
    }
}
