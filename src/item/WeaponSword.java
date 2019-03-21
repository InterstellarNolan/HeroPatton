package item;

public class WeaponSword extends Weapon {
    public WeaponSword(String name1, String description1, double damage1, String damageType1) {
        name = name1.concat("-近战");
        description = description1;
        level = 1;
        damage = damage1;
        damageType = damageType1;
        value = 10;
    }

    @Override
    public int levelUp() {
        if (level < 100) {
            damage=damage+level*5;
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
