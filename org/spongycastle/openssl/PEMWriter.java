package org.spongycastle.openssl;

import java.io.IOException;
import java.io.Writer;
import org.spongycastle.openssl.jcajce.JcaMiscPEMGenerator;
import org.spongycastle.util.p033io.pem.PemGenerationException;
import org.spongycastle.util.p033io.pem.PemObjectGenerator;
import org.spongycastle.util.p033io.pem.PemWriter;

public class PEMWriter extends PemWriter {
    public PEMWriter(Writer writer) {
        super(writer);
    }

    public void writeObject(Object obj) throws IOException {
        writeObject(obj, (PEMEncryptor) null);
    }

    public void writeObject(Object obj, PEMEncryptor pEMEncryptor) throws IOException {
        try {
            super.writeObject(new JcaMiscPEMGenerator(obj, pEMEncryptor));
        } catch (PemGenerationException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    public void writeObject(PemObjectGenerator pemObjectGenerator) throws IOException {
        super.writeObject(pemObjectGenerator);
    }
}
