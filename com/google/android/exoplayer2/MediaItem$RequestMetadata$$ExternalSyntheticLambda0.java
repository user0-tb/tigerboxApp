package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;

public final /* synthetic */ class MediaItem$RequestMetadata$$ExternalSyntheticLambda0 implements Bundleable.Creator {
    public static final /* synthetic */ MediaItem$RequestMetadata$$ExternalSyntheticLambda0 INSTANCE = new MediaItem$RequestMetadata$$ExternalSyntheticLambda0();

    private /* synthetic */ MediaItem$RequestMetadata$$ExternalSyntheticLambda0() {
    }

    public final Bundleable fromBundle(Bundle bundle) {
        return new MediaItem.RequestMetadata.Builder().setMediaUri((Uri) bundle.getParcelable(MediaItem.RequestMetadata.FIELD_MEDIA_URI)).setSearchQuery(bundle.getString(MediaItem.RequestMetadata.FIELD_SEARCH_QUERY)).setExtras(bundle.getBundle(MediaItem.RequestMetadata.FIELD_EXTRAS)).build();
    }
}
