package media.tiger.tigerbox.services.interfaces.audioPlayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.webserver.dto.PlaybackDto;

@Metadata(mo33736d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u00107\u001a\u000208H&J\b\u00109\u001a\u000208H&J\b\u0010:\u001a\u000208H&J\u0010\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020\u0017H&J\b\u0010=\u001a\u000208H&J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@H&J\u0010\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020\u000bH&J\b\u0010C\u001a\u000208H&J\b\u0010D\u001a\u000208H&J5\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020\u00072#\u0010G\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010I¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0004\u0012\u0002080HH&J\b\u0010M\u001a\u000208H&J\u0010\u0010N\u001a\u0002082\u0006\u0010?\u001a\u00020@H&J\u0010\u0010O\u001a\u0002082\u0006\u0010P\u001a\u00020\u0017H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u0004\u0018\u00010#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0011R\u0012\u0010,\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0019R\u0012\u0010.\u001a\u00020/X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0019R\u0018\u00104\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001b¨\u0006Q"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "", "currentItem", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "getCurrentItem", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "currentPlaylist", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylist;", "getCurrentPlaylist", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylist;", "currentProductInfo", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "getCurrentProductInfo", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "currentTrackDuration", "", "getCurrentTrackDuration", "()J", "currentTrackPosition", "getCurrentTrackPosition", "setCurrentTrackPosition", "(J)V", "currentTrackProgress", "", "getCurrentTrackProgress", "()I", "setCurrentTrackProgress", "(I)V", "hasNext", "", "getHasNext", "()Z", "hasPrevious", "getHasPrevious", "playbackDto", "Lmedia/tiger/tigerbox/webserver/dto/PlaybackDto;", "getPlaybackDto", "()Lmedia/tiger/tigerbox/webserver/dto/PlaybackDto;", "playbackReason", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackReason;", "getPlaybackReason", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackReason;", "playlistPosition", "getPlaylistPosition", "playlistProgress", "getPlaylistProgress", "state", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "getState", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "streamMaxVolume", "getStreamMaxVolume", "trackIndex", "getTrackIndex", "setTrackIndex", "pause", "", "play", "playNext", "playPlaylistItem", "idx", "playPrevious", "registerListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackListener;", "setInitialPlaylistProduct", "product", "stop", "stopPlayingNonCardsProducts", "streamPlaylist", "playlist", "onAcquisitionReady", "Lkotlin/Function1;", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "Lkotlin/ParameterName;", "name", "error", "togglePlayPause", "unregisterListener", "updateStreamMusicVolume", "volume", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlayerService.kt */
public interface AudioPlayerService {
    AudioItem getCurrentItem();

    AudioPlaylist getCurrentPlaylist();

    AudioProductInfo getCurrentProductInfo();

    long getCurrentTrackDuration();

    long getCurrentTrackPosition();

    int getCurrentTrackProgress();

    boolean getHasNext();

    boolean getHasPrevious();

    PlaybackDto getPlaybackDto();

    AudioPlaybackReason getPlaybackReason();

    long getPlaylistPosition();

    int getPlaylistProgress();

    AudioPlaybackState getState();

    int getStreamMaxVolume();

    int getTrackIndex();

    void pause();

    void play();

    void playNext();

    void playPlaylistItem(int i);

    void playPrevious();

    void registerListener(AudioPlaybackListener audioPlaybackListener);

    void setCurrentTrackPosition(long j);

    void setCurrentTrackProgress(int i);

    void setInitialPlaylistProduct(AudioProductInfo audioProductInfo);

    void setTrackIndex(int i);

    void stop();

    void stopPlayingNonCardsProducts();

    void streamPlaylist(AudioPlaylist audioPlaylist, Function1<? super ProductAcquisitionService.ErrorCode, Unit> function1);

    void togglePlayPause();

    void unregisterListener(AudioPlaybackListener audioPlaybackListener);

    void updateStreamMusicVolume(int i);
}
