package monster;

public class MonsterFactory {
    private static MonsterFactory instance;

    private MonsterFactory(){}

    public static MonsterFactory getInstance(){
        if(instance==null){
            instance=new MonsterFactory();
            return instance;
        }else{
            return instance;
        }
    }

    public Monster createMonster(int level){
        int flag=(int) (Math.random()*10);
        if(flag>6){
            return new TankMonster(level);
        }else{
            return new NormalMonster(level);
        }

    }

}
