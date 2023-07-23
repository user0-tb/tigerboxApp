package media.tiger.tigerbox.data.database;

import kotlin.Metadata;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/database/AccessTokenDao;", "", "deleteAccessToken", "", "token", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "deleteAllAccessToken", "getAccessToken", "insertAccessToken", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AccessTokenDao.kt */
public interface AccessTokenDao {
    void deleteAccessToken(AccessTokenDomain accessTokenDomain);

    void deleteAllAccessToken();

    AccessTokenDomain getAccessToken();

    void insertAccessToken(AccessTokenDomain accessTokenDomain);
}
