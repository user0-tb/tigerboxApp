package com.google.android.exoplayer2;

/* renamed from: com.google.android.exoplayer2.StreamVolumeManager$VolumeChangeReceiver$$ExternalSyntheticLambda0 */
public final /* synthetic */ class C0994x8b49c079 implements Runnable {
    public final /* synthetic */ StreamVolumeManager f$0;

    public /* synthetic */ C0994x8b49c079(StreamVolumeManager streamVolumeManager) {
        this.f$0 = streamVolumeManager;
    }

    public final void run() {
        this.f$0.updateVolumeAndNotifyIfChanged();
    }
}
