package p009j$.util.stream;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.concurrent.CountedCompleter;
import p009j$.util.Collection;
import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.Spliterators;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.IntFunction;
import p009j$.util.function.LongConsumer;
import p009j$.util.function.LongFunction;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.Nodes */
abstract class Nodes {
    /* access modifiers changed from: private */
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    private static final Node.OfDouble EMPTY_DOUBLE_NODE = new EmptyNode.OfDouble();
    /* access modifiers changed from: private */
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Node.OfInt EMPTY_INT_NODE = new EmptyNode.OfInt();
    /* access modifiers changed from: private */
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final Node.OfLong EMPTY_LONG_NODE = new EmptyNode.OfLong();
    private static final Node EMPTY_NODE = new EmptyNode.OfRef((C14401) null);

    /* renamed from: j$.util.stream.Nodes$1 */
    abstract /* synthetic */ class C14401 {
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
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.Nodes.C14401.<clinit>():void");
        }
    }

    /* renamed from: j$.util.stream.Nodes$AbstractConcNode */
    abstract class AbstractConcNode implements Node {
        protected final Node left;
        protected final Node right;
        private final long size;

        AbstractConcNode(Node node, Node node2) {
            this.left = node;
            this.right = node2;
            this.size = node.count() + node2.count();
        }

        public long count() {
            return this.size;
        }

        public Node getChild(int i) {
            if (i == 0) {
                return this.left;
            }
            if (i == 1) {
                return this.right;
            }
            throw new IndexOutOfBoundsException();
        }

        public int getChildCount() {
            return 2;
        }
    }

    /* renamed from: j$.util.stream.Nodes$ArrayNode */
    class ArrayNode implements Node {
        final Object[] array;
        int curSize;

        ArrayNode(long j, IntFunction intFunction) {
            if (j < 2147483639) {
                this.array = (Object[]) intFunction.apply((int) j);
                this.curSize = 0;
                return;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        ArrayNode(Object[] objArr) {
            this.array = objArr;
            this.curSize = objArr.length;
        }

        public Object[] asArray(IntFunction intFunction) {
            Object[] objArr = this.array;
            if (objArr.length == this.curSize) {
                return objArr;
            }
            throw new IllegalStateException();
        }

        public void copyInto(Object[] objArr, int i) {
            System.arraycopy(this.array, 0, objArr, i, this.curSize);
        }

        public long count() {
            return (long) this.curSize;
        }

        public void forEach(Consumer consumer) {
            for (int i = 0; i < this.curSize; i++) {
                consumer.accept(this.array[i]);
            }
        }

        public Node getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public Spliterator spliterator() {
            return Spliterators.spliterator(this.array, 0, this.curSize, 1040);
        }

        public String toString() {
            return String.format("ArrayNode[%d][%s]", new Object[]{Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array)});
        }

        public /* synthetic */ Node truncate(long j, long j2, IntFunction intFunction) {
            return Node.CC.$default$truncate((Node) this, j, j2, intFunction);
        }
    }

    /* renamed from: j$.util.stream.Nodes$CollectionNode */
    final class CollectionNode implements Node {

        /* renamed from: c */
        private final Collection f237c;

        CollectionNode(Collection collection) {
            this.f237c = collection;
        }

        public Object[] asArray(IntFunction intFunction) {
            Collection collection = this.f237c;
            return collection.toArray((Object[]) intFunction.apply(collection.size()));
        }

        public void copyInto(Object[] objArr, int i) {
            for (Object obj : this.f237c) {
                objArr[i] = obj;
                i++;
            }
        }

        public long count() {
            return (long) this.f237c.size();
        }

        public void forEach(Consumer consumer) {
            Collection.EL.forEach(this.f237c, consumer);
        }

        public Node getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public Spliterator spliterator() {
            java.util.Collection collection = this.f237c;
            return (collection instanceof p009j$.util.Collection ? ((p009j$.util.Collection) collection).stream() : Objects.$default$stream(collection)).spliterator();
        }

        public String toString() {
            return String.format("CollectionNode[%d][%s]", new Object[]{Integer.valueOf(this.f237c.size()), this.f237c});
        }

        public /* synthetic */ Node truncate(long j, long j2, IntFunction intFunction) {
            return Node.CC.$default$truncate((Node) this, j, j2, intFunction);
        }
    }

    /* renamed from: j$.util.stream.Nodes$ConcNode */
    final class ConcNode extends AbstractConcNode {

        /* renamed from: j$.util.stream.Nodes$ConcNode$OfDouble */
        final class OfDouble extends OfPrimitive implements Node.OfDouble {
            OfDouble(Node.OfDouble ofDouble, Node.OfDouble ofDouble2) {
                super(ofDouble, ofDouble2);
            }

            public /* synthetic */ void copyInto(Double[] dArr, int i) {
                Node.CC.$default$copyInto((Node.OfDouble) this, dArr, i);
            }

            public /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.$default$forEach((Node.OfDouble) this, consumer);
            }

            public Spliterator.OfPrimitive spliterator() {
                return new InternalNodeSpliterator.OfDouble(this);
            }

            public double[] newArray(int i) {
                return new double[i];
            }

            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m745spliterator() {
                return new InternalNodeSpliterator.OfDouble(this);
            }
        }

        /* renamed from: j$.util.stream.Nodes$ConcNode$OfInt */
        final class OfInt extends OfPrimitive implements Node.OfInt {
            OfInt(Node.OfInt ofInt, Node.OfInt ofInt2) {
                super(ofInt, ofInt2);
            }

            public /* synthetic */ void copyInto(Integer[] numArr, int i) {
                Node.CC.$default$copyInto((Node.OfInt) this, numArr, i);
            }

            public /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.$default$forEach((Node.OfInt) this, consumer);
            }

            public Spliterator.OfPrimitive spliterator() {
                return new InternalNodeSpliterator.OfInt(this);
            }

            public int[] newArray(int i) {
                return new int[i];
            }

            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m746spliterator() {
                return new InternalNodeSpliterator.OfInt(this);
            }
        }

        /* renamed from: j$.util.stream.Nodes$ConcNode$OfLong */
        final class OfLong extends OfPrimitive implements Node.OfLong {
            OfLong(Node.OfLong ofLong, Node.OfLong ofLong2) {
                super(ofLong, ofLong2);
            }

            public /* synthetic */ void copyInto(Long[] lArr, int i) {
                Node.CC.$default$copyInto((Node.OfLong) this, lArr, i);
            }

            public /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.$default$forEach((Node.OfLong) this, consumer);
            }

            public Spliterator.OfPrimitive spliterator() {
                return new InternalNodeSpliterator.OfLong(this);
            }

            public long[] newArray(int i) {
                return new long[i];
            }

            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m747spliterator() {
                return new InternalNodeSpliterator.OfLong(this);
            }
        }

        /* renamed from: j$.util.stream.Nodes$ConcNode$OfPrimitive */
        abstract class OfPrimitive extends AbstractConcNode implements Node.OfPrimitive {
            OfPrimitive(Node.OfPrimitive ofPrimitive, Node.OfPrimitive ofPrimitive2) {
                super(ofPrimitive, ofPrimitive2);
            }

            public /* synthetic */ Object[] asArray(IntFunction intFunction) {
                return Node.CC.$default$asArray(this, intFunction);
            }

            public Object asPrimitiveArray() {
                long count = count();
                if (count < 2147483639) {
                    Object newArray = newArray((int) count);
                    copyInto(newArray, 0);
                    return newArray;
                }
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }

            public void copyInto(Object obj, int i) {
                ((Node.OfPrimitive) this.left).copyInto(obj, i);
                ((Node.OfPrimitive) this.right).copyInto(obj, i + ((int) ((Node.OfPrimitive) this.left).count()));
            }

            public void forEach(Object obj) {
                ((Node.OfPrimitive) this.left).forEach(obj);
                ((Node.OfPrimitive) this.right).forEach(obj);
            }

            public String toString() {
                if (count() < 32) {
                    return String.format("%s[%s.%s]", new Object[]{getClass().getName(), this.left, this.right});
                }
                return String.format("%s[size=%d]", new Object[]{getClass().getName(), Long.valueOf(count())});
            }
        }

        ConcNode(Node node, Node node2) {
            super(node, node2);
        }

        public Object[] asArray(IntFunction intFunction) {
            long count = count();
            if (count < 2147483639) {
                Object[] objArr = (Object[]) intFunction.apply((int) count);
                copyInto(objArr, 0);
                return objArr;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        public void copyInto(Object[] objArr, int i) {
            java.util.Objects.requireNonNull(objArr);
            this.left.copyInto(objArr, i);
            this.right.copyInto(objArr, i + ((int) this.left.count()));
        }

        public void forEach(Consumer consumer) {
            this.left.forEach(consumer);
            this.right.forEach(consumer);
        }

        public Spliterator spliterator() {
            return new InternalNodeSpliterator.OfRef(this);
        }

        public String toString() {
            if (count() < 32) {
                return String.format("ConcNode[%s.%s]", new Object[]{this.left, this.right});
            }
            return String.format("ConcNode[size=%d]", new Object[]{Long.valueOf(count())});
        }

        public Node truncate(long j, long j2, IntFunction intFunction) {
            if (j == 0 && j2 == count()) {
                return this;
            }
            long count = this.left.count();
            if (j >= count) {
                return this.right.truncate(j - count, j2 - count, intFunction);
            }
            if (j2 <= count) {
                return this.left.truncate(j, j2, intFunction);
            }
            IntFunction intFunction2 = intFunction;
            return Nodes.conc(StreamShape.REFERENCE, this.left.truncate(j, count, intFunction2), this.right.truncate(0, j2 - count, intFunction2));
        }
    }

    /* renamed from: j$.util.stream.Nodes$DoubleFixedNodeBuilder */
    final class DoubleFixedNodeBuilder extends DoubleArrayNode implements Node.Builder.OfDouble {
        DoubleFixedNodeBuilder(long j) {
            super(j);
        }

        public void accept(double d) {
            int i = this.curSize;
            double[] dArr = this.array;
            if (i < dArr.length) {
                this.curSize = i + 1;
                dArr[i] = d;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(this.array.length)}));
        }

        public /* synthetic */ void accept(int i) {
            Node.CC.$default$accept(this);
            throw null;
        }

        public /* synthetic */ void accept(long j) {
            Node.CC.$default$accepta(this);
            throw null;
        }

        public /* synthetic */ void accept(Double d) {
            Node.CC.$default$accept((Sink.OfDouble) this, d);
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public void begin(long j) {
            if (j == ((long) this.array.length)) {
                this.curSize = 0;
            } else {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(this.array.length)}));
            }
        }

        public Node.OfDouble build() {
            if (this.curSize >= this.array.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)}));
        }

        public /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        public void end() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)}));
            }
        }

        public String toString() {
            return String.format("DoubleFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array)});
        }
    }

    /* renamed from: j$.util.stream.Nodes$DoubleSpinedNodeBuilder */
    final class DoubleSpinedNodeBuilder extends SpinedBuffer.OfDouble implements Node.OfDouble, Node.Builder.OfDouble {
        DoubleSpinedNodeBuilder() {
        }

        public void accept(double d) {
            super.accept(d);
        }

        public /* synthetic */ void accept(int i) {
            Node.CC.$default$accept(this);
            throw null;
        }

        public /* synthetic */ void accept(long j) {
            Node.CC.$default$accepta(this);
            throw null;
        }

        public /* synthetic */ void accept(Double d) {
            Node.CC.$default$accept((Sink.OfDouble) this, d);
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public /* synthetic */ Object[] asArray(IntFunction intFunction) {
            return Node.CC.$default$asArray(this, intFunction);
        }

        public Object asPrimitiveArray() {
            return (double[]) super.asPrimitiveArray();
        }

        public void begin(long j) {
            clear();
            ensureCapacity(j);
        }

        public Node.OfDouble build() {
            return this;
        }

        /* renamed from: build  reason: collision with other method in class */
        public Node m749build() {
            return this;
        }

        public /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        public void copyInto(Object obj, int i) {
            super.copyInto((double[]) obj, i);
        }

        public /* synthetic */ void copyInto(Double[] dArr, int i) {
            Node.CC.$default$copyInto((Node.OfDouble) this, dArr, i);
        }

        public void end() {
        }

        public void forEach(Object obj) {
            super.forEach((DoubleConsumer) obj);
        }

        public Node.OfPrimitive getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public Spliterator.OfDouble spliterator() {
            return super.spliterator();
        }

        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator.OfPrimitive m750spliterator() {
            return super.spliterator();
        }

        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m751spliterator() {
            return super.spliterator();
        }
    }

    /* renamed from: j$.util.stream.Nodes$EmptyNode */
    abstract class EmptyNode implements Node {

        /* renamed from: j$.util.stream.Nodes$EmptyNode$OfDouble */
        final class OfDouble extends EmptyNode implements Node.OfDouble {
            OfDouble() {
            }

            public Object asPrimitiveArray() {
                return Nodes.EMPTY_DOUBLE_ARRAY;
            }

            public /* synthetic */ void copyInto(Double[] dArr, int i) {
                Node.CC.$default$copyInto((Node.OfDouble) this, dArr, i);
            }

            public /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.$default$forEach((Node.OfDouble) this, consumer);
            }

            public Node.OfPrimitive getChild(int i) {
                throw new IndexOutOfBoundsException();
            }

            public Spliterator.OfPrimitive spliterator() {
                return Spliterators.emptyDoubleSpliterator();
            }

            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m752spliterator() {
                return Spliterators.emptyDoubleSpliterator();
            }
        }

        /* renamed from: j$.util.stream.Nodes$EmptyNode$OfInt */
        final class OfInt extends EmptyNode implements Node.OfInt {
            OfInt() {
            }

            public Object asPrimitiveArray() {
                return Nodes.EMPTY_INT_ARRAY;
            }

            public /* synthetic */ void copyInto(Integer[] numArr, int i) {
                Node.CC.$default$copyInto((Node.OfInt) this, numArr, i);
            }

            public /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.$default$forEach((Node.OfInt) this, consumer);
            }

            public Node.OfPrimitive getChild(int i) {
                throw new IndexOutOfBoundsException();
            }

            public Spliterator.OfPrimitive spliterator() {
                return Spliterators.emptyIntSpliterator();
            }

            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m753spliterator() {
                return Spliterators.emptyIntSpliterator();
            }
        }

        /* renamed from: j$.util.stream.Nodes$EmptyNode$OfLong */
        final class OfLong extends EmptyNode implements Node.OfLong {
            OfLong() {
            }

            public Object asPrimitiveArray() {
                return Nodes.EMPTY_LONG_ARRAY;
            }

            public /* synthetic */ void copyInto(Long[] lArr, int i) {
                Node.CC.$default$copyInto((Node.OfLong) this, lArr, i);
            }

            public /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.$default$forEach((Node.OfLong) this, consumer);
            }

            public Node.OfPrimitive getChild(int i) {
                throw new IndexOutOfBoundsException();
            }

            public Spliterator.OfPrimitive spliterator() {
                return Spliterators.emptyLongSpliterator();
            }

            /* renamed from: spliterator  reason: collision with other method in class */
            public Spliterator m754spliterator() {
                return Spliterators.emptyLongSpliterator();
            }
        }

        /* renamed from: j$.util.stream.Nodes$EmptyNode$OfRef */
        class OfRef extends EmptyNode {
            OfRef(C14401 r1) {
            }

            public /* bridge */ /* synthetic */ void copyInto(Object[] objArr, int i) {
            }

            public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
            }

            public Spliterator spliterator() {
                return Spliterators.emptySpliterator();
            }
        }

        EmptyNode() {
        }

        public Object[] asArray(IntFunction intFunction) {
            return (Object[]) intFunction.apply(0);
        }

        public void copyInto(Object obj, int i) {
        }

        public long count() {
            return 0;
        }

        public void forEach(Object obj) {
        }

        public Node getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public /* synthetic */ Node truncate(long j, long j2, IntFunction intFunction) {
            return Node.CC.$default$truncate((Node) this, j, j2, intFunction);
        }
    }

    /* renamed from: j$.util.stream.Nodes$FixedNodeBuilder */
    final class FixedNodeBuilder extends ArrayNode implements Node.Builder {
        FixedNodeBuilder(long j, IntFunction intFunction) {
            super(j, intFunction);
        }

        public /* synthetic */ void accept(double d) {
            Node.CC.$default$acceptb(this);
            throw null;
        }

        public /* synthetic */ void accept(int i) {
            Node.CC.$default$accept(this);
            throw null;
        }

        public /* synthetic */ void accept(long j) {
            Node.CC.$default$accepta(this);
            throw null;
        }

        public void accept(Object obj) {
            int i = this.curSize;
            Object[] objArr = this.array;
            if (i < objArr.length) {
                this.curSize = i + 1;
                objArr[i] = obj;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(this.array.length)}));
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public void begin(long j) {
            if (j == ((long) this.array.length)) {
                this.curSize = 0;
            } else {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(this.array.length)}));
            }
        }

        public Node build() {
            if (this.curSize >= this.array.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)}));
        }

        public /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        public void end() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)}));
            }
        }

        public String toString() {
            return String.format("FixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array)});
        }
    }

    /* renamed from: j$.util.stream.Nodes$IntFixedNodeBuilder */
    final class IntFixedNodeBuilder extends IntArrayNode implements Node.Builder.OfInt {
        IntFixedNodeBuilder(long j) {
            super(j);
        }

        public /* synthetic */ void accept(double d) {
            Node.CC.$default$acceptb(this);
            throw null;
        }

        public void accept(int i) {
            int i2 = this.curSize;
            int[] iArr = this.array;
            if (i2 < iArr.length) {
                this.curSize = i2 + 1;
                iArr[i2] = i;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(this.array.length)}));
        }

        public /* synthetic */ void accept(long j) {
            Node.CC.$default$accepta(this);
            throw null;
        }

        public /* synthetic */ void accept(Integer num) {
            Node.CC.$default$accept((Sink.OfInt) this, num);
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public void begin(long j) {
            if (j == ((long) this.array.length)) {
                this.curSize = 0;
            } else {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(this.array.length)}));
            }
        }

        public Node.OfInt build() {
            if (this.curSize >= this.array.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)}));
        }

        public /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        public void end() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)}));
            }
        }

        public String toString() {
            return String.format("IntFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array)});
        }
    }

    /* renamed from: j$.util.stream.Nodes$IntSpinedNodeBuilder */
    final class IntSpinedNodeBuilder extends SpinedBuffer.OfInt implements Node.OfInt, Node.Builder.OfInt {
        IntSpinedNodeBuilder() {
        }

        public /* synthetic */ void accept(double d) {
            Node.CC.$default$acceptb(this);
            throw null;
        }

        public void accept(int i) {
            super.accept(i);
        }

        public /* synthetic */ void accept(long j) {
            Node.CC.$default$accepta(this);
            throw null;
        }

        public /* synthetic */ void accept(Integer num) {
            Node.CC.$default$accept((Sink.OfInt) this, num);
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public /* synthetic */ Object[] asArray(IntFunction intFunction) {
            return Node.CC.$default$asArray(this, intFunction);
        }

        public Object asPrimitiveArray() {
            return (int[]) super.asPrimitiveArray();
        }

        public void begin(long j) {
            clear();
            ensureCapacity(j);
        }

        public Node.OfInt build() {
            return this;
        }

        /* renamed from: build  reason: collision with other method in class */
        public Node m756build() {
            return this;
        }

        public /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        public void copyInto(Object obj, int i) {
            super.copyInto((int[]) obj, i);
        }

        public /* synthetic */ void copyInto(Integer[] numArr, int i) {
            Node.CC.$default$copyInto((Node.OfInt) this, numArr, i);
        }

        public void end() {
        }

        public void forEach(Object obj) {
            super.forEach((IntConsumer) obj);
        }

        public Node.OfPrimitive getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public Spliterator.OfInt spliterator() {
            return super.spliterator();
        }

        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator.OfPrimitive m757spliterator() {
            return super.spliterator();
        }

        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m758spliterator() {
            return super.spliterator();
        }
    }

    /* renamed from: j$.util.stream.Nodes$InternalNodeSpliterator */
    abstract class InternalNodeSpliterator implements Spliterator {
        int curChildIndex;
        Node curNode;
        Spliterator lastNodeSpliterator;
        Spliterator tryAdvanceSpliterator;
        Deque tryAdvanceStack;

        /* renamed from: j$.util.stream.Nodes$InternalNodeSpliterator$OfDouble */
        final class OfDouble extends OfPrimitive implements Spliterator.OfDouble {
            OfDouble(Node.OfDouble ofDouble) {
                super(ofDouble);
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Objects.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
            }

            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Objects.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
            }
        }

        /* renamed from: j$.util.stream.Nodes$InternalNodeSpliterator$OfInt */
        final class OfInt extends OfPrimitive implements Spliterator.OfInt {
            OfInt(Node.OfInt ofInt) {
                super(ofInt);
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Objects.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
            }

            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Objects.$default$tryAdvance((Spliterator.OfInt) this, consumer);
            }
        }

        /* renamed from: j$.util.stream.Nodes$InternalNodeSpliterator$OfLong */
        final class OfLong extends OfPrimitive implements Spliterator.OfLong {
            OfLong(Node.OfLong ofLong) {
                super(ofLong);
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Objects.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
            }

            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Objects.$default$tryAdvance((Spliterator.OfLong) this, consumer);
            }
        }

        /* renamed from: j$.util.stream.Nodes$InternalNodeSpliterator$OfPrimitive */
        abstract class OfPrimitive extends InternalNodeSpliterator implements Spliterator.OfPrimitive {
            OfPrimitive(Node.OfPrimitive ofPrimitive) {
                super(ofPrimitive);
            }

            public void forEachRemaining(Object obj) {
                if (this.curNode != null) {
                    if (this.tryAdvanceSpliterator == null) {
                        Spliterator spliterator = this.lastNodeSpliterator;
                        if (spliterator == null) {
                            Deque initStack = initStack();
                            while (true) {
                                Node.OfPrimitive ofPrimitive = (Node.OfPrimitive) findNextLeafNode(initStack);
                                if (ofPrimitive != null) {
                                    ofPrimitive.forEach(obj);
                                } else {
                                    this.curNode = null;
                                    return;
                                }
                            }
                        } else {
                            ((Spliterator.OfPrimitive) spliterator).forEachRemaining(obj);
                        }
                    } else {
                        do {
                        } while (tryAdvance(obj));
                    }
                }
            }

            public boolean tryAdvance(Object obj) {
                Node.OfPrimitive ofPrimitive;
                if (!initTryAdvance()) {
                    return false;
                }
                boolean tryAdvance = ((Spliterator.OfPrimitive) this.tryAdvanceSpliterator).tryAdvance(obj);
                if (!tryAdvance) {
                    if (this.lastNodeSpliterator != null || (ofPrimitive = (Node.OfPrimitive) findNextLeafNode(this.tryAdvanceStack)) == null) {
                        this.curNode = null;
                    } else {
                        Spliterator.OfPrimitive spliterator = ofPrimitive.spliterator();
                        this.tryAdvanceSpliterator = spliterator;
                        return spliterator.tryAdvance(obj);
                    }
                }
                return tryAdvance;
            }
        }

        /* renamed from: j$.util.stream.Nodes$InternalNodeSpliterator$OfRef */
        final class OfRef extends InternalNodeSpliterator {
            OfRef(Node node) {
                super(node);
            }

            public void forEachRemaining(Consumer consumer) {
                if (this.curNode != null) {
                    if (this.tryAdvanceSpliterator == null) {
                        Spliterator spliterator = this.lastNodeSpliterator;
                        if (spliterator == null) {
                            Deque initStack = initStack();
                            while (true) {
                                Node findNextLeafNode = findNextLeafNode(initStack);
                                if (findNextLeafNode != null) {
                                    findNextLeafNode.forEach(consumer);
                                } else {
                                    this.curNode = null;
                                    return;
                                }
                            }
                        } else {
                            spliterator.forEachRemaining(consumer);
                        }
                    } else {
                        do {
                        } while (tryAdvance(consumer));
                    }
                }
            }

            public boolean tryAdvance(Consumer consumer) {
                Node findNextLeafNode;
                if (!initTryAdvance()) {
                    return false;
                }
                boolean tryAdvance = this.tryAdvanceSpliterator.tryAdvance(consumer);
                if (!tryAdvance) {
                    if (this.lastNodeSpliterator != null || (findNextLeafNode = findNextLeafNode(this.tryAdvanceStack)) == null) {
                        this.curNode = null;
                    } else {
                        Spliterator spliterator = findNextLeafNode.spliterator();
                        this.tryAdvanceSpliterator = spliterator;
                        return spliterator.tryAdvance(consumer);
                    }
                }
                return tryAdvance;
            }
        }

        InternalNodeSpliterator(Node node) {
            this.curNode = node;
        }

        public final int characteristics() {
            return 64;
        }

        public final long estimateSize() {
            long j = 0;
            if (this.curNode == null) {
                return 0;
            }
            Spliterator spliterator = this.lastNodeSpliterator;
            if (spliterator != null) {
                return spliterator.estimateSize();
            }
            for (int i = this.curChildIndex; i < this.curNode.getChildCount(); i++) {
                j += this.curNode.getChild(i).count();
            }
            return j;
        }

        /* access modifiers changed from: protected */
        public final Node findNextLeafNode(Deque deque) {
            while (true) {
                Node node = (Node) deque.pollFirst();
                if (node == null) {
                    return null;
                }
                if (node.getChildCount() != 0) {
                    for (int childCount = node.getChildCount() - 1; childCount >= 0; childCount--) {
                        deque.addFirst(node.getChild(childCount));
                    }
                } else if (node.count() > 0) {
                    return node;
                }
            }
        }

        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Objects.$default$hasCharacteristics(this, i);
        }

        /* access modifiers changed from: protected */
        public final Deque initStack() {
            ArrayDeque arrayDeque = new ArrayDeque(8);
            int childCount = this.curNode.getChildCount();
            while (true) {
                childCount--;
                if (childCount < this.curChildIndex) {
                    return arrayDeque;
                }
                arrayDeque.addFirst(this.curNode.getChild(childCount));
            }
        }

        /* access modifiers changed from: protected */
        public final boolean initTryAdvance() {
            if (this.curNode == null) {
                return false;
            }
            if (this.tryAdvanceSpliterator != null) {
                return true;
            }
            Spliterator spliterator = this.lastNodeSpliterator;
            if (spliterator == null) {
                Deque initStack = initStack();
                this.tryAdvanceStack = initStack;
                Node findNextLeafNode = findNextLeafNode(initStack);
                if (findNextLeafNode != null) {
                    spliterator = findNextLeafNode.spliterator();
                } else {
                    this.curNode = null;
                    return false;
                }
            }
            this.tryAdvanceSpliterator = spliterator;
            return true;
        }

        public final Spliterator trySplit() {
            Node node = this.curNode;
            if (node == null || this.tryAdvanceSpliterator != null) {
                return null;
            }
            Spliterator spliterator = this.lastNodeSpliterator;
            if (spliterator != null) {
                return spliterator.trySplit();
            }
            if (this.curChildIndex < node.getChildCount() - 1) {
                Node node2 = this.curNode;
                int i = this.curChildIndex;
                this.curChildIndex = i + 1;
                return node2.getChild(i).spliterator();
            }
            Node child = this.curNode.getChild(this.curChildIndex);
            this.curNode = child;
            if (child.getChildCount() == 0) {
                Spliterator spliterator2 = this.curNode.spliterator();
                this.lastNodeSpliterator = spliterator2;
                return spliterator2.trySplit();
            }
            this.curChildIndex = 0;
            Node node3 = this.curNode;
            this.curChildIndex = 1;
            return node3.getChild(0).spliterator();
        }
    }

    /* renamed from: j$.util.stream.Nodes$LongFixedNodeBuilder */
    final class LongFixedNodeBuilder extends LongArrayNode implements Node.Builder.OfLong {
        LongFixedNodeBuilder(long j) {
            super(j);
        }

        public /* synthetic */ void accept(double d) {
            Node.CC.$default$acceptb(this);
            throw null;
        }

        public /* synthetic */ void accept(int i) {
            Node.CC.$default$accept(this);
            throw null;
        }

        public void accept(long j) {
            int i = this.curSize;
            long[] jArr = this.array;
            if (i < jArr.length) {
                this.curSize = i + 1;
                jArr[i] = j;
                return;
            }
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(this.array.length)}));
        }

        public /* synthetic */ void accept(Long l) {
            Node.CC.$default$accept((Sink.OfLong) this, l);
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public void begin(long j) {
            if (j == ((long) this.array.length)) {
                this.curSize = 0;
            } else {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(this.array.length)}));
            }
        }

        public Node.OfLong build() {
            if (this.curSize >= this.array.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)}));
        }

        public /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        public void end() {
            if (this.curSize < this.array.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.curSize), Integer.valueOf(this.array.length)}));
            }
        }

        public String toString() {
            return String.format("LongFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array)});
        }
    }

    /* renamed from: j$.util.stream.Nodes$LongSpinedNodeBuilder */
    final class LongSpinedNodeBuilder extends SpinedBuffer.OfLong implements Node.OfLong, Node.Builder.OfLong {
        LongSpinedNodeBuilder() {
        }

        public /* synthetic */ void accept(double d) {
            Node.CC.$default$acceptb(this);
            throw null;
        }

        public /* synthetic */ void accept(int i) {
            Node.CC.$default$accept(this);
            throw null;
        }

        public void accept(long j) {
            super.accept(j);
        }

        public /* synthetic */ void accept(Long l) {
            Node.CC.$default$accept((Sink.OfLong) this, l);
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public /* synthetic */ Object[] asArray(IntFunction intFunction) {
            return Node.CC.$default$asArray(this, intFunction);
        }

        public Object asPrimitiveArray() {
            return (long[]) super.asPrimitiveArray();
        }

        public void begin(long j) {
            clear();
            ensureCapacity(j);
        }

        public Node.OfLong build() {
            return this;
        }

        /* renamed from: build  reason: collision with other method in class */
        public Node m760build() {
            return this;
        }

        public /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        public void copyInto(Object obj, int i) {
            super.copyInto((long[]) obj, i);
        }

        public /* synthetic */ void copyInto(Long[] lArr, int i) {
            Node.CC.$default$copyInto((Node.OfLong) this, lArr, i);
        }

        public void end() {
        }

        public void forEach(Object obj) {
            super.forEach((LongConsumer) obj);
        }

        public Node.OfPrimitive getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public Spliterator.OfLong spliterator() {
            return super.spliterator();
        }

        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator.OfPrimitive m761spliterator() {
            return super.spliterator();
        }

        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m762spliterator() {
            return super.spliterator();
        }
    }

    /* renamed from: j$.util.stream.Nodes$SizedCollectorTask */
    abstract class SizedCollectorTask extends CountedCompleter implements Sink {
        protected int fence;
        protected final PipelineHelper helper;
        protected int index;
        protected long length;
        protected long offset;
        protected final Spliterator spliterator;
        protected final long targetSize;

        /* renamed from: j$.util.stream.Nodes$SizedCollectorTask$OfDouble */
        final class OfDouble extends SizedCollectorTask implements Sink.OfDouble {
            private final double[] array;

            OfDouble(Spliterator spliterator, PipelineHelper pipelineHelper, double[] dArr) {
                super(spliterator, pipelineHelper, dArr.length);
                this.array = dArr;
            }

            OfDouble(OfDouble ofDouble, Spliterator spliterator, long j, long j2) {
                super(ofDouble, spliterator, j, j2, ofDouble.array.length);
                this.array = ofDouble.array;
            }

            public void accept(double d) {
                int i = this.index;
                if (i < this.fence) {
                    double[] dArr = this.array;
                    this.index = i + 1;
                    dArr[i] = d;
                    return;
                }
                throw new IndexOutOfBoundsException(Integer.toString(this.index));
            }

            public /* synthetic */ void accept(Double d) {
                Node.CC.$default$accept((Sink.OfDouble) this, d);
            }

            /* access modifiers changed from: package-private */
            public SizedCollectorTask makeChild(Spliterator spliterator, long j, long j2) {
                return new OfDouble(this, spliterator, j, j2);
            }
        }

        /* renamed from: j$.util.stream.Nodes$SizedCollectorTask$OfInt */
        final class OfInt extends SizedCollectorTask implements Sink.OfInt {
            private final int[] array;

            OfInt(Spliterator spliterator, PipelineHelper pipelineHelper, int[] iArr) {
                super(spliterator, pipelineHelper, iArr.length);
                this.array = iArr;
            }

            OfInt(OfInt ofInt, Spliterator spliterator, long j, long j2) {
                super(ofInt, spliterator, j, j2, ofInt.array.length);
                this.array = ofInt.array;
            }

            public void accept(int i) {
                int i2 = this.index;
                if (i2 < this.fence) {
                    int[] iArr = this.array;
                    this.index = i2 + 1;
                    iArr[i2] = i;
                    return;
                }
                throw new IndexOutOfBoundsException(Integer.toString(this.index));
            }

            public /* synthetic */ void accept(Integer num) {
                Node.CC.$default$accept((Sink.OfInt) this, num);
            }

            /* access modifiers changed from: package-private */
            public SizedCollectorTask makeChild(Spliterator spliterator, long j, long j2) {
                return new OfInt(this, spliterator, j, j2);
            }
        }

        /* renamed from: j$.util.stream.Nodes$SizedCollectorTask$OfLong */
        final class OfLong extends SizedCollectorTask implements Sink.OfLong {
            private final long[] array;

            OfLong(Spliterator spliterator, PipelineHelper pipelineHelper, long[] jArr) {
                super(spliterator, pipelineHelper, jArr.length);
                this.array = jArr;
            }

            OfLong(OfLong ofLong, Spliterator spliterator, long j, long j2) {
                super(ofLong, spliterator, j, j2, ofLong.array.length);
                this.array = ofLong.array;
            }

            public void accept(long j) {
                int i = this.index;
                if (i < this.fence) {
                    long[] jArr = this.array;
                    this.index = i + 1;
                    jArr[i] = j;
                    return;
                }
                throw new IndexOutOfBoundsException(Integer.toString(this.index));
            }

            public /* synthetic */ void accept(Long l) {
                Node.CC.$default$accept((Sink.OfLong) this, l);
            }

            /* access modifiers changed from: package-private */
            public SizedCollectorTask makeChild(Spliterator spliterator, long j, long j2) {
                return new OfLong(this, spliterator, j, j2);
            }
        }

        /* renamed from: j$.util.stream.Nodes$SizedCollectorTask$OfRef */
        final class OfRef extends SizedCollectorTask {
            private final Object[] array;

            OfRef(Spliterator spliterator, PipelineHelper pipelineHelper, Object[] objArr) {
                super(spliterator, pipelineHelper, objArr.length);
                this.array = objArr;
            }

            OfRef(OfRef ofRef, Spliterator spliterator, long j, long j2) {
                super(ofRef, spliterator, j, j2, ofRef.array.length);
                this.array = ofRef.array;
            }

            public void accept(Object obj) {
                int i = this.index;
                if (i < this.fence) {
                    Object[] objArr = this.array;
                    this.index = i + 1;
                    objArr[i] = obj;
                    return;
                }
                throw new IndexOutOfBoundsException(Integer.toString(this.index));
            }

            /* access modifiers changed from: package-private */
            public SizedCollectorTask makeChild(Spliterator spliterator, long j, long j2) {
                return new OfRef(this, spliterator, j, j2);
            }
        }

        SizedCollectorTask(Spliterator spliterator2, PipelineHelper pipelineHelper, int i) {
            this.spliterator = spliterator2;
            this.helper = pipelineHelper;
            this.targetSize = AbstractTask.suggestTargetSize(spliterator2.estimateSize());
            this.offset = 0;
            this.length = (long) i;
        }

        SizedCollectorTask(SizedCollectorTask sizedCollectorTask, Spliterator spliterator2, long j, long j2, int i) {
            super(sizedCollectorTask);
            this.spliterator = spliterator2;
            this.helper = sizedCollectorTask.helper;
            this.targetSize = sizedCollectorTask.targetSize;
            this.offset = j;
            this.length = j2;
            if (j < 0 || j2 < 0 || (j + j2) - 1 >= ((long) i)) {
                throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", new Object[]{Long.valueOf(j), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}));
            }
        }

        public /* synthetic */ void accept(double d) {
            Node.CC.$default$acceptb(this);
            throw null;
        }

        public /* synthetic */ void accept(int i) {
            Node.CC.$default$accept(this);
            throw null;
        }

        public /* synthetic */ void accept(long j) {
            Node.CC.$default$accepta(this);
            throw null;
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public void begin(long j) {
            long j2 = this.length;
            if (j <= j2) {
                int i = (int) this.offset;
                this.index = i;
                this.fence = i + ((int) j2);
                return;
            }
            throw new IllegalStateException("size passed to Sink.begin exceeds array length");
        }

        public /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        public void compute() {
            Spliterator trySplit;
            Spliterator spliterator2 = this.spliterator;
            SizedCollectorTask sizedCollectorTask = this;
            while (spliterator2.estimateSize() > sizedCollectorTask.targetSize && (trySplit = spliterator2.trySplit()) != null) {
                sizedCollectorTask.setPendingCount(1);
                long estimateSize = trySplit.estimateSize();
                sizedCollectorTask.makeChild(trySplit, sizedCollectorTask.offset, estimateSize).fork();
                sizedCollectorTask = sizedCollectorTask.makeChild(spliterator2, sizedCollectorTask.offset + estimateSize, sizedCollectorTask.length - estimateSize);
            }
            AbstractPipeline abstractPipeline = (AbstractPipeline) sizedCollectorTask.helper;
            java.util.Objects.requireNonNull(abstractPipeline);
            abstractPipeline.copyInto(abstractPipeline.wrapSink(sizedCollectorTask), spliterator2);
            sizedCollectorTask.propagateCompletion();
        }

        public /* synthetic */ void end() {
        }

        /* access modifiers changed from: package-private */
        public abstract SizedCollectorTask makeChild(Spliterator spliterator2, long j, long j2);
    }

    /* renamed from: j$.util.stream.Nodes$SpinedNodeBuilder */
    final class SpinedNodeBuilder extends SpinedBuffer implements Node, Node.Builder {
        SpinedNodeBuilder() {
        }

        public /* synthetic */ void accept(double d) {
            Node.CC.$default$acceptb(this);
            throw null;
        }

        public /* synthetic */ void accept(int i) {
            Node.CC.$default$accept(this);
            throw null;
        }

        public /* synthetic */ void accept(long j) {
            Node.CC.$default$accepta(this);
            throw null;
        }

        public void accept(Object obj) {
            super.accept(obj);
        }

        public Object[] asArray(IntFunction intFunction) {
            long count = count();
            if (count < 2147483639) {
                Object[] objArr = (Object[]) intFunction.apply((int) count);
                copyInto(objArr, 0);
                return objArr;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        public void begin(long j) {
            clear();
            ensureCapacity(j);
        }

        public Node build() {
            return this;
        }

        public /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        public void copyInto(Object[] objArr, int i) {
            super.copyInto(objArr, i);
        }

        public void end() {
        }

        public void forEach(Consumer consumer) {
            super.forEach(consumer);
        }

        public Node getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public Spliterator spliterator() {
            return super.spliterator();
        }

        public /* synthetic */ Node truncate(long j, long j2, IntFunction intFunction) {
            return Node.CC.$default$truncate((Node) this, j, j2, intFunction);
        }
    }

    /* renamed from: j$.util.stream.Nodes$ToArrayTask */
    abstract class ToArrayTask extends CountedCompleter {
        protected final Node node;
        protected final int offset;

        /* renamed from: j$.util.stream.Nodes$ToArrayTask$OfInt */
        final class OfInt extends OfRef {
            public OfInt(Node.OfDouble ofDouble, double[] dArr, int i) {
                super((Node.OfPrimitive) ofDouble, (Object) dArr, i, (C14401) null);
            }

            public OfInt(Node.OfInt ofInt, int[] iArr, int i) {
                super((Node.OfPrimitive) ofInt, (Object) iArr, i, (C14401) null);
            }

            public OfInt(Node.OfLong ofLong, long[] jArr, int i) {
                super((Node.OfPrimitive) ofLong, (Object) jArr, i, (C14401) null);
            }
        }

        /* renamed from: j$.util.stream.Nodes$ToArrayTask$OfRef */
        class OfRef extends ToArrayTask {
            public final /* synthetic */ int $r8$classId;
            private final Object array;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OfRef(Node.OfPrimitive ofPrimitive, Object obj, int i) {
                super(ofPrimitive, i);
                this.$r8$classId = 1;
                this.array = obj;
            }

            /* access modifiers changed from: package-private */
            public void copyNodeToArray() {
                switch (this.$r8$classId) {
                    case 0:
                        this.node.copyInto((Object[]) this.array, this.offset);
                        return;
                    default:
                        ((Node.OfPrimitive) this.node).copyInto(this.array, this.offset);
                        return;
                }
            }

            /* access modifiers changed from: package-private */
            public ToArrayTask makeChild(int i, int i2) {
                switch (this.$r8$classId) {
                    case 0:
                        return new OfRef(this, this.node.getChild(i), i2);
                    default:
                        return new OfRef(this, ((Node.OfPrimitive) this.node).getChild(i), i2);
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ OfRef(Node.OfPrimitive ofPrimitive, Object obj, int i, C14401 r4) {
                this(ofPrimitive, obj, i);
                this.$r8$classId = 1;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OfRef(Node node, Object[] objArr, int i, C14401 r4) {
                super(node, i);
                this.$r8$classId = 0;
                this.$r8$classId = 0;
                this.array = objArr;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OfRef(OfRef ofRef, Node.OfPrimitive ofPrimitive, int i) {
                super(ofRef, ofPrimitive, i);
                this.$r8$classId = 1;
                this.array = ofRef.array;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OfRef(OfRef ofRef, Node node, int i) {
                super(ofRef, node, i);
                this.$r8$classId = 0;
                this.array = (Object[]) ofRef.array;
            }
        }

        ToArrayTask(Node node2, int i) {
            this.node = node2;
            this.offset = i;
        }

        ToArrayTask(ToArrayTask toArrayTask, Node node2, int i) {
            super(toArrayTask);
            this.node = node2;
            this.offset = i;
        }

        public void compute() {
            ToArrayTask toArrayTask = this;
            while (toArrayTask.node.getChildCount() != 0) {
                toArrayTask.setPendingCount(toArrayTask.node.getChildCount() - 1);
                int i = 0;
                int i2 = 0;
                while (i < toArrayTask.node.getChildCount() - 1) {
                    ToArrayTask makeChild = toArrayTask.makeChild(i, toArrayTask.offset + i2);
                    i2 = (int) (((long) i2) + makeChild.node.count());
                    makeChild.fork();
                    i++;
                }
                toArrayTask = toArrayTask.makeChild(i, toArrayTask.offset + i2);
            }
            toArrayTask.copyNodeToArray();
            toArrayTask.propagateCompletion();
        }

        /* access modifiers changed from: package-private */
        public abstract void copyNodeToArray();

        /* access modifiers changed from: package-private */
        public abstract ToArrayTask makeChild(int i, int i2);
    }

    static Node.Builder builder(long j, IntFunction intFunction) {
        return (j < 0 || j >= 2147483639) ? new SpinedNodeBuilder() : new FixedNodeBuilder(j, intFunction);
    }

    public static Node collect(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z, IntFunction intFunction) {
        long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
        if (exactOutputSizeIfKnown < 0 || !spliterator.hasCharacteristics(16384)) {
            Node node = (Node) new CollectorTask.OfInt(pipelineHelper, intFunction, spliterator).invoke();
            return z ? flatten(node, intFunction) : node;
        } else if (exactOutputSizeIfKnown < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) exactOutputSizeIfKnown);
            new SizedCollectorTask.OfRef(spliterator, pipelineHelper, objArr).invoke();
            return new ArrayNode(objArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static Node.OfDouble collectDouble(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z) {
        long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
        if (exactOutputSizeIfKnown < 0 || !spliterator.hasCharacteristics(16384)) {
            Node.OfDouble ofDouble = (Node.OfDouble) new CollectorTask.OfInt(pipelineHelper, spliterator, 1).invoke();
            return z ? flattenDouble(ofDouble) : ofDouble;
        } else if (exactOutputSizeIfKnown < 2147483639) {
            double[] dArr = new double[((int) exactOutputSizeIfKnown)];
            new SizedCollectorTask.OfDouble(spliterator, pipelineHelper, dArr).invoke();
            return new DoubleArrayNode(dArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static Node.OfInt collectInt(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z) {
        long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
        if (exactOutputSizeIfKnown < 0 || !spliterator.hasCharacteristics(16384)) {
            Node.OfInt ofInt = (Node.OfInt) new CollectorTask.OfInt(pipelineHelper, spliterator, 0).invoke();
            return z ? flattenInt(ofInt) : ofInt;
        } else if (exactOutputSizeIfKnown < 2147483639) {
            int[] iArr = new int[((int) exactOutputSizeIfKnown)];
            new SizedCollectorTask.OfInt(spliterator, pipelineHelper, iArr).invoke();
            return new IntArrayNode(iArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static Node.OfLong collectLong(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z) {
        long exactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
        if (exactOutputSizeIfKnown < 0 || !spliterator.hasCharacteristics(16384)) {
            Node.OfLong ofLong = (Node.OfLong) new CollectorTask.OfInt(pipelineHelper, spliterator, 2).invoke();
            return z ? flattenLong(ofLong) : ofLong;
        } else if (exactOutputSizeIfKnown < 2147483639) {
            long[] jArr = new long[((int) exactOutputSizeIfKnown)];
            new SizedCollectorTask.OfLong(spliterator, pipelineHelper, jArr).invoke();
            return new LongArrayNode(jArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    static Node conc(StreamShape streamShape, Node node, Node node2) {
        int i = C14401.$SwitchMap$java$util$stream$StreamShape[streamShape.ordinal()];
        if (i == 1) {
            return new ConcNode(node, node2);
        }
        if (i == 2) {
            return new ConcNode.OfInt((Node.OfInt) node, (Node.OfInt) node2);
        }
        if (i == 3) {
            return new ConcNode.OfLong((Node.OfLong) node, (Node.OfLong) node2);
        }
        if (i == 4) {
            return new ConcNode.OfDouble((Node.OfDouble) node, (Node.OfDouble) node2);
        }
        throw new IllegalStateException("Unknown shape " + streamShape);
    }

    static Node.Builder.OfDouble doubleBuilder(long j) {
        return (j < 0 || j >= 2147483639) ? new DoubleSpinedNodeBuilder() : new DoubleFixedNodeBuilder(j);
    }

    static Node emptyNode(StreamShape streamShape) {
        int i = C14401.$SwitchMap$java$util$stream$StreamShape[streamShape.ordinal()];
        if (i == 1) {
            return EMPTY_NODE;
        }
        if (i == 2) {
            return EMPTY_INT_NODE;
        }
        if (i == 3) {
            return EMPTY_LONG_NODE;
        }
        if (i == 4) {
            return EMPTY_DOUBLE_NODE;
        }
        throw new IllegalStateException("Unknown shape " + streamShape);
    }

    public static Node flatten(Node node, IntFunction intFunction) {
        if (node.getChildCount() <= 0) {
            return node;
        }
        long count = node.count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            new ToArrayTask.OfRef(node, objArr, 0, (C14401) null).invoke();
            return new ArrayNode(objArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static Node.OfDouble flattenDouble(Node.OfDouble ofDouble) {
        if (ofDouble.getChildCount() <= 0) {
            return ofDouble;
        }
        long count = ofDouble.count();
        if (count < 2147483639) {
            double[] dArr = new double[((int) count)];
            new ToArrayTask.OfInt(ofDouble, dArr, 0).invoke();
            return new DoubleArrayNode(dArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static Node.OfInt flattenInt(Node.OfInt ofInt) {
        if (ofInt.getChildCount() <= 0) {
            return ofInt;
        }
        long count = ofInt.count();
        if (count < 2147483639) {
            int[] iArr = new int[((int) count)];
            new ToArrayTask.OfInt(ofInt, iArr, 0).invoke();
            return new IntArrayNode(iArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static Node.OfLong flattenLong(Node.OfLong ofLong) {
        if (ofLong.getChildCount() <= 0) {
            return ofLong;
        }
        long count = ofLong.count();
        if (count < 2147483639) {
            long[] jArr = new long[((int) count)];
            new ToArrayTask.OfInt(ofLong, jArr, 0).invoke();
            return new LongArrayNode(jArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    static Node.Builder.OfInt intBuilder(long j) {
        return (j < 0 || j >= 2147483639) ? new IntSpinedNodeBuilder() : new IntFixedNodeBuilder(j);
    }

    static Node.Builder.OfLong longBuilder(long j) {
        return (j < 0 || j >= 2147483639) ? new LongSpinedNodeBuilder() : new LongFixedNodeBuilder(j);
    }

    /* renamed from: j$.util.stream.Nodes$CollectorTask */
    class CollectorTask extends AbstractTask {
        protected final LongFunction builderFactory;
        protected final BinaryOperator concFactory;
        protected final PipelineHelper helper;

        CollectorTask(CollectorTask collectorTask, Spliterator spliterator) {
            super((AbstractTask) collectorTask, spliterator);
            this.helper = collectorTask.helper;
            this.builderFactory = collectorTask.builderFactory;
            this.concFactory = collectorTask.concFactory;
        }

        CollectorTask(PipelineHelper pipelineHelper, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator) {
            super(pipelineHelper, spliterator);
            this.helper = pipelineHelper;
            this.builderFactory = longFunction;
            this.concFactory = binaryOperator;
        }

        /* access modifiers changed from: protected */
        public Object doLeaf() {
            Node.Builder builder = (Node.Builder) this.builderFactory.apply(this.helper.exactOutputSizeIfKnown(this.spliterator));
            this.helper.wrapAndCopyInto(builder, this.spliterator);
            return builder.build();
        }

        /* access modifiers changed from: protected */
        public AbstractTask makeChild(Spliterator spliterator) {
            return new CollectorTask(this, spliterator);
        }

        public void onCompletion(CountedCompleter countedCompleter) {
            if (!isLeaf()) {
                setLocalResult((Node) this.concFactory.apply((Node) ((CollectorTask) this.leftChild).getLocalResult(), (Node) ((CollectorTask) this.rightChild).getLocalResult()));
            }
            this.spliterator = null;
            this.rightChild = null;
            this.leftChild = null;
        }

        /* renamed from: j$.util.stream.Nodes$CollectorTask$OfInt */
        final class OfInt extends CollectorTask {
            public static final /* synthetic */ int $r8$clinit = 0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OfInt(PipelineHelper pipelineHelper, Spliterator spliterator, int i) {
                super(pipelineHelper, spliterator, Nodes$CollectorTask$OfInt$$ExternalSyntheticLambda1.INSTANCE, Nodes$CollectorTask$OfInt$$ExternalSyntheticLambda0.INSTANCE);
                if (i == 1) {
                    super(pipelineHelper, spliterator, Nodes$CollectorTask$OfDouble$$ExternalSyntheticLambda1.INSTANCE, Nodes$CollectorTask$OfDouble$$ExternalSyntheticLambda0.INSTANCE);
                } else if (i != 2) {
                } else {
                    super(pipelineHelper, spliterator, Nodes$CollectorTask$OfLong$$ExternalSyntheticLambda1.INSTANCE, Nodes$CollectorTask$OfLong$$ExternalSyntheticLambda0.INSTANCE);
                }
            }

            public OfInt(PipelineHelper pipelineHelper, IntFunction intFunction, Spliterator spliterator) {
                super(pipelineHelper, spliterator, new SpinedBuffer$$ExternalSyntheticLambda0(intFunction), Nodes$CollectorTask$OfRef$$ExternalSyntheticLambda0.INSTANCE);
            }
        }
    }

    /* renamed from: j$.util.stream.Nodes$DoubleArrayNode */
    class DoubleArrayNode implements Node.OfDouble {
        final double[] array;
        int curSize;

        DoubleArrayNode(long j) {
            if (j < 2147483639) {
                this.array = new double[((int) j)];
                this.curSize = 0;
                return;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        DoubleArrayNode(double[] dArr) {
            this.array = dArr;
            this.curSize = dArr.length;
        }

        public /* synthetic */ Object[] asArray(IntFunction intFunction) {
            return Node.CC.$default$asArray(this, intFunction);
        }

        public Object asPrimitiveArray() {
            double[] dArr = this.array;
            int length = dArr.length;
            int i = this.curSize;
            return length == i ? dArr : Arrays.copyOf(dArr, i);
        }

        public void copyInto(Object obj, int i) {
            System.arraycopy(this.array, 0, (double[]) obj, i, this.curSize);
        }

        public /* synthetic */ void copyInto(Double[] dArr, int i) {
            Node.CC.$default$copyInto((Node.OfDouble) this, dArr, i);
        }

        public long count() {
            return (long) this.curSize;
        }

        public /* synthetic */ void forEach(Consumer consumer) {
            Node.CC.$default$forEach((Node.OfDouble) this, consumer);
        }

        public void forEach(Object obj) {
            DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
            for (int i = 0; i < this.curSize; i++) {
                doubleConsumer.accept(this.array[i]);
            }
        }

        public Node.OfPrimitive getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public Spliterator.OfPrimitive spliterator() {
            return Spliterators.spliterator(this.array, 0, this.curSize, 1040);
        }

        public String toString() {
            return String.format("DoubleArrayNode[%d][%s]", new Object[]{Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array)});
        }

        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m748spliterator() {
            return Spliterators.spliterator(this.array, 0, this.curSize, 1040);
        }
    }

    /* renamed from: j$.util.stream.Nodes$IntArrayNode */
    class IntArrayNode implements Node.OfInt {
        final int[] array;
        int curSize;

        IntArrayNode(long j) {
            if (j < 2147483639) {
                this.array = new int[((int) j)];
                this.curSize = 0;
                return;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        IntArrayNode(int[] iArr) {
            this.array = iArr;
            this.curSize = iArr.length;
        }

        public /* synthetic */ Object[] asArray(IntFunction intFunction) {
            return Node.CC.$default$asArray(this, intFunction);
        }

        public Object asPrimitiveArray() {
            int[] iArr = this.array;
            int length = iArr.length;
            int i = this.curSize;
            return length == i ? iArr : Arrays.copyOf(iArr, i);
        }

        public void copyInto(Object obj, int i) {
            System.arraycopy(this.array, 0, (int[]) obj, i, this.curSize);
        }

        public /* synthetic */ void copyInto(Integer[] numArr, int i) {
            Node.CC.$default$copyInto((Node.OfInt) this, numArr, i);
        }

        public long count() {
            return (long) this.curSize;
        }

        public /* synthetic */ void forEach(Consumer consumer) {
            Node.CC.$default$forEach((Node.OfInt) this, consumer);
        }

        public void forEach(Object obj) {
            IntConsumer intConsumer = (IntConsumer) obj;
            for (int i = 0; i < this.curSize; i++) {
                intConsumer.accept(this.array[i]);
            }
        }

        public Node.OfPrimitive getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public Spliterator.OfPrimitive spliterator() {
            return Spliterators.spliterator(this.array, 0, this.curSize, 1040);
        }

        public String toString() {
            return String.format("IntArrayNode[%d][%s]", new Object[]{Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array)});
        }

        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m755spliterator() {
            return Spliterators.spliterator(this.array, 0, this.curSize, 1040);
        }
    }

    /* renamed from: j$.util.stream.Nodes$LongArrayNode */
    class LongArrayNode implements Node.OfLong {
        final long[] array;
        int curSize;

        LongArrayNode(long j) {
            if (j < 2147483639) {
                this.array = new long[((int) j)];
                this.curSize = 0;
                return;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        LongArrayNode(long[] jArr) {
            this.array = jArr;
            this.curSize = jArr.length;
        }

        public /* synthetic */ Object[] asArray(IntFunction intFunction) {
            return Node.CC.$default$asArray(this, intFunction);
        }

        public Object asPrimitiveArray() {
            long[] jArr = this.array;
            int length = jArr.length;
            int i = this.curSize;
            return length == i ? jArr : Arrays.copyOf(jArr, i);
        }

        public void copyInto(Object obj, int i) {
            System.arraycopy(this.array, 0, (long[]) obj, i, this.curSize);
        }

        public /* synthetic */ void copyInto(Long[] lArr, int i) {
            Node.CC.$default$copyInto((Node.OfLong) this, lArr, i);
        }

        public long count() {
            return (long) this.curSize;
        }

        public /* synthetic */ void forEach(Consumer consumer) {
            Node.CC.$default$forEach((Node.OfLong) this, consumer);
        }

        public void forEach(Object obj) {
            LongConsumer longConsumer = (LongConsumer) obj;
            for (int i = 0; i < this.curSize; i++) {
                longConsumer.accept(this.array[i]);
            }
        }

        public Node.OfPrimitive getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        public /* synthetic */ int getChildCount() {
            return 0;
        }

        public Spliterator.OfPrimitive spliterator() {
            return Spliterators.spliterator(this.array, 0, this.curSize, 1040);
        }

        public String toString() {
            return String.format("LongArrayNode[%d][%s]", new Object[]{Integer.valueOf(this.array.length - this.curSize), Arrays.toString(this.array)});
        }

        /* renamed from: spliterator  reason: collision with other method in class */
        public Spliterator m759spliterator() {
            return Spliterators.spliterator(this.array, 0, this.curSize, 1040);
        }
    }
}
