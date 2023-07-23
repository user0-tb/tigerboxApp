package kotlin.streams.jdk8;

import kotlin.sequences.Sequence;
import p009j$.util.function.Supplier;

public final /* synthetic */ class StreamsKt$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ Sequence f$0;

    public /* synthetic */ StreamsKt$$ExternalSyntheticLambda0(Sequence sequence) {
        this.f$0 = sequence;
    }

    public final Object get() {
        return StreamsKt.asStream$lambda$4(this.f$0);
    }
}
