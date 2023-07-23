package media.tiger.tigerbox.services.implementations;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: InfoSoundPlayer.kt */
final class InfoSoundPlayer$exoPlayer$2 extends Lambda implements Function0<SimpleExoPlayer> {
    final /* synthetic */ InfoSoundPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfoSoundPlayer$exoPlayer$2(InfoSoundPlayer infoSoundPlayer) {
        super(0);
        this.this$0 = infoSoundPlayer;
    }

    public final SimpleExoPlayer invoke() {
        SimpleExoPlayer build = new SimpleExoPlayer.Builder(this.this$0.context, (RenderersFactory) new DefaultRenderersFactory(this.this$0.context)).setHandleAudioBecomingNoisy(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(context, rendere…rue)\n            .build()");
        return build;
    }
}
