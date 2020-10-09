package com.company.test;
/*
 *使用throw关键字抛出异常
 */

public class demo12_5_2 {
    public static void main(String[] args) {
        int count=-100;
        try {
            if (count<0){
                throw new ArithmeticException("人员数量是负数："+count);
            }
            System.out.println("当前统计的人数为："+count);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("捕捉到了异常");
        }
        /*
         *发生异常之前，拦截异常
         *将算术异常变成了空指针异常
         */
        try {
           int a=1,b=0;
           if(b==0){
               throw new NullPointerException("b等于0，发生异常！");
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
