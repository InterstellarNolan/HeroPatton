package monster.state;

public interface MonsterState {

    public abstract int Attack(int attack);

    public abstract int beAttacked(int damage);
}
