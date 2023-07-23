package media.tiger.tigerbox.p016ui.main.card;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.model.domain.PinInfo;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.CardValidationFailError;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;
import media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase;
import media.tiger.tigerbox.utils.DateUtilsKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 72\u00020\u0001:\u0003789B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020)H\u0002J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0015J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020)H\u0002J\u0018\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u0017H\u0002R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001d¨\u0006:"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "tigerCardsManagerService", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;", "tigerCardPinCheckUseCase", "Lmedia/tiger/tigerbox/usecase/TigerTicketValidatePinUseCase;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;Lmedia/tiger/tigerbox/usecase/TigerTicketValidatePinUseCase;Lkotlinx/coroutines/CoroutineScope;)V", "tigerTicketValidatePinUseCase", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;Lmedia/tiger/tigerbox/usecase/TigerTicketValidatePinUseCase;)V", "_navigationState", "Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$NavigationState;", "_viewState", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "charStack", "Ljava/util/Stack;", "", "currentPin", "", "getCurrentPin", "()Ljava/lang/String;", "navigationState", "Landroidx/lifecycle/LiveData;", "getNavigationState", "()Landroidx/lifecycle/LiveData;", "ticketCode", "getTicketCode", "tigerTicketStepDomain", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "getTigerTicketStepDomain", "()Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "setTigerTicketStepDomain", "(Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;)V", "viewState", "getViewState", "backSpacePressed", "", "clearPin", "numberPressed", "character", "pinSuccessHandler", "info", "Lmedia/tiger/tigerbox/model/domain/PinInfo;", "pinValidationFailureHandler", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "update", "validatePin", "code", "pin", "Companion", "NavigationState", "ViewState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel */
/* compiled from: TigerTicketInputPinViewModel.kt */
public final class TigerTicketInputPinViewModel extends DialogViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_TEXT_STATE = "_ _ _ _";
    public static final String END_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String END_DATE_OUTPUT_FORMAT = "dd.MM.yyyy";
    private static final int MAX_LIMIT = 4;
    /* access modifiers changed from: private */
    public static final Map<String, String> UNIT_TRANSLATION = MapsKt.mapOf(TuplesKt.m475to("day", "Tages"), TuplesKt.m475to("week", "Wochen"), TuplesKt.m475to("month", "Monats"), TuplesKt.m475to("year", "Jahres"));
    private final SingleLiveEvent<NavigationState> _navigationState;
    private final MutableLiveData<ViewState> _viewState;
    private final Stack<Character> charStack;
    private CoroutineScope coroutineScope;
    private final LiveData<NavigationState> navigationState;
    private final TigerCardsManagerService tigerCardsManagerService;
    private TigerTicketStepDomain tigerTicketStepDomain;
    /* access modifiers changed from: private */
    public final TigerTicketValidatePinUseCase tigerTicketValidatePinUseCase;
    private final LiveData<ViewState> viewState;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$WhenMappings */
    /* compiled from: TigerTicketInputPinViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardValidationFailError.values().length];
            iArr[CardValidationFailError.TIGERTICKET_ERROR_400.ordinal()] = 1;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_403.ordinal()] = 2;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_404.ordinal()] = 3;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_410.ordinal()] = 4;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_429.ordinal()] = 5;
            iArr[CardValidationFailError.TIGERTICKET_ERROR_GENERAL.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public TigerTicketInputPinViewModel(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService2, TigerTicketValidatePinUseCase tigerTicketValidatePinUseCase2) {
        super(buttonService);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(tigerCardsManagerService2, "tigerCardsManagerService");
        Intrinsics.checkNotNullParameter(tigerTicketValidatePinUseCase2, "tigerTicketValidatePinUseCase");
        this.tigerCardsManagerService = tigerCardsManagerService2;
        this.tigerTicketValidatePinUseCase = tigerTicketValidatePinUseCase2;
        this.coroutineScope = ViewModelKt.getViewModelScope(this);
        MutableLiveData<ViewState> mutableLiveData = new MutableLiveData<>(new ViewState.CurrentPin(DEFAULT_TEXT_STATE));
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
        SingleLiveEvent<NavigationState> singleLiveEvent = new SingleLiveEvent<>();
        this._navigationState = singleLiveEvent;
        this.navigationState = singleLiveEvent;
        this.charStack = new Stack<>();
    }

    public final LiveData<ViewState> getViewState() {
        return this.viewState;
    }

    public final String getCurrentPin() {
        String str;
        ViewState value = this._viewState.getValue();
        ViewState.CurrentPin currentPin = value instanceof ViewState.CurrentPin ? (ViewState.CurrentPin) value : null;
        if (currentPin == null || (str = currentPin.getPin()) == null) {
            str = "";
        }
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!CharsKt.isWhitespace(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.getTicket()).getCouponCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getTicketCode() {
        /*
            r1 = this;
            media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain r0 = r1.tigerTicketStepDomain
            if (r0 == 0) goto L_0x0010
            media.tiger.tigerbox.services.interfaces.TigerTicketDomain r0 = r0.getTicket()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getCouponCode()
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            java.lang.String r0 = ""
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.getTicketCode():java.lang.String");
    }

    public final LiveData<NavigationState> getNavigationState() {
        return this.navigationState;
    }

    public final TigerTicketStepDomain getTigerTicketStepDomain() {
        return this.tigerTicketStepDomain;
    }

    public final void setTigerTicketStepDomain(TigerTicketStepDomain tigerTicketStepDomain2) {
        this.tigerTicketStepDomain = tigerTicketStepDomain2;
    }

    private final void update() {
        StringBuilder sb = new StringBuilder();
        String str = DEFAULT_TEXT_STATE;
        for (Character ch : this.charStack) {
            Intrinsics.checkNotNullExpressionValue(ch, "it");
            str = StringsKt.replaceFirst$default(str, '_', ch.charValue(), false, 4, (Object) null);
            sb.append(ch.charValue());
        }
        this._viewState.setValue(new ViewState.CurrentPin(str));
        if (this.charStack.size() == 4) {
            String ticketCode = getTicketCode();
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
            validatePin(ticketCode, sb2);
        }
    }

    private final void validatePin(String str, String str2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TigerTicketInputPinViewModel$validatePin$1(this, str, str2, (Continuation<? super TigerTicketInputPinViewModel$validatePin$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b9, code lost:
        r4 = r4.getMessage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void pinValidationFailureHandler(media.tiger.tigerbox.infrastructure.exception.Failure r4) {
        /*
            r3 = this;
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "pinValidationFailureHandler: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.mo50221i(r1, r2)
            r3.clearPin()
            media.tiger.tigerbox.services.interfaces.TigerCardsManagerService r0 = r3.tigerCardsManagerService
            media.tiger.tigerbox.services.interfaces.TicketFailure r4 = r0.failureToTicketFailure(r4)
            media.tiger.tigerbox.services.interfaces.CardValidationFailError r0 = r4.getCardFailError()
            int[] r1 = media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            java.lang.String r1 = ""
            switch(r0) {
                case 1: goto L_0x00b3;
                case 2: goto L_0x009d;
                case 3: goto L_0x0087;
                case 4: goto L_0x0071;
                case 5: goto L_0x005a;
                case 6: goto L_0x0043;
                default: goto L_0x0033;
            }
        L_0x0033:
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialogGeneral r0 = new media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialogGeneral
            media.tiger.tigerbox.model.domain.TigerTicketFail r4 = r4.getFailReason()
            if (r4 == 0) goto L_0x00da
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto L_0x00d9
            goto L_0x00da
        L_0x0043:
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialogGeneral r0 = new media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialogGeneral
            media.tiger.tigerbox.model.domain.TigerTicketFail r4 = r4.getFailReason()
            if (r4 == 0) goto L_0x0053
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r1 = r4
        L_0x0053:
            r0.<init>(r1)
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState r0 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState) r0
            goto L_0x00df
        L_0x005a:
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog429 r0 = new media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog429
            media.tiger.tigerbox.model.domain.TigerTicketFail r4 = r4.getFailReason()
            if (r4 == 0) goto L_0x006a
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r1 = r4
        L_0x006a:
            r0.<init>(r1)
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState r0 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState) r0
            goto L_0x00df
        L_0x0071:
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog410 r0 = new media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog410
            media.tiger.tigerbox.model.domain.TigerTicketFail r4 = r4.getFailReason()
            if (r4 == 0) goto L_0x0081
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r1 = r4
        L_0x0081:
            r0.<init>(r1)
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState r0 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState) r0
            goto L_0x00df
        L_0x0087:
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog404 r0 = new media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog404
            media.tiger.tigerbox.model.domain.TigerTicketFail r4 = r4.getFailReason()
            if (r4 == 0) goto L_0x0097
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r1 = r4
        L_0x0097:
            r0.<init>(r1)
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState r0 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState) r0
            goto L_0x00df
        L_0x009d:
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog403 r0 = new media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog403
            media.tiger.tigerbox.model.domain.TigerTicketFail r4 = r4.getFailReason()
            if (r4 == 0) goto L_0x00ad
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r1 = r4
        L_0x00ad:
            r0.<init>(r1)
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState r0 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState) r0
            goto L_0x00df
        L_0x00b3:
            media.tiger.tigerbox.model.domain.TigerTicketFail r4 = r4.getFailReason()
            if (r4 == 0) goto L_0x00c4
            java.lang.String r4 = r4.getMessage()
            if (r4 == 0) goto L_0x00c4
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)
            goto L_0x00c5
        L_0x00c4:
            r4 = 0
        L_0x00c5:
            if (r4 == 0) goto L_0x00d3
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$InvalidPin r0 = new media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$InvalidPin
            int r4 = r4.intValue()
            r0.<init>(r4)
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState r0 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState) r0
            goto L_0x00df
        L_0x00d3:
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ConnectionFailure r4 = media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ConnectionFailure.INSTANCE
            r0 = r4
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState r0 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState) r0
            goto L_0x00df
        L_0x00d9:
            r1 = r4
        L_0x00da:
            r0.<init>(r1)
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState r0 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState) r0
        L_0x00df:
            androidx.lifecycle.MutableLiveData<media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState> r4 = r3._viewState
            r4.postValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.pinValidationFailureHandler(media.tiger.tigerbox.infrastructure.exception.Failure):void");
    }

    /* access modifiers changed from: private */
    public final void pinSuccessHandler(PinInfo pinInfo) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("pinSuccessHandler: " + pinInfo, new Object[0]);
        this.charStack.clear();
        if (pinInfo.isSuccess()) {
            TigerTicketStepDomain tigerTicketStepDomain2 = this.tigerTicketStepDomain;
            if (tigerTicketStepDomain2 != null) {
                String valueOf = String.valueOf(tigerTicketStepDomain2.getProduct().getLinkedProduct().getPeriod().getQuantity());
                String str = UNIT_TRANSLATION.get(tigerTicketStepDomain2.getProduct().getLinkedProduct().getPeriod().getUnit());
                if (str == null) {
                    str = tigerTicketStepDomain2.getProduct().getLinkedProduct().getPeriod().getUnit();
                }
                String format = new SimpleDateFormat(END_DATE_OUTPUT_FORMAT, Locale.getDefault()).format(DateUtilsKt.toDate(tigerTicketStepDomain2.getProduct().getNewEndDate(), "yyyy-MM-dd'T'HH:mm:ss"));
                SingleLiveEvent<NavigationState> singleLiveEvent = this._navigationState;
                Intrinsics.checkNotNullExpressionValue(format, "endDateString");
                singleLiveEvent.postValue(new NavigationState.Validated(valueOf, str, format));
                return;
            }
            return;
        }
        clearPin();
        int code = pinInfo.getCode();
        if (code == 2) {
            this._viewState.postValue(new ViewState.ErrorDialog429(String.valueOf(pinInfo.getAttempts())));
        } else if (code == 3) {
            this._viewState.postValue(new ViewState.ErrorDialog429("29"));
        } else if (code == 4) {
            this._viewState.postValue(new ViewState.InvalidPin(pinInfo.getAttempts()));
        } else if (code != 7) {
            this._viewState.postValue(new ViewState.ErrorDialogGeneral(""));
        } else {
            this._viewState.postValue(new ViewState.ErrorDialog403((String) null, 1, (DefaultConstructorMarker) null));
        }
    }

    private final void clearPin() {
        this.charStack.clear();
        update();
    }

    public final void numberPressed(char c) {
        if (this.charStack.size() < 4) {
            this.charStack.push(Character.valueOf(c));
            update();
        }
    }

    public final void backSpacePressed() {
        if (!this.charStack.isEmpty()) {
            this.charStack.pop();
            update();
        }
    }

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "", "()V", "ConnectionFailure", "CurrentPin", "ErrorDialog403", "ErrorDialog404", "ErrorDialog410", "ErrorDialog429", "ErrorDialogGeneral", "InvalidPin", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ConnectionFailure;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialog403;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialog404;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialog410;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialog429;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialogGeneral;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$CurrentPin;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$InvalidPin;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState */
    /* compiled from: TigerTicketInputPinViewModel.kt */
    public static abstract class ViewState {
        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ConnectionFailure;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ConnectionFailure */
        /* compiled from: TigerTicketInputPinViewModel.kt */
        public static final class ConnectionFailure extends ViewState {
            public static final ConnectionFailure INSTANCE = new ConnectionFailure();

            private ConnectionFailure() {
                super((DefaultConstructorMarker) null);
            }
        }

        private ViewState() {
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialog403;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "retryAfter", "", "(Ljava/lang/String;)V", "getRetryAfter", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog403 */
        /* compiled from: TigerTicketInputPinViewModel.kt */
        public static final class ErrorDialog403 extends ViewState {
            private final String retryAfter;

            public ErrorDialog403() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ErrorDialog403 copy$default(ErrorDialog403 errorDialog403, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = errorDialog403.retryAfter;
                }
                return errorDialog403.copy(str);
            }

            public final String component1() {
                return this.retryAfter;
            }

            public final ErrorDialog403 copy(String str) {
                return new ErrorDialog403(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ErrorDialog403) && Intrinsics.areEqual((Object) this.retryAfter, (Object) ((ErrorDialog403) obj).retryAfter);
            }

            public int hashCode() {
                String str = this.retryAfter;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ErrorDialog403(retryAfter=" + this.retryAfter + ')';
            }

            public ErrorDialog403(String str) {
                super((DefaultConstructorMarker) null);
                this.retryAfter = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ErrorDialog403(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getRetryAfter() {
                return this.retryAfter;
            }
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialog404;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "retryAfter", "", "(Ljava/lang/String;)V", "getRetryAfter", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog404 */
        /* compiled from: TigerTicketInputPinViewModel.kt */
        public static final class ErrorDialog404 extends ViewState {
            private final String retryAfter;

            public ErrorDialog404() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ErrorDialog404 copy$default(ErrorDialog404 errorDialog404, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = errorDialog404.retryAfter;
                }
                return errorDialog404.copy(str);
            }

            public final String component1() {
                return this.retryAfter;
            }

            public final ErrorDialog404 copy(String str) {
                return new ErrorDialog404(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ErrorDialog404) && Intrinsics.areEqual((Object) this.retryAfter, (Object) ((ErrorDialog404) obj).retryAfter);
            }

            public int hashCode() {
                String str = this.retryAfter;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ErrorDialog404(retryAfter=" + this.retryAfter + ')';
            }

            public ErrorDialog404(String str) {
                super((DefaultConstructorMarker) null);
                this.retryAfter = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ErrorDialog404(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getRetryAfter() {
                return this.retryAfter;
            }
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialog410;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "retryAfter", "", "(Ljava/lang/String;)V", "getRetryAfter", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog410 */
        /* compiled from: TigerTicketInputPinViewModel.kt */
        public static final class ErrorDialog410 extends ViewState {
            private final String retryAfter;

            public ErrorDialog410() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ErrorDialog410 copy$default(ErrorDialog410 errorDialog410, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = errorDialog410.retryAfter;
                }
                return errorDialog410.copy(str);
            }

            public final String component1() {
                return this.retryAfter;
            }

            public final ErrorDialog410 copy(String str) {
                return new ErrorDialog410(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ErrorDialog410) && Intrinsics.areEqual((Object) this.retryAfter, (Object) ((ErrorDialog410) obj).retryAfter);
            }

            public int hashCode() {
                String str = this.retryAfter;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ErrorDialog410(retryAfter=" + this.retryAfter + ')';
            }

            public ErrorDialog410(String str) {
                super((DefaultConstructorMarker) null);
                this.retryAfter = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ErrorDialog410(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getRetryAfter() {
                return this.retryAfter;
            }
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialog429;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "retryAfter", "", "(Ljava/lang/String;)V", "getRetryAfter", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog429 */
        /* compiled from: TigerTicketInputPinViewModel.kt */
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

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$ErrorDialogGeneral;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "retryAfter", "", "(Ljava/lang/String;)V", "getRetryAfter", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialogGeneral */
        /* compiled from: TigerTicketInputPinViewModel.kt */
        public static final class ErrorDialogGeneral extends ViewState {
            private final String retryAfter;

            public ErrorDialogGeneral() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ErrorDialogGeneral copy$default(ErrorDialogGeneral errorDialogGeneral, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = errorDialogGeneral.retryAfter;
                }
                return errorDialogGeneral.copy(str);
            }

            public final String component1() {
                return this.retryAfter;
            }

            public final ErrorDialogGeneral copy(String str) {
                return new ErrorDialogGeneral(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ErrorDialogGeneral) && Intrinsics.areEqual((Object) this.retryAfter, (Object) ((ErrorDialogGeneral) obj).retryAfter);
            }

            public int hashCode() {
                String str = this.retryAfter;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ErrorDialogGeneral(retryAfter=" + this.retryAfter + ')';
            }

            public ErrorDialogGeneral(String str) {
                super((DefaultConstructorMarker) null);
                this.retryAfter = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ErrorDialogGeneral(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getRetryAfter() {
                return this.retryAfter;
            }
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$CurrentPin;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "pin", "", "(Ljava/lang/String;)V", "getPin", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$CurrentPin */
        /* compiled from: TigerTicketInputPinViewModel.kt */
        public static final class CurrentPin extends ViewState {
            private final String pin;

            public static /* synthetic */ CurrentPin copy$default(CurrentPin currentPin, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = currentPin.pin;
                }
                return currentPin.copy(str);
            }

            public final String component1() {
                return this.pin;
            }

            public final CurrentPin copy(String str) {
                Intrinsics.checkNotNullParameter(str, "pin");
                return new CurrentPin(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof CurrentPin) && Intrinsics.areEqual((Object) this.pin, (Object) ((CurrentPin) obj).pin);
            }

            public int hashCode() {
                return this.pin.hashCode();
            }

            public String toString() {
                return "CurrentPin(pin=" + this.pin + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CurrentPin(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "pin");
                this.pin = str;
            }

            public final String getPin() {
                return this.pin;
            }
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState$InvalidPin;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$ViewState;", "attempts", "", "(I)V", "getAttempts", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$InvalidPin */
        /* compiled from: TigerTicketInputPinViewModel.kt */
        public static final class InvalidPin extends ViewState {
            private final int attempts;

            public static /* synthetic */ InvalidPin copy$default(InvalidPin invalidPin, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = invalidPin.attempts;
                }
                return invalidPin.copy(i);
            }

            public final int component1() {
                return this.attempts;
            }

            public final InvalidPin copy(int i) {
                return new InvalidPin(i);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof InvalidPin) && this.attempts == ((InvalidPin) obj).attempts;
            }

            public int hashCode() {
                return this.attempts;
            }

            public String toString() {
                return "InvalidPin(attempts=" + this.attempts + ')';
            }

            public InvalidPin(int i) {
                super((DefaultConstructorMarker) null);
                this.attempts = i;
            }

            public final int getAttempts() {
                return this.attempts;
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$NavigationState;", "", "()V", "Cancel", "Validated", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$NavigationState$Cancel;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$NavigationState$Validated;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$NavigationState */
    /* compiled from: TigerTicketInputPinViewModel.kt */
    public static abstract class NavigationState {
        public /* synthetic */ NavigationState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$NavigationState$Cancel;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$NavigationState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$NavigationState$Cancel */
        /* compiled from: TigerTicketInputPinViewModel.kt */
        public static final class Cancel extends NavigationState {
            public static final Cancel INSTANCE = new Cancel();

            private Cancel() {
                super((DefaultConstructorMarker) null);
            }
        }

        private NavigationState() {
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$NavigationState$Validated;", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$NavigationState;", "quantity", "", "timeunit", "newEndDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNewEndDate", "()Ljava/lang/String;", "getQuantity", "getTimeunit", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$NavigationState$Validated */
        /* compiled from: TigerTicketInputPinViewModel.kt */
        public static final class Validated extends NavigationState {
            private final String newEndDate;
            private final String quantity;
            private final String timeunit;

            public static /* synthetic */ Validated copy$default(Validated validated, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = validated.quantity;
                }
                if ((i & 2) != 0) {
                    str2 = validated.timeunit;
                }
                if ((i & 4) != 0) {
                    str3 = validated.newEndDate;
                }
                return validated.copy(str, str2, str3);
            }

            public final String component1() {
                return this.quantity;
            }

            public final String component2() {
                return this.timeunit;
            }

            public final String component3() {
                return this.newEndDate;
            }

            public final Validated copy(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "quantity");
                Intrinsics.checkNotNullParameter(str2, "timeunit");
                Intrinsics.checkNotNullParameter(str3, "newEndDate");
                return new Validated(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Validated)) {
                    return false;
                }
                Validated validated = (Validated) obj;
                return Intrinsics.areEqual((Object) this.quantity, (Object) validated.quantity) && Intrinsics.areEqual((Object) this.timeunit, (Object) validated.timeunit) && Intrinsics.areEqual((Object) this.newEndDate, (Object) validated.newEndDate);
            }

            public int hashCode() {
                return (((this.quantity.hashCode() * 31) + this.timeunit.hashCode()) * 31) + this.newEndDate.hashCode();
            }

            public String toString() {
                return "Validated(quantity=" + this.quantity + ", timeunit=" + this.timeunit + ", newEndDate=" + this.newEndDate + ')';
            }

            public final String getQuantity() {
                return this.quantity;
            }

            public final String getTimeunit() {
                return this.timeunit;
            }

            public final String getNewEndDate() {
                return this.newEndDate;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Validated(String str, String str2, String str3) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "quantity");
                Intrinsics.checkNotNullParameter(str2, "timeunit");
                Intrinsics.checkNotNullParameter(str3, "newEndDate");
                this.quantity = str;
                this.timeunit = str2;
                this.newEndDate = str3;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TigerTicketInputPinViewModel(ButtonService buttonService, TigerCardsManagerService tigerCardsManagerService2, TigerTicketValidatePinUseCase tigerTicketValidatePinUseCase2, CoroutineScope coroutineScope2) {
        this(buttonService, tigerCardsManagerService2, tigerTicketValidatePinUseCase2);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(tigerCardsManagerService2, "tigerCardsManagerService");
        Intrinsics.checkNotNullParameter(tigerTicketValidatePinUseCase2, "tigerCardPinCheckUseCase");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        this.coroutineScope = coroutineScope2;
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel$Companion;", "", "()V", "DEFAULT_TEXT_STATE", "", "END_DATE_FORMAT", "END_DATE_OUTPUT_FORMAT", "MAX_LIMIT", "", "UNIT_TRANSLATION", "", "getUNIT_TRANSLATION", "()Ljava/util/Map;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$Companion */
    /* compiled from: TigerTicketInputPinViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, String> getUNIT_TRANSLATION() {
            return TigerTicketInputPinViewModel.UNIT_TRANSLATION;
        }
    }
}
