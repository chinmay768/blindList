import java.util.concurrent.locks.ReentrantLock;
import java.lang.management.*;

public class DeadlockRecoveryDemo {

    static class Worker extends Thread {
        private final ReentrantLock lock1;
        private final ReentrantLock lock2;

        Worker(String name, ReentrantLock lock1, ReentrantLock lock2) {
            super(name);
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(getName() + " trying to acquire lock1");
                    lock1.lockInterruptibly(); // interruptible lock

                    try {
                        Thread.sleep(100); // simulate delay

                        System.out.println(getName() + " trying to acquire lock2");
                        lock2.lockInterruptibly(); // interruptible lock

                        try {
                            System.out.println(getName() + " acquired both locks, working...");
                        } finally {
                            lock2.unlock();
                        }

                    } finally {
                        lock1.unlock();
                    }

                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted, releasing locks and exiting");
            }
        }
    }

    // 🔍 Deadlock Detector Thread
    static class DeadlockDetector extends Thread {
        public void run() {
            ThreadMXBean bean = ManagementFactory.getThreadMXBean();

            while (true) {
                long[] ids = bean.findDeadlockedThreads();

                if (ids != null) {
                    System.out.println("\n🚨 Deadlock detected! Interrupting threads...\n");

                    ThreadInfo[] infos = bean.getThreadInfo(ids);

                    for (ThreadInfo info : infos) {
                        for (Thread t : Thread.getAllStackTraces().keySet()) {
                            if (t.getId() == info.getThreadId()) {
                                t.interrupt(); // 🔥 break deadlock
                            }
                        }
                    }
                    break;
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();

        // Create deadlock situation
        Worker t1 = new Worker("Thread-1", lockA, lockB);
        Worker t2 = new Worker("Thread-2", lockB, lockA);

        t1.start();
        t2.start();

        // Start deadlock detector
        DeadlockDetector detector = new DeadlockDetector();
        detector.setDaemon(true);
        detector.start();
    }
}