package p009j$.util.stream;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import p009j$.util.Spliterator;
import p009j$.util.concurrent.ConcurrentHashMap;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.Function;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.IntFunction;
import p009j$.util.function.LongConsumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.ForEachOps$ForEachOp;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.Nodes;
import p009j$.util.stream.ReferencePipeline;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.DistinctOps$1 */
class DistinctOps$1 extends ReferencePipeline.StatefulOp {

    /* renamed from: j$.util.stream.DistinctOps$1$2 */
    class C14312 extends Sink.ChainedReference {
        public final /* synthetic */ int $r8$classId = 0;
        Object seen;
        final /* synthetic */ Object this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14312(DistinctOps$1 distinctOps$1, Sink sink) {
            super(sink);
            this.this$0 = distinctOps$1;
        }

        public void accept(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    if (!((Set) this.seen).contains(obj)) {
                        ((Set) this.seen).add(obj);
                        this.downstream.accept(obj);
                        return;
                    }
                    return;
                case 1:
                    LongStream longStream = (LongStream) ((Function) ((IntPipeline.C14375) this.this$0).val$mapper).apply(obj);
                    if (longStream != null) {
                        try {
                            longStream.sequential().forEach((LongConsumer) this.seen);
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                            break;
                        }
                    }
                    if (longStream != null) {
                        longStream.close();
                        return;
                    }
                    return;
                case 2:
                    IntStream intStream = (IntStream) ((Function) ((IntPipeline.C14353) this.this$0).val$mapper).apply(obj);
                    if (intStream != null) {
                        try {
                            intStream.sequential().forEach((IntConsumer) this.seen);
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            break;
                        }
                    }
                    if (intStream != null) {
                        intStream.close();
                        return;
                    }
                    return;
                default:
                    DoubleStream doubleStream = (DoubleStream) ((Function) ((IntPipeline.C14386) this.this$0).val$mapper).apply(obj);
                    if (doubleStream != null) {
                        try {
                            doubleStream.sequential().forEach((DoubleConsumer) this.seen);
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                            break;
                        }
                    }
                    if (doubleStream != null) {
                        doubleStream.close();
                        return;
                    }
                    return;
            }
            throw th;
            throw th;
            throw th;
        }

        public void begin(long j) {
            switch (this.$r8$classId) {
                case 0:
                    this.seen = new HashSet();
                    this.downstream.begin(-1);
                    return;
                case 1:
                    this.downstream.begin(-1);
                    return;
                case 2:
                    this.downstream.begin(-1);
                    return;
                default:
                    this.downstream.begin(-1);
                    return;
            }
        }

        public void end() {
            switch (this.$r8$classId) {
                case 0:
                    this.seen = null;
                    this.downstream.end();
                    return;
                default:
                    this.downstream.end();
                    return;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14312(IntPipeline.C14353 r2, Sink sink) {
            super(sink);
            this.this$0 = r2;
            Sink sink2 = this.downstream;
            Objects.requireNonNull(sink2);
            this.seen = new IntPipeline$$ExternalSyntheticLambda6(sink2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14312(IntPipeline.C14375 r2, Sink sink) {
            super(sink);
            this.this$0 = r2;
            Sink sink2 = this.downstream;
            Objects.requireNonNull(sink2);
            this.seen = new LongPipeline$$ExternalSyntheticLambda7(sink2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14312(IntPipeline.C14386 r2, Sink sink) {
            super(sink);
            this.this$0 = r2;
            Sink sink2 = this.downstream;
            Objects.requireNonNull(sink2);
            this.seen = new DoublePipeline$$ExternalSyntheticLambda6(sink2);
        }
    }

    DistinctOps$1(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
        super(abstractPipeline, streamShape, i);
    }

    /* access modifiers changed from: package-private */
    public Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
        if (StreamOpFlag.DISTINCT.isKnown(pipelineHelper.getStreamAndOpFlags())) {
            return pipelineHelper.evaluate(spliterator, false, intFunction);
        }
        if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
            return reduce(pipelineHelper, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        new ForEachOps$ForEachOp.OfRef(new MatchOps$$ExternalSyntheticLambda0(atomicBoolean, concurrentHashMap), false).evaluateParallel(pipelineHelper, spliterator);
        Set keySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(keySet);
            hashSet.add((Object) null);
            keySet = hashSet;
        }
        return new Nodes.CollectionNode(keySet);
    }

    /* access modifiers changed from: package-private */
    public Spliterator opEvaluateParallelLazy(PipelineHelper pipelineHelper, Spliterator spliterator) {
        return StreamOpFlag.DISTINCT.isKnown(pipelineHelper.getStreamAndOpFlags()) ? pipelineHelper.wrapSpliterator(spliterator) : StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()) ? ((Nodes.CollectionNode) reduce(pipelineHelper, spliterator)).spliterator() : new StreamSpliterators$DistinctSpliterator(pipelineHelper.wrapSpliterator(spliterator));
    }

    /* access modifiers changed from: package-private */
    public Sink opWrapSink(int i, Sink sink) {
        Objects.requireNonNull(sink);
        if (StreamOpFlag.DISTINCT.isKnown(i)) {
            return sink;
        }
        return StreamOpFlag.SORTED.isKnown(i) ? new Sink.ChainedReference(this, sink) {
            Object lastSeen;
            boolean seenNull;

            public void accept(Object obj) {
                if (obj != null) {
                    Object obj2 = this.lastSeen;
                    if (obj2 == null || !obj.equals(obj2)) {
                        Sink sink = this.downstream;
                        this.lastSeen = obj;
                        sink.accept(obj);
                    }
                } else if (!this.seenNull) {
                    this.seenNull = true;
                    Sink sink2 = this.downstream;
                    this.lastSeen = null;
                    sink2.accept(null);
                }
            }

            public void begin(long j) {
                this.seenNull = false;
                this.lastSeen = null;
                this.downstream.begin(-1);
            }

            public void end() {
                this.seenNull = false;
                this.lastSeen = null;
                this.downstream.end();
            }
        } : new C14312(this, sink);
    }

    /* access modifiers changed from: package-private */
    public Node reduce(PipelineHelper pipelineHelper, Spliterator spliterator) {
        DistinctOps$1$$ExternalSyntheticLambda3 distinctOps$1$$ExternalSyntheticLambda3 = DistinctOps$1$$ExternalSyntheticLambda3.INSTANCE;
        DistinctOps$1$$ExternalSyntheticLambda0 distinctOps$1$$ExternalSyntheticLambda0 = DistinctOps$1$$ExternalSyntheticLambda0.INSTANCE;
        return new Nodes.CollectionNode((Collection) new ReduceOps$1(StreamShape.REFERENCE, (BiConsumer) DistinctOps$1$$ExternalSyntheticLambda1.INSTANCE, (BiConsumer) distinctOps$1$$ExternalSyntheticLambda0, (Supplier) distinctOps$1$$ExternalSyntheticLambda3).evaluateParallel(pipelineHelper, spliterator));
    }
}
