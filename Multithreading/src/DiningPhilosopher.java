import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopher {

    static class Philosopher extends Thread {
        private final Object firstFork;
        private final Object secondFork;
        private final int id;

        Philosopher(int id, Object left, Object right) {
            this.id = id;

            // Enforce global order using identityHashCode
            if (System.identityHashCode(left) < System.identityHashCode(right)) {
                this.firstFork = left;
                this.secondFork = right;
            } else {
                this.firstFork = right;
                this.secondFork = left;
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    think();

                    synchronized (firstFork) {
                        synchronized (secondFork) {
                            eat();
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void think() throws InterruptedException {
            System.out.println("Philosopher " + id + " is thinking");
            Thread.sleep((int) (Math.random() * 500));
        }

        private void eat() throws InterruptedException {
            System.out.println("Philosopher " + id + " is eating 🍝");
            Thread.sleep((int) (Math.random() * 500));
        }
    }



    static class PhilosopherSemaphone extends Thread {

        private static Semaphore table; // N-1 (for 5 philosophers)

        private final Object leftFork;
        private final Object rightFork;

        PhilosopherSemaphone(Object left, Object right, int n) {
            table = new Semaphore(n - 1);
            this.leftFork = left;
            this.rightFork = right;
        }

        public void run() {
            try {
                while (true) {
                    table.acquire();

                    try {
                        synchronized (leftFork) {
                            synchronized (rightFork) {
                                System.out.println(getName() + " eating");
                            }
                        }
                    } finally {
                        table.release(); // ensure permit is always returned
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    class PhilosopherReenterant extends Thread {
        private final ReentrantLock leftFork;
        private final ReentrantLock rightFork;
        private final int id;

        PhilosopherReenterant(int id, ReentrantLock left, ReentrantLock right) {
            this.id = id;
            this.leftFork = left;
            this.rightFork = right;
        }

        public void run() {
            try {
                while (true) {
                    think();
                    eat();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void think() throws InterruptedException {
            System.out.println("Philosopher " + id + " is thinking");
            Thread.sleep((int) (Math.random() * 1000));
        }

        private void eat() throws InterruptedException {
            while (true) {
                if (leftFork.tryLock()) {
                    try {
                        if (rightFork.tryLock()) {
                            try {
                                System.out.println("Philosopher " + id + " is eating");
                                Thread.sleep((int) (Math.random() * 1000));
                                return;
                            } finally {
                                rightFork.unlock();
                            }
                        }
                    } finally {
                        leftFork.unlock();
                    }
                }
                // Retry after short delay
                Thread.sleep(50);
            }
        }
    }

    // Object Ordering
//    public static void main(String[] args) throws InterruptedException {
//        int n = 3;
//
//        Object[] forks = new Object[n];
//        for (int i = 0; i < n; i++) {
//            forks[i] = new Object();
//        }
//
//        Philosopher[] philosophers = new Philosopher[n];
//
//        for (int i = 0; i < n; i++) {
//            Object leftFork = forks[i];
//            Object rightFork = forks[(i + 1) % n];
//
//            philosophers[i] = new Philosopher(i, leftFork, rightFork);
//            philosophers[i].start();
//        }
//
//        // Let it run for 5 seconds
//        Thread.sleep(5000);
//
//        // Stop all threads
//        for (Philosopher p : philosophers) {
//            p.interrupt();
//        }
//    }

    // Semaphone
//    public static void main(String[] args) throws InterruptedException {
//        int n = 3;
//
//        Object[] forks = new Object[n];
//        for (int i = 0; i < n; i++) {
//            forks[i] = new Object();
//        }
//
//        PhilosopherSemaphone[] philosophers = new PhilosopherSemaphone[n];
//
//        for (int i = 0; i < n; i++) {
//            Object leftFork = forks[i];
//            Object rightFork = forks[(i + 1) % n];
//
//            philosophers[i] = new PhilosopherSemaphone(leftFork, rightFork, n);
//            philosophers[i].start();
//        }
//
//        // Let it run for 5 seconds
//        Thread.sleep(5000);
//
//        // Stop all threads
//        for (PhilosopherSemaphone p : philosophers) {
//            p.interrupt();
//        }
//    }


    public static void main(String[] args) {
        int n = 3;
        ReentrantLock[] forks = new ReentrantLock[n];

        for (int i = 0; i < n; i++) {
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < n; i++) {
            ReentrantLock left = forks[i];
            ReentrantLock right = forks[(i + 1) % n];

            new Philosopher(i, left, right).start();
        }
    }
}