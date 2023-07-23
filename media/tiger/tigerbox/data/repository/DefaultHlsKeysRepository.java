package media.tiger.tigerbox.data.repository;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.model.domain.HlsKeyDomain;

@Singleton
@Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/DefaultHlsKeysRepository;", "Lmedia/tiger/tigerbox/data/repository/HlsKeysRepository;", "tigerBoxDataBase", "Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;", "encryptedSharedPreferences", "Landroid/content/SharedPreferences;", "(Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;Landroid/content/SharedPreferences;)V", "deleteAlHlsKeys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHlsKey", "Lmedia/tiger/tigerbox/model/domain/HlsKeyDomain;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHlsKey", "key", "(Lmedia/tiger/tigerbox/model/domain/HlsKeyDomain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HlsKeysRepository.kt */
public class DefaultHlsKeysRepository implements HlsKeysRepository {
    private final SharedPreferences encryptedSharedPreferences;
    private final TigerBoxDatabase tigerBoxDataBase;

    public Object deleteAlHlsKeys(Continuation<? super Unit> continuation) {
        return this.tigerBoxDataBase.hlsKeysDao().deleteAllKeys();
    }

    public Object getHlsKey(String str, Continuation<? super HlsKeyDomain> continuation) {
        return getHlsKey$suspendImpl(this, str, continuation);
    }

    public Object insertHlsKey(HlsKeyDomain hlsKeyDomain, Continuation<? super Unit> continuation) {
        return this.tigerBoxDataBase.hlsKeysDao().insertPlaybackPosition(hlsKeyDomain);
    }

    @Inject
    public DefaultHlsKeysRepository(TigerBoxDatabase tigerBoxDatabase, SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDataBase");
        Intrinsics.checkNotNullParameter(sharedPreferences, "encryptedSharedPreferences");
        this.tigerBoxDataBase = tigerBoxDatabase;
        this.encryptedSharedPreferences = sharedPreferences;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object getHlsKey$suspendImpl(media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository r11, java.lang.String r12, kotlin.coroutines.Continuation r13) {
        /*
            boolean r0 = r13 instanceof media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository$getHlsKey$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository$getHlsKey$1 r0 = (media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository$getHlsKey$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository$getHlsKey$1 r0 = new media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository$getHlsKey$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r0.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.ResultKt.throwOnFailure(r13)
            r5 = r11
            r6 = r12
            goto L_0x0088
        L_0x0035:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r13)
            media.tiger.tigerbox.data.database.TigerBoxDatabase r13 = r11.tigerBoxDataBase
            media.tiger.tigerbox.data.database.HlsKeysDao r13 = r13.hlsKeysDao()
            media.tiger.tigerbox.model.domain.HlsKeyDomain r13 = r13.getHlsKey(r12)
            if (r13 == 0) goto L_0x0056
            timber.log.Timber$Forest r11 = timber.log.Timber.Forest
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.String r0 = "RETURN FROM NEW STORAGE"
            r11.mo50236w(r0, r12)
            return r13
        L_0x0056:
            android.content.SharedPreferences r13 = r11.encryptedSharedPreferences
            java.lang.String r2 = ""
            java.lang.String r13 = r13.getString(r12, r2)
            if (r13 == 0) goto L_0x009b
            r2 = r13
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x006b
            r2 = 1
            goto L_0x006c
        L_0x006b:
            r2 = 0
        L_0x006c:
            if (r2 == 0) goto L_0x009b
            media.tiger.tigerbox.model.domain.HlsKeyDomain r2 = new media.tiger.tigerbox.model.domain.HlsKeyDomain
            r8 = 0
            r9 = 4
            r10 = 0
            r5 = r2
            r6 = r13
            r7 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            r0.L$0 = r12
            r0.L$1 = r13
            r0.label = r4
            java.lang.Object r11 = r11.insertHlsKey(r2, r0)
            if (r11 != r1) goto L_0x0086
            return r1
        L_0x0086:
            r6 = r12
            r5 = r13
        L_0x0088:
            timber.log.Timber$Forest r11 = timber.log.Timber.Forest
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.String r13 = "RETURN FROM OLD STORAGE"
            r11.mo50236w(r13, r12)
            media.tiger.tigerbox.model.domain.HlsKeyDomain r11 = new media.tiger.tigerbox.model.domain.HlsKeyDomain
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r11
        L_0x009b:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository.getHlsKey$suspendImpl(media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
