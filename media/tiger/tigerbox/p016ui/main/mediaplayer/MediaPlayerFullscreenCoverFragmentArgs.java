package media.tiger.tigerbox.p016ui.main.mediaplayer;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerFullscreenCoverFragmentArgs;", "Landroidx/navigation/NavArgs;", "imageUrl", "", "(Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFullscreenCoverFragmentArgs */
/* compiled from: MediaPlayerFullscreenCoverFragmentArgs.kt */
public final class MediaPlayerFullscreenCoverFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String imageUrl;

    public MediaPlayerFullscreenCoverFragmentArgs() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MediaPlayerFullscreenCoverFragmentArgs copy$default(MediaPlayerFullscreenCoverFragmentArgs mediaPlayerFullscreenCoverFragmentArgs, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mediaPlayerFullscreenCoverFragmentArgs.imageUrl;
        }
        return mediaPlayerFullscreenCoverFragmentArgs.copy(str);
    }

    @JvmStatic
    public static final MediaPlayerFullscreenCoverFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final MediaPlayerFullscreenCoverFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final MediaPlayerFullscreenCoverFragmentArgs copy(String str) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        return new MediaPlayerFullscreenCoverFragmentArgs(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MediaPlayerFullscreenCoverFragmentArgs) && Intrinsics.areEqual((Object) this.imageUrl, (Object) ((MediaPlayerFullscreenCoverFragmentArgs) obj).imageUrl);
    }

    public int hashCode() {
        return this.imageUrl.hashCode();
    }

    public String toString() {
        return "MediaPlayerFullscreenCoverFragmentArgs(imageUrl=" + this.imageUrl + ')';
    }

    public MediaPlayerFullscreenCoverFragmentArgs(String str) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        this.imageUrl = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaPlayerFullscreenCoverFragmentArgs(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "\"\"" : str);
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl", this.imageUrl);
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("imageUrl", this.imageUrl);
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerFullscreenCoverFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerFullscreenCoverFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFullscreenCoverFragmentArgs$Companion */
    /* compiled from: MediaPlayerFullscreenCoverFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MediaPlayerFullscreenCoverFragmentArgs fromBundle(Bundle bundle) {
            String str;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(MediaPlayerFullscreenCoverFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("imageUrl")) {
                str = bundle.getString("imageUrl");
                if (str == null) {
                    throw new IllegalArgumentException("Argument \"imageUrl\" is marked as non-null but was passed a null value.");
                }
            } else {
                str = "\"\"";
            }
            return new MediaPlayerFullscreenCoverFragmentArgs(str);
        }

        @JvmStatic
        public final MediaPlayerFullscreenCoverFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
            String str;
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("imageUrl")) {
                str = (String) savedStateHandle.get("imageUrl");
                if (str == null) {
                    throw new IllegalArgumentException("Argument \"imageUrl\" is marked as non-null but was passed a null value");
                }
            } else {
                str = "\"\"";
            }
            return new MediaPlayerFullscreenCoverFragmentArgs(str);
        }
    }
}
