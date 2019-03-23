package hero.skill;

import util.SkillResult;

//造成伤害等量回血
public class WarriorSkill2 extends Skill{

    private double power;

    public  WarriorSkill2(){
        this.power=1.5;
        this.level=1;
        this.cost=10;
    }

    public SkillResult execute(int attack) {
        int dmg=(int)(attack*power);
        return new SkillResult(dmg,dmg,this.cost);
    }

    public void levelUp(){
        this.level++;
        power+=0.15;
    }
}
