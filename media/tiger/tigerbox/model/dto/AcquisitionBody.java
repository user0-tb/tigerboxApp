package media.tiger.tigerbox.model.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/AcquisitionBody;", "", "productId", "", "accountId", "assignmentType", "", "source", "(IILjava/lang/String;Ljava/lang/String;)V", "getAccountId", "()I", "getAssignmentType", "()Ljava/lang/String;", "getProductId", "getSource", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AcquisitionBody.kt */
public final class AcquisitionBody {
    private final int accountId;
    private final String assignmentType;
    private final int productId;
    private final String source;

    public static /* synthetic */ AcquisitionBody copy$default(AcquisitionBody acquisitionBody, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = acquisitionBody.productId;
        }
        if ((i3 & 2) != 0) {
            i2 = acquisitionBody.accountId;
        }
        if ((i3 & 4) != 0) {
            str = acquisitionBody.assignmentType;
        }
        if ((i3 & 8) != 0) {
            str2 = acquisitionBody.source;
        }
        return acquisitionBody.copy(i, i2, str, str2);
    }

    public final int component1() {
        return this.productId;
    }

    public final int component2() {
        return this.accountId;
    }

    public final String component3() {
        return this.assignmentType;
    }

    public final String component4() {
        return this.source;
    }

    public final AcquisitionBody copy(int i, int i2, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "assignmentType");
        Intrinsics.checkNotNullParameter(str2, "source");
        return new AcquisitionBody(i, i2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AcquisitionBody)) {
            return false;
        }
        AcquisitionBody acquisitionBody = (AcquisitionBody) obj;
        return this.productId == acquisitionBody.productId && this.accountId == acquisitionBody.accountId && Intrinsics.areEqual((Object) this.assignmentType, (Object) acquisitionBody.assignmentType) && Intrinsics.areEqual((Object) this.source, (Object) acquisitionBody.source);
    }

    public int hashCode() {
        return (((((this.productId * 31) + this.accountId) * 31) + this.assignmentType.hashCode()) * 31) + this.source.hashCode();
    }

    public String toString() {
        return "AcquisitionBody(productId=" + this.productId + ", accountId=" + this.accountId + ", assignmentType=" + this.assignmentType + ", source=" + this.source + ')';
    }

    public AcquisitionBody(int i, int i2, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "assignmentType");
        Intrinsics.checkNotNullParameter(str2, "source");
        this.productId = i;
        this.accountId = i2;
        this.assignmentType = str;
        this.source = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AcquisitionBody(int i, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? "SUBSCRIPTION" : str, (i3 & 8) != 0 ? "SUBSCRIPTION" : str2);
    }

    public final int getProductId() {
        return this.productId;
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final String getAssignmentType() {
        return this.assignmentType;
    }

    public final String getSource() {
        return this.source;
    }
}
