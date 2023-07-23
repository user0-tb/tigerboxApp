package org.spongycastle.cert.ocsp;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.ocsp.OCSPRequest;
import org.spongycastle.asn1.ocsp.Request;
import org.spongycastle.asn1.ocsp.Signature;
import org.spongycastle.asn1.ocsp.TBSRequest;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.operator.ContentSigner;

public class OCSPReqBuilder {
    private List list = new ArrayList();
    private Extensions requestExtensions = null;
    private GeneralName requestorName = null;

    private class RequestObject {
        CertificateID certId;
        Extensions extensions;

        public RequestObject(CertificateID certificateID, Extensions extensions2) {
            this.certId = certificateID;
            this.extensions = extensions2;
        }

        public Request toRequest() throws Exception {
            return new Request(this.certId.toASN1Object(), this.extensions);
        }
    }

    public OCSPReqBuilder addRequest(CertificateID certificateID) {
        this.list.add(new RequestObject(certificateID, (Extensions) null));
        return this;
    }

    public OCSPReqBuilder addRequest(CertificateID certificateID, Extensions extensions) {
        this.list.add(new RequestObject(certificateID, extensions));
        return this;
    }

    public OCSPReqBuilder setRequestorName(X500Name x500Name) {
        this.requestorName = new GeneralName(4, (ASN1Encodable) x500Name);
        return this;
    }

    public OCSPReqBuilder setRequestorName(GeneralName generalName) {
        this.requestorName = generalName;
        return this;
    }

    public OCSPReqBuilder setRequestExtensions(Extensions extensions) {
        this.requestExtensions = extensions;
        return this;
    }

    private OCSPReq generateRequest(ContentSigner contentSigner, X509CertificateHolder[] x509CertificateHolderArr) throws OCSPException {
        Signature signature;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (RequestObject request : this.list) {
            try {
                aSN1EncodableVector.add(request.toRequest());
            } catch (Exception e) {
                throw new OCSPException("exception creating Request", e);
            }
        }
        TBSRequest tBSRequest = new TBSRequest(this.requestorName, (ASN1Sequence) new DERSequence(aSN1EncodableVector), this.requestExtensions);
        Signature signature2 = null;
        if (contentSigner != null) {
            if (this.requestorName != null) {
                try {
                    OutputStream outputStream = contentSigner.getOutputStream();
                    outputStream.write(tBSRequest.getEncoded(ASN1Encoding.DER));
                    outputStream.close();
                    DERBitString dERBitString = new DERBitString(contentSigner.getSignature());
                    AlgorithmIdentifier algorithmIdentifier = contentSigner.getAlgorithmIdentifier();
                    if (x509CertificateHolderArr == null || x509CertificateHolderArr.length <= 0) {
                        signature = new Signature(algorithmIdentifier, dERBitString);
                    } else {
                        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                        for (int i = 0; i != x509CertificateHolderArr.length; i++) {
                            aSN1EncodableVector2.add(x509CertificateHolderArr[i].toASN1Structure());
                        }
                        signature = new Signature(algorithmIdentifier, dERBitString, new DERSequence(aSN1EncodableVector2));
                    }
                    signature2 = signature;
                } catch (Exception e2) {
                    throw new OCSPException("exception processing TBSRequest: " + e2, e2);
                }
            } else {
                throw new OCSPException("requestorName must be specified if request is signed.");
            }
        }
        return new OCSPReq(new OCSPRequest(tBSRequest, signature2));
    }

    public OCSPReq build() throws OCSPException {
        return generateRequest((ContentSigner) null, (X509CertificateHolder[]) null);
    }

    public OCSPReq build(ContentSigner contentSigner, X509CertificateHolder[] x509CertificateHolderArr) throws OCSPException, IllegalArgumentException {
        if (contentSigner != null) {
            return generateRequest(contentSigner, x509CertificateHolderArr);
        }
        throw new IllegalArgumentException("no signer specified");
    }
}
