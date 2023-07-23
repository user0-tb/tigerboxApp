package media.tiger.tigerbox.p016ui.main.seemoreproducts;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreProductsFragmentArgs;", "Landroidx/navigation/NavArgs;", "rowId", "", "ordinal", "(II)V", "getOrdinal", "()I", "getRowId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragmentArgs */
/* compiled from: SeeMoreProductsFragmentArgs.kt */
public final class SeeMoreProductsFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int ordinal;
    private final int rowId;

    public static /* synthetic */ SeeMoreProductsFragmentArgs copy$default(SeeMoreProductsFragmentArgs seeMoreProductsFragmentArgs, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = seeMoreProductsFragmentArgs.rowId;
        }
        if ((i3 & 2) != 0) {
            i2 = seeMoreProductsFragmentArgs.ordinal;
        }
        return seeMoreProductsFragmentArgs.copy(i, i2);
    }

    @JvmStatic
    public static final SeeMoreProductsFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final SeeMoreProductsFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final int component1() {
        return this.rowId;
    }

    public final int component2() {
        return this.ordinal;
    }

    public final SeeMoreProductsFragmentArgs copy(int i, int i2) {
        return new SeeMoreProductsFragmentArgs(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SeeMoreProductsFragmentArgs)) {
            return false;
        }
        SeeMoreProductsFragmentArgs seeMoreProductsFragmentArgs = (SeeMoreProductsFragmentArgs) obj;
        return this.rowId == seeMoreProductsFragmentArgs.rowId && this.ordinal == seeMoreProductsFragmentArgs.ordinal;
    }

    public int hashCode() {
        return (this.rowId * 31) + this.ordinal;
    }

    public String toString() {
        return "SeeMoreProductsFragmentArgs(rowId=" + this.rowId + ", ordinal=" + this.ordinal + ')';
    }

    public SeeMoreProductsFragmentArgs(int i, int i2) {
        this.rowId = i;
        this.ordinal = i2;
    }

    public final int getRowId() {
        return this.rowId;
    }

    public final int getOrdinal() {
        return this.ordinal;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("rowId", this.rowId);
        bundle.putInt("ordinal", this.ordinal);
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("rowId", Integer.valueOf(this.rowId));
        savedStateHandle.set("ordinal", Integer.valueOf(this.ordinal));
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreProductsFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreProductsFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragmentArgs$Companion */
    /* compiled from: SeeMoreProductsFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SeeMoreProductsFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(SeeMoreProductsFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("rowId")) {
                int i = bundle.getInt("rowId");
                if (bundle.containsKey("ordinal")) {
                    return new SeeMoreProductsFragmentArgs(i, bundle.getInt("ordinal"));
                }
                throw new IllegalArgumentException("Required argument \"ordinal\" is missing and does not have an android:defaultValue");
            }
            throw new IllegalArgumentException("Required argument \"rowId\" is missing and does not have an android:defaultValue");
        }

        @JvmStatic
        public final SeeMoreProductsFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("rowId")) {
                Integer num = (Integer) savedStateHandle.get("rowId");
                if (num == null) {
                    throw new IllegalArgumentException("Argument \"rowId\" of type integer does not support null values");
                } else if (savedStateHandle.contains("ordinal")) {
                    Integer num2 = (Integer) savedStateHandle.get("ordinal");
                    if (num2 != null) {
                        return new SeeMoreProductsFragmentArgs(num.intValue(), num2.intValue());
                    }
                    throw new IllegalArgumentException("Argument \"ordinal\" of type integer does not support null values");
                } else {
                    throw new IllegalArgumentException("Required argument \"ordinal\" is missing and does not have an android:defaultValue");
                }
            } else {
                throw new IllegalArgumentException("Required argument \"rowId\" is missing and does not have an android:defaultValue");
            }
        }
    }
}
