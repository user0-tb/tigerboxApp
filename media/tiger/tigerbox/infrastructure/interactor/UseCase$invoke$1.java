package media.tiger.tigerbox.infrastructure.interactor;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000\"\u0006\b\u0001\u0010\u0003 \u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0007"}, mo33737d2 = {"<anonymous>", "", "Params", "Type", "it", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: UseCase.kt */
final class UseCase$invoke$1 extends Lambda implements Function1<Either<? extends Failure, ? extends Type>, Unit> {
    public static final UseCase$invoke$1 INSTANCE = new UseCase$invoke$1();

    UseCase$invoke$1() {
        super(1);
    }

    public final void invoke(Either<? extends Failure, ? extends Type> either) {
        Intrinsics.checkNotNullParameter(either, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either) obj);
        return Unit.INSTANCE;
    }
}
