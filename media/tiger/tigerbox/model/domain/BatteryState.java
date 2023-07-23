package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/BatteryState;", "", "(Ljava/lang/String;I)V", "EMPTY", "WEAK", "GOOD", "FULL", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: BatteryState.kt */
public enum BatteryState {
    EMPTY,
    WEAK,
    GOOD,
    FULL;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/BatteryState$Companion;", "", "()V", "getBatteryStateFromPercentage", "Lmedia/tiger/tigerbox/model/domain/BatteryState;", "percentage", "Lkotlin/UByte;", "getBatteryStateFromPercentage-7apg3OU", "(B)Lmedia/tiger/tigerbox/model/domain/BatteryState;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: BatteryState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getBatteryStateFromPercentage-7apg3OU  reason: not valid java name */
        public final BatteryState m2338getBatteryStateFromPercentage7apg3OU(byte b) {
            byte b2 = b & 255;
            if (!(UnsignedKt.uintCompare(UInt.m866constructorimpl(b2), 100) <= 0)) {
                throw new IllegalArgumentException("Percentage shouldn't be above 100".toString());
            } else if (UnsignedKt.uintCompare(UInt.m866constructorimpl(b2), 5) <= 0) {
                return BatteryState.EMPTY;
            } else {
                if (UnsignedKt.uintCompare(UInt.m866constructorimpl(b2), 20) <= 0) {
                    return BatteryState.WEAK;
                }
                if (UnsignedKt.uintCompare(UInt.m866constructorimpl(b2), 100) < 0) {
                    return BatteryState.GOOD;
                }
                return BatteryState.FULL;
            }
        }
    }
}
