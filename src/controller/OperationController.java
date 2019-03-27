package controller;

import component.Battle;
import hero.Character;
import ui.AfterBattlePanel;
import ui.BattleOperationPanel;
import ui.HeroInfoUI;
import ui.MonsterInfoUI;

import java.util.ArrayList;

public class OperationController {

    private BattleOperationPanel battleOperationPanel;
    private Battle battle;
    private HeroInfoUI heroInfoUI;
    private MonsterInfoUI monsterInfoUI;

    public  OperationController(){

    }

    public void activeController(){
        this.battleOperationPanel.initializeController(this);
    }

    public void attack(){
        this.battle.attack();
        heroInfoUI.refresh();
        monsterInfoUI.refresh();
        if(this.battle.isEnd()){
            if(this.battle.isWin()){

            }else{

            }

        }
    }

    public void skill(ArrayList<Integer> skills){


    }




    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }
}
