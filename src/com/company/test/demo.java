package com.company.test;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        double num1,num2;
        System.out.println("请输入两个数");
        Scanner sc1=new Scanner(System.in);
        num1=sc1.nextInt();
        Scanner sc2=new Scanner(System.in);
        num2=sc2.nextInt();
        int s=(int)num1+(int)(Math.random()*(num2-num1));
        System.out.println((int)(Math.random()*(num2-num1)));
        if(s%2==0){
           System.out.println("随机数为偶数："+s);
        }else {
            System.out.println("随机数为奇数："+s);
        }
    }
}


