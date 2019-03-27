package ui;

import controller.GameplayController;
import controller.OperationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AfterBattlePanel {
    private JPanel btPanel;
    private JButton next;
    private JButton shop;
    private JButton end;

    public AfterBattlePanel(){
        initializeUI();
    }

    private void initializeUI(){
        // 功能按键初始化
        this.next = new JButton("下一场");
        this.shop = new JButton("商店");
        this.end = new JButton("结束");
        this.btPanel = new JPanel();
        btPanel.setLayout(new GridLayout(2, 5));
        btPanel.add(next);
        btPanel.add(shop);
        btPanel.add(end);
    }


    public JPanel getBtPanel(){
        return this.btPanel;
    }

    public void initializeController(GameplayController gameplayController){
        this.next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameplayController.nextBattle();
            }
        });
        this.shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameplayController.goToShop();
            }
        });
        this.end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameplayController.newGame();
            }
        });


    }
    
}
