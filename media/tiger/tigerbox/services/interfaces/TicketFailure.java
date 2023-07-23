package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.TigerTicketFail;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/TicketFailure;", "", "cardFailError", "Lmedia/tiger/tigerbox/services/interfaces/CardValidationFailError;", "failReason", "Lmedia/tiger/tigerbox/model/domain/TigerTicketFail;", "(Lmedia/tiger/tigerbox/services/interfaces/CardValidationFailError;Lmedia/tiger/tigerbox/model/domain/TigerTicketFail;)V", "getCardFailError", "()Lmedia/tiger/tigerbox/services/interfaces/CardValidationFailError;", "getFailReason", "()Lmedia/tiger/tigerbox/model/domain/TigerTicketFail;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerCardsManagerService.kt */
public final class TicketFailure {
    private final CardValidationFailError cardFailError;
    private final TigerTicketFail failReason;

    public static /* synthetic */ TicketFailure copy$default(TicketFailure ticketFailure, CardValidationFailError cardValidationFailError, TigerTicketFail tigerTicketFail, int i, Object obj) {
        if ((i & 1) != 0) {
            cardValidationFailError = ticketFailure.cardFailError;
        }
        if ((i & 2) != 0) {
            tigerTicketFail = ticketFailure.failReason;
        }
        return ticketFailure.copy(cardValidationFailError, tigerTicketFail);
    }

    public final CardValidationFailError component1() {
        return this.cardFailError;
    }

    public final TigerTicketFail component2() {
        return this.failReason;
    }

    public final TicketFailure copy(CardValidationFailError cardValidationFailError, TigerTicketFail tigerTicketFail) {
        Intrinsics.checkNotNullParameter(cardValidationFailError, "cardFailError");
        return new TicketFailure(cardValidationFailError, tigerTicketFail);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TicketFailure)) {
            return false;
        }
        TicketFailure ticketFailure = (TicketFailure) obj;
        return this.cardFailError == ticketFailure.cardFailError && Intrinsics.areEqual((Object) this.failReason, (Object) ticketFailure.failReason);
    }

    public int hashCode() {
        int hashCode = this.cardFailError.hashCode() * 31;
        TigerTicketFail tigerTicketFail = this.failReason;
        return hashCode + (tigerTicketFail == null ? 0 : tigerTicketFail.hashCode());
    }

    public String toString() {
        return "TicketFailure(cardFailError=" + this.cardFailError + ", failReason=" + this.failReason + ')';
    }

    public TicketFailure(CardValidationFailError cardValidationFailError, TigerTicketFail tigerTicketFail) {
        Intrinsics.checkNotNullParameter(cardValidationFailError, "cardFailError");
        this.cardFailError = cardValidationFailError;
        this.failReason = tigerTicketFail;
    }

    public final CardValidationFailError getCardFailError() {
        return this.cardFailError;
    }

    public final TigerTicketFail getFailReason() {
        return this.failReason;
    }
}
