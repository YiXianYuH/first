package com.company.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MyJFrame extends JFrame implements KeyListener, ActionListener {

    int[][] datas = new int[4][4];
    int[][] victory = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    int x0 = 0, y0 = 0;  //定义两个变量，用来记录空白位置 0
    int step = 0;
    JMenuItem jMenuItem1;
    JMenuItem jMenuItem2;

    public MyJFrame() {
        //初始化界面
        initFrame();

        //初始化菜单
        initJMenu();

        //初始化数据
        initData();

        //初始化图片
        initImage();

        //让窗体显示出来
        this.setVisible(true);
    }

    public void initData() {
        int[] temp = {2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};

        //随机一维数组
        for (int i = 0; i < temp.length; i++) {
            Random r = new Random();
            int index = r.nextInt(temp.length);
            int number = temp[i];
            temp[i] = temp[index];
            temp[index] = number;
        }
        //把一维数组的值赋值给二维数组
        for (int i = 0; i < temp.length; i++) {
            datas[i / 4][i % 4] = temp[i];
            if (temp[i] == 0) {
                x0 = i / 4;
                y0 = i % 4;
            }
        }
    }

    public void initFrame() {

        //设置窗体宽高
        this.setSize(514, 595);

        //设置窗体标题
        this.setTitle("石头迷阵单机版 v1.0");

        //设置窗体的关闭方式
        this.setDefaultCloseOperation(3);

        //设置窗体在屏幕中央
        this.setLocationRelativeTo(null);

        //设置窗体可以覆盖其他软件
        this.setAutoRequestFocus(true);

        //设置键盘监听
        this.addKeyListener(this);

        //取消内部居中放置
        this.setLayout(null);
    }

    public void initJMenu() {
        //创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //设置菜单宽高
        jMenuBar.setSize(514, 20);

        //创建菜单选项
        JMenu jMenu1 = new JMenu("功能");
        JMenu jMenu2 = new JMenu("关于");

        //创建菜单条目
        jMenuItem1 = new JMenuItem("重新游戏");
        jMenuItem2 = new JMenuItem("联系我们");
        jMenuItem1.addActionListener(this);
        jMenuItem2.addActionListener(this);
        //把条目添加到菜单选项里
        jMenu1.add(jMenuItem1);
        jMenu2.add(jMenuItem2);

        //把菜单添加到选项中
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);

        //把菜单添加到最外层的窗体当中
        this.setJMenuBar(jMenuBar);
    }

    public void initImage() {

        //将界面原来所有的图片全部删除
        this.getContentPane().removeAll();

        JLabel jLabel_step = new JLabel("步数：" + step);
        jLabel_step.setBounds(50, 20, 100, 20);
        this.add(jLabel_step);

        //判断游戏是否胜利
        if (victory()) {
            ImageIcon imageIcon = new ImageIcon("image\\win.png");
            JLabel jLabel = new JLabel(imageIcon);
            jLabel.setBounds(514 / 2 - 266 / 2, 230, 266, 88);
            this.add(jLabel);
        }

        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                int data = datas[i][j];
                if (data != 0) {
                    ImageIcon imageIcon = new ImageIcon("image\\" + data + ".png");
                    JLabel jLabel = new JLabel(imageIcon);
                    jLabel.setBounds(j * 100 + 50, i * 100 + 90, 100, 100);
                    this.add(jLabel);
                }
            }
        }

        //设置背景
        ImageIcon background = new ImageIcon("image\\background.png");
        JLabel backgroundJLabel = new JLabel(background);
        backgroundJLabel.setBounds(26, 30, 450, 484);
        this.add(backgroundJLabel);

        //将整个界面重新绘制
        this.getContentPane().repaint();
    }

    public boolean victory() {
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                if (datas[i][j] != victory[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下
    @Override
    public void keyPressed(KeyEvent e) {

    }

    //松开
    @Override
    public void keyReleased(KeyEvent e) {
        //获取按键的数字
        int keyCode = e.getKeyCode();
        move(keyCode);
        initImage();
    }

    private void move(int keyCode) {
        //左
        if (keyCode == 37) {
            if (y0 == 3) {
                return;
            }
            datas[x0][y0] = datas[x0][y0 + 1];
            datas[x0][y0 + 1] = 0;
            y0++;
            step++;
            //上
        } else if (keyCode == 38) {
            if (x0 == 3) {
                return;
            }
            datas[x0][y0] = datas[x0 + 1][y0];
            datas[x0 + 1][y0] = 0;
            x0++;
            step++;
            //右
        } else if (keyCode == 39) {
            if (y0 == 0) {
                return;
            }
            datas[x0][y0] = datas[x0][y0 - 1];
            datas[x0][y0 - 1] = 0;
            y0--;
            step++;
            //下
        } else if (keyCode == 40) {
            if (x0 == 0) {
                return;
            }
            datas[x0][y0] = datas[x0 - 1][y0];
            datas[x0 - 1][y0] = 0;
            x0--;
            step++;
        } else if (keyCode == 87 || keyCode == 68) {
            datas = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        } else {
            System.out.println("只能按上下左右键");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("点击重新开始");
        if (e.getSource() == jMenuItem1) {
            initData();
            step = 0;
            initImage();
        } else if (e.getSource() == jMenuItem2) {
            JDialog jDialog = new JDialog();
            jDialog.setModal(true);
            ImageIcon imageIcon = new ImageIcon("image\\about.png");
            JLabel jLabel = new JLabel(imageIcon);
            jLabel.setBounds(0, 0, 344, 344);
            jDialog.add(jLabel);
            jDialog.setSize(344, 344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
        } else {

        }

    }
}
