package media.tiger.tigerbox.p016ui.common;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentInfoDialogBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J-\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020\u001f2\b\b\u0001\u0010#\u001a\u00020$H\u0002J$\u0010.\u001a\u00020\u001f2\b\b\u0001\u0010#\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020,H\u0002J\u001c\u00102\u001a\u00020\u001f2\b\b\u0001\u0010#\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J'\u00103\u001a\u00020\u001f2\b\b\u0001\u0010#\u001a\u00020$2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002¢\u0006\u0002\u00104R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u00066"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/InfoDialogFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenDialogFragment;", "()V", "args", "Lmedia/tiger/tigerbox/ui/common/InfoDialogFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/common/InfoDialogFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentInfoDialogBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentInfoDialogBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentInfoDialogBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onViewCreated", "view", "setUpBodyText", "id", "", "quantityIndex", "formatParams", "", "", "(II[Ljava/lang/String;)V", "setUpCloseButton", "show", "", "setUpIcon", "setUpNegativeButton", "resultKey", "Lmedia/tiger/tigerbox/ui/common/InfoDialogTypeResult;", "isPositiveNegativeDialogue", "setUpPositiveButton", "setUpTitleText", "(I[Ljava/lang/String;)V", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.InfoDialogFragment */
/* compiled from: InfoDialogFragment.kt */
public final class InfoDialogFragment extends FullScreenDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(InfoDialogFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentInfoDialogBinding;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Integer[] RED_FILLED_DRAWABLES = {Integer.valueOf(C2814R.C2816drawable.vector_header_close)};
    public static final String REQUEST_KEY = "ERROR_DIALOG_FRAGMENT_REQUEST_KEY";
    public static final String RESULT_KEY = "RESULT_KEY";
    private final NavArgsLazy args$delegate;
    private final AutoClearedValue binding$delegate;

    public ImageView getCloseButton() {
        return null;
    }

    public DialogViewModel getViewModel() {
        return null;
    }

    public InfoDialogFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(InfoDialogFragmentArgs.class), new InfoDialogFragment$special$$inlined$navArgs$1(fragment));
    }

    private final FragmentInfoDialogBinding getBinding() {
        return (FragmentInfoDialogBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentInfoDialogBinding fragmentInfoDialogBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentInfoDialogBinding);
    }

    private final InfoDialogFragmentArgs getArgs() {
        return (InfoDialogFragmentArgs) this.args$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentInfoDialogBinding inflate = FragmentInfoDialogBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        InfoDialog infoDialog = getArgs().getDialogType().getInfoDialog();
        setUpCloseButton(infoDialog.getShowCloseButton());
        setUpIcon(infoDialog.getBackgroundImageId());
        setUpTitleText(infoDialog.getTitleTextId(), getArgs().getTitleFormatParams());
        setUpBodyText(infoDialog.getBodyTextId(), infoDialog.getQuantityIndex(), getArgs().getMessageFormatParams());
        setUpPositiveButton(infoDialog.getPositiveButtonTextId(), infoDialog.getPositiveResultKey());
        setUpNegativeButton(infoDialog.getNegativeButtonTextId(), infoDialog.getNegativeResultKey(), infoDialog.isPositiveNegativeDialog());
    }

    private final void setUpCloseButton(boolean z) {
        getBinding().setCloseButtonVisible(z);
        getBinding().closeButton.setOnClickListener(new InfoDialogFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpCloseButton$lambda-1  reason: not valid java name */
    public static final void m2372setUpCloseButton$lambda1(InfoDialogFragment infoDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(infoDialogFragment, "this$0");
        FragmentKt.findNavController(infoDialogFragment).navigateUp();
    }

    private final void setUpIcon(int i) {
        if (i == -2) {
            getBinding().infoDialogErrorIcon.setVisibility(8);
            getBinding().infoDialogGuideline.setGuidelinePercent(0.0f);
            getBinding().infoDialogSwipeIndicator.setVisibility(0);
        } else if (i != -1) {
            getBinding().infoDialogErrorIcon.setImageResource(i);
            getBinding().infoDialogGuideline.setGuidelinePercent(0.33f);
            if (ArraysKt.contains((T[]) RED_FILLED_DRAWABLES, Integer.valueOf(i))) {
                getBinding().infoDialogErrorIcon.setColorFilter(ContextCompat.getColor(requireContext(), C2814R.C2815color.error_red));
            }
        } else {
            getBinding().infoDialogErrorIcon.setVisibility(8);
            getBinding().infoDialogGuideline.setGuidelinePercent(0.0f);
        }
    }

    private final void setUpTitleText(int i, String[] strArr) {
        CharSequence charSequence;
        if (i == -1) {
            getBinding().infoDialogTitle.setVisibility(8);
            TextView textView = getBinding().infoDialogBody;
            textView.setTextSize(textView.getResources().getDimension(C2814R.dimen.text_size_large_xl));
            textView.setTypeface((Typeface) null, 1);
            return;
        }
        TextView textView2 = getBinding().infoDialogTitle;
        if (strArr == null) {
            charSequence = getString(i);
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(id)");
            Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
            String format = String.format(string, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            charSequence = format;
        }
        textView2.setText(charSequence);
    }

    private final void setUpBodyText(int i, int i2, String[] strArr) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("setUpBodyText " + i2 + ' ' + strArr, new Object[0]);
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                if (i2 < 0 || i2 >= strArr.length) {
                    TextView textView = getBinding().infoDialogBody;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(id)");
                    Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
                    String format = String.format(string, Arrays.copyOf(copyOf, copyOf.length));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    textView.setText(format);
                    return;
                }
                String quantityString = requireContext().getResources().getQuantityString(i, Integer.parseInt(strArr[i2]));
                Intrinsics.checkNotNullExpressionValue(quantityString, "requireContext().resourc…s[quantityIndex].toInt())");
                try {
                    TextView textView2 = getBinding().infoDialogBody;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    Object[] copyOf2 = Arrays.copyOf(strArr, strArr.length);
                    String format2 = String.format(quantityString, Arrays.copyOf(copyOf2, copyOf2.length));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    textView2.setText(format2);
                    return;
                } catch (Exception e) {
                    Timber.Tree tag = Timber.Forest.tag("InfoDialogFragment setUpBodyText");
                    tag.mo50217e("Exception: " + e.getMessage() + " text " + quantityString + " formatParams: " + strArr, new Object[0]);
                    getBinding().infoDialogBody.setText(quantityString);
                    return;
                }
            }
        }
        getBinding().infoDialogBody.setText(getText(i));
    }

    private final void setUpPositiveButton(int i, InfoDialogTypeResult infoDialogTypeResult) {
        if (i == -1) {
            getBinding().infoDialogSubmitButton.setVisibility(8);
        } else {
            getBinding().infoDialogSubmitButton.setText(getString(i));
            getBinding().infoDialogSubmitButton.setVisibility(0);
        }
        getBinding().infoDialogSubmitButton.setOnClickListener(new InfoDialogFragment$$ExternalSyntheticLambda1(this, infoDialogTypeResult));
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpPositiveButton$lambda-3  reason: not valid java name */
    public static final void m2374setUpPositiveButton$lambda3(InfoDialogFragment infoDialogFragment, InfoDialogTypeResult infoDialogTypeResult, View view) {
        Intrinsics.checkNotNullParameter(infoDialogFragment, "this$0");
        FragmentKt.findNavController(infoDialogFragment).navigateUp();
        if (infoDialogTypeResult != null) {
            infoDialogFragment.requireActivity().getSupportFragmentManager().setFragmentResult(REQUEST_KEY, BundleKt.bundleOf(TuplesKt.m475to("RESULT_KEY", infoDialogTypeResult.getText())));
        }
    }

    private final void setUpNegativeButton(int i, InfoDialogTypeResult infoDialogTypeResult, boolean z) {
        if (i == -1) {
            getBinding().infoDialogCancelButton.setVisibility(8);
        } else {
            getBinding().infoDialogCancelButton.setText(getString(i));
            getBinding().infoDialogCancelButton.setVisibility(0);
        }
        if (!z) {
            getBinding().infoDialogCancelButton.setBackgroundResource(C2814R.C2816drawable.selector_onboarding_dialog_button_submit);
        } else {
            getBinding().infoDialogCancelButton.setBackgroundResource(C2814R.C2816drawable.selector_onboarding_dialog_button_cancel);
        }
        getBinding().infoDialogCancelButton.setOnClickListener(new InfoDialogFragment$$ExternalSyntheticLambda2(this, infoDialogTypeResult));
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpNegativeButton$lambda-4  reason: not valid java name */
    public static final void m2373setUpNegativeButton$lambda4(InfoDialogFragment infoDialogFragment, InfoDialogTypeResult infoDialogTypeResult, View view) {
        Intrinsics.checkNotNullParameter(infoDialogFragment, "this$0");
        FragmentKt.findNavController(infoDialogFragment).navigateUp();
        if (infoDialogTypeResult != null) {
            infoDialogFragment.requireActivity().getSupportFragmentManager().setFragmentResult(REQUEST_KEY, BundleKt.bundleOf(TuplesKt.m475to("RESULT_KEY", infoDialogTypeResult.getText())));
        }
    }

    public void onPause() {
        super.onPause();
        requireActivity().getSupportFragmentManager().clearFragmentResult("RESULT_KEY");
        requireActivity().getSupportFragmentManager().clearFragmentResult(REQUEST_KEY);
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/InfoDialogFragment$Companion;", "", "()V", "RED_FILLED_DRAWABLES", "", "", "getRED_FILLED_DRAWABLES", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "REQUEST_KEY", "", "RESULT_KEY", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.InfoDialogFragment$Companion */
    /* compiled from: InfoDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Integer[] getRED_FILLED_DRAWABLES() {
            return InfoDialogFragment.RED_FILLED_DRAWABLES;
        }
    }
}
