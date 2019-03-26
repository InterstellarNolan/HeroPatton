package hero.skill;

import util.SkillResult;

//伤害技能
public class HunterSkill1 extends Skill {
    private double power;

    public HunterSkill1() {
        this.power = 2;
        this.level = 1;
        this.cost = 10;
    }

    public SkillResult execute(int attack) {
        int dmg = (int) (attack * power);
        return new SkillResult(dmg, 0, this.cost);
    }

    public void levelUp() {
        this.level++;
        power += 0.2;
    }

}
