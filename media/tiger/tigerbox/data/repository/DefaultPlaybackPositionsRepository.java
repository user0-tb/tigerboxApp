package media.tiger.tigerbox.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.model.domain.PlaybackPositionDomain;

@Singleton
@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/DefaultPlaybackPositionsRepository;", "Lmedia/tiger/tigerbox/data/repository/PlaybackPositionsRepository;", "tigerBoxDataBase", "Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;", "(Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;)V", "deleteAllPlaybackPositions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaybackPosition", "Lmedia/tiger/tigerbox/model/domain/PlaybackPositionDomain;", "userId", "", "productId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPlaybackPosition", "playPosition", "(Lmedia/tiger/tigerbox/model/domain/PlaybackPositionDomain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackPositionsRepository.kt */
public class DefaultPlaybackPositionsRepository implements PlaybackPositionsRepository {
    private final TigerBoxDatabase tigerBoxDataBase;

    public Object deleteAllPlaybackPositions(Continuation<? super Unit> continuation) {
        return this.tigerBoxDataBase.playbackPositionsDao().deleteAllPlaybackPositions();
    }

    public Object getPlaybackPosition(int i, int i2, Continuation<? super PlaybackPositionDomain> continuation) {
        return this.tigerBoxDataBase.playbackPositionsDao().getPlaybackPosition(i, i2);
    }

    public Object insertPlaybackPosition(PlaybackPositionDomain playbackPositionDomain, Continuation<? super Unit> continuation) {
        return insertPlaybackPosition$suspendImpl(this, playbackPositionDomain, continuation);
    }

    @Inject
    public DefaultPlaybackPositionsRepository(TigerBoxDatabase tigerBoxDatabase) {
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDataBase");
        this.tigerBoxDataBase = tigerBoxDatabase;
    }

    static /* synthetic */ Object insertPlaybackPosition$suspendImpl(DefaultPlaybackPositionsRepository defaultPlaybackPositionsRepository, PlaybackPositionDomain playbackPositionDomain, Continuation continuation) {
        if (defaultPlaybackPositionsRepository.tigerBoxDataBase.playbackPositionsDao().getPlaybackPosition(playbackPositionDomain.getUserId(), playbackPositionDomain.getProductId()) == null) {
            defaultPlaybackPositionsRepository.tigerBoxDataBase.playbackPositionsDao().insertPlaybackPosition(playbackPositionDomain);
        } else {
            defaultPlaybackPositionsRepository.tigerBoxDataBase.playbackPositionsDao().updatePlaybackPosition(playbackPositionDomain.getUserId(), playbackPositionDomain.getProductId(), playbackPositionDomain.getTrackNumber(), playbackPositionDomain.getTrackPosition(), playbackPositionDomain.getModifiedDate());
        }
        return Unit.INSTANCE;
    }
}
