package media.tiger.tigerbox.services.implementations.audioPlayer;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.LastUsedProductService;
import media.tiger.tigerbox.usecase.ReportLastCardProductUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0003&'(B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0017\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001cJ\f\u0010\u001d\u001a\u00060\rR\u00020\u0000H\u0002J\u0012\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u001bH\u0002J,\u0010$\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u001bH\u0002R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/LastUsedProductService;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackListener;", "audioService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "sharedPreferences", "Landroid/content/SharedPreferences;", "reportLastCardProductUseCase", "Lmedia/tiger/tigerbox/usecase/ReportLastCardProductUseCase;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Landroid/content/SharedPreferences;Lmedia/tiger/tigerbox/usecase/ReportLastCardProductUseCase;Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;)V", "_localLastProductStates", "Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct$LastUsedProductsPerUser;", "activeUserId", "", "getActiveUserId", "()I", "handlePostStateReqFailure", "", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "handlePostStateReqSuccess", "state", "(Lkotlin/Unit;)V", "lastUsedProduct", "multicardCode", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "localLastProductStates", "onPlaybackItemChanged", "item", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "saveLastUsedProduct", "productId", "multicardReportUrl", "sendLastUsedProductToServer", "userId", "CardOrDefault", "Companion", "LastUsedProductsPerUser", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LastUsedProduct.kt */
public final class LastUsedProduct implements LastUsedProductService, AudioPlaybackListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_LAST_USED_PRODUCT_KEY = "lastUsedProduct";
    public static final String USER_LAST_USED_PRODUCTS_KEY = "user_last_used_products";
    private LastUsedProductsPerUser _localLastProductStates;
    private final GetTigerBoxAccountUseCase getTigerBoxAccountUseCase;
    private ReportLastCardProductUseCase reportLastCardProductUseCase;
    /* access modifiers changed from: private */
    public final SharedPreferences sharedPreferences;

    /* access modifiers changed from: private */
    public final void handlePostStateReqSuccess(Unit unit) {
    }

    public LastUsedProduct(AudioPlayerService audioPlayerService, SharedPreferences sharedPreferences2, ReportLastCardProductUseCase reportLastCardProductUseCase2, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2) {
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioService");
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(reportLastCardProductUseCase2, "reportLastCardProductUseCase");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
        this.sharedPreferences = sharedPreferences2;
        this.reportLastCardProductUseCase = reportLastCardProductUseCase2;
        this.getTigerBoxAccountUseCase = getTigerBoxAccountUseCase2;
        audioPlayerService.registerListener(this);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C29041(this, (Continuation<? super C29041>) null), 3, (Object) null);
    }

    public void onPlaybackBeginScrubbing(AudioItem audioItem, long j, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackBeginScrubbing(this, audioItem, j, i);
    }

    public void onPlaybackEndScrubbing(AudioItem audioItem, long j, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackEndScrubbing(this, audioItem, j, i);
    }

    public void onPlaybackPlaylistChangeReady() {
        AudioPlaybackListener.DefaultImpls.onPlaybackPlaylistChangeReady(this);
    }

    public void onPlaybackPlaylistWillChange() {
        AudioPlaybackListener.DefaultImpls.onPlaybackPlaylistWillChange(this);
    }

    public void onPlaybackStateChanged(AudioPlaybackState audioPlaybackState) {
        AudioPlaybackListener.DefaultImpls.onPlaybackStateChanged(this, audioPlaybackState);
    }

    public void onPlaybackTrackDidChange(AudioItem audioItem, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackDidChange(this, audioItem, i);
    }

    public void onPlaybackTrackPositionChanged(AudioItem audioItem, long j, int i, int i2) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackPositionChanged(this, audioItem, j, i, i2);
    }

    public void onPlaybackTrackWillChange(AudioItem audioItem, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackWillChange(this, audioItem, i);
    }

    public void onProductAcquisitionError(ProductAcquisitionService.ErrorCode errorCode) {
        AudioPlaybackListener.DefaultImpls.onProductAcquisitionError(this, errorCode);
    }

    public void onProductPlaybackEnd(AudioItem audioItem) {
        AudioPlaybackListener.DefaultImpls.onProductPlaybackEnd(this, audioItem);
    }

    private final int getActiveUserId() {
        return this.getTigerBoxAccountUseCase.invoke().getUser().getActiveProfileId();
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.LastUsedProduct$1", mo34424f = "LastUsedProduct.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.services.implementations.audioPlayer.LastUsedProduct$1 */
    /* compiled from: LastUsedProduct.kt */
    static final class C29041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LastUsedProduct this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29041(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LastUsedProductsPerUser unused = this.this$0.localLastProductStates();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct$Companion;", "", "()V", "DEFAULT_LAST_USED_PRODUCT_KEY", "", "USER_LAST_USED_PRODUCTS_KEY", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: LastUsedProduct.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct$CardOrDefault;", "", "(Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct;)V", "cardOrDefautMap", "", "", "", "(Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct;Ljava/util/Map;)V", "getCardOrDefautMap", "()Ljava/util/Map;", "setCardOrDefautMap", "(Ljava/util/Map;)V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: LastUsedProduct.kt */
    public final class CardOrDefault {
        private Map<String, Integer> cardOrDefautMap;
        final /* synthetic */ LastUsedProduct this$0;

        public CardOrDefault(LastUsedProduct lastUsedProduct, Map<String, Integer> map) {
            Intrinsics.checkNotNullParameter(map, "cardOrDefautMap");
            this.this$0 = lastUsedProduct;
            this.cardOrDefautMap = map;
        }

        public final Map<String, Integer> getCardOrDefautMap() {
            return this.cardOrDefautMap;
        }

        public final void setCardOrDefautMap(Map<String, Integer> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.cardOrDefautMap = map;
        }

        public CardOrDefault(LastUsedProduct lastUsedProduct) {
            this(lastUsedProduct, new LinkedHashMap());
        }
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006R\u00020\u00070\u0004¢\u0006\u0002\u0010\bR*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006R\u00020\u00070\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct$LastUsedProductsPerUser;", "", "(Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct;)V", "perUserId", "", "", "Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct$CardOrDefault;", "Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct;", "(Lmedia/tiger/tigerbox/services/implementations/audioPlayer/LastUsedProduct;Ljava/util/Map;)V", "getPerUserId", "()Ljava/util/Map;", "setPerUserId", "(Ljava/util/Map;)V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: LastUsedProduct.kt */
    public final class LastUsedProductsPerUser {
        private Map<String, CardOrDefault> perUserId;
        final /* synthetic */ LastUsedProduct this$0;

        public LastUsedProductsPerUser(LastUsedProduct lastUsedProduct, Map<String, CardOrDefault> map) {
            Intrinsics.checkNotNullParameter(map, "perUserId");
            this.this$0 = lastUsedProduct;
            this.perUserId = map;
        }

        public final Map<String, CardOrDefault> getPerUserId() {
            return this.perUserId;
        }

        public final void setPerUserId(Map<String, CardOrDefault> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.perUserId = map;
        }

        public LastUsedProductsPerUser(LastUsedProduct lastUsedProduct) {
            this(lastUsedProduct, new LinkedHashMap());
        }
    }

    public void onPlaybackItemChanged(AudioItem audioItem) {
        TigerCardDomain.MultiTigercardVariantDomain multiTigercardVariant;
        if (audioItem != null) {
            int id = audioItem.getProduct().getId();
            TigerCardDomain nfcPayload = audioItem.getNfcPayload();
            String str = null;
            String code = nfcPayload != null ? nfcPayload.getCode() : null;
            TigerCardDomain nfcPayload2 = audioItem.getNfcPayload();
            if (!(nfcPayload2 == null || (multiTigercardVariant = nfcPayload2.getMultiTigercardVariant()) == null)) {
                str = multiTigercardVariant.getSaveRecentlyUsedMultiTigercardProductUrl();
            }
            saveLastUsedProduct(id, code, str);
        }
    }

    /* access modifiers changed from: private */
    public final LastUsedProductsPerUser localLastProductStates() {
        LastUsedProductsPerUser lastUsedProductsPerUser;
        if (this._localLastProductStates == null) {
            String string = this.sharedPreferences.getString(USER_LAST_USED_PRODUCTS_KEY, "");
            if (string != null) {
                if (string.length() > 0) {
                    lastUsedProductsPerUser = (LastUsedProductsPerUser) new Gson().fromJson(string, new LastUsedProduct$localLastProductStates$statesType$1().getType());
                    this._localLastProductStates = lastUsedProductsPerUser;
                }
            }
            lastUsedProductsPerUser = new LastUsedProductsPerUser(this);
            this._localLastProductStates = lastUsedProductsPerUser;
        }
        LastUsedProductsPerUser lastUsedProductsPerUser2 = this._localLastProductStates;
        Intrinsics.checkNotNull(lastUsedProductsPerUser2);
        return lastUsedProductsPerUser2;
    }

    private final void saveLastUsedProduct(int i, String str, String str2) {
        if (i > 0) {
            String valueOf = String.valueOf(getActiveUserId());
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new LastUsedProduct$saveLastUsedProduct$1(this, valueOf, i, str, (Continuation<? super LastUsedProduct$saveLastUsedProduct$1>) null), 3, (Object) null);
            sendLastUsedProductToServer(i, Integer.parseInt(valueOf), str, str2);
        }
    }

    public Integer lastUsedProduct(String str) {
        CardOrDefault cardOrDefault = localLastProductStates().getPerUserId().get(String.valueOf(getActiveUserId()));
        if (cardOrDefault == null) {
            return null;
        }
        if (str != null) {
            return cardOrDefault.getCardOrDefautMap().get(str);
        }
        return cardOrDefault.getCardOrDefautMap().get(DEFAULT_LAST_USED_PRODUCT_KEY);
    }

    private final void sendLastUsedProductToServer(int i, int i2, String str, String str2) {
        if (str2 != null) {
            try {
                this.reportLastCardProductUseCase.invoke(new ReportLastCardProductUseCase.RequestParams(str2, i2, i), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new LastUsedProduct$sendLastUsedProductToServer$1$1(this));
            } catch (Exception e) {
                Timber.Tree tag = Timber.Forest.tag("LastUsedProduct");
                tag.mo50217e("Last Product report exception: " + e.getMessage(), new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void handlePostStateReqFailure(Failure failure) {
        Timber.Tree tag = Timber.Forest.tag("LastUsedProduct");
        tag.mo50217e("updating server with last product failed " + failure, new Object[0]);
    }
}
