package com.company.fifteen;
/*
 *BufferedReader 缓冲输入流以行为单位读取内容
 */

import java.io.*;

public class demo5_2_1 {
    public static void main(String[] args) {
        File f=new File("word.txt");
        FileReader fr=null;
        BufferedReader br=null;

        try {
            fr=new FileReader(f);
            br=new BufferedReader(fr);//将文件字符输入流包装成缓冲字符输入流
            String tmp=null;
            int i=1;
            while ((tmp=br.readLine())!=null){//循环读取文件中的内容
                System.out.println("第"+i+"行："+tmp);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
