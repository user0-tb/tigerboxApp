package media.tiger.tigerbox.data.database;

import kotlin.Metadata;
import media.tiger.tigerbox.model.domain.HlsKeyDomain;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H'¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/database/HlsKeysDao;", "", "deleteAllKeys", "", "getHlsKey", "Lmedia/tiger/tigerbox/model/domain/HlsKeyDomain;", "url", "", "insertPlaybackPosition", "key", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HlsKeysDao.kt */
public interface HlsKeysDao {
    void deleteAllKeys();

    HlsKeyDomain getHlsKey(String str);

    void insertPlaybackPosition(HlsKeyDomain hlsKeyDomain);
}
