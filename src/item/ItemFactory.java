package item;

import java.util.Random;

public class ItemFactory {
    private static ItemFactory instance;
    private static String[] weaponSwordNames = {"短剑", "长剑", "短刀", "长刀"};
    private static String[] weaponBowNames = {"复合弓", "反曲弓", "猎弓", "轻弩"};
    private static String[] armorLightNames = {"布甲", "轻甲", "皮甲", "猎人的装束"};
    private static String[] armorHeavyNames = {"重甲", "链甲", "铁甲", "战士的盔甲"};

    private static String[] weaponSwordDescriptions = {"一把简陋的短剑", "经过岁月磨砺的长剑", "你可以把它刚好藏在袖中", "晶莹的刀身上有上古语言写成的文字"};
    private static String[] weaponBowDescriptions = {"一把普通的复合弓", "这把弓有着不错的拉弓速度", "你可以轻松地保持瞄准动作", "神奇的机械让这把弩可以自动射击"};
    private static String[] armorLightDescriptions = {"一套布甲……不如说是衣服", "材质轻薄却不阻碍行动的轻甲", "绿维珑大陆上最常见的制式皮甲", "可以让你融入森林颜色的礼物"};
    private static String[] armorHeavyDescriptions = {"一套重甲……保护着你的关节", "传说链甲可以挡住劈砍但没人愿意尝试", "军团铁匠铸造的厚重铁甲", "这件盔甲的前主人们都光荣退役回乡了"};

    public static ItemFactory getInstance() {
        if (instance == null) {
            instance = new ItemFactory();
        }
        return instance;
    }

    private ItemFactory() {

    }

    public Weapon createWeapon(String role) {
        Random random = new Random();
        int i = random.nextInt(4);
        if (role.equals("Hunter")) {
            return new WeaponBow(weaponBowNames[i], weaponBowDescriptions[i], 10);
        } else if (role.equals("Warrior")) {
            return new WeaponSword(weaponSwordNames[i], weaponSwordDescriptions[i], 12);
        }
        return new WeaponSword(weaponSwordNames[i], weaponSwordDescriptions[i], 12);
    }

    public Armor createArmor(String role) {
        Random random = new Random();
        int i = random.nextInt(4);
        if (role.equals("Hunter")) {
            return new ArmorLight(armorLightNames[i], armorLightDescriptions[i], 20);
        } else if (role.equals("Warrior")) {
            return new ArmorHeavy(armorHeavyNames[i], armorHeavyDescriptions[i], 30);
        }
        return new ArmorHeavy(armorHeavyNames[i], armorHeavyDescriptions[i], 30);
    }
}
