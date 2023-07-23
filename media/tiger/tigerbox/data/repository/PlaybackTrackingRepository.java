package media.tiger.tigerbox.data.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.model.domain.PlaybackTrackingDomain;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/PlaybackTrackingRepository;", "", "deleteAllPlaybackTracking", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlaybackTrackingEvent", "event", "Lmedia/tiger/tigerbox/model/domain/PlaybackTrackingDomain;", "(Lmedia/tiger/tigerbox/model/domain/PlaybackTrackingDomain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaybackTracking", "", "insertPlaybackTracking", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackTrackingRepository.kt */
public interface PlaybackTrackingRepository {
    Object deleteAllPlaybackTracking(Continuation<? super Unit> continuation);

    Object deletePlaybackTrackingEvent(PlaybackTrackingDomain playbackTrackingDomain, Continuation<? super Unit> continuation);

    Object getPlaybackTracking(Continuation<? super List<PlaybackTrackingDomain>> continuation);

    Object insertPlaybackTracking(PlaybackTrackingDomain playbackTrackingDomain, Continuation<? super Unit> continuation);
}
