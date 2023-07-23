package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.SettingsNavGraphDirections;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberDialogFragmentDirections;", "", "()V", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberDialogFragmentDirections */
/* compiled from: TicketRedeemTicketNumberDialogFragmentDirections.kt */
public final class TicketRedeemTicketNumberDialogFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberDialogFragmentDirections$Companion;", "", "()V", "actionToTigerTicketPinInput", "Landroidx/navigation/NavDirections;", "tigerTicketStepDomain", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberDialogFragmentDirections$Companion */
    /* compiled from: TicketRedeemTicketNumberDialogFragmentDirections.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavDirections actionToTigerTicketPinInput(TigerTicketStepDomain tigerTicketStepDomain) {
            Intrinsics.checkNotNullParameter(tigerTicketStepDomain, "tigerTicketStepDomain");
            return SettingsNavGraphDirections.Companion.actionToTigerTicketPinInput(tigerTicketStepDomain);
        }
    }

    private TicketRedeemTicketNumberDialogFragmentDirections() {
    }
}
