package component;

import hero.Role;
import hero.skill.Skill;
import monster.Monster;
import monster.MonsterFactory;
import util.ResultMessage;
import util.SkillResult;

import java.util.ArrayList;

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

    public ResultMessage attack(){
        boolean killed=monster.beAttacked((int) role.normalAttack().getT());
        if(killed){
            this.getReward();
        }
        killed=role.beAttacked(monster.attack());
        if(killed){
            this.beKilled();
        }
        return new ResultMessage(true, "下一回合", 0);
    }

    public ResultMessage skill(ArrayList<Skill> skills){
        int cost=0;
        for(Skill skill:skills){
            cost+=skill.getCost();
        }
        if(cost>this.role.getCharacter().getMagicPoint()){
            return  new ResultMessage(false, "MP不够", cost);
        }else{
            this.role.getCharacter().setMagicPoint(this.role.getCharacter().getMaxMagicPoint()-cost);
        }
        for(Skill skill:skills){
            SkillResult result=skill.execute(role.getCharacter().getWeapon().getDamage());
            if(result.getDamage()>0){
                boolean killed=this.monster.beAttacked(result.getDamage());
                if(killed){

                    this.getReward();

                }
            }
            if(result.getHeal()>0){
                this.role.heal(result.getHeal());
            }
        }

        boolean beKilled=role.beAttacked(monster.attack());
        if(beKilled){
           this.beKilled();
        }

        return new ResultMessage(true, "下一回合", 0);
    }

    private ResultMessage getReward(){
        this.end=true;
        this.win=true;
        int coin=this.role.getCharacter().getCoin()+this.monster.getCoin();
        this.role.getCharacter().setCoin(coin);
        this.role.levelUp();
        this.role.getCharacter().setHealthPoint(this.role.getCharacter().getMaxHealthPoint());
        this.role.getCharacter().setMagicPoint(this.role.getCharacter().getMaxMagicPoint());
        return new ResultMessage(true, "战斗胜利", 0);
    }



    private ResultMessage beKilled(){
        this.end=true;
        this.win=false;
        return new ResultMessage(false, "战斗失败", 0);
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
