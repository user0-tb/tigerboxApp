package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cmp.PKIStatusInfo;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.PolicyInformation;

public class DVCSCertInfo extends ASN1Object {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_CERTS = 3;
    private static final int TAG_DV_STATUS = 0;
    private static final int TAG_POLICY = 1;
    private static final int TAG_REQ_SIGNATURE = 2;
    private ASN1Sequence certs;
    private DVCSRequestInformation dvReqInfo;
    private PKIStatusInfo dvStatus;
    private Extensions extensions;
    private DigestInfo messageImprint;
    private PolicyInformation policy;
    private ASN1Set reqSignature;
    private DVCSTime responseTime;
    private ASN1Integer serialNumber;
    private int version = 1;

    public DVCSCertInfo(DVCSRequestInformation dVCSRequestInformation, DigestInfo digestInfo, ASN1Integer aSN1Integer, DVCSTime dVCSTime) {
        this.dvReqInfo = dVCSRequestInformation;
        this.messageImprint = digestInfo;
        this.serialNumber = aSN1Integer;
        this.responseTime = dVCSTime;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r8.extensions = org.spongycastle.asn1.x509.Extensions.getInstance(r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0089 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DVCSCertInfo(org.spongycastle.asn1.ASN1Sequence r9) {
        /*
            r8 = this;
            r8.<init>()
            r0 = 1
            r8.version = r0
            r1 = 0
            org.spongycastle.asn1.ASN1Encodable r2 = r9.getObjectAt(r1)
            r3 = 2
            org.spongycastle.asn1.ASN1Integer r4 = org.spongycastle.asn1.ASN1Integer.getInstance(r2)     // Catch:{ IllegalArgumentException -> 0x0020 }
            java.math.BigInteger r4 = r4.getValue()     // Catch:{ IllegalArgumentException -> 0x0020 }
            int r4 = r4.intValue()     // Catch:{ IllegalArgumentException -> 0x0020 }
            r8.version = r4     // Catch:{ IllegalArgumentException -> 0x0020 }
            org.spongycastle.asn1.ASN1Encodable r2 = r9.getObjectAt(r0)     // Catch:{ IllegalArgumentException -> 0x001e }
        L_0x001e:
            r4 = 2
            goto L_0x0021
        L_0x0020:
            r4 = 1
        L_0x0021:
            org.spongycastle.asn1.dvcs.DVCSRequestInformation r2 = org.spongycastle.asn1.dvcs.DVCSRequestInformation.getInstance(r2)
            r8.dvReqInfo = r2
            int r2 = r4 + 1
            org.spongycastle.asn1.ASN1Encodable r4 = r9.getObjectAt(r4)
            org.spongycastle.asn1.x509.DigestInfo r4 = org.spongycastle.asn1.x509.DigestInfo.getInstance(r4)
            r8.messageImprint = r4
            int r4 = r2 + 1
            org.spongycastle.asn1.ASN1Encodable r2 = r9.getObjectAt(r2)
            org.spongycastle.asn1.ASN1Integer r2 = org.spongycastle.asn1.ASN1Integer.getInstance(r2)
            r8.serialNumber = r2
            int r2 = r4 + 1
            org.spongycastle.asn1.ASN1Encodable r4 = r9.getObjectAt(r4)
            org.spongycastle.asn1.dvcs.DVCSTime r4 = org.spongycastle.asn1.dvcs.DVCSTime.getInstance(r4)
            r8.responseTime = r4
        L_0x004b:
            int r4 = r9.size()
            if (r2 >= r4) goto L_0x0091
            int r4 = r2 + 1
            org.spongycastle.asn1.ASN1Encodable r2 = r9.getObjectAt(r2)
            org.spongycastle.asn1.ASN1TaggedObject r5 = org.spongycastle.asn1.ASN1TaggedObject.getInstance(r2)     // Catch:{ IllegalArgumentException -> 0x0089 }
            int r6 = r5.getTagNo()     // Catch:{ IllegalArgumentException -> 0x0089 }
            if (r6 == 0) goto L_0x0082
            if (r6 == r0) goto L_0x0077
            if (r6 == r3) goto L_0x0070
            r7 = 3
            if (r6 == r7) goto L_0x0069
            goto L_0x008f
        L_0x0069:
            org.spongycastle.asn1.ASN1Sequence r5 = org.spongycastle.asn1.ASN1Sequence.getInstance(r5, r1)     // Catch:{ IllegalArgumentException -> 0x0089 }
            r8.certs = r5     // Catch:{ IllegalArgumentException -> 0x0089 }
            goto L_0x008f
        L_0x0070:
            org.spongycastle.asn1.ASN1Set r5 = org.spongycastle.asn1.ASN1Set.getInstance(r5, r1)     // Catch:{ IllegalArgumentException -> 0x0089 }
            r8.reqSignature = r5     // Catch:{ IllegalArgumentException -> 0x0089 }
            goto L_0x008f
        L_0x0077:
            org.spongycastle.asn1.ASN1Sequence r5 = org.spongycastle.asn1.ASN1Sequence.getInstance(r5, r1)     // Catch:{ IllegalArgumentException -> 0x0089 }
            org.spongycastle.asn1.x509.PolicyInformation r5 = org.spongycastle.asn1.x509.PolicyInformation.getInstance(r5)     // Catch:{ IllegalArgumentException -> 0x0089 }
            r8.policy = r5     // Catch:{ IllegalArgumentException -> 0x0089 }
            goto L_0x008f
        L_0x0082:
            org.spongycastle.asn1.cmp.PKIStatusInfo r5 = org.spongycastle.asn1.cmp.PKIStatusInfo.getInstance(r5, r1)     // Catch:{ IllegalArgumentException -> 0x0089 }
            r8.dvStatus = r5     // Catch:{ IllegalArgumentException -> 0x0089 }
            goto L_0x008f
        L_0x0089:
            org.spongycastle.asn1.x509.Extensions r2 = org.spongycastle.asn1.x509.Extensions.getInstance(r2)     // Catch:{ IllegalArgumentException -> 0x008f }
            r8.extensions = r2     // Catch:{ IllegalArgumentException -> 0x008f }
        L_0x008f:
            r2 = r4
            goto L_0x004b
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.dvcs.DVCSCertInfo.<init>(org.spongycastle.asn1.ASN1Sequence):void");
    }

    public static DVCSCertInfo getInstance(Object obj) {
        if (obj instanceof DVCSCertInfo) {
            return (DVCSCertInfo) obj;
        }
        if (obj != null) {
            return new DVCSCertInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static DVCSCertInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = this.version;
        if (i != 1) {
            aSN1EncodableVector.add(new ASN1Integer((long) i));
        }
        aSN1EncodableVector.add(this.dvReqInfo);
        aSN1EncodableVector.add(this.messageImprint);
        aSN1EncodableVector.add(this.serialNumber);
        aSN1EncodableVector.add(this.responseTime);
        if (this.dvStatus != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.dvStatus));
        }
        if (this.policy != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, this.policy));
        }
        if (this.reqSignature != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, this.reqSignature));
        }
        if (this.certs != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, this.certs));
        }
        Extensions extensions2 = this.extensions;
        if (extensions2 != null) {
            aSN1EncodableVector.add(extensions2);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DVCSCertInfo {\n");
        if (this.version != 1) {
            stringBuffer.append("version: " + this.version + "\n");
        }
        stringBuffer.append("dvReqInfo: " + this.dvReqInfo + "\n");
        stringBuffer.append("messageImprint: " + this.messageImprint + "\n");
        stringBuffer.append("serialNumber: " + this.serialNumber + "\n");
        stringBuffer.append("responseTime: " + this.responseTime + "\n");
        if (this.dvStatus != null) {
            stringBuffer.append("dvStatus: " + this.dvStatus + "\n");
        }
        if (this.policy != null) {
            stringBuffer.append("policy: " + this.policy + "\n");
        }
        if (this.reqSignature != null) {
            stringBuffer.append("reqSignature: " + this.reqSignature + "\n");
        }
        if (this.certs != null) {
            stringBuffer.append("certs: " + this.certs + "\n");
        }
        if (this.extensions != null) {
            stringBuffer.append("extensions: " + this.extensions + "\n");
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    public int getVersion() {
        return this.version;
    }

    private void setVersion(int i) {
        this.version = i;
    }

    public DVCSRequestInformation getDvReqInfo() {
        return this.dvReqInfo;
    }

    private void setDvReqInfo(DVCSRequestInformation dVCSRequestInformation) {
        this.dvReqInfo = dVCSRequestInformation;
    }

    public DigestInfo getMessageImprint() {
        return this.messageImprint;
    }

    private void setMessageImprint(DigestInfo digestInfo) {
        this.messageImprint = digestInfo;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public DVCSTime getResponseTime() {
        return this.responseTime;
    }

    public PKIStatusInfo getDvStatus() {
        return this.dvStatus;
    }

    public PolicyInformation getPolicy() {
        return this.policy;
    }

    public ASN1Set getReqSignature() {
        return this.reqSignature;
    }

    public TargetEtcChain[] getCerts() {
        ASN1Sequence aSN1Sequence = this.certs;
        if (aSN1Sequence != null) {
            return TargetEtcChain.arrayFromSequence(aSN1Sequence);
        }
        return null;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }
}
