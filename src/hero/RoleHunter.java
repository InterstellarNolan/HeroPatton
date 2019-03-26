package hero;

import item.Weapon;
import util.ResultMessage;

import java.util.Random;

public class RoleHunter implements Role {

    private  Character character;

    public RoleHunter(Character character) {
        this.character = character;
    }


    @Override
    public Character getCharacter() {
        return this.character;
    }

    @Override
    public String getRole() {
        return "Hunter";
    }

    @Override
    public ResultMessage levelUp() {
        /**
         * Hunter等级提升一级（不超过100级）
         */
        int currentLevel = this.character.getLevel();
        if (currentLevel < 100) {
            this.character.setLevel(currentLevel + 1);
        } else {
            return new ResultMessage(false,"角色升级失败，已达到100级",currentLevel);
        }

        int healthPoint = this.character.getMaxMagicPoint() + 30 * currentLevel;
        this.character.setMaxHealthPoint(healthPoint);
        this.character.setHealthPoint(healthPoint);

        int magicPoint = this.character.getMaxMagicPoint() + 50 * currentLevel;
        this.character.setMaxMagicPoint(magicPoint);
        this.character.setMagicPoint(magicPoint);


        /**
         * 武器升级
         */
        if (this.character.getWeapon() != null) {
            Weapon weapon = this.character.getWeapon();
            ResultMessage resultMessage = weapon.levelUp();
            if (!resultMessage.isSuccess()){
                return new ResultMessage(true,"猎人角色升级成功，武器升级失败",currentLevel+1);
            }
        }


        return new ResultMessage(true,"猎人角色升级成功",currentLevel+1);
    }

    @Override
    public ResultMessage normalAttack() {
        //有武器的话
        if (this.character.getWeapon() != null) {
            Weapon weapon = this.character.getWeapon();
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
            int damage = this.character.getLevel() * 5 + new Random().nextInt(5) + 2;
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
        int hp = this.character.getHealthPoint();
        if (this.character.getEvadeRate() > new Random().nextDouble()) {
            hp = this.character.getHealthPoint() - damage;
        }
        this.character.setHealthPoint(hp);
        if (hp <= 0) {
            this.character.setHealthPoint(0);
            return true;
        } else {
            return false;
        }
    }

    //@Override
    public ResultMessage heal(int value){
        int hp = this.character.getHealthPoint()+value;
        if(hp>this.character.getMaxHealthPoint()){
            hp=this.character.getMaxHealthPoint();
        }
        this.character.setHealthPoint(hp);
        return new ResultMessage(true, "回复".concat(String.valueOf(value) + "点血量"), value);
    }
}
