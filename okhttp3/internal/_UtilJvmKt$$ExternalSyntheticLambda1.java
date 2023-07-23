package okhttp3.internal;

import okhttp3.Call;
import okhttp3.EventListener;

public final /* synthetic */ class _UtilJvmKt$$ExternalSyntheticLambda1 implements EventListener.Factory {
    public final /* synthetic */ EventListener f$0;

    public /* synthetic */ _UtilJvmKt$$ExternalSyntheticLambda1(EventListener eventListener) {
        this.f$0 = eventListener;
    }

    public final EventListener create(Call call) {
        return _UtilJvmKt.m2725asFactory$lambda7(this.f$0, call);
    }
}
