package p009j$.util.stream;

import p009j$.util.function.BinaryOperator;
import p009j$.util.stream.Nodes;

/* renamed from: j$.util.stream.Nodes$CollectorTask$OfRef$$ExternalSyntheticLambda0 */
public final /* synthetic */ class Nodes$CollectorTask$OfRef$$ExternalSyntheticLambda0 implements BinaryOperator {
    public static final /* synthetic */ Nodes$CollectorTask$OfRef$$ExternalSyntheticLambda0 INSTANCE = new Nodes$CollectorTask$OfRef$$ExternalSyntheticLambda0();

    private /* synthetic */ Nodes$CollectorTask$OfRef$$ExternalSyntheticLambda0() {
    }

    public final Object apply(Object obj, Object obj2) {
        return new Nodes.ConcNode((Node) obj, (Node) obj2);
    }
}
