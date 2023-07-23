package media.tiger.tigerbox.services.implementations;

import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LightControl.kt */
final class LightControl$isMusicLightEnabled$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $value;
    final /* synthetic */ LightControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LightControl$isMusicLightEnabled$1(LightControl lightControl, boolean z) {
        super(0);
        this.this$0 = lightControl;
        this.$value = z;
    }

    public final void invoke() {
        this.this$0.writeFile("/sys/bus/i2c/devices/i2c-2/2-0064/led_debug", this.$value ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : SessionDescription.SUPPORTED_SDP_VERSION);
    }
}
