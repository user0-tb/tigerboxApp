package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackPosition.kt */
final class PlaybackPosition$sendStateToServer$1 extends Lambda implements Function1<Either<? extends Failure, ? extends Unit>, Unit> {
    final /* synthetic */ PlaybackPosition this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaybackPosition$sendStateToServer$1(PlaybackPosition playbackPosition) {
        super(1);
        this.this$0 = playbackPosition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, Unit>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Either<? extends Failure, Unit> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        either.fold(new Function1<Failure, Unit>(this.this$0) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((PlaybackPosition) this.receiver).handleUpdatePostStateReqFailure(failure);
            }
        }, new Function1<Unit, Unit>(this.this$0) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Unit) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Unit unit) {
                ((PlaybackPosition) this.receiver).handleUpdatePostStateReqSuccess(unit);
            }
        });
    }
}
