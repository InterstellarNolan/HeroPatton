package item;

import util.ResultMessage;

//武器注魔，装饰者模式，继承抽象类WeaponStrength
public class WeaponInfusion extends WeaponStrength {
    private Weapon weapon;

    public WeaponInfusion(Weapon weapon) {
        this.weapon = weapon;
    }


    /**
     * 武器注魔，改变伤害类型，消耗一次机会，增加2%命中率
     *
     * @return
     */
    @Override
    public ResultMessage Strengthen() {

        if (weapon.getLeftStrength() > 0) {
            weapon.setDamageType("诡异-".concat(weapon.getDamageType()));
            weapon.setName("奇特的".concat(getName()));
            weapon.setLeftStrength(weapon.getLeftStrength() - 1);
            weapon.setHitRate(weapon.getHitRate() + 0.02);
            return new ResultMessage(true, weapon.getName().concat("已注魔，当前伤害" + String.valueOf(weapon.getDamage())), weapon.getDamage());
        } else {
            return new ResultMessage(false, "注魔失败，剩余强化次数不够", weapon.getDamage());
        }
    }
}
