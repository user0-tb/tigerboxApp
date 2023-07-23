package p009j$.util.stream;

import java.util.Arrays;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.SortedOps$IntSortingSink */
final class SortedOps$IntSortingSink extends SortedOps$AbstractIntSortingSink {

    /* renamed from: b */
    private SpinedBuffer.OfInt f249b;

    SortedOps$IntSortingSink(Sink sink) {
        super(sink);
    }

    public void accept(int i) {
        this.f249b.accept(i);
    }

    public void begin(long j) {
        SpinedBuffer.OfInt ofInt;
        if (j < 2147483639) {
            if (j > 0) {
                int i = (int) j;
            } else {
                ofInt = new SpinedBuffer.OfInt();
            }
            this.f249b = ofInt;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public void end() {
        int[] iArr = (int[]) this.f249b.asPrimitiveArray();
        Arrays.sort(iArr);
        this.downstream.begin((long) iArr.length);
        int i = 0;
        if (!this.cancellationWasRequested) {
            int length = iArr.length;
            while (i < length) {
                this.downstream.accept(iArr[i]);
                i++;
            }
        } else {
            int length2 = iArr.length;
            while (i < length2) {
                int i2 = iArr[i];
                if (this.downstream.cancellationRequested()) {
                    break;
                }
                this.downstream.accept(i2);
                i++;
            }
        }
        this.downstream.end();
    }
}
