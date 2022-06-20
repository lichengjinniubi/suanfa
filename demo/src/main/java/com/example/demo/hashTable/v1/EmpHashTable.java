package com.example.demo.hashTable.v1;

public class EmpHashTable {

    private int size;

    private EmpList[] empLists;


    public EmpHashTable(int size){
        this.size = size;
        this.empLists = new EmpList[size];
        for(int i = 0; i < size; ++i) {
            this.empLists[i] = new EmpList();
        }
    }


    public boolean add(Node node){
        int num = getIndex(node.id);
        this.empLists[num].add(node);
        return true;
    }


    public int getIndex(int num){
        return num % size;
    }
}
