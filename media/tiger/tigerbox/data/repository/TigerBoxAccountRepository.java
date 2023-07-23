package media.tiger.tigerbox.data.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.TigerBoxAccountDomain;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;
import media.tiger.tigerbox.model.domain.TigerBoxUserDomain;

@Metadata(mo33736d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&J\b\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0011\u0010\u0016\u001a\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ2\u0010\u0017\u001a\u00020\u00102(\b\u0002\u0010\u0018\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f0\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "", "activeProfile", "Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "getActiveProfile", "()Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "fetchAccountInfo", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Lmedia/tiger/tigerbox/model/domain/TigerBoxAccountDomain;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTigerBoxProfiles", "", "getTigerBoxUser", "Lmedia/tiger/tigerbox/model/domain/TigerBoxUserDomain;", "loadInitialDatabaseData", "", "onDone", "Lkotlin/Function0;", "registerProfileChangeListener", "listener", "Lmedia/tiger/tigerbox/data/repository/ProfileChangeListener;", "removeTigerBoxAccountInfo", "requestUpdatedProfilesInfoFromServer", "onResult", "Lkotlin/Function1;", "setActiveProfile", "profileId", "", "unregisterProfileChangeListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserRepository.kt */
public interface TigerBoxAccountRepository {
    Object fetchAccountInfo(Continuation<? super Either<? extends Failure, TigerBoxAccountDomain>> continuation);

    TigerBoxProfileDomain getActiveProfile();

    List<TigerBoxProfileDomain> getTigerBoxProfiles();

    TigerBoxUserDomain getTigerBoxUser();

    void loadInitialDatabaseData(Function0<Unit> function0);

    void registerProfileChangeListener(ProfileChangeListener profileChangeListener);

    Object removeTigerBoxAccountInfo(Continuation<? super Unit> continuation);

    void requestUpdatedProfilesInfoFromServer(Function1<? super Either<? extends Failure, ? extends List<TigerBoxProfileDomain>>, Unit> function1);

    void setActiveProfile(int i);

    void unregisterProfileChangeListener(ProfileChangeListener profileChangeListener);

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerBoxUserRepository.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void requestUpdatedProfilesInfoFromServer$default(TigerBoxAccountRepository tigerBoxAccountRepository, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function1 = null;
                }
                tigerBoxAccountRepository.requestUpdatedProfilesInfoFromServer(function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestUpdatedProfilesInfoFromServer");
        }
    }
}
