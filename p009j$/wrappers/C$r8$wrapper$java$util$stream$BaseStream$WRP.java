package p009j$.wrappers;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/* renamed from: j$.wrappers.$r8$wrapper$java$util$stream$BaseStream$-WRP  reason: invalid class name */
public final /* synthetic */ class C$r8$wrapper$java$util$stream$BaseStream$WRP implements BaseStream {
    final /* synthetic */ p009j$.util.stream.BaseStream wrappedValue;

    private /* synthetic */ C$r8$wrapper$java$util$stream$BaseStream$WRP(p009j$.util.stream.BaseStream baseStream) {
        this.wrappedValue = baseStream;
    }

    public static /* synthetic */ BaseStream convert(p009j$.util.stream.BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return new C$r8$wrapper$java$util$stream$BaseStream$WRP(baseStream);
    }

    public /* synthetic */ void close() {
        this.wrappedValue.close();
    }

    public /* synthetic */ boolean isParallel() {
        return this.wrappedValue.isParallel();
    }

    public /* synthetic */ Iterator iterator() {
        return this.wrappedValue.iterator();
    }

    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return convert(this.wrappedValue.onClose(runnable));
    }

    public /* synthetic */ BaseStream parallel() {
        return convert(this.wrappedValue.parallel());
    }

    public /* synthetic */ BaseStream sequential() {
        return convert(this.wrappedValue.sequential());
    }

    public /* synthetic */ Spliterator spliterator() {
        return C$r8$wrapper$java$util$Spliterator$WRP.convert(this.wrappedValue.spliterator());
    }

    public /* synthetic */ BaseStream unordered() {
        return convert(this.wrappedValue.unordered());
    }
}
