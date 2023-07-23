package p009j$.util.stream;

import java.util.Objects;
import java.util.concurrent.CountedCompleter;
import p009j$.util.Spliterator;
import p009j$.util.concurrent.ConcurrentHashMap;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.ForEachOps$ForEachOrderedTask */
final class ForEachOps$ForEachOrderedTask extends CountedCompleter {
    public static final /* synthetic */ int $r8$clinit = 0;
    private final Sink action;
    private final ConcurrentHashMap completionMap;
    private final PipelineHelper helper;
    private final ForEachOps$ForEachOrderedTask leftPredecessor;
    private Node node;
    private Spliterator spliterator;
    private final long targetSize;

    ForEachOps$ForEachOrderedTask(ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask, Spliterator spliterator2, ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask2) {
        super(forEachOps$ForEachOrderedTask);
        this.helper = forEachOps$ForEachOrderedTask.helper;
        this.spliterator = spliterator2;
        this.targetSize = forEachOps$ForEachOrderedTask.targetSize;
        this.completionMap = forEachOps$ForEachOrderedTask.completionMap;
        this.action = forEachOps$ForEachOrderedTask.action;
        this.leftPredecessor = forEachOps$ForEachOrderedTask2;
    }

    protected ForEachOps$ForEachOrderedTask(PipelineHelper pipelineHelper, Spliterator spliterator2, Sink sink) {
        super((CountedCompleter) null);
        this.helper = pipelineHelper;
        this.spliterator = spliterator2;
        this.targetSize = AbstractTask.suggestTargetSize(spliterator2.estimateSize());
        this.completionMap = new ConcurrentHashMap(Math.max(16, AbstractTask.LEAF_TARGET << 1));
        this.action = sink;
        this.leftPredecessor = null;
    }

    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator2 = this.spliterator;
        long j = this.targetSize;
        boolean z = false;
        ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask = this;
        while (spliterator2.estimateSize() > j && (trySplit = spliterator2.trySplit()) != null) {
            ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask2 = new ForEachOps$ForEachOrderedTask(forEachOps$ForEachOrderedTask, trySplit, forEachOps$ForEachOrderedTask.leftPredecessor);
            ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask3 = new ForEachOps$ForEachOrderedTask(forEachOps$ForEachOrderedTask, spliterator2, forEachOps$ForEachOrderedTask2);
            forEachOps$ForEachOrderedTask.addToPendingCount(1);
            forEachOps$ForEachOrderedTask3.addToPendingCount(1);
            forEachOps$ForEachOrderedTask.completionMap.put(forEachOps$ForEachOrderedTask2, forEachOps$ForEachOrderedTask3);
            if (forEachOps$ForEachOrderedTask.leftPredecessor != null) {
                forEachOps$ForEachOrderedTask2.addToPendingCount(1);
                if (forEachOps$ForEachOrderedTask.completionMap.replace(forEachOps$ForEachOrderedTask.leftPredecessor, forEachOps$ForEachOrderedTask, forEachOps$ForEachOrderedTask2)) {
                    forEachOps$ForEachOrderedTask.addToPendingCount(-1);
                } else {
                    forEachOps$ForEachOrderedTask2.addToPendingCount(-1);
                }
            }
            if (z) {
                spliterator2 = trySplit;
                forEachOps$ForEachOrderedTask = forEachOps$ForEachOrderedTask2;
                forEachOps$ForEachOrderedTask2 = forEachOps$ForEachOrderedTask3;
            } else {
                forEachOps$ForEachOrderedTask = forEachOps$ForEachOrderedTask3;
            }
            z = !z;
            forEachOps$ForEachOrderedTask2.fork();
        }
        if (forEachOps$ForEachOrderedTask.getPendingCount() > 0) {
            ForEachOps$ForEachOrderedTask$$ExternalSyntheticLambda0 forEachOps$ForEachOrderedTask$$ExternalSyntheticLambda0 = ForEachOps$ForEachOrderedTask$$ExternalSyntheticLambda0.INSTANCE;
            PipelineHelper pipelineHelper = forEachOps$ForEachOrderedTask.helper;
            Node.Builder makeNodeBuilder = pipelineHelper.makeNodeBuilder(pipelineHelper.exactOutputSizeIfKnown(spliterator2), forEachOps$ForEachOrderedTask$$ExternalSyntheticLambda0);
            AbstractPipeline abstractPipeline = (AbstractPipeline) forEachOps$ForEachOrderedTask.helper;
            Objects.requireNonNull(abstractPipeline);
            Objects.requireNonNull(makeNodeBuilder);
            abstractPipeline.copyInto(abstractPipeline.wrapSink(makeNodeBuilder), spliterator2);
            forEachOps$ForEachOrderedTask.node = makeNodeBuilder.build();
            forEachOps$ForEachOrderedTask.spliterator = null;
        }
        forEachOps$ForEachOrderedTask.tryComplete();
    }

    public void onCompletion(CountedCompleter countedCompleter) {
        Node node2 = this.node;
        if (node2 != null) {
            node2.forEach(this.action);
            this.node = null;
        } else {
            Spliterator spliterator2 = this.spliterator;
            if (spliterator2 != null) {
                PipelineHelper pipelineHelper = this.helper;
                Sink sink = this.action;
                AbstractPipeline abstractPipeline = (AbstractPipeline) pipelineHelper;
                Objects.requireNonNull(abstractPipeline);
                Objects.requireNonNull(sink);
                abstractPipeline.copyInto(abstractPipeline.wrapSink(sink), spliterator2);
                this.spliterator = null;
            }
        }
        ForEachOps$ForEachOrderedTask forEachOps$ForEachOrderedTask = (ForEachOps$ForEachOrderedTask) this.completionMap.remove(this);
        if (forEachOps$ForEachOrderedTask != null) {
            forEachOps$ForEachOrderedTask.tryComplete();
        }
    }
}
