package media.tiger.tigerbox.data.database;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.model.domain.TigerBoxUserDomain;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'J\u0019\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH'\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/database/TigerBoxUserDao;", "", "deleteAllUsers", "", "deleteTigerboxUser", "user", "Lmedia/tiger/tigerbox/model/domain/TigerBoxUserDomain;", "getUser", "insertUser", "(Lmedia/tiger/tigerbox/model/domain/TigerBoxUserDomain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "activeProfileId", "", "accountId", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserDao.kt */
public interface TigerBoxUserDao {
    void deleteAllUsers();

    void deleteTigerboxUser(TigerBoxUserDomain tigerBoxUserDomain);

    TigerBoxUserDomain getUser();

    Object insertUser(TigerBoxUserDomain tigerBoxUserDomain, Continuation<? super Unit> continuation);

    void update(int i, int i2);
}
