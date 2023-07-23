package p012io.shipbook.shipbooksdk.Models;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.Models.BaseLog;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/BaseEvent;", "Lio/shipbook/shipbooksdk/Models/BaseLog;", "type", "", "(Ljava/lang/String;)V", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.BaseEvent */
/* compiled from: BaseEvent.kt */
public abstract class BaseEvent extends BaseLog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseEvent(String str) {
        super(str, 0, (Date) null, (BaseLog.ThreadInfo) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, SessionDescription.ATTR_TYPE);
    }
}
