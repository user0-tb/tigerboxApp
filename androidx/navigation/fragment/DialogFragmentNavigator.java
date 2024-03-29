package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.NavigatorState;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J*\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo33737d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "restoredTagsAwaitingAttach", "", "", "createDestination", "navigate", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "entries", "", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "onAttach", "state", "Landroidx/navigation/NavigatorState;", "popBackStack", "popUpTo", "savedState", "", "Companion", "Destination", "navigation-fragment_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@Navigator.Name("dialog")
/* compiled from: DialogFragmentNavigator.kt */
public final class DialogFragmentNavigator extends Navigator<Destination> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String TAG = "DialogFragmentNavigator";
    private final Context context;
    private final FragmentManager fragmentManager;
    private final LifecycleEventObserver observer = new DialogFragmentNavigator$$ExternalSyntheticLambda1(this);
    private final Set<String> restoredTagsAwaitingAttach = new LinkedHashSet();

    public DialogFragmentNavigator(Context context2, FragmentManager fragmentManager2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        this.context = context2;
        this.fragmentManager = fragmentManager2;
    }

    /* access modifiers changed from: private */
    /* renamed from: observer$lambda-3  reason: not valid java name */
    public static final void m688observer$lambda3(DialogFragmentNavigator dialogFragmentNavigator, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Object obj;
        Intrinsics.checkNotNullParameter(dialogFragmentNavigator, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        boolean z = false;
        if (event == Lifecycle.Event.ON_CREATE) {
            DialogFragment dialogFragment = (DialogFragment) lifecycleOwner;
            Iterable value = dialogFragmentNavigator.getState().getBackStack().getValue();
            if (!(value instanceof Collection) || !((Collection) value).isEmpty()) {
                Iterator it = value.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.areEqual((Object) ((NavBackStackEntry) it.next()).getId(), (Object) dialogFragment.getTag())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (!z) {
                dialogFragment.dismiss();
            }
        } else if (event == Lifecycle.Event.ON_STOP) {
            DialogFragment dialogFragment2 = (DialogFragment) lifecycleOwner;
            if (!dialogFragment2.requireDialog().isShowing()) {
                List value2 = dialogFragmentNavigator.getState().getBackStack().getValue();
                ListIterator listIterator = value2.listIterator(value2.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        obj = null;
                        break;
                    }
                    obj = listIterator.previous();
                    if (Intrinsics.areEqual((Object) ((NavBackStackEntry) obj).getId(), (Object) dialogFragment2.getTag())) {
                        break;
                    }
                }
                if (obj != null) {
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                    if (!Intrinsics.areEqual(CollectionsKt.lastOrNull(value2), (Object) navBackStackEntry)) {
                        Log.i(TAG, "Dialog " + dialogFragment2 + " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
                    }
                    dialogFragmentNavigator.popBackStack(navBackStackEntry, false);
                    return;
                }
                throw new IllegalStateException(("Dialog " + dialogFragment2 + " has already been popped off of the Navigation back stack").toString());
            }
        }
    }

    public void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        if (this.fragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List value = getState().getBackStack().getValue();
        for (NavBackStackEntry id : CollectionsKt.reversed(value.subList(value.indexOf(navBackStackEntry), value.size()))) {
            Fragment findFragmentByTag = this.fragmentManager.findFragmentByTag(id.getId());
            if (findFragmentByTag != null) {
                findFragmentByTag.getLifecycle().removeObserver(this.observer);
                ((DialogFragment) findFragmentByTag).dismiss();
            }
        }
        getState().pop(navBackStackEntry, z);
    }

    public Destination createDestination() {
        return new Destination((Navigator<? extends Destination>) this);
    }

    public void navigate(List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(list, "entries");
        if (this.fragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        for (NavBackStackEntry navigate : list) {
            navigate(navigate);
        }
    }

    private final void navigate(NavBackStackEntry navBackStackEntry) {
        Destination destination = (Destination) navBackStackEntry.getDestination();
        String className = destination.getClassName();
        if (className.charAt(0) == '.') {
            className = Intrinsics.stringPlus(this.context.getPackageName(), className);
        }
        Fragment instantiate = this.fragmentManager.getFragmentFactory().instantiate(this.context.getClassLoader(), className);
        Intrinsics.checkNotNullExpressionValue(instantiate, "fragmentManager.fragment…ader, className\n        )");
        if (DialogFragment.class.isAssignableFrom(instantiate.getClass())) {
            DialogFragment dialogFragment = (DialogFragment) instantiate;
            dialogFragment.setArguments(navBackStackEntry.getArguments());
            dialogFragment.getLifecycle().addObserver(this.observer);
            dialogFragment.show(this.fragmentManager, navBackStackEntry.getId());
            getState().push(navBackStackEntry);
            return;
        }
        throw new IllegalArgumentException(("Dialog destination " + destination.getClassName() + " is not an instance of DialogFragment").toString());
    }

    public void onAttach(NavigatorState navigatorState) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(navigatorState, "state");
        super.onAttach(navigatorState);
        for (NavBackStackEntry navBackStackEntry : navigatorState.getBackStack().getValue()) {
            DialogFragment dialogFragment = (DialogFragment) this.fragmentManager.findFragmentByTag(navBackStackEntry.getId());
            Unit unit = null;
            if (!(dialogFragment == null || (lifecycle = dialogFragment.getLifecycle()) == null)) {
                lifecycle.addObserver(this.observer);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.restoredTagsAwaitingAttach.add(navBackStackEntry.getId());
            }
        }
        this.fragmentManager.addFragmentOnAttachListener(new DialogFragmentNavigator$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttach$lambda-5  reason: not valid java name */
    public static final void m689onAttach$lambda5(DialogFragmentNavigator dialogFragmentNavigator, FragmentManager fragmentManager2, Fragment fragment) {
        Intrinsics.checkNotNullParameter(dialogFragmentNavigator, "this$0");
        Intrinsics.checkNotNullParameter(fragmentManager2, "$noName_0");
        Intrinsics.checkNotNullParameter(fragment, "childFragment");
        if (dialogFragmentNavigator.restoredTagsAwaitingAttach.remove(fragment.getTag())) {
            fragment.getLifecycle().addObserver(dialogFragmentNavigator.observer);
        }
    }

    @Metadata(mo33736d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, mo33737d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/FloatingWindow;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "fragmentNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "_className", "", "className", "getClassName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setClassName", "navigation-fragment_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DialogFragmentNavigator.kt */
    public static class Destination extends NavDestination implements FloatingWindow {
        private String _className;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(Navigator<? extends Destination> navigator) {
            super((Navigator<? extends NavDestination>) navigator);
            Intrinsics.checkNotNullParameter(navigator, "fragmentNavigator");
        }

        public final String getClassName() {
            String str = this._className;
            if (str != null) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.String");
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set".toString());
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Destination(NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(DialogFragmentNavigator.class));
            Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        }

        public void onInflate(Context context, AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0616R.styleable.DialogFragmentNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…ntNavigator\n            )");
            String string = obtainAttributes.getString(C0616R.styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                setClassName(string);
            }
            obtainAttributes.recycle();
        }

        public final Destination setClassName(String str) {
            Intrinsics.checkNotNullParameter(str, "className");
            this._className = str;
            return this;
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

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator$Companion;", "", "()V", "TAG", "", "navigation-fragment_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DialogFragmentNavigator.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
