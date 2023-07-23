package p009j$.util.stream;

import p009j$.util.Spliterator;
import p009j$.util.function.IntFunction;
import p009j$.util.stream.DoublePipeline;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.LongPipeline;
import p009j$.util.stream.Node;
import p009j$.util.stream.ReferencePipeline;
import p009j$.util.stream.Sink;
import p009j$.util.stream.StreamSpliterators$SliceSpliterator;
import p009j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator;

/* renamed from: j$.util.stream.SliceOps */
abstract class SliceOps {

    /* renamed from: j$.util.stream.SliceOps$5 */
    abstract /* synthetic */ class C14515 {
        static final /* synthetic */ int[] $SwitchMap$java$util$stream$StreamShape;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                j$.util.stream.StreamShape[] r0 = p009j$.util.stream.StreamShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$util$stream$StreamShape = r0
                j$.util.stream.StreamShape r1 = p009j$.util.stream.StreamShape.REFERENCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$util$stream$StreamShape     // Catch:{ NoSuchFieldError -> 0x001d }
                j$.util.stream.StreamShape r1 = p009j$.util.stream.StreamShape.INT_VALUE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$util$stream$StreamShape     // Catch:{ NoSuchFieldError -> 0x0028 }
                j$.util.stream.StreamShape r1 = p009j$.util.stream.StreamShape.LONG_VALUE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$util$stream$StreamShape     // Catch:{ NoSuchFieldError -> 0x0033 }
                j$.util.stream.StreamShape r1 = p009j$.util.stream.StreamShape.DOUBLE_VALUE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.SliceOps.C14515.<clinit>():void");
        }
    }

    /* renamed from: j$.util.stream.SliceOps$SliceTask */
    final class SliceTask extends AbstractShortCircuitTask {
        private volatile boolean completed;
        private final IntFunction generator;

        /* renamed from: op */
        private final AbstractPipeline f247op;
        private final long targetOffset;
        private final long targetSize;
        private long thisNodeSize;

        SliceTask(AbstractPipeline abstractPipeline, PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction, long j, long j2) {
            super(pipelineHelper, spliterator);
            this.f247op = abstractPipeline;
            this.generator = intFunction;
            this.targetOffset = j;
            this.targetSize = j2;
        }

        SliceTask(SliceTask sliceTask, Spliterator spliterator) {
            super((AbstractShortCircuitTask) sliceTask, spliterator);
            this.f247op = sliceTask.f247op;
            this.generator = sliceTask.generator;
            this.targetOffset = sliceTask.targetOffset;
            this.targetSize = sliceTask.targetSize;
        }

        private long completedSize(long j) {
            if (this.completed) {
                return this.thisNodeSize;
            }
            SliceTask sliceTask = (SliceTask) this.leftChild;
            SliceTask sliceTask2 = (SliceTask) this.rightChild;
            if (sliceTask == null || sliceTask2 == null) {
                return this.thisNodeSize;
            }
            long completedSize = sliceTask.completedSize(j);
            return completedSize >= j ? completedSize : completedSize + sliceTask2.completedSize(j);
        }

        /* access modifiers changed from: protected */
        public void cancel() {
            this.canceled = true;
            if (this.completed) {
                setLocalResult(getEmptyResult());
            }
        }

        /* access modifiers changed from: protected */
        public Object doLeaf() {
            long j = -1;
            if (isRoot()) {
                if (StreamOpFlag.SIZED.isPreserved(this.f247op.sourceOrOpFlags)) {
                    j = this.f247op.exactOutputSizeIfKnown(this.spliterator);
                }
                Node.Builder makeNodeBuilder = this.f247op.makeNodeBuilder(j, this.generator);
                Sink opWrapSink = this.f247op.opWrapSink(this.helper.getStreamAndOpFlags(), makeNodeBuilder);
                PipelineHelper pipelineHelper = this.helper;
                pipelineHelper.copyIntoWithCancel(pipelineHelper.wrapSink(opWrapSink), this.spliterator);
                return makeNodeBuilder.build();
            }
            PipelineHelper pipelineHelper2 = this.helper;
            Node.Builder makeNodeBuilder2 = pipelineHelper2.makeNodeBuilder(-1, this.generator);
            pipelineHelper2.wrapAndCopyInto(makeNodeBuilder2, this.spliterator);
            Node build = makeNodeBuilder2.build();
            this.thisNodeSize = build.count();
            this.completed = true;
            this.spliterator = null;
            return build;
        }

        /* access modifiers changed from: protected */
        public final Node getEmptyResult() {
            return Nodes.emptyNode(this.f247op.getOutputShape());
        }

        /* access modifiers changed from: protected */
        public AbstractTask makeChild(Spliterator spliterator) {
            return new SliceTask(this, spliterator);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0065  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCompletion(java.util.concurrent.CountedCompleter r12) {
            /*
                r11 = this;
                boolean r12 = r11.isLeaf()
                r0 = 1
                r1 = 0
                if (r12 != 0) goto L_0x0089
                j$.util.stream.AbstractTask r12 = r11.leftChild
                j$.util.stream.SliceOps$SliceTask r12 = (p009j$.util.stream.SliceOps.SliceTask) r12
                long r3 = r12.thisNodeSize
                j$.util.stream.AbstractTask r12 = r11.rightChild
                j$.util.stream.SliceOps$SliceTask r12 = (p009j$.util.stream.SliceOps.SliceTask) r12
                long r5 = r12.thisNodeSize
                long r3 = r3 + r5
                r11.thisNodeSize = r3
                boolean r12 = r11.canceled
                if (r12 == 0) goto L_0x0024
                r11.thisNodeSize = r1
            L_0x001e:
                j$.util.stream.Node r12 = r11.getEmptyResult()
            L_0x0022:
                r3 = r12
                goto L_0x005f
            L_0x0024:
                long r3 = r11.thisNodeSize
                int r12 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r12 != 0) goto L_0x002b
                goto L_0x001e
            L_0x002b:
                j$.util.stream.AbstractTask r12 = r11.leftChild
                j$.util.stream.SliceOps$SliceTask r12 = (p009j$.util.stream.SliceOps.SliceTask) r12
                long r3 = r12.thisNodeSize
                int r12 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r12 != 0) goto L_0x0040
                j$.util.stream.AbstractTask r12 = r11.rightChild
                j$.util.stream.SliceOps$SliceTask r12 = (p009j$.util.stream.SliceOps.SliceTask) r12
                java.lang.Object r12 = r12.getLocalResult()
                j$.util.stream.Node r12 = (p009j$.util.stream.Node) r12
                goto L_0x0022
            L_0x0040:
                j$.util.stream.AbstractPipeline r12 = r11.f247op
                j$.util.stream.StreamShape r12 = r12.getOutputShape()
                j$.util.stream.AbstractTask r3 = r11.leftChild
                j$.util.stream.SliceOps$SliceTask r3 = (p009j$.util.stream.SliceOps.SliceTask) r3
                java.lang.Object r3 = r3.getLocalResult()
                j$.util.stream.Node r3 = (p009j$.util.stream.Node) r3
                j$.util.stream.AbstractTask r4 = r11.rightChild
                j$.util.stream.SliceOps$SliceTask r4 = (p009j$.util.stream.SliceOps.SliceTask) r4
                java.lang.Object r4 = r4.getLocalResult()
                j$.util.stream.Node r4 = (p009j$.util.stream.Node) r4
                j$.util.stream.Node r12 = p009j$.util.stream.Nodes.conc(r12, r3, r4)
                goto L_0x0022
            L_0x005f:
                boolean r12 = r11.isRoot()
                if (r12 == 0) goto L_0x0084
                long r4 = r11.targetSize
                int r12 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r12 < 0) goto L_0x0079
                long r4 = r3.count()
                long r6 = r11.targetOffset
                long r8 = r11.targetSize
                long r6 = r6 + r8
                long r4 = java.lang.Math.min(r4, r6)
                goto L_0x007b
            L_0x0079:
                long r4 = r11.thisNodeSize
            L_0x007b:
                r6 = r4
                long r4 = r11.targetOffset
                j$.util.function.IntFunction r8 = r11.generator
                j$.util.stream.Node r3 = r3.truncate(r4, r6, r8)
            L_0x0084:
                r11.setLocalResult(r3)
                r11.completed = r0
            L_0x0089:
                long r3 = r11.targetSize
                int r12 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r12 < 0) goto L_0x00dc
                boolean r12 = r11.isRoot()
                if (r12 != 0) goto L_0x00dc
                long r1 = r11.targetOffset
                long r3 = r11.targetSize
                long r1 = r1 + r3
                boolean r12 = r11.completed
                if (r12 == 0) goto L_0x00a1
                long r3 = r11.thisNodeSize
                goto L_0x00a5
            L_0x00a1:
                long r3 = r11.completedSize(r1)
            L_0x00a5:
                int r12 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r12 < 0) goto L_0x00aa
                goto L_0x00d7
            L_0x00aa:
                j$.util.stream.AbstractTask r12 = r11.getParent()
                j$.util.stream.SliceOps$SliceTask r12 = (p009j$.util.stream.SliceOps.SliceTask) r12
                r5 = r11
            L_0x00b1:
                if (r12 == 0) goto L_0x00d1
                j$.util.stream.AbstractTask r6 = r12.rightChild
                if (r5 != r6) goto L_0x00c7
                j$.util.stream.AbstractTask r5 = r12.leftChild
                j$.util.stream.SliceOps$SliceTask r5 = (p009j$.util.stream.SliceOps.SliceTask) r5
                if (r5 == 0) goto L_0x00c7
                long r5 = r5.completedSize(r1)
                long r3 = r3 + r5
                int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r5 < 0) goto L_0x00c7
                goto L_0x00d7
            L_0x00c7:
                j$.util.stream.AbstractTask r5 = r12.getParent()
                j$.util.stream.SliceOps$SliceTask r5 = (p009j$.util.stream.SliceOps.SliceTask) r5
                r10 = r5
                r5 = r12
                r12 = r10
                goto L_0x00b1
            L_0x00d1:
                int r12 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r12 < 0) goto L_0x00d6
                goto L_0x00d7
            L_0x00d6:
                r0 = 0
            L_0x00d7:
                if (r0 == 0) goto L_0x00dc
                r11.cancelLaterNodes()
            L_0x00dc:
                r12 = 0
                r11.spliterator = r12
                r11.rightChild = r12
                r11.leftChild = r12
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.SliceOps.SliceTask.onCompletion(java.util.concurrent.CountedCompleter):void");
        }
    }

    static Spliterator access$200(StreamShape streamShape, Spliterator spliterator, long j, long j2) {
        long calcSliceFence = calcSliceFence(j, j2);
        int i = C14515.$SwitchMap$java$util$stream$StreamShape[streamShape.ordinal()];
        if (i == 1) {
            return new StreamSpliterators$SliceSpliterator.OfRef(spliterator, j, calcSliceFence);
        }
        if (i == 2) {
            return new StreamSpliterators$SliceSpliterator.OfInt((Spliterator.OfInt) spliterator, j, calcSliceFence);
        }
        if (i == 3) {
            return new StreamSpliterators$SliceSpliterator.OfLong((Spliterator.OfLong) spliterator, j, calcSliceFence);
        }
        if (i == 4) {
            return new StreamSpliterators$SliceSpliterator.OfDouble((Spliterator.OfDouble) spliterator, j, calcSliceFence);
        }
        throw new IllegalStateException("Unknown shape " + streamShape);
    }

    static long access$300(long j, long j2, long j3) {
        if (j >= 0) {
            return Math.max(-1, Math.min(j - j2, j3));
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static long calcSliceFence(long j, long j2) {
        long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
        if (j3 >= 0) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    private static int flags(long j) {
        return (j != -1 ? StreamOpFlag.IS_SHORT_CIRCUIT : 0) | StreamOpFlag.NOT_SIZED;
    }

    public static DoubleStream makeDouble(AbstractPipeline abstractPipeline, long j, long j2) {
        if (j >= 0) {
            final long j3 = j;
            final long j4 = j2;
            return new DoublePipeline.StatefulOp(abstractPipeline, StreamShape.DOUBLE_VALUE, flags(j2)) {
                /* access modifiers changed from: package-private */
                public Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
                    long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    if (exactOutputSizeIfKnown <= 0) {
                        PipelineHelper pipelineHelper2 = pipelineHelper;
                        Spliterator spliterator2 = spliterator;
                    } else if (spliterator.hasCharacteristics(16384)) {
                        return Nodes.collectDouble(pipelineHelper, SliceOps.access$200(pipelineHelper.getSourceShape(), spliterator, j3, j4), true);
                    } else {
                        PipelineHelper pipelineHelper3 = pipelineHelper;
                    }
                    if (!StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                        return Nodes.collectDouble(this, unorderedSkipLimitSpliterator((Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), j3, j4, exactOutputSizeIfKnown), true);
                    }
                    return (Node) new SliceTask(this, pipelineHelper, spliterator, intFunction, j3, j4).invoke();
                }

                /* access modifiers changed from: package-private */
                public Spliterator opEvaluateParallelLazy(PipelineHelper pipelineHelper, Spliterator spliterator) {
                    long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    if (exactOutputSizeIfKnown <= 0) {
                        Spliterator spliterator2 = spliterator;
                    } else if (spliterator.hasCharacteristics(16384)) {
                        long j = j3;
                        return new StreamSpliterators$SliceSpliterator.OfDouble((Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), j, SliceOps.calcSliceFence(j, j4));
                    }
                    if (!StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                        return unorderedSkipLimitSpliterator((Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), j3, j4, exactOutputSizeIfKnown);
                    }
                    return ((Node) new SliceTask(this, pipelineHelper, spliterator, SliceOps$4$$ExternalSyntheticLambda0.INSTANCE, j3, j4).invoke()).spliterator();
                }

                /* access modifiers changed from: package-private */
                public Sink opWrapSink(int i, Sink sink) {
                    return new Sink.ChainedDouble(sink) {

                        /* renamed from: m */
                        long f245m;

                        /* renamed from: n */
                        long f246n;

                        {
                            this.f246n = j3;
                            long j = j4;
                            this.f245m = j < 0 ? Long.MAX_VALUE : j;
                        }

                        public void accept(double d) {
                            long j = this.f246n;
                            if (j == 0) {
                                long j2 = this.f245m;
                                if (j2 > 0) {
                                    this.f245m = j2 - 1;
                                    this.downstream.accept(d);
                                    return;
                                }
                                return;
                            }
                            this.f246n = j - 1;
                        }

                        public void begin(long j) {
                            this.downstream.begin(SliceOps.access$300(j, j3, this.f245m));
                        }

                        public boolean cancellationRequested() {
                            return this.f245m == 0 || this.downstream.cancellationRequested();
                        }
                    };
                }

                /* access modifiers changed from: package-private */
                public Spliterator.OfDouble unorderedSkipLimitSpliterator(Spliterator.OfDouble ofDouble, long j, long j2, long j3) {
                    long j4;
                    long j5;
                    if (j <= j3) {
                        long j6 = j3 - j;
                        j4 = j2 >= 0 ? Math.min(j2, j6) : j6;
                        j5 = 0;
                    } else {
                        j5 = j;
                        j4 = j2;
                    }
                    return new StreamSpliterators$UnorderedSliceSpliterator.OfDouble(ofDouble, j5, j4);
                }
            };
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static IntStream makeInt(AbstractPipeline abstractPipeline, long j, long j2) {
        if (j >= 0) {
            final long j3 = j;
            final long j4 = j2;
            return new IntPipeline.StatefulOp(abstractPipeline, StreamShape.INT_VALUE, flags(j2)) {
                /* access modifiers changed from: package-private */
                public Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
                    long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    if (exactOutputSizeIfKnown <= 0) {
                        PipelineHelper pipelineHelper2 = pipelineHelper;
                        Spliterator spliterator2 = spliterator;
                    } else if (spliterator.hasCharacteristics(16384)) {
                        return Nodes.collectInt(pipelineHelper, SliceOps.access$200(pipelineHelper.getSourceShape(), spliterator, j3, j4), true);
                    } else {
                        PipelineHelper pipelineHelper3 = pipelineHelper;
                    }
                    if (!StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                        return Nodes.collectInt(this, unorderedSkipLimitSpliterator((Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), j3, j4, exactOutputSizeIfKnown), true);
                    }
                    return (Node) new SliceTask(this, pipelineHelper, spliterator, intFunction, j3, j4).invoke();
                }

                /* access modifiers changed from: package-private */
                public Spliterator opEvaluateParallelLazy(PipelineHelper pipelineHelper, Spliterator spliterator) {
                    long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    if (exactOutputSizeIfKnown <= 0) {
                        Spliterator spliterator2 = spliterator;
                    } else if (spliterator.hasCharacteristics(16384)) {
                        long j = j3;
                        return new StreamSpliterators$SliceSpliterator.OfInt((Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), j, SliceOps.calcSliceFence(j, j4));
                    }
                    if (!StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                        return unorderedSkipLimitSpliterator((Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), j3, j4, exactOutputSizeIfKnown);
                    }
                    return ((Node) new SliceTask(this, pipelineHelper, spliterator, SliceOps$2$$ExternalSyntheticLambda0.INSTANCE, j3, j4).invoke()).spliterator();
                }

                /* access modifiers changed from: package-private */
                public Sink opWrapSink(int i, Sink sink) {
                    return new Sink.ChainedInt(sink) {

                        /* renamed from: m */
                        long f241m;

                        /* renamed from: n */
                        long f242n;

                        {
                            this.f242n = j3;
                            long j = j4;
                            this.f241m = j < 0 ? Long.MAX_VALUE : j;
                        }

                        public void accept(int i) {
                            long j = this.f242n;
                            if (j == 0) {
                                long j2 = this.f241m;
                                if (j2 > 0) {
                                    this.f241m = j2 - 1;
                                    this.downstream.accept(i);
                                    return;
                                }
                                return;
                            }
                            this.f242n = j - 1;
                        }

                        public void begin(long j) {
                            this.downstream.begin(SliceOps.access$300(j, j3, this.f241m));
                        }

                        public boolean cancellationRequested() {
                            return this.f241m == 0 || this.downstream.cancellationRequested();
                        }
                    };
                }

                /* access modifiers changed from: package-private */
                public Spliterator.OfInt unorderedSkipLimitSpliterator(Spliterator.OfInt ofInt, long j, long j2, long j3) {
                    long j4;
                    long j5;
                    if (j <= j3) {
                        long j6 = j3 - j;
                        j4 = j2 >= 0 ? Math.min(j2, j6) : j6;
                        j5 = 0;
                    } else {
                        j5 = j;
                        j4 = j2;
                    }
                    return new StreamSpliterators$UnorderedSliceSpliterator.OfInt(ofInt, j5, j4);
                }
            };
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static LongStream makeLong(AbstractPipeline abstractPipeline, long j, long j2) {
        if (j >= 0) {
            final long j3 = j;
            final long j4 = j2;
            return new LongPipeline.StatefulOp(abstractPipeline, StreamShape.LONG_VALUE, flags(j2)) {
                /* access modifiers changed from: package-private */
                public Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
                    long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    if (exactOutputSizeIfKnown <= 0) {
                        PipelineHelper pipelineHelper2 = pipelineHelper;
                        Spliterator spliterator2 = spliterator;
                    } else if (spliterator.hasCharacteristics(16384)) {
                        return Nodes.collectLong(pipelineHelper, SliceOps.access$200(pipelineHelper.getSourceShape(), spliterator, j3, j4), true);
                    } else {
                        PipelineHelper pipelineHelper3 = pipelineHelper;
                    }
                    if (!StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                        return Nodes.collectLong(this, unorderedSkipLimitSpliterator((Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), j3, j4, exactOutputSizeIfKnown), true);
                    }
                    return (Node) new SliceTask(this, pipelineHelper, spliterator, intFunction, j3, j4).invoke();
                }

                /* access modifiers changed from: package-private */
                public Spliterator opEvaluateParallelLazy(PipelineHelper pipelineHelper, Spliterator spliterator) {
                    long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    if (exactOutputSizeIfKnown <= 0) {
                        Spliterator spliterator2 = spliterator;
                    } else if (spliterator.hasCharacteristics(16384)) {
                        long j = j3;
                        return new StreamSpliterators$SliceSpliterator.OfLong((Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), j, SliceOps.calcSliceFence(j, j4));
                    }
                    if (!StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                        return unorderedSkipLimitSpliterator((Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), j3, j4, exactOutputSizeIfKnown);
                    }
                    return ((Node) new SliceTask(this, pipelineHelper, spliterator, SliceOps$3$$ExternalSyntheticLambda0.INSTANCE, j3, j4).invoke()).spliterator();
                }

                /* access modifiers changed from: package-private */
                public Sink opWrapSink(int i, Sink sink) {
                    return new Sink.ChainedLong(sink) {

                        /* renamed from: m */
                        long f243m;

                        /* renamed from: n */
                        long f244n;

                        {
                            this.f244n = j3;
                            long j = j4;
                            this.f243m = j < 0 ? Long.MAX_VALUE : j;
                        }

                        public void accept(long j) {
                            long j2 = this.f244n;
                            if (j2 == 0) {
                                long j3 = this.f243m;
                                if (j3 > 0) {
                                    this.f243m = j3 - 1;
                                    this.downstream.accept(j);
                                    return;
                                }
                                return;
                            }
                            this.f244n = j2 - 1;
                        }

                        public void begin(long j) {
                            this.downstream.begin(SliceOps.access$300(j, j3, this.f243m));
                        }

                        public boolean cancellationRequested() {
                            return this.f243m == 0 || this.downstream.cancellationRequested();
                        }
                    };
                }

                /* access modifiers changed from: package-private */
                public Spliterator.OfLong unorderedSkipLimitSpliterator(Spliterator.OfLong ofLong, long j, long j2, long j3) {
                    long j4;
                    long j5;
                    if (j <= j3) {
                        long j6 = j3 - j;
                        j4 = j2 >= 0 ? Math.min(j2, j6) : j6;
                        j5 = 0;
                    } else {
                        j5 = j;
                        j4 = j2;
                    }
                    return new StreamSpliterators$UnorderedSliceSpliterator.OfLong(ofLong, j5, j4);
                }
            };
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static Stream makeRef(AbstractPipeline abstractPipeline, long j, long j2) {
        if (j >= 0) {
            final long j3 = j;
            final long j4 = j2;
            return new ReferencePipeline.StatefulOp(abstractPipeline, StreamShape.REFERENCE, flags(j2)) {
                /* access modifiers changed from: package-private */
                public Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
                    IntFunction intFunction2 = intFunction;
                    long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    if (exactOutputSizeIfKnown <= 0) {
                        PipelineHelper pipelineHelper2 = pipelineHelper;
                        Spliterator spliterator2 = spliterator;
                    } else if (spliterator.hasCharacteristics(16384)) {
                        return Nodes.collect(pipelineHelper, SliceOps.access$200(pipelineHelper.getSourceShape(), spliterator, j3, j4), true, intFunction2);
                    } else {
                        PipelineHelper pipelineHelper3 = pipelineHelper;
                    }
                    if (!StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                        return Nodes.collect(this, unorderedSkipLimitSpliterator(pipelineHelper.wrapSpliterator(spliterator), j3, j4, exactOutputSizeIfKnown), true, intFunction2);
                    }
                    return (Node) new SliceTask(this, pipelineHelper, spliterator, intFunction, j3, j4).invoke();
                }

                /* access modifiers changed from: package-private */
                public Spliterator opEvaluateParallelLazy(PipelineHelper pipelineHelper, Spliterator spliterator) {
                    long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    if (exactOutputSizeIfKnown <= 0) {
                        Spliterator spliterator2 = spliterator;
                    } else if (spliterator.hasCharacteristics(16384)) {
                        Spliterator wrapSpliterator = pipelineHelper.wrapSpliterator(spliterator);
                        long j = j3;
                        return new StreamSpliterators$SliceSpliterator.OfRef(wrapSpliterator, j, SliceOps.calcSliceFence(j, j4));
                    }
                    if (!StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                        return unorderedSkipLimitSpliterator(pipelineHelper.wrapSpliterator(spliterator), j3, j4, exactOutputSizeIfKnown);
                    }
                    return ((Node) new SliceTask(this, pipelineHelper, spliterator, SliceOps$$ExternalSyntheticLambda0.INSTANCE, j3, j4).invoke()).spliterator();
                }

                /* access modifiers changed from: package-private */
                public Sink opWrapSink(int i, Sink sink) {
                    return new Sink.ChainedReference(sink) {

                        /* renamed from: m */
                        long f239m;

                        /* renamed from: n */
                        long f240n;

                        {
                            this.f240n = j3;
                            long j = j4;
                            this.f239m = j < 0 ? Long.MAX_VALUE : j;
                        }

                        public void accept(Object obj) {
                            long j = this.f240n;
                            if (j == 0) {
                                long j2 = this.f239m;
                                if (j2 > 0) {
                                    this.f239m = j2 - 1;
                                    this.downstream.accept(obj);
                                    return;
                                }
                                return;
                            }
                            this.f240n = j - 1;
                        }

                        public void begin(long j) {
                            this.downstream.begin(SliceOps.access$300(j, j3, this.f239m));
                        }

                        public boolean cancellationRequested() {
                            return this.f239m == 0 || this.downstream.cancellationRequested();
                        }
                    };
                }

                /* access modifiers changed from: package-private */
                public Spliterator unorderedSkipLimitSpliterator(Spliterator spliterator, long j, long j2, long j3) {
                    long j4;
                    long j5;
                    if (j <= j3) {
                        long j6 = j3 - j;
                        j4 = j2 >= 0 ? Math.min(j2, j6) : j6;
                        j5 = 0;
                    } else {
                        j5 = j;
                        j4 = j2;
                    }
                    return new StreamSpliterators$UnorderedSliceSpliterator.OfRef(spliterator, j5, j4);
                }
            };
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }
}
