package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\u0006"}, mo33737d2 = {"save", "", "Landroid/content/SharedPreferences;", "saveMethod", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SharedPreferencesStorageService.kt */
public final class SharedPreferencesStorageServiceKt {
    public static final void save(SharedPreferences sharedPreferences, Function1<? super SharedPreferences.Editor, Unit> function1) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(function1, "saveMethod");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        function1.invoke(edit);
        edit.apply();
    }
}
