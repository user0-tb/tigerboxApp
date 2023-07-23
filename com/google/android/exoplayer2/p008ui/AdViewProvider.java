package com.google.android.exoplayer2.p008ui;

import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.ui.AdViewProvider */
public interface AdViewProvider {
    List<AdOverlayInfo> getAdOverlayInfos();

    ViewGroup getAdViewGroup();

    /* renamed from: com.google.android.exoplayer2.ui.AdViewProvider$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$getAdOverlayInfos(AdViewProvider _this) {
            return ImmutableList.m261of();
        }
    }
}
