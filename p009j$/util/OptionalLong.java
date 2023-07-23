package p009j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.OptionalLong */
public final class OptionalLong {
    private static final OptionalLong EMPTY = new OptionalLong();
    private final boolean isPresent;
    private final long value;

    private OptionalLong() {
        this.isPresent = false;
        this.value = 0;
    }

    private OptionalLong(long j) {
        this.isPresent = true;
        this.value = j;
    }

    public static OptionalLong empty() {
        return EMPTY;
    }

    /* renamed from: of */
    public static OptionalLong m204of(long j) {
        return new OptionalLong(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionalLong)) {
            return false;
        }
        OptionalLong optionalLong = (OptionalLong) obj;
        boolean z = this.isPresent;
        if (!z || !optionalLong.isPresent) {
            if (z == optionalLong.isPresent) {
                return true;
            }
        } else if (this.value == optionalLong.value) {
            return true;
        }
        return false;
    }

    public long getAsLong() {
        if (this.isPresent) {
            return this.value;
        }
        throw new NoSuchElementException("No value present");
    }

    public int hashCode() {
        if (!this.isPresent) {
            return 0;
        }
        long j = this.value;
        return (int) (j ^ (j >>> 32));
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public String toString() {
        if (!this.isPresent) {
            return "OptionalLong.empty";
        }
        return String.format("OptionalLong[%s]", new Object[]{Long.valueOf(this.value)});
    }
}
