package com.company.test;

import javax.swing.*;
import java.awt.*;

public class demo13_5_2 extends JFrame {
    public demo13_5_2(){
        setBounds(100,100,500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container=getContentPane();//获取容器
        JTextArea area=new JTextArea();     //添加文本域组件
        JScrollPane jScrollPane=new JScrollPane(area);  //创建滚动面板，给文本域添加滚动条
        container.add(jScrollPane); //容器添加滚动面板
        setVisible(true);
    }

    public static void main(String[] args) {
        new demo13_5_2();
    }
}
