package media.tiger.tigerbox.infrastructure.functional;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Either.kt */
/* synthetic */ class EitherKt$map$1 extends FunctionReferenceImpl implements Function1<T, Either.Right<? extends T>> {
    EitherKt$map$1(Object obj) {
        super(1, obj, Either.class, TtmlNode.RIGHT, "right(Ljava/lang/Object;)Lmedia/tiger/tigerbox/infrastructure/functional/Either$Right;", 0);
    }

    public final Either.Right<T> invoke(T t) {
        return ((Either) this.receiver).right(t);
    }
}
