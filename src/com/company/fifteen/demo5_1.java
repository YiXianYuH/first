package com.company.fifteen;

import java.io.*;

public class demo5_1 {
    public static void main(String[] args) {
        File f=new File("E:\\game\\武神空间.txt");
        BufferedInputStream bi=null;//大大提高了运行效率
        FileInputStream in=null;
        long start=System.currentTimeMillis();//获取流开始时毫秒值
        try {
            in=new FileInputStream(f);
            bi=new BufferedInputStream(in);//将文件字节流包装成缓冲字节流
            byte b[]=new byte[1024];//缓冲区字节数组(这个缓冲区与Buffered不同)
            while (bi.read(b)!=-1){//使用缓冲流读取数据

            }
            long end=System.currentTimeMillis();//获取流结束时毫秒值
            System.out.println("运行经历的毫秒数："+(end-start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
        if (bi!=null){
            try {
                bi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
