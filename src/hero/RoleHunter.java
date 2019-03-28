package hero;

import hero.skill.HunterSkill1;
import hero.skill.HunterSkill2;
import hero.skill.Skill;
import item.Weapon;
import util.ResultMessage;
import util.SkillResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoleHunter implements Role {

    private Character character;

    private ArrayList<Skill> skills;

    public RoleHunter(Character character) {
        this.character = character;
        skills=new ArrayList<Skill>();
        skills.add(new HunterSkill1());
        skills.add(new HunterSkill2());
    }


    @Override
    public Character getCharacter() {
        return this.character;
    }

    @Override
    public String getRole() {
        return "Hunter";
    }

    /**
     * 升级
     *
     * @return
     */
    @Override
    public ResultMessage levelUp() {
        /**
         * Hunter等级提升一级（不超过100级）
         */
        int currentLevel = this.character.getLevel();
        if (currentLevel < 100) {
            this.character.setLevel(currentLevel + 1);
        } else {
            return new ResultMessage(false, "角色升级失败，已达到100级", currentLevel);
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
            if (!resultMessage.isSuccess()) {
                return new ResultMessage(true, "猎人角色升级成功，武器升级失败", currentLevel + 1);
            }
        }


        return new ResultMessage(true, "猎人角色升级成功", currentLevel + 1);
    }

    /**
     * 普通攻击
     *
     * @return
     */
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

    /**
     * 被敌人攻击
     *
     * @param damage 伤害数值
     * @return true死了false活着
     */
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

    /**
     * 使用技能，带治疗效果的在本类中立即对角色进行治疗，带伤害效果的返回伤害数值给Battle战斗
     *
     * @param list 使用技能（按键1或2）对应猎人技能（0或1）
     * @return
     */
    @Override
    public ResultMessage useSkill(ArrayList<Integer> list) {
        int damage = 0;
        ArrayList<Skill> usedSkills = new ArrayList<>();
        String healInfo =" ";
        for (int i : list) {
            Skill skill = skills.get(i);
            int cost = skill.getCost();
            if (cost > this.character.getMagicPoint()) {
                if (usedSkills.size() == 0) {
                    return new ResultMessage(false, "猎人MP不够，无法施展任何技能", damage);
                }
                return new ResultMessage(true, "猎人MP不够，仅使用了部分技能", damage);
            } else {
                usedSkills.add(skills.get(i));
                SkillResult skillResult = skill.execute(this.character.getWeapon().getDamage());
                int resultDamage = skillResult.getDamage();
                int resultHeal = skillResult.getHeal();

                if (resultHeal > 0) {
                    ResultMessage healResult = this.character.heal(resultHeal);
                    healInfo = healResult.getInformation();
                }
                this.character.setMagicPoint(this.character.getMagicPoint() - cost);
            }
        }


        return new ResultMessage(true, "猎人使用技能；".concat(healInfo), damage);
    }


}
