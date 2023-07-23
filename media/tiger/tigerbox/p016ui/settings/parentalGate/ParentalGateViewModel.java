package media.tiger.tigerbox.p016ui.settings.parentalGate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f*\u0001$\b\u0007\u0018\u0000 52\u00020\u0001:\u0003567B\u001f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020\u000fH\u0002J\u000e\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u001dJ\u000e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u000fJ\b\u00100\u001a\u00020)H\u0002J\u0006\u00101\u001a\u00020)J\b\u00102\u001a\u00020)H\u0002J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u000fH\u0002R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000f0\u000f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00168F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0004¢\u0006\u0004\n\u0002\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018¨\u00068"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lkotlinx/coroutines/CoroutineScope;)V", "(Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;)V", "_accountHasRandomPin", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_accountPin", "", "_navigationState", "Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$NavigationState;", "_viewState", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState;", "accountHasRandomPin", "Landroidx/lifecycle/LiveData;", "getAccountHasRandomPin", "()Landroidx/lifecycle/LiveData;", "accountPin", "getAccountPin", "charStack", "Ljava/util/Stack;", "", "generatedRandomPin", "navigationState", "getNavigationState", "pinAttempts", "", "profilesUpdateListener", "media/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$profilesUpdateListener$1", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$profilesUpdateListener$1;", "viewState", "getViewState", "backSpacePressed", "", "clearPin", "getDefaultText", "numberPressed", "character", "prepare", "randomPin", "preparePinUse", "removeObservers", "update", "validatePin", "pin", "Companion", "NavigationState", "ViewState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel */
/* compiled from: ParentalGateViewModel.kt */
public final class ParentalGateViewModel extends DialogViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_TEXT_STATE = "_ _ _";
    public static final int MAX_RANDOM_PIN_LIMIT = 3;
    private MutableLiveData<Boolean> _accountHasRandomPin;
    private MutableLiveData<String> _accountPin;
    private final SingleLiveEvent<NavigationState> _navigationState;
    private final MutableLiveData<ViewState> _viewState;
    /* access modifiers changed from: private */
    public final TigerBoxAccountRepository accountRepository;
    private final Stack<Character> charStack;
    private CoroutineScope coroutineScope;
    private String generatedRandomPin;
    private final LiveData<NavigationState> navigationState;
    private int pinAttempts;
    private final ParentalGateViewModel$profilesUpdateListener$1 profilesUpdateListener;
    private final LiveData<ViewState> viewState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ParentalGateViewModel(ButtonService buttonService, TigerBoxAccountRepository tigerBoxAccountRepository) {
        super(buttonService);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "accountRepository");
        this.accountRepository = tigerBoxAccountRepository;
        this.coroutineScope = ViewModelKt.getViewModelScope(this);
        MutableLiveData<ViewState> mutableLiveData = new MutableLiveData<>(new ViewState.UpdatedPin(DEFAULT_TEXT_STATE));
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
        this._accountPin = new MutableLiveData<>("");
        this._accountHasRandomPin = new MutableLiveData<>(false);
        this.generatedRandomPin = "";
        this.profilesUpdateListener = new ParentalGateViewModel$profilesUpdateListener$1(this);
        SingleLiveEvent<NavigationState> singleLiveEvent = new SingleLiveEvent<>();
        this._navigationState = singleLiveEvent;
        this.navigationState = singleLiveEvent;
        this.charStack = new Stack<>();
    }

    public final LiveData<ViewState> getViewState() {
        return this.viewState;
    }

    public final LiveData<String> getAccountPin() {
        return this._accountPin;
    }

    public final LiveData<Boolean> getAccountHasRandomPin() {
        return this._accountHasRandomPin;
    }

    /* access modifiers changed from: private */
    public final void preparePinUse() {
        clearPin();
        String pin = this.accountRepository.getTigerBoxUser().getPin();
        this._accountPin.setValue(pin == null ? this.generatedRandomPin : pin);
        this._accountHasRandomPin.setValue(Boolean.valueOf(pin == null));
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("preparePinUse pin: " + this._accountPin.getValue() + " _accountHasRandomPin: " + this._accountHasRandomPin.getValue(), new Object[0]);
    }

    public final void removeObservers() {
        this.accountRepository.unregisterProfileChangeListener(this.profilesUpdateListener);
    }

    public final void prepare(String str) {
        Intrinsics.checkNotNullParameter(str, "randomPin");
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("PREPARE WITH RANDOM PIN " + str, new Object[0]);
        this.generatedRandomPin = str;
        preparePinUse();
        this._viewState.setValue(new ViewState.UpdatedPin(getDefaultText()));
        this.accountRepository.registerProfileChangeListener(this.profilesUpdateListener);
        this.accountRepository.requestUpdatedProfilesInfoFromServer(ParentalGateViewModel$prepare$1.INSTANCE);
    }

    public final LiveData<NavigationState> getNavigationState() {
        return this.navigationState;
    }

    private final String getDefaultText() {
        String value = this._accountPin.getValue();
        int length = value != null ? value.length() : 3;
        int i = 1;
        String str = "";
        if (1 <= length) {
            while (true) {
                str = str + '_';
                if (i != length) {
                    str = str + ' ';
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return str;
    }

    private final void update() {
        String defaultText = getDefaultText();
        StringBuilder sb = new StringBuilder();
        String str = defaultText;
        for (Character ch : this.charStack) {
            Character ch2 = Intrinsics.areEqual((Object) this._accountHasRandomPin.getValue(), (Object) true) ? ch : '*';
            Intrinsics.checkNotNullExpressionValue(ch2, "if (_accountHasRandomPin…true) { it } else { '*' }");
            str = StringsKt.replaceFirst$default(str, '_', ch2.charValue(), false, 4, (Object) null);
            Intrinsics.checkNotNullExpressionValue(ch, "it");
            sb.append(ch.charValue());
        }
        this._viewState.postValue(new ViewState.UpdatedPin(str));
        int size = this.charStack.size();
        String value = this._accountPin.getValue();
        if (size == (value != null ? value.length() : 3)) {
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
            validatePin(sb2);
        }
    }

    private final void validatePin(String str) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("VALIDATE PIN " + str + " vs " + getAccountPin().getValue(), new Object[0]);
        if (Intrinsics.areEqual((Object) str, (Object) getAccountPin().getValue())) {
            this._viewState.setValue(new ViewState.ValidatedPin(str));
            return;
        }
        clearPin();
        int i = this.pinAttempts + 1;
        this.pinAttempts = i;
        this._viewState.setValue(new ViewState.InvalidPin(i));
    }

    private final void clearPin() {
        this.charStack.clear();
        update();
    }

    public final void numberPressed(char c) {
        int size = this.charStack.size();
        String value = this._accountPin.getValue();
        if (size < (value != null ? value.length() : 3)) {
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

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState;", "", "()V", "InvalidPin", "UpdatedPin", "ValidatedPin", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState$UpdatedPin;", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState$InvalidPin;", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState$ValidatedPin;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel$ViewState */
    /* compiled from: ParentalGateViewModel.kt */
    public static abstract class ViewState {
        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState$UpdatedPin;", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState;", "pin", "", "(Ljava/lang/String;)V", "getPin", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel$ViewState$UpdatedPin */
        /* compiled from: ParentalGateViewModel.kt */
        public static final class UpdatedPin extends ViewState {
            private final String pin;

            public static /* synthetic */ UpdatedPin copy$default(UpdatedPin updatedPin, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = updatedPin.pin;
                }
                return updatedPin.copy(str);
            }

            public final String component1() {
                return this.pin;
            }

            public final UpdatedPin copy(String str) {
                Intrinsics.checkNotNullParameter(str, "pin");
                return new UpdatedPin(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof UpdatedPin) && Intrinsics.areEqual((Object) this.pin, (Object) ((UpdatedPin) obj).pin);
            }

            public int hashCode() {
                return this.pin.hashCode();
            }

            public String toString() {
                return "UpdatedPin(pin=" + this.pin + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UpdatedPin(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "pin");
                this.pin = str;
            }

            public final String getPin() {
                return this.pin;
            }
        }

        private ViewState() {
        }

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState$InvalidPin;", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState;", "attempts", "", "(I)V", "getAttempts", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel$ViewState$InvalidPin */
        /* compiled from: ParentalGateViewModel.kt */
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

        @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState$ValidatedPin;", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$ViewState;", "pin", "", "(Ljava/lang/String;)V", "getPin", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel$ViewState$ValidatedPin */
        /* compiled from: ParentalGateViewModel.kt */
        public static final class ValidatedPin extends ViewState {
            private final String pin;

            public static /* synthetic */ ValidatedPin copy$default(ValidatedPin validatedPin, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = validatedPin.pin;
                }
                return validatedPin.copy(str);
            }

            public final String component1() {
                return this.pin;
            }

            public final ValidatedPin copy(String str) {
                Intrinsics.checkNotNullParameter(str, "pin");
                return new ValidatedPin(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ValidatedPin) && Intrinsics.areEqual((Object) this.pin, (Object) ((ValidatedPin) obj).pin);
            }

            public int hashCode() {
                return this.pin.hashCode();
            }

            public String toString() {
                return "ValidatedPin(pin=" + this.pin + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ValidatedPin(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "pin");
                this.pin = str;
            }

            public final String getPin() {
                return this.pin;
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$NavigationState;", "", "()V", "Cancel", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$NavigationState$Cancel;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel$NavigationState */
    /* compiled from: ParentalGateViewModel.kt */
    public static abstract class NavigationState {
        public /* synthetic */ NavigationState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$NavigationState$Cancel;", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$NavigationState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel$NavigationState$Cancel */
        /* compiled from: ParentalGateViewModel.kt */
        public static final class Cancel extends NavigationState {
            public static final Cancel INSTANCE = new Cancel();

            private Cancel() {
                super((DefaultConstructorMarker) null);
            }
        }

        private NavigationState() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ParentalGateViewModel(ButtonService buttonService, TigerBoxAccountRepository tigerBoxAccountRepository, CoroutineScope coroutineScope2) {
        this(buttonService, tigerBoxAccountRepository);
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        this.coroutineScope = coroutineScope2;
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel$Companion;", "", "()V", "DEFAULT_TEXT_STATE", "", "MAX_RANDOM_PIN_LIMIT", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel$Companion */
    /* compiled from: ParentalGateViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
