package ui;

import javax.swing.*;
import java.awt.*;

public class HeroUI {
    private JFrame jFrame;
    private static void createAndShowGUI() {

        // 创建及设置窗口
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加 "Hello World" 标签
        JLabel label = new JLabel("Hello World");

        JTextArea textArea=new JTextArea("this is textArea");
        frame.add(label,BorderLayout.NORTH);
        frame.add(textArea,BorderLayout.SOUTH);

        // 显示窗口
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
