package media.tiger.tigerbox.webserver.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.webserver.exception.BadRequestException;
import p009j$.time.LocalTime;
import p009j$.time.format.DateTimeFormatter;
import p009j$.time.format.DateTimeParseException;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, mo33737d2 = {"validateAndSanitize", "Lmedia/tiger/tigerbox/webserver/dto/WindowedTimerDto;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WindowedTimerDto.kt */
public final class WindowedTimerDtoKt {
    public static final WindowedTimerDto validateAndSanitize(WindowedTimerDto windowedTimerDto) {
        Intrinsics.checkNotNullParameter(windowedTimerDto, "<this>");
        CharSequence windowedStart = windowedTimerDto.getWindowedStart();
        boolean z = false;
        if (!(windowedStart == null || StringsKt.isBlank(windowedStart))) {
            CharSequence windowedEnd = windowedTimerDto.getWindowedEnd();
            if (windowedEnd == null || StringsKt.isBlank(windowedEnd)) {
                z = true;
            }
            if (!z) {
                try {
                    LocalTime.parse(windowedTimerDto.getWindowedStart(), DateTimeFormatter.ISO_LOCAL_TIME);
                    LocalTime.parse(windowedTimerDto.getWindowedEnd(), DateTimeFormatter.ISO_LOCAL_TIME);
                    return windowedTimerDto;
                } catch (DateTimeParseException unused) {
                    throw new BadRequestException("Invalid request");
                }
            }
        }
        throw new BadRequestException("Invalid request");
    }
}
