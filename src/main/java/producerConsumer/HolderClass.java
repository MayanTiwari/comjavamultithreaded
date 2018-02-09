package producerConsumer;

/**
 * Created by mayan on 2/12/17.
 */
public class HolderClass {

    private static final int BUFFER_SIZE = 50;
    private Object lock = new Object();
    int count = 0 ;
    int[] buffer = new int[BUFFER_SIZE];
    class Producer{
        public void produce() throws InterruptedException {
            synchronized (lock){
                if (isFull(buffer)){
                    lock.wait();
                }
                buffer[count++] = 1;
                lock.notifyAll();
            }
        }
        private boolean isFull(int[] buffer) {
            return  false;
        }
    }
    class Consumer{
        public void consumer() throws InterruptedException {
            synchronized (lock){
                if(isEmpty(buffer))
                    lock.wait();
                buffer[--count] = 0;
                lock.notifyAll();
            }
        }

        private boolean isEmpty(int[] buffer) {
            return true;
        }
    }
}
