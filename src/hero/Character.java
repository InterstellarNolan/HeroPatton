package hero;

import item.Armor;
import item.Weapon;
import util.ResultMessage;

/*
角色
 */
public class Character {
    //角色名称
    private String name;

    //金钱
    private int coin = 0;

    //健康值
    private int healthPoint = 100;

    //最大健康量
    private int maxHealthPoint = 100;

    //法力值
    private int magicPoint = 100;

    //最大法力值
    private int maxMagicPoint = 100;

    //职业
    private Role role;

    //等级
    private int level = 1;

    //经验
    private int experience = 0;



    //闪避率
    private double evadeRate = 0.05;

    //武器
    private Weapon weapon = null;

    //盔甲
    private Armor armor = null;

    //private static Character uniqueCharacter;

    /*
    public static Character getInstance(String name, String roleName) {
        if (uniqueCharacter == null) {
            uniqueCharacter = new Character(name, roleName);
        }
        return uniqueCharacter;
    }
    */
    public Character(String name, String roleName) {
        this.name = name;
        Role role;
        switch (roleName) {
            case "warrior":
                role = new RoleWarrior(this);
                break;
            case "hunter":
                role = new RoleHunter(this);
                break;
            default:
                role = new RoleWarrior(this);
        }
        this.role = role;
    }

    public ResultMessage levelUp(){
        return role.levelUp();
    }

    //普通攻击，返回是否命中，伤害数值
    public ResultMessage normalAttack(){
        return role.normalAttack();
    }

    //被打败返回true
    public boolean beAttacked(int damage){
        return role.beAttacked(damage);
    }

    public ResultMessage heal(int value){
        int hp = this.getHealthPoint()+value;
        if(hp>this.getMaxHealthPoint()){
            value = hp - this.getMaxHealthPoint();
            hp=this.getMaxHealthPoint();
        }
        this.setHealthPoint(hp);
        return new ResultMessage(true, "回复".concat(String.valueOf(value) + "点血量"), value);
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }

    public int getMagicPoint() {
        return magicPoint;
    }

    public void setMagicPoint(int magicPoint) {
        this.magicPoint = magicPoint;
    }

    public int getMaxMagicPoint() {
        return maxMagicPoint;
    }

    public void setMaxMagicPoint(int maxMagicPoint) {
        this.maxMagicPoint = maxMagicPoint;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    //命中率
    private double hitRate = 0.85;

    public double getEvadeRate() {
        return evadeRate;
    }

    public void setEvadeRate(double evadeRate) {
        this.evadeRate = evadeRate;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * 装备武器
     * @param weapon
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    /**
     * 装备盔甲
     * @param armor
     */
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}

