package ui;

import monster.Monster;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MonsterInfoUI {
    private Monster monster;
    private JPanel monsterInfoPanel;
    private JTextArea description;

    public MonsterInfoUI(Monster monster){
        initialize(monster);
    }

    private void initialize(Monster monster){
        this.monster=monster;
        this.monsterInfoPanel = new JPanel();
        Border heroTitle = BorderFactory.createTitledBorder("怪物信息");
        this.monsterInfoPanel.setBorder(heroTitle);
        this.description=new JTextArea(monster.getInfo());

        this.description.setEditable(false);
        this.monsterInfoPanel.add(this.description,BorderLayout.CENTER);

        this.monsterInfoPanel.setVisible(true);
    }

    public JPanel getPanel(){
        return this.monsterInfoPanel;
    }

    public void refresh(){
        this.description.setText(monster.getInfo());
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
