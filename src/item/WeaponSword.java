package item;

import util.ResultMessage;

import java.util.Random;

public class WeaponSword extends Weapon {


    public WeaponSword(String name1, String description1, int damage1) {
        this.setName(name1.concat("-近战"));
        this.setWeaponType("warrior");
        this.setDescription(description1);
        this.setLevel(1);
        this.setDamage(damage1);
        this.setDamageType("近战伤害");
        this.setValue(10);
    }

    @Override
    public ResultMessage levelUp() {
        ResultMessage resultMessage;
        int level = this.getLevel();
        if (level < 100) {
            this.setDamage(this.getDamage() + level * 5);
            this.setLevel(level++);
            this.setValue(10 * level + new Random().nextInt(10));
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

        if (this.getLeftStrength() > 0) {
            this.setDamage(this.getDamage() + new Random().nextInt(3) + 1);
            this.setLeftStrength(this.getLeftStrength() - 1);
            return new ResultMessage(true, getName().concat("已强化，当前伤害" + String.valueOf(this.getDamage())), this.getDamage());
        } else {
            return new ResultMessage(false,"强化失败，剩余强化次数不够",this.getDamage());
        }
    }
}
