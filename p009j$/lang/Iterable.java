package p009j$.lang;

import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;

/* renamed from: j$.lang.Iterable */
public interface Iterable {

    /* renamed from: j$.lang.Iterable$-CC  reason: invalid class name */
    public abstract /* synthetic */ class CC {
        /* renamed from: m */
        public static /* synthetic */ int m181m(long j) {
            int i = (int) j;
            if (j == ((long) i)) {
                return i;
            }
            throw new ArithmeticException();
        }

        /* renamed from: m */
        public static /* synthetic */ long m182m(long j, long j2) {
            long j3 = j + j2;
            boolean z = true;
            boolean z2 = (j2 ^ j) < 0;
            if ((j ^ j3) < 0) {
                z = false;
            }
            if (z2 || z) {
                return j3;
            }
            throw new ArithmeticException();
        }

        public static /* synthetic */ long m$1(long j, long j2) {
            long j3 = j % j2;
            if (j3 == 0) {
                return 0;
            }
            return (((j ^ j2) >> 63) | 1) > 0 ? j3 : j3 + j2;
        }

        public static /* synthetic */ long m$2(long j, long j2) {
            long j3 = j / j2;
            return (j - (j2 * j3) != 0 && (((j ^ j2) >> 63) | 1) < 0) ? j3 - 1 : j3;
        }

        public static /* synthetic */ long m$3(long j, long j2) {
            int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
            if (numberOfLeadingZeros > 65) {
                return j * j2;
            }
            if (numberOfLeadingZeros >= 64) {
                boolean z = true;
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                boolean z2 = i >= 0;
                if (j2 == Long.MIN_VALUE) {
                    z = false;
                }
                if (z2 || z) {
                    long j3 = j * j2;
                    if (i == 0 || j3 / j == j2) {
                        return j3;
                    }
                }
            }
            throw new ArithmeticException();
        }

        public static /* synthetic */ long m$4(long j, long j2) {
            long j3 = j - j2;
            boolean z = true;
            boolean z2 = (j2 ^ j) >= 0;
            if ((j ^ j3) < 0) {
                z = false;
            }
            if (z2 || z) {
                return j3;
            }
            throw new ArithmeticException();
        }
    }

    void forEach(Consumer consumer);

    Spliterator spliterator();
}
