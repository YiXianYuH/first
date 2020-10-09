package com.company.thirteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo6_3 extends JFrame {
    public demo6_3(){
        setBounds(100,100,190,120);
        setDefaultCloseOperation(3);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox c1=new JCheckBox("1");
        JCheckBox c2=new JCheckBox("2");
        JCheckBox c3=new JCheckBox("3");
        c.add(c1);
        c.add(c2);
        c.add(c3);

        c1.setSelected(true);

        JButton btn=new JButton("打印");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(c1.getText()+"复选框选中状态"+c1.isSelected());//获取复选框状
                System.out.println(c2.getText()+"复选框选中状态"+c2.isSelected());
                System.out.println(c3.getText()+"复选框选中状态"+c3.isSelected());
            }
        });
        c.add(btn); //把按钮组件添加到容器中
        setVisible(true);
    }

    public static void main(String[] args) {
        new demo6_3();
    }
}
