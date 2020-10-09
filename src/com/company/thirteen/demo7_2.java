package com.company.thirteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo7_2 extends JFrame {
    public demo7_2(){
        setBounds(100,100,217,167);
        setDefaultCloseOperation(3);

        Container c=getContentPane();
        c.setLayout(null);

        String items[] ={"元素1","元素2","元素3","元素4","元素5","元素6","元素7","元素8"};
//        JList<String> j1=new JList<>(items);    //设置列表框

        DefaultListModel<String> model=new DefaultListModel<>();    //列表框数据模型
        for (String tmp:items){
            model.addElement(tmp);  //向数据模型添加元素
        }

        JList<String> j1=new JList<>();
        model.addElement("添加元素");//数据模型添加新元素
        j1.setModel(model);//列表框载入数据模型

        /*
         * SINGLE_SELECTION 单选
         *SINGLE_INTERVAL_SELECTION 只能连续选择相邻的元素
         * MULTIPLE_INTERVAL_SELECTION 随便选
         */
        j1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane js=new JScrollPane(j1);     //为列表框添加滚动条
        js.setBounds(10,10,100,100);
        c.add(js);

        JButton btn=new JButton("确认");
        btn.setBounds(120,90,70,25);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取列表框中选中的所有元素
                java.util.List<String> values=j1.getSelectedValuesList();
                for (String tmp:values){
                    System.out.println(tmp);
                }
                System.out.println("-----end------");
            }
        });
        c.add(btn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new demo7_2();
    }
}
