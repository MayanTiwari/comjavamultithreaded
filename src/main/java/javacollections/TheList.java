package javacollections;

import java.util.*;

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
    }
}
