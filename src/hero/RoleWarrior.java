package hero;

import item.Weapon;
import monster.Monster;

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

        }

        return currentLevel + 1;


    }

    @Override
    public int normalAttack() {
        return 0;
    }

    @Override
    public boolean beAttacked(int damage) {
        int hp=this.character.getHealthPoint()-damage;
        this.character.setHealthPoint(hp);
        if(hp<=0){
            this.character.setHealthPoint(0);
            return true;
        }else{
            return false;
        }

    }
}
