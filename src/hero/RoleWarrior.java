package hero;

import item.Weapon;
import util.ResultMessage;

import java.util.Random;

public class RoleWarrior implements Role {

    private Character character;

    public RoleWarrior(Character character) {
        this.character = character;
    }


    @Override
    public Character getCharacter() {
        return this.character;
    }


    @Override
    public String getRole() {
        return "Warrior";
    }

    /**
     * 升级
     *
     * @return
     */
    @Override
    public ResultMessage levelUp() {
        /**
         * Warrior等级提升一级（不超过100级）
         */
        int currentLevel = this.character.getLevel();
        if (currentLevel < 100) {
            this.character.setLevel(currentLevel + 1);
        } else {
            return new ResultMessage(false, "角色升级失败，已达到100级", currentLevel);
        }

        int healthPoint = this.character.getMaxMagicPoint() + 50 * currentLevel;
        this.character.setMaxHealthPoint(healthPoint);
        this.character.setHealthPoint(healthPoint);

        int magicPoint = this.character.getMaxMagicPoint() + 20 * currentLevel;
        this.character.setMaxMagicPoint(magicPoint);
        this.character.setMagicPoint(magicPoint);

        /**
         * 武器升级
         */
        if (this.character.getWeapon() != null) {
            Weapon weapon = this.character.getWeapon();
            ResultMessage resultMessage = weapon.levelUp();
            if (!resultMessage.isSuccess()) {
                return new ResultMessage(true, "战士角色升级成功，武器升级失败", currentLevel + 1);
            }
        }


        return new ResultMessage(true, "战士角色升级成功", currentLevel + 1);


    }

    /**
     * 普通攻击
     *
     * @return
     */
    @Override
    public ResultMessage normalAttack() {
        //有武器的话
        if (character.getWeapon() != null) {
            Weapon weapon = character.getWeapon();
            int damage = 0;
            boolean hit = false;
            //如果是近战武器造成1.1倍伤害，如果是远程造成1倍伤害
            if (weapon.getWeaponType().equals("warrior")) {
                damage = (int) (weapon.getDamage() * 1.1);
            } else if (weapon.getWeaponType().equals("hunter")) {
                damage = weapon.getDamage();
            } else {
                damage = weapon.getDamage();
            }
            //计算命中
            if (weapon.getHitRate() > new Random().nextDouble()) {
                hit = true;
            } else {
                damage = 0;
            }
            return new ResultMessage(hit, "造成".concat(String.valueOf(damage) + "点" + weapon.getDamageType() + "伤害"), damage);
            //没有武器 造成必定命中的徒手伤害
        } else {
            //7乘角色等级，加3-8点伤害
            int damage = character.getLevel() * 7 + new Random().nextInt(6) + 3;
            return new ResultMessage(true, "造成".concat(String.valueOf(damage) + "点徒手伤害"), damage);
        }
    }

    /**
     * 被敌人攻击
     *
     * @param damage 伤害数值
     * @return true死了false活着
     */
    @Override
    public boolean beAttacked(int damage) {
        int hp = this.character.getHealthPoint() - damage;
        this.character.setHealthPoint(hp);
        if (hp <= 0) {
            this.character.setHealthPoint(0);
            return true;
        } else {
            return false;
        }

    }

    /**
     * 回血
     *
     * @param value
     * @return
     */
    // @Override
    public ResultMessage heal(int value) {
        int hp = this.character.getHealthPoint() + value;
        if (hp > this.character.getMaxHealthPoint()) {
            value = hp - this.character.getMaxHealthPoint();
            hp = this.character.getMaxHealthPoint();
        }
        this.character.setHealthPoint(hp);
        return new ResultMessage(true, "回复".concat(String.valueOf(value) + "点血量"), value);
    }
}
