package com.company.thirteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo8_2 extends JFrame {
    public demo8_2(){
        setBounds(100,100,400,100);
        setDefaultCloseOperation(3);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        JPasswordField jp=new JPasswordField();
        jp.setColumns(20);//设置文本长度
        jp.setFont(new Font("Arial",Font.BOLD,18));//设置字体样式
        jp.setEchoChar('*'); //设置回显字符
        jp.addActionListener(new ActionListener() {//添加动作监听，回车
            @Override
            public void actionPerformed(ActionEvent e) {
                char ch[]= jp.getPassword();//获取密码的字符数组
                String str=new String(ch);//把字符数组传入字符串
                System.out.println(str);
            }
        });
        c.add(jp);

        setVisible(true);
    }

    public static void main(String[] args) {
        new demo8_2();
    }
}
