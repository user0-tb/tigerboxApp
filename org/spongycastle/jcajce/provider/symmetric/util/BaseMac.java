package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.MacSpi;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
import org.spongycastle.jcajce.spec.SkeinParameterSpec;

public class BaseMac extends MacSpi implements PBE {
    private int keySize = CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256;
    private Mac macEngine;
    private int pbeHash = 1;
    private int pbeType = 2;

    protected BaseMac(Mac mac) {
        this.macEngine = mac;
    }

    protected BaseMac(Mac mac, int i, int i2, int i3) {
        this.macEngine = mac;
        this.pbeType = i;
        this.pbeHash = i2;
        this.keySize = i3;
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParameters;
        if (key != null) {
            if (key instanceof BCPBEKey) {
                BCPBEKey bCPBEKey = (BCPBEKey) key;
                if (bCPBEKey.getParam() != null) {
                    cipherParameters = bCPBEKey.getParam();
                } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                    cipherParameters = PBE.C3199Util.makePBEMacParameters(bCPBEKey, algorithmParameterSpec);
                } else {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                cipherParameters = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
            } else if (algorithmParameterSpec instanceof SkeinParameterSpec) {
                cipherParameters = new SkeinParameters.Builder(copyMap(((SkeinParameterSpec) algorithmParameterSpec).getParameters())).setKey(key.getEncoded()).build();
            } else if (algorithmParameterSpec == null) {
                cipherParameters = new KeyParameter(key.getEncoded());
            } else {
                throw new InvalidAlgorithmParameterException("unknown parameter type.");
            }
            this.macEngine.init(cipherParameters);
            return;
        }
        throw new InvalidKeyException("key is null");
    }

    /* access modifiers changed from: protected */
    public int engineGetMacLength() {
        return this.macEngine.getMacSize();
    }

    /* access modifiers changed from: protected */
    public void engineReset() {
        this.macEngine.reset();
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) {
        this.macEngine.update(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.macEngine.update(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal() {
        byte[] bArr = new byte[engineGetMacLength()];
        this.macEngine.doFinal(bArr, 0);
        return bArr;
    }

    private static Hashtable copyMap(Map map) {
        Hashtable hashtable = new Hashtable();
        for (Object next : map.keySet()) {
            hashtable.put(next, map.get(next));
        }
        return hashtable;
    }
}
