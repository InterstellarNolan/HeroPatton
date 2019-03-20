package monster.state;

public class NormalMonsterState implements MonsterState{

    @Override
    public int Attack(int attack) {
        double ratio=Math.random()*0.5-0.25+1.0;
        int damage= (int) (attack*ratio);
        return damage;
    }

    @Override
    public int beAttacked(int damage) {
        return damage;
    }
}
