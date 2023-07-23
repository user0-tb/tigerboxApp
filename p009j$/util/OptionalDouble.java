package p009j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.OptionalDouble */
public final class OptionalDouble {
    private static final OptionalDouble EMPTY = new OptionalDouble();
    private final boolean isPresent;
    private final double value;

    private OptionalDouble() {
        this.isPresent = false;
        this.value = Double.NaN;
    }

    private OptionalDouble(double d) {
        this.isPresent = true;
        this.value = d;
    }

    public static OptionalDouble empty() {
        return EMPTY;
    }

    /* renamed from: of */
    public static OptionalDouble m202of(double d) {
        return new OptionalDouble(d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionalDouble)) {
            return false;
        }
        OptionalDouble optionalDouble = (OptionalDouble) obj;
        boolean z = this.isPresent;
        if (!z || !optionalDouble.isPresent) {
            if (z == optionalDouble.isPresent) {
                return true;
            }
        } else if (Double.compare(this.value, optionalDouble.value) == 0) {
            return true;
        }
        return false;
    }

    public double getAsDouble() {
        if (this.isPresent) {
            return this.value;
        }
        throw new NoSuchElementException("No value present");
    }

    public int hashCode() {
        if (!this.isPresent) {
            return 0;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.value);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public String toString() {
        if (!this.isPresent) {
            return "OptionalDouble.empty";
        }
        return String.format("OptionalDouble[%s]", new Object[]{Double.valueOf(this.value)});
    }
}
