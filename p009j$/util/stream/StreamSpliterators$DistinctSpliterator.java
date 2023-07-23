package p009j$.util.stream;

import java.util.Comparator;
import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.concurrent.ConcurrentHashMap;
import p009j$.util.function.Consumer;

/* renamed from: j$.util.stream.StreamSpliterators$DistinctSpliterator */
final class StreamSpliterators$DistinctSpliterator implements Spliterator, Consumer {
    private static final Object NULL_VALUE = new Object();

    /* renamed from: s */
    private final Spliterator f254s;
    private final ConcurrentHashMap seen;
    private Object tmpSlot;

    StreamSpliterators$DistinctSpliterator(Spliterator spliterator) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f254s = spliterator;
        this.seen = concurrentHashMap;
    }

    private StreamSpliterators$DistinctSpliterator(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.f254s = spliterator;
        this.seen = concurrentHashMap;
    }

    public void accept(Object obj) {
        this.tmpSlot = obj;
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public int characteristics() {
        return (this.f254s.characteristics() & -16469) | 1;
    }

    public long estimateSize() {
        return this.f254s.estimateSize();
    }

    public void forEachRemaining(Consumer consumer) {
        this.f254s.forEachRemaining(new MatchOps$$ExternalSyntheticLambda0(this, consumer));
    }

    public Comparator getComparator() {
        return this.f254s.getComparator();
    }

    public /* synthetic */ long getExactSizeIfKnown() {
        return Objects.$default$getExactSizeIfKnown(this);
    }

    public /* synthetic */ boolean hasCharacteristics(int i) {
        return Objects.$default$hasCharacteristics(this, i);
    }

    /* renamed from: lambda$forEachRemaining$0$java-util-stream-StreamSpliterators$DistinctSpliterator */
    public void mo23362xb9bff3f1(Consumer consumer, Object obj) {
        if (this.seen.putIfAbsent(obj != null ? obj : NULL_VALUE, Boolean.TRUE) == null) {
            consumer.accept(obj);
        }
    }

    public boolean tryAdvance(Consumer consumer) {
        while (this.f254s.tryAdvance(this)) {
            ConcurrentHashMap concurrentHashMap = this.seen;
            Object obj = this.tmpSlot;
            if (obj == null) {
                obj = NULL_VALUE;
            }
            if (concurrentHashMap.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.tmpSlot);
                this.tmpSlot = null;
                return true;
            }
        }
        return false;
    }

    public Spliterator trySplit() {
        Spliterator trySplit = this.f254s.trySplit();
        if (trySplit != null) {
            return new StreamSpliterators$DistinctSpliterator(trySplit, this.seen);
        }
        return null;
    }
}
