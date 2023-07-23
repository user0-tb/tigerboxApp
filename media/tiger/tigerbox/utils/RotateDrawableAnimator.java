package media.tiger.tigerbox.utils;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/utils/RotateDrawableAnimator;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "mValueAnimator", "Landroid/animation/ValueAnimator;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RotateDrawableAnimator.kt */
public final class RotateDrawableAnimator {
    private final Drawable drawable;
    private final ValueAnimator mValueAnimator;

    public RotateDrawableAnimator(Drawable drawable2) {
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        this.drawable = drawable2;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 10000});
        Intrinsics.checkNotNullExpressionValue(ofInt, "ofInt(0, 10000)");
        this.mValueAnimator = ofInt;
        ofInt.setDuration(3600);
        ofInt.addUpdateListener(new RotateDrawableAnimator$$ExternalSyntheticLambda0(this));
        ofInt.setRepeatMode(1);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m2573_init_$lambda0(RotateDrawableAnimator rotateDrawableAnimator, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(rotateDrawableAnimator, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Drawable drawable2 = rotateDrawableAnimator.drawable;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        drawable2.setLevel(((Integer) animatedValue).intValue());
    }
}
