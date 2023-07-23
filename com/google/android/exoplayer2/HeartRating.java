package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C1229Util;
import com.google.common.base.Objects;

public final class HeartRating extends Rating {
    public static final Bundleable.Creator<HeartRating> CREATOR = HeartRating$$ExternalSyntheticLambda0.INSTANCE;
    private static final String FIELD_IS_HEART = C1229Util.intToStringMaxRadix(2);
    private static final String FIELD_RATED = C1229Util.intToStringMaxRadix(1);
    private static final int TYPE = 0;
    private final boolean isHeart;
    private final boolean rated;

    public HeartRating() {
        this.rated = false;
        this.isHeart = false;
    }

    public HeartRating(boolean z) {
        this.rated = true;
        this.isHeart = z;
    }

    public boolean isRated() {
        return this.rated;
    }

    public boolean isHeart() {
        return this.isHeart;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.rated), Boolean.valueOf(this.isHeart));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        if (this.isHeart == heartRating.isHeart && this.rated == heartRating.rated) {
            return true;
        }
        return false;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_RATING_TYPE, 0);
        bundle.putBoolean(FIELD_RATED, this.rated);
        bundle.putBoolean(FIELD_IS_HEART, this.isHeart);
        return bundle;
    }

    /* access modifiers changed from: private */
    public static HeartRating fromBundle(Bundle bundle) {
        Assertions.checkArgument(bundle.getInt(FIELD_RATING_TYPE, -1) == 0);
        if (bundle.getBoolean(FIELD_RATED, false)) {
            return new HeartRating(bundle.getBoolean(FIELD_IS_HEART, false));
        }
        return new HeartRating();
    }
}
