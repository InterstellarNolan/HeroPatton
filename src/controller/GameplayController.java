package controller;

import component.Battle;
import monster.Monster;
import ui.AfterBattlePanel;
import hero.Character;
import ui.HeroUI;
import ui.MonsterInfoUI;

public class GameplayController {
    private AfterBattlePanel afterBattlePanel;
    private Character character;
    private HeroUI heroUI;
    private MonsterInfoUI monsterUI;

    public void activeController(){
        this.afterBattlePanel.initializeController(this);
    }

    public void nextBattle(){
        Battle battle=new Battle(this.character);

    }

    public void goToShop(){

    }

    public void newGame(){

    }

}
