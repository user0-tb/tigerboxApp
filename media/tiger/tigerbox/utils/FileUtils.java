package media.tiger.tigerbox.utils;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p013io.FilesKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/utils/FileUtils;", "", "()V", "TAG", "", "isFileExists", "", "filePath", "readToString", "path", "writeFile", "", "value", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: FileUtils.kt */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();
    private static final String TAG = "FileUtils";

    private FileUtils() {
    }

    public final void writeFile(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "path");
        writeFile(str, String.valueOf(i));
    }

    public final boolean isFileExists(String str) {
        File file = new File(str);
        return file.exists() && file.canRead() && file.length() > 0;
    }

    public final void writeFile(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "path");
        if (str2 != null) {
            try {
                FilesKt.writeText$default(new File(str), str2, (Charset) null, 2, (Object) null);
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("FileUtils: ERROR: while writing to file [" + str + "]: [" + e + ']', new Object[0]);
            }
        }
    }

    public final String readToString(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        File file = new File(str);
        if (!file.exists()) {
            return "";
        }
        try {
            return FilesKt.readText$default(file, (Charset) null, 1, (Object) null);
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("FileUtils: ERROR: while reading from file [" + str + "]: [" + e + ']', new Object[0]);
            return "";
        }
    }
}
