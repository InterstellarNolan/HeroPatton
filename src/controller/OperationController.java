package controller;

import component.Battle;
import hero.Character;
import ui.*;

import java.util.ArrayList;

public class OperationController {

    private OperationPanel operationPanel;
    private Battle battle;
    private HeroInfoUI heroInfoUI;
    private MonsterInfoUI monsterInfoUI;
    private Character character;

    public  OperationController(){

    }

    public void activeController(){
        this.operationPanel.initializeController(this);
    }

    public void attack(){
        this.operationPanel.disableButtons();
        this.battle.attack();
        this.heroInfoUI.refresh();
        this.monsterInfoUI.refresh();
        if(this.battle.isEnd()){
            if(this.battle.isWin()){
                this.operationPanel.changeToAfter();
            }else{
                //lose
            }

        }
        this.operationPanel.enableButtons();
    }

    public void skill(ArrayList<Integer> skills){
        this.operationPanel.disableButtons();
        this.battle.skill(skills);
        this.heroInfoUI.refresh();
        this.monsterInfoUI.refresh();
        if(this.battle.isEnd()){
            if(this.battle.isWin()){
                this.operationPanel.changeToAfter();
            }else{
                //lose
            }
        }
        this.operationPanel.enableButtons();
    }

    public void nextBattle(){
        Battle battle=new Battle(this.character);
        this.monsterInfoUI.setMonster(battle.getMonster());
        this.monsterInfoUI.refresh();
        this.heroInfoUI.refresh();
        this.operationPanel.changeToBattle();
    }

    public void goToShop(){

    }

    public void endGame(){

    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }
}
