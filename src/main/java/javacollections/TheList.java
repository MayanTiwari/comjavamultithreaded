package javacollections;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by mayan on 22/6/18.
 */
public class TheList {
    static class SkipIterator<T> implements Iterator<T>{
        private int size = 0;
        private Iterator<T> iterator;

        public SkipIterator(Collection<T> tCollection) {
            this.size = tCollection.size();
            iterator = tCollection.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.size >= 2;
        }

        @Override
        public T next() {
            int count = 0;
            this.size = size- 2;
            T value = null;
            while (this.iterator.hasNext() && count < 2){
                value = this.iterator.next();
                count++;
            }

            return value;
        }
    }
    public static void main(String[] args){
        List<Integer> i = Arrays.asList(1,2,3,4,5,6,7,8);
        SkipIterator<Integer> integerSkipIterator = new SkipIterator<Integer>(i);
        while (integerSkipIterator.hasNext()){
            System.out.println(integerSkipIterator.next());
        }
        HashSet<Integer> integers = new HashSet<>();
        HashMap<Integer,Integer> integerHashMap = new HashMap<>();
        Map<Integer,Integer> integerMap = new TreeMap<>();
        Queue<Integer> integerQueue = new LinkedBlockingQueue<>(10);
        Queue<Integer> integerAQueue = new ArrayBlockingQueue<Integer>(10);
        Queue<Integer> syncQueue = new SynchronousQueue<>(false);
        //Queue<Integer> delayQueue = new DelayQueue<>(100);
        TransferQueue<Integer> transferQueue = new LinkedTransferQueue<>();
        ConcurrentHashMap<Integer,Integer> integerIntegerConcurrentHashMap = new ConcurrentHashMap<>();
        LongAdder longAdder;
        List<Integer> copyOnList = new CopyOnWriteArrayList<>();
        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
        hashMap.put(1,2);
        hashMap.get(1);





    }
}
