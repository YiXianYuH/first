package com.company.fifteen;
/*
 *字节流
 *FileOutputStream 输出流，写入内容
 * FileInputStream 输入流，读出内容
 */

import java.io.*;

public class demo4_1 {
    public static void main(String[] args) {
        File f=new File("word.txt");
        FileOutputStream out=null;
        try {
            out =new FileOutputStream(f,false);//false/true 文件输出流，替换文件内容/在文件末尾追加内容

            String str="你见过洛杉矶，凌晨四点的样子吗？";
            byte b[]=str.getBytes();//将字符串转换为字节数组
            try {
                out.write(b);//将字节数组写入文件当中
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileInputStream in=null;

        try {
            in=new FileInputStream(f);//输入流读取文件
            byte b2[]=new byte[1025];//缓冲区
            try {
                int len= in.read(b2);//读入缓冲区的总字节数
                System.out.println("文件中的数据是："+new String(b2,0,len));//去掉空格  ps：似乎不需要去空格了
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
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
