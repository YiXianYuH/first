package com.company.thirteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo9_2 extends JFrame {
    public demo9_2(){
        setBounds(100,100,450,100);
        setDefaultCloseOperation(3);

        Container c=getContentPane();

        JPanel centerP=new JPanel();
        centerP.setLayout(new FlowLayout());
        c.add(centerP,BorderLayout.CENTER);

        JPanel southP=new JPanel();
        JLabel console=new JLabel("点击组件");
        southP.add(console);
        c.add(southP,BorderLayout.SOUTH);

        JButton btn=new JButton("按钮");
        centerP.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                console.setText("按钮被点击");
            }
        });

        JTextField jt=new JTextField(10);
        centerP.add(jt);
        jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj=e.getSource();
                JTextField jtTmp=(JTextField)obj;
                System.out.println(jtTmp.getText());
                console.setText("文本框中点击了回车");
            }
        });

        JCheckBox jc=new JCheckBox("多选框");
        centerP.add(jc);
        jc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                console.setText("多选框被点击");
            }
        });

        JRadioButton jr=new JRadioButton("单选框");
        centerP.add(jr);
        jr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                console.setText("单选框被点击");
            }
        });

        String values[]={"选项1","选项2","选项3"};
        JComboBox jb=new JComboBox(values);
        centerP.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                console.setText("下拉列表被选择");
            }
        });

        c.validate(); //重新验证一下容器中的组件

        setVisible(true);
    }

    public static void main(String[] args) {
        new demo9_2();
    }
}
