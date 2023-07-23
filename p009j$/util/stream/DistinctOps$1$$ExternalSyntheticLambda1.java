package p009j$.util.stream;

import java.util.LinkedHashSet;
import p009j$.util.function.BiConsumer;

/* renamed from: j$.util.stream.DistinctOps$1$$ExternalSyntheticLambda1 */
public final /* synthetic */ class DistinctOps$1$$ExternalSyntheticLambda1 implements BiConsumer {
    public static final /* synthetic */ DistinctOps$1$$ExternalSyntheticLambda1 INSTANCE = new DistinctOps$1$$ExternalSyntheticLambda1();

    private /* synthetic */ DistinctOps$1$$ExternalSyntheticLambda1() {
    }

    public final void accept(Object obj, Object obj2) {
        ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
    }
}
