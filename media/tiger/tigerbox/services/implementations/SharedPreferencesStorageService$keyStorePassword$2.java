package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SharedPreferencesStorageService.kt */
final class SharedPreferencesStorageService$keyStorePassword$2 extends Lambda implements Function0<String> {
    final /* synthetic */ SharedPreferencesStorageService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesStorageService$keyStorePassword$2(SharedPreferencesStorageService sharedPreferencesStorageService) {
        super(0);
        this.this$0 = sharedPreferencesStorageService;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke() {
        /*
            r3 = this;
            media.tiger.tigerbox.services.implementations.SharedPreferencesStorageService r0 = r3.this$0
            android.content.SharedPreferences r0 = r0.encryptedSharedPreferences
            java.lang.String r1 = "KEYSTORE_PASSWORD"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)
            if (r0 != 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r2 = r0
        L_0x0012:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            media.tiger.tigerbox.services.implementations.SharedPreferencesStorageService r0 = r3.this$0
            int r1 = r2.length()
            if (r1 != 0) goto L_0x001e
            r1 = 1
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            if (r1 == 0) goto L_0x003c
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r2 = r1.toString()
            java.lang.String r1 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            android.content.SharedPreferences r0 = r0.encryptedSharedPreferences
            media.tiger.tigerbox.services.implementations.SharedPreferencesStorageService$keyStorePassword$2$1$1 r1 = new media.tiger.tigerbox.services.implementations.SharedPreferencesStorageService$keyStorePassword$2$1$1
            r1.<init>(r2)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            media.tiger.tigerbox.services.implementations.SharedPreferencesStorageServiceKt.save(r0, r1)
        L_0x003c:
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.SharedPreferencesStorageService$keyStorePassword$2.invoke():java.lang.String");
    }
}
