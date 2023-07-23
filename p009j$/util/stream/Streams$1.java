package p009j$.util.stream;

/* renamed from: j$.util.stream.Streams$1 */
class Streams$1 implements Runnable {
    final /* synthetic */ Runnable val$a;
    final /* synthetic */ Runnable val$b;

    Streams$1(Runnable runnable, Runnable runnable2) {
        this.val$a = runnable;
        this.val$b = runnable2;
    }

    public void run() {
        try {
            this.val$a.run();
            this.val$b.run();
            return;
        } catch (Throwable th) {
            try {
                th.addSuppressed(th);
            } catch (Throwable unused) {
            }
        }
        throw th;
    }
}
