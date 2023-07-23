package p009j$.util.stream;

import java.util.Iterator;
import java.util.Objects;
import p009j$.util.LongSummaryStatistics;
import p009j$.util.OptionalDouble;
import p009j$.util.OptionalLong;
import p009j$.util.PrimitiveIterator;
import p009j$.util.Spliterator;
import p009j$.util.Spliterators;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.IntFunction;
import p009j$.util.function.LongBinaryOperator;
import p009j$.util.function.LongConsumer;
import p009j$.util.function.LongFunction;
import p009j$.util.function.LongUnaryOperator;
import p009j$.util.function.ObjLongConsumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.ForEachOps$ForEachOp;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.Node;
import p009j$.util.stream.StreamSpliterators$DelegatingSpliterator;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.LongPipeline */
abstract class LongPipeline extends AbstractPipeline implements LongStream {

    /* renamed from: j$.util.stream.LongPipeline$Head */
    static class Head extends LongPipeline {
        Head(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        public void forEach(LongConsumer longConsumer) {
            if (!isParallel()) {
                LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(longConsumer);
            } else {
                LongPipeline.super.forEach(longConsumer);
            }
        }

        public void forEachOrdered(LongConsumer longConsumer) {
            if (!isParallel()) {
                LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(longConsumer);
                return;
            }
            Objects.requireNonNull(longConsumer);
            evaluate(new ForEachOps$ForEachOp.OfLong(longConsumer, true));
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public final Sink opWrapSink(int i, Sink sink) {
            throw new UnsupportedOperationException();
        }

        public /* bridge */ /* synthetic */ LongStream parallel() {
            parallel();
            return this;
        }

        public /* bridge */ /* synthetic */ LongStream sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.LongPipeline$StatefulOp */
    abstract class StatefulOp extends LongPipeline {
        StatefulOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            return true;
        }

        public /* bridge */ /* synthetic */ LongStream parallel() {
            parallel();
            return this;
        }

        public /* bridge */ /* synthetic */ LongStream sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.LongPipeline$StatelessOp */
    abstract class StatelessOp extends LongPipeline {
        StatelessOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            return false;
        }

        public /* bridge */ /* synthetic */ LongStream parallel() {
            parallel();
            return this;
        }

        public /* bridge */ /* synthetic */ LongStream sequential() {
            sequential();
            return this;
        }
    }

    LongPipeline(Spliterator spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    LongPipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    /* access modifiers changed from: private */
    public static Spliterator.OfLong adapt(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.OfLong) {
            return (Spliterator.OfLong) spliterator;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    public final boolean allMatch$2(C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        return ((Boolean) evaluate(Node.CC.makeLong(r2, MatchOps$MatchKind.ALL))).booleanValue();
    }

    public final boolean anyMatch$2(C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        return ((Boolean) evaluate(Node.CC.makeLong(r2, MatchOps$MatchKind.ANY))).booleanValue();
    }

    public final DoubleStream asDoubleStream() {
        return new IntPipeline.C14342(this, (AbstractPipeline) this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT);
    }

    public final OptionalDouble average() {
        long[] jArr = (long[]) collect(LongPipeline$$ExternalSyntheticLambda12.INSTANCE, LongPipeline$$ExternalSyntheticLambda11.INSTANCE, LongPipeline$$ExternalSyntheticLambda1.INSTANCE);
        return jArr[0] > 0 ? OptionalDouble.m202of(((double) jArr[1]) / ((double) jArr[0])) : OptionalDouble.empty();
    }

    public final Stream boxed() {
        return mapToObj(LongPipeline$$ExternalSyntheticLambda8.INSTANCE);
    }

    public final Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        IntPipeline$$ExternalSyntheticLambda2 intPipeline$$ExternalSyntheticLambda2 = new IntPipeline$$ExternalSyntheticLambda2(biConsumer, 2);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objLongConsumer);
        return evaluate(new ReduceOps$1(StreamShape.LONG_VALUE, (BinaryOperator) intPipeline$$ExternalSyntheticLambda2, objLongConsumer, supplier));
    }

    public final long count() {
        return ((LongPipeline) map(LongPipeline$$ExternalSyntheticLambda9.INSTANCE)).sum();
    }

    public final LongStream distinct() {
        return ((ReferencePipeline) mapToObj(LongPipeline$$ExternalSyntheticLambda8.INSTANCE)).distinct().mapToLong(LongPipeline$$ExternalSyntheticLambda13.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public final Node evaluateToNode(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.collectLong(pipelineHelper, spliterator, z);
    }

    public final LongStream filter(C$r8$wrapper$java$util$function$IntPredicate$VWRP r8) {
        Objects.requireNonNull(r8);
        return new IntPipeline.C14375(this, (AbstractPipeline) this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SIZED, r8);
    }

    public final OptionalLong findAny() {
        return (OptionalLong) evaluate(new FindOps$FindOp(false, StreamShape.LONG_VALUE, OptionalLong.empty(), FindOps$$ExternalSyntheticLambda3.INSTANCE, FindOps$$ExternalSyntheticLambda6.INSTANCE));
    }

    public final OptionalLong findFirst() {
        return (OptionalLong) evaluate(new FindOps$FindOp(true, StreamShape.LONG_VALUE, OptionalLong.empty(), FindOps$$ExternalSyntheticLambda3.INSTANCE, FindOps$$ExternalSyntheticLambda6.INSTANCE));
    }

    public final LongStream flatMap(LongFunction longFunction) {
        return new IntPipeline.C14375(this, (AbstractPipeline) this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, longFunction);
    }

    public void forEach(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        evaluate(new ForEachOps$ForEachOp.OfLong(longConsumer, false));
    }

    public void forEachOrdered(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        evaluate(new ForEachOps$ForEachOp.OfLong(longConsumer, true));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[LOOP:0: B:6:0x0015->B:9:0x001f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void forEachWithCancel(p009j$.util.Spliterator r3, p009j$.util.stream.Sink r4) {
        /*
            r2 = this;
            j$.util.Spliterator$OfLong r3 = adapt(r3)
            boolean r0 = r4 instanceof p009j$.util.function.LongConsumer
            if (r0 == 0) goto L_0x000c
            r0 = r4
            j$.util.function.LongConsumer r0 = (p009j$.util.function.LongConsumer) r0
            goto L_0x0015
        L_0x000c:
            boolean r0 = p009j$.util.stream.Tripwire.ENABLED
            if (r0 != 0) goto L_0x0022
            j$.util.stream.LongPipeline$$ExternalSyntheticLambda7 r0 = new j$.util.stream.LongPipeline$$ExternalSyntheticLambda7
            r0.<init>((p009j$.util.stream.Sink) r4)
        L_0x0015:
            boolean r1 = r4.cancellationRequested()
            if (r1 != 0) goto L_0x0021
            boolean r1 = r3.tryAdvance((p009j$.util.function.LongConsumer) r0)
            if (r1 != 0) goto L_0x0015
        L_0x0021:
            return
        L_0x0022:
            java.lang.Class<j$.util.stream.AbstractPipeline> r3 = p009j$.util.stream.AbstractPipeline.class
            java.lang.String r4 = "using LongStream.adapt(Sink<Long> s)"
            p009j$.util.stream.Tripwire.trip(r3, r4)
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.LongPipeline.forEachWithCancel(j$.util.Spliterator, j$.util.stream.Sink):void");
    }

    /* access modifiers changed from: package-private */
    public final StreamShape getOutputShape() {
        return StreamShape.LONG_VALUE;
    }

    public final PrimitiveIterator.OfLong iterator() {
        return Spliterators.iterator(spliterator());
    }

    /* renamed from: iterator  reason: collision with other method in class */
    public Iterator m744iterator() {
        return Spliterators.iterator(spliterator());
    }

    /* access modifiers changed from: package-private */
    public Spliterator lazySpliterator(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator.OfLong(supplier);
    }

    public final LongStream limit(long j) {
        if (j >= 0) {
            return SliceOps.makeLong(this, 0, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    /* access modifiers changed from: package-private */
    public final Node.Builder makeNodeBuilder(long j, IntFunction intFunction) {
        return Nodes.longBuilder(j);
    }

    public final LongStream map(LongUnaryOperator longUnaryOperator) {
        Objects.requireNonNull(longUnaryOperator);
        return new IntPipeline.C14375(this, (AbstractPipeline) this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, longUnaryOperator);
    }

    public final DoubleStream mapToDouble$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r8) {
        Objects.requireNonNull(r8);
        return new IntPipeline.C14386(this, (AbstractPipeline) this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, r8);
    }

    public final IntStream mapToInt$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r8) {
        Objects.requireNonNull(r8);
        return new IntPipeline.C14353(this, (AbstractPipeline) this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, r8);
    }

    public final Stream mapToObj(LongFunction longFunction) {
        Objects.requireNonNull(longFunction);
        return new IntPipeline.C14364(this, (AbstractPipeline) this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, longFunction);
    }

    public final OptionalLong max() {
        return reduce(LongPipeline$$ExternalSyntheticLambda5.INSTANCE);
    }

    public final OptionalLong min() {
        return reduce(LongPipeline$$ExternalSyntheticLambda6.INSTANCE);
    }

    public final boolean noneMatch$2(C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        return ((Boolean) evaluate(Node.CC.makeLong(r2, MatchOps$MatchKind.NONE))).booleanValue();
    }

    public final LongStream peek(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new IntPipeline.C14375(this, (AbstractPipeline) this, StreamShape.LONG_VALUE, 0, longConsumer);
    }

    public final long reduce(long j, LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return ((Long) evaluate(new ReduceOps$8(StreamShape.LONG_VALUE, longBinaryOperator, j))).longValue();
    }

    public final LongStream skip(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : SliceOps.makeLong(this, j, -1);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    public final LongStream sorted() {
        return new SortedOps$OfLong(this);
    }

    public final Spliterator.OfLong spliterator() {
        return adapt(super.spliterator());
    }

    public final long sum() {
        return ((Long) evaluate(new ReduceOps$8(StreamShape.LONG_VALUE, LongPipeline$$ExternalSyntheticLambda4.INSTANCE, 0))).longValue();
    }

    public final LongSummaryStatistics summaryStatistics() {
        return (LongSummaryStatistics) collect(Collectors$$ExternalSyntheticLambda82.INSTANCE, LongPipeline$$ExternalSyntheticLambda10.INSTANCE, LongPipeline$$ExternalSyntheticLambda0.INSTANCE);
    }

    public final long[] toArray() {
        return (long[]) Nodes.flattenLong((Node.OfLong) evaluateToArrayNode(LongPipeline$$ExternalSyntheticLambda3.INSTANCE)).asPrimitiveArray();
    }

    public BaseStream unordered() {
        return !isOrdered() ? this : new IntPipeline.C14321(this, (AbstractPipeline) this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_ORDERED);
    }

    /* access modifiers changed from: package-private */
    public final Spliterator wrap(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        return new StreamSpliterators$LongWrappingSpliterator(pipelineHelper, supplier, z);
    }

    public final OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return (OptionalLong) evaluate(new ReduceOps$2(StreamShape.LONG_VALUE, longBinaryOperator));
    }
}
