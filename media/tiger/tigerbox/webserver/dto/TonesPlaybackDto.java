package media.tiger.tigerbox.webserver.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J`\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/dto/TonesPlaybackDto;", "", "productId", "", "cover", "", "title", "author", "isPaused", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "trackNumber", "trackPosition", "", "coverUrl", "(ILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAuthor", "()Ljava/lang/String;", "getCoverUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProductId", "()I", "getTitle", "getTrackNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTrackPosition", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lmedia/tiger/tigerbox/webserver/dto/TonesPlaybackDto;", "equals", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackDto.kt */
public final class TonesPlaybackDto {
    private final String author;
    private final String coverUrl;
    private final Boolean isPaused;
    private final int productId;
    private final String title;
    private final Integer trackNumber;
    private final Long trackPosition;

    public static /* synthetic */ TonesPlaybackDto copy$default(TonesPlaybackDto tonesPlaybackDto, int i, Integer num, Long l, String str, String str2, String str3, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tonesPlaybackDto.productId;
        }
        if ((i2 & 2) != 0) {
            num = tonesPlaybackDto.trackNumber;
        }
        Integer num2 = num;
        if ((i2 & 4) != 0) {
            l = tonesPlaybackDto.trackPosition;
        }
        Long l2 = l;
        if ((i2 & 8) != 0) {
            str = tonesPlaybackDto.coverUrl;
        }
        String str4 = str;
        if ((i2 & 16) != 0) {
            str2 = tonesPlaybackDto.title;
        }
        String str5 = str2;
        if ((i2 & 32) != 0) {
            str3 = tonesPlaybackDto.author;
        }
        String str6 = str3;
        if ((i2 & 64) != 0) {
            bool = tonesPlaybackDto.isPaused;
        }
        return tonesPlaybackDto.copy(i, num2, l2, str4, str5, str6, bool);
    }

    public final int component1() {
        return this.productId;
    }

    public final Integer component2() {
        return this.trackNumber;
    }

    public final Long component3() {
        return this.trackPosition;
    }

    public final String component4() {
        return this.coverUrl;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.author;
    }

    public final Boolean component7() {
        return this.isPaused;
    }

    public final TonesPlaybackDto copy(int i, Integer num, Long l, String str, String str2, String str3, Boolean bool) {
        return new TonesPlaybackDto(i, num, l, str, str2, str3, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TonesPlaybackDto)) {
            return false;
        }
        TonesPlaybackDto tonesPlaybackDto = (TonesPlaybackDto) obj;
        return this.productId == tonesPlaybackDto.productId && Intrinsics.areEqual((Object) this.trackNumber, (Object) tonesPlaybackDto.trackNumber) && Intrinsics.areEqual((Object) this.trackPosition, (Object) tonesPlaybackDto.trackPosition) && Intrinsics.areEqual((Object) this.coverUrl, (Object) tonesPlaybackDto.coverUrl) && Intrinsics.areEqual((Object) this.title, (Object) tonesPlaybackDto.title) && Intrinsics.areEqual((Object) this.author, (Object) tonesPlaybackDto.author) && Intrinsics.areEqual((Object) this.isPaused, (Object) tonesPlaybackDto.isPaused);
    }

    public int hashCode() {
        int i = this.productId * 31;
        Integer num = this.trackNumber;
        int i2 = 0;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.trackPosition;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.coverUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.author;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isPaused;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return "TonesPlaybackDto(productId=" + this.productId + ", trackNumber=" + this.trackNumber + ", trackPosition=" + this.trackPosition + ", coverUrl=" + this.coverUrl + ", title=" + this.title + ", author=" + this.author + ", isPaused=" + this.isPaused + ')';
    }

    public TonesPlaybackDto(int i, Integer num, Long l, String str, String str2, String str3, Boolean bool) {
        this.productId = i;
        this.trackNumber = num;
        this.trackPosition = l;
        this.coverUrl = str;
        this.title = str2;
        this.author = str3;
        this.isPaused = bool;
    }

    public final int getProductId() {
        return this.productId;
    }

    public final Integer getTrackNumber() {
        return this.trackNumber;
    }

    public final Long getTrackPosition() {
        return this.trackPosition;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getAuthor() {
        return this.author;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TonesPlaybackDto(int r7, java.lang.Integer r8, java.lang.Long r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r0 = r14 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r8
        L_0x0008:
            r2 = r14 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r3 = r14 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r10
        L_0x0016:
            r4 = r14 & 16
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r11
        L_0x001d:
            r5 = r14 & 32
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r12
        L_0x0023:
            r5 = r14 & 64
            if (r5 == 0) goto L_0x002d
            r5 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x002e
        L_0x002d:
            r5 = r13
        L_0x002e:
            r8 = r6
            r9 = r7
            r10 = r0
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r1
            r15 = r5
            r8.<init>((int) r9, (java.lang.Integer) r10, (java.lang.Long) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.Boolean) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.webserver.dto.TonesPlaybackDto.<init>(int, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean isPaused() {
        return this.isPaused;
    }

    public TonesPlaybackDto(int i, String str, String str2, String str3, Boolean bool) {
        this(i, (Integer) null, (Long) null, str, str2, str3, (Boolean) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TonesPlaybackDto(int i, String str, String str2, String str3, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : bool);
    }
}
