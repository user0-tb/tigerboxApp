package media.tiger.tigerbox.services.implementations;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.services.implementations.audioPlayer.AudioItemImpl;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Availability.kt */
final class Availability$parseEncodingPlaylists$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Ref.BooleanRef $captureTsRelativePath;
    final /* synthetic */ Ref.ObjectRef<String> $keyUri;
    final /* synthetic */ ArrayList<String> $tsRelativePaths;
    final /* synthetic */ Ref.ObjectRef<String> $updatedFileContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$parseEncodingPlaylists$1(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Ref.BooleanRef booleanRef, ArrayList<String> arrayList) {
        super(1);
        this.$keyUri = objectRef;
        this.$updatedFileContent = objectRef2;
        this.$captureTsRelativePath = booleanRef;
        this.$tsRelativePaths = arrayList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        CharSequence charSequence = str;
        if (StringsKt.contains$default(charSequence, (CharSequence) AudioItemImpl.EXT_X_KEY, false, 2, (Object) null)) {
            String replace$default = StringsKt.replace$default(str, "https://", "local://", false, 4, (Object) null);
            this.$keyUri.element = StringsKt.substringBefore$default(StringsKt.substringAfter$default(replace$default, AudioItemImpl.KEY_URI_BEGIN, (String) null, 2, (Object) null), AudioItemImpl.KEY_URI_END, (String) null, 2, (Object) null);
            Ref.ObjectRef<String> objectRef = this.$updatedFileContent;
            objectRef.element = ((String) this.$updatedFileContent.element) + replace$default + 10;
        } else {
            Ref.ObjectRef<String> objectRef2 = this.$updatedFileContent;
            objectRef2.element = ((String) this.$updatedFileContent.element) + str + 10;
        }
        if (this.$captureTsRelativePath.element) {
            this.$tsRelativePaths.add(str);
        }
        this.$captureTsRelativePath.element = false;
        if (StringsKt.contains$default(charSequence, (CharSequence) AudioItemImpl.EXTINF_TAG, false, 2, (Object) null)) {
            this.$captureTsRelativePath.element = true;
        }
    }
}
