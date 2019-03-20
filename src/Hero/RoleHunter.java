package Hero;

public class RoleHunter implements Role {

    private Character character;

    public RoleHunter(Character character) {
        this.character = character;
    }

    @Override
    public String getRole() {
        return "Hunter";
    }

    @Override
    public int levelUp() {
        int currentLevel = character.getLevel();
        if (currentLevel < 100) {
            character.setLevel(currentLevel + 1);
        } else {
            return currentLevel;
        }

        double healthPoint = character.getMaxMagicPoint() + 30 * currentLevel;
        character.setMaxHealthPoint(healthPoint);
        character.setHealthPoint(healthPoint);

        double magicPoint = character.getMaxMagicPoint() + 50 * currentLevel;
        character.setMaxMagicPoint(magicPoint);
        character.setMagicPoint(magicPoint);

        return currentLevel += 1;
    }
}
