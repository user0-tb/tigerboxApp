package com.google.android.material.elevation;

import android.content.Context;
import com.google.android.material.C1241R;
import com.google.android.material.color.MaterialColors;

public enum SurfaceColors {
    SURFACE_0(C1241R.dimen.m3_sys_elevation_level0),
    SURFACE_1(C1241R.dimen.m3_sys_elevation_level1),
    SURFACE_2(C1241R.dimen.m3_sys_elevation_level2),
    SURFACE_3(C1241R.dimen.m3_sys_elevation_level3),
    SURFACE_4(C1241R.dimen.m3_sys_elevation_level4),
    SURFACE_5(C1241R.dimen.m3_sys_elevation_level5);
    
    private final int elevationResId;

    private SurfaceColors(int i) {
        this.elevationResId = i;
    }

    public int getColor(Context context) {
        return getColorForElevation(context, context.getResources().getDimension(this.elevationResId));
    }

    public static int getColorForElevation(Context context, float f) {
        return new ElevationOverlayProvider(context).compositeOverlay(MaterialColors.getColor(context, C1241R.attr.colorSurface, 0), f);
    }
}
