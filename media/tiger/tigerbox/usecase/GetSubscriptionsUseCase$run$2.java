package media.tiger.tigerbox.usecase;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.AccountSubscriptionDomain;
import media.tiger.tigerbox.model.dto.SubscriptionDto;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel;
import media.tiger.tigerbox.utils.DateUtilsKt;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/AccountSubscriptionDomain;", "response", "", "Lmedia/tiger/tigerbox/model/dto/SubscriptionDto;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetSubscriptionsUseCase.kt */
final class GetSubscriptionsUseCase$run$2 extends Lambda implements Function1<List<? extends SubscriptionDto>, AccountSubscriptionDomain> {
    public static final GetSubscriptionsUseCase$run$2 INSTANCE = new GetSubscriptionsUseCase$run$2();

    GetSubscriptionsUseCase$run$2() {
        super(1);
    }

    public final AccountSubscriptionDomain invoke(List<SubscriptionDto> list) {
        SubscriptionDto subscriptionDto;
        String str = null;
        if (list == null || (subscriptionDto = (SubscriptionDto) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        String validUntil = subscriptionDto.getValidUntil();
        if (validUntil != null) {
            str = new SimpleDateFormat(TigerTicketInputPinViewModel.END_DATE_OUTPUT_FORMAT, Locale.getDefault()).format(DateUtilsKt.toDate(validUntil, "yyyy-MM-dd'T'HH:mm:ss"));
        }
        return new AccountSubscriptionDomain(subscriptionDto.getId(), subscriptionDto.getValidUntil(), str, subscriptionDto.getActive(), subscriptionDto.getSource(), subscriptionDto.getAccountId(), subscriptionDto.getRenewable());
    }
}
