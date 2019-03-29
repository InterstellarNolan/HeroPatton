package controller;

import hero.Character;
import ui.HeroUI;
import ui.ShopUI;
import util.ResultMessage;

import javax.swing.*;

public class ShopController {
    private ShopUI shopUI;
    private Character character;
    private HeroUI heroUI;

    public ShopController(Character character,ShopUI shopUI,HeroUI heroUI){
        this.character=character;
        this.shopUI=shopUI;
        this.heroUI=heroUI;

        activeController();
    }

    public void activeController(){
        this.shopUI.initializeController(this);
    }

    public void enhanceWeapon(){
        ResultMessage message=this.character.getWeapon().Strengthen();
        if(message.isSuccess()){
            this.shopUI.refresh();
            JOptionPane.showMessageDialog(heroUI.getFrame(), "强化成功", "成功",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(heroUI.getFrame(), "强化失败", "失败",JOptionPane.ERROR_MESSAGE);
        }

    }

    public void enhanceArmor(){
        ResultMessage message=this.character.getArmor().strength();
        if(message.isSuccess()){
            this.shopUI.refresh();
            JOptionPane.showMessageDialog(heroUI.getFrame(), "强化成功", "成功",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(heroUI.getFrame(), "强化失败", "失败",JOptionPane.ERROR_MESSAGE);
        }
    }


}
