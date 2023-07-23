package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/AdbEnabler;", "", "invoke", "", "adbState", "Lmedia/tiger/tigerbox/services/interfaces/AdbEnabler$AdbState;", "AdbState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AdbEnabler.kt */
public interface AdbEnabler {
    void invoke(AdbState adbState);

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/AdbEnabler$AdbState;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "ENABLED", "DISABLED", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AdbEnabler.kt */
    public enum AdbState {
        ENABLED(1),
        DISABLED(0);
        
        private final int code;

        private AdbState(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }
}
