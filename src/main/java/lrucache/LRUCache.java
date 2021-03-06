package lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.System.out;

/**
 * Created by mayan on 8/6/18.
 * Example
 * LRU Cache of size 2.
 * cache.put(1, 1);
 cache.put(2, 2);
 cache.get(1);       // returns 1
 cache.put(3, 3);    // evicts key 2
 cache.get(2        );       // returns -1 (not found)
 cache.put(4, 4);    // evicts key 1
 cache.get(1);       // returns -1 (not found)
 cache.get(3);       // returns 3
 cache.get(4);       // returns 4
 */
public class LRUCache {

    public static void main(String[] args){
        LRUCache aLruCache = new LRUCache(2);
        aLruCache.put(10,10);
        aLruCache.put(11,11);
        int test = aLruCache.get(11);
        aLruCache.put(12,12);
        ;
        out.println(aLruCache.integerIntegerMap.keySet());
    }
    //User this as doubly link list.
    class Node{
        int data;
        Node prev,next;

        public Node(int data) {
            this.data = data;
        }
    }
    //recent item
    Node head;
    //good to remove item.
    Node tail;
    //map to store ket and nodes for O(1) get and put.
    private final Map<Integer,Node> integerIntegerMap = new HashMap<>();

    int size = 0;

    public LRUCache(int size) {
        this.size = size;
    }

    public int get(int key){
        if(integerIntegerMap.containsKey(key)){
            Node node = integerIntegerMap.get(key);
            updateLinkList(node);
            return node.data;
        }else return -1;
    }
    public void put(int key,int value){
        Node node =integerIntegerMap.get(key);
        if(node !=null){
            node.data = value;
            updateLinkList(node);
        }else{
            node = new Node(value);
            integerIntegerMap.put(key,node);
            addNodeToHead(node);
        }
        if(integerIntegerMap.size() == size){
            removeLRU();
        }
    }

    private void addNodeToHead(Node node) {
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void removeLRU(){
        if(tail == null) return;
        //remove
        Node newTail = tail.prev;
        tail.prev = null;
        newTail.next = null;
        tail = newTail;

    }
    private void updateLinkList(Node node){
       if(head  == null ){
           head = node;
           tail = node;
       }
       else if(head == node){
           //nothing
       }
       else if(node == tail){
           //Add node in front of list
           //remove from last
           tail = tail.prev;
           tail.prev.next = null;
           tail.prev = null;

           //Add in front
           node.next = head;
           head.prev = node;
           head = node;
           return;
       }else {//between head and tail.
           //removed from btn
           node.prev.next = node.next;
           node.next.prev = node.prev;

           //Add it to head.
           node.next = head;
           head.prev =node;
           node = head ;
       }
    }
}
