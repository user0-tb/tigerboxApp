package media.tiger.tigerbox.services.implementations.downloadsManager;

import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class DownloadsManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ DownloadsManager f$1;
    public final /* synthetic */ Function3 f$2;
    public final /* synthetic */ List f$3;
    public final /* synthetic */ Ref.BooleanRef f$4;

    public /* synthetic */ DownloadsManager$$ExternalSyntheticLambda1(List list, DownloadsManager downloadsManager, Function3 function3, List list2, Ref.BooleanRef booleanRef) {
        this.f$0 = list;
        this.f$1 = downloadsManager;
        this.f$2 = function3;
        this.f$3 = list2;
        this.f$4 = booleanRef;
    }

    public final void run() {
        DownloadsManager.m2351startJobs$lambda7$lambda6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
