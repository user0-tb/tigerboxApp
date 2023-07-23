package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.data.network.OtaWebService;
import media.tiger.tigerbox.infrastructure.functional.DownloadProgressUpdate;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DownloadWithAsyncTask;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler;
import media.tiger.tigerbox.services.interfaces.AssetService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import okhttp3.ResponseBody;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u001a!\u0018\u0000 =2\u00020\u0001:\u0003=>?BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J!\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020!2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002¢\u0006\u0002\u0010\"J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002J8\u0010#\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002J\u0010\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0007JB\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001e0\u001c2\b\b\u0002\u0010.\u001a\u00020\u0014H\u0002J$\u0010/\u001a\u00020-2\u0006\u0010+\u001a\u00020,2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002J^\u00100\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u00101\u001a\u0002022!\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u001e0\u001c2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u001e0\u001c2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:H\u0002J[\u0010;\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u00101\u001a\u0002022!\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u001e0\u001c2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u001e0\u001c2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:J$\u0010<\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware;", "", "otaWebService", "Lmedia/tiger/tigerbox/data/network/OtaWebService;", "validateDigest", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DigestValidator;", "assetService", "Lmedia/tiger/tigerbox/services/interfaces/AssetService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "downloadProgressNotifier", "Lmedia/tiger/tigerbox/infrastructure/functional/DownloadProgressUpdate;", "base64Converter", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/Base64Converter;", "largeDownloadHandler", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Lmedia/tiger/tigerbox/data/network/OtaWebService;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DigestValidator;Lmedia/tiger/tigerbox/services/interfaces/AssetService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/infrastructure/functional/DownloadProgressUpdate;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/Base64Converter;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "maxAttempts", "", "getMaxAttempts", "()I", "maxAttempts$delegate", "Lkotlin/Lazy;", "createDownloadListener", "media/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$createDownloadListener$1", "method", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$createDownloadListener$1;", "createValidationListener", "media/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$createValidationListener$1", "(Lkotlin/jvm/functions/Function1;)Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$createValidationListener$1;", "downloadAndValidateFirmware", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$ValidationResult;", "release", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "progressUpdate", "onComplete", "downloadAndValidateFirmwareSynchronously", "downloadAsyncWithRetry", "url", "", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result;", "attempts", "downloadFirmware", "invoke", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "update", "Lkotlin/ParameterName;", "name", "percent", "onFail", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$FailReason;", "onSuccess", "Lkotlin/Function0;", "invokeAsync", "validateFirmware", "Companion", "FailReason", "ValidationResult", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware */
/* compiled from: DownloadFirmware.kt */
public final class DownloadFirmware {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DOWNLOAD_TOTAL_PERCENT = 50.0f;
    private final AssetService assetService;
    private final Base64Converter base64Converter;
    /* access modifiers changed from: private */
    public final ConfigurationProperties configurationProperties;
    private final DownloadProgressUpdate downloadProgressNotifier;
    private final LargeDownloadHandler largeDownloadHandler;
    private final Lazy maxAttempts$delegate = LazyKt.lazy(new DownloadFirmware$maxAttempts$2(this));
    /* access modifiers changed from: private */
    public final OtaWebService otaWebService;
    private final StorageService storageService;
    private final DigestValidator validateDigest;

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$FailReason;", "", "(Ljava/lang/String;I)V", "DOWNLOAD_UNSUCCESSFUL", "FILE_NOT_FOUND", "TIMEOUT", "UNABLE_TO_SAVE", "INVALID_IMAGE", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$FailReason */
    /* compiled from: DownloadFirmware.kt */
    public enum FailReason {
        DOWNLOAD_UNSUCCESSFUL,
        FILE_NOT_FOUND,
        TIMEOUT,
        UNABLE_TO_SAVE,
        INVALID_IMAGE
    }

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$WhenMappings */
    /* compiled from: DownloadFirmware.kt */
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
    public DownloadFirmware(OtaWebService otaWebService2, DigestValidator digestValidator, AssetService assetService2, StorageService storageService2, DownloadProgressUpdate downloadProgressUpdate, Base64Converter base64Converter2, LargeDownloadHandler largeDownloadHandler2, ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(otaWebService2, "otaWebService");
        Intrinsics.checkNotNullParameter(digestValidator, "validateDigest");
        Intrinsics.checkNotNullParameter(assetService2, "assetService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(downloadProgressUpdate, "downloadProgressNotifier");
        Intrinsics.checkNotNullParameter(base64Converter2, "base64Converter");
        Intrinsics.checkNotNullParameter(largeDownloadHandler2, "largeDownloadHandler");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        this.otaWebService = otaWebService2;
        this.validateDigest = digestValidator;
        this.assetService = assetService2;
        this.storageService = storageService2;
        this.downloadProgressNotifier = downloadProgressUpdate;
        this.base64Converter = base64Converter2;
        this.largeDownloadHandler = largeDownloadHandler2;
        this.configurationProperties = configurationProperties2;
    }

    /* access modifiers changed from: private */
    public final int getMaxAttempts() {
        return ((Number) this.maxAttempts$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final ValidationResult downloadAndValidateFirmware(ReleaseInformation.Release release, Function1<? super Double, Unit> function1) {
        LargeDownloadHandler.Result downloadFirmware = downloadFirmware(release.getUrl(), function1);
        if (downloadFirmware instanceof LargeDownloadHandler.Result.Failure) {
            int i = WhenMappings.$EnumSwitchMapping$0[((LargeDownloadHandler.Result.Failure) downloadFirmware).getReason().ordinal()];
            if (i == 1) {
                return new ValidationResult.Failure(FailReason.DOWNLOAD_UNSUCCESSFUL);
            }
            if (i == 2) {
                return new ValidationResult.Failure(FailReason.FILE_NOT_FOUND);
            }
            if (i == 3) {
                return new ValidationResult.Failure(FailReason.TIMEOUT);
            }
            if (i == 4) {
                return new ValidationResult.Failure(FailReason.DOWNLOAD_UNSUCCESSFUL);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (downloadFirmware instanceof LargeDownloadHandler.Result.Success) {
            StorageService storageService2 = this.storageService;
            ResponseBody body = ((LargeDownloadHandler.Result.Success) downloadFirmware).getResponse().body();
            Intrinsics.checkNotNull(body);
            if (!storageService2.saveFirmware(body)) {
                return new ValidationResult.Failure(FailReason.UNABLE_TO_SAVE);
            }
        }
        return validateFirmware(release, function1);
    }

    private final LargeDownloadHandler.Result downloadFirmware(String str, Function1<? super Double, Unit> function1) {
        this.downloadProgressNotifier.subscribe(createDownloadListener(function1));
        LargeDownloadHandler.Result invoke = this.largeDownloadHandler.invoke(new DownloadFirmware$downloadFirmware$response$1(this, str), new DownloadFirmware$downloadFirmware$response$2(str));
        int i = 1;
        while ((invoke instanceof LargeDownloadHandler.Result.Failure) && i < getMaxAttempts()) {
            i++;
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("Firmware Update: Failed. Retry attempt: " + i, new Object[0]);
            invoke = this.largeDownloadHandler.invoke(new DownloadFirmware$downloadFirmware$1(this, str), new DownloadFirmware$downloadFirmware$2(str));
        }
        return invoke;
    }

    private final void downloadAndValidateFirmware(ReleaseInformation.Release release, Function1<? super Double, Unit> function1, Function1<? super ValidationResult, Unit> function12) {
        downloadAsyncWithRetry(release.getUrl(), function1, new DownloadFirmware$downloadAndValidateFirmware$1(function12, this, release, function1), 1);
    }

    static /* synthetic */ void downloadAsyncWithRetry$default(DownloadFirmware downloadFirmware, String str, Function1 function1, Function1 function12, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 1;
        }
        downloadFirmware.downloadAsyncWithRetry(str, function1, function12, i);
    }

    /* access modifiers changed from: private */
    public final void downloadAsyncWithRetry(String str, Function1<? super Double, Unit> function1, Function1<? super LargeDownloadHandler.Result, Unit> function12, int i) {
        Function1<? super Double, Unit> function13 = function1;
        String str2 = str;
        new DownloadWithAsyncTask(new DownloadWithAsyncTask.DownloadInfo(str2, this.storageService.getFirmwareDownloadPath(), createDownloadListener(function13), new DownloadFirmware$downloadAsyncWithRetry$asyncTask$1(i, this, str, function13, function12), new DownloadFirmware$downloadAsyncWithRetry$asyncTask$2(function12))).execute(new Unit[0]);
    }

    /* access modifiers changed from: private */
    public final ValidationResult validateFirmware(ReleaseInformation.Release release, Function1<? super Double, Unit> function1) {
        ValidationResult validationResult;
        Function1 createValidationListener = createValidationListener(function1);
        this.validateDigest.subscribe(createValidationListener);
        if (this.validateDigest.invoke(this.storageService.getFirmwareDownloadPath(), this.assetService.getOtaPublicKey(), release.getSignature(), this.base64Converter)) {
            validationResult = ValidationResult.Success.INSTANCE;
        } else {
            this.storageService.deleteFirmware();
            validationResult = new ValidationResult.Failure(FailReason.INVALID_IMAGE);
        }
        this.validateDigest.unsubscribe(createValidationListener);
        return validationResult;
    }

    public final void invoke(ReleaseInformation.Release release, CoroutineScope coroutineScope, Function1<? super Double, Unit> function1, Function1<? super FailReason, Unit> function12, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(release, "release");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function12, "onFail");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new DownloadFirmware$invoke$1(this, release, function1, function0, function12, (Continuation<? super DownloadFirmware$invoke$1>) null), 2, (Object) null);
    }

    public final void invokeAsync(ReleaseInformation.Release release, CoroutineScope coroutineScope, Function1<? super Double, Unit> function1, Function1<? super FailReason, Unit> function12, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(release, "release");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function12, "onFail");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        downloadAndValidateFirmware(release, function1, new DownloadFirmware$invokeAsync$1(coroutineScope, function0, function12));
    }

    @Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$ValidationResult;", "", "()V", "Failure", "Success", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$ValidationResult$Success;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$ValidationResult$Failure;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$ValidationResult */
    /* compiled from: DownloadFirmware.kt */
    public static abstract class ValidationResult {
        public /* synthetic */ ValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$ValidationResult$Success;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$ValidationResult;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$ValidationResult$Success */
        /* compiled from: DownloadFirmware.kt */
        public static final class Success extends ValidationResult {
            public static final Success INSTANCE = new Success();

            private Success() {
                super((DefaultConstructorMarker) null);
            }
        }

        private ValidationResult() {
        }

        @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$ValidationResult$Failure;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$ValidationResult;", "failReason", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$FailReason;", "(Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$FailReason;)V", "getFailReason", "()Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$FailReason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$ValidationResult$Failure */
        /* compiled from: DownloadFirmware.kt */
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

    private final DownloadFirmware$createDownloadListener$1 createDownloadListener(Function1<? super Double, Unit> function1) {
        return new DownloadFirmware$createDownloadListener$1(function1);
    }

    private final DownloadFirmware$createValidationListener$1 createValidationListener(Function1<? super Double, Unit> function1) {
        return new DownloadFirmware$createValidationListener$1(function1);
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$Companion;", "", "()V", "DOWNLOAD_TOTAL_PERCENT", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$Companion */
    /* compiled from: DownloadFirmware.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ValidationResult downloadAndValidateFirmwareSynchronously(ReleaseInformation.Release release) {
        Intrinsics.checkNotNullParameter(release, "release");
        return downloadAndValidateFirmware(release, DownloadFirmware$downloadAndValidateFirmwareSynchronously$1.INSTANCE);
    }
}
