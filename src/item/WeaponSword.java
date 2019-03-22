package item;

import util.ResultMessage;

import java.util.Random;

public class WeaponSword extends Weapon {


    public WeaponSword(String name1, String description1, int damage1) {
        setName(name1.concat("-近战"));
        setWeaponType("warrior");
        setDescription(description1);
        setLevel(1);
        setDamage(damage1);
        setDamageType("近战伤害");
        setValue(10);
    }

    @Override
    public ResultMessage levelUp() {
        ResultMessage resultMessage;
        int level = getLevel();
        if (level < 100) {
            setDamage(getDamage() + level * 5);
            setLevel(level++);
            setValue(10 * level + new Random().nextInt(10));
            resultMessage = new ResultMessage(true, "武器已升级到" + String.valueOf(level) + "级", level);
            return resultMessage;
        } else {
            resultMessage = new ResultMessage(false, "武器升级失败，已达到100级", level);
            return resultMessage;
        }
    }

    /**
     * 近战武器强化，提高伤害1-3点，消耗一次机会
     *
     * @return
     */
    @Override
    public ResultMessage Strengthen() {

        if (getLeftStrength() > 0) {
            setDamage(getDamage() + new Random().nextInt(3) + 1);
            setLeftStrength(getLeftStrength() - 1);
            return new ResultMessage(true, getName().concat("已强化，当前伤害" + String.valueOf(getDamage())), getDamage());
        } else {
            return new ResultMessage(false,"强化失败，剩余强化次数不够",getDamage());
        }
    }
}
