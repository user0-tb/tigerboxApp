package p012io.shipbook.shipbooksdk.Events;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import java.util.Date;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.InnerLog;
import p012io.shipbook.shipbooksdk.LogManager;
import p012io.shipbook.shipbooksdk.Models.ActionEvent;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.Util.CompoundButtonExtKt;
import p012io.shipbook.shipbooksdk.Util.SeekBarExtKt;
import p012io.shipbook.shipbooksdk.Util.ViewExtKt;
import p012io.shipbook.shipbooksdk.Util.ViewGroupExtKt;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Events/ActionEventManager;", "", "()V", "TAG", "", "ignoreViews", "", "", "getIgnoreViews", "()Ljava/util/Set;", "setIgnoreViews", "(Ljava/util/Set;)V", "createActionEvent", "", "action", "title", "view", "Landroid/view/View;", "registerView", "registerViews", "parent", "Landroid/view/ViewGroup;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Events.ActionEventManager */
/* compiled from: ActionEventManager.kt */
public final class ActionEventManager {
    public static final ActionEventManager INSTANCE = new ActionEventManager();
    private static final String TAG = "ActionEventManager";
    private static Set<Integer> ignoreViews = SetsKt.emptySet();

    private ActionEventManager() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("ActionEventManager", "ActionEventManager::class.java.simpleName");
    }

    public final Set<Integer> getIgnoreViews() {
        return ignoreViews;
    }

    public final void setIgnoreViews(Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        ignoreViews = set;
    }

    /* access modifiers changed from: private */
    public final void createActionEvent(String str, String str2, View view) {
        String simpleName = view.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "view.javaClass.simpleName");
        ActionEvent actionEvent = new ActionEvent(str, simpleName, str2, "", 0, (Date) null, (BaseLog.ThreadInfo) null, 112, (DefaultConstructorMarker) null);
        InnerLog.v$default(InnerLog.INSTANCE, TAG, Intrinsics.stringPlus("added action event: ", actionEvent), (Throwable) null, 4, (Object) null);
        LogManager.INSTANCE.push(actionEvent);
    }

    private final void registerView(View view) {
        if (!ignoreViews.contains(Integer.valueOf(view.getId()))) {
            if (view instanceof ViewGroup) {
                registerViews((ViewGroup) view);
            } else if (view instanceof CompoundButton) {
                CompoundButton compoundButton = (CompoundButton) view;
                compoundButton.setOnCheckedChangeListener(new ActionEventManager$$ExternalSyntheticLambda1(view, CompoundButtonExtKt.getOnCheckedChangeListener(compoundButton)));
            } else if (view instanceof Button) {
                view.setOnClickListener(new ActionEventManager$$ExternalSyntheticLambda0(view, ViewExtKt.getOnClickListener(view)));
            } else if (view instanceof EditText) {
                ((EditText) view).addTextChangedListener(new ActionEventManager$registerView$3(view));
            } else if (view instanceof SeekBar) {
                SeekBar seekBar = (SeekBar) view;
                seekBar.setOnSeekBarChangeListener(new ActionEventManager$registerView$4(SeekBarExtKt.getOnSeekBarChangeListener(seekBar)));
            } else if (view instanceof Spinner) {
                Spinner spinner = (Spinner) view;
                spinner.setOnItemSelectedListener(new ActionEventManager$registerView$5(spinner.getOnItemSelectedListener()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerView$lambda-0  reason: not valid java name */
    public static final void m765registerView$lambda0(View view, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(view, "$view");
        INSTANCE.createActionEvent("onCheckedChange", ((CompoundButton) view).getText().toString(), view);
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerView$lambda-1  reason: not valid java name */
    public static final void m766registerView$lambda1(View view, View.OnClickListener onClickListener, View view2) {
        Intrinsics.checkNotNullParameter(view, "$view");
        ActionEventManager actionEventManager = INSTANCE;
        String obj = ((Button) view).getText().toString();
        Intrinsics.checkNotNullExpressionValue(view2, "it");
        actionEventManager.createActionEvent("onClick", obj, view2);
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void registerViews(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        for (View registerView : ViewGroupExtKt.getViews(viewGroup)) {
            INSTANCE.registerView(registerView);
        }
    }
}
