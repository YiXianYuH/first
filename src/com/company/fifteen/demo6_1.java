package com.company.fifteen;
/*
 *I/O:I为读，O为写
 * 两个数字不能挨着写
 */

import java.io.*;

public class demo6_1 {
    public static void main(String[] args) {
        File f=new File("word6.txt");
        FileOutputStream out=null;//创建文件输出流
        DataOutputStream dos=null;//创建数据输出流
        try {
            out=new FileOutputStream(f);
            dos=new DataOutputStream(out);//将文件流包装成数据流

            dos.writeUTF("这是写入字符串数据");//写入字符串数据
            dos.writeDouble(3.14);//写入浮点型数据
            dos.writeBoolean(true);//写入布尔类型数据
            dos.writeInt(123);//写入整形数据

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos!=null){//关闭数据流
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){//关闭文件流
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        DataInputStream di=null;//创建数据输入流
        FileInputStream in=null;//创建文件输入流
        try {
            in=new FileInputStream(f);
            di=new DataInputStream(in);
            System.out.println("readUTF()读取数据:"+di.readUTF());
            System.out.println("readDouble()读取数据:"+di.readDouble());
            System.out.println("readBoolean()读取数据:"+di.readBoolean());
            System.out.println("readInt()读取数据:"+di.readInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (di!=null){
                try {
                    di.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
