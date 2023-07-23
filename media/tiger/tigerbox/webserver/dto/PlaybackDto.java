package media.tiger.tigerbox.webserver.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.PlaybackPositionDomain$$ExternalSyntheticBackport0;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nBM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\rHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J\\\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/dto/PlaybackDto;", "", "productId", "", "cover", "", "title", "author", "isPaused", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "trackNumber", "trackPosition", "", "coverUrl", "(IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAuthor", "()Ljava/lang/String;", "getCoverUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProductId", "()I", "getTitle", "getTrackNumber", "getTrackPosition", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lmedia/tiger/tigerbox/webserver/dto/PlaybackDto;", "equals", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackDto.kt */
public final class PlaybackDto {
    private final String author;
    private final String coverUrl;
    private final Boolean isPaused;
    private final int productId;
    private final String title;
    private final int trackNumber;
    private final long trackPosition;

    public static /* synthetic */ PlaybackDto copy$default(PlaybackDto playbackDto, int i, int i2, long j, String str, String str2, String str3, Boolean bool, int i3, Object obj) {
        PlaybackDto playbackDto2 = playbackDto;
        return playbackDto.copy((i3 & 1) != 0 ? playbackDto2.productId : i, (i3 & 2) != 0 ? playbackDto2.trackNumber : i2, (i3 & 4) != 0 ? playbackDto2.trackPosition : j, (i3 & 8) != 0 ? playbackDto2.coverUrl : str, (i3 & 16) != 0 ? playbackDto2.title : str2, (i3 & 32) != 0 ? playbackDto2.author : str3, (i3 & 64) != 0 ? playbackDto2.isPaused : bool);
    }

    public final int component1() {
        return this.productId;
    }

    public final int component2() {
        return this.trackNumber;
    }

    public final long component3() {
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

    public final PlaybackDto copy(int i, int i2, long j, String str, String str2, String str3, Boolean bool) {
        return new PlaybackDto(i, i2, j, str, str2, str3, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaybackDto)) {
            return false;
        }
        PlaybackDto playbackDto = (PlaybackDto) obj;
        return this.productId == playbackDto.productId && this.trackNumber == playbackDto.trackNumber && this.trackPosition == playbackDto.trackPosition && Intrinsics.areEqual((Object) this.coverUrl, (Object) playbackDto.coverUrl) && Intrinsics.areEqual((Object) this.title, (Object) playbackDto.title) && Intrinsics.areEqual((Object) this.author, (Object) playbackDto.author) && Intrinsics.areEqual((Object) this.isPaused, (Object) playbackDto.isPaused);
    }

    public int hashCode() {
        int m = ((((this.productId * 31) + this.trackNumber) * 31) + PlaybackPositionDomain$$ExternalSyntheticBackport0.m493m(this.trackPosition)) * 31;
        String str = this.coverUrl;
        int i = 0;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.author;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isPaused;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "PlaybackDto(productId=" + this.productId + ", trackNumber=" + this.trackNumber + ", trackPosition=" + this.trackPosition + ", coverUrl=" + this.coverUrl + ", title=" + this.title + ", author=" + this.author + ", isPaused=" + this.isPaused + ')';
    }

    public PlaybackDto(int i, int i2, long j, String str, String str2, String str3, Boolean bool) {
        this.productId = i;
        this.trackNumber = i2;
        this.trackPosition = j;
        this.coverUrl = str;
        this.title = str2;
        this.author = str3;
        this.isPaused = bool;
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

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getAuthor() {
        return this.author;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaybackDto(int i, int i2, long j, String str, String str2, String str3, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? false : bool);
    }

    public final Boolean isPaused() {
        return this.isPaused;
    }

    public PlaybackDto(int i, String str, String str2, String str3, Boolean bool) {
        this(i, 0, 0, str, str2, str3, (Boolean) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaybackDto(int i, String str, String str2, String str3, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : bool);
    }
}
