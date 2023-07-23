package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import media.tiger.tigerbox.model.domain.TigerCard;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/NfcListener;", "", "onCardException", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onCardInserted", "card", "Lmedia/tiger/tigerbox/model/domain/TigerCard;", "onCardRemoved", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NfcService.kt */
public interface NfcListener {
    void onCardException(Exception exc);

    void onCardInserted(TigerCard tigerCard);

    void onCardRemoved();
}
