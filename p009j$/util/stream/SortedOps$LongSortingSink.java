package p009j$.util.stream;

import java.util.Arrays;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.SortedOps$LongSortingSink */
final class SortedOps$LongSortingSink extends SortedOps$AbstractLongSortingSink {

    /* renamed from: b */
    private SpinedBuffer.OfLong f250b;

    SortedOps$LongSortingSink(Sink sink) {
        super(sink);
    }

    public void accept(long j) {
        this.f250b.accept(j);
    }

    public void begin(long j) {
        SpinedBuffer.OfLong ofLong;
        if (j < 2147483639) {
            if (j > 0) {
                int i = (int) j;
            } else {
                ofLong = new SpinedBuffer.OfLong();
            }
            this.f250b = ofLong;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public void end() {
        long[] jArr = (long[]) this.f250b.asPrimitiveArray();
        Arrays.sort(jArr);
        this.downstream.begin((long) jArr.length);
        int i = 0;
        if (!this.cancellationWasRequested) {
            int length = jArr.length;
            while (i < length) {
                this.downstream.accept(jArr[i]);
                i++;
            }
        } else {
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                if (this.downstream.cancellationRequested()) {
                    break;
                }
                this.downstream.accept(j);
                i++;
            }
        }
        this.downstream.end();
    }
}
