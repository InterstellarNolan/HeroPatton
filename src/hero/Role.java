package hero;

import monster.Monster;
import util.ResultMessage;

public interface Role {

    Character getCharacter();

    public String getRole();

    int levelUp();

    ResultMessage normalAttack();

    //被打败返回true
    boolean beAttacked(int damage);
}
