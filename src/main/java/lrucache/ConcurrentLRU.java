package lrucache;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by mayan on 22/7/18.
 */
public class ConcurrentLRU<Key,Value> {

    private final int maxSize;
    private ConcurrentHashMap<Key, Value> map;
    private ConcurrentLinkedQueue<Key> queue;
    private ConcurrentLinkedDeque<Integer> test;

    public ConcurrentLRU(final int maxSize) {
        this.maxSize = maxSize;
        map = new ConcurrentHashMap<Key, Value>(maxSize);
        queue = new ConcurrentLinkedQueue<Key>();
    }

    /**
     * @param key - may not be null!
     * @param value - may not be null!
     */
    public void put(final Key key, final Value value) {
        if (map.containsKey(key)) {
            queue.remove(key); // remove the key from the FIFO queue
        }

        while (queue.size() >= maxSize) {
            Key oldestKey = queue.poll();
            if (null != oldestKey) {
                map.remove(oldestKey);
            }
        }
        queue.add(key);
        map.put(key, value);
    }

    /**
     * @param key - may not be null!
     * @return the value associated to the given key or null
     */
    public Value get(final Key key) {
        return map.get(key);
    }
}
