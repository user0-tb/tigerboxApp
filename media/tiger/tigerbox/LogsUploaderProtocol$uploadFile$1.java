package media.tiger.tigerbox;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Ljava/io/File;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LogsUploaderProtocol.kt */
final class LogsUploaderProtocol$uploadFile$1 extends Lambda implements Function1<Either<? extends Failure, ? extends File>, Unit> {
    final /* synthetic */ File $file;
    final /* synthetic */ Function2<Boolean, File, Unit> $finishLambda;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogsUploaderProtocol$uploadFile$1(Function2<? super Boolean, ? super File, Unit> function2, File file) {
        super(1);
        this.$finishLambda = function2;
        this.$file = file;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, ? extends File>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Either<? extends Failure, ? extends File> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        final Function2<Boolean, File, Unit> function2 = this.$finishLambda;
        final File file = this.$file;
        final Function2<Boolean, File, Unit> function22 = this.$finishLambda;
        final File file2 = this.$file;
        either.fold(new Function1<Failure, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                function2.invoke(false, file);
            }
        }, new Function1<File, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((File) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(File file) {
                function22.invoke(true, file2);
            }
        });
    }
}
