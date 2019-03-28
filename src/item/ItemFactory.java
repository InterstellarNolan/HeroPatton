package item;

public class ItemFactory {
    private static ItemFactory instance;
    public ItemFactory getInstance(){
        if(instance==null){
            instance=new ItemFactory();
        }
        return instance;
    }
    private ItemFactory(){

    }
    public Weapon createWeapon(String weaponName,String weaponDescription,String role,int damage){
        return null;
    }
}
