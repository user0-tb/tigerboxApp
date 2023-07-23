package media.tiger.tigerbox.p016ui.binding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.infrastructure.GlideApp;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.model.domain.ConnectionState;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.model.domain.WifiStrength;
import media.tiger.tigerbox.p016ui.main.mediaplayer.OnMediaCoverImageClickListener;
import media.tiger.tigerbox.p016ui.settings.SettingsItemData;
import media.tiger.tigerbox.p016ui.view.BatteryView;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import media.tiger.tigerbox.utils.DateUtilsKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007\u001a\u001a\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a \u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007\u001a\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0007\u001a\u0018\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007\u001a\u0018\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018H\u0007\u001a\u0018\u0010$\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0007\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010'\u001a\u00020\u0016H\u0007\u001a\u0016\u0010)\u001a\u00020\u0001*\u00020\b2\b\b\u0001\u0010*\u001a\u00020\u0018H\u0007¨\u0006+"}, mo33737d2 = {"bindBatteryView", "", "batteryView", "Lmedia/tiger/tigerbox/ui/view/BatteryView;", "batterySummary", "Lmedia/tiger/tigerbox/model/domain/BatterySummary;", "bindFullScreenImageFromUrl", "view", "Landroid/widget/ImageView;", "imageUrl", "", "bindImageFromUrl", "bindMediaCoverImageClickListener", "Landroidx/constraintlayout/widget/ConstraintLayout;", "product", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioProductInfo;", "clickListener", "Lmedia/tiger/tigerbox/ui/main/mediaplayer/OnMediaCoverImageClickListener;", "connectedStateString", "textView", "Landroid/widget/TextView;", "connected", "", "percent", "", "displayTime", "timeInSec", "", "drawableIcon", "imageView", "item", "Lmedia/tiger/tigerbox/ui/settings/SettingsItemData;", "mediaPlayerSeekBarProgress", "seekBar", "Landroid/widget/SeekBar;", "trackProgress", "wifiStrengthIcon", "wifiItem", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "isPlaying", "Landroid/widget/ImageButton;", "setImageTint", "color", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.binding.BindingAdaptersKt */
/* compiled from: BindingAdapters.kt */
public final class BindingAdaptersKt {

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.binding.BindingAdaptersKt$WhenMappings */
    /* compiled from: BindingAdapters.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WifiStrength.values().length];
            iArr[WifiStrength.WIFI_WEAK.ordinal()] = 1;
            iArr[WifiStrength.WIFI_MEDIUM.ordinal()] = 2;
            iArr[WifiStrength.WIFI_STRONG.ordinal()] = 3;
            iArr[WifiStrength.NO_WIFI.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @BindingAdapter({"app:tint"})
    public static final void setImageTint(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        imageView.setColorFilter(i);
    }

    @BindingAdapter({"setBatterySummary"})
    public static final void bindBatteryView(BatteryView batteryView, BatterySummary batterySummary) {
        Intrinsics.checkNotNullParameter(batteryView, "batteryView");
        batteryView.setCharging(batterySummary != null ? batterySummary.isCharging() : false);
        batteryView.setBatteryPercent(batterySummary != null ? batterySummary.getBatteryPercent() : 0.0f);
    }

    @BindingAdapter({"imageFromUrl"})
    public static final void bindImageFromUrl(ImageView imageView, String str) {
        Intrinsics.checkNotNullParameter(imageView, "view");
        GlideApp.with(imageView.getContext()).load(str).error((int) C2814R.C2816drawable.background_product_item_placeholder).placeholder((int) C2814R.C2816drawable.background_product_item_placeholder).apply((BaseRequestOptions) RequestOptions.bitmapTransform(new RoundedCorners(imageView.getContext().getResources().getInteger(C2814R.integer.main_content_image_radius)))).listener((RequestListener) new BindingAdaptersKt$bindImageFromUrl$1(imageView)).into(imageView);
    }

    @BindingAdapter({"fullScreenImageFromUrl"})
    public static final void bindFullScreenImageFromUrl(ImageView imageView, String str) {
        Intrinsics.checkNotNullParameter(imageView, "view");
        GlideApp.with(imageView.getContext()).load(str).error((int) C2814R.C2816drawable.background_product_item_placeholder).placeholder((int) C2814R.C2816drawable.background_product_item_placeholder).into(imageView);
    }

    @BindingAdapter({"product", "mediaImageClickListener"})
    public static final void bindMediaCoverImageClickListener(ConstraintLayout constraintLayout, AudioProductInfo audioProductInfo, OnMediaCoverImageClickListener onMediaCoverImageClickListener) {
        Intrinsics.checkNotNullParameter(constraintLayout, "view");
        Intrinsics.checkNotNullParameter(onMediaCoverImageClickListener, "clickListener");
        if (audioProductInfo != null) {
            constraintLayout.setOnClickListener(new BindingAdaptersKt$$ExternalSyntheticLambda0(onMediaCoverImageClickListener, audioProductInfo));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindMediaCoverImageClickListener$lambda-2$lambda-1  reason: not valid java name */
    public static final void m2358bindMediaCoverImageClickListener$lambda2$lambda1(OnMediaCoverImageClickListener onMediaCoverImageClickListener, AudioProductInfo audioProductInfo, View view) {
        Intrinsics.checkNotNullParameter(onMediaCoverImageClickListener, "$clickListener");
        Intrinsics.checkNotNullParameter(audioProductInfo, "$productInfo");
        onMediaCoverImageClickListener.onClick(audioProductInfo.getCoverPath());
    }

    @BindingAdapter({"wifiStrengthIcon"})
    public static final void wifiStrengthIcon(ImageView imageView, WifiItem wifiItem) {
        int i;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(wifiItem, "wifiItem");
        int i2 = WhenMappings.$EnumSwitchMapping$0[wifiItem.getWifiStrength().ordinal()];
        int i3 = C2814R.mipmap.parent_wifi_inactive;
        if (i2 == 1) {
            i = wifiItem.isSecure() ? C2814R.C2816drawable.vector_wifi_locked_level_1 : C2814R.C2816drawable.vector_wifi_level_1;
        } else if (i2 == 2) {
            i = wifiItem.isSecure() ? C2814R.C2816drawable.vector_wifi_locked_level_2 : C2814R.C2816drawable.vector_wifi_level_2;
        } else if (i2 == 3) {
            i = wifiItem.isSecure() ? C2814R.C2816drawable.vector_wifi_locked_level_3 : C2814R.C2816drawable.vector_wifi_level_3;
        } else if (i2 == 4) {
            i = C2814R.mipmap.parent_wifi_inactive;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (!wifiItem.isHeader() || (imageView.isEnabled() && wifiItem.getConnectionState() != ConnectionState.NOT_CONNECTED)) {
            i3 = i;
        } else {
            Timber.Forest.mo50214d("WIFI ICON parent_wifi_inactive", new Object[0]);
        }
        imageView.setImageDrawable(AppCompatResources.getDrawable(imageView.getContext(), i3));
    }

    @BindingAdapter({"isConnected", "batteryLevel"})
    public static final void connectedStateString(TextView textView, boolean z, int i) {
        String str;
        Intrinsics.checkNotNullParameter(textView, "textView");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        if (z) {
            str = textView.getContext().getString(C2814R.string.ota_battery_connected_low_power_text);
        } else {
            str = textView.getContext().getString(C2814R.string.ota_battery_disconnected_low_power_text);
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (connected) {\n       …low_power_text)\n        }");
        String format = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string = textView.getContext().getString(C2814R.string.ota_battery_low_power_text);
        Intrinsics.checkNotNullExpressionValue(string, "textView.context.getStri…a_battery_low_power_text)");
        String format2 = String.format(string, Arrays.copyOf(new Object[]{format}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView.setText(format2);
    }

    @BindingAdapter({"drawableIcon"})
    public static final void drawableIcon(ImageView imageView, SettingsItemData settingsItemData) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(settingsItemData, "item");
        imageView.setImageDrawable(AppCompatResources.getDrawable(imageView.getContext(), settingsItemData.getIcon()));
    }

    @BindingAdapter({"isPlaying"})
    public static final void isPlaying(ImageButton imageButton, boolean z) {
        Intrinsics.checkNotNullParameter(imageButton, "<this>");
        if (!z) {
            imageButton.setBackgroundTintList(ContextCompat.getColorStateList(imageButton.getContext(), 17170445));
            imageButton.setImageDrawable(ContextCompat.getDrawable(imageButton.getContext(), C2814R.C2816drawable.media_player_play));
            return;
        }
        imageButton.setBackgroundTintList(ContextCompat.getColorStateList(imageButton.getContext(), C2814R.C2815color.main_theme_color));
        imageButton.setImageDrawable(ContextCompat.getDrawable(imageButton.getContext(), C2814R.C2816drawable.media_player_pause));
    }

    @BindingAdapter({"displayTime"})
    public static final void displayTime(TextView textView, long j) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setText(DateUtilsKt.toTimeString(j * 1000));
    }

    @BindingAdapter({"trackProgress"})
    public static final void mediaPlayerSeekBarProgress(SeekBar seekBar, int i) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        seekBar.setProgress(i);
    }
}
