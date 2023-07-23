package p009j$.util.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import p009j$.util.Collection;
import p009j$.util.Objects;

/* renamed from: j$.util.stream.SortedOps$RefSortingSink */
final class SortedOps$RefSortingSink extends SortedOps$AbstractRefSortingSink {
    private ArrayList list;

    SortedOps$RefSortingSink(Sink sink, Comparator comparator) {
        super(sink, comparator);
    }

    public void accept(Object obj) {
        this.list.add(obj);
    }

    public void begin(long j) {
        ArrayList arrayList;
        if (j < 2147483639) {
            if (j >= 0) {
                int i = (int) j;
            } else {
                arrayList = new ArrayList();
            }
            this.list = arrayList;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public void end() {
        Objects.sort(this.list, this.comparator);
        this.downstream.begin((long) this.list.size());
        if (!this.cancellationWasRequested) {
            ArrayList arrayList = this.list;
            Sink sink = this.downstream;
            java.util.Objects.requireNonNull(sink);
            Collection.EL.forEach(arrayList, new SpinedBuffer$$ExternalSyntheticLambda0(sink));
        } else {
            Iterator it = this.list.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (this.downstream.cancellationRequested()) {
                    break;
                }
                this.downstream.accept(next);
            }
        }
        this.downstream.end();
        this.list = null;
    }
}
