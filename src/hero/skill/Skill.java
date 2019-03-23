package hero.skill;

import util.SkillResult;

public abstract class Skill {
    protected int level=0;
    protected int cost;

    public SkillResult execute(int attack){
        return new SkillResult();
    }

    public void levelUp(){
        this.level++;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
