package media.tiger.tigerbox.p016ui.binding;

import android.graphics.drawable.Drawable;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.util.Objects;
import kotlin.Metadata;
import media.tiger.tigerbox.C2814R;

@Metadata(mo33736d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J>\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, mo33737d2 = {"media/tiger/tigerbox/ui/binding/BindingAdaptersKt$bindImageFromUrl$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.binding.BindingAdaptersKt$bindImageFromUrl$1 */
/* compiled from: BindingAdapters.kt */
public final class BindingAdaptersKt$bindImageFromUrl$1 implements RequestListener<Drawable> {
    final /* synthetic */ ImageView $view;

    BindingAdaptersKt$bindImageFromUrl$1(ImageView imageView) {
        this.$view = imageView;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
        if (this.$view.getParent().getParent() instanceof ConstraintLayout) {
            ViewParent parent = this.$view.getParent().getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ((TextView) ((ConstraintLayout) parent).findViewById(C2814R.C2817id.f1730producttitle)).setVisibility(0);
        }
        return false;
    }

    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
        if (this.$view.getParent().getParent() instanceof ConstraintLayout) {
            ViewParent parent = this.$view.getParent().getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ((ConstraintLayout) parent).setBackgroundResource(0);
            ViewParent parent2 = this.$view.getParent().getParent();
            Objects.requireNonNull(parent2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ((TextView) ((ConstraintLayout) parent2).findViewById(C2814R.C2817id.f1730producttitle)).setVisibility(8);
        }
        return false;
    }
}
