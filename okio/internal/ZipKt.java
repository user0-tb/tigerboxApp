package okio.internal;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import okhttp3.internal.p017ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;

@Metadata(mo33736d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00064"}, mo33737d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: zip.kt */
public final class ZipKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = ZipKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r11.close();
        r5 = r5 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
        if (r5 <= 0) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005f, code lost:
        r5 = okio.Okio.buffer(r4.source(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r6 = (okio.BufferedSource) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
        if (r6.readIntLe() != ZIP64_LOCATOR_SIGNATURE) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        r12 = r6.readIntLe();
        r13 = r6.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
        if (r6.readIntLe() != 1) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0084, code lost:
        if (r12 != 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0086, code lost:
        r6 = okio.Okio.buffer(r4.source(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r12 = (okio.BufferedSource) r6;
        r13 = r12.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009a, code lost:
        if (r13 != ZIP64_EOCD_RECORD_SIGNATURE) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009c, code lost:
        r9 = readZip64EocdRecord(r12, r9);
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r6, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cc, code lost:
        throw new java.io.IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ce, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d1, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00dd, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00de, code lost:
        r6 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r5, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e5, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e8, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ec, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ed, code lost:
        r5 = new java.util.ArrayList();
        r4 = okio.Okio.buffer(r4.source(r9.getCentralDirectoryOffset()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r6 = (okio.BufferedSource) r4;
        r12 = r9.getEntryCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010b, code lost:
        if (r7 >= r12) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010d, code lost:
        r14 = readEntry(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011b, code lost:
        if (r14.getOffset() >= r9.getCentralDirectoryOffset()) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0127, code lost:
        if (r2.invoke(r14).booleanValue() == false) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0129, code lost:
        r5.add(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012f, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x013a, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x013b, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r4, (java.lang.Throwable) null);
        r4 = new okio.ZipFileSystem(r0, r1, buildIndex(r5), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0149, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r3, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x014c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x014d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014e, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0150, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0151, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0155, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        r9 = readEocdRecord(r11);
        r10 = r11.readUtf8((long) r9.getCommentByteCount());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem openZip(okio.Path r20, okio.FileSystem r21, kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r22) throws java.io.IOException {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "zipPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "fileSystem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            okio.FileHandle r3 = r1.openReadOnly(r0)
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = r3
            okio.FileHandle r4 = (okio.FileHandle) r4     // Catch:{ all -> 0x018a }
            long r5 = r4.size()     // Catch:{ all -> 0x018a }
            r7 = 22
            long r7 = (long) r7     // Catch:{ all -> 0x018a }
            long r5 = r5 - r7
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x016f
            r9 = 65536(0x10000, double:3.2379E-319)
            long r9 = r5 - r9
            long r9 = java.lang.Math.max(r9, r7)     // Catch:{ all -> 0x018a }
        L_0x0035:
            okio.Source r11 = r4.source(r5)     // Catch:{ all -> 0x018a }
            okio.BufferedSource r11 = okio.Okio.buffer((okio.Source) r11)     // Catch:{ all -> 0x018a }
            int r12 = r11.readIntLe()     // Catch:{ all -> 0x016a }
            r13 = 101010256(0x6054b50, float:2.506985E-35)
            if (r12 != r13) goto L_0x0156
            okio.internal.EocdRecord r9 = readEocdRecord(r11)     // Catch:{ all -> 0x016a }
            int r10 = r9.getCommentByteCount()     // Catch:{ all -> 0x016a }
            long r12 = (long) r10     // Catch:{ all -> 0x016a }
            java.lang.String r10 = r11.readUtf8(r12)     // Catch:{ all -> 0x016a }
            r11.close()     // Catch:{ all -> 0x018a }
            r11 = 20
            long r11 = (long) r11     // Catch:{ all -> 0x018a }
            long r5 = r5 - r11
            r11 = 0
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 <= 0) goto L_0x00ed
            okio.Source r5 = r4.source(r5)     // Catch:{ all -> 0x018a }
            okio.BufferedSource r5 = okio.Okio.buffer((okio.Source) r5)     // Catch:{ all -> 0x018a }
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ all -> 0x018a }
            r6 = r5
            okio.BufferedSource r6 = (okio.BufferedSource) r6     // Catch:{ all -> 0x00e4 }
            int r12 = r6.readIntLe()     // Catch:{ all -> 0x00e4 }
            r13 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r12 != r13) goto L_0x00de
            int r12 = r6.readIntLe()     // Catch:{ all -> 0x00e4 }
            long r13 = r6.readLongLe()     // Catch:{ all -> 0x00e4 }
            int r6 = r6.readIntLe()     // Catch:{ all -> 0x00e4 }
            r15 = 1
            if (r6 != r15) goto L_0x00d6
            if (r12 != 0) goto L_0x00d6
            okio.Source r6 = r4.source(r13)     // Catch:{ all -> 0x00e4 }
            okio.BufferedSource r6 = okio.Okio.buffer((okio.Source) r6)     // Catch:{ all -> 0x00e4 }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x00e4 }
            r12 = r6
            okio.BufferedSource r12 = (okio.BufferedSource) r12     // Catch:{ all -> 0x00cd }
            int r13 = r12.readIntLe()     // Catch:{ all -> 0x00cd }
            r14 = 101075792(0x6064b50, float:2.525793E-35)
            if (r13 != r14) goto L_0x00a6
            okio.internal.EocdRecord r9 = readZip64EocdRecord(r12, r9)     // Catch:{ all -> 0x00cd }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00cd }
            kotlin.p013io.CloseableKt.closeFinally(r6, r11)     // Catch:{ all -> 0x00e4 }
            goto L_0x00de
        L_0x00a6:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r1.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = "bad zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = getHex(r14)     // Catch:{ all -> 0x00cd }
            r1.append(r2)     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = " but was "
            r1.append(r2)     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = getHex(r13)     // Catch:{ all -> 0x00cd }
            r1.append(r2)     // Catch:{ all -> 0x00cd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00cd }
            r0.<init>(r1)     // Catch:{ all -> 0x00cd }
            throw r0     // Catch:{ all -> 0x00cd }
        L_0x00cd:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r0 = move-exception
            r2 = r0
            kotlin.p013io.CloseableKt.closeFinally(r6, r1)     // Catch:{ all -> 0x00e4 }
            throw r2     // Catch:{ all -> 0x00e4 }
        L_0x00d6:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x00e4 }
            throw r0     // Catch:{ all -> 0x00e4 }
        L_0x00de:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e4 }
            kotlin.p013io.CloseableKt.closeFinally(r5, r11)     // Catch:{ all -> 0x018a }
            goto L_0x00ed
        L_0x00e4:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00e7 }
        L_0x00e7:
            r0 = move-exception
            r2 = r0
            kotlin.p013io.CloseableKt.closeFinally(r5, r1)     // Catch:{ all -> 0x018a }
            throw r2     // Catch:{ all -> 0x018a }
        L_0x00ed:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x018a }
            r5.<init>()     // Catch:{ all -> 0x018a }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x018a }
            long r12 = r9.getCentralDirectoryOffset()     // Catch:{ all -> 0x018a }
            okio.Source r4 = r4.source(r12)     // Catch:{ all -> 0x018a }
            okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r4)     // Catch:{ all -> 0x018a }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x018a }
            r6 = r4
            okio.BufferedSource r6 = (okio.BufferedSource) r6     // Catch:{ all -> 0x014d }
            long r12 = r9.getEntryCount()     // Catch:{ all -> 0x014d }
        L_0x0109:
            int r14 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x013b
            okio.internal.ZipEntry r14 = readEntry(r6)     // Catch:{ all -> 0x014d }
            long r15 = r14.getOffset()     // Catch:{ all -> 0x014d }
            long r17 = r9.getCentralDirectoryOffset()     // Catch:{ all -> 0x014d }
            int r19 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r19 >= 0) goto L_0x0133
            java.lang.Object r15 = r2.invoke(r14)     // Catch:{ all -> 0x014d }
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x014d }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x014d }
            if (r15 == 0) goto L_0x012f
            r15 = r5
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ all -> 0x014d }
            r15.add(r14)     // Catch:{ all -> 0x014d }
        L_0x012f:
            r14 = 1
            long r7 = r7 + r14
            goto L_0x0109
        L_0x0133:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x014d }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x014d }
            throw r0     // Catch:{ all -> 0x014d }
        L_0x013b:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014d }
            kotlin.p013io.CloseableKt.closeFinally(r4, r11)     // Catch:{ all -> 0x018a }
            java.util.Map r2 = buildIndex(r5)     // Catch:{ all -> 0x018a }
            okio.ZipFileSystem r4 = new okio.ZipFileSystem     // Catch:{ all -> 0x018a }
            r4.<init>(r0, r1, r2, r10)     // Catch:{ all -> 0x018a }
            kotlin.p013io.CloseableKt.closeFinally(r3, r11)
            return r4
        L_0x014d:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0150 }
        L_0x0150:
            r0 = move-exception
            r2 = r0
            kotlin.p013io.CloseableKt.closeFinally(r4, r1)     // Catch:{ all -> 0x018a }
            throw r2     // Catch:{ all -> 0x018a }
        L_0x0156:
            r11.close()     // Catch:{ all -> 0x018a }
            r11 = -1
            long r5 = r5 + r11
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0162
            goto L_0x0035
        L_0x0162:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x018a }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x018a }
            throw r0     // Catch:{ all -> 0x018a }
        L_0x016a:
            r0 = move-exception
            r11.close()     // Catch:{ all -> 0x018a }
            throw r0     // Catch:{ all -> 0x018a }
        L_0x016f:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r1.<init>()     // Catch:{ all -> 0x018a }
            java.lang.String r2 = "not a zip: size="
            r1.append(r2)     // Catch:{ all -> 0x018a }
            long r4 = r4.size()     // Catch:{ all -> 0x018a }
            r1.append(r4)     // Catch:{ all -> 0x018a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018a }
            r0.<init>(r1)     // Catch:{ all -> 0x018a }
            throw r0     // Catch:{ all -> 0x018a }
        L_0x018a:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x018d }
        L_0x018d:
            r0 = move-exception
            r2 = r0
            kotlin.p013io.CloseableKt.closeFinally(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, DownloadsManager.FOLDERS_SEPARATOR, false, 1, (Object) null);
        Map<Path, ZipEntry> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m475to(path, new ZipEntry(path, true, (String) null, 0, 0, 0, 0, (Long) null, 0, 508, (DefaultConstructorMarker) null)));
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(list, new ZipKt$buildIndex$$inlined$sortedBy$1())) {
            if (mutableMapOf.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = mutableMapOf.get(parent);
                    if (zipEntry2 != null) {
                        zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                        break;
                    }
                    ZipEntry zipEntry3 = r4;
                    ZipEntry zipEntry4 = new ZipEntry(parent, true, (String) null, 0, 0, 0, 0, (Long) null, 0, 508, (DefaultConstructorMarker) null);
                    ZipEntry zipEntry5 = zipEntry3;
                    mutableMapOf.put(parent, zipEntry5);
                    zipEntry5.getChildren().add(zipEntry.getCanonicalPath());
                    zipEntry = zipEntry5;
                }
            }
        }
        return mutableMapOf;
    }

    public static final ZipEntry readEntry(BufferedSource bufferedSource) throws IOException {
        BufferedSource bufferedSource2 = bufferedSource;
        Intrinsics.checkNotNullParameter(bufferedSource2, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(4);
            short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & UShort.MAX_VALUE, bufferedSource.readShortLe() & UShort.MAX_VALUE);
                long readIntLe2 = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe4 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe5 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(8);
                Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                String readUtf8 = bufferedSource2.readUtf8((long) readShortLe3);
                if (!StringsKt.contains$default((CharSequence) readUtf8, 0, false, 2, (Object) null)) {
                    String str = readUtf8;
                    long j = longRef2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? ((long) 8) + 0 : 0;
                    if (longRef.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                        j += (long) 8;
                    }
                    if (longRef3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                        j += (long) 8;
                    }
                    long j2 = j;
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    Long l = dosDateTimeToEpochMillis;
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    short s = readShortLe2;
                    String str2 = str;
                    Ref.LongRef longRef4 = longRef3;
                    short s2 = readShortLe5;
                    readExtra(bufferedSource2, readShortLe4, new ZipKt$readEntry$1(booleanRef, j2, longRef2, bufferedSource, longRef, longRef4));
                    if (j2 <= 0 || booleanRef2.element) {
                        String str3 = str2;
                        return new ZipEntry(Path.Companion.get$default(Path.Companion, DownloadsManager.FOLDERS_SEPARATOR, false, 1, (Object) null).resolve(str3), StringsKt.endsWith$default(str3, DownloadsManager.FOLDERS_SEPARATOR, false, 2, (Object) null), bufferedSource2.readUtf8((long) s2), readIntLe2, longRef.element, longRef2.element, s, l, longRef4.element);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(readShortLe));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long readShortLe3 = (long) (bufferedSource.readShortLe() & UShort.MAX_VALUE);
        if (readShortLe3 == ((long) (bufferedSource.readShortLe() & UShort.MAX_VALUE)) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4);
            return new EocdRecord(readShortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & UShort.MAX_VALUE);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, Unit> function2) {
        long j = (long) i;
        while (j != 0) {
            if (j >= 4) {
                short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j2 = j - ((long) 4);
                if (j2 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    int i2 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i2 >= 0) {
                        if (i2 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j = j2 - readShortLe2;
                    } else {
                        throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, (FileMetadata) null);
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(fileMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, fileMetadata);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        BufferedSource bufferedSource2 = bufferedSource;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = fileMetadata != null ? fileMetadata.getLastModifiedAtMillis() : null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(2);
            short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                bufferedSource2.skip(18);
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(readShortLe2);
                if (fileMetadata == null) {
                    bufferedSource2.skip((long) readShortLe3);
                    return null;
                }
                readExtra(bufferedSource2, readShortLe3, new ZipKt$readOrSkipLocalHeader$1(bufferedSource2, objectRef, objectRef2, objectRef3));
                return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), (Path) null, fileMetadata.getSize(), (Long) objectRef3.element, (Long) objectRef.element, (Long) objectRef2.element, (Map) null, 128, (DefaultConstructorMarker) null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(readShortLe));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        gregorianCalendar2.set(((i >> 9) & 127) + 1980, ((i >> 5) & 15) - 1, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String num = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }
}
