package p012io.shipbook.shipbooksdk.Models;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import org.json.JSONArray;
import org.json.JSONObject;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.ShipBook;
import p012io.shipbook.shipbooksdk.Util.ListStackTraceElementExtKt;

@Metadata(mo33736d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 T2\u00020\u0001:\u0002TUB\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u0015HÆ\u0003J\t\u0010A\u001a\u00020\u0017HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¦\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\u000fHÖ\u0001J\b\u0010Q\u001a\u00020RH\u0016J\t\u0010S\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u001a\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001cR\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006V"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/Message;", "Lio/shipbook/shipbooksdk/Models/BaseLog;", "severity", "Lio/shipbook/shipbooksdk/Models/Severity;", "message", "", "tag", "stackTrace", "", "Lio/shipbook/shipbooksdk/Models/StackTraceElement;", "throwable", "", "function", "fileName", "lineNumber", "", "className", "exception", "Lio/shipbook/shipbooksdk/Models/Message$MessageException;", "orderId", "time", "Ljava/util/Date;", "threadInfo", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "(Lio/shipbook/shipbooksdk/Models/Severity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lio/shipbook/shipbooksdk/Models/Message$MessageException;ILjava/util/Date;Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "getException", "()Lio/shipbook/shipbooksdk/Models/Message$MessageException;", "setException", "(Lio/shipbook/shipbooksdk/Models/Message$MessageException;)V", "getFileName", "setFileName", "getFunction", "setFunction", "getLineNumber", "()Ljava/lang/Integer;", "setLineNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMessage", "getOrderId", "()I", "setOrderId", "(I)V", "getSeverity", "()Lio/shipbook/shipbooksdk/Models/Severity;", "getStackTrace", "()Ljava/util/List;", "setStackTrace", "(Ljava/util/List;)V", "getTag", "setTag", "getThreadInfo", "()Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "getThrowable", "()Ljava/lang/Throwable;", "getTime", "()Ljava/util/Date;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lio/shipbook/shipbooksdk/Models/Severity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lio/shipbook/shipbooksdk/Models/Message$MessageException;ILjava/util/Date;Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;)Lio/shipbook/shipbooksdk/Models/Message;", "equals", "", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "MessageException", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.Message */
/* compiled from: Message.kt */
public final class Message extends BaseLog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> ignoreClasses;
    /* access modifiers changed from: private */
    public static final String shipbookClassname;
    private String className;
    private MessageException exception;
    private String fileName;
    private String function;
    private Integer lineNumber;
    private final String message;
    private int orderId;
    private final Severity severity;
    private List<StackTraceElement> stackTrace;
    private String tag;
    private final BaseLog.ThreadInfo threadInfo;
    private final Throwable throwable;
    private final Date time;

    public static /* synthetic */ Message copy$default(Message message2, Severity severity2, String str, String str2, List list, Throwable th, String str3, String str4, Integer num, String str5, MessageException messageException, int i, Date date, BaseLog.ThreadInfo threadInfo2, int i2, Object obj) {
        Message message3 = message2;
        int i3 = i2;
        return message2.copy((i3 & 1) != 0 ? message3.severity : severity2, (i3 & 2) != 0 ? message3.message : str, (i3 & 4) != 0 ? message3.tag : str2, (i3 & 8) != 0 ? message3.stackTrace : list, (i3 & 16) != 0 ? message3.throwable : th, (i3 & 32) != 0 ? message3.function : str3, (i3 & 64) != 0 ? message3.fileName : str4, (i3 & 128) != 0 ? message3.lineNumber : num, (i3 & 256) != 0 ? message3.className : str5, (i3 & 512) != 0 ? message3.exception : messageException, (i3 & 1024) != 0 ? message2.getOrderId() : i, (i3 & 2048) != 0 ? message2.getTime() : date, (i3 & 4096) != 0 ? message2.getThreadInfo() : threadInfo2);
    }

    public final Severity component1() {
        return this.severity;
    }

    public final MessageException component10() {
        return this.exception;
    }

    public final int component11() {
        return getOrderId();
    }

    public final Date component12() {
        return getTime();
    }

    public final BaseLog.ThreadInfo component13() {
        return getThreadInfo();
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.tag;
    }

    public final List<StackTraceElement> component4() {
        return this.stackTrace;
    }

    public final Throwable component5() {
        return this.throwable;
    }

    public final String component6() {
        return this.function;
    }

    public final String component7() {
        return this.fileName;
    }

    public final Integer component8() {
        return this.lineNumber;
    }

    public final String component9() {
        return this.className;
    }

    public final Message copy(Severity severity2, String str, String str2, List<StackTraceElement> list, Throwable th, String str3, String str4, Integer num, String str5, MessageException messageException, int i, Date date, BaseLog.ThreadInfo threadInfo2) {
        Severity severity3 = severity2;
        Intrinsics.checkNotNullParameter(severity3, "severity");
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "message");
        Date date2 = date;
        Intrinsics.checkNotNullParameter(date2, "time");
        BaseLog.ThreadInfo threadInfo3 = threadInfo2;
        Intrinsics.checkNotNullParameter(threadInfo3, "threadInfo");
        return new Message(severity3, str6, str2, list, th, str3, str4, num, str5, messageException, i, date2, threadInfo3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message2 = (Message) obj;
        return this.severity == message2.severity && Intrinsics.areEqual((Object) this.message, (Object) message2.message) && Intrinsics.areEqual((Object) this.tag, (Object) message2.tag) && Intrinsics.areEqual((Object) this.stackTrace, (Object) message2.stackTrace) && Intrinsics.areEqual((Object) this.throwable, (Object) message2.throwable) && Intrinsics.areEqual((Object) this.function, (Object) message2.function) && Intrinsics.areEqual((Object) this.fileName, (Object) message2.fileName) && Intrinsics.areEqual((Object) this.lineNumber, (Object) message2.lineNumber) && Intrinsics.areEqual((Object) this.className, (Object) message2.className) && Intrinsics.areEqual((Object) this.exception, (Object) message2.exception) && getOrderId() == message2.getOrderId() && Intrinsics.areEqual((Object) getTime(), (Object) message2.getTime()) && Intrinsics.areEqual((Object) getThreadInfo(), (Object) message2.getThreadInfo());
    }

    public int hashCode() {
        int hashCode = ((this.severity.hashCode() * 31) + this.message.hashCode()) * 31;
        String str = this.tag;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<StackTraceElement> list = this.stackTrace;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Throwable th = this.throwable;
        int hashCode4 = (hashCode3 + (th == null ? 0 : th.hashCode())) * 31;
        String str2 = this.function;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fileName;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.lineNumber;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.className;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        MessageException messageException = this.exception;
        if (messageException != null) {
            i = messageException.hashCode();
        }
        return ((((((hashCode8 + i) * 31) + getOrderId()) * 31) + getTime().hashCode()) * 31) + getThreadInfo().hashCode();
    }

    public String toString() {
        return "Message(severity=" + this.severity + ", message=" + this.message + ", tag=" + this.tag + ", stackTrace=" + this.stackTrace + ", throwable=" + this.throwable + ", function=" + this.function + ", fileName=" + this.fileName + ", lineNumber=" + this.lineNumber + ", className=" + this.className + ", exception=" + this.exception + ", orderId=" + getOrderId() + ", time=" + getTime() + ", threadInfo=" + getThreadInfo() + ')';
    }

    public final Severity getSeverity() {
        return this.severity;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final List<StackTraceElement> getStackTrace() {
        return this.stackTrace;
    }

    public final void setStackTrace(List<StackTraceElement> list) {
        this.stackTrace = list;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final String getFunction() {
        return this.function;
    }

    public final void setFunction(String str) {
        this.function = str;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(String str) {
        this.fileName = str;
    }

    public final Integer getLineNumber() {
        return this.lineNumber;
    }

    public final void setLineNumber(Integer num) {
        this.lineNumber = num;
    }

    public final String getClassName() {
        return this.className;
    }

    public final void setClassName(String str) {
        this.className = str;
    }

    public final MessageException getException() {
        return this.exception;
    }

    public final void setException(MessageException messageException) {
        this.exception = messageException;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int i) {
        this.orderId = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Message(p012io.shipbook.shipbooksdk.Models.Severity r18, java.lang.String r19, java.lang.String r20, java.util.List r21, java.lang.Throwable r22, java.lang.String r23, java.lang.String r24, java.lang.Integer r25, java.lang.String r26, p012io.shipbook.shipbooksdk.Models.Message.MessageException r27, int r28, java.util.Date r29, p012io.shipbook.shipbooksdk.Models.BaseLog.ThreadInfo r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r20
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r21
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r8 = r2
            goto L_0x001b
        L_0x0019:
            r8 = r22
        L_0x001b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0021
            r9 = r2
            goto L_0x0023
        L_0x0021:
            r9 = r23
        L_0x0023:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0029
            r10 = r2
            goto L_0x002b
        L_0x0029:
            r10 = r24
        L_0x002b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0031
            r11 = r2
            goto L_0x0033
        L_0x0031:
            r11 = r25
        L_0x0033:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0039
            r12 = r2
            goto L_0x003b
        L_0x0039:
            r12 = r26
        L_0x003b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0041
            r13 = r2
            goto L_0x0043
        L_0x0041:
            r13 = r27
        L_0x0043:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004a
            r1 = 0
            r14 = 0
            goto L_0x004c
        L_0x004a:
            r14 = r28
        L_0x004c:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0057
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            r15 = r1
            goto L_0x0059
        L_0x0057:
            r15 = r29
        L_0x0059:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0078
            io.shipbook.shipbooksdk.Models.BaseLog$ThreadInfo r0 = new io.shipbook.shipbooksdk.Models.BaseLog$ThreadInfo
            r1 = 0
            r2 = 0
            r4 = 0
            r5 = 7
            r16 = 0
            r20 = r0
            r21 = r1
            r22 = r2
            r24 = r4
            r25 = r5
            r26 = r16
            r20.<init>(r21, r22, r24, r25, r26)
            r16 = r0
            goto L_0x007a
        L_0x0078:
            r16 = r30
        L_0x007a:
            r3 = r17
            r4 = r18
            r5 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p012io.shipbook.shipbooksdk.Models.Message.<init>(io.shipbook.shipbooksdk.Models.Severity, java.lang.String, java.lang.String, java.util.List, java.lang.Throwable, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, io.shipbook.shipbooksdk.Models.Message$MessageException, int, java.util.Date, io.shipbook.shipbooksdk.Models.BaseLog$ThreadInfo, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public Date getTime() {
        return this.time;
    }

    @Metadata(mo33736d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/Message$Companion;", "", "()V", "ignoreClasses", "", "", "getIgnoreClasses", "()Ljava/util/List;", "shipbookClassname", "getShipbookClassname", "()Ljava/lang/String;", "addIgnoreClass", "", "name", "create", "Lio/shipbook/shipbooksdk/Models/Message;", "json", "Lorg/json/JSONObject;", "orderId", "", "time", "Ljava/util/Date;", "threadInfo", "Lio/shipbook/shipbooksdk/Models/BaseLog$ThreadInfo;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.Message$Companion */
    /* compiled from: Message.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Message create(JSONObject jSONObject, int i, Date date, BaseLog.ThreadInfo threadInfo) {
            MessageException messageException;
            JSONObject jSONObject2 = jSONObject;
            Intrinsics.checkNotNullParameter(jSONObject2, "json");
            Intrinsics.checkNotNullParameter(date, "time");
            Intrinsics.checkNotNullParameter(threadInfo, "threadInfo");
            String optString = jSONObject2.optString("tag");
            String optString2 = jSONObject2.optString("severity");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"severity\")");
            Severity valueOf = Severity.valueOf(optString2);
            String optString3 = jSONObject2.optString("message");
            JSONArray optJSONArray = jSONObject2.optJSONArray("stackTrace");
            List<StackTraceElement> listStackTraceElement = optJSONArray == null ? null : ListStackTraceElementExtKt.toListStackTraceElement(optJSONArray);
            if (jSONObject2.has("exception")) {
                MessageException.Companion companion = MessageException.Companion;
                JSONObject optJSONObject = jSONObject2.optJSONObject("exception");
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "json.optJSONObject(\"exception\")");
                messageException = companion.create(optJSONObject);
            } else {
                messageException = null;
            }
            String optString4 = jSONObject2.optString("function");
            String optString5 = jSONObject2.optString("fileName");
            int optInt = jSONObject2.optInt("lineNumber");
            String optString6 = jSONObject2.optString("className");
            Intrinsics.checkNotNullExpressionValue(optString3, "message");
            return new Message(valueOf, optString3, optString, listStackTraceElement, (Throwable) null, optString4, optString5, Integer.valueOf(optInt), optString6, messageException, i, date, threadInfo);
        }

        public final void addIgnoreClass(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            getIgnoreClasses().add(str);
        }

        public final String getShipbookClassname() {
            return Message.shipbookClassname;
        }

        public final List<String> getIgnoreClasses() {
            return Message.ignoreClasses;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Message(Severity severity2, String str, String str2, List<StackTraceElement> list, Throwable th, String str3, String str4, Integer num, String str5, MessageException messageException, int i, Date date, BaseLog.ThreadInfo threadInfo2) {
        super("message", 0, (Date) null, (BaseLog.ThreadInfo) null, 14, (DefaultConstructorMarker) null);
        StackTraceElement stackTraceElement;
        String str6;
        String str7;
        Integer num2;
        String str8;
        Object obj;
        boolean z;
        String str9 = str;
        Date date2 = date;
        BaseLog.ThreadInfo threadInfo3 = threadInfo2;
        Intrinsics.checkNotNullParameter(severity2, "severity");
        Intrinsics.checkNotNullParameter(str9, "message");
        Intrinsics.checkNotNullParameter(date2, "time");
        Intrinsics.checkNotNullParameter(threadInfo3, "threadInfo");
        this.severity = severity2;
        this.message = str9;
        this.tag = str2;
        this.stackTrace = list;
        this.throwable = th;
        this.function = str3;
        this.fileName = str4;
        this.lineNumber = num;
        this.className = str5;
        this.exception = messageException;
        this.orderId = i;
        this.time = date2;
        this.threadInfo = threadInfo3;
        setOrderId(incrementOrderId(getOrderId()));
        String str10 = null;
        if (this.fileName == null) {
            StackTraceElement[] stackTrace2 = new Throwable().getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace2, "Throwable().stackTrace");
            Object[] objArr = (Object[]) stackTrace2;
            int length = objArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    stackTraceElement = null;
                    break;
                }
                stackTraceElement = objArr[i2];
                i2++;
                StackTraceElement stackTraceElement2 = (StackTraceElement) stackTraceElement;
                Iterator it = ignoreClasses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    String className2 = stackTraceElement2.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className2, "trace.className");
                    if (StringsKt.startsWith$default(className2, (String) obj, false, 2, (Object) null)) {
                        break;
                    }
                }
                if (obj == null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            StackTraceElement stackTraceElement3 = stackTraceElement;
            if (stackTraceElement3 == null) {
                str6 = null;
            } else {
                str6 = stackTraceElement3.getMethodName();
            }
            this.function = str6;
            if (stackTraceElement3 == null) {
                str7 = null;
            } else {
                str7 = stackTraceElement3.getFileName();
            }
            this.fileName = str7;
            if (stackTraceElement3 == null) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(stackTraceElement3.getLineNumber());
            }
            this.lineNumber = num2;
            if (stackTraceElement3 == null) {
                str8 = null;
            } else {
                str8 = stackTraceElement3.getClassName();
            }
            this.className = str8;
        }
        if (this.tag == null) {
            String str11 = this.className;
            this.tag = str11 != null ? StringsKt.substringAfterLast$default(str11, '.', (String) null, 2, (Object) null) : str10;
        }
        Throwable th2 = this.throwable;
        if (th2 != null) {
            StackTraceElement[] stackTrace3 = th2.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace3, "throwable.stackTrace");
            this.exception = new MessageException(this.throwable.getClass().getName(), this.throwable.getMessage(), ListStackTraceElementExtKt.toInternal(stackTrace3));
        }
    }

    public BaseLog.ThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    static {
        String name = ShipBook.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "ShipBook::class.java.name");
        String substringBeforeLast$default = StringsKt.substringBeforeLast$default(name, DownloadsManager.EXTENSION_SEPARATOR, (String) null, 2, (Object) null);
        shipbookClassname = substringBeforeLast$default;
        ignoreClasses = CollectionsKt.mutableListOf(substringBeforeLast$default);
    }

    public JSONObject toJson() {
        JSONObject json = super.toJson();
        json.put("tag", this.tag);
        json.put("severity", this.severity);
        json.put("message", this.message);
        MessageException messageException = this.exception;
        JSONArray jSONArray = null;
        json.putOpt("exception", messageException == null ? null : messageException.toJson());
        List<StackTraceElement> list = this.stackTrace;
        if (list != null) {
            jSONArray = ListStackTraceElementExtKt.toJson(list);
        }
        json.putOpt("stackTrace", jSONArray);
        json.put("function", this.function);
        json.put("fileName", this.fileName);
        json.put("lineNumber", this.lineNumber);
        json.put("className", this.className);
        return json;
    }

    @Metadata(mo33736d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/Message$MessageException;", "Lio/shipbook/shipbooksdk/Models/BaseObj;", "name", "", "reason", "stackTrace", "", "Lio/shipbook/shipbooksdk/Models/StackTraceElement;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getReason", "getStackTrace", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.Message$MessageException */
    /* compiled from: Message.kt */
    public static final class MessageException implements BaseObj {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String name;
        private final String reason;
        private final List<StackTraceElement> stackTrace;

        public static /* synthetic */ MessageException copy$default(MessageException messageException, String str, String str2, List<StackTraceElement> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = messageException.name;
            }
            if ((i & 2) != 0) {
                str2 = messageException.reason;
            }
            if ((i & 4) != 0) {
                list = messageException.stackTrace;
            }
            return messageException.copy(str, str2, list);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.reason;
        }

        public final List<StackTraceElement> component3() {
            return this.stackTrace;
        }

        public final MessageException copy(String str, String str2, List<StackTraceElement> list) {
            Intrinsics.checkNotNullParameter(list, "stackTrace");
            return new MessageException(str, str2, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageException)) {
                return false;
            }
            MessageException messageException = (MessageException) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) messageException.name) && Intrinsics.areEqual((Object) this.reason, (Object) messageException.reason) && Intrinsics.areEqual((Object) this.stackTrace, (Object) messageException.stackTrace);
        }

        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.reason;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return ((hashCode + i) * 31) + this.stackTrace.hashCode();
        }

        public String toString() {
            return "MessageException(name=" + this.name + ", reason=" + this.reason + ", stackTrace=" + this.stackTrace + ')';
        }

        public MessageException(String str, String str2, List<StackTraceElement> list) {
            Intrinsics.checkNotNullParameter(list, "stackTrace");
            this.name = str;
            this.reason = str2;
            this.stackTrace = list;
        }

        public final String getName() {
            return this.name;
        }

        public final String getReason() {
            return this.reason;
        }

        @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/Message$MessageException$Companion;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Models/Message$MessageException;", "json", "Lorg/json/JSONObject;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: io.shipbook.shipbooksdk.Models.Message$MessageException$Companion */
        /* compiled from: Message.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final MessageException create(JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                String optString = jSONObject.optString("name");
                String optString2 = jSONObject.optString("reason");
                JSONArray jSONArray = jSONObject.getJSONArray("stackTrace");
                Intrinsics.checkNotNullExpressionValue(jSONArray, "json.getJSONArray(\"stackTrace\")");
                return new MessageException(optString, optString2, ListStackTraceElementExtKt.toListStackTraceElement(jSONArray));
            }
        }

        public final List<StackTraceElement> getStackTrace() {
            return this.stackTrace;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", this.name);
            jSONObject.putOpt("reason", this.reason);
            jSONObject.put("stackTrace", ListStackTraceElementExtKt.toJson(this.stackTrace));
            return jSONObject;
        }
    }
}
