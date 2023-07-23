package media.tiger.tigerbox.services.interfaces;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.dto.TigerTicketAssignedProduct;

@Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "Ljava/io/Serializable;", "step", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepType;", "ticket", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketDomain;", "product", "Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct;", "(Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepType;Lmedia/tiger/tigerbox/services/interfaces/TigerTicketDomain;Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct;)V", "getProduct", "()Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct;", "getStep", "()Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepType;", "getTicket", "()Lmedia/tiger/tigerbox/services/interfaces/TigerTicketDomain;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerTicketStepDomain.kt */
public final class TigerTicketStepDomain implements Serializable {
    private final TigerTicketAssignedProduct product;
    private final TigerTicketStepType step;
    private final TigerTicketDomain ticket;

    public static /* synthetic */ TigerTicketStepDomain copy$default(TigerTicketStepDomain tigerTicketStepDomain, TigerTicketStepType tigerTicketStepType, TigerTicketDomain tigerTicketDomain, TigerTicketAssignedProduct tigerTicketAssignedProduct, int i, Object obj) {
        if ((i & 1) != 0) {
            tigerTicketStepType = tigerTicketStepDomain.step;
        }
        if ((i & 2) != 0) {
            tigerTicketDomain = tigerTicketStepDomain.ticket;
        }
        if ((i & 4) != 0) {
            tigerTicketAssignedProduct = tigerTicketStepDomain.product;
        }
        return tigerTicketStepDomain.copy(tigerTicketStepType, tigerTicketDomain, tigerTicketAssignedProduct);
    }

    public final TigerTicketStepType component1() {
        return this.step;
    }

    public final TigerTicketDomain component2() {
        return this.ticket;
    }

    public final TigerTicketAssignedProduct component3() {
        return this.product;
    }

    public final TigerTicketStepDomain copy(TigerTicketStepType tigerTicketStepType, TigerTicketDomain tigerTicketDomain, TigerTicketAssignedProduct tigerTicketAssignedProduct) {
        Intrinsics.checkNotNullParameter(tigerTicketStepType, "step");
        Intrinsics.checkNotNullParameter(tigerTicketDomain, "ticket");
        Intrinsics.checkNotNullParameter(tigerTicketAssignedProduct, "product");
        return new TigerTicketStepDomain(tigerTicketStepType, tigerTicketDomain, tigerTicketAssignedProduct);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TigerTicketStepDomain)) {
            return false;
        }
        TigerTicketStepDomain tigerTicketStepDomain = (TigerTicketStepDomain) obj;
        return this.step == tigerTicketStepDomain.step && Intrinsics.areEqual((Object) this.ticket, (Object) tigerTicketStepDomain.ticket) && Intrinsics.areEqual((Object) this.product, (Object) tigerTicketStepDomain.product);
    }

    public int hashCode() {
        return (((this.step.hashCode() * 31) + this.ticket.hashCode()) * 31) + this.product.hashCode();
    }

    public String toString() {
        return "TigerTicketStepDomain(step=" + this.step + ", ticket=" + this.ticket + ", product=" + this.product + ')';
    }

    public TigerTicketStepDomain(TigerTicketStepType tigerTicketStepType, TigerTicketDomain tigerTicketDomain, TigerTicketAssignedProduct tigerTicketAssignedProduct) {
        Intrinsics.checkNotNullParameter(tigerTicketStepType, "step");
        Intrinsics.checkNotNullParameter(tigerTicketDomain, "ticket");
        Intrinsics.checkNotNullParameter(tigerTicketAssignedProduct, "product");
        this.step = tigerTicketStepType;
        this.ticket = tigerTicketDomain;
        this.product = tigerTicketAssignedProduct;
    }

    public final TigerTicketStepType getStep() {
        return this.step;
    }

    public final TigerTicketDomain getTicket() {
        return this.ticket;
    }

    public final TigerTicketAssignedProduct getProduct() {
        return this.product;
    }
}
