package media.tiger.tigerbox.services.implementations.audioPlayer;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioItemImpl.kt */
final class AudioItemImpl$Companion$create$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Ref.BooleanRef $captureChapterPlaylist;
    final /* synthetic */ Ref.LongRef $chapterLength;
    final /* synthetic */ Ref.ObjectRef<String> $chapterTitle;
    final /* synthetic */ String $dstDir;
    final /* synthetic */ ArrayList<AudioTrackModel> $tracks;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AudioItemImpl$Companion$create$1(Ref.BooleanRef booleanRef, String str, ArrayList<AudioTrackModel> arrayList, Ref.ObjectRef<String> objectRef, Ref.LongRef longRef) {
        super(1);
        this.$captureChapterPlaylist = booleanRef;
        this.$dstDir = str;
        this.$tracks = arrayList;
        this.$chapterTitle = objectRef;
        this.$chapterLength = longRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        if (this.$captureChapterPlaylist.element) {
            this.$tracks.add(new AudioTrackModel((String) this.$chapterTitle.element, this.$chapterLength.element, this.$dstDir + "/track_" + (this.$tracks.size() + 1) + "/playlist.m3u8", str));
        }
        this.$captureChapterPlaylist.element = false;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) AudioItemImpl.EXTINF_TAG, false, 2, (Object) null)) {
            this.$chapterLength.element = (long) Double.parseDouble(StringsKt.substringBefore$default(StringsKt.substringAfter$default(str, AudioItemImpl.EXTINF_TAG, (String) null, 2, (Object) null), ",", (String) null, 2, (Object) null));
            this.$chapterTitle.element = StringsKt.substringAfter$default(str, ",", (String) null, 2, (Object) null);
            this.$captureChapterPlaylist.element = true;
        }
    }
}
