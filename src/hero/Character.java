package hero;

import item.Armor;
import item.Weapon;

/*
角色
 */
public class Character {
    //角色名称
    private String name;

    //金钱
    private int coin = 0;

    //健康值
    private double healthPoint = 100;

    //最大健康量
    private double maxHealthPoint = 100;

    //法力值
    private double magicPoint = 100;

    //最大法力值
    private double maxMagicPoint = 100;

    //职业
    private Role role;

    //等级
    private int level = 1;

    //经验
    private int experience = 0;

    //命中率
    private double hitRate = 0.85;

    //闪避率
    private double evadeRate = 0.05;

    //武器
    private Weapon weapon = null;

    //盔甲
    private Armor armor = null;

    private static Character uniqueCharacter;

    public static Character getInstance(String name, String roleName) {
        if (uniqueCharacter == null) {
            uniqueCharacter = new Character(name, roleName);
        }
        return uniqueCharacter;
    }

    private Character(String name, String roleName) {
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

    public double getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }

    public double getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(double maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }

    public double getMagicPoint() {
        return magicPoint;
    }

    public void setMagicPoint(double magicPoint) {
        this.magicPoint = magicPoint;
    }

    public double getMaxMagicPoint() {
        return maxMagicPoint;
    }

    public void setMaxMagicPoint(double maxMagicPoint) {
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

    public double getHitRate() {
        return hitRate;
    }

    public void setHitRate(double hitRate) {
        this.hitRate = hitRate;
    }

    public double getEvadeRate() {
        return evadeRate;
    }

    public void setEvadeRate(double evadeRate) {
        this.evadeRate = evadeRate;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}

