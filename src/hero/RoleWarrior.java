package hero;

import item.Weapon;
import monster.Monster;

public class RoleWarrior implements Role {

    private Character character;

    public RoleWarrior(Character character) {
        this.character = character;
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

        double healthPoint = character.getMaxMagicPoint() + 50 * currentLevel;
        character.setMaxHealthPoint(healthPoint);
        character.setHealthPoint(healthPoint);

        double magicPoint = character.getMaxMagicPoint() + 20 * currentLevel;
        character.setMaxMagicPoint(magicPoint);
        character.setMagicPoint(magicPoint);

        /**
         * 武器升级
         */
        if (character.getWeapon()!=null){
            Weapon weapon=character.getWeapon();
            weapon.se
        }

        return currentLevel + 1;


    }

    @Override
    public double normalAttack(Monster monster) {
        return 0;
    }
}
