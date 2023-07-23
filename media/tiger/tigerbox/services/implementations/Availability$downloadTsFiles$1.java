package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.implementations.Availability;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo33737d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Availability.kt */
final class Availability$downloadTsFiles$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Availability.AudioDownload $download;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$downloadTsFiles$1(Availability.AudioDownload audioDownload) {
        super(0);
        this.$download = audioDownload;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(!this.$download.getCanceled());
    }
}
