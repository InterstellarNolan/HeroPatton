package monster;

import monster.state.NormalMonsterState;

public class NormalMonster extends Monster{

    public NormalMonster(int level){
        this.setName("NormalMonster");
        this.setLevel(level);
        this.setCoin(level*10);
        this.setExperience(level*10);
        this.setMaxHealthPoint(level*10);
        this.setAttackValue(level*5);
        this.setHealthPoint(this.getMaxHealthPoint());
        this.setState(new NormalMonsterState());
        this.setTurnFlag(0);
        this.setTurns(3);

    }

}
