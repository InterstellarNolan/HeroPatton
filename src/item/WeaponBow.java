package item;

public class WeaponBow extends Weapon {
    public WeaponBow(String name1, String description1, double damage1, String damageType1) {
        name = name1.concat("-远程");
        description = description1;
        level = 1;
        damage = damage1;
        damageType = damageType1;
        value = 10;
    }

    @Override
    public int levelUp() {
        if (level < 100) {
            damage = damage + level * 4;
            level++;
            return level;
        } else {
            return level;
        }
    }

    @Override
    public double Strengthen(int coin) {
        return 0;
    }
}
