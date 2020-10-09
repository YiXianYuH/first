package com.company.fifteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class demo7_1 extends JFrame {
    String str1 = null;
    String str2 = null;

    public demo7_1() {
        setBounds(100, 100, 300, 200);
        setDefaultCloseOperation(3);
        setTitle("压缩工具v1.0");
        Container c = getContentPane();
        setLayout(new BorderLayout());

        JTextField jt1 = new JTextField();
        jt1.setColumns(20);  //设置文本框长度，20个字符
        jt1.setFont(new Font("黑体", Font.PLAIN, 20));//设置字体样式
        c.add(jt1);

        JTextField jt2 = new JTextField();
        jt2.setColumns(20);  //设置文本框长度，20个字符
        jt2.setFont(new Font("黑体", Font.PLAIN, 20));//设置字体样式
        c.add(jt2);

        JButton btn2 = new JButton("确认");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str2 = jt2.getText();
                System.out.println("文本框中的内容为：" + jt2.getText());//获取文本框中的文本框
                jt2.setText("");//清空文本框内容
                jt2.requestFocus();//获取焦点，获取光标
            }
        });

        setVisible(true);
    }

    static void compress() {//静态压缩方法
        File source = new File("E:\\test\\");//源文件
        File targer = new File("E:\\test.7z");//压缩包压缩位置

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
        new demo7_1();
        //compress();
    }

}
