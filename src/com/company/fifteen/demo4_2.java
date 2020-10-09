package com.company.fifteen;
/*
 *字符流
 * FileWriter 字符输入流
 * FileReader  字符输出流
 */

import java.io.*;

public class demo4_2 {
    public static void main(String[] args) {
       File f=new File("words.txt");

        /*FileWriter fw=null;
        try {
            fw=new FileWriter(f,true);//当为true时，在源文件后添加新内容,为false或默认时则覆盖原内容
            String str="自强不息，厚德载物。";
            fw.write(str);//将字符串写入到文本文档
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        FileReader fr=null;
        try {
            fr=new FileReader(f);
            char ch[]=new char[1024];//缓冲区
            int count;//已经读出的字符数
            while (true){
                try {
                    if (!((count=fr.read(ch))!=-1)) break;//循环读取文件中的数据，直到所有字符都读完
                    System.out.println("文件中的内容为："+new String(ch));
                    System.out.println(fr.read(ch));//read()如果读取数据流末尾没有数据，则返回值为-1
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
