package media.tiger.tigerbox.data.repository;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;
import media.tiger.tigerbox.model.dto.Profile;
import media.tiger.tigerbox.model.dto.TigerBoxAccountProfiles;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo33737d2 = {"<anonymous>", "", "Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "it", "Lmedia/tiger/tigerbox/model/dto/TigerBoxAccountProfiles;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserRepository.kt */
final class DefaultTigerBoxAccountRepository$fetchProfilesInfo$3 extends Lambda implements Function1<TigerBoxAccountProfiles, List<? extends TigerBoxProfileDomain>> {
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultTigerBoxAccountRepository$fetchProfilesInfo$3(DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository) {
        super(1);
        this.this$0 = defaultTigerBoxAccountRepository;
    }

    public final List<TigerBoxProfileDomain> invoke(TigerBoxAccountProfiles tigerBoxAccountProfiles) {
        Intrinsics.checkNotNullParameter(tigerBoxAccountProfiles, "it");
        List<TigerBoxProfileDomain> arrayList = new ArrayList<>();
        List<Profile> profiles = tigerBoxAccountProfiles.get_embedded().getProfiles();
        if (profiles != null) {
            DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository = this.this$0;
            for (Profile next : profiles) {
                int id = next.getId();
                String email = defaultTigerBoxAccountRepository.getAccountInfo().getUser().getEmail();
                int accountId = defaultTigerBoxAccountRepository.getAccountInfo().getUser().getAccountId();
                String name = next.getName();
                Profile.Links.Link avatar = next.get_links().getAvatar();
                arrayList.add(new TigerBoxProfileDomain(id, email, accountId, name, (String) null, (String) null, avatar != null ? avatar.getHref() : null));
                if (next.getDefaultProfile()) {
                    next.getId();
                }
            }
        }
        return arrayList;
    }
}
