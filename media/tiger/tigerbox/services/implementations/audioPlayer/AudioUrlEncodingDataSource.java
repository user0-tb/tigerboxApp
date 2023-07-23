package media.tiger.tigerbox.services.implementations.audioPlayer;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.utils.FileUtilsKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioUrlEncodingDataSource;", "Lcom/google/android/exoplayer2/upstream/DataSource;", "defaultDataSource", "(Lcom/google/android/exoplayer2/upstream/DataSource;)V", "addTransferListener", "", "transferListener", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "close", "getUri", "Landroid/net/Uri;", "open", "", "dataSpecORIG", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "read", "", "buffer", "", "offset", "readLength", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioUrlEncodingDataSource.kt */
public final class AudioUrlEncodingDataSource implements DataSource {
    private final DataSource defaultDataSource;

    public /* synthetic */ Map getResponseHeaders() {
        return DataSource.CC.$default$getResponseHeaders(this);
    }

    public AudioUrlEncodingDataSource(DataSource dataSource) {
        this.defaultDataSource = dataSource;
    }

    public long open(DataSpec dataSpec) throws IOException {
        Intrinsics.checkNotNullParameter(dataSpec, "dataSpecORIG");
        try {
            String uri = dataSpec.uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "dataSpecORIG.uri.toString()");
            String encode = URLEncoder.encode(URLDecoder.decode(FileUtilsKt.lastPathComponent(uri), "utf-8"), "utf-8");
            String removingLastPathComponent = FileUtilsKt.removingLastPathComponent(uri);
            Intrinsics.checkNotNullExpressionValue(encode, "lastPathEncoded");
            String appendingPathComponent = FileUtilsKt.appendingPathComponent(removingLastPathComponent, encode);
            DataSpec.Builder builder = new DataSpec.Builder();
            builder.setUri(Uri.parse(appendingPathComponent));
            DataSpec build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "builderSpec.build()");
            DataSource dataSource = this.defaultDataSource;
            Intrinsics.checkNotNull(dataSource);
            return dataSource.open(build);
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("AudioUrlEncodingDataSource: Exception " + e, new Object[0]);
            return 0;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        DataSource dataSource = this.defaultDataSource;
        Intrinsics.checkNotNull(dataSource);
        return dataSource.read(bArr, i, i2);
    }

    public Uri getUri() {
        DataSource dataSource = this.defaultDataSource;
        Intrinsics.checkNotNull(dataSource);
        return dataSource.getUri();
    }

    public void close() throws IOException {
        DataSource dataSource = this.defaultDataSource;
        Intrinsics.checkNotNull(dataSource);
        dataSource.close();
    }

    public void addTransferListener(TransferListener transferListener) {
        Intrinsics.checkNotNullParameter(transferListener, "transferListener");
        DataSource dataSource = this.defaultDataSource;
        Intrinsics.checkNotNull(dataSource);
        dataSource.addTransferListener(transferListener);
    }
}
