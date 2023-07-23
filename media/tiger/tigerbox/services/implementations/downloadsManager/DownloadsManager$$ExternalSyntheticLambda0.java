package media.tiger.tigerbox.services.implementations.downloadsManager;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

public final /* synthetic */ class DownloadsManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ DownloadsManager f$1;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ Function1 f$3;
    public final /* synthetic */ Function3 f$4;

    public /* synthetic */ DownloadsManager$$ExternalSyntheticLambda0(List list, DownloadsManager downloadsManager, Function0 function0, Function1 function1, Function3 function3) {
        this.f$0 = list;
        this.f$1 = downloadsManager;
        this.f$2 = function0;
        this.f$3 = function1;
        this.f$4 = function3;
    }

    public final void run() {
        DownloadsManager.m2349startJobs$lambda7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
