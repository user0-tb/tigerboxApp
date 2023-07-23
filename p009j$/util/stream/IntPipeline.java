package p009j$.util.stream;

import java.util.Iterator;
import java.util.Objects;
import p009j$.lang.Iterable$CC$$IA$1;
import p009j$.lang.Iterable$CC$$IA$2;
import p009j$.lang.Iterable$CC$$IA$3;
import p009j$.util.IntSummaryStatistics;
import p009j$.util.OptionalDouble;
import p009j$.util.OptionalInt;
import p009j$.util.PrimitiveIterator;
import p009j$.util.Spliterator;
import p009j$.util.Spliterators;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.DoubleFunction;
import p009j$.util.function.DoubleToLongFunction;
import p009j$.util.function.Function;
import p009j$.util.function.IntBinaryOperator;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.IntFunction;
import p009j$.util.function.IntToLongFunction;
import p009j$.util.function.LongConsumer;
import p009j$.util.function.LongFunction;
import p009j$.util.function.LongUnaryOperator;
import p009j$.util.function.ObjIntConsumer;
import p009j$.util.function.Predicate;
import p009j$.util.function.Supplier;
import p009j$.util.function.ToDoubleFunction;
import p009j$.util.function.ToIntFunction;
import p009j$.util.function.ToLongFunction;
import p009j$.util.stream.DistinctOps$1;
import p009j$.util.stream.DoublePipeline;
import p009j$.util.stream.ForEachOps$ForEachOp;
import p009j$.util.stream.LongPipeline;
import p009j$.util.stream.Node;
import p009j$.util.stream.ReferencePipeline;
import p009j$.util.stream.Sink;
import p009j$.util.stream.StreamSpliterators$DelegatingSpliterator;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.IntPipeline */
abstract class IntPipeline extends AbstractPipeline implements IntStream {

    /* renamed from: j$.util.stream.IntPipeline$1 */
    class C14321 extends LongPipeline.StatelessOp {
        public final /* synthetic */ int $r8$classId = 0;

        /* renamed from: j$.util.stream.IntPipeline$1$1 */
        class C14331 extends Sink.ChainedInt {
            public final /* synthetic */ int $r8$classId = 0;
            final /* synthetic */ Object this$1;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C14331(C14321 r2, Sink sink) {
                super(sink);
                this.this$1 = r2;
            }

            public void accept(int i) {
                switch (this.$r8$classId) {
                    case 0:
                        this.downstream.accept((long) i);
                        return;
                    case 1:
                        ((IntConsumer) ((C14353) this.this$1).val$mapper).accept(i);
                        this.downstream.accept(i);
                        return;
                    case 2:
                        this.downstream.accept((double) i);
                        return;
                    case 3:
                        this.downstream.accept(((C$r8$wrapper$java$util$function$IntPredicate$VWRP) ((C14353) this.this$1).val$mapper).applyAsInt(i));
                        return;
                    case 4:
                        this.downstream.accept(((IntFunction) ((C14364) this.this$1).val$mapper).apply(i));
                        return;
                    case 5:
                        this.downstream.accept(((IntToLongFunction) ((C14375) this.this$1).val$mapper).applyAsLong(i));
                        return;
                    case 6:
                        this.downstream.accept(((C$r8$wrapper$java$util$function$IntPredicate$VWRP) ((C14386) this.this$1).val$mapper).applyAsDouble(i));
                        return;
                    case 7:
                        IntStream intStream = (IntStream) ((IntFunction) ((C14353) this.this$1).val$mapper).apply(i);
                        if (intStream != null) {
                            try {
                                intStream.sequential().forEach(new IntPipeline$$ExternalSyntheticLambda6(this));
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                                break;
                            }
                        }
                        if (intStream != null) {
                            intStream.close();
                            return;
                        }
                        return;
                    default:
                        if (((C$r8$wrapper$java$util$function$IntPredicate$VWRP) ((C14353) this.this$1).val$mapper).test(i)) {
                            this.downstream.accept(i);
                            return;
                        }
                        return;
                }
                throw th;
            }

            public void begin(long j) {
                switch (this.$r8$classId) {
                    case 7:
                        this.downstream.begin(-1);
                        return;
                    case 8:
                        this.downstream.begin(-1);
                        return;
                    default:
                        this.downstream.begin(j);
                        return;
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C14331(C14342 r2, Sink sink) {
                super(sink);
                this.this$1 = r2;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C14331(C14353 r2, Sink sink) {
                super(sink);
                this.this$1 = r2;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C14331(C14353 r1, Sink sink, Iterable$CC$$IA$1 r3) {
                super(sink);
                this.this$1 = r1;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C14331(C14353 r1, Sink sink, Iterable$CC$$IA$2 r3) {
                super(sink);
                this.this$1 = r1;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C14331(C14353 r1, Sink sink, Iterable$CC$$IA$3 r3) {
                super(sink);
                this.this$1 = r1;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C14331(C14364 r2, Sink sink) {
                super(sink);
                this.this$1 = r2;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C14331(C14375 r2, Sink sink) {
                super(sink);
                this.this$1 = r2;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C14331(C14386 r2, Sink sink) {
                super(sink);
                this.this$1 = r2;
            }
        }

        public C14321(IntPipeline intPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, streamShape, i);
        }

        /* access modifiers changed from: package-private */
        public Sink opWrapSink(int i, Sink sink) {
            switch (this.$r8$classId) {
                case 0:
                    return new C14331(this, sink);
                default:
                    return sink;
            }
        }

        public C14321(LongPipeline longPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, streamShape, i);
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$2 */
    class C14342 extends DoublePipeline.StatelessOp {
        public final /* synthetic */ int $r8$classId = 1;

        public C14342(DoublePipeline doublePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, streamShape, i);
        }

        /* access modifiers changed from: package-private */
        public Sink opWrapSink(int i, Sink sink) {
            switch (this.$r8$classId) {
                case 0:
                    return new C14321.C14331(this, sink);
                case 1:
                    return sink;
                default:
                    return new LongPipeline$1$1(this, sink);
            }
        }

        public C14342(IntPipeline intPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, streamShape, i);
        }

        public C14342(LongPipeline longPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, streamShape, i);
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$3 */
    class C14353 extends StatelessOp {
        public final /* synthetic */ int $r8$classId = 1;
        final /* synthetic */ Object val$mapper;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14353(DoublePipeline doublePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, C$r8$wrapper$java$util$function$IntPredicate$VWRP r5) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = r5;
        }

        /* access modifiers changed from: package-private */
        public Sink opWrapSink(int i, Sink sink) {
            switch (this.$r8$classId) {
                case 0:
                    return new C14321.C14331(this, sink, (Iterable$CC$$IA$1) null);
                case 1:
                    return new DoublePipeline$1$1(this, sink);
                case 2:
                    return new C14321.C14331(this, sink);
                case 3:
                    return new C14321.C14331(this, sink, (Iterable$CC$$IA$2) null);
                case 4:
                    return new C14321.C14331(this, sink, (Iterable$CC$$IA$3) null);
                case 5:
                    return new LongPipeline$1$1(this, sink);
                case 6:
                    return new ReferencePipeline$2$1(this, sink);
                default:
                    return new DistinctOps$1.C14312(this, sink);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14353(IntPipeline intPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, IntConsumer intConsumer) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = intConsumer;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14353(IntPipeline intPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, IntFunction intFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = intFunction;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14353(IntPipeline intPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, C$r8$wrapper$java$util$function$IntPredicate$VWRP r5) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = r5;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14353(IntPipeline intPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, C$r8$wrapper$java$util$function$IntPredicate$VWRP r5, Iterable$CC$$IA$1 r6) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = r5;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14353(LongPipeline longPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, C$r8$wrapper$java$util$function$IntPredicate$VWRP r5) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = r5;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14353(ReferencePipeline referencePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, Function function) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = function;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14353(ReferencePipeline referencePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, ToIntFunction toIntFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = toIntFunction;
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$4 */
    class C14364 extends ReferencePipeline.StatelessOp {
        public final /* synthetic */ int $r8$classId = 1;
        final /* synthetic */ Object val$mapper;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14364(DoublePipeline doublePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, DoubleFunction doubleFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = doubleFunction;
        }

        /* access modifiers changed from: package-private */
        public Sink opWrapSink(int i, Sink sink) {
            switch (this.$r8$classId) {
                case 0:
                    return new C14321.C14331(this, sink);
                case 1:
                    return new DoublePipeline$1$1(this, sink);
                case 2:
                    return new LongPipeline$1$1(this, sink);
                case 3:
                    return new ReferencePipeline$2$1(this, sink);
                default:
                    return new ReferencePipeline$2$1(this, sink, (Iterable$CC$$IA$1) null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14364(IntPipeline intPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, IntFunction intFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = intFunction;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14364(LongPipeline longPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, LongFunction longFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = longFunction;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14364(ReferencePipeline referencePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, Consumer consumer) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = consumer;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14364(ReferencePipeline referencePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, Predicate predicate) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = predicate;
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$5 */
    class C14375 extends LongPipeline.StatelessOp {
        public final /* synthetic */ int $r8$classId = 1;
        final /* synthetic */ Object val$mapper;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14375(DoublePipeline doublePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, DoubleToLongFunction doubleToLongFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = doubleToLongFunction;
        }

        /* access modifiers changed from: package-private */
        public Sink opWrapSink(int i, Sink sink) {
            switch (this.$r8$classId) {
                case 0:
                    return new C14321.C14331(this, sink);
                case 1:
                    return new DoublePipeline$1$1(this, sink);
                case 2:
                    return new LongPipeline$1$1(this, sink);
                case 3:
                    return new LongPipeline$1$1(this, sink, (Iterable$CC$$IA$1) null);
                case 4:
                    return new LongPipeline$1$1(this, sink, (Iterable$CC$$IA$2) null);
                case 5:
                    return new LongPipeline$1$1(this, sink, (Iterable$CC$$IA$3) null);
                case 6:
                    return new DistinctOps$1.C14312(this, sink);
                default:
                    return new ReferencePipeline$2$1(this, sink);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14375(IntPipeline intPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, IntToLongFunction intToLongFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = intToLongFunction;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14375(LongPipeline longPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, LongConsumer longConsumer) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = longConsumer;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14375(LongPipeline longPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, LongFunction longFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = longFunction;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14375(LongPipeline longPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, LongUnaryOperator longUnaryOperator) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = longUnaryOperator;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14375(LongPipeline longPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, C$r8$wrapper$java$util$function$IntPredicate$VWRP r5) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = r5;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14375(ReferencePipeline referencePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, Function function) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = function;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14375(ReferencePipeline referencePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, ToLongFunction toLongFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = toLongFunction;
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$6 */
    class C14386 extends DoublePipeline.StatelessOp {
        public final /* synthetic */ int $r8$classId = 4;
        final /* synthetic */ Object val$mapper;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14386(DoublePipeline doublePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, DoubleConsumer doubleConsumer) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = doubleConsumer;
        }

        /* access modifiers changed from: package-private */
        public Sink opWrapSink(int i, Sink sink) {
            switch (this.$r8$classId) {
                case 0:
                    return new C14321.C14331(this, sink);
                case 1:
                    return new DoublePipeline$1$1(this, sink);
                case 2:
                    return new DoublePipeline$1$1(this, sink, (Iterable$CC$$IA$1) null);
                case 3:
                    return new DoublePipeline$1$1(this, sink, (Iterable$CC$$IA$2) null);
                case 4:
                    return new DoublePipeline$1$1(this, sink, (Iterable$CC$$IA$3) null);
                case 5:
                    return new LongPipeline$1$1(this, sink);
                case 6:
                    return new ReferencePipeline$2$1(this, sink);
                default:
                    return new DistinctOps$1.C14312(this, sink);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14386(DoublePipeline doublePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, DoubleFunction doubleFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = doubleFunction;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14386(DoublePipeline doublePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, C$r8$wrapper$java$util$function$IntPredicate$VWRP r5) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = r5;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14386(DoublePipeline doublePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, C$r8$wrapper$java$util$function$IntPredicate$VWRP r5, Iterable$CC$$IA$1 r6) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = r5;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14386(IntPipeline intPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, C$r8$wrapper$java$util$function$IntPredicate$VWRP r5) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = r5;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14386(LongPipeline longPipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, C$r8$wrapper$java$util$function$IntPredicate$VWRP r5) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = r5;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14386(ReferencePipeline referencePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, Function function) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = function;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C14386(ReferencePipeline referencePipeline, AbstractPipeline abstractPipeline, StreamShape streamShape, int i, ToDoubleFunction toDoubleFunction) {
            super(abstractPipeline, streamShape, i);
            this.val$mapper = toDoubleFunction;
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$Head */
    static class Head extends IntPipeline {
        Head(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        public void forEach(IntConsumer intConsumer) {
            if (!isParallel()) {
                IntPipeline.adapt(sourceStageSpliterator()).forEachRemaining(intConsumer);
            } else {
                IntPipeline.super.forEach(intConsumer);
            }
        }

        public void forEachOrdered(IntConsumer intConsumer) {
            if (!isParallel()) {
                IntPipeline.adapt(sourceStageSpliterator()).forEachRemaining(intConsumer);
                return;
            }
            Objects.requireNonNull(intConsumer);
            evaluate(new ForEachOps$ForEachOp.OfInt(intConsumer, true));
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public final Sink opWrapSink(int i, Sink sink) {
            throw new UnsupportedOperationException();
        }

        public /* bridge */ /* synthetic */ IntStream parallel() {
            parallel();
            return this;
        }

        public /* bridge */ /* synthetic */ IntStream sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$StatefulOp */
    abstract class StatefulOp extends IntPipeline {
        StatefulOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            return true;
        }

        public /* bridge */ /* synthetic */ IntStream parallel() {
            parallel();
            return this;
        }

        public /* bridge */ /* synthetic */ IntStream sequential() {
            sequential();
            return this;
        }
    }

    /* renamed from: j$.util.stream.IntPipeline$StatelessOp */
    abstract class StatelessOp extends IntPipeline {
        StatelessOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        /* access modifiers changed from: package-private */
        public final boolean opIsStateful() {
            return false;
        }

        public /* bridge */ /* synthetic */ IntStream parallel() {
            parallel();
            return this;
        }

        public /* bridge */ /* synthetic */ IntStream sequential() {
            sequential();
            return this;
        }
    }

    IntPipeline(Spliterator spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    IntPipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    /* access modifiers changed from: private */
    public static Spliterator.OfInt adapt(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.OfInt) {
            return (Spliterator.OfInt) spliterator;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    public final boolean allMatch$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        return ((Boolean) evaluate(Node.CC.makeInt(r2, MatchOps$MatchKind.ALL))).booleanValue();
    }

    public final boolean anyMatch$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        return ((Boolean) evaluate(Node.CC.makeInt(r2, MatchOps$MatchKind.ANY))).booleanValue();
    }

    public final DoubleStream asDoubleStream() {
        return new C14342(this, (AbstractPipeline) this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT);
    }

    public final LongStream asLongStream() {
        return new C14321(this, (AbstractPipeline) this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT);
    }

    public final OptionalDouble average() {
        long[] jArr = (long[]) collect(IntPipeline$$ExternalSyntheticLambda12.INSTANCE, IntPipeline$$ExternalSyntheticLambda11.INSTANCE, IntPipeline$$ExternalSyntheticLambda1.INSTANCE);
        return jArr[0] > 0 ? OptionalDouble.m202of(((double) jArr[1]) / ((double) jArr[0])) : OptionalDouble.empty();
    }

    public final Stream boxed() {
        return mapToObj(IntPipeline$$ExternalSyntheticLambda7.INSTANCE);
    }

    public final Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        IntPipeline$$ExternalSyntheticLambda2 intPipeline$$ExternalSyntheticLambda2 = new IntPipeline$$ExternalSyntheticLambda2(biConsumer, 0);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objIntConsumer);
        return evaluate(new ReduceOps$1(StreamShape.INT_VALUE, (BinaryOperator) intPipeline$$ExternalSyntheticLambda2, objIntConsumer, supplier));
    }

    public final long count() {
        return ((LongPipeline) mapToLong(IntPipeline$$ExternalSyntheticLambda9.INSTANCE)).sum();
    }

    public final IntStream distinct() {
        return ((ReferencePipeline) mapToObj(IntPipeline$$ExternalSyntheticLambda7.INSTANCE)).distinct().mapToInt(IntPipeline$$ExternalSyntheticLambda13.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public final Node evaluateToNode(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.collectInt(pipelineHelper, spliterator, z);
    }

    public final IntStream filter(C$r8$wrapper$java$util$function$IntPredicate$VWRP r9) {
        Objects.requireNonNull(r9);
        return new C14353(this, this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SIZED, r9, (Iterable$CC$$IA$1) null);
    }

    public final OptionalInt findAny() {
        return (OptionalInt) evaluate(new FindOps$FindOp(false, StreamShape.INT_VALUE, OptionalInt.empty(), FindOps$$ExternalSyntheticLambda2.INSTANCE, FindOps$$ExternalSyntheticLambda5.INSTANCE));
    }

    public final OptionalInt findFirst() {
        return (OptionalInt) evaluate(new FindOps$FindOp(true, StreamShape.INT_VALUE, OptionalInt.empty(), FindOps$$ExternalSyntheticLambda2.INSTANCE, FindOps$$ExternalSyntheticLambda5.INSTANCE));
    }

    public final IntStream flatMap(IntFunction intFunction) {
        return new C14353(this, (AbstractPipeline) this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED, intFunction);
    }

    public void forEach(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        evaluate(new ForEachOps$ForEachOp.OfInt(intConsumer, false));
    }

    public void forEachOrdered(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        evaluate(new ForEachOps$ForEachOp.OfInt(intConsumer, true));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[LOOP:0: B:6:0x0015->B:9:0x001f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void forEachWithCancel(p009j$.util.Spliterator r3, p009j$.util.stream.Sink r4) {
        /*
            r2 = this;
            j$.util.Spliterator$OfInt r3 = adapt(r3)
            boolean r0 = r4 instanceof p009j$.util.function.IntConsumer
            if (r0 == 0) goto L_0x000c
            r0 = r4
            j$.util.function.IntConsumer r0 = (p009j$.util.function.IntConsumer) r0
            goto L_0x0015
        L_0x000c:
            boolean r0 = p009j$.util.stream.Tripwire.ENABLED
            if (r0 != 0) goto L_0x0022
            j$.util.stream.IntPipeline$$ExternalSyntheticLambda6 r0 = new j$.util.stream.IntPipeline$$ExternalSyntheticLambda6
            r0.<init>((p009j$.util.stream.Sink) r4)
        L_0x0015:
            boolean r1 = r4.cancellationRequested()
            if (r1 != 0) goto L_0x0021
            boolean r1 = r3.tryAdvance((p009j$.util.function.IntConsumer) r0)
            if (r1 != 0) goto L_0x0015
        L_0x0021:
            return
        L_0x0022:
            java.lang.Class<j$.util.stream.AbstractPipeline> r3 = p009j$.util.stream.AbstractPipeline.class
            java.lang.String r4 = "using IntStream.adapt(Sink<Integer> s)"
            p009j$.util.stream.Tripwire.trip(r3, r4)
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.IntPipeline.forEachWithCancel(j$.util.Spliterator, j$.util.stream.Sink):void");
    }

    /* access modifiers changed from: package-private */
    public final StreamShape getOutputShape() {
        return StreamShape.INT_VALUE;
    }

    public final PrimitiveIterator.OfInt iterator() {
        return Spliterators.iterator(spliterator());
    }

    /* renamed from: iterator  reason: collision with other method in class */
    public Iterator m743iterator() {
        return Spliterators.iterator(spliterator());
    }

    /* access modifiers changed from: package-private */
    public Spliterator lazySpliterator(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator.OfInt(supplier);
    }

    public final IntStream limit(long j) {
        if (j >= 0) {
            return SliceOps.makeInt(this, 0, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    /* access modifiers changed from: package-private */
    public final Node.Builder makeNodeBuilder(long j, IntFunction intFunction) {
        return Nodes.intBuilder(j);
    }

    public final IntStream map(C$r8$wrapper$java$util$function$IntPredicate$VWRP r8) {
        Objects.requireNonNull(r8);
        return new C14353(this, (AbstractPipeline) this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, r8);
    }

    public final DoubleStream mapToDouble(C$r8$wrapper$java$util$function$IntPredicate$VWRP r8) {
        Objects.requireNonNull(r8);
        return new C14386(this, (AbstractPipeline) this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, r8);
    }

    public final LongStream mapToLong(IntToLongFunction intToLongFunction) {
        Objects.requireNonNull(intToLongFunction);
        return new C14375(this, (AbstractPipeline) this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, intToLongFunction);
    }

    public final Stream mapToObj(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new C14364(this, (AbstractPipeline) this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT, intFunction);
    }

    public final OptionalInt max() {
        return reduce(IntPipeline$$ExternalSyntheticLambda4.INSTANCE);
    }

    public final OptionalInt min() {
        return reduce(IntPipeline$$ExternalSyntheticLambda5.INSTANCE);
    }

    public final boolean noneMatch$1(C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        return ((Boolean) evaluate(Node.CC.makeInt(r2, MatchOps$MatchKind.NONE))).booleanValue();
    }

    public final IntStream peek(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new C14353(this, (AbstractPipeline) this, StreamShape.INT_VALUE, 0, intConsumer);
    }

    public final int reduce(int i, IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return ((Integer) evaluate(new ReduceOps$5(StreamShape.INT_VALUE, intBinaryOperator, i))).intValue();
    }

    public final IntStream skip(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : SliceOps.makeInt(this, j, -1);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    public final IntStream sorted() {
        return new SortedOps$OfInt(this);
    }

    public final Spliterator.OfInt spliterator() {
        return adapt(super.spliterator());
    }

    public final int sum() {
        return ((Integer) evaluate(new ReduceOps$5(StreamShape.INT_VALUE, IntPipeline$$ExternalSyntheticLambda3.INSTANCE, 0))).intValue();
    }

    public final IntSummaryStatistics summaryStatistics() {
        return (IntSummaryStatistics) collect(Collectors$$ExternalSyntheticLambda81.INSTANCE, IntPipeline$$ExternalSyntheticLambda10.INSTANCE, IntPipeline$$ExternalSyntheticLambda0.INSTANCE);
    }

    public final int[] toArray() {
        return (int[]) Nodes.flattenInt((Node.OfInt) evaluateToArrayNode(IntPipeline$$ExternalSyntheticLambda8.INSTANCE)).asPrimitiveArray();
    }

    public BaseStream unordered() {
        return !isOrdered() ? this : new StatelessOp(this, this, StreamShape.INT_VALUE, StreamOpFlag.NOT_ORDERED) {
            /* access modifiers changed from: package-private */
            public Sink opWrapSink(int i, Sink sink) {
                return sink;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final Spliterator wrap(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        return new StreamSpliterators$IntWrappingSpliterator(pipelineHelper, supplier, z);
    }

    public final OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return (OptionalInt) evaluate(new ReduceOps$2(StreamShape.INT_VALUE, intBinaryOperator));
    }
}
