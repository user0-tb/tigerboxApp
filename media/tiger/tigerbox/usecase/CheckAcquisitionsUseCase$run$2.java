package media.tiger.tigerbox.usecase;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.Acquisition;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "Lmedia/tiger/tigerbox/model/dto/Acquisition;", "acquisition", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: CheckAcquisitionsUseCase.kt */
final class CheckAcquisitionsUseCase$run$2 extends Lambda implements Function1<List<? extends Acquisition>, List<? extends Acquisition>> {
    public static final CheckAcquisitionsUseCase$run$2 INSTANCE = new CheckAcquisitionsUseCase$run$2();

    CheckAcquisitionsUseCase$run$2() {
        super(1);
    }

    public final List<Acquisition> invoke(List<Acquisition> list) {
        Intrinsics.checkNotNullParameter(list, "acquisition");
        return list;
    }
}
