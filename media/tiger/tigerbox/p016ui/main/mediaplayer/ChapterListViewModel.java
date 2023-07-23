package media.tiger.tigerbox.p016ui.main.mediaplayer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.ChapterItem;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;

@Metadata(mo33736d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u0018R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/ChapterListViewModel;", "Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "_chapterList", "Landroidx/lifecycle/MutableLiveData;", "", "Lmedia/tiger/tigerbox/model/domain/ChapterItem;", "chapterList", "Landroidx/lifecycle/LiveData;", "getChapterList", "()Landroidx/lifecycle/LiveData;", "chapterTitle", "", "getChapterTitle", "()Ljava/lang/String;", "onClick", "", "data", "updateData", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.ChapterListViewModel */
/* compiled from: ChapterListViewModel.kt */
public final class ChapterListViewModel extends FullScreenViewModel {
    private final MutableLiveData<List<ChapterItem>> _chapterList = new MutableLiveData<>();
    private final AudioPlayerService audioPlayerService;
    private final StorageService storageService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ChapterListViewModel(AudioPlayerService audioPlayerService2, StorageService storageService2, ButtonService buttonService, HeaderProvider headerProvider) {
        super(buttonService, headerProvider);
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(headerProvider, "headerProvider");
        this.audioPlayerService = audioPlayerService2;
        this.storageService = storageService2;
    }

    public final LiveData<List<ChapterItem>> getChapterList() {
        return this._chapterList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = (r0 = r0.getProduct()).getTitle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getChapterTitle() {
        /*
            r1 = this;
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r0 = r1.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r0 = r0.getCurrentItem()
            if (r0 == 0) goto L_0x0014
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r0 = r0.getProduct()
            if (r0 == 0) goto L_0x0014
            java.lang.String r0 = r0.getTitle()
            if (r0 != 0) goto L_0x0016
        L_0x0014:
            java.lang.String r0 = ""
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.mediaplayer.ChapterListViewModel.getChapterTitle():java.lang.String");
    }

    public final void onClick(ChapterItem chapterItem) {
        Intrinsics.checkNotNullParameter(chapterItem, "data");
        if (chapterItem.isProduct()) {
            this.audioPlayerService.playPlaylistItem(chapterItem.getPosition());
        } else {
            this.audioPlayerService.setTrackIndex(chapterItem.getId());
            this.audioPlayerService.play();
        }
        updateData();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateData() {
        /*
            r17 = this;
            r0 = r17
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r2 = r0.audioPlayerService
            int r2 = r2.getTrackIndex()
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r3 = r0.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist r3 = r3.getCurrentPlaylist()
            r5 = 0
            if (r3 == 0) goto L_0x0063
            java.util.List r3 = r3.getProducts()
            if (r3 == 0) goto L_0x0063
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.lang.Iterable r3 = kotlin.collections.CollectionsKt.withIndex(r3)
            if (r3 == 0) goto L_0x0063
            java.util.Iterator r3 = r3.iterator()
        L_0x0028:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0059
            java.lang.Object r6 = r3.next()
            r7 = r6
            kotlin.collections.IndexedValue r7 = (kotlin.collections.IndexedValue) r7
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r8 = r0.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r8 = r8.getCurrentItem()
            if (r8 == 0) goto L_0x0055
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r8 = r8.getProduct()
            if (r8 == 0) goto L_0x0055
            java.lang.Object r7 = r7.getValue()
            media.tiger.tigerbox.webserver.dto.PlaybackDto r7 = (media.tiger.tigerbox.webserver.dto.PlaybackDto) r7
            int r7 = r7.getProductId()
            int r8 = r8.getId()
            if (r7 != r8) goto L_0x0055
            r7 = 1
            goto L_0x0056
        L_0x0055:
            r7 = 0
        L_0x0056:
            if (r7 == 0) goto L_0x0028
            goto L_0x005a
        L_0x0059:
            r6 = 0
        L_0x005a:
            kotlin.collections.IndexedValue r6 = (kotlin.collections.IndexedValue) r6
            if (r6 == 0) goto L_0x0063
            int r3 = r6.getIndex()
            goto L_0x0064
        L_0x0063:
            r3 = 0
        L_0x0064:
            media.tiger.tigerbox.services.interfaces.StorageService r6 = r0.storageService
            boolean r6 = r6.getAutoplay()
            if (r6 == 0) goto L_0x00b4
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r6 = r0.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist r6 = r6.getCurrentPlaylist()
            if (r6 == 0) goto L_0x00b4
            java.util.List r6 = r6.getProducts()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r10 = 0
        L_0x007f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00b4
            java.lang.Object r7 = r6.next()
            int r15 = r10 + 1
            if (r10 >= 0) goto L_0x0090
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0090:
            media.tiger.tigerbox.webserver.dto.PlaybackDto r7 = (media.tiger.tigerbox.webserver.dto.PlaybackDto) r7
            if (r10 > r3) goto L_0x00b2
            java.lang.String r9 = r7.getTitle()
            if (r9 == 0) goto L_0x00b2
            media.tiger.tigerbox.model.domain.ChapterItem r14 = new media.tiger.tigerbox.model.domain.ChapterItem
            int r8 = r7.getProductId()
            r12 = 0
            r13 = 1
            java.lang.String r16 = r7.getCoverUrl()
            java.lang.String r11 = ""
            r7 = r14
            r4 = r14
            r14 = r16
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            r1.add(r4)
        L_0x00b2:
            r10 = r15
            goto L_0x007f
        L_0x00b4:
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r4 = r0.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r4 = r4.getCurrentItem()
            if (r4 == 0) goto L_0x00ff
            java.util.ArrayList r4 = r4.getTracks()
            if (r4 == 0) goto L_0x00ff
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r7 = 0
        L_0x00c9:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00ff
            java.lang.Object r6 = r4.next()
            int r14 = r7 + 1
            if (r7 >= 0) goto L_0x00da
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00da:
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel r6 = (media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel) r6
            long r8 = r6.getDuration()
            r10 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r10
            java.lang.String r10 = media.tiger.tigerbox.utils.DateUtilsKt.toTimeString(r8)
            media.tiger.tigerbox.model.domain.ChapterItem r15 = new media.tiger.tigerbox.model.domain.ChapterItem
            java.lang.String r8 = r6.getTitle()
            if (r7 != r2) goto L_0x00f2
            r11 = 1
            goto L_0x00f3
        L_0x00f2:
            r11 = 0
        L_0x00f3:
            r12 = 0
            r13 = 0
            r6 = r15
            r9 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r1.add(r15)
            r7 = r14
            goto L_0x00c9
        L_0x00ff:
            media.tiger.tigerbox.services.interfaces.StorageService r2 = r0.storageService
            boolean r2 = r2.getAutoplay()
            if (r2 == 0) goto L_0x014c
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r2 = r0.audioPlayerService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist r2 = r2.getCurrentPlaylist()
            if (r2 == 0) goto L_0x014c
            java.util.List r2 = r2.getProducts()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r9 = 0
        L_0x011a:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x014c
            java.lang.Object r4 = r2.next()
            int r5 = r9 + 1
            if (r9 >= 0) goto L_0x012b
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x012b:
            media.tiger.tigerbox.webserver.dto.PlaybackDto r4 = (media.tiger.tigerbox.webserver.dto.PlaybackDto) r4
            if (r3 >= r9) goto L_0x014a
            java.lang.String r8 = r4.getTitle()
            if (r8 == 0) goto L_0x014a
            media.tiger.tigerbox.model.domain.ChapterItem r14 = new media.tiger.tigerbox.model.domain.ChapterItem
            int r7 = r4.getProductId()
            r11 = 0
            r12 = 1
            java.lang.String r13 = r4.getCoverUrl()
            java.lang.String r10 = ""
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r1.add(r14)
        L_0x014a:
            r9 = r5
            goto L_0x011a
        L_0x014c:
            androidx.lifecycle.MutableLiveData<java.util.List<media.tiger.tigerbox.model.domain.ChapterItem>> r2 = r0._chapterList
            r2.setValue(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.mediaplayer.ChapterListViewModel.updateData():void");
    }
}
