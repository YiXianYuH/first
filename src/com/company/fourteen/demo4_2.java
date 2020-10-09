package com.company.fourteen;
/*
 *存放数据：集合中不会保存相同的对象（地址和元素相同）
 *        同一个哈希地址可存放多个不同的对象（地址相同，元素不同）
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class demo4_2 {
    int id;
    String name;

    public demo4_2(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "demo4_2 [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof demo4_2)) return false;
        demo4_2 demo4_2 = (demo4_2) o;
        return id == demo4_2.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static void main(String[] args) {
        Set set=new HashSet();
        demo4_2 p1=new demo4_2(1,"小明");
        demo4_2 p2=new demo4_2(2,"大壮");
        demo4_2 p3=new demo4_2(3,"阿强");
        set.add(p1);
        set.add(p2);
        set.add(p3);
        //set.add(null);//HashSet允许null值

        /*
         *在此集合里，更改id，删除是无效的
         * 把人存在了这个id位置，更改id后，人不在原来的位置了，所以删除无效
         */
        p2.id=5;
        set.add(p2);
        set.remove(p2);//id=5的hashcode
        System.out.println("集合的长度："+set.size());

        Iterator it=set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
