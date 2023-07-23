package media.tiger.tigerbox.services.implementations;

import media.tiger.tigerbox.services.interfaces.InfoSoundService;

public final /* synthetic */ class InfoSoundPlayer$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ InfoSoundPlayer f$0;
    public final /* synthetic */ InfoSoundService.SoundType f$1;

    public /* synthetic */ InfoSoundPlayer$$ExternalSyntheticLambda2(InfoSoundPlayer infoSoundPlayer, InfoSoundService.SoundType soundType) {
        this.f$0 = infoSoundPlayer;
        this.f$1 = soundType;
    }

    public final void run() {
        InfoSoundPlayer.m2346playSound$lambda2(this.f$0, this.f$1);
    }
}
