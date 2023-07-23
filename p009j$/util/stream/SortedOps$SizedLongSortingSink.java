package p009j$.util.stream;

import java.util.Arrays;

/* renamed from: j$.util.stream.SortedOps$SizedLongSortingSink */
final class SortedOps$SizedLongSortingSink extends SortedOps$AbstractLongSortingSink {
    private long[] array;
    private int offset;

    SortedOps$SizedLongSortingSink(Sink sink) {
        super(sink);
    }

    public void accept(long j) {
        long[] jArr = this.array;
        int i = this.offset;
        this.offset = i + 1;
        jArr[i] = j;
    }

    public void begin(long j) {
        if (j < 2147483639) {
            this.array = new long[((int) j)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public void end() {
        int i = 0;
        Arrays.sort(this.array, 0, this.offset);
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
