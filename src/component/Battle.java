package component;

import hero.Role;
import monster.Monster;
import monster.MonsterFactory;

public class Battle {
    private Monster monster;
    private Role role;
    private boolean end=false;
    private boolean win=false;

    public Battle(){}

    public Battle(Role role){
        this.role=role;
        this.monster=MonsterFactory.getInstance().createMonster(role.getCharacter().getLevel());
        this.end=false;
        this.win=false;
    }

    public void attack(){
        

    }

    public void skill(int i){

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

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
