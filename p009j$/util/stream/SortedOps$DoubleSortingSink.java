package p009j$.util.stream;

import java.util.Arrays;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.SortedOps$DoubleSortingSink */
final class SortedOps$DoubleSortingSink extends SortedOps$AbstractDoubleSortingSink {

    /* renamed from: b */
    private SpinedBuffer.OfDouble f248b;

    SortedOps$DoubleSortingSink(Sink sink) {
        super(sink);
    }

    public void accept(double d) {
        this.f248b.accept(d);
    }

    public void begin(long j) {
        SpinedBuffer.OfDouble ofDouble;
        if (j < 2147483639) {
            if (j > 0) {
                int i = (int) j;
            } else {
                ofDouble = new SpinedBuffer.OfDouble();
            }
            this.f248b = ofDouble;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public void end() {
        double[] dArr = (double[]) this.f248b.asPrimitiveArray();
        Arrays.sort(dArr);
        this.downstream.begin((long) dArr.length);
        int i = 0;
        if (!this.cancellationWasRequested) {
            int length = dArr.length;
            while (i < length) {
                this.downstream.accept(dArr[i]);
                i++;
            }
        } else {
            int length2 = dArr.length;
            while (i < length2) {
                double d = dArr[i];
                if (this.downstream.cancellationRequested()) {
                    break;
                }
                this.downstream.accept(d);
                i++;
            }
        }
        this.downstream.end();
    }
}
