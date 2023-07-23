package media.tiger.tigerbox.services.interfaces.audioPlayer;

import java.util.ArrayList;
import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;

@Metadata(mo33736d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006#"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "", "duration", "", "getDuration", "()J", "nfcPayload", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "getNfcPayload", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "product", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "getProduct", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "setProduct", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;)V", "shouldResumePlayback", "", "getShouldResumePlayback", "()Z", "setShouldResumePlayback", "(Z)V", "tracks", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioTrackModel;", "Lkotlin/collections/ArrayList;", "getTracks", "()Ljava/util/ArrayList;", "durationOf", "trackIndex", "", "durationTo", "updateDuration", "", "durationSec", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioItem.kt */
public interface AudioItem {
    long durationOf(int i);

    long durationTo(int i);

    long getDuration();

    TigerCardDomain getNfcPayload();

    AudioProductInfo getProduct();

    boolean getShouldResumePlayback();

    ArrayList<AudioTrackModel> getTracks();

    void setProduct(AudioProductInfo audioProductInfo);

    void setShouldResumePlayback(boolean z);

    void updateDuration(int i, long j);
}
