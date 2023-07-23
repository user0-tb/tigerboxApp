package media.tiger.tigerbox.p016ui.common;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ<\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006 "}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/InfoDialogFragmentArgs;", "Landroidx/navigation/NavArgs;", "dialogType", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "titleFormatParams", "", "", "messageFormatParams", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;[Ljava/lang/String;)V", "getDialogType", "()Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "getMessageFormatParams", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getTitleFormatParams", "component1", "component2", "component3", "copy", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;[Ljava/lang/String;)Lmedia/tiger/tigerbox/ui/common/InfoDialogFragmentArgs;", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.InfoDialogFragmentArgs */
/* compiled from: InfoDialogFragmentArgs.kt */
public final class InfoDialogFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final InfoDialogType dialogType;
    private final String[] messageFormatParams;
    private final String[] titleFormatParams;

    public static /* synthetic */ InfoDialogFragmentArgs copy$default(InfoDialogFragmentArgs infoDialogFragmentArgs, InfoDialogType infoDialogType, String[] strArr, String[] strArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            infoDialogType = infoDialogFragmentArgs.dialogType;
        }
        if ((i & 2) != 0) {
            strArr = infoDialogFragmentArgs.titleFormatParams;
        }
        if ((i & 4) != 0) {
            strArr2 = infoDialogFragmentArgs.messageFormatParams;
        }
        return infoDialogFragmentArgs.copy(infoDialogType, strArr, strArr2);
    }

    @JvmStatic
    public static final InfoDialogFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final InfoDialogFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final InfoDialogType component1() {
        return this.dialogType;
    }

    public final String[] component2() {
        return this.titleFormatParams;
    }

    public final String[] component3() {
        return this.messageFormatParams;
    }

    public final InfoDialogFragmentArgs copy(InfoDialogType infoDialogType, String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(infoDialogType, "dialogType");
        return new InfoDialogFragmentArgs(infoDialogType, strArr, strArr2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InfoDialogFragmentArgs)) {
            return false;
        }
        InfoDialogFragmentArgs infoDialogFragmentArgs = (InfoDialogFragmentArgs) obj;
        return this.dialogType == infoDialogFragmentArgs.dialogType && Intrinsics.areEqual((Object) this.titleFormatParams, (Object) infoDialogFragmentArgs.titleFormatParams) && Intrinsics.areEqual((Object) this.messageFormatParams, (Object) infoDialogFragmentArgs.messageFormatParams);
    }

    public int hashCode() {
        int hashCode = this.dialogType.hashCode() * 31;
        String[] strArr = this.titleFormatParams;
        int i = 0;
        int hashCode2 = (hashCode + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String[] strArr2 = this.messageFormatParams;
        if (strArr2 != null) {
            i = Arrays.hashCode(strArr2);
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "InfoDialogFragmentArgs(dialogType=" + this.dialogType + ", titleFormatParams=" + Arrays.toString(this.titleFormatParams) + ", messageFormatParams=" + Arrays.toString(this.messageFormatParams) + ')';
    }

    public InfoDialogFragmentArgs(InfoDialogType infoDialogType, String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(infoDialogType, "dialogType");
        this.dialogType = infoDialogType;
        this.titleFormatParams = strArr;
        this.messageFormatParams = strArr2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InfoDialogFragmentArgs(InfoDialogType infoDialogType, String[] strArr, String[] strArr2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(infoDialogType, (i & 2) != 0 ? null : strArr, (i & 4) != 0 ? null : strArr2);
    }

    public final InfoDialogType getDialogType() {
        return this.dialogType;
    }

    public final String[] getTitleFormatParams() {
        return this.titleFormatParams;
    }

    public final String[] getMessageFormatParams() {
        return this.messageFormatParams;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (Parcelable.class.isAssignableFrom(InfoDialogType.class)) {
            bundle.putParcelable("dialogType", (Parcelable) this.dialogType);
        } else if (Serializable.class.isAssignableFrom(InfoDialogType.class)) {
            bundle.putSerializable("dialogType", this.dialogType);
        } else {
            throw new UnsupportedOperationException(InfoDialogType.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        bundle.putStringArray("titleFormatParams", this.titleFormatParams);
        bundle.putStringArray("messageFormatParams", this.messageFormatParams);
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (Parcelable.class.isAssignableFrom(InfoDialogType.class)) {
            savedStateHandle.set("dialogType", (Parcelable) this.dialogType);
        } else if (Serializable.class.isAssignableFrom(InfoDialogType.class)) {
            savedStateHandle.set("dialogType", this.dialogType);
        } else {
            throw new UnsupportedOperationException(InfoDialogType.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        savedStateHandle.set("titleFormatParams", this.titleFormatParams);
        savedStateHandle.set("messageFormatParams", this.messageFormatParams);
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/InfoDialogFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/common/InfoDialogFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.InfoDialogFragmentArgs$Companion */
    /* compiled from: InfoDialogFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final InfoDialogFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(InfoDialogFragmentArgs.class.getClassLoader());
            if (!bundle.containsKey("dialogType")) {
                throw new IllegalArgumentException("Required argument \"dialogType\" is missing and does not have an android:defaultValue");
            } else if (Parcelable.class.isAssignableFrom(InfoDialogType.class) || Serializable.class.isAssignableFrom(InfoDialogType.class)) {
                InfoDialogType infoDialogType = (InfoDialogType) bundle.get("dialogType");
                if (infoDialogType != null) {
                    String[] strArr = null;
                    String[] stringArray = bundle.containsKey("titleFormatParams") ? bundle.getStringArray("titleFormatParams") : null;
                    if (bundle.containsKey("messageFormatParams")) {
                        strArr = bundle.getStringArray("messageFormatParams");
                    }
                    return new InfoDialogFragmentArgs(infoDialogType, stringArray, strArr);
                }
                throw new IllegalArgumentException("Argument \"dialogType\" is marked as non-null but was passed a null value.");
            } else {
                throw new UnsupportedOperationException(InfoDialogType.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final media.tiger.tigerbox.p016ui.common.InfoDialogFragmentArgs fromSavedStateHandle(androidx.lifecycle.SavedStateHandle r6) {
            /*
                r5 = this;
                java.lang.String r0 = "savedStateHandle"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "dialogType"
                boolean r1 = r6.contains(r0)
                if (r1 == 0) goto L_0x0075
                java.lang.Class<android.os.Parcelable> r1 = android.os.Parcelable.class
                java.lang.Class<media.tiger.tigerbox.ui.common.InfoDialogType> r2 = media.tiger.tigerbox.p016ui.common.InfoDialogType.class
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 != 0) goto L_0x003f
                java.lang.Class<java.io.Serializable> r1 = java.io.Serializable.class
                java.lang.Class<media.tiger.tigerbox.ui.common.InfoDialogType> r2 = media.tiger.tigerbox.p016ui.common.InfoDialogType.class
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x0022
                goto L_0x003f
            L_0x0022:
                java.lang.UnsupportedOperationException r6 = new java.lang.UnsupportedOperationException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.Class<media.tiger.tigerbox.ui.common.InfoDialogType> r1 = media.tiger.tigerbox.p016ui.common.InfoDialogType.class
                java.lang.String r1 = r1.getName()
                r0.append(r1)
                java.lang.String r1 = " must implement Parcelable or Serializable or must be an Enum."
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r6.<init>(r0)
                throw r6
            L_0x003f:
                java.lang.Object r0 = r6.get(r0)
                media.tiger.tigerbox.ui.common.InfoDialogType r0 = (media.tiger.tigerbox.p016ui.common.InfoDialogType) r0
                if (r0 == 0) goto L_0x006d
                java.lang.String r1 = "titleFormatParams"
                boolean r2 = r6.contains(r1)
                r3 = 0
                if (r2 == 0) goto L_0x0057
                java.lang.Object r1 = r6.get(r1)
                java.lang.String[] r1 = (java.lang.String[]) r1
                goto L_0x0058
            L_0x0057:
                r1 = r3
            L_0x0058:
                java.lang.String r2 = "messageFormatParams"
                boolean r4 = r6.contains(r2)
                if (r4 == 0) goto L_0x0067
                java.lang.Object r6 = r6.get(r2)
                r3 = r6
                java.lang.String[] r3 = (java.lang.String[]) r3
            L_0x0067:
                media.tiger.tigerbox.ui.common.InfoDialogFragmentArgs r6 = new media.tiger.tigerbox.ui.common.InfoDialogFragmentArgs
                r6.<init>(r0, r1, r3)
                return r6
            L_0x006d:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Argument \"dialogType\" is marked as non-null but was passed a null value"
                r6.<init>(r0)
                throw r6
            L_0x0075:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Required argument \"dialogType\" is missing and does not have an android:defaultValue"
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.common.InfoDialogFragmentArgs.Companion.fromSavedStateHandle(androidx.lifecycle.SavedStateHandle):media.tiger.tigerbox.ui.common.InfoDialogFragmentArgs");
        }
    }
}
