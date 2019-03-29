package ui;

import component.Battle;
import controller.OperationController;
import controller.ShopController;
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
    private ShopUI shopUI;

    private OperationController operationController;
    private ShopController shopController;

    public HeroUI() {
        this.character = new Character("player", "warrior");
        Battle battle = new Battle(character);
        this.heroInfoUI = new HeroInfoUI(character);
        this.monsterInfoUI = new MonsterInfoUI(battle.getMonster());
        this.operationPanel = new OperationPanel();
        operationPanel.changeToBattle();
        this.infoBoard = new InfoBoard();


        //this.operationController=new OperationController(character,battle,heroInfoUI,monsterInfoUI,operationPanel,this);


        initializeUI();
    }

    public HeroUI(Character character) {
        this.character = character;
        Battle battle = new Battle(character);
        this.heroInfoUI = new HeroInfoUI(character);
        this.monsterInfoUI = new MonsterInfoUI(battle.getMonster());
        this.operationPanel = new OperationPanel();
        operationPanel.changeToBattle();
        this.infoBoard = new InfoBoard();
        this.shopUI = new ShopUI(character);

        this.operationController = new OperationController(character, battle, heroInfoUI, monsterInfoUI, operationPanel, infoBoard, this, shopUI);
        this.shopController = new ShopController(character, shopUI, infoBoard, this, heroInfoUI);

        initializeUI();
    }


    private void initializeUI() {
        this.frame = new JFrame("HeroPattern");
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(2, 3));
        frame.add(this.monsterInfoUI.getPanel());
        frame.add(this.heroInfoUI.getPanel());
        frame.add(this.shopUI.getPanel());
        frame.add(this.infoBoard.getInfoPanel());
        frame.add(this.operationPanel.getPanel());

        frame.setBounds(300, 200, 1000, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void clear() {
        frame.remove(this.monsterInfoUI.getPanel());
        frame.remove(this.heroInfoUI.getPanel());
        frame.remove(this.infoBoard.getInfoPanel());
        frame.remove(this.operationPanel.getPanel());
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
