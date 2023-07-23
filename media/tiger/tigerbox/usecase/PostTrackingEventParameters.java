package media.tiger.tigerbox.usecase;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.dto.PlaybackTrackingEvent;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/PostTrackingEventParameters;", "", "event", "Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;", "isNew", "", "(Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;Z)V", "getEvent", "()Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PostTrackingEventUseCase.kt */
public final class PostTrackingEventParameters {
    private final PlaybackTrackingEvent event;
    private final boolean isNew;

    public static /* synthetic */ PostTrackingEventParameters copy$default(PostTrackingEventParameters postTrackingEventParameters, PlaybackTrackingEvent playbackTrackingEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            playbackTrackingEvent = postTrackingEventParameters.event;
        }
        if ((i & 2) != 0) {
            z = postTrackingEventParameters.isNew;
        }
        return postTrackingEventParameters.copy(playbackTrackingEvent, z);
    }

    public final PlaybackTrackingEvent component1() {
        return this.event;
    }

    public final boolean component2() {
        return this.isNew;
    }

    public final PostTrackingEventParameters copy(PlaybackTrackingEvent playbackTrackingEvent, boolean z) {
        Intrinsics.checkNotNullParameter(playbackTrackingEvent, NotificationCompat.CATEGORY_EVENT);
        return new PostTrackingEventParameters(playbackTrackingEvent, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostTrackingEventParameters)) {
            return false;
        }
        PostTrackingEventParameters postTrackingEventParameters = (PostTrackingEventParameters) obj;
        return Intrinsics.areEqual((Object) this.event, (Object) postTrackingEventParameters.event) && this.isNew == postTrackingEventParameters.isNew;
    }

    public int hashCode() {
        int hashCode = this.event.hashCode() * 31;
        boolean z = this.isNew;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "PostTrackingEventParameters(event=" + this.event + ", isNew=" + this.isNew + ')';
    }

    public PostTrackingEventParameters(PlaybackTrackingEvent playbackTrackingEvent, boolean z) {
        Intrinsics.checkNotNullParameter(playbackTrackingEvent, NotificationCompat.CATEGORY_EVENT);
        this.event = playbackTrackingEvent;
        this.isNew = z;
    }

    public final PlaybackTrackingEvent getEvent() {
        return this.event;
    }

    public final boolean isNew() {
        return this.isNew;
    }
}
