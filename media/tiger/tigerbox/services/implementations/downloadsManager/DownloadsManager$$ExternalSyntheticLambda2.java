package media.tiger.tigerbox.services.implementations.downloadsManager;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class DownloadsManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Ref.BooleanRef f$1;
    public final /* synthetic */ DownloadsManager f$2;
    public final /* synthetic */ Ref.BooleanRef f$3;
    public final /* synthetic */ DownloadJobImpl f$4;
    public final /* synthetic */ Function1 f$5;
    public final /* synthetic */ Ref.BooleanRef f$6;

    public /* synthetic */ DownloadsManager$$ExternalSyntheticLambda2(Function0 function0, Ref.BooleanRef booleanRef, DownloadsManager downloadsManager, Ref.BooleanRef booleanRef2, DownloadJobImpl downloadJobImpl, Function1 function1, Ref.BooleanRef booleanRef3) {
        this.f$0 = function0;
        this.f$1 = booleanRef;
        this.f$2 = downloadsManager;
        this.f$3 = booleanRef2;
        this.f$4 = downloadJobImpl;
        this.f$5 = function1;
        this.f$6 = booleanRef3;
    }

    public final void run() {
        DownloadsManager.m2350startJobs$lambda7$lambda4$lambda3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}
