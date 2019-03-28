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
        boolean killed = monster.beAttacked((int) character.normalAttack().getT());
        if (killed) {
            return this.getReward();
        }
        killed = character.beAttacked(monster.attack());
        if (killed) {
            return this.beKilled();
        }
        return new ResultMessage(true, "下一回合", 0);
    }

    /**
     * 战斗中角色使用技能，并对怪物造成伤害
     * @param skills 技能列表，0是职业技能1，1是职业技能2
     * @return
     */
    public ResultMessage skill(ArrayList<Integer> skills) {
        ResultMessage roleSkillResult = this.character.getRole().useSkill(skills);
        if (roleSkillResult.isSuccess()) {
            boolean monsterKilled = this.monster.beAttacked((Integer) roleSkillResult.getT());
            if (monsterKilled) {
                this.getReward();
            } else {
                return new ResultMessage(true, roleSkillResult.getInformation().concat("；怪物受到" + Integer.valueOf((Integer) roleSkillResult.getT())), (Integer) roleSkillResult.getT());
            }
        } else {
            return roleSkillResult;
        }
        boolean killed = character.beAttacked(monster.attack());
        if (killed) {
            this.beKilled();
        }

        return  new ResultMessage(true, "下一回合", 0);
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

                    this.getReward();

                }
            }
            if (result.getHeal() > 0) {
                this.character.heal(result.getHeal());
            }
        }

        boolean beKilled = character.beAttacked(monster.attack());
        if (beKilled) {
            this.beKilled();
        }

        return new ResultMessage(true, "下一回合", 0);
    }

    private ResultMessage getReward() {
        this.end = true;
        this.win = true;
        int coin = this.character.getCoin() + this.monster.getCoin();
        this.character.setCoin(coin);
        this.character.levelUp();
        this.character.setHealthPoint(this.character.getMaxHealthPoint());
        this.character.setMagicPoint(this.character.getMaxMagicPoint());
        return new ResultMessage(true, "战斗胜利", 0);
    }


    private ResultMessage beKilled() {
        this.end = true;
        this.win = false;
        return new ResultMessage(false, "战斗失败", 0);
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
