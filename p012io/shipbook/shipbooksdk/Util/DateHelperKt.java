package p012io.shipbook.shipbooksdk.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.Constants;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"TAG", "", "sDateFormat", "Ljava/text/SimpleDateFormat;", "toStandardString", "Ljava/util/Date;", "shipbooksdk_release"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Util.DateHelperKt */
/* compiled from: DateHelper.kt */
public final class DateHelperKt {
    /* access modifiers changed from: private */
    public static final String TAG = "DateHelper";
    /* access modifiers changed from: private */
    public static final SimpleDateFormat sDateFormat = new SimpleDateFormat(Constants.TIME_DATE_FORMAT, Locale.US);

    static {
        Class<DateHelper> cls = DateHelper.class;
        Intrinsics.checkNotNullExpressionValue("DateHelper", "DateHelper::class.java.simpleName");
    }

    public static final String toStandardString(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        String format = sDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "sDateFormat.format(this)");
        return format;
    }
}
