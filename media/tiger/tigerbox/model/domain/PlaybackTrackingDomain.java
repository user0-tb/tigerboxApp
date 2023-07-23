package media.tiger.tigerbox.model.domain;

import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.extractor.p007ts.PsExtractor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BU\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006&"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/PlaybackTrackingDomain;", "", "()V", "accountId", "", "userId", "productId", "event", "", "start", "end", "total", "id", "(IIILjava/lang/String;IIII)V", "getAccountId", "()I", "getEnd", "getEvent", "()Ljava/lang/String;", "getId", "getProductId", "getStart", "getTotal", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackTrackingDomain.kt */
public final class PlaybackTrackingDomain {
    private final int accountId;
    private final int end;
    private final String event;

    /* renamed from: id */
    private final int f626id;
    private final int productId;
    private final int start;
    private final int total;
    private final int userId;

    public static /* synthetic */ PlaybackTrackingDomain copy$default(PlaybackTrackingDomain playbackTrackingDomain, int i, int i2, int i3, String str, int i4, int i5, int i6, int i7, int i8, Object obj) {
        PlaybackTrackingDomain playbackTrackingDomain2 = playbackTrackingDomain;
        int i9 = i8;
        return playbackTrackingDomain.copy((i9 & 1) != 0 ? playbackTrackingDomain2.accountId : i, (i9 & 2) != 0 ? playbackTrackingDomain2.userId : i2, (i9 & 4) != 0 ? playbackTrackingDomain2.productId : i3, (i9 & 8) != 0 ? playbackTrackingDomain2.event : str, (i9 & 16) != 0 ? playbackTrackingDomain2.start : i4, (i9 & 32) != 0 ? playbackTrackingDomain2.end : i5, (i9 & 64) != 0 ? playbackTrackingDomain2.total : i6, (i9 & 128) != 0 ? playbackTrackingDomain2.f626id : i7);
    }

    public final int component1() {
        return this.accountId;
    }

    public final int component2() {
        return this.userId;
    }

    public final int component3() {
        return this.productId;
    }

    public final String component4() {
        return this.event;
    }

    public final int component5() {
        return this.start;
    }

    public final int component6() {
        return this.end;
    }

    public final int component7() {
        return this.total;
    }

    public final int component8() {
        return this.f626id;
    }

    public final PlaybackTrackingDomain copy(int i, int i2, int i3, String str, int i4, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        return new PlaybackTrackingDomain(i, i2, i3, str, i4, i5, i6, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaybackTrackingDomain)) {
            return false;
        }
        PlaybackTrackingDomain playbackTrackingDomain = (PlaybackTrackingDomain) obj;
        return this.accountId == playbackTrackingDomain.accountId && this.userId == playbackTrackingDomain.userId && this.productId == playbackTrackingDomain.productId && Intrinsics.areEqual((Object) this.event, (Object) playbackTrackingDomain.event) && this.start == playbackTrackingDomain.start && this.end == playbackTrackingDomain.end && this.total == playbackTrackingDomain.total && this.f626id == playbackTrackingDomain.f626id;
    }

    public int hashCode() {
        return (((((((((((((this.accountId * 31) + this.userId) * 31) + this.productId) * 31) + this.event.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.total) * 31) + this.f626id;
    }

    public String toString() {
        return "PlaybackTrackingDomain(accountId=" + this.accountId + ", userId=" + this.userId + ", productId=" + this.productId + ", event=" + this.event + ", start=" + this.start + ", end=" + this.end + ", total=" + this.total + ", id=" + this.f626id + ')';
    }

    public PlaybackTrackingDomain(int i, int i2, int i3, String str, int i4, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        this.accountId = i;
        this.userId = i2;
        this.productId = i3;
        this.event = str;
        this.start = i4;
        this.end = i5;
        this.total = i6;
        this.f626id = i7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PlaybackTrackingDomain(int r10, int r11, int r12, java.lang.String r13, int r14, int r15, int r16, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = -1
            if (r1 == 0) goto L_0x0009
            r1 = -1
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = -1
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r2 = r12
        L_0x0017:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x001e
            java.lang.String r4 = "progress"
            goto L_0x001f
        L_0x001e:
            r4 = r13
        L_0x001f:
            r5 = r0 & 16
            r6 = 0
            if (r5 == 0) goto L_0x0026
            r5 = 0
            goto L_0x0027
        L_0x0026:
            r5 = r14
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = 0
            goto L_0x002e
        L_0x002d:
            r7 = r15
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = 0
            goto L_0x0036
        L_0x0034:
            r8 = r16
        L_0x0036:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r6 = r17
        L_0x003d:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r2
            r14 = r4
            r15 = r5
            r16 = r7
            r17 = r8
            r18 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.model.domain.PlaybackTrackingDomain.<init>(int, int, int, java.lang.String, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final int getProductId() {
        return this.productId;
    }

    public final String getEvent() {
        return this.event;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getId() {
        return this.f626id;
    }

    public PlaybackTrackingDomain() {
        this(-1, -1, -1, "progress", 0, 0, 0, 0, PsExtractor.VIDEO_STREAM_MASK, (DefaultConstructorMarker) null);
    }
}
