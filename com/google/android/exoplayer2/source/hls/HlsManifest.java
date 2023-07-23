package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;

public final class HlsManifest {
    @Deprecated
    public final HlsMasterPlaylist masterPlaylist;
    public final HlsMediaPlaylist mediaPlaylist;
    public final HlsMultivariantPlaylist multivariantPlaylist;

    HlsManifest(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.multivariantPlaylist = hlsMultivariantPlaylist;
        this.mediaPlaylist = hlsMediaPlaylist;
        this.masterPlaylist = new HlsMasterPlaylist(hlsMultivariantPlaylist.baseUri, hlsMultivariantPlaylist.tags, hlsMultivariantPlaylist.variants, hlsMultivariantPlaylist.videos, hlsMultivariantPlaylist.audios, hlsMultivariantPlaylist.subtitles, hlsMultivariantPlaylist.closedCaptions, hlsMultivariantPlaylist.muxedAudioFormat, hlsMultivariantPlaylist.muxedCaptionFormats, hlsMultivariantPlaylist.hasIndependentSegments, hlsMultivariantPlaylist.variableDefinitions, hlsMultivariantPlaylist.sessionKeyDrmInitData);
    }
}
