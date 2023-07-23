package media.tiger.tigerbox;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import media.tiger.tigerbox.LogsUploaderProtocol;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "success", "", "file", "Ljava/io/File;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LogsUploaderProtocol.kt */
final class LogsUploaderProtocol$uploadThenDeleteFiles$1 extends Lambda implements Function2<Boolean, File, Unit> {
    final /* synthetic */ String $cpuId;
    final /* synthetic */ List<File> $finalFiles;
    final /* synthetic */ Function0<Unit> $finishLambda;
    final /* synthetic */ PostCrashLogsUseCase $postLogsUseCase;
    final /* synthetic */ String $serialNumber;
    final /* synthetic */ Ref.ObjectRef<Function2<Boolean, File, Unit>> $stepLambda;
    final /* synthetic */ LogsUploaderProtocol this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogsUploaderProtocol$uploadThenDeleteFiles$1(List<File> list, Ref.ObjectRef<Function2<Boolean, File, Unit>> objectRef, LogsUploaderProtocol logsUploaderProtocol, PostCrashLogsUseCase postCrashLogsUseCase, String str, String str2, Function0<Unit> function0) {
        super(2);
        this.$finalFiles = list;
        this.$stepLambda = objectRef;
        this.this$0 = logsUploaderProtocol;
        this.$postLogsUseCase = postCrashLogsUseCase;
        this.$cpuId = str;
        this.$serialNumber = str2;
        this.$finishLambda = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), (File) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (z) {
            file.delete();
        }
        this.$finalFiles.remove(file);
        if (!(!this.$finalFiles.isEmpty()) || this.$stepLambda.element == null) {
            this.$finishLambda.invoke();
            return;
        }
        LogsUploaderProtocol logsUploaderProtocol = this.this$0;
        PostCrashLogsUseCase postCrashLogsUseCase = this.$postLogsUseCase;
        String str = this.$cpuId;
        String str2 = this.$serialNumber;
        T t = this.$stepLambda.element;
        Intrinsics.checkNotNull(t);
        LogsUploaderProtocol.DefaultImpls.uploadFile(logsUploaderProtocol, (File) CollectionsKt.first(this.$finalFiles), postCrashLogsUseCase, str, str2, (Function2) t);
    }
}
