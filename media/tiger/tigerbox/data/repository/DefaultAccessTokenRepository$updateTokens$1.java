package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"media/tiger/tigerbox/data/repository/DefaultAccessTokenRepository$updateTokens$1", "Ljava/lang/Thread;", "run", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AccessTokenRepository.kt */
public final class DefaultAccessTokenRepository$updateTokens$1 extends Thread {
    final /* synthetic */ DefaultAccessTokenRepository this$0;

    DefaultAccessTokenRepository$updateTokens$1(DefaultAccessTokenRepository defaultAccessTokenRepository) {
        this.this$0 = defaultAccessTokenRepository;
    }

    public void run() {
        Timber.Forest.mo50217e("Running a shutdown hook - to wait until tokens database updates", new Object[0]);
        do {
        } while (this.this$0.updatingDatabaseInProgress.get());
    }
}
