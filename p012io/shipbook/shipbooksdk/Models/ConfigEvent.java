package p012io.shipbook.shipbooksdk.Models;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p012io.shipbook.shipbooksdk.Models.BaseLog;

@Metadata(mo33736d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/ConfigEvent;", "Lio/shipbook/shipbooksdk/Models/BaseEvent;", "orientation", "Lio/shipbook/shipbooksdk/Models/Orientation;", "orderId", "", "time", "Ljava/util/Date;", "threadInfo", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "(Lio/shipbook/shipbooksdk/Models/Orientation;ILjava/util/Date;Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;)V", "getOrderId", "()I", "setOrderId", "(I)V", "getOrientation", "()Lio/shipbook/shipbooksdk/Models/Orientation;", "getThreadInfo", "()Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "getTime", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.ConfigEvent */
/* compiled from: ConfigEvent.kt */
public final class ConfigEvent extends BaseEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int orderId;
    private final Orientation orientation;
    private final BaseLog.ThreadInfo threadInfo;
    private final Date time;

    public static /* synthetic */ ConfigEvent copy$default(ConfigEvent configEvent, Orientation orientation2, int i, Date date, BaseLog.ThreadInfo threadInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            orientation2 = configEvent.orientation;
        }
        if ((i2 & 2) != 0) {
            i = configEvent.getOrderId();
        }
        if ((i2 & 4) != 0) {
            date = configEvent.getTime();
        }
        if ((i2 & 8) != 0) {
            threadInfo2 = configEvent.getThreadInfo();
        }
        return configEvent.copy(orientation2, i, date, threadInfo2);
    }

    public final Orientation component1() {
        return this.orientation;
    }

    public final int component2() {
        return getOrderId();
    }

    public final Date component3() {
        return getTime();
    }

    public final BaseLog.ThreadInfo component4() {
        return getThreadInfo();
    }

    public final ConfigEvent copy(Orientation orientation2, int i, Date date, BaseLog.ThreadInfo threadInfo2) {
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(date, "time");
        Intrinsics.checkNotNullParameter(threadInfo2, "threadInfo");
        return new ConfigEvent(orientation2, i, date, threadInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigEvent)) {
            return false;
        }
        ConfigEvent configEvent = (ConfigEvent) obj;
        return this.orientation == configEvent.orientation && getOrderId() == configEvent.getOrderId() && Intrinsics.areEqual((Object) getTime(), (Object) configEvent.getTime()) && Intrinsics.areEqual((Object) getThreadInfo(), (Object) configEvent.getThreadInfo());
    }

    public int hashCode() {
        return (((((this.orientation.hashCode() * 31) + getOrderId()) * 31) + getTime().hashCode()) * 31) + getThreadInfo().hashCode();
    }

    public String toString() {
        return "ConfigEvent(orientation=" + this.orientation + ", orderId=" + getOrderId() + ", time=" + getTime() + ", threadInfo=" + getThreadInfo() + ')';
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int i) {
        this.orderId = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConfigEvent(Orientation orientation2, int i, Date date, BaseLog.ThreadInfo threadInfo2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation2, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? new Date() : date, (i2 & 8) != 0 ? new BaseLog.ThreadInfo((String) null, 0, false, 7, (DefaultConstructorMarker) null) : threadInfo2);
    }

    public Date getTime() {
        return this.time;
    }

    @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/ConfigEvent$Companion;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Models/ConfigEvent;", "json", "Lorg/json/JSONObject;", "orderId", "", "time", "Ljava/util/Date;", "threadInfo", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.ConfigEvent$Companion */
    /* compiled from: ConfigEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConfigEvent create(JSONObject jSONObject, int i, Date date, BaseLog.ThreadInfo threadInfo) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            Intrinsics.checkNotNullParameter(date, "time");
            Intrinsics.checkNotNullParameter(threadInfo, "threadInfo");
            String optString = jSONObject.optString("orientation");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"orientation\")");
            return new ConfigEvent(Orientation.valueOf(optString), i, date, threadInfo);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfigEvent(Orientation orientation2, int i, Date date, BaseLog.ThreadInfo threadInfo2) {
        super("configEvent");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(date, "time");
        Intrinsics.checkNotNullParameter(threadInfo2, "threadInfo");
        this.orientation = orientation2;
        this.orderId = i;
        this.time = date;
        this.threadInfo = threadInfo2;
        setOrderId(incrementOrderId(getOrderId()));
    }

    public BaseLog.ThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    public JSONObject toJson() {
        JSONObject json = super.toJson();
        json.put("orientation", this.orientation);
        return json;
    }
}
