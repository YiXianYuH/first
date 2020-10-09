package com.company.fifteen;

import java.io.*;

public class demo5_1_1 {
    public static void main(String[] args) {
        File f=new File("word.txt");
        FileOutputStream out=null;
        BufferedOutputStream bo=null;//缓冲输出流

        try {
            out=new FileOutputStream(f);
            bo=new BufferedOutputStream(out);//包装文件输出流
            String str="天生我材必有用，千金散尽还复来";
            byte b[]=str.getBytes();
            bo.write(b);
            //使用缓冲字节输出流时，要多刷新操作；不需要等乘客坐满再走
            bo.flush();//刷新,强制将缓冲区数据写入文件中，即使缓冲区没有写满

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(bo!=null){
            try {
                bo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
