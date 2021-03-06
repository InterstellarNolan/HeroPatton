package item;

import util.ResultMessage;

public abstract class Weapon {

    //武器名称
    private String name = "武器";

    //武器类型，适合Warrior或Hunter
    private String weaponType;

    //武器介绍
    private String description;

    //武器等级
    private int level;

    //武器伤害
    private int damage;

    //伤害类型
    private String damageType;

    //价值
    private int value;

    //剩余加强次数
    private int leftStrength = 5;

    //命中率
    private double hitRate = 0.9;

    public String getInfo(){
        String result="武器名："+this.getName()+"\n职业："+this.getWeaponType()+" \n等级："+String.valueOf(this.getLevel())+" \n伤害："+String.valueOf(this.getDamage())+"\n介绍："+this.getDescription()+" \n剩余强化次数："+String.valueOf(this.getLeftStrength());
        return  result;
    }

    public ResultMessage levelUp() {
        return new ResultMessage(false, "升级失败，不是具体武器", level);
    }

    public abstract ResultMessage Strengthen();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLeftStrength() {
        return leftStrength;
    }

    public void setLeftStrength(int leftStrength) {
        this.leftStrength = leftStrength;
    }

    public double getHitRate() {
        return hitRate;
    }

    public void setHitRate(double hitRate) {
        this.hitRate = hitRate;
    }
}
