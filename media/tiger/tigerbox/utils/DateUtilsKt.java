package media.tiger.tigerbox.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.infrastructure.Constants;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0007\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0006\u001a\n\u0010\b\u001a\u00020\u0002*\u00020\u0006¨\u0006\t"}, mo33737d2 = {"extractDateFromFirmware", "Ljava/util/Date;", "", "toDate", "formatString", "toHumanHHMMorSSString", "", "toHumanTimerString", "toTimeString", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DateUtils.kt */
public final class DateUtilsKt {
    public static /* synthetic */ Date toDate$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = Constants.TIME_DATE_FORMAT;
        }
        return toDate(str, str2);
    }

    public static final Date toDate(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "formatString");
        Date parse = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        Intrinsics.checkNotNull(parse);
        return parse;
    }

    public static final String toTimeString(long j) {
        long j2 = j / ((long) 1000);
        long j3 = (long) 60;
        long j4 = j2 % j3;
        long j5 = j2 / j3;
        long j6 = j5 % j3;
        long j7 = (j5 / j3) % ((long) 24);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j6), Long.valueOf(j4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        if (j7 <= 0) {
            return format;
        }
        StringBuilder sb = new StringBuilder();
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(Locale.getDefault(), "%02d:", Arrays.copyOf(new Object[]{Long.valueOf(j7)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        sb.append(format2);
        sb.append(format);
        return sb.toString();
    }

    public static final String toHumanTimerString(long j) {
        String str;
        String str2;
        if (j <= 0) {
            return "NA";
        }
        long j2 = j / ((long) 1000);
        long j3 = (long) 60;
        long j4 = j2 % j3;
        long j5 = j2 / j3;
        long j6 = j5 % j3;
        long j7 = (j5 / j3) % ((long) 24);
        if (j4 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(Locale.getDefault(), " %01d", Arrays.copyOf(new Object[]{Long.valueOf(j4)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        } else {
            str = "";
        }
        if (j6 > 1) {
            StringBuilder sb = new StringBuilder();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), " %01d Minuten", Arrays.copyOf(new Object[]{Long.valueOf(j6)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            sb.append(format);
            sb.append(str);
            str2 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.getDefault(), " %01d Minute", Arrays.copyOf(new Object[]{Long.valueOf(j6)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
            sb2.append(format2);
            sb2.append(str);
            str2 = sb2.toString();
        }
        if (j7 > 1) {
            StringBuilder sb3 = new StringBuilder();
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String format3 = String.format(Locale.getDefault(), "%01d Stunden", Arrays.copyOf(new Object[]{Long.valueOf(j7)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(locale, format, *args)");
            sb3.append(format3);
            sb3.append(str2);
            return sb3.toString();
        } else if (j7 <= 0) {
            return str2;
        } else {
            StringBuilder sb4 = new StringBuilder();
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            String format4 = String.format(Locale.getDefault(), "%01d Stunde", Arrays.copyOf(new Object[]{Long.valueOf(j7)}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(locale, format, *args)");
            sb4.append(format4);
            sb4.append(str2);
            return sb4.toString();
        }
    }

    public static final String toHumanHHMMorSSString(long j) {
        if (j <= 0) {
            return "";
        }
        long j2 = j / ((long) 1000);
        long j3 = (long) 60;
        long j4 = j2 % j3;
        long j5 = j2 / j3;
        long j6 = j5 % j3;
        long j7 = (j5 / j3) % ((long) 24);
        if (j6 > 0 || j7 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j7), Long.valueOf(j6)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j4)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        return format2;
    }

    public static final Date extractDateFromFirmware(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toDate(StringsKt.takeLast(str, 15), Constants.FIRMWARE_DATE_FORMAT);
    }
}
