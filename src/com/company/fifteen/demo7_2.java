package com.company.fifteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class demo7_2 extends JFrame {
    public demo7_2() {
        final String[] str1 = {null};
        final String[] str2 = {null};
        /*Scanner sc=new Scanner(System.in);
        System.out.println("请输入压缩文件路径：");
        str1=sc.nextLine();
        System.out.println("请输入压缩路径：");
        str2=sc.nextLine();
        System.out.println("压缩文件路径："+str1);
        System.out.println("压缩路径："+str2);

        compress(str1,str2);*/

        setBounds(100, 100, 280, 150);
        setDefaultCloseOperation(3);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        setTitle("解压工具v1.0");

        JTextField jt1 = new JTextField();
        jt1.setColumns(20);  //设置文本框长度，20个字符
        jt1.setFont(new Font("黑体", Font.PLAIN, 20));//设置字体样式

        JTextField jt2 = new JTextField();
        jt2.setColumns(20);  //设置文本框长度，20个字符
        jt2.setFont(new Font("黑体", Font.PLAIN, 20));//设置字体样式
        c.add(jt1);
        c.add(jt2);

        JButton btn = new JButton("确认");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str1[0] = jt1.getText();
                str2[0] = jt2.getText();
                decompression(str1[0], str2[0]);
                jt1.requestFocus();//获取焦点，获取光标
            }
        });
        c.add(btn);

        setVisible(true);
    }

    static void decompression(String str1, String str2) {
        File dir = new File(str1);  //解压压缩源文件路径
        File source = new File(str2);  //压缩包源文件
        byte buf[] = new byte[1024];//缓冲区

        ZipEntry entry = null;//压缩包条目

        try (FileInputStream fis = new FileInputStream(source);
             ZipInputStream zis = new ZipInputStream(fis)) {//文件输入流和压缩包输入流
            while (true) {
                entry = zis.getNextEntry();//获取压缩包文件一个条目
                if (entry == null) {//没有一个条目就停止循环
                    break;
                }
                if (entry.isDirectory()) {//如果是文件夹就跳过这个循环
                    continue;
                }
                File f = new File(dir, entry.getName());
                if (!f.getParentFile().exists()) {//如果解压的文件夹不存在
                    f.getParentFile().mkdirs();//则创建文件夹
                }
                int count = -1;
                FileOutputStream fos = new FileOutputStream(f);//创建输出流，把解压数据写入磁盘中
                while ((count = zis.read(buf)) != -1) {//zis.read()从压缩输入流读出的数据写入到缓存当中buf
                    //(count =zis.read(buf))不等于-1则说明读取的是有用数据
                    fos.write(buf, 0, count);//把读出的数据写出去，从0开始，有多少写多少
                    fos.flush();//刷新数据
                }
                fos.close();//关闭数据流
                zis.closeEntry();//关闭条目
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new demo7_2();
    }
}
