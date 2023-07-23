package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class ExecutionSequencer {
    /* access modifiers changed from: private */
    public ThreadConfinedTaskQueue latestTaskQueue = new ThreadConfinedTaskQueue();
    private final AtomicReference<ListenableFuture<Void>> ref = new AtomicReference<>(Futures.immediateVoidFuture());

    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    private static final class ThreadConfinedTaskQueue {
        @CheckForNull
        Executor nextExecutor;
        @CheckForNull
        Runnable nextTask;
        @CheckForNull
        Thread thread;

        private ThreadConfinedTaskQueue() {
        }
    }

    public <T> ListenableFuture<T> submit(final Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(executor);
        return submitAsync(new AsyncCallable<T>(this) {
            public ListenableFuture<T> call() throws Exception {
                return Futures.immediateFuture(callable.call());
            }

            public String toString() {
                return callable.toString();
            }
        }, executor);
    }

    public <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> asyncCallable, Executor executor) {
        Preconditions.checkNotNull(asyncCallable);
        Preconditions.checkNotNull(executor);
        final TaskNonReentrantExecutor taskNonReentrantExecutor = new TaskNonReentrantExecutor(executor, this);
        C21012 r10 = new AsyncCallable<T>(this) {
            public ListenableFuture<T> call() throws Exception {
                if (!taskNonReentrantExecutor.trySetStarted()) {
                    return Futures.immediateCancelledFuture();
                }
                return asyncCallable.call();
            }

            public String toString() {
                return asyncCallable.toString();
            }
        };
        final SettableFuture create = SettableFuture.create();
        final ListenableFuture andSet = this.ref.getAndSet(create);
        TrustedListenableFutureTask create2 = TrustedListenableFutureTask.create(r10);
        andSet.addListener(create2, taskNonReentrantExecutor);
        ListenableFuture<T> nonCancellationPropagating = Futures.nonCancellationPropagating(create2);
        final TrustedListenableFutureTask trustedListenableFutureTask = create2;
        final ListenableFuture<T> listenableFuture = nonCancellationPropagating;
        C21023 r0 = new Runnable(this) {
            public void run() {
                if (trustedListenableFutureTask.isDone()) {
                    create.setFuture(andSet);
                } else if (listenableFuture.isCancelled() && taskNonReentrantExecutor.trySetCancelled()) {
                    trustedListenableFutureTask.cancel(false);
                }
            }
        };
        nonCancellationPropagating.addListener(r0, MoreExecutors.directExecutor());
        create2.addListener(r0, MoreExecutors.directExecutor());
        return nonCancellationPropagating;
    }

    private static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {
        @CheckForNull
        Executor delegate;
        @CheckForNull
        ExecutionSequencer sequencer;
        @CheckForNull
        Thread submitting;
        @CheckForNull
        Runnable task;

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = executor;
            this.sequencer = executionSequencer;
        }

        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                ExecutionSequencer executionSequencer = this.sequencer;
                Objects.requireNonNull(executionSequencer);
                ThreadConfinedTaskQueue access$400 = executionSequencer.latestTaskQueue;
                if (access$400.thread == this.submitting) {
                    this.sequencer = null;
                    Preconditions.checkState(access$400.nextTask == null);
                    access$400.nextTask = runnable;
                    Executor executor = this.delegate;
                    Objects.requireNonNull(executor);
                    access$400.nextExecutor = executor;
                    this.delegate = null;
                } else {
                    Executor executor2 = this.delegate;
                    Objects.requireNonNull(executor2);
                    this.delegate = null;
                    this.task = runnable;
                    executor2.execute(this);
                }
            } finally {
                this.submitting = null;
            }
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            if (currentThread != this.submitting) {
                Runnable runnable = this.task;
                Objects.requireNonNull(runnable);
                this.task = null;
                runnable.run();
                return;
            }
            ThreadConfinedTaskQueue threadConfinedTaskQueue = new ThreadConfinedTaskQueue();
            threadConfinedTaskQueue.thread = currentThread;
            ExecutionSequencer executionSequencer = this.sequencer;
            Objects.requireNonNull(executionSequencer);
            ThreadConfinedTaskQueue unused = executionSequencer.latestTaskQueue = threadConfinedTaskQueue;
            this.sequencer = null;
            try {
                Runnable runnable2 = this.task;
                Objects.requireNonNull(runnable2);
                this.task = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = threadConfinedTaskQueue.nextTask;
                    boolean z = true;
                    boolean z2 = runnable3 != null;
                    Executor executor = threadConfinedTaskQueue.nextExecutor;
                    if (executor == null) {
                        z = false;
                    }
                    if (z && z2) {
                        threadConfinedTaskQueue.nextTask = null;
                        threadConfinedTaskQueue.nextExecutor = null;
                        executor.execute(runnable3);
                    } else {
                        return;
                    }
                }
            } finally {
                threadConfinedTaskQueue.thread = null;
            }
        }

        /* access modifiers changed from: private */
        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        /* access modifiers changed from: private */
        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }
    }
}
