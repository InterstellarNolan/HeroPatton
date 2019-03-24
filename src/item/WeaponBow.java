package item;

import util.ResultMessage;

import java.util.Random;

public class WeaponBow extends Weapon {


    public WeaponBow(String name1, String description1, int damage1) {
        this.setName(name1.concat("-远程"));
        this.setWeaponType("hunter");
        this.setDescription(description1);
        this.setLevel(1);
        this.setDamage(damage1);
        this.setDamageType("远程伤害");
        this.setValue(10);
    }

    @Override
    public ResultMessage levelUp() {
        ResultMessage resultMessage;
        int level = this.getLevel();
        if (level < 100) {
            this.setDamage(this.getDamage() + level * 4);
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
     * 远程武器强化，提高伤害0-5点，消耗一次机会
     *
     * @return
     */
    @Override
    public ResultMessage Strengthen() {

        if (this.getLeftStrength() > 0) {
            this.setDamage(this.getDamage() + new Random().nextInt(5));
            this.setLeftStrength(this.getLeftStrength() - 1);
            return new ResultMessage(true, getName().concat("已强化，当前伤害" + String.valueOf(this.getDamage())), this.getDamage());
        } else {
            return new ResultMessage(false,"强化失败，剩余强化次数不够",this.getDamage());
        }
    }

}
