package p009j$.util.stream;

import java.util.Iterator;
import java.util.Objects;
import p009j$.lang.Iterable$CC$$IA$1;
import p009j$.util.DoubleSummaryStatistics;
import p009j$.util.OptionalDouble;
import p009j$.util.PrimitiveIterator;
import p009j$.util.Spliterator;
import p009j$.util.Spliterators;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.DoubleBinaryOperator;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.DoubleFunction;
import p009j$.util.function.DoubleToLongFunction;
import p009j$.util.function.IntFunction;
import p009j$.util.function.ObjDoubleConsumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.ForEachOps$ForEachOp;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.Node;
import p009j$.util.stream.StreamSpliterators$DelegatingSpliterator;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.DoublePipeline */
abstract class DoublePipeline extends AbstractPipeline implements DoubleStream {

    /* renamed from: j$.util.stream.DoublePipeline$Head */
    static class Head extends DoublePipeline {
        Head(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        public void forEach(DoubleConsumer doubleConsumer) {
            if (!isParallel()) {
                DoublePipeline.adapt(sourceStageSpliterator()).forEachRemaining(doubleConsumer);
            } else {
                DoublePipeline.super.forEach(doubleConsumer);
            }
        }

        public void forEachOrdered(DoubleConsumer doubleConsumer) {
            if (!isParallel()) {
                DoublePipeline.adapt(sourceStageSpliterator()).forEachRemaining(doubleConsumer);
                return;
            }
            Objects.requireNonNull(doubleConsumer);
            evaluate(new ForEachOps$ForEachOp.OfDouble(doubleConsumer, true));
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public final Sink opWrapSink(int i, Sink sink) {
            throw new UnsupportedOperationException();
        }

        public /* bridge */ /* synthetic */ DoubleStream parallel() {
            parallel();
            return this;
        }

        public /* bridge */ /* synthetic */ DoubleStream sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.DoublePipeline$StatefulOp */
    abstract class StatefulOp extends DoublePipeline {
        StatefulOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            return true;
        }

        public /* bridge */ /* synthetic */ DoubleStream parallel() {
            parallel();
            return this;
        }

        public /* bridge */ /* synthetic */ DoubleStream sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.DoublePipeline$StatelessOp */
    abstract class StatelessOp extends DoublePipeline {
        StatelessOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            return false;
        }

        public /* bridge */ /* synthetic */ DoubleStream parallel() {
            parallel();
            return this;
        }

        public /* bridge */ /* synthetic */ DoubleStream sequential() {
            sequential();
            return this;
        }
    }

    DoublePipeline(Spliterator spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    DoublePipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    /* access modifiers changed from: private */
    public static Spliterator.OfDouble adapt(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.OfDouble) {
            return (Spliterator.OfDouble) spliterator;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    public final boolean allMatch(C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        return ((Boolean) evaluate(Node.CC.makeDouble(r2, MatchOps$MatchKind.ALL))).booleanValue();
    }

    public final boolean anyMatch(C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        return ((Boolean) evaluate(Node.CC.makeDouble(r2, MatchOps$MatchKind.ANY))).booleanValue();
    }

    public final OptionalDouble average() {
        double[] dArr = (double[]) collect(DoublePipeline$$ExternalSyntheticLambda13.INSTANCE, DoublePipeline$$ExternalSyntheticLambda11.INSTANCE, DoublePipeline$$ExternalSyntheticLambda1.INSTANCE);
        return dArr[2] > 0.0d ? OptionalDouble.m202of(Collectors.computeFinalSum(dArr) / dArr[2]) : OptionalDouble.empty();
    }

    public final Stream boxed() {
        return mapToObj(DoublePipeline$$ExternalSyntheticLambda7.INSTANCE);
    }

    public final Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        IntPipeline$$ExternalSyntheticLambda2 intPipeline$$ExternalSyntheticLambda2 = new IntPipeline$$ExternalSyntheticLambda2(biConsumer, 1);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objDoubleConsumer);
        return evaluate(new ReduceOps$1(StreamShape.DOUBLE_VALUE, (BinaryOperator) intPipeline$$ExternalSyntheticLambda2, objDoubleConsumer, supplier));
    }

    public final long count() {
        return ((LongPipeline) mapToLong(DoublePipeline$$ExternalSyntheticLambda8.INSTANCE)).sum();
    }

    public final DoubleStream distinct() {
        return ((ReferencePipeline) mapToObj(DoublePipeline$$ExternalSyntheticLambda7.INSTANCE)).distinct().mapToDouble(DoublePipeline$$ExternalSyntheticLambda15.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public final Node evaluateToNode(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.collectDouble(pipelineHelper, spliterator, z);
    }

    public final DoubleStream filter(C$r8$wrapper$java$util$function$IntPredicate$VWRP r9) {
        Objects.requireNonNull(r9);
        return new IntPipeline.C14386(this, this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SIZED, r9, (Iterable$CC$$IA$1) null);
    }

    public final OptionalDouble findAny() {
        return (OptionalDouble) evaluate(new FindOps$FindOp(false, StreamShape.DOUBLE_VALUE, OptionalDouble.empty(), FindOps$$ExternalSyntheticLambda1.INSTANCE, FindOps$$ExternalSyntheticLambda4.INSTANCE));
    }

    public final OptionalDouble findFirst() {
        return (OptionalDouble) evaluate(new FindOps$FindOp(true, StreamShape.DOUBLE_VALUE, OptionalDouble.empty(), FindOps$$ExternalSyntheticLambda1.INSTANCE, FindOps$$ExternalSyntheticLambda4.INSTANCE));
    }

    public final DoubleStream flatMap(DoubleFunction doubleFunction) {
        return new IntPipeline.C14386(this, (AbstractPipeline) this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, doubleFunction);
    }

    public void forEach(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        evaluate(new ForEachOps$ForEachOp.OfDouble(doubleConsumer, false));
    }

    public void forEachOrdered(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        evaluate(new ForEachOps$ForEachOp.OfDouble(doubleConsumer, true));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[LOOP:0: B:6:0x0015->B:9:0x001f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void forEachWithCancel(p009j$.util.Spliterator r3, p009j$.util.stream.Sink r4) {
        /*
            r2 = this;
            j$.util.Spliterator$OfDouble r3 = adapt(r3)
            boolean r0 = r4 instanceof p009j$.util.function.DoubleConsumer
            if (r0 == 0) goto L_0x000c
            r0 = r4
            j$.util.function.DoubleConsumer r0 = (p009j$.util.function.DoubleConsumer) r0
            goto L_0x0015
        L_0x000c:
            boolean r0 = p009j$.util.stream.Tripwire.ENABLED
            if (r0 != 0) goto L_0x0022
            j$.util.stream.DoublePipeline$$ExternalSyntheticLambda6 r0 = new j$.util.stream.DoublePipeline$$ExternalSyntheticLambda6
            r0.<init>((p009j$.util.stream.Sink) r4)
        L_0x0015:
            boolean r1 = r4.cancellationRequested()
            if (r1 != 0) goto L_0x0021
            boolean r1 = r3.tryAdvance((p009j$.util.function.DoubleConsumer) r0)
            if (r1 != 0) goto L_0x0015
        L_0x0021:
            return
        L_0x0022:
            java.lang.Class<j$.util.stream.AbstractPipeline> r3 = p009j$.util.stream.AbstractPipeline.class
            java.lang.String r4 = "using DoubleStream.adapt(Sink<Double> s)"
            p009j$.util.stream.Tripwire.trip(r3, r4)
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.DoublePipeline.forEachWithCancel(j$.util.Spliterator, j$.util.stream.Sink):void");
    }

    /* access modifiers changed from: package-private */
    public final StreamShape getOutputShape() {
        return StreamShape.DOUBLE_VALUE;
    }

    public final PrimitiveIterator.OfDouble iterator() {
        return Spliterators.iterator(spliterator());
    }

    /* renamed from: iterator  reason: collision with other method in class */
    public Iterator m742iterator() {
        return Spliterators.iterator(spliterator());
    }

    /* access modifiers changed from: package-private */
    public Spliterator lazySpliterator(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator.OfDouble(supplier);
    }

    public final DoubleStream limit(long j) {
        if (j >= 0) {
            return SliceOps.makeDouble(this, 0, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    /* access modifiers changed from: package-private */
    public final Node.Builder makeNodeBuilder(long j, IntFunction intFunction) {
        return Nodes.doubleBuilder(j);
    }

    public final DoubleStream map(C$r8$wrapper$java$util$function$IntPredicate$VWRP r8) {
        Objects.requireNonNull(r8);
        return new IntPipeline.C14386(this, (AbstractPipeline) this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, r8);
    }

    public final IntStream mapToInt(C$r8$wrapper$java$util$function$IntPredicate$VWRP r8) {
        Objects.requireNonNull(r8);
        return new IntPipeline.C14353(this, (AbstractPipeline) this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, r8);
    }

    public final LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
        Objects.requireNonNull(doubleToLongFunction);
        return new IntPipeline.C14375(this, (AbstractPipeline) this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, doubleToLongFunction);
    }

    public final Stream mapToObj(DoubleFunction doubleFunction) {
        Objects.requireNonNull(doubleFunction);
        return new IntPipeline.C14364(this, (AbstractPipeline) this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, doubleFunction);
    }

    public final OptionalDouble max() {
        return reduce(DoublePipeline$$ExternalSyntheticLambda4.INSTANCE);
    }

    public final OptionalDouble min() {
        return reduce(DoublePipeline$$ExternalSyntheticLambda5.INSTANCE);
    }

    public final boolean noneMatch(C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        return ((Boolean) evaluate(Node.CC.makeDouble(r2, MatchOps$MatchKind.NONE))).booleanValue();
    }

    public final DoubleStream peek(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return new IntPipeline.C14386(this, (AbstractPipeline) this, StreamShape.DOUBLE_VALUE, 0, doubleConsumer);
    }

    public final double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return ((Double) evaluate(new ReduceOps$11(StreamShape.DOUBLE_VALUE, doubleBinaryOperator, d))).doubleValue();
    }

    public final DoubleStream skip(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : SliceOps.makeDouble(this, j, -1);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    public final DoubleStream sorted() {
        return new SortedOps$OfDouble(this);
    }

    public final Spliterator.OfDouble spliterator() {
        return adapt(super.spliterator());
    }

    public final double sum() {
        return Collectors.computeFinalSum((double[]) collect(DoublePipeline$$ExternalSyntheticLambda14.INSTANCE, DoublePipeline$$ExternalSyntheticLambda12.INSTANCE, DoublePipeline$$ExternalSyntheticLambda2.INSTANCE));
    }

    public final DoubleSummaryStatistics summaryStatistics() {
        return (DoubleSummaryStatistics) collect(Collectors$$ExternalSyntheticLambda78.INSTANCE, DoublePipeline$$ExternalSyntheticLambda10.INSTANCE, DoublePipeline$$ExternalSyntheticLambda0.INSTANCE);
    }

    public final double[] toArray() {
        return (double[]) Nodes.flattenDouble((Node.OfDouble) evaluateToArrayNode(DoublePipeline$$ExternalSyntheticLambda9.INSTANCE)).asPrimitiveArray();
    }

    public BaseStream unordered() {
        return !isOrdered() ? this : new IntPipeline.C14342(this, (AbstractPipeline) this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_ORDERED);
    }

    /* access modifiers changed from: package-private */
    public final Spliterator wrap(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        return new StreamSpliterators$DoubleWrappingSpliterator(pipelineHelper, supplier, z);
    }

    public final OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return (OptionalDouble) evaluate(new ReduceOps$2(StreamShape.DOUBLE_VALUE, doubleBinaryOperator));
    }
}
