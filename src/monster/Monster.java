package monster;

import monster.state.MonsterState;
import monster.state.NormalMonsterState;
import monster.state.StrongMonsterState;

public abstract class Monster {
    //名称
    private String name;
    //打败获得经验
    private int experience;
    //打败获得金钱
    private int coin;
    //健康值
    private int healthPoint;
    //最大健康量
    private int maxHealthPoint;
    //等级
    private int level;
    //攻击力
    private int attackValue;
    //根据回合转换状态标记
    private int turnFlag=0;
    //回合数 达到变状态
    private int turns;
    //状态
    private MonsterState state;

    //状态切换
    public void turnForward(){
        if(turnFlag==turns){
            turnFlag=0;
            state=new StrongMonsterState();
        }else if(turnFlag==0){
            turnFlag++;
            state=new NormalMonsterState();
        }else{
            turnFlag++;
        }

    }

    public int attack(){
        return state.Attack(attackValue);
    }

    //被打死返回true 反之false
    public boolean beAttacked(int damage){
        int dmg= state.beAttacked(damage);
        this.healthPoint-=dmg;

        if(this.healthPoint<=0){
            this.healthPoint=0;
            return true;

        }
        return false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    public int getTurnFlag() {
        return turnFlag;
    }

    public void setTurnFlag(int turnFlag) {
        this.turnFlag = turnFlag;
    }

    public MonsterState getState() {
        return state;
    }

    public void setState(MonsterState state) {
        this.state = state;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}
