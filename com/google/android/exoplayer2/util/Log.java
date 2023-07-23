package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    private static final Object lock = new Object();
    private static int logLevel = 0;
    private static boolean logStackTraces = true;
    private static Logger logger = Logger.DEFAULT;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            /* renamed from: d */
            public void mo19877d(String str, String str2) {
                android.util.Log.d(str, str2);
            }

            /* renamed from: i */
            public void mo19879i(String str, String str2) {
                android.util.Log.i(str, str2);
            }

            /* renamed from: w */
            public void mo19880w(String str, String str2) {
                android.util.Log.w(str, str2);
            }

            /* renamed from: e */
            public void mo19878e(String str, String str2) {
                android.util.Log.e(str, str2);
            }
        };

        /* renamed from: d */
        void mo19877d(String str, String str2);

        /* renamed from: e */
        void mo19878e(String str, String str2);

        /* renamed from: i */
        void mo19879i(String str, String str2);

        /* renamed from: w */
        void mo19880w(String str, String str2);
    }

    private Log() {
    }

    @Pure
    public static int getLogLevel() {
        int i;
        synchronized (lock) {
            i = logLevel;
        }
        return i;
    }

    public static void setLogLevel(int i) {
        synchronized (lock) {
            logLevel = i;
        }
    }

    public static void setLogStackTraces(boolean z) {
        synchronized (lock) {
            logStackTraces = z;
        }
    }

    public static void setLogger(Logger logger2) {
        synchronized (lock) {
            logger = logger2;
        }
    }

    @Pure
    /* renamed from: d */
    public static void m151d(String str, String str2) {
        synchronized (lock) {
            if (logLevel == 0) {
                logger.mo19877d(str, str2);
            }
        }
    }

    @Pure
    /* renamed from: d */
    public static void m152d(String str, String str2, Throwable th) {
        m151d(str, appendThrowableString(str2, th));
    }

    @Pure
    /* renamed from: i */
    public static void m155i(String str, String str2) {
        synchronized (lock) {
            if (logLevel <= 1) {
                logger.mo19879i(str, str2);
            }
        }
    }

    @Pure
    /* renamed from: i */
    public static void m156i(String str, String str2, Throwable th) {
        m155i(str, appendThrowableString(str2, th));
    }

    @Pure
    /* renamed from: w */
    public static void m157w(String str, String str2) {
        synchronized (lock) {
            if (logLevel <= 2) {
                logger.mo19880w(str, str2);
            }
        }
    }

    @Pure
    /* renamed from: w */
    public static void m158w(String str, String str2, Throwable th) {
        m157w(str, appendThrowableString(str2, th));
    }

    @Pure
    /* renamed from: e */
    public static void m153e(String str, String str2) {
        synchronized (lock) {
            if (logLevel <= 3) {
                logger.mo19878e(str, str2);
            }
        }
    }

    @Pure
    /* renamed from: e */
    public static void m154e(String str, String str2, Throwable th) {
        m153e(str, appendThrowableString(str2, th));
    }

    @Pure
    public static String getThrowableString(Throwable th) {
        synchronized (lock) {
            if (th == null) {
                return null;
            }
            if (isCausedByUnknownHostException(th)) {
                return "UnknownHostException (no network)";
            }
            if (!logStackTraces) {
                String message = th.getMessage();
                return message;
            }
            String replace = android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
            return replace;
        }
    }

    @Pure
    private static String appendThrowableString(String str, Throwable th) {
        String throwableString = getThrowableString(th);
        if (TextUtils.isEmpty(throwableString)) {
            return str;
        }
        return str + "\n  " + throwableString.replace("\n", "\n  ") + 10;
    }

    @Pure
    private static boolean isCausedByUnknownHostException(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }
}
