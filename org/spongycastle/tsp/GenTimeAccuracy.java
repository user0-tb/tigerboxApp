package org.spongycastle.tsp;

import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.tsp.Accuracy;

public class GenTimeAccuracy {
    private Accuracy accuracy;

    public GenTimeAccuracy(Accuracy accuracy2) {
        this.accuracy = accuracy2;
    }

    public int getSeconds() {
        return getTimeComponent(this.accuracy.getSeconds());
    }

    public int getMillis() {
        return getTimeComponent(this.accuracy.getMillis());
    }

    public int getMicros() {
        return getTimeComponent(this.accuracy.getMicros());
    }

    private int getTimeComponent(ASN1Integer aSN1Integer) {
        if (aSN1Integer != null) {
            return aSN1Integer.getValue().intValue();
        }
        return 0;
    }

    public String toString() {
        return getSeconds() + DownloadsManager.EXTENSION_SEPARATOR + format(getMillis()) + format(getMicros());
    }

    private String format(int i) {
        if (i < 10) {
            return "00" + i;
        } else if (i >= 100) {
            return Integer.toString(i);
        } else {
            return SessionDescription.SUPPORTED_SDP_VERSION + i;
        }
    }
}
