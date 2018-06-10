package consistenthashing;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

import static java.lang.System.out;

/**
 * Created by mayan on 9/6/18.
 */
public class ConsistentHash<T> {
    public static void main(String[] args){
       /* ArrayList<String> al = new ArrayList<String>();
        al.add("redis1");
        al.add("redis2");
        al.add("redis3");
        al.add("redis4");
        String[] userIds =
                {"-84942321036308",
                        "-76029520310209",
                        "-68343931116147",
                        "-54921760962352"
                };
        ConsistentHash<String> consistentHash = new ConsistentHash<>(Hashing.md5(),10,al);
        for (String userId : userIds) {
            System.out.println(consistentHash.get(userId));
        }
*/
        String[] userIds =
                {"-84942321036308",
                        "-76029520310209",
                        "-68343931116147",
                        "-54921760962352"
                };
        TreeMap<Long,String> longStringTreeMap = new TreeMap<>();
        longStringTreeMap.put((long) 12,"aB");
        longStringTreeMap.put((long) 13,"aC");
        longStringTreeMap.put((long) 14,"aD");
        longStringTreeMap.put((long) 15,"aF");
        out.println(longStringTreeMap.tailMap((long)14));
        SortedMap<Long, String> tailMap = longStringTreeMap.tailMap((long)14);
        out.println(tailMap.firstKey());

    }
    private final HashFunction hashFunction;
    private final int numberOfReplicas;
    private final SortedMap<Long, T> circle = new TreeMap<Long, T>();

    public ConsistentHash(HashFunction hashFunction, int numberOfReplicas,
                          Collection<T> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;

        for (T node : nodes) {
            add(node);
        }
    }

    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hashFunction.hashString(node.toString() + i).asLong(),
                    node);
        }
    }

    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hashFunction.hashString(node.toString() + i).asLong());
        }
    }

    public T get(Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        long hash = hashFunction.hashString(key.toString()).asLong();
        if (!circle.containsKey(hash)) {
            SortedMap<Long, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
}
