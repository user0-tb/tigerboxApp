package media.tiger.tigerbox.p016ui.settings.timersSetup;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupFragmentArgs;", "Landroidx/navigation/NavArgs;", "isDeletable", "", "index", "", "(ZI)V", "getIndex", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupFragmentArgs */
/* compiled from: TimersSetupWindowSetupFragmentArgs.kt */
public final class TimersSetupWindowSetupFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int index;
    private final boolean isDeletable;

    public TimersSetupWindowSetupFragmentArgs() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TimersSetupWindowSetupFragmentArgs copy$default(TimersSetupWindowSetupFragmentArgs timersSetupWindowSetupFragmentArgs, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = timersSetupWindowSetupFragmentArgs.isDeletable;
        }
        if ((i2 & 2) != 0) {
            i = timersSetupWindowSetupFragmentArgs.index;
        }
        return timersSetupWindowSetupFragmentArgs.copy(z, i);
    }

    @JvmStatic
    public static final TimersSetupWindowSetupFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final TimersSetupWindowSetupFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final boolean component1() {
        return this.isDeletable;
    }

    public final int component2() {
        return this.index;
    }

    public final TimersSetupWindowSetupFragmentArgs copy(boolean z, int i) {
        return new TimersSetupWindowSetupFragmentArgs(z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimersSetupWindowSetupFragmentArgs)) {
            return false;
        }
        TimersSetupWindowSetupFragmentArgs timersSetupWindowSetupFragmentArgs = (TimersSetupWindowSetupFragmentArgs) obj;
        return this.isDeletable == timersSetupWindowSetupFragmentArgs.isDeletable && this.index == timersSetupWindowSetupFragmentArgs.index;
    }

    public int hashCode() {
        boolean z = this.isDeletable;
        if (z) {
            z = true;
        }
        return ((z ? 1 : 0) * true) + this.index;
    }

    public String toString() {
        return "TimersSetupWindowSetupFragmentArgs(isDeletable=" + this.isDeletable + ", index=" + this.index + ')';
    }

    public TimersSetupWindowSetupFragmentArgs(boolean z, int i) {
        this.isDeletable = z;
        this.index = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimersSetupWindowSetupFragmentArgs(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 1 : i);
    }

    public final boolean isDeletable() {
        return this.isDeletable;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isDeletable", this.isDeletable);
        bundle.putInt("index", this.index);
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("isDeletable", Boolean.valueOf(this.isDeletable));
        savedStateHandle.set("index", Integer.valueOf(this.index));
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupFragmentArgs$Companion */
    /* compiled from: TimersSetupWindowSetupFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TimersSetupWindowSetupFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(TimersSetupWindowSetupFragmentArgs.class.getClassLoader());
            return new TimersSetupWindowSetupFragmentArgs(bundle.containsKey("isDeletable") ? bundle.getBoolean("isDeletable") : false, bundle.containsKey("index") ? bundle.getInt("index") : 1);
        }

        @JvmStatic
        public final TimersSetupWindowSetupFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
            Boolean bool;
            Integer num;
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("isDeletable")) {
                bool = (Boolean) savedStateHandle.get("isDeletable");
                if (bool == null) {
                    throw new IllegalArgumentException("Argument \"isDeletable\" of type boolean does not support null values");
                }
            } else {
                bool = false;
            }
            if (savedStateHandle.contains("index")) {
                num = (Integer) savedStateHandle.get("index");
                if (num == null) {
                    throw new IllegalArgumentException("Argument \"index\" of type integer does not support null values");
                }
            } else {
                num = 1;
            }
            return new TimersSetupWindowSetupFragmentArgs(bool.booleanValue(), num.intValue());
        }
    }
}
