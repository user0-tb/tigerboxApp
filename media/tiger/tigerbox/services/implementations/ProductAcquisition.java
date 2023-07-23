package media.tiger.tigerbox.services.implementations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.model.domain.DownloadReason;
import media.tiger.tigerbox.model.domain.OfflineAvailabilityState;
import media.tiger.tigerbox.model.domain.ProductDetails;
import media.tiger.tigerbox.model.dto.Acquisition;
import media.tiger.tigerbox.model.dto.AssetProduct;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import media.tiger.tigerbox.services.interfaces.AcquisitionReason;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionDelegate;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.usecase.CheckAcquisitionsParameters;
import media.tiger.tigerbox.usecase.CheckAcquisitionsUseCase;
import media.tiger.tigerbox.usecase.GetProductAssetsParameters;
import media.tiger.tigerbox.usecase.GetProductAssetsUseCase;
import media.tiger.tigerbox.usecase.GetProductDetailsParameters;
import media.tiger.tigerbox.usecase.GetProductDetailsUseCase;
import media.tiger.tigerbox.usecase.RequestAcquisitionParameters;
import media.tiger.tigerbox.usecase.RequestAcquisitionUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import media.tiger.tigerbox.utils.DateUtilsKt;
import media.tiger.tigerbox.utils.FileUtilsKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003123BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012Jf\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 28\u0010!\u001a4\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00180\"H\u0016J\\\u0010)\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 28\u0010!\u001a4\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00180\"H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u0015H\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0002R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition;", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "dlManagerService", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "getProductAssetsUseCase", "Lmedia/tiger/tigerbox/usecase/GetProductAssetsUseCase;", "getProductDetailsUseCase", "Lmedia/tiger/tigerbox/usecase/GetProductDetailsUseCase;", "requestAcquisitionUseCase", "Lmedia/tiger/tigerbox/usecase/RequestAcquisitionUseCase;", "checkAcquisitionsUseCase", "Lmedia/tiger/tigerbox/usecase/CheckAcquisitionsUseCase;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "(Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/usecase/GetProductAssetsUseCase;Lmedia/tiger/tigerbox/usecase/GetProductDetailsUseCase;Lmedia/tiger/tigerbox/usecase/RequestAcquisitionUseCase;Lmedia/tiger/tigerbox/usecase/CheckAcquisitionsUseCase;Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;)V", "activeHandlers", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$RequestHandler;", "Lkotlin/collections/ArrayList;", "checkProduct", "", "productId", "", "reason", "Lmedia/tiger/tigerbox/services/interfaces/AcquisitionReason;", "tigerCardDomain", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "delegate", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionDelegate;", "onStep", "Lkotlin/Function2;", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$StepType;", "Lkotlin/ParameterName;", "name", "step", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "error", "downloadProduct", "isDownloadAcquisitionInProgress", "", "removeHandler", "handler", "requestProduct", "req", "Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$AcquisitionRequest;", "AcquisitionFinishAction", "AcquisitionRequest", "RequestHandler", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProductAcquisition.kt */
public final class ProductAcquisition implements ProductAcquisitionService {
    private ArrayList<RequestHandler> activeHandlers = new ArrayList<>();
    private AvailabilityService availabilityService;
    private CheckAcquisitionsUseCase checkAcquisitionsUseCase;
    private DownloadsManagerService dlManagerService;
    private GetProductAssetsUseCase getProductAssetsUseCase;
    private GetProductDetailsUseCase getProductDetailsUseCase;
    private GetTigerBoxAccountUseCase getTigerBoxAccountUseCase;
    private RequestAcquisitionUseCase requestAcquisitionUseCase;
    private StorageService storageService;

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$AcquisitionFinishAction;", "", "(Ljava/lang/String;I)V", "NONE", "DOWNLOAD", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ProductAcquisition.kt */
    public enum AcquisitionFinishAction {
        NONE,
        DOWNLOAD
    }

    public ProductAcquisition(DownloadsManagerService downloadsManagerService, StorageService storageService2, AvailabilityService availabilityService2, GetProductAssetsUseCase getProductAssetsUseCase2, GetProductDetailsUseCase getProductDetailsUseCase2, RequestAcquisitionUseCase requestAcquisitionUseCase2, CheckAcquisitionsUseCase checkAcquisitionsUseCase2, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2) {
        Intrinsics.checkNotNullParameter(downloadsManagerService, "dlManagerService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        Intrinsics.checkNotNullParameter(getProductAssetsUseCase2, "getProductAssetsUseCase");
        Intrinsics.checkNotNullParameter(getProductDetailsUseCase2, "getProductDetailsUseCase");
        Intrinsics.checkNotNullParameter(requestAcquisitionUseCase2, "requestAcquisitionUseCase");
        Intrinsics.checkNotNullParameter(checkAcquisitionsUseCase2, "checkAcquisitionsUseCase");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
        this.dlManagerService = downloadsManagerService;
        this.storageService = storageService2;
        this.availabilityService = availabilityService2;
        this.getProductAssetsUseCase = getProductAssetsUseCase2;
        this.getProductDetailsUseCase = getProductDetailsUseCase2;
        this.requestAcquisitionUseCase = requestAcquisitionUseCase2;
        this.checkAcquisitionsUseCase = checkAcquisitionsUseCase2;
        this.getTigerBoxAccountUseCase = getTigerBoxAccountUseCase2;
    }

    @Metadata(mo33736d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012:\u0010\u0004\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'RE\u0010\u0004\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006/"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$AcquisitionRequest;", "", "productId", "", "stepLambda", "Lkotlin/Function2;", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$StepType;", "Lkotlin/ParameterName;", "name", "step", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "error", "", "finishActionType", "Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$AcquisitionFinishAction;", "reason", "Lmedia/tiger/tigerbox/services/interfaces/AcquisitionReason;", "delegate", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionDelegate;", "trackIdx", "trackPosition", "", "tigerCardDomain", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "(ILkotlin/jvm/functions/Function2;Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$AcquisitionFinishAction;Lmedia/tiger/tigerbox/services/interfaces/AcquisitionReason;Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionDelegate;IJLmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;)V", "getDelegate", "()Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionDelegate;", "getFinishActionType", "()Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$AcquisitionFinishAction;", "getProductId", "()I", "productList", "", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "getProductList", "()Ljava/util/List;", "setProductList", "(Ljava/util/List;)V", "getReason", "()Lmedia/tiger/tigerbox/services/interfaces/AcquisitionReason;", "getStepLambda", "()Lkotlin/jvm/functions/Function2;", "getTigerCardDomain", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "getTrackIdx", "getTrackPosition", "()J", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ProductAcquisition.kt */
    public static final class AcquisitionRequest {
        private final ProductAcquisitionDelegate delegate;
        private final AcquisitionFinishAction finishActionType;
        private final int productId;
        private List<AudioProductInfo> productList;
        private final AcquisitionReason reason;
        private final Function2<ProductAcquisitionService.StepType, ProductAcquisitionService.ErrorCode, Unit> stepLambda;
        private final TigerCardDomain tigerCardDomain;
        private final int trackIdx;
        private final long trackPosition;

        public AcquisitionRequest(int i, Function2<? super ProductAcquisitionService.StepType, ? super ProductAcquisitionService.ErrorCode, Unit> function2, AcquisitionFinishAction acquisitionFinishAction, AcquisitionReason acquisitionReason, ProductAcquisitionDelegate productAcquisitionDelegate, int i2, long j, TigerCardDomain tigerCardDomain2) {
            Intrinsics.checkNotNullParameter(acquisitionFinishAction, "finishActionType");
            Intrinsics.checkNotNullParameter(acquisitionReason, "reason");
            this.productId = i;
            this.stepLambda = function2;
            this.finishActionType = acquisitionFinishAction;
            this.reason = acquisitionReason;
            this.delegate = productAcquisitionDelegate;
            this.trackIdx = i2;
            this.trackPosition = j;
            this.tigerCardDomain = tigerCardDomain2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ AcquisitionRequest(int r13, kotlin.jvm.functions.Function2 r14, media.tiger.tigerbox.services.implementations.ProductAcquisition.AcquisitionFinishAction r15, media.tiger.tigerbox.services.interfaces.AcquisitionReason r16, media.tiger.tigerbox.services.interfaces.ProductAcquisitionDelegate r17, int r18, long r19, media.tiger.tigerbox.services.interfaces.TigerCardDomain r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
            /*
                r12 = this;
                r0 = r22
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0009
                r1 = 0
                r8 = 0
                goto L_0x000b
            L_0x0009:
                r8 = r18
            L_0x000b:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0013
                r1 = 0
                r9 = r1
                goto L_0x0015
            L_0x0013:
                r9 = r19
            L_0x0015:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x001c
                r0 = 0
                r11 = r0
                goto L_0x001e
            L_0x001c:
                r11 = r21
            L_0x001e:
                r2 = r12
                r3 = r13
                r4 = r14
                r5 = r15
                r6 = r16
                r7 = r17
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.ProductAcquisition.AcquisitionRequest.<init>(int, kotlin.jvm.functions.Function2, media.tiger.tigerbox.services.implementations.ProductAcquisition$AcquisitionFinishAction, media.tiger.tigerbox.services.interfaces.AcquisitionReason, media.tiger.tigerbox.services.interfaces.ProductAcquisitionDelegate, int, long, media.tiger.tigerbox.services.interfaces.TigerCardDomain, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final int getProductId() {
            return this.productId;
        }

        public final Function2<ProductAcquisitionService.StepType, ProductAcquisitionService.ErrorCode, Unit> getStepLambda() {
            return this.stepLambda;
        }

        public final AcquisitionFinishAction getFinishActionType() {
            return this.finishActionType;
        }

        public final AcquisitionReason getReason() {
            return this.reason;
        }

        public final ProductAcquisitionDelegate getDelegate() {
            return this.delegate;
        }

        public final int getTrackIdx() {
            return this.trackIdx;
        }

        public final long getTrackPosition() {
            return this.trackPosition;
        }

        public final TigerCardDomain getTigerCardDomain() {
            return this.tigerCardDomain;
        }

        public final List<AudioProductInfo> getProductList() {
            return this.productList;
        }

        public final void setProductList(List<AudioProductInfo> list) {
            this.productList = list;
        }
    }

    public boolean isDownloadAcquisitionInProgress(int i) {
        synchronized (this.activeHandlers) {
            Iterator<RequestHandler> it = this.activeHandlers.iterator();
            while (it.hasNext()) {
                RequestHandler next = it.next();
                if (next.getActiveRequest().getProductId() == i && next.getActiveRequest().getFinishActionType() == AcquisitionFinishAction.DOWNLOAD) {
                    return true;
                }
            }
            Unit unit = Unit.INSTANCE;
            return false;
        }
    }

    public void downloadProduct(int i, AcquisitionReason acquisitionReason, ProductAcquisitionDelegate productAcquisitionDelegate, Function2<? super ProductAcquisitionService.StepType, ? super ProductAcquisitionService.ErrorCode, Unit> function2) {
        Intrinsics.checkNotNullParameter(acquisitionReason, "reason");
        Function2<? super ProductAcquisitionService.StepType, ? super ProductAcquisitionService.ErrorCode, Unit> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "onStep");
        int i2 = i;
        requestProduct(new AcquisitionRequest(i2, function22, AcquisitionFinishAction.DOWNLOAD, acquisitionReason, productAcquisitionDelegate, 0, 0, (TigerCardDomain) null, 224, (DefaultConstructorMarker) null));
    }

    public void checkProduct(int i, AcquisitionReason acquisitionReason, TigerCardDomain tigerCardDomain, ProductAcquisitionDelegate productAcquisitionDelegate, Function2<? super ProductAcquisitionService.StepType, ? super ProductAcquisitionService.ErrorCode, Unit> function2) {
        Intrinsics.checkNotNullParameter(acquisitionReason, "reason");
        Function2<? super ProductAcquisitionService.StepType, ? super ProductAcquisitionService.ErrorCode, Unit> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "onStep");
        int i2 = i;
        requestProduct(new AcquisitionRequest(i2, function22, AcquisitionFinishAction.NONE, acquisitionReason, productAcquisitionDelegate, 0, 0, tigerCardDomain));
    }

    private final void requestProduct(AcquisitionRequest acquisitionRequest) {
        RequestHandler requestHandler = new RequestHandler(acquisitionRequest, this.dlManagerService, this.storageService, this.availabilityService, this.getProductAssetsUseCase, this.getProductDetailsUseCase, this.requestAcquisitionUseCase, this.checkAcquisitionsUseCase, this.getTigerBoxAccountUseCase, new ProductAcquisition$requestProduct$reqHandler$1(this));
        synchronized (this.activeHandlers) {
            this.activeHandlers.add(requestHandler);
            Function2<ProductAcquisitionService.StepType, ProductAcquisitionService.ErrorCode, Unit> stepLambda = acquisitionRequest.getStepLambda();
            if (stepLambda != null) {
                stepLambda.invoke(ProductAcquisitionService.StepType.ACQUISITION_STARTED, null);
            }
            requestHandler.startRequest();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void removeHandler(RequestHandler requestHandler) {
        synchronized (this.activeHandlers) {
            this.activeHandlers.remove(requestHandler);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bp\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0002\u0010\u001aJ\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\u00020\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010*\u001a\u00020\u00192\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0%H\u0002J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u0010-\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0010\u00102\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020&H\u0002J\b\u00105\u001a\u00020\u0019H\u0002J\u0010\u00106\u001a\u0002072\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u00108\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010;\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u0010<\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R)\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$RequestHandler;", "", "activeRequest", "Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$AcquisitionRequest;", "dlManagerService", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "getProductAssetsUseCase", "Lmedia/tiger/tigerbox/usecase/GetProductAssetsUseCase;", "getProductDetailsUseCase", "Lmedia/tiger/tigerbox/usecase/GetProductDetailsUseCase;", "requestAcquisitionUseCase", "Lmedia/tiger/tigerbox/usecase/RequestAcquisitionUseCase;", "checkAcquisitionsUseCase", "Lmedia/tiger/tigerbox/usecase/CheckAcquisitionsUseCase;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "finishedRequest", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "req", "", "(Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$AcquisitionRequest;Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/usecase/GetProductAssetsUseCase;Lmedia/tiger/tigerbox/usecase/GetProductDetailsUseCase;Lmedia/tiger/tigerbox/usecase/RequestAcquisitionUseCase;Lmedia/tiger/tigerbox/usecase/CheckAcquisitionsUseCase;Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;Lkotlin/jvm/functions/Function1;)V", "getActiveRequest", "()Lmedia/tiger/tigerbox/services/implementations/ProductAcquisition$AcquisitionRequest;", "checkAcquisitionsIfNeededForActiveRequest", "downloadProduct", "getProductAssetsForActiveRequest", "handleCheckAcquisitionFailure", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "handleCheckAcquisitionsResponse", "acquisitionsList", "", "Lmedia/tiger/tigerbox/model/dto/Acquisition;", "handleFinishAction", "handleGetProductAssetsFailure", "handleGetProductDetailsFailure", "handleProductAssets", "list", "Lmedia/tiger/tigerbox/model/dto/AssetProduct;", "handleProductDetails", "productId", "", "details", "Lmedia/tiger/tigerbox/model/domain/ProductDetails;", "handleRequestAcquisitionFailure", "handleRequestAcquisitionResponse", "acquisition", "handleWildcardUserContentAssets", "hasValidLocalAcquisitions", "", "notifyFinish", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "requestAcquisition", "startRequest", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ProductAcquisition.kt */
    public static final class RequestHandler {
        private final AcquisitionRequest activeRequest;
        /* access modifiers changed from: private */
        public AvailabilityService availabilityService;
        private CheckAcquisitionsUseCase checkAcquisitionsUseCase;
        private DownloadsManagerService dlManagerService;
        private Function1<? super RequestHandler, Unit> finishedRequest;
        private GetProductAssetsUseCase getProductAssetsUseCase;
        private GetProductDetailsUseCase getProductDetailsUseCase;
        private final GetTigerBoxAccountUseCase getTigerBoxAccountUseCase;
        private RequestAcquisitionUseCase requestAcquisitionUseCase;
        private StorageService storageService;

        @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: ProductAcquisition.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[AcquisitionFinishAction.values().length];
                iArr[AcquisitionFinishAction.DOWNLOAD.ordinal()] = 1;
                iArr[AcquisitionFinishAction.NONE.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[AcquisitionReason.values().length];
                iArr2[AcquisitionReason.TIGERCARD.ordinal()] = 1;
                iArr2[AcquisitionReason.WILDCARD.ordinal()] = 2;
                iArr2[AcquisitionReason.WILDCARD_USER_CONTENT.ordinal()] = 3;
                iArr2[AcquisitionReason.MANUAL.ordinal()] = 4;
                iArr2[AcquisitionReason.WEBSERVER.ordinal()] = 5;
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public RequestHandler(AcquisitionRequest acquisitionRequest, DownloadsManagerService downloadsManagerService, StorageService storageService2, AvailabilityService availabilityService2, GetProductAssetsUseCase getProductAssetsUseCase2, GetProductDetailsUseCase getProductDetailsUseCase2, RequestAcquisitionUseCase requestAcquisitionUseCase2, CheckAcquisitionsUseCase checkAcquisitionsUseCase2, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2, Function1<? super RequestHandler, Unit> function1) {
            Intrinsics.checkNotNullParameter(acquisitionRequest, "activeRequest");
            Intrinsics.checkNotNullParameter(downloadsManagerService, "dlManagerService");
            Intrinsics.checkNotNullParameter(storageService2, "storageService");
            Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
            Intrinsics.checkNotNullParameter(getProductAssetsUseCase2, "getProductAssetsUseCase");
            Intrinsics.checkNotNullParameter(getProductDetailsUseCase2, "getProductDetailsUseCase");
            Intrinsics.checkNotNullParameter(requestAcquisitionUseCase2, "requestAcquisitionUseCase");
            Intrinsics.checkNotNullParameter(checkAcquisitionsUseCase2, "checkAcquisitionsUseCase");
            Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
            Intrinsics.checkNotNullParameter(function1, "finishedRequest");
            this.activeRequest = acquisitionRequest;
            this.dlManagerService = downloadsManagerService;
            this.storageService = storageService2;
            this.availabilityService = availabilityService2;
            this.getProductAssetsUseCase = getProductAssetsUseCase2;
            this.getProductDetailsUseCase = getProductDetailsUseCase2;
            this.requestAcquisitionUseCase = requestAcquisitionUseCase2;
            this.checkAcquisitionsUseCase = checkAcquisitionsUseCase2;
            this.getTigerBoxAccountUseCase = getTigerBoxAccountUseCase2;
            this.finishedRequest = function1;
        }

        public final AcquisitionRequest getActiveRequest() {
            return this.activeRequest;
        }

        public final void startRequest() {
            checkAcquisitionsIfNeededForActiveRequest();
        }

        private final boolean hasValidLocalAcquisitions(int i) {
            Date date = new Date();
            List<Acquisition> acquisitions = this.storageService.getAcquisitions(i);
            if (acquisitions == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (Acquisition acquisition : acquisitions) {
                try {
                    if (acquisition.getValidUntil() == null || Intrinsics.areEqual((Object) acquisition.getValidUntil(), (Object) "")) {
                        arrayList.add(acquisition);
                    } else if (DateUtilsKt.toDate(acquisition.getValidUntil(), "yyyy-MM-dd'T'HH:mm:ss").after(date)) {
                        arrayList.add(acquisition);
                    }
                } catch (Exception e) {
                    Timber.Forest forest = Timber.Forest;
                    forest.mo50217e("ProductAcquisition: could not validate validUntilDate " + acquisition.getValidUntil() + " message: " + e.getMessage(), new Object[0]);
                }
            }
            this.storageService.saveAcquisitions(i, arrayList);
            if (arrayList.size() > 0) {
                return true;
            }
            return false;
        }

        private final void checkAcquisitionsIfNeededForActiveRequest() {
            if (this.activeRequest.getReason() == AcquisitionReason.WILDCARD_USER_CONTENT) {
                handleWildcardUserContentAssets();
            } else if (hasValidLocalAcquisitions(this.activeRequest.getProductId()) || this.activeRequest.getReason() == AcquisitionReason.TIGERCARD) {
                getProductAssetsForActiveRequest();
            } else {
                this.checkAcquisitionsUseCase.invoke(new CheckAcquisitionsParameters(String.valueOf(this.getTigerBoxAccountUseCase.invoke().getUser().getAccountId()), String.valueOf(this.activeRequest.getProductId())), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new C2883x11a25fea(this));
            }
        }

        /* access modifiers changed from: private */
        public final void handleCheckAcquisitionFailure(Failure failure) {
            Timber.Tree tag = Timber.Forest.tag("ProductAcquisition");
            tag.mo50217e("handleCheckAcquisitionFailure: " + failure, new Object[0]);
            if (failure instanceof Failure.NetworkConnection) {
                notifyFinish(ProductAcquisitionService.ErrorCode.NO_WIFI);
            } else if (failure.getErrorCode() == 403) {
                notifyFinish(ProductAcquisitionService.ErrorCode.ACQUISITION_ERROR_410);
            } else {
                notifyFinish(ProductAcquisitionService.ErrorCode.IO_ERROR);
            }
        }

        /* access modifiers changed from: private */
        public final void handleCheckAcquisitionsResponse(List<Acquisition> list) {
            if (list.isEmpty()) {
                requestAcquisition(this.activeRequest.getProductId());
                return;
            }
            this.storageService.saveAcquisitions(this.activeRequest.getProductId(), list);
            getProductAssetsForActiveRequest();
        }

        private final void requestAcquisition(int i) {
            this.requestAcquisitionUseCase.invoke(new RequestAcquisitionParameters(this.getTigerBoxAccountUseCase.invoke().getUser().getAccountId(), i), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new ProductAcquisition$RequestHandler$requestAcquisition$1(this));
        }

        /* access modifiers changed from: private */
        public final void handleRequestAcquisitionFailure(Failure failure) {
            Timber.Tree tag = Timber.Forest.tag("ProductAcquisition");
            tag.mo50217e("handleRequestAcquisitionFailure: " + failure, new Object[0]);
            if (failure instanceof Failure.NetworkConnection) {
                notifyFinish(ProductAcquisitionService.ErrorCode.NO_WIFI);
            } else if (failure.getErrorCode() == 403) {
                notifyFinish(ProductAcquisitionService.ErrorCode.ACQUISITION_ERROR_410);
            } else {
                notifyFinish(ProductAcquisitionService.ErrorCode.IO_ERROR);
            }
        }

        /* access modifiers changed from: private */
        public final void handleRequestAcquisitionResponse(Acquisition acquisition) {
            Integer productId = acquisition.getProductId();
            int productId2 = this.activeRequest.getProductId();
            if (productId != null && productId.intValue() == productId2) {
                this.storageService.saveAcquisitions(this.activeRequest.getProductId(), CollectionsKt.listOf(acquisition));
                getProductAssetsForActiveRequest();
                return;
            }
            Timber.Forest.tag("ProductAcquisition").mo50214d("handleRequestAcquisitionResponse - invalid acquisition", new Object[0]);
            notifyFinish(ProductAcquisitionService.ErrorCode.ACQUISITION_ERROR_410);
        }

        private final void getProductAssetsForActiveRequest() {
            String str;
            String code;
            if (AvailabilityService.DefaultImpls.offlineAvailabilityStateFor$default(this.availabilityService, this.activeRequest.getProductId(), false, 2, (Object) null) == OfflineAvailabilityState.AVAILABLE) {
                int i = WhenMappings.$EnumSwitchMapping$0[this.activeRequest.getFinishActionType().ordinal()];
                if (i == 1 || i == 2) {
                    notifyFinish((ProductAcquisitionService.ErrorCode) null);
                    return;
                }
                return;
            }
            GetProductAssetsUseCase getProductAssetsUseCase2 = this.getProductAssetsUseCase;
            String valueOf = String.valueOf(this.activeRequest.getProductId());
            TigerCardDomain tigerCardDomain = this.activeRequest.getTigerCardDomain();
            String str2 = "";
            if (tigerCardDomain == null || (str = tigerCardDomain.getUid()) == null) {
                str = str2;
            }
            TigerCardDomain tigerCardDomain2 = this.activeRequest.getTigerCardDomain();
            if (!(tigerCardDomain2 == null || (code = tigerCardDomain2.getCode()) == null)) {
                str2 = code;
            }
            getProductAssetsUseCase2.invoke(new GetProductAssetsParameters(valueOf, str, str2), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new C2886x33c9b12c(this));
        }

        /* access modifiers changed from: private */
        public final void handleGetProductAssetsFailure(Failure failure) {
            Timber.Tree tag = Timber.Forest.tag("ProductAcquisition");
            tag.mo50217e("handleGetProductAssetsFailure: " + failure, new Object[0]);
            if (failure instanceof Failure.NetworkConnection) {
                notifyFinish(ProductAcquisitionService.ErrorCode.NO_WIFI);
            } else if (failure.getException() instanceof IOException) {
                notifyFinish(ProductAcquisitionService.ErrorCode.IO_ERROR);
            } else {
                notifyFinish(ProductAcquisitionService.ErrorCode.ACQUISITION_ERROR_GET_PRODUCT_ASSET);
            }
        }

        private final void handleWildcardUserContentAssets() {
            TigerCardDomain.AccountGeneratedContentsDomain wildcardUserContent;
            TigerCardDomain tigerCardDomain = this.activeRequest.getTigerCardDomain();
            if (tigerCardDomain != null && (wildcardUserContent = tigerCardDomain.getWildcardUserContent()) != null) {
                if (this.availabilityService.isOldWildcardContent(this.activeRequest.getProductId(), wildcardUserContent.getLastModifiedDate())) {
                    this.availabilityService.removeProduct(this.activeRequest.getProductId());
                    List arrayList = new ArrayList();
                    String pathForProduct = this.availabilityService.pathForProduct(this.activeRequest.getProductId());
                    String substringAfterLast$default = StringsKt.substringAfterLast$default(wildcardUserContent.getCoverLink(), DownloadsManager.EXTENSION_SEPARATOR, (String) null, 2, (Object) null);
                    String appendingPathComponent = FileUtilsKt.appendingPathComponent(pathForProduct, "cover." + substringAfterLast$default);
                    arrayList.add(new DownloadsManagerService.FileDownloadInfo(wildcardUserContent.getCoverLink(), appendingPathComponent));
                    String appendingPathComponent2 = FileUtilsKt.appendingPathComponent(pathForProduct, "content/hls_playlist.m3u");
                    arrayList.add(new DownloadsManagerService.FileDownloadInfo(wildcardUserContent.getPlaylistLink(), appendingPathComponent2));
                    DownloadsManagerService.DefaultImpls.downloadFiles$default(this.dlManagerService, arrayList, (Function0) null, new C2891xf10cfa86(this, appendingPathComponent2, appendingPathComponent, wildcardUserContent), 2, (Object) null);
                    return;
                }
                handleFinishAction();
            }
        }

        /* access modifiers changed from: private */
        public final void handleFinishAction() {
            if (WhenMappings.$EnumSwitchMapping$0[this.activeRequest.getFinishActionType().ordinal()] == 1) {
                downloadProduct();
            }
            notifyFinish((ProductAcquisitionService.ErrorCode) null);
        }

        /* access modifiers changed from: private */
        public final void handleProductAssets(List<AssetProduct> list) {
            List arrayList = new ArrayList();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            String pathForProduct = this.availabilityService.pathForProduct(this.activeRequest.getProductId());
            for (AssetProduct next : list) {
                String str = null;
                if (Intrinsics.areEqual((Object) next.getAssetProductType(), (Object) "COVER")) {
                    AssetProduct.ContentLocation contentLocation = next.getContentLocation();
                    String location = contentLocation != null ? contentLocation.getLocation() : null;
                    if (location == null) {
                        location = "";
                    }
                    String substringAfterLast$default = StringsKt.substringAfterLast$default(location, DownloadsManager.EXTENSION_SEPARATOR, (String) null, 2, (Object) null);
                    objectRef.element = FileUtilsKt.appendingPathComponent(pathForProduct, "cover." + substringAfterLast$default);
                    AssetProduct.ContentLocation contentLocation2 = next.getContentLocation();
                    String location2 = contentLocation2 != null ? contentLocation2.getLocation() : null;
                    if (location2 == null) {
                        location2 = "";
                    }
                    arrayList.add(new DownloadsManagerService.FileDownloadInfo(location2, (String) objectRef.element));
                }
                if (Intrinsics.areEqual((Object) next.getAssetProductType(), (Object) "HLS")) {
                    objectRef2.element = FileUtilsKt.appendingPathComponent(pathForProduct, "content/hls_playlist.m3u");
                    AssetProduct.ContentLocation contentLocation3 = next.getContentLocation();
                    if (contentLocation3 != null) {
                        str = contentLocation3.getLocation();
                    }
                    if (str == null) {
                        str = "";
                    }
                    arrayList.add(new DownloadsManagerService.FileDownloadInfo(str, (String) objectRef2.element));
                }
            }
            DownloadsManagerService.DefaultImpls.downloadFiles$default(this.dlManagerService, arrayList, (Function0) null, new ProductAcquisition$RequestHandler$handleProductAssets$1(this, objectRef2, objectRef), 2, (Object) null);
        }

        /* access modifiers changed from: private */
        public final void handleProductDetails(int i) {
            this.getProductDetailsUseCase.invoke(new GetProductDetailsParameters(String.valueOf(i)), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new ProductAcquisition$RequestHandler$handleProductDetails$1(this));
        }

        /* access modifiers changed from: private */
        public final void handleProductDetails(ProductDetails productDetails) {
            if (productDetails != null) {
                this.availabilityService.flushProductDetails(productDetails);
            }
            handleFinishAction();
        }

        /* access modifiers changed from: private */
        public final void handleGetProductDetailsFailure(Failure failure) {
            if (failure instanceof Failure.NetworkConnection) {
                notifyFinish(ProductAcquisitionService.ErrorCode.NO_WIFI);
            } else {
                handleFinishAction();
            }
        }

        private final void downloadProduct() {
            DownloadReason downloadReason;
            ProductAcquisitionDelegate delegate = this.activeRequest.getDelegate();
            boolean z = false;
            if (delegate != null && !delegate.shouldExecuteAcquisitionAction()) {
                z = true;
            }
            if (!z) {
                int i = WhenMappings.$EnumSwitchMapping$1[this.activeRequest.getReason().ordinal()];
                if (i == 1) {
                    downloadReason = DownloadReason.AUTOMATIC_BY_NFC_CARD;
                } else if (i == 2) {
                    downloadReason = DownloadReason.AUTOMATIC_BY_NFC_CARD;
                } else if (i == 3) {
                    downloadReason = DownloadReason.AUTOMATIC_BY_NFC_CARD;
                } else if (i == 4) {
                    downloadReason = DownloadReason.MANUAL;
                } else if (i == 5) {
                    downloadReason = DownloadReason.WEBSERVER_INITIATED;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                this.availabilityService.downloadAudioProduct(this.activeRequest.getProductId(), this.activeRequest.getTigerCardDomain(), downloadReason);
            }
        }

        /* access modifiers changed from: private */
        public final void notifyFinish(ProductAcquisitionService.ErrorCode errorCode) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new ProductAcquisition$RequestHandler$notifyFinish$1(this, errorCode, (Continuation<? super ProductAcquisition$RequestHandler$notifyFinish$1>) null), 3, (Object) null);
            this.finishedRequest.invoke(this);
        }
    }
}
