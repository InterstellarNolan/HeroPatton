package monster.state;

public class StrongMonsterState implements MonsterState{
    private int strongRatio=2;
    @Override
    public int Attack(int attack) {
        double ratio=Math.random()*0.5-0.25+1.0;
        int damage= (int) (attack*ratio);
        return strongRatio*damage;
    }

    @Override
    public int beAttacked(int damage) {
        return damage*strongRatio;
    }
}
