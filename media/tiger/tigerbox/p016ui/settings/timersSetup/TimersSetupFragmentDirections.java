package media.tiger.tigerbox.p016ui.settings.timersSetup;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.SettingsNavGraphDirections;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupFragmentDirections;", "", "()V", "ActionTimersSetupToLimitEditFragment", "ActionTimersSetupToWindowEditFragment", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupFragmentDirections */
/* compiled from: TimersSetupFragmentDirections.kt */
public final class TimersSetupFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupFragmentDirections$ActionTimersSetupToLimitEditFragment;", "Landroidx/navigation/NavDirections;", "isSleepTimer", "", "sleepSeconds", "", "(ZI)V", "actionId", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "()Z", "getSleepSeconds", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupFragmentDirections$ActionTimersSetupToLimitEditFragment */
    /* compiled from: TimersSetupFragmentDirections.kt */
    private static final class ActionTimersSetupToLimitEditFragment implements NavDirections {
        private final int actionId;
        private final boolean isSleepTimer;
        private final int sleepSeconds;

        public ActionTimersSetupToLimitEditFragment() {
            this(false, 0, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ActionTimersSetupToLimitEditFragment copy$default(ActionTimersSetupToLimitEditFragment actionTimersSetupToLimitEditFragment, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = actionTimersSetupToLimitEditFragment.isSleepTimer;
            }
            if ((i2 & 2) != 0) {
                i = actionTimersSetupToLimitEditFragment.sleepSeconds;
            }
            return actionTimersSetupToLimitEditFragment.copy(z, i);
        }

        public final boolean component1() {
            return this.isSleepTimer;
        }

        public final int component2() {
            return this.sleepSeconds;
        }

        public final ActionTimersSetupToLimitEditFragment copy(boolean z, int i) {
            return new ActionTimersSetupToLimitEditFragment(z, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionTimersSetupToLimitEditFragment)) {
                return false;
            }
            ActionTimersSetupToLimitEditFragment actionTimersSetupToLimitEditFragment = (ActionTimersSetupToLimitEditFragment) obj;
            return this.isSleepTimer == actionTimersSetupToLimitEditFragment.isSleepTimer && this.sleepSeconds == actionTimersSetupToLimitEditFragment.sleepSeconds;
        }

        public int hashCode() {
            boolean z = this.isSleepTimer;
            if (z) {
                z = true;
            }
            return ((z ? 1 : 0) * true) + this.sleepSeconds;
        }

        public String toString() {
            return "ActionTimersSetupToLimitEditFragment(isSleepTimer=" + this.isSleepTimer + ", sleepSeconds=" + this.sleepSeconds + ')';
        }

        public ActionTimersSetupToLimitEditFragment(boolean z, int i) {
            this.isSleepTimer = z;
            this.sleepSeconds = i;
            this.actionId = C2814R.C2817id.action_timersSetup_to_limitEditFragment;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionTimersSetupToLimitEditFragment(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
        }

        public final boolean isSleepTimer() {
            return this.isSleepTimer;
        }

        public final int getSleepSeconds() {
            return this.sleepSeconds;
        }

        public int getActionId() {
            return this.actionId;
        }

        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSleepTimer", this.isSleepTimer);
            bundle.putInt("sleepSeconds", this.sleepSeconds);
            return bundle;
        }
    }

    private TimersSetupFragmentDirections() {
    }

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000f¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupFragmentDirections$ActionTimersSetupToWindowEditFragment;", "Landroidx/navigation/NavDirections;", "isDeletable", "", "index", "", "(ZI)V", "actionId", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getIndex", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupFragmentDirections$ActionTimersSetupToWindowEditFragment */
    /* compiled from: TimersSetupFragmentDirections.kt */
    private static final class ActionTimersSetupToWindowEditFragment implements NavDirections {
        private final int actionId;
        private final int index;
        private final boolean isDeletable;

        public ActionTimersSetupToWindowEditFragment() {
            this(false, 0, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ActionTimersSetupToWindowEditFragment copy$default(ActionTimersSetupToWindowEditFragment actionTimersSetupToWindowEditFragment, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = actionTimersSetupToWindowEditFragment.isDeletable;
            }
            if ((i2 & 2) != 0) {
                i = actionTimersSetupToWindowEditFragment.index;
            }
            return actionTimersSetupToWindowEditFragment.copy(z, i);
        }

        public final boolean component1() {
            return this.isDeletable;
        }

        public final int component2() {
            return this.index;
        }

        public final ActionTimersSetupToWindowEditFragment copy(boolean z, int i) {
            return new ActionTimersSetupToWindowEditFragment(z, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionTimersSetupToWindowEditFragment)) {
                return false;
            }
            ActionTimersSetupToWindowEditFragment actionTimersSetupToWindowEditFragment = (ActionTimersSetupToWindowEditFragment) obj;
            return this.isDeletable == actionTimersSetupToWindowEditFragment.isDeletable && this.index == actionTimersSetupToWindowEditFragment.index;
        }

        public int hashCode() {
            boolean z = this.isDeletable;
            if (z) {
                z = true;
            }
            return ((z ? 1 : 0) * true) + this.index;
        }

        public String toString() {
            return "ActionTimersSetupToWindowEditFragment(isDeletable=" + this.isDeletable + ", index=" + this.index + ')';
        }

        public ActionTimersSetupToWindowEditFragment(boolean z, int i) {
            this.isDeletable = z;
            this.index = i;
            this.actionId = C2814R.C2817id.action_timersSetup_to_windowEditFragment;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionTimersSetupToWindowEditFragment(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 1 : i);
        }

        public final boolean isDeletable() {
            return this.isDeletable;
        }

        public final int getIndex() {
            return this.index;
        }

        public int getActionId() {
            return this.actionId;
        }

        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDeletable", this.isDeletable);
            bundle.putInt("index", this.index);
            return bundle;
        }
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupFragmentDirections$Companion;", "", "()V", "actionTimersSetupToLimitEditFragment", "Landroidx/navigation/NavDirections;", "isSleepTimer", "", "sleepSeconds", "", "actionTimersSetupToWindowEditFragment", "isDeletable", "index", "actionToTigerTicketPinInput", "tigerTicketStepDomain", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupFragmentDirections$Companion */
    /* compiled from: TimersSetupFragmentDirections.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ NavDirections actionTimersSetupToLimitEditFragment$default(Companion companion, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.actionTimersSetupToLimitEditFragment(z, i);
        }

        public final NavDirections actionTimersSetupToLimitEditFragment(boolean z, int i) {
            return new ActionTimersSetupToLimitEditFragment(z, i);
        }

        public static /* synthetic */ NavDirections actionTimersSetupToWindowEditFragment$default(Companion companion, boolean z, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                i = 1;
            }
            return companion.actionTimersSetupToWindowEditFragment(z, i);
        }

        public final NavDirections actionTimersSetupToWindowEditFragment(boolean z, int i) {
            return new ActionTimersSetupToWindowEditFragment(z, i);
        }

        public final NavDirections actionToTigerTicketPinInput(TigerTicketStepDomain tigerTicketStepDomain) {
            Intrinsics.checkNotNullParameter(tigerTicketStepDomain, "tigerTicketStepDomain");
            return SettingsNavGraphDirections.Companion.actionToTigerTicketPinInput(tigerTicketStepDomain);
        }
    }
}
