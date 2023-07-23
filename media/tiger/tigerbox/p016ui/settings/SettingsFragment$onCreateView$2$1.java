package media.tiger.tigerbox.p016ui.settings;

import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.C2814R;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.settings.SettingsFragment$onCreateView$2$1", mo34424f = "SettingsFragment.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$onCreateView$2$1 */
/* compiled from: SettingsFragment.kt */
final class SettingsFragment$onCreateView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Boolean $it;
    final /* synthetic */ List<SettingsItemData> $settingsItemsList;
    int label;
    final /* synthetic */ SettingsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsFragment$onCreateView$2$1(Boolean bool, List<? extends SettingsItemData> list, SettingsFragment settingsFragment, Continuation<? super SettingsFragment$onCreateView$2$1> continuation) {
        super(2, continuation);
        this.$it = bool;
        this.$settingsItemsList = list;
        this.this$0 = settingsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsFragment$onCreateView$2$1(this.$it, this.$settingsItemsList, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsFragment$onCreateView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Boolean bool = this.$it;
            Intrinsics.checkNotNullExpressionValue(bool, "it");
            SettingsAdapter settingsAdapter = null;
            if (bool.booleanValue()) {
                for (SettingsItemData settingsItemData : this.$settingsItemsList) {
                    if (settingsItemData.getId() == C2814R.string.settings_delete_downloads) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        SettingsAdapter access$getAdapter$p = this.this$0.adapter;
                        if (access$getAdapter$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        } else {
                            settingsAdapter = access$getAdapter$p;
                        }
                        settingsAdapter.updateData(CollectionsKt.minus(this.$settingsItemsList, settingsItemData));
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            SettingsAdapter access$getAdapter$p2 = this.this$0.adapter;
            if (access$getAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                settingsAdapter = access$getAdapter$p2;
            }
            settingsAdapter.updateData(this.$settingsItemsList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
