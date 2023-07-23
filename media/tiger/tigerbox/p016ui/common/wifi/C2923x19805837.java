package media.tiger.tigerbox.p016ui.common.wifi;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.databinding.FragmentWifiEnterPasswordBinding;

@Metadata(mo33736d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, mo33737d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordFragment$onCreateView$lambda-2$$inlined$doOnTextChanged$1 */
/* compiled from: TextView.kt */
public final class C2923x19805837 implements TextWatcher {
    final /* synthetic */ FragmentWifiEnterPasswordBinding $this_apply$inlined;
    final /* synthetic */ WifiEnterPasswordFragment this$0;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C2923x19805837(FragmentWifiEnterPasswordBinding fragmentWifiEnterPasswordBinding, WifiEnterPasswordFragment wifiEnterPasswordFragment) {
        this.$this_apply$inlined = fragmentWifiEnterPasswordBinding;
        this.this$0 = wifiEnterPasswordFragment;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z = false;
        this.$this_apply$inlined.wifiEnterPswConfirmButton.setEnabled(charSequence != null && (StringsKt.isBlank(charSequence) ^ true));
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (z) {
            this.this$0.getBinding().wifiEnterPswEditTextLayout.setPasswordVisibilityToggleEnabled(true);
        }
    }
}
