package ui;

import controller.ShopController;
import hero.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopUI {
    private Character character;
    private JPanel shopPanel;
    private JButton enhanceWeapon;
    private JButton enhanceArmor;
    private JPanel weapon;
    private JPanel armor;
    private JTextArea weaponInfo;
    private JTextArea armorInfo;

    public ShopUI(Character character){
        this.character=character;
        initialize(character);
    }

    private void initialize(Character character){
        this.shopPanel=new JPanel();
        shopPanel.setLayout(new GridLayout(2, 1));
        this.weapon=new JPanel();
        this.armor=new JPanel();
        this.enhanceWeapon=new JButton("强化");
        this.enhanceArmor=new JButton("强化");
        this.weaponInfo=new JTextArea(character.getWeapon().getInfo());
        weaponInfo.setEditable(false);
        this.armorInfo=new JTextArea(character.getArmor().getInfo());
        this.armorInfo.setEditable(false);
        weapon.add(weaponInfo);
        armor.add(armorInfo);
        weapon.add(enhanceWeapon);
        armor.add(enhanceArmor);
        shopPanel.add(weapon);
        shopPanel.add(armor);
    }

    public void initializeController(ShopController shopController){
        this.enhanceWeapon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shopController.enhanceWeapon();
            }
        });
        this.enhanceArmor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shopController.enhanceArmor();
            }
        });
    }


    public void refresh(){
        this.weaponInfo.setText(character.getWeapon().getInfo());
        this.armorInfo.setText(character.getArmor().getInfo());
    }

    public JPanel getPanel() {
        return shopPanel;
    }

    public void enableButtons(){
        this.enhanceWeapon.setEnabled(true);
        this.enhanceArmor.setEnabled(true);
    }

    public void disableButtons(){
        this.enhanceWeapon.setEnabled(false);
        this.enhanceArmor.setEnabled(false);
    }
}
