package com.company.test;
/*多态和继承
 *方法重载
 */
class Animal{
    void eat(){
        System.out.println("进食");
    }
    void sleep(){
        System.out.println("睡觉");
    }
    void breed(){
        System.out.println("繁殖");
    }
}
class bird extends Animal{
    void eat(){
        System.out.println("吃鱼");
    }
    void Colour(String colour){
        String c=colour;
        System.out.println("这是一只"+c+"的鸟");
    }
    void fly(){
        System.out.println("飞翔");
    }
    void run(){
        System.out.println("跑");
    }
}
class run extends Animal{
    void eat(){
        System.out.println("吃虫子");
    }
    void Colour(String colour){
        String c=colour;
        System.out.println("这是一只"+c+"的鸟");
    }
    void fly(){
        System.out.println("飞翔");
    }
    void run(){
        System.out.println("跑");
    }
}

public class demo3 {


    public static void main(String[] args) {
        Animal jack=new bird();
        ((bird) jack).Colour("白色");
        ((bird) jack).fly();
        ((bird)jack).eat();
        jack.sleep();
        jack.breed();

        jack=new run();
        ((run) jack).Colour("黑色");
        ((run) jack).fly();
        ((run)jack).eat();
        jack.sleep();
        jack.breed();
    }
}
