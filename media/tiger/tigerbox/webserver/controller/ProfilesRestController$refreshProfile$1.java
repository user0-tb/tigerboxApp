package media.tiger.tigerbox.webserver.controller;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, mo33737d2 = {"<anonymous>", "", "it", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "", "Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProfilesRestController.kt */
final class ProfilesRestController$refreshProfile$1 extends Lambda implements Function1<Either<? extends Failure, ? extends List<? extends TigerBoxProfileDomain>>, Unit> {
    public static final ProfilesRestController$refreshProfile$1 INSTANCE = new ProfilesRestController$refreshProfile$1();

    ProfilesRestController$refreshProfile$1() {
        super(1);
    }

    public final void invoke(Either<? extends Failure, ? extends List<TigerBoxProfileDomain>> either) {
        Intrinsics.checkNotNullParameter(either, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, ? extends List<TigerBoxProfileDomain>>) (Either) obj);
        return Unit.INSTANCE;
    }
}
