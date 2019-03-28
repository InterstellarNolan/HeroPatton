package ui;

import hero.Character;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HeroInfoUI {
    private Character character;
    private JPanel heroInfoPanel;
    public HeroInfoUI(Character character){
        initialize(character);
    }

    private void initialize(Character character){
        this.heroInfoPanel = new JPanel();
        this.heroInfoPanel.setLayout(new BorderLayout());

        Border heroTitle = BorderFactory.createTitledBorder("人物信息");
        this.heroInfoPanel.setBorder(heroTitle);

        this.heroInfoPanel.setVisible(true);
    }

    public JPanel getHeroInfoPanel(){
        return this.heroInfoPanel;
    }

    public void refresh(){

    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
