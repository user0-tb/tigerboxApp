package p009j$.util.stream;

import p009j$.util.function.BinaryOperator;
import p009j$.util.stream.Node;
import p009j$.util.stream.Nodes;

/* renamed from: j$.util.stream.Nodes$CollectorTask$OfLong$$ExternalSyntheticLambda0 */
public final /* synthetic */ class Nodes$CollectorTask$OfLong$$ExternalSyntheticLambda0 implements BinaryOperator {
    public static final /* synthetic */ Nodes$CollectorTask$OfLong$$ExternalSyntheticLambda0 INSTANCE = new Nodes$CollectorTask$OfLong$$ExternalSyntheticLambda0();

    private /* synthetic */ Nodes$CollectorTask$OfLong$$ExternalSyntheticLambda0() {
    }

    public final Object apply(Object obj, Object obj2) {
        return new Nodes.ConcNode.OfLong((Node.OfLong) obj, (Node.OfLong) obj2);
    }
}
