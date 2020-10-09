package com.company.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class test1_1 extends JFrame {
    public test1_1() {
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
        this.setTitle("压缩工具v1.0");
        this.setLocationRelativeTo(null);

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
                compress(str1[0], str2[0]);
                jt1.requestFocus();//获取焦点，获取光标
            }
        });
        c.add(btn);

        setVisible(true);
    }

    static void compress(String str1, String str2) {//静态压缩方法

        File source = new File(str1);//源文件
        File targer = new File(str2);//压缩包压缩位置

        try (FileOutputStream fis = new FileOutputStream(targer);
             ZipOutputStream zos = new ZipOutputStream(fis)) {
            if (source.isDirectory()) {//如果是文件夹
                for (File f : source.listFiles()) {//遍历文件夹下的所有文件
                    addEntry(zos, "", f);
                }

            } else {//如果不是文件夹，就直接压缩
                addEntry(zos, "", source);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param zos    - 压缩流
     * @param base   - 文件在压缩包中的路径
     * @param source - 被压缩的文件
     */
    static void addEntry(ZipOutputStream zos, String base, File source) {
        if (source.isDirectory()) {//如果传入的条目是文件夹
            for (File file : source.listFiles()) {//取出文件夹中所有的文件
                //文件夹压缩时，原来的文件路径加上文件夹的名字（source.getName()）再加上当前系统默认的文件夹分隔符（File.separator）
                addEntry(zos, base + source.getName() + File.separator, file);//file 被压缩的文件
            }
        } else {//压缩文件
            byte buf[] = new byte[1024];
            try (FileInputStream fis = new FileInputStream(source)) {//读取源文件 source
                int count = -1;
                //在压缩包中添加新条目
                zos.putNextEntry(new ZipEntry(base + source.getName()));
                while ((count = fis.read(buf)) != -1) {//读取到的数据写入缓冲区
                    zos.write(buf, 0, count);//从缓冲区数据写到压缩包当中，从0字节，写到读出多少字节就写多少字节count
                    zos.flush();//刷新
                }
                zos.closeEntry();//关闭条目
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new test1_1();
    }
}
