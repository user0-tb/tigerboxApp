package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/CheckAcquisitionsParameters;", "", "accountId", "", "productId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getProductId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: CheckAcquisitionsUseCase.kt */
public final class CheckAcquisitionsParameters {
    private final String accountId;
    private final String productId;

    public static /* synthetic */ CheckAcquisitionsParameters copy$default(CheckAcquisitionsParameters checkAcquisitionsParameters, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkAcquisitionsParameters.accountId;
        }
        if ((i & 2) != 0) {
            str2 = checkAcquisitionsParameters.productId;
        }
        return checkAcquisitionsParameters.copy(str, str2);
    }

    public final String component1() {
        return this.accountId;
    }

    public final String component2() {
        return this.productId;
    }

    public final CheckAcquisitionsParameters copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "accountId");
        Intrinsics.checkNotNullParameter(str2, "productId");
        return new CheckAcquisitionsParameters(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckAcquisitionsParameters)) {
            return false;
        }
        CheckAcquisitionsParameters checkAcquisitionsParameters = (CheckAcquisitionsParameters) obj;
        return Intrinsics.areEqual((Object) this.accountId, (Object) checkAcquisitionsParameters.accountId) && Intrinsics.areEqual((Object) this.productId, (Object) checkAcquisitionsParameters.productId);
    }

    public int hashCode() {
        return (this.accountId.hashCode() * 31) + this.productId.hashCode();
    }

    public String toString() {
        return "CheckAcquisitionsParameters(accountId=" + this.accountId + ", productId=" + this.productId + ')';
    }

    public CheckAcquisitionsParameters(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "accountId");
        Intrinsics.checkNotNullParameter(str2, "productId");
        this.accountId = str;
        this.productId = str2;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getProductId() {
        return this.productId;
    }
}
