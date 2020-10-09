package com.company.fourteen;
/*
 *TreeSet:树状集合，存放有序；注意要想指定集合存放顺序，被排序的对象需实现Comparable接口
 *HashSet：散列集合，高效快速；注意HashSet存储的对象，应该重写hashCode()和equals()两个方法
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class demo4_1 implements Comparable{
    int id;
    int age;
    String name;

    public demo4_1(int id, int age, String name) {
        super();
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "demo4 [" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ']';
    }

    /*
     *id 按ID排序
     */
    @Override
    public int compareTo(Object o) {//返回三个值 0，正数，负数
        demo4_1 p;
        if (o instanceof demo4_1){
            p=(demo4_1)o;
        }else {
            return -1;//-1代表传入的参数比我本身要小
        }
        int diff=this.id-p.id;
        if (diff!=0){
            diff=diff/Math.abs(diff);//差值除以本身绝对值，可以得到+1或-1的值
        }
        return diff;
    }

    public static void main(String[] args) {
        Set set=new TreeSet();
        demo4_1 p1=new demo4_1(1,18,"小明");
        demo4_1 p2=new demo4_1(2,5,"大壮");
        demo4_1 p3=new demo4_1(3,20,"阿强");

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p3);    //重复的元素不会被添加到集合中 ***只有id重复才会出现这种情况
        //set.add(null);使用TreeSet不能添加null值 调用compareTo方法会抛出空指针异常
        System.out.println(set.size());
        Iterator it=set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
