package p012io.shipbook.shipbooksdk.Appenders;

import android.util.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.Models.Message;
import p012io.shipbook.shipbooksdk.Models.Severity;

@Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\n2\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007H\u0016¨\u0006\u000e"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Appenders/ConsoleAppender;", "Lio/shipbook/shipbooksdk/Appenders/BaseAppender;", "name", "", "config", "", "", "Lio/shipbook/shipbooksdk/Appenders/Config;", "(Ljava/lang/String;Ljava/util/Map;)V", "push", "", "log", "Lio/shipbook/shipbooksdk/Models/BaseLog;", "update", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Appenders.ConsoleAppender */
/* compiled from: ConsoleAppender.kt */
public final class ConsoleAppender extends BaseAppender {

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Appenders.ConsoleAppender$WhenMappings */
    /* compiled from: ConsoleAppender.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Severity.values().length];
            iArr[Severity.Error.ordinal()] = 1;
            iArr[Severity.Warning.ordinal()] = 2;
            iArr[Severity.Info.ordinal()] = 3;
            iArr[Severity.Debug.ordinal()] = 4;
            iArr[Severity.Verbose.ordinal()] = 5;
            iArr[Severity.Off.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void update(Map<String, ? extends Object> map) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConsoleAppender(String str, Map<String, ? extends Object> map) {
        super(str, map);
        Intrinsics.checkNotNullParameter(str, "name");
    }

    public void push(BaseLog baseLog) {
        Intrinsics.checkNotNullParameter(baseLog, "log");
        if (baseLog instanceof Message) {
            Message message = (Message) baseLog;
            if (message.getThrowable() == null) {
                int i = WhenMappings.$EnumSwitchMapping$0[message.getSeverity().ordinal()];
                if (i == 1) {
                    Log.e(message.getTag(), message.getMessage());
                } else if (i == 2) {
                    Log.w(message.getTag(), message.getMessage());
                } else if (i == 3) {
                    Log.i(message.getTag(), message.getMessage());
                } else if (i == 4) {
                    Log.d(message.getTag(), message.getMessage());
                } else if (i == 5) {
                    Log.v(message.getTag(), message.getMessage());
                }
            } else {
                int i2 = WhenMappings.$EnumSwitchMapping$0[message.getSeverity().ordinal()];
                if (i2 == 1) {
                    Log.e(message.getTag(), message.getMessage(), message.getThrowable());
                } else if (i2 == 2) {
                    Log.w(message.getTag(), message.getMessage(), message.getThrowable());
                } else if (i2 == 3) {
                    Log.i(message.getTag(), message.getMessage(), message.getThrowable());
                } else if (i2 == 4) {
                    Log.d(message.getTag(), message.getMessage(), message.getThrowable());
                } else if (i2 == 5) {
                    Log.v(message.getTag(), message.getMessage(), message.getThrowable());
                }
            }
        }
    }
}
