package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NavController.kt */
final class NavController$handleDeepLink$2 extends Lambda implements Function1<NavOptionsBuilder, Unit> {
    final /* synthetic */ NavDestination $node;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavController$handleDeepLink$2(NavDestination navDestination, NavController navController) {
        super(1);
        this.$node = navDestination;
        this.this$0 = navController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        if (r0 != false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.navigation.NavOptionsBuilder r7) {
        /*
            r6 = this;
            java.lang.String r0 = "$this$navOptions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.navigation.NavController$handleDeepLink$2$1 r0 = androidx.navigation.NavController$handleDeepLink$2.C06101.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r7.anim(r0)
            androidx.navigation.NavDestination r0 = r6.$node
            boolean r0 = r0 instanceof androidx.navigation.NavGraph
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0046
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.Companion
            androidx.navigation.NavDestination r3 = r6.$node
            kotlin.sequences.Sequence r0 = r0.getHierarchy(r3)
            androidx.navigation.NavController r3 = r6.this$0
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0042
            java.lang.Object r4 = r0.next()
            androidx.navigation.NavDestination r4 = (androidx.navigation.NavDestination) r4
            androidx.navigation.NavDestination r5 = r3.getCurrentDestination()
            if (r5 != 0) goto L_0x0036
            r5 = 0
            goto L_0x003a
        L_0x0036:
            androidx.navigation.NavGraph r5 = r5.getParent()
        L_0x003a:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0022
            r0 = 0
            goto L_0x0043
        L_0x0042:
            r0 = 1
        L_0x0043:
            if (r0 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r1 = 0
        L_0x0047:
            if (r1 == 0) goto L_0x0066
            boolean r0 = androidx.navigation.NavController.deepLinkSaveState
            if (r0 == 0) goto L_0x0066
            androidx.navigation.NavGraph$Companion r0 = androidx.navigation.NavGraph.Companion
            androidx.navigation.NavController r1 = r6.this$0
            androidx.navigation.NavGraph r1 = r1.getGraph()
            androidx.navigation.NavDestination r0 = r0.findStartDestination(r1)
            int r0 = r0.getId()
            androidx.navigation.NavController$handleDeepLink$2$2 r1 = androidx.navigation.NavController$handleDeepLink$2.C06112.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r7.popUpTo((int) r0, (kotlin.jvm.functions.Function1<? super androidx.navigation.PopUpToBuilder, kotlin.Unit>) r1)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController$handleDeepLink$2.invoke(androidx.navigation.NavOptionsBuilder):void");
    }
}
