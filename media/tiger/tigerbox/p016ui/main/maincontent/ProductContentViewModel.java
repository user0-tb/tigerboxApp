package media.tiger.tigerbox.p016ui.main.maincontent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.exception.ShopLayoutFailure;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.domain.DownloadReason;
import media.tiger.tigerbox.model.domain.OfflineAvailabilityState;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.model.domain.ProductRowDomain;
import media.tiger.tigerbox.model.domain.ProductRowType;
import media.tiger.tigerbox.model.domain.ProductSource;
import media.tiger.tigerbox.model.dto.ProductDetailsDto;
import media.tiger.tigerbox.p016ui.common.BaseViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.implementations.HeadsetService;
import media.tiger.tigerbox.services.interfaces.AcquisitionReason;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.NightLightTimerService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionDelegate;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;
import media.tiger.tigerbox.services.interfaces.UpdateCheckTimerService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import media.tiger.tigerbox.services.interfaces.audioPlayer.LastUsedProductService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackPositionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackTrackingService;
import media.tiger.tigerbox.usecase.GetMainContentUseCase;
import media.tiger.tigerbox.usecase.ReportInformationRequestBody;
import media.tiger.tigerbox.usecase.ReportInformationUseCase;
import media.tiger.tigerbox.webserver.controller.MediaRestController;
import media.tiger.tigerbox.webserver.dto.PlaybackDto;
import p009j$.util.Collection;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000Å\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0007TW^a~\u0001\b\u0007\u0018\u00002\u00020\u0001BÇ\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u0012\u0006\u00100\u001a\u000201¢\u0006\u0002\u00102J\u0007\u0010\u0001\u001a\u000209J\u0007\u0010\u0001\u001a\u000209J\u0010\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020EJU\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020B2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020E0\u000120\b\u0002\u0010\u0001\u001a)\u0012\u001d\u0012\u001b\u0012\u0004\u0012\u00020E0\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u000209\u0018\u00010sH\u0002J1\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020B2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020B0\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020E0AH\u0002J\u0006\u0010f\u001a\u000209J\u0007\u0010\u0001\u001a\u00020<J\u0018\u0010|\u001a\u0002092\u0007\u0010\u0001\u001a\u00020q2\u0007\u0010\u0001\u001a\u00020qJ\u0015\u0010\u0001\u001a\u0002092\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0012\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020tH\u0014J%\u0010\u0001\u001a\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0A\u0012\u0005\u0012\u00030\u00010s2\u0007\u0010\u0001\u001a\u00020BH\u0002J\u0018\u0010\u0001\u001a\u0002092\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020B0AH\u0002J\u0012\u0010 \u0001\u001a\u00020?2\u0007\u0010¡\u0001\u001a\u00020BH\u0002J\u0013\u0010¢\u0001\u001a\u00030£\u00012\u0007\u0010¤\u0001\u001a\u00020EH\u0002J\t\u0010¥\u0001\u001a\u000209H\u0017J\u0007\u0010¦\u0001\u001a\u000209J\u0019\u0010§\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020E2\u0007\u0010\u0001\u001a\u00020qJ\u0007\u0010¨\u0001\u001a\u000209J\u0010\u0010©\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020EJ\t\u0010ª\u0001\u001a\u000209H\u0002J\u0007\u0010«\u0001\u001a\u000209J#\u0010¬\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020E2\u000f\u0010­\u0001\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010AH\u0002J\u0007\u0010®\u0001\u001a\u000209J\u0007\u0010¯\u0001\u001a\u000209J\u0019\u0010°\u0001\u001a\u0002092\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020B0\u0001H\u0002J\u0018\u0010±\u0001\u001a\u0002092\r\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020B0AH\u0002J\u0013\u0010³\u0001\u001a\u00020?*\b\u0012\u0004\u0012\u00020B0AH\u0002J\u0013\u0010´\u0001\u001a\u00020?*\b\u0012\u0004\u0012\u00020B0AH\u0002J\u0015\u0010µ\u0001\u001a\u0004\u0018\u00010B*\b\u0012\u0004\u0012\u00020B0AH\u0002R\u0016\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010504X\u0004¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010704X\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020904X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010<0<0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?04X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020?04X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0A04X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G04X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050I8F¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0019\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070I8F¢\u0006\u0006\u001a\u0004\bR\u0010KR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u00020TX\u000e¢\u0006\u0004\n\u0002\u0010UR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u00020WX\u0004¢\u0006\u0004\n\u0002\u0010XR\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u0002090I8F¢\u0006\u0006\u001a\u0004\bZ\u0010KR\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020<0I8F¢\u0006\u0006\u001a\u0004\b\\\u0010KR\u0010\u0010]\u001a\u00020^X\u0004¢\u0006\u0004\n\u0002\u0010_R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u00020aX\u0004¢\u0006\u0004\n\u0002\u0010bR\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020?0I8F¢\u0006\u0006\u001a\u0004\bd\u0010KR\u001d\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0I8F¢\u0006\u0006\u001a\u0004\bf\u0010KR\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020?0I8F¢\u0006\u0006\u001a\u0004\bh\u0010KR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020qX\u000e¢\u0006\u0002\n\u0000R2\u0010r\u001a\u0010\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u000209\u0018\u00010s8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0A0I8F¢\u0006\u0006\u001a\u0004\b|\u0010KR\u0010\u0010}\u001a\u00020~X\u0004¢\u0006\u0004\n\u0002\u0010R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0I8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010KR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0005\n\u0003\u0010\u0001R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000¨\u0006¶\u0001"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel;", "Lmedia/tiger/tigerbox/ui/common/BaseViewModel;", "getMainContentUseCase", "Lmedia/tiger/tigerbox/usecase/GetMainContentUseCase;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "productAcquisitionService", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "playbackPositionService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/PlaybackPositionService;", "lastUsedProductService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/LastUsedProductService;", "playbackTrackingService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/PlaybackTrackingService;", "powerManagementService", "Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;", "tigerCardsManagerService", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;", "nightNightLightTimer", "Lmedia/tiger/tigerbox/services/interfaces/NightLightTimerService;", "updateCheckTimer", "Lmedia/tiger/tigerbox/services/interfaces/UpdateCheckTimerService;", "mediaRestController", "Lmedia/tiger/tigerbox/webserver/controller/MediaRestController;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "reportInformationUseCase", "Lmedia/tiger/tigerbox/usecase/ReportInformationUseCase;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headsetService", "Lmedia/tiger/tigerbox/services/implementations/HeadsetService;", "batteryService", "Lmedia/tiger/tigerbox/services/interfaces/BatteryService;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "generateCsr", "Lmedia/tiger/tigerbox/ui/main/maincontent/GenerateCsr;", "getProductListRequest", "Lmedia/tiger/tigerbox/ui/main/maincontent/GetProductListRequest;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "infoSoundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "(Lmedia/tiger/tigerbox/usecase/GetMainContentUseCase;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/PlaybackPositionService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/LastUsedProductService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/PlaybackTrackingService;Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;Lmedia/tiger/tigerbox/services/interfaces/NightLightTimerService;Lmedia/tiger/tigerbox/services/interfaces/UpdateCheckTimerService;Lmedia/tiger/tigerbox/webserver/controller/MediaRestController;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/usecase/ReportInformationUseCase;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/implementations/HeadsetService;Lmedia/tiger/tigerbox/services/interfaces/BatteryService;Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/ui/main/maincontent/GenerateCsr;Lmedia/tiger/tigerbox/ui/main/maincontent/GetProductListRequest;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;)V", "_activeError", "Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "_activeTigerTicketStep", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "_closeMediaPlayer", "", "_deviceName", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_loadingListInProgress", "", "_mainContent", "", "Lmedia/tiger/tigerbox/model/domain/ProductRowDomain;", "_multiCardInserted", "_productList", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "_startedAudioProduct", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "activeError", "Landroidx/lifecycle/LiveData;", "getActiveError", "()Landroidx/lifecycle/LiveData;", "activeErrorMessage", "getActiveErrorMessage", "()Ljava/lang/String;", "setActiveErrorMessage", "(Ljava/lang/String;)V", "activeTigerTicketStep", "getActiveTigerTicketStep", "audioServiceListener", "media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$audioServiceListener$1", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$audioServiceListener$1;", "availabilityServiceListener", "media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$availabilityServiceListener$1", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$availabilityServiceListener$1;", "closeMediaPlayer", "getCloseMediaPlayer", "deviceName", "getDeviceName", "displayNameListener", "media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$displayNameListener$1", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$displayNameListener$1;", "headsetListener", "media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$headsetListener$1", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$headsetListener$1;", "loadingListInProgress", "getLoadingListInProgress", "mainContent", "getMainContent", "multiCardInserted", "getMultiCardInserted", "multiProductTigerCard", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "getMultiProductTigerCard", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "setMultiProductTigerCard", "(Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;)V", "offlineRow", "offlineRowPosition", "", "onFail", "Lkotlin/Function1;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "getOnFail$annotations", "()V", "getOnFail", "()Lkotlin/jvm/functions/Function1;", "setOnFail", "(Lkotlin/jvm/functions/Function1;)V", "productList", "getProductList", "profilesListener", "media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$profilesListener$1", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$profilesListener$1;", "startedAudioProduct", "getStartedAudioProduct", "tigerCardListener", "media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$tigerCardListener$1", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$tigerCardListener$1;", "clearProductList", "confirmOfflineMode", "downloadProduct", "product", "fetchNextLinkProductListData", "Lkotlinx/coroutines/Job;", "clickedRow", "mergedResponsesList", "", "onDone", "Lkotlin/ParameterName;", "name", "list", "filterNonBannerWithContent", "row", "newList", "getOfflineRowTitle", "rowId", "ordinal", "handleAcquisitionError", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "handleFailure", "failure", "handleGetBannerProductListResponse", "handleMainContentLayout", "listOfProductRows", "isNotBannerOrBannerWithContent", "productRow", "offlineStateForProduct", "Lmedia/tiger/tigerbox/model/domain/OfflineAvailabilityState;", "pd", "onCleared", "playBatteryBelow5PercentIfNeeded", "playProduct", "registerListeners", "removeDownloadedProduct", "sendDeviceInformation", "showMultiProductList", "startPlaybackWithRowProducts", "rowProducts", "unsubscribeFromContentRefresh", "updateListDlStatus", "updateOfflineContent", "updateProductAvailableStatus", "mainContentList", "containsOfflineContent", "doesNotContainOfflineContent", "getOfflineContentRow", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel */
/* compiled from: ProductContentViewModel.kt */
public final class ProductContentViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<InfoDialogType> _activeError;
    /* access modifiers changed from: private */
    public final SingleLiveEvent<TigerTicketStepDomain> _activeTigerTicketStep;
    private final SingleLiveEvent<Unit> _closeMediaPlayer;
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _deviceName;
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Boolean> _loadingListInProgress;
    private final MutableLiveData<List<ProductRowDomain>> _mainContent;
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Boolean> _multiCardInserted;
    /* access modifiers changed from: private */
    public final SingleLiveEvent<List<ProductDomain>> _productList;
    /* access modifiers changed from: private */
    public final SingleLiveEvent<AudioProductInfo> _startedAudioProduct;
    /* access modifiers changed from: private */
    public final TigerBoxAccountRepository accountRepository;
    private String activeErrorMessage;
    /* access modifiers changed from: private */
    public final AudioPlayerService audioPlayerService;
    private ProductContentViewModel$audioServiceListener$1 audioServiceListener;
    private final AvailabilityService availabilityService;
    private final ProductContentViewModel$availabilityServiceListener$1 availabilityServiceListener;
    private final BatteryService batteryService;
    private final ButtonService buttonService;
    /* access modifiers changed from: private */
    public final ConfigurationProperties configurationProperties;
    private final ProductContentViewModel$displayNameListener$1 displayNameListener;
    private final GetMainContentUseCase getMainContentUseCase;
    /* access modifiers changed from: private */
    public final GetProductListRequest getProductListRequest;
    private final ProductContentViewModel$headsetListener$1 headsetListener;
    private final HeadsetService headsetService;
    private final InfoSoundService infoSoundService;
    private final LastUsedProductService lastUsedProductService;
    private final MediaRestController mediaRestController;
    /* access modifiers changed from: private */
    public final MetaDataService metaDataService;
    private TigerCardDomain multiProductTigerCard;
    private final NightLightTimerService nightNightLightTimer;
    /* access modifiers changed from: private */
    public ProductRowDomain offlineRow;
    /* access modifiers changed from: private */
    public int offlineRowPosition = -1;
    private Function1<? super Failure, Unit> onFail;
    private final PlaybackPositionService playbackPositionService;
    private final PlaybackTrackingService playbackTrackingService;
    private final PowerManagementService powerManagementService;
    private final ProductAcquisitionService productAcquisitionService;
    private final ProductContentViewModel$profilesListener$1 profilesListener;
    private final ReportInformationUseCase reportInformationUseCase;
    /* access modifiers changed from: private */
    public final StorageService storageService;
    /* access modifiers changed from: private */
    public final ProductContentViewModel$tigerCardListener$1 tigerCardListener;
    private final TigerCardsManagerService tigerCardsManagerService;
    private final UpdateCheckTimerService updateCheckTimer;
    private final WifiService wifiService;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$WhenMappings */
    /* compiled from: ProductContentViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductAcquisitionService.ErrorCode.values().length];
            iArr[ProductAcquisitionService.ErrorCode.NO_WIFI.ordinal()] = 1;
            iArr[ProductAcquisitionService.ErrorCode.ACQUISITION_ERROR_410.ordinal()] = 2;
            iArr[ProductAcquisitionService.ErrorCode.ACQUISITION_ERROR_GET_PRODUCT_ASSET.ordinal()] = 3;
            iArr[ProductAcquisitionService.ErrorCode.IO_ERROR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getOnFail$annotations() {
    }

    @Inject
    public ProductContentViewModel(GetMainContentUseCase getMainContentUseCase2, StorageService storageService2, ProductAcquisitionService productAcquisitionService2, AvailabilityService availabilityService2, AudioPlayerService audioPlayerService2, TigerBoxAccountRepository tigerBoxAccountRepository, PlaybackPositionService playbackPositionService2, LastUsedProductService lastUsedProductService2, PlaybackTrackingService playbackTrackingService2, PowerManagementService powerManagementService2, TigerCardsManagerService tigerCardsManagerService2, NightLightTimerService nightLightTimerService, UpdateCheckTimerService updateCheckTimerService, MediaRestController mediaRestController2, MetaDataService metaDataService2, ReportInformationUseCase reportInformationUseCase2, ButtonService buttonService2, HeadsetService headsetService2, BatteryService batteryService2, WifiService wifiService2, GenerateCsr generateCsr, GetProductListRequest getProductListRequest2, ConfigurationProperties configurationProperties2, InfoSoundService infoSoundService2) {
        GetMainContentUseCase getMainContentUseCase3 = getMainContentUseCase2;
        StorageService storageService3 = storageService2;
        ProductAcquisitionService productAcquisitionService3 = productAcquisitionService2;
        AvailabilityService availabilityService3 = availabilityService2;
        AudioPlayerService audioPlayerService3 = audioPlayerService2;
        TigerBoxAccountRepository tigerBoxAccountRepository2 = tigerBoxAccountRepository;
        PlaybackPositionService playbackPositionService3 = playbackPositionService2;
        LastUsedProductService lastUsedProductService3 = lastUsedProductService2;
        PlaybackTrackingService playbackTrackingService3 = playbackTrackingService2;
        PowerManagementService powerManagementService3 = powerManagementService2;
        TigerCardsManagerService tigerCardsManagerService3 = tigerCardsManagerService2;
        NightLightTimerService nightLightTimerService2 = nightLightTimerService;
        UpdateCheckTimerService updateCheckTimerService2 = updateCheckTimerService;
        MediaRestController mediaRestController3 = mediaRestController2;
        ReportInformationUseCase reportInformationUseCase3 = reportInformationUseCase2;
        Intrinsics.checkNotNullParameter(getMainContentUseCase3, "getMainContentUseCase");
        Intrinsics.checkNotNullParameter(storageService3, "storageService");
        Intrinsics.checkNotNullParameter(productAcquisitionService3, "productAcquisitionService");
        Intrinsics.checkNotNullParameter(availabilityService3, "availabilityService");
        Intrinsics.checkNotNullParameter(audioPlayerService3, "audioPlayerService");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository2, "accountRepository");
        Intrinsics.checkNotNullParameter(playbackPositionService3, "playbackPositionService");
        Intrinsics.checkNotNullParameter(lastUsedProductService3, "lastUsedProductService");
        Intrinsics.checkNotNullParameter(playbackTrackingService3, "playbackTrackingService");
        Intrinsics.checkNotNullParameter(powerManagementService3, "powerManagementService");
        Intrinsics.checkNotNullParameter(tigerCardsManagerService3, "tigerCardsManagerService");
        Intrinsics.checkNotNullParameter(nightLightTimerService2, "nightNightLightTimer");
        Intrinsics.checkNotNullParameter(updateCheckTimerService2, "updateCheckTimer");
        Intrinsics.checkNotNullParameter(mediaRestController3, "mediaRestController");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(reportInformationUseCase2, "reportInformationUseCase");
        Intrinsics.checkNotNullParameter(buttonService2, "buttonService");
        Intrinsics.checkNotNullParameter(headsetService2, "headsetService");
        Intrinsics.checkNotNullParameter(batteryService2, "batteryService");
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(generateCsr, "generateCsr");
        Intrinsics.checkNotNullParameter(getProductListRequest2, "getProductListRequest");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        Intrinsics.checkNotNullParameter(infoSoundService2, "infoSoundService");
        this.getMainContentUseCase = getMainContentUseCase3;
        this.storageService = storageService3;
        this.productAcquisitionService = productAcquisitionService3;
        this.availabilityService = availabilityService3;
        this.audioPlayerService = audioPlayerService3;
        this.accountRepository = tigerBoxAccountRepository2;
        this.playbackPositionService = playbackPositionService3;
        this.lastUsedProductService = lastUsedProductService3;
        this.playbackTrackingService = playbackTrackingService3;
        this.powerManagementService = powerManagementService3;
        this.tigerCardsManagerService = tigerCardsManagerService3;
        this.nightNightLightTimer = nightLightTimerService2;
        this.updateCheckTimer = updateCheckTimerService2;
        this.mediaRestController = mediaRestController3;
        this.metaDataService = metaDataService2;
        this.reportInformationUseCase = reportInformationUseCase2;
        this.buttonService = buttonService2;
        this.headsetService = headsetService2;
        this.batteryService = batteryService2;
        this.wifiService = wifiService2;
        this.getProductListRequest = getProductListRequest2;
        this.configurationProperties = configurationProperties2;
        this.infoSoundService = infoSoundService2;
        generateCsr.invoke(ViewModelKt.getViewModelScope(this), new Function1<Failure, Unit>(this) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((ProductContentViewModel) this.receiver).handleFailure(failure);
            }
        });
        mediaRestController3.subscribeToContentRefresh(this, new Function0<Unit>(this) {
            final /* synthetic */ ProductContentViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.getMainContent();
            }
        });
        sendDeviceInformation();
        this._deviceName = new MutableLiveData<>(storageService2.getDisplayName());
        this._mainContent = new MutableLiveData<>();
        this._startedAudioProduct = new SingleLiveEvent<>();
        this._closeMediaPlayer = new SingleLiveEvent<>();
        this._multiCardInserted = new SingleLiveEvent<>();
        this._activeError = new SingleLiveEvent<>();
        this._activeTigerTicketStep = new SingleLiveEvent<>();
        this._productList = new SingleLiveEvent<>();
        this._loadingListInProgress = new SingleLiveEvent<>();
        this.profilesListener = new ProductContentViewModel$profilesListener$1(this);
        this.tigerCardListener = new ProductContentViewModel$tigerCardListener$1(this);
        this.headsetListener = new ProductContentViewModel$headsetListener$1(this);
        this.displayNameListener = new ProductContentViewModel$displayNameListener$1(this);
        this.audioServiceListener = new ProductContentViewModel$audioServiceListener$1(this);
        this.availabilityServiceListener = new ProductContentViewModel$availabilityServiceListener$1(this);
    }

    public final TigerCardDomain getMultiProductTigerCard() {
        return this.multiProductTigerCard;
    }

    public final void setMultiProductTigerCard(TigerCardDomain tigerCardDomain) {
        this.multiProductTigerCard = tigerCardDomain;
    }

    public final LiveData<String> getDeviceName() {
        return this._deviceName;
    }

    public final LiveData<List<ProductRowDomain>> getMainContent() {
        return this._mainContent;
    }

    public final LiveData<AudioProductInfo> getStartedAudioProduct() {
        return this._startedAudioProduct;
    }

    public final LiveData<Unit> getCloseMediaPlayer() {
        return this._closeMediaPlayer;
    }

    public final LiveData<Boolean> getMultiCardInserted() {
        return this._multiCardInserted;
    }

    public final String getActiveErrorMessage() {
        return this.activeErrorMessage;
    }

    public final void setActiveErrorMessage(String str) {
        this.activeErrorMessage = str;
    }

    public final LiveData<InfoDialogType> getActiveError() {
        return this._activeError;
    }

    public final LiveData<TigerTicketStepDomain> getActiveTigerTicketStep() {
        return this._activeTigerTicketStep;
    }

    public final LiveData<List<ProductDomain>> getProductList() {
        return this._productList;
    }

    public final LiveData<Boolean> getLoadingListInProgress() {
        return this._loadingListInProgress;
    }

    public final void playBatteryBelow5PercentIfNeeded() {
        this.batteryService.playBatteryBelow5PercentIfNeeded();
    }

    public final void unsubscribeFromContentRefresh() {
        this.mediaRestController.unsubscribeToContentRefresh(this);
    }

    private final void sendDeviceInformation() {
        this.reportInformationUseCase.invoke(new ReportInformationRequestBody(this.metaDataService.getCpuId(), this.metaDataService.getSerialNumber(), this.metaDataService.getFirmwareVersion(), this.metaDataService.getIpAddress()), ViewModelKt.getViewModelScope(this), new ProductContentViewModel$sendDeviceInformation$1(this));
    }

    /* renamed from: getMainContent  reason: collision with other method in class */
    public final void m2401getMainContent() {
        this.getMainContentUseCase.invoke(Unit.INSTANCE, ViewModelKt.getViewModelScope(this), new ProductContentViewModel$getMainContent$1(this));
    }

    public final void registerListeners() {
        Timber.Forest.mo50221i("ProductContentViewModel registerListeners", new Object[0]);
        this.availabilityService.registerListener(this.availabilityServiceListener, false);
        this.audioPlayerService.registerListener(this.audioServiceListener);
        this.tigerCardsManagerService.registerListener(this.tigerCardListener);
        this.headsetService.subscribe(this.headsetListener);
        this.metaDataService.registerDisplayNameChangeListener(this.displayNameListener);
        this.accountRepository.registerProfileChangeListener(this.profilesListener);
        this.accountRepository.requestUpdatedProfilesInfoFromServer(ProductContentViewModel$registerListeners$1.INSTANCE);
    }

    public void onCleared() {
        Timber.Forest.mo50221i("ProductContentViewModel onCleared", new Object[0]);
        this.audioPlayerService.unregisterListener(this.audioServiceListener);
        this.availabilityService.unregisterListener(this.availabilityServiceListener);
        this.tigerCardsManagerService.unregisterListener(this.tigerCardListener);
        this.headsetService.unsubscribe(this.headsetListener);
        this.metaDataService.unregisterDisplayNameChangeListener(this.displayNameListener);
        this.accountRepository.unregisterProfileChangeListener(this.profilesListener);
        super.onCleared();
    }

    /* access modifiers changed from: private */
    public final void handleMainContentLayout(List<ProductRowDomain> list) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ProductContentViewModel$handleMainContentLayout$1(list, CollectionsKt.toMutableList(list), this, (Continuation<? super ProductContentViewModel$handleMainContentLayout$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void filterNonBannerWithContent(ProductRowDomain productRowDomain, List<ProductRowDomain> list, List<ProductDomain> list2) {
        Collection collection = list2;
        if (!collection.isEmpty()) {
            productRowDomain.getProducts().clear();
            productRowDomain.getProducts().addAll(collection);
        } else if (!productRowDomain.isOfflineRowType()) {
            list.remove(productRowDomain);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isNotBannerOrBannerWithContent(ProductRowDomain productRowDomain) {
        boolean z = productRowDomain.getLayoutItemType() != ProductRowType.BANNER && (productRowDomain.getProducts().isEmpty() ^ true);
        boolean z2 = productRowDomain.getLayoutItemType() == ProductRowType.BANNER && (productRowDomain.getBannerProducts().isEmpty() ^ true);
        if (z || z2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void updateProductAvailableStatus(List<ProductRowDomain> list) {
        List arrayList = new ArrayList();
        for (ProductRowDomain productRowDomain : list) {
            List arrayList2 = new ArrayList();
            for (ProductDomain productDomain : productRowDomain.getProducts()) {
                OfflineAvailabilityState offlineStateForProduct = offlineStateForProduct(productDomain);
                if (offlineStateForProduct != productDomain.getOfflineAvailabilityState()) {
                    arrayList2.add(ProductDomain.copy$default(productDomain, 0, (String) null, (String) null, (String) null, false, offlineStateForProduct, this.availabilityService.offlineAvailabilityReason(productDomain.getId()), false, (ProductSource) null, 287, (Object) null));
                } else {
                    arrayList2.add(productDomain);
                }
            }
            arrayList.add(ProductRowDomain.copy$default(productRowDomain, 0, (String) null, (ProductRowType) null, (String) null, (String) null, arrayList2, (List) null, (String) null, 223, (Object) null));
        }
        updateOfflineContent(arrayList);
        List arrayList3 = new ArrayList();
        List<ProductDomain> value = this._productList.getValue();
        if (value != null) {
            for (ProductDomain productDomain2 : value) {
                OfflineAvailabilityState offlineStateForProduct2 = offlineStateForProduct(productDomain2);
                if (offlineStateForProduct2 != productDomain2.getOfflineAvailabilityState()) {
                    arrayList3.add(ProductDomain.copy$default(productDomain2, 0, (String) null, (String) null, (String) null, false, offlineStateForProduct2, this.availabilityService.offlineAvailabilityReason(productDomain2.getId()), false, (ProductSource) null, 287, (Object) null));
                } else {
                    arrayList3.add(productDomain2);
                }
            }
        }
        this._mainContent.setValue(arrayList);
        this._productList.setValue(arrayList3);
    }

    private final OfflineAvailabilityState offlineStateForProduct(ProductDomain productDomain) {
        if (this.availabilityService.offlineAvailabilityReason(productDomain.getId()) == DownloadReason.AUTOMATIC_BY_NFC_CARD) {
            return OfflineAvailabilityState.NOT_AVAILABLE;
        }
        if (this.productAcquisitionService.isDownloadAcquisitionInProgress(productDomain.getId())) {
            return OfflineAvailabilityState.IN_PROGRESS;
        }
        return this.availabilityService.offlineAvailabilityStateFor(productDomain.getId(), true);
    }

    private final void updateOfflineContent(List<ProductRowDomain> list) {
        ProductRowDomain offlineContentRow = getOfflineContentRow(list);
        if (offlineContentRow == null) {
            offlineContentRow = this.offlineRow;
        }
        List<ProductDomain> downloadedProducts = this.availabilityService.downloadedProducts();
        if (offlineContentRow != null) {
            offlineContentRow.getProducts().clear();
            offlineContentRow.getProducts().addAll(downloadedProducts);
            if (offlineContentRow.getProducts().isEmpty() && containsOfflineContent(list)) {
                Collection.EL.removeIf(list, ProductContentViewModel$$ExternalSyntheticLambda0.INSTANCE);
            } else if ((!offlineContentRow.getProducts().isEmpty()) && doesNotContainOfflineContent(list) && this.offlineRowPosition != -1 && (!list.isEmpty())) {
                list.add(this.offlineRowPosition, offlineContentRow);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateOfflineContent$lambda-4$lambda-3  reason: not valid java name */
    public static final boolean m2400updateOfflineContent$lambda4$lambda3(ProductRowDomain productRowDomain) {
        Intrinsics.checkNotNullParameter(productRowDomain, "row");
        return productRowDomain.isOfflineRowType();
    }

    public final void clearProductList() {
        this._loadingListInProgress.setValue(true);
        this._productList.setValue(new ArrayList());
    }

    public final void showMultiProductList() {
        List<ProductDomain> list;
        TigerCardDomain.MultiTigercardVariantDomain multiTigercardVariant;
        List<ProductDetailsDto> products;
        String str;
        ProductDetailsDto.Links.Link cover;
        this._loadingListInProgress.setValue(false);
        TigerCardDomain tigerCardDomain = this.multiProductTigerCard;
        if (tigerCardDomain == null || (multiTigercardVariant = tigerCardDomain.getMultiTigercardVariant()) == null || (products = multiTigercardVariant.getProducts()) == null) {
            list = CollectionsKt.emptyList();
        } else {
            Iterable<ProductDetailsDto> iterable = products;
            java.util.Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ProductDetailsDto productDetailsDto : iterable) {
                int id = productDetailsDto.getId();
                String title = productDetailsDto.getTitle();
                String str2 = title == null ? "" : title;
                String author = productDetailsDto.getAuthor();
                if (author == null) {
                    str = "";
                } else {
                    str = author;
                }
                ProductDetailsDto.Links links = productDetailsDto.get_links();
                String href = (links == null || (cover = links.getCover()) == null) ? null : cover.getHref();
                if (href == null) {
                    href = "";
                }
                arrayList.add(new ProductDomain(id, str2, str, href, false, OfflineAvailabilityState.NOT_AVAILABLE, DownloadReason.NONE, false, ProductSource.MULTI_PRODUCT_CARD));
            }
            list = (List) arrayList;
        }
        List arrayList2 = new ArrayList();
        for (ProductDomain productDomain : list) {
            OfflineAvailabilityState offlineStateForProduct = offlineStateForProduct(productDomain);
            if (offlineStateForProduct != productDomain.getOfflineAvailabilityState()) {
                arrayList2.add(ProductDomain.copy$default(productDomain, 0, (String) null, (String) null, (String) null, false, offlineStateForProduct, this.availabilityService.offlineAvailabilityReason(productDomain.getId()), false, (ProductSource) null, 287, (Object) null));
            } else {
                arrayList2.add(productDomain);
            }
        }
        this._productList.setValue(arrayList2);
    }

    public final void getProductList(int i, int i2) {
        ProductRowDomain productRowDomain;
        Object obj;
        boolean z;
        List value = this._mainContent.getValue();
        if ((value != null ? Integer.valueOf(value.size()) : null) == null || i < 0 || i2 < -1) {
            handleFailure(ShopLayoutFailure.InternalError.INSTANCE);
            return;
        }
        List value2 = this._mainContent.getValue();
        if (value2 != null) {
            Iterator it = value2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ProductRowDomain) obj).getId() == i) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            productRowDomain = (ProductRowDomain) obj;
        } else {
            productRowDomain = null;
        }
        if (productRowDomain == null) {
            return;
        }
        if (productRowDomain.getLayoutItemType() != ProductRowType.BANNER) {
            List arrayList = new ArrayList();
            arrayList.addAll(productRowDomain.getProducts());
            this._productList.setValue(arrayList);
            fetchNextLinkProductListData(productRowDomain, arrayList, new ProductContentViewModel$getProductList$1$1(this));
        } else if (i2 > productRowDomain.getBannerProducts().size() || i2 == -1) {
            handleFailure(ShopLayoutFailure.InternalError.INSTANCE);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ProductContentViewModel$getProductList$1$2(this, productRowDomain, i2, (Continuation<? super ProductContentViewModel$getProductList$1$2>) null), 3, (Object) null);
        }
    }

    static /* synthetic */ Job fetchNextLinkProductListData$default(ProductContentViewModel productContentViewModel, ProductRowDomain productRowDomain, List list, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return productContentViewModel.fetchNextLinkProductListData(productRowDomain, list, function1);
    }

    /* access modifiers changed from: private */
    public final Job fetchNextLinkProductListData(ProductRowDomain productRowDomain, List<ProductDomain> list, Function1<? super List<ProductDomain>, Unit> function1) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ProductContentViewModel$fetchNextLinkProductListData$1(productRowDomain, this, function1, list, (Continuation<? super ProductContentViewModel$fetchNextLinkProductListData$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void handleFailure(Failure failure) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        this._loadingListInProgress.postValue(false);
        super.handleFailure(failure);
    }

    /* access modifiers changed from: private */
    public final Function1<List<ProductDomain>, Job> handleGetBannerProductListResponse(ProductRowDomain productRowDomain) {
        return new ProductContentViewModel$handleGetBannerProductListResponse$1(this, productRowDomain);
    }

    /* access modifiers changed from: private */
    public final void handleAcquisitionError(ProductAcquisitionService.ErrorCode errorCode) {
        int i;
        this._activeError.setValue(null);
        if (errorCode == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[errorCode.ordinal()];
        }
        if (i == 1) {
            this._activeError.setValue(InfoDialogType.NO_WIRELESS_SIGNAL);
        } else if (i == 2) {
            this._activeError.setValue(InfoDialogType.ACCESS_FAILURE);
        } else if (i == 3) {
            this._activeError.setValue(InfoDialogType.GENERAL_ERROR);
        } else if (i != 4) {
            this._activeError.setValue(null);
        }
    }

    /* access modifiers changed from: private */
    public final void startPlaybackWithRowProducts(ProductDomain productDomain, List<ProductDomain> list) {
        List list2;
        if (list != null) {
            Iterable<ProductDomain> iterable = list;
            java.util.Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ProductDomain productDomain2 : iterable) {
                arrayList.add(new PlaybackDto(productDomain2.getId(), productDomain2.getImageUrl(), productDomain2.getTitle(), productDomain2.getAuthor(), (Boolean) null, 16, (DefaultConstructorMarker) null));
            }
            list2 = (List) arrayList;
        } else {
            list2 = null;
        }
        java.util.Collection collection = list2;
        if (!(collection == null || collection.isEmpty())) {
            if (productDomain.getSource() != ProductSource.MULTI_PRODUCT_CARD) {
                this.audioPlayerService.streamPlaylist(AudioPlaylist.Companion.create(list2, productDomain.getId(), AudioPlaybackReason.DEFAULT, (TigerCardDomain) null), new ProductContentViewModel$startPlaybackWithRowProducts$2(this));
            } else if (this.multiProductTigerCard != null) {
                this.audioPlayerService.streamPlaylist(AudioPlaylist.Companion.create(list2, productDomain.getId(), AudioPlaybackReason.TIGERCARD, this.multiProductTigerCard), new ProductContentViewModel$startPlaybackWithRowProducts$1$1(this));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: media.tiger.tigerbox.model.domain.ProductRowDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: media.tiger.tigerbox.model.domain.ProductRowDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: media.tiger.tigerbox.model.domain.ProductRowDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: media.tiger.tigerbox.model.domain.ProductRowDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: media.tiger.tigerbox.model.domain.ProductRowDomain} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void playProduct(media.tiger.tigerbox.model.domain.ProductDomain r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "product"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r0 = r10.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r0 = r0.getCurrentProductInfo()
            if (r0 == 0) goto L_0x002c
            int r1 = r0.getId()
            int r2 = r11.getId()
            if (r1 != r2) goto L_0x002c
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r11 = r10.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState r11 = r11.getState()
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState r12 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState.PLAYING
            if (r11 == r12) goto L_0x0026
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r11 = r10.audioPlayerService
            r11.play()
        L_0x0026:
            media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent<media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo> r11 = r10._startedAudioProduct
            r11.postValue(r0)
            return
        L_0x002c:
            java.lang.String r0 = r11.getImageUrl()
            if (r0 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            java.lang.String r0 = ""
        L_0x0035:
            r4 = r0
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r0 = new media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo
            int r2 = r11.getId()
            java.lang.String r5 = r11.getTitle()
            java.lang.String r6 = r11.getAuthor()
            r7 = 0
            r8 = 32
            r9 = 0
            java.lang.String r3 = ""
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r1 = r10.audioPlayerService
            r1.setInitialPlaylistProduct(r0)
            media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent<media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo> r1 = r10._startedAudioProduct
            r1.postValue(r0)
            r0 = -1
            if (r12 == r0) goto L_0x00c4
            r0 = 1000(0x3e8, float:1.401E-42)
            if (r12 == r0) goto L_0x00ba
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            androidx.lifecycle.MutableLiveData<java.util.List<media.tiger.tigerbox.model.domain.ProductRowDomain>> r1 = r10._mainContent
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            r2 = 0
            if (r1 == 0) goto L_0x0092
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0077:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0090
            java.lang.Object r3 = r1.next()
            r4 = r3
            media.tiger.tigerbox.model.domain.ProductRowDomain r4 = (media.tiger.tigerbox.model.domain.ProductRowDomain) r4
            int r4 = r4.getId()
            if (r4 != r12) goto L_0x008c
            r4 = 1
            goto L_0x008d
        L_0x008c:
            r4 = 0
        L_0x008d:
            if (r4 == 0) goto L_0x0077
            r2 = r3
        L_0x0090:
            media.tiger.tigerbox.model.domain.ProductRowDomain r2 = (media.tiger.tigerbox.model.domain.ProductRowDomain) r2
        L_0x0092:
            if (r2 == 0) goto L_0x00cf
            java.util.List r12 = r2.getProducts()
            java.util.Collection r12 = (java.util.Collection) r12
            r0.addAll(r12)
            boolean r12 = r2.getHasLoadMore()
            if (r12 == 0) goto L_0x00b6
            media.tiger.tigerbox.services.interfaces.StorageService r12 = r10.storageService
            boolean r12 = r12.getAutoplay()
            if (r12 == 0) goto L_0x00b6
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$playProduct$3$1 r12 = new media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$playProduct$3$1
            r12.<init>(r10, r11)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r10.fetchNextLinkProductListData(r2, r0, r12)
            goto L_0x00cf
        L_0x00b6:
            r10.startPlaybackWithRowProducts(r11, r0)
            goto L_0x00cf
        L_0x00ba:
            media.tiger.tigerbox.services.interfaces.AvailabilityService r12 = r10.availabilityService
            java.util.List r12 = r12.downloadedProducts()
            r10.startPlaybackWithRowProducts(r11, r12)
            goto L_0x00cf
        L_0x00c4:
            media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent<java.util.List<media.tiger.tigerbox.model.domain.ProductDomain>> r12 = r10._productList
            java.lang.Object r12 = r12.getValue()
            java.util.List r12 = (java.util.List) r12
            r10.startPlaybackWithRowProducts(r11, r12)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.maincontent.ProductContentViewModel.playProduct(media.tiger.tigerbox.model.domain.ProductDomain, int):void");
    }

    public final void downloadProduct(ProductDomain productDomain) {
        Intrinsics.checkNotNullParameter(productDomain, "product");
        if (this.availabilityService.offlineAvailabilityReason(productDomain.getId()) == DownloadReason.AUTOMATIC_BY_NFC_CARD) {
            this.availabilityService.changeDownloadReasonForProduct(productDomain.getId(), DownloadReason.MANUAL, new ProductContentViewModel$downloadProduct$1(this));
        } else {
            this.productAcquisitionService.downloadProduct(productDomain.getId(), productDomain.getSource() == ProductSource.MULTI_PRODUCT_CARD ? AcquisitionReason.TIGERCARD : AcquisitionReason.MANUAL, (ProductAcquisitionDelegate) null, new ProductContentViewModel$downloadProduct$2(this));
        }
    }

    public final void updateListDlStatus() {
        List value = this._mainContent.getValue();
        if (value == null) {
            value = CollectionsKt.emptyList();
        }
        updateProductAvailableStatus(value);
    }

    public final void removeDownloadedProduct(ProductDomain productDomain) {
        Intrinsics.checkNotNullParameter(productDomain, "product");
        this.availabilityService.removeProduct(productDomain.getId());
    }

    public final void confirmOfflineMode() {
        this.wifiService.confirmOfflineMode();
    }

    public final String getOfflineRowTitle() {
        return this.storageService.getOfflineRowTitle();
    }

    private final boolean containsOfflineContent(List<ProductRowDomain> list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ProductRowDomain) obj).isOfflineRowType()) {
                break;
            }
        }
        return obj != null;
    }

    private final boolean doesNotContainOfflineContent(List<ProductRowDomain> list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ProductRowDomain) obj).isOfflineRowType()) {
                break;
            }
        }
        return obj == null;
    }

    private final ProductRowDomain getOfflineContentRow(List<ProductRowDomain> list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ProductRowDomain) obj).isOfflineRowType()) {
                break;
            }
        }
        return (ProductRowDomain) obj;
    }

    public final Function1<Failure, Unit> getOnFail() {
        return this.onFail;
    }

    public final void setOnFail(Function1<? super Failure, Unit> function1) {
        this.onFail = function1;
    }
}
