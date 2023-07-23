package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo33737d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DeepSleepTimerService.kt */
final class DeepSleepTimerService$timeoutSeconds$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ ConfigurationProperties $configurationProperties;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeepSleepTimerService$timeoutSeconds$2(ConfigurationProperties configurationProperties) {
        super(0);
        this.$configurationProperties = configurationProperties;
    }

    public final Integer invoke() {
        return Integer.valueOf(Integer.parseInt(this.$configurationProperties.getProperty("deep.sleep.timeout.seconds")));
    }
}
