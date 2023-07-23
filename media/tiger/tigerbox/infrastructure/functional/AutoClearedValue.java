package media.tiger.tigerbox.infrastructure.functional;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\"\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00042\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002¢\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)V", "_value", "Ljava/lang/Object;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AutoClearedValue.kt */
public final class AutoClearedValue<T> implements ReadWriteProperty<Fragment, T> {
    /* access modifiers changed from: private */
    public T _value;
    private final Fragment fragment;

    public AutoClearedValue(Fragment fragment2) {
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        this.fragment = fragment2;
        fragment2.getLifecycle().addObserver(new DefaultLifecycleObserver(this) {
            final /* synthetic */ AutoClearedValue<T> this$0;

            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onDestroy(this, lifecycleOwner);
            }

            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
            }

            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onResume(this, lifecycleOwner);
            }

            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onStart(this, lifecycleOwner);
            }

            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onStop(this, lifecycleOwner);
            }

            {
                this.this$0 = r1;
            }

            public void onCreate(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                this.this$0.getFragment().getViewLifecycleOwnerLiveData().observe(this.this$0.getFragment(), new AutoClearedValue$1$$ExternalSyntheticLambda0(this.this$0));
            }

            /* access modifiers changed from: private */
            /* renamed from: onCreate$lambda-0  reason: not valid java name */
            public static final void m2335onCreate$lambda0(AutoClearedValue autoClearedValue, LifecycleOwner lifecycleOwner) {
                Lifecycle lifecycle;
                Intrinsics.checkNotNullParameter(autoClearedValue, "this$0");
                if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                    lifecycle.addObserver(new AutoClearedValue$1$onCreate$1$1(autoClearedValue));
                }
            }
        });
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public T getValue(Fragment fragment2, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(fragment2, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t = this._value;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("should never call auto-cleared-value get when it might not be available");
    }

    public void setValue(Fragment fragment2, KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(fragment2, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t, "value");
        this._value = t;
    }
}
