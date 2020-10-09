package com.company.thirteen;
/*
 *swing窗体
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo6_1 extends JFrame {
    public demo6_1(){
        setBounds(100,100,500,300);
        setDefaultCloseOperation(3);
        Container container=getContentPane();
        container.setLayout(new GridLayout(3,2,5,5));
        JButton btn[]=new JButton[6];
        for (int i=0;i<btn.length;i++){
            btn[i]=new JButton();
            container.add(btn[i]);
        }
        btn[0].setText("不可用");
        btn[0].setEnabled(false);

        btn[1].setText("有颜色");
        btn[1].setBackground(Color.YELLOW);

        btn[2].setText("无边框");
        btn[2].setBorderPainted(false); //不显示边框

        btn[3].setText("有边框");
        btn[3].setBorder(BorderFactory.createLineBorder(Color.RED)); //设置线边框和边框颜色

        Icon icon=new ImageIcon("image\\0.png");//获取按钮
        btn[4].setIcon(icon);//给按钮设置图片
        btn[4].setToolTipText("图片按钮"); //鼠标悬停提示

        btn[5].setText("可点击");
        btn[5].addActionListener(new ActionListener() {//添加事件监听
            @Override
            public void actionPerformed(ActionEvent e) {//监听触发的方法
                JOptionPane.showMessageDialog(demo6_1.this,"点击按钮");//弹出小对话框
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new demo6_1();
    }
}
