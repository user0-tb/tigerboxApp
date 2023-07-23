package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.model.domain.TigerTicketFail;
import media.tiger.tigerbox.model.dto.TigerTicketAssignedProduct;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.CardValidationFailError;
import media.tiger.tigerbox.services.interfaces.TicketFailure;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.services.interfaces.TigerTicketDomain;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepType;
import media.tiger.tigerbox.usecase.TigerTicketGetProductUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0011\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u0018J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0006\u0010!\u001a\u00020\u0018R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "tigerCardsManagerService", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;", "tigerTicketGetProductUseCase", "Lmedia/tiger/tigerbox/usecase/TigerTicketGetProductUseCase;", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;Lmedia/tiger/tigerbox/usecase/TigerTicketGetProductUseCase;)V", "_viewState", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "ticketCode", "", "tigerCardListener", "media/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$tigerCardListener$1", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$tigerCardListener$1;", "viewState", "Landroidx/lifecycle/LiveData;", "getViewState", "()Landroidx/lifecycle/LiveData;", "getTicketProduct", "", "code", "registerListeners", "ticketProductFailureHandler", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "ticketProductSuccessHandler", "ticketProduct", "Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct;", "unregisterListeners", "ViewState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel */
/* compiled from: TicketRedeemTicketNumberViewModel.kt */
public final class TicketRedeemTicketNumberViewModel extends DialogViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<ViewState> _viewState;
    private CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
    private String ticketCode = "";
    private final TicketRedeemTicketNumberViewModel$tigerCardListener$1 tigerCardListener = new TicketRedeemTicketNumberViewModel$tigerCardListener$1(this);
    private final TigerCardsManagerService tigerCardsManagerService;
    /* access modifiers changed from: private */
    public TigerTicketGetProductUseCase tigerTicketGetProductUseCase;
    private final LiveData<ViewState> viewState;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$WhenMappings */
    /* compiled from: TicketRedeemTicketNumberViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardValidationFailError.values().length];
            iArr[CardValidationFailError.TIGERTICKET_ERROR_403.ordinal()] = 1;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_404.ordinal()] = 2;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_410.ordinal()] = 3;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_429.ordinal()] = 4;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_GENERAL.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public TicketRedeemTicketNumberViewModel(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService2, TigerTicketGetProductUseCase tigerTicketGetProductUseCase2) {
        super(buttonService);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(tigerCardsManagerService2, "tigerCardsManagerService");
        Intrinsics.checkNotNullParameter(tigerTicketGetProductUseCase2, "tigerTicketGetProductUseCase");
        this.tigerCardsManagerService = tigerCardsManagerService2;
        this.tigerTicketGetProductUseCase = tigerTicketGetProductUseCase2;
        MutableLiveData<ViewState> mutableLiveData = new MutableLiveData<>(new ViewState.CurrentTicket((TigerTicketStepDomain) null));
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
    }

    public final LiveData<ViewState> getViewState() {
        return this.viewState;
    }

    public final void registerListeners() {
        this.tigerCardsManagerService.registerListener(this.tigerCardListener);
    }

    public final void unregisterListeners() {
        this.tigerCardsManagerService.unregisterListener(this.tigerCardListener);
    }

    public final void getTicketProduct(String str) {
        Intrinsics.checkNotNullParameter(str, "code");
        this.ticketCode = str;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TicketRedeemTicketNumberViewModel$getTicketProduct$1(this, str, (Continuation<? super TicketRedeemTicketNumberViewModel$getTicketProduct$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void ticketProductFailureHandler(Failure failure) {
        ViewState viewState2;
        String str;
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("ticketProductFailureHandler " + failure, new Object[0]);
        TicketFailure failureToTicketFailure = this.tigerCardsManagerService.failureToTicketFailure(failure);
        int i = WhenMappings.$EnumSwitchMapping$0[failureToTicketFailure.getCardFailError().ordinal()];
        if (i == 1) {
            viewState2 = ViewState.ErrorDialog403.INSTANCE;
        } else if (i == 2) {
            viewState2 = ViewState.ErrorDialog404.INSTANCE;
        } else if (i == 3) {
            viewState2 = ViewState.ErrorDialog410.INSTANCE;
        } else if (i == 4) {
            TigerTicketFail failReason = failureToTicketFailure.getFailReason();
            if (failReason == null || (str = failReason.getMessage()) == null) {
                str = "";
            }
            viewState2 = new ViewState.ErrorDialog429(str);
        } else if (i != 5) {
            viewState2 = null;
        } else {
            viewState2 = ViewState.ErrorDialogGeneral.INSTANCE;
        }
        if (viewState2 != null) {
            this._viewState.postValue(viewState2);
        }
    }

    /* access modifiers changed from: private */
    public final void ticketProductSuccessHandler(TigerTicketAssignedProduct tigerTicketAssignedProduct) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("ticketProductSuccessHandler " + tigerTicketAssignedProduct, new Object[0]);
        if (tigerTicketAssignedProduct != null) {
            this._viewState.postValue(new ViewState.CurrentTicket(new TigerTicketStepDomain(TigerTicketStepType.TIGER_TICKET_STEP_INPUT_PIN, new TigerTicketDomain(this.ticketCode, "", "", ""), tigerTicketAssignedProduct)));
            return;
        }
        this._viewState.postValue(new ViewState.InvalidTicketCode((Failure) null));
    }

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "", "()V", "CurrentTicket", "ErrorDialog403", "ErrorDialog404", "ErrorDialog410", "ErrorDialog429", "ErrorDialogGeneral", "InvalidTicketCode", "TicketInserted", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog403;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog404;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog410;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog429;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialogGeneral;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$TicketInserted;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$CurrentTicket;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$InvalidTicketCode;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState */
    /* compiled from: TicketRedeemTicketNumberViewModel.kt */
    public static abstract class ViewState {
        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog403;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog403 */
        /* compiled from: TicketRedeemTicketNumberViewModel.kt */
        public static final class ErrorDialog403 extends ViewState {
            public static final ErrorDialog403 INSTANCE = new ErrorDialog403();

            private ErrorDialog403() {
                super((DefaultConstructorMarker) null);
            }
        }

        private ViewState() {
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog404;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog404 */
        /* compiled from: TicketRedeemTicketNumberViewModel.kt */
        public static final class ErrorDialog404 extends ViewState {
            public static final ErrorDialog404 INSTANCE = new ErrorDialog404();

            private ErrorDialog404() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog410;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog410 */
        /* compiled from: TicketRedeemTicketNumberViewModel.kt */
        public static final class ErrorDialog410 extends ViewState {
            public static final ErrorDialog410 INSTANCE = new ErrorDialog410();

            private ErrorDialog410() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog429;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "retryAfter", "", "(Ljava/lang/String;)V", "getRetryAfter", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog429 */
        /* compiled from: TicketRedeemTicketNumberViewModel.kt */
        public static final class ErrorDialog429 extends ViewState {
            private final String retryAfter;

            public ErrorDialog429() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ErrorDialog429 copy$default(ErrorDialog429 errorDialog429, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = errorDialog429.retryAfter;
                }
                return errorDialog429.copy(str);
            }

            public final String component1() {
                return this.retryAfter;
            }

            public final ErrorDialog429 copy(String str) {
                return new ErrorDialog429(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ErrorDialog429) && Intrinsics.areEqual((Object) this.retryAfter, (Object) ((ErrorDialog429) obj).retryAfter);
            }

            public int hashCode() {
                String str = this.retryAfter;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ErrorDialog429(retryAfter=" + this.retryAfter + ')';
            }

            public ErrorDialog429(String str) {
                super((DefaultConstructorMarker) null);
                this.retryAfter = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ErrorDialog429(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getRetryAfter() {
                return this.retryAfter;
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$ErrorDialogGeneral;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$ErrorDialogGeneral */
        /* compiled from: TicketRedeemTicketNumberViewModel.kt */
        public static final class ErrorDialogGeneral extends ViewState {
            public static final ErrorDialogGeneral INSTANCE = new ErrorDialogGeneral();

            private ErrorDialogGeneral() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$TicketInserted;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "ticketNr", "", "(Ljava/lang/String;)V", "getTicketNr", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$TicketInserted */
        /* compiled from: TicketRedeemTicketNumberViewModel.kt */
        public static final class TicketInserted extends ViewState {
            private final String ticketNr;

            public static /* synthetic */ TicketInserted copy$default(TicketInserted ticketInserted, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = ticketInserted.ticketNr;
                }
                return ticketInserted.copy(str);
            }

            public final String component1() {
                return this.ticketNr;
            }

            public final TicketInserted copy(String str) {
                Intrinsics.checkNotNullParameter(str, "ticketNr");
                return new TicketInserted(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof TicketInserted) && Intrinsics.areEqual((Object) this.ticketNr, (Object) ((TicketInserted) obj).ticketNr);
            }

            public int hashCode() {
                return this.ticketNr.hashCode();
            }

            public String toString() {
                return "TicketInserted(ticketNr=" + this.ticketNr + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TicketInserted(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "ticketNr");
                this.ticketNr = str;
            }

            public final String getTicketNr() {
                return this.ticketNr;
            }
        }

        @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$CurrentTicket;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "ticketStepDomain", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "(Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;)V", "getTicketStepDomain", "()Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$CurrentTicket */
        /* compiled from: TicketRedeemTicketNumberViewModel.kt */
        public static final class CurrentTicket extends ViewState {
            private final TigerTicketStepDomain ticketStepDomain;

            public static /* synthetic */ CurrentTicket copy$default(CurrentTicket currentTicket, TigerTicketStepDomain tigerTicketStepDomain, int i, Object obj) {
                if ((i & 1) != 0) {
                    tigerTicketStepDomain = currentTicket.ticketStepDomain;
                }
                return currentTicket.copy(tigerTicketStepDomain);
            }

            public final TigerTicketStepDomain component1() {
                return this.ticketStepDomain;
            }

            public final CurrentTicket copy(TigerTicketStepDomain tigerTicketStepDomain) {
                return new CurrentTicket(tigerTicketStepDomain);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof CurrentTicket) && Intrinsics.areEqual((Object) this.ticketStepDomain, (Object) ((CurrentTicket) obj).ticketStepDomain);
            }

            public int hashCode() {
                TigerTicketStepDomain tigerTicketStepDomain = this.ticketStepDomain;
                if (tigerTicketStepDomain == null) {
                    return 0;
                }
                return tigerTicketStepDomain.hashCode();
            }

            public String toString() {
                return "CurrentTicket(ticketStepDomain=" + this.ticketStepDomain + ')';
            }

            public CurrentTicket(TigerTicketStepDomain tigerTicketStepDomain) {
                super((DefaultConstructorMarker) null);
                this.ticketStepDomain = tigerTicketStepDomain;
            }

            public final TigerTicketStepDomain getTicketStepDomain() {
                return this.ticketStepDomain;
            }
        }

        @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState$InvalidTicketCode;", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel$ViewState;", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "(Lmedia/tiger/tigerbox/infrastructure/exception/Failure;)V", "getFailure", "()Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$InvalidTicketCode */
        /* compiled from: TicketRedeemTicketNumberViewModel.kt */
        public static final class InvalidTicketCode extends ViewState {
            private final Failure failure;

            public static /* synthetic */ InvalidTicketCode copy$default(InvalidTicketCode invalidTicketCode, Failure failure2, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure2 = invalidTicketCode.failure;
                }
                return invalidTicketCode.copy(failure2);
            }

            public final Failure component1() {
                return this.failure;
            }

            public final InvalidTicketCode copy(Failure failure2) {
                return new InvalidTicketCode(failure2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof InvalidTicketCode) && Intrinsics.areEqual((Object) this.failure, (Object) ((InvalidTicketCode) obj).failure);
            }

            public int hashCode() {
                Failure failure2 = this.failure;
                if (failure2 == null) {
                    return 0;
                }
                return failure2.hashCode();
            }

            public String toString() {
                return "InvalidTicketCode(failure=" + this.failure + ')';
            }

            public InvalidTicketCode(Failure failure2) {
                super((DefaultConstructorMarker) null);
                this.failure = failure2;
            }

            public final Failure getFailure() {
                return this.failure;
            }
        }
    }
}
