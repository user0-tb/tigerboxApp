package media.tiger.tigerbox.services.implementations;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;

public final /* synthetic */ class InfoSoundPlayer$$ExternalSyntheticLambda0 implements DataSource.Factory {
    public final /* synthetic */ RawResourceDataSource f$0;

    public /* synthetic */ InfoSoundPlayer$$ExternalSyntheticLambda0(RawResourceDataSource rawResourceDataSource) {
        this.f$0 = rawResourceDataSource;
    }

    public final DataSource createDataSource() {
        return InfoSoundPlayer.m2345buildRawMediaSource$lambda5(this.f$0);
    }
}
