package com.company.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo13_2_2 extends JDialog {
    public demo13_2_2(JFrame frame ){
        super(frame,"对话框标题",true);  //设置弹出对话权限
        Container c=getContentPane();   //获取窗体容器
        c.add(new JLabel("这是一个对话框"));
        setBounds(100,100,100,100);
    }

    public static void main(String[] args) {
        JFrame f=new JFrame("父窗体");
        f.setBounds(50,50,300,300);
        Container c=f.getContentPane();
        JButton btn=new JButton("弹出对话框");
        c.setLayout(new FlowLayout());  //设置布局，使用流布局
        c.add(btn);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
        btn.addActionListener(new ActionListener() {    //设置按钮点击事件
            @Override
            public void actionPerformed(ActionEvent e) {
                demo13_2_2 d=new demo13_2_2(f);
                d.setVisible(true);
            }
        });
    }
}
