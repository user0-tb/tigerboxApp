package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.PlaybackTrackingEvent;

@Metadata(mo33736d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;", "it", "", "invoke", "(Lkotlin/Unit;)Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PostTrackingEventUseCase.kt */
final class PostTrackingEventUseCase$run$2 extends Lambda implements Function1<Unit, PlaybackTrackingEvent> {
    final /* synthetic */ PostTrackingEventParameters $params;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostTrackingEventUseCase$run$2(PostTrackingEventParameters postTrackingEventParameters) {
        super(1);
        this.$params = postTrackingEventParameters;
    }

    public final PlaybackTrackingEvent invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return this.$params.getEvent();
    }
}
