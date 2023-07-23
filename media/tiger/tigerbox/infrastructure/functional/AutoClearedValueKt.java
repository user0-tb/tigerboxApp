package media.tiger.tigerbox.infrastructure.functional;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004¨\u0006\u0005"}, mo33737d2 = {"autoCleared", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "T", "", "Landroidx/fragment/app/Fragment;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AutoClearedValue.kt */
public final class AutoClearedValueKt {
    public static final <T> AutoClearedValue<T> autoCleared(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return new AutoClearedValue<>(fragment);
    }
}
