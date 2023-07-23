package com.google.common.p010io;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* renamed from: com.google.common.io.Closer */
public final class Closer implements Closeable {
    private static final Suppressor SUPPRESSOR;
    private final Deque<Closeable> stack = new ArrayDeque(4);
    final Suppressor suppressor;
    @CheckForNull
    private Throwable thrown;

    /* renamed from: com.google.common.io.Closer$Suppressor */
    interface Suppressor {
        void suppress(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        Suppressor tryCreate = SuppressingSuppressor.tryCreate();
        if (tryCreate == null) {
            tryCreate = LoggingSuppressor.INSTANCE;
        }
        SUPPRESSOR = tryCreate;
    }

    public static Closer create() {
        return new Closer(SUPPRESSOR);
    }

    Closer(Suppressor suppressor2) {
        this.suppressor = (Suppressor) Preconditions.checkNotNull(suppressor2);
    }

    @ParametricNullness
    public <C extends Closeable> C register(@ParametricNullness C c) {
        if (c != null) {
            this.stack.addFirst(c);
        }
        return c;
    }

    public RuntimeException rethrow(Throwable th) throws IOException {
        Preconditions.checkNotNull(th);
        this.thrown = th;
        Throwables.propagateIfPossible(th, IOException.class);
        throw new RuntimeException(th);
    }

    public <X extends Exception> RuntimeException rethrow(Throwable th, Class<X> cls) throws IOException, Exception {
        Preconditions.checkNotNull(th);
        this.thrown = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls);
        throw new RuntimeException(th);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable th, Class<X1> cls, Class<X2> cls2) throws IOException, Exception, Exception {
        Preconditions.checkNotNull(th);
        this.thrown = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls, cls2);
        throw new RuntimeException(th);
    }

    public void close() throws IOException {
        Throwable th = this.thrown;
        while (!this.stack.isEmpty()) {
            Closeable removeFirst = this.stack.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.suppressor.suppress(removeFirst, th, th2);
                }
            }
        }
        if (this.thrown == null && th != null) {
            Throwables.propagateIfPossible(th, IOException.class);
            throw new AssertionError(th);
        }
    }

    /* renamed from: com.google.common.io.Closer$LoggingSuppressor */
    static final class LoggingSuppressor implements Suppressor {
        static final LoggingSuppressor INSTANCE = new LoggingSuppressor();

        LoggingSuppressor() {
        }

        public void suppress(Closeable closeable, Throwable th, Throwable th2) {
            Logger logger = Closeables.logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(closeable);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 42);
            sb.append("Suppressing exception thrown when closing ");
            sb.append(valueOf);
            logger.log(level, sb.toString(), th2);
        }
    }

    /* renamed from: com.google.common.io.Closer$SuppressingSuppressor */
    static final class SuppressingSuppressor implements Suppressor {
        private final Method addSuppressed;

        @CheckForNull
        static SuppressingSuppressor tryCreate() {
            try {
                return new SuppressingSuppressor(Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class}));
            } catch (Throwable unused) {
                return null;
            }
        }

        private SuppressingSuppressor(Method method) {
            this.addSuppressed = method;
        }

        public void suppress(Closeable closeable, Throwable th, Throwable th2) {
            if (th != th2) {
                try {
                    this.addSuppressed.invoke(th, new Object[]{th2});
                } catch (Throwable unused) {
                    LoggingSuppressor.INSTANCE.suppress(closeable, th, th2);
                }
            }
        }
    }
}
