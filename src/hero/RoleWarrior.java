package hero;

import hero.skill.Skill;
import hero.skill.WarriorSkill1;
import hero.skill.WarriorSkill2;
import item.Weapon;
import item.WeaponSword;
import util.ResultMessage;
import util.SkillResult;

import java.util.ArrayList;
import java.util.Random;

public class RoleWarrior implements Role {

    private Character character;

    private ArrayList<Skill> skills;

    public RoleWarrior(Character character) {
        this.character = character;
        this.character.setWeapon(new WeaponSword("剑","des",10));
        skills=new ArrayList<Skill>();
        this.skills.add(new WarriorSkill1());
        this.skills.add(new WarriorSkill2());
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

        int healthPoint = this.character.getMaxHealthPoint() + 50 * currentLevel;
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
                    return new ResultMessage(false, "战士MP不够，无法施展任何技能", damage);
                }
                return new ResultMessage(true, "战士MP不够，仅使用了部分技能", damage);
            } else {
                usedSkills.add(skills.get(i));
                SkillResult skillResult = skill.execute(this.character.getWeapon().getDamage());
                int resultDamage = skillResult.getDamage();
                int resultHeal = skillResult.getHeal();
                damage+=resultDamage;
                if (resultHeal > 0) {
                    ResultMessage healResult = this.character.heal(resultHeal);
                    healInfo = healResult.getInformation();
                }
                this.character.setMagicPoint(this.character.getMagicPoint() - cost);
            }
        }
        return new ResultMessage(true, "战士使用技能；".concat(healInfo), damage);
    }


}
