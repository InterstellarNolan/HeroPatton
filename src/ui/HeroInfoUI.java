package ui;

import hero.Character;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HeroInfoUI {
    private Character character;
    private JPanel heroInfoPanel;
    private JTextArea description;

    public HeroInfoUI(Character character){
        initialize(character);
    }

    private void initialize(Character character){
        this.character=character;
        this.heroInfoPanel = new JPanel();
        Border heroTitle = BorderFactory.createTitledBorder("人物信息");
        this.heroInfoPanel.setBorder(heroTitle);
        this.description=new JTextArea(character.getInfo());
        this.description.setEditable(false);
        this.heroInfoPanel.add(this.description,BorderLayout.CENTER);

        this.heroInfoPanel.setVisible(true);
    }

    public JPanel getPanel(){
        return this.heroInfoPanel;
    }

    public void refresh(){
        description.setText(character.getInfo());
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
