package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ReportInformationUseCase.kt */
final class ReportInformationUseCase$run$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ReportInformationUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportInformationUseCase$run$3(ReportInformationUseCase reportInformationUseCase) {
        super(0);
        this.this$0 = reportInformationUseCase;
    }

    public final void invoke() {
        Timber.Forest.mo50221i("ReportInformationUseCase error", new Object[0]);
        this.this$0.resetFlags();
    }
}
