package media.tiger.tigerbox.services.interfaces.audioPlayer;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.DownloadReason;
import org.spongycastle.i18n.MessageBundle;

@Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B;\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000eHÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006&"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "Ljava/io/Serializable;", "productId", "", "hls", "", "cover", "(ILjava/lang/String;Ljava/lang/String;)V", "id", "hlsPath", "coverPath", "title", "author", "downloadReason", "Lmedia/tiger/tigerbox/model/domain/DownloadReason;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmedia/tiger/tigerbox/model/domain/DownloadReason;)V", "getAuthor", "()Ljava/lang/String;", "getCoverPath", "getDownloadReason", "()Lmedia/tiger/tigerbox/model/domain/DownloadReason;", "getHlsPath", "getId", "()I", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlayerService.kt */
public final class AudioProductInfo implements Serializable {
    private final String author;
    private final String coverPath;
    private final DownloadReason downloadReason;
    private final String hlsPath;

    /* renamed from: id */
    private final int f653id;
    private final String title;

    public static /* synthetic */ AudioProductInfo copy$default(AudioProductInfo audioProductInfo, int i, String str, String str2, String str3, String str4, DownloadReason downloadReason2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = audioProductInfo.f653id;
        }
        if ((i2 & 2) != 0) {
            str = audioProductInfo.hlsPath;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = audioProductInfo.coverPath;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = audioProductInfo.title;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = audioProductInfo.author;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            downloadReason2 = audioProductInfo.downloadReason;
        }
        return audioProductInfo.copy(i, str5, str6, str7, str8, downloadReason2);
    }

    public final int component1() {
        return this.f653id;
    }

    public final String component2() {
        return this.hlsPath;
    }

    public final String component3() {
        return this.coverPath;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.author;
    }

    public final DownloadReason component6() {
        return this.downloadReason;
    }

    public final AudioProductInfo copy(int i, String str, String str2, String str3, String str4, DownloadReason downloadReason2) {
        Intrinsics.checkNotNullParameter(str, "hlsPath");
        Intrinsics.checkNotNullParameter(str2, "coverPath");
        Intrinsics.checkNotNullParameter(str3, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str4, "author");
        Intrinsics.checkNotNullParameter(downloadReason2, "downloadReason");
        return new AudioProductInfo(i, str, str2, str3, str4, downloadReason2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioProductInfo)) {
            return false;
        }
        AudioProductInfo audioProductInfo = (AudioProductInfo) obj;
        return this.f653id == audioProductInfo.f653id && Intrinsics.areEqual((Object) this.hlsPath, (Object) audioProductInfo.hlsPath) && Intrinsics.areEqual((Object) this.coverPath, (Object) audioProductInfo.coverPath) && Intrinsics.areEqual((Object) this.title, (Object) audioProductInfo.title) && Intrinsics.areEqual((Object) this.author, (Object) audioProductInfo.author) && this.downloadReason == audioProductInfo.downloadReason;
    }

    public int hashCode() {
        return (((((((((this.f653id * 31) + this.hlsPath.hashCode()) * 31) + this.coverPath.hashCode()) * 31) + this.title.hashCode()) * 31) + this.author.hashCode()) * 31) + this.downloadReason.hashCode();
    }

    public String toString() {
        return "AudioProductInfo(id=" + this.f653id + ", hlsPath=" + this.hlsPath + ", coverPath=" + this.coverPath + ", title=" + this.title + ", author=" + this.author + ", downloadReason=" + this.downloadReason + ')';
    }

    public AudioProductInfo(int i, String str, String str2, String str3, String str4, DownloadReason downloadReason2) {
        Intrinsics.checkNotNullParameter(str, "hlsPath");
        Intrinsics.checkNotNullParameter(str2, "coverPath");
        Intrinsics.checkNotNullParameter(str3, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str4, "author");
        Intrinsics.checkNotNullParameter(downloadReason2, "downloadReason");
        this.f653id = i;
        this.hlsPath = str;
        this.coverPath = str2;
        this.title = str3;
        this.author = str4;
        this.downloadReason = downloadReason2;
    }

    public final int getId() {
        return this.f653id;
    }

    public final String getHlsPath() {
        return this.hlsPath;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getAuthor() {
        return this.author;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AudioProductInfo(int r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, media.tiger.tigerbox.model.domain.DownloadReason r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 8
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0008
            r6 = r1
            goto L_0x0009
        L_0x0008:
            r6 = r13
        L_0x0009:
            r0 = r16 & 16
            if (r0 == 0) goto L_0x000f
            r7 = r1
            goto L_0x0010
        L_0x000f:
            r7 = r14
        L_0x0010:
            r0 = r16 & 32
            if (r0 == 0) goto L_0x0018
            media.tiger.tigerbox.model.domain.DownloadReason r0 = media.tiger.tigerbox.model.domain.DownloadReason.NONE
            r8 = r0
            goto L_0x0019
        L_0x0018:
            r8 = r15
        L_0x0019:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, media.tiger.tigerbox.model.domain.DownloadReason, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final DownloadReason getDownloadReason() {
        return this.downloadReason;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AudioProductInfo(int i, String str, String str2) {
        this(i, str, str2, "", "", DownloadReason.NONE);
        Intrinsics.checkNotNullParameter(str, "hls");
        Intrinsics.checkNotNullParameter(str2, "cover");
    }
}
