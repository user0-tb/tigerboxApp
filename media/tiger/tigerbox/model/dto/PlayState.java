package media.tiger.tigerbox.model.dto;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/PlayState;", "", "id", "", "productId", "userId", "trackNumber", "trackPosition", "(IIIII)V", "getId", "()I", "getProductId", "getTrackNumber", "getTrackPosition", "getUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: UserProductPlayStates.kt */
public final class PlayState {

    /* renamed from: id */
    private final int f640id;
    private final int productId;
    private final int trackNumber;
    private final int trackPosition;
    private final int userId;

    public static /* synthetic */ PlayState copy$default(PlayState playState, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = playState.f640id;
        }
        if ((i6 & 2) != 0) {
            i2 = playState.productId;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = playState.userId;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = playState.trackNumber;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = playState.trackPosition;
        }
        return playState.copy(i, i7, i8, i9, i5);
    }

    public final int component1() {
        return this.f640id;
    }

    public final int component2() {
        return this.productId;
    }

    public final int component3() {
        return this.userId;
    }

    public final int component4() {
        return this.trackNumber;
    }

    public final int component5() {
        return this.trackPosition;
    }

    public final PlayState copy(int i, int i2, int i3, int i4, int i5) {
        return new PlayState(i, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayState)) {
            return false;
        }
        PlayState playState = (PlayState) obj;
        return this.f640id == playState.f640id && this.productId == playState.productId && this.userId == playState.userId && this.trackNumber == playState.trackNumber && this.trackPosition == playState.trackPosition;
    }

    public int hashCode() {
        return (((((((this.f640id * 31) + this.productId) * 31) + this.userId) * 31) + this.trackNumber) * 31) + this.trackPosition;
    }

    public String toString() {
        return "PlayState(id=" + this.f640id + ", productId=" + this.productId + ", userId=" + this.userId + ", trackNumber=" + this.trackNumber + ", trackPosition=" + this.trackPosition + ')';
    }

    public PlayState(int i, int i2, int i3, int i4, int i5) {
        this.f640id = i;
        this.productId = i2;
        this.userId = i3;
        this.trackNumber = i4;
        this.trackPosition = i5;
    }

    public final int getId() {
        return this.f640id;
    }

    public final int getProductId() {
        return this.productId;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final int getTrackNumber() {
        return this.trackNumber;
    }

    public final int getTrackPosition() {
        return this.trackPosition;
    }
}
