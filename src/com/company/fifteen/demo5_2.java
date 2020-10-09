package com.company.fifteen;
/*
 *缓冲字符流 ：可以以行为单位进行输入/输出
 *BufferedWriter 缓冲输出流以行写入内容
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class demo5_2 {
    public static void main(String[] args) {
        File f=new File("word.txt");
        FileWriter fw=null;
        BufferedWriter bw=null;

        try {
            fw=new FileWriter(f);
            bw=new BufferedWriter(fw);//将文件字符输出流包装成缓冲字符流

            String str1="世界那么大";
            String str2="我想去看看";
            bw.write(str1);//第一行数据
            bw.newLine();//创建一个新行
            bw.write(str2);//第二行数据

        } catch (IOException e) {
            e.printStackTrace();
        }finally {//要注意流的关闭顺序，先创建的后关闭
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
