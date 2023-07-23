package media.tiger.tigerbox;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/SettingsNavGraphDirections;", "", "()V", "ActionToTigerTicketPinInput", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SettingsNavGraphDirections.kt */
public final class SettingsNavGraphDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/SettingsNavGraphDirections$ActionToTigerTicketPinInput;", "Landroidx/navigation/NavDirections;", "tigerTicketStepDomain", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "(Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getTigerTicketStepDomain", "()Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: SettingsNavGraphDirections.kt */
    private static final class ActionToTigerTicketPinInput implements NavDirections {
        private final int actionId = C2814R.C2817id.action_to_tigerTicketPinInput;
        private final TigerTicketStepDomain tigerTicketStepDomain;

        public static /* synthetic */ ActionToTigerTicketPinInput copy$default(ActionToTigerTicketPinInput actionToTigerTicketPinInput, TigerTicketStepDomain tigerTicketStepDomain2, int i, Object obj) {
            if ((i & 1) != 0) {
                tigerTicketStepDomain2 = actionToTigerTicketPinInput.tigerTicketStepDomain;
            }
            return actionToTigerTicketPinInput.copy(tigerTicketStepDomain2);
        }

        public final TigerTicketStepDomain component1() {
            return this.tigerTicketStepDomain;
        }

        public final ActionToTigerTicketPinInput copy(TigerTicketStepDomain tigerTicketStepDomain2) {
            Intrinsics.checkNotNullParameter(tigerTicketStepDomain2, "tigerTicketStepDomain");
            return new ActionToTigerTicketPinInput(tigerTicketStepDomain2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActionToTigerTicketPinInput) && Intrinsics.areEqual((Object) this.tigerTicketStepDomain, (Object) ((ActionToTigerTicketPinInput) obj).tigerTicketStepDomain);
        }

        public int hashCode() {
            return this.tigerTicketStepDomain.hashCode();
        }

        public String toString() {
            return "ActionToTigerTicketPinInput(tigerTicketStepDomain=" + this.tigerTicketStepDomain + ')';
        }

        public ActionToTigerTicketPinInput(TigerTicketStepDomain tigerTicketStepDomain2) {
            Intrinsics.checkNotNullParameter(tigerTicketStepDomain2, "tigerTicketStepDomain");
            this.tigerTicketStepDomain = tigerTicketStepDomain2;
        }

        public final TigerTicketStepDomain getTigerTicketStepDomain() {
            return this.tigerTicketStepDomain;
        }

        public int getActionId() {
            return this.actionId;
        }

        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (Parcelable.class.isAssignableFrom(TigerTicketStepDomain.class)) {
                bundle.putParcelable("tigerTicketStepDomain", (Parcelable) this.tigerTicketStepDomain);
            } else if (Serializable.class.isAssignableFrom(TigerTicketStepDomain.class)) {
                bundle.putSerializable("tigerTicketStepDomain", this.tigerTicketStepDomain);
            } else {
                throw new UnsupportedOperationException(TigerTicketStepDomain.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            return bundle;
        }
    }

    private SettingsNavGraphDirections() {
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/SettingsNavGraphDirections$Companion;", "", "()V", "actionToTigerTicketPinInput", "Landroidx/navigation/NavDirections;", "tigerTicketStepDomain", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: SettingsNavGraphDirections.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavDirections actionToTigerTicketPinInput(TigerTicketStepDomain tigerTicketStepDomain) {
            Intrinsics.checkNotNullParameter(tigerTicketStepDomain, "tigerTicketStepDomain");
            return new ActionToTigerTicketPinInput(tigerTicketStepDomain);
        }
    }
}
