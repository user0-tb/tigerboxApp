package media.tiger.tigerbox.services.interfaces.audioPlayer;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.webserver.dto.PlaybackDto;

@Metadata(mo33736d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylist;", "", "products", "", "Lmedia/tiger/tigerbox/webserver/dto/PlaybackDto;", "activeIdx", "", "reason", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackReason;", "nfc", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "(Ljava/util/List;ILmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackReason;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;)V", "getActiveIdx", "()I", "setActiveIdx", "(I)V", "delegate", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylistDelegate;", "getDelegate", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylistDelegate;", "setDelegate", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylistDelegate;)V", "getNfc", "()Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "getProducts", "()Ljava/util/List;", "getReason", "()Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackReason;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlaylist.kt */
public class AudioPlaylist {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int activeIdx;
    private AudioPlaylistDelegate delegate;
    private final TigerCardDomain nfc;
    private final List<PlaybackDto> products;
    private final AudioPlaybackReason reason;

    public /* synthetic */ AudioPlaylist(List list, int i, AudioPlaybackReason audioPlaybackReason, TigerCardDomain tigerCardDomain, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, audioPlaybackReason, tigerCardDomain);
    }

    private AudioPlaylist(List<PlaybackDto> list, int i, AudioPlaybackReason audioPlaybackReason, TigerCardDomain tigerCardDomain) {
        this.products = list;
        this.activeIdx = i;
        this.reason = audioPlaybackReason;
        this.nfc = tigerCardDomain;
    }

    public final List<PlaybackDto> getProducts() {
        return this.products;
    }

    public final int getActiveIdx() {
        return this.activeIdx;
    }

    public final void setActiveIdx(int i) {
        this.activeIdx = i;
    }

    public final AudioPlaybackReason getReason() {
        return this.reason;
    }

    public final TigerCardDomain getNfc() {
        return this.nfc;
    }

    public final AudioPlaylistDelegate getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(AudioPlaylistDelegate audioPlaylistDelegate) {
        this.delegate = audioPlaylistDelegate;
    }

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ&\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylist$Companion;", "", "()V", "create", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaylist;", "products", "", "Lmedia/tiger/tigerbox/webserver/dto/PlaybackDto;", "firstProductId", "", "reason", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackReason;", "nfc", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AudioPlaylist.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AudioPlaylist create(List<PlaybackDto> list, AudioPlaybackReason audioPlaybackReason, TigerCardDomain tigerCardDomain) {
            Intrinsics.checkNotNullParameter(list, "products");
            Intrinsics.checkNotNullParameter(audioPlaybackReason, "reason");
            return new AudioPlaylist(list, 0, audioPlaybackReason, tigerCardDomain, (DefaultConstructorMarker) null);
        }

        public final AudioPlaylist create(List<PlaybackDto> list, int i, AudioPlaybackReason audioPlaybackReason, TigerCardDomain tigerCardDomain) {
            Object obj;
            boolean z;
            Intrinsics.checkNotNullParameter(list, "products");
            Intrinsics.checkNotNullParameter(audioPlaybackReason, "reason");
            Iterator it = CollectionsKt.withIndex(list).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((PlaybackDto) ((IndexedValue) obj).getValue()).getProductId() == i) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            IndexedValue indexedValue = (IndexedValue) obj;
            return new AudioPlaylist(list, indexedValue != null ? indexedValue.getIndex() : 0, audioPlaybackReason, tigerCardDomain, (DefaultConstructorMarker) null);
        }
    }
}
