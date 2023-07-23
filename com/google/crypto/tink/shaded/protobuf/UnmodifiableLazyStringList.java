package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p009j$.util.Iterator;
import p009j$.util.function.Consumer;
import p009j$.wrappers.C$r8$wrapper$java$util$function$Consumer$VWRP;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    /* access modifiers changed from: private */
    public final LazyStringList list;

    public LazyStringList getUnmodifiableView() {
        return this;
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    public String get(int i) {
        return (String) this.list.get(i);
    }

    public Object getRaw(int i) {
        return this.list.getRaw(i);
    }

    public int size() {
        return this.list.size();
    }

    public ByteString getByteString(int i) {
        return this.list.getByteString(i);
    }

    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public void set(int i, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    public byte[] getByteArray(int i) {
        return this.list.getByteArray(i);
    }

    public void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public void set(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteArray(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<String> listIterator(int i) {
        return new Object(i) {
            ListIterator<String> iter;
            final /* synthetic */ int val$index;

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
            }

            {
                this.val$index = r2;
                this.iter = UnmodifiableLazyStringList.this.list.listIterator(r2);
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public String next() {
                return this.iter.next();
            }

            public boolean hasPrevious() {
                return this.iter.hasPrevious();
            }

            public String previous() {
                return this.iter.previous();
            }

            public int nextIndex() {
                return this.iter.nextIndex();
            }

            public int previousIndex() {
                return this.iter.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            public void add(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public java.util.Iterator<String> iterator() {
        return new Object() {
            java.util.Iterator<String> iter;

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
            }

            {
                this.iter = UnmodifiableLazyStringList.this.list.iterator();
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public String next() {
                return this.iter.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.list.asByteStringList());
    }
}
