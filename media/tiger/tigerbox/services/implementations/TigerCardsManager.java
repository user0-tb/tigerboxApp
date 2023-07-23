package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.model.domain.DownloadReason;
import media.tiger.tigerbox.model.domain.OfflineAvailabilityState;
import media.tiger.tigerbox.model.domain.TigerCard;
import media.tiger.tigerbox.model.domain.TigerTicketFail;
import media.tiger.tigerbox.model.dto.ProductDetailsDto;
import media.tiger.tigerbox.model.dto.TigerCardValidState;
import media.tiger.tigerbox.model.dto.TigerTicketAssignedProduct;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.CardValidationFailError;
import media.tiger.tigerbox.services.interfaces.NfcListener;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.TicketFailure;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.TigerCardsListener;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.services.interfaces.TigerTicketDomain;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepType;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.WildcardReassignStep;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist;
import media.tiger.tigerbox.usecase.GetValidTigerCardParameters;
import media.tiger.tigerbox.usecase.GetValidTigerCardUseCase;
import media.tiger.tigerbox.usecase.TigerTicketGetProductUseCase;
import media.tiger.tigerbox.usecase.WildCardReassignUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import media.tiger.tigerbox.webserver.dto.PlaybackDto;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000Í\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001 \u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020;2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010>\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010?H\u0002J\u0010\u0010@\u001a\u00020;2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010A\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u00020\u001bH\u0002J\u0010\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020\u001bH\u0002J\b\u0010F\u001a\u00020;H\u0002J\u001c\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u00020I2\n\b\u0002\u0010J\u001a\u0004\u0018\u000107H\u0002J\u0010\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020;2\u0006\u0010L\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020\u001eH\u0002J\u0014\u0010Q\u001a\u00020;2\n\u0010R\u001a\u00060Sj\u0002`TH\u0016J\u0010\u0010U\u001a\u00020;2\u0006\u0010E\u001a\u00020#H\u0016J\b\u0010V\u001a\u00020;H\u0016J\u0010\u0010W\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001bH\u0002J\b\u0010X\u001a\u00020;H\u0016J\u0010\u0010Y\u001a\u00020;2\u0006\u0010Z\u001a\u00020&H\u0016J\u0018\u0010[\u001a\u00020;2\u0006\u0010\\\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020\u001bH\u0002J\u0010\u0010]\u001a\u00020;2\u0006\u0010Z\u001a\u00020&H\u0016J\b\u0010^\u001a\u00020_H\u0002R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'X\u000e¢\u0006\u0002\n\u0000R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\u0004\u0018\u00010\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R$\u00101\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001e8V@VX\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/TigerCardsManager;", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;", "Lmedia/tiger/tigerbox/services/interfaces/NfcListener;", "nfcService", "Lmedia/tiger/tigerbox/services/interfaces/NfcService;", "sharedPreferences", "Landroid/content/SharedPreferences;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "availability", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "productAcquisition", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "validStateUseCase", "Lmedia/tiger/tigerbox/usecase/GetValidTigerCardUseCase;", "tigerTicketGetProductUseCase", "Lmedia/tiger/tigerbox/usecase/TigerTicketGetProductUseCase;", "wildcardReassignUseCase", "Lmedia/tiger/tigerbox/usecase/WildCardReassignUseCase;", "(Lmedia/tiger/tigerbox/services/interfaces/NfcService;Landroid/content/SharedPreferences;Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;Lmedia/tiger/tigerbox/usecase/GetValidTigerCardUseCase;Lmedia/tiger/tigerbox/usecase/TigerTicketGetProductUseCase;Lmedia/tiger/tigerbox/usecase/WildCardReassignUseCase;)V", "_localCardDomains", "", "", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "_validatedCard", "_wildcardReassignModeEnabled", "", "audioPlaylistDelegate", "media/tiger/tigerbox/services/implementations/TigerCardsManager$audioPlaylistDelegate$1", "Lmedia/tiger/tigerbox/services/implementations/TigerCardsManager$audioPlaylistDelegate$1;", "insertedNfcCard", "Lmedia/tiger/tigerbox/model/domain/TigerCard;", "listeners", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsListener;", "Lkotlin/collections/ArrayList;", "localCardDomains", "getLocalCardDomains", "()Ljava/util/Map;", "tigerTicketProduct", "Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct;", "validatedCard", "getValidatedCard", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "value", "wildcardReassignModeEnabled", "getWildcardReassignModeEnabled", "()Z", "setWildcardReassignModeEnabled", "(Z)V", "failureToTicketFailure", "Lmedia/tiger/tigerbox/services/interfaces/TicketFailure;", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "handleTicketValidateFailure", "", "handleTicketValidateResponse", "response", "handleValidWildcardReassignResponse", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState;", "handleValidateFailure", "handleValidateResponse", "handleValidatedCard", "aResponse", "notifyAllOnCardInsertedAndValidated", "card", "notifyAllOnCardRemoved", "notifyAllOnCardValidateFailure", "failError", "Lmedia/tiger/tigerbox/services/interfaces/CardValidationFailError;", "ticketFailure", "notifyAllOnTigerTicketStep", "step", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "notifyAllOnWildcardReassignStep", "Lmedia/tiger/tigerbox/services/interfaces/WildcardReassignStep;", "notifyWildcardReassignStepIfNeeded", "onCardException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onCardInserted", "onCardRemoved", "preparedResponse", "reassignInsertedWildcard", "registerListener", "listener", "saveToLocalStorage", "cardId", "unregisterListener", "updateLocalStorage", "Lkotlinx/coroutines/Job;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerCardsManager.kt */
public final class TigerCardsManager implements TigerCardsManagerService, NfcListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String MULTI_TIGERCARD = "MULTI_TIGERCARD";
    public static final String TIGERCARD = "TIGERCARD";
    public static final String TIGERTICKET = "TIGERTICKET";
    private static final int TIGERTICKET_ERROR_400 = 400;
    private static final int TIGERTICKET_ERROR_403 = 403;
    private static final int TIGERTICKET_ERROR_404 = 404;
    private static final int TIGERTICKET_ERROR_410 = 410;
    private static final int TIGERTICKET_ERROR_429 = 429;
    private static final String VALIDATED_CARDS = "LocalValidCardDomains";
    public static final String WILDCARD = "WILDCARD";
    private static final int WILDCARD_ASSIGN_ERROR_STATUS = 800;
    private static final int WILDCARD_NOT_FINISHED_STATUS = 425;
    private static final int WILDCARD_PRIVATE_STATUS = 422;
    private static final String WILDCARD_TRANSCODING_FINISHED = "FINISHED";
    private Map<String, TigerCardDomain> _localCardDomains;
    private TigerCardDomain _validatedCard;
    private boolean _wildcardReassignModeEnabled;
    private AudioPlayerService audioPlayerService;
    private TigerCardsManager$audioPlaylistDelegate$1 audioPlaylistDelegate = new TigerCardsManager$audioPlaylistDelegate$1(this);
    private AvailabilityService availability;
    private GetTigerBoxAccountUseCase getTigerBoxAccountUseCase;
    private TigerCard insertedNfcCard;
    private ArrayList<TigerCardsListener> listeners = new ArrayList<>();
    /* access modifiers changed from: private */
    public NfcService nfcService;
    private ProductAcquisitionService productAcquisition;
    /* access modifiers changed from: private */
    public final SharedPreferences sharedPreferences;
    private TigerTicketGetProductUseCase tigerTicketGetProductUseCase;
    private TigerTicketAssignedProduct tigerTicketProduct;
    private GetValidTigerCardUseCase validStateUseCase;
    private final WifiService wifiService;
    private WildCardReassignUseCase wildcardReassignUseCase;

    public TigerCardsManager(NfcService nfcService2, SharedPreferences sharedPreferences2, WifiService wifiService2, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2, AudioPlayerService audioPlayerService2, AvailabilityService availabilityService, ProductAcquisitionService productAcquisitionService, GetValidTigerCardUseCase getValidTigerCardUseCase, TigerTicketGetProductUseCase tigerTicketGetProductUseCase2, WildCardReassignUseCase wildCardReassignUseCase) {
        Intrinsics.checkNotNullParameter(nfcService2, "nfcService");
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        Intrinsics.checkNotNullParameter(availabilityService, "availability");
        Intrinsics.checkNotNullParameter(productAcquisitionService, "productAcquisition");
        Intrinsics.checkNotNullParameter(getValidTigerCardUseCase, "validStateUseCase");
        Intrinsics.checkNotNullParameter(tigerTicketGetProductUseCase2, "tigerTicketGetProductUseCase");
        Intrinsics.checkNotNullParameter(wildCardReassignUseCase, "wildcardReassignUseCase");
        this.nfcService = nfcService2;
        this.sharedPreferences = sharedPreferences2;
        this.wifiService = wifiService2;
        this.getTigerBoxAccountUseCase = getTigerBoxAccountUseCase2;
        this.audioPlayerService = audioPlayerService2;
        this.availability = availabilityService;
        this.productAcquisition = productAcquisitionService;
        this.validStateUseCase = getValidTigerCardUseCase;
        this.tigerTicketGetProductUseCase = tigerTicketGetProductUseCase2;
        this.wildcardReassignUseCase = wildCardReassignUseCase;
        nfcService2.registerListener(this);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C28961(this, (Continuation<? super C28961>) null), 3, (Object) null);
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.TigerCardsManager$1", mo34424f = "TigerCardsManager.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.services.implementations.TigerCardsManager$1 */
    /* compiled from: TigerCardsManager.kt */
    static final class C28961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TigerCardsManager this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28961(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Map unused = this.this$0.getLocalCardDomains();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public TigerCardDomain getValidatedCard() {
        return this._validatedCard;
    }

    /* access modifiers changed from: private */
    public final Map<String, TigerCardDomain> getLocalCardDomains() {
        Map<String, TigerCardDomain> map;
        if (this._localCardDomains == null) {
            String string = this.sharedPreferences.getString(VALIDATED_CARDS, "");
            if (string != null) {
                if (string.length() > 0) {
                    map = (Map) new Gson().fromJson(string, new TigerCardsManager$localCardDomains$statesType$1().getType());
                    this._localCardDomains = map;
                }
            }
            map = new LinkedHashMap<>();
            this._localCardDomains = map;
        }
        Map<String, TigerCardDomain> map2 = this._localCardDomains;
        Intrinsics.checkNotNull(map2);
        return map2;
    }

    private final void saveToLocalStorage(String str, TigerCardDomain tigerCardDomain) {
        synchronized (getLocalCardDomains()) {
            getLocalCardDomains().put(str, tigerCardDomain);
            updateLocalStorage();
        }
    }

    private final Job updateLocalStorage() {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new TigerCardsManager$updateLocalStorage$1(this, (Continuation<? super TigerCardsManager$updateLocalStorage$1>) null), 3, (Object) null);
    }

    public void onCardInserted(TigerCard tigerCard) {
        Intrinsics.checkNotNullParameter(tigerCard, "card");
        Timber.Forest forest = Timber.Forest;
        forest.mo50214d("Nfc: onCardInserted: [" + tigerCard + ']', new Object[0]);
        this.insertedNfcCard = tigerCard;
        if (Intrinsics.areEqual((Object) true, (Object) this.wifiService.getOfflineMode().getValue())) {
            synchronized (getLocalCardDomains()) {
                TigerCardDomain tigerCardDomain = getLocalCardDomains().get(tigerCard.getId());
                if (tigerCardDomain != null) {
                    handleValidatedCard(tigerCardDomain);
                    return;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        this.validStateUseCase.invoke(new GetValidTigerCardParameters(String.valueOf(this.getTigerBoxAccountUseCase.invoke().getUser().getActiveProfileId()), tigerCard.getSecureCode(), tigerCard.getId()), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new TigerCardsManager$onCardInserted$2(this));
    }

    /* access modifiers changed from: private */
    public final void handleValidateFailure(Failure failure) {
        if (failure instanceof Failure.NetworkConnection) {
            notifyAllOnCardValidateFailure$default(this, CardValidationFailError.NO_WIFI, (TicketFailure) null, 2, (Object) null);
        } else if (failure.getErrorCode() != 422) {
            setWildcardReassignModeEnabled(false);
            if (failure.getErrorCode() == WILDCARD_ASSIGN_ERROR_STATUS) {
                notifyAllOnWildcardReassignStep(WildcardReassignStep.WILDCARD_REASSIGN_FAIL);
            } else if (failure.getErrorCode() == 425) {
                notifyAllOnCardValidateFailure$default(this, CardValidationFailError.WILDCARD_USER_CONTENT_NOT_FINISHED, (TicketFailure) null, 2, (Object) null);
            } else {
                notifyAllOnCardValidateFailure$default(this, CardValidationFailError.CARD_404_NOT_VALID, (TicketFailure) null, 2, (Object) null);
            }
        } else if (!notifyWildcardReassignStepIfNeeded()) {
            notifyAllOnCardValidateFailure$default(this, CardValidationFailError.WILDCARD_IS_PRIVATE, (TicketFailure) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void handleValidateResponse(TigerCardDomain tigerCardDomain) {
        if (tigerCardDomain != null) {
            saveToLocalStorage(tigerCardDomain.getUid(), tigerCardDomain);
            handleValidatedCard(tigerCardDomain);
        }
    }

    private final TigerCardDomain preparedResponse(TigerCardDomain tigerCardDomain) {
        TigerCardDomain.MultiTigercardVariantDomain multiTigercardVariant;
        TigerCardDomain tigerCardDomain2;
        ProductDetailsDto productDetailsDto;
        ProductDetailsDto productDetailsDto2;
        if (!Intrinsics.areEqual((Object) tigerCardDomain.getCardType(), (Object) MULTI_TIGERCARD) || (multiTigercardVariant = tigerCardDomain.getMultiTigercardVariant()) == null) {
            return tigerCardDomain;
        }
        if (multiTigercardVariant.getRecentlyUsedProduct() != null) {
            tigerCardDomain2 = TigerCardDomain.copy$default(tigerCardDomain, (String) null, (String) null, (String) null, Integer.valueOf(multiTigercardVariant.getRecentlyUsedProduct().getProductId()), 0, (TigerCardDomain.AccountGeneratedContentsDomain) null, (TigerTicketDomain) null, (TigerCardDomain.MultiTigercardVariantDomain) null, 247, (Object) null);
        } else {
            List<ProductDetailsDto> products = multiTigercardVariant.getProducts();
            if (products == null || (productDetailsDto2 = (ProductDetailsDto) CollectionsKt.firstOrNull(products)) == null) {
                tigerCardDomain2 = tigerCardDomain;
            } else {
                tigerCardDomain2 = TigerCardDomain.copy$default(tigerCardDomain, (String) null, (String) null, (String) null, Integer.valueOf(productDetailsDto2.getId()), 0, (TigerCardDomain.AccountGeneratedContentsDomain) null, (TigerTicketDomain) null, (TigerCardDomain.MultiTigercardVariantDomain) null, 247, (Object) null);
            }
        }
        if (Intrinsics.areEqual((Object) true, (Object) this.wifiService.getOfflineMode().getValue())) {
            Timber.Forest.mo50221i("multiTigercardVariant - Filter product list as we are in offline mode", new Object[0]);
            List arrayList = new ArrayList();
            List<ProductDetailsDto> products2 = multiTigercardVariant.getProducts();
            if (products2 != null) {
                for (ProductDetailsDto next : products2) {
                    if (AvailabilityService.DefaultImpls.offlineAvailabilityStateFor$default(this.availability, next.getId(), false, 2, (Object) null) == OfflineAvailabilityState.AVAILABLE) {
                        arrayList.add(next);
                    }
                }
            }
            multiTigercardVariant = TigerCardDomain.MultiTigercardVariantDomain.copy$default(multiTigercardVariant, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, arrayList, (TigerCardDomain.MultiTigercardVariantDomain.RecentlyUsedProductDomain) null, (String) null, 447, (Object) null);
            Integer productId = tigerCardDomain2.getProductId();
            if (productId != null) {
                if (this.availability.offlineAvailabilityReason(productId.intValue()) == DownloadReason.NONE && (productDetailsDto = (ProductDetailsDto) CollectionsKt.firstOrNull(arrayList)) != null) {
                    tigerCardDomain2 = TigerCardDomain.copy$default(tigerCardDomain, (String) null, (String) null, (String) null, Integer.valueOf(productDetailsDto.getId()), 0, (TigerCardDomain.AccountGeneratedContentsDomain) null, (TigerTicketDomain) null, (TigerCardDomain.MultiTigercardVariantDomain) null, 247, (Object) null);
                }
            }
        }
        return TigerCardDomain.copy$default(tigerCardDomain2, (String) null, (String) null, (String) null, (Integer) null, 0, (TigerCardDomain.AccountGeneratedContentsDomain) null, (TigerTicketDomain) null, multiTigercardVariant, 127, (Object) null);
    }

    private final void handleValidatedCard(TigerCardDomain tigerCardDomain) {
        TigerCardDomain tigerCardDomain2;
        List<ProductDetailsDto> products;
        String str;
        ProductDetailsDto.Links.Link cover;
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("TigerCardsManager handleValidatedCard response " + tigerCardDomain, new Object[0]);
        this._validatedCard = preparedResponse(tigerCardDomain);
        if (!notifyWildcardReassignStepIfNeeded() && (tigerCardDomain2 = this._validatedCard) != null) {
            Timber.Forest.mo50221i("TigerCardsManager: we have a validated card response", new Object[0]);
            String cardType = tigerCardDomain2.getCardType();
            switch (cardType.hashCode()) {
                case -483323767:
                    if (cardType.equals(MULTI_TIGERCARD)) {
                        Timber.Forest.mo50221i("TigerCardsManager - MULTI_TIGERCARD", new Object[0]);
                        if (tigerCardDomain2.getProductId() != null) {
                            Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            objectRef.element = CollectionsKt.listOf(new PlaybackDto(tigerCardDomain2.getProductId().intValue(), (String) null, (String) null, (String) null, (Boolean) null, 30, (DefaultConstructorMarker) null));
                            TigerCardDomain.MultiTigercardVariantDomain multiTigercardVariant = tigerCardDomain2.getMultiTigercardVariant();
                            if (!(multiTigercardVariant == null || (products = multiTigercardVariant.getProducts()) == null)) {
                                Iterable<ProductDetailsDto> subList = products.subList(0, products.size());
                                T t = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
                                for (ProductDetailsDto productDetailsDto : subList) {
                                    int id = productDetailsDto.getId();
                                    ProductDetailsDto.Links links = productDetailsDto.get_links();
                                    if (links == null || (cover = links.getCover()) == null || (str = cover.getHref()) == null) {
                                        str = "";
                                    }
                                    PlaybackDto playbackDto = r9;
                                    PlaybackDto playbackDto2 = new PlaybackDto(id, str, productDetailsDto.getTitle(), productDetailsDto.getAuthor(), (Boolean) null, 16, (DefaultConstructorMarker) null);
                                    t.add(playbackDto);
                                }
                                objectRef.element = (List) t;
                            }
                            Timber.Forest forest2 = Timber.Forest;
                            forest2.mo50221i("TigerCardsManager - Multicard has a main productId " + tigerCardDomain2.getProductId() + " productsList " + objectRef.element, new Object[0]);
                            if (!((Collection) objectRef.element).isEmpty()) {
                                notifyAllOnCardInsertedAndValidated(tigerCardDomain2);
                                AudioPlaylist create = AudioPlaylist.Companion.create((List) objectRef.element, tigerCardDomain2.getProductId().intValue(), AudioPlaybackReason.TIGERCARD, tigerCardDomain2);
                                create.setDelegate(this.audioPlaylistDelegate);
                                this.audioPlayerService.streamPlaylist(create, new TigerCardsManager$handleValidatedCard$1$3(this));
                                return;
                            } else if (Intrinsics.areEqual((Object) true, (Object) this.wifiService.getOfflineMode().getValue())) {
                                notifyAllOnCardValidateFailure$default(this, CardValidationFailError.NO_WIFI, (TicketFailure) null, 2, (Object) null);
                                return;
                            } else {
                                notifyAllOnCardValidateFailure$default(this, CardValidationFailError.TIGERCARD_PRODUCT_ID_MISSING, (TicketFailure) null, 2, (Object) null);
                                return;
                            }
                        } else {
                            notifyAllOnCardValidateFailure$default(this, CardValidationFailError.TIGERCARD_PRODUCT_ID_MISSING, (TicketFailure) null, 2, (Object) null);
                            return;
                        }
                    }
                    break;
                case -390388262:
                    if (cardType.equals(WILDCARD)) {
                        Timber.Forest.mo50221i("TigerCardsManager - WILDCARD", new Object[0]);
                        if (tigerCardDomain2.getProductId() != null) {
                            notifyAllOnCardInsertedAndValidated(tigerCardDomain2);
                            AudioPlaylist create2 = AudioPlaylist.Companion.create(CollectionsKt.listOf(new PlaybackDto(tigerCardDomain2.getProductId().intValue(), (String) null, (String) null, (String) null, (Boolean) null, 30, (DefaultConstructorMarker) null)), AudioPlaybackReason.WILDCARD, tigerCardDomain2);
                            create2.setDelegate(this.audioPlaylistDelegate);
                            this.audioPlayerService.streamPlaylist(create2, new TigerCardsManager$handleValidatedCard$1$4(this));
                            return;
                        }
                        notifyAllOnCardInsertedAndValidated(tigerCardDomain2);
                        TigerCardDomain.AccountGeneratedContentsDomain wildcardUserContent = tigerCardDomain2.getWildcardUserContent();
                        if (wildcardUserContent == null) {
                            return;
                        }
                        if (Intrinsics.areEqual((Object) wildcardUserContent.getTranscodingStatus(), (Object) WILDCARD_TRANSCODING_FINISHED)) {
                            AudioPlaylist create3 = AudioPlaylist.Companion.create(CollectionsKt.listOf(new PlaybackDto(tigerCardDomain2.getAccountGeneratedContentId(), (String) null, (String) null, (String) null, (Boolean) null, 30, (DefaultConstructorMarker) null)), AudioPlaybackReason.WILDCARD_USER_CONTENT, tigerCardDomain2);
                            create3.setDelegate(this.audioPlaylistDelegate);
                            this.audioPlayerService.streamPlaylist(create3, new TigerCardsManager$handleValidatedCard$1$5$1(this));
                            return;
                        }
                        notifyAllOnCardValidateFailure$default(this, CardValidationFailError.WILDCARD_USER_CONTENT_NOT_FINISHED, (TicketFailure) null, 2, (Object) null);
                        return;
                    }
                    break;
                case 669131883:
                    if (cardType.equals(TIGERTICKET)) {
                        Timber.Forest.mo50221i("TigerCardsManager - TIGERTICKET", new Object[0]);
                        notifyAllOnCardInsertedAndValidated(tigerCardDomain2);
                        TigerTicketDomain tigerTicketContent = tigerCardDomain2.getTigerTicketContent();
                        if (tigerTicketContent != null) {
                            this.tigerTicketGetProductUseCase.invoke(new TigerTicketGetProductUseCase.TigerTicketProductParameters(tigerTicketContent.getCouponCode()), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new TigerCardsManager$handleValidatedCard$1$6$1(this));
                            return;
                        }
                        return;
                    }
                    break;
                case 1810236463:
                    if (cardType.equals(TIGERCARD)) {
                        Timber.Forest.mo50221i("TigerCardsManager - TIGERCARD", new Object[0]);
                        if (tigerCardDomain2.getProductId() != null) {
                            notifyAllOnCardInsertedAndValidated(tigerCardDomain2);
                            AudioPlaylist create4 = AudioPlaylist.Companion.create(CollectionsKt.listOf(new PlaybackDto(tigerCardDomain2.getProductId().intValue(), (String) null, (String) null, (String) null, (Boolean) null, 30, (DefaultConstructorMarker) null)), AudioPlaybackReason.TIGERCARD, tigerCardDomain2);
                            create4.setDelegate(this.audioPlaylistDelegate);
                            this.audioPlayerService.streamPlaylist(create4, new TigerCardsManager$handleValidatedCard$1$1(this));
                            return;
                        }
                        notifyAllOnCardValidateFailure$default(this, CardValidationFailError.TIGERCARD_PRODUCT_ID_MISSING, (TicketFailure) null, 2, (Object) null);
                        return;
                    }
                    break;
            }
            notifyAllOnCardValidateFailure$default(this, CardValidationFailError.UNKNOWN_CARD_TYPE, (TicketFailure) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void handleTicketValidateFailure(Failure failure) {
        TicketFailure failureToTicketFailure = failureToTicketFailure(failure);
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("handleTicketValidateFailure " + failure + " ticketFailure " + failureToTicketFailure, new Object[0]);
        notifyAllOnCardValidateFailure(failureToTicketFailure.getCardFailError(), failureToTicketFailure);
    }

    public TicketFailure failureToTicketFailure(Failure failure) {
        TigerTicketFail tigerTicketFail;
        String message;
        Intrinsics.checkNotNullParameter(failure, "failure");
        Timber.Forest.mo50221i("failureToTicketFailure " + failure, new Object[0]);
        TigerTicketFail tigerTicketFail2 = null;
        try {
            tigerTicketFail = (TigerTicketFail) new Gson().fromJson(failure.getErrorMessage(), TigerTicketFail.class);
        } catch (Exception unused) {
            Timber.Forest.mo50217e("failureToTicketFailure: failureToTicketFailure", new Object[0]);
            tigerTicketFail = null;
        }
        int errorCode = failure.getErrorCode();
        if (errorCode == 400) {
            return new TicketFailure(CardValidationFailError.TIGERTICKET_ERROR_400, tigerTicketFail);
        }
        if (errorCode == 410) {
            return new TicketFailure(CardValidationFailError.TIGERTICKET_ERROR_410, tigerTicketFail);
        }
        if (errorCode == 429) {
            String message2 = tigerTicketFail != null ? tigerTicketFail.getMessage() : null;
            Integer intOrNull = (tigerTicketFail == null || (message = tigerTicketFail.getMessage()) == null) ? null : StringsKt.toIntOrNull(message);
            if (intOrNull != null) {
                message2 = String.valueOf(intOrNull.intValue() / 60);
            }
            if (tigerTicketFail != null) {
                if (message2 == null) {
                    message2 = "";
                }
                tigerTicketFail2 = TigerTicketFail.copy$default(tigerTicketFail, 0, 0, message2, 3, (Object) null);
            }
            return new TicketFailure(CardValidationFailError.TIGERTICKET_ERROR_429, tigerTicketFail2);
        } else if (errorCode == 403) {
            return new TicketFailure(CardValidationFailError.TIGERTICKET_ERROR_403, tigerTicketFail);
        } else {
            if (errorCode != 404) {
                return new TicketFailure(CardValidationFailError.TIGERTICKET_ERROR_GENERAL, tigerTicketFail);
            }
            return new TicketFailure(CardValidationFailError.TIGERTICKET_ERROR_404, tigerTicketFail);
        }
    }

    /* access modifiers changed from: private */
    public final void handleTicketValidateResponse(TigerTicketAssignedProduct tigerTicketAssignedProduct) {
        if (tigerTicketAssignedProduct != null) {
            this.tigerTicketProduct = tigerTicketAssignedProduct;
            TigerCardDomain validatedCard = getValidatedCard();
            if ((validatedCard != null ? validatedCard.getTigerTicketContent() : null) != null) {
                TigerTicketStepType tigerTicketStepType = TigerTicketStepType.TIGER_TICKET_STEP_REMOVE_CARD;
                TigerCardDomain validatedCard2 = getValidatedCard();
                Intrinsics.checkNotNull(validatedCard2);
                TigerTicketDomain tigerTicketContent = validatedCard2.getTigerTicketContent();
                Intrinsics.checkNotNull(tigerTicketContent);
                notifyAllOnTigerTicketStep(new TigerTicketStepDomain(tigerTicketStepType, tigerTicketContent, tigerTicketAssignedProduct));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c1, code lost:
        if (r1 == false) goto L_0x00c8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCardRemoved() {
        /*
            r6 = this;
            r0 = 0
            r6.setWildcardReassignModeEnabled(r0)
            media.tiger.tigerbox.model.dto.TigerTicketAssignedProduct r1 = r6.tigerTicketProduct
            r2 = 0
            if (r1 == 0) goto L_0x0034
            media.tiger.tigerbox.services.interfaces.TigerCardDomain r1 = r6.getValidatedCard()
            if (r1 == 0) goto L_0x0014
            media.tiger.tigerbox.services.interfaces.TigerTicketDomain r1 = r1.getTigerTicketContent()
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            if (r1 == 0) goto L_0x0034
            media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain r1 = new media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain
            media.tiger.tigerbox.services.interfaces.TigerTicketStepType r3 = media.tiger.tigerbox.services.interfaces.TigerTicketStepType.TIGER_TICKET_STEP_INPUT_PIN
            media.tiger.tigerbox.services.interfaces.TigerCardDomain r4 = r6.getValidatedCard()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            media.tiger.tigerbox.services.interfaces.TigerTicketDomain r4 = r4.getTigerTicketContent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            media.tiger.tigerbox.model.dto.TigerTicketAssignedProduct r5 = r6.tigerTicketProduct
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r1.<init>(r3, r4, r5)
            r6.notifyAllOnTigerTicketStep(r1)
        L_0x0034:
            media.tiger.tigerbox.services.interfaces.TigerCardDomain r1 = r6.getValidatedCard()
            if (r1 == 0) goto L_0x00c8
            media.tiger.tigerbox.services.interfaces.TigerCardDomain r1 = r6.getValidatedCard()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            media.tiger.tigerbox.services.interfaces.TigerCardDomain$MultiTigercardVariantDomain r1 = r1.getMultiTigercardVariant()
            if (r1 == 0) goto L_0x0079
            java.util.List r1 = r1.getProducts()
            if (r1 == 0) goto L_0x0079
            java.util.Iterator r1 = r1.iterator()
        L_0x0051:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r1.next()
            media.tiger.tigerbox.model.dto.ProductDetailsDto r3 = (media.tiger.tigerbox.model.dto.ProductDetailsDto) r3
            int r3 = r3.getId()
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r4 = r6.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r4 = r4.getCurrentItem()
            if (r4 == 0) goto L_0x0074
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r4 = r4.getProduct()
            if (r4 == 0) goto L_0x0074
            int r4 = r4.getId()
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            if (r3 != r4) goto L_0x0051
            r1 = 1
            goto L_0x007a
        L_0x0079:
            r1 = 0
        L_0x007a:
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r3 = r6.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r3 = r3.getCurrentItem()
            if (r3 == 0) goto L_0x008d
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r3 = r3.getProduct()
            if (r3 == 0) goto L_0x008d
            int r3 = r3.getId()
            goto L_0x008e
        L_0x008d:
            r3 = 0
        L_0x008e:
            media.tiger.tigerbox.services.interfaces.TigerCardDomain r4 = r6.getValidatedCard()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Integer r4 = r4.getProductId()
            if (r4 != 0) goto L_0x009c
            goto L_0x00a2
        L_0x009c:
            int r4 = r4.intValue()
            if (r3 == r4) goto L_0x00c3
        L_0x00a2:
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r3 = r6.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r3 = r3.getCurrentItem()
            if (r3 == 0) goto L_0x00b4
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r3 = r3.getProduct()
            if (r3 == 0) goto L_0x00b4
            int r0 = r3.getId()
        L_0x00b4:
            media.tiger.tigerbox.services.interfaces.TigerCardDomain r3 = r6.getValidatedCard()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r3 = r3.getAccountGeneratedContentId()
            if (r0 == r3) goto L_0x00c3
            if (r1 == 0) goto L_0x00c8
        L_0x00c3:
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r0 = r6.audioPlayerService
            r0.stop()
        L_0x00c8:
            r6._validatedCard = r2
            r6.insertedNfcCard = r2
            r6.notifyAllOnCardRemoved()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.TigerCardsManager.onCardRemoved():void");
    }

    public void onCardException(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        this._validatedCard = null;
        setWildcardReassignModeEnabled(false);
        notifyAllOnCardValidateFailure$default(this, CardValidationFailError.COULD_NOT_READ_CARD, (TicketFailure) null, 2, (Object) null);
    }

    public void registerListener(TigerCardsListener tigerCardsListener) {
        Intrinsics.checkNotNullParameter(tigerCardsListener, "listener");
        if (!this.listeners.contains(tigerCardsListener)) {
            this.listeners.add(tigerCardsListener);
        }
    }

    public void unregisterListener(TigerCardsListener tigerCardsListener) {
        Intrinsics.checkNotNullParameter(tigerCardsListener, "listener");
        this.listeners.remove(tigerCardsListener);
    }

    private final void notifyAllOnCardInsertedAndValidated(TigerCardDomain tigerCardDomain) {
        Timber.Forest.mo50221i("TigerCardsManager notifyAllOnCardInsertedAndValidated", new Object[0]);
        Iterator<TigerCardsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onCardInsertedAndValidated(tigerCardDomain);
        }
    }

    private final void notifyAllOnCardRemoved() {
        Timber.Forest.mo50221i("TigerCardsManager notifyAllOnCardRemoved", new Object[0]);
        Iterator<TigerCardsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onCardRemoved();
        }
    }

    static /* synthetic */ void notifyAllOnCardValidateFailure$default(TigerCardsManager tigerCardsManager, CardValidationFailError cardValidationFailError, TicketFailure ticketFailure, int i, Object obj) {
        if ((i & 2) != 0) {
            ticketFailure = null;
        }
        tigerCardsManager.notifyAllOnCardValidateFailure(cardValidationFailError, ticketFailure);
    }

    private final void notifyAllOnCardValidateFailure(CardValidationFailError cardValidationFailError, TicketFailure ticketFailure) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("TigerCardsManager notifyAllOnCardValidateFailure " + cardValidationFailError, new Object[0]);
        Iterator<TigerCardsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onCardValidateFailure(cardValidationFailError, ticketFailure);
        }
    }

    private final void notifyAllOnTigerTicketStep(TigerTicketStepDomain tigerTicketStepDomain) {
        Timber.Forest.mo50221i("TigerCardsManager notifyAllOnTigerTicketStep", new Object[0]);
        Iterator<TigerCardsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTigerTicketStep(tigerTicketStepDomain);
        }
    }

    private final void notifyAllOnWildcardReassignStep(WildcardReassignStep wildcardReassignStep) {
        Timber.Forest.mo50221i("TigerCardsManager notifyAllOnWildcardReassignStep", new Object[0]);
        Iterator<TigerCardsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onWildcardReassignStep(wildcardReassignStep);
        }
    }

    public boolean getWildcardReassignModeEnabled() {
        return this._wildcardReassignModeEnabled;
    }

    public void setWildcardReassignModeEnabled(boolean z) {
        if (!z && z != this._wildcardReassignModeEnabled) {
            notifyAllOnWildcardReassignStep(WildcardReassignStep.WILDCARD_REASSIGN_CANCELED_OR_ENDED);
        }
        this._wildcardReassignModeEnabled = z;
        notifyWildcardReassignStepIfNeeded();
    }

    private final boolean notifyWildcardReassignStepIfNeeded() {
        if (!this._wildcardReassignModeEnabled) {
            return false;
        }
        TigerCardDomain validatedCard = getValidatedCard();
        if (Intrinsics.areEqual((Object) validatedCard != null ? validatedCard.getCardType() : null, (Object) WILDCARD) || this.insertedNfcCard != null) {
            notifyAllOnWildcardReassignStep(WildcardReassignStep.WILDCARD_REASSIGN_STEP_2);
            return true;
        }
        notifyAllOnWildcardReassignStep(WildcardReassignStep.WILDCARD_REASSIGN_STEP_1);
        return true;
    }

    public void reassignInsertedWildcard() {
        if (this._wildcardReassignModeEnabled && this.insertedNfcCard != null) {
            notifyAllOnWildcardReassignStep(WildcardReassignStep.WILDCARD_REASSIGN_STEP_3);
            WildCardReassignUseCase wildCardReassignUseCase = this.wildcardReassignUseCase;
            TigerCard tigerCard = this.insertedNfcCard;
            String str = null;
            String valueOf = String.valueOf(tigerCard != null ? tigerCard.getId() : null);
            TigerCard tigerCard2 = this.insertedNfcCard;
            if (tigerCard2 != null) {
                str = tigerCard2.getSecureCode();
            }
            wildCardReassignUseCase.invoke(new WildCardReassignUseCase.RequestParams(valueOf, String.valueOf(str)), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new TigerCardsManager$reassignInsertedWildcard$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void handleValidWildcardReassignResponse(TigerCardValidState tigerCardValidState) {
        setWildcardReassignModeEnabled(false);
        if (tigerCardValidState != null) {
            notifyAllOnWildcardReassignStep(WildcardReassignStep.WILDCARD_REASSIGN_STEP_4);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/TigerCardsManager$Companion;", "", "()V", "MULTI_TIGERCARD", "", "TIGERCARD", "TIGERTICKET", "TIGERTICKET_ERROR_400", "", "TIGERTICKET_ERROR_403", "TIGERTICKET_ERROR_404", "TIGERTICKET_ERROR_410", "TIGERTICKET_ERROR_429", "VALIDATED_CARDS", "WILDCARD", "WILDCARD_ASSIGN_ERROR_STATUS", "WILDCARD_NOT_FINISHED_STATUS", "WILDCARD_PRIVATE_STATUS", "WILDCARD_TRANSCODING_FINISHED", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerCardsManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
