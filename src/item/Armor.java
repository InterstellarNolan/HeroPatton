package item;

import util.ResultMessage;

public abstract class Armor {
    //武器名称
    private String name = "盔甲";

    //盔甲类型，适合Warrior或Hunter
    private String armorType;

    //盔甲介绍
    private String description;

    //盔甲等级
    private int level;

    //盔甲血量，增加给角色
    private int extraHP;

    //价值
    private int value;

    //剩余加强次数
    private int leftStrength = 5;

    public String getInfo(){
        String result="防具名："+this.getName()+"\n职业："+this.getArmorType()+" \n等级："+String.valueOf(this.getLevel())+" \n额外血量："+String.valueOf(this.getExtraHP())+"\n介绍："+this.getDescription()+" \n剩余强化次数："+String.valueOf(this.getLeftStrength());
        return  result;
    }


    public abstract ResultMessage strength();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
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

    public int getExtraHP() {
        return extraHP;
    }

    public void setExtraHP(int extraHP) {
        this.extraHP = extraHP;
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

    public ResultMessage levelUp() {
        return new ResultMessage(false, "升级失败，不是具体盔甲", level);
    }
}
