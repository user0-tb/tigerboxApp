package org.spongycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BERSet;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cms.AuthenticatedData;
import org.spongycastle.asn1.cms.CMSObjectIdentifiers;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.operator.DigestCalculator;
import org.spongycastle.operator.DigestCalculatorProvider;
import org.spongycastle.operator.MacCalculator;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.util.p033io.TeeOutputStream;

public class CMSAuthenticatedDataGenerator extends CMSAuthenticatedGenerator {
    public CMSAuthenticatedData generate(CMSTypedData cMSTypedData, MacCalculator macCalculator) throws CMSException {
        return generate(cMSTypedData, macCalculator, (DigestCalculator) null);
    }

    public CMSAuthenticatedData generate(CMSTypedData cMSTypedData, MacCalculator macCalculator, DigestCalculator digestCalculator) throws CMSException {
        AuthenticatedData authenticatedData;
        CMSTypedData cMSTypedData2 = cMSTypedData;
        final DigestCalculator digestCalculator2 = digestCalculator;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (RecipientInfoGenerator generate : this.recipientInfoGenerators) {
            aSN1EncodableVector.add(generate.generate(macCalculator.getKey()));
        }
        BERSet bERSet = null;
        if (digestCalculator2 != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                TeeOutputStream teeOutputStream = new TeeOutputStream(digestCalculator.getOutputStream(), byteArrayOutputStream);
                cMSTypedData2.write(teeOutputStream);
                teeOutputStream.close();
                BEROctetString bEROctetString = new BEROctetString(byteArrayOutputStream.toByteArray());
                Map baseParameters = getBaseParameters(cMSTypedData.getContentType(), digestCalculator.getAlgorithmIdentifier(), digestCalculator.getDigest());
                if (this.authGen == null) {
                    this.authGen = new DefaultAuthenticatedAttributeTableGenerator();
                }
                DERSet dERSet = new DERSet(this.authGen.getAttributes(Collections.unmodifiableMap(baseParameters)).toASN1EncodableVector());
                try {
                    OutputStream outputStream = macCalculator.getOutputStream();
                    outputStream.write(dERSet.getEncoded(ASN1Encoding.DER));
                    outputStream.close();
                    DEROctetString dEROctetString = new DEROctetString(macCalculator.getMac());
                    if (this.unauthGen != null) {
                        bERSet = new BERSet(this.unauthGen.getAttributes(Collections.unmodifiableMap(baseParameters)).toASN1EncodableVector());
                    }
                    ContentInfo contentInfo = new ContentInfo(CMSObjectIdentifiers.data, bEROctetString);
                    authenticatedData = new AuthenticatedData(this.originatorInfo, new DERSet(aSN1EncodableVector), macCalculator.getAlgorithmIdentifier(), digestCalculator.getAlgorithmIdentifier(), contentInfo, dERSet, dEROctetString, bERSet);
                } catch (IOException e) {
                    throw new CMSException("exception decoding algorithm parameters.", e);
                }
            } catch (IOException e2) {
                throw new CMSException("unable to perform digest calculation: " + e2.getMessage(), e2);
            }
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                TeeOutputStream teeOutputStream2 = new TeeOutputStream(byteArrayOutputStream2, macCalculator.getOutputStream());
                cMSTypedData2.write(teeOutputStream2);
                teeOutputStream2.close();
                BEROctetString bEROctetString2 = new BEROctetString(byteArrayOutputStream2.toByteArray());
                DEROctetString dEROctetString2 = new DEROctetString(macCalculator.getMac());
                if (this.unauthGen != null) {
                    bERSet = new BERSet(this.unauthGen.getAttributes(new HashMap()).toASN1EncodableVector());
                }
                ContentInfo contentInfo2 = new ContentInfo(CMSObjectIdentifiers.data, bEROctetString2);
                authenticatedData = new AuthenticatedData(this.originatorInfo, new DERSet(aSN1EncodableVector), macCalculator.getAlgorithmIdentifier(), (AlgorithmIdentifier) null, contentInfo2, (ASN1Set) null, dEROctetString2, bERSet);
            } catch (IOException e3) {
                throw new CMSException("exception decoding algorithm parameters.", e3);
            }
        }
        return new CMSAuthenticatedData(new ContentInfo(CMSObjectIdentifiers.authenticatedData, authenticatedData), (DigestCalculatorProvider) new DigestCalculatorProvider() {
            public DigestCalculator get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
                return digestCalculator2;
            }
        });
    }
}
