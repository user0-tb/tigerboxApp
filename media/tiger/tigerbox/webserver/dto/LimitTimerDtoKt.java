package media.tiger.tigerbox.webserver.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.webserver.exception.BadRequestException;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, mo33737d2 = {"validateAndSanitize", "Lmedia/tiger/tigerbox/webserver/dto/LimitTimerDto;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LimitTimerDto.kt */
public final class LimitTimerDtoKt {
    public static final LimitTimerDto validateAndSanitize(LimitTimerDto limitTimerDto) {
        Intrinsics.checkNotNullParameter(limitTimerDto, "<this>");
        if (limitTimerDto.getInitialLimitSeconds() != null) {
            return limitTimerDto;
        }
        throw new BadRequestException("Invalid request");
    }
}
