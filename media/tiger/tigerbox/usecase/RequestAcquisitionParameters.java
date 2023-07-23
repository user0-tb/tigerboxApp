package media.tiger.tigerbox.usecase;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/RequestAcquisitionParameters;", "", "accountId", "", "productId", "(II)V", "getAccountId", "()I", "getProductId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestAcquisitionUseCase.kt */
public final class RequestAcquisitionParameters {
    private final int accountId;
    private final int productId;

    public static /* synthetic */ RequestAcquisitionParameters copy$default(RequestAcquisitionParameters requestAcquisitionParameters, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = requestAcquisitionParameters.accountId;
        }
        if ((i3 & 2) != 0) {
            i2 = requestAcquisitionParameters.productId;
        }
        return requestAcquisitionParameters.copy(i, i2);
    }

    public final int component1() {
        return this.accountId;
    }

    public final int component2() {
        return this.productId;
    }

    public final RequestAcquisitionParameters copy(int i, int i2) {
        return new RequestAcquisitionParameters(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestAcquisitionParameters)) {
            return false;
        }
        RequestAcquisitionParameters requestAcquisitionParameters = (RequestAcquisitionParameters) obj;
        return this.accountId == requestAcquisitionParameters.accountId && this.productId == requestAcquisitionParameters.productId;
    }

    public int hashCode() {
        return (this.accountId * 31) + this.productId;
    }

    public String toString() {
        return "RequestAcquisitionParameters(accountId=" + this.accountId + ", productId=" + this.productId + ')';
    }

    public RequestAcquisitionParameters(int i, int i2) {
        this.accountId = i;
        this.productId = i2;
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final int getProductId() {
        return this.productId;
    }
}
