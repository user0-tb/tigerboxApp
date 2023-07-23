package androidx.navigation.fragment;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.fragment.DialogFragmentNavigator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo33737d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigatorDestinationBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "navigator", "Landroidx/navigation/fragment/DialogFragmentNavigator;", "id", "", "fragmentClass", "Lkotlin/reflect/KClass;", "Landroidx/fragment/app/DialogFragment;", "(Landroidx/navigation/fragment/DialogFragmentNavigator;ILkotlin/reflect/KClass;)V", "route", "", "(Landroidx/navigation/fragment/DialogFragmentNavigator;Ljava/lang/String;Lkotlin/reflect/KClass;)V", "build", "navigation-fragment_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@NavDestinationDsl
/* compiled from: DialogFragmentNavigatorDestinationBuilder.kt */
public final class DialogFragmentNavigatorDestinationBuilder extends NavDestinationBuilder<DialogFragmentNavigator.Destination> {
    private KClass<? extends DialogFragment> fragmentClass;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use routes to build your DialogFragmentNavigatorDestination instead", replaceWith = @ReplaceWith(expression = "DialogFragmentNavigatorDestinationBuilder(navigator, route = id.toString(), fragmentClass) ", imports = {}))
    public DialogFragmentNavigatorDestinationBuilder(DialogFragmentNavigator dialogFragmentNavigator, int i, KClass<? extends DialogFragment> kClass) {
        super(dialogFragmentNavigator, i);
        Intrinsics.checkNotNullParameter(dialogFragmentNavigator, "navigator");
        Intrinsics.checkNotNullParameter(kClass, "fragmentClass");
        this.fragmentClass = kClass;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogFragmentNavigatorDestinationBuilder(DialogFragmentNavigator dialogFragmentNavigator, String str, KClass<? extends DialogFragment> kClass) {
        super(dialogFragmentNavigator, str);
        Intrinsics.checkNotNullParameter(dialogFragmentNavigator, "navigator");
        Intrinsics.checkNotNullParameter(str, "route");
        Intrinsics.checkNotNullParameter(kClass, "fragmentClass");
        this.fragmentClass = kClass;
    }

    public DialogFragmentNavigator.Destination build() {
        DialogFragmentNavigator.Destination destination = (DialogFragmentNavigator.Destination) super.build();
        String name = JvmClassMappingKt.getJavaClass(this.fragmentClass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "fragmentClass.java.name");
        destination.setClassName(name);
        return destination;
    }
}
