package org.spongycastle.cms;

import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public class CMSSignedDataGenerator extends CMSSignedGenerator {
    private List signerInfs = new ArrayList();

    public CMSSignedData generate(CMSTypedData cMSTypedData) throws CMSException {
        return generate(cMSTypedData, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.cms.CMSSignedData generate(org.spongycastle.cms.CMSTypedData r12, boolean r13) throws org.spongycastle.cms.CMSException {
        /*
            r11 = this;
            java.util.List r0 = r11.signerInfs
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0105
            org.spongycastle.asn1.ASN1EncodableVector r0 = new org.spongycastle.asn1.ASN1EncodableVector
            r0.<init>()
            org.spongycastle.asn1.ASN1EncodableVector r1 = new org.spongycastle.asn1.ASN1EncodableVector
            r1.<init>()
            java.util.Map r2 = r11.digests
            r2.clear()
            java.util.List r2 = r11._signers
            java.util.Iterator r2 = r2.iterator()
        L_0x001d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003e
            java.lang.Object r3 = r2.next()
            org.spongycastle.cms.SignerInformation r3 = (org.spongycastle.cms.SignerInformation) r3
            org.spongycastle.cms.CMSSignedHelper r4 = org.spongycastle.cms.CMSSignedHelper.INSTANCE
            org.spongycastle.asn1.x509.AlgorithmIdentifier r5 = r3.getDigestAlgorithmID()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r4 = r4.fixAlgID(r5)
            r0.add(r4)
            org.spongycastle.asn1.cms.SignerInfo r3 = r3.toASN1Structure()
            r1.add(r3)
            goto L_0x001d
        L_0x003e:
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r12.getContentType()
            java.lang.Object r3 = r12.getContent()
            r4 = 0
            if (r3 == 0) goto L_0x008a
            if (r13 == 0) goto L_0x0051
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>()
            goto L_0x0052
        L_0x0051:
            r3 = r4
        L_0x0052:
            java.util.List r5 = r11.signerGens
            java.io.OutputStream r5 = org.spongycastle.cms.CMSUtils.attachSignersToOutputStream(r5, r3)
            java.io.OutputStream r5 = org.spongycastle.cms.CMSUtils.getSafeOutputStream(r5)
            r12.write(r5)     // Catch:{ IOException -> 0x006e }
            r5.close()     // Catch:{ IOException -> 0x006e }
            if (r13 == 0) goto L_0x008a
            org.spongycastle.asn1.BEROctetString r13 = new org.spongycastle.asn1.BEROctetString
            byte[] r3 = r3.toByteArray()
            r13.<init>((byte[]) r3)
            goto L_0x008b
        L_0x006e:
            r12 = move-exception
            org.spongycastle.cms.CMSException r13 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "data processing exception: "
            r0.append(r1)
            java.lang.String r1 = r12.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0, r12)
            throw r13
        L_0x008a:
            r13 = r4
        L_0x008b:
            java.util.List r3 = r11.signerGens
            java.util.Iterator r3 = r3.iterator()
        L_0x0091:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00c3
            java.lang.Object r5 = r3.next()
            org.spongycastle.cms.SignerInfoGenerator r5 = (org.spongycastle.cms.SignerInfoGenerator) r5
            org.spongycastle.asn1.cms.SignerInfo r6 = r5.generate(r2)
            org.spongycastle.asn1.x509.AlgorithmIdentifier r7 = r6.getDigestAlgorithm()
            r0.add(r7)
            r1.add(r6)
            byte[] r5 = r5.getCalculatedDigest()
            if (r5 == 0) goto L_0x0091
            java.util.Map r7 = r11.digests
            org.spongycastle.asn1.x509.AlgorithmIdentifier r6 = r6.getDigestAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r6.getAlgorithm()
            java.lang.String r6 = r6.getId()
            r7.put(r6, r5)
            goto L_0x0091
        L_0x00c3:
            java.util.List r3 = r11.certs
            int r3 = r3.size()
            if (r3 == 0) goto L_0x00d3
            java.util.List r3 = r11.certs
            org.spongycastle.asn1.ASN1Set r3 = org.spongycastle.cms.CMSUtils.createBerSetFromList(r3)
            r8 = r3
            goto L_0x00d4
        L_0x00d3:
            r8 = r4
        L_0x00d4:
            java.util.List r3 = r11.crls
            int r3 = r3.size()
            if (r3 == 0) goto L_0x00e2
            java.util.List r3 = r11.crls
            org.spongycastle.asn1.ASN1Set r4 = org.spongycastle.cms.CMSUtils.createBerSetFromList(r3)
        L_0x00e2:
            r9 = r4
            org.spongycastle.asn1.cms.ContentInfo r7 = new org.spongycastle.asn1.cms.ContentInfo
            r7.<init>(r2, r13)
            org.spongycastle.asn1.cms.SignedData r13 = new org.spongycastle.asn1.cms.SignedData
            org.spongycastle.asn1.DERSet r6 = new org.spongycastle.asn1.DERSet
            r6.<init>((org.spongycastle.asn1.ASN1EncodableVector) r0)
            org.spongycastle.asn1.DERSet r10 = new org.spongycastle.asn1.DERSet
            r10.<init>((org.spongycastle.asn1.ASN1EncodableVector) r1)
            r5 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            org.spongycastle.asn1.cms.ContentInfo r0 = new org.spongycastle.asn1.cms.ContentInfo
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = org.spongycastle.asn1.cms.CMSObjectIdentifiers.signedData
            r0.<init>(r1, r13)
            org.spongycastle.cms.CMSSignedData r13 = new org.spongycastle.cms.CMSSignedData
            r13.<init>((org.spongycastle.cms.CMSProcessable) r12, (org.spongycastle.asn1.cms.ContentInfo) r0)
            return r13
        L_0x0105:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "this method can only be used with SignerInfoGenerator"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.CMSSignedDataGenerator.generate(org.spongycastle.cms.CMSTypedData, boolean):org.spongycastle.cms.CMSSignedData");
    }

    public SignerInformationStore generateCounterSigners(SignerInformation signerInformation) throws CMSException {
        return generate(new CMSProcessableByteArray((ASN1ObjectIdentifier) null, signerInformation.getSignature()), false).getSignerInfos();
    }
}
