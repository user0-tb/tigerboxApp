package androidx.security.crypto;

import android.content.Context;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.streamingaead.StreamingAeadConfig;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

public final class EncryptedFile {
    private static final String KEYSET_ALIAS = "__androidx_security_crypto_encrypted_file_keyset__";
    private static final String KEYSET_PREF_NAME = "__androidx_security_crypto_encrypted_file_pref__";
    final Context mContext;
    final File mFile;
    final String mMasterKeyAlias;
    final StreamingAead mStreamingAead;

    EncryptedFile(File file, String str, StreamingAead streamingAead, Context context) {
        this.mFile = file;
        this.mContext = context;
        this.mMasterKeyAlias = str;
        this.mStreamingAead = streamingAead;
    }

    public enum FileEncryptionScheme {
        AES256_GCM_HKDF_4KB("AES256_GCM_HKDF_4KB");
        
        private final String mKeyTemplateName;

        private FileEncryptionScheme(String str) {
            this.mKeyTemplateName = str;
        }

        /* access modifiers changed from: package-private */
        public KeyTemplate getKeyTemplate() throws GeneralSecurityException {
            return KeyTemplates.get(this.mKeyTemplateName);
        }
    }

    public static final class Builder {
        private static Object sLock = new Object();
        final Context mContext;
        File mFile;
        final FileEncryptionScheme mFileEncryptionScheme;
        String mKeysetAlias = EncryptedFile.KEYSET_ALIAS;
        String mKeysetPrefName = EncryptedFile.KEYSET_PREF_NAME;
        final String mMasterKeyAlias;

        @Deprecated
        public Builder(File file, Context context, String str, FileEncryptionScheme fileEncryptionScheme) {
            this.mFile = file;
            this.mFileEncryptionScheme = fileEncryptionScheme;
            this.mContext = context.getApplicationContext();
            this.mMasterKeyAlias = str;
        }

        public Builder(Context context, File file, MasterKey masterKey, FileEncryptionScheme fileEncryptionScheme) {
            this.mFile = file;
            this.mFileEncryptionScheme = fileEncryptionScheme;
            this.mContext = context.getApplicationContext();
            this.mMasterKeyAlias = masterKey.getKeyAlias();
        }

        public Builder setKeysetPrefName(String str) {
            this.mKeysetPrefName = str;
            return this;
        }

        public Builder setKeysetAlias(String str) {
            this.mKeysetAlias = str;
            return this;
        }

        public EncryptedFile build() throws GeneralSecurityException, IOException {
            AndroidKeysetManager build;
            StreamingAeadConfig.register();
            AndroidKeysetManager.Builder withSharedPref = new AndroidKeysetManager.Builder().withKeyTemplate(this.mFileEncryptionScheme.getKeyTemplate()).withSharedPref(this.mContext, this.mKeysetAlias, this.mKeysetPrefName);
            AndroidKeysetManager.Builder withMasterKeyUri = withSharedPref.withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + this.mMasterKeyAlias);
            synchronized (sLock) {
                build = withMasterKeyUri.build();
            }
            return new EncryptedFile(this.mFile, this.mKeysetAlias, (StreamingAead) build.getKeysetHandle().getPrimitive(StreamingAead.class), this.mContext);
        }
    }

    public FileOutputStream openFileOutput() throws GeneralSecurityException, IOException {
        if (!this.mFile.exists()) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.mFile);
            return new EncryptedFileOutputStream(fileOutputStream.getFD(), this.mStreamingAead.newEncryptingStream(fileOutputStream, this.mFile.getName().getBytes(StandardCharsets.UTF_8)));
        }
        throw new IOException("output file already exists, please use a new file: " + this.mFile.getName());
    }

    public FileInputStream openFileInput() throws GeneralSecurityException, IOException, FileNotFoundException {
        if (this.mFile.exists()) {
            FileInputStream fileInputStream = new FileInputStream(this.mFile);
            return new EncryptedFileInputStream(fileInputStream.getFD(), this.mStreamingAead.newDecryptingStream(fileInputStream, this.mFile.getName().getBytes(StandardCharsets.UTF_8)));
        }
        throw new FileNotFoundException("file doesn't exist: " + this.mFile.getName());
    }

    private static final class EncryptedFileOutputStream extends FileOutputStream {
        private final OutputStream mEncryptedOutputStream;

        EncryptedFileOutputStream(FileDescriptor fileDescriptor, OutputStream outputStream) {
            super(fileDescriptor);
            this.mEncryptedOutputStream = outputStream;
        }

        public void write(byte[] bArr) throws IOException {
            this.mEncryptedOutputStream.write(bArr);
        }

        public void write(int i) throws IOException {
            this.mEncryptedOutputStream.write(i);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mEncryptedOutputStream.write(bArr, i, i2);
        }

        public void close() throws IOException {
            this.mEncryptedOutputStream.close();
        }

        public FileChannel getChannel() {
            throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
        }

        public void flush() throws IOException {
            this.mEncryptedOutputStream.flush();
        }
    }

    private static final class EncryptedFileInputStream extends FileInputStream {
        private final InputStream mEncryptedInputStream;
        private final Object mLock = new Object();

        EncryptedFileInputStream(FileDescriptor fileDescriptor, InputStream inputStream) {
            super(fileDescriptor);
            this.mEncryptedInputStream = inputStream;
        }

        public int read() throws IOException {
            return this.mEncryptedInputStream.read();
        }

        public int read(byte[] bArr) throws IOException {
            return this.mEncryptedInputStream.read(bArr);
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            return this.mEncryptedInputStream.read(bArr, i, i2);
        }

        public long skip(long j) throws IOException {
            return this.mEncryptedInputStream.skip(j);
        }

        public int available() throws IOException {
            return this.mEncryptedInputStream.available();
        }

        public void close() throws IOException {
            this.mEncryptedInputStream.close();
        }

        public FileChannel getChannel() {
            throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
        }

        public void mark(int i) {
            synchronized (this.mLock) {
                this.mEncryptedInputStream.mark(i);
            }
        }

        public void reset() throws IOException {
            synchronized (this.mLock) {
                this.mEncryptedInputStream.reset();
            }
        }

        public boolean markSupported() {
            return this.mEncryptedInputStream.markSupported();
        }
    }
}
