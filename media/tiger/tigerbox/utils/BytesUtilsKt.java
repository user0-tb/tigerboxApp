package media.tiger.tigerbox.utils;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo33737d2 = {"bytesToString", "", "", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: BytesUtils.kt */
public final class BytesUtilsKt {
    public static final String bytesToString(long j) {
        long abs = j == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(j);
        if (abs < 1024) {
            return j + " B";
        }
        CharacterIterator stringCharacterIterator = new StringCharacterIterator("KMGTPE");
        int i = 40;
        long j2 = abs;
        while (i >= 0 && abs > (1152865209611504844 >> i)) {
            j2 >>= 10;
            stringCharacterIterator.next();
            i -= 10;
        }
        long signum = j2 * ((long) Long.signum(j));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f %cB", Arrays.copyOf(new Object[]{Double.valueOf(((double) signum) / 1024.0d), Character.valueOf(stringCharacterIterator.current())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
