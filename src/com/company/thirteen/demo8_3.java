package com.company.thirteen;

import javax.swing.*;
import java.awt.*;

public class demo8_3 extends JFrame {
    public demo8_3(){
        setBounds(100,100,400,400);
        setDefaultCloseOperation(3);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        JTextArea area=new JTextArea();
        area.setText("这是文本域");    //设置文本内容
        area.setRows(5);//设定行
        area.setColumns(20);//设定列数
        area.append("添加内容");//添加内容
        area.insert("插入",2);//在第二个字符后面插入内容
        area.setFont(new Font("楷体",Font.PLAIN,20));
        JScrollPane js=new JScrollPane(area);

        c.add(js);

        setVisible(true);
    }

    public static void main(String[] args) {
        new demo8_3();
    }
}
