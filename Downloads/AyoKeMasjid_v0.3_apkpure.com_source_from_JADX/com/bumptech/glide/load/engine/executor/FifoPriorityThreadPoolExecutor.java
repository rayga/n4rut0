package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor {
    AtomicInteger ordering;

    public static class DefaultThreadFactory implements ThreadFactory {
        int threadNum;

        /* renamed from: com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.DefaultThreadFactory.1 */
        class C01901 extends Thread {
            C01901(Runnable x0, String x1) {
                super(x0, x1);
            }

            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        public DefaultThreadFactory() {
            this.threadNum = 0;
        }

        public Thread newThread(Runnable runnable) {
            Thread result = new C01901(runnable, "fifo-pool-thread-" + this.threadNum);
            this.threadNum++;
            return result;
        }
    }

    static class LoadTask<T> extends FutureTask<T> implements Comparable<LoadTask<?>> {
        private final int order;
        private final int priority;

        public LoadTask(Runnable runnable, T result, int order) {
            super(runnable, result);
            if (runnable instanceof Prioritized) {
                this.priority = ((Prioritized) runnable).getPriority();
                this.order = order;
                return;
            }
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
        }

        public boolean equals(Object o) {
            if (!(o instanceof LoadTask)) {
                return false;
            }
            LoadTask<Object> other = (LoadTask) o;
            if (this.order == other.order && this.priority == other.priority) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.priority * 31) + this.order;
        }

        public int compareTo(LoadTask<?> loadTask) {
            int result = this.priority - loadTask.priority;
            if (result == 0) {
                return this.order - loadTask.order;
            }
            return result;
        }
    }

    public FifoPriorityThreadPoolExecutor(int poolSize) {
        this(poolSize, poolSize, 0, TimeUnit.MILLISECONDS, new DefaultThreadFactory());
    }

    public FifoPriorityThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAlive, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAlive, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.ordering = new AtomicInteger();
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new LoadTask(runnable, value, this.ordering.getAndIncrement());
    }
}
