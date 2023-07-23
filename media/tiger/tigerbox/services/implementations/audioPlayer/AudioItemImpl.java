package media.tiger.tigerbox.services.implementations.audioPlayer;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p013io.FilesKt;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel;

@Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\fH\u0016R\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioItemImpl;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "product", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "nfcPayload", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "tracks", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioTrackModel;", "Lkotlin/collections/ArrayList;", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;Ljava/util/ArrayList;)V", "duration", "", "getDuration", "()J", "getNfcPayload", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "getProduct", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "setProduct", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;)V", "shouldResumePlayback", "", "getShouldResumePlayback", "()Z", "setShouldResumePlayback", "(Z)V", "getTracks", "()Ljava/util/ArrayList;", "durationOf", "trackIndex", "", "durationTo", "updateDuration", "", "durationSec", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioItemImpl.kt */
public class AudioItemImpl implements AudioItem {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTINF_TAG = "#EXTINF:";
    public static final String EXT_X_KEY = "EXT-X-KEY:";
    public static final String EXT_X_STREAM_INF = "EXT-X-STREAM-INF:";
    public static final String KEY_URI_BEGIN = "URI=\"";
    public static final String KEY_URI_END = "\",";
    private final TigerCardDomain nfcPayload;
    private AudioProductInfo product;
    private boolean shouldResumePlayback;
    private final ArrayList<AudioTrackModel> tracks;

    public /* synthetic */ AudioItemImpl(AudioProductInfo audioProductInfo, TigerCardDomain tigerCardDomain, ArrayList arrayList, DefaultConstructorMarker defaultConstructorMarker) {
        this(audioProductInfo, tigerCardDomain, arrayList);
    }

    private AudioItemImpl(AudioProductInfo audioProductInfo, TigerCardDomain tigerCardDomain, ArrayList<AudioTrackModel> arrayList) {
        this.product = audioProductInfo;
        this.nfcPayload = tigerCardDomain;
        this.tracks = arrayList;
        this.shouldResumePlayback = true;
    }

    public AudioProductInfo getProduct() {
        return this.product;
    }

    public void setProduct(AudioProductInfo audioProductInfo) {
        Intrinsics.checkNotNullParameter(audioProductInfo, "<set-?>");
        this.product = audioProductInfo;
    }

    public TigerCardDomain getNfcPayload() {
        return this.nfcPayload;
    }

    public ArrayList<AudioTrackModel> getTracks() {
        return this.tracks;
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioItemImpl$Companion;", "", "()V", "EXTINF_TAG", "", "EXT_X_KEY", "EXT_X_STREAM_INF", "KEY_URI_BEGIN", "KEY_URI_END", "create", "Lmedia/tiger/tigerbox/services/implementations/audioPlayer/AudioItemImpl;", "info", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "nfcInfo", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AudioItemImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AudioItemImpl create(AudioProductInfo audioProductInfo, TigerCardDomain tigerCardDomain) {
            Intrinsics.checkNotNullParameter(audioProductInfo, "info");
            File file = new File(audioProductInfo.getHlsPath());
            ArrayList arrayList = new ArrayList();
            if (!file.exists()) {
                return new AudioItemImpl(audioProductInfo, tigerCardDomain, arrayList, (DefaultConstructorMarker) null);
            }
            String substringBeforeLast$default = StringsKt.substringBeforeLast$default(audioProductInfo.getHlsPath(), DownloadsManager.FOLDERS_SEPARATOR, (String) null, 2, (Object) null);
            Ref.LongRef longRef = new Ref.LongRef();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            FilesKt.forEachLine$default(file, (Charset) null, new AudioItemImpl$Companion$create$1(new Ref.BooleanRef(), substringBeforeLast$default, arrayList, objectRef, longRef), 1, (Object) null);
            return new AudioItemImpl(audioProductInfo, tigerCardDomain, arrayList, (DefaultConstructorMarker) null);
        }
    }

    public long getDuration() {
        Iterator<AudioTrackModel> it = getTracks().iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().getDuration();
        }
        return j;
    }

    public void updateDuration(int i, long j) {
        if (i >= 0 && i < getTracks().size() && getTracks().get(i).getDuration() != j) {
            ArrayList<AudioTrackModel> tracks2 = getTracks();
            AudioTrackModel audioTrackModel = getTracks().get(i);
            Intrinsics.checkNotNullExpressionValue(audioTrackModel, "tracks[trackIndex]");
            tracks2.set(i, AudioTrackModel.copy$default(audioTrackModel, (String) null, j, (String) null, (String) null, 13, (Object) null));
        }
    }

    public long durationTo(int i) {
        int min = Math.min(Math.max(0, i), getTracks().size() - 1);
        long j = 0;
        for (int i2 = 0; i2 < min; i2++) {
            j += getTracks().get(i2).getDuration();
        }
        return j;
    }

    public long durationOf(int i) {
        if (i < 0 || i >= getTracks().size()) {
            return -1;
        }
        return getTracks().get(i).getDuration();
    }

    public boolean getShouldResumePlayback() {
        return this.shouldResumePlayback;
    }

    public void setShouldResumePlayback(boolean z) {
        this.shouldResumePlayback = z;
    }
}
