package component;

import hero.Role;
import monster.Monster;
import monster.MonsterFactory;

public class Battle {
    private Monster monster;
    private Role role;
    public Battle(){}

    public Battle(Role role){
        this.role=role;

    }




    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
