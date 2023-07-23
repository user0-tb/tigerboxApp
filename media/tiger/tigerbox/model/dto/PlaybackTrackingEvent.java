package media.tiger.tigerbox.model.dto;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;", "", "accountId", "", "userId", "productId", "data", "Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent$EventData;", "event", "", "(IIILmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent$EventData;Ljava/lang/String;)V", "getAccountId", "()I", "getData", "()Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent$EventData;", "getEvent", "()Ljava/lang/String;", "getProductId", "getUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "EventData", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackTrackingEvent.kt */
public final class PlaybackTrackingEvent {
    private final int accountId;
    private final EventData data;
    private final String event;
    private final int productId;
    private final int userId;

    public static /* synthetic */ PlaybackTrackingEvent copy$default(PlaybackTrackingEvent playbackTrackingEvent, int i, int i2, int i3, EventData eventData, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = playbackTrackingEvent.accountId;
        }
        if ((i4 & 2) != 0) {
            i2 = playbackTrackingEvent.userId;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = playbackTrackingEvent.productId;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            eventData = playbackTrackingEvent.data;
        }
        EventData eventData2 = eventData;
        if ((i4 & 16) != 0) {
            str = playbackTrackingEvent.event;
        }
        return playbackTrackingEvent.copy(i, i5, i6, eventData2, str);
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

    public final EventData component4() {
        return this.data;
    }

    public final String component5() {
        return this.event;
    }

    public final PlaybackTrackingEvent copy(int i, int i2, int i3, EventData eventData, String str) {
        Intrinsics.checkNotNullParameter(eventData, "data");
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        return new PlaybackTrackingEvent(i, i2, i3, eventData, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaybackTrackingEvent)) {
            return false;
        }
        PlaybackTrackingEvent playbackTrackingEvent = (PlaybackTrackingEvent) obj;
        return this.accountId == playbackTrackingEvent.accountId && this.userId == playbackTrackingEvent.userId && this.productId == playbackTrackingEvent.productId && Intrinsics.areEqual((Object) this.data, (Object) playbackTrackingEvent.data) && Intrinsics.areEqual((Object) this.event, (Object) playbackTrackingEvent.event);
    }

    public int hashCode() {
        return (((((((this.accountId * 31) + this.userId) * 31) + this.productId) * 31) + this.data.hashCode()) * 31) + this.event.hashCode();
    }

    public String toString() {
        return "PlaybackTrackingEvent(accountId=" + this.accountId + ", userId=" + this.userId + ", productId=" + this.productId + ", data=" + this.data + ", event=" + this.event + ')';
    }

    public PlaybackTrackingEvent(int i, int i2, int i3, EventData eventData, String str) {
        Intrinsics.checkNotNullParameter(eventData, "data");
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        this.accountId = i;
        this.userId = i2;
        this.productId = i3;
        this.data = eventData;
        this.event = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaybackTrackingEvent(int i, int i2, int i3, EventData eventData, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, eventData, (i4 & 16) != 0 ? "progress" : str);
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

    public final EventData getData() {
        return this.data;
    }

    public final String getEvent() {
        return this.event;
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent$EventData;", "", "start", "", "end", "total", "device", "", "(IIILjava/lang/String;)V", "getDevice", "()Ljava/lang/String;", "getEnd", "()I", "getStart", "getTotal", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: PlaybackTrackingEvent.kt */
    public static final class EventData {
        private final String device;
        private final int end;
        private final int start;
        private final int total;

        public static /* synthetic */ EventData copy$default(EventData eventData, int i, int i2, int i3, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = eventData.start;
            }
            if ((i4 & 2) != 0) {
                i2 = eventData.end;
            }
            if ((i4 & 4) != 0) {
                i3 = eventData.total;
            }
            if ((i4 & 8) != 0) {
                str = eventData.device;
            }
            return eventData.copy(i, i2, i3, str);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final int component3() {
            return this.total;
        }

        public final String component4() {
            return this.device;
        }

        public final EventData copy(int i, int i2, int i3, String str) {
            Intrinsics.checkNotNullParameter(str, "device");
            return new EventData(i, i2, i3, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EventData)) {
                return false;
            }
            EventData eventData = (EventData) obj;
            return this.start == eventData.start && this.end == eventData.end && this.total == eventData.total && Intrinsics.areEqual((Object) this.device, (Object) eventData.device);
        }

        public int hashCode() {
            return (((((this.start * 31) + this.end) * 31) + this.total) * 31) + this.device.hashCode();
        }

        public String toString() {
            return "EventData(start=" + this.start + ", end=" + this.end + ", total=" + this.total + ", device=" + this.device + ')';
        }

        public EventData(int i, int i2, int i3, String str) {
            Intrinsics.checkNotNullParameter(str, "device");
            this.start = i;
            this.end = i2;
            this.total = i3;
            this.device = str;
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

        public final String getDevice() {
            return this.device;
        }
    }
}
