package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(mo33736d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0017\u0018Jf\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b28\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\rH&J\\\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b28\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\rH&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "", "checkProduct", "", "productId", "", "reason", "Lmedia/tiger/tigerbox/services/interfaces/AcquisitionReason;", "tigerCardDomain", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "delegate", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionDelegate;", "onStep", "Lkotlin/Function2;", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$StepType;", "Lkotlin/ParameterName;", "name", "step", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "error", "downloadProduct", "isDownloadAcquisitionInProgress", "", "ErrorCode", "StepType", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProductAcquisitionService.kt */
public interface ProductAcquisitionService {

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "", "(Ljava/lang/String;I)V", "ACQUISITION_ERROR_410", "ACQUISITION_ERROR_GET_PRODUCT_ASSET", "ACQUISITION_ERROR_GET_WILDCARD_USER_CONTENT_ASSETS", "NO_WIFI", "IO_ERROR", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ProductAcquisitionService.kt */
    public enum ErrorCode {
        ACQUISITION_ERROR_410,
        ACQUISITION_ERROR_GET_PRODUCT_ASSET,
        ACQUISITION_ERROR_GET_WILDCARD_USER_CONTENT_ASSETS,
        NO_WIFI,
        IO_ERROR
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$StepType;", "", "(Ljava/lang/String;I)V", "ACQUISITION_STARTED", "ACQUISITION_FINISHED", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ProductAcquisitionService.kt */
    public enum StepType {
        ACQUISITION_STARTED,
        ACQUISITION_FINISHED
    }

    void checkProduct(int i, AcquisitionReason acquisitionReason, TigerCardDomain tigerCardDomain, ProductAcquisitionDelegate productAcquisitionDelegate, Function2<? super StepType, ? super ErrorCode, Unit> function2);

    void downloadProduct(int i, AcquisitionReason acquisitionReason, ProductAcquisitionDelegate productAcquisitionDelegate, Function2<? super StepType, ? super ErrorCode, Unit> function2);

    boolean isDownloadAcquisitionInProgress(int i);
}
