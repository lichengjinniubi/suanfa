package com.example.demo.hashTable.lru;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class LRUCache<TKey, TValue> {

    /**
     * 缓存node结构 (双向链接)
     *
     * @param <TKey>   缓存node的key类型
     * @param <TValue> 缓存node的value类型
     */
    private class Node<TKey, TValue> {
        /**
         * 双向链接node的前一个结点
         */
        private Node<TKey, TValue> prev;

        /**
         * 双向链接node的后一个结点
         */
        private Node<TKey, TValue> next;

        /**
         * 缓存的key
         */
        private TKey key;

        /**
         * 缓存的value
         */
        private TValue value;

        public Node() {
        }

        public Node(TKey key, TValue value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * 增加Map来存储具体缓存项,来实现O(1)访问
     */
    private final Map<TKey, Node<TKey, TValue>> cache = new HashMap<>();

    /**
     * 缓存最大数量
     */
    private final int capacity;
    /**
     * 当前缓存数量
     */
    private int size;

    /**
     * 双向链接的header
     */
    private final Node<TKey, TValue> header;

    /**
     * 双向链接的tail
     */
    private final Node<TKey, TValue> tail;

    /**
     * 获取缓存
     *
     * @param key 缓存key
     * @return 缓存value
     */
    public TValue get(final TKey key) {
        Node<TKey, TValue> node = cache.get(key);
        if (node == null) {
            return null;
        }
        // 移到header
        synchronized (cache) {
            move2Header(node);
        }

        return node.value;
    }

    /**
     * 添加数据
     *
     * @param key   缓存key
     * @param value 缓存value
     */
    public void put(final TKey key, final TValue value) {
        Node<TKey, TValue> node = cache.get(key);
        if (node == null) {
            synchronized (cache) {
                if (size >= capacity) {
                    //删除尾部
                    Node<TKey, TValue> expireNode = removeTail();
                    cache.remove(expireNode.key);
                    this.size--;
                }

                node = insertHeader(key, value);
                cache.put(key, node);
                this.size++;
            }
        } else {
            node.value = value;
            synchronized (cache) {
                move2Header(node);
            }
        }
    }

    /**
     * 移除缓存
     *
     * @param key 缓存key
     */
    public void remove(final TKey key) {
        Node<TKey, TValue> node = cache.get(key);
        if (node == null) {
            return;
        }
        synchronized (cache) {
            remove(node);
            this.cache.remove(key);
            this.size--;
        }
    }

    /**
     * 添加缓存key/value到链表的header
     *
     * @param key   缓存key
     * @param value 缓存value
     */
    private Node<TKey, TValue> insertHeader(final TKey key, final TValue value) {
        Node<TKey, TValue> node = new Node<>(key, value);

        return insertHeader(node);
    }

    /**
     * 添加缓存node到链表的header
     *
     * @param node 缓存node
     * @return 缓存node
     */
    private Node<TKey, TValue> insertHeader(final Node<TKey, TValue> node) {
        node.prev = this.header;
        node.next = this.header.next;
        this.header.next.prev = node;
        this.header.next = node;
        return node;
    }

    /**
     * 移动缓存node到header
     *
     * @param node 缓存node
     */
    private void move2Header(final Node<TKey, TValue> node) {
        remove(node);
        insertHeader(node);
    }

    /**
     * 删除链表尾部
     */
    private Node<TKey, TValue> removeTail() {
        Node<TKey, TValue> node = this.tail.prev;
        remove(node);
        return node;
    }

    /**
     * 删除链表的node
     */
    private void remove(final Node<TKey, TValue> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 添加缓存node到链表的tail
     *
     * @param key   缓存node的key
     * @param value 缓存node的value
     * @return 缓存node
     */
    private Node<TKey, TValue> putTail(final TKey key, final TValue value) {
        Node<TKey, TValue> node = new Node<>(key, value);
        return putTail(node);
    }

    /**
     * 添加缓存node到链表的tail
     *
     * @param node 缓存node
     * @return 缓存node
     */
    private Node<TKey, TValue> putTail(final Node<TKey, TValue> node) {
        node.prev = this.tail.prev;
        node.next = this.tail;
        this.tail.prev.next = node;
        this.tail.prev = node;
        return node;
    }

    /**
     * .ctor
     *
     * @param capacity 最大缓存数量
     */
    public LRUCache(final int capacity) {
        this.capacity = capacity;
        this.header = new Node<>();
        this.tail = new Node<>();
        this.header.next = this.tail;
        this.header.prev = null;
        this.tail.prev = this.header;
        this.tail.next = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        Node<TKey, TValue> node = this.header.next;
        StringBuilder sb = new StringBuilder();
        sb.append("(size:");
        sb.append(size);
        sb.append(")");
        while (node != this.tail) {
            sb.append(node.key);
            sb.append(":");
            sb.append(node.value);
            sb.append(",");
            node = node.next;
        }
        // sb.append(cache.toString());
        return sb.toString();
    }

    public void showCache(){
        cache.forEach((k, v)->{
            System.out.println(k);
            System.out.println(v);
            System.out.println(v.next);
        });
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(4);
        cache.put("key1", "value1");
        System.out.println(cache);
        cache.put("key2", "value2");
        System.out.println(cache);
        cache.put("key1", "value3");
        System.out.println(cache);
        //cache.showCache();
        cache.put("key4", "value4");
        System.out.println(cache);
        cache.put("key4", "value44");
        System.out.println(cache);
        cache.put("key5", "value5");
        cache.get("key2");
        System.out.println(cache);
//        System.out.println(cache);
    }
}
