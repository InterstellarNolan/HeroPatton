package hero;

import item.Weapon;
import util.ResultMessage;

import java.util.Random;

public class RoleHunter implements Role {

    private Character character;

    public RoleHunter(Character character) {
        this.character = character;
    }


    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public String getRole() {
        return "Hunter";
    }

    @Override
    public int levelUp() {
        /**
         * Hunter等级提升一级（不超过100级）
         */
        int currentLevel = character.getLevel();
        if (currentLevel < 100) {
            character.setLevel(currentLevel + 1);
        } else {
            return currentLevel;
        }

        int healthPoint = character.getMaxMagicPoint() + 30 * currentLevel;
        character.setMaxHealthPoint(healthPoint);
        character.setHealthPoint(healthPoint);

        int magicPoint = character.getMaxMagicPoint() + 50 * currentLevel;
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
            //如果是远程武器造成1.2倍伤害，如果是近战造成1倍伤害
            if (weapon.getWeaponType().equals("hunter")) {
                damage = (int) (weapon.getDamage() * 1.2);
            } else if (weapon.getWeaponType().equals("warrior")) {
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
            //没有武器 造成80%命中的石块伤害
        } else {
            //5乘角色等级，加2-6点伤害
            int damage = character.getLevel() * 5 + new Random().nextInt(5) + 2;
            boolean hit = false;
            if (new Random().nextDouble() > 0.2) {
                hit = true;
            } else {
                damage = 0;
            }
            return new ResultMessage(hit, "造成".concat(String.valueOf(damage) + "点石块伤害"), damage);
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
