package item;

import java.util.Random;

public class WeaponBow extends Weapon {


    public WeaponBow(String name1, String description1, int damage1, String damageType1) {
        setName(name1.concat("-远程"));
        setDescription(description1);
        setLevel(1);
        setDamage(damage1);
        setDamageType(damageType1);
        setValue(10);
    }

    @Override
    public int levelUp() {
        int level = getLevel();
        if (level < 100) {
            setDamage(getDamage() + level * 4);
            setLevel(level++);
            setValue(10 * level + new Random().nextInt(10));
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
