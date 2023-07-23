package p012io.shipbook.shipbooksdk.Models;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p012io.shipbook.shipbooksdk.Util.DateHelper;
import p012io.shipbook.shipbooksdk.Util.DateHelperKt;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/BaseLog;", "Lio/shipbook/shipbooksdk/Models/BaseObj;", "type", "", "orderId", "", "time", "Ljava/util/Date;", "threadInfo", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "(Ljava/lang/String;ILjava/util/Date;Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;)V", "getOrderId", "()I", "setOrderId", "(I)V", "getThreadInfo", "()Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "getTime", "()Ljava/util/Date;", "getType", "()Ljava/lang/String;", "incrementOrderId", "toJson", "Lorg/json/JSONObject;", "Companion", "ThreadInfo", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.BaseLog */
/* compiled from: BaseLog.kt */
public abstract class BaseLog implements BaseObj {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static AtomicInteger count = new AtomicInteger(0);
    private int orderId;
    private final ThreadInfo threadInfo;
    private final Date time;
    private final String type;

    public BaseLog(String str, int i, Date date, ThreadInfo threadInfo2) {
        Intrinsics.checkNotNullParameter(str, SessionDescription.ATTR_TYPE);
        Intrinsics.checkNotNullParameter(date, "time");
        Intrinsics.checkNotNullParameter(threadInfo2, "threadInfo");
        this.type = str;
        this.orderId = i;
        this.time = date;
        this.threadInfo = threadInfo2;
    }

    public final String getType() {
        return this.type;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int i) {
        this.orderId = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseLog(String str, int i, Date date, ThreadInfo threadInfo2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? new Date() : date, (i2 & 8) != 0 ? new ThreadInfo((String) null, 0, false, 7, (DefaultConstructorMarker) null) : threadInfo2);
    }

    public Date getTime() {
        return this.time;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/BaseLog$Companion;", "", "()V", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "create", "Lio/shipbook/shipbooksdk/Models/BaseLog;", "json", "Lorg/json/JSONObject;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.BaseLog$Companion */
    /* compiled from: BaseLog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AtomicInteger getCount() {
            return BaseLog.count;
        }

        public final void setCount(AtomicInteger atomicInteger) {
            Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
            BaseLog.count = atomicInteger;
        }

        public final BaseLog create(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = jSONObject.optString(SessionDescription.ATTR_TYPE);
            int i = jSONObject.getInt("orderId");
            DateHelper dateHelper = DateHelper.INSTANCE;
            String optString2 = jSONObject.optString("time");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"time\")");
            Date createDateStandard = dateHelper.createDateStandard(optString2);
            Intrinsics.checkNotNull(createDateStandard);
            ThreadInfo.Companion companion = ThreadInfo.Companion;
            JSONObject jSONObject2 = jSONObject.getJSONObject("threadInfo");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.getJSONObject(\"threadInfo\")");
            ThreadInfo create = companion.create(jSONObject2);
            if (optString != null) {
                switch (optString.hashCode()) {
                    case -1060101941:
                        if (optString.equals("activityEvent")) {
                            return ActivityEvent.Companion.create(jSONObject, i, createDateStandard, create);
                        }
                        break;
                    case -882798038:
                        if (optString.equals("fragmentEvent")) {
                            return FragmentEvent.Companion.create(jSONObject, i, createDateStandard, create);
                        }
                        break;
                    case -67033714:
                        if (optString.equals("screenEvent")) {
                            return ScreenEvent.Companion.create(jSONObject, i, createDateStandard, create);
                        }
                        break;
                    case -6440840:
                        if (optString.equals("configEvent")) {
                            return ConfigEvent.Companion.create(jSONObject, i, createDateStandard, create);
                        }
                        break;
                    case 954925063:
                        if (optString.equals("message")) {
                            return Message.Companion.create(jSONObject, i, createDateStandard, create);
                        }
                        break;
                    case 1481625679:
                        if (optString.equals("exception")) {
                            return Exception.Companion.create(jSONObject, i, createDateStandard, create);
                        }
                        break;
                    case 1559787012:
                        if (optString.equals("actionEvent")) {
                            return ActionEvent.Companion.create(jSONObject, i, createDateStandard, create);
                        }
                        break;
                }
            }
            throw new Error("There doesn't exist this type");
        }
    }

    public ThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    public final int incrementOrderId(int i) {
        return i == 0 ? count.incrementAndGet() : i;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SessionDescription.ATTR_TYPE, this.type);
        jSONObject.put("orderId", getOrderId());
        jSONObject.put("time", DateHelperKt.toStandardString(getTime()));
        jSONObject.put("threadInfo", getThreadInfo().toJson());
        return jSONObject;
    }

    @Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0001 B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "Lio/shipbook/shipbooksdk/Models/BaseObj;", "threadName", "", "threadId", "", "isMain", "", "(Ljava/lang/String;JZ)V", "()Z", "setMain", "(Z)V", "getThreadId", "()J", "setThreadId", "(J)V", "getThreadName", "()Ljava/lang/String;", "setThreadName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.BaseLog$ThreadInfo */
    /* compiled from: BaseLog.kt */
    public static final class ThreadInfo implements BaseObj {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private boolean isMain;
        private long threadId;
        private String threadName;

        public ThreadInfo() {
            this((String) null, 0, false, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ThreadInfo copy$default(ThreadInfo threadInfo, String str, long j, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = threadInfo.threadName;
            }
            if ((i & 2) != 0) {
                j = threadInfo.threadId;
            }
            if ((i & 4) != 0) {
                z = threadInfo.isMain;
            }
            return threadInfo.copy(str, j, z);
        }

        public final String component1() {
            return this.threadName;
        }

        public final long component2() {
            return this.threadId;
        }

        public final boolean component3() {
            return this.isMain;
        }

        public final ThreadInfo copy(String str, long j, boolean z) {
            Intrinsics.checkNotNullParameter(str, "threadName");
            return new ThreadInfo(str, j, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ThreadInfo)) {
                return false;
            }
            ThreadInfo threadInfo = (ThreadInfo) obj;
            return Intrinsics.areEqual((Object) this.threadName, (Object) threadInfo.threadName) && this.threadId == threadInfo.threadId && this.isMain == threadInfo.isMain;
        }

        public int hashCode() {
            int hashCode = ((this.threadName.hashCode() * 31) + BaseLog$ThreadInfo$$ExternalSyntheticBackport0.m465m(this.threadId)) * 31;
            boolean z = this.isMain;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "ThreadInfo(threadName=" + this.threadName + ", threadId=" + this.threadId + ", isMain=" + this.isMain + ')';
        }

        public ThreadInfo(String str, long j, boolean z) {
            Intrinsics.checkNotNullParameter(str, "threadName");
            this.threadName = str;
            this.threadId = j;
            this.isMain = z;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ ThreadInfo(java.lang.String r1, long r2, boolean r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
            /*
                r0 = this;
                r6 = r5 & 1
                if (r6 == 0) goto L_0x0011
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                java.lang.String r1 = r1.getName()
                java.lang.String r6 = "currentThread().name"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            L_0x0011:
                r6 = r5 & 2
                if (r6 == 0) goto L_0x001d
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                long r2 = r2.getId()
            L_0x001d:
                r5 = r5 & 4
                if (r5 == 0) goto L_0x002d
                android.os.Looper r4 = android.os.Looper.myLooper()
                android.os.Looper r5 = android.os.Looper.getMainLooper()
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            L_0x002d:
                r0.<init>(r1, r2, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p012io.shipbook.shipbooksdk.Models.BaseLog.ThreadInfo.<init>(java.lang.String, long, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getThreadName() {
            return this.threadName;
        }

        public final void setThreadName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.threadName = str;
        }

        public final long getThreadId() {
            return this.threadId;
        }

        public final void setThreadId(long j) {
            this.threadId = j;
        }

        public final boolean isMain() {
            return this.isMain;
        }

        public final void setMain(boolean z) {
            this.isMain = z;
        }

        @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo$Companion;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "json", "Lorg/json/JSONObject;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: io.shipbook.shipbooksdk.Models.BaseLog$ThreadInfo$Companion */
        /* compiled from: BaseLog.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ThreadInfo create(JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                String optString = jSONObject.optString("threadName");
                long j = jSONObject.getLong("threadId");
                boolean z = jSONObject.getBoolean("isMain");
                Intrinsics.checkNotNullExpressionValue(optString, "threadName");
                return new ThreadInfo(optString, j, z);
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threadName", this.threadName);
            jSONObject.put("threadId", this.threadId);
            jSONObject.put("isMain", this.isMain);
            return jSONObject;
        }
    }
}
