package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LightControl.kt */
final class LightControl$tigerLightIntensity$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $deviceValue;
    final /* synthetic */ LightControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LightControl$tigerLightIntensity$1(LightControl lightControl, int i) {
        super(0);
        this.this$0 = lightControl;
        this.$deviceValue = i;
    }

    public final void invoke() {
        this.this$0.modifyTigerLightIntensity(this.$deviceValue);
    }
}
