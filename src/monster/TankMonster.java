package monster;

import monster.state.NormalMonsterState;

public class TankMonster extends Monster{
    public TankMonster(int level){
        this.setName("Tank");
        this.setLevel(level);
        this.setCoin(level*10);
        this.setExperience(level*10);
        this.setMaxHealthPoint(level*100);
        this.setAttackValue(level*2);
        this.setHealthPoint(this.getMaxHealthPoint());
        this.setState(new NormalMonsterState());
        this.setTurnFlag(0);
        this.setTurns(3);
    }
}
