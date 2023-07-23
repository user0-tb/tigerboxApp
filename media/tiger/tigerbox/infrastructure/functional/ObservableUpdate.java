package media.tiger.tigerbox.infrastructure.functional;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J+\u0010\u0007\u001a\u00020\u00042!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\tH&J+\u0010\r\u001a\u00020\u00042!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\tH&¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/functional/ObservableUpdate;", "T", "", "notify", "", "data", "(Ljava/lang/Object;)V", "subscribe", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "percentComplete", "unsubscribe", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ObservableUpdate.kt */
public interface ObservableUpdate<T> {
    void notify(T t);

    void subscribe(Function1<? super T, Unit> function1);

    void unsubscribe(Function1<? super T, Unit> function1);
}
