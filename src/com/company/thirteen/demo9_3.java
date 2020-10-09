package com.company.thirteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class demo9_3 extends JFrame {
    public demo9_3(){
        setDefaultCloseOperation(3);
        setBounds(100,100,230,150);
        JPanel contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField jt1=new JTextField(10);
        jt1.setBounds(10,10,66,21);
        contentPane.add(jt1);

        JTextField jt2=new JTextField(10);
        jt2.setBounds(10,41,66,21);
        contentPane.add(jt2);

        JTextField jt3=new JTextField(10);
        jt3.setBounds(10,72,66,21);
        contentPane.add(jt3);

        JLabel jl1=new JLabel("未获取焦点");
        jl1.setBounds(86,13,100,15);
        contentPane.add(jl1);

        JLabel jl2=new JLabel("未获取焦点");
        jl2.setBounds(86,44,100,15);
        contentPane.add(jl2);

        JLabel jl3=new JLabel("未获取焦点");
        jl3.setBounds(86,75,100,15);
        contentPane.add(jl3);

        /*jt1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jl1.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                jl1.setText("失去焦点");
                jl1.setForeground(Color.RED);
            }
        });

        jt2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jl2.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                jl2.setText("失去焦点");
                jl2.setForeground(Color.RED);
            }
        });

        jt3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jl3.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                jl3.setText("失去焦点");
                jl3.setForeground(Color.RED);
            }
        });*/
        jt1.addFocusListener(new MyFocusListener());//使用自定义鉴定实现类
        jt2.addFocusListener(new MyFocusListener());
        jt3.addFocusListener(new MyFocusListener());


        setVisible(true);
    }

    //内部类  implements接口
    class MyFocusListener implements FocusListener{//自定义的焦点事件监听实现类
        @Override
        public void focusGained(FocusEvent e) {
            JTextField tmp=(JTextField) e.getSource();//获取触发事件的组件
            tmp.setBorder(BorderFactory.createLineBorder(Color.green));//给获取焦点的文本框设置绿色边框
        }

        @Override
        public void focusLost(FocusEvent e) {
            JTextField tmp=(JTextField) e.getSource();//获取触发事件的组件
            tmp.setBorder(BorderFactory.createLineBorder(Color.RED));//给失去焦点的文本框设置红色边框
        }
    }

    public static void main(String[] args) {
        new demo9_3();
    }
}
