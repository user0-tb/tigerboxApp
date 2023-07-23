package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.model.domain.TigerBoxAccountDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$3", mo34424f = "TigerBoxUserRepository.kt", mo34425i = {}, mo34426l = {122, 126}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: TigerBoxUserRepository.kt */
final class DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TigerBoxAccountDomain $info;
    Object L$0;
    int label;
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$3(TigerBoxAccountDomain tigerBoxAccountDomain, DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository, Continuation<? super DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$3> continuation) {
        super(2, continuation);
        this.$info = tigerBoxAccountDomain;
        this.this$0 = defaultTigerBoxAccountRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$3(this.$info, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            java.lang.Object r1 = r7.L$0
            java.util.Iterator r1 = (java.util.Iterator) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0071
        L_0x0017:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0061
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r8)
            timber.log.Timber$Forest r8 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "Updating database with account info "
            r1.append(r5)
            media.tiger.tigerbox.model.domain.TigerBoxAccountDomain r5 = r7.$info
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r8.mo50217e(r1, r5)
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r8 = r7.this$0
            r8.deleteAllUsersFromDatabase()
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r8 = r7.this$0
            media.tiger.tigerbox.data.database.TigerBoxDatabase r8 = r8.tigerBoxDataBase
            media.tiger.tigerbox.data.database.TigerBoxUserDao r8 = r8.tigerBoxUserDao()
            media.tiger.tigerbox.model.domain.TigerBoxAccountDomain r1 = r7.$info
            media.tiger.tigerbox.model.domain.TigerBoxUserDomain r1 = r1.getUser()
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.label = r4
            java.lang.Object r8 = r8.insertUser(r1, r5)
            if (r8 != r0) goto L_0x0061
            return r0
        L_0x0061:
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r8 = r7.this$0
            r8.deleteAllProfilesFromDatabase()
            media.tiger.tigerbox.model.domain.TigerBoxAccountDomain r8 = r7.$info
            java.util.List r8 = r8.getProfiles()
            java.util.Iterator r8 = r8.iterator()
            r1 = r8
        L_0x0071:
            r8 = r7
        L_0x0072:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0096
            java.lang.Object r4 = r1.next()
            media.tiger.tigerbox.model.domain.TigerBoxProfileDomain r4 = (media.tiger.tigerbox.model.domain.TigerBoxProfileDomain) r4
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r5 = r8.this$0
            media.tiger.tigerbox.data.database.TigerBoxDatabase r5 = r5.tigerBoxDataBase
            media.tiger.tigerbox.data.database.TigerBoxProfileDao r5 = r5.tigerBoxProfileDao()
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r4 = r5.insertProfile(r4, r6)
            if (r4 != r0) goto L_0x0072
            return r0
        L_0x0096:
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r0 = r8.this$0
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.updatingDatabaseInProgress
            r0.set(r2)
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r0 = r8.this$0
            java.lang.Thread r0 = r0.shutdownThreadHook
            if (r0 == 0) goto L_0x00b2
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()
            boolean r0 = r1.removeShutdownHook(r0)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
        L_0x00b2:
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r8 = r8.this$0
            r0 = 0
            r8.shutdownThreadHook = r0
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
