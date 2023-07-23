package media.tiger.tigerbox.services.implementations.audioPlayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.extension.AndroidKt;
import media.tiger.tigerbox.model.domain.DownloadReason;
import media.tiger.tigerbox.model.domain.OfflineAvailabilityState;
import media.tiger.tigerbox.p016ui.common.TimedRefreshHandler;
import media.tiger.tigerbox.services.implementations.timersController.TimersControllerKt;
import media.tiger.tigerbox.services.interfaces.AcquisitionReason;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionDelegate;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel;
import media.tiger.tigerbox.services.interfaces.audioPlayer.HlsKeyProviderService;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;
import media.tiger.tigerbox.webserver.dto.PlaybackDto;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00028^\u0018\u0000 ³\u00012\u00020\u0001:\u0004²\u0001³\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u00020\u001aH\u0002J\u0018\u0010t\u001a\u00020p2\u0006\u0010u\u001a\u00020*2\u0006\u0010k\u001a\u00020\u0016H\u0002J\u0018\u0010v\u001a\u00020p2\u0006\u0010u\u001a\u00020*2\u0006\u0010k\u001a\u00020\u0016H\u0002J\b\u0010w\u001a\u00020pH\u0002J\b\u0010x\u001a\u00020pH\u0002J\b\u0010y\u001a\u00020pH\u0002J\b\u0010z\u001a\u00020pH\u0002J\u0010\u0010{\u001a\u00020p2\u0006\u0010k\u001a\u00020\u0016H\u0002J\b\u0010|\u001a\u00020pH\u0002J\u0010\u0010}\u001a\u00020p2\u0006\u0010k\u001a\u00020\u0016H\u0002J\u0011\u0010~\u001a\u00020p2\u0007\u0010\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020pH\u0002J\"\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020F2\u0006\u0010u\u001a\u00020*2\u0006\u0010k\u001a\u00020\u0016H\u0002J\"\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020F2\u0006\u0010u\u001a\u00020*2\u0006\u0010k\u001a\u00020\u0016H\u0002J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020FH\u0002J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020FH\u0002J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020FH\u0002J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020FH\u0002J\u001a\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020F2\u0006\u0010k\u001a\u00020\u0016H\u0002J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020FH\u0002J\u001a\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020F2\u0006\u0010k\u001a\u00020\u0016H\u0002J\t\u0010\u0001\u001a\u00020pH\u0016J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u001aH\u0002J\t\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0014H\u0002J\u0013\u0010\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u0001H\u0002Ja\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020\u001a2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00162*\u0010\u0001\u001a%\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000e\b\u0001\u0012\t\b\u0001\u0012\u0004\b\b(\u0012\u0004\u0012\u00020p\u0018\u00010\u0001H\u0002¢\u0006\u0003\u0010 \u0001J\u0011\u0010¡\u0001\u001a\u00020p2\u0006\u0010k\u001a\u00020\u0016H\u0002J\u0012\u0010¢\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020FH\u0016J\u0012\u0010£\u0001\u001a\u00020p2\u0007\u0010¤\u0001\u001a\u00020\u0018H\u0016J\t\u0010¥\u0001\u001a\u00020pH\u0002J\t\u0010¦\u0001\u001a\u00020pH\u0016J\t\u0010§\u0001\u001a\u00020pH\u0016J\t\u0010¨\u0001\u001a\u00020pH\u0002J<\u0010©\u0001\u001a\u00020p2\u0007\u0010ª\u0001\u001a\u00020\u001f2(\u0010«\u0001\u001a#\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000e\b\u0001\u0012\t\b\u0001\u0012\u0004\b\b(\u0012\u0004\u0012\u00020p0\u0001H\u0016J\t\u0010¬\u0001\u001a\u00020pH\u0016J\u0014\u0010­\u0001\u001a\u0005\u0018\u00010®\u00012\u0006\u0010k\u001a\u00020\u0016H\u0002J\u0012\u0010¯\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020FH\u0016J\u0012\u0010°\u0001\u001a\u00020p2\u0007\u0010±\u0001\u001a\u00020\u0016H\u0016R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u0004\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u0004\u0018\u00010\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R$\u0010.\u001a\u00020*2\u0006\u0010-\u001a\u00020*8V@VX\u000e¢\u0006\f\u001a\u0004\b/\u0010,\"\u0004\b0\u00101R$\u00102\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00168V@VX\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u00107\u001a\u000208X\u0004¢\u0006\u0004\n\u0002\u00109R\u000e\u0010:\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010=R\u0014\u0010@\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010=R\u0014\u0010B\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010=R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u0012\u0012\u0004\u0012\u00020F0Ej\b\u0012\u0004\u0012\u00020F`GX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bJ\u0010KR\u000e\u0010N\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010O\u001a\u0004\u0018\u00010P8VX\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020T8VX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010=R\u0014\u0010Y\u001a\u00020*8VX\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010,R\u0014\u0010[\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\\\u00104R\u0010\u0010]\u001a\u00020^X\u0004¢\u0006\u0004\n\u0002\u0010_R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\u00020c8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010f\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\bg\u00104R\u000e\u0010h\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0004¢\u0006\u0002\n\u0000R$\u0010k\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00168V@VX\u000e¢\u0006\f\u001a\u0004\bl\u00104\"\u0004\bm\u00106R\u000e\u0010n\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000¨\u0006´\u0001"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioPlayer;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "context", "Landroid/content/Context;", "hlsService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "acquisitionService", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "audioManager", "Landroid/media/AudioManager;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "lockedModeService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;Landroid/media/AudioManager;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;)V", "_currentItem", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "_currentTrackIndex", "", "_initialPlaylistProductInfo", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "_isPlaying", "", "_isPreparingItem", "_isPreparingPlaylist", "_notificationsEnabled", "_playlist", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylist;", "currentItem", "getCurrentItem", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "currentPlaylist", "getCurrentPlaylist", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylist;", "currentProductInfo", "getCurrentProductInfo", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "currentTrackDuration", "", "getCurrentTrackDuration", "()J", "newValue", "currentTrackPosition", "getCurrentTrackPosition", "setCurrentTrackPosition", "(J)V", "currentTrackProgress", "getCurrentTrackProgress", "()I", "setCurrentTrackProgress", "(I)V", "exoListener", "media/tiger/tigerbox/services/implementations/audioPlayer/AudioPlayer$exoListener$1", "Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioPlayer$exoListener$1;", "hasAskedToDownload", "hasNext", "getHasNext", "()Z", "hasNextPlaylistItems", "getHasNextPlaylistItems", "hasPrevious", "getHasPrevious", "hasPreviousPlaylistItems", "getHasPreviousPlaylistItems", "listeners", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackListener;", "Lkotlin/collections/ArrayList;", "mExoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "getMExoPlayer", "()Lcom/google/android/exoplayer2/ExoPlayer;", "mExoPlayer$delegate", "Lkotlin/Lazy;", "mPreparePlayerTryCount", "playbackDto", "Lmedia/tiger/tigerbox/webserver/dto/PlaybackDto;", "getPlaybackDto", "()Lmedia/tiger/tigerbox/webserver/dto/PlaybackDto;", "playbackReason", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackReason;", "getPlaybackReason", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackReason;", "playerHasError", "getPlayerHasError", "playlistPosition", "getPlaylistPosition", "playlistProgress", "getPlaylistProgress", "profileChangeListener", "media/tiger/tigerbox/services/implementations/audioPlayer/AudioPlayer$profileChangeListener$1", "Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioPlayer$profileChangeListener$1;", "progressRefreshJob", "Lkotlinx/coroutines/Job;", "state", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "getState", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "streamMaxVolume", "getStreamMaxVolume", "streamVolume", "timedRefreshHandler", "Lmedia/tiger/tigerbox/ui/common/TimedRefreshHandler;", "trackIndex", "getTrackIndex", "setTrackIndex", "uninterruptedListeningSec", "downloadCurrentAudioItem", "", "reason", "Lmedia/tiger/tigerbox/model/domain/DownloadReason;", "isAllowedToPlay", "notifyAllOnPlaybackBeginScrubbing", "trackPosition", "notifyAllOnPlaybackEndScrubbing", "notifyAllOnPlaybackModelChanged", "notifyAllOnPlaybackPlaylistChangeReady", "notifyAllOnPlaybackPlaylistWillChange", "notifyAllOnPlaybackStateChanged", "notifyAllOnPlaybackTrackDidChange", "notifyAllOnPlaybackTrackPositionChanged", "notifyAllOnPlaybackTrackWillChange", "notifyAllOnProductAcquisitionError", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "notifyAllOnProductPlaybackEnd", "onPlaybackBeginScrubbing", "listener", "onPlaybackEndScrubbing", "onPlaybackModelChanged", "onPlaybackPlaylistChangeReady", "onPlaybackPlaylistWillChange", "onPlaybackStateChanged", "onPlaybackTrackDidChange", "onPlaybackTrackPositionChanged", "onPlaybackTrackWillChange", "pause", "performGoNext", "byUser", "play", "playNext", "playPlaylistItem", "idx", "playPrevious", "prepare", "item", "preparePlayerWithTrackPath", "path", "Landroid/net/Uri;", "preparePlaylistItem", "useDtoPlayPosition", "playItemIdx", "onStreamReady", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(ZZZLjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Z", "prepareTrack", "registerListener", "setInitialPlaylistProduct", "product", "startProgressRefreshHandler", "stop", "stopPlayingNonCardsProducts", "stopProgressRefreshHandler", "streamPlaylist", "playlist", "onAcquisitionReady", "togglePlayPause", "trackAtIndex", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioTrackModel;", "unregisterListener", "updateStreamMusicVolume", "volume", "AudioServiceHLSDataSourceFactory", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlayer.kt */
public final class AudioPlayer implements AudioPlayerService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DOWNLOAD_AFTER_TIME = 60000;
    private static final int GO_TO_PREVIOUS_TRACK_PROGRESS_SEC = 5;
    private static final int MAX_TRY_CNT = 4;
    private static final long PROGRESS_REFRESH_TIME = 1000;
    private static final int SECONDS_TO_MILLISECONDS_FACTOR = 1000;
    private AudioItem _currentItem;
    /* access modifiers changed from: private */
    public int _currentTrackIndex = -1;
    private AudioProductInfo _initialPlaylistProductInfo;
    /* access modifiers changed from: private */
    public boolean _isPlaying;
    /* access modifiers changed from: private */
    public boolean _isPreparingItem;
    /* access modifiers changed from: private */
    public boolean _isPreparingPlaylist;
    /* access modifiers changed from: private */
    public boolean _notificationsEnabled = true;
    /* access modifiers changed from: private */
    public AudioPlaylist _playlist;
    private final TigerBoxAccountRepository accountRepository;
    private final ProductAcquisitionService acquisitionService;
    private final AudioManager audioManager;
    /* access modifiers changed from: private */
    public final AvailabilityService availabilityService;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final AudioPlayer$exoListener$1 exoListener = new AudioPlayer$exoListener$1(this);
    /* access modifiers changed from: private */
    public boolean hasAskedToDownload;
    private final HlsKeyProviderService hlsService;
    private ArrayList<AudioPlaybackListener> listeners = new ArrayList<>();
    private final LockedModeService lockedModeService;
    private final Lazy mExoPlayer$delegate = LazyKt.lazy(new AudioPlayer$mExoPlayer$2(this));
    private int mPreparePlayerTryCount;
    private final AudioPlayer$profileChangeListener$1 profileChangeListener;
    private Job progressRefreshJob;
    private final StorageService storageService;
    private int streamVolume = getStreamMaxVolume();
    /* access modifiers changed from: private */
    public final TimedRefreshHandler timedRefreshHandler = new TimedRefreshHandler();
    /* access modifiers changed from: private */
    public long uninterruptedListeningSec;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AudioPlayer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudioPlaybackReason.values().length];
            iArr[AudioPlaybackReason.DEFAULT.ordinal()] = 1;
            iArr[AudioPlaybackReason.TIGERCARD.ordinal()] = 2;
            iArr[AudioPlaybackReason.WILDCARD.ordinal()] = 3;
            iArr[AudioPlaybackReason.WILDCARD_USER_CONTENT.ordinal()] = 4;
            iArr[AudioPlaybackReason.WEBSERVER_INITIATED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean getHasPrevious() {
        return true;
    }

    public AudioPlayer(Context context2, HlsKeyProviderService hlsKeyProviderService, StorageService storageService2, AvailabilityService availabilityService2, ProductAcquisitionService productAcquisitionService, AudioManager audioManager2, TigerBoxAccountRepository tigerBoxAccountRepository, LockedModeService lockedModeService2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(hlsKeyProviderService, "hlsService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        Intrinsics.checkNotNullParameter(productAcquisitionService, "acquisitionService");
        Intrinsics.checkNotNullParameter(audioManager2, "audioManager");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(lockedModeService2, "lockedModeService");
        this.context = context2;
        this.hlsService = hlsKeyProviderService;
        this.storageService = storageService2;
        this.availabilityService = availabilityService2;
        this.acquisitionService = productAcquisitionService;
        this.audioManager = audioManager2;
        this.accountRepository = tigerBoxAccountRepository;
        this.lockedModeService = lockedModeService2;
        AudioPlayer$profileChangeListener$1 audioPlayer$profileChangeListener$1 = new AudioPlayer$profileChangeListener$1(this);
        this.profileChangeListener = audioPlayer$profileChangeListener$1;
        tigerBoxAccountRepository.registerProfileChangeListener(audioPlayer$profileChangeListener$1);
    }

    public int getStreamMaxVolume() {
        return this.audioManager.getStreamMaxVolume(3);
    }

    public void updateStreamMusicVolume(int i) {
        this.streamVolume = i;
        this.audioManager.setStreamVolume(3, i, 0);
    }

    /* access modifiers changed from: private */
    public final ExoPlayer getMExoPlayer() {
        return (ExoPlayer) this.mExoPlayer$delegate.getValue();
    }

    public AudioPlaylist getCurrentPlaylist() {
        return this._playlist;
    }

    /* access modifiers changed from: private */
    public final boolean isAllowedToPlay() {
        return !TimersControllerKt.isInLockedMode(this.lockedModeService.checkLockedMode());
    }

    public void setInitialPlaylistProduct(AudioProductInfo audioProductInfo) {
        Intrinsics.checkNotNullParameter(audioProductInfo, "product");
        notifyAllOnPlaybackPlaylistWillChange();
        this._initialPlaylistProductInfo = audioProductInfo;
        this._isPreparingPlaylist = true;
        notifyAllOnPlaybackPlaylistChangeReady();
    }

    public void streamPlaylist(AudioPlaylist audioPlaylist, Function1<? super ProductAcquisitionService.ErrorCode, Unit> function1) {
        Intrinsics.checkNotNullParameter(audioPlaylist, "playlist");
        Intrinsics.checkNotNullParameter(function1, "onAcquisitionReady");
        if (isAllowedToPlay()) {
            this._isPreparingPlaylist = true;
            this._isPreparingItem = true;
            this._playlist = audioPlaylist;
            preparePlaylistItem(true, false, false, (Integer) null, new AudioPlayer$streamPlaylist$1(this, function1));
        }
    }

    private final boolean preparePlaylistItem(boolean z, boolean z2, boolean z3, Integer num, Function1<? super ProductAcquisitionService.ErrorCode, Unit> function1) {
        AcquisitionReason acquisitionReason;
        if (!isAllowedToPlay()) {
            return false;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        AudioPlaylist audioPlaylist = this._playlist;
        if (audioPlaylist != null) {
            int activeIdx = audioPlaylist.getActiveIdx();
            int activeIdx2 = audioPlaylist.getActiveIdx();
            if (z3) {
                activeIdx2--;
            } else if (z2) {
                activeIdx2++;
            }
            if (num != null) {
                activeIdx2 = num.intValue();
            }
            if (activeIdx2 >= 0 && activeIdx2 < audioPlaylist.getProducts().size()) {
                AudioPlaylist audioPlaylist2 = this._playlist;
                if (audioPlaylist2 != null) {
                    audioPlaylist2.setActiveIdx(activeIdx2);
                }
                PlaybackDto playbackDto = audioPlaylist.getProducts().get(activeIdx2);
                int productId = playbackDto.getProductId();
                int i = WhenMappings.$EnumSwitchMapping$0[audioPlaylist.getReason().ordinal()];
                if (i == 1) {
                    acquisitionReason = AcquisitionReason.MANUAL;
                } else if (i == 2) {
                    acquisitionReason = AcquisitionReason.TIGERCARD;
                } else if (i == 3) {
                    acquisitionReason = AcquisitionReason.WILDCARD;
                } else if (i == 4) {
                    acquisitionReason = AcquisitionReason.WILDCARD_USER_CONTENT;
                } else if (i == 5) {
                    acquisitionReason = AcquisitionReason.WEBSERVER;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                this.acquisitionService.checkProduct(productId, acquisitionReason, audioPlaylist.getNfc(), (ProductAcquisitionDelegate) null, new AudioPlayer$preparePlaylistItem$1$2(this, activeIdx, function1, audioPlaylist, productId, playbackDto, z, booleanRef));
            }
        }
        return booleanRef.element;
    }

    /* access modifiers changed from: private */
    public final void prepare(AudioItem audioItem) {
        AudioItem audioItem2 = this._currentItem;
        if (audioItem2 == null || audioItem2.getTracks().size() <= 0 || audioItem2.getProduct().getId() != audioItem.getProduct().getId()) {
            stop();
            updateStreamMusicVolume(this.streamVolume);
            this.hasAskedToDownload = false;
            this._currentItem = audioItem;
            this._currentTrackIndex = -1;
            setTrackIndex(0);
            this.availabilityService.noteProductWasUsed(audioItem.getProduct().getId());
            if (getPlaybackReason() == AudioPlaybackReason.TIGERCARD || getPlaybackReason() == AudioPlaybackReason.WILDCARD_USER_CONTENT || getPlaybackReason() == AudioPlaybackReason.WILDCARD) {
                downloadCurrentAudioItem(DownloadReason.AUTOMATIC_BY_NFC_CARD);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void downloadCurrentAudioItem(DownloadReason downloadReason) {
        if (!this.hasAskedToDownload && getCurrentItem() != null) {
            this.hasAskedToDownload = true;
            AvailabilityService availabilityService2 = this.availabilityService;
            AudioItem currentItem = getCurrentItem();
            Intrinsics.checkNotNull(currentItem);
            int id = currentItem.getProduct().getId();
            AudioItem currentItem2 = getCurrentItem();
            Intrinsics.checkNotNull(currentItem2);
            availabilityService2.downloadAudioProduct(id, currentItem2.getNfcPayload(), downloadReason);
        }
    }

    private final boolean getHasNextPlaylistItems() {
        AudioPlaylist audioPlaylist = this._playlist;
        if (audioPlaylist == null || audioPlaylist.getActiveIdx() + 1 >= audioPlaylist.getProducts().size() || !this.storageService.getAutoplay()) {
            return false;
        }
        return true;
    }

    private final boolean getHasPreviousPlaylistItems() {
        AudioPlaylist audioPlaylist = this._playlist;
        if (audioPlaylist == null || audioPlaylist.getActiveIdx() - 1 < 0 || !this.storageService.getAutoplay()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void performGoNext(boolean z) {
        boolean z2 = true;
        this._isPreparingItem = true;
        this.uninterruptedListeningSec = 0;
        if (this._currentItem != null) {
            AndroidKt.runOnUiThread(AudioPlayer$performGoNext$1.INSTANCE);
            int trackIndex = getTrackIndex() + 1;
            AudioItem audioItem = this._currentItem;
            Intrinsics.checkNotNull(audioItem);
            if (trackIndex >= audioItem.getTracks().size()) {
                notifyAllOnProductPlaybackEnd();
                trackIndex = 0;
            } else {
                z2 = false;
            }
            setTrackIndex(trackIndex);
            if (!z && z2) {
                pause();
                setCurrentTrackPosition(0);
            }
            if (z2 && getHasNextPlaylistItems()) {
                preparePlaylistItem(false, true, false, (Integer) null, (Function1<? super ProductAcquisitionService.ErrorCode, Unit>) null);
            }
        }
    }

    public void playNext() {
        performGoNext(true);
    }

    public void playPlaylistItem(int i) {
        this._isPreparingItem = true;
        this.uninterruptedListeningSec = 0;
        preparePlaylistItem(false, false, false, Integer.valueOf(i), (Function1<? super ProductAcquisitionService.ErrorCode, Unit>) null);
    }

    public void playPrevious() {
        if (getCurrentTrackPosition() > 5) {
            setCurrentTrackPosition(0);
            return;
        }
        this._isPreparingItem = true;
        this.uninterruptedListeningSec = 0;
        if (this._currentItem != null) {
            int trackIndex = getTrackIndex() - 1;
            if (trackIndex < 0) {
                this._isPreparingItem = false;
                setTrackIndex(0);
                if (!getHasPreviousPlaylistItems()) {
                    setCurrentTrackPosition(0);
                    play();
                    return;
                }
                notifyAllOnProductPlaybackEnd();
                if (getHasPreviousPlaylistItems()) {
                    preparePlaylistItem(false, false, true, (Integer) null, (Function1<? super ProductAcquisitionService.ErrorCode, Unit>) null);
                    return;
                }
                return;
            }
            this._isPreparingItem = false;
            setTrackIndex(trackIndex);
        }
    }

    public void togglePlayPause() {
        if (getState() == AudioPlaybackState.PLAYING) {
            pause();
        } else if (getState() == AudioPlaybackState.PAUSED || getState() == AudioPlaybackState.STOPPED) {
            play();
        }
    }

    public void play() {
        if (!isAllowedToPlay()) {
            stop();
            return;
        }
        this._isPlaying = true;
        AndroidKt.runOnUiThread(new AudioPlayer$play$1(this));
        notifyAllOnPlaybackStateChanged();
        startProgressRefreshHandler();
    }

    public void pause() {
        AndroidKt.runOnUiThread(new AudioPlayer$pause$1(this));
        this._isPreparingItem = false;
        this.uninterruptedListeningSec = 0;
        if (this._isPlaying) {
            this._isPlaying = false;
            notifyAllOnPlaybackStateChanged();
            stopProgressRefreshHandler();
        }
    }

    public void stop() {
        this._isPlaying = false;
        this._isPreparingItem = false;
        this.uninterruptedListeningSec = 0;
        AndroidKt.runOnUiThread(new AudioPlayer$stop$1(this));
        this._currentItem = null;
        setTrackIndex(-1);
        notifyAllOnPlaybackStateChanged();
        stopProgressRefreshHandler();
    }

    public void stopPlayingNonCardsProducts() {
        if (getPlaybackReason() != AudioPlaybackReason.WILDCARD && getPlaybackReason() != AudioPlaybackReason.TIGERCARD && getPlaybackReason() != AudioPlaybackReason.WILDCARD_USER_CONTENT) {
            stop();
        }
    }

    public AudioItem getCurrentItem() {
        return this._currentItem;
    }

    public AudioProductInfo getCurrentProductInfo() {
        if (this._isPreparingPlaylist) {
            return this._initialPlaylistProductInfo;
        }
        AudioItem audioItem = this._currentItem;
        if (audioItem != null) {
            return audioItem.getProduct();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getReason();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason getPlaybackReason() {
        /*
            r1 = this;
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist r0 = r1._playlist
            if (r0 == 0) goto L_0x000a
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason r0 = r0.getReason()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason r0 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason.DEFAULT
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.audioPlayer.AudioPlayer.getPlaybackReason():media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason");
    }

    public PlaybackDto getPlaybackDto() {
        if (getCurrentItem() == null) {
            return null;
        }
        AudioItem currentItem = getCurrentItem();
        Intrinsics.checkNotNull(currentItem);
        return new PlaybackDto(currentItem.getProduct().getId(), getTrackIndex(), getCurrentTrackPosition(), (String) null, (String) null, (String) null, Boolean.valueOf(getState() == AudioPlaybackState.PAUSED), 56, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final boolean getPlayerHasError() {
        return ((Boolean) BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new AudioPlayer$playerHasError$1(this, (Continuation<? super AudioPlayer$playerHasError$1>) null))).booleanValue();
    }

    public AudioPlaybackState getState() {
        return (AudioPlaybackState) BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new AudioPlayer$state$1(this, (Continuation<? super AudioPlayer$state$1>) null));
    }

    public boolean getHasNext() {
        if (this._currentItem == null) {
            return getHasNextPlaylistItems();
        }
        int trackIndex = getTrackIndex();
        AudioItem audioItem = this._currentItem;
        Intrinsics.checkNotNull(audioItem);
        return trackIndex < audioItem.getTracks().size() - 1 || getHasNextPlaylistItems();
    }

    public int getTrackIndex() {
        return this._currentTrackIndex;
    }

    public void setTrackIndex(int i) {
        int i2 = this._currentTrackIndex;
        if (i2 != i) {
            notifyAllOnPlaybackTrackWillChange(i2);
            this.uninterruptedListeningSec = 0;
            prepareTrack(i);
            int i3 = this._currentTrackIndex;
            if (i3 >= 0) {
                notifyAllOnPlaybackTrackDidChange(i3);
                return;
            }
            return;
        }
        this._isPreparingItem = false;
    }

    public long getPlaylistPosition() {
        AudioItem currentItem = getCurrentItem();
        if (currentItem != null) {
            return getCurrentTrackPosition() + currentItem.durationTo(this._currentTrackIndex);
        }
        return 0;
    }

    public int getPlaylistProgress() {
        AudioItem currentItem = getCurrentItem();
        if (currentItem != null) {
            return (int) ((((float) getPlaylistPosition()) / ((float) currentItem.getDuration())) * 100.0f);
        }
        return 0;
    }

    public long getCurrentTrackPosition() {
        return ((Number) BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new AudioPlayer$currentTrackPosition$1(this, (Continuation<? super AudioPlayer$currentTrackPosition$1>) null))).longValue();
    }

    public void setCurrentTrackPosition(long j) {
        notifyAllOnPlaybackBeginScrubbing(getCurrentTrackPosition(), getTrackIndex());
        AudioTrackModel trackAtIndex = trackAtIndex(getTrackIndex());
        if (trackAtIndex != null) {
            this.uninterruptedListeningSec = 0;
            AndroidKt.runOnUiThread(new AudioPlayer$currentTrackPosition$2(this, trackAtIndex, Math.max(0, Math.min(j, trackAtIndex.getDuration()))));
            notifyAllOnPlaybackTrackPositionChanged();
        }
        notifyAllOnPlaybackEndScrubbing(getCurrentTrackPosition(), getTrackIndex());
    }

    public int getCurrentTrackProgress() {
        return (int) ((((float) getCurrentTrackPosition()) / ((float) getCurrentTrackDuration())) * 100.0f);
    }

    public void setCurrentTrackProgress(int i) {
        setCurrentTrackPosition((long) (((float) getCurrentTrackDuration()) * (((float) Math.max(0, Math.min(100, i))) / 100.0f)));
    }

    public long getCurrentTrackDuration() {
        AudioTrackModel trackAtIndex = trackAtIndex(getTrackIndex());
        if (trackAtIndex != null) {
            return trackAtIndex.getDuration();
        }
        return 0;
    }

    private final void onPlaybackPlaylistWillChange(AudioPlaybackListener audioPlaybackListener) {
        audioPlaybackListener.onPlaybackPlaylistWillChange();
    }

    private final void onPlaybackPlaylistChangeReady(AudioPlaybackListener audioPlaybackListener) {
        audioPlaybackListener.onPlaybackPlaylistChangeReady();
    }

    private final void onPlaybackModelChanged(AudioPlaybackListener audioPlaybackListener) {
        audioPlaybackListener.onPlaybackItemChanged(getCurrentItem());
    }

    private final void onPlaybackTrackWillChange(AudioPlaybackListener audioPlaybackListener, int i) {
        AudioItem currentItem = getCurrentItem();
        if (currentItem != null) {
            audioPlaybackListener.onPlaybackTrackWillChange(currentItem, i);
        }
    }

    private final void onPlaybackTrackDidChange(AudioPlaybackListener audioPlaybackListener, int i) {
        AudioItem currentItem = getCurrentItem();
        if (currentItem != null) {
            audioPlaybackListener.onPlaybackTrackDidChange(currentItem, i);
        }
    }

    private final void onPlaybackTrackPositionChanged(AudioPlaybackListener audioPlaybackListener) {
        AudioItem currentItem = getCurrentItem();
        if (currentItem != null) {
            audioPlaybackListener.onPlaybackTrackPositionChanged(currentItem, getCurrentTrackPosition(), getCurrentTrackProgress(), getTrackIndex());
        }
    }

    private final void onPlaybackStateChanged(AudioPlaybackListener audioPlaybackListener) {
        audioPlaybackListener.onPlaybackStateChanged(getState());
    }

    private final void onPlaybackBeginScrubbing(AudioPlaybackListener audioPlaybackListener, long j, int i) {
        AudioItem currentItem = getCurrentItem();
        if (currentItem != null) {
            audioPlaybackListener.onPlaybackBeginScrubbing(currentItem, j, i);
        }
    }

    private final void onPlaybackEndScrubbing(AudioPlaybackListener audioPlaybackListener, long j, int i) {
        AudioItem currentItem = getCurrentItem();
        if (currentItem != null) {
            audioPlaybackListener.onPlaybackEndScrubbing(currentItem, j, i);
        }
    }

    private final void notifyAllOnPlaybackPlaylistWillChange() {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AudioPlaybackListener next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "listener");
                onPlaybackPlaylistWillChange(next);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void notifyAllOnPlaybackPlaylistChangeReady() {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AudioPlaybackListener next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "listener");
                onPlaybackPlaylistChangeReady(next);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void notifyAllOnPlaybackModelChanged() {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AudioPlaybackListener next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "listener");
                onPlaybackModelChanged(next);
            }
        }
    }

    private final void notifyAllOnPlaybackTrackWillChange(int i) {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AudioPlaybackListener next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "listener");
                onPlaybackTrackWillChange(next, i);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void notifyAllOnPlaybackTrackDidChange(int i) {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AudioPlaybackListener next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "listener");
                onPlaybackTrackDidChange(next, i);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void notifyAllOnPlaybackTrackPositionChanged() {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AudioPlaybackListener next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "listener");
                onPlaybackTrackPositionChanged(next);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void notifyAllOnPlaybackStateChanged() {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AudioPlaybackListener next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "listener");
                onPlaybackStateChanged(next);
            }
        }
    }

    private final void notifyAllOnPlaybackBeginScrubbing(long j, int i) {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AudioPlaybackListener next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "listener");
                onPlaybackBeginScrubbing(next, j, i);
            }
        }
    }

    private final void notifyAllOnPlaybackEndScrubbing(long j, int i) {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                AudioPlaybackListener next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "listener");
                onPlaybackEndScrubbing(next, j, i);
            }
        }
    }

    private final void notifyAllOnProductPlaybackEnd() {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onProductPlaybackEnd(getCurrentItem());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void notifyAllOnProductAcquisitionError(ProductAcquisitionService.ErrorCode errorCode) {
        if (this._notificationsEnabled) {
            Iterator<AudioPlaybackListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onProductAcquisitionError(errorCode);
            }
        }
    }

    public void registerListener(AudioPlaybackListener audioPlaybackListener) {
        Intrinsics.checkNotNullParameter(audioPlaybackListener, "listener");
        if (!this.listeners.contains(audioPlaybackListener)) {
            this.listeners.add(audioPlaybackListener);
            onPlaybackModelChanged(audioPlaybackListener);
            onPlaybackTrackDidChange(audioPlaybackListener, getTrackIndex());
            onPlaybackTrackPositionChanged(audioPlaybackListener);
            onPlaybackStateChanged(audioPlaybackListener);
        }
    }

    public void unregisterListener(AudioPlaybackListener audioPlaybackListener) {
        Intrinsics.checkNotNullParameter(audioPlaybackListener, "listener");
        this.listeners.remove(audioPlaybackListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = r0.getTracks();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel trackAtIndex(int r2) {
        /*
            r1 = this;
            if (r2 < 0) goto L_0x0024
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r0 = r1._currentItem
            if (r0 == 0) goto L_0x0011
            java.util.ArrayList r0 = r0.getTracks()
            if (r0 == 0) goto L_0x0011
            int r0 = r0.size()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r2 >= r0) goto L_0x0024
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r0 = r1._currentItem
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.ArrayList r0 = r0.getTracks()
            java.lang.Object r2 = r0.get(r2)
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel r2 = (media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel) r2
            return r2
        L_0x0024:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.audioPlayer.AudioPlayer.trackAtIndex(int):media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel");
    }

    private final void prepareTrack(int i) {
        AudioTrackModel trackAtIndex = trackAtIndex(i);
        if (trackAtIndex != null && getCurrentItem() != null) {
            if (!isAllowedToPlay()) {
                stop();
                return;
            }
            this._currentTrackIndex = i;
            try {
                Uri parse = Uri.parse(trackAtIndex.getEncodingsM3UUrl());
                AvailabilityService availabilityService2 = this.availabilityService;
                AudioItem currentItem = getCurrentItem();
                Intrinsics.checkNotNull(currentItem);
                if (AvailabilityService.DefaultImpls.offlineAvailabilityStateFor$default(availabilityService2, currentItem.getProduct().getId(), false, 2, (Object) null) == OfflineAvailabilityState.AVAILABLE) {
                    File file = new File(trackAtIndex.getEncodingsM3ULocalPath());
                    if (file.exists()) {
                        parse = Uri.fromFile(file);
                        Intrinsics.checkNotNullExpressionValue(parse, "fromFile(this)");
                    }
                }
                Intrinsics.checkNotNullExpressionValue(parse, "uri");
                preparePlayerWithTrackPath(parse);
                this._isPreparingItem = false;
                notifyAllOnPlaybackTrackPositionChanged();
                startProgressRefreshHandler();
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("AudioPlayer: Failed to prepare track " + e, new Object[0]);
            }
        }
    }

    private final void preparePlayerWithTrackPath(Uri uri) {
        DefaultDataSource.Factory factory = new DefaultDataSource.Factory(this.context);
        MediaItem fromUri = MediaItem.fromUri(uri);
        Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri(path)");
        DefaultHlsDataSourceFactory defaultHlsDataSourceFactory = new DefaultHlsDataSourceFactory(factory);
        HlsKeyProviderService hlsKeyProviderService = this.hlsService;
        AudioItem audioItem = this._currentItem;
        HlsMediaSource createMediaSource = new HlsMediaSource.Factory((HlsDataSourceFactory) new AudioServiceHLSDataSourceFactory(defaultHlsDataSourceFactory, hlsKeyProviderService, audioItem != null ? audioItem.getNfcPayload() : null)).setAllowChunklessPreparation(true).createMediaSource(fromUri);
        Intrinsics.checkNotNullExpressionValue(createMediaSource, "Factory(hlsDataSrcFactor…).createMediaSource(item)");
        try {
            AndroidKt.runOnUiThread(new AudioPlayer$preparePlayerWithTrackPath$1(this, createMediaSource));
            this.mPreparePlayerTryCount = 0;
        } catch (IllegalStateException e) {
            if (this.mPreparePlayerTryCount < 4) {
                preparePlayerWithTrackPath(uri);
                this.mPreparePlayerTryCount++;
            }
            Timber.Forest.mo50217e("AudioPlayer: IllegalStateException " + e, new Object[0]);
        }
    }

    private final void startProgressRefreshHandler() {
        Job job = this.progressRefreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.uninterruptedListeningSec = 0;
        this.progressRefreshJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AudioPlayer$startProgressRefreshHandler$1(this, (Continuation<? super AudioPlayer$startProgressRefreshHandler$1>) null), 3, (Object) null);
    }

    private final void stopProgressRefreshHandler() {
        Job job = this.progressRefreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioPlayer$Companion;", "", "()V", "DOWNLOAD_AFTER_TIME", "", "GO_TO_PREVIOUS_TRACK_PROGRESS_SEC", "", "MAX_TRY_CNT", "PROGRESS_REFRESH_TIME", "SECONDS_TO_MILLISECONDS_FACTOR", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AudioPlayer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioPlayer$AudioServiceHLSDataSourceFactory;", "Lcom/google/android/exoplayer2/source/hls/HlsDataSourceFactory;", "defaultDatasourceFactory", "Lcom/google/android/exoplayer2/source/hls/DefaultHlsDataSourceFactory;", "hlsService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;", "nfc", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "(Lcom/google/android/exoplayer2/source/hls/DefaultHlsDataSourceFactory;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;)V", "createDataSource", "Lcom/google/android/exoplayer2/upstream/DataSource;", "dataType", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AudioPlayer.kt */
    private static final class AudioServiceHLSDataSourceFactory implements HlsDataSourceFactory {
        private final DefaultHlsDataSourceFactory defaultDatasourceFactory;
        private final HlsKeyProviderService hlsService;
        private final TigerCardDomain nfc;

        public AudioServiceHLSDataSourceFactory(DefaultHlsDataSourceFactory defaultHlsDataSourceFactory, HlsKeyProviderService hlsKeyProviderService, TigerCardDomain tigerCardDomain) {
            Intrinsics.checkNotNullParameter(defaultHlsDataSourceFactory, "defaultDatasourceFactory");
            Intrinsics.checkNotNullParameter(hlsKeyProviderService, "hlsService");
            this.defaultDatasourceFactory = defaultHlsDataSourceFactory;
            this.hlsService = hlsKeyProviderService;
            this.nfc = tigerCardDomain;
        }

        public DataSource createDataSource(int i) {
            if (i != 1) {
                if (i == 3) {
                    return new AudioHlsDataSource(this.hlsService, this.nfc);
                }
                if (i != 4) {
                    DataSource createDataSource = this.defaultDatasourceFactory.createDataSource(i);
                    Intrinsics.checkNotNullExpressionValue(createDataSource, "{\n                defaul…e(dataType)\n            }");
                    return createDataSource;
                }
            }
            return new AudioUrlEncodingDataSource(this.defaultDatasourceFactory.createDataSource(i));
        }
    }
}
