package ui;

import controller.OperationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class OperationPanel {
    private JPanel btnPanel;
    private JPanel currentPanel;
    private JPanel battleBtn;
    private JPanel afterBattleBtn;

    private JButton attack;
    private JButton skill1;
    private JButton skill2;
    private JButton skills;
    private JButton next;
    private JButton shop;
    private JButton end;

    private CardLayout card;

    public OperationPanel(){
        initializeUI();
    }

    private void initializeUI(){
        // 功能按键初始化
        this.attack = new JButton("普通攻击");
        this.skill1 = new JButton("技能1");
        this.skill2 = new JButton("技能2");
        this.skills = new JButton("组合技能");
        
        this.battleBtn = new JPanel();
        battleBtn.setLayout(new GridLayout(4, 1));
        battleBtn.add(attack);
        battleBtn.add(skill1);
        battleBtn.add(skill2);
        battleBtn.add(skills);

        this.next = new JButton("下一场");
        this.shop = new JButton("强化装备");
        this.end = new JButton("结束");
        this.afterBattleBtn = new JPanel();
        afterBattleBtn.setLayout(new GridLayout(3, 1));
        afterBattleBtn.add(next);
        afterBattleBtn.add(shop);
        afterBattleBtn.add(end);

        //card = new CardLayout(5, 5);
        card = new CardLayout();
        btnPanel=new JPanel(card);
        btnPanel.add(battleBtn,"battle");
        btnPanel.add(afterBattleBtn,"after");
        btnPanel.setVisible(true);

    }

    public void changeToBattle(){
        this.currentPanel=battleBtn;
        card.show(btnPanel,"battle");
    }
    public void changeToAfter(){
        this.currentPanel=afterBattleBtn;
        card.show(btnPanel,"after");
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

        this.next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationController.nextBattle();
            }
        });
        this.shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationController.goToShop();
            }
        });
        this.end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationController.endGame();
            }
        });


    }

    public JPanel getPanel(){
        return this.btnPanel;
    }

    public JPanel getCurrentPanel(){
        return this.currentPanel;
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
