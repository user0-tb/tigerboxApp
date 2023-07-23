package media.tiger.tigerbox.services.implementations.audioPlayer;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.audioPlayer.HlsKeyProviderService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0016J \u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioHlsDataSource;", "Lcom/google/android/exoplayer2/upstream/DataSource;", "hlsService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;", "nfcInfo", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;)V", "mBytesRead", "", "mCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "mDataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "mKeyfileBytes", "", "mKeyfileError", "", "addTransferListener", "", "transferListener", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "close", "finishedLoadingData", "bytes", "getUri", "Landroid/net/Uri;", "open", "", "dataSpec", "read", "buffer", "offset", "readLength", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioHlsDataSource.kt */
public final class AudioHlsDataSource implements DataSource {
    /* access modifiers changed from: private */
    public final HlsKeyProviderService hlsService;
    private int mBytesRead;
    private CountDownLatch mCountDownLatch;
    private DataSpec mDataSpec;
    private byte[] mKeyfileBytes;
    private boolean mKeyfileError;
    /* access modifiers changed from: private */
    public final TigerCardDomain nfcInfo;

    public void addTransferListener(TransferListener transferListener) {
        Intrinsics.checkNotNullParameter(transferListener, "transferListener");
    }

    public /* synthetic */ Map getResponseHeaders() {
        return DataSource.CC.$default$getResponseHeaders(this);
    }

    public AudioHlsDataSource(HlsKeyProviderService hlsKeyProviderService, TigerCardDomain tigerCardDomain) {
        Intrinsics.checkNotNullParameter(hlsKeyProviderService, "hlsService");
        this.hlsService = hlsKeyProviderService;
        this.nfcInfo = tigerCardDomain;
    }

    public long open(DataSpec dataSpec) throws IOException {
        Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
        this.mDataSpec = dataSpec;
        this.mKeyfileError = false;
        this.mCountDownLatch = new CountDownLatch(1);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AudioHlsDataSource$open$1(this, dataSpec, (Continuation<? super AudioHlsDataSource$open$1>) null), 3, (Object) null);
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        try {
            CountDownLatch countDownLatch = this.mCountDownLatch;
            Intrinsics.checkNotNull(countDownLatch);
            countDownLatch.await();
            if (!this.mKeyfileError) {
                byte[] bArr2 = this.mKeyfileBytes;
                Intrinsics.checkNotNull(bArr2);
                int min = Math.min(i2, bArr2.length - this.mBytesRead);
                byte[] bArr3 = this.mKeyfileBytes;
                Intrinsics.checkNotNull(bArr3);
                System.arraycopy(bArr3, this.mBytesRead, bArr, i, min);
                int i3 = this.mBytesRead;
                byte[] bArr4 = this.mKeyfileBytes;
                Intrinsics.checkNotNull(bArr4);
                int i4 = i3 >= bArr4.length ? -1 : min;
                this.mBytesRead += min;
                return i4;
            }
            Timber.Forest.mo50217e("AudioHlsDataSource: Error in Keyfile Request", new Object[0]);
            throw new IOException("Error in Keyfile Request");
        } catch (InterruptedException e) {
            Timber.Forest.mo50217e("AudioHlsDataSource: exception " + e, new Object[0]);
            throw new IOException(e);
        }
    }

    public Uri getUri() {
        DataSpec dataSpec = this.mDataSpec;
        if (dataSpec == null) {
            return null;
        }
        Intrinsics.checkNotNull(dataSpec);
        return dataSpec.uri;
    }

    /* access modifiers changed from: private */
    public final void finishedLoadingData(byte[] bArr) {
        this.mKeyfileBytes = bArr;
        boolean z = false;
        this.mBytesRead = 0;
        if (bArr == null) {
            z = true;
        }
        this.mKeyfileError = z;
        CountDownLatch countDownLatch = this.mCountDownLatch;
        Intrinsics.checkNotNull(countDownLatch);
        countDownLatch.countDown();
    }

    public void close() throws IOException {
        this.mDataSpec = null;
    }
}
