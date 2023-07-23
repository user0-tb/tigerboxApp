package p012io.shipbook.shipbooksdk.Util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.InnerLog;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Util/DateHelper;", "", "()V", "createDateStandard", "Ljava/util/Date;", "string", "", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Util.DateHelper */
/* compiled from: DateHelper.kt */
public final class DateHelper {
    public static final DateHelper INSTANCE = new DateHelper();

    private DateHelper() {
    }

    public final Date createDateStandard(String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        try {
            return DateHelperKt.sDateFormat.parse(str);
        } catch (Exception e) {
            InnerLog.INSTANCE.mo33259e(DateHelperKt.TAG, "error in the parse", e);
            return null;
        }
    }
}
