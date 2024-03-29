package com.google.common.hash;

import com.google.common.base.Supplier;
import com.google.errorprone.annotations.Immutable;

@ElementTypesAreNonnullByDefault
@Immutable
interface ImmutableSupplier<T> extends Supplier<T> {
}
