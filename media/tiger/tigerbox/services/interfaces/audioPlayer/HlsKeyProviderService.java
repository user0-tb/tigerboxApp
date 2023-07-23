package media.tiger.tigerbox.services.interfaces.audioPlayer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;", "", "readHlsKeyFromUrl", "", "localUrl", "", "nfcInfo", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "overwrite", "", "(Ljava/lang/String;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HlsKeyProviderService.kt */
public interface HlsKeyProviderService {
    Object readHlsKeyFromUrl(String str, TigerCardDomain tigerCardDomain, boolean z, Continuation<? super byte[]> continuation);

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HlsKeyProviderService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object readHlsKeyFromUrl$default(HlsKeyProviderService hlsKeyProviderService, String str, TigerCardDomain tigerCardDomain, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return hlsKeyProviderService.readHlsKeyFromUrl(str, tigerCardDomain, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readHlsKeyFromUrl");
        }
    }
}
