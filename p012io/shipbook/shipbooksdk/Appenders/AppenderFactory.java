package p012io.shipbook.shipbooksdk.Appenders;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tj\u0004\u0018\u0001`\n¨\u0006\u000b"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Appenders/AppenderFactory;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Appenders/BaseAppender;", "type", "", "name", "config", "", "Lio/shipbook/shipbooksdk/Appenders/Config;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Appenders.AppenderFactory */
/* compiled from: AppenderFactory.kt */
public final class AppenderFactory {
    public static final AppenderFactory INSTANCE = new AppenderFactory();

    private AppenderFactory() {
    }

    public final BaseAppender create(String str, String str2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, SessionDescription.ATTR_TYPE);
        Intrinsics.checkNotNullParameter(str2, "name");
        int hashCode = str.hashCode();
        if (hashCode != -878823522) {
            if (hashCode != 1148532931) {
                if (hashCode != 1909151885 || !str.equals("SBCloudAppender")) {
                    return null;
                }
            } else if (!str.equals("SLCloudAppender")) {
                return null;
            }
            return new SBCloudAppender(str2, map);
        } else if (!str.equals("ConsoleAppender")) {
            return null;
        } else {
            return new ConsoleAppender(str2, map);
        }
    }
}
