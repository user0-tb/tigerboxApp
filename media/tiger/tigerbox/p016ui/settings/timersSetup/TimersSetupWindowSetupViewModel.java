package media.tiger.tigerbox.p016ui.settings.timersSetup;

import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupViewModel;", "Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "timeLimitController", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "endWindowHour", "", "getEndWindowHour", "()I", "endWindowMinute", "getEndWindowMinute", "startWindowHour", "getStartWindowHour", "startWindowMinute", "getStartWindowMinute", "windowIdx", "getWindowIdx", "setWindowIdx", "(I)V", "deleteTimeWindow", "", "extractHHMM", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupViewModel$HHMM;", "aTime", "", "setTimeWindow", "start", "end", "HHMM", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel */
/* compiled from: TimersSetupWindowSetupViewModel.kt */
public final class TimersSetupWindowSetupViewModel extends FullScreenViewModel {
    private final StorageService storageService;
    private final TimersControllerService timeLimitController;
    private int windowIdx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public TimersSetupWindowSetupViewModel(StorageService storageService2, TimersControllerService timersControllerService, ButtonService buttonService, HeaderProvider headerProvider) {
        super(buttonService, headerProvider);
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(timersControllerService, "timeLimitController");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(headerProvider, "headerProvider");
        this.storageService = storageService2;
        this.timeLimitController = timersControllerService;
    }

    public final int getWindowIdx() {
        return this.windowIdx;
    }

    public final void setWindowIdx(int i) {
        this.windowIdx = i;
    }

    public final int getStartWindowHour() {
        List<WindowedLimits.WindowedLimit> limits = this.storageService.getWindowedLimit().getLimits();
        int i = this.windowIdx;
        if (i < 0 || i >= limits.size()) {
            return 0;
        }
        return extractHHMM(limits.get(this.windowIdx).getWindowStart()).getHour();
    }

    public final int getStartWindowMinute() {
        List<WindowedLimits.WindowedLimit> limits = this.storageService.getWindowedLimit().getLimits();
        int i = this.windowIdx;
        if (i < 0 || i >= limits.size()) {
            return 0;
        }
        return extractHHMM(limits.get(this.windowIdx).getWindowStart()).getMinute();
    }

    public final int getEndWindowHour() {
        List<WindowedLimits.WindowedLimit> limits = this.storageService.getWindowedLimit().getLimits();
        int i = this.windowIdx;
        if (i < 0 || i >= limits.size()) {
            return 23;
        }
        return extractHHMM(limits.get(this.windowIdx).getWindowEnd()).getHour();
    }

    public final int getEndWindowMinute() {
        List<WindowedLimits.WindowedLimit> limits = this.storageService.getWindowedLimit().getLimits();
        int i = this.windowIdx;
        if (i < 0 || i >= limits.size()) {
            return 59;
        }
        return extractHHMM(limits.get(this.windowIdx).getWindowEnd()).getMinute();
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupViewModel$HHMM;", "", "hour", "", "minute", "(II)V", "getHour", "()I", "getMinute", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel$HHMM */
    /* compiled from: TimersSetupWindowSetupViewModel.kt */
    private static final class HHMM {
        private final int hour;
        private final int minute;

        public static /* synthetic */ HHMM copy$default(HHMM hhmm, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = hhmm.hour;
            }
            if ((i3 & 2) != 0) {
                i2 = hhmm.minute;
            }
            return hhmm.copy(i, i2);
        }

        public final int component1() {
            return this.hour;
        }

        public final int component2() {
            return this.minute;
        }

        public final HHMM copy(int i, int i2) {
            return new HHMM(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HHMM)) {
                return false;
            }
            HHMM hhmm = (HHMM) obj;
            return this.hour == hhmm.hour && this.minute == hhmm.minute;
        }

        public int hashCode() {
            return (this.hour * 31) + this.minute;
        }

        public String toString() {
            return "HHMM(hour=" + this.hour + ", minute=" + this.minute + ')';
        }

        public HHMM(int i, int i2) {
            this.hour = i;
            this.minute = i2;
        }

        public final int getHour() {
            return this.hour;
        }

        public final int getMinute() {
            return this.minute;
        }
    }

    private final HHMM extractHHMM(String str) {
        Object[] array = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        CharSequence charSequence = strArr[0];
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        int parseInt = Integer.parseInt(charSequence.subSequence(i, length + 1).toString());
        CharSequence charSequence2 = strArr[1];
        int length2 = charSequence2.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = Intrinsics.compare((int) charSequence2.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (!z3) {
                if (!z4) {
                    z3 = true;
                } else {
                    i2++;
                }
            } else if (!z4) {
                break;
            } else {
                length2--;
            }
        }
        return new HHMM(parseInt, Integer.parseInt(charSequence2.subSequence(i2, length2 + 1).toString()));
    }

    public final void setTimeWindow(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, TtmlNode.START);
        Intrinsics.checkNotNullParameter(str2, TtmlNode.END);
        List mutableList = CollectionsKt.toMutableList(this.storageService.getWindowedLimit().getLimits());
        if (this.windowIdx >= mutableList.size()) {
            mutableList.add(new WindowedLimits.WindowedLimit(str, str2));
        } else {
            mutableList.set(this.windowIdx, new WindowedLimits.WindowedLimit(str, str2));
        }
        this.storageService.setWindowedLimit(new WindowedLimits(mutableList));
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("setTimeWindow " + this.storageService.getWindowedLimit(), new Object[0]);
        this.timeLimitController.initiateWindowedLimit();
    }

    public final void deleteTimeWindow() {
        List mutableList = CollectionsKt.toMutableList(this.storageService.getWindowedLimit().getLimits());
        int i = this.windowIdx;
        if (i >= 0 && i < mutableList.size()) {
            mutableList.remove(this.windowIdx);
        }
        this.storageService.setWindowedLimit(new WindowedLimits(mutableList));
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("deleteTimeWindow " + this.storageService.getWindowedLimit(), new Object[0]);
        this.timeLimitController.initiateWindowedLimit();
    }
}
