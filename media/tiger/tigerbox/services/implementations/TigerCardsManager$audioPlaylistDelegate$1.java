package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylistDelegate;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/TigerCardsManager$audioPlaylistDelegate$1", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylistDelegate;", "shouldBeginPlayback", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerCardsManager.kt */
public final class TigerCardsManager$audioPlaylistDelegate$1 implements AudioPlaylistDelegate {
    final /* synthetic */ TigerCardsManager this$0;

    TigerCardsManager$audioPlaylistDelegate$1(TigerCardsManager tigerCardsManager) {
        this.this$0 = tigerCardsManager;
    }

    public boolean shouldBeginPlayback() {
        return this.this$0.nfcService.getInsertedCardPayload() != null;
    }
}
