package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/GetProductDetailsParameters;", "", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetProductDetailsUseCase.kt */
public final class GetProductDetailsParameters {
    private final String productId;

    public static /* synthetic */ GetProductDetailsParameters copy$default(GetProductDetailsParameters getProductDetailsParameters, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getProductDetailsParameters.productId;
        }
        return getProductDetailsParameters.copy(str);
    }

    public final String component1() {
        return this.productId;
    }

    public final GetProductDetailsParameters copy(String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        return new GetProductDetailsParameters(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetProductDetailsParameters) && Intrinsics.areEqual((Object) this.productId, (Object) ((GetProductDetailsParameters) obj).productId);
    }

    public int hashCode() {
        return this.productId.hashCode();
    }

    public String toString() {
        return "GetProductDetailsParameters(productId=" + this.productId + ')';
    }

    public GetProductDetailsParameters(String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        this.productId = str;
    }

    public final String getProductId() {
        return this.productId;
    }
}
