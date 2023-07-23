package p009j$.util.function;

import java.util.concurrent.ConcurrentMap;
import p009j$.util.function.Consumer;

/* renamed from: j$.util.function.Consumer$$ExternalSyntheticLambda0 */
public final /* synthetic */ class Consumer$$ExternalSyntheticLambda0 implements Consumer, BiConsumer {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Consumer$$ExternalSyntheticLambda0(Consumer consumer, Consumer consumer2) {
        this.f$0 = consumer;
        this.f$1 = consumer2;
    }

    public void accept(Object obj) {
        ((Consumer) this.f$0).accept(obj);
        ((Consumer) this.f$1).accept(obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public /* synthetic */ Consumer$$ExternalSyntheticLambda0(ConcurrentMap concurrentMap, BiFunction biFunction) {
        this.f$0 = concurrentMap;
        this.f$1 = biFunction;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0008 A[LOOP:0: B:1:0x0008->B:4:0x0016, LOOP_START, PHI: r5 
      PHI: (r5v1 java.lang.Object) = (r5v0 java.lang.Object), (r5v3 java.lang.Object) binds: [B:0:0x0000, B:4:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void accept(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f$0
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            java.lang.Object r1 = r3.f$1
            j$.util.function.BiFunction r1 = (p009j$.util.function.BiFunction) r1
        L_0x0008:
            java.lang.Object r2 = r1.apply(r4, r5)
            boolean r5 = r0.replace(r4, r5, r2)
            if (r5 != 0) goto L_0x0018
            java.lang.Object r5 = r0.get(r4)
            if (r5 != 0) goto L_0x0008
        L_0x0018:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.function.Consumer$$ExternalSyntheticLambda0.accept(java.lang.Object, java.lang.Object):void");
    }
}
