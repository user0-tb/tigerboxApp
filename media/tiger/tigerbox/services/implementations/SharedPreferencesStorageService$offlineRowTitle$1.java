package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "Landroid/content/SharedPreferences$Editor;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SharedPreferencesStorageService.kt */
final class SharedPreferencesStorageService$offlineRowTitle$1 extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
    final /* synthetic */ String $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesStorageService$offlineRowTitle$1(String str) {
        super(1);
        this.$value = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SharedPreferences.Editor) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "it");
        editor.putString("OFFLINE_ROW_TITLE", this.$value);
    }
}
