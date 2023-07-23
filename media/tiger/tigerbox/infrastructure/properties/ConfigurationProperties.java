package media.tiger.tigerbox.infrastructure.properties;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.C2814R;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u00020\u000fH\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J \u0010\u0019\u001a\u00020\u000b*\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0002R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "", "context", "Landroid/content/Context;", "configurationEnvironment", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties$ConfigurationEnvironment;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties$ConfigurationEnvironment;Landroid/content/SharedPreferences;)V", "_volatileProperties", "", "", "propertiesFile", "Ljava/util/Properties;", "clearVolatileProperties", "", "getProperty", "propertyKey", "defaultValue", "removeVolatileProperty", "key", "setVolatileProperty", "value", "updateVolatileProperties", "volatileProperties", "fetchProperty", "Companion", "ConfigurationEnvironment", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ConfigurationProperties.kt */
public final class ConfigurationProperties {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEBUG_TOOLS = "adb.tools.enabled";
    private static final String VOLATILE_CONFIG_PROPERTIES = "VOLATILE_CONFIG_PROPERTIES";
    private Map<String, String> _volatileProperties;
    private final Properties propertiesFile;
    /* access modifiers changed from: private */
    public final SharedPreferences sharedPreferences;

    public ConfigurationProperties(Context context, ConfigurationEnvironment configurationEnvironment, SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configurationEnvironment, "configurationEnvironment");
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
        InputStream openRawResource = context.getResources().openRawResource(configurationEnvironment.getConfigFileReference());
        Intrinsics.checkNotNullExpressionValue(openRawResource, "context.resources.openRa…ment.configFileReference)");
        Properties properties = new Properties();
        properties.load(openRawResource);
        this.propertiesFile = properties;
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C28682(this, (Continuation<? super C28682>) null), 3, (Object) null);
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties$ConfigurationEnvironment;", "", "configFileReference", "", "(Ljava/lang/String;II)V", "getConfigFileReference", "()I", "STAGING", "DEBUG", "PRODUCTION", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ConfigurationProperties.kt */
    public enum ConfigurationEnvironment {
        STAGING(C2814R.C2822raw.staging),
        DEBUG(C2814R.C2822raw.debug),
        PRODUCTION(C2814R.C2822raw.production);
        
        private final int configFileReference;

        private ConfigurationEnvironment(int i) {
            this.configFileReference = i;
        }

        public final int getConfigFileReference() {
            return this.configFileReference;
        }
    }

    /* access modifiers changed from: private */
    public final Map<String, String> volatileProperties() {
        Map<String, String> map;
        if (this._volatileProperties == null) {
            String string = this.sharedPreferences.getString(VOLATILE_CONFIG_PROPERTIES, "");
            if (string != null) {
                if (string.length() > 0) {
                    try {
                        map = (Map) new Gson().fromJson(string, new ConfigurationProperties$volatileProperties$statesType$1().getType());
                    } catch (Exception e) {
                        Timber.Forest forest = Timber.Forest;
                        forest.mo50217e("ConfigurationEnvironment: Exception reading local states " + e, new Object[0]);
                        map = new LinkedHashMap<>();
                    }
                    this._volatileProperties = map;
                }
            }
            map = new LinkedHashMap<>();
            this._volatileProperties = map;
        }
        Map<String, String> map2 = this._volatileProperties;
        Intrinsics.checkNotNull(map2);
        return map2;
    }

    private final void updateVolatileProperties() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new ConfigurationProperties$updateVolatileProperties$1(this, (Continuation<? super ConfigurationProperties$updateVolatileProperties$1>) null), 3, (Object) null);
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties$2", mo34424f = "ConfigurationProperties.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties$2 */
    /* compiled from: ConfigurationProperties.kt */
    static final class C28682 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ConfigurationProperties this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28682(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28682) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Map unused = this.this$0.volatileProperties();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final String getProperty(String str) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(str, "propertyKey");
        return fetchProperty$default(this, this.propertiesFile, str, (String) null, 2, (Object) null);
    }

    public final String getProperty(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "propertyKey");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        return fetchProperty(this.propertiesFile, str, str2);
    }

    public final void clearVolatileProperties() {
        volatileProperties().clear();
        updateVolatileProperties();
    }

    public final void removeVolatileProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (volatileProperties().containsKey(str)) {
            volatileProperties().remove(str);
        }
    }

    public final void setVolatileProperty(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        removeVolatileProperty(str);
        volatileProperties().put(str, str2);
        updateVolatileProperties();
    }

    static /* synthetic */ String fetchProperty$default(ConfigurationProperties configurationProperties, Properties properties, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return configurationProperties.fetchProperty(properties, str, str2);
    }

    private final String fetchProperty(Properties properties, String str, String str2) {
        String property = properties.getProperty(DEBUG_TOOLS);
        if (volatileProperties().containsKey(str)) {
            boolean z = true;
            if (property == null || !Boolean.parseBoolean(property)) {
                z = false;
            }
            if (z) {
                String str3 = volatileProperties().get(str);
                Intrinsics.checkNotNull(str3);
                return str3;
            }
        }
        String property2 = properties.getProperty(str);
        if (str2 == null) {
            if (property2 == null) {
                throw new IllegalArgumentException(("Property '" + str + "' not found.").toString());
            }
        } else if (property2 == null) {
            return str2;
        }
        return property2;
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties$Companion;", "", "()V", "DEBUG_TOOLS", "", "VOLATILE_CONFIG_PROPERTIES", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ConfigurationProperties.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
