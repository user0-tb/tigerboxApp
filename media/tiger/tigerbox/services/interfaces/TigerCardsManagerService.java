package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;

@Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;", "", "validatedCard", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "getValidatedCard", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "wildcardReassignModeEnabled", "", "getWildcardReassignModeEnabled", "()Z", "setWildcardReassignModeEnabled", "(Z)V", "failureToTicketFailure", "Lmedia/tiger/tigerbox/services/interfaces/TicketFailure;", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "reassignInsertedWildcard", "", "registerListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsListener;", "unregisterListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerCardsManagerService.kt */
public interface TigerCardsManagerService {
    TicketFailure failureToTicketFailure(Failure failure);

    TigerCardDomain getValidatedCard();

    boolean getWildcardReassignModeEnabled();

    void reassignInsertedWildcard();

    void registerListener(TigerCardsListener tigerCardsListener);

    void setWildcardReassignModeEnabled(boolean z);

    void unregisterListener(TigerCardsListener tigerCardsListener);
}
