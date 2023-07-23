package p009j$.util.stream;

import p009j$.util.function.BinaryOperator;
import p009j$.util.stream.Node;
import p009j$.util.stream.Nodes;

/* renamed from: j$.util.stream.Nodes$CollectorTask$OfInt$$ExternalSyntheticLambda0 */
public final /* synthetic */ class Nodes$CollectorTask$OfInt$$ExternalSyntheticLambda0 implements BinaryOperator {
    public static final /* synthetic */ Nodes$CollectorTask$OfInt$$ExternalSyntheticLambda0 INSTANCE = new Nodes$CollectorTask$OfInt$$ExternalSyntheticLambda0();

    private /* synthetic */ Nodes$CollectorTask$OfInt$$ExternalSyntheticLambda0() {
    }

    public final Object apply(Object obj, Object obj2) {
        return new Nodes.ConcNode.OfInt((Node.OfInt) obj, (Node.OfInt) obj2);
    }
}
