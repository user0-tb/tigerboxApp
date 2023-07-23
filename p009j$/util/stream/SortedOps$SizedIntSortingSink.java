package p009j$.util.stream;

import java.util.Arrays;

/* renamed from: j$.util.stream.SortedOps$SizedIntSortingSink */
final class SortedOps$SizedIntSortingSink extends SortedOps$AbstractIntSortingSink {
    private int[] array;
    private int offset;

    SortedOps$SizedIntSortingSink(Sink sink) {
        super(sink);
    }

    public void accept(int i) {
        int[] iArr = this.array;
        int i2 = this.offset;
        this.offset = i2 + 1;
        iArr[i2] = i;
    }

    public void begin(long j) {
        if (j < 2147483639) {
            this.array = new int[((int) j)];
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
