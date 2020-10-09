package com.company.fifteen;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo3_1 {
    public static void main(String[] args) {
        /*
         *项目下的路径(默认路径)：word.txt
         * 包中的文件路径：src/com.company/fifteen/word.txt
         * 注意：  /  表示文件夹
         *        \\ 表示文件夹(转义字符)
         * 绝对路径：F:\\test\\word.txt
         */
        File f1=new File("F:\\test\\word.txt");//第一种构造方法

       /* File f2=new File("F:\\test","word.txt");//第二种构造方法  文件夹和文件

        File dir=new File("F:\\test");//文件夹
        File f3=new File(dir,"word.txt");//第三种构造方法

        System.out.println(f1.getAbsolutePath());//输出文件的绝对路径
        System.out.println(f2.getAbsolutePath());//输出文件的绝对路径
        System.out.println(f3.getAbsolutePath());//输出文件的绝对路径

        System.out.println(f1==f2);//独立的对象（false）
        System.out.println(f1.equals(f2));//但指向同一个文件（true）*/

        System.out.println("文件是否存在："+f1.exists());//文件是否存在

        System.out.println("文件名："+f1.getName());//输出文件名
        System.out.println("文件的绝对路径："+f1.getAbsolutePath());//输出文件的绝对路径
        System.out.println("是否是隐藏文件："+f1.isHidden());//是否是隐藏文件
        System.out.println("文件的字节数："+f1.length());//输出文件大小，单位：字节
        Date date=new Date(f1.lastModified());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("文件最后的修改时间："+sdf.format(date));//文件最后的修改时间

        boolean del=f1.delete();//删除文件
        System.out.println("删除文件是否成功："+del);

        try {
            //已存在的文件，不能重新创建，且不能覆盖已有文件
            boolean create= f1.createNewFile();//创建新空文件
            System.out.println("创建文件是否成功："+create);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
