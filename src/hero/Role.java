package hero;

import monster.Monster;
import util.ResultMessage;

import java.util.ArrayList;

public interface Role {

    Character getCharacter();

    public String getRole();

    ResultMessage levelUp();

    //普通攻击，返回是否命中，伤害数值
    ResultMessage normalAttack();

    //被打败返回true
    boolean beAttacked(int damage);

    //ResultMessage heal(int value);

    ResultMessage useSkill(ArrayList<Integer> list);
}
