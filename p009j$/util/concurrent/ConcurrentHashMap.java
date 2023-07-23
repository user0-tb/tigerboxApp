package p009j$.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Stream;
import p009j$.util.Collection;
import p009j$.util.Iterator;
import p009j$.util.Spliterator;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BiFunction;
import p009j$.util.function.Consumer;
import p009j$.util.function.Predicate;
import p009j$.wrappers.C$r8$wrapper$java$util$function$BiConsumer$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$BiFunction$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$Consumer$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$Function$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntFunction$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$Predicate$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$stream$Stream$WRP;
import sun.misc.Unsafe;

/* renamed from: j$.util.concurrent.ConcurrentHashMap */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, ConcurrentMap<K, V> {
    private static final long ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;

    /* renamed from: U */
    private static final Unsafe f233U;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient CounterCell[] counterCells;
    private transient EntrySetView entrySet;
    private transient KeySetView keySet;
    private volatile transient Node[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient Node[] table;
    private volatile transient int transferIndex;
    private transient ValuesView values;

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$BaseIterator */
    static class BaseIterator extends Traverser {
        Node lastReturned;
        final ConcurrentHashMap map;

        BaseIterator(Node[] nodeArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3);
            this.map = concurrentHashMap;
            advance();
        }

        public final boolean hasMoreElements() {
            return this.next != null;
        }

        public final boolean hasNext() {
            return this.next != null;
        }

        public final void remove() {
            Node node = this.lastReturned;
            if (node != null) {
                this.lastReturned = null;
                this.map.replaceNode(node.key, (Object) null, (Object) null);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$CounterCell */
    static final class CounterCell {
        volatile long value;

        CounterCell(long j) {
            this.value = j;
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$EntryIterator */
    static final class EntryIterator extends BaseIterator implements Iterator, p009j$.util.Iterator {
        EntryIterator(Node[] nodeArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3, concurrentHashMap);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        public Object next() {
            Node node = this.next;
            if (node != null) {
                Object obj = node.key;
                Object obj2 = node.val;
                this.lastReturned = node;
                advance();
                return new MapEntry(obj, obj2, this.map);
            }
            throw new NoSuchElementException();
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$EntrySetView */
    static final class EntrySetView extends CollectionView implements Set, Collection {
        EntrySetView(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        public boolean add(Map.Entry entry) {
            return this.map.putVal(entry.getKey(), entry.getValue(), false) == null;
        }

        public boolean addAll(java.util.Collection collection) {
            java.util.Iterator it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (add((Map.Entry) it.next())) {
                    z = true;
                }
            }
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
            r0 = r2.map.get((r0 = r3.getKey()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
            r3 = (r3 = (java.util.Map.Entry) r3).getValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean contains(java.lang.Object r3) {
            /*
                r2 = this;
                boolean r0 = r3 instanceof java.util.Map.Entry
                if (r0 == 0) goto L_0x0024
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                java.lang.Object r0 = r3.getKey()
                if (r0 == 0) goto L_0x0024
                j$.util.concurrent.ConcurrentHashMap r1 = r2.map
                java.lang.Object r0 = r1.get(r0)
                if (r0 == 0) goto L_0x0024
                java.lang.Object r3 = r3.getValue()
                if (r3 == 0) goto L_0x0024
                if (r3 == r0) goto L_0x0022
                boolean r3 = r3.equals(r0)
                if (r3 == 0) goto L_0x0024
            L_0x0022:
                r3 = 1
                goto L_0x0025
            L_0x0024:
                r3 = 0
            L_0x0025:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.EntrySetView.contains(java.lang.Object):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r2 = (java.util.Set) r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r2) {
            /*
                r1 = this;
                boolean r0 = r2 instanceof java.util.Set
                if (r0 == 0) goto L_0x0016
                java.util.Set r2 = (java.util.Set) r2
                if (r2 == r1) goto L_0x0014
                boolean r0 = r1.containsAll(r2)
                if (r0 == 0) goto L_0x0016
                boolean r2 = r2.containsAll(r1)
                if (r2 == 0) goto L_0x0016
            L_0x0014:
                r2 = 1
                goto L_0x0017
            L_0x0016:
                r2 = 0
            L_0x0017:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.EntrySetView.equals(java.lang.Object):boolean");
        }

        public void forEach(Consumer consumer) {
            Objects.requireNonNull(consumer);
            Node[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node advance = traverser.advance();
                    if (advance != null) {
                        consumer.accept(new MapEntry(advance.key, advance.val, this.map));
                    } else {
                        return;
                    }
                }
            }
        }

        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        public final int hashCode() {
            Node[] nodeArr = this.map.table;
            int i = 0;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node advance = traverser.advance();
                    if (advance == null) {
                        break;
                    }
                    i += advance.hashCode();
                }
            }
            return i;
        }

        public java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntryIterator(nodeArr, length, 0, length, concurrentHashMap);
        }

        public /* synthetic */ Stream parallelStream() {
            return C$r8$wrapper$java$util$stream$Stream$WRP.convert(p009j$.util.Objects.$default$parallelStream(this));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r3 = (java.util.Map.Entry) r3;
            r0 = r3.getKey();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
            r3 = r3.getValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(java.lang.Object r3) {
            /*
                r2 = this;
                boolean r0 = r3 instanceof java.util.Map.Entry
                if (r0 == 0) goto L_0x001c
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                java.lang.Object r0 = r3.getKey()
                if (r0 == 0) goto L_0x001c
                java.lang.Object r3 = r3.getValue()
                if (r3 == 0) goto L_0x001c
                j$.util.concurrent.ConcurrentHashMap r1 = r2.map
                boolean r3 = r1.remove(r0, r3)
                if (r3 == 0) goto L_0x001c
                r3 = 1
                goto L_0x001d
            L_0x001c:
                r3 = 0
            L_0x001d:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.EntrySetView.remove(java.lang.Object):boolean");
        }

        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return p009j$.util.Objects.$default$removeIf(this, predicate);
        }

        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return p009j$.util.Objects.$default$removeIf(this, C$r8$wrapper$java$util$function$Predicate$VWRP.convert(predicate));
        }

        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            long sumCount = concurrentHashMap.sumCount();
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            long j = 0;
            if (sumCount >= 0) {
                j = sumCount;
            }
            return new EntrySpliterator(nodeArr, length, 0, length, j, concurrentHashMap);
        }

        public Object[] toArray(IntFunction intFunction) {
            return toArray((Object[]) C$r8$wrapper$java$util$function$IntFunction$VWRP.convert(intFunction).apply(0));
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$EntrySpliterator */
    static final class EntrySpliterator extends Traverser implements Spliterator {
        long est;
        final ConcurrentHashMap map;

        EntrySpliterator(Node[] nodeArr, int i, int i2, int i3, long j, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3);
            this.map = concurrentHashMap;
            this.est = j;
        }

        public int characteristics() {
            return 4353;
        }

        public long estimateSize() {
            return this.est;
        }

        public void forEachRemaining(Consumer consumer) {
            Objects.requireNonNull(consumer);
            while (true) {
                Node advance = advance();
                if (advance != null) {
                    consumer.accept(new MapEntry(advance.key, advance.val, this.map));
                } else {
                    return;
                }
            }
        }

        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return p009j$.util.Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return p009j$.util.Objects.$default$hasCharacteristics(this, i);
        }

        public boolean tryAdvance(Consumer consumer) {
            Objects.requireNonNull(consumer);
            Node advance = advance();
            if (advance == null) {
                return false;
            }
            consumer.accept(new MapEntry(advance.key, advance.val, this.map));
            return true;
        }

        public Spliterator trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new EntrySpliterator(nodeArr, i4, i3, i2, j, this.map);
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$ForwardingNode */
    static final class ForwardingNode extends Node {
        final Node[] nextTable;

        ForwardingNode(Node[] nodeArr) {
            super(-1, (Object) null, (Object) null, (Node) null);
            this.nextTable = nodeArr;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            if ((r0 instanceof p009j$.util.concurrent.ConcurrentHashMap.ForwardingNode) == false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            r0 = ((p009j$.util.concurrent.ConcurrentHashMap.ForwardingNode) r0).nextTable;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
            return r0.find(r5, r6);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p009j$.util.concurrent.ConcurrentHashMap.Node find(int r5, java.lang.Object r6) {
            /*
                r4 = this;
                j$.util.concurrent.ConcurrentHashMap$Node[] r0 = r4.nextTable
            L_0x0002:
                r1 = 0
                if (r0 == 0) goto L_0x0037
                int r2 = r0.length
                if (r2 == 0) goto L_0x0037
                int r2 = r2 + -1
                r2 = r2 & r5
                j$.util.concurrent.ConcurrentHashMap$Node r0 = p009j$.util.concurrent.ConcurrentHashMap.tabAt(r0, r2)
                if (r0 != 0) goto L_0x0012
                goto L_0x0037
            L_0x0012:
                int r2 = r0.hash
                if (r2 != r5) goto L_0x0023
                java.lang.Object r3 = r0.key
                if (r3 == r6) goto L_0x0022
                if (r3 == 0) goto L_0x0023
                boolean r3 = r6.equals(r3)
                if (r3 == 0) goto L_0x0023
            L_0x0022:
                return r0
            L_0x0023:
                if (r2 >= 0) goto L_0x0033
                boolean r1 = r0 instanceof p009j$.util.concurrent.ConcurrentHashMap.ForwardingNode
                if (r1 == 0) goto L_0x002e
                j$.util.concurrent.ConcurrentHashMap$ForwardingNode r0 = (p009j$.util.concurrent.ConcurrentHashMap.ForwardingNode) r0
                j$.util.concurrent.ConcurrentHashMap$Node[] r0 = r0.nextTable
                goto L_0x0002
            L_0x002e:
                j$.util.concurrent.ConcurrentHashMap$Node r5 = r0.find(r5, r6)
                return r5
            L_0x0033:
                j$.util.concurrent.ConcurrentHashMap$Node r0 = r0.next
                if (r0 != 0) goto L_0x0012
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.ForwardingNode.find(int, java.lang.Object):j$.util.concurrent.ConcurrentHashMap$Node");
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$KeyIterator */
    static final class KeyIterator extends BaseIterator implements java.util.Iterator, Enumeration, p009j$.util.Iterator {
        KeyIterator(Node[] nodeArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3, concurrentHashMap);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        public final Object next() {
            Node node = this.next;
            if (node != null) {
                Object obj = node.key;
                this.lastReturned = node;
                advance();
                return obj;
            }
            throw new NoSuchElementException();
        }

        public final Object nextElement() {
            return next();
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$KeySetView */
    public static class KeySetView extends CollectionView implements Set, Collection {
        KeySetView(ConcurrentHashMap concurrentHashMap, Object obj) {
            super(concurrentHashMap);
        }

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(java.util.Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r2 = (java.util.Set) r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r2) {
            /*
                r1 = this;
                boolean r0 = r2 instanceof java.util.Set
                if (r0 == 0) goto L_0x0016
                java.util.Set r2 = (java.util.Set) r2
                if (r2 == r1) goto L_0x0014
                boolean r0 = r1.containsAll(r2)
                if (r0 == 0) goto L_0x0016
                boolean r2 = r2.containsAll(r1)
                if (r2 == 0) goto L_0x0016
            L_0x0014:
                r2 = 1
                goto L_0x0017
            L_0x0016:
                r2 = 0
            L_0x0017:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.KeySetView.equals(java.lang.Object):boolean");
        }

        public void forEach(Consumer consumer) {
            Objects.requireNonNull(consumer);
            Node[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node advance = traverser.advance();
                    if (advance != null) {
                        consumer.accept(advance.key);
                    } else {
                        return;
                    }
                }
            }
        }

        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        public int hashCode() {
            java.util.Iterator it = iterator();
            int i = 0;
            while (((BaseIterator) it).hasNext()) {
                i += ((KeyIterator) it).next().hashCode();
            }
            return i;
        }

        public java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeyIterator(nodeArr, length, 0, length, concurrentHashMap);
        }

        public /* synthetic */ Stream parallelStream() {
            return C$r8$wrapper$java$util$stream$Stream$WRP.convert(p009j$.util.Objects.$default$parallelStream(this));
        }

        public boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }

        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return p009j$.util.Objects.$default$removeIf(this, predicate);
        }

        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return p009j$.util.Objects.$default$removeIf(this, C$r8$wrapper$java$util$function$Predicate$VWRP.convert(predicate));
        }

        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            long sumCount = concurrentHashMap.sumCount();
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            long j = 0;
            if (sumCount >= 0) {
                j = sumCount;
            }
            return new KeySpliterator(nodeArr, length, 0, length, j);
        }

        public Object[] toArray(IntFunction intFunction) {
            return toArray((Object[]) C$r8$wrapper$java$util$function$IntFunction$VWRP.convert(intFunction).apply(0));
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$KeySpliterator */
    static final class KeySpliterator extends Traverser implements Spliterator {
        long est;

        KeySpliterator(Node[] nodeArr, int i, int i2, int i3, long j) {
            super(nodeArr, i, i2, i3);
            this.est = j;
        }

        public int characteristics() {
            return 4353;
        }

        public long estimateSize() {
            return this.est;
        }

        public void forEachRemaining(Consumer consumer) {
            Objects.requireNonNull(consumer);
            while (true) {
                Node advance = advance();
                if (advance != null) {
                    consumer.accept(advance.key);
                } else {
                    return;
                }
            }
        }

        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return p009j$.util.Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return p009j$.util.Objects.$default$hasCharacteristics(this, i);
        }

        public boolean tryAdvance(Consumer consumer) {
            Objects.requireNonNull(consumer);
            Node advance = advance();
            if (advance == null) {
                return false;
            }
            consumer.accept(advance.key);
            return true;
        }

        public Spliterator trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new KeySpliterator(nodeArr, i4, i3, i2, j);
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$MapEntry */
    static final class MapEntry implements Map.Entry {
        final Object key;
        final ConcurrentHashMap map;
        Object val;

        MapEntry(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
            this.key = obj;
            this.val = obj2;
            this.map = concurrentHashMap;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            r0 = r2.val;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r3 = (java.util.Map.Entry) r3;
            r0 = r3.getKey();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
            r3 = r3.getValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
            r1 = r2.key;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r3) {
            /*
                r2 = this;
                boolean r0 = r3 instanceof java.util.Map.Entry
                if (r0 == 0) goto L_0x0028
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                java.lang.Object r0 = r3.getKey()
                if (r0 == 0) goto L_0x0028
                java.lang.Object r3 = r3.getValue()
                if (r3 == 0) goto L_0x0028
                java.lang.Object r1 = r2.key
                if (r0 == r1) goto L_0x001c
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0028
            L_0x001c:
                java.lang.Object r0 = r2.val
                if (r3 == r0) goto L_0x0026
                boolean r3 = r3.equals(r0)
                if (r3 == 0) goto L_0x0028
            L_0x0026:
                r3 = 1
                goto L_0x0029
            L_0x0028:
                r3 = 0
            L_0x0029:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.MapEntry.equals(java.lang.Object):boolean");
        }

        public Object getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.val;
        }

        public int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        public Object setValue(Object obj) {
            Objects.requireNonNull(obj);
            Object obj2 = this.val;
            this.val = obj;
            this.map.put(this.key, obj);
            return obj2;
        }

        public String toString() {
            return this.key + "=" + this.val;
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$Node */
    static class Node implements Map.Entry {
        final int hash;
        final Object key;
        volatile Node next;
        volatile Object val;

        Node(int i, Object obj, Object obj2, Node node) {
            this.hash = i;
            this.key = obj;
            this.val = obj2;
            this.next = node;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            r0 = r2.val;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r3 = (java.util.Map.Entry) r3;
            r0 = r3.getKey();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
            r3 = r3.getValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
            r1 = r2.key;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r3) {
            /*
                r2 = this;
                boolean r0 = r3 instanceof java.util.Map.Entry
                if (r0 == 0) goto L_0x0028
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                java.lang.Object r0 = r3.getKey()
                if (r0 == 0) goto L_0x0028
                java.lang.Object r3 = r3.getValue()
                if (r3 == 0) goto L_0x0028
                java.lang.Object r1 = r2.key
                if (r0 == r1) goto L_0x001c
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0028
            L_0x001c:
                java.lang.Object r0 = r2.val
                if (r3 == r0) goto L_0x0026
                boolean r3 = r3.equals(r0)
                if (r3 == 0) goto L_0x0028
            L_0x0026:
                r3 = 1
                goto L_0x0029
            L_0x0028:
                r3 = 0
            L_0x0029:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.Node.equals(java.lang.Object):boolean");
        }

        /* access modifiers changed from: package-private */
        public Node find(int i, Object obj) {
            Object obj2;
            Node node = this;
            do {
                if (node.hash == i && ((obj2 = node.key) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return node;
                }
                node = node.next;
            } while (node != null);
            return null;
        }

        public final Object getKey() {
            return this.key;
        }

        public final Object getValue() {
            return this.val;
        }

        public final int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            return this.key + "=" + this.val;
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$ReservationNode */
    static final class ReservationNode extends Node {
        ReservationNode() {
            super(-3, (Object) null, (Object) null, (Node) null);
        }

        /* access modifiers changed from: package-private */
        public Node find(int i, Object obj) {
            return null;
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$Segment */
    static class Segment extends ReentrantLock {
        Segment(float f) {
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$TableStack */
    static final class TableStack {
        int index;
        int length;
        TableStack next;
        Node[] tab;

        TableStack() {
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$Traverser */
    static class Traverser {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int index;
        Node next = null;
        TableStack spare;
        TableStack stack;
        Node[] tab;

        Traverser(Node[] nodeArr, int i, int i2, int i3) {
            this.tab = nodeArr;
            this.baseSize = i;
            this.index = i2;
            this.baseIndex = i2;
            this.baseLimit = i3;
        }

        /* access modifiers changed from: package-private */
        public final Node advance() {
            Node node;
            Node[] nodeArr;
            int length;
            int i;
            TableStack tableStack;
            Node node2 = this.next;
            if (node2 != null) {
                node2 = node2.next;
            }
            while (node == null) {
                if (this.baseIndex >= this.baseLimit || (nodeArr = this.tab) == null || (length = nodeArr.length) <= (i = this.index) || i < 0) {
                    this.next = null;
                    return null;
                }
                Node tabAt = ConcurrentHashMap.tabAt(nodeArr, i);
                if (tabAt == null || tabAt.hash >= 0) {
                    node = tabAt;
                } else if (tabAt instanceof ForwardingNode) {
                    this.tab = ((ForwardingNode) tabAt).nextTable;
                    TableStack tableStack2 = this.spare;
                    if (tableStack2 != null) {
                        this.spare = tableStack2.next;
                    } else {
                        tableStack2 = new TableStack();
                    }
                    tableStack2.tab = nodeArr;
                    tableStack2.length = length;
                    tableStack2.index = i;
                    tableStack2.next = this.stack;
                    this.stack = tableStack2;
                    node = null;
                } else {
                    node = tabAt instanceof TreeBin ? ((TreeBin) tabAt).first : null;
                }
                if (this.stack != null) {
                    while (true) {
                        tableStack = this.stack;
                        if (tableStack == null) {
                            break;
                        }
                        int i2 = this.index;
                        int i3 = tableStack.length;
                        int i4 = i2 + i3;
                        this.index = i4;
                        if (i4 < length) {
                            break;
                        }
                        this.index = tableStack.index;
                        this.tab = tableStack.tab;
                        tableStack.tab = null;
                        TableStack tableStack3 = tableStack.next;
                        tableStack.next = this.spare;
                        this.stack = tableStack3;
                        this.spare = tableStack;
                        length = i3;
                    }
                    if (tableStack == null) {
                        int i5 = this.index + this.baseSize;
                        this.index = i5;
                        if (i5 >= length) {
                            int i6 = this.baseIndex + 1;
                            this.baseIndex = i6;
                            this.index = i6;
                        }
                    }
                } else {
                    int i7 = i + this.baseSize;
                    this.index = i7;
                    if (i7 >= length) {
                        int i8 = this.baseIndex + 1;
                        this.baseIndex = i8;
                        this.index = i8;
                    }
                }
            }
            this.next = node;
            return node;
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$TreeBin */
    static final class TreeBin extends Node {
        private static final long LOCKSTATE;

        /* renamed from: U */
        private static final Unsafe f234U;
        volatile TreeNode first;
        volatile int lockState;
        TreeNode root;
        volatile Thread waiter;

        static {
            try {
                Unsafe unsafe = DesugarUnsafe.getUnsafe();
                f234U = unsafe;
                LOCKSTATE = unsafe.objectFieldOffset(TreeBin.class.getDeclaredField("lockState"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
            r6 = p009j$.util.concurrent.ConcurrentHashMap.comparableClassFor(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
            r8 = p009j$.util.concurrent.ConcurrentHashMap.compareComparables(r6, r3, r7);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        TreeBin(p009j$.util.concurrent.ConcurrentHashMap.TreeNode r10) {
            /*
                r9 = this;
                r0 = -2
                r1 = 0
                r9.<init>(r0, r1, r1, r1)
                r9.first = r10
                r0 = r1
            L_0x0008:
                if (r10 == 0) goto L_0x005c
                j$.util.concurrent.ConcurrentHashMap$Node r2 = r10.next
                j$.util.concurrent.ConcurrentHashMap$TreeNode r2 = (p009j$.util.concurrent.ConcurrentHashMap.TreeNode) r2
                r10.right = r1
                r10.left = r1
                if (r0 != 0) goto L_0x001b
                r10.parent = r1
                r0 = 0
                r10.red = r0
            L_0x0019:
                r0 = r10
                goto L_0x0058
            L_0x001b:
                java.lang.Object r3 = r10.key
                int r4 = r10.hash
                r5 = r0
                r6 = r1
            L_0x0021:
                java.lang.Object r7 = r5.key
                int r8 = r5.hash
                if (r8 <= r4) goto L_0x0029
                r7 = -1
                goto L_0x0041
            L_0x0029:
                if (r8 >= r4) goto L_0x002d
                r7 = 1
                goto L_0x0041
            L_0x002d:
                if (r6 != 0) goto L_0x0035
                java.lang.Class r6 = p009j$.util.concurrent.ConcurrentHashMap.comparableClassFor(r3)
                if (r6 == 0) goto L_0x003b
            L_0x0035:
                int r8 = p009j$.util.concurrent.ConcurrentHashMap.compareComparables(r6, r3, r7)
                if (r8 != 0) goto L_0x0040
            L_0x003b:
                int r7 = tieBreakOrder(r3, r7)
                goto L_0x0041
            L_0x0040:
                r7 = r8
            L_0x0041:
                if (r7 > 0) goto L_0x0046
                j$.util.concurrent.ConcurrentHashMap$TreeNode r8 = r5.left
                goto L_0x0048
            L_0x0046:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r8 = r5.right
            L_0x0048:
                if (r8 != 0) goto L_0x005a
                r10.parent = r5
                if (r7 > 0) goto L_0x0051
                r5.left = r10
                goto L_0x0053
            L_0x0051:
                r5.right = r10
            L_0x0053:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r10 = balanceInsertion(r0, r10)
                goto L_0x0019
            L_0x0058:
                r10 = r2
                goto L_0x0008
            L_0x005a:
                r5 = r8
                goto L_0x0021
            L_0x005c:
                r9.root = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.TreeBin.<init>(j$.util.concurrent.ConcurrentHashMap$TreeNode):void");
        }

        static TreeNode balanceDeletion(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3;
            while (treeNode2 != null && treeNode2 != treeNode) {
                TreeNode treeNode4 = treeNode2.parent;
                if (treeNode4 == null) {
                    treeNode2.red = false;
                    return treeNode2;
                } else if (treeNode2.red) {
                    treeNode2.red = false;
                    return treeNode;
                } else {
                    TreeNode treeNode5 = treeNode4.left;
                    TreeNode treeNode6 = null;
                    if (treeNode5 == treeNode2) {
                        treeNode3 = treeNode4.right;
                        if (treeNode3 != null && treeNode3.red) {
                            treeNode3.red = false;
                            treeNode4.red = true;
                            treeNode = rotateLeft(treeNode, treeNode4);
                            treeNode4 = treeNode2.parent;
                            treeNode3 = treeNode4 == null ? null : treeNode4.right;
                        }
                        if (treeNode3 != null) {
                            TreeNode treeNode7 = treeNode3.left;
                            TreeNode treeNode8 = treeNode3.right;
                            if ((treeNode8 != null && treeNode8.red) || (treeNode7 != null && treeNode7.red)) {
                                if (treeNode8 == null || !treeNode8.red) {
                                    if (treeNode7 != null) {
                                        treeNode7.red = false;
                                    }
                                    treeNode3.red = true;
                                    treeNode = rotateRight(treeNode, treeNode3);
                                    treeNode4 = treeNode2.parent;
                                    if (treeNode4 != null) {
                                        treeNode6 = treeNode4.right;
                                    }
                                } else {
                                    treeNode6 = treeNode3;
                                }
                                if (treeNode6 != null) {
                                    treeNode6.red = treeNode4 == null ? false : treeNode4.red;
                                    TreeNode treeNode9 = treeNode6.right;
                                    if (treeNode9 != null) {
                                        treeNode9.red = false;
                                    }
                                }
                                if (treeNode4 != null) {
                                    treeNode4.red = false;
                                    treeNode = rotateLeft(treeNode, treeNode4);
                                }
                                treeNode2 = treeNode;
                                treeNode = treeNode2;
                            }
                            treeNode3.red = true;
                        }
                    } else {
                        if (treeNode5 != null && treeNode5.red) {
                            treeNode5.red = false;
                            treeNode4.red = true;
                            treeNode = rotateRight(treeNode, treeNode4);
                            treeNode4 = treeNode2.parent;
                            treeNode5 = treeNode4 == null ? null : treeNode4.left;
                        }
                        if (treeNode3 != null) {
                            TreeNode treeNode10 = treeNode3.left;
                            TreeNode treeNode11 = treeNode3.right;
                            if ((treeNode10 != null && treeNode10.red) || (treeNode11 != null && treeNode11.red)) {
                                if (treeNode10 == null || !treeNode10.red) {
                                    if (treeNode11 != null) {
                                        treeNode11.red = false;
                                    }
                                    treeNode3.red = true;
                                    treeNode = rotateLeft(treeNode, treeNode3);
                                    treeNode4 = treeNode2.parent;
                                    if (treeNode4 != null) {
                                        treeNode6 = treeNode4.left;
                                    }
                                } else {
                                    treeNode6 = treeNode3;
                                }
                                if (treeNode6 != null) {
                                    treeNode6.red = treeNode4 == null ? false : treeNode4.red;
                                    TreeNode treeNode12 = treeNode6.left;
                                    if (treeNode12 != null) {
                                        treeNode12.red = false;
                                    }
                                }
                                if (treeNode4 != null) {
                                    treeNode4.red = false;
                                    treeNode = rotateRight(treeNode, treeNode4);
                                }
                                treeNode2 = treeNode;
                                treeNode = treeNode2;
                            }
                            treeNode3.red = true;
                        }
                    }
                    treeNode2 = treeNode4;
                }
            }
            return treeNode;
        }

        static TreeNode balanceInsertion(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3;
            treeNode2.red = true;
            while (true) {
                TreeNode treeNode4 = treeNode2.parent;
                if (treeNode4 == null) {
                    treeNode2.red = false;
                    return treeNode2;
                } else if (!treeNode4.red || (treeNode3 = treeNode4.parent) == null) {
                    return treeNode;
                } else {
                    TreeNode treeNode5 = treeNode3.left;
                    if (treeNode4 == treeNode5) {
                        treeNode5 = treeNode3.right;
                        if (treeNode5 == null || !treeNode5.red) {
                            if (treeNode2 == treeNode4.right) {
                                treeNode = rotateLeft(treeNode, treeNode4);
                                TreeNode treeNode6 = treeNode4.parent;
                                treeNode3 = treeNode6 == null ? null : treeNode6.parent;
                                TreeNode treeNode7 = treeNode4;
                                treeNode4 = treeNode6;
                                treeNode2 = treeNode7;
                            }
                            if (treeNode4 != null) {
                                treeNode4.red = false;
                                if (treeNode3 != null) {
                                    treeNode3.red = true;
                                    treeNode = rotateRight(treeNode, treeNode3);
                                }
                            }
                        }
                    } else if (treeNode5 == null || !treeNode5.red) {
                        if (treeNode2 == treeNode4.left) {
                            treeNode = rotateRight(treeNode, treeNode4);
                            TreeNode treeNode8 = treeNode4.parent;
                            treeNode3 = treeNode8 == null ? null : treeNode8.parent;
                            TreeNode treeNode9 = treeNode4;
                            treeNode4 = treeNode8;
                            treeNode2 = treeNode9;
                        }
                        if (treeNode4 != null) {
                            treeNode4.red = false;
                            if (treeNode3 != null) {
                                treeNode3.red = true;
                                treeNode = rotateLeft(treeNode, treeNode3);
                            }
                        }
                    }
                    treeNode5.red = false;
                    treeNode4.red = false;
                    treeNode3.red = true;
                    treeNode2 = treeNode3;
                }
            }
            return treeNode;
        }

        private final void contendedLock() {
            boolean z = false;
            while (true) {
                int i = this.lockState;
                if ((i & -3) == 0) {
                    if (f234U.compareAndSwapInt(this, LOCKSTATE, i, 1)) {
                        break;
                    }
                } else if ((i & 2) == 0) {
                    if (f234U.compareAndSwapInt(this, LOCKSTATE, i, i | 2)) {
                        z = true;
                        this.waiter = Thread.currentThread();
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.waiter = null;
            }
        }

        private final void lockRoot() {
            if (!f234U.compareAndSwapInt(this, LOCKSTATE, 0, 1)) {
                contendedLock();
            }
        }

        static TreeNode rotateLeft(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3 = treeNode2.right;
            if (treeNode3 != null) {
                TreeNode treeNode4 = treeNode3.left;
                treeNode2.right = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.red = false;
                    treeNode = treeNode3;
                } else if (treeNode5.left == treeNode2) {
                    treeNode5.left = treeNode3;
                } else {
                    treeNode5.right = treeNode3;
                }
                treeNode3.left = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        static TreeNode rotateRight(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3 = treeNode2.left;
            if (treeNode3 != null) {
                TreeNode treeNode4 = treeNode3.right;
                treeNode2.left = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.red = false;
                    treeNode = treeNode3;
                } else if (treeNode5.right == treeNode2) {
                    treeNode5.right = treeNode3;
                } else {
                    treeNode5.left = treeNode3;
                }
                treeNode3.right = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        static int tieBreakOrder(Object obj, Object obj2) {
            int compareTo;
            return (obj == null || obj2 == null || (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : compareTo;
        }

        /* access modifiers changed from: package-private */
        public final Node find(int i, Object obj) {
            Thread thread;
            Thread thread2;
            Object obj2;
            Node node = this.first;
            while (true) {
                TreeNode treeNode = null;
                if (node == null) {
                    return null;
                }
                int i2 = this.lockState;
                if ((i2 & 3) == 0) {
                    Unsafe unsafe = f234U;
                    long j = LOCKSTATE;
                    if (unsafe.compareAndSwapInt(this, j, i2, i2 + 4)) {
                        try {
                            TreeNode treeNode2 = this.root;
                            if (treeNode2 != null) {
                                treeNode = treeNode2.findTreeNode(i, obj, (Class) null);
                            }
                            if (DesugarUnsafe.getAndAddInt(unsafe, this, j, -4) == 6 && (thread2 = this.waiter) != null) {
                                LockSupport.unpark(thread2);
                            }
                            return treeNode;
                        } catch (Throwable th) {
                            if (DesugarUnsafe.getAndAddInt(f234U, this, LOCKSTATE, -4) == 6 && (thread = this.waiter) != null) {
                                LockSupport.unpark(thread);
                            }
                            throw th;
                        }
                    }
                } else if (node.hash != i || ((obj2 = node.key) != obj && (obj2 == null || !obj.equals(obj2)))) {
                    node = node.next;
                }
            }
            return node;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a3, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final p009j$.util.concurrent.ConcurrentHashMap.TreeNode putTreeVal(int r16, java.lang.Object r17, java.lang.Object r18) {
            /*
                r15 = this;
                r1 = r15
                r0 = r16
                r4 = r17
                j$.util.concurrent.ConcurrentHashMap$TreeNode r2 = r1.root
                r8 = 0
                r9 = 0
                r10 = r2
                r2 = r8
                r3 = 0
            L_0x000c:
                if (r10 != 0) goto L_0x0022
                j$.util.concurrent.ConcurrentHashMap$TreeNode r9 = new j$.util.concurrent.ConcurrentHashMap$TreeNode
                r6 = 0
                r7 = 0
                r2 = r9
                r3 = r16
                r4 = r17
                r5 = r18
                r2.<init>(r3, r4, r5, r6, r7)
                r1.root = r9
                r1.first = r9
                goto L_0x00a3
            L_0x0022:
                int r5 = r10.hash
                r11 = 1
                if (r5 <= r0) goto L_0x002a
                r5 = -1
                r12 = -1
                goto L_0x0069
            L_0x002a:
                if (r5 >= r0) goto L_0x002e
                r12 = 1
                goto L_0x0069
            L_0x002e:
                java.lang.Object r5 = r10.key
                if (r5 == r4) goto L_0x00ab
                if (r5 == 0) goto L_0x003c
                boolean r6 = r4.equals(r5)
                if (r6 == 0) goto L_0x003c
                goto L_0x00ab
            L_0x003c:
                if (r2 != 0) goto L_0x0044
                java.lang.Class r2 = p009j$.util.concurrent.ConcurrentHashMap.comparableClassFor(r17)
                if (r2 == 0) goto L_0x004a
            L_0x0044:
                int r6 = p009j$.util.concurrent.ConcurrentHashMap.compareComparables(r2, r4, r5)
                if (r6 != 0) goto L_0x0068
            L_0x004a:
                if (r3 != 0) goto L_0x0062
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r10.left
                if (r3 == 0) goto L_0x0056
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r3.findTreeNode(r0, r4, r2)
                if (r3 != 0) goto L_0x0060
            L_0x0056:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r10.right
                if (r3 == 0) goto L_0x0061
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r3.findTreeNode(r0, r4, r2)
                if (r3 == 0) goto L_0x0061
            L_0x0060:
                return r3
            L_0x0061:
                r3 = 1
            L_0x0062:
                int r5 = tieBreakOrder(r4, r5)
                r12 = r5
                goto L_0x0069
            L_0x0068:
                r12 = r6
            L_0x0069:
                if (r12 > 0) goto L_0x006e
                j$.util.concurrent.ConcurrentHashMap$TreeNode r5 = r10.left
                goto L_0x0070
            L_0x006e:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r5 = r10.right
            L_0x0070:
                if (r5 != 0) goto L_0x00a8
                j$.util.concurrent.ConcurrentHashMap$TreeNode r13 = r1.first
                j$.util.concurrent.ConcurrentHashMap$TreeNode r14 = new j$.util.concurrent.ConcurrentHashMap$TreeNode
                r2 = r14
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r13
                r7 = r10
                r2.<init>(r3, r4, r5, r6, r7)
                r1.first = r14
                if (r13 == 0) goto L_0x0088
                r13.prev = r14
            L_0x0088:
                if (r12 > 0) goto L_0x008d
                r10.left = r14
                goto L_0x008f
            L_0x008d:
                r10.right = r14
            L_0x008f:
                boolean r0 = r10.red
                if (r0 != 0) goto L_0x0096
                r14.red = r11
                goto L_0x00a3
            L_0x0096:
                r15.lockRoot()
                j$.util.concurrent.ConcurrentHashMap$TreeNode r0 = r1.root     // Catch:{ all -> 0x00a4 }
                j$.util.concurrent.ConcurrentHashMap$TreeNode r0 = balanceInsertion(r0, r14)     // Catch:{ all -> 0x00a4 }
                r1.root = r0     // Catch:{ all -> 0x00a4 }
                r1.lockState = r9
            L_0x00a3:
                return r8
            L_0x00a4:
                r0 = move-exception
                r1.lockState = r9
                throw r0
            L_0x00a8:
                r10 = r5
                goto L_0x000c
            L_0x00ab:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.TreeBin.putTreeVal(int, java.lang.Object, java.lang.Object):j$.util.concurrent.ConcurrentHashMap$TreeNode");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x008e A[Catch:{ all -> 0x00c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00a9 A[Catch:{ all -> 0x00c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x00aa A[Catch:{ all -> 0x00c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x00ba A[Catch:{ all -> 0x00c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00bd A[Catch:{ all -> 0x00c8 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean removeTreeNode(p009j$.util.concurrent.ConcurrentHashMap.TreeNode r11) {
            /*
                r10 = this;
                j$.util.concurrent.ConcurrentHashMap$Node r0 = r11.next
                j$.util.concurrent.ConcurrentHashMap$TreeNode r0 = (p009j$.util.concurrent.ConcurrentHashMap.TreeNode) r0
                j$.util.concurrent.ConcurrentHashMap$TreeNode r1 = r11.prev
                if (r1 != 0) goto L_0x000b
                r10.first = r0
                goto L_0x000d
            L_0x000b:
                r1.next = r0
            L_0x000d:
                if (r0 == 0) goto L_0x0011
                r0.prev = r1
            L_0x0011:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r0 = r10.first
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x001a
                r10.root = r2
                return r1
            L_0x001a:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r0 = r10.root
                if (r0 == 0) goto L_0x00cc
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r0.right
                if (r3 == 0) goto L_0x00cc
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r0.left
                if (r3 == 0) goto L_0x00cc
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r3.left
                if (r3 != 0) goto L_0x002c
                goto L_0x00cc
            L_0x002c:
                r10.lockRoot()
                r1 = 0
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r11.left     // Catch:{ all -> 0x00c8 }
                j$.util.concurrent.ConcurrentHashMap$TreeNode r4 = r11.right     // Catch:{ all -> 0x00c8 }
                if (r3 == 0) goto L_0x0084
                if (r4 == 0) goto L_0x0084
                r5 = r4
            L_0x0039:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r6 = r5.left     // Catch:{ all -> 0x00c8 }
                if (r6 == 0) goto L_0x003f
                r5 = r6
                goto L_0x0039
            L_0x003f:
                boolean r6 = r5.red     // Catch:{ all -> 0x00c8 }
                boolean r7 = r11.red     // Catch:{ all -> 0x00c8 }
                r5.red = r7     // Catch:{ all -> 0x00c8 }
                r11.red = r6     // Catch:{ all -> 0x00c8 }
                j$.util.concurrent.ConcurrentHashMap$TreeNode r6 = r5.right     // Catch:{ all -> 0x00c8 }
                j$.util.concurrent.ConcurrentHashMap$TreeNode r7 = r11.parent     // Catch:{ all -> 0x00c8 }
                if (r5 != r4) goto L_0x0052
                r11.parent = r5     // Catch:{ all -> 0x00c8 }
                r5.right = r11     // Catch:{ all -> 0x00c8 }
                goto L_0x0065
            L_0x0052:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r8 = r5.parent     // Catch:{ all -> 0x00c8 }
                r11.parent = r8     // Catch:{ all -> 0x00c8 }
                if (r8 == 0) goto L_0x0061
                j$.util.concurrent.ConcurrentHashMap$TreeNode r9 = r8.left     // Catch:{ all -> 0x00c8 }
                if (r5 != r9) goto L_0x005f
                r8.left = r11     // Catch:{ all -> 0x00c8 }
                goto L_0x0061
            L_0x005f:
                r8.right = r11     // Catch:{ all -> 0x00c8 }
            L_0x0061:
                r5.right = r4     // Catch:{ all -> 0x00c8 }
                r4.parent = r5     // Catch:{ all -> 0x00c8 }
            L_0x0065:
                r11.left = r2     // Catch:{ all -> 0x00c8 }
                r11.right = r6     // Catch:{ all -> 0x00c8 }
                if (r6 == 0) goto L_0x006d
                r6.parent = r11     // Catch:{ all -> 0x00c8 }
            L_0x006d:
                r5.left = r3     // Catch:{ all -> 0x00c8 }
                r3.parent = r5     // Catch:{ all -> 0x00c8 }
                r5.parent = r7     // Catch:{ all -> 0x00c8 }
                if (r7 != 0) goto L_0x0077
                r0 = r5
                goto L_0x0080
            L_0x0077:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r7.left     // Catch:{ all -> 0x00c8 }
                if (r11 != r3) goto L_0x007e
                r7.left = r5     // Catch:{ all -> 0x00c8 }
                goto L_0x0080
            L_0x007e:
                r7.right = r5     // Catch:{ all -> 0x00c8 }
            L_0x0080:
                if (r6 == 0) goto L_0x008b
                r3 = r6
                goto L_0x008c
            L_0x0084:
                if (r3 == 0) goto L_0x0087
                goto L_0x008c
            L_0x0087:
                if (r4 == 0) goto L_0x008b
                r3 = r4
                goto L_0x008c
            L_0x008b:
                r3 = r11
            L_0x008c:
                if (r3 == r11) goto L_0x00a5
                j$.util.concurrent.ConcurrentHashMap$TreeNode r4 = r11.parent     // Catch:{ all -> 0x00c8 }
                r3.parent = r4     // Catch:{ all -> 0x00c8 }
                if (r4 != 0) goto L_0x0096
                r0 = r3
                goto L_0x009f
            L_0x0096:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r5 = r4.left     // Catch:{ all -> 0x00c8 }
                if (r11 != r5) goto L_0x009d
                r4.left = r3     // Catch:{ all -> 0x00c8 }
                goto L_0x009f
            L_0x009d:
                r4.right = r3     // Catch:{ all -> 0x00c8 }
            L_0x009f:
                r11.parent = r2     // Catch:{ all -> 0x00c8 }
                r11.right = r2     // Catch:{ all -> 0x00c8 }
                r11.left = r2     // Catch:{ all -> 0x00c8 }
            L_0x00a5:
                boolean r4 = r11.red     // Catch:{ all -> 0x00c8 }
                if (r4 == 0) goto L_0x00aa
                goto L_0x00ae
            L_0x00aa:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r0 = balanceDeletion(r0, r3)     // Catch:{ all -> 0x00c8 }
            L_0x00ae:
                r10.root = r0     // Catch:{ all -> 0x00c8 }
                if (r11 != r3) goto L_0x00c5
                j$.util.concurrent.ConcurrentHashMap$TreeNode r0 = r11.parent     // Catch:{ all -> 0x00c8 }
                if (r0 == 0) goto L_0x00c5
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r0.left     // Catch:{ all -> 0x00c8 }
                if (r11 != r3) goto L_0x00bd
                r0.left = r2     // Catch:{ all -> 0x00c8 }
                goto L_0x00c3
            L_0x00bd:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r0.right     // Catch:{ all -> 0x00c8 }
                if (r11 != r3) goto L_0x00c3
                r0.right = r2     // Catch:{ all -> 0x00c8 }
            L_0x00c3:
                r11.parent = r2     // Catch:{ all -> 0x00c8 }
            L_0x00c5:
                r10.lockState = r1
                return r1
            L_0x00c8:
                r11 = move-exception
                r10.lockState = r1
                throw r11
            L_0x00cc:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.TreeBin.removeTreeNode(j$.util.concurrent.ConcurrentHashMap$TreeNode):boolean");
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$TreeNode */
    static final class TreeNode extends Node {
        TreeNode left;
        TreeNode parent;
        TreeNode prev;
        boolean red;
        TreeNode right;

        TreeNode(int i, Object obj, Object obj2, Node node, TreeNode treeNode) {
            super(i, obj, obj2, node);
            this.parent = treeNode;
        }

        /* access modifiers changed from: package-private */
        public Node find(int i, Object obj) {
            return findTreeNode(i, obj, (Class) null);
        }

        /* access modifiers changed from: package-private */
        public final TreeNode findTreeNode(int i, Object obj, Class cls) {
            int compareComparables;
            if (obj == null) {
                return null;
            }
            TreeNode treeNode = this;
            do {
                TreeNode treeNode2 = treeNode.left;
                TreeNode treeNode3 = treeNode.right;
                int i2 = treeNode.hash;
                if (i2 <= i) {
                    if (i2 >= i) {
                        Object obj2 = treeNode.key;
                        if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                            return treeNode;
                        }
                        if (treeNode2 != null) {
                            if (treeNode3 != null) {
                                if ((cls == null && (cls = ConcurrentHashMap.comparableClassFor(obj)) == null) || (compareComparables = ConcurrentHashMap.compareComparables(cls, obj, obj2)) == 0) {
                                    TreeNode findTreeNode = treeNode3.findTreeNode(i, obj, cls);
                                    if (findTreeNode != null) {
                                        return findTreeNode;
                                    }
                                } else if (compareComparables >= 0) {
                                    treeNode2 = treeNode3;
                                }
                            }
                        }
                    }
                    treeNode = treeNode3;
                    continue;
                }
                treeNode = treeNode2;
                continue;
            } while (treeNode != null);
            return null;
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$ValueIterator */
    static final class ValueIterator extends BaseIterator implements java.util.Iterator, Enumeration, p009j$.util.Iterator {
        ValueIterator(Node[] nodeArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3, concurrentHashMap);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        public final Object next() {
            Node node = this.next;
            if (node != null) {
                Object obj = node.val;
                this.lastReturned = node;
                advance();
                return obj;
            }
            throw new NoSuchElementException();
        }

        public final Object nextElement() {
            return next();
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$ValueSpliterator */
    static final class ValueSpliterator extends Traverser implements Spliterator {
        long est;

        ValueSpliterator(Node[] nodeArr, int i, int i2, int i3, long j) {
            super(nodeArr, i, i2, i3);
            this.est = j;
        }

        public int characteristics() {
            return 4352;
        }

        public long estimateSize() {
            return this.est;
        }

        public void forEachRemaining(Consumer consumer) {
            Objects.requireNonNull(consumer);
            while (true) {
                Node advance = advance();
                if (advance != null) {
                    consumer.accept(advance.val);
                } else {
                    return;
                }
            }
        }

        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return p009j$.util.Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return p009j$.util.Objects.$default$hasCharacteristics(this, i);
        }

        public boolean tryAdvance(Consumer consumer) {
            Objects.requireNonNull(consumer);
            Node advance = advance();
            if (advance == null) {
                return false;
            }
            consumer.accept(advance.val);
            return true;
        }

        public Spliterator trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new ValueSpliterator(nodeArr, i4, i3, i2, j);
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$ValuesView */
    static final class ValuesView extends CollectionView implements Collection {
        ValuesView(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(java.util.Collection collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean contains(Object obj) {
            return this.map.containsValue(obj);
        }

        public void forEach(Consumer consumer) {
            Objects.requireNonNull(consumer);
            Node[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node advance = traverser.advance();
                    if (advance != null) {
                        consumer.accept(advance.val);
                    } else {
                        return;
                    }
                }
            }
        }

        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        public final java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new ValueIterator(nodeArr, length, 0, length, concurrentHashMap);
        }

        public /* synthetic */ Stream parallelStream() {
            return C$r8$wrapper$java$util$stream$Stream$WRP.convert(p009j$.util.Objects.$default$parallelStream(this));
        }

        public final boolean remove(Object obj) {
            BaseIterator baseIterator;
            if (obj == null) {
                return false;
            }
            java.util.Iterator it = iterator();
            do {
                baseIterator = (BaseIterator) it;
                if (!baseIterator.hasNext()) {
                    return false;
                }
            } while (!obj.equals(((ValueIterator) it).next()));
            baseIterator.remove();
            return true;
        }

        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return p009j$.util.Objects.$default$removeIf(this, predicate);
        }

        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return p009j$.util.Objects.$default$removeIf(this, C$r8$wrapper$java$util$function$Predicate$VWRP.convert(predicate));
        }

        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            long sumCount = concurrentHashMap.sumCount();
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            long j = 0;
            if (sumCount >= 0) {
                j = sumCount;
            }
            return new ValueSpliterator(nodeArr, length, 0, length, j);
        }

        public Object[] toArray(IntFunction intFunction) {
            return toArray((Object[]) C$r8$wrapper$java$util$function$IntFunction$VWRP.convert(intFunction).apply(0));
        }
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", Segment[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        try {
            Unsafe unsafe = DesugarUnsafe.getUnsafe();
            f233U = unsafe;
            Class<ConcurrentHashMap> cls2 = ConcurrentHashMap.class;
            SIZECTL = unsafe.objectFieldOffset(cls2.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = unsafe.objectFieldOffset(cls2.getDeclaredField("transferIndex"));
            BASECOUNT = unsafe.objectFieldOffset(cls2.getDeclaredField("baseCount"));
            CELLSBUSY = unsafe.objectFieldOffset(cls2.getDeclaredField("cellsBusy"));
            CELLVALUE = unsafe.objectFieldOffset(CounterCell.class.getDeclaredField("value"));
            Class<Node[]> cls3 = Node[].class;
            ABASE = (long) unsafe.arrayBaseOffset(cls3);
            int arrayIndexScale = unsafe.arrayIndexScale(cls3);
            if (((arrayIndexScale - 1) & arrayIndexScale) == 0) {
                ASHIFT = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
                return;
            }
            throw new Error("data type scale not a power of two");
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i) {
        if (i >= 0) {
            this.sizeCtl = i >= 536870912 ? 1073741824 : tableSizeFor(i + (i >>> 1) + 1);
            return;
        }
        throw new IllegalArgumentException();
    }

    public ConcurrentHashMap(int i, float f, int i2) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        long j = (long) (((double) (((float) ((long) (i < i2 ? i2 : i))) / f)) + 1.0d);
        this.sizeCtl = j >= 1073741824 ? 1073741824 : tableSizeFor((int) j);
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r1.compareAndSwapLong(r11, r3, r5, r9) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addCount(long r12, int r14) {
        /*
            r11 = this;
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r0 = r11.counterCells
            if (r0 != 0) goto L_0x0014
            sun.misc.Unsafe r1 = f233U
            long r3 = BASECOUNT
            long r5 = r11.baseCount
            long r9 = r5 + r12
            r2 = r11
            r7 = r9
            boolean r1 = r1.compareAndSwapLong(r2, r3, r5, r7)
            if (r1 != 0) goto L_0x003b
        L_0x0014:
            r1 = 1
            if (r0 == 0) goto L_0x0094
            int r2 = r0.length
            int r2 = r2 - r1
            if (r2 < 0) goto L_0x0094
            int r3 = p009j$.util.concurrent.ThreadLocalRandom.getProbe()
            r2 = r2 & r3
            r4 = r0[r2]
            if (r4 == 0) goto L_0x0094
            sun.misc.Unsafe r3 = f233U
            long r5 = CELLVALUE
            long r7 = r4.value
            long r9 = r7 + r12
            boolean r0 = r3.compareAndSwapLong(r4, r5, r7, r9)
            if (r0 != 0) goto L_0x0034
            r1 = r0
            goto L_0x0094
        L_0x0034:
            if (r14 > r1) goto L_0x0037
            return
        L_0x0037:
            long r9 = r11.sumCount()
        L_0x003b:
            if (r14 < 0) goto L_0x0093
        L_0x003d:
            int r4 = r11.sizeCtl
            long r12 = (long) r4
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x0093
            j$.util.concurrent.ConcurrentHashMap$Node[] r12 = r11.table
            if (r12 == 0) goto L_0x0093
            int r13 = r12.length
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 >= r14) goto L_0x0093
            int r13 = resizeStamp(r13)
            if (r4 >= 0) goto L_0x007b
            int r14 = r4 >>> 16
            if (r14 != r13) goto L_0x0093
            int r14 = r13 + 1
            if (r4 == r14) goto L_0x0093
            r14 = 65535(0xffff, float:9.1834E-41)
            int r13 = r13 + r14
            if (r4 == r13) goto L_0x0093
            j$.util.concurrent.ConcurrentHashMap$Node[] r13 = r11.nextTable
            if (r13 == 0) goto L_0x0093
            int r14 = r11.transferIndex
            if (r14 > 0) goto L_0x006a
            goto L_0x0093
        L_0x006a:
            sun.misc.Unsafe r0 = f233U
            long r2 = SIZECTL
            int r5 = r4 + 1
            r1 = r11
            boolean r14 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r14 == 0) goto L_0x008e
            r11.transfer(r12, r13)
            goto L_0x008e
        L_0x007b:
            sun.misc.Unsafe r0 = f233U
            long r2 = SIZECTL
            int r13 = r13 << 16
            int r5 = r13 + 2
            r1 = r11
            boolean r13 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r13 == 0) goto L_0x008e
            r13 = 0
            r11.transfer(r12, r13)
        L_0x008e:
            long r9 = r11.sumCount()
            goto L_0x003d
        L_0x0093:
            return
        L_0x0094:
            r11.fullAddCount(r12, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.addCount(long, int):void");
    }

    static final boolean casTabAt(Node[] nodeArr, int i, Node node, Node node2) {
        return f233U.compareAndSwapObject(nodeArr, (((long) i) << ASHIFT) + ABASE, (Object) null, node2);
    }

    static Class comparableClassFor(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            return cls;
        }
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    return cls;
                }
            }
        }
        return null;
    }

    static int compareComparables(Class cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009b, code lost:
        if (r9.counterCells != r7) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009d, code lost:
        r1 = new p009j$.util.concurrent.ConcurrentHashMap.CounterCell[(r8 << 1)];
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a2, code lost:
        if (r2 >= r8) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a4, code lost:
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ab, code lost:
        r9.counterCells = r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0101 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x001b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void fullAddCount(long r25, boolean r27) {
        /*
            r24 = this;
            r9 = r24
            r10 = r25
            int r0 = p009j$.util.concurrent.ThreadLocalRandom.getProbe()
            r12 = 1
            if (r0 != 0) goto L_0x0015
            p009j$.util.concurrent.ThreadLocalRandom.localInit()
            int r0 = p009j$.util.concurrent.ThreadLocalRandom.getProbe()
            r1 = r0
            r0 = 1
            goto L_0x0018
        L_0x0015:
            r1 = r0
            r0 = r27
        L_0x0018:
            r13 = 0
            r14 = r1
            r15 = 0
        L_0x001b:
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r7 = r9.counterCells
            if (r7 == 0) goto L_0x00bd
            int r8 = r7.length
            if (r8 <= 0) goto L_0x00bd
            int r1 = r8 + -1
            r1 = r1 & r14
            r1 = r7[r1]
            if (r1 != 0) goto L_0x0061
            int r1 = r9.cellsBusy
            if (r1 != 0) goto L_0x00b6
            j$.util.concurrent.ConcurrentHashMap$CounterCell r7 = new j$.util.concurrent.ConcurrentHashMap$CounterCell
            r7.<init>(r10)
            int r1 = r9.cellsBusy
            if (r1 != 0) goto L_0x00b6
            sun.misc.Unsafe r1 = f233U
            long r3 = CELLSBUSY
            r5 = 0
            r6 = 1
            r2 = r24
            boolean r1 = r1.compareAndSwapInt(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x00b6
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r1 = r9.counterCells     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0056
            int r2 = r1.length     // Catch:{ all -> 0x005d }
            if (r2 <= 0) goto L_0x0056
            int r2 = r2 + -1
            r2 = r2 & r14
            r3 = r1[r2]     // Catch:{ all -> 0x005d }
            if (r3 != 0) goto L_0x0056
            r1[r2] = r7     // Catch:{ all -> 0x005d }
            r1 = 1
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            r9.cellsBusy = r13
            if (r1 == 0) goto L_0x001b
            goto L_0x0101
        L_0x005d:
            r0 = move-exception
            r9.cellsBusy = r13
            throw r0
        L_0x0061:
            if (r0 != 0) goto L_0x0065
            r0 = 1
            goto L_0x00b7
        L_0x0065:
            sun.misc.Unsafe r2 = f233U
            long r18 = CELLVALUE
            long r3 = r1.value
            long r22 = r3 + r10
            r16 = r2
            r17 = r1
            r20 = r3
            boolean r1 = r16.compareAndSwapLong(r17, r18, r20, r22)
            if (r1 == 0) goto L_0x007b
            goto L_0x0101
        L_0x007b:
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r1 = r9.counterCells
            if (r1 != r7) goto L_0x00b6
            int r1 = NCPU
            if (r8 < r1) goto L_0x0084
            goto L_0x00b6
        L_0x0084:
            if (r15 != 0) goto L_0x0088
            r15 = 1
            goto L_0x00b7
        L_0x0088:
            int r1 = r9.cellsBusy
            if (r1 != 0) goto L_0x00b7
            long r3 = CELLSBUSY
            r5 = 0
            r6 = 1
            r1 = r2
            r2 = r24
            boolean r1 = r1.compareAndSwapInt(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x00b7
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r1 = r9.counterCells     // Catch:{ all -> 0x00b2 }
            if (r1 != r7) goto L_0x00ad
            int r1 = r8 << 1
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r1 = new p009j$.util.concurrent.ConcurrentHashMap.CounterCell[r1]     // Catch:{ all -> 0x00b2 }
            r2 = 0
        L_0x00a2:
            if (r2 >= r8) goto L_0x00ab
            r3 = r7[r2]     // Catch:{ all -> 0x00b2 }
            r1[r2] = r3     // Catch:{ all -> 0x00b2 }
            int r2 = r2 + 1
            goto L_0x00a2
        L_0x00ab:
            r9.counterCells = r1     // Catch:{ all -> 0x00b2 }
        L_0x00ad:
            r9.cellsBusy = r13
            r1 = r14
            goto L_0x0018
        L_0x00b2:
            r0 = move-exception
            r9.cellsBusy = r13
            throw r0
        L_0x00b6:
            r15 = 0
        L_0x00b7:
            int r14 = p009j$.util.concurrent.ThreadLocalRandom.advanceProbe(r14)
            goto L_0x001b
        L_0x00bd:
            int r1 = r9.cellsBusy
            if (r1 != 0) goto L_0x00f1
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r1 = r9.counterCells
            if (r1 != r7) goto L_0x00f1
            sun.misc.Unsafe r1 = f233U
            long r3 = CELLSBUSY
            r5 = 0
            r6 = 1
            r2 = r24
            boolean r1 = r1.compareAndSwapInt(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x00f1
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r1 = r9.counterCells     // Catch:{ all -> 0x00ed }
            if (r1 != r7) goto L_0x00e7
            r1 = 2
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r1 = new p009j$.util.concurrent.ConcurrentHashMap.CounterCell[r1]     // Catch:{ all -> 0x00ed }
            r2 = r14 & 1
            j$.util.concurrent.ConcurrentHashMap$CounterCell r3 = new j$.util.concurrent.ConcurrentHashMap$CounterCell     // Catch:{ all -> 0x00ed }
            r3.<init>(r10)     // Catch:{ all -> 0x00ed }
            r1[r2] = r3     // Catch:{ all -> 0x00ed }
            r9.counterCells = r1     // Catch:{ all -> 0x00ed }
            r1 = 1
            goto L_0x00e8
        L_0x00e7:
            r1 = 0
        L_0x00e8:
            r9.cellsBusy = r13
            if (r1 == 0) goto L_0x001b
            goto L_0x0101
        L_0x00ed:
            r0 = move-exception
            r9.cellsBusy = r13
            throw r0
        L_0x00f1:
            sun.misc.Unsafe r1 = f233U
            long r3 = BASECOUNT
            long r5 = r9.baseCount
            long r7 = r5 + r10
            r2 = r24
            boolean r1 = r1.compareAndSwapLong(r2, r3, r5, r7)
            if (r1 == 0) goto L_0x001b
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.fullAddCount(long, boolean):void");
    }

    /* JADX INFO: finally extract failed */
    private final Node[] initTable() {
        while (true) {
            Node[] nodeArr = this.table;
            if (nodeArr != null && nodeArr.length != 0) {
                return nodeArr;
            }
            int i = this.sizeCtl;
            if (i < 0) {
                Thread.yield();
            } else {
                if (f233U.compareAndSwapInt(this, SIZECTL, i, -1)) {
                    try {
                        Node[] nodeArr2 = this.table;
                        if (nodeArr2 == null || nodeArr2.length == 0) {
                            int i2 = i > 0 ? i : 16;
                            Node[] nodeArr3 = new Node[i2];
                            this.table = nodeArr3;
                            i = i2 - (i2 >>> 2);
                            nodeArr2 = nodeArr3;
                        }
                        this.sizeCtl = i;
                        return nodeArr2;
                    } catch (Throwable th) {
                        this.sizeCtl = i;
                        throw th;
                    }
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j;
        int i;
        boolean z;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j2 = 0;
        long j3 = 0;
        Node node = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j = 1;
            if (readObject != null && readObject2 != null) {
                j3++;
                node = new Node(spread(readObject.hashCode()), readObject, readObject2, node);
            }
        }
        if (j3 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j3 >= 536870912) {
            i = 1073741824;
        } else {
            int i2 = (int) j3;
            i = tableSizeFor(i2 + (i2 >>> 1) + 1);
        }
        Node[] nodeArr = new Node[i];
        int i3 = i - 1;
        while (node != null) {
            Node node2 = node.next;
            int i4 = node.hash;
            int i5 = i4 & i3;
            Node tabAt = tabAt(nodeArr, i5);
            if (tabAt == null) {
                z = true;
            } else {
                Object obj2 = node.key;
                if (tabAt.hash >= 0) {
                    Node node3 = tabAt;
                    int i6 = 0;
                    while (true) {
                        if (node3 == null) {
                            z = true;
                            break;
                        } else if (node3.hash != i4 || ((obj = node3.key) != obj2 && (obj == null || !obj2.equals(obj)))) {
                            i6++;
                            node3 = node3.next;
                        }
                    }
                    z = false;
                    if (z && i6 >= 8) {
                        j2++;
                        node.next = tabAt;
                        Node node4 = node;
                        TreeNode treeNode = null;
                        TreeNode treeNode2 = null;
                        while (node4 != null) {
                            long j4 = j2;
                            TreeNode treeNode3 = new TreeNode(node4.hash, node4.key, node4.val, (Node) null, (TreeNode) null);
                            treeNode3.prev = treeNode2;
                            if (treeNode2 == null) {
                                treeNode = treeNode3;
                            } else {
                                treeNode2.next = treeNode3;
                            }
                            node4 = node4.next;
                            treeNode2 = treeNode3;
                            j2 = j4;
                        }
                        long j5 = j2;
                        setTabAt(nodeArr, i5, new TreeBin(treeNode));
                    }
                } else if (((TreeBin) tabAt).putTreeVal(i4, obj2, node.val) == null) {
                    j2 += j;
                }
                z = false;
            }
            if (z) {
                j2++;
                node.next = tabAt;
                setTabAt(nodeArr, i5, node);
            }
            j = 1;
            node = node2;
        }
        this.table = nodeArr;
        this.sizeCtl = i - (i >>> 2);
        this.baseCount = j2;
    }

    static final int resizeStamp(int i) {
        return Integer.numberOfLeadingZeros(i) | 32768;
    }

    static final void setTabAt(Node[] nodeArr, int i, Node node) {
        f233U.putObjectVolatile(nodeArr, (((long) i) << ASHIFT) + ABASE, node);
    }

    static final int spread(int i) {
        return (i ^ (i >>> 16)) & Integer.MAX_VALUE;
    }

    static final Node tabAt(Node[] nodeArr, int i) {
        return (Node) f233U.getObjectVolatile(nodeArr, (((long) i) << ASHIFT) + ABASE);
    }

    private static final int tableSizeFor(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        if (i7 < 0) {
            return 1;
        }
        if (i7 >= 1073741824) {
            return 1073741824;
        }
        return 1 + i7;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: j$.util.concurrent.ConcurrentHashMap$Node} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: j$.util.concurrent.ConcurrentHashMap$Node} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: j$.util.concurrent.ConcurrentHashMap$TreeNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: j$.util.concurrent.ConcurrentHashMap$Node} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: j$.util.concurrent.ConcurrentHashMap$Node} */
    /* JADX WARNING: type inference failed for: r13v14, types: [j$.util.concurrent.ConcurrentHashMap$Node] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void transfer(p009j$.util.concurrent.ConcurrentHashMap.Node[] r31, p009j$.util.concurrent.ConcurrentHashMap.Node[] r32) {
        /*
            r30 = this;
            r7 = r30
            r0 = r31
            int r8 = r0.length
            int r1 = NCPU
            r9 = 1
            if (r1 <= r9) goto L_0x000e
            int r2 = r8 >>> 3
            int r2 = r2 / r1
            goto L_0x000f
        L_0x000e:
            r2 = r8
        L_0x000f:
            r10 = 16
            if (r2 >= r10) goto L_0x0016
            r11 = 16
            goto L_0x0017
        L_0x0016:
            r11 = r2
        L_0x0017:
            if (r32 != 0) goto L_0x0029
            int r1 = r8 << 1
            j$.util.concurrent.ConcurrentHashMap$Node[] r1 = new p009j$.util.concurrent.ConcurrentHashMap.Node[r1]     // Catch:{ all -> 0x0023 }
            r7.nextTable = r1
            r7.transferIndex = r8
            r12 = r1
            goto L_0x002b
        L_0x0023:
            r0 = 2147483647(0x7fffffff, float:NaN)
            r7.sizeCtl = r0
            return
        L_0x0029:
            r12 = r32
        L_0x002b:
            int r13 = r12.length
            j$.util.concurrent.ConcurrentHashMap$ForwardingNode r14 = new j$.util.concurrent.ConcurrentHashMap$ForwardingNode
            r14.<init>(r12)
            r3 = r0
            r5 = 0
            r6 = 0
            r16 = 1
            r17 = 0
        L_0x0038:
            r1 = -1
            if (r16 == 0) goto L_0x0082
            int r5 = r5 + -1
            if (r5 >= r6) goto L_0x0075
            if (r17 == 0) goto L_0x0042
            goto L_0x0075
        L_0x0042:
            int r4 = r7.transferIndex
            if (r4 > 0) goto L_0x0049
            r15 = r3
            r5 = -1
            goto L_0x007e
        L_0x0049:
            sun.misc.Unsafe r1 = f233U
            long r18 = TRANSFERINDEX
            if (r4 <= r11) goto L_0x0054
            int r2 = r4 - r11
            r20 = r2
            goto L_0x0056
        L_0x0054:
            r20 = 0
        L_0x0056:
            r2 = r30
            r15 = r3
            r21 = r4
            r3 = r18
            r18 = r5
            r5 = r21
            r19 = r6
            r6 = r20
            boolean r1 = r1.compareAndSwapInt(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x0071
            int r4 = r21 + -1
            r5 = r4
            r6 = r20
            goto L_0x007e
        L_0x0071:
            r3 = r15
            r5 = r18
            goto L_0x009b
        L_0x0075:
            r15 = r3
            r18 = r5
            r19 = r6
            r5 = r18
            r6 = r19
        L_0x007e:
            r3 = r15
            r16 = 0
            goto L_0x0038
        L_0x0082:
            r15 = r3
            r19 = r6
            r2 = 0
            if (r5 < 0) goto L_0x01ab
            if (r5 >= r8) goto L_0x01ab
            int r3 = r5 + r8
            if (r3 < r13) goto L_0x0090
            goto L_0x01ab
        L_0x0090:
            j$.util.concurrent.ConcurrentHashMap$Node r4 = tabAt(r15, r5)
            if (r4 != 0) goto L_0x009e
            boolean r16 = casTabAt(r15, r5, r2, r14)
            r3 = r15
        L_0x009b:
            r6 = r19
            goto L_0x0038
        L_0x009e:
            int r6 = r4.hash
            if (r6 != r1) goto L_0x00a8
            r3 = r15
            r6 = r19
            r16 = 1
            goto L_0x0038
        L_0x00a8:
            monitor-enter(r4)
            j$.util.concurrent.ConcurrentHashMap$Node r1 = tabAt(r15, r5)     // Catch:{ all -> 0x01a8 }
            if (r1 != r4) goto L_0x0193
            if (r6 < 0) goto L_0x0105
            r1 = r6 & r8
            j$.util.concurrent.ConcurrentHashMap$Node r6 = r4.next     // Catch:{ all -> 0x01a8 }
            r10 = r4
        L_0x00b6:
            if (r6 == 0) goto L_0x00c3
            int r9 = r6.hash     // Catch:{ all -> 0x01a8 }
            r9 = r9 & r8
            if (r9 == r1) goto L_0x00bf
            r10 = r6
            r1 = r9
        L_0x00bf:
            j$.util.concurrent.ConcurrentHashMap$Node r6 = r6.next     // Catch:{ all -> 0x01a8 }
            r9 = 1
            goto L_0x00b6
        L_0x00c3:
            if (r1 != 0) goto L_0x00c8
            r1 = r2
            r2 = r10
            goto L_0x00c9
        L_0x00c8:
            r1 = r10
        L_0x00c9:
            r6 = r4
        L_0x00ca:
            if (r6 == r10) goto L_0x00f4
            int r9 = r6.hash     // Catch:{ all -> 0x01a8 }
            r16 = r10
            java.lang.Object r10 = r6.key     // Catch:{ all -> 0x01a8 }
            r21 = r11
            java.lang.Object r11 = r6.val     // Catch:{ all -> 0x01a8 }
            r22 = r9 & r8
            if (r22 != 0) goto L_0x00e3
            r22 = r13
            j$.util.concurrent.ConcurrentHashMap$Node r13 = new j$.util.concurrent.ConcurrentHashMap$Node     // Catch:{ all -> 0x01a8 }
            r13.<init>(r9, r10, r11, r2)     // Catch:{ all -> 0x01a8 }
            r2 = r13
            goto L_0x00eb
        L_0x00e3:
            r22 = r13
            j$.util.concurrent.ConcurrentHashMap$Node r13 = new j$.util.concurrent.ConcurrentHashMap$Node     // Catch:{ all -> 0x01a8 }
            r13.<init>(r9, r10, r11, r1)     // Catch:{ all -> 0x01a8 }
            r1 = r13
        L_0x00eb:
            j$.util.concurrent.ConcurrentHashMap$Node r6 = r6.next     // Catch:{ all -> 0x01a8 }
            r10 = r16
            r11 = r21
            r13 = r22
            goto L_0x00ca
        L_0x00f4:
            r21 = r11
            r22 = r13
            setTabAt(r12, r5, r2)     // Catch:{ all -> 0x01a8 }
            setTabAt(r12, r3, r1)     // Catch:{ all -> 0x01a8 }
            setTabAt(r15, r5, r14)     // Catch:{ all -> 0x01a8 }
            r7 = r14
            r3 = r15
            goto L_0x0190
        L_0x0105:
            r21 = r11
            r22 = r13
            boolean r1 = r4 instanceof p009j$.util.concurrent.ConcurrentHashMap.TreeBin     // Catch:{ all -> 0x01a8 }
            if (r1 == 0) goto L_0x0197
            r1 = r4
            j$.util.concurrent.ConcurrentHashMap$TreeBin r1 = (p009j$.util.concurrent.ConcurrentHashMap.TreeBin) r1     // Catch:{ all -> 0x01a8 }
            j$.util.concurrent.ConcurrentHashMap$TreeNode r6 = r1.first     // Catch:{ all -> 0x01a8 }
            r9 = r2
            r10 = r9
            r11 = r6
            r13 = 0
            r15 = 0
            r6 = r10
        L_0x0118:
            if (r11 == 0) goto L_0x015b
            r16 = r1
            int r1 = r11.hash     // Catch:{ all -> 0x01a8 }
            j$.util.concurrent.ConcurrentHashMap$TreeNode r7 = new j$.util.concurrent.ConcurrentHashMap$TreeNode     // Catch:{ all -> 0x01a8 }
            java.lang.Object r0 = r11.key     // Catch:{ all -> 0x01a8 }
            r29 = r14
            java.lang.Object r14 = r11.val     // Catch:{ all -> 0x01a8 }
            r27 = 0
            r28 = 0
            r23 = r7
            r24 = r1
            r25 = r0
            r26 = r14
            r23.<init>(r24, r25, r26, r27, r28)     // Catch:{ all -> 0x01a8 }
            r0 = r1 & r8
            if (r0 != 0) goto L_0x0145
            r7.prev = r10     // Catch:{ all -> 0x01a8 }
            if (r10 != 0) goto L_0x013f
            r2 = r7
            goto L_0x0141
        L_0x013f:
            r10.next = r7     // Catch:{ all -> 0x01a8 }
        L_0x0141:
            int r13 = r13 + 1
            r10 = r7
            goto L_0x0150
        L_0x0145:
            r7.prev = r9     // Catch:{ all -> 0x01a8 }
            if (r9 != 0) goto L_0x014b
            r6 = r7
            goto L_0x014d
        L_0x014b:
            r9.next = r7     // Catch:{ all -> 0x01a8 }
        L_0x014d:
            int r15 = r15 + 1
            r9 = r7
        L_0x0150:
            j$.util.concurrent.ConcurrentHashMap$Node r11 = r11.next     // Catch:{ all -> 0x01a8 }
            r7 = r30
            r0 = r31
            r1 = r16
            r14 = r29
            goto L_0x0118
        L_0x015b:
            r16 = r1
            r29 = r14
            r0 = 6
            if (r13 > r0) goto L_0x0167
            j$.util.concurrent.ConcurrentHashMap$Node r1 = untreeify(r2)     // Catch:{ all -> 0x01a8 }
            goto L_0x0171
        L_0x0167:
            if (r15 == 0) goto L_0x016f
            j$.util.concurrent.ConcurrentHashMap$TreeBin r1 = new j$.util.concurrent.ConcurrentHashMap$TreeBin     // Catch:{ all -> 0x01a8 }
            r1.<init>(r2)     // Catch:{ all -> 0x01a8 }
            goto L_0x0171
        L_0x016f:
            r1 = r16
        L_0x0171:
            if (r15 > r0) goto L_0x0178
            j$.util.concurrent.ConcurrentHashMap$Node r0 = untreeify(r6)     // Catch:{ all -> 0x01a8 }
            goto L_0x0182
        L_0x0178:
            if (r13 == 0) goto L_0x0180
            j$.util.concurrent.ConcurrentHashMap$TreeBin r0 = new j$.util.concurrent.ConcurrentHashMap$TreeBin     // Catch:{ all -> 0x01a8 }
            r0.<init>(r6)     // Catch:{ all -> 0x01a8 }
            goto L_0x0182
        L_0x0180:
            r0 = r16
        L_0x0182:
            setTabAt(r12, r5, r1)     // Catch:{ all -> 0x01a8 }
            setTabAt(r12, r3, r0)     // Catch:{ all -> 0x01a8 }
            r0 = r31
            r7 = r29
            setTabAt(r0, r5, r7)     // Catch:{ all -> 0x01a8 }
            r3 = r0
        L_0x0190:
            r16 = 1
            goto L_0x0199
        L_0x0193:
            r21 = r11
            r22 = r13
        L_0x0197:
            r7 = r14
            r3 = r15
        L_0x0199:
            monitor-exit(r4)     // Catch:{ all -> 0x01a8 }
            r14 = r7
            r6 = r19
            r11 = r21
            r13 = r22
            r9 = 1
            r10 = 16
            r7 = r30
            goto L_0x0038
        L_0x01a8:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x01a8 }
            throw r0
        L_0x01ab:
            r21 = r11
            r22 = r13
            r7 = r14
            r9 = r30
            if (r17 == 0) goto L_0x01c1
            r9.nextTable = r2
            r9.table = r12
            int r0 = r8 << 1
            r10 = 1
            int r1 = r8 >>> 1
            int r0 = r0 - r1
            r9.sizeCtl = r0
            return
        L_0x01c1:
            r10 = 1
            sun.misc.Unsafe r1 = f233U
            long r3 = SIZECTL
            int r11 = r9.sizeCtl
            int r6 = r11 + -1
            r2 = r30
            r13 = r5
            r5 = r11
            boolean r1 = r1.compareAndSwapInt(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x01f3
            int r11 = r11 + -2
            int r1 = resizeStamp(r8)
            r2 = 16
            int r1 = r1 << r2
            if (r11 == r1) goto L_0x01e0
            return
        L_0x01e0:
            r14 = r7
            r5 = r8
            r7 = r9
            r3 = r15
            r6 = r19
            r11 = r21
            r13 = r22
            r9 = 1
            r10 = 16
            r16 = 1
            r17 = 1
            goto L_0x0038
        L_0x01f3:
            r14 = r7
            r7 = r9
            r5 = r13
            r3 = r15
            r6 = r19
            r11 = r21
            r13 = r22
            r9 = 1
            r10 = 16
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.transfer(j$.util.concurrent.ConcurrentHashMap$Node[], j$.util.concurrent.ConcurrentHashMap$Node[]):void");
    }

    private final void treeifyBin(Node[] nodeArr, int i) {
        int length = nodeArr.length;
        if (length < 64) {
            tryPresize(length << 1);
            return;
        }
        Node tabAt = tabAt(nodeArr, i);
        if (tabAt != null && tabAt.hash >= 0) {
            synchronized (tabAt) {
                if (tabAt(nodeArr, i) == tabAt) {
                    TreeNode treeNode = null;
                    Node node = tabAt;
                    TreeNode treeNode2 = null;
                    while (node != null) {
                        TreeNode treeNode3 = new TreeNode(node.hash, node.key, node.val, (Node) null, (TreeNode) null);
                        treeNode3.prev = treeNode2;
                        if (treeNode2 == null) {
                            treeNode = treeNode3;
                        } else {
                            treeNode2.next = treeNode3;
                        }
                        node = node.next;
                        treeNode2 = treeNode3;
                    }
                    setTabAt(nodeArr, i, new TreeBin(treeNode));
                }
            }
        }
    }

    private final void tryPresize(int i) {
        int length;
        Node[] nodeArr;
        int tableSizeFor = i >= 536870912 ? 1073741824 : tableSizeFor(i + (i >>> 1) + 1);
        while (true) {
            int i2 = this.sizeCtl;
            if (i2 >= 0) {
                Node[] nodeArr2 = this.table;
                if (nodeArr2 == null || (length = nodeArr2.length) == 0) {
                    int i3 = i2 > tableSizeFor ? i2 : tableSizeFor;
                    if (f233U.compareAndSwapInt(this, SIZECTL, i2, -1)) {
                        try {
                            if (this.table == nodeArr2) {
                                this.table = new Node[i3];
                                i2 = i3 - (i3 >>> 2);
                            }
                        } finally {
                            this.sizeCtl = i2;
                        }
                    }
                } else if (tableSizeFor > i2 && length < 1073741824) {
                    if (nodeArr2 == this.table) {
                        int resizeStamp = resizeStamp(length);
                        if (i2 >= 0) {
                            if (f233U.compareAndSwapInt(this, SIZECTL, i2, (resizeStamp << 16) + 2)) {
                                transfer(nodeArr2, (Node[]) null);
                            }
                        } else if ((i2 >>> 16) == resizeStamp && i2 != resizeStamp + 1 && i2 != resizeStamp + 65535 && (nodeArr = this.nextTable) != null && this.transferIndex > 0) {
                            if (f233U.compareAndSwapInt(this, SIZECTL, i2, i2 + 1)) {
                                transfer(nodeArr2, nodeArr);
                            }
                        } else {
                            return;
                        }
                    } else {
                        continue;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    static Node untreeify(Node node) {
        Node node2 = null;
        Node node3 = null;
        while (node != null) {
            Node node4 = new Node(node.hash, node.key, node.val, (Node) null);
            if (node3 == null) {
                node2 = node4;
            } else {
                node3.next = node4;
            }
            node = node.next;
            node3 = node4;
        }
        return node2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int i = 1;
        int i2 = 0;
        while (i < 16) {
            i2++;
            i <<= 1;
        }
        int i3 = 32 - i2;
        int i4 = i - 1;
        Segment[] segmentArr = new Segment[16];
        for (int i5 = 0; i5 < 16; i5++) {
            segmentArr[i5] = new Segment(0.75f);
        }
        objectOutputStream.putFields().put("segments", segmentArr);
        objectOutputStream.putFields().put("segmentShift", i3);
        objectOutputStream.putFields().put("segmentMask", i4);
        objectOutputStream.writeFields();
        Node[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                objectOutputStream.writeObject(advance.key);
                objectOutputStream.writeObject(advance.val);
            }
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject((Object) null);
    }

    public void clear() {
        Node[] nodeArr = this.table;
        long j = 0;
        loop0:
        while (true) {
            int i = 0;
            while (nodeArr != null && i < nodeArr.length) {
                Node tabAt = tabAt(nodeArr, i);
                if (tabAt == null) {
                    i++;
                } else {
                    int i2 = tabAt.hash;
                    if (i2 == -1) {
                        nodeArr = helpTransfer(nodeArr, tabAt);
                    } else {
                        synchronized (tabAt) {
                            if (tabAt(nodeArr, i) == tabAt) {
                                for (Node node = i2 >= 0 ? tabAt : tabAt instanceof TreeBin ? ((TreeBin) tabAt).first : null; node != null; node = node.next) {
                                    j--;
                                }
                                setTabAt(nodeArr, i, (Node) null);
                                i++;
                            }
                        }
                    }
                }
            }
        }
        if (j != 0) {
            addCount(j, -1);
        }
    }

    /* JADX INFO: finally extract failed */
    public Object compute(Object obj, BiFunction biFunction) {
        Object obj2;
        Object obj3;
        int i;
        Node node;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int spread = spread(obj.hashCode());
        Node[] nodeArr = this.table;
        int i2 = 0;
        Object obj4 = null;
        int i3 = 0;
        while (true) {
            if (nodeArr != null) {
                int length = nodeArr.length;
                if (length != 0) {
                    int i4 = (length - 1) & spread;
                    Node tabAt = tabAt(nodeArr, i4);
                    if (tabAt == null) {
                        ReservationNode reservationNode = new ReservationNode();
                        synchronized (reservationNode) {
                            if (casTabAt(nodeArr, i4, (Node) null, reservationNode)) {
                                try {
                                    Object apply = biFunction.apply(obj, (Object) null);
                                    if (apply != null) {
                                        node = new Node(spread, obj, apply, (Node) null);
                                        i = 1;
                                    } else {
                                        i = i2;
                                        node = null;
                                    }
                                    setTabAt(nodeArr, i4, node);
                                    i2 = i;
                                    obj4 = apply;
                                    i3 = 1;
                                } catch (Throwable th) {
                                    setTabAt(nodeArr, i4, (Node) null);
                                    throw th;
                                }
                            }
                        }
                        if (i3 != 0) {
                            break;
                        }
                    } else {
                        int i5 = tabAt.hash;
                        if (i5 == -1) {
                            nodeArr = helpTransfer(nodeArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(nodeArr, i4) == tabAt) {
                                    if (i5 >= 0) {
                                        Node node2 = null;
                                        Node node3 = tabAt;
                                        int i6 = 1;
                                        while (true) {
                                            if (node3.hash != spread || ((obj3 = node3.key) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                                Node node4 = node3.next;
                                                if (node4 == null) {
                                                    Object apply2 = biFunction.apply(obj, (Object) null);
                                                    if (apply2 != null) {
                                                        node3.next = new Node(spread, obj, apply2, (Node) null);
                                                        i2 = 1;
                                                    }
                                                    obj2 = apply2;
                                                } else {
                                                    i6++;
                                                    Node node5 = node4;
                                                    node2 = node3;
                                                    node3 = node5;
                                                }
                                            }
                                        }
                                        obj2 = biFunction.apply(obj, node3.val);
                                        if (obj2 != null) {
                                            node3.val = obj2;
                                        } else {
                                            Node node6 = node3.next;
                                            if (node2 != null) {
                                                node2.next = node6;
                                            } else {
                                                setTabAt(nodeArr, i4, node6);
                                            }
                                            i2 = -1;
                                        }
                                        i3 = i6;
                                        obj4 = obj2;
                                    } else if (tabAt instanceof TreeBin) {
                                        TreeBin treeBin = (TreeBin) tabAt;
                                        TreeNode treeNode = treeBin.root;
                                        TreeNode findTreeNode = treeNode != null ? treeNode.findTreeNode(spread, obj, (Class) null) : null;
                                        Object apply3 = biFunction.apply(obj, findTreeNode == null ? null : findTreeNode.val);
                                        if (apply3 != null) {
                                            if (findTreeNode != null) {
                                                findTreeNode.val = apply3;
                                            } else {
                                                treeBin.putTreeVal(spread, obj, apply3);
                                                i2 = 1;
                                            }
                                        } else if (findTreeNode != null) {
                                            if (treeBin.removeTreeNode(findTreeNode)) {
                                                setTabAt(nodeArr, i4, untreeify(treeBin.first));
                                            }
                                            i2 = -1;
                                        }
                                        obj4 = apply3;
                                        i3 = 1;
                                    }
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    treeifyBin(nodeArr, i4);
                                }
                            }
                        }
                    }
                }
            }
            nodeArr = initTable();
        }
        if (i2 != 0) {
            addCount((long) i2, i3);
        }
        return obj4;
    }

    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, C$r8$wrapper$java$util$function$BiFunction$VWRP.convert(biFunction));
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00c2, code lost:
        if (r5 == null) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00c4, code lost:
        addCount(1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00c9, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object computeIfAbsent(java.lang.Object r13, p009j$.util.function.Function r14) {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L_0x00d3
            if (r14 == 0) goto L_0x00d3
            int r1 = r13.hashCode()
            int r1 = spread(r1)
            j$.util.concurrent.ConcurrentHashMap$Node[] r2 = r12.table
            r3 = 0
            r5 = r0
            r4 = 0
        L_0x0012:
            if (r2 == 0) goto L_0x00cd
            int r6 = r2.length
            if (r6 != 0) goto L_0x0019
            goto L_0x00cd
        L_0x0019:
            int r6 = r6 + -1
            r6 = r6 & r1
            j$.util.concurrent.ConcurrentHashMap$Node r7 = tabAt(r2, r6)
            r8 = 1
            if (r7 != 0) goto L_0x004f
            j$.util.concurrent.ConcurrentHashMap$ReservationNode r9 = new j$.util.concurrent.ConcurrentHashMap$ReservationNode
            r9.<init>()
            monitor-enter(r9)
            boolean r7 = casTabAt(r2, r6, r0, r9)     // Catch:{ all -> 0x004c }
            if (r7 == 0) goto L_0x0047
            java.lang.Object r4 = r14.apply(r13)     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x003b
            j$.util.concurrent.ConcurrentHashMap$Node r5 = new j$.util.concurrent.ConcurrentHashMap$Node     // Catch:{ all -> 0x0042 }
            r5.<init>(r1, r13, r4, r0)     // Catch:{ all -> 0x0042 }
            goto L_0x003c
        L_0x003b:
            r5 = r0
        L_0x003c:
            setTabAt(r2, r6, r5)     // Catch:{ all -> 0x004c }
            r5 = r4
            r4 = 1
            goto L_0x0047
        L_0x0042:
            r13 = move-exception
            setTabAt(r2, r6, r0)     // Catch:{ all -> 0x004c }
            throw r13     // Catch:{ all -> 0x004c }
        L_0x0047:
            monitor-exit(r9)     // Catch:{ all -> 0x004c }
            if (r4 == 0) goto L_0x0012
            goto L_0x00c2
        L_0x004c:
            r13 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004c }
            throw r13
        L_0x004f:
            int r9 = r7.hash
            r10 = -1
            if (r9 != r10) goto L_0x0059
            j$.util.concurrent.ConcurrentHashMap$Node[] r2 = r12.helpTransfer(r2, r7)
            goto L_0x0012
        L_0x0059:
            monitor-enter(r7)
            j$.util.concurrent.ConcurrentHashMap$Node r10 = tabAt(r2, r6)     // Catch:{ all -> 0x00ca }
            if (r10 != r7) goto L_0x00b4
            if (r9 < 0) goto L_0x008d
            r4 = r7
            r5 = 1
        L_0x0064:
            int r9 = r4.hash     // Catch:{ all -> 0x00ca }
            if (r9 != r1) goto L_0x0077
            java.lang.Object r9 = r4.key     // Catch:{ all -> 0x00ca }
            if (r9 == r13) goto L_0x0074
            if (r9 == 0) goto L_0x0077
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x0077
        L_0x0074:
            java.lang.Object r4 = r4.val     // Catch:{ all -> 0x00ca }
            goto L_0x00a1
        L_0x0077:
            j$.util.concurrent.ConcurrentHashMap$Node r9 = r4.next     // Catch:{ all -> 0x00ca }
            if (r9 != 0) goto L_0x0089
            java.lang.Object r9 = r14.apply(r13)     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x00b0
            j$.util.concurrent.ConcurrentHashMap$Node r10 = new j$.util.concurrent.ConcurrentHashMap$Node     // Catch:{ all -> 0x00ca }
            r10.<init>(r1, r13, r9, r0)     // Catch:{ all -> 0x00ca }
            r4.next = r10     // Catch:{ all -> 0x00ca }
            goto L_0x00b1
        L_0x0089:
            int r5 = r5 + 1
            r4 = r9
            goto L_0x0064
        L_0x008d:
            boolean r9 = r7 instanceof p009j$.util.concurrent.ConcurrentHashMap.TreeBin     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x00b4
            r5 = 2
            r4 = r7
            j$.util.concurrent.ConcurrentHashMap$TreeBin r4 = (p009j$.util.concurrent.ConcurrentHashMap.TreeBin) r4     // Catch:{ all -> 0x00ca }
            j$.util.concurrent.ConcurrentHashMap$TreeNode r9 = r4.root     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x00a6
            j$.util.concurrent.ConcurrentHashMap$TreeNode r9 = r9.findTreeNode(r1, r13, r0)     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x00a6
            java.lang.Object r4 = r9.val     // Catch:{ all -> 0x00ca }
        L_0x00a1:
            r8 = 0
            r11 = r5
            r5 = r4
            r4 = r11
            goto L_0x00b5
        L_0x00a6:
            java.lang.Object r9 = r14.apply(r13)     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x00b0
            r4.putTreeVal(r1, r13, r9)     // Catch:{ all -> 0x00ca }
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            r4 = r5
            r5 = r9
            goto L_0x00b5
        L_0x00b4:
            r8 = 0
        L_0x00b5:
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            if (r4 == 0) goto L_0x0012
            r13 = 8
            if (r4 < r13) goto L_0x00bf
            r12.treeifyBin(r2, r6)
        L_0x00bf:
            if (r8 != 0) goto L_0x00c2
            return r5
        L_0x00c2:
            if (r5 == 0) goto L_0x00c9
            r13 = 1
            r12.addCount(r13, r4)
        L_0x00c9:
            return r5
        L_0x00ca:
            r13 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            throw r13
        L_0x00cd:
            j$.util.concurrent.ConcurrentHashMap$Node[] r2 = r12.initTable()
            goto L_0x0012
        L_0x00d3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.computeIfAbsent(java.lang.Object, j$.util.function.Function):java.lang.Object");
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return computeIfAbsent(obj, C$r8$wrapper$java$util$function$Function$VWRP.convert(function));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0099, code lost:
        if (r3 == 0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009b, code lost:
        addCount((long) r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009f, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object computeIfPresent(java.lang.Object r14, p009j$.util.function.BiFunction r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L_0x00a9
            if (r15 == 0) goto L_0x00a9
            int r1 = r14.hashCode()
            int r1 = spread(r1)
            j$.util.concurrent.ConcurrentHashMap$Node[] r2 = r13.table
            r3 = 0
            r5 = r0
            r4 = 0
        L_0x0012:
            if (r2 == 0) goto L_0x00a3
            int r6 = r2.length
            if (r6 != 0) goto L_0x0019
            goto L_0x00a3
        L_0x0019:
            int r6 = r6 + -1
            r6 = r6 & r1
            j$.util.concurrent.ConcurrentHashMap$Node r7 = tabAt(r2, r6)
            if (r7 != 0) goto L_0x0024
            goto L_0x0099
        L_0x0024:
            int r8 = r7.hash
            r9 = -1
            if (r8 != r9) goto L_0x002e
            j$.util.concurrent.ConcurrentHashMap$Node[] r2 = r13.helpTransfer(r2, r7)
            goto L_0x0012
        L_0x002e:
            monitor-enter(r7)
            j$.util.concurrent.ConcurrentHashMap$Node r10 = tabAt(r2, r6)     // Catch:{ all -> 0x00a0 }
            if (r10 != r7) goto L_0x0096
            if (r8 < 0) goto L_0x006c
            r4 = 1
            r10 = r0
            r8 = r7
        L_0x003a:
            int r11 = r8.hash     // Catch:{ all -> 0x00a0 }
            if (r11 != r1) goto L_0x0061
            java.lang.Object r11 = r8.key     // Catch:{ all -> 0x00a0 }
            if (r11 == r14) goto L_0x004a
            if (r11 == 0) goto L_0x0061
            boolean r11 = r14.equals(r11)     // Catch:{ all -> 0x00a0 }
            if (r11 == 0) goto L_0x0061
        L_0x004a:
            java.lang.Object r5 = r8.val     // Catch:{ all -> 0x00a0 }
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch:{ all -> 0x00a0 }
            if (r5 == 0) goto L_0x0055
            r8.val = r5     // Catch:{ all -> 0x00a0 }
            goto L_0x0096
        L_0x0055:
            j$.util.concurrent.ConcurrentHashMap$Node r3 = r8.next     // Catch:{ all -> 0x00a0 }
            if (r10 == 0) goto L_0x005c
            r10.next = r3     // Catch:{ all -> 0x00a0 }
            goto L_0x005f
        L_0x005c:
            setTabAt(r2, r6, r3)     // Catch:{ all -> 0x00a0 }
        L_0x005f:
            r3 = -1
            goto L_0x0096
        L_0x0061:
            j$.util.concurrent.ConcurrentHashMap$Node r10 = r8.next     // Catch:{ all -> 0x00a0 }
            if (r10 != 0) goto L_0x0066
            goto L_0x0096
        L_0x0066:
            int r4 = r4 + 1
            r12 = r10
            r10 = r8
            r8 = r12
            goto L_0x003a
        L_0x006c:
            boolean r8 = r7 instanceof p009j$.util.concurrent.ConcurrentHashMap.TreeBin     // Catch:{ all -> 0x00a0 }
            if (r8 == 0) goto L_0x0096
            r4 = 2
            r8 = r7
            j$.util.concurrent.ConcurrentHashMap$TreeBin r8 = (p009j$.util.concurrent.ConcurrentHashMap.TreeBin) r8     // Catch:{ all -> 0x00a0 }
            j$.util.concurrent.ConcurrentHashMap$TreeNode r10 = r8.root     // Catch:{ all -> 0x00a0 }
            if (r10 == 0) goto L_0x0096
            j$.util.concurrent.ConcurrentHashMap$TreeNode r10 = r10.findTreeNode(r1, r14, r0)     // Catch:{ all -> 0x00a0 }
            if (r10 == 0) goto L_0x0096
            java.lang.Object r5 = r10.val     // Catch:{ all -> 0x00a0 }
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch:{ all -> 0x00a0 }
            if (r5 == 0) goto L_0x0089
            r10.val = r5     // Catch:{ all -> 0x00a0 }
            goto L_0x0096
        L_0x0089:
            boolean r3 = r8.removeTreeNode(r10)     // Catch:{ all -> 0x00a0 }
            if (r3 == 0) goto L_0x005f
            j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r8.first     // Catch:{ all -> 0x00a0 }
            j$.util.concurrent.ConcurrentHashMap$Node r3 = untreeify(r3)     // Catch:{ all -> 0x00a0 }
            goto L_0x005c
        L_0x0096:
            monitor-exit(r7)     // Catch:{ all -> 0x00a0 }
            if (r4 == 0) goto L_0x0012
        L_0x0099:
            if (r3 == 0) goto L_0x009f
            long r14 = (long) r3
            r13.addCount(r14, r4)
        L_0x009f:
            return r5
        L_0x00a0:
            r14 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00a0 }
            throw r14
        L_0x00a3:
            j$.util.concurrent.ConcurrentHashMap$Node[] r2 = r13.initTable()
            goto L_0x0012
        L_0x00a9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.computeIfPresent(java.lang.Object, j$.util.function.BiFunction):java.lang.Object");
    }

    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, C$r8$wrapper$java$util$function$BiFunction$VWRP.convert(biFunction));
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        Objects.requireNonNull(obj);
        Node[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                Object obj2 = advance.val;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        EntrySetView entrySetView = this.entrySet;
        if (entrySetView != null) {
            return entrySetView;
        }
        EntrySetView entrySetView2 = new EntrySetView(this);
        this.entrySet = entrySetView2;
        return entrySetView2;
    }

    public boolean equals(Object obj) {
        Object value;
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        Node[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        while (true) {
            Node advance = traverser.advance();
            if (advance != null) {
                Object obj3 = advance.val;
                Object obj4 = map.get(advance.key);
                if (obj4 == null || (obj4 != obj3 && !obj4.equals(obj3))) {
                    return false;
                }
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (obj2 = get(key)) == null || (value != obj2 && !value.equals(obj2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void forEach(BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        Node[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node advance = traverser.advance();
                if (advance != null) {
                    biConsumer.accept(advance.key, advance.val);
                } else {
                    return;
                }
            }
        }
    }

    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(C$r8$wrapper$java$util$function$BiConsumer$VWRP.convert(biConsumer));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004d, code lost:
        return r1.val;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            int r0 = spread(r0)
            j$.util.concurrent.ConcurrentHashMap$Node[] r1 = r4.table
            r2 = 0
            if (r1 == 0) goto L_0x004e
            int r3 = r1.length
            if (r3 <= 0) goto L_0x004e
            int r3 = r3 + -1
            r3 = r3 & r0
            j$.util.concurrent.ConcurrentHashMap$Node r1 = tabAt(r1, r3)
            if (r1 == 0) goto L_0x004e
            int r3 = r1.hash
            if (r3 != r0) goto L_0x002c
            java.lang.Object r3 = r1.key
            if (r3 == r5) goto L_0x0029
            if (r3 == 0) goto L_0x0037
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0037
        L_0x0029:
            java.lang.Object r5 = r1.val
            return r5
        L_0x002c:
            if (r3 >= 0) goto L_0x0037
            j$.util.concurrent.ConcurrentHashMap$Node r5 = r1.find(r0, r5)
            if (r5 == 0) goto L_0x0036
            java.lang.Object r2 = r5.val
        L_0x0036:
            return r2
        L_0x0037:
            j$.util.concurrent.ConcurrentHashMap$Node r1 = r1.next
            if (r1 == 0) goto L_0x004e
            int r3 = r1.hash
            if (r3 != r0) goto L_0x0037
            java.lang.Object r3 = r1.key
            if (r3 == r5) goto L_0x004b
            if (r3 == 0) goto L_0x0037
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0037
        L_0x004b:
            java.lang.Object r5 = r1.val
            return r5
        L_0x004e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object");
    }

    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? obj2 : obj3;
    }

    public int hashCode() {
        Node[] nodeArr = this.table;
        int i = 0;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                i += advance.val.hashCode() ^ advance.key.hashCode();
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final Node[] helpTransfer(Node[] nodeArr, Node node) {
        Node[] nodeArr2;
        int i;
        if (!(node instanceof ForwardingNode) || (nodeArr2 = ((ForwardingNode) node).nextTable) == null) {
            return this.table;
        }
        int resizeStamp = resizeStamp(nodeArr.length);
        while (true) {
            if (nodeArr2 != this.nextTable || this.table != nodeArr || (i = this.sizeCtl) >= 0 || (i >>> 16) != resizeStamp || i == resizeStamp + 1 || i == 65535 + resizeStamp || this.transferIndex <= 0) {
                break;
            }
            if (f233U.compareAndSwapInt(this, SIZECTL, i, i + 1)) {
                transfer(nodeArr, nodeArr2);
                break;
            }
        }
        return nodeArr2;
    }

    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    public Set keySet() {
        KeySetView keySetView = this.keySet;
        if (keySetView != null) {
            return keySetView;
        }
        KeySetView keySetView2 = new KeySetView(this, (Object) null);
        this.keySet = keySetView2;
        return keySetView2;
    }

    public Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i;
        Object obj3;
        Object obj4;
        Object obj5 = obj;
        Object obj6 = obj2;
        BiFunction biFunction2 = biFunction;
        if (obj5 == null || obj6 == null || biFunction2 == null) {
            throw null;
        }
        int spread = spread(obj.hashCode());
        Node[] nodeArr = this.table;
        int i2 = 0;
        Object obj7 = null;
        int i3 = 0;
        while (true) {
            if (nodeArr != null) {
                int length = nodeArr.length;
                if (length != 0) {
                    int i4 = (length - 1) & spread;
                    Node tabAt = tabAt(nodeArr, i4);
                    i = 1;
                    if (tabAt != null) {
                        int i5 = tabAt.hash;
                        if (i5 == -1) {
                            nodeArr = helpTransfer(nodeArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(nodeArr, i4) == tabAt) {
                                    if (i5 >= 0) {
                                        Node node = null;
                                        Node node2 = tabAt;
                                        int i6 = 1;
                                        while (true) {
                                            if (node2.hash != spread || ((obj4 = node2.key) != obj5 && (obj4 == null || !obj5.equals(obj4)))) {
                                                Node node3 = node2.next;
                                                if (node3 == null) {
                                                    node2.next = new Node(spread, obj5, obj6, (Node) null);
                                                    obj3 = obj6;
                                                    break;
                                                }
                                                i6++;
                                                Node node4 = node3;
                                                node = node2;
                                                node2 = node4;
                                            }
                                        }
                                        Object apply = biFunction2.apply(node2.val, obj6);
                                        if (apply != null) {
                                            node2.val = apply;
                                        } else {
                                            Node node5 = node2.next;
                                            if (node != null) {
                                                node.next = node5;
                                            } else {
                                                setTabAt(nodeArr, i4, node5);
                                            }
                                            i2 = -1;
                                        }
                                        Object obj8 = apply;
                                        i = i2;
                                        obj3 = obj8;
                                        i3 = i6;
                                        obj7 = obj3;
                                        i2 = i;
                                    } else if (tabAt instanceof TreeBin) {
                                        i3 = 2;
                                        TreeBin treeBin = (TreeBin) tabAt;
                                        TreeNode treeNode = treeBin.root;
                                        TreeNode findTreeNode = treeNode == null ? null : treeNode.findTreeNode(spread, obj5, (Class) null);
                                        Object apply2 = findTreeNode == null ? obj6 : biFunction2.apply(findTreeNode.val, obj6);
                                        if (apply2 != null) {
                                            if (findTreeNode != null) {
                                                findTreeNode.val = apply2;
                                            } else {
                                                treeBin.putTreeVal(spread, obj5, apply2);
                                                i2 = 1;
                                            }
                                        } else if (findTreeNode != null) {
                                            if (treeBin.removeTreeNode(findTreeNode)) {
                                                setTabAt(nodeArr, i4, untreeify(treeBin.first));
                                            }
                                            i2 = -1;
                                        }
                                        obj7 = apply2;
                                    }
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    treeifyBin(nodeArr, i4);
                                }
                                i = i2;
                                obj6 = obj7;
                            }
                        }
                    } else if (casTabAt(nodeArr, i4, (Node) null, new Node(spread, obj5, obj6, (Node) null))) {
                        break;
                    }
                }
            }
            nodeArr = initTable();
        }
        if (i != 0) {
            addCount((long) i, i3);
        }
        return obj6;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, C$r8$wrapper$java$util$function$BiFunction$VWRP.convert(biFunction));
    }

    public V put(K k, V v) {
        return putVal(k, v, false);
    }

    public void putAll(Map map) {
        tryPresize(map.size());
        for (Map.Entry entry : map.entrySet()) {
            putVal(entry.getKey(), entry.getValue(), false);
        }
    }

    public V putIfAbsent(K k, V v) {
        return putVal(k, v, true);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r11 == false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object putVal(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0098
            if (r10 == 0) goto L_0x0098
            int r1 = r9.hashCode()
            int r1 = spread(r1)
            r2 = 0
            j$.util.concurrent.ConcurrentHashMap$Node[] r3 = r8.table
        L_0x0010:
            if (r3 == 0) goto L_0x0092
            int r4 = r3.length
            if (r4 != 0) goto L_0x0017
            goto L_0x0092
        L_0x0017:
            int r4 = r4 + -1
            r4 = r4 & r1
            j$.util.concurrent.ConcurrentHashMap$Node r5 = tabAt(r3, r4)
            if (r5 != 0) goto L_0x002c
            j$.util.concurrent.ConcurrentHashMap$Node r5 = new j$.util.concurrent.ConcurrentHashMap$Node
            r5.<init>(r1, r9, r10, r0)
            boolean r4 = casTabAt(r3, r4, r0, r5)
            if (r4 == 0) goto L_0x0010
            goto L_0x0089
        L_0x002c:
            int r6 = r5.hash
            r7 = -1
            if (r6 != r7) goto L_0x0036
            j$.util.concurrent.ConcurrentHashMap$Node[] r3 = r8.helpTransfer(r3, r5)
            goto L_0x0010
        L_0x0036:
            monitor-enter(r5)
            j$.util.concurrent.ConcurrentHashMap$Node r7 = tabAt(r3, r4)     // Catch:{ all -> 0x008f }
            if (r7 != r5) goto L_0x007b
            if (r6 < 0) goto L_0x0068
            r2 = 1
            r6 = r5
        L_0x0041:
            int r7 = r6.hash     // Catch:{ all -> 0x008f }
            if (r7 != r1) goto L_0x0058
            java.lang.Object r7 = r6.key     // Catch:{ all -> 0x008f }
            if (r7 == r9) goto L_0x0051
            if (r7 == 0) goto L_0x0058
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x008f }
            if (r7 == 0) goto L_0x0058
        L_0x0051:
            java.lang.Object r7 = r6.val     // Catch:{ all -> 0x008f }
            if (r11 != 0) goto L_0x007c
        L_0x0055:
            r6.val = r10     // Catch:{ all -> 0x008f }
            goto L_0x007c
        L_0x0058:
            j$.util.concurrent.ConcurrentHashMap$Node r7 = r6.next     // Catch:{ all -> 0x008f }
            if (r7 != 0) goto L_0x0064
            j$.util.concurrent.ConcurrentHashMap$Node r7 = new j$.util.concurrent.ConcurrentHashMap$Node     // Catch:{ all -> 0x008f }
            r7.<init>(r1, r9, r10, r0)     // Catch:{ all -> 0x008f }
            r6.next = r7     // Catch:{ all -> 0x008f }
            goto L_0x007b
        L_0x0064:
            int r2 = r2 + 1
            r6 = r7
            goto L_0x0041
        L_0x0068:
            boolean r6 = r5 instanceof p009j$.util.concurrent.ConcurrentHashMap.TreeBin     // Catch:{ all -> 0x008f }
            if (r6 == 0) goto L_0x007b
            r2 = 2
            r6 = r5
            j$.util.concurrent.ConcurrentHashMap$TreeBin r6 = (p009j$.util.concurrent.ConcurrentHashMap.TreeBin) r6     // Catch:{ all -> 0x008f }
            j$.util.concurrent.ConcurrentHashMap$TreeNode r6 = r6.putTreeVal(r1, r9, r10)     // Catch:{ all -> 0x008f }
            if (r6 == 0) goto L_0x007b
            java.lang.Object r7 = r6.val     // Catch:{ all -> 0x008f }
            if (r11 != 0) goto L_0x007c
            goto L_0x0055
        L_0x007b:
            r7 = r0
        L_0x007c:
            monitor-exit(r5)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0010
            r9 = 8
            if (r2 < r9) goto L_0x0086
            r8.treeifyBin(r3, r4)
        L_0x0086:
            if (r7 == 0) goto L_0x0089
            return r7
        L_0x0089:
            r9 = 1
            r8.addCount(r9, r2)
            return r0
        L_0x008f:
            r9 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x008f }
            throw r9
        L_0x0092:
            j$.util.concurrent.ConcurrentHashMap$Node[] r3 = r8.initTable()
            goto L_0x0010
        L_0x0098:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.putVal(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    public V remove(Object obj) {
        return replaceNode(obj, (Object) null, (Object) null);
    }

    public boolean remove(Object obj, Object obj2) {
        Objects.requireNonNull(obj);
        return (obj2 == null || replaceNode(obj, (Object) null, obj2) == null) ? false : true;
    }

    public Object replace(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return replaceNode(obj, obj2, (Object) null);
        }
        throw null;
    }

    public boolean replace(K k, V v, V v2) {
        if (k != null && v != null && v2 != null) {
            return replaceNode(k, v2, v) != null;
        }
        throw null;
    }

    public void replaceAll(BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Node[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node advance = traverser.advance();
                if (advance != null) {
                    Object obj = advance.val;
                    Object obj2 = advance.key;
                    do {
                        Object apply = biFunction.apply(obj2, obj);
                        Objects.requireNonNull(apply);
                        if (replaceNode(obj2, apply, obj) != null || (obj = get(obj2)) == null) {
                        }
                        Object apply2 = biFunction.apply(obj2, obj);
                        Objects.requireNonNull(apply2);
                        break;
                    } while ((obj = get(obj2)) == null);
                } else {
                    return;
                }
            }
        }
    }

    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(C$r8$wrapper$java$util$function$BiFunction$VWRP.convert(biFunction));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00af, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object replaceNode(java.lang.Object r13, java.lang.Object r14, java.lang.Object r15) {
        /*
            r12 = this;
            int r0 = r13.hashCode()
            int r0 = spread(r0)
            j$.util.concurrent.ConcurrentHashMap$Node[] r1 = r12.table
        L_0x000a:
            r2 = 0
            if (r1 == 0) goto L_0x00af
            int r3 = r1.length
            if (r3 == 0) goto L_0x00af
            int r3 = r3 + -1
            r3 = r3 & r0
            j$.util.concurrent.ConcurrentHashMap$Node r4 = tabAt(r1, r3)
            if (r4 != 0) goto L_0x001b
            goto L_0x00af
        L_0x001b:
            int r5 = r4.hash
            r6 = -1
            if (r5 != r6) goto L_0x0025
            j$.util.concurrent.ConcurrentHashMap$Node[] r1 = r12.helpTransfer(r1, r4)
            goto L_0x000a
        L_0x0025:
            r7 = 0
            monitor-enter(r4)
            j$.util.concurrent.ConcurrentHashMap$Node r8 = tabAt(r1, r3)     // Catch:{ all -> 0x00ac }
            r9 = 1
            if (r8 != r4) goto L_0x009e
            if (r5 < 0) goto L_0x006d
            r7 = r2
            r5 = r4
        L_0x0032:
            int r8 = r5.hash     // Catch:{ all -> 0x00ac }
            if (r8 != r0) goto L_0x0062
            java.lang.Object r8 = r5.key     // Catch:{ all -> 0x00ac }
            if (r8 == r13) goto L_0x0042
            if (r8 == 0) goto L_0x0062
            boolean r8 = r13.equals(r8)     // Catch:{ all -> 0x00ac }
            if (r8 == 0) goto L_0x0062
        L_0x0042:
            java.lang.Object r8 = r5.val     // Catch:{ all -> 0x00ac }
            if (r15 == 0) goto L_0x0050
            if (r15 == r8) goto L_0x0050
            if (r8 == 0) goto L_0x0066
            boolean r10 = r15.equals(r8)     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x0066
        L_0x0050:
            if (r14 == 0) goto L_0x0055
            r5.val = r14     // Catch:{ all -> 0x00ac }
            goto L_0x0067
        L_0x0055:
            if (r7 == 0) goto L_0x005c
            j$.util.concurrent.ConcurrentHashMap$Node r3 = r5.next     // Catch:{ all -> 0x00ac }
            r7.next = r3     // Catch:{ all -> 0x00ac }
            goto L_0x0067
        L_0x005c:
            j$.util.concurrent.ConcurrentHashMap$Node r5 = r5.next     // Catch:{ all -> 0x00ac }
        L_0x005e:
            setTabAt(r1, r3, r5)     // Catch:{ all -> 0x00ac }
            goto L_0x0067
        L_0x0062:
            j$.util.concurrent.ConcurrentHashMap$Node r7 = r5.next     // Catch:{ all -> 0x00ac }
            if (r7 != 0) goto L_0x0069
        L_0x0066:
            r8 = r2
        L_0x0067:
            r7 = 1
            goto L_0x009f
        L_0x0069:
            r11 = r7
            r7 = r5
            r5 = r11
            goto L_0x0032
        L_0x006d:
            boolean r5 = r4 instanceof p009j$.util.concurrent.ConcurrentHashMap.TreeBin     // Catch:{ all -> 0x00ac }
            if (r5 == 0) goto L_0x009e
            r5 = r4
            j$.util.concurrent.ConcurrentHashMap$TreeBin r5 = (p009j$.util.concurrent.ConcurrentHashMap.TreeBin) r5     // Catch:{ all -> 0x00ac }
            j$.util.concurrent.ConcurrentHashMap$TreeNode r7 = r5.root     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x0066
            j$.util.concurrent.ConcurrentHashMap$TreeNode r7 = r7.findTreeNode(r0, r13, r2)     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x0066
            java.lang.Object r8 = r7.val     // Catch:{ all -> 0x00ac }
            if (r15 == 0) goto L_0x008c
            if (r15 == r8) goto L_0x008c
            if (r8 == 0) goto L_0x0066
            boolean r10 = r15.equals(r8)     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x0066
        L_0x008c:
            if (r14 == 0) goto L_0x0091
            r7.val = r14     // Catch:{ all -> 0x00ac }
            goto L_0x0067
        L_0x0091:
            boolean r7 = r5.removeTreeNode(r7)     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x0067
            j$.util.concurrent.ConcurrentHashMap$TreeNode r5 = r5.first     // Catch:{ all -> 0x00ac }
            j$.util.concurrent.ConcurrentHashMap$Node r5 = untreeify(r5)     // Catch:{ all -> 0x00ac }
            goto L_0x005e
        L_0x009e:
            r8 = r2
        L_0x009f:
            monitor-exit(r4)     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x000a
            if (r8 == 0) goto L_0x00af
            if (r14 != 0) goto L_0x00ab
            r13 = -1
            r12.addCount(r13, r6)
        L_0x00ab:
            return r8
        L_0x00ac:
            r13 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00ac }
            throw r13
        L_0x00af:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.replaceNode(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public int size() {
        long sumCount = sumCount();
        if (sumCount < 0) {
            return 0;
        }
        if (sumCount > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) sumCount;
    }

    /* access modifiers changed from: package-private */
    public final long sumCount() {
        CounterCell[] counterCellArr = this.counterCells;
        long j = this.baseCount;
        if (counterCellArr != null) {
            for (CounterCell counterCell : counterCellArr) {
                if (counterCell != null) {
                    j += counterCell.value;
                }
            }
        }
        return j;
    }

    public String toString() {
        Node[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Node advance = traverser.advance();
        if (advance != null) {
            while (true) {
                Object obj = advance.key;
                Object obj2 = advance.val;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                sb.append(',');
                sb.append(' ');
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public java.util.Collection<V> values() {
        ValuesView valuesView = this.values;
        if (valuesView != null) {
            return valuesView;
        }
        ValuesView valuesView2 = new ValuesView(this);
        this.values = valuesView2;
        return valuesView2;
    }

    /* renamed from: j$.util.concurrent.ConcurrentHashMap$CollectionView */
    static abstract class CollectionView implements java.util.Collection, Serializable {
        final ConcurrentHashMap map;

        CollectionView(ConcurrentHashMap concurrentHashMap) {
            this.map = concurrentHashMap;
        }

        public final void clear() {
            this.map.clear();
        }

        public abstract boolean contains(Object obj);

        /* JADX WARNING: Removed duplicated region for block: B:4:0x000c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean containsAll(java.util.Collection r2) {
            /*
                r1 = this;
                if (r2 == r1) goto L_0x001a
                java.util.Iterator r2 = r2.iterator()
            L_0x0006:
                boolean r0 = r2.hasNext()
                if (r0 == 0) goto L_0x001a
                java.lang.Object r0 = r2.next()
                if (r0 == 0) goto L_0x0018
                boolean r0 = r1.contains(r0)
                if (r0 != 0) goto L_0x0006
            L_0x0018:
                r2 = 0
                return r2
            L_0x001a:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentHashMap.CollectionView.containsAll(java.util.Collection):boolean");
        }

        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        public abstract java.util.Iterator iterator();

        public final boolean removeAll(java.util.Collection collection) {
            Objects.requireNonNull(collection);
            java.util.Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public final boolean retainAll(java.util.Collection collection) {
            Objects.requireNonNull(collection);
            java.util.Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public final int size() {
            return this.map.size();
        }

        public final Object[] toArray() {
            long sumCount = this.map.sumCount();
            if (sumCount < 0) {
                sumCount = 0;
            }
            if (sumCount <= 2147483639) {
                int i = (int) sumCount;
                Object[] objArr = new Object[i];
                int i2 = 0;
                java.util.Iterator it = iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (i2 == i) {
                        int i3 = 2147483639;
                        if (i < 2147483639) {
                            if (i < 1073741819) {
                                i3 = (i >>> 1) + 1 + i;
                            }
                            objArr = Arrays.copyOf(objArr, i3);
                            i = i3;
                        } else {
                            throw new OutOfMemoryError("Required array size too large");
                        }
                    }
                    objArr[i2] = next;
                    i2++;
                }
                return i2 == i ? objArr : Arrays.copyOf(objArr, i2);
            }
            throw new OutOfMemoryError("Required array size too large");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            java.util.Iterator it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object next = it.next();
                    if (next == this) {
                        next = "(this Collection)";
                    }
                    sb.append(next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(',');
                    sb.append(' ');
                }
            }
            sb.append(']');
            return sb.toString();
        }

        public final Object[] toArray(Object[] objArr) {
            long sumCount = this.map.sumCount();
            if (sumCount < 0) {
                sumCount = 0;
            }
            if (sumCount <= 2147483639) {
                int i = (int) sumCount;
                Object[] objArr2 = objArr.length >= i ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
                int length = objArr2.length;
                int i2 = 0;
                java.util.Iterator it = iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (i2 == length) {
                        int i3 = 2147483639;
                        if (length < 2147483639) {
                            if (length < 1073741819) {
                                i3 = (length >>> 1) + 1 + length;
                            }
                            objArr2 = Arrays.copyOf(objArr2, i3);
                            length = i3;
                        } else {
                            throw new OutOfMemoryError("Required array size too large");
                        }
                    }
                    objArr2[i2] = next;
                    i2++;
                }
                if (objArr != objArr2 || i2 >= length) {
                    return i2 == length ? objArr2 : Arrays.copyOf(objArr2, i2);
                }
                objArr2[i2] = null;
                return objArr2;
            }
            throw new OutOfMemoryError("Required array size too large");
        }
    }
}
