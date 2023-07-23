package p009j$.util.stream;

import java.util.List;
import java.util.Set;
import p009j$.util.function.BinaryOperator;

/* renamed from: j$.util.stream.Collectors$$ExternalSyntheticLambda36 */
public final /* synthetic */ class Collectors$$ExternalSyntheticLambda36 implements BinaryOperator {
    public static final /* synthetic */ Collectors$$ExternalSyntheticLambda36 INSTANCE = new Collectors$$ExternalSyntheticLambda36();

    private /* synthetic */ Collectors$$ExternalSyntheticLambda36() {
    }

    public final Object apply(Object obj, Object obj2) {
        List list = (List) obj;
        Set set = Collectors.CH_ID;
        list.addAll((List) obj2);
        return list;
    }
}
