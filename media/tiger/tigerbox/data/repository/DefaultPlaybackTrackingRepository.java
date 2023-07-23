package media.tiger.tigerbox.data.repository;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.model.domain.PlaybackTrackingDomain;

@Singleton
@Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/DefaultPlaybackTrackingRepository;", "Lmedia/tiger/tigerbox/data/repository/PlaybackTrackingRepository;", "tigerBoxDataBase", "Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;", "(Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;)V", "deleteAllPlaybackTracking", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlaybackTrackingEvent", "event", "Lmedia/tiger/tigerbox/model/domain/PlaybackTrackingDomain;", "(Lmedia/tiger/tigerbox/model/domain/PlaybackTrackingDomain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaybackTracking", "", "insertPlaybackTracking", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackTrackingRepository.kt */
public class DefaultPlaybackTrackingRepository implements PlaybackTrackingRepository {
    private final TigerBoxDatabase tigerBoxDataBase;

    public Object deleteAllPlaybackTracking(Continuation<? super Unit> continuation) {
        return this.tigerBoxDataBase.playbackTrackingDao().deleteAllPlaybackTracking();
    }

    public Object deletePlaybackTrackingEvent(PlaybackTrackingDomain playbackTrackingDomain, Continuation<? super Unit> continuation) {
        return this.tigerBoxDataBase.playbackTrackingDao().deletePlaybackTrackingEvent(playbackTrackingDomain.getAccountId(), playbackTrackingDomain.getUserId(), playbackTrackingDomain.getProductId(), playbackTrackingDomain.getEvent(), playbackTrackingDomain.getStart(), playbackTrackingDomain.getEnd(), playbackTrackingDomain.getTotal());
    }

    public Object getPlaybackTracking(Continuation<? super List<PlaybackTrackingDomain>> continuation) {
        return this.tigerBoxDataBase.playbackTrackingDao().getAllPlaybackTracking();
    }

    public Object insertPlaybackTracking(PlaybackTrackingDomain playbackTrackingDomain, Continuation<? super Unit> continuation) {
        return this.tigerBoxDataBase.playbackTrackingDao().insertPlaybackTrackEvent(playbackTrackingDomain);
    }

    @Inject
    public DefaultPlaybackTrackingRepository(TigerBoxDatabase tigerBoxDatabase) {
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDataBase");
        this.tigerBoxDataBase = tigerBoxDatabase;
    }
}
