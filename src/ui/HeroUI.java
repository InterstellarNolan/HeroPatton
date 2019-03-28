package ui;

import component.Battle;
import controller.OperationController;
import hero.Character;

import javax.swing.*;
import java.awt.*;

public class HeroUI {
    private JFrame frame;
    private HeroInfoUI heroInfoUI;
    private MonsterInfoUI monsterInfoUI;
    private OperationPanel operationPanel;
    private Character character;
    private InfoBoard infoBoard;

    private OperationController operationController;


    public HeroUI(){
        this.character=new Character("player","warrior");
        Battle battle=new Battle(character);
        this.heroInfoUI=new HeroInfoUI(character);
        this.monsterInfoUI=new MonsterInfoUI(battle.getMonster());
        this.operationPanel=new OperationPanel();
        operationPanel.changeToBattle();
        this.infoBoard=new InfoBoard();

        this.operationController=new OperationController(character,battle,heroInfoUI,monsterInfoUI,operationPanel);

        initializeUI();
    }

    public HeroUI(Character character) {
        this.character = character;
        Battle battle=new Battle(character);
        this.heroInfoUI=new HeroInfoUI(character);
        this.monsterInfoUI=new MonsterInfoUI(battle.getMonster());
        this.operationPanel=new OperationPanel();
        operationPanel.changeToBattle();
        this.infoBoard=new InfoBoard();

        this.operationController=new OperationController(character,battle,heroInfoUI,monsterInfoUI,operationPanel);

        initializeUI();
    }



    private void initializeUI(){
        this.frame = new JFrame("HeroPattern");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(2,2));
        frame.add(this.monsterInfoUI.getPanel());
        frame.add(this.heroInfoUI.getPanel());
        frame.add(this.infoBoard.getInfoPanel());
        frame.add(this.operationPanel.getPanel());

        frame.setBounds(300, 200, 800, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private static void createAndShowGUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加 "Hello World" 标签
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        // 显示窗口
        frame.pack();
        frame.setVisible(true);
    }

}
