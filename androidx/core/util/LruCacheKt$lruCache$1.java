package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33735bv = {1, 0, 3}, mo33736d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n"}, mo33737d2 = {"", "K", "V", "<anonymous parameter 0>", "<anonymous parameter 1>", "", "<anonymous>"}, mo33738k = 3, mo33739mv = {1, 5, 1})
/* compiled from: LruCache.kt */
public final class LruCacheKt$lruCache$1 extends Lambda implements Function2<K, V, Integer> {
    public static final LruCacheKt$lruCache$1 INSTANCE = new LruCacheKt$lruCache$1();

    public LruCacheKt$lruCache$1() {
        super(2);
    }

    public final Integer invoke(K k, V v) {
        Intrinsics.checkNotNullParameter(k, "$noName_0");
        Intrinsics.checkNotNullParameter(v, "$noName_1");
        return 1;
    }
}
