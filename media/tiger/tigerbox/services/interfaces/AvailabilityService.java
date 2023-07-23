package media.tiger.tigerbox.services.interfaces;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import media.tiger.tigerbox.model.domain.DownloadReason;
import media.tiger.tigerbox.model.domain.OfflineAvailabilityState;
import media.tiger.tigerbox.model.domain.ProductDetails;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J;\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00110\u0015H&J\u0019\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H&J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\rH&J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020&H&J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020\u0007H&J\b\u0010,\u001a\u00020\u0007H&J\b\u0010-\u001a\u00020\u0007H&J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010/\u001a\u000200H&J\u0010\u00101\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u00102\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001a\u00103\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u0007H&J\u0010\u00106\u001a\u0002002\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u00107\u001a\u0002002\u0006\u0010(\u001a\u00020\u000fH&J\u001a\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u0007H&J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010=\u001a\u00020\u00112\u0006\u00109\u001a\u00020:H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "", "availableBytes", "", "getAvailableBytes", "()J", "downloadsInProgress", "", "getDownloadsInProgress", "()Z", "totalBytes", "getTotalBytes", "audioProductInfoForProductId", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "productId", "", "changeDownloadReasonForProduct", "", "reason", "Lmedia/tiger/tigerbox/model/domain/DownloadReason;", "onDone", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "deleteAllDownloadedProducts", "type", "Lmedia/tiger/tigerbox/services/interfaces/DeleteType;", "(Lmedia/tiger/tigerbox/services/interfaces/DeleteType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAudioProduct", "nfcPayload", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "downloadedProducts", "", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "flushAudioProductInfoToDisk", "info", "flushProductDetails", "Lmedia/tiger/tigerbox/model/domain/ProductDetails;", "flushWildcardUserContentInfo", "wildcardUserContentId", "userContent", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$AccountGeneratedContentsDomain;", "freeSpaceForUpdateIfNeeded", "hasAvailableSpaceForDownloads", "hasAvailableSpaceForUpdate", "isOldWildcardContent", "modificationDate", "", "noteProductWasUsed", "offlineAvailabilityReason", "offlineAvailabilityStateFor", "Lmedia/tiger/tigerbox/model/domain/OfflineAvailabilityState;", "checkCurrentProfileOnly", "pathForProduct", "pathForWildcardUserContentInfo", "registerListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityListener;", "notifyOnceOnRegister", "removeProduct", "unregisterListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AvailabilityService.kt */
public interface AvailabilityService {
    AudioProductInfo audioProductInfoForProductId(int i);

    void changeDownloadReasonForProduct(int i, DownloadReason downloadReason, Function1<? super Boolean, Unit> function1);

    Object deleteAllDownloadedProducts(DeleteType deleteType, Continuation<? super Unit> continuation);

    void downloadAudioProduct(int i, TigerCardDomain tigerCardDomain, DownloadReason downloadReason);

    List<ProductDomain> downloadedProducts();

    void flushAudioProductInfoToDisk(AudioProductInfo audioProductInfo);

    void flushProductDetails(ProductDetails productDetails);

    void flushWildcardUserContentInfo(int i, TigerCardDomain.AccountGeneratedContentsDomain accountGeneratedContentsDomain);

    boolean freeSpaceForUpdateIfNeeded();

    long getAvailableBytes();

    boolean getDownloadsInProgress();

    long getTotalBytes();

    boolean hasAvailableSpaceForDownloads();

    boolean hasAvailableSpaceForUpdate();

    boolean isOldWildcardContent(int i, String str);

    void noteProductWasUsed(int i);

    DownloadReason offlineAvailabilityReason(int i);

    OfflineAvailabilityState offlineAvailabilityStateFor(int i, boolean z);

    String pathForProduct(int i);

    String pathForWildcardUserContentInfo(int i);

    void registerListener(AvailabilityListener availabilityListener, boolean z);

    boolean removeProduct(int i);

    void unregisterListener(AvailabilityListener availabilityListener);

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AvailabilityService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ OfflineAvailabilityState offlineAvailabilityStateFor$default(AvailabilityService availabilityService, int i, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = false;
                }
                return availabilityService.offlineAvailabilityStateFor(i, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offlineAvailabilityStateFor");
        }

        public static /* synthetic */ void registerListener$default(AvailabilityService availabilityService, AvailabilityListener availabilityListener, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                availabilityService.registerListener(availabilityListener, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerListener");
        }
    }
}
