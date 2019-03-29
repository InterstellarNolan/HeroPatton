package controller;

import hero.Character;
import ui.HeroInfoUI;
import ui.HeroUI;
import ui.InfoBoard;
import ui.ShopUI;
import util.ResultMessage;

import javax.swing.*;

public class ShopController {
    private ShopUI shopUI;
    private Character character;
    private HeroUI heroUI;
    private HeroInfoUI heroInfoUI;
    private InfoBoard infoBoard;

    public ShopController(Character character,ShopUI shopUI,InfoBoard infoBoard,HeroUI heroUI,HeroInfoUI heroInfoUI){
        this.character=character;
        this.shopUI=shopUI;
        this.infoBoard=infoBoard;
        this.heroUI=heroUI;
        this.heroInfoUI=heroInfoUI;

        activeController();
    }

    public void activeController(){
        this.shopUI.initializeController(this);
    }

    public void enhanceWeapon(){
        //int fee=this.cost(this.character.getWeapon().getLeftStrength());
        ResultMessage message=this.character.getWeapon().Strengthen();
        if(message.isSuccess()){
            this.shopUI.refresh();
            this.heroInfoUI.refresh();
            this.infoBoard.setInfoText(message.getInformation());
            JOptionPane.showMessageDialog(heroUI.getFrame(), "强化成功", "成功",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(heroUI.getFrame(), "强化失败", "失败",JOptionPane.ERROR_MESSAGE);
        }

    }

    public void enhanceArmor(){
        ResultMessage message=this.character.getArmor().strength();
        if(message.isSuccess()){
            this.shopUI.refresh();
            this.heroInfoUI.refresh();
            this.infoBoard.setInfoText(message.getInformation());
            JOptionPane.showMessageDialog(heroUI.getFrame(), "强化成功", "成功",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(heroUI.getFrame(), "强化失败", "失败",JOptionPane.ERROR_MESSAGE);
        }
    }

    private int cost(int times){
        return 10*(6-times);
    }

}
