package p012io.shipbook.shipbooksdk.Models;

import androidx.core.app.NotificationCompat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.spongycastle.i18n.MessageBundle;
import p012io.shipbook.shipbooksdk.Models.BaseLog;

@Metadata(mo33736d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\b\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006)"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/ActivityEvent;", "Lio/shipbook/shipbooksdk/Models/BaseEvent;", "name", "", "event", "title", "orderId", "", "time", "Ljava/util/Date;", "threadInfo", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Date;Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;)V", "getEvent", "()Ljava/lang/String;", "getName", "getOrderId", "()I", "setOrderId", "(I)V", "getThreadInfo", "()Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "getTime", "()Ljava/util/Date;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.ActivityEvent */
/* compiled from: ActivityEvent.kt */
public final class ActivityEvent extends BaseEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String event;
    private final String name;
    private int orderId;
    private final BaseLog.ThreadInfo threadInfo;
    private final Date time;
    private final String title;

    public static /* synthetic */ ActivityEvent copy$default(ActivityEvent activityEvent, String str, String str2, String str3, int i, Date date, BaseLog.ThreadInfo threadInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = activityEvent.name;
        }
        if ((i2 & 2) != 0) {
            str2 = activityEvent.event;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = activityEvent.title;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            i = activityEvent.getOrderId();
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            date = activityEvent.getTime();
        }
        Date date2 = date;
        if ((i2 & 32) != 0) {
            threadInfo2 = activityEvent.getThreadInfo();
        }
        return activityEvent.copy(str, str4, str5, i3, date2, threadInfo2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.event;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return getOrderId();
    }

    public final Date component5() {
        return getTime();
    }

    public final BaseLog.ThreadInfo component6() {
        return getThreadInfo();
    }

    public final ActivityEvent copy(String str, String str2, String str3, int i, Date date, BaseLog.ThreadInfo threadInfo2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(str3, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(date, "time");
        Intrinsics.checkNotNullParameter(threadInfo2, "threadInfo");
        return new ActivityEvent(str, str2, str3, i, date, threadInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityEvent)) {
            return false;
        }
        ActivityEvent activityEvent = (ActivityEvent) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) activityEvent.name) && Intrinsics.areEqual((Object) this.event, (Object) activityEvent.event) && Intrinsics.areEqual((Object) this.title, (Object) activityEvent.title) && getOrderId() == activityEvent.getOrderId() && Intrinsics.areEqual((Object) getTime(), (Object) activityEvent.getTime()) && Intrinsics.areEqual((Object) getThreadInfo(), (Object) activityEvent.getThreadInfo());
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.event.hashCode()) * 31) + this.title.hashCode()) * 31) + getOrderId()) * 31) + getTime().hashCode()) * 31) + getThreadInfo().hashCode();
    }

    public String toString() {
        return "ActivityEvent(name=" + this.name + ", event=" + this.event + ", title=" + this.title + ", orderId=" + getOrderId() + ", time=" + getTime() + ", threadInfo=" + getThreadInfo() + ')';
    }

    public final String getName() {
        return this.name;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getTitle() {
        return this.title;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int i) {
        this.orderId = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityEvent(String str, String str2, String str3, int i, Date date, BaseLog.ThreadInfo threadInfo2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? new Date() : date, (i2 & 32) != 0 ? new BaseLog.ThreadInfo((String) null, 0, false, 7, (DefaultConstructorMarker) null) : threadInfo2);
    }

    public Date getTime() {
        return this.time;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityEvent(String str, String str2, String str3, int i, Date date, BaseLog.ThreadInfo threadInfo2) {
        super("activityEvent");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(str3, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(date, "time");
        Intrinsics.checkNotNullParameter(threadInfo2, "threadInfo");
        this.name = str;
        this.event = str2;
        this.title = str3;
        this.orderId = i;
        this.time = date;
        this.threadInfo = threadInfo2;
        setOrderId(incrementOrderId(getOrderId()));
    }

    public BaseLog.ThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/ActivityEvent$Companion;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Models/ActivityEvent;", "json", "Lorg/json/JSONObject;", "orderId", "", "time", "Ljava/util/Date;", "threadInfo", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.ActivityEvent$Companion */
    /* compiled from: ActivityEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActivityEvent create(JSONObject jSONObject, int i, Date date, BaseLog.ThreadInfo threadInfo) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            Intrinsics.checkNotNullParameter(date, "time");
            Intrinsics.checkNotNullParameter(threadInfo, "threadInfo");
            String optString = jSONObject.optString("name");
            String optString2 = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
            String optString3 = jSONObject.optString(MessageBundle.TITLE_ENTRY);
            Intrinsics.checkNotNullExpressionValue(optString, "name");
            Intrinsics.checkNotNullExpressionValue(optString2, NotificationCompat.CATEGORY_EVENT);
            Intrinsics.checkNotNullExpressionValue(optString3, MessageBundle.TITLE_ENTRY);
            return new ActivityEvent(optString, optString2, optString3, i, date, threadInfo);
        }
    }

    public JSONObject toJson() {
        JSONObject json = super.toJson();
        json.put("name", this.name);
        json.put(NotificationCompat.CATEGORY_EVENT, this.event);
        json.put(MessageBundle.TITLE_ENTRY, this.title);
        return json;
    }
}
