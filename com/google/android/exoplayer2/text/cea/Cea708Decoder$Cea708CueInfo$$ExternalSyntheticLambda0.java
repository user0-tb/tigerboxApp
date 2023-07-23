package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.Comparator;

public final /* synthetic */ class Cea708Decoder$Cea708CueInfo$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ Cea708Decoder$Cea708CueInfo$$ExternalSyntheticLambda0 INSTANCE = new Cea708Decoder$Cea708CueInfo$$ExternalSyntheticLambda0();

    private /* synthetic */ Cea708Decoder$Cea708CueInfo$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((Cea708Decoder.Cea708CueInfo) obj2).priority, ((Cea708Decoder.Cea708CueInfo) obj).priority);
    }
}
