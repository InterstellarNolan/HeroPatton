package item;

import util.ResultMessage;

import java.util.Random;

public class ArmorLight extends Armor {
    /**
     * 轻甲强化，加1-3血
     * @return
     */
    @Override
    public ResultMessage strength() {
        if (this.getLeftStrength() > 0) {
            this.setExtraHP(this.getExtraHP() + new Random().nextInt(3) + 1);
            this.setLeftStrength(this.getLeftStrength() - 1);
            return new ResultMessage(true, getName().concat("已强化，当前增加生命值" + String.valueOf(this.getExtraHP())), this.getExtraHP());
        } else {
            return new ResultMessage(false,"强化失败，剩余强化次数不够",this.getExtraHP());
        }
    }

    public ArmorLight(String name, String description, int extraHP) {
        this.setName(name);
        this.setArmorType("hunter");
        this.setDescription(description);
        this.setLevel(1);
        this.setExtraHP(extraHP);
    }

    public ResultMessage levelUp(){
        ResultMessage resultMessage;
        int level = this.getLevel();
        if (level < 100) {
            this.setExtraHP(this.getExtraHP() + level * 8);
            this.setLevel(level++);
            this.setValue(10 * level + new Random().nextInt(10));
            resultMessage = new ResultMessage(true, "盔甲已升级到" + String.valueOf(level) + "级", level);
            return resultMessage;
        } else {
            resultMessage = new ResultMessage(false, "盔甲升级失败，已达到100级", level);
            return resultMessage;
        }
    }
}
