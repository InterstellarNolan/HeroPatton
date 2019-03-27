package ui;

import controller.OperationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BattleOperationPanel {
    private JPanel btPanel;
    private JButton attack;
    private JButton skill1;
    private JButton skill2;
    private JButton skills;

    public BattleOperationPanel(){
        initializeUI();
    }

    private void initializeUI(){
        // 功能按键初始化
        this.attack = new JButton("普通攻击");
        this.skill1 = new JButton("技能1");
        this.skill2 = new JButton("技能2");
        this.skills = new JButton("组合技能");


        this.btPanel = new JPanel();
        btPanel.setLayout(new GridLayout(3, 5));
        btPanel.add(attack);
        btPanel.add(skill1);
        btPanel.add(skill2);
        btPanel.add(skills);

    }

    public void initializeController(OperationController operationController){
        this.attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationController.attack();
            }
        });

        this.skill1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> skills=new ArrayList<Integer>();
                skills.add(0);
                operationController.skill(skills);
            }
        });
        this.skill2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> skills=new ArrayList<Integer>();
                skills.add(1);
                operationController.skill(skills);
            }
        });
        this.skills.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> skills=new ArrayList<Integer>();
                skills.add(0);
                skills.add(1);
                operationController.skill(skills);
            }
        });


    }


    public JPanel getBtPanel(){
        return this.btPanel;
    }

    public void enableButtons(){
        this.attack.setEnabled(true);
        this.skill1.setEnabled(true);
        this.skill2.setEnabled(true);
        this.skills.setEnabled(true);
    }

    public void disableButtons(){
        this.attack.setEnabled(false);
        this.skill1.setEnabled(false);
        this.skill2.setEnabled(false);
        this.skills.setEnabled(false);
    }

}
