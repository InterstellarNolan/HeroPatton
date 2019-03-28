package controller;

import hero.Character;
import ui.HeroUI;
import ui.WelcomeUI;


public class InitializeController {
    private WelcomeUI welcomeUI;
    private Character character;

    public InitializeController(WelcomeUI welcomeUI) {
        this.welcomeUI = welcomeUI;
    }

    public void activeController() {
        this.welcomeUI.initializeController(this);
    }

    public void gameStart(String name, String role) {
        System.out.println();
        System.out.println("okoko");
        String roleName = "Warrior";
        if (name == null) {
            name = "新玩家";
        }
        if (role.equals("战士")) {
            roleName = "Warrior";
        } else if (role.equals("猎人")) {
            roleName = "Hunter";
        }
        character = new Character(name, roleName);
        HeroUI heroUI = new HeroUI(character);
        welcomeUI=null;
    }
}
