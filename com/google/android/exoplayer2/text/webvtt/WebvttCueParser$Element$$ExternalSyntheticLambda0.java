package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Comparator;

public final /* synthetic */ class WebvttCueParser$Element$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ WebvttCueParser$Element$$ExternalSyntheticLambda0 INSTANCE = new WebvttCueParser$Element$$ExternalSyntheticLambda0();

    private /* synthetic */ WebvttCueParser$Element$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((WebvttCueParser.Element) obj).startTag.position, ((WebvttCueParser.Element) obj2).startTag.position);
    }
}
