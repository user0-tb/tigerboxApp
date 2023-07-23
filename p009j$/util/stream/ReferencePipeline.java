package p009j$.util.stream;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import p009j$.lang.Iterable$CC$$IA$1;
import p009j$.util.Optional;
import p009j$.util.Spliterator;
import p009j$.util.Spliterators;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BiFunction;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Consumer;
import p009j$.util.function.Function;
import p009j$.util.function.IntFunction;
import p009j$.util.function.Predicate;
import p009j$.util.function.Predicate$$ExternalSyntheticLambda1;
import p009j$.util.function.Supplier;
import p009j$.util.function.ToDoubleFunction;
import p009j$.util.function.ToIntFunction;
import p009j$.util.function.ToLongFunction;
import p009j$.util.stream.Collector;
import p009j$.util.stream.ForEachOps$ForEachOp;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.ReferencePipeline */
abstract class ReferencePipeline extends AbstractPipeline implements Stream {

    /* renamed from: j$.util.stream.ReferencePipeline$Head */
    static class Head extends ReferencePipeline {
        Head(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        Head(Supplier supplier, int i, boolean z) {
            super(supplier, i, z);
        }

        public void forEach(Consumer consumer) {
            if (!isParallel()) {
                sourceStageSpliterator().forEachRemaining(consumer);
            } else {
                ReferencePipeline.super.forEach(consumer);
            }
        }

        public void forEachOrdered(Consumer consumer) {
            if (!isParallel()) {
                sourceStageSpliterator().forEachRemaining(consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            evaluate(new ForEachOps$ForEachOp.OfRef(consumer, true));
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public final Sink opWrapSink(int i, Sink sink) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: j$.util.stream.ReferencePipeline$StatefulOp */
    abstract class StatefulOp extends ReferencePipeline {
        StatefulOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            return true;
        }
    }

    /* renamed from: j$.util.stream.ReferencePipeline$StatelessOp */
    abstract class StatelessOp extends ReferencePipeline {
        StatelessOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            return false;
        }
    }

    ReferencePipeline(Spliterator spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    ReferencePipeline(Supplier supplier, int i, boolean z) {
        super(supplier, i, z);
    }

    ReferencePipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    public final boolean allMatch(Predicate predicate) {
        return ((Boolean) evaluate(Node.CC.makeRef(predicate, MatchOps$MatchKind.ALL))).booleanValue();
    }

    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) evaluate(Node.CC.makeRef(predicate, MatchOps$MatchKind.ANY))).booleanValue();
    }

    public final Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return evaluate(new ReduceOps$1(StreamShape.REFERENCE, biConsumer2, biConsumer, supplier));
    }

    public final long count() {
        return ((LongPipeline) mapToLong(ReferencePipeline$$ExternalSyntheticLambda2.INSTANCE)).sum();
    }

    public final Stream distinct() {
        return new DistinctOps$1(this, StreamShape.REFERENCE, StreamOpFlag.IS_DISTINCT | StreamOpFlag.NOT_SIZED);
    }

    /* access modifiers changed from: package-private */
    public final Node evaluateToNode(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.collect(pipelineHelper, spliterator, z, intFunction);
    }

    public final Stream filter(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new IntPipeline.C14364(this, (AbstractPipeline) this, StreamShape.REFERENCE, StreamOpFlag.NOT_SIZED, predicate);
    }

    public final Optional findAny() {
        return (Optional) evaluate(new FindOps$FindOp(false, StreamShape.REFERENCE, Optional.empty(), FindOps$$ExternalSyntheticLambda0.INSTANCE, FindOps$$ExternalSyntheticLambda7.INSTANCE));
    }

    public final Optional findFirst() {
        return (Optional) evaluate(new FindOps$FindOp(true, StreamShape.REFERENCE, Optional.empty(), FindOps$$ExternalSyntheticLambda0.INSTANCE, FindOps$$ExternalSyntheticLambda7.INSTANCE));
    }

    public final Stream flatMap(Function function) {
        Objects.requireNonNull(function);
        return new StatelessOp(this, this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, function, 1) {
            public final /* synthetic */ int $r8$classId;
            final /* synthetic */ Function val$mapper;

            {
                this.$r8$classId = r6;
                if (r6 != 1) {
                    this.val$mapper = r5;
                    return;
                }
                this.val$mapper = r5;
            }

            /* access modifiers changed from: package-private */
            public Sink opWrapSink(int i, Sink sink) {
                switch (this.$r8$classId) {
                    case 0:
                        return new ReferencePipeline$2$1(this, sink);
                    default:
                        return new ReferencePipeline$2$1(this, sink, (Iterable$CC$$IA$1) null);
                }
            }
        };
    }

    public final DoubleStream flatMapToDouble(Function function) {
        Objects.requireNonNull(function);
        return new IntPipeline.C14386(this, (AbstractPipeline) this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, function);
    }

    public final IntStream flatMapToInt(Function function) {
        Objects.requireNonNull(function);
        return new IntPipeline.C14353(this, (AbstractPipeline) this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, function);
    }

    public final LongStream flatMapToLong(Function function) {
        Objects.requireNonNull(function);
        return new IntPipeline.C14375(this, (AbstractPipeline) this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, function);
    }

    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        evaluate(new ForEachOps$ForEachOp.OfRef(consumer, false));
    }

    public void forEachOrdered(Consumer consumer) {
        Objects.requireNonNull(consumer);
        evaluate(new ForEachOps$ForEachOp.OfRef(consumer, true));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void forEachWithCancel(p009j$.util.Spliterator r2, p009j$.util.stream.Sink r3) {
        /*
            r1 = this;
        L_0x0000:
            boolean r0 = r3.cancellationRequested()
            if (r0 != 0) goto L_0x000c
            boolean r0 = r2.tryAdvance(r3)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.ReferencePipeline.forEachWithCancel(j$.util.Spliterator, j$.util.stream.Sink):void");
    }

    /* access modifiers changed from: package-private */
    public final StreamShape getOutputShape() {
        return StreamShape.REFERENCE;
    }

    public final Iterator iterator() {
        return Spliterators.iterator(spliterator());
    }

    /* access modifiers changed from: package-private */
    public final Spliterator lazySpliterator(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator(supplier);
    }

    public final Stream limit(long j) {
        if (j >= 0) {
            return SliceOps.makeRef(this, 0, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    /* access modifiers changed from: package-private */
    public final Node.Builder makeNodeBuilder(long j, IntFunction intFunction) {
        return Nodes.builder(j, intFunction);
    }

    public final Stream map(Function function) {
        Objects.requireNonNull(function);
        return new StatelessOp(this, this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, function, 0) {
            public final /* synthetic */ int $r8$classId;
            final /* synthetic */ Function val$mapper;

            {
                this.$r8$classId = r6;
                if (r6 != 1) {
                    this.val$mapper = r5;
                    return;
                }
                this.val$mapper = r5;
            }

            /* access modifiers changed from: package-private */
            public Sink opWrapSink(int i, Sink sink) {
                switch (this.$r8$classId) {
                    case 0:
                        return new ReferencePipeline$2$1(this, sink);
                    default:
                        return new ReferencePipeline$2$1(this, sink, (Iterable$CC$$IA$1) null);
                }
            }
        };
    }

    public final DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new IntPipeline.C14386(this, (AbstractPipeline) this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, toDoubleFunction);
    }

    public final IntStream mapToInt(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new IntPipeline.C14353(this, (AbstractPipeline) this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, toIntFunction);
    }

    public final LongStream mapToLong(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new IntPipeline.C14375(this, (AbstractPipeline) this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, toLongFunction);
    }

    public final Optional max(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new Predicate$$ExternalSyntheticLambda1(comparator, 1));
    }

    public final Optional min(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new Predicate$$ExternalSyntheticLambda1(comparator, 2));
    }

    public final boolean noneMatch(Predicate predicate) {
        return ((Boolean) evaluate(Node.CC.makeRef(predicate, MatchOps$MatchKind.NONE))).booleanValue();
    }

    public final Stream peek(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new IntPipeline.C14364(this, (AbstractPipeline) this, StreamShape.REFERENCE, 0, consumer);
    }

    public final Optional reduce(BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return (Optional) evaluate(new ReduceOps$2(StreamShape.REFERENCE, binaryOperator));
    }

    public final Stream skip(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : SliceOps.makeRef(this, j, -1);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    public final Stream sorted() {
        return new SortedOps$OfRef(this);
    }

    public final Object[] toArray() {
        ReferencePipeline$$ExternalSyntheticLambda1 referencePipeline$$ExternalSyntheticLambda1 = ReferencePipeline$$ExternalSyntheticLambda1.INSTANCE;
        return Nodes.flatten(evaluateToArrayNode(referencePipeline$$ExternalSyntheticLambda1), referencePipeline$$ExternalSyntheticLambda1).asArray(referencePipeline$$ExternalSyntheticLambda1);
    }

    public final Object[] toArray(IntFunction intFunction) {
        return Nodes.flatten(evaluateToArrayNode(intFunction), intFunction).asArray(intFunction);
    }

    public BaseStream unordered() {
        return !isOrdered() ? this : new StatelessOp(this, this, StreamShape.REFERENCE, StreamOpFlag.NOT_ORDERED) {
            /* access modifiers changed from: package-private */
            public Sink opWrapSink(int i, Sink sink) {
                return sink;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final Spliterator wrap(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        return new StreamSpliterators$WrappingSpliterator(pipelineHelper, supplier, z);
    }

    public final Stream sorted(Comparator comparator) {
        return new SortedOps$OfRef(this, comparator);
    }

    public final Object collect(Collector collector) {
        Object obj;
        if (!isParallel() || !collector.characteristics().contains(Collector.Characteristics.CONCURRENT) || (isOrdered() && !collector.characteristics().contains(Collector.Characteristics.UNORDERED))) {
            Objects.requireNonNull(collector);
            Supplier supplier = collector.supplier();
            obj = evaluate(new ReduceOps$3(StreamShape.REFERENCE, collector.combiner(), collector.accumulator(), supplier, collector));
        } else {
            obj = collector.supplier().get();
            forEach(new MatchOps$$ExternalSyntheticLambda0(collector.accumulator(), obj));
        }
        return collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH) ? obj : collector.finisher().apply(obj);
    }

    public final Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(binaryOperator);
        return evaluate(new ReduceOps$1(StreamShape.REFERENCE, binaryOperator, biFunction, obj));
    }

    public final Object reduce(Object obj, BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return evaluate(new ReduceOps$1(StreamShape.REFERENCE, binaryOperator, (BiFunction) binaryOperator, obj));
    }
}
