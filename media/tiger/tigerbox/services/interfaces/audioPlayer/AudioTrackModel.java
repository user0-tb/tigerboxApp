package media.tiger.tigerbox.services.interfaces.audioPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.PlaybackPositionDomain$$ExternalSyntheticBackport0;
import org.spongycastle.i18n.MessageBundle;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioTrackModel;", "", "title", "", "duration", "", "encodingsM3ULocalPath", "encodingsM3UUrl", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getDuration", "()J", "getEncodingsM3ULocalPath", "()Ljava/lang/String;", "getEncodingsM3UUrl", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioTrackModel.kt */
public final class AudioTrackModel {
    private final long duration;
    private final String encodingsM3ULocalPath;
    private final String encodingsM3UUrl;
    private final String title;

    public static /* synthetic */ AudioTrackModel copy$default(AudioTrackModel audioTrackModel, String str, long j, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = audioTrackModel.title;
        }
        if ((i & 2) != 0) {
            j = audioTrackModel.duration;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = audioTrackModel.encodingsM3ULocalPath;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = audioTrackModel.encodingsM3UUrl;
        }
        return audioTrackModel.copy(str, j2, str4, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final long component2() {
        return this.duration;
    }

    public final String component3() {
        return this.encodingsM3ULocalPath;
    }

    public final String component4() {
        return this.encodingsM3UUrl;
    }

    public final AudioTrackModel copy(String str, long j, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "encodingsM3ULocalPath");
        Intrinsics.checkNotNullParameter(str3, "encodingsM3UUrl");
        return new AudioTrackModel(str, j, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioTrackModel)) {
            return false;
        }
        AudioTrackModel audioTrackModel = (AudioTrackModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) audioTrackModel.title) && this.duration == audioTrackModel.duration && Intrinsics.areEqual((Object) this.encodingsM3ULocalPath, (Object) audioTrackModel.encodingsM3ULocalPath) && Intrinsics.areEqual((Object) this.encodingsM3UUrl, (Object) audioTrackModel.encodingsM3UUrl);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + PlaybackPositionDomain$$ExternalSyntheticBackport0.m493m(this.duration)) * 31) + this.encodingsM3ULocalPath.hashCode()) * 31) + this.encodingsM3UUrl.hashCode();
    }

    public String toString() {
        return "AudioTrackModel(title=" + this.title + ", duration=" + this.duration + ", encodingsM3ULocalPath=" + this.encodingsM3ULocalPath + ", encodingsM3UUrl=" + this.encodingsM3UUrl + ')';
    }

    public AudioTrackModel(String str, long j, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "encodingsM3ULocalPath");
        Intrinsics.checkNotNullParameter(str3, "encodingsM3UUrl");
        this.title = str;
        this.duration = j;
        this.encodingsM3ULocalPath = str2;
        this.encodingsM3UUrl = str3;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getEncodingsM3ULocalPath() {
        return this.encodingsM3ULocalPath;
    }

    public final String getEncodingsM3UUrl() {
        return this.encodingsM3UUrl;
    }
}
