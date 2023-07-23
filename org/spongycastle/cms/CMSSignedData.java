package org.spongycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.cms.SignedData;
import org.spongycastle.asn1.cms.SignerInfo;
import org.spongycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.util.Store;

public class CMSSignedData {
    private static final CMSSignedHelper HELPER = CMSSignedHelper.INSTANCE;
    ContentInfo contentInfo;
    private Map hashes;
    CMSTypedData signedContent;
    SignedData signedData;
    SignerInformationStore signerInfoStore;

    private CMSSignedData(CMSSignedData cMSSignedData) {
        this.signedData = cMSSignedData.signedData;
        this.contentInfo = cMSSignedData.contentInfo;
        this.signedContent = cMSSignedData.signedContent;
        this.signerInfoStore = cMSSignedData.signerInfoStore;
    }

    public CMSSignedData(byte[] bArr) throws CMSException {
        this(CMSUtils.readContentInfo(bArr));
    }

    public CMSSignedData(CMSProcessable cMSProcessable, byte[] bArr) throws CMSException {
        this(cMSProcessable, CMSUtils.readContentInfo(bArr));
    }

    public CMSSignedData(Map map, byte[] bArr) throws CMSException {
        this(map, CMSUtils.readContentInfo(bArr));
    }

    public CMSSignedData(CMSProcessable cMSProcessable, InputStream inputStream) throws CMSException {
        this(cMSProcessable, CMSUtils.readContentInfo((InputStream) new ASN1InputStream(inputStream)));
    }

    public CMSSignedData(InputStream inputStream) throws CMSException {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public CMSSignedData(final CMSProcessable cMSProcessable, ContentInfo contentInfo2) throws CMSException {
        if (cMSProcessable instanceof CMSTypedData) {
            this.signedContent = (CMSTypedData) cMSProcessable;
        } else {
            this.signedContent = new CMSTypedData() {
                public ASN1ObjectIdentifier getContentType() {
                    return CMSSignedData.this.signedData.getEncapContentInfo().getContentType();
                }

                public void write(OutputStream outputStream) throws IOException, CMSException {
                    cMSProcessable.write(outputStream);
                }

                public Object getContent() {
                    return cMSProcessable.getContent();
                }
            };
        }
        this.contentInfo = contentInfo2;
        this.signedData = getSignedData();
    }

    public CMSSignedData(Map map, ContentInfo contentInfo2) throws CMSException {
        this.hashes = map;
        this.contentInfo = contentInfo2;
        this.signedData = getSignedData();
    }

    public CMSSignedData(ContentInfo contentInfo2) throws CMSException {
        this.contentInfo = contentInfo2;
        SignedData signedData2 = getSignedData();
        this.signedData = signedData2;
        if (signedData2.getEncapContentInfo().getContent() != null) {
            this.signedContent = new CMSProcessableByteArray(this.signedData.getEncapContentInfo().getContentType(), ((ASN1OctetString) this.signedData.getEncapContentInfo().getContent()).getOctets());
        } else {
            this.signedContent = null;
        }
    }

    private SignedData getSignedData() throws CMSException {
        try {
            return SignedData.getInstance(this.contentInfo.getContent());
        } catch (ClassCastException e) {
            throw new CMSException("Malformed content.", e);
        } catch (IllegalArgumentException e2) {
            throw new CMSException("Malformed content.", e2);
        }
    }

    public int getVersion() {
        return this.signedData.getVersion().getValue().intValue();
    }

    public SignerInformationStore getSignerInfos() {
        Object obj;
        Map map;
        if (this.signerInfoStore == null) {
            ASN1Set signerInfos = this.signedData.getSignerInfos();
            ArrayList arrayList = new ArrayList();
            new DefaultSignatureAlgorithmIdentifierFinder();
            for (int i = 0; i != signerInfos.size(); i++) {
                SignerInfo instance = SignerInfo.getInstance(signerInfos.getObjectAt(i));
                ASN1ObjectIdentifier contentType = this.signedData.getEncapContentInfo().getContentType();
                Map map2 = this.hashes;
                if (map2 == null) {
                    arrayList.add(new SignerInformation(instance, contentType, this.signedContent, (byte[]) null));
                } else {
                    if (map2.keySet().iterator().next() instanceof String) {
                        map = this.hashes;
                        obj = instance.getDigestAlgorithm().getAlgorithm().getId();
                    } else {
                        map = this.hashes;
                        obj = instance.getDigestAlgorithm().getAlgorithm();
                    }
                    arrayList.add(new SignerInformation(instance, contentType, (CMSProcessable) null, (byte[]) map.get(obj)));
                }
            }
            this.signerInfoStore = new SignerInformationStore(arrayList);
        }
        return this.signerInfoStore;
    }

    public Store getCertificates() {
        return HELPER.getCertificates(this.signedData.getCertificates());
    }

    public Store getCRLs() {
        return HELPER.getCRLs(this.signedData.getCRLs());
    }

    public Store getAttributeCertificates() {
        return HELPER.getAttributeCertificates(this.signedData.getCertificates());
    }

    public Store getOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return HELPER.getOtherRevocationInfo(aSN1ObjectIdentifier, this.signedData.getCRLs());
    }

    public String getSignedContentTypeOID() {
        return this.signedData.getEncapContentInfo().getContentType().getId();
    }

    public CMSTypedData getSignedContent() {
        return this.signedContent;
    }

    public ContentInfo toASN1Structure() {
        return this.contentInfo;
    }

    public byte[] getEncoded() throws IOException {
        return this.contentInfo.getEncoded();
    }

    public boolean verifySignatures(SignerInformationVerifierProvider signerInformationVerifierProvider) throws CMSException {
        return verifySignatures(signerInformationVerifierProvider, false);
    }

    public boolean verifySignatures(SignerInformationVerifierProvider signerInformationVerifierProvider, boolean z) throws CMSException {
        for (SignerInformation signerInformation : getSignerInfos().getSigners()) {
            try {
                if (!signerInformation.verify(signerInformationVerifierProvider.get(signerInformation.getSID()))) {
                    return false;
                }
                if (!z) {
                    for (SignerInformation verify : signerInformation.getCounterSignatures().getSigners()) {
                        if (!verify.verify(signerInformationVerifierProvider.get(signerInformation.getSID()))) {
                            return false;
                        }
                    }
                    continue;
                }
            } catch (OperatorCreationException e) {
                throw new CMSException("failure in verifier provider: " + e.getMessage(), e);
            }
        }
        return true;
    }

    public static CMSSignedData replaceSigners(CMSSignedData cMSSignedData, SignerInformationStore signerInformationStore) {
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        cMSSignedData2.signerInfoStore = signerInformationStore;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (SignerInformation signerInformation : signerInformationStore.getSigners()) {
            aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(signerInformation.getDigestAlgorithmID()));
            aSN1EncodableVector2.add(signerInformation.toASN1Structure());
        }
        DERSet dERSet = new DERSet(aSN1EncodableVector);
        DERSet dERSet2 = new DERSet(aSN1EncodableVector2);
        ASN1Sequence aSN1Sequence = (ASN1Sequence) cMSSignedData.signedData.toASN1Primitive();
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        aSN1EncodableVector3.add(aSN1Sequence.getObjectAt(0));
        aSN1EncodableVector3.add(dERSet);
        for (int i = 2; i != aSN1Sequence.size() - 1; i++) {
            aSN1EncodableVector3.add(aSN1Sequence.getObjectAt(i));
        }
        aSN1EncodableVector3.add(dERSet2);
        cMSSignedData2.signedData = SignedData.getInstance(new BERSequence(aSN1EncodableVector3));
        cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
        return cMSSignedData2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.spongycastle.cms.CMSSignedData replaceCertificatesAndCRLs(org.spongycastle.cms.CMSSignedData r8, org.spongycastle.util.Store r9, org.spongycastle.util.Store r10, org.spongycastle.util.Store r11) throws org.spongycastle.cms.CMSException {
        /*
            org.spongycastle.cms.CMSSignedData r0 = new org.spongycastle.cms.CMSSignedData
            r0.<init>((org.spongycastle.cms.CMSSignedData) r8)
            r1 = 0
            if (r9 != 0) goto L_0x000a
            if (r10 == 0) goto L_0x002d
        L_0x000a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r9 == 0) goto L_0x0018
            java.util.List r9 = org.spongycastle.cms.CMSUtils.getCertificatesFromStore(r9)
            r2.addAll(r9)
        L_0x0018:
            if (r10 == 0) goto L_0x0021
            java.util.List r9 = org.spongycastle.cms.CMSUtils.getAttributeCertificatesFromStore(r10)
            r2.addAll(r9)
        L_0x0021:
            org.spongycastle.asn1.ASN1Set r9 = org.spongycastle.cms.CMSUtils.createBerSetFromList(r2)
            int r10 = r9.size()
            if (r10 == 0) goto L_0x002d
            r5 = r9
            goto L_0x002e
        L_0x002d:
            r5 = r1
        L_0x002e:
            if (r11 == 0) goto L_0x0040
            java.util.List r9 = org.spongycastle.cms.CMSUtils.getCRLsFromStore(r11)
            org.spongycastle.asn1.ASN1Set r9 = org.spongycastle.cms.CMSUtils.createBerSetFromList(r9)
            int r10 = r9.size()
            if (r10 == 0) goto L_0x0040
            r6 = r9
            goto L_0x0041
        L_0x0040:
            r6 = r1
        L_0x0041:
            org.spongycastle.asn1.cms.SignedData r9 = new org.spongycastle.asn1.cms.SignedData
            org.spongycastle.asn1.cms.SignedData r10 = r8.signedData
            org.spongycastle.asn1.ASN1Set r3 = r10.getDigestAlgorithms()
            org.spongycastle.asn1.cms.SignedData r10 = r8.signedData
            org.spongycastle.asn1.cms.ContentInfo r4 = r10.getEncapContentInfo()
            org.spongycastle.asn1.cms.SignedData r8 = r8.signedData
            org.spongycastle.asn1.ASN1Set r7 = r8.getSignerInfos()
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            r0.signedData = r9
            org.spongycastle.asn1.cms.ContentInfo r8 = new org.spongycastle.asn1.cms.ContentInfo
            org.spongycastle.asn1.cms.ContentInfo r9 = r0.contentInfo
            org.spongycastle.asn1.ASN1ObjectIdentifier r9 = r9.getContentType()
            org.spongycastle.asn1.cms.SignedData r10 = r0.signedData
            r8.<init>(r9, r10)
            r0.contentInfo = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.CMSSignedData.replaceCertificatesAndCRLs(org.spongycastle.cms.CMSSignedData, org.spongycastle.util.Store, org.spongycastle.util.Store, org.spongycastle.util.Store):org.spongycastle.cms.CMSSignedData");
    }
}
