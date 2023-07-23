package p012io.shipbook.shipbooksdk.Models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p012io.shipbook.shipbooksdk.Models.BaseLog;

@Metadata(mo33736d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 +2\u00020\u0001:\u0001+BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\bHÖ\u0001J\b\u0010(\u001a\u00020)H\u0016J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/ActionEvent;", "Lio/shipbook/shipbooksdk/Models/BaseEvent;", "action", "", "sender", "senderTitle", "target", "orderId", "", "time", "Ljava/util/Date;", "threadInfo", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Date;Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;)V", "getAction", "()Ljava/lang/String;", "getOrderId", "()I", "setOrderId", "(I)V", "getSender", "getSenderTitle", "getTarget", "getThreadInfo", "()Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "getTime", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.ActionEvent */
/* compiled from: ActionEvent.kt */
public final class ActionEvent extends BaseEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String action;
    private int orderId;
    private final String sender;
    private final String senderTitle;
    private final String target;
    private final BaseLog.ThreadInfo threadInfo;
    private final Date time;

    public static /* synthetic */ ActionEvent copy$default(ActionEvent actionEvent, String str, String str2, String str3, String str4, int i, Date date, BaseLog.ThreadInfo threadInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = actionEvent.action;
        }
        if ((i2 & 2) != 0) {
            str2 = actionEvent.sender;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = actionEvent.senderTitle;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = actionEvent.target;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = actionEvent.getOrderId();
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            date = actionEvent.getTime();
        }
        Date date2 = date;
        if ((i2 & 64) != 0) {
            threadInfo2 = actionEvent.getThreadInfo();
        }
        return actionEvent.copy(str, str5, str6, str7, i3, date2, threadInfo2);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.sender;
    }

    public final String component3() {
        return this.senderTitle;
    }

    public final String component4() {
        return this.target;
    }

    public final int component5() {
        return getOrderId();
    }

    public final Date component6() {
        return getTime();
    }

    public final BaseLog.ThreadInfo component7() {
        return getThreadInfo();
    }

    public final ActionEvent copy(String str, String str2, String str3, String str4, int i, Date date, BaseLog.ThreadInfo threadInfo2) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "sender");
        Intrinsics.checkNotNullParameter(str3, "senderTitle");
        Intrinsics.checkNotNullParameter(str4, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(date, "time");
        BaseLog.ThreadInfo threadInfo3 = threadInfo2;
        Intrinsics.checkNotNullParameter(threadInfo3, "threadInfo");
        return new ActionEvent(str, str2, str3, str4, i, date, threadInfo3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionEvent)) {
            return false;
        }
        ActionEvent actionEvent = (ActionEvent) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) actionEvent.action) && Intrinsics.areEqual((Object) this.sender, (Object) actionEvent.sender) && Intrinsics.areEqual((Object) this.senderTitle, (Object) actionEvent.senderTitle) && Intrinsics.areEqual((Object) this.target, (Object) actionEvent.target) && getOrderId() == actionEvent.getOrderId() && Intrinsics.areEqual((Object) getTime(), (Object) actionEvent.getTime()) && Intrinsics.areEqual((Object) getThreadInfo(), (Object) actionEvent.getThreadInfo());
    }

    public int hashCode() {
        return (((((((((((this.action.hashCode() * 31) + this.sender.hashCode()) * 31) + this.senderTitle.hashCode()) * 31) + this.target.hashCode()) * 31) + getOrderId()) * 31) + getTime().hashCode()) * 31) + getThreadInfo().hashCode();
    }

    public String toString() {
        return "ActionEvent(action=" + this.action + ", sender=" + this.sender + ", senderTitle=" + this.senderTitle + ", target=" + this.target + ", orderId=" + getOrderId() + ", time=" + getTime() + ", threadInfo=" + getThreadInfo() + ')';
    }

    public final String getAction() {
        return this.action;
    }

    public final String getSender() {
        return this.sender;
    }

    public final String getSenderTitle() {
        return this.senderTitle;
    }

    public final String getTarget() {
        return this.target;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int i) {
        this.orderId = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionEvent(String str, String str2, String str3, String str4, int i, Date date, BaseLog.ThreadInfo threadInfo2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? new Date() : date, (i2 & 64) != 0 ? new BaseLog.ThreadInfo((String) null, 0, false, 7, (DefaultConstructorMarker) null) : threadInfo2);
    }

    public Date getTime() {
        return this.time;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionEvent(String str, String str2, String str3, String str4, int i, Date date, BaseLog.ThreadInfo threadInfo2) {
        super("actionEvent");
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "sender");
        Intrinsics.checkNotNullParameter(str3, "senderTitle");
        Intrinsics.checkNotNullParameter(str4, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(date, "time");
        Intrinsics.checkNotNullParameter(threadInfo2, "threadInfo");
        this.action = str;
        this.sender = str2;
        this.senderTitle = str3;
        this.target = str4;
        this.orderId = i;
        this.time = date;
        this.threadInfo = threadInfo2;
        setOrderId(incrementOrderId(getOrderId()));
    }

    public BaseLog.ThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/ActionEvent$Companion;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Models/ActionEvent;", "json", "Lorg/json/JSONObject;", "orderId", "", "time", "Ljava/util/Date;", "threadInfo", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.ActionEvent$Companion */
    /* compiled from: ActionEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActionEvent create(JSONObject jSONObject, int i, Date date, BaseLog.ThreadInfo threadInfo) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            Intrinsics.checkNotNullParameter(date, "time");
            Intrinsics.checkNotNullParameter(threadInfo, "threadInfo");
            String optString = jSONObject.optString("action");
            String optString2 = jSONObject.optString("sender");
            String optString3 = jSONObject.optString("senderTitle");
            String optString4 = jSONObject.optString(TypedValues.AttributesType.S_TARGET);
            Intrinsics.checkNotNullExpressionValue(optString, "action");
            Intrinsics.checkNotNullExpressionValue(optString2, "sender");
            Intrinsics.checkNotNullExpressionValue(optString3, "senderTitle");
            Intrinsics.checkNotNullExpressionValue(optString4, TypedValues.AttributesType.S_TARGET);
            return new ActionEvent(optString, optString2, optString3, optString4, i, date, threadInfo);
        }
    }

    public JSONObject toJson() {
        JSONObject json = super.toJson();
        json.put("action", this.action);
        json.put("sender", this.sender);
        json.put("senderTitle", this.senderTitle);
        json.put(TypedValues.AttributesType.S_TARGET, this.target);
        return json;
    }
}
