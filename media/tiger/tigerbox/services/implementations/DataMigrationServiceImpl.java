package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;
import media.tiger.tigerbox.model.domain.TigerBoxUserDomain;
import media.tiger.tigerbox.services.interfaces.DataMigrationService;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/DataMigrationServiceImpl;", "Lmedia/tiger/tigerbox/services/interfaces/DataMigrationService;", "encryptedSharedPreferences", "Landroid/content/SharedPreferences;", "tigerBoxDatabase", "Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;", "(Landroid/content/SharedPreferences;Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;)V", "migrate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AccessTokenDeserializer", "TigerBoxUserDeserializer", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DataMigrationServiceImpl.kt */
public final class DataMigrationServiceImpl implements DataMigrationService {
    private final SharedPreferences encryptedSharedPreferences;
    private final TigerBoxDatabase tigerBoxDatabase;

    public DataMigrationServiceImpl(SharedPreferences sharedPreferences, TigerBoxDatabase tigerBoxDatabase2) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "encryptedSharedPreferences");
        Intrinsics.checkNotNullParameter(tigerBoxDatabase2, "tigerBoxDatabase");
        this.encryptedSharedPreferences = sharedPreferences;
        this.tigerBoxDatabase = tigerBoxDatabase2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object migrate(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$1 r0 = (media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$1 r0 = new media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$1
            r0.<init>(r13, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl r0 = (media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00e1
        L_0x002f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r14)
            com.google.gson.GsonBuilder r14 = new com.google.gson.GsonBuilder
            r14.<init>()
            java.lang.Class<media.tiger.tigerbox.model.domain.TigerBoxUserDomain> r2 = media.tiger.tigerbox.model.domain.TigerBoxUserDomain.class
            java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
            media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$TigerBoxUserDeserializer r4 = new media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$TigerBoxUserDeserializer
            r4.<init>()
            r14.registerTypeAdapter(r2, r4)
            java.lang.Class<media.tiger.tigerbox.model.domain.AccessTokenDomain> r2 = media.tiger.tigerbox.model.domain.AccessTokenDomain.class
            java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
            media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$AccessTokenDeserializer r4 = new media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$AccessTokenDeserializer
            r4.<init>()
            r14.registerTypeAdapter(r2, r4)
            com.google.gson.Gson r14 = r14.create()
            android.content.SharedPreferences r2 = r13.encryptedSharedPreferences
            java.lang.String r4 = "accessToken"
            r5 = 0
            java.lang.String r2 = r2.getString(r4, r5)
            java.lang.Class<media.tiger.tigerbox.model.domain.AccessTokenDomain> r4 = media.tiger.tigerbox.model.domain.AccessTokenDomain.class
            java.lang.Object r2 = r14.fromJson((java.lang.String) r2, r4)
            media.tiger.tigerbox.model.domain.AccessTokenDomain r2 = (media.tiger.tigerbox.model.domain.AccessTokenDomain) r2
            android.content.SharedPreferences r4 = r13.encryptedSharedPreferences
            java.lang.String r6 = "deviceInfo"
            java.lang.String r4 = r4.getString(r6, r5)
            java.lang.Class<media.tiger.tigerbox.model.dto.DeviceInformation> r6 = media.tiger.tigerbox.model.dto.DeviceInformation.class
            java.lang.Object r4 = r14.fromJson((java.lang.String) r4, r6)
            media.tiger.tigerbox.model.dto.DeviceInformation r4 = (media.tiger.tigerbox.model.dto.DeviceInformation) r4
            android.content.SharedPreferences r6 = r13.encryptedSharedPreferences
            java.lang.String r7 = "accountInfo"
            java.lang.String r5 = r6.getString(r7, r5)
            java.lang.Class<media.tiger.tigerbox.model.domain.TigerBoxUserDomain> r6 = media.tiger.tigerbox.model.domain.TigerBoxUserDomain.class
            java.lang.Object r14 = r14.fromJson((java.lang.String) r5, r6)
            r5 = r14
            media.tiger.tigerbox.model.domain.TigerBoxUserDomain r5 = (media.tiger.tigerbox.model.domain.TigerBoxUserDomain) r5
            if (r2 == 0) goto L_0x00b2
            java.lang.String r14 = r2.getAccessToken()
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            int r14 = r14.length()
            if (r14 <= 0) goto L_0x009d
            r14 = 1
            goto L_0x009e
        L_0x009d:
            r14 = 0
        L_0x009e:
            if (r14 == 0) goto L_0x00b2
            media.tiger.tigerbox.data.database.TigerBoxDatabase r14 = r13.tigerBoxDatabase
            media.tiger.tigerbox.data.database.AccessTokenDao r14 = r14.accessTokenDao()
            r14.insertAccessToken(r2)
            android.content.SharedPreferences r14 = r13.encryptedSharedPreferences
            media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$2 r2 = media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$2.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            media.tiger.tigerbox.services.implementations.SharedPreferencesStorageServiceKt.save(r14, r2)
        L_0x00b2:
            if (r5 == 0) goto L_0x00e0
            int r14 = r5.getProfileId()
            r2 = -1
            if (r14 == r2) goto L_0x00e0
            media.tiger.tigerbox.data.database.TigerBoxDatabase r14 = r13.tigerBoxDatabase
            media.tiger.tigerbox.data.database.TigerBoxUserDao r14 = r14.tigerBoxUserDao()
            r6 = 0
            if (r4 == 0) goto L_0x00ca
            int r2 = r4.getAccountId()
            r7 = r2
            goto L_0x00cb
        L_0x00ca:
            r7 = -1
        L_0x00cb:
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 29
            r12 = 0
            media.tiger.tigerbox.model.domain.TigerBoxUserDomain r2 = media.tiger.tigerbox.model.domain.TigerBoxUserDomain.copy$default(r5, r6, r7, r8, r9, r10, r11, r12)
            r0.L$0 = r13
            r0.label = r3
            java.lang.Object r14 = r14.insertUser(r2, r0)
            if (r14 != r1) goto L_0x00e0
            return r1
        L_0x00e0:
            r0 = r13
        L_0x00e1:
            android.content.SharedPreferences r14 = r0.encryptedSharedPreferences
            media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$3$1 r0 = media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$3$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            media.tiger.tigerbox.services.implementations.SharedPreferencesStorageServiceKt.save(r14, r0)
            media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$3$2 r0 = media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl$migrate$3$2.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            media.tiger.tigerbox.services.implementations.SharedPreferencesStorageServiceKt.save(r14, r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl.migrate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/DataMigrationServiceImpl$TigerBoxUserDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lmedia/tiger/tigerbox/model/domain/TigerBoxUserDomain;", "()V", "deserialize", "jElement", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DataMigrationServiceImpl.kt */
    private static final class TigerBoxUserDeserializer implements JsonDeserializer<TigerBoxUserDomain> {
        public TigerBoxUserDomain deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonElement, "jElement");
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            int asInt = asJsonObject.get(TtmlNode.ATTR_ID).getAsInt();
            String asString = asJsonObject.get(NotificationCompat.CATEGORY_EMAIL).getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, NotificationCompat.CATEGORY_EMAIL);
            return new TigerBoxUserDomain(asInt, 0, 0, asString, (String) null, 22, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/DataMigrationServiceImpl$AccessTokenDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "()V", "deserialize", "jElement", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DataMigrationServiceImpl.kt */
    private static final class AccessTokenDeserializer implements JsonDeserializer<AccessTokenDomain> {
        public AccessTokenDomain deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonElement, "jElement");
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            String asString = asJsonObject.get("access_token").getAsString();
            String asString2 = asJsonObject.get("refresh_token").getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "accessToken");
            Intrinsics.checkNotNullExpressionValue(asString2, "refreshToken");
            return new AccessTokenDomain(asString, asString2, 0, 4, (DefaultConstructorMarker) null);
        }
    }
}
