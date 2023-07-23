package media.tiger.tigerbox.p016ui;

import androidx.lifecycle.LiveDataScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import media.tiger.tigerbox.infrastructure.interactor.Event;
import media.tiger.tigerbox.usecase.OnboardingCompletedUseCase;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lmedia/tiger/tigerbox/infrastructure/interactor/Event;", "Lmedia/tiger/tigerbox/ui/LaunchNavigationAction;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.LaunchViewModel$launchDestination$1", mo34424f = "LaunchViewModel.kt", mo34425i = {0}, mo34426l = {21, 23, 25}, mo34427m = "invokeSuspend", mo34428n = {"$this$liveData"}, mo34429s = {"L$0"})
/* renamed from: media.tiger.tigerbox.ui.LaunchViewModel$launchDestination$1 */
/* compiled from: LaunchViewModel.kt */
final class LaunchViewModel$launchDestination$1 extends SuspendLambda implements Function2<LiveDataScope<Event<? extends LaunchNavigationAction>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnboardingCompletedUseCase $onboardingCompletedUseCase;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LaunchViewModel$launchDestination$1(OnboardingCompletedUseCase onboardingCompletedUseCase, Continuation<? super LaunchViewModel$launchDestination$1> continuation) {
        super(2, continuation);
        this.$onboardingCompletedUseCase = onboardingCompletedUseCase;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LaunchViewModel$launchDestination$1 launchViewModel$launchDestination$1 = new LaunchViewModel$launchDestination$1(this.$onboardingCompletedUseCase, continuation);
        launchViewModel$launchDestination$1.L$0 = obj;
        return launchViewModel$launchDestination$1;
    }

    public final Object invoke(LiveDataScope<Event<LaunchNavigationAction>> liveDataScope, Continuation<? super Unit> continuation) {
        return ((LaunchViewModel$launchDestination$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.lifecycle.LiveDataScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r4) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007e
        L_0x001e:
            java.lang.Object r1 = r7.L$0
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0040
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            media.tiger.tigerbox.usecase.OnboardingCompletedUseCase r8 = r7.$onboardingCompletedUseCase
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = r8.invoke(r5, r6)
            if (r8 != r0) goto L_0x0040
            return r0
        L_0x0040:
            media.tiger.tigerbox.infrastructure.functional.Either r8 = (media.tiger.tigerbox.infrastructure.functional.Either) r8
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            java.lang.Object r8 = media.tiger.tigerbox.infrastructure.functional.EitherKt.getOrElse(r8, r4)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r4 = 0
            if (r8 != 0) goto L_0x0069
            media.tiger.tigerbox.infrastructure.interactor.Event r8 = new media.tiger.tigerbox.infrastructure.interactor.Event
            media.tiger.tigerbox.ui.LaunchNavigationAction$NavigateToOnboardingAction r2 = media.tiger.tigerbox.p016ui.LaunchNavigationAction.NavigateToOnboardingAction.INSTANCE
            r8.<init>(r2)
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.L$0 = r4
            r7.label = r3
            java.lang.Object r8 = r1.emit(r8, r2)
            if (r8 != r0) goto L_0x007e
            return r0
        L_0x0069:
            media.tiger.tigerbox.infrastructure.interactor.Event r8 = new media.tiger.tigerbox.infrastructure.interactor.Event
            media.tiger.tigerbox.ui.LaunchNavigationAction$NavigateToMainActivityAction r3 = media.tiger.tigerbox.p016ui.LaunchNavigationAction.NavigateToMainActivityAction.INSTANCE
            r8.<init>(r3)
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.L$0 = r4
            r7.label = r2
            java.lang.Object r8 = r1.emit(r8, r3)
            if (r8 != r0) goto L_0x007e
            return r0
        L_0x007e:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.LaunchViewModel$launchDestination$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
