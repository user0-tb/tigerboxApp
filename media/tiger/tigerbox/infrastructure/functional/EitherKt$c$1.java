package media.tiger.tigerbox.infrastructure.functional;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo33737d2 = {"<anonymous>", "C", "A", "B", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Either.kt */
final class EitherKt$c$1 extends Lambda implements Function1<A, C> {

    /* renamed from: $f */
    final /* synthetic */ Function1<B, C> f620$f;
    final /* synthetic */ Function1<A, B> $this_c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EitherKt$c$1(Function1<? super B, ? extends C> function1, Function1<? super A, ? extends B> function12) {
        super(1);
        this.f620$f = function1;
        this.$this_c = function12;
    }

    public final C invoke(A a) {
        return this.f620$f.invoke(this.$this_c.invoke(a));
    }
}
