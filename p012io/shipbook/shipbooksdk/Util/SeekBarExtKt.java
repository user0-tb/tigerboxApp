package p012io.shipbook.shipbooksdk.Util;

import android.widget.SeekBar;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.InnerLog;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, mo33737d2 = {"onSeekBarChangeListener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "getOnSeekBarChangeListener", "(Landroid/widget/SeekBar;)Landroid/widget/SeekBar$OnSeekBarChangeListener;", "shipbooksdk_release"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Util.SeekBarExtKt */
/* compiled from: SeekBarExt.kt */
public final class SeekBarExtKt {
    public static final SeekBar.OnSeekBarChangeListener getOnSeekBarChangeListener(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "<this>");
        try {
            Field declaredField = Class.forName("android.widget.SeekBar").getDeclaredField("mOnSeekBarChangeListener");
            Intrinsics.checkNotNullExpressionValue(declaredField, "forName(viewStr).getDecl…OnSeekBarChangeListener\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(seekBar);
            if (obj instanceof SeekBar.OnSeekBarChangeListener) {
                return (SeekBar.OnSeekBarChangeListener) obj;
            }
            return null;
        } catch (NoSuchFieldException unused) {
            InnerLog.e$default(InnerLog.INSTANCE, "Reflection", "No Such Field.", (Throwable) null, 4, (Object) null);
            return null;
        } catch (IllegalAccessException unused2) {
            InnerLog.e$default(InnerLog.INSTANCE, "Reflection", "Illegal Access.", (Throwable) null, 4, (Object) null);
            return null;
        } catch (ClassNotFoundException unused3) {
            InnerLog.e$default(InnerLog.INSTANCE, "Reflection", "Class Not Found.", (Throwable) null, 4, (Object) null);
            return null;
        }
    }
}
