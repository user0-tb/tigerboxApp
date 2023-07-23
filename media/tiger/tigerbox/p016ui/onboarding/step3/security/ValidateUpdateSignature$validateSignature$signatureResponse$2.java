package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "it", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$validateSignature$signatureResponse$2 */
/* compiled from: ValidateUpdateSignature.kt */
final class ValidateUpdateSignature$validateSignature$signatureResponse$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ReleaseInformation $releaseInformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ValidateUpdateSignature$validateSignature$signatureResponse$2(ReleaseInformation releaseInformation) {
        super(1);
        this.$releaseInformation = releaseInformation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        Timber.Forest forest = Timber.Forest;
        forest.mo50217e("ValidateUpdateSignature: Downloading [" + this.$releaseInformation.getSignature() + "] " + str, new Object[0]);
    }
}
