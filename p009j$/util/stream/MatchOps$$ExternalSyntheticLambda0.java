package p009j$.util.stream;

import java.util.concurrent.atomic.AtomicBoolean;
import p009j$.lang.Iterable$CC$$IA$1;
import p009j$.lang.Iterable$CC$$IA$2;
import p009j$.util.concurrent.ConcurrentHashMap;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.Consumer;
import p009j$.util.function.Predicate;
import p009j$.util.function.Supplier;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.MatchOps$$ExternalSyntheticLambda0 */
public final /* synthetic */ class MatchOps$$ExternalSyntheticLambda0 implements Supplier, Consumer {
    public final /* synthetic */ int $r8$classId = 5;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MatchOps$$ExternalSyntheticLambda0(BiConsumer biConsumer, Object obj) {
        this.f$0 = biConsumer;
        this.f$1 = obj;
    }

    public void accept(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f$0;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f$1;
                if (obj == null) {
                    atomicBoolean.set(true);
                    return;
                } else {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    return;
                }
            case 5:
                ((BiConsumer) this.f$0).accept(this.f$1, obj);
                return;
            default:
                ((StreamSpliterators$DistinctSpliterator) this.f$0).mo23362xb9bff3f1((Consumer) this.f$1, obj);
                return;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.$r8$classId) {
            case 1:
                return Consumer.CC.$default$andThen(this, consumer);
            case 5:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    public Object get() {
        switch (this.$r8$classId) {
            case 0:
                return new MatchOps$4MatchSink((MatchOps$MatchKind) this.f$0, (C$r8$wrapper$java$util$function$IntPredicate$VWRP) this.f$1);
            case 2:
                return new MatchOps$2MatchSink((MatchOps$MatchKind) this.f$0, (C$r8$wrapper$java$util$function$IntPredicate$VWRP) this.f$1);
            case 3:
                return new MatchOps$3MatchSink((MatchOps$MatchKind) this.f$0, (C$r8$wrapper$java$util$function$IntPredicate$VWRP) this.f$1);
            default:
                return new MatchOps$1MatchSink((MatchOps$MatchKind) this.f$0, (Predicate) this.f$1);
        }
    }

    public /* synthetic */ MatchOps$$ExternalSyntheticLambda0(MatchOps$MatchKind matchOps$MatchKind, Predicate predicate) {
        this.f$0 = matchOps$MatchKind;
        this.f$1 = predicate;
    }

    public /* synthetic */ MatchOps$$ExternalSyntheticLambda0(MatchOps$MatchKind matchOps$MatchKind, C$r8$wrapper$java$util$function$IntPredicate$VWRP r3) {
        this.f$0 = matchOps$MatchKind;
        this.f$1 = r3;
    }

    public /* synthetic */ MatchOps$$ExternalSyntheticLambda0(MatchOps$MatchKind matchOps$MatchKind, C$r8$wrapper$java$util$function$IntPredicate$VWRP r2, Iterable$CC$$IA$1 r3) {
        this.f$0 = matchOps$MatchKind;
        this.f$1 = r2;
    }

    public /* synthetic */ MatchOps$$ExternalSyntheticLambda0(MatchOps$MatchKind matchOps$MatchKind, C$r8$wrapper$java$util$function$IntPredicate$VWRP r2, Iterable$CC$$IA$2 r3) {
        this.f$0 = matchOps$MatchKind;
        this.f$1 = r2;
    }

    public /* synthetic */ MatchOps$$ExternalSyntheticLambda0(StreamSpliterators$DistinctSpliterator streamSpliterators$DistinctSpliterator, Consumer consumer) {
        this.f$0 = streamSpliterators$DistinctSpliterator;
        this.f$1 = consumer;
    }

    public /* synthetic */ MatchOps$$ExternalSyntheticLambda0(AtomicBoolean atomicBoolean, ConcurrentHashMap concurrentHashMap) {
        this.f$0 = atomicBoolean;
        this.f$1 = concurrentHashMap;
    }
}
