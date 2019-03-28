package ui;

import controller.InitializeController;
import controller.OperationController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static java.awt.Font.*;

public class WelcomeUI {
    private JFrame frame;
    private JPanel topPanel;
    private JPanel midPanel;
    private JPanel btmPanel;
    private JComboBox role;
    private InitializeController initializeController;
    private JTextField characterName;
    private JButton confirm;

    public WelcomeUI() {


        this.topPanel = new JPanel();

        JLabel label = new JLabel("创建英雄");
        label.setFont(new Font("宋体", BOLD, 20));
        this.topPanel.add(label);


        this.midPanel = new JPanel();
        this.midPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.characterName = new JTextField();
        this.characterName.addFocusListener(new JTextFieldHintListener(this.characterName, "英雄名称"));
        this.characterName.setColumns(10);
        this.role = new JComboBox();

        this.role.addItem("战士");
        this.role.addItem("猎人");
        this.role.setSelectedIndex(0);
        this.midPanel.add(this.characterName);
        this.midPanel.add(this.role);


        this.confirm = new JButton("确定");
        this.btmPanel = new JPanel();
        this.btmPanel.add(confirm);


        this.topPanel.setVisible(true);
        this.midPanel.setVisible(true);
        this.btmPanel.setVisible(true);
        this.initializeController = new InitializeController(this);

        initialize();
    }

    public void initialize() {
        this.frame = new JFrame("HeroPatton");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 1));
        frame.add(topPanel);
        frame.add(midPanel);
        frame.add(btmPanel);
        frame.setBounds(300, 200, 800, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initializeController(InitializeController initializeController) {
        this.confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeController.gameStart(characterName.getText(), (String) role.getSelectedItem());

            }
        });
    }


    class JTextFieldHintListener implements FocusListener {
        private String hintText;
        private JTextField textField;

        public JTextFieldHintListener(JTextField jTextField, String hintText) {
            this.textField = jTextField;
            this.hintText = hintText;
            jTextField.setText(hintText);  //默认直接显示
            jTextField.setForeground(Color.GRAY);
        }

        @Override
        public void focusGained(FocusEvent e) {
            //获取焦点时，清空提示内容
            String temp = textField.getText();
            if (temp.equals(hintText)) {
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }

        }

        @Override
        public void focusLost(FocusEvent e) {
            //失去焦点时，没有输入内容，显示提示内容
            String temp = textField.getText();
            if (temp.equals("")) {
                textField.setForeground(Color.GRAY);
                textField.setText(hintText);
            }

        }

    }
    public void clear(){
        frame.remove(topPanel);
        frame.remove(midPanel);
        frame.remove(btmPanel);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
