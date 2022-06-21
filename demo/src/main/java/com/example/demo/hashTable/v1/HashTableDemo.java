package com.example.demo.hashTable.v1;

import java.util.Scanner;

public class HashTableDemo {

    public static void main(String[] args) {
        EmpHashTable hashTab = new EmpHashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while(true) {
            while(true) {
                System.out.println("add:  添加雇员");
                System.out.println("list: 显示雇员");
                System.out.println("find: 查找雇员");
                System.out.println("exit: 退出系统");
                key = scanner.next();
                int id;
                switch(key.hashCode()) {
                    case 96417:
                        if (key.equals("add")) {
                            System.out.println("输入id");
                            id = scanner.nextInt();
                            System.out.println("输入名字");
                            String name = scanner.next();
                            Node emp = new Node(id, name);
                            hashTab.add(emp);
                        }
                        break;
                    case 3127582:
                        if (key.equals("exit")) {
                            scanner.close();
                            System.exit(0);
                        }
                        break;
                    case 3143097:
                        if (key.equals("find")) {
                            System.out.println("请输入要查找的id");
                            id = scanner.nextInt();
                            hashTab.findById(id);
                        }
                        break;
                    case 3322014:
                        if (key.equals("list")) {
                            hashTab.list();
                        }
                }
            }
        }
    }
}
