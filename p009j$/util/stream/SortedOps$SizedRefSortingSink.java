package p009j$.util.stream;

import java.util.Arrays;
import java.util.Comparator;

/* renamed from: j$.util.stream.SortedOps$SizedRefSortingSink */
final class SortedOps$SizedRefSortingSink extends SortedOps$AbstractRefSortingSink {
    private Object[] array;
    private int offset;

    SortedOps$SizedRefSortingSink(Sink sink, Comparator comparator) {
        super(sink, comparator);
    }

    public void accept(Object obj) {
        Object[] objArr = this.array;
        int i = this.offset;
        this.offset = i + 1;
        objArr[i] = obj;
    }

    public void begin(long j) {
        if (j < 2147483639) {
            this.array = new Object[((int) j)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public void end() {
        int i = 0;
        Arrays.sort(this.array, 0, this.offset, this.comparator);
        this.downstream.begin((long) this.offset);
        if (!this.cancellationWasRequested) {
            while (i < this.offset) {
                this.downstream.accept(this.array[i]);
                i++;
            }
        } else {
            while (i < this.offset && !this.downstream.cancellationRequested()) {
                this.downstream.accept(this.array[i]);
                i++;
            }
        }
        this.downstream.end();
        this.array = null;
    }
}
