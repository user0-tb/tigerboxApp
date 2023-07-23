package media.tiger.tigerbox.p016ui.settings.timersSetup;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupFragmentArgs;", "Landroidx/navigation/NavArgs;", "isSleepTimer", "", "sleepSeconds", "", "(ZI)V", "()Z", "getSleepSeconds", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupFragmentArgs */
/* compiled from: TimersSetupLimitSetupFragmentArgs.kt */
public final class TimersSetupLimitSetupFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean isSleepTimer;
    private final int sleepSeconds;

    public TimersSetupLimitSetupFragmentArgs() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TimersSetupLimitSetupFragmentArgs copy$default(TimersSetupLimitSetupFragmentArgs timersSetupLimitSetupFragmentArgs, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = timersSetupLimitSetupFragmentArgs.isSleepTimer;
        }
        if ((i2 & 2) != 0) {
            i = timersSetupLimitSetupFragmentArgs.sleepSeconds;
        }
        return timersSetupLimitSetupFragmentArgs.copy(z, i);
    }

    @JvmStatic
    public static final TimersSetupLimitSetupFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final TimersSetupLimitSetupFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final boolean component1() {
        return this.isSleepTimer;
    }

    public final int component2() {
        return this.sleepSeconds;
    }

    public final TimersSetupLimitSetupFragmentArgs copy(boolean z, int i) {
        return new TimersSetupLimitSetupFragmentArgs(z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimersSetupLimitSetupFragmentArgs)) {
            return false;
        }
        TimersSetupLimitSetupFragmentArgs timersSetupLimitSetupFragmentArgs = (TimersSetupLimitSetupFragmentArgs) obj;
        return this.isSleepTimer == timersSetupLimitSetupFragmentArgs.isSleepTimer && this.sleepSeconds == timersSetupLimitSetupFragmentArgs.sleepSeconds;
    }

    public int hashCode() {
        boolean z = this.isSleepTimer;
        if (z) {
            z = true;
        }
        return ((z ? 1 : 0) * true) + this.sleepSeconds;
    }

    public String toString() {
        return "TimersSetupLimitSetupFragmentArgs(isSleepTimer=" + this.isSleepTimer + ", sleepSeconds=" + this.sleepSeconds + ')';
    }

    public TimersSetupLimitSetupFragmentArgs(boolean z, int i) {
        this.isSleepTimer = z;
        this.sleepSeconds = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimersSetupLimitSetupFragmentArgs(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
    }

    public final boolean isSleepTimer() {
        return this.isSleepTimer;
    }

    public final int getSleepSeconds() {
        return this.sleepSeconds;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSleepTimer", this.isSleepTimer);
        bundle.putInt("sleepSeconds", this.sleepSeconds);
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("isSleepTimer", Boolean.valueOf(this.isSleepTimer));
        savedStateHandle.set("sleepSeconds", Integer.valueOf(this.sleepSeconds));
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupFragmentArgs$Companion */
    /* compiled from: TimersSetupLimitSetupFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TimersSetupLimitSetupFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(TimersSetupLimitSetupFragmentArgs.class.getClassLoader());
            int i = 0;
            boolean z = bundle.containsKey("isSleepTimer") ? bundle.getBoolean("isSleepTimer") : false;
            if (bundle.containsKey("sleepSeconds")) {
                i = bundle.getInt("sleepSeconds");
            }
            return new TimersSetupLimitSetupFragmentArgs(z, i);
        }

        @JvmStatic
        public final TimersSetupLimitSetupFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
            Boolean bool;
            Integer num;
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("isSleepTimer")) {
                bool = (Boolean) savedStateHandle.get("isSleepTimer");
                if (bool == null) {
                    throw new IllegalArgumentException("Argument \"isSleepTimer\" of type boolean does not support null values");
                }
            } else {
                bool = false;
            }
            if (savedStateHandle.contains("sleepSeconds")) {
                num = (Integer) savedStateHandle.get("sleepSeconds");
                if (num == null) {
                    throw new IllegalArgumentException("Argument \"sleepSeconds\" of type integer does not support null values");
                }
            } else {
                num = 0;
            }
            return new TimersSetupLimitSetupFragmentArgs(bool.booleanValue(), num.intValue());
        }
    }
}
