package com.example.demo.hashTable.lru.v2;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTest {

    //定义一个链表节点
    static class Node{
        Node pre, next;
        int key, val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    //定义一个双向链表
    static class DoubleList{

        private Node head = null;
        private Node tail = null;

        int size;

        public void addFirst(Node node){
            if(head == null){
                head = tail = node;
            }else{
                node.next = head;
                head.pre = node;
                head = node;
            }
            size++;
        }


        public void remove(Node node){
            if(head == tail){ //只有一个节点
                head = tail = null;
            }else if(node.key == head.key){ //是第一个节点
                Node curr = head.next;
                head.next.pre = null;
                head.next = null;
                head = curr;
            }else if(node.key == tail.key){
                Node curr = tail.pre;
                tail.pre.next = null;
                tail.pre = null;
                tail = curr;
            }else{
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = node.pre = null;
//                node.pre.next = node.next;
//                node.next.pre = node.pre;
//                node.next = node.pre = null;
            }
            size--;
        }
    }

    //定义hashmap用于存储散列表
    Map<Integer, Node> map = new HashMap<>();
    DoubleList cache;
    int capacity;

    public LRUCacheTest(int capacity){
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        cache = new DoubleList();
    }

    public int get(int key){
        if(map.containsKey(key)){ //已经包含这个数据
            int val = map.get(key).val;
            put(key, val);
            return val;
        }else{
            return -1;
        }
    }


    public void put(int key, int val){
        Node node = new Node(key,val);
        if(map.containsKey(key)){
            cache.remove(map.get(key));
        }else{
            if (capacity == cache.size) {
                map.remove(cache.tail.key);
                cache.remove(cache.tail);
            }
        }
        cache.addFirst(node);
        map.put(key, node);
    }


    public Map<Integer,Node> list(){
        return this.map;
    }

    public static void main(String[] args) {
        LRUCacheTest cache = new LRUCacheTest(200);
        for(int i=1; i<=100; i++){
            cache.put(i, i);
        }


        Map<Integer, Node> maps = cache.list();
        maps.forEach((k, v) -> {
            System.out.println(k + "=>" + v.key + "=>" + v.val);
        });
    }

}
