package com.company.fourteen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class demo3_2 {
    public static void main(String[] args) {
        /*
         *List动态存储，删除前面的后面的会补上
         * ArrayList适合查找索引
         * LinkedList适合添加删除操作
         */
        List list1=new LinkedList();
        List list=new ArrayList();

        list.add("清明时节雨纷纷");
        list.add("路上行人欲断魂");
        list.add("借问酒家何处有");
        list.add("牧童遥指杏花村");

        list.remove(1);
        list.add(1,"插入一句");
        list.set(1,"这句话我改了");

        for (int i=0;i<list.size();i++){
            System.out.println("list的索引"+i+list.get(i));
        }
        System.out.println(list.get(3));
    }
}
