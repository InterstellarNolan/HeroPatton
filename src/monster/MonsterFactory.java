package monster;

public class MonsterFactory {
    private static MonsterFactory instance;

    private MonsterFactory(){}

    public MonsterFactory getInstance(){
        if(instance==null){
            instance=new MonsterFactory();
            return instance;
        }else{
            return instance;
        }
    }

    public Monster createMonster(String type,int level){
        if(type.equals("tank")){
            return new TankMonster(level);
        }else{
            return new NormalMonster(level);
        }

    }

}
