package media.tiger.tigerbox.usecase;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo33737d2 = {"<anonymous>", "Ljava/io/File;", "it", "", "invoke", "(Lkotlin/Unit;)Ljava/io/File;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PostCrashLogsUseCase.kt */
final class PostCrashLogsUseCase$run$2 extends Lambda implements Function1<Unit, File> {
    final /* synthetic */ CrashLogsUseCaseParameters $params;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostCrashLogsUseCase$run$2(CrashLogsUseCaseParameters crashLogsUseCaseParameters) {
        super(1);
        this.$params = crashLogsUseCaseParameters;
    }

    public final File invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return this.$params.getFile();
    }
}
