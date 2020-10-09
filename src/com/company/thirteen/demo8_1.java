package com.company.thirteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo8_1 extends JFrame {
    public demo8_1() {
        setBounds(100, 100, 250, 150);
        setDefaultCloseOperation(3);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JTextField jt = new JTextField();
        jt.setColumns(20);  //设置文本框长度，20个字符
        jt.setText("aa");
        jt.setFont(new Font("黑体", Font.PLAIN, 20));//设置字体样式
        c.add(jt);

        JButton btn = new JButton("确认");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("文本框中的内容为：" + jt.getText());//获取文本框中的文本框
                jt.setText("");//清空文本框内容
                jt.requestFocus();//获取焦点，获取光标
            }
        });
        c.add(btn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new demo8_1();
    }
}
