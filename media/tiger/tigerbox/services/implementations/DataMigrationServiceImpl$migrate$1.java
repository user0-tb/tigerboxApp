package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl", mo34424f = "DataMigrationServiceImpl.kt", mo34425i = {0}, mo34426l = {43}, mo34427m = "migrate", mo34428n = {"this"}, mo34429s = {"L$0"})
/* compiled from: DataMigrationServiceImpl.kt */
final class DataMigrationServiceImpl$migrate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataMigrationServiceImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataMigrationServiceImpl$migrate$1(DataMigrationServiceImpl dataMigrationServiceImpl, Continuation<? super DataMigrationServiceImpl$migrate$1> continuation) {
        super(continuation);
        this.this$0 = dataMigrationServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.migrate(this);
    }
}
