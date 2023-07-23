package com.google.common.p010io;

import java.io.IOException;

@ElementTypesAreNonnullByDefault
/* renamed from: com.google.common.io.LineProcessor */
public interface LineProcessor<T> {
    @ParametricNullness
    T getResult();

    boolean processLine(String str) throws IOException;
}
