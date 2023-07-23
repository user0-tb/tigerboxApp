package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.ReportInformation;
import media.tiger.tigerbox.model.dto.ReportInformationDto;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/ReportInformation;", "dto", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ReportInformationUseCase.kt */
final class ReportInformationUseCase$run$2 extends Lambda implements Function1<ReportInformationDto, ReportInformation> {
    final /* synthetic */ ReportInformationUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportInformationUseCase$run$2(ReportInformationUseCase reportInformationUseCase) {
        super(1);
        this.this$0 = reportInformationUseCase;
    }

    public final ReportInformation invoke(ReportInformationDto reportInformationDto) {
        Intrinsics.checkNotNullParameter(reportInformationDto, "dto");
        this.this$0.processFeatureFlags(reportInformationDto);
        return new ReportInformation(reportInformationDto.getId(), reportInformationDto.getAccountId(), reportInformationDto.getCurrentUserId());
    }
}
