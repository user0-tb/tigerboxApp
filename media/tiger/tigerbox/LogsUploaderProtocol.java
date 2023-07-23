package media.tiger.tigerbox;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import media.tiger.tigerbox.usecase.CrashLogsUseCaseParameters;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J`\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00030\fH\u0002J<\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0016¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/LogsUploaderProtocol;", "", "uploadFile", "", "file", "Ljava/io/File;", "postLogsUseCase", "Lmedia/tiger/tigerbox/usecase/PostCrashLogsUseCase;", "cpuId", "", "serialNumber", "finishLambda", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "uploadThenDeleteFiles", "files", "", "Lkotlin/Function0;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LogsUploaderProtocol.kt */
public interface LogsUploaderProtocol {
    void uploadThenDeleteFiles(List<? extends File> list, PostCrashLogsUseCase postCrashLogsUseCase, String str, String str2, Function0<Unit> function0);

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: LogsUploaderProtocol.kt */
    public static final class DefaultImpls {
        public static void uploadThenDeleteFiles(LogsUploaderProtocol logsUploaderProtocol, List<? extends File> list, PostCrashLogsUseCase postCrashLogsUseCase, String str, String str2, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(list, "files");
            Intrinsics.checkNotNullParameter(postCrashLogsUseCase, "postLogsUseCase");
            Intrinsics.checkNotNullParameter(str, "cpuId");
            Intrinsics.checkNotNullParameter(str2, "serialNumber");
            Intrinsics.checkNotNullParameter(function0, "finishLambda");
            List mutableList = CollectionsKt.toMutableList(list);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new LogsUploaderProtocol$uploadThenDeleteFiles$1(mutableList, objectRef, logsUploaderProtocol, postCrashLogsUseCase, str, str2, function0);
            if (!mutableList.isEmpty()) {
                T t = objectRef.element;
                Intrinsics.checkNotNull(t);
                uploadFile(logsUploaderProtocol, (File) CollectionsKt.first(mutableList), postCrashLogsUseCase, str, str2, (Function2) t);
                return;
            }
            function0.invoke();
        }

        /* access modifiers changed from: private */
        public static void uploadFile(LogsUploaderProtocol logsUploaderProtocol, File file, PostCrashLogsUseCase postCrashLogsUseCase, String str, String str2, Function2<? super Boolean, ? super File, Unit> function2) {
            if (!file.exists() || file.length() == 0) {
                function2.invoke(true, file);
                return;
            }
            try {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "file.name");
                postCrashLogsUseCase.invoke(new CrashLogsUseCaseParameters(str, str2, file, name, RequestBody.Companion.create$default(RequestBody.Companion, file, (MediaType) null, 1, (Object) null)), CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), new LogsUploaderProtocol$uploadFile$1(function2, file));
            } catch (Exception e) {
                Timber.Tree tag = Timber.Forest.tag("LogsUploaderProtocol");
                tag.mo50217e("Exception: " + e.getMessage(), new Object[0]);
                function2.invoke(false, file);
            }
        }
    }
}
