package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0002H\u0016J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J*\u0010\u0013\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\"H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo33737d2 = {"Landroidx/navigation/fragment/FragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "savedIds", "", "", "createDestination", "instantiateFragment", "Landroidx/fragment/app/Fragment;", "className", "args", "Landroid/os/Bundle;", "navigate", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "entries", "", "onRestoreState", "savedState", "onSaveState", "popBackStack", "popUpTo", "", "Companion", "Destination", "Extras", "navigation-fragment_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@Navigator.Name("fragment")
/* compiled from: FragmentNavigator.kt */
public class FragmentNavigator extends Navigator<Destination> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String KEY_SAVED_IDS = "androidx-nav-fragment:navigator:savedIds";
    @Deprecated
    private static final String TAG = "FragmentNavigator";
    private final int containerId;
    private final Context context;
    private final FragmentManager fragmentManager;
    private final Set<String> savedIds = new LinkedHashSet();

    public FragmentNavigator(Context context2, FragmentManager fragmentManager2, int i) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        this.context = context2;
        this.fragmentManager = fragmentManager2;
        this.containerId = i;
    }

    public void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        if (this.fragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        if (z) {
            List value = getState().getBackStack().getValue();
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.first(value);
            for (NavBackStackEntry navBackStackEntry3 : CollectionsKt.reversed(value.subList(value.indexOf(navBackStackEntry), value.size()))) {
                if (Intrinsics.areEqual((Object) navBackStackEntry3, (Object) navBackStackEntry2)) {
                    Log.i(TAG, Intrinsics.stringPlus("FragmentManager cannot save the state of the initial destination ", navBackStackEntry3));
                } else {
                    this.fragmentManager.saveBackStack(navBackStackEntry3.getId());
                    this.savedIds.add(navBackStackEntry3.getId());
                }
            }
        } else {
            this.fragmentManager.popBackStack(navBackStackEntry.getId(), 1);
        }
        getState().pop(navBackStackEntry, z);
    }

    public Destination createDestination() {
        return new Destination((Navigator<? extends Destination>) this);
    }

    @Deprecated(message = "Set a custom {@link androidx.fragment.app.FragmentFactory} via\n      {@link FragmentManager#setFragmentFactory(FragmentFactory)} to control\n      instantiation of Fragments.")
    public Fragment instantiateFragment(Context context2, FragmentManager fragmentManager2, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        Intrinsics.checkNotNullParameter(str, "className");
        Fragment instantiate = fragmentManager2.getFragmentFactory().instantiate(context2.getClassLoader(), str);
        Intrinsics.checkNotNullExpressionValue(instantiate, "fragmentManager.fragment…t.classLoader, className)");
        return instantiate;
    }

    public void navigate(List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(list, "entries");
        if (this.fragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        for (NavBackStackEntry navigate : list) {
            navigate(navigate, navOptions, extras);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void navigate(androidx.navigation.NavBackStackEntry r13, androidx.navigation.NavOptions r14, androidx.navigation.Navigator.Extras r15) {
        /*
            r12 = this;
            androidx.navigation.NavigatorState r0 = r12.getState()
            kotlinx.coroutines.flow.StateFlow r0 = r0.getBackStack()
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            r2 = 1
            r3 = 0
            if (r14 == 0) goto L_0x002c
            if (r1 != 0) goto L_0x002c
            boolean r4 = r14.shouldRestoreState()
            if (r4 == 0) goto L_0x002c
            java.util.Set<java.lang.String> r4 = r12.savedIds
            java.lang.String r5 = r13.getId()
            boolean r4 = r4.remove(r5)
            if (r4 == 0) goto L_0x002c
            r4 = 1
            goto L_0x002d
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 == 0) goto L_0x0040
            androidx.fragment.app.FragmentManager r14 = r12.fragmentManager
            java.lang.String r15 = r13.getId()
            r14.restoreBackStack(r15)
            androidx.navigation.NavigatorState r14 = r12.getState()
            r14.push(r13)
            return
        L_0x0040:
            androidx.navigation.NavDestination r4 = r13.getDestination()
            androidx.navigation.fragment.FragmentNavigator$Destination r4 = (androidx.navigation.fragment.FragmentNavigator.Destination) r4
            android.os.Bundle r5 = r13.getArguments()
            java.lang.String r6 = r4.getClassName()
            char r7 = r6.charAt(r3)
            r8 = 46
            if (r7 != r8) goto L_0x0060
            android.content.Context r7 = r12.context
            java.lang.String r7 = r7.getPackageName()
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r6)
        L_0x0060:
            androidx.fragment.app.FragmentManager r7 = r12.fragmentManager
            androidx.fragment.app.FragmentFactory r7 = r7.getFragmentFactory()
            android.content.Context r8 = r12.context
            java.lang.ClassLoader r8 = r8.getClassLoader()
            androidx.fragment.app.Fragment r6 = r7.instantiate(r8, r6)
            java.lang.String r7 = "fragmentManager.fragment…t.classLoader, className)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r6.setArguments(r5)
            androidx.fragment.app.FragmentManager r5 = r12.fragmentManager
            androidx.fragment.app.FragmentTransaction r5 = r5.beginTransaction()
            java.lang.String r7 = "fragmentManager.beginTransaction()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            r7 = -1
            if (r14 != 0) goto L_0x0088
            r8 = -1
            goto L_0x008c
        L_0x0088:
            int r8 = r14.getEnterAnim()
        L_0x008c:
            if (r14 != 0) goto L_0x0090
            r9 = -1
            goto L_0x0094
        L_0x0090:
            int r9 = r14.getExitAnim()
        L_0x0094:
            if (r14 != 0) goto L_0x0098
            r10 = -1
            goto L_0x009c
        L_0x0098:
            int r10 = r14.getPopEnterAnim()
        L_0x009c:
            if (r14 != 0) goto L_0x00a0
            r11 = -1
            goto L_0x00a4
        L_0x00a0:
            int r11 = r14.getPopExitAnim()
        L_0x00a4:
            if (r8 != r7) goto L_0x00ac
            if (r9 != r7) goto L_0x00ac
            if (r10 != r7) goto L_0x00ac
            if (r11 == r7) goto L_0x00bf
        L_0x00ac:
            if (r8 == r7) goto L_0x00af
            goto L_0x00b0
        L_0x00af:
            r8 = 0
        L_0x00b0:
            if (r9 == r7) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r9 = 0
        L_0x00b4:
            if (r10 == r7) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r10 = 0
        L_0x00b8:
            if (r11 == r7) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r11 = 0
        L_0x00bc:
            r5.setCustomAnimations(r8, r9, r10, r11)
        L_0x00bf:
            int r7 = r12.containerId
            r5.replace(r7, r6)
            r5.setPrimaryNavigationFragment(r6)
            int r4 = r4.getId()
            if (r14 == 0) goto L_0x00e7
            if (r1 != 0) goto L_0x00e7
            boolean r14 = r14.shouldLaunchSingleTop()
            if (r14 == 0) goto L_0x00e7
            java.lang.Object r14 = kotlin.collections.CollectionsKt.last(r0)
            androidx.navigation.NavBackStackEntry r14 = (androidx.navigation.NavBackStackEntry) r14
            androidx.navigation.NavDestination r14 = r14.getDestination()
            int r14 = r14.getId()
            if (r14 != r4) goto L_0x00e7
            r14 = 1
            goto L_0x00e8
        L_0x00e7:
            r14 = 0
        L_0x00e8:
            if (r1 == 0) goto L_0x00ec
        L_0x00ea:
            r3 = 1
            goto L_0x010d
        L_0x00ec:
            if (r14 == 0) goto L_0x0105
            int r14 = r0.size()
            if (r14 <= r2) goto L_0x010d
            androidx.fragment.app.FragmentManager r14 = r12.fragmentManager
            java.lang.String r0 = r13.getId()
            r14.popBackStack((java.lang.String) r0, (int) r2)
            java.lang.String r14 = r13.getId()
            r5.addToBackStack(r14)
            goto L_0x010d
        L_0x0105:
            java.lang.String r14 = r13.getId()
            r5.addToBackStack(r14)
            goto L_0x00ea
        L_0x010d:
            boolean r14 = r15 instanceof androidx.navigation.fragment.FragmentNavigator.Extras
            if (r14 == 0) goto L_0x013b
            androidx.navigation.fragment.FragmentNavigator$Extras r15 = (androidx.navigation.fragment.FragmentNavigator.Extras) r15
            java.util.Map r14 = r15.getSharedElements()
            java.util.Set r14 = r14.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x011f:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x013b
            java.lang.Object r15 = r14.next()
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15
            java.lang.Object r0 = r15.getKey()
            android.view.View r0 = (android.view.View) r0
            java.lang.Object r15 = r15.getValue()
            java.lang.String r15 = (java.lang.String) r15
            r5.addSharedElement(r0, r15)
            goto L_0x011f
        L_0x013b:
            r5.setReorderingAllowed(r2)
            r5.commit()
            if (r3 == 0) goto L_0x014a
            androidx.navigation.NavigatorState r14 = r12.getState()
            r14.push(r13)
        L_0x014a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.FragmentNavigator.navigate(androidx.navigation.NavBackStackEntry, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    public Bundle onSaveState() {
        if (this.savedIds.isEmpty()) {
            return null;
        }
        return BundleKt.bundleOf(TuplesKt.m475to(KEY_SAVED_IDS, new ArrayList(this.savedIds)));
    }

    public void onRestoreState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "savedState");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_SAVED_IDS);
        if (stringArrayList != null) {
            this.savedIds.clear();
            CollectionsKt.addAll(this.savedIds, stringArrayList);
        }
    }

    @Metadata(mo33736d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\tH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, mo33737d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "fragmentNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "_className", "", "className", "getClassName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setClassName", "toString", "navigation-fragment_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: FragmentNavigator.kt */
    public static class Destination extends NavDestination {
        private String _className;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(Navigator<? extends Destination> navigator) {
            super((Navigator<? extends NavDestination>) navigator);
            Intrinsics.checkNotNullParameter(navigator, "fragmentNavigator");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Destination(NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(FragmentNavigator.class));
            Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        }

        public void onInflate(Context context, AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0616R.styleable.FragmentNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…leable.FragmentNavigator)");
            String string = obtainAttributes.getString(C0616R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                setClassName(string);
            }
            Unit unit = Unit.INSTANCE;
            obtainAttributes.recycle();
        }

        public final Destination setClassName(String str) {
            Intrinsics.checkNotNullParameter(str, "className");
            this._className = str;
            return this;
        }

        public final String getClassName() {
            String str = this._className;
            if (str != null) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.String");
                return str;
            }
            throw new IllegalStateException("Fragment class was not set".toString());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this._className;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Destination) || !super.equals(obj) || !Intrinsics.areEqual((Object) this._className, (Object) ((Destination) obj)._className)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            String str = this._className;
            return hashCode + (str == null ? 0 : str.hashCode());
        }
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u001b\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, mo33737d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "sharedElements", "", "Landroid/view/View;", "", "(Ljava/util/Map;)V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getSharedElements", "()Ljava/util/Map;", "Builder", "navigation-fragment_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: FragmentNavigator.kt */
    public static final class Extras implements Navigator.Extras {
        private final LinkedHashMap<View, String> _sharedElements;

        public Extras(Map<View, String> map) {
            Intrinsics.checkNotNullParameter(map, "sharedElements");
            LinkedHashMap<View, String> linkedHashMap = new LinkedHashMap<>();
            this._sharedElements = linkedHashMap;
            linkedHashMap.putAll(map);
        }

        public final Map<View, String> getSharedElements() {
            return MapsKt.toMap(this._sharedElements);
        }

        @Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u000b\u001a\u00020\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\rJ\u0006\u0010\u000e\u001a\u00020\u000fR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo33737d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras$Builder;", "", "()V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "", "Lkotlin/collections/LinkedHashMap;", "addSharedElement", "sharedElement", "name", "addSharedElements", "sharedElements", "", "build", "Landroidx/navigation/fragment/FragmentNavigator$Extras;", "navigation-fragment_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: FragmentNavigator.kt */
        public static final class Builder {
            private final LinkedHashMap<View, String> _sharedElements = new LinkedHashMap<>();

            public final Builder addSharedElements(Map<View, String> map) {
                Intrinsics.checkNotNullParameter(map, "sharedElements");
                for (Map.Entry next : map.entrySet()) {
                    addSharedElement((View) next.getKey(), (String) next.getValue());
                }
                return this;
            }

            public final Builder addSharedElement(View view, String str) {
                Intrinsics.checkNotNullParameter(view, "sharedElement");
                Intrinsics.checkNotNullParameter(str, "name");
                this._sharedElements.put(view, str);
                return this;
            }

            public final Extras build() {
                return new Extras(this._sharedElements);
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Companion;", "", "()V", "KEY_SAVED_IDS", "", "TAG", "navigation-fragment_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: FragmentNavigator.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
