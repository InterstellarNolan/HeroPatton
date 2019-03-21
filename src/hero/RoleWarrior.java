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
        return character;
    }


    @Override
    public String getRole() {
        return "Warrior";
    }

    @Override
    public int levelUp() {
        /**
         * Warrior等级提升一级（不超过100级）
         */
        int currentLevel = character.getLevel();
        if (currentLevel < 100) {
            character.setLevel(currentLevel + 1);
        } else {
            return currentLevel;
        }

        int healthPoint = character.getMaxMagicPoint() + 50 * currentLevel;
        character.setMaxHealthPoint(healthPoint);
        character.setHealthPoint(healthPoint);

        int magicPoint = character.getMaxMagicPoint() + 20 * currentLevel;
        character.setMaxMagicPoint(magicPoint);
        character.setMagicPoint(magicPoint);

        /**
         * 武器升级
         */
        if (character.getWeapon() != null) {
            Weapon weapon = character.getWeapon();
            ResultMessage resultMessage = weapon.levelUp();
        }

        return currentLevel + 1;


    }

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
}
