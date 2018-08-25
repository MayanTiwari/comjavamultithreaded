package casing;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by mayan on 29/7/18.
 */
public class ConcurrentStack<E> {

    static class Node<E> {
        public final E item;
        public Node<E> next;

        public Node(E item){
            this.item = item;
        }
    }
    AtomicReference<Node<E>> top = new AtomicReference<>();
    public void push(E item){
        Node<E> newHead = new Node<E>(item);
        Node<E> oldHead;
        do{
            oldHead = top.get();
            newHead.next = oldHead;
        }while (!top.compareAndSet(oldHead,newHead));

    }
    public E pop(){
        Node<E> oldHead;
        Node<E> newHead;
        do{
            oldHead = top.get();
            if(oldHead == null){
                return null;
            }
            newHead = oldHead.next;
        }while (!top.compareAndSet(oldHead,newHead));
        return newHead.item;
    }
}
