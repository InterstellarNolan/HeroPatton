package hero.skill;

import util.SkillResult;

public class WarriorSkill1 extends Skill {

    private double power;

    public WarriorSkill1() {
        this.power = 2.5;
        this.level = 1;
        this.cost = 10;
    }

    public SkillResult execute(int attack) {
        int dmg = (int) (attack * power);
        return new SkillResult(dmg, 0, this.cost);
    }

    public void levelUp() {
        this.level++;
        power += 0.25;
    }
}
