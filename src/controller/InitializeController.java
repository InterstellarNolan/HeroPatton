package controller;

import hero.Character;
import ui.HeroUI;
import ui.WelcomeUI;


public class InitializeController {
    private WelcomeUI welcomeUI;
    private Character character;

    public InitializeController(WelcomeUI welcomeUI) {
        this.welcomeUI = welcomeUI;
        activeController();
    }

    public void activeController() {
        this.welcomeUI.initializeController(this);
    }

    public void gameStart(String name, String role) {

        String roleName="warrior";
        if (name.equals("")) {
            name = "新玩家";
        }
        if (role.equals("战士")) {
            roleName = "warrior";
        } else if (role.equals("猎人")) {
            roleName = "hunter";
        }
        this.character = new Character(name, roleName);
        welcomeUI.getFrame().dispose();
        HeroUI heroUI = new HeroUI(character);
    }
}
