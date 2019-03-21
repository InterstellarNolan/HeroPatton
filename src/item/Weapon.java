package item;

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

    public int levelUp(){
        return level;
    }

    public abstract double Strengthen(int coin);


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

}
