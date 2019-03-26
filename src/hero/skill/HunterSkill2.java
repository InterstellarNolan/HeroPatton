package hero.skill;

import util.SkillResult;

//heal治疗技能
public class HunterSkill2 extends Skill {
    private double power;

    public HunterSkill2() {
        this.power = 1;
        this.level = 1;
        this.cost = 10;
    }

    public SkillResult execute(int attack) {
        int heal = (int) (attack * power);
        return new SkillResult(0, heal, this.cost);
    }

    public void levelUp() {
        this.level++;
        power += 0.1;
    }
}
