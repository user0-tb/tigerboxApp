package media.tiger.tigerbox.services.implementations;

import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "Ljavax/net/ssl/KeyManagerFactory;", "kotlin.jvm.PlatformType", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SharedPreferencesStorageService.kt */
final class SharedPreferencesStorageService$keyManagerFactory$2 extends Lambda implements Function0<KeyManagerFactory> {
    final /* synthetic */ SharedPreferencesStorageService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesStorageService$keyManagerFactory$2(SharedPreferencesStorageService sharedPreferencesStorageService) {
        super(0);
        this.this$0 = sharedPreferencesStorageService;
    }

    public final KeyManagerFactory invoke() {
        KeyManagerFactory instance = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        SharedPreferencesStorageService sharedPreferencesStorageService = this.this$0;
        KeyStore keyStore = sharedPreferencesStorageService.getKeyStore();
        char[] charArray = sharedPreferencesStorageService.getKeyStorePassword().toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        instance.init(keyStore, charArray);
        return instance;
    }
}
