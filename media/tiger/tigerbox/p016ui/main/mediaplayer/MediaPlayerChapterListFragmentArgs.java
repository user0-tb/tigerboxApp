package media.tiger.tigerbox.p016ui.main.mediaplayer;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.ProductDomain;

@Metadata(mo33736d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerChapterListFragmentArgs;", "Landroidx/navigation/NavArgs;", "productDomain", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "(Lmedia/tiger/tigerbox/model/domain/ProductDomain;)V", "getProductDomain", "()Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerChapterListFragmentArgs */
/* compiled from: MediaPlayerChapterListFragmentArgs.kt */
public final class MediaPlayerChapterListFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ProductDomain productDomain;

    public static /* synthetic */ MediaPlayerChapterListFragmentArgs copy$default(MediaPlayerChapterListFragmentArgs mediaPlayerChapterListFragmentArgs, ProductDomain productDomain2, int i, Object obj) {
        if ((i & 1) != 0) {
            productDomain2 = mediaPlayerChapterListFragmentArgs.productDomain;
        }
        return mediaPlayerChapterListFragmentArgs.copy(productDomain2);
    }

    @JvmStatic
    public static final MediaPlayerChapterListFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final MediaPlayerChapterListFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final ProductDomain component1() {
        return this.productDomain;
    }

    public final MediaPlayerChapterListFragmentArgs copy(ProductDomain productDomain2) {
        Intrinsics.checkNotNullParameter(productDomain2, "productDomain");
        return new MediaPlayerChapterListFragmentArgs(productDomain2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MediaPlayerChapterListFragmentArgs) && Intrinsics.areEqual((Object) this.productDomain, (Object) ((MediaPlayerChapterListFragmentArgs) obj).productDomain);
    }

    public int hashCode() {
        return this.productDomain.hashCode();
    }

    public String toString() {
        return "MediaPlayerChapterListFragmentArgs(productDomain=" + this.productDomain + ')';
    }

    public MediaPlayerChapterListFragmentArgs(ProductDomain productDomain2) {
        Intrinsics.checkNotNullParameter(productDomain2, "productDomain");
        this.productDomain = productDomain2;
    }

    public final ProductDomain getProductDomain() {
        return this.productDomain;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (Parcelable.class.isAssignableFrom(ProductDomain.class)) {
            bundle.putParcelable("productDomain", (Parcelable) this.productDomain);
        } else if (Serializable.class.isAssignableFrom(ProductDomain.class)) {
            bundle.putSerializable("productDomain", this.productDomain);
        } else {
            throw new UnsupportedOperationException(ProductDomain.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (Parcelable.class.isAssignableFrom(ProductDomain.class)) {
            savedStateHandle.set("productDomain", (Parcelable) this.productDomain);
        } else if (Serializable.class.isAssignableFrom(ProductDomain.class)) {
            savedStateHandle.set("productDomain", this.productDomain);
        } else {
            throw new UnsupportedOperationException(ProductDomain.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerChapterListFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerChapterListFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerChapterListFragmentArgs$Companion */
    /* compiled from: MediaPlayerChapterListFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MediaPlayerChapterListFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(MediaPlayerChapterListFragmentArgs.class.getClassLoader());
            if (!bundle.containsKey("productDomain")) {
                throw new IllegalArgumentException("Required argument \"productDomain\" is missing and does not have an android:defaultValue");
            } else if (Parcelable.class.isAssignableFrom(ProductDomain.class) || Serializable.class.isAssignableFrom(ProductDomain.class)) {
                ProductDomain productDomain = (ProductDomain) bundle.get("productDomain");
                if (productDomain != null) {
                    return new MediaPlayerChapterListFragmentArgs(productDomain);
                }
                throw new IllegalArgumentException("Argument \"productDomain\" is marked as non-null but was passed a null value.");
            } else {
                throw new UnsupportedOperationException(ProductDomain.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
        }

        @JvmStatic
        public final MediaPlayerChapterListFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (!savedStateHandle.contains("productDomain")) {
                throw new IllegalArgumentException("Required argument \"productDomain\" is missing and does not have an android:defaultValue");
            } else if (Parcelable.class.isAssignableFrom(ProductDomain.class) || Serializable.class.isAssignableFrom(ProductDomain.class)) {
                ProductDomain productDomain = (ProductDomain) savedStateHandle.get("productDomain");
                if (productDomain != null) {
                    return new MediaPlayerChapterListFragmentArgs(productDomain);
                }
                throw new IllegalArgumentException("Argument \"productDomain\" is marked as non-null but was passed a null value");
            } else {
                throw new UnsupportedOperationException(ProductDomain.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
        }
    }
}
