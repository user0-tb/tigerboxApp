package media.tiger.tigerbox.services.implementations.audioPlayer;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "Lcom/google/android/exoplayer2/ExoPlayer;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlayer.kt */
final class AudioPlayer$mExoPlayer$2 extends Lambda implements Function0<ExoPlayer> {
    final /* synthetic */ AudioPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AudioPlayer$mExoPlayer$2(AudioPlayer audioPlayer) {
        super(0);
        this.this$0 = audioPlayer;
    }

    public final ExoPlayer invoke() {
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(this.this$0.context);
        OkHttpDataSource.Factory factory = new OkHttpDataSource.Factory(new OkHttpClient.Builder().build());
        ExoPlayer.Builder builder = new ExoPlayer.Builder(this.this$0.context, (RenderersFactory) defaultRenderersFactory);
        builder.setMediaSourceFactory(new DefaultMediaSourceFactory((DataSource.Factory) factory));
        builder.setHandleAudioBecomingNoisy(true);
        ExoPlayer build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "exoBuilder.build()");
        build.setWakeMode(2);
        build.addListener(this.this$0.exoListener);
        return build;
    }
}
