package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.model.domain.HlsKeyDomain;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/HlsKeysRepository;", "", "deleteAlHlsKeys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHlsKey", "Lmedia/tiger/tigerbox/model/domain/HlsKeyDomain;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHlsKey", "key", "(Lmedia/tiger/tigerbox/model/domain/HlsKeyDomain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HlsKeysRepository.kt */
public interface HlsKeysRepository {
    Object deleteAlHlsKeys(Continuation<? super Unit> continuation);

    Object getHlsKey(String str, Continuation<? super HlsKeyDomain> continuation);

    Object insertHlsKey(HlsKeyDomain hlsKeyDomain, Continuation<? super Unit> continuation);
}
