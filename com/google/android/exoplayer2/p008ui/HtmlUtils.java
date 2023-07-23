package com.google.android.exoplayer2.p008ui;

import android.graphics.Color;
import com.google.android.exoplayer2.util.C1229Util;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;

/* renamed from: com.google.android.exoplayer2.ui.HtmlUtils */
final class HtmlUtils {
    private HtmlUtils() {
    }

    public static String toCssRgba(int i) {
        return C1229Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(((double) Color.alpha(i)) / 255.0d));
    }

    public static String cssAllClassDescendantsSelector(String str) {
        return DownloadsManager.EXTENSION_SEPARATOR + str + ",." + str + " *";
    }
}
