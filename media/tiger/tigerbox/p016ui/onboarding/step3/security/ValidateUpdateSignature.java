package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.data.network.OtaWebService;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler;
import media.tiger.tigerbox.services.interfaces.AssetService;

@Metadata(mo33736d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0007J9\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature;", "", "otaWebService", "Lmedia/tiger/tigerbox/data/network/OtaWebService;", "validateDigest", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DigestValidator;", "assetService", "Lmedia/tiger/tigerbox/services/interfaces/AssetService;", "base64Converter", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/Base64Converter;", "largeDownloadHandler", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler;", "(Lmedia/tiger/tigerbox/data/network/OtaWebService;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DigestValidator;Lmedia/tiger/tigerbox/services/interfaces/AssetService;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/Base64Converter;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler;)V", "checkDataSynchronously", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$ValidationResult;", "invoke", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onFail", "Lkotlin/Function1;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$FailReason;", "onSuccess", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "validateSignature", "FailReason", "ValidationResult", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature */
/* compiled from: ValidateUpdateSignature.kt */
public final class ValidateUpdateSignature {
    private final AssetService assetService;
    private final Base64Converter base64Converter;
    private final LargeDownloadHandler largeDownloadHandler;
    /* access modifiers changed from: private */
    public final OtaWebService otaWebService;
    private final DigestValidator validateDigest;

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$FailReason;", "", "(Ljava/lang/String;I)V", "DOWNLOAD_UNSUCCESSFUL", "FILE_NOT_FOUND", "TIMEOUT", "INVALID_DIGEST", "RELEASE_UNREACHABLE", "RELEASE_UNAVAILABLE", "NO_UPDATE", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason */
    /* compiled from: ValidateUpdateSignature.kt */
    public enum FailReason {
        DOWNLOAD_UNSUCCESSFUL,
        FILE_NOT_FOUND,
        TIMEOUT,
        INVALID_DIGEST,
        RELEASE_UNREACHABLE,
        RELEASE_UNAVAILABLE,
        NO_UPDATE
    }

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$WhenMappings */
    /* compiled from: ValidateUpdateSignature.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LargeDownloadHandler.FailReason.values().length];
            iArr[LargeDownloadHandler.FailReason.DOWNLOAD_UNSUCCESSFUL.ordinal()] = 1;
            iArr[LargeDownloadHandler.FailReason.FILE_NOT_FOUND.ordinal()] = 2;
            iArr[LargeDownloadHandler.FailReason.TIMEOUT.ordinal()] = 3;
            iArr[LargeDownloadHandler.FailReason.UNKNOWN.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ValidateUpdateSignature(OtaWebService otaWebService2, DigestValidator digestValidator, AssetService assetService2, Base64Converter base64Converter2, LargeDownloadHandler largeDownloadHandler2) {
        Intrinsics.checkNotNullParameter(otaWebService2, "otaWebService");
        Intrinsics.checkNotNullParameter(digestValidator, "validateDigest");
        Intrinsics.checkNotNullParameter(assetService2, "assetService");
        Intrinsics.checkNotNullParameter(base64Converter2, "base64Converter");
        Intrinsics.checkNotNullParameter(largeDownloadHandler2, "largeDownloadHandler");
        this.otaWebService = otaWebService2;
        this.validateDigest = digestValidator;
        this.assetService = assetService2;
        this.base64Converter = base64Converter2;
        this.largeDownloadHandler = largeDownloadHandler2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x013d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x013e, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0141, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult validateSignature() {
        /*
            r9 = this;
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler r0 = r9.largeDownloadHandler
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$validateSignature$releaseRawCallResponse$1 r1 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$validateSignature$releaseRawCallResponse$1
            r1.<init>(r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$validateSignature$releaseRawCallResponse$2 r2 = media.tiger.tigerbox.p016ui.onboarding.step3.security.C2993x3034405b.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result r0 = r0.invoke(r1, r2)
            boolean r1 = r0 instanceof media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler.Result.Failure
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x005d
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result$Failure r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler.Result.Failure) r0
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$FailReason r0 = r0.getReason()
            int[] r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L_0x0053
            if (r0 == r4) goto L_0x0049
            if (r0 == r3) goto L_0x003f
            if (r0 != r2) goto L_0x0039
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.RELEASE_UNREACHABLE
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
            goto L_0x005c
        L_0x0039:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x003f:
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.TIMEOUT
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
            goto L_0x005c
        L_0x0049:
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.RELEASE_UNAVAILABLE
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
            goto L_0x005c
        L_0x0053:
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.RELEASE_UNREACHABLE
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
        L_0x005c:
            return r0
        L_0x005d:
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result$Success r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler.Result.Success) r0
            retrofit2.Response r0 = r0.getResponse()
            java.lang.Object r0 = r0.body()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            okhttp3.ResponseBody r0 = (okhttp3.ResponseBody) r0
            java.lang.String r0 = r0.string()
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Class<media.tiger.tigerbox.model.dto.ReleaseInformation> r6 = media.tiger.tigerbox.model.dto.ReleaseInformation.class
            java.lang.Object r1 = r1.fromJson((java.lang.String) r0, r6)
            media.tiger.tigerbox.model.dto.ReleaseInformation r1 = (media.tiger.tigerbox.model.dto.ReleaseInformation) r1
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler r6 = r9.largeDownloadHandler
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$validateSignature$signatureResponse$1 r7 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$validateSignature$signatureResponse$1
            r7.<init>(r9, r1)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$validateSignature$signatureResponse$2 r8 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$validateSignature$signatureResponse$2
            r8.<init>(r1)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result r6 = r6.invoke(r7, r8)
            boolean r7 = r6 instanceof media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler.Result.Failure
            if (r7 == 0) goto L_0x00d9
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result$Failure r6 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler.Result.Failure) r6
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$FailReason r0 = r6.getReason()
            int[] r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L_0x00cf
            if (r0 == r4) goto L_0x00c5
            if (r0 == r3) goto L_0x00bb
            if (r0 != r2) goto L_0x00b5
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.DOWNLOAD_UNSUCCESSFUL
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
            goto L_0x00d8
        L_0x00b5:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00bb:
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.TIMEOUT
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
            goto L_0x00d8
        L_0x00c5:
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.FILE_NOT_FOUND
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
            goto L_0x00d8
        L_0x00cf:
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.DOWNLOAD_UNSUCCESSFUL
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
        L_0x00d8:
            return r0
        L_0x00d9:
            media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result$Success r6 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler.Result.Success) r6
            retrofit2.Response r2 = r6.getResponse()
            java.lang.Object r2 = r2.body()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            okhttp3.ResponseBody r2 = (okhttp3.ResponseBody) r2
            java.io.InputStream r2 = r2.byteStream()
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = 0
            r4 = r2
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x013b }
            byte[] r4 = kotlin.p013io.ByteStreamsKt.readBytes(r4)     // Catch:{ all -> 0x013b }
            kotlin.p013io.CloseableKt.closeFinally(r2, r3)
            java.lang.String r2 = "releaseInformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            media.tiger.tigerbox.model.dto.ReleaseInformation$Release r1 = media.tiger.tigerbox.model.dto.ReleaseInformationKt.getLatest(r1)
            if (r1 != 0) goto L_0x010e
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.NO_UPDATE
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
            return r0
        L_0x010e:
            media.tiger.tigerbox.ui.onboarding.step3.security.DigestValidator r2 = r9.validateDigest
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8
            byte[] r0 = r0.getBytes(r3)
            java.lang.String r3 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            media.tiger.tigerbox.services.interfaces.AssetService r3 = r9.assetService
            java.lang.String r3 = r3.getOtaPublicKey()
            media.tiger.tigerbox.ui.onboarding.step3.security.Base64Converter r5 = r9.base64Converter
            boolean r0 = r2.invoke((byte[]) r0, (java.lang.String) r3, (byte[]) r4, (media.tiger.tigerbox.p016ui.onboarding.step3.security.Base64Converter) r5)
            if (r0 == 0) goto L_0x0131
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Success r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Success
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
            goto L_0x013a
        L_0x0131:
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure r0 = new media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$FailReason r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.FailReason.INVALID_DIGEST
            r0.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult r0 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.ValidationResult) r0
        L_0x013a:
            return r0
        L_0x013b:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x013d }
        L_0x013d:
            r1 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature.validateSignature():media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult");
    }

    public final void invoke(CoroutineScope coroutineScope, Function1<? super FailReason, Unit> function1, Function1<? super ReleaseInformation.Release, Unit> function12) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(function1, "onFail");
        Intrinsics.checkNotNullParameter(function12, "onSuccess");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new ValidateUpdateSignature$invoke$1(this, function12, function1, (Continuation<? super ValidateUpdateSignature$invoke$1>) null), 2, (Object) null);
    }

    @Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$ValidationResult;", "", "()V", "Failure", "Success", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$ValidationResult$Success;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$ValidationResult$Failure;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult */
    /* compiled from: ValidateUpdateSignature.kt */
    public static abstract class ValidationResult {
        public /* synthetic */ ValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$ValidationResult$Success;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$ValidationResult;", "release", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "(Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;)V", "getRelease", "()Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Success */
        /* compiled from: ValidateUpdateSignature.kt */
        public static final class Success extends ValidationResult {
            private final ReleaseInformation.Release release;

            public static /* synthetic */ Success copy$default(Success success, ReleaseInformation.Release release2, int i, Object obj) {
                if ((i & 1) != 0) {
                    release2 = success.release;
                }
                return success.copy(release2);
            }

            public final ReleaseInformation.Release component1() {
                return this.release;
            }

            public final Success copy(ReleaseInformation.Release release2) {
                Intrinsics.checkNotNullParameter(release2, "release");
                return new Success(release2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && Intrinsics.areEqual((Object) this.release, (Object) ((Success) obj).release);
            }

            public int hashCode() {
                return this.release.hashCode();
            }

            public String toString() {
                return "Success(release=" + this.release + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(ReleaseInformation.Release release2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(release2, "release");
                this.release = release2;
            }

            public final ReleaseInformation.Release getRelease() {
                return this.release;
            }
        }

        private ValidationResult() {
        }

        @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$ValidationResult$Failure;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$ValidationResult;", "failReason", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$FailReason;", "(Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$FailReason;)V", "getFailReason", "()Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature$FailReason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$ValidationResult$Failure */
        /* compiled from: ValidateUpdateSignature.kt */
        public static final class Failure extends ValidationResult {
            private final FailReason failReason;

            public static /* synthetic */ Failure copy$default(Failure failure, FailReason failReason2, int i, Object obj) {
                if ((i & 1) != 0) {
                    failReason2 = failure.failReason;
                }
                return failure.copy(failReason2);
            }

            public final FailReason component1() {
                return this.failReason;
            }

            public final Failure copy(FailReason failReason2) {
                Intrinsics.checkNotNullParameter(failReason2, "failReason");
                return new Failure(failReason2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failure) && this.failReason == ((Failure) obj).failReason;
            }

            public int hashCode() {
                return this.failReason.hashCode();
            }

            public String toString() {
                return "Failure(failReason=" + this.failReason + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failure(FailReason failReason2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(failReason2, "failReason");
                this.failReason = failReason2;
            }

            public final FailReason getFailReason() {
                return this.failReason;
            }
        }
    }

    public final ValidationResult checkDataSynchronously() {
        return validateSignature();
    }
}
