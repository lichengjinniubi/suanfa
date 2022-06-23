package com.example.demo.hashTable.lru.v2;

import java.util.HashMap;

public class LRUCache{
    static class Node{
        int key,val;
        Node pre,next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    static class DoubleList{
        int size;
        Node head,tail;

        public void addFirst(Node node){
            if (head == null) {
                head = tail = node;
            }else {
                node.next = head;
                head.pre = node;
                head = node;
            }
            size++;
        }

        public void remove(Node node){
            if (head == tail) {
                head = tail = null;
            }else if (node.key == tail.key){
                final Node p = tail.pre;
                tail.pre.next = null;
                tail.pre = null;
                tail = p;
            }else if (node.key == head.key) {
                final Node n = head.next;
                head.next.pre = null;
                head.next = null;
                head = n;
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = node.pre = null;
            }
            size--;
        }
    }

    HashMap<Integer,Node> map;
    DoubleList cache;
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        cache = new DoubleList();
    }

    public int get(int key){
        if (map.containsKey(key)) {
            int val = map.get(key).val;
            put(key,val);
            return val;
        }else {
            return -1;
        }
    }

    public void put(int key,int val){
        final Node node = new Node(key,val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        }else {
            if (capacity == cache.size) {
                map.remove(cache.tail.key);
                cache.remove(cache.tail);
            }
        }
        cache.addFirst(node);
        map.put(key,node);
    }

    public HashMap<Integer,Node> list(){
        return this.map;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(200);
        for(int i=1; i<=100; i++){
            cache.put(i, i);
        }


        HashMap<Integer,Node> maps = cache.list();
        maps.forEach((k, v) -> {
            System.out.println(k + "=>" + v.key + "=>" + v.val);
        });
    }
}


