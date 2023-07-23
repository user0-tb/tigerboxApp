package media.tiger.tigerbox.p016ui.common.wifi;

import android.os.Bundle;
import androidx.fragment.app.FragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"media/tiger/tigerbox/ui/common/wifi/WifiEnterPasswordFragment$closeHandler$1", "Lmedia/tiger/tigerbox/ui/binding/UnTypedBindingClickListener;", "onClick", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordFragment$closeHandler$1 */
/* compiled from: WifiEnterPasswordFragment.kt */
public final class WifiEnterPasswordFragment$closeHandler$1 implements UnTypedBindingClickListener {
    final /* synthetic */ WifiEnterPasswordFragment this$0;

    WifiEnterPasswordFragment$closeHandler$1(WifiEnterPasswordFragment wifiEnterPasswordFragment) {
        this.this$0 = wifiEnterPasswordFragment;
    }

    public void onClick() {
        Bundle bundle = Bundle.EMPTY;
        Intrinsics.checkNotNullExpressionValue(bundle, "EMPTY");
        FragmentKt.setFragmentResult(this.this$0, WifiEnterPasswordFragment.REQUEST_KEY, bundle);
        androidx.navigation.fragment.FragmentKt.findNavController(this.this$0).navigateUp();
    }
}
