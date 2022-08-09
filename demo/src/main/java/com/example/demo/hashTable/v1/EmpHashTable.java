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
        System.out.println(num);
        this.empLists[num].add(node);
        return true;
    }


    public void findById(int id){
        int index = getIndex(id);
        Node node = this.empLists[index].find(id);
        if(node == null){
            System.out.println("没有这个数据");
        }else{
            System.out.println(node.id+"---"+node.name);
        }
    }

    public void list() {
        for(int i = 0; i < this.size; ++i) {
            this.empLists[i].list(i);
        }

    }


    public int getIndex(int num){
        return num % size;
    }
}
