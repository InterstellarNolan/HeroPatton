package controller;

import component.Battle;
import hero.Character;
import ui.*;
import util.ResultMessage;

import javax.swing.*;
import java.util.ArrayList;

public class OperationController {

    private OperationPanel operationPanel;
    private Battle battle;
    private HeroInfoUI heroInfoUI;
    private MonsterInfoUI monsterInfoUI;
    private Character character;
    private InfoBoard infoBoard;
    private HeroUI heroUI;
    private ShopUI shopUI;


    public OperationController(Character character, Battle battle, HeroInfoUI heroInfoUI, MonsterInfoUI monsterInfoUI, OperationPanel operationPanel, InfoBoard infoBoard, HeroUI heroUI, ShopUI shopUI) {
        this.character = character;
        this.heroInfoUI = heroInfoUI;
        this.monsterInfoUI = monsterInfoUI;
        this.battle = battle;
        this.operationPanel = operationPanel;
        this.infoBoard = infoBoard;
        this.heroUI = heroUI;
        this.shopUI = shopUI;
        activeController();

    }

    public void activeController() {
        this.operationPanel.initializeController(this);
    }

    public void attack() {
        this.operationPanel.disableButtons();
        ResultMessage resultMessage = this.battle.attack();
        this.infoBoard.setInfoText(resultMessage.getInformation());
        this.heroInfoUI.refresh();
        this.monsterInfoUI.refresh();
        if (this.battle.isEnd()) {
            if (this.battle.isWin()) {
                this.operationPanel.changeToAfter();
            } else {
                JOptionPane.showMessageDialog(heroUI.getFrame(), "你被打败了", "游戏结束", JOptionPane.ERROR_MESSAGE);
                this.heroUI.getFrame().dispose();
                WelcomeUI welcomeUI = new WelcomeUI();
            }

        }
        this.operationPanel.enableButtons();
    }

    public void skill(ArrayList<Integer> skills) {
        this.operationPanel.disableButtons();
        ResultMessage resultMessage = this.battle.skill(skills);
        this.infoBoard.setInfoText(resultMessage.getInformation());
        this.heroInfoUI.refresh();
        this.monsterInfoUI.refresh();
        if (this.battle.isEnd()) {
            if (this.battle.isWin()) {
                this.operationPanel.changeToAfter();
            } else {
                JOptionPane.showMessageDialog(heroUI.getFrame(), "你被打败了", "游戏结束", JOptionPane.ERROR_MESSAGE);
                this.heroUI.getFrame().dispose();
                WelcomeUI welcomeUI = new WelcomeUI();
            }
        }
        this.operationPanel.enableButtons();
    }

    public void nextBattle() {
        Battle battle = new Battle(this.character);
        this.battle = battle;
        this.monsterInfoUI.setMonster(battle.getMonster());
        this.monsterInfoUI.refresh();
        this.heroInfoUI.refresh();
        this.operationPanel.changeToBattle();
        shopUI.disableButtons();
    }

    public void goToShop() {
        shopUI.enableButtons();
    }

    public void endGame() {
        this.heroUI.getFrame().dispose();
        WelcomeUI welcomeUI = new WelcomeUI();
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }
}
