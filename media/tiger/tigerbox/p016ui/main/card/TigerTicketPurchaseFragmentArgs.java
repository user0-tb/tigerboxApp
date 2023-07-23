package media.tiger.tigerbox.p016ui.main.card;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseFragmentArgs;", "Landroidx/navigation/NavArgs;", "tigerTicketCode", "", "tigerTicketPin", "(Ljava/lang/String;Ljava/lang/String;)V", "getTigerTicketCode", "()Ljava/lang/String;", "getTigerTicketPin", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseFragmentArgs */
/* compiled from: TigerTicketPurchaseFragmentArgs.kt */
public final class TigerTicketPurchaseFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String tigerTicketCode;
    private final String tigerTicketPin;

    public static /* synthetic */ TigerTicketPurchaseFragmentArgs copy$default(TigerTicketPurchaseFragmentArgs tigerTicketPurchaseFragmentArgs, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tigerTicketPurchaseFragmentArgs.tigerTicketCode;
        }
        if ((i & 2) != 0) {
            str2 = tigerTicketPurchaseFragmentArgs.tigerTicketPin;
        }
        return tigerTicketPurchaseFragmentArgs.copy(str, str2);
    }

    @JvmStatic
    public static final TigerTicketPurchaseFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final TigerTicketPurchaseFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final String component1() {
        return this.tigerTicketCode;
    }

    public final String component2() {
        return this.tigerTicketPin;
    }

    public final TigerTicketPurchaseFragmentArgs copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tigerTicketCode");
        Intrinsics.checkNotNullParameter(str2, "tigerTicketPin");
        return new TigerTicketPurchaseFragmentArgs(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TigerTicketPurchaseFragmentArgs)) {
            return false;
        }
        TigerTicketPurchaseFragmentArgs tigerTicketPurchaseFragmentArgs = (TigerTicketPurchaseFragmentArgs) obj;
        return Intrinsics.areEqual((Object) this.tigerTicketCode, (Object) tigerTicketPurchaseFragmentArgs.tigerTicketCode) && Intrinsics.areEqual((Object) this.tigerTicketPin, (Object) tigerTicketPurchaseFragmentArgs.tigerTicketPin);
    }

    public int hashCode() {
        return (this.tigerTicketCode.hashCode() * 31) + this.tigerTicketPin.hashCode();
    }

    public String toString() {
        return "TigerTicketPurchaseFragmentArgs(tigerTicketCode=" + this.tigerTicketCode + ", tigerTicketPin=" + this.tigerTicketPin + ')';
    }

    public TigerTicketPurchaseFragmentArgs(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tigerTicketCode");
        Intrinsics.checkNotNullParameter(str2, "tigerTicketPin");
        this.tigerTicketCode = str;
        this.tigerTicketPin = str2;
    }

    public final String getTigerTicketCode() {
        return this.tigerTicketCode;
    }

    public final String getTigerTicketPin() {
        return this.tigerTicketPin;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("tigerTicketCode", this.tigerTicketCode);
        bundle.putString("tigerTicketPin", this.tigerTicketPin);
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("tigerTicketCode", this.tigerTicketCode);
        savedStateHandle.set("tigerTicketPin", this.tigerTicketPin);
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseFragmentArgs$Companion */
    /* compiled from: TigerTicketPurchaseFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TigerTicketPurchaseFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(TigerTicketPurchaseFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("tigerTicketCode")) {
                String string = bundle.getString("tigerTicketCode");
                if (string == null) {
                    throw new IllegalArgumentException("Argument \"tigerTicketCode\" is marked as non-null but was passed a null value.");
                } else if (bundle.containsKey("tigerTicketPin")) {
                    String string2 = bundle.getString("tigerTicketPin");
                    if (string2 != null) {
                        return new TigerTicketPurchaseFragmentArgs(string, string2);
                    }
                    throw new IllegalArgumentException("Argument \"tigerTicketPin\" is marked as non-null but was passed a null value.");
                } else {
                    throw new IllegalArgumentException("Required argument \"tigerTicketPin\" is missing and does not have an android:defaultValue");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"tigerTicketCode\" is missing and does not have an android:defaultValue");
            }
        }

        @JvmStatic
        public final TigerTicketPurchaseFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("tigerTicketCode")) {
                String str = (String) savedStateHandle.get("tigerTicketCode");
                if (str == null) {
                    throw new IllegalArgumentException("Argument \"tigerTicketCode\" is marked as non-null but was passed a null value");
                } else if (savedStateHandle.contains("tigerTicketPin")) {
                    String str2 = (String) savedStateHandle.get("tigerTicketPin");
                    if (str2 != null) {
                        return new TigerTicketPurchaseFragmentArgs(str, str2);
                    }
                    throw new IllegalArgumentException("Argument \"tigerTicketPin\" is marked as non-null but was passed a null value");
                } else {
                    throw new IllegalArgumentException("Required argument \"tigerTicketPin\" is missing and does not have an android:defaultValue");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"tigerTicketCode\" is missing and does not have an android:defaultValue");
            }
        }
    }
}
