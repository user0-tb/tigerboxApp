package media.tiger.tigerbox.data.database;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH'J\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/database/TigerBoxProfileDao;", "", "deleteAllProfiles", "", "deleteTigerboxProfile", "profile", "Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "getProfiles", "", "insertProfile", "(Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserDao.kt */
public interface TigerBoxProfileDao {
    void deleteAllProfiles();

    void deleteTigerboxProfile(TigerBoxProfileDomain tigerBoxProfileDomain);

    List<TigerBoxProfileDomain> getProfiles();

    Object insertProfile(TigerBoxProfileDomain tigerBoxProfileDomain, Continuation<? super Unit> continuation);
}
