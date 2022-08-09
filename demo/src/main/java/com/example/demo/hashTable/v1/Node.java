package com.example.demo.hashTable.v1;

public class Node {

    public int id;
    public String name;
    public Node next;
    public Node prev;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Node() {
    }
}
