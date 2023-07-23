package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0004HÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/PlaybackPositionDomain;", "", "()V", "userId", "", "productId", "trackNumber", "trackPosition", "", "modifiedDate", "", "id", "(IIIJLjava/lang/String;I)V", "getId", "()I", "getModifiedDate", "()Ljava/lang/String;", "getProductId", "getTrackNumber", "getTrackPosition", "()J", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackPositionDomain.kt */
public final class PlaybackPositionDomain {

    /* renamed from: id */
    private final int f625id;
    private final String modifiedDate;
    private final int productId;
    private final int trackNumber;
    private final long trackPosition;
    private final int userId;

    public static /* synthetic */ PlaybackPositionDomain copy$default(PlaybackPositionDomain playbackPositionDomain, int i, int i2, int i3, long j, String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = playbackPositionDomain.userId;
        }
        if ((i5 & 2) != 0) {
            i2 = playbackPositionDomain.productId;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = playbackPositionDomain.trackNumber;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            j = playbackPositionDomain.trackPosition;
        }
        long j2 = j;
        if ((i5 & 16) != 0) {
            str = playbackPositionDomain.modifiedDate;
        }
        String str2 = str;
        if ((i5 & 32) != 0) {
            i4 = playbackPositionDomain.f625id;
        }
        return playbackPositionDomain.copy(i, i6, i7, j2, str2, i4);
    }

    public final int component1() {
        return this.userId;
    }

    public final int component2() {
        return this.productId;
    }

    public final int component3() {
        return this.trackNumber;
    }

    public final long component4() {
        return this.trackPosition;
    }

    public final String component5() {
        return this.modifiedDate;
    }

    public final int component6() {
        return this.f625id;
    }

    public final PlaybackPositionDomain copy(int i, int i2, int i3, long j, String str, int i4) {
        Intrinsics.checkNotNullParameter(str, "modifiedDate");
        return new PlaybackPositionDomain(i, i2, i3, j, str, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaybackPositionDomain)) {
            return false;
        }
        PlaybackPositionDomain playbackPositionDomain = (PlaybackPositionDomain) obj;
        return this.userId == playbackPositionDomain.userId && this.productId == playbackPositionDomain.productId && this.trackNumber == playbackPositionDomain.trackNumber && this.trackPosition == playbackPositionDomain.trackPosition && Intrinsics.areEqual((Object) this.modifiedDate, (Object) playbackPositionDomain.modifiedDate) && this.f625id == playbackPositionDomain.f625id;
    }

    public int hashCode() {
        return (((((((((this.userId * 31) + this.productId) * 31) + this.trackNumber) * 31) + PlaybackPositionDomain$$ExternalSyntheticBackport0.m493m(this.trackPosition)) * 31) + this.modifiedDate.hashCode()) * 31) + this.f625id;
    }

    public String toString() {
        return "PlaybackPositionDomain(userId=" + this.userId + ", productId=" + this.productId + ", trackNumber=" + this.trackNumber + ", trackPosition=" + this.trackPosition + ", modifiedDate=" + this.modifiedDate + ", id=" + this.f625id + ')';
    }

    public PlaybackPositionDomain(int i, int i2, int i3, long j, String str, int i4) {
        Intrinsics.checkNotNullParameter(str, "modifiedDate");
        this.userId = i;
        this.productId = i2;
        this.trackNumber = i3;
        this.trackPosition = j;
        this.modifiedDate = str;
        this.f625id = i4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PlaybackPositionDomain(int r6, int r7, int r8, long r9, java.lang.String r11, int r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = -1
            if (r14 == 0) goto L_0x0007
            r14 = -1
            goto L_0x0008
        L_0x0007:
            r14 = r6
        L_0x0008:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x000e
            r1 = -1
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r8
        L_0x0015:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x001b
            r9 = 0
        L_0x001b:
            r2 = r9
            r6 = r13 & 16
            if (r6 == 0) goto L_0x0022
            java.lang.String r11 = ""
        L_0x0022:
            r4 = r11
            r6 = r13 & 32
            if (r6 == 0) goto L_0x002a
            r12 = 0
            r13 = 0
            goto L_0x002b
        L_0x002a:
            r13 = r12
        L_0x002b:
            r6 = r5
            r7 = r14
            r8 = r1
            r9 = r0
            r10 = r2
            r12 = r4
            r6.<init>(r7, r8, r9, r10, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.model.domain.PlaybackPositionDomain.<init>(int, int, int, long, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getUserId() {
        return this.userId;
    }

    public final int getProductId() {
        return this.productId;
    }

    public final int getTrackNumber() {
        return this.trackNumber;
    }

    public final long getTrackPosition() {
        return this.trackPosition;
    }

    public final String getModifiedDate() {
        return this.modifiedDate;
    }

    public final int getId() {
        return this.f625id;
    }

    public PlaybackPositionDomain() {
        this(-1, -1, -1, 0, "", 0, 32, (DefaultConstructorMarker) null);
    }
}
