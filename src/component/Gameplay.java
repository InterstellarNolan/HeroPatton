package component;

import hero.Role;
import hero.Character;
import util.ResultMessage;

public class Gameplay {
    private Character player;

    public Gameplay(){
        player=new Character("player", "warrior");
    }

    public Gameplay(String name,String type){
        player=new Character(name, type);
    }


}
