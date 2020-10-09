package com.company.fourteen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class demo2 {
    public static void main(String[] args) {
        Collection c=new ArrayList();//Collection接口
        System.out.println("集合是不是空的："+c.isEmpty()+"集合的长度："+c.size());

        c.add("你好");
        c.add(3.14);
        c.add(new Object());

        System.out.println("集合是不是空的："+c.isEmpty()+"集合的长度："+c.size());

        c.remove(3.14);
        System.out.println("集合是不是空的："+c.isEmpty()+"集合的长度："+c.size());

        /*
         * iterator()返回Collection的元素上进行迭代的迭代器。用于遍历集合中的对象
         */
        Iterator it=c.iterator();
        while (it.hasNext()){   //hasNext()  判断是否有下一个元素
            Object o=it.next();
            System.out.println(o);
        }
    }
}
