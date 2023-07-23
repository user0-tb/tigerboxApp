package media.tiger.tigerbox.p016ui.main.profiles;

import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.ProfilesItem;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel$onClick$1$1", mo34424f = "ProfilesViewModel.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel$onClick$1$1 */
/* compiled from: ProfilesViewModel.kt */
final class ProfilesViewModel$onClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $assignUrl;
    final /* synthetic */ ProfilesItem $data;
    int label;
    final /* synthetic */ ProfilesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfilesViewModel$onClick$1$1(String str, ProfilesItem profilesItem, ProfilesViewModel profilesViewModel, Continuation<? super ProfilesViewModel$onClick$1$1> continuation) {
        super(2, continuation);
        this.$assignUrl = str;
        this.$data = profilesItem;
        this.this$0 = profilesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfilesViewModel$onClick$1$1(this.$assignUrl, this.$data, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfilesViewModel$onClick$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest forest = Timber.Forest;
            forest.mo50221i("assignProfileToAccountUseCase: url " + this.$assignUrl + ", id: " + this.$data.getId(), new Object[0]);
            AssignProfileToAccountUseCase access$getAssignProfileToAccountUseCase$p = this.this$0.assignProfileToAccountUseCase;
            AssignProfileToAccountUseCase.RequestParams requestParams = new AssignProfileToAccountUseCase.RequestParams(this.$assignUrl, this.$data.getId());
            CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this.this$0);
            final ProfilesViewModel profilesViewModel = this.this$0;
            access$getAssignProfileToAccountUseCase$p.invoke(requestParams, viewModelScope, new Function1<Either<? extends Failure, ? extends DeviceInformation>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Either<? extends Failure, DeviceInformation>) (Either) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Either<? extends Failure, DeviceInformation> either) {
                    Intrinsics.checkNotNullParameter(either, "it");
                    either.fold(new Function1<Failure, Unit>(profilesViewModel) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Failure) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Failure failure) {
                            Intrinsics.checkNotNullParameter(failure, "p0");
                            ((ProfilesViewModel) this.receiver).assignProfileToBackendFailureHandler(failure);
                        }
                    }, new Function1<DeviceInformation, Unit>(profilesViewModel) {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((DeviceInformation) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(DeviceInformation deviceInformation) {
                            Intrinsics.checkNotNullParameter(deviceInformation, "p0");
                            ((ProfilesViewModel) this.receiver).assignProfileSuccessHandler(deviceInformation);
                        }
                    });
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
