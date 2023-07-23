package media.tiger.tigerbox.p016ui.main.card;

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
import media.tiger.tigerbox.model.domain.TigerTicketPurchase;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.CardValidationFailError;
import media.tiger.tigerbox.services.interfaces.TicketFailure;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.usecase.TigerTicketPurchaseUseCase;

@Metadata(mo33736d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "tigerCardsManagerService", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;", "tigerTicketPurchaseUseCase", "Lmedia/tiger/tigerbox/usecase/TigerTicketPurchaseUseCase;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;Lmedia/tiger/tigerbox/usecase/TigerTicketPurchaseUseCase;Lkotlinx/coroutines/CoroutineScope;)V", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;Lmedia/tiger/tigerbox/usecase/TigerTicketPurchaseUseCase;)V", "_viewState", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState;", "viewState", "Landroidx/lifecycle/LiveData;", "getViewState", "()Landroidx/lifecycle/LiveData;", "orderFailureHandler", "", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "orderSuccessHandler", "info", "Lmedia/tiger/tigerbox/model/domain/TigerTicketPurchase;", "purchase", "code", "", "pin", "ViewState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel */
/* compiled from: TigerTicketPurchaseViewModel.kt */
public final class TigerTicketPurchaseViewModel extends DialogViewModel {
    private final MutableLiveData<ViewState> _viewState;
    private CoroutineScope coroutineScope;
    private final TigerCardsManagerService tigerCardsManagerService;
    /* access modifiers changed from: private */
    public final TigerTicketPurchaseUseCase tigerTicketPurchaseUseCase;
    private final LiveData<ViewState> viewState;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$WhenMappings */
    /* compiled from: TigerTicketPurchaseViewModel.kt */
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
    public TigerTicketPurchaseViewModel(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService2, TigerTicketPurchaseUseCase tigerTicketPurchaseUseCase2) {
        super(buttonService);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(tigerCardsManagerService2, "tigerCardsManagerService");
        Intrinsics.checkNotNullParameter(tigerTicketPurchaseUseCase2, "tigerTicketPurchaseUseCase");
        this.tigerCardsManagerService = tigerCardsManagerService2;
        this.tigerTicketPurchaseUseCase = tigerTicketPurchaseUseCase2;
        this.coroutineScope = ViewModelKt.getViewModelScope(this);
        MutableLiveData<ViewState> mutableLiveData = new MutableLiveData<>();
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
    }

    public final LiveData<ViewState> getViewState() {
        return this.viewState;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TigerTicketPurchaseViewModel(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService2, TigerTicketPurchaseUseCase tigerTicketPurchaseUseCase2, CoroutineScope coroutineScope2) {
        this(buttonService, tigerCardsManagerService2, tigerTicketPurchaseUseCase2);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(tigerCardsManagerService2, "tigerCardsManagerService");
        Intrinsics.checkNotNullParameter(tigerTicketPurchaseUseCase2, "tigerTicketPurchaseUseCase");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        this.coroutineScope = coroutineScope2;
    }

    public final void purchase(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "pin");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TigerTicketPurchaseViewModel$purchase$1(this, str, str2, (Continuation<? super TigerTicketPurchaseViewModel$purchase$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void orderFailureHandler(Failure failure) {
        ViewState viewState2;
        String str;
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
    public final void orderSuccessHandler(TigerTicketPurchase tigerTicketPurchase) {
        this._viewState.postValue(ViewState.PremiumAccessReady.INSTANCE);
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState;", "", "()V", "ErrorDialog403", "ErrorDialog404", "ErrorDialog410", "ErrorDialog429", "ErrorDialogGeneral", "PremiumAccessReady", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$PremiumAccessReady;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialog403;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialog404;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialog410;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialog429;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialogGeneral;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$ViewState */
    /* compiled from: TigerTicketPurchaseViewModel.kt */
    public static abstract class ViewState {
        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$PremiumAccessReady;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$ViewState$PremiumAccessReady */
        /* compiled from: TigerTicketPurchaseViewModel.kt */
        public static final class PremiumAccessReady extends ViewState {
            public static final PremiumAccessReady INSTANCE = new PremiumAccessReady();

            private PremiumAccessReady() {
                super((DefaultConstructorMarker) null);
            }
        }

        private ViewState() {
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialog403;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$ViewState$ErrorDialog403 */
        /* compiled from: TigerTicketPurchaseViewModel.kt */
        public static final class ErrorDialog403 extends ViewState {
            public static final ErrorDialog403 INSTANCE = new ErrorDialog403();

            private ErrorDialog403() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialog404;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$ViewState$ErrorDialog404 */
        /* compiled from: TigerTicketPurchaseViewModel.kt */
        public static final class ErrorDialog404 extends ViewState {
            public static final ErrorDialog404 INSTANCE = new ErrorDialog404();

            private ErrorDialog404() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialog410;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$ViewState$ErrorDialog410 */
        /* compiled from: TigerTicketPurchaseViewModel.kt */
        public static final class ErrorDialog410 extends ViewState {
            public static final ErrorDialog410 INSTANCE = new ErrorDialog410();

            private ErrorDialog410() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialog429;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState;", "retryAfter", "", "(Ljava/lang/String;)V", "getRetryAfter", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$ViewState$ErrorDialog429 */
        /* compiled from: TigerTicketPurchaseViewModel.kt */
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

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState$ErrorDialogGeneral;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel$ViewState$ErrorDialogGeneral */
        /* compiled from: TigerTicketPurchaseViewModel.kt */
        public static final class ErrorDialogGeneral extends ViewState {
            public static final ErrorDialogGeneral INSTANCE = new ErrorDialogGeneral();

            private ErrorDialogGeneral() {
                super((DefaultConstructorMarker) null);
            }
        }
    }
}
