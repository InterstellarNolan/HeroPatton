package component;

import hero.Character;
import hero.skill.Skill;
import monster.Monster;
import monster.MonsterFactory;
import util.ResultMessage;
import util.SkillResult;

import java.util.ArrayList;

public class Battle {
    private Monster monster;
    private Character character;
    private boolean end = false;
    private boolean win = false;

    public Battle() {
    }

    public Battle(Character character) {
        this.character = character;
        this.monster = MonsterFactory.getInstance().createMonster(character.getLevel());
        this.end = false;
        this.win = false;
    }

    public ResultMessage attack() {
        ResultMessage attackMessage=character.normalAttack();
        boolean killed = monster.beAttacked((int) attackMessage.getT());
        if (killed) {
            return this.getReward(attackMessage.getInformation());
        }
        int monsterDamage=monster.attack();
        killed = character.beAttacked(monsterDamage);
        if (killed) {
            return this.beKilled("怪物对英雄造成"+String.valueOf(monsterDamage)+"点伤害，英雄死亡；");
        }
        return new ResultMessage(true, attackMessage.getInformation(), 0);
    }

    /**
     * 战斗中角色使用技能，并对怪物造成伤害
     * @param skills 技能列表，0是职业技能1，1是职业技能2
     * @return
     */
    public ResultMessage skill(ArrayList<Integer> skills) {
        ResultMessage roleSkillResult = this.character.getRole().useSkill(skills);
        String info="";
        int damage=0;
        if (roleSkillResult.isSuccess()) {
            boolean monsterKilled = this.monster.beAttacked((Integer) roleSkillResult.getT());
            if (monsterKilled) {
                return this.getReward(roleSkillResult.getInformation().concat("怪物受到" + Integer.valueOf((Integer) roleSkillResult.getT())+"点伤害；"));
            } else {
                info=roleSkillResult.getInformation().concat("怪物受到" + Integer.valueOf((Integer) roleSkillResult.getT())+"点伤害；");
            }
        } else {
            info= roleSkillResult.getInformation();
        }
        int monsterDamage=monster.attack();
        boolean killed = character.beAttacked(monsterDamage);
        if (killed) {
            return this.beKilled("怪物对英雄造成"+String.valueOf(monsterDamage)+"点伤害，英雄死亡；");
        }

        return  new ResultMessage(true, (info), 0);
    }

    public ResultMessage oldskill(ArrayList<Skill> skills) {
        int cost = 0;
        for (Skill skill : skills) {
            cost += skill.getCost();
        }
        if (cost > this.character.getMagicPoint()) {
            return new ResultMessage(false, "MP不够", cost);
        } else {
            this.character.setMagicPoint(this.character.getMagicPoint() - cost);
        }
        for (Skill skill : skills) {
            SkillResult result = skill.execute(character.getWeapon().getDamage());
            if (result.getDamage() > 0) {
                boolean killed = this.monster.beAttacked(result.getDamage());
                if (killed) {

                    this.getReward("无");

                }
            }
            if (result.getHeal() > 0) {
                this.character.heal(result.getHeal());
            }
        }

        boolean beKilled = character.beAttacked(monster.attack());
        if (beKilled) {
            this.beKilled("无");
        }

        return new ResultMessage(true, "下一回合", 0);
    }

    private ResultMessage getReward(String info) {
        this.end = true;
        this.win = true;
        int coin = this.character.getCoin() + this.monster.getCoin();
        this.character.setCoin(coin);
        this.character.levelUp();
        return new ResultMessage(true, info.concat("\n战斗胜利！"), 0);
    }


    private ResultMessage beKilled(String info) {
        this.end = true;
        this.win = false;
        return new ResultMessage(false, info.concat("\n战斗失败，重新开始！"), 0);
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
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
