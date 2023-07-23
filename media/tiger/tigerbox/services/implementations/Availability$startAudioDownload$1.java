package media.tiger.tigerbox.services.implementations;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.services.implementations.Availability;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.MultiFileDownloadState;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$startAudioDownload$1", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Availability.kt */
final class Availability$startAudioDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Availability.AudioDownload $download;
    int label;
    final /* synthetic */ Availability this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$startAudioDownload$1(Availability.AudioDownload audioDownload, Availability availability, Continuation<? super Availability$startAudioDownload$1> continuation) {
        super(2, continuation);
        this.$download = audioDownload;
        this.this$0 = availability;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Availability$startAudioDownload$1(this.$download, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Availability$startAudioDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int id = this.$download.getProduct().getId();
            if (this.this$0.isDownloaded(id)) {
                Job unused = this.this$0.finishAudioDownload(this.$download);
                return Unit.INSTANCE;
            }
            Job unused2 = this.this$0.addAudioDownload(this.$download);
            boolean unused3 = this.this$0.freeSpaceIfNeeded();
            File file = new File(this.this$0.pathForProduct(id));
            if (!file.exists()) {
                file.mkdirs();
            }
            Availability availability = this.this$0;
            Job unused4 = availability.addProfileToAudioProductFolder(this.$download, availability.getCurrentProfileId());
            this.this$0.flushAudioProductInfoToDisk(this.$download.getProduct());
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 1000;
            Availability.AudioDownload access$get_activeAudioDownload$p = this.this$0._activeAudioDownload;
            if (access$get_activeAudioDownload$p != null) {
                Availability availability2 = this.this$0;
                boolean unused5 = availability2.touchProductInfo(access$get_activeAudioDownload$p.getProduct().getId(), availability2.timeService.getCurrentSystemTimeMillis() + ((long) intRef.element));
                Job unused6 = availability2.publishDownloadedProductsDidChange();
                availability2.updateDownloadsInProgress();
                return Unit.INSTANCE;
            }
            this.this$0._activeAudioDownload = this.$download;
            List access$getAudioDownloadsInProgress = this.this$0.getAudioDownloadsInProgress();
            Availability availability3 = this.this$0;
            synchronized (access$getAudioDownloadsInProgress) {
                for (Availability.AudioDownload product : availability3.getAudioDownloadsInProgress()) {
                    intRef.element += 1000;
                    boolean unused7 = availability3.touchProductInfo(product.getProduct().getId(), availability3.timeService.getCurrentSystemTimeMillis() + ((long) intRef.element));
                }
                Unit unit = Unit.INSTANCE;
            }
            boolean unused8 = this.this$0.touchProductInfo(this.$download.getProduct().getId(), this.this$0.timeService.getCurrentSystemTimeMillis() + ((long) intRef.element));
            final ArrayList arrayList = new ArrayList();
            Iterator<AudioTrackModel> it = this.$download.getTracks().iterator();
            while (it.hasNext()) {
                AudioTrackModel next = it.next();
                arrayList.add(new DownloadsManagerService.FileDownloadInfo(next.getEncodingsM3UUrl(), next.getEncodingsM3ULocalPath()));
            }
            this.this$0.wakeService.addPartialWakeLock();
            final Availability.AudioDownload audioDownload = this.$download;
            final Availability availability4 = this.this$0;
            final Availability.AudioDownload audioDownload2 = this.$download;
            this.this$0.dlService.downloadFiles(arrayList, new Function0<Boolean>() {
                public final Boolean invoke() {
                    return Boolean.valueOf(!audioDownload.getCanceled());
                }
            }, new Function5<Boolean, String, String, List<? extends DownloadsManagerService.FileDownloadInfo>, MultiFileDownloadState, Unit>() {

                @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
                /* renamed from: media.tiger.tigerbox.services.implementations.Availability$startAudioDownload$1$4$WhenMappings */
                /* compiled from: Availability.kt */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[MultiFileDownloadState.values().length];
                        iArr[MultiFileDownloadState.FINISHED_ALL_SUCCESS.ordinal()] = 1;
                        iArr[MultiFileDownloadState.FINISHED_SOME_FAILED.ordinal()] = 2;
                        iArr[MultiFileDownloadState.FINISHED_ONE_DOWNLOADING_REST.ordinal()] = 3;
                        iArr[MultiFileDownloadState.CANCELED.ordinal()] = 4;
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke(((Boolean) obj).booleanValue(), (String) obj2, (String) obj3, (List<DownloadsManagerService.FileDownloadInfo>) (List) obj4, (MultiFileDownloadState) obj5);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, String str, String str2, final List<DownloadsManagerService.FileDownloadInfo> list, MultiFileDownloadState multiFileDownloadState) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 2>");
                    Intrinsics.checkNotNullParameter(list, "downloaded");
                    Intrinsics.checkNotNullParameter(multiFileDownloadState, "state");
                    int i = WhenMappings.$EnumSwitchMapping$0[multiFileDownloadState.ordinal()];
                    if (i == 1) {
                        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
                        final Availability availability = availability4;
                        final Availability.AudioDownload audioDownload = audioDownload2;
                        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C28751((Continuation<? super C28751>) null), 3, (Object) null);
                    } else if (i == 2) {
                        availability4.failAudioDownload(audioDownload2);
                    } else if (i == 3) {
                        float f = 0.0f;
                        if (arrayList.size() != 0) {
                            f = ((float) list.size()) / ((float) arrayList.size());
                        }
                        availability4.progressAudioDownload(audioDownload2, (int) (f * 10.0f));
                    } else if (i == 4) {
                        Job unused2 = availability4.finishAudioDownload(audioDownload2);
                    }
                }

                @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
                @DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$startAudioDownload$1$4$1", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
                /* renamed from: media.tiger.tigerbox.services.implementations.Availability$startAudioDownload$1$4$1 */
                /* compiled from: Availability.kt */
                static final class C28751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C28751(availability, audioDownload, list, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C28751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            availability.progressAudioDownload(audioDownload, 10);
                            List access$parseM3U8s = availability.parseM3U8s(list);
                            availability.downloadEncodingPlaylists(audioDownload, access$parseM3U8s);
                            if (access$parseM3U8s.isEmpty()) {
                                availability.downloadTsFiles(audioDownload, availability.parseEncodingPlaylists(audioDownload, list));
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            });
            Job unused9 = this.this$0.publishDownloadedProductsDidChange();
            this.this$0.updateDownloadsInProgress();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
