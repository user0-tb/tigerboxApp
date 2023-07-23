package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p013io.FilesKt;
import kotlin.p013io.TextStreamsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.model.domain.DownloadReason;
import media.tiger.tigerbox.model.domain.OfflineAvailabilityState;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.model.domain.ProductSource;
import media.tiger.tigerbox.services.implementations.audioPlayer.AudioItemImpl;
import media.tiger.tigerbox.services.interfaces.AvailabilityListener;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.DeleteType;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEvent;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEventKt;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.WakeService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel;
import media.tiger.tigerbox.services.interfaces.audioPlayer.HlsKeyProviderService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import media.tiger.tigerbox.utils.FileUtils;
import media.tiger.tigerbox.utils.FileUtilsKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0016H\u0002J\u0018\u00106\u001a\u0002042\u0006\u00105\u001a\u00020\u00162\u0006\u00107\u001a\u00020#H\u0002J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0016J\u0012\u0010<\u001a\u00020=2\b\b\u0002\u00107\u001a\u00020#H\u0002J;\u0010>\u001a\u00020=2\u0006\u0010:\u001a\u00020;2\u0006\u0010?\u001a\u00020@2!\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020=0BH\u0016J\b\u0010F\u001a\u00020=H\u0002J\u0019\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020IH@ø\u0001\u0000¢\u0006\u0002\u0010JJ\"\u0010K\u001a\u00020=2\u0006\u0010:\u001a\u00020;2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010?\u001a\u00020@H\u0016J\u001e\u0010N\u001a\u00020=2\u0006\u00105\u001a\u00020\u00162\f\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PH\u0002J\u001e\u0010R\u001a\u00020=2\u0006\u00105\u001a\u00020\u00162\f\u0010S\u001a\b\u0012\u0004\u0012\u00020Q0PH\u0002J\u0018\u0010T\u001a\b\u0012\u0004\u0012\u0002090P2\b\b\u0002\u00107\u001a\u00020#H\u0002J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020V0PH\u0016J\u0010\u0010W\u001a\u00020=2\u0006\u00105\u001a\u00020\u0016H\u0002J\u0010\u0010X\u001a\u0002042\u0006\u00105\u001a\u00020\u0016H\u0002J\u0010\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u000209H\u0016J\u0010\u0010[\u001a\u00020=2\u0006\u0010Z\u001a\u00020\\H\u0016J\u0018\u0010]\u001a\u00020=2\u0006\u0010^\u001a\u00020;2\u0006\u0010_\u001a\u00020`H\u0016J\u0016\u0010a\u001a\u00020\u001a2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001a0cH\u0002J\b\u0010d\u001a\u00020\u001aH\u0016J\b\u0010e\u001a\u00020\u001aH\u0002J\u0010\u0010f\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020hH\u0002J\u0010\u0010i\u001a\u00020\u001f2\u0006\u0010j\u001a\u00020hH\u0002J\u0010\u0010k\u001a\u00020\u001f2\u0006\u0010j\u001a\u00020hH\u0002J\b\u0010l\u001a\u00020\u001aH\u0016J\b\u0010m\u001a\u00020\u001aH\u0016J\u0010\u0010n\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010o\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010p\u001a\u00020\u001a2\u0006\u0010q\u001a\u00020#H\u0002J\u0018\u0010r\u001a\u00020\u001a2\u0006\u0010^\u001a\u00020;2\u0006\u0010s\u001a\u00020#H\u0016J\u0010\u0010t\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020;H\u0002J\u0018\u0010u\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020;2\u0006\u00107\u001a\u00020#H\u0002J\u0010\u0010v\u001a\u00020=2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010w\u001a\u00020@2\u0006\u0010:\u001a\u00020;H\u0016J\u0018\u0010x\u001a\u00020y2\u0006\u0010:\u001a\u00020;2\u0006\u0010z\u001a\u00020\u001aH\u0016J$\u0010{\u001a\b\u0012\u0004\u0012\u00020Q0P2\u0006\u00105\u001a\u00020\u00162\f\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PH\u0002J\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020Q0P2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PH\u0002J\u0010\u0010}\u001a\u00020#2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010~\u001a\u00020#2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010\u001a\u00020#2\u0006\u0010:\u001a\u00020;H\u0002J\u0019\u0010\u0001\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u00107\u001a\u00020#H\u0002J\u0011\u0010\u0001\u001a\u00020#2\u0006\u0010^\u001a\u00020;H\u0016J\u0019\u0010\u0001\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020;2\u0006\u00107\u001a\u00020#H\u0002J\u001a\u0010\u0001\u001a\u00020=2\u0006\u00105\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020;H\u0002J\u0011\u0010\u0001\u001a\u00020=2\u0006\u0010:\u001a\u00020;H\u0002J\u001a\u0010\u0001\u001a\u00020=2\u0006\u0010:\u001a\u00020;2\u0007\u0010\u0001\u001a\u00020;H\u0002J\t\u0010\u0001\u001a\u000204H\u0002J\t\u0010\u0001\u001a\u000204H\u0002J\u001b\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020\u001aH\u0016J\u0011\u0010\u0001\u001a\u0002042\u0006\u00105\u001a\u00020\u0016H\u0002J\u0011\u0010\u0001\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020;H\u0016J\u0019\u0010\u0001\u001a\u00020=2\u0006\u0010:\u001a\u00020;2\u0006\u00107\u001a\u00020#H\u0002J\u0011\u0010\u0001\u001a\u0002042\u0006\u00105\u001a\u00020\u0016H\u0002J\u001c\u0010\u0001\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020;2\t\b\u0002\u0010\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020-H\u0016J\t\u0010\u0001\u001a\u00020=H\u0002J\t\u0010\u0001\u001a\u00020=H\u0002J\r\u0010\u0001\u001a\u00020\u001a*\u00020hH\u0002R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010!R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010!R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/Availability;", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "dlService", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "sharedPreferences", "Landroid/content/SharedPreferences;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "hlsService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;", "lightControlService", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "wakeService", "Lmedia/tiger/tigerbox/services/interfaces/WakeService;", "fileUtils", "Lmedia/tiger/tigerbox/utils/FileUtils;", "(Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService;Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;Landroid/content/SharedPreferences;Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;Lmedia/tiger/tigerbox/services/interfaces/LightControlService;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Lmedia/tiger/tigerbox/services/interfaces/WakeService;Lmedia/tiger/tigerbox/utils/FileUtils;)V", "_activeAudioDownload", "Lmedia/tiger/tigerbox/services/implementations/Availability$AudioDownload;", "_audioDownloadsInProgress", "", "_downloadsInProgress", "", "audioDownloadsInProgress", "getAudioDownloadsInProgress", "()Ljava/util/List;", "availableBytes", "", "getAvailableBytes", "()J", "currentProfileId", "", "getCurrentProfileId", "()Ljava/lang/String;", "downloadsInProgress", "getDownloadsInProgress", "()Z", "freeMemoryBytes", "getFreeMemoryBytes", "listeners", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityListener;", "Lkotlin/collections/ArrayList;", "tigerCardsUsedSpace", "getTigerCardsUsedSpace", "totalBytes", "getTotalBytes", "addAudioDownload", "Lkotlinx/coroutines/Job;", "download", "addProfileToAudioProductFolder", "profile", "audioProductInfoForProductId", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "productId", "", "cancelAllDownloadsInProgress", "", "changeDownloadReasonForProduct", "reason", "Lmedia/tiger/tigerbox/model/domain/DownloadReason;", "onDone", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "checkPendingDownloads", "deleteAllDownloadedProducts", "type", "Lmedia/tiger/tigerbox/services/interfaces/DeleteType;", "(Lmedia/tiger/tigerbox/services/interfaces/DeleteType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAudioProduct", "nfcPayload", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "downloadEncodingPlaylists", "m3u8List", "", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService$FileDownloadInfo;", "downloadTsFiles", "tsList", "downloadedAudioProducts", "downloadedProducts", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "failAudioDownload", "finishAudioDownload", "flushAudioProductInfoToDisk", "info", "flushProductDetails", "Lmedia/tiger/tigerbox/model/domain/ProductDetails;", "flushWildcardUserContentInfo", "wildcardUserContentId", "userContent", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain$AccountGeneratedContentsDomain;", "freeSpaceBasedOnTestUnit", "testUnit", "Lkotlin/Function0;", "freeSpaceForUpdateIfNeeded", "freeSpaceIfNeeded", "getFolderSize", "f", "Ljava/io/File;", "getFreeMemory", "path", "getTotalMemory", "hasAvailableSpaceForDownloads", "hasAvailableSpaceForUpdate", "isDownloaded", "isDownloading", "isDownloadingForProductFolderInProgress", "id", "isOldWildcardContent", "modificationDate", "isProductFolderBelongingToAnyNonDefaultProfile", "isProductFolderBelongingToProfile", "noteProductWasUsed", "offlineAvailabilityReason", "offlineAvailabilityStateFor", "Lmedia/tiger/tigerbox/model/domain/OfflineAvailabilityState;", "checkCurrentProfileOnly", "parseEncodingPlaylists", "parseM3U8s", "pathForAudioProductInfo", "pathForProduct", "pathForProductDetails", "pathForProductProfileFile", "pathForWildcardUserContentInfo", "productFolderBelongsToProfile", "progressAudioDownload", "percent", "publishDidFailDownloadingProduct", "publishDidProgressDownloadingProduct", "publishDownloadedProductsDidChange", "publishDownloadsInProgressDidChange", "registerListener", "listener", "notifyOnceOnRegister", "removeAudioDownloadFromQueue", "removeProduct", "removeProfileFromAudioProductFolder", "startAudioDownload", "touchProductInfo", "time", "unregisterListener", "updateAudioDownloadLocalStorage", "updateDownloadsInProgress", "deleteFileOrDirectory", "AudioDownload", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Availability.kt */
public final class Availability implements AvailabilityService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_PROFILE = "default";
    private static final String DOWNLOADS_IN_PROGRESS_KEY = "audioDownloadsInProgress";
    private static final int FILE_TOUCH_DELAY = 1000;
    private static final String PRODUCT_CONTENT_INFO = "info.json";
    private static final String PRODUCT_CONTENT_READY_ID = "content.ready";
    private static final String PRODUCT_DETAILS_INFO = "details.json";
    private static final String PROFILE_EXTENSION = "profile";
    private static final long REQ_MIN_FREE_SPACE_BYTES = 209715200;
    private static final long UPDATE_REQ_FREE_SPACE_BYTES = 681574400;
    private static final String WILDCARD_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String WILDCARD_USER_CONTENT_INFO = "wildcard_user_content.json";
    /* access modifiers changed from: private */
    public AudioDownload _activeAudioDownload;
    private List<AudioDownload> _audioDownloadsInProgress;
    private boolean _downloadsInProgress;
    /* access modifiers changed from: private */
    public final DownloadsManagerService dlService;
    private final FileUtils fileUtils;
    private GetTigerBoxAccountUseCase getTigerBoxAccountUseCase;
    /* access modifiers changed from: private */
    public final HlsKeyProviderService hlsService;
    private final LightControlService lightControlService;
    /* access modifiers changed from: private */
    public ArrayList<AvailabilityListener> listeners = new ArrayList<>();
    private final SharedPreferences sharedPreferences;
    /* access modifiers changed from: private */
    public final TimeService timeService;
    /* access modifiers changed from: private */
    public final WakeService wakeService;
    private final WifiService wifiService;

    /* access modifiers changed from: private */
    public final void progressAudioDownload(AudioDownload audioDownload, int i) {
    }

    /* access modifiers changed from: private */
    public final void publishDidProgressDownloadingProduct(int i, int i2) {
    }

    public Availability(DownloadsManagerService downloadsManagerService, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2, SharedPreferences sharedPreferences2, WifiService wifiService2, HlsKeyProviderService hlsKeyProviderService, LightControlService lightControlService2, TimeService timeService2, WakeService wakeService2, FileUtils fileUtils2) {
        Intrinsics.checkNotNullParameter(downloadsManagerService, "dlService");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(hlsKeyProviderService, "hlsService");
        Intrinsics.checkNotNullParameter(lightControlService2, "lightControlService");
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        Intrinsics.checkNotNullParameter(wakeService2, "wakeService");
        Intrinsics.checkNotNullParameter(fileUtils2, "fileUtils");
        this.dlService = downloadsManagerService;
        this.getTigerBoxAccountUseCase = getTigerBoxAccountUseCase2;
        this.sharedPreferences = sharedPreferences2;
        this.wifiService = wifiService2;
        this.hlsService = hlsKeyProviderService;
        this.lightControlService = lightControlService2;
        this.timeService = timeService2;
        this.wakeService = wakeService2;
        this.fileUtils = fileUtils2;
        checkPendingDownloads();
        wifiService2.getOfflineMode().observeForever(new Availability$$ExternalSyntheticLambda0(this));
    }

    private final long getFreeMemory(File file) throws IllegalArgumentException {
        return new StatFs(file.getAbsolutePath()).getAvailableBytes();
    }

    private final long getTotalMemory(File file) {
        return new StatFs(file.getAbsolutePath()).getTotalBytes();
    }

    private final long getFreeMemoryBytes() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            Intrinsics.checkNotNullExpressionValue(dataDirectory, "getDataDirectory()");
            return getFreeMemory(dataDirectory);
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("Availability: availableBytes exception " + e, new Object[0]);
            return 0;
        }
    }

    public long getAvailableBytes() {
        return Math.max(0, getFreeMemoryBytes() - REQ_MIN_FREE_SPACE_BYTES);
    }

    public long getTotalBytes() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            Intrinsics.checkNotNullExpressionValue(dataDirectory, "getDataDirectory()");
            return getTotalMemory(dataDirectory);
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("Availability: totalBytes exception " + e, new Object[0]);
            return 0;
        }
    }

    private final long getFolderSize(File file) {
        long j = 0;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            Intrinsics.checkNotNullExpressionValue(file2, "file");
            j += getFolderSize(file2);
        }
        return j;
    }

    private final long getTigerCardsUsedSpace() {
        long j = 0;
        for (AudioProductInfo audioProductInfo : downloadedAudioProducts$default(this, (String) null, 1, (Object) null)) {
            if (audioProductInfo.getDownloadReason() == DownloadReason.AUTOMATIC_BY_NFC_CARD) {
                j += getFolderSize(new File(pathForProduct(audioProductInfo.getId())));
            }
        }
        return j;
    }

    public boolean freeSpaceForUpdateIfNeeded() {
        return freeSpaceBasedOnTestUnit(new Availability$freeSpaceForUpdateIfNeeded$1(this));
    }

    public boolean hasAvailableSpaceForUpdate() {
        return getFreeMemoryBytes() > UPDATE_REQ_FREE_SPACE_BYTES;
    }

    /* access modifiers changed from: private */
    public final boolean freeSpaceIfNeeded() {
        return freeSpaceBasedOnTestUnit(new Availability$freeSpaceIfNeeded$1(this));
    }

    public boolean hasAvailableSpaceForDownloads() {
        return getFreeMemoryBytes() > REQ_MIN_FREE_SPACE_BYTES;
    }

    private final boolean freeSpaceBasedOnTestUnit(Function0<Boolean> function0) {
        if (function0.invoke().booleanValue()) {
            return false;
        }
        boolean z = false;
        for (AudioProductInfo audioProductInfo : CollectionsKt.reversed(downloadedAudioProducts$default(this, (String) null, 1, (Object) null))) {
            if (function0.invoke().booleanValue()) {
                break;
            } else if (audioProductInfo.getDownloadReason() != DownloadReason.AUTOMATIC_BY_NFC_CARD || ((double) getTigerCardsUsedSpace()) >= ((double) getTotalBytes()) * 0.15d) {
                File file = new File(pathForProduct(audioProductInfo.getId()));
                if (deleteFileOrDirectory(file)) {
                    Timber.Forest forest = Timber.Forest;
                    forest.mo50221i("Did delete product folder " + file + " to make space.", new Object[0]);
                    z = true;
                }
            }
        }
        return z;
    }

    public Object deleteAllDownloadedProducts(DeleteType deleteType, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new Availability$deleteAllDownloadedProducts$2(deleteType, this, (Continuation<? super Availability$deleteAllDownloadedProducts$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final boolean isDownloaded(int i) {
        return new File(pathForProduct(i) + "/content.ready").exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f A[SYNTHETIC, Splitter:B:20:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A[SYNTHETIC, Splitter:B:23:0x0075] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public media.tiger.tigerbox.model.domain.DownloadReason offlineAvailabilityReason(int r6) {
        /*
            r5 = this;
            java.lang.String r6 = r5.pathForProduct(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = "/info.json"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            media.tiger.tigerbox.model.domain.DownloadReason r6 = media.tiger.tigerbox.model.domain.DownloadReason.NONE
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0079
            r1 = 0
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0053 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0053 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0053 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0053 }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ Exception -> 0x0053 }
            r3.<init>(r4, r2)     // Catch:{ Exception -> 0x0053 }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r0.<init>()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r1 = r3
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.lang.Class<media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo> r2 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo.class
            java.lang.Object r0 = r0.fromJson((java.io.Reader) r1, r2)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r0 = (media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo) r0     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            if (r0 == 0) goto L_0x0047
            media.tiger.tigerbox.model.domain.DownloadReason r6 = r0.getDownloadReason()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
        L_0x0047:
            r3.close()     // Catch:{ Exception -> 0x0079 }
            goto L_0x0079
        L_0x004b:
            r6 = move-exception
            r1 = r3
            goto L_0x0073
        L_0x004e:
            r0 = move-exception
            r1 = r3
            goto L_0x0054
        L_0x0051:
            r6 = move-exception
            goto L_0x0073
        L_0x0053:
            r0 = move-exception
        L_0x0054:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r3.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = "Availability: Exception reading download reason from product info "
            r3.append(r4)     // Catch:{ all -> 0x0051 }
            r3.append(r0)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0051 }
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0051 }
            r2.mo50217e(r0, r3)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ Exception -> 0x0079 }
            goto L_0x0079
        L_0x0073:
            if (r1 == 0) goto L_0x0078
            r1.close()     // Catch:{ Exception -> 0x0078 }
        L_0x0078:
            throw r6
        L_0x0079:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability.offlineAvailabilityReason(int):media.tiger.tigerbox.model.domain.DownloadReason");
    }

    static /* synthetic */ List downloadedAudioProducts$default(Availability availability, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return availability.downloadedAudioProducts(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e2 A[SYNTHETIC, Splitter:B:31:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo> downloadedAudioProducts(java.lang.String r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.File r1 = new java.io.File
            media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService r2 = r11.dlService
            java.lang.String r2 = r2.getDownloadsFolder()
            r1.<init>(r2)
            java.lang.String[] r1 = r1.list()
            if (r1 == 0) goto L_0x00ea
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0019:
            if (r4 >= r2) goto L_0x00ea
            r5 = r1[r4]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService r7 = r11.dlService
            java.lang.String r7 = r7.getDownloadsFolder()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.io.File r7 = new java.io.File
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            java.lang.String r9 = "/content.ready"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            boolean r7 = r7.exists()
            java.lang.String r8 = "it"
            if (r7 != 0) goto L_0x0059
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            boolean r7 = r11.isDownloadingForProductFolderInProgress(r5)
            if (r7 == 0) goto L_0x00e6
        L_0x0059:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            int r5 = java.lang.Integer.parseInt(r5)
            boolean r5 = r11.productFolderBelongsToProfile(r5, r12)
            if (r5 == 0) goto L_0x00e6
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r6)
            java.lang.String r6 = "/info.json"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            boolean r5 = r6.exists()
            if (r5 == 0) goto L_0x00e6
            r5 = 0
            java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            r9.<init>(r6)     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            java.io.InputStream r9 = (java.io.InputStream) r9     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            r8.<init>(r9, r7)     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ Exception -> 0x00bc }
            r5.<init>()     // Catch:{ Exception -> 0x00bc }
            r7 = r8
            java.io.Reader r7 = (java.io.Reader) r7     // Catch:{ Exception -> 0x00bc }
            java.lang.Class<media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo> r9 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo.class
            java.lang.Object r5 = r5.fromJson((java.io.Reader) r7, r9)     // Catch:{ Exception -> 0x00bc }
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r5 = (media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo) r5     // Catch:{ Exception -> 0x00bc }
            if (r5 == 0) goto L_0x00b8
            java.lang.String r7 = "product"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)     // Catch:{ Exception -> 0x00bc }
            kotlin.Pair r7 = new kotlin.Pair     // Catch:{ Exception -> 0x00bc }
            long r9 = r6.lastModified()     // Catch:{ Exception -> 0x00bc }
            java.lang.Long r6 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x00bc }
            r7.<init>(r6, r5)     // Catch:{ Exception -> 0x00bc }
            r0.add(r7)     // Catch:{ Exception -> 0x00bc }
        L_0x00b8:
            r8.close()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00e6
        L_0x00bc:
            r5 = move-exception
            goto L_0x00c3
        L_0x00be:
            r12 = move-exception
            goto L_0x00e0
        L_0x00c0:
            r6 = move-exception
            r8 = r5
            r5 = r6
        L_0x00c3:
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest     // Catch:{ all -> 0x00de }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00de }
            r7.<init>()     // Catch:{ all -> 0x00de }
            java.lang.String r9 = "Availability: Exception reading product info "
            r7.append(r9)     // Catch:{ all -> 0x00de }
            r7.append(r5)     // Catch:{ all -> 0x00de }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x00de }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ all -> 0x00de }
            r6.mo50217e(r5, r7)     // Catch:{ all -> 0x00de }
            if (r8 == 0) goto L_0x00e6
            goto L_0x00b8
        L_0x00de:
            r12 = move-exception
            r5 = r8
        L_0x00e0:
            if (r5 == 0) goto L_0x00e5
            r5.close()     // Catch:{ Exception -> 0x00e5 }
        L_0x00e5:
            throw r12
        L_0x00e6:
            int r4 = r4 + 1
            goto L_0x0019
        L_0x00ea:
            r12 = r0
            java.util.List r12 = (java.util.List) r12
            media.tiger.tigerbox.services.implementations.Availability$downloadedAudioProducts$$inlined$compareByDescending$1 r1 = new media.tiger.tigerbox.services.implementations.Availability$downloadedAudioProducts$$inlined$compareByDescending$1
            r1.<init>()
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r12, r1)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r0 = r0.iterator()
        L_0x0102:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0116
            java.lang.Object r1 = r0.next()
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r1 = r1.getSecond()
            r12.add(r1)
            goto L_0x0102
        L_0x0116:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability.downloadedAudioProducts(java.lang.String):java.util.List");
    }

    public List<ProductDomain> downloadedProducts() {
        OfflineAvailabilityState offlineAvailabilityState;
        List<AudioProductInfo> downloadedAudioProducts = downloadedAudioProducts(getCurrentProfileId());
        ArrayList arrayList = new ArrayList();
        for (AudioProductInfo next : downloadedAudioProducts) {
            if (!(next.getDownloadReason() == DownloadReason.AUTOMATIC_BY_NFC_CARD || next.getDownloadReason() == DownloadReason.NONE)) {
                int id = next.getId();
                String title = next.getTitle();
                String author = next.getAuthor();
                String coverPath = this.fileUtils.isFileExists(next.getCoverPath()) ? next.getCoverPath() : null;
                if (isDownloading(next.getId())) {
                    offlineAvailabilityState = OfflineAvailabilityState.IN_PROGRESS;
                } else {
                    offlineAvailabilityState = OfflineAvailabilityState.AVAILABLE;
                }
                arrayList.add(new ProductDomain(id, title, author, coverPath, false, offlineAvailabilityState, next.getDownloadReason(), false, (ProductSource) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null));
            }
        }
        return arrayList;
    }

    static /* synthetic */ boolean touchProductInfo$default(Availability availability, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = availability.timeService.getCurrentSystemTimeMillis();
        }
        return availability.touchProductInfo(i, j);
    }

    /* access modifiers changed from: private */
    public final boolean touchProductInfo(int i, long j) {
        File file = new File(pathForAudioProductInfo(i));
        if (file.exists()) {
            return file.setLastModified(j);
        }
        return false;
    }

    public void noteProductWasUsed(int i) {
        if (touchProductInfo$default(this, i, 0, 2, (Object) null)) {
            publishDownloadedProductsDidChange();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0070, code lost:
        if (r5 != null) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[SYNTHETIC, Splitter:B:21:0x0076] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isOldWildcardContent(int r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "yyyy-MM-dd'T'HH:mm:ss"
            java.lang.String r1 = "modificationDate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.io.File r1 = new java.io.File
            java.lang.String r8 = r7.pathForWildcardUserContentInfo(r8)
            r1.<init>(r8)
            boolean r8 = r1.exists()
            r2 = 1
            if (r8 == 0) goto L_0x007a
            r8 = 0
            r3 = 0
            java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            java.io.InputStream r6 = (java.io.InputStream) r6     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            r5.<init>(r6, r4)     // Catch:{ Exception -> 0x0055, all -> 0x0051 }
            com.google.gson.Gson r8 = new com.google.gson.Gson     // Catch:{ Exception -> 0x004f }
            r8.<init>()     // Catch:{ Exception -> 0x004f }
            r1 = r5
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ Exception -> 0x004f }
            java.lang.Class<media.tiger.tigerbox.services.interfaces.TigerCardDomain$AccountGeneratedContentsDomain> r4 = media.tiger.tigerbox.services.interfaces.TigerCardDomain.AccountGeneratedContentsDomain.class
            java.lang.Object r8 = r8.fromJson((java.io.Reader) r1, r4)     // Catch:{ Exception -> 0x004f }
            media.tiger.tigerbox.services.interfaces.TigerCardDomain$AccountGeneratedContentsDomain r8 = (media.tiger.tigerbox.services.interfaces.TigerCardDomain.AccountGeneratedContentsDomain) r8     // Catch:{ Exception -> 0x004f }
            java.lang.String r8 = r8.getLastModifiedDate()     // Catch:{ Exception -> 0x004f }
            java.util.Date r8 = media.tiger.tigerbox.utils.DateUtilsKt.toDate(r8, r0)     // Catch:{ Exception -> 0x004f }
            java.util.Date r9 = media.tiger.tigerbox.utils.DateUtilsKt.toDate(r9, r0)     // Catch:{ Exception -> 0x004f }
            int r8 = r9.compareTo(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 <= 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            r5.close()     // Catch:{ Exception -> 0x007a }
            goto L_0x007a
        L_0x004f:
            r8 = move-exception
            goto L_0x0058
        L_0x0051:
            r9 = move-exception
            r5 = r8
            r8 = r9
            goto L_0x0074
        L_0x0055:
            r9 = move-exception
            r5 = r8
            r8 = r9
        L_0x0058:
            timber.log.Timber$Forest r9 = timber.log.Timber.Forest     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r0.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "Availability: Exception reading playlist info "
            r0.append(r1)     // Catch:{ all -> 0x0073 }
            r0.append(r8)     // Catch:{ all -> 0x0073 }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x0073 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x0073 }
            r9.mo50217e(r8, r0)     // Catch:{ all -> 0x0073 }
            if (r5 == 0) goto L_0x007a
            goto L_0x004b
        L_0x0073:
            r8 = move-exception
        L_0x0074:
            if (r5 == 0) goto L_0x0079
            r5.close()     // Catch:{ Exception -> 0x0079 }
        L_0x0079:
            throw r8
        L_0x007a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability.isOldWildcardContent(int, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A[SYNTHETIC, Splitter:B:16:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a A[Catch:{ Exception -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050 A[SYNTHETIC, Splitter:B:22:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055 A[Catch:{ Exception -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flushWildcardUserContentInfo(int r4, media.tiger.tigerbox.services.interfaces.TigerCardDomain.AccountGeneratedContentsDomain r5) {
        /*
            r3 = this;
            java.lang.String r0 = "userContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch:{ Exception -> 0x0029 }
            java.lang.String r4 = r3.pathForWildcardUserContentInfo(r4)     // Catch:{ Exception -> 0x0029 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0029 }
            com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r4.<init>()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r0 = r1
            java.lang.Appendable r0 = (java.lang.Appendable) r0     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r4.toJson((java.lang.Object) r5, (java.lang.Appendable) r0)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1.flush()     // Catch:{ Exception -> 0x004d }
            r1.close()     // Catch:{ Exception -> 0x004d }
            goto L_0x004d
        L_0x0021:
            r4 = move-exception
            r0 = r1
            goto L_0x004e
        L_0x0024:
            r4 = move-exception
            r0 = r1
            goto L_0x002a
        L_0x0027:
            r4 = move-exception
            goto L_0x004e
        L_0x0029:
            r4 = move-exception
        L_0x002a:
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest     // Catch:{ all -> 0x0027 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0027 }
            r1.<init>()     // Catch:{ all -> 0x0027 }
            java.lang.String r2 = "Availability: Exception writing wildcard info "
            r1.append(r2)     // Catch:{ all -> 0x0027 }
            r1.append(r4)     // Catch:{ all -> 0x0027 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0027 }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0027 }
            r5.mo50217e(r4, r1)     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0048
            r0.flush()     // Catch:{ Exception -> 0x004d }
        L_0x0048:
            if (r0 == 0) goto L_0x004d
            r0.close()     // Catch:{ Exception -> 0x004d }
        L_0x004d:
            return
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            r0.flush()     // Catch:{ Exception -> 0x0058 }
        L_0x0053:
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability.flushWildcardUserContentInfo(int, media.tiger.tigerbox.services.interfaces.TigerCardDomain$AccountGeneratedContentsDomain):void");
    }

    public String pathForWildcardUserContentInfo(int i) {
        return pathForProduct(i) + WILDCARD_USER_CONTENT_INFO;
    }

    public String pathForProduct(int i) {
        return this.dlService.getDownloadsFolder() + i + '/';
    }

    /* access modifiers changed from: private */
    public final String pathForAudioProductInfo(int i) {
        return FileUtilsKt.appendingPathComponent(pathForProduct(i), PRODUCT_CONTENT_INFO);
    }

    private final String pathForProductDetails(int i) {
        return FileUtilsKt.appendingPathComponent(pathForProduct(i), PRODUCT_DETAILS_INFO);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:26|(2:28|29)|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ca, code lost:
        if (r4 == null) goto L_0x00d5;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00a6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c A[SYNTHETIC, Splitter:B:24:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a3 A[SYNTHETIC, Splitter:B:28:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1 A[SYNTHETIC, Splitter:B:46:0x00d1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo audioProductInfoForProductId(int r16) {
        /*
            r15 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r15.pathForAudioProductInfo(r16)
            r0.<init>(r1)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 == 0) goto L_0x00d5
            r1 = 0
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
            r5.<init>(r0)     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
            r4.<init>(r5, r3)     // Catch:{ Exception -> 0x00b0, all -> 0x00ae }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x00ac }
            r0.<init>()     // Catch:{ Exception -> 0x00ac }
            r3 = r4
            java.io.Reader r3 = (java.io.Reader) r3     // Catch:{ Exception -> 0x00ac }
            java.lang.Class<media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo> r5 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo.class
            java.lang.Object r0 = r0.fromJson((java.io.Reader) r3, r5)     // Catch:{ Exception -> 0x00ac }
            r3 = r0
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r3 = (media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo) r3     // Catch:{ Exception -> 0x00ac }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00ac }
            java.lang.String r5 = r15.pathForProductDetails(r16)     // Catch:{ Exception -> 0x00ac }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00ac }
            boolean r5 = r0.exists()     // Catch:{ Exception -> 0x00ac }
            if (r5 == 0) goto L_0x00a7
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            java.io.InputStreamReader r14 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            java.io.InputStream r6 = (java.io.InputStream) r6     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            r14.<init>(r6, r5)     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x007b }
            r0.<init>()     // Catch:{ Exception -> 0x007b }
            r5 = r14
            java.io.Reader r5 = (java.io.Reader) r5     // Catch:{ Exception -> 0x007b }
            java.lang.Class<media.tiger.tigerbox.model.domain.ProductDetails> r6 = media.tiger.tigerbox.model.domain.ProductDetails.class
            java.lang.Object r0 = r0.fromJson((java.io.Reader) r5, r6)     // Catch:{ Exception -> 0x007b }
            media.tiger.tigerbox.model.domain.ProductDetails r0 = (media.tiger.tigerbox.model.domain.ProductDetails) r0     // Catch:{ Exception -> 0x007b }
            java.lang.String r5 = "info"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ Exception -> 0x007b }
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = r0.getTitle()     // Catch:{ Exception -> 0x007b }
            java.lang.String r10 = r0.getAuthor()     // Catch:{ Exception -> 0x007b }
            r11 = 0
            r12 = 39
            r13 = 0
            r5 = r3
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r0 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x007b }
            r14.close()     // Catch:{ Exception -> 0x0079 }
        L_0x0079:
            r2 = r0
            goto L_0x00a8
        L_0x007b:
            r0 = move-exception
            goto L_0x0082
        L_0x007d:
            r0 = move-exception
            r14 = r2
            goto L_0x00a1
        L_0x0080:
            r0 = move-exception
            r14 = r2
        L_0x0082:
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r6.<init>()     // Catch:{ all -> 0x00a0 }
            java.lang.String r7 = "Availability: Exception reading product details "
            r6.append(r7)     // Catch:{ all -> 0x00a0 }
            r6.append(r0)     // Catch:{ all -> 0x00a0 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x00a0 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a0 }
            r5.mo50217e(r0, r6)     // Catch:{ all -> 0x00a0 }
            if (r14 == 0) goto L_0x00a7
            r14.close()     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00a7
        L_0x00a0:
            r0 = move-exception
        L_0x00a1:
            if (r14 == 0) goto L_0x00a6
            r14.close()     // Catch:{ Exception -> 0x00a6 }
        L_0x00a6:
            throw r0     // Catch:{ Exception -> 0x00ac }
        L_0x00a7:
            r2 = r3
        L_0x00a8:
            r4.close()     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00d5
        L_0x00ac:
            r0 = move-exception
            goto L_0x00b2
        L_0x00ae:
            r0 = move-exception
            goto L_0x00cf
        L_0x00b0:
            r0 = move-exception
            r4 = r2
        L_0x00b2:
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r5.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r6 = "Availability: Exception reading playlist info "
            r5.append(r6)     // Catch:{ all -> 0x00cd }
            r5.append(r0)     // Catch:{ all -> 0x00cd }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00cd }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00cd }
            r3.mo50217e(r0, r1)     // Catch:{ all -> 0x00cd }
            if (r4 == 0) goto L_0x00d5
            goto L_0x00a8
        L_0x00cd:
            r0 = move-exception
            r2 = r4
        L_0x00cf:
            if (r2 == 0) goto L_0x00d4
            r2.close()     // Catch:{ Exception -> 0x00d4 }
        L_0x00d4:
            throw r0
        L_0x00d5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability.audioProductInfoForProductId(int):media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo");
    }

    /* access modifiers changed from: private */
    public final String getCurrentProfileId() {
        int activeProfileId = this.getTigerBoxAccountUseCase.invoke().getUser().getActiveProfileId();
        return String.valueOf(activeProfileId != 0 ? Integer.valueOf(activeProfileId) : DEFAULT_PROFILE);
    }

    /* access modifiers changed from: private */
    public final String pathForProductProfileFile(int i, String str) {
        return pathForProduct(i) + str + ".profile";
    }

    private final boolean productFolderBelongsToProfile(int i, String str) {
        if (str.length() == 0) {
            return true;
        }
        try {
            String[] list = new File(pathForProduct(i)).list();
            if (list != null) {
                boolean z = false;
                for (String str2 : list) {
                    Intrinsics.checkNotNullExpressionValue(str2, "fileName");
                    if (Intrinsics.areEqual((Object) FileUtilsKt.pathExtension(str2), (Object) PROFILE_EXTENSION)) {
                        z = true;
                    }
                    if (Intrinsics.areEqual((Object) str2, (Object) str + ".profile")) {
                        return true;
                    }
                }
                if (!z) {
                    return true;
                }
            }
        } catch (IOException e) {
            Timber.Forest.mo50217e("productFolderBelongsToProfile exception: " + e, new Object[0]);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void removeProfileFromAudioProductFolder(int i, String str) {
        try {
            File file = new File(pathForProductProfileFile(i, str));
            if (file.exists()) {
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final boolean isProductFolderBelongingToProfile(int i, String str) {
        if (str.length() == 0) {
            return true;
        }
        return new File(pathForProductProfileFile(i, str)).exists();
    }

    /* access modifiers changed from: private */
    public final boolean isProductFolderBelongingToAnyNonDefaultProfile(int i) {
        String[] list = new File(pathForProduct(i)).list();
        if (list != null) {
            for (String str : list) {
                Intrinsics.checkNotNullExpressionValue(str, "fileName");
                if (Intrinsics.areEqual((Object) FileUtilsKt.pathExtension(str), (Object) PROFILE_EXTENSION)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final Job addProfileToAudioProductFolder(AudioDownload audioDownload, String str) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$addProfileToAudioProductFolder$1(audioDownload, this, str, (Continuation<? super Availability$addProfileToAudioProductFolder$1>) null), 3, (Object) null);
    }

    public void flushAudioProductInfoToDisk(AudioProductInfo audioProductInfo) {
        Intrinsics.checkNotNullParameter(audioProductInfo, "info");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$flushAudioProductInfoToDisk$1(this, audioProductInfo, (Continuation<? super Availability$flushAudioProductInfoToDisk$1>) null), 3, (Object) null);
    }

    public void changeDownloadReasonForProduct(int i, DownloadReason downloadReason, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(downloadReason, "reason");
        Intrinsics.checkNotNullParameter(function1, "onDone");
        if (!isDownloaded(i)) {
            function1.invoke(false);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$changeDownloadReasonForProduct$1(this, i, downloadReason, function1, (Continuation<? super Availability$changeDownloadReasonForProduct$1>) null), 3, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[SYNTHETIC, Splitter:B:16:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[Catch:{ Exception -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054 A[SYNTHETIC, Splitter:B:22:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059 A[Catch:{ Exception -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flushProductDetails(media.tiger.tigerbox.model.domain.ProductDetails r5) {
        /*
            r4 = this;
            java.lang.String r0 = "info"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch:{ Exception -> 0x002d }
            int r2 = r5.getId()     // Catch:{ Exception -> 0x002d }
            java.lang.String r2 = r4.pathForProductDetails(r2)     // Catch:{ Exception -> 0x002d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002d }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0028, all -> 0x0025 }
            r0.<init>()     // Catch:{ Exception -> 0x0028, all -> 0x0025 }
            r2 = r1
            java.lang.Appendable r2 = (java.lang.Appendable) r2     // Catch:{ Exception -> 0x0028, all -> 0x0025 }
            r0.toJson((java.lang.Object) r5, (java.lang.Appendable) r2)     // Catch:{ Exception -> 0x0028, all -> 0x0025 }
            r1.flush()     // Catch:{ Exception -> 0x0051 }
            r1.close()     // Catch:{ Exception -> 0x0051 }
            goto L_0x0051
        L_0x0025:
            r5 = move-exception
            r0 = r1
            goto L_0x0052
        L_0x0028:
            r5 = move-exception
            r0 = r1
            goto L_0x002e
        L_0x002b:
            r5 = move-exception
            goto L_0x0052
        L_0x002d:
            r5 = move-exception
        L_0x002e:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r2.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r3 = "Availability: Exception flushProductDetails: "
            r2.append(r3)     // Catch:{ all -> 0x002b }
            r2.append(r5)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x002b }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x002b }
            r1.mo50217e(r5, r2)     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x004c
            r0.flush()     // Catch:{ Exception -> 0x0051 }
        L_0x004c:
            if (r0 == 0) goto L_0x0051
            r0.close()     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            return
        L_0x0052:
            if (r0 == 0) goto L_0x0057
            r0.flush()     // Catch:{ Exception -> 0x005c }
        L_0x0057:
            if (r0 == 0) goto L_0x005c
            r0.close()     // Catch:{ Exception -> 0x005c }
        L_0x005c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability.flushProductDetails(media.tiger.tigerbox.model.domain.ProductDetails):void");
    }

    public boolean removeProduct(int i) {
        File file = new File(pathForProduct(i));
        if (!file.exists() || !file.isDirectory() || !deleteFileOrDirectory(file)) {
            return false;
        }
        publishDownloadedProductsDidChange();
        return true;
    }

    @Metadata(mo33736d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JC\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/Availability$AudioDownload;", "", "product", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "tracks", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioTrackModel;", "Lkotlin/collections/ArrayList;", "nfc", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "canceled", "", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;Ljava/util/ArrayList;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;Z)V", "getCanceled", "()Z", "setCanceled", "(Z)V", "getNfc", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "setNfc", "(Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;)V", "getProduct", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "setProduct", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;)V", "getTracks", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Availability.kt */
    private static final class AudioDownload {
        private boolean canceled;
        private TigerCardDomain nfc;
        private AudioProductInfo product;
        private final ArrayList<AudioTrackModel> tracks;

        public static /* synthetic */ AudioDownload copy$default(AudioDownload audioDownload, AudioProductInfo audioProductInfo, ArrayList<AudioTrackModel> arrayList, TigerCardDomain tigerCardDomain, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                audioProductInfo = audioDownload.product;
            }
            if ((i & 2) != 0) {
                arrayList = audioDownload.tracks;
            }
            if ((i & 4) != 0) {
                tigerCardDomain = audioDownload.nfc;
            }
            if ((i & 8) != 0) {
                z = audioDownload.canceled;
            }
            return audioDownload.copy(audioProductInfo, arrayList, tigerCardDomain, z);
        }

        public final AudioProductInfo component1() {
            return this.product;
        }

        public final ArrayList<AudioTrackModel> component2() {
            return this.tracks;
        }

        public final TigerCardDomain component3() {
            return this.nfc;
        }

        public final boolean component4() {
            return this.canceled;
        }

        public final AudioDownload copy(AudioProductInfo audioProductInfo, ArrayList<AudioTrackModel> arrayList, TigerCardDomain tigerCardDomain, boolean z) {
            Intrinsics.checkNotNullParameter(audioProductInfo, "product");
            Intrinsics.checkNotNullParameter(arrayList, "tracks");
            return new AudioDownload(audioProductInfo, arrayList, tigerCardDomain, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioDownload)) {
                return false;
            }
            AudioDownload audioDownload = (AudioDownload) obj;
            return Intrinsics.areEqual((Object) this.product, (Object) audioDownload.product) && Intrinsics.areEqual((Object) this.tracks, (Object) audioDownload.tracks) && Intrinsics.areEqual((Object) this.nfc, (Object) audioDownload.nfc) && this.canceled == audioDownload.canceled;
        }

        public int hashCode() {
            int hashCode = ((this.product.hashCode() * 31) + this.tracks.hashCode()) * 31;
            TigerCardDomain tigerCardDomain = this.nfc;
            int hashCode2 = (hashCode + (tigerCardDomain == null ? 0 : tigerCardDomain.hashCode())) * 31;
            boolean z = this.canceled;
            if (z) {
                z = true;
            }
            return hashCode2 + (z ? 1 : 0);
        }

        public String toString() {
            return "AudioDownload(product=" + this.product + ", tracks=" + this.tracks + ", nfc=" + this.nfc + ", canceled=" + this.canceled + ')';
        }

        public AudioDownload(AudioProductInfo audioProductInfo, ArrayList<AudioTrackModel> arrayList, TigerCardDomain tigerCardDomain, boolean z) {
            Intrinsics.checkNotNullParameter(audioProductInfo, "product");
            Intrinsics.checkNotNullParameter(arrayList, "tracks");
            this.product = audioProductInfo;
            this.tracks = arrayList;
            this.nfc = tigerCardDomain;
            this.canceled = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AudioDownload(AudioProductInfo audioProductInfo, ArrayList arrayList, TigerCardDomain tigerCardDomain, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(audioProductInfo, arrayList, tigerCardDomain, (i & 8) != 0 ? false : z);
        }

        public final AudioProductInfo getProduct() {
            return this.product;
        }

        public final void setProduct(AudioProductInfo audioProductInfo) {
            Intrinsics.checkNotNullParameter(audioProductInfo, "<set-?>");
            this.product = audioProductInfo;
        }

        public final ArrayList<AudioTrackModel> getTracks() {
            return this.tracks;
        }

        public final TigerCardDomain getNfc() {
            return this.nfc;
        }

        public final void setNfc(TigerCardDomain tigerCardDomain) {
            this.nfc = tigerCardDomain;
        }

        public final boolean getCanceled() {
            return this.canceled;
        }

        public final void setCanceled(boolean z) {
            this.canceled = z;
        }
    }

    /* access modifiers changed from: private */
    public final List<AudioDownload> getAudioDownloadsInProgress() {
        List<AudioDownload> list;
        if (this._audioDownloadsInProgress == null) {
            String string = this.sharedPreferences.getString(DOWNLOADS_IN_PROGRESS_KEY, "");
            if (string != null) {
                if (string.length() > 0) {
                    try {
                        list = (List) new Gson().fromJson(string, new Availability$audioDownloadsInProgress$statesType$1().getType());
                    } catch (Exception e) {
                        Timber.Forest forest = Timber.Forest;
                        forest.mo50217e("Availability: Exception reading audioDownloadsInProgress " + e, new Object[0]);
                        list = new ArrayList<>();
                    }
                    this._audioDownloadsInProgress = list;
                }
            }
            list = new ArrayList<>();
            this._audioDownloadsInProgress = list;
        }
        List<AudioDownload> list2 = this._audioDownloadsInProgress;
        Intrinsics.checkNotNull(list2);
        return list2;
    }

    /* access modifiers changed from: private */
    public final void updateAudioDownloadLocalStorage() {
        try {
            this.sharedPreferences.edit().putString(DOWNLOADS_IN_PROGRESS_KEY, new Gson().toJson((Object) getAudioDownloadsInProgress(), new Availability$updateAudioDownloadLocalStorage$statesType$1().getType())).apply();
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("Availability: Exception writing audio downloads to local storage " + e, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final Job addAudioDownload(AudioDownload audioDownload) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$addAudioDownload$1(this, audioDownload, (Continuation<? super Availability$addAudioDownload$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Job removeAudioDownloadFromQueue(AudioDownload audioDownload) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$removeAudioDownloadFromQueue$1(this, audioDownload, (Continuation<? super Availability$removeAudioDownloadFromQueue$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void checkPendingDownloads() {
        if (!Intrinsics.areEqual((Object) this.wifiService.getOfflineMode().getValue(), (Object) true)) {
            synchronized (getAudioDownloadsInProgress()) {
                if (true ^ getAudioDownloadsInProgress().isEmpty()) {
                    startAudioDownload((AudioDownload) CollectionsKt.last(getAudioDownloadsInProgress()));
                    return;
                }
                Unit unit = Unit.INSTANCE;
                updateDownloadsInProgress();
            }
        }
    }

    private final boolean isDownloading(int i) {
        return isDownloadingForProductFolderInProgress(String.valueOf(i));
    }

    public OfflineAvailabilityState offlineAvailabilityStateFor(int i, boolean z) {
        if (isDownloading(i)) {
            if (!z || productFolderBelongsToProfile(i, getCurrentProfileId())) {
                return OfflineAvailabilityState.IN_PROGRESS;
            }
            return OfflineAvailabilityState.NOT_AVAILABLE;
        } else if (!isDownloaded(i)) {
            return OfflineAvailabilityState.NOT_AVAILABLE;
        } else {
            if (!z || productFolderBelongsToProfile(i, getCurrentProfileId())) {
                return OfflineAvailabilityState.AVAILABLE;
            }
            return OfflineAvailabilityState.NOT_AVAILABLE;
        }
    }

    static /* synthetic */ void cancelAllDownloadsInProgress$default(Availability availability, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        availability.cancelAllDownloadsInProgress(str);
    }

    /* access modifiers changed from: private */
    public final void cancelAllDownloadsInProgress(String str) {
        this._activeAudioDownload = null;
        synchronized (getAudioDownloadsInProgress()) {
            for (AudioDownload audioDownload : getAudioDownloadsInProgress()) {
                if ((str.length() == 0) || isProductFolderBelongingToProfile(audioDownload.getProduct().getId(), str)) {
                    audioDownload.setCanceled(true);
                }
            }
            getAudioDownloadsInProgress().clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean isDownloadingForProductFolderInProgress(String str) {
        if (Intrinsics.areEqual((Object) this.wifiService.getOfflineMode().getValue(), (Object) true)) {
            return false;
        }
        synchronized (getAudioDownloadsInProgress()) {
            if (!getAudioDownloadsInProgress().isEmpty()) {
                for (AudioDownload next : getAudioDownloadsInProgress()) {
                    if (Intrinsics.areEqual((Object) String.valueOf(next.getProduct().getId()), (Object) str) && !next.getCanceled()) {
                        return true;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            return false;
        }
    }

    public void downloadAudioProduct(int i, TigerCardDomain tigerCardDomain, DownloadReason downloadReason) {
        Intrinsics.checkNotNullParameter(downloadReason, "reason");
        AudioProductInfo audioProductInfoForProductId = audioProductInfoForProductId(i);
        if (audioProductInfoForProductId != null && !isDownloaded(i) && !isDownloading(i)) {
            startAudioDownload(new AudioDownload(AudioProductInfo.copy$default(audioProductInfoForProductId, 0, (String) null, (String) null, (String) null, (String) null, downloadReason, 31, (Object) null), AudioItemImpl.Companion.create(audioProductInfoForProductId, tigerCardDomain).getTracks(), tigerCardDomain, false, 8, (DefaultConstructorMarker) null));
        }
    }

    private final Job startAudioDownload(AudioDownload audioDownload) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$startAudioDownload$1(audioDownload, this, (Continuation<? super Availability$startAudioDownload$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void failAudioDownload(AudioDownload audioDownload) {
        this._activeAudioDownload = null;
        publishDidFailDownloadingProduct(audioDownload.getProduct().getId());
        publishDownloadedProductsDidChange();
        checkPendingDownloads();
    }

    /* access modifiers changed from: private */
    public final Job finishAudioDownload(AudioDownload audioDownload) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$finishAudioDownload$1(this, audioDownload, (Continuation<? super Availability$finishAudioDownload$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final List<DownloadsManagerService.FileDownloadInfo> parseM3U8s(List<DownloadsManagerService.FileDownloadInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (DownloadsManagerService.FileDownloadInfo next : list) {
            String url = next.getUrl();
            String destinationPath = next.getDestinationPath();
            File file = new File(destinationPath);
            if (file.exists()) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                T t = "";
                objectRef.element = t;
                boolean z = true;
                try {
                    Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
                    Iterator it = TextStreamsKt.readLines(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)).iterator();
                    while (true) {
                        boolean z2 = false;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            T t2 = (String) it.next();
                            objectRef.element = ((String) objectRef.element) + t2 + 10;
                            if (z2) {
                                t = t2;
                                break;
                            } else if (StringsKt.contains$default((CharSequence) t2, (CharSequence) AudioItemImpl.EXT_X_STREAM_INF, false, 2, (Object) null)) {
                                z2 = true;
                            }
                        }
                    }
                } catch (Exception e) {
                    Timber.Tree tag = Timber.Forest.tag("Availability");
                    tag.mo50217e("Exception while reading lines from buffer: " + e, new Object[0]);
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$parseM3U8s$1(file, objectRef, (Continuation<? super Availability$parseM3U8s$1>) null), 3, (Object) null);
                if (((CharSequence) t).length() <= 0) {
                    z = false;
                }
                if (z) {
                    arrayList.add(new DownloadsManagerService.FileDownloadInfo(FileUtilsKt.appendingPathComponent(FileUtilsKt.removingLastPathComponent(url), t), FileUtilsKt.appendingPathComponent(FileUtilsKt.removingLastPathComponent(destinationPath), t)));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void downloadEncodingPlaylists(AudioDownload audioDownload, List<DownloadsManagerService.FileDownloadInfo> list) {
        this.dlService.downloadFiles(list, new Availability$downloadEncodingPlaylists$1(audioDownload), new Availability$downloadEncodingPlaylists$2(this, audioDownload, list));
    }

    /* access modifiers changed from: private */
    public final List<DownloadsManagerService.FileDownloadInfo> parseEncodingPlaylists(AudioDownload audioDownload, List<DownloadsManagerService.FileDownloadInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (DownloadsManagerService.FileDownloadInfo next : list) {
            String url = next.getUrl();
            String destinationPath = next.getDestinationPath();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            ArrayList arrayList2 = new ArrayList();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            File file = new File(destinationPath);
            if (file.exists()) {
                try {
                    FilesKt.forEachLine$default(file, (Charset) null, new Availability$parseEncodingPlaylists$1(objectRef, objectRef2, new Ref.BooleanRef(), arrayList2), 1, (Object) null);
                } catch (Exception e) {
                    Timber.Tree tag = Timber.Forest.tag("Availability");
                    tag.mo50217e("Exception while parsing file " + e, new Object[0]);
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$parseEncodingPlaylists$2(file, objectRef2, (Continuation<? super Availability$parseEncodingPlaylists$2>) null), 3, (Object) null);
                String removingLastPathComponent = FileUtilsKt.removingLastPathComponent(url);
                String removingLastPathComponent2 = FileUtilsKt.removingLastPathComponent(destinationPath);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    Intrinsics.checkNotNullExpressionValue(str, "tsRelativePath");
                    arrayList.add(new DownloadsManagerService.FileDownloadInfo(FileUtilsKt.appendingPathComponent(removingLastPathComponent, str), FileUtilsKt.appendingPathComponent(removingLastPathComponent2, str)));
                }
                Map linkedHashMap = new LinkedHashMap();
                if (!linkedHashMap.containsKey(objectRef.element)) {
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Availability$parseEncodingPlaylists$3(this, objectRef, audioDownload, (Continuation<? super Availability$parseEncodingPlaylists$3>) null), 3, (Object) null);
                    linkedHashMap.put(objectRef.element, true);
                }
            }
            AudioDownload audioDownload2 = audioDownload;
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void downloadTsFiles(AudioDownload audioDownload, List<DownloadsManagerService.FileDownloadInfo> list) {
        this.dlService.downloadFiles(list, new Availability$downloadTsFiles$1(audioDownload), new Availability$downloadTsFiles$2(this, audioDownload, list));
    }

    public void registerListener(AvailabilityListener availabilityListener, boolean z) {
        Intrinsics.checkNotNullParameter(availabilityListener, "listener");
        if (!this.listeners.contains(availabilityListener)) {
            this.listeners.add(availabilityListener);
            if (z) {
                availabilityListener.downloadsInProgressDidChange(getDownloadsInProgress());
                availabilityListener.downloadedProductsDidChange();
            }
        }
    }

    public void unregisterListener(AvailabilityListener availabilityListener) {
        Intrinsics.checkNotNullParameter(availabilityListener, "listener");
        this.listeners.remove(availabilityListener);
    }

    /* access modifiers changed from: private */
    public final void updateDownloadsInProgress() {
        boolean z;
        int i;
        synchronized (getAudioDownloadsInProgress()) {
            z = false;
            i = 0;
            for (AudioDownload canceled : getAudioDownloadsInProgress()) {
                if (!canceled.getCanceled()) {
                    i++;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        boolean z2 = this._downloadsInProgress != (i > 0);
        if (i > 0) {
            z = true;
        }
        this._downloadsInProgress = z;
        if (z2) {
            publishDownloadsInProgressDidChange();
        }
        if (this._downloadsInProgress || this._activeAudioDownload != null) {
            this.lightControlService.addTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_IN_PROGRESS));
        } else if (z2) {
            this.lightControlService.addTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_FINISHED));
        }
    }

    public boolean getDownloadsInProgress() {
        Boolean value = this.wifiService.getOfflineMode().getValue();
        if (value == null || !value.booleanValue()) {
            return this._downloadsInProgress;
        }
        return false;
    }

    private final Job publishDownloadsInProgressDidChange() {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new Availability$publishDownloadsInProgressDidChange$1(this, (Continuation<? super Availability$publishDownloadsInProgressDidChange$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Job publishDownloadedProductsDidChange() {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new Availability$publishDownloadedProductsDidChange$1(this, (Continuation<? super Availability$publishDownloadedProductsDidChange$1>) null), 3, (Object) null);
    }

    private final void publishDidFailDownloadingProduct(int i) {
        Iterator<AvailabilityListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().didFailDownloadingProduct(i);
        }
    }

    @Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/Availability$Companion;", "", "()V", "DEFAULT_PROFILE", "", "DOWNLOADS_IN_PROGRESS_KEY", "FILE_TOUCH_DELAY", "", "PRODUCT_CONTENT_INFO", "PRODUCT_CONTENT_READY_ID", "PRODUCT_DETAILS_INFO", "PROFILE_EXTENSION", "REQ_MIN_FREE_SPACE_BYTES", "", "UPDATE_REQ_FREE_SPACE_BYTES", "WILDCARD_DATE_FORMAT", "WILDCARD_USER_CONTENT_INFO", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Availability.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-13  reason: not valid java name */
    public static final void m2340_init_$lambda13(Availability availability, Boolean bool) {
        Intrinsics.checkNotNullParameter(availability, "this$0");
        if (Intrinsics.areEqual((Object) bool, (Object) false)) {
            availability.lightControlService.removeTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_INTERRUPTED_BY_WIFI));
            availability.checkPendingDownloads();
        } else {
            availability.lightControlService.addTigerButtonLightEvents(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_INTERRUPTED_BY_WIFI));
        }
        availability.publishDownloadsInProgressDidChange();
    }

    /* access modifiers changed from: private */
    public final boolean deleteFileOrDirectory(File file) {
        if (file.exists()) {
            try {
                Runtime.getRuntime().exec("rm -rf " + file.getPath()).waitFor();
                return true;
            } catch (IOException e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("Availability: Exception deleting dir " + e, new Object[0]);
            }
        }
        return false;
    }
}
