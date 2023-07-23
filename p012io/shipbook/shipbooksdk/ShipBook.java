package p012io.shipbook.shipbooksdk;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.Events.ActionEventManager;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.Models.Message;
import p012io.shipbook.shipbooksdk.Models.ScreenEvent;
import p012io.shipbook.shipbooksdk.Networking.ConnectionClient;
import p012io.shipbook.shipbooksdk.Networking.SessionManager;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/ShipBook;", "", "()V", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.ShipBook */
/* compiled from: ShipBook.kt */
public final class ShipBook {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final void addWrapperClass(String str) {
        Companion.addWrapperClass(str);
    }

    @JvmStatic
    public static final void enableInnerLog(boolean z) {
        Companion.enableInnerLog(z);
    }

    @JvmStatic
    public static final Log getLogger(String str) {
        return Companion.getLogger(str);
    }

    @JvmStatic
    public static final void ignoreViews(int... iArr) {
        Companion.ignoreViews(iArr);
    }

    @JvmStatic
    public static final void logout() {
        Companion.logout();
    }

    @JvmStatic
    public static final void registerUser(String str) {
        Companion.registerUser(str);
    }

    @JvmStatic
    public static final void registerUser(String str, String str2) {
        Companion.registerUser(str, str2);
    }

    @JvmStatic
    public static final void registerUser(String str, String str2, String str3) {
        Companion.registerUser(str, str2, str3);
    }

    @JvmStatic
    public static final void registerUser(String str, String str2, String str3, String str4) {
        Companion.registerUser(str, str2, str3, str4);
    }

    @JvmStatic
    public static final void registerUser(String str, String str2, String str3, String str4, String str5) {
        Companion.registerUser(str, str2, str3, str4, str5);
    }

    @JvmStatic
    public static final void registerUser(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Companion.registerUser(str, str2, str3, str4, str5, map);
    }

    @JvmStatic
    public static final void screen(String str) {
        Companion.screen(str);
    }

    @JvmStatic
    public static final void setConnectionUrl(String str) {
        Companion.setConnectionUrl(str);
    }

    @JvmStatic
    public static final void start(Application application, String str, String str2) {
        Companion.start(application, str, str2);
    }

    @JvmStatic
    public static final void start(Application application, String str, String str2, Function1<? super String, Unit> function1) {
        Companion.start(application, str, str2, function1);
    }

    @JvmStatic
    public static final void start(Application application, String str, String str2, Function1<? super String, Unit> function1, URI uri) {
        Companion.start(application, str, str2, function1, uri);
    }

    @Metadata(mo33736d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0014\u0010\r\u001a\u00020\u00042\n\u0010\u000e\u001a\u00020\u000f\"\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007JX\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006H\u0007JD\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007¨\u0006&"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/ShipBook$Companion;", "", "()V", "addWrapperClass", "", "name", "", "enableInnerLog", "enable", "", "getLogger", "Lio/shipbook/shipbooksdk/Log;", "tag", "ignoreViews", "ids", "", "", "logout", "registerUser", "userId", "userName", "fullName", "email", "phoneNumber", "additionalInfo", "", "screen", "setConnectionUrl", "url", "start", "application", "Landroid/app/Application;", "appId", "appKey", "completion", "Lkotlin/Function1;", "uri", "Ljava/net/URI;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.ShipBook$Companion */
    /* compiled from: ShipBook.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void registerUser(String str) {
            Intrinsics.checkNotNullParameter(str, "userId");
            registerUser$default(this, str, (String) null, (String) null, (String) null, (String) null, (Map) null, 62, (Object) null);
        }

        @JvmStatic
        public final void registerUser(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "userId");
            registerUser$default(this, str, str2, (String) null, (String) null, (String) null, (Map) null, 60, (Object) null);
        }

        @JvmStatic
        public final void registerUser(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "userId");
            registerUser$default(this, str, str2, str3, (String) null, (String) null, (Map) null, 56, (Object) null);
        }

        @JvmStatic
        public final void registerUser(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "userId");
            registerUser$default(this, str, str2, str3, str4, (String) null, (Map) null, 48, (Object) null);
        }

        @JvmStatic
        public final void registerUser(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "userId");
            registerUser$default(this, str, str2, str3, str4, str5, (Map) null, 32, (Object) null);
        }

        @JvmStatic
        public final void start(Application application, String str, String str2) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            Intrinsics.checkNotNullParameter(str, "appId");
            Intrinsics.checkNotNullParameter(str2, "appKey");
            start$default(this, application, str, str2, (Function1) null, (URI) null, 24, (Object) null);
        }

        @JvmStatic
        public final void start(Application application, String str, String str2, Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            Intrinsics.checkNotNullParameter(str, "appId");
            Intrinsics.checkNotNullParameter(str2, "appKey");
            start$default(this, application, str, str2, function1, (URI) null, 16, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Application application, String str, String str2, Function1 function1, URI uri, int i, Object obj) {
            companion.start(application, str, str2, (i & 8) != 0 ? null : function1, (i & 16) != 0 ? null : uri);
        }

        @JvmStatic
        public final void start(Application application, String str, String str2, Function1<? super String, Unit> function1, URI uri) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            Intrinsics.checkNotNullParameter(str, "appId");
            Intrinsics.checkNotNullParameter(str2, "appKey");
            SessionManager.INSTANCE.login(application, str, str2, function1, uri);
        }

        @JvmStatic
        public final void enableInnerLog(boolean z) {
            InnerLog.INSTANCE.setEnabled(z);
        }

        @JvmStatic
        public final void setConnectionUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            ConnectionClient.INSTANCE.setBaseUrl(str);
        }

        @JvmStatic
        public final Log getLogger(String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            return new Log(str);
        }

        public static /* synthetic */ void registerUser$default(Companion companion, String str, String str2, String str3, String str4, String str5, Map map, int i, Object obj) {
            Map map2 = null;
            String str6 = (i & 2) != 0 ? null : str2;
            String str7 = (i & 4) != 0 ? null : str3;
            String str8 = (i & 8) != 0 ? null : str4;
            String str9 = (i & 16) != 0 ? null : str5;
            if ((i & 32) == 0) {
                map2 = map;
            }
            companion.registerUser(str, str6, str7, str8, str9, map2);
        }

        @JvmStatic
        public final void registerUser(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "userId");
            SessionManager.INSTANCE.registerUser(str, str2, str3, str4, str5, map);
        }

        @JvmStatic
        public final void logout() {
            SessionManager.INSTANCE.logout();
        }

        @JvmStatic
        public final void ignoreViews(int... iArr) {
            Intrinsics.checkNotNullParameter(iArr, "ids");
            ActionEventManager.INSTANCE.setIgnoreViews(ArraysKt.toSet(iArr));
        }

        @JvmStatic
        public final void screen(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            LogManager.INSTANCE.push(new ScreenEvent(str, 0, (Date) null, (BaseLog.ThreadInfo) null, 14, (DefaultConstructorMarker) null));
        }

        @JvmStatic
        public final void addWrapperClass(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            Message.Companion.addIgnoreClass(str);
        }
    }
}
