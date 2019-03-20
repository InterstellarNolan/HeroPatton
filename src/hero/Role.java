package hero;

import monster.Monster;

public interface Role {

    public String getRole();

    int levelUp();

    double normalAttack(Monster monster);
}
