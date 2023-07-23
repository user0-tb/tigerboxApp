package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;

/* renamed from: com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker$MediaPlaylistBundle$$ExternalSyntheticLambda0 */
public final /* synthetic */ class C1149x8000b21b implements Runnable {
    public final /* synthetic */ DefaultHlsPlaylistTracker.MediaPlaylistBundle f$0;
    public final /* synthetic */ Uri f$1;

    public /* synthetic */ C1149x8000b21b(DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle, Uri uri) {
        this.f$0 = mediaPlaylistBundle;
        this.f$1 = uri;
    }

    public final void run() {
        this.f$0.mo18527x4fadff69(this.f$1);
    }
}
