package hero;

import monster.Monster;

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

        return currentLevel + 1;
    }

    @Override
    public double normalAttack(Monster monster) {
        return 0;
    }
}
