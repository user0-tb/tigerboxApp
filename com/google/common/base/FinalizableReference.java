package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use an instance of one of the Finalizable*Reference classes")
public interface FinalizableReference {
    void finalizeReferent();
}
