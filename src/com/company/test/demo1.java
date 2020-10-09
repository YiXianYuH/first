package com.company.test;

import java.math.BigInteger;

public class demo1 {
    String str1="这是一个父类";
    void startUp(){
        System.out.println("调用了父类");
    }
    public static void main(String[] args) {
        String a="5";
        BigInteger bigInteger=new BigInteger("12");
        System.out.println(bigInteger.remainder(new BigInteger(a)));
    }
}
