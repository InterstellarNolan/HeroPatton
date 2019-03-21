package hero;

import monster.Monster;

public interface Role {

    Character getCharacter();

    public String getRole();

    int levelUp();

    int normalAttack();

    //被打败返回true
    boolean beAttacked(int damage);
}
