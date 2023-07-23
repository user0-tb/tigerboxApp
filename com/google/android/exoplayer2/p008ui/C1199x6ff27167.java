package com.google.android.exoplayer2.p008ui;

import android.view.View;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p008ui.StyledPlayerControlView;
import com.google.android.exoplayer2.source.TrackGroup;

/* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackSelectionAdapter$$ExternalSyntheticLambda0 */
public final /* synthetic */ class C1199x6ff27167 implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView.TrackSelectionAdapter f$0;
    public final /* synthetic */ Player f$1;
    public final /* synthetic */ TrackGroup f$2;
    public final /* synthetic */ StyledPlayerControlView.TrackInformation f$3;

    public /* synthetic */ C1199x6ff27167(StyledPlayerControlView.TrackSelectionAdapter trackSelectionAdapter, Player player, TrackGroup trackGroup, StyledPlayerControlView.TrackInformation trackInformation) {
        this.f$0 = trackSelectionAdapter;
        this.f$1 = player;
        this.f$2 = trackGroup;
        this.f$3 = trackInformation;
    }

    public final void onClick(View view) {
        this.f$0.mo19348x30db9e7f(this.f$1, this.f$2, this.f$3, view);
    }
}
