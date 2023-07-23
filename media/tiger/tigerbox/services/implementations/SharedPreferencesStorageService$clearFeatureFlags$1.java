package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "editor", "Landroid/content/SharedPreferences$Editor;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SharedPreferencesStorageService.kt */
final class SharedPreferencesStorageService$clearFeatureFlags$1 extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
    public static final SharedPreferencesStorageService$clearFeatureFlags$1 INSTANCE = new SharedPreferencesStorageService$clearFeatureFlags$1();

    SharedPreferencesStorageService$clearFeatureFlags$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SharedPreferences.Editor) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        editor.remove("flag.submitLogs");
        editor.remove("flag.autoplay");
        editor.remove("flag.forceCrash");
        editor.remove("flag.ticketManualRedemption");
        editor.remove("flag.advanceTimers");
        editor.remove("flag.profiles");
        editor.remove("flag.pinEntry");
        editor.remove("flag.autoLogs");
    }
}
