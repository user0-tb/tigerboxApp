package kotlinx.coroutines.debug.internal;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(mo33736d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\bÀ\u0002\u0018\u00002\u00020\u0014:\u0002\u0001B\t\b\u0002¢\u0006\u0004\b\u0001\u0010\u0002J3\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J@\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\b\b\u0000\u0010\u0017*\u00020\u00142\u001e\b\u0004\u0010\u001b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00028\u00000\u0018H\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u000eJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f¢\u0006\u0004\b \u0010\u0012J)\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u000f2\u0006\u0010!\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000f¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020\u0010¢\u0006\u0004\b'\u0010(J5\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0\u000f2\u0006\u0010)\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010*2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\b,\u0010-J?\u00102\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.012\u0006\u0010/\u001a\u00020.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\"0\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\b2\u00103J3\u00105\u001a\u00020.2\u0006\u00104\u001a\u00020.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\"0\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\b5\u00106J\u001d\u00109\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\f\u0018\u000107H\u0002¢\u0006\u0004\b9\u0010:J\u0015\u0010=\u001a\u00020&2\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\f¢\u0006\u0004\b?\u0010\u0002J%\u0010A\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\bA\u0010BJ\u001b\u0010D\u001a\u00020\f2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\bD\u0010EJ)\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010K\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010M\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\bL\u0010JJ'\u0010P\u001a\b\u0012\u0004\u0012\u00020\"0\u000f\"\b\b\u0000\u0010\u0003*\u00020N2\u0006\u0010O\u001a\u00028\u0000H\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\fH\u0002¢\u0006\u0004\bR\u0010\u0002J\u000f\u0010S\u001a\u00020\fH\u0002¢\u0006\u0004\bS\u0010\u0002J\r\u0010T\u001a\u00020\f¢\u0006\u0004\bT\u0010\u0002J\u001f\u0010V\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020U2\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\bV\u0010WJ#\u0010X\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\bX\u0010YJ/\u0010X\u001a\u00020\f2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\bX\u0010ZJ;\u0010b\u001a\u00020\f*\u00020;2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\\0[2\n\u0010`\u001a\u00060^j\u0002`_2\u0006\u0010a\u001a\u00020&H\u0002¢\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001a\u000208*\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\bd\u0010eJ\u001d\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\bC\u0010fJ\u001a\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u00020UH\u0010¢\u0006\u0004\bC\u0010gJ\u0016\u0010h\u001a\u0004\u0018\u00010U*\u00020UH\u0010¢\u0006\u0004\bh\u0010iJ\u001b\u0010j\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020&*\u00020\u0014H\u0002¢\u0006\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020&8\u0002XT¢\u0006\u0006\n\u0004\bn\u0010oR \u0010q\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\\0p8\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u001e\u0010v\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190s8BX\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR$\u0010w\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u0002080p8\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010rR\u0014\u0010y\u001a\u00020x8\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010|\u001a\u00020{8\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\"\u0010~\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\f\u0018\u0001078\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R)\u0010\u0001\u001a\u0002088\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u0002088@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u0002088\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u00020&*\u00020;8BX\u0004¢\u0006\u000f\u0012\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010>R\u001b\u0010\u0001\u001a\u000208*\u00020\"8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, mo33737d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "<init>", "()V", "T", "Lkotlin/coroutines/Continuation;", "completion", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "frame", "createOwner", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/StackTraceFrame;)Lkotlin/coroutines/Continuation;", "Ljava/io/PrintStream;", "out", "", "dumpCoroutines", "(Ljava/io/PrintStream;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfo", "()Ljava/util/List;", "", "", "dumpCoroutinesInfoAsJsonAndReferences", "()[Ljava/lang/Object;", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "Lkotlin/coroutines/CoroutineContext;", "create", "dumpCoroutinesInfoImpl", "(Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "dumpCoroutinesSynchronized", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", "info", "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "", "enhanceStackTraceWithThreadDumpAsJson", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;)Ljava/lang/String;", "state", "Ljava/lang/Thread;", "thread", "enhanceStackTraceWithThreadDumpImpl", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "actualTrace", "Lkotlin/Pair;", "findContinuationStartIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "findIndexOfFrame", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/Function1;", "", "getDynamicAttach", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/Job;", "job", "hierarchyToString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "install", "frames", "printStackTrace", "(Ljava/io/PrintStream;Ljava/util/List;)V", "owner", "probeCoroutineCompleted", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", "", "throwable", "sanitizeStackTrace", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateRunningState", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/String;)V", "updateState", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "indent", "build", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "isFinished", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Z", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "realCaller", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "toStackTraceFrame", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "toStringWithQuotes", "(Ljava/lang/Object;)Ljava/lang/String;", "ARTIFICIAL_FRAME_MESSAGE", "Ljava/lang/String;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutines", "capturedCoroutinesMap", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/jvm/functions/Function1;", "enableCreationStackTraces", "Z", "getEnableCreationStackTraces", "()Z", "setEnableCreationStackTraces", "(Z)V", "installations", "I", "isInstalled$kotlinx_coroutines_core", "isInstalled", "sanitizeStackTraces", "getSanitizeStackTraces", "setSanitizeStackTraces", "weakRefCleanerThread", "Ljava/lang/Thread;", "getDebugString", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "debugString", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "CoroutineOwner", "kotlinx-coroutines-core"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DebugProbesImpl.kt */
public final class DebugProbesImpl {
    private static final String ARTIFICIAL_FRAME_MESSAGE = "Coroutine creation stacktrace";
    public static final DebugProbesImpl INSTANCE;
    /* access modifiers changed from: private */
    public static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> callerInfoCache = new ConcurrentWeakMap<>(true);
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap = new ConcurrentWeakMap<>(false, 1, (DefaultConstructorMarker) null);
    private static final ReentrantReadWriteLock coroutineStateLock = new ReentrantReadWriteLock();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final /* synthetic */ SequenceNumberRefVolatile debugProbesImpl$SequenceNumberRefVolatile = new SequenceNumberRefVolatile(0);
    private static final Function1<Boolean, Unit> dynamicAttach;
    private static boolean enableCreationStackTraces = true;
    private static volatile int installations;
    private static boolean sanitizeStackTraces = true;
    private static final /* synthetic */ AtomicLongFieldUpdater sequenceNumber$FU = AtomicLongFieldUpdater.newUpdater(SequenceNumberRefVolatile.class, "sequenceNumber");
    private static Thread weakRefCleanerThread;

    /* synthetic */ class SequenceNumberRefVolatile {
        volatile long sequenceNumber;

        public SequenceNumberRefVolatile(long j) {
            this.sequenceNumber = j;
        }
    }

    private static /* synthetic */ void getDebugString$annotations(Job job) {
    }

    private DebugProbesImpl() {
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        INSTANCE = debugProbesImpl;
        dynamicAttach = debugProbesImpl.getDynamicAttach();
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    public final boolean isInstalled$kotlinx_coroutines_core() {
        return installations > 0;
    }

    public final boolean getSanitizeStackTraces() {
        return sanitizeStackTraces;
    }

    public final void setSanitizeStackTraces(boolean z) {
        sanitizeStackTraces = z;
    }

    public final boolean getEnableCreationStackTraces() {
        return enableCreationStackTraces;
    }

    public final void setEnableCreationStackTraces(boolean z) {
        enableCreationStackTraces = z;
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DebugProbesImpl debugProbesImpl = this;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            if (newInstance != null) {
                obj = Result.m772constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
                if (Result.m778isFailureimpl(obj)) {
                    obj = null;
                }
                return (Function1) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m772constructorimpl(ResultKt.createFailure(th));
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void install() {
        /*
            r7 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x006b }
            int r5 = installations     // Catch:{ all -> 0x006b }
            r6 = 1
            int r5 = r5 + r6
            installations = r5     // Catch:{ all -> 0x006b }
            int r5 = installations     // Catch:{ all -> 0x006b }
            if (r5 <= r6) goto L_0x003b
        L_0x002f:
            if (r3 >= r2) goto L_0x0037
            r1.lock()
            int r3 = r3 + 1
            goto L_0x002f
        L_0x0037:
            r0.unlock()
            return
        L_0x003b:
            r4.startWeakRefCleanerThread()     // Catch:{ all -> 0x006b }
            kotlinx.coroutines.debug.internal.AgentInstallationType r4 = kotlinx.coroutines.debug.internal.AgentInstallationType.INSTANCE     // Catch:{ all -> 0x006b }
            boolean r4 = r4.isInstalledStatically$kotlinx_coroutines_core()     // Catch:{ all -> 0x006b }
            if (r4 == 0) goto L_0x0052
        L_0x0046:
            if (r3 >= r2) goto L_0x004e
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0046
        L_0x004e:
            r0.unlock()
            return
        L_0x0052:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r4 = dynamicAttach     // Catch:{ all -> 0x006b }
            if (r4 == 0) goto L_0x005d
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x006b }
            r4.invoke(r5)     // Catch:{ all -> 0x006b }
        L_0x005d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006b }
        L_0x005f:
            if (r3 >= r2) goto L_0x0067
            r1.lock()
            int r3 = r3 + 1
            goto L_0x005f
        L_0x0067:
            r0.unlock()
            return
        L_0x006b:
            r4 = move-exception
        L_0x006c:
            if (r3 >= r2) goto L_0x0074
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006c
        L_0x0074:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.install():void");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void uninstall() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0087 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0087 }
            if (r5 == 0) goto L_0x007b
            int r5 = installations     // Catch:{ all -> 0x0087 }
            int r5 = r5 + -1
            installations = r5     // Catch:{ all -> 0x0087 }
            int r5 = installations     // Catch:{ all -> 0x0087 }
            if (r5 == 0) goto L_0x0041
        L_0x0035:
            if (r3 >= r2) goto L_0x003d
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0035
        L_0x003d:
            r0.unlock()
            return
        L_0x0041:
            r4.stopWeakRefCleanerThread()     // Catch:{ all -> 0x0087 }
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner<?>, java.lang.Boolean> r4 = capturedCoroutinesMap     // Catch:{ all -> 0x0087 }
            r4.clear()     // Catch:{ all -> 0x0087 }
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl> r4 = callerInfoCache     // Catch:{ all -> 0x0087 }
            r4.clear()     // Catch:{ all -> 0x0087 }
            kotlinx.coroutines.debug.internal.AgentInstallationType r4 = kotlinx.coroutines.debug.internal.AgentInstallationType.INSTANCE     // Catch:{ all -> 0x0087 }
            boolean r4 = r4.isInstalledStatically$kotlinx_coroutines_core()     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x0062
        L_0x0056:
            if (r3 >= r2) goto L_0x005e
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0056
        L_0x005e:
            r0.unlock()
            return
        L_0x0062:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r4 = dynamicAttach     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x006d
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0087 }
            r4.invoke(r5)     // Catch:{ all -> 0x0087 }
        L_0x006d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0087 }
        L_0x006f:
            if (r3 >= r2) goto L_0x0077
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006f
        L_0x0077:
            r0.unlock()
            return
        L_0x007b:
            java.lang.String r4 = "Agent was not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0087 }
            r5.<init>(r4)     // Catch:{ all -> 0x0087 }
            throw r5     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r4 = move-exception
        L_0x0088:
            if (r3 >= r2) goto L_0x0090
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0088
        L_0x0090:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.uninstall():void");
    }

    private final void startWeakRefCleanerThread() {
        weakRefCleanerThread = ThreadsKt.thread$default(false, true, (ClassLoader) null, "Coroutines Debugger Cleaner", 0, DebugProbesImpl$startWeakRefCleanerThread$1.INSTANCE, 21, (Object) null);
    }

    private final void stopWeakRefCleanerThread() {
        Thread thread = weakRefCleanerThread;
        if (thread != null) {
            weakRefCleanerThread = null;
            thread.interrupt();
            thread.join();
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final java.lang.String hierarchyToString(kotlinx.coroutines.Job r10) {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x00cd }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x00cd }
            if (r5 == 0) goto L_0x00c1
            java.util.Set r4 = r4.getCapturedCoroutines()     // Catch:{ all -> 0x00cd }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x00cd }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00cd }
            r5.<init>()     // Catch:{ all -> 0x00cd }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x00cd }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00cd }
        L_0x003c:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x00cd }
            if (r6 == 0) goto L_0x0062
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x00cd }
            r7 = r6
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r7     // Catch:{ all -> 0x00cd }
            kotlin.coroutines.Continuation<T> r7 = r7.delegate     // Catch:{ all -> 0x00cd }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x00cd }
            kotlinx.coroutines.Job$Key r8 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00cd }
            kotlin.coroutines.CoroutineContext$Key r8 = (kotlin.coroutines.CoroutineContext.Key) r8     // Catch:{ all -> 0x00cd }
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r8)     // Catch:{ all -> 0x00cd }
            if (r7 == 0) goto L_0x005b
            r7 = 1
            goto L_0x005c
        L_0x005b:
            r7 = 0
        L_0x005c:
            if (r7 == 0) goto L_0x003c
            r5.add(r6)     // Catch:{ all -> 0x00cd }
            goto L_0x003c
        L_0x0062:
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x00cd }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x00cd }
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r4)     // Catch:{ all -> 0x00cd }
            int r4 = kotlin.collections.MapsKt.mapCapacity(r4)     // Catch:{ all -> 0x00cd }
            r6 = 16
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r4, (int) r6)     // Catch:{ all -> 0x00cd }
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00cd }
            r6.<init>(r4)     // Catch:{ all -> 0x00cd }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x00cd }
            java.util.Iterator r4 = r5.iterator()     // Catch:{ all -> 0x00cd }
        L_0x0081:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00cd }
            if (r5 == 0) goto L_0x00a0
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00cd }
            r7 = r5
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r7     // Catch:{ all -> 0x00cd }
            kotlin.coroutines.Continuation<T> r7 = r7.delegate     // Catch:{ all -> 0x00cd }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x00cd }
            kotlinx.coroutines.Job r7 = kotlinx.coroutines.JobKt.getJob(r7)     // Catch:{ all -> 0x00cd }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r5 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r5     // Catch:{ all -> 0x00cd }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r5 = r5.info     // Catch:{ all -> 0x00cd }
            r6.put(r7, r5)     // Catch:{ all -> 0x00cd }
            goto L_0x0081
        L_0x00a0:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r4.<init>()     // Catch:{ all -> 0x00cd }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = INSTANCE     // Catch:{ all -> 0x00cd }
            java.lang.String r7 = ""
            r5.build(r10, r6, r4, r7)     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)     // Catch:{ all -> 0x00cd }
        L_0x00b5:
            if (r3 >= r2) goto L_0x00bd
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00b5
        L_0x00bd:
            r0.unlock()
            return r10
        L_0x00c1:
            java.lang.String r10 = "Debug probes are not installed"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00cd }
            r4.<init>(r10)     // Catch:{ all -> 0x00cd }
            throw r4     // Catch:{ all -> 0x00cd }
        L_0x00cd:
            r10 = move-exception
        L_0x00ce:
            if (r3 >= r2) goto L_0x00d6
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00ce
        L_0x00d6:
            r0.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.hierarchyToString(kotlinx.coroutines.Job):java.lang.String");
    }

    private final void build(Job job, Map<Job, DebugCoroutineInfoImpl> map, StringBuilder sb, String str) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(job);
        if (debugCoroutineInfoImpl != null) {
            String state = debugCoroutineInfoImpl.getState();
            sb.append(str + getDebugString(job) + ", continuation is " + state + " at line " + ((StackTraceElement) CollectionsKt.firstOrNull(debugCoroutineInfoImpl.lastObservedStackTrace())) + 10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(9);
            str = sb2.toString();
        } else if (!(job instanceof ScopeCoroutine)) {
            sb.append(str + getDebugString(job) + 10);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(9);
            str = sb3.toString();
        }
        for (Job build : job.getChildren()) {
            build(build, map, sb, str);
        }
    }

    private final String getDebugString(Job job) {
        return job instanceof JobSupport ? ((JobSupport) job).toDebugString() : job.toString();
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final <R> java.util.List<R> dumpCoroutinesInfoImpl(kotlin.jvm.functions.Function2<? super kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>, ? super kotlin.coroutines.CoroutineContext, ? extends R> r8) {
        /*
            r7 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r4 = 1
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = INSTANCE     // Catch:{ all -> 0x006e }
            boolean r6 = r5.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x006e }
            if (r6 == 0) goto L_0x0062
            java.util.Set r5 = r5.getCapturedCoroutines()     // Catch:{ all -> 0x006e }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x006e }
            kotlin.sequences.Sequence r5 = kotlin.collections.CollectionsKt.asSequence(r5)     // Catch:{ all -> 0x006e }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1 r6 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1     // Catch:{ all -> 0x006e }
            r6.<init>()     // Catch:{ all -> 0x006e }
            java.util.Comparator r6 = (java.util.Comparator) r6     // Catch:{ all -> 0x006e }
            kotlin.sequences.Sequence r5 = kotlin.sequences.SequencesKt.sortedWith(r5, r6)     // Catch:{ all -> 0x006e }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$1$3 r6 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$1$3     // Catch:{ all -> 0x006e }
            r6.<init>(r8)     // Catch:{ all -> 0x006e }
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6     // Catch:{ all -> 0x006e }
            kotlin.sequences.Sequence r8 = kotlin.sequences.SequencesKt.mapNotNull(r5, r6)     // Catch:{ all -> 0x006e }
            java.util.List r8 = kotlin.sequences.SequencesKt.toList(r8)     // Catch:{ all -> 0x006e }
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
        L_0x0053:
            if (r3 >= r2) goto L_0x005b
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0053
        L_0x005b:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            return r8
        L_0x0062:
            java.lang.String r8 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006e }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x006e }
            r5.<init>(r8)     // Catch:{ all -> 0x006e }
            throw r5     // Catch:{ all -> 0x006e }
        L_0x006e:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
        L_0x0072:
            if (r3 >= r2) goto L_0x007a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0072
        L_0x007a:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfoImpl(kotlin.jvm.functions.Function2):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003a, code lost:
        r8 = r8.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        /*
            r17 = this;
            r0 = r17
            java.util.List r1 = r17.dumpCoroutinesInfo()
            int r2 = r1.size()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r2)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r2)
            java.util.Iterator r2 = r1.iterator()
        L_0x001d:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x00c1
            java.lang.Object r6 = r2.next()
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo r6 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfo) r6
            kotlin.coroutines.CoroutineContext r7 = r6.getContext()
            kotlinx.coroutines.CoroutineName$Key r8 = kotlinx.coroutines.CoroutineName.Key
            kotlin.coroutines.CoroutineContext$Key r8 = (kotlin.coroutines.CoroutineContext.Key) r8
            kotlin.coroutines.CoroutineContext$Element r8 = r7.get(r8)
            kotlinx.coroutines.CoroutineName r8 = (kotlinx.coroutines.CoroutineName) r8
            r9 = 0
            if (r8 == 0) goto L_0x0045
            java.lang.String r8 = r8.getName()
            if (r8 == 0) goto L_0x0045
            java.lang.String r8 = r0.toStringWithQuotes(r8)
            goto L_0x0046
        L_0x0045:
            r8 = r9
        L_0x0046:
            kotlinx.coroutines.CoroutineDispatcher$Key r10 = kotlinx.coroutines.CoroutineDispatcher.Key
            kotlin.coroutines.CoroutineContext$Key r10 = (kotlin.coroutines.CoroutineContext.Key) r10
            kotlin.coroutines.CoroutineContext$Element r10 = r7.get(r10)
            kotlinx.coroutines.CoroutineDispatcher r10 = (kotlinx.coroutines.CoroutineDispatcher) r10
            if (r10 == 0) goto L_0x0057
            java.lang.String r10 = r0.toStringWithQuotes(r10)
            goto L_0x0058
        L_0x0057:
            r10 = r9
        L_0x0058:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "\n                {\n                    \"name\": "
            r11.append(r12)
            r11.append(r8)
            java.lang.String r8 = ",\n                    \"id\": "
            r11.append(r8)
            kotlinx.coroutines.CoroutineId$Key r8 = kotlinx.coroutines.CoroutineId.Key
            kotlin.coroutines.CoroutineContext$Key r8 = (kotlin.coroutines.CoroutineContext.Key) r8
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r8)
            kotlinx.coroutines.CoroutineId r7 = (kotlinx.coroutines.CoroutineId) r7
            if (r7 == 0) goto L_0x007e
            long r7 = r7.getId()
            java.lang.Long r9 = java.lang.Long.valueOf(r7)
        L_0x007e:
            r11.append(r9)
            java.lang.String r7 = ",\n                    \"dispatcher\": "
            r11.append(r7)
            r11.append(r10)
            java.lang.String r7 = ",\n                    \"sequenceNumber\": "
            r11.append(r7)
            long r7 = r6.getSequenceNumber()
            r11.append(r7)
            java.lang.String r7 = ",\n                    \"state\": \""
            r11.append(r7)
            java.lang.String r7 = r6.getState()
            r11.append(r7)
            java.lang.String r7 = "\"\n                } \n                "
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            java.lang.String r7 = kotlin.text.StringsKt.trimIndent(r7)
            r5.add(r7)
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r7 = r6.getLastObservedFrame()
            r4.add(r7)
            java.lang.Thread r6 = r6.getLastObservedThread()
            r3.add(r6)
            goto L_0x001d
        L_0x00c1:
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = 91
            r6.append(r7)
            r8 = r5
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 63
            r16 = 0
            java.lang.String r5 = kotlin.collections.CollectionsKt.joinToString$default(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r6.append(r5)
            r5 = 93
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r6 = 0
            r2[r6] = r5
            r5 = 1
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.Thread[] r7 = new java.lang.Thread[r6]
            java.lang.Object[] r3 = r3.toArray(r7)
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            java.util.Objects.requireNonNull(r3, r7)
            r2[r5] = r3
            r3 = 2
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.coroutines.jvm.internal.CoroutineStackFrame[] r5 = new kotlin.coroutines.jvm.internal.CoroutineStackFrame[r6]
            java.lang.Object[] r4 = r4.toArray(r5)
            java.util.Objects.requireNonNull(r4, r7)
            r2[r3] = r4
            r3 = 3
            java.util.Collection r1 = (java.util.Collection) r1
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo[] r4 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfo[r6]
            java.lang.Object[] r1 = r1.toArray(r4)
            java.util.Objects.requireNonNull(r1, r7)
            r2[r3] = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfoAsJsonAndReferences():java.lang.Object[]");
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo debugCoroutineInfo) {
        List<StackTraceElement> enhanceStackTraceWithThreadDump = enhanceStackTraceWithThreadDump(debugCoroutineInfo, debugCoroutineInfo.lastObservedStackTrace());
        List arrayList = new ArrayList();
        for (StackTraceElement next : enhanceStackTraceWithThreadDump) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"declaringClass\": \"");
            sb.append(next.getClassName());
            sb.append("\",\n                    \"methodName\": \"");
            sb.append(next.getMethodName());
            sb.append("\",\n                    \"fileName\": ");
            String fileName = next.getFileName();
            sb.append(fileName != null ? toStringWithQuotes(fileName) : null);
            sb.append(",\n                    \"lineNumber\": ");
            sb.append(next.getLineNumber());
            sb.append("\n                }\n                ");
            arrayList.add(StringsKt.trimIndent(sb.toString()));
        }
        return '[' + CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ']';
    }

    private final String toStringWithQuotes(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.quote);
        sb.append(obj);
        sb.append(Typography.quote);
        return sb.toString();
    }

    public final void dumpCoroutines(PrintStream printStream) {
        synchronized (printStream) {
            INSTANCE.dumpCoroutinesSynchronized(printStream);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final boolean isFinished(CoroutineOwner<?> coroutineOwner) {
        Job job;
        CoroutineContext context = coroutineOwner.info.getContext();
        if (context == null || (job = (Job) context.get(Job.Key)) == null || !job.isCompleted()) {
            return false;
        }
        capturedCoroutinesMap.remove(coroutineOwner);
        return true;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final void dumpCoroutinesSynchronized(java.io.PrintStream r14) {
        /*
            r13 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x011a }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x011a }
            if (r5 == 0) goto L_0x010e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r5.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r6 = "Coroutines dump "
            r5.append(r6)     // Catch:{ all -> 0x011a }
            java.text.SimpleDateFormat r6 = dateFormat     // Catch:{ all -> 0x011a }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x011a }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x011a }
            java.lang.String r6 = r6.format(r7)     // Catch:{ all -> 0x011a }
            r5.append(r6)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x011a }
            r14.print(r5)     // Catch:{ all -> 0x011a }
            java.util.Set r4 = r4.getCapturedCoroutines()     // Catch:{ all -> 0x011a }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x011a }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.asSequence(r4)     // Catch:{ all -> 0x011a }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$1$2 r5 = kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$1$2.INSTANCE     // Catch:{ all -> 0x011a }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ all -> 0x011a }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.filter(r4, r5)     // Catch:{ all -> 0x011a }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$lambda-19$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$lambda-19$$inlined$sortedBy$1     // Catch:{ all -> 0x011a }
            r5.<init>()     // Catch:{ all -> 0x011a }
            java.util.Comparator r5 = (java.util.Comparator) r5     // Catch:{ all -> 0x011a }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.sortedWith(r4, r5)     // Catch:{ all -> 0x011a }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x011a }
        L_0x006e:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x011a }
            if (r5 == 0) goto L_0x0100
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x011a }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r5 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r5     // Catch:{ all -> 0x011a }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r6 = r5.info     // Catch:{ all -> 0x011a }
            java.util.List r7 = r6.lastObservedStackTrace()     // Catch:{ all -> 0x011a }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r8 = INSTANCE     // Catch:{ all -> 0x011a }
            java.lang.String r9 = r6.getState()     // Catch:{ all -> 0x011a }
            java.lang.Thread r10 = r6.lastObservedThread     // Catch:{ all -> 0x011a }
            java.util.List r9 = r8.enhanceStackTraceWithThreadDumpImpl(r9, r10, r7)     // Catch:{ all -> 0x011a }
            java.lang.String r10 = r6.getState()     // Catch:{ all -> 0x011a }
            java.lang.String r11 = "RUNNING"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x011a }
            if (r10 == 0) goto L_0x00b0
            if (r9 != r7) goto L_0x00b0
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r10.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r11 = r6.getState()     // Catch:{ all -> 0x011a }
            r10.append(r11)     // Catch:{ all -> 0x011a }
            java.lang.String r11 = " (Last suspension stacktrace, not an actual stacktrace)"
            r10.append(r11)     // Catch:{ all -> 0x011a }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x011a }
            goto L_0x00b4
        L_0x00b0:
            java.lang.String r10 = r6.getState()     // Catch:{ all -> 0x011a }
        L_0x00b4:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r11.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r12 = "\n\nCoroutine "
            r11.append(r12)     // Catch:{ all -> 0x011a }
            kotlin.coroutines.Continuation<T> r5 = r5.delegate     // Catch:{ all -> 0x011a }
            r11.append(r5)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = ", state: "
            r11.append(r5)     // Catch:{ all -> 0x011a }
            r11.append(r10)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = r11.toString()     // Catch:{ all -> 0x011a }
            r14.print(r5)     // Catch:{ all -> 0x011a }
            boolean r5 = r7.isEmpty()     // Catch:{ all -> 0x011a }
            if (r5 == 0) goto L_0x00fb
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r5.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r7 = "\n\tat "
            r5.append(r7)     // Catch:{ all -> 0x011a }
            java.lang.String r7 = "Coroutine creation stacktrace"
            java.lang.StackTraceElement r7 = kotlinx.coroutines.internal.StackTraceRecoveryKt.artificialFrame(r7)     // Catch:{ all -> 0x011a }
            r5.append(r7)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x011a }
            r14.print(r5)     // Catch:{ all -> 0x011a }
            java.util.List r5 = r6.getCreationStackTrace()     // Catch:{ all -> 0x011a }
            r8.printStackTrace(r14, r5)     // Catch:{ all -> 0x011a }
            goto L_0x006e
        L_0x00fb:
            r8.printStackTrace(r14, r9)     // Catch:{ all -> 0x011a }
            goto L_0x006e
        L_0x0100:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x011a }
        L_0x0102:
            if (r3 >= r2) goto L_0x010a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0102
        L_0x010a:
            r0.unlock()
            return
        L_0x010e:
            java.lang.String r14 = "Debug probes are not installed"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011a }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x011a }
            r4.<init>(r14)     // Catch:{ all -> 0x011a }
            throw r4     // Catch:{ all -> 0x011a }
        L_0x011a:
            r14 = move-exception
        L_0x011b:
            if (r3 >= r2) goto L_0x0123
            r1.lock()
            int r3 = r3 + 1
            goto L_0x011b
        L_0x0123:
            r0.unlock()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized(java.io.PrintStream):void");
    }

    private final void printStackTrace(PrintStream printStream, List<StackTraceElement> list) {
        for (StackTraceElement stackTraceElement : list) {
            printStream.print("\n\tat " + stackTraceElement);
        }
    }

    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo debugCoroutineInfo, List<StackTraceElement> list) {
        return enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfo.getState(), debugCoroutineInfo.getLastObservedThread(), list);
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String str, Thread thread, List<StackTraceElement> list) {
        Object obj;
        if (!Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING) || thread == null) {
            return list;
        }
        try {
            Result.Companion companion = Result.Companion;
            DebugProbesImpl debugProbesImpl = this;
            obj = Result.m772constructorimpl(thread.getStackTrace());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m772constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m778isFailureimpl(obj)) {
            obj = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        if (stackTraceElementArr == null) {
            return list;
        }
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            if (Intrinsics.areEqual((Object) stackTraceElement.getClassName(), (Object) "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual((Object) stackTraceElement.getMethodName(), (Object) "resumeWith") && Intrinsics.areEqual((Object) stackTraceElement.getFileName(), (Object) "ContinuationImpl.kt")) {
                break;
            }
            i++;
        }
        Pair<Integer, Integer> findContinuationStartIndex = findContinuationStartIndex(i, stackTraceElementArr, list);
        int intValue = findContinuationStartIndex.component1().intValue();
        int intValue2 = findContinuationStartIndex.component2().intValue();
        if (intValue == -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList((((list.size() + i) - intValue) - 1) - intValue2);
        int i2 = i - intValue2;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(stackTraceElementArr[i3]);
        }
        int size = list.size();
        for (int i4 = intValue + 1; i4 < size; i4++) {
            arrayList.add(list.get(i4));
        }
        return arrayList;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        for (int i2 = 0; i2 < 3; i2++) {
            int findIndexOfFrame = INSTANCE.findIndexOfFrame((i - 1) - i2, stackTraceElementArr, list);
            if (findIndexOfFrame != -1) {
                return TuplesKt.m475to(Integer.valueOf(findIndexOfFrame), Integer.valueOf(i2));
            }
        }
        return TuplesKt.m475to(-1, 0);
    }

    private final int findIndexOfFrame(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt.getOrNull((T[]) stackTraceElementArr, i);
        if (stackTraceElement == null) {
            return -1;
        }
        int i2 = 0;
        for (StackTraceElement next : list) {
            if (Intrinsics.areEqual((Object) next.getFileName(), (Object) stackTraceElement.getFileName()) && Intrinsics.areEqual((Object) next.getClassName(), (Object) stackTraceElement.getClassName()) && Intrinsics.areEqual((Object) next.getMethodName(), (Object) stackTraceElement.getMethodName())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    private final void updateState(Continuation<?> continuation, String str) {
        if (isInstalled$kotlinx_coroutines_core()) {
            if (!Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING) || !KotlinVersion.CURRENT.isAtLeast(1, 3, 30)) {
                CoroutineOwner<?> owner = owner(continuation);
                if (owner != null) {
                    updateState(owner, continuation, str);
                    return;
                }
                return;
            }
            CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
            if (coroutineStackFrame != null) {
                updateRunningState(coroutineStackFrame, str);
            }
        }
    }

    private final void updateRunningState(CoroutineStackFrame coroutineStackFrame, String str) {
        ReentrantReadWriteLock.ReadLock readLock = coroutineStateLock.readLock();
        readLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = INSTANCE;
            if (debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
                ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> concurrentWeakMap = callerInfoCache;
                DebugCoroutineInfoImpl remove = concurrentWeakMap.remove(coroutineStackFrame);
                if (remove == null) {
                    CoroutineOwner<?> owner = debugProbesImpl.owner(coroutineStackFrame);
                    if (owner != null) {
                        remove = owner.info;
                        if (remove != null) {
                            CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = remove.getLastObservedFrame$kotlinx_coroutines_core();
                            CoroutineStackFrame realCaller = lastObservedFrame$kotlinx_coroutines_core != null ? debugProbesImpl.realCaller(lastObservedFrame$kotlinx_coroutines_core) : null;
                            if (realCaller != null) {
                                concurrentWeakMap.remove(realCaller);
                            }
                        }
                    }
                    readLock.unlock();
                    return;
                }
                remove.updateState$kotlinx_coroutines_core(str, (Continuation) coroutineStackFrame);
                CoroutineStackFrame realCaller2 = debugProbesImpl.realCaller(coroutineStackFrame);
                if (realCaller2 == null) {
                    readLock.unlock();
                    return;
                }
                concurrentWeakMap.put(realCaller2, remove);
                Unit unit = Unit.INSTANCE;
                readLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    private final void updateState(CoroutineOwner<?> coroutineOwner, Continuation<?> continuation, String str) {
        ReentrantReadWriteLock.ReadLock readLock = coroutineStateLock.readLock();
        readLock.lock();
        try {
            if (INSTANCE.isInstalled$kotlinx_coroutines_core()) {
                coroutineOwner.info.updateState$kotlinx_coroutines_core(str, continuation);
                Unit unit = Unit.INSTANCE;
                readLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }

    private final CoroutineOwner<?> owner(Continuation<?> continuation) {
        CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
        if (coroutineStackFrame != null) {
            return owner(coroutineStackFrame);
        }
        return null;
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof CoroutineOwner)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (CoroutineOwner) coroutineStackFrame;
    }

    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> continuation) {
        StackTraceFrame stackTraceFrame;
        if (!isInstalled$kotlinx_coroutines_core() || owner((Continuation<?>) continuation) != null) {
            return continuation;
        }
        if (enableCreationStackTraces) {
            stackTraceFrame = toStackTraceFrame(sanitizeStackTrace(new Exception()));
        } else {
            stackTraceFrame = null;
        }
        return createOwner(continuation, stackTraceFrame);
    }

    private final <T> Continuation<T> createOwner(Continuation<? super T> continuation, StackTraceFrame stackTraceFrame) {
        if (!isInstalled$kotlinx_coroutines_core()) {
            return continuation;
        }
        CoroutineOwner coroutineOwner = new CoroutineOwner(continuation, new DebugCoroutineInfoImpl(continuation.getContext(), stackTraceFrame, sequenceNumber$FU.incrementAndGet(debugProbesImpl$SequenceNumberRefVolatile)), stackTraceFrame);
        ConcurrentWeakMap<CoroutineOwner<?>, Boolean> concurrentWeakMap = capturedCoroutinesMap;
        concurrentWeakMap.put(coroutineOwner, true);
        if (!isInstalled$kotlinx_coroutines_core()) {
            concurrentWeakMap.clear();
        }
        return coroutineOwner;
    }

    /* access modifiers changed from: private */
    public final void probeCoroutineCompleted(CoroutineOwner<?> coroutineOwner) {
        CoroutineStackFrame realCaller;
        capturedCoroutinesMap.remove(coroutineOwner);
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = coroutineOwner.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core != null && (realCaller = realCaller(lastObservedFrame$kotlinx_coroutines_core)) != null) {
            callerInfoCache.remove(realCaller);
        }
    }

    @Metadata(mo33736d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, mo33737d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "frame", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DebugProbesImpl.kt */
    private static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> delegate;
        private final CoroutineStackFrame frame;
        public final DebugCoroutineInfoImpl info;

        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        public CoroutineOwner(Continuation<? super T> continuation, DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineStackFrame coroutineStackFrame) {
            this.delegate = continuation;
            this.info = debugCoroutineInfoImpl;
            this.frame = coroutineStackFrame;
        }

        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getCallerFrame();
            }
            return null;
        }

        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getStackTraceElement();
            }
            return null;
        }

        public void resumeWith(Object obj) {
            DebugProbesImpl.INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(obj);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T t) {
        int i;
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i3 = length2 - 1;
                if (Intrinsics.areEqual((Object) stackTrace[length2].getClassName(), (Object) "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i2 = length2;
                    break;
                } else if (i3 < 0) {
                    break;
                } else {
                    length2 = i3;
                }
            }
        }
        if (!sanitizeStackTraces) {
            int i4 = length - i;
            ArrayList arrayList = new ArrayList(i4);
            int i5 = 0;
            while (i5 < i4) {
                arrayList.add(i5 == 0 ? StackTraceRecoveryKt.artificialFrame(ARTIFICIAL_FRAME_MESSAGE) : stackTrace[i5 + i]);
                i5++;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i) + 1);
        Collection collection = arrayList2;
        collection.add(StackTraceRecoveryKt.artificialFrame(ARTIFICIAL_FRAME_MESSAGE));
        while (true) {
            i++;
            while (i < length) {
                if (isInternalMethod(stackTrace[i])) {
                    collection.add(stackTrace[i]);
                    int i6 = i + 1;
                    while (i6 < length && isInternalMethod(stackTrace[i6])) {
                        i6++;
                    }
                    int i7 = i6 - 1;
                    int i8 = i7;
                    while (i8 > i && stackTrace[i8].getFileName() == null) {
                        i8--;
                    }
                    if (i8 > i && i8 < i7) {
                        collection.add(stackTrace[i8]);
                    }
                    collection.add(stackTrace[i7]);
                    i = i6;
                } else {
                    collection.add(stackTrace[i]);
                }
            }
            return arrayList2;
        }
    }

    private final boolean isInternalMethod(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, (Object) null);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final java.util.List<kotlinx.coroutines.debug.internal.DebugCoroutineInfo> dumpCoroutinesInfo() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0067 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0067 }
            if (r5 == 0) goto L_0x005b
            java.util.Set r4 = r4.getCapturedCoroutines()     // Catch:{ all -> 0x0067 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x0067 }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.asSequence(r4)     // Catch:{ all -> 0x0067 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1     // Catch:{ all -> 0x0067 }
            r5.<init>()     // Catch:{ all -> 0x0067 }
            java.util.Comparator r5 = (java.util.Comparator) r5     // Catch:{ all -> 0x0067 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.sortedWith(r4, r5)     // Catch:{ all -> 0x0067 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1     // Catch:{ all -> 0x0067 }
            r5.<init>()     // Catch:{ all -> 0x0067 }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ all -> 0x0067 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.mapNotNull(r4, r5)     // Catch:{ all -> 0x0067 }
            java.util.List r4 = kotlin.sequences.SequencesKt.toList(r4)     // Catch:{ all -> 0x0067 }
        L_0x004f:
            if (r3 >= r2) goto L_0x0057
            r1.lock()
            int r3 = r3 + 1
            goto L_0x004f
        L_0x0057:
            r0.unlock()
            return r4
        L_0x005b:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0067 }
            r5.<init>(r4)     // Catch:{ all -> 0x0067 }
            throw r5     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r4 = move-exception
        L_0x0068:
            if (r3 >= r2) goto L_0x0070
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0068
        L_0x0070:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfo():java.util.List");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final java.util.List<kotlinx.coroutines.debug.internal.DebuggerInfo> dumpDebuggerInfo() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0067 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0067 }
            if (r5 == 0) goto L_0x005b
            java.util.Set r4 = r4.getCapturedCoroutines()     // Catch:{ all -> 0x0067 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x0067 }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.asSequence(r4)     // Catch:{ all -> 0x0067 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1     // Catch:{ all -> 0x0067 }
            r5.<init>()     // Catch:{ all -> 0x0067 }
            java.util.Comparator r5 = (java.util.Comparator) r5     // Catch:{ all -> 0x0067 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.sortedWith(r4, r5)     // Catch:{ all -> 0x0067 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1     // Catch:{ all -> 0x0067 }
            r5.<init>()     // Catch:{ all -> 0x0067 }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ all -> 0x0067 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.mapNotNull(r4, r5)     // Catch:{ all -> 0x0067 }
            java.util.List r4 = kotlin.sequences.SequencesKt.toList(r4)     // Catch:{ all -> 0x0067 }
        L_0x004f:
            if (r3 >= r2) goto L_0x0057
            r1.lock()
            int r3 = r3 + 1
            goto L_0x004f
        L_0x0057:
            r0.unlock()
            return r4
        L_0x005b:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0067 }
            r5.<init>(r4)     // Catch:{ all -> 0x0067 }
            throw r5     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r4 = move-exception
        L_0x0068:
            if (r3 >= r2) goto L_0x0070
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0068
        L_0x0070:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpDebuggerInfo():java.util.List");
    }

    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> list) {
        StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return stackTraceFrame;
    }
}
