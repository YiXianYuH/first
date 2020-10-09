package com.company.thirteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo7_1 extends JFrame {
    public demo7_1(){
        setBounds(100,100,190,120);
        setDefaultCloseOperation(3);

        Container c=getContentPane();
        c.setLayout(null);

//        JComboBox<String> comboBox=new JComboBox<>();
//        comboBox.addItem("身份证");
//        comboBox.addItem("学生证");
//        comboBox.addItem("工作证");

//        String item[]={"数组元素1","数组元素2","数组元素3"};
//        JComboBox<String> comboBox=new JComboBox<>(item);//使用String数组添加下拉列表元素

        JComboBox<String> comboBox=new JComboBox<>();
        String item[]={"身份证","学生证","军人证"};
        ComboBoxModel cm=new DefaultComboBoxModel<>(item);//创建下拉列表模型
        comboBox.setModel(cm);//向列表中添加数据模型

        JButton btn=new JButton("打印");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("选中的索引"+comboBox.getSelectedIndex());//获取选中的索引
                System.out.println("选中的值："+comboBox.getSelectedItem());//获取选中的值
            }
        });
        btn.setBounds(100,10,60,20);
        c.add(btn);

        comboBox.setEditable(true); //是否可以编辑

        comboBox.setBounds(10,10,80,21);
        c.add(comboBox);

        setVisible(true);
    }

    public static void main(String[] args) {
        new demo7_1();
    }
}
