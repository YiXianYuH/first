package com.company.thirteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo6_2 extends JFrame {
    public demo6_2(){
        setBounds(100,100,180,100);
        setDefaultCloseOperation(3);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        JRadioButton left=new JRadioButton("向左走");
        JRadioButton right=new JRadioButton("向右走");
        c.add(left);
        c.add(right);
        ButtonGroup group=new ButtonGroup();
        group.add(left);     //把单选按钮放到按钮组中
        group.add(right);

        left.setSelected(true); //默认选中

        JButton btn=new JButton("打印");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(left.getText()+"按钮选中状态"+left.isSelected());
                System.out.println(right.getText()+"按钮选中状态"+right.isSelected());
                group.clearSelection();//清空按钮选项
            }
        });
        c.add(btn);
        setVisible(true);
    }

    public static void main(String[] args) {
        new demo6_2();
    }
}
