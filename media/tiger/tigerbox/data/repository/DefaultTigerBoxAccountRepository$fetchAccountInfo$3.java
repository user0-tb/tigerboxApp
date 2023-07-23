package media.tiger.tigerbox.data.repository;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.TigerBoxAccountDomain;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;
import media.tiger.tigerbox.model.domain.TigerBoxUserDomain;
import media.tiger.tigerbox.model.dto.Profile;
import media.tiger.tigerbox.model.dto.TigerBoxUser;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/TigerBoxAccountDomain;", "it", "Lmedia/tiger/tigerbox/model/dto/TigerBoxUser;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserRepository.kt */
final class DefaultTigerBoxAccountRepository$fetchAccountInfo$3 extends Lambda implements Function1<TigerBoxUser, TigerBoxAccountDomain> {
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultTigerBoxAccountRepository$fetchAccountInfo$3(DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository) {
        super(1);
        this.this$0 = defaultTigerBoxAccountRepository;
    }

    public final TigerBoxAccountDomain invoke(TigerBoxUser tigerBoxUser) {
        int i;
        Intrinsics.checkNotNullParameter(tigerBoxUser, "it");
        List arrayList = new ArrayList();
        List<Profile> profiles = tigerBoxUser.get_embedded().getProfiles();
        if (profiles != null) {
            int i2 = -1;
            for (Profile next : profiles) {
                int id = next.getId();
                String email = tigerBoxUser.getEmail();
                int id2 = tigerBoxUser.getId();
                String name = next.getName();
                Profile.Links.Link avatar = next.get_links().getAvatar();
                arrayList.add(new TigerBoxProfileDomain(id, email, id2, name, (String) null, (String) null, avatar != null ? avatar.getHref() : null));
                if (next.getDefaultProfile()) {
                    i2 = next.getId();
                }
            }
            i = i2;
        } else {
            i = -1;
        }
        return new TigerBoxAccountDomain(new TigerBoxUserDomain(i, tigerBoxUser.getId(), this.this$0.getAccountInfo().getUser().getActiveProfileId() == -1 ? i : this.this$0.getAccountInfo().getUser().getActiveProfileId(), tigerBoxUser.getEmail(), tigerBoxUser.getPin()), arrayList);
    }
}
