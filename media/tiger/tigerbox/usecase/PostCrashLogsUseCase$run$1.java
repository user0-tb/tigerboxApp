package media.tiger.tigerbox.usecase;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.usecase.PostCrashLogsUseCase", mo34424f = "PostCrashLogsUseCase.kt", mo34425i = {0}, mo34426l = {23}, mo34427m = "run", mo34428n = {"params"}, mo34429s = {"L$0"})
/* compiled from: PostCrashLogsUseCase.kt */
final class PostCrashLogsUseCase$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PostCrashLogsUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostCrashLogsUseCase$run$1(PostCrashLogsUseCase postCrashLogsUseCase, Continuation<? super PostCrashLogsUseCase$run$1> continuation) {
        super(continuation);
        this.this$0 = postCrashLogsUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((CrashLogsUseCaseParameters) null, (Continuation<? super Either<? extends Failure, ? extends File>>) this);
    }
}
