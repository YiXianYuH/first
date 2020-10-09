package com.company.fourteen;

import java.util.*;

public class demo5_2 {
    public static void main(String[] args) {
        Map map=new HashMap();

        map.put("String","这是一个字符串");
        map.put("Object",new Object());
        map.put("int","1234");
        map.put("数字","1234");
        map.put(1,"1");     //换成TreeMap 报错
        map.put(new Object(),new Object()); //换成TreeMap 报错
        map.put(null,null); //换成TreeMap 报错

        System.out.println("map中的元素个数："+map.size());

        Set set=map.keySet();
        Iterator it=set.iterator();
        while (it.hasNext()){
            Object obj=it.next();
            //System.out.println(it.next());
            System.out.println("key="+obj+"  value:"+map.get(obj));
        }
        System.out.println(map.get("String"));
    }
}
