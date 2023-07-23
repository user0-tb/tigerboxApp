package media.tiger.tigerbox.data.database;

import kotlin.Metadata;
import media.tiger.tigerbox.model.domain.PlaybackPositionDomain;

@Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H'J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/database/PlaybackPositionsDao;", "", "deleteAllPlaybackPositions", "", "getPlaybackPosition", "Lmedia/tiger/tigerbox/model/domain/PlaybackPositionDomain;", "userId", "", "productId", "insertPlaybackPosition", "playState", "updatePlaybackPosition", "trackNumber", "trackPosition", "", "modifiedDate", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackPositionsDao.kt */
public interface PlaybackPositionsDao {
    void deleteAllPlaybackPositions();

    PlaybackPositionDomain getPlaybackPosition(int i, int i2);

    void insertPlaybackPosition(PlaybackPositionDomain playbackPositionDomain);

    void updatePlaybackPosition(int i, int i2, int i3, long j, String str);
}
