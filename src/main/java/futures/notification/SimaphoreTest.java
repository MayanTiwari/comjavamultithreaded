package futures.notification;

import java.util.concurrent.Semaphore;

/**
 * Created by mayan on 3/8/18.
 */
public class SimaphoreTest {
    private Semaphore semaphore = new Semaphore(0);
    private String winner;

    private synchronized void finished(String threadName) {
        if (winner == null) {
            winner = threadName;
        }
        semaphore.release();
    }

    public void run() {
        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    Thread.sleep((long) (5000 * Math.random()));
                }
                catch (InterruptedException e) {
                    // ignore
                }
                finally {
                    finished("thread 1");
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                try {
                    Thread.sleep((long) (5000 * Math.random()));
                }
                catch (InterruptedException e) {
                    // ignore
                }
                finally {
                    finished("thread 2");
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        try {
            semaphore.acquire();
            System.out.println("The winner is " + winner);
        }
        catch (InterruptedException e) {
            System.out.println("No winner");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        new SimaphoreTest().run();
    }
}
