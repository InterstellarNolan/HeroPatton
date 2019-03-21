package item;

import util.ResultMessage;

import java.util.Random;

public class WeaponBow extends Weapon {


    public WeaponBow(String name1, String description1, int damage1) {
        setName(name1.concat("-远程"));
        setWeaponType("hunter");
        setDescription(description1);
        setLevel(1);
        setDamage(damage1);
        setDamageType("远程伤害");
        setValue(10);
    }

    @Override
    public ResultMessage levelUp() {
        ResultMessage resultMessage;
        int level = getLevel();
        if (level < 100) {
            setDamage(getDamage() + level * 4);
            setLevel(level++);
            setValue(10 * level + new Random().nextInt(10));
            resultMessage = new ResultMessage(true, "武器已升级到" + String.valueOf(level) + "级", level);
            return resultMessage;
        } else {
            resultMessage = new ResultMessage(false, "武器升级失败", level);
            return resultMessage;
        }
    }

    /**
     * 远程武器强化，提高伤害0-5点，消耗一次机会
     *
     * @return
     */
    @Override
    public ResultMessage Strengthen() {

        if (getLeftStrength() > 0) {
            setDamage(getDamage() + new Random().nextInt(5));
            setLeftStrength(getLeftStrength() - 1);
            return new ResultMessage(true, getName().concat("已强化，当前伤害" + String.valueOf(getDamage())), getDamage());
        } else {
            return new ResultMessage(false,"强化失败，剩余强化次数不够",getDamage());
        }
    }

}
