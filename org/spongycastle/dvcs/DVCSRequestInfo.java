package org.spongycastle.dvcs;

import java.math.BigInteger;
import java.util.Date;
import org.spongycastle.asn1.dvcs.DVCSRequestInformation;
import org.spongycastle.asn1.dvcs.DVCSTime;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.PolicyInformation;
import org.spongycastle.tsp.TimeStampToken;
import org.spongycastle.util.Arrays;

public class DVCSRequestInfo {
    private DVCSRequestInformation data;

    public DVCSRequestInfo(byte[] bArr) {
        this(DVCSRequestInformation.getInstance(bArr));
    }

    public DVCSRequestInfo(DVCSRequestInformation dVCSRequestInformation) {
        this.data = dVCSRequestInformation;
    }

    public DVCSRequestInformation toASN1Structure() {
        return this.data;
    }

    public int getVersion() {
        return this.data.getVersion();
    }

    public int getServiceType() {
        return this.data.getService().getValue().intValue();
    }

    public BigInteger getNonce() {
        return this.data.getNonce();
    }

    public Date getRequestTime() throws DVCSParsingException {
        DVCSTime requestTime = this.data.getRequestTime();
        if (requestTime == null) {
            return null;
        }
        try {
            if (requestTime.getGenTime() != null) {
                return requestTime.getGenTime().getDate();
            }
            return new TimeStampToken(requestTime.getTimeStampToken()).getTimeStampInfo().getGenTime();
        } catch (Exception e) {
            throw new DVCSParsingException("unable to extract time: " + e.getMessage(), e);
        }
    }

    public GeneralNames getRequester() {
        return this.data.getRequester();
    }

    public PolicyInformation getRequestPolicy() {
        if (this.data.getRequestPolicy() != null) {
            return this.data.getRequestPolicy();
        }
        return null;
    }

    public GeneralNames getDVCSNames() {
        return this.data.getDVCS();
    }

    public GeneralNames getDataLocations() {
        return this.data.getDataLocations();
    }

    public static boolean validate(DVCSRequestInfo dVCSRequestInfo, DVCSRequestInfo dVCSRequestInfo2) {
        DVCSRequestInformation dVCSRequestInformation = dVCSRequestInfo.data;
        DVCSRequestInformation dVCSRequestInformation2 = dVCSRequestInfo2.data;
        if (dVCSRequestInformation.getVersion() != dVCSRequestInformation2.getVersion() || !clientEqualsServer(dVCSRequestInformation.getService(), dVCSRequestInformation2.getService()) || !clientEqualsServer(dVCSRequestInformation.getRequestTime(), dVCSRequestInformation2.getRequestTime()) || !clientEqualsServer(dVCSRequestInformation.getRequestPolicy(), dVCSRequestInformation2.getRequestPolicy()) || !clientEqualsServer(dVCSRequestInformation.getExtensions(), dVCSRequestInformation2.getExtensions())) {
            return false;
        }
        if (dVCSRequestInformation.getNonce() == null) {
            return true;
        }
        if (dVCSRequestInformation2.getNonce() == null) {
            return false;
        }
        byte[] byteArray = dVCSRequestInformation.getNonce().toByteArray();
        byte[] byteArray2 = dVCSRequestInformation2.getNonce().toByteArray();
        if (byteArray2.length >= byteArray.length && Arrays.areEqual(byteArray, Arrays.copyOfRange(byteArray2, 0, byteArray.length))) {
            return true;
        }
        return false;
    }

    private static boolean clientEqualsServer(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || (obj != null && obj.equals(obj2));
    }
}
