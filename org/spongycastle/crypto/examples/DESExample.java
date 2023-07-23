package org.spongycastle.crypto.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.encoders.Hex;

public class DESExample {
    private PaddedBufferedBlockCipher cipher;
    private boolean encrypt;

    /* renamed from: in */
    private BufferedInputStream f1029in;
    private byte[] key;
    private BufferedOutputStream out;

    public static void main(String[] strArr) {
        String str;
        boolean z = true;
        if (strArr.length < 2) {
            DESExample dESExample = new DESExample();
            PrintStream printStream = System.err;
            printStream.println("Usage: java " + dESExample.getClass().getName() + " infile outfile [keyfile]");
            System.exit(1);
        }
        String str2 = strArr[0];
        String str3 = strArr[1];
        if (strArr.length > 2) {
            str = strArr[2];
            z = false;
        } else {
            str = "deskey.dat";
        }
        new DESExample(str2, str3, str, z).process();
    }

    public DESExample() {
        this.encrypt = true;
        this.cipher = null;
        this.f1029in = null;
        this.out = null;
        this.key = null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        java.lang.System.err.println("Hmmm, no SHA1PRNG, you need the Sun implementation");
        java.lang.System.exit(1);
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b3, code lost:
        r7 = java.lang.System.err;
        r7.println("Could not decryption create key file [" + r9 + "]");
        java.lang.System.exit(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0078 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DESExample(java.lang.String r7, java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r6 = this;
            java.lang.String r0 = "]"
            r6.<init>()
            r1 = 1
            r6.encrypt = r1
            r2 = 0
            r6.cipher = r2
            r6.f1029in = r2
            r6.out = r2
            r6.key = r2
            r6.encrypt = r10
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0020 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0020 }
            r4.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0020 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0020 }
            r6.f1029in = r3     // Catch:{ FileNotFoundException -> 0x0020 }
            goto L_0x003c
        L_0x0020:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Input file not found ["
            r4.append(r5)
            r4.append(r7)
            r4.append(r0)
            java.lang.String r7 = r4.toString()
            r3.println(r7)
            java.lang.System.exit(r1)
        L_0x003c:
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0049 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0049 }
            r3.<init>(r8)     // Catch:{ IOException -> 0x0049 }
            r7.<init>(r3)     // Catch:{ IOException -> 0x0049 }
            r6.out = r7     // Catch:{ IOException -> 0x0049 }
            goto L_0x0065
        L_0x0049:
            java.io.PrintStream r7 = java.lang.System.err
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Output file not created ["
            r3.append(r4)
            r3.append(r8)
            r3.append(r0)
            java.lang.String r8 = r3.toString()
            r7.println(r8)
            java.lang.System.exit(r1)
        L_0x0065:
            r7 = 0
            if (r10 == 0) goto L_0x00d0
            java.security.SecureRandom r8 = new java.security.SecureRandom     // Catch:{ Exception -> 0x0078 }
            r8.<init>()     // Catch:{ Exception -> 0x0078 }
            java.lang.String r10 = "www.bouncycastle.org"
            byte[] r10 = r10.getBytes()     // Catch:{ Exception -> 0x0077 }
            r8.setSeed(r10)     // Catch:{ Exception -> 0x0077 }
            goto L_0x0083
        L_0x0077:
            r2 = r8
        L_0x0078:
            java.io.PrintStream r8 = java.lang.System.err     // Catch:{ IOException -> 0x00b3 }
            java.lang.String r10 = "Hmmm, no SHA1PRNG, you need the Sun implementation"
            r8.println(r10)     // Catch:{ IOException -> 0x00b3 }
            java.lang.System.exit(r1)     // Catch:{ IOException -> 0x00b3 }
            r8 = r2
        L_0x0083:
            org.spongycastle.crypto.KeyGenerationParameters r10 = new org.spongycastle.crypto.KeyGenerationParameters     // Catch:{ IOException -> 0x00b3 }
            r2 = 192(0xc0, float:2.69E-43)
            r10.<init>(r8, r2)     // Catch:{ IOException -> 0x00b3 }
            org.spongycastle.crypto.generators.DESedeKeyGenerator r8 = new org.spongycastle.crypto.generators.DESedeKeyGenerator     // Catch:{ IOException -> 0x00b3 }
            r8.<init>()     // Catch:{ IOException -> 0x00b3 }
            r8.init(r10)     // Catch:{ IOException -> 0x00b3 }
            byte[] r8 = r8.generateKey()     // Catch:{ IOException -> 0x00b3 }
            r6.key = r8     // Catch:{ IOException -> 0x00b3 }
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00b3 }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b3 }
            r10.<init>(r9)     // Catch:{ IOException -> 0x00b3 }
            r8.<init>(r10)     // Catch:{ IOException -> 0x00b3 }
            byte[] r10 = r6.key     // Catch:{ IOException -> 0x00b3 }
            byte[] r10 = org.spongycastle.util.encoders.Hex.encode(r10)     // Catch:{ IOException -> 0x00b3 }
            int r2 = r10.length     // Catch:{ IOException -> 0x00b3 }
            r8.write(r10, r7, r2)     // Catch:{ IOException -> 0x00b3 }
            r8.flush()     // Catch:{ IOException -> 0x00b3 }
            r8.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x0106
        L_0x00b3:
            java.io.PrintStream r7 = java.lang.System.err
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "Could not decryption create key file ["
            r8.append(r10)
            r8.append(r9)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.println(r8)
            java.lang.System.exit(r1)
            goto L_0x0106
        L_0x00d0:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00ea }
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00ea }
            r10.<init>(r9)     // Catch:{ IOException -> 0x00ea }
            r8.<init>(r10)     // Catch:{ IOException -> 0x00ea }
            int r10 = r8.available()     // Catch:{ IOException -> 0x00ea }
            byte[] r2 = new byte[r10]     // Catch:{ IOException -> 0x00ea }
            r8.read(r2, r7, r10)     // Catch:{ IOException -> 0x00ea }
            byte[] r7 = org.spongycastle.util.encoders.Hex.decode((byte[]) r2)     // Catch:{ IOException -> 0x00ea }
            r6.key = r7     // Catch:{ IOException -> 0x00ea }
            goto L_0x0106
        L_0x00ea:
            java.io.PrintStream r7 = java.lang.System.err
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "Decryption key file not found, or not valid ["
            r8.append(r10)
            r8.append(r9)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.println(r8)
            java.lang.System.exit(r1)
        L_0x0106:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.examples.DESExample.<init>(java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    private void process() {
        this.cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new DESedeEngine()));
        if (this.encrypt) {
            performEncrypt(this.key);
        } else {
            performDecrypt(this.key);
        }
        try {
            this.f1029in.close();
            this.out.flush();
            this.out.close();
        } catch (IOException unused) {
        }
    }

    private void performEncrypt(byte[] bArr) {
        this.cipher.init(true, new KeyParameter(bArr));
        byte[] bArr2 = new byte[47];
        byte[] bArr3 = new byte[this.cipher.getOutputSize(47)];
        while (true) {
            try {
                int read = this.f1029in.read(bArr2, 0, 47);
                if (read > 0) {
                    int processBytes = this.cipher.processBytes(bArr2, 0, read, bArr3, 0);
                    if (processBytes > 0) {
                        byte[] encode = Hex.encode(bArr3, 0, processBytes);
                        this.out.write(encode, 0, encode.length);
                        this.out.write(10);
                    }
                } else {
                    try {
                        break;
                    } catch (CryptoException unused) {
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        int doFinal = this.cipher.doFinal(bArr3, 0);
        if (doFinal > 0) {
            byte[] encode2 = Hex.encode(bArr3, 0, doFinal);
            this.out.write(encode2, 0, encode2.length);
            this.out.write(10);
        }
    }

    private void performDecrypt(byte[] bArr) {
        this.cipher.init(false, new KeyParameter(bArr));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f1029in));
        byte[] bArr2 = null;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    byte[] decode = Hex.decode(readLine);
                    bArr2 = new byte[this.cipher.getOutputSize(decode.length)];
                    int processBytes = this.cipher.processBytes(decode, 0, decode.length, bArr2, 0);
                    if (processBytes > 0) {
                        this.out.write(bArr2, 0, processBytes);
                    }
                } else {
                    try {
                        break;
                    } catch (CryptoException unused) {
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        int doFinal = this.cipher.doFinal(bArr2, 0);
        if (doFinal > 0) {
            this.out.write(bArr2, 0, doFinal);
        }
    }
}
