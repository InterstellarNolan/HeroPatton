package util;

public class SkillResult {
    private int damage;
    private int heal;
    private int cost;

    public SkillResult() {
        this.damage = 0;
        this.heal = 0;
        this.cost=0;
    }

    public SkillResult(int damage, int heal, int cost) {
        this.damage = damage;
        this.heal = heal;
        this.cost = cost;
    }

    public SkillResult(int damage, int heal) {
        this.damage = damage;
        this.heal = heal;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
