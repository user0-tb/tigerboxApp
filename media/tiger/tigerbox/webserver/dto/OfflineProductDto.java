package media.tiger.tigerbox.webserver.dto;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/dto/OfflineProductDto;", "", "productId", "", "(I)V", "getProductId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: OfflineProductDto.kt */
public final class OfflineProductDto {
    private final int productId;

    public static /* synthetic */ OfflineProductDto copy$default(OfflineProductDto offlineProductDto, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = offlineProductDto.productId;
        }
        return offlineProductDto.copy(i);
    }

    public final int component1() {
        return this.productId;
    }

    public final OfflineProductDto copy(int i) {
        return new OfflineProductDto(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OfflineProductDto) && this.productId == ((OfflineProductDto) obj).productId;
    }

    public int hashCode() {
        return this.productId;
    }

    public String toString() {
        return "OfflineProductDto(productId=" + this.productId + ')';
    }

    public OfflineProductDto(int i) {
        this.productId = i;
    }

    public final int getProductId() {
        return this.productId;
    }
}
