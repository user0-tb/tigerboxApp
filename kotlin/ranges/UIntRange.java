package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0018\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R \u0010\b\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001d"}, mo33737d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-pVg5ArA$annotations", "()V", "getEndExclusive-pVg5ArA", "()I", "getEndInclusive-pVg5ArA", "getStart-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* compiled from: UIntRange.kt */
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UIntRange EMPTY = new UIntRange(-1, 0, (DefaultConstructorMarker) null);

    public /* synthetic */ UIntRange(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    /* renamed from: getEndExclusive-pVg5ArA$annotations  reason: not valid java name */
    public static /* synthetic */ void m2001getEndExclusivepVg5ArA$annotations() {
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return m2002containsWZ4Q5Ns(((UInt) comparable).m917unboximpl());
    }

    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return UInt.m860boximpl(m2003getEndExclusivepVg5ArA());
    }

    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return UInt.m860boximpl(m2004getEndInclusivepVg5ArA());
    }

    public /* bridge */ /* synthetic */ Comparable getStart() {
        return UInt.m860boximpl(m2005getStartpVg5ArA());
    }

    private UIntRange(int i, int i2) {
        super(i, i2, 1, (DefaultConstructorMarker) null);
    }

    /* renamed from: getStart-pVg5ArA  reason: not valid java name */
    public int m2005getStartpVg5ArA() {
        return m1997getFirstpVg5ArA();
    }

    /* renamed from: getEndInclusive-pVg5ArA  reason: not valid java name */
    public int m2004getEndInclusivepVg5ArA() {
        return m1998getLastpVg5ArA();
    }

    /* renamed from: getEndExclusive-pVg5ArA  reason: not valid java name */
    public int m2003getEndExclusivepVg5ArA() {
        if (m1998getLastpVg5ArA() != -1) {
            return UInt.m866constructorimpl(m1998getLastpVg5ArA() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m2002containsWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(m1997getFirstpVg5ArA(), i) <= 0 && UnsignedKt.uintCompare(i, m1998getLastpVg5ArA()) <= 0;
    }

    public boolean isEmpty() {
        return UnsignedKt.uintCompare(m1997getFirstpVg5ArA(), m1998getLastpVg5ArA()) > 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) obj).isEmpty()) {
                UIntRange uIntRange = (UIntRange) obj;
                if (!(m1997getFirstpVg5ArA() == uIntRange.m1997getFirstpVg5ArA() && m1998getLastpVg5ArA() == uIntRange.m1998getLastpVg5ArA())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m1997getFirstpVg5ArA() * 31) + m1998getLastpVg5ArA();
    }

    public String toString() {
        return UInt.m911toStringimpl(m1997getFirstpVg5ArA()) + ".." + UInt.m911toStringimpl(m1998getLastpVg5ArA());
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo33737d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    /* compiled from: UIntRange.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UIntRange getEMPTY() {
            return UIntRange.EMPTY;
        }
    }
}
