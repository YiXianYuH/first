package com.company.test;

public class demo2 extends demo1 {
    void openUp(){
        System.out.println("调用了子类");
    }

    public static void main(String[] args) {
        demo2 d=new demo2();
        System.out.println(d.str1);
        d.startUp();
        d.openUp();
    }
}
