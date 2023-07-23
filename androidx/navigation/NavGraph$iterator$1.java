package androidx.navigation;

import androidx.collection.SparseArrayCompat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import p009j$.util.Iterator;
import p009j$.util.function.Consumer;
import p009j$.wrappers.C$r8$wrapper$java$util$function$Consumer$VWRP;

@Metadata(mo33736d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0002J\t\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo33737d2 = {"androidx/navigation/NavGraph$iterator$1", "", "Landroidx/navigation/NavDestination;", "index", "", "wentToNext", "", "hasNext", "next", "remove", "", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NavGraph.kt */
public final class NavGraph$iterator$1 implements Iterator<NavDestination>, KMutableIterator, p009j$.util.Iterator {
    private int index = -1;
    final /* synthetic */ NavGraph this$0;
    private boolean wentToNext;

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
    }

    NavGraph$iterator$1(NavGraph navGraph) {
        this.this$0 = navGraph;
    }

    public boolean hasNext() {
        return this.index + 1 < this.this$0.getNodes().size();
    }

    public NavDestination next() {
        if (hasNext()) {
            this.wentToNext = true;
            SparseArrayCompat<NavDestination> nodes = this.this$0.getNodes();
            int i = this.index + 1;
            this.index = i;
            NavDestination valueAt = nodes.valueAt(i);
            Intrinsics.checkNotNullExpressionValue(valueAt, "nodes.valueAt(++index)");
            return valueAt;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.wentToNext) {
            SparseArrayCompat<NavDestination> nodes = this.this$0.getNodes();
            nodes.valueAt(this.index).setParent((NavGraph) null);
            nodes.removeAt(this.index);
            this.index--;
            this.wentToNext = false;
            return;
        }
        throw new IllegalStateException("You must call next() before you can remove an element".toString());
    }
}
