package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PostPlayStateUseCase.kt */
final class PostPlayStateUseCase$run$2 extends Lambda implements Function1<Unit, Unit> {
    public static final PostPlayStateUseCase$run$2 INSTANCE = new PostPlayStateUseCase$run$2();

    PostPlayStateUseCase$run$2() {
        super(1);
    }

    public final void invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Unit) obj);
        return Unit.INSTANCE;
    }
}
