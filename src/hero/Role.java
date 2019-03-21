package hero;

import monster.Monster;

public interface Role {


    Character getCharacter();

    public String getRole();

    int levelUp();

    double normalAttack(Monster monster);
}
